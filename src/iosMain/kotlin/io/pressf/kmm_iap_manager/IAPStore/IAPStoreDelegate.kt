package io.pressf.kmm_iap_manager.IAPStore

import io.pressf.kmm_iap_manager.IAPProduct.IAPProduct
import io.pressf.kmm_iap_manager.IAPProduct.IAPProductMetadata
import io.pressf.kmm_iap_manager.IAPProduct.IAPProductState
import io.pressf.kmm_iap_manager.IAPProduct.from
import io.pressf.kmm_iap_manager.Logging.*
import io.pressf.kmm_iap_manager.Logging.w
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import platform.Foundation.NSError
import platform.StoreKit.*
import platform.darwin.NSObject

internal class IAPStoreDelegate: NSObject(), SKPaymentTransactionObserverProtocol,
    SKProductsRequestDelegateProtocol {

    private val scope = CoroutineScope(Dispatchers.Default)
    val productChannel = Channel<Result<List<IAPProduct>>>()
    val productMetadataChannel = Channel<Result<IAPProductMetadata>>()

    fun start() {
        val observers = SKPaymentQueue.defaultQueue().transactionObservers
            .mapNotNull { it as? SKPaymentTransactionObserverProtocol }
        if (!observers.contains(this)) {
            SKPaymentQueue.defaultQueue().addTransactionObserver(this)
        }
    }

    fun updateReceipt() {
        mObjc("Updating receipt...", "IAPStoreDelegate")
        val request = SKReceiptRefreshRequest()
        request.setDelegate(this)
        request.start()
    }

    fun requestProducts(ids: Set<String>) {
        mObjc("Requesting products...", "IAPStoreDelegate")
        val request = SKProductsRequest(productIdentifiers = ids)
        request.setDelegate(this)
        request.start()
    }

    fun purchaseProduct(product: IAPProduct) {
        mObjc("Purchasing product", "IAPStoreDelegate", mapOf("id" to product.id))
        if (!SKPaymentQueue.canMakePayments()) {
            wObjc("Payment queue can't make payments", "IAPStoreDelegate")
            return
        }

        val transactions = SKPaymentQueue.defaultQueue().transactions
            .mapNotNull { it as? SKPaymentTransaction }

        if ((transactions.isNotEmpty()) && (transactions.last().transactionState == SKPaymentTransactionState.SKPaymentTransactionStatePurchasing)) {
            wObjc("One or more purchase is pending, can't proceed", "IAPStoreDelegate")
            return
        }

        val payment = SKMutablePayment.paymentWithProduct(product.skProduct)
        SKPaymentQueue.defaultQueue().addPayment(payment)
    }

    fun restorePurchases() {
        mObjc("Restoring purchases...", "IAPStoreDelegate")
        SKPaymentQueue.defaultQueue().restoreCompletedTransactions()
    }

    /* SKPaymentTransactionObserverProtocol conformance */

    override fun paymentQueue(queue: SKPaymentQueue, updatedTransactions: List<*>) {
        val transactions = updatedTransactions
            .mapNotNull { it as? SKPaymentTransaction }
        scope.launch {
            transactions.forEach {
                productMetadataChannel.send(Result.success(IAPProductMetadata(it)))
                mObjc("Payment queue did update transaction", "IAPStoreDelegate", mapOf(
                    "productId" to it.payment.productIdentifier,
                    "transactionId" to (it.transactionIdentifier ?: "no id"),
                    "state" to it.transactionState.name
                ))
            }
        }
    }

    override fun paymentQueue(queue: SKPaymentQueue, restoreCompletedTransactionsFailedWithError: NSError) {
        eObjc("Failed to restore", "IAPStoreDelegate", mapOf("error" to restoreCompletedTransactionsFailedWithError.localizedDescription))
        scope.launch {
            productMetadataChannel.send(Result.failure(Exception(restoreCompletedTransactionsFailedWithError.localizedDescription)))
        }
    }

    /* SKProductsRequestDelegateProtocol conformance */

    override fun productsRequest(request: SKProductsRequest, didReceiveResponse: SKProductsResponse) {
        val receivedProducts = didReceiveResponse.products
        val iapProducts = receivedProducts
            .mapNotNull { it as? SKProduct }
            .map { IAPProduct(it) }
        mObjc("Received products from store:", "IAPStoreDelegate", iapProducts.mapIndexed { index, product -> "id$index" to product.id }.toMap())
        scope.launch {
            productChannel.send(Result.success(iapProducts))
        }
    }

    override fun requestDidFinish(request: SKRequest) {
        if (request is SKReceiptRefreshRequest) {
            mObjc("Successfully refreshed receipt", "IAPStoreDelegate")
        }
    }

    override fun request(request: SKRequest, didFailWithError: NSError) {
        eObjc("Failed to update receipt", "IAPStoreDelegate", mapOf( "error" to didFailWithError.localizedDescription ))
        scope.launch {
            productChannel.send(Result.failure(Exception(didFailWithError.localizedDescription)))
        }
    }

}