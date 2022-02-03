package io.pressf.kmm_iap_manager.IAPProduct

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import platform.Foundation.NSNumberFormatter
import platform.Foundation.NSNumberFormatterCurrencyStyle
import platform.StoreKit.SKProduct
import platform.posix.sched_get_priority_max
import platform.posix.stat

actual class IAPProduct(internal val skProduct: SKProduct) {

    private val _state = MutableStateFlow(IAPProductState.NotPurchased)
    private val scope = CoroutineScope(Dispatchers.Main)

    actual val id: String = skProduct.productIdentifier
    actual val localizedTitle = skProduct.localizedTitle
    actual val localizedPrice: String?
        get() {
            val formatter = NSNumberFormatter()
            formatter.numberStyle = NSNumberFormatterCurrencyStyle
            formatter.locale = skProduct.priceLocale
            return formatter.stringFromNumber(skProduct.price)
        }
    actual val price: String = skProduct.price.toString()
    actual val state: IAPProductState
        get() = _state.value

    internal actual suspend fun update(state: IAPProductState) {
        _state.emit(state)
    }

    actual fun observeStateChange(callback: (IAPProductState) -> Unit) {
        stopObserving()
        scope.launch {
            _state.collect {
                callback(it)
            }
        }
    }

    actual fun stopObserving() {
        scope.cancel()
    }

}