package io.pressf.kmm_iap_manager.store

import io.pressf.kmm_iap_manager.product.IAPProductNotification
import io.pressf.kmm_iap_manager.product.IAPProduct

interface IAPStoreDelegate {

    fun productListWasReceived(products: List<IAPProduct>)

    fun didFailWithError(error: String)

    fun productNotificationWasReceived(notification: IAPProductNotification)

    fun getProductList(): List<IAPProduct>

}