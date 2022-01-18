package io.pressf.kmm_iap_manager.IAPProduct

import kotlinx.coroutines.flow.StateFlow

expect class IAPProduct {

    val id: String
    val state: StateFlow<IAPProductState>

    internal suspend fun update(state: IAPProductState)

}