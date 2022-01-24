package io.pressf.kmm_iap_manager.IAPManager

import io.pressf.kmm_iap_manager.IAPProduct.IAPProduct
import io.pressf.kmm_iap_manager.IAPProduct.IAPProductState
import io.pressf.kmm_iap_manager.IAPStore.IAPStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

typealias ProductId = String
typealias IsPurchased = Boolean

abstract class IAPManager {

    private val scope = CoroutineScope(Dispatchers.Default)

    private val _products = MutableSharedFlow<Result<List<IAPProduct>>>()
    val products = _products.asSharedFlow()

    private val productIdsToStatus = MutableStateFlow<Map<ProductId, IsPurchased>>(emptyMap())

    init {
        scope.launch {
            IAPStore.productsChannel.consumeEach { result ->
                val products = result.getOrNull()
                if ((result.isSuccess) && (products != null)) {
                    products.forEach { product ->
                        productIdsToStatus.value[product.id]?.let { isPurchased ->
                            if (isPurchased) { product.update(IAPProductState.Purchased) }
                        }
                    }
                    _products.emit(Result.success(products))
                } else {
                    _products.emit(Result.failure(result.exceptionOrNull() ?: Exception("Received empty product list")))
                }
            }
        }
    }

    abstract suspend fun productWasPurchased(product: IAPProduct): Boolean

    abstract suspend fun productWasRestored(product: IAPProduct)

    abstract suspend fun getProductIds(): Map<ProductId, IsPurchased>

    fun refreshProducts() {
        scope.launch {
            val response = getProductIds()
            productIdsToStatus.value = response
            IAPStore.requestProducts(response.keys)
        }
    }

    fun purchaseProduct(product: IAPProduct) {
        IAPStore.purchaseProduct(product)
    }

    fun restorePurchases() {
        IAPStore.restorePurchases()
    }

}