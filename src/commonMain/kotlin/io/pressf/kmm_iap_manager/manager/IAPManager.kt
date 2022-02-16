package io.pressf.kmm_iap_manager.manager

import io.pressf.kmm_iap_manager.product.IAPProduct
import io.pressf.kmm_iap_manager.product.IAPProductNotification
import io.pressf.kmm_iap_manager.store.IAPStore
import io.pressf.kmm_iap_manager.log.m
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

object IAPManager {

    object NotificationQueue {

        private val notificationQueue = MutableSharedFlow<IAPProductNotification>()

        internal suspend fun post(notification: IAPProductNotification) {
            notificationQueue.emit(notification)
        }

        suspend fun observe(onReceive: (IAPProductNotification) -> Unit) {
            notificationQueue.collect {
                onReceive(it)
            }
        }

    }

    object ProductList {

        private val productList = MutableStateFlow<List<IAPProduct>>(emptyList())

        internal suspend fun post(products: List<IAPProduct>) {
            productList.emit(products)
        }

        suspend fun observe(onReceive: (List<IAPProduct>) -> Unit) {
            productList.collect {
                onReceive(it)
            }
        }

        fun get() = productList.value

    }

    object ErrorQueue {

        private val errorQueue = MutableSharedFlow<String>()

        internal suspend fun post(error: String) {
            errorQueue.emit(error)
        }

        suspend fun observe(onReceive: (String) -> Unit) {
            errorQueue.collect {
                onReceive(it)
            }
        }

    }

    private val scope = CoroutineScope(Dispatchers.Main)
    private val store = IAPStore()

    val receipt: String?
        get() = store.receipt

    fun refreshProducts(ids: Set<String>, callback: ((List<IAPProduct>) -> Unit)? = null) {
        store.refreshProducts(ids, callback)
    }

    fun purchaseProduct(product: IAPProduct) {
        store.purchaseProduct(product)
    }

    fun refreshReceipt() {
        store.refreshReceipt()
    }

    fun setPurchaseCompleted(notification: IAPProductNotification) {
        store.setPurchaseCompleted(notification)
    }

    fun start() {
        m("started")
        store.start()
    }

    internal fun productListWasReceived(products: List<IAPProduct>) {
        scope.launch {
            ProductList.post(products)
        }
    }

    internal fun didFailWithError(error: String) {
        scope.launch {
            ErrorQueue.post(error)
        }
    }

    internal fun productNotificationWasReceived(notification: IAPProductNotification) {
        scope.launch {
            NotificationQueue.post(notification)
        }
    }

    internal fun getProductList(): List<IAPProduct> {
        return ProductList.get()
    }

}