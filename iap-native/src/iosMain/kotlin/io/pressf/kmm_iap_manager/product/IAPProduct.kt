package io.pressf.kmm_iap_manager.product

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import platform.Foundation.NSNumberFormatter
import platform.Foundation.NSNumberFormatterCurrencyStyle
import platform.StoreKit.SKPaymentTransaction
import platform.StoreKit.SKPaymentTransactionState
import platform.StoreKit.SKProduct

actual class IAPProduct(internal val skProduct: SKProduct) {

    actual val id: String = skProduct.productIdentifier
    actual val localizedTitle = skProduct.localizedTitle
    actual val localizedPrice: String?
        get() {
            val formatter = NSNumberFormatter()
            formatter.numberStyle = NSNumberFormatterCurrencyStyle
            formatter.locale = skProduct.priceLocale
            return formatter.stringFromNumber(skProduct.price)
        }
    actual val price: String = skProduct.price.toString()

}