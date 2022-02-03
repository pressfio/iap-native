package io.pressf.kmm_iap_manager.IAPProduct

import kotlinx.coroutines.flow.StateFlow

expect class IAPProduct {

    val id: String
    val localizedTitle: String
    val localizedPrice: String?
    val price: String
    val state: IAPProductState

    internal suspend fun update(state: IAPProductState)

    fun observeStateChange(callback: ((IAPProductState) -> Unit))

    fun stopObserving()

}