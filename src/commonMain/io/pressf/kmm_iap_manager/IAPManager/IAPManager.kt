package io.pressf.kmm_iap_manager.IAPManager

import io.pressf.kmm_iap_manager.IAPProduct.IAPProduct
import io.pressf.kmm_iap_manager.IAPStore.IAPStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext

open class IAPManager {

    private val store = IAPStore()

    open suspend fun productIds(): Set<String> = emptySet()

}