package io.pressf.kmm_iap_manager.store

import io.pressf.kmm_iap_manager.product.IAPProduct
import io.pressf.kmm_iap_manager.product.IAPProductNotification

internal actual class IAPStore actual constructor() {

    internal actual val receipt: String?
        get() = TODO("Not yet implemented")

    internal actual fun refreshProducts(ids: Set<String>, callback: ((List<IAPProduct>) -> Unit)?) {
    }

    internal actual fun purchaseProduct(product: IAPProduct) {
    }

    internal actual fun refreshReceipt() {
    }

    internal actual fun start() {
    }

    internal actual fun setPurchaseCompleted(notification: IAPProductNotification) {
    }

}