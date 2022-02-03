package io.pressf.kmm_iap_manager.IAPStore

import io.pressf.kmm_iap_manager.IAPProduct.IAPProduct
import io.pressf.kmm_iap_manager.Logging.wrn
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ObjCObjectVar
import platform.Foundation.*


internal actual object IAPStore {

    private val delegate = IAPStoreDelegate()
    internal actual val productsChannel = delegate.productChannel
    internal actual val productMetadataChannel = delegate.productMetadataChannel
    internal actual val purchaseHistory: String?
        get() = getBase64EncodedDeviceReceipt()

    private fun getBase64EncodedDeviceReceipt(): String? {
        val receiptUrlString = NSBundle.mainBundle.appStoreReceiptURL?.path
        if (receiptUrlString != null) {
            val receiptExists = NSFileManager.defaultManager.fileExistsAtPath(receiptUrlString)
            if (receiptExists) {
                var error = NSError()
                val receiptData = NSData.dataWithContentsOfFile(receiptUrlString, NSDataReadingMappedAlways, null)
                if (receiptData != null) {
                    val receiptString = receiptData.base64Encoding()
                    return receiptString
                } else {
                    wrn("Failed to read data from receipt")
                }
            } else {
                wrn("Found receipt url, but there is no such file")
            }
        } else {
            wrn("Receipt url is null")
        }
        return null
    }

    internal actual fun requestProducts(ids: Set<String>) {
        delegate.requestProducts(ids)
    }

    internal actual fun restorePurchases() {
        delegate.restorePurchases()
    }

    internal actual fun purchaseProduct(product: IAPProduct) {
        delegate.purchaseProduct(product)
    }

    internal actual fun start() {
        delegate.start()
    }

    internal actual fun updatePurchaseHistory() {
        delegate.updateReceipt()
    }

}