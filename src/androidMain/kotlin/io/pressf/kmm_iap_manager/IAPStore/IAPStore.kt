package io.pressf.kmm_iap_manager.IAPStore

import io.pressf.kmm_iap_manager.IAPProduct.IAPProduct

internal actual class IAPStore {

    actual suspend fun getProducts(ids: Set<String>): Pair<List<IAPProduct>?, String?> {
        TODO("Not yet implemented")
    }

    actual suspend fun purchase(product: IAPProduct) {
    }

}