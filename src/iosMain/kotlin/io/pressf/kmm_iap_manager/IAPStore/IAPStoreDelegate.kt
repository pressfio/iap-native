package io.pressf.kmm_iap_manager.IAPStore

import io.pressf.kmm_iap_manager.IAPProduct.IAPProduct
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
    val productChannel = Channel<Pair<List<IAPProduct>?, String?>>()
    val transactionsChannel = Channel<Pair<List<SKPaymentTransaction>?, String?>>()

    fun prepare() {
        SKPaymentQueue.defaultQueue().addTransactionObserver(this)
    }

    fun requestProducts(ids: Set<String>) {
        val request = SKProductsRequest(productIdentifiers = ids)
        request.setDelegate(this)
        request.start()
    }

    fun purchaseProduct(product: IAPProduct) {
        if (!SKPaymentQueue.canMakePayments()) return

        val transactions = SKPaymentQueue.defaultQueue().transactions
            .mapNotNull { it as? SKPaymentTransaction }

        if ((transactions.isNotEmpty()) && (transactions.last().transactionState == SKPaymentTransactionState.SKPaymentTransactionStatePurchasing)) return

        val payment = SKMutablePayment.paymentWithProduct(product.skProduct)
        SKPaymentQueue.defaultQueue().addPayment(payment)
    }

    fun restorePurchases() {
        SKPaymentQueue.defaultQueue().restoreCompletedTransactions()
    }

    /* SKPaymentTransactionObserverProtocol conformance */

    override fun paymentQueue(queue: SKPaymentQueue, updatedTransactions: List<*>) {
        val transactions = updatedTransactions
            .mapNotNull { it as? SKPaymentTransaction }

        scope.launch {
            transactionsChannel.send(Pair(transactions, null))
        }
    }

    override fun paymentQueue(queue: SKPaymentQueue, restoreCompletedTransactionsFailedWithError: NSError) {
        scope.launch {
            transactionsChannel.send(Pair(null, restoreCompletedTransactionsFailedWithError.localizedDescription))
        }
    }

    /* SKProductsRequestDelegateProtocol conformance */

    override fun productsRequest(request: SKProductsRequest, didReceiveResponse: SKProductsResponse) {
        val receivedProducts = didReceiveResponse.products
        val iapProducts = receivedProducts
            .mapNotNull { it as? SKProduct }
            .map { IAPProduct(it) }

        scope.launch {
            productChannel.send(Pair(iapProducts, null))
        }
    }

    override fun request(request: SKRequest, didFailWithError: NSError) {
        scope.launch {
            productChannel.send(Pair(null, didFailWithError.localizedDescription))
        }
    }

}