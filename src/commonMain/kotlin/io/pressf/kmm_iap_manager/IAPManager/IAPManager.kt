package io.pressf.kmm_iap_manager.IAPManager

import io.pressf.kmm_iap_manager.IAPProduct.IAPProduct
import io.pressf.kmm_iap_manager.IAPProduct.IAPProductMetadata
import io.pressf.kmm_iap_manager.IAPProduct.IAPProductState
import io.pressf.kmm_iap_manager.IAPStore.IAPStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

internal typealias ProductId = String

@Suppress("MemberVisibilityCanBePrivate")
abstract class IAPManager {

    /* Abstract members */

    abstract suspend fun productWasPurchased(productId: String, purchaseId: String?, purchaseHistory: String?, ios: Boolean): Boolean

    abstract suspend fun productWasRestored(productId: String, purchaseId: String?, purchaseHistory: String?, ios: Boolean)

    abstract suspend fun productWasRestored(product: IAPProduct)

    /* Implemented members */

    init {
        start()
    }

    private val scope = CoroutineScope(Dispatchers.Default)

    private val _products = MutableStateFlow<List<IAPProduct>>(emptyList())
    val products = _products.asSharedFlow()

    private val _error = MutableSharedFlow<Throwable>()
    val error = _error.asSharedFlow()

    private val _states = MutableStateFlow<Map<ProductId, IAPProductState>>(emptyMap())

    fun reloadProducts(productIds: Set<String>, purchasedProductIds: Set<String>) {
        scope.launch {
            val states = _states.value
            _states.value = purchasedProductIds.union(states.keys.toSet())
                .map {
                    it to if (purchasedProductIds.contains(it)) { IAPProductState.Purchased } else { states[it] ?: IAPProductState.NotPurchased }
                }
                .toMap()
        }
    }

    fun purchaseProduct(product: IAPProduct) {
        scope.launch {
            product.update(IAPProductState.Loading)
        }
        IAPStore.purchaseProduct(product)
    }

    fun restorePurchases() {
        IAPStore.restorePurchases()
    }

    fun start() {

        IAPStore.start()

        scope.launch {
            IAPStore.productsChannel.consumeEach { result ->
                val receivedProducts = result.getOrNull()
                if ((result.isSuccess) && (receivedProducts != null)) {
                    receivedProducts.forEach { product ->
                        _states.value[product.id]?.let { state ->
                            product.update(state)
                        }
                    }
                    _products.emit(receivedProducts)
                } else {
                    _error.emit(result.exceptionOrNull() ?: Exception("Received empty product list"))
                }
            }
        }

        scope.launch {
            IAPStore.productMetadataChannel.consumeEach { result ->
                val meta = result.getOrNull()
                if ((result.isSuccess) && (meta != null)) {
                    val id = meta.productId
                    val state = meta.state
                    val transactionId = meta.transactionId
                    val platform = meta.platform
                    val isIos = platform == IAPProductMetadata.Platform.IOS

                    val product = _products.value
                        .firstOrNull { it.id == id }
                    product?.update(state)

                    if (state == IAPProductState.Purchased) {
                        val acknowledged = productWasPurchased(id, transactionId, IAPStore.purchaseHistory, isIos)
                        if (acknowledged) {
                            meta.completePurchase()
                        }
                    } else if (state == IAPProductState.Restored) {
                        productWasRestored(id, transactionId, IAPStore.purchaseHistory, isIos)
                    }
                } else {
                    _error.emit(result.exceptionOrNull() ?: Exception("Received null product metadata"))
                }
            }
        }

    }

}