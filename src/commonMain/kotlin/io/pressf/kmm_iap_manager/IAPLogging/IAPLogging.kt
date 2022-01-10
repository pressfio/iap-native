package io.pressf.kmm_iap_manager.IAPLogging

import kotlinx.coroutines.flow.MutableSharedFlow

internal fun log(msg: String) {
    println("*** IAP Manager: $msg")
}

internal fun warn(msg: String) {
    println("*** IAP Warning: $msg")
}

internal fun err(msg: String) {
    println("*** IAP Error: $msg")
}