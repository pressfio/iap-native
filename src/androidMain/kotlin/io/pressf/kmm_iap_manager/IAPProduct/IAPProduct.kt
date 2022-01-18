package io.pressf.kmm_iap_manager.IAPProduct

import kotlinx.coroutines.flow.StateFlow

actual class IAPProduct {

    actual val id: String
        get() = TODO("Not yet implemented")
    actual val state: StateFlow<IAPProductState>
        get() = TODO("Not yet implemented")

    internal actual suspend fun update(state: IAPProductState) {
        TODO("Not yet implemented")
    }
}