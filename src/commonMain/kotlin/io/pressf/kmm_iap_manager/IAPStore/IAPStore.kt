package io.pressf.kmm_iap_manager.IAPStore

import io.pressf.kmm_iap_manager.IAPProduct.IAPProduct
import io.pressf.kmm_iap_manager.IAPProduct.IAPProductMetadata
import io.pressf.kmm_iap_manager.IAPProduct.IAPProductState
import kotlinx.coroutines.channels.Channel

internal expect object IAPStore {

    internal val productsChannel: Channel<Result<List<IAPProduct>>>

    internal val productMetadataChannel: Channel<Result<IAPProductMetadata>>

    internal fun requestProducts(ids: Set<String>)

    internal fun restorePurchases()

    internal fun purchaseProduct(product: IAPProduct)

    internal fun getPurchaseHistoryDataAsBase64EncodedString(): String?

    internal fun prepare()

}