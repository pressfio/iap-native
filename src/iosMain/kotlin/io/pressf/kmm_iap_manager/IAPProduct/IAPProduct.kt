package io.pressf.kmm_iap_manager.IAPProduct

import platform.StoreKit.SKProduct

actual class IAPProduct(val skProduct: SKProduct) {

    actual val id: String = skProduct.productIdentifier

}