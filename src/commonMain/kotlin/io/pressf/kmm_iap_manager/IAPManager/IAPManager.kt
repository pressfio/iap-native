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
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class IAPManager {

    private val scope = CoroutineScope(Dispatchers.Default)

    private val _productsFlow = MutableStateFlow<List<IAPProduct>>(emptyList())
    val productsFlow = _productsFlow.asStateFlow()

    private val _errorFlow = MutableStateFlow<String?>(null)
    val errorFlow = _errorFlow.asStateFlow()

    init {
        scope.launch {
            IAPStore.productsChannel.consumeEach {
                val products = it.first
                val error = it.second
                if (products != null) {
                    val purchasedIds = getPurchasedProductIds()
                    products.forEach { product ->
                        if (purchasedIds.contains(product.id)) {
                            product.update(IAPProductState.Purchased)
                        }
                    }
                    println("Count: ${products.count()}")
                    _productsFlow.value = products
                } else {
                    _errorFlow.value = error
                }
            }
        }
    }

    abstract suspend fun productWasPurchased(product: IAPProduct): Boolean

    abstract suspend fun productWasRestored(product: IAPProduct): Boolean

    abstract suspend fun getProductIds(): Set<String>

    abstract suspend fun getPurchasedProductIds(): Set<String>

    fun refreshProducts() {
        scope.launch {
            val ids = getProductIds()
            IAPStore.requestProducts(ids)
        }
    }

    fun purchaseProduct(product: IAPProduct) {
        IAPStore.purchaseProduct(product)
    }

    fun restorePurchases() {
        IAPStore.restorePurchases()
    }

}