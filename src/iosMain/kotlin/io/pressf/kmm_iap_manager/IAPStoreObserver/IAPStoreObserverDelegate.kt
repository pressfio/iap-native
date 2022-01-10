package io.pressf.kmm_iap_manager.IAPProduct

import io.pressf.kmm_iap_manager.IAPProduct
import platform.Foundation.NSError

interface IAPStoreObserverDelegate {

    fun storeObserverDidReceiveProducts(products: List<IAPProduct>)

    fun storeObserverDidFailWithError(error: NSError)

}