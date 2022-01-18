package io.pressf.kmm_iap_manager.IAPStore

import io.pressf.kmm_iap_manager.IAPProduct.IAPProduct
import kotlinx.coroutines.channels.Channel

internal actual object IAPStore {

    internal actual val productsChannel: Channel<Pair<List<IAPProduct>?, String?>>
        get() = TODO("Not yet implemented")

    internal actual fun requestProducts(ids: Set<String>) {
    }

    internal actual fun restorePurchases() {
    }

    internal actual fun purchaseProduct(product: IAPProduct) {
    }

    internal actual fun getPurchaseHistoryDataAsBase64EncodedString(): String? {
        TODO("Not yet implemented")
    }

    internal actual fun prepare() {
    }

}