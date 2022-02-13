package io.pressf.kmm_iap_manager.store

import io.pressf.kmm_iap_manager.product.IAPProduct

internal actual class IAPStore actual constructor() {

    internal actual val receipt: String?
        get() = TODO("Not yet implemented")

    internal actual fun refreshProducts(ids: Set<String>) {
    }

    internal actual fun purchaseProduct(product: IAPProduct) {
    }

    internal actual fun refreshReceipt() {
    }

    internal actual fun start() {
    }

    internal actual fun setPurchaseCompleted(product: IAPProduct) {
    }

}