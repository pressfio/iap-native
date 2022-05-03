package io.pressf.kmm_iap_manager.product

import io.pressf.kmm_iap_manager.product.IAPProductNotificationType
import platform.StoreKit.SKPaymentTransactionState

actual enum class IAPProductNotificationType {
    ProductWasPurchased,
    ProductWasDeferred,
    ProductPurchaseFailed,
    ProductWasRestored,
    ProductIsPurchasing;

    actual companion object {

        fun fromSkPaymentTransactionState(state: SKPaymentTransactionState): IAPProductNotificationType {
            return when (state) {
                SKPaymentTransactionState.SKPaymentTransactionStateDeferred -> ProductWasDeferred
                SKPaymentTransactionState.SKPaymentTransactionStatePurchasing -> ProductIsPurchasing
                SKPaymentTransactionState.SKPaymentTransactionStateRestored -> ProductWasRestored
                SKPaymentTransactionState.SKPaymentTransactionStatePurchased -> ProductWasPurchased
                else -> ProductPurchaseFailed
            }
        }

    }

}
