package io.pressf.kmm_iap_manager.IAPProduct

import kotlinx.coroutines.flow.StateFlow

actual class IAPProduct {

    actual val id: String
        get() = TODO("Not yet implemented")
    actual val localizedTitle: String
        get() = TODO("Not yet implemented")
    actual val localizedPrice: String?
        get() = TODO("Not yet implemented")
    actual val price: String
        get() = TODO("Not yet implemented")
    actual val state: IAPProductState
        get() = TODO("Not yet implemented")

    internal actual suspend fun update(state: IAPProductState) {
        TODO("Not yet implemented")
    }

    actual fun observeStateChange(callback: (IAPProductState) -> Unit) {
    }

    actual fun stopObserving() {
    }
}