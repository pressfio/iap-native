package io.pressf.kmm_iap_manager.store

import io.pressf.kmm_iap_manager.product.IAPProduct
import io.pressf.kmm_iap_manager.product.IAPProductNotification

internal expect class IAPStore() {

    internal val receipt: String?

    internal fun refreshProducts(ids: Set<String>, callback: ((List<IAPProduct>) -> Unit)? = null)

    internal fun purchaseProduct(product: IAPProduct)

    internal fun refreshReceipt()

    internal fun setPurchaseCompleted(notification: IAPProductNotification)

    internal fun start()

}