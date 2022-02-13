package io.pressf.kmm_iap_manager.store

import io.pressf.kmm_iap_manager.product.IAPProduct

internal expect class IAPStore() {

    internal val receipt: String?

    internal fun refreshProducts(ids: Set<String>)

    internal fun purchaseProduct(product: IAPProduct)

    internal fun refreshReceipt()

    internal fun setPurchaseCompleted(product: IAPProduct)

    internal fun start()

}