package io.pressf.kmm_iap_manager.IAPLogging

import kotlinx.coroutines.flow.MutableSharedFlow

private fun printWithHeader(header: String, vararg msg: String) {
    println("*** $header")
    msg.forEach {
        println(it)
    }
}

internal fun log(vararg msg: String) {
    printWithHeader("IAPManager", *msg)
}

internal fun warn(vararg msg: String) {
    printWithHeader("IAPManager WARNING", *msg)
}

internal fun err(vararg msg: String) {
    printWithHeader("IAPManager ERROR", *msg)
}