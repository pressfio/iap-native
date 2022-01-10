package io.pressf.kmm_iap_manager.IAPStore

import io.pressf.kmm_iap_manager.IAPProduct.IAPProduct

internal expect class IAPStore() {

    suspend fun getProducts(ids: Set<String>): Pair<List<IAPProduct>?, String?>

    suspend fun purchase(product: IAPProduct)

}