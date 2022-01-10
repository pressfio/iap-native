package io.pressf.kmm_iap_manager.IAPStore

import io.pressf.kmm_iap_manager.IAPLogging.err
import io.pressf.kmm_iap_manager.IAPLogging.log
import io.pressf.kmm_iap_manager.IAPLogging.warn
import io.pressf.kmm_iap_manager.IAPProduct.IAPProduct
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import platform.Foundation.NSError
import platform.Foundation.NSErrorDomain
import platform.StoreKit.*
import platform.darwin.NSObject

internal actual class IAPStore: NSObject(), SKPaymentTransactionObserverProtocol,
    SKProductsRequestDelegateProtocol {

    private val productChannel = Channel<Pair<List<IAPProduct>?, String?>>()

    init {
        SKPaymentQueue.defaultQueue().addTransactionObserver(this)
    }

    actual suspend fun getProducts(ids: Set<String>): Pair<List<IAPProduct>?, String?> {

        val request = SKProductsRequest(productIdentifiers = ids)
        request.setDelegate(this)
        request.start()

        return productChannel.receive()

    }

    actual suspend fun purchase(product: IAPProduct) {

        if (!SKPaymentQueue.canMakePayments()) return

        val transactions = SKPaymentQueue.defaultQueue().transactions
            .mapNotNull { it as? SKPaymentTransaction }
        if (transactions.last().transactionState == SKPaymentTransactionState.SKPaymentTransactionStatePurchasing) return

        val payment = SKPayment.paymentWithProduct(product.skProduct)
        SKPaymentQueue.defaultQueue().addPayment(payment)

    }

    /* SKPaymentTransactionObserverProtocol conformance */

    override fun paymentQueue(queue: SKPaymentQueue, updatedTransactions: List<*>) {

        val transactions = updatedTransactions
            .mapNotNull { it as? SKPaymentTransaction }

        transactions.forEach {
        }
    }

    /* SKProductsRequestDelegateProtocol conformance */

    override fun productsRequest(request: SKProductsRequest, didReceiveResponse: SKProductsResponse) {

        val receivedProducts = didReceiveResponse.products
        val iapProducts = receivedProducts
            .mapNotNull { it as? SKProduct }
            .map { IAPProduct(it) }

        GlobalScope.launch {
            productChannel.send(Pair(iapProducts, null))
        }

    }

    override fun request(request: SKRequest, didFailWithError: NSError) {
        GlobalScope.launch {
            productChannel.send(Pair(null, didFailWithError.localizedDescription))
        }
    }

}