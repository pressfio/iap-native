package io.pressf.kmm_iap_manager.IAPProduct

import platform.StoreKit.SKPaymentQueue
import platform.StoreKit.SKPaymentTransaction

internal actual data class IAPProductMetadata(
    val transaction: SKPaymentTransaction
) {

    actual enum class Platform {
        IOS, Android
    }

    actual val productId: String
        get() = transaction.payment.productIdentifier
    actual val state: IAPProductState
        get() = IAPProductState.from(transaction.transactionState)
    actual val transactionId: String?
        get() = transaction.originalTransaction?.transactionIdentifier ?: transaction.transactionIdentifier
    actual val platform: Platform
        get() = Platform.IOS

    actual fun completePurchase() {
        SKPaymentQueue.defaultQueue().finishTransaction(transaction)
    }

}