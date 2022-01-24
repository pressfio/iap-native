package io.pressf.kmm_iap_manager.IAPStore

import io.pressf.kmm_iap_manager.IAPProduct.IAPProduct
import platform.Foundation.*


internal actual object IAPStore {

    private val delegate = IAPStoreDelegate()
    internal actual val productsChannel = delegate.productChannel
    internal actual val productMetadataChannel = delegate.productMetadataChannel

    internal actual fun requestProducts(ids: Set<String>) {
        delegate.requestProducts(ids)
    }

    internal actual fun restorePurchases() {
        delegate.restorePurchases()
    }

    internal actual fun purchaseProduct(product: IAPProduct) {
        delegate.purchaseProduct(product)
    }

    internal actual fun prepare() {
        delegate.prepare()
    }

    internal actual fun getPurchaseHistoryDataAsBase64EncodedString(): String? {
        NSBundle.mainBundle.appStoreReceiptURL?.path?.let {
            if (NSFileManager.defaultManager.fileExistsAtPath(it)) {
                val receiptData = NSData.dataWithContentsOfFile(path = it, options = NSDataReadingMappedAlways, null)
                return receiptData?.base64Encoding()
            }
        }
        return null
    }


}