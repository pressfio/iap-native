package io.pressf.kmm_iap_manager.IAPStore

import io.pressf.kmm_iap_manager.IAPProduct.IAPProduct
import kotlinx.coroutines.channels.Channel

internal expect object IAPStore {

    internal val productsChannel: Channel<Pair<List<IAPProduct>?, String?>>

    internal fun requestProducts(ids: Set<String>)

    internal fun restorePurchases()

    internal fun purchaseProduct(product: IAPProduct)

    internal fun getPurchaseHistoryDataAsBase64EncodedString(): String?

    internal fun prepare()

}