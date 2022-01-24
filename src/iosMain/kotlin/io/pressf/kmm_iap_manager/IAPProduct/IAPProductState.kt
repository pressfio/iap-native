package io.pressf.kmm_iap_manager.IAPProduct

import platform.StoreKit.SKPaymentTransaction
import platform.StoreKit.SKPaymentTransactionState
import platform.zlib.deflateParams

fun IAPProductState.Companion.from(sKPaymentTransactionState: SKPaymentTransactionState): IAPProductState {
    return when (sKPaymentTransactionState) {
        SKPaymentTransactionState.SKPaymentTransactionStatePurchased -> IAPProductState.Purchased
        SKPaymentTransactionState.SKPaymentTransactionStatePurchasing -> IAPProductState.IsPurchasing
        SKPaymentTransactionState.SKPaymentTransactionStateFailed -> IAPProductState.Error
        SKPaymentTransactionState.SKPaymentTransactionStateRestored -> IAPProductState.Restored
        SKPaymentTransactionState.SKPaymentTransactionStateDeferred -> IAPProductState.Loading
    }

}