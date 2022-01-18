package io.pressf.kmm_iap_manager.IAPProduct

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import platform.StoreKit.SKProduct

actual class IAPProduct(val skProduct: SKProduct) {

    actual val id: String = skProduct.productIdentifier
    private val _status = MutableStateFlow(IAPProductState.NotPurchased)
    actual val state: StateFlow<IAPProductState> = _status.asStateFlow()

    internal actual suspend fun update(state: IAPProductState) {
        _status.emit(state)
    }

}