package io.pressf.kmm_iap_manager.IAPStoreObserver

import io.pressf.kmm_iap_manager.IAPLogging.log
import platform.Foundation.NSError
import platform.StoreKit.*
import platform.darwin.NSObject

internal class IAPStoreObserver(delegate: IAPStoreObserverDelegate): NSObject(), SKPaymentTransactionObserverProtocol,
    SKProductsRequestDelegateProtocol {

    override fun productsRequest(request: SKProductsRequest, didReceiveResponse: SKProductsResponse) {

    }

    override fun request(request: SKRequest, didFailWithError: NSError) {
        log("Products request failed: ${didFailWithError.localizedDescription}")
    }

    override fun paymentQueue(queue: SKPaymentQueue, updatedTransactions: List<*>) {
        TODO("Not yet implemented")
    }


}