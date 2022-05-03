package io.pressf.kmm_iap_manager.store

import io.pressf.kmm_iap_manager.manager.IAPManager
import io.pressf.kmm_iap_manager.product.IAPProductNotification
import io.pressf.kmm_iap_manager.product.IAPProduct
import io.pressf.kmm_iap_manager.product.IAPProductNotificationType
import io.pressf.kmm_iap_manager.log.eObjc
import io.pressf.kmm_iap_manager.log.mObjc
import io.pressf.kmm_iap_manager.log.wObjc
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import platform.Foundation.*
import platform.StoreKit.*
import platform.darwin.NSObject
import platform.darwin.NSUInteger


internal actual class IAPStore actual constructor(): NSObject(),
    SKPaymentTransactionObserverProtocol, SKProductsRequestDelegateProtocol {

    private val className = "IAPStore"

    actual val receipt: String?
        get() = getBase64EncodedDeviceReceipt()

    private fun getBase64EncodedDeviceReceipt(): String? {
        val receiptUrlString = NSBundle.mainBundle.appStoreReceiptURL?.path
        if (receiptUrlString != null) {
            val receiptExists = NSFileManager.defaultManager.fileExistsAtPath(receiptUrlString)
            if (receiptExists) {
                var error = NSError()
                val receiptData = NSData.dataWithContentsOfFile(receiptUrlString, NSDataReadingMappedAlways, null)
                if (receiptData != null) {
                    return receiptData.base64Encoding()
                } else {
                    wObjc("failed to read data from receipt", className)
                }
            } else {
                wObjc("found receipt url, but there is no such file", className)
            }
        } else {
            wObjc("receipt url is null", className)
        }
        return null
    }

    actual fun refreshProducts(ids: Set<String>, callback: ((List<IAPProduct>) -> Unit)?) {

        mObjc("refreshing products", className)

        val request = SKProductsRequest(productIdentifiers = ids)
        request.setDelegate(this)

        request.start()

    }

    actual fun purchaseProduct(product: IAPProduct) {
        mObjc("purchasing product ${product.id}", className)
        if (!SKPaymentQueue.canMakePayments()) {
            wObjc("payment queue can't make payments", className)
            return
        }

        val transactions = SKPaymentQueue.defaultQueue().transactions
            .mapNotNull { it as? SKPaymentTransaction }

        if ((transactions.isNotEmpty()) && (transactions.last().transactionState == SKPaymentTransactionState.SKPaymentTransactionStatePurchasing)) {
            wObjc("one or more purchase is pending, can't proceed", className)
            return
        }

        val payment = SKMutablePayment.paymentWithProduct(product.skProduct)
        SKPaymentQueue.defaultQueue().addPayment(payment)
    }

    actual fun setPurchaseCompleted(notification: IAPProductNotification) {
        notification.transaction?.let { SKPaymentQueue.defaultQueue().finishTransaction(it) }
    }

    actual fun refreshReceipt() {
        mObjc("updating receipt", "IAPStoreDelegate")
        val request = SKReceiptRefreshRequest()
        request.setDelegate(this)
        request.start()
    }

    actual fun start() {
        mObjc("started", className)

        refreshReceipt()

        val observers = SKPaymentQueue.defaultQueue().transactionObservers
            .mapNotNull { it as? SKPaymentTransactionObserverProtocol }
        if (!observers.contains(this)) {
            SKPaymentQueue.defaultQueue().addTransactionObserver(this)
        }
    }

    /* SKPaymentTransactionObserverProtocol conformance */

    override fun paymentQueue(queue: SKPaymentQueue, updatedTransactions: List<*>) {

        val transactions = updatedTransactions
            .mapNotNull { it as? SKPaymentTransaction }

        transactions.forEach {

            val type = IAPProductNotificationType.fromSkPaymentTransactionState(it.transactionState)

            val error = it.error?.localizedDescription

            IAPManager.productNotificationWasReceived(IAPProductNotification(type, it, error))

            mObjc("payment queue did update transaction", className, mapOf(
                "productId" to it.payment.productIdentifier,
                "transactionId" to (it.transactionIdentifier ?: "no id"),
                "state" to it.transactionState.name
            ))

        }

    }

    /* SKProductsRequestDelegateProtocol conformance */

    override fun productsRequest(request: SKProductsRequest, didReceiveResponse: SKProductsResponse) {

        val receivedProducts = didReceiveResponse.products

        val iapProducts = receivedProducts
            .mapNotNull { it as? SKProduct }
            .map { IAPProduct(it) }

        IAPManager.productListWasReceived(iapProducts)

        mObjc("received products from store:", className, iapProducts.mapIndexed { index, product -> "id$index" to product.id }.toMap())

    }

    override fun requestDidFinish(request: SKRequest) {

        if (request is SKReceiptRefreshRequest) {
            mObjc("successfully refreshed receipt", "IAPStoreDelegate")
        }

    }

    override fun request(request: SKRequest, didFailWithError: NSError) {

        if (request is SKProductsRequest) {
            IAPManager.didFailWithError(didFailWithError.localizedDescription)
            eObjc("failed to update products with error: ${didFailWithError.localizedDescription}", className)
        } else if (request is SKReceiptRefreshRequest) {
            eObjc("failed to update receipt with error: ${didFailWithError.localizedDescription}", className)
        }

    }

}