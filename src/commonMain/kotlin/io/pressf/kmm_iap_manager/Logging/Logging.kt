package io.pressf.kmm_iap_manager.Logging

internal enum class MessageType(val title: String) {
    Message(""),
    Warning("WARNING"),
    Error("ERROR")
}

private fun writeToConsole(message: String, type: MessageType, context: List<String>?) {
    println("[${Timestamp.basicDatetimeNoMillis()}] - ${type.title} - $message")
    context?.forEachIndexed() { index, string ->
        val symbol = if (index == context.count() - 1) "└──" else "├──"
        println("$symbol\t$string")
    }
}

internal fun msg(msg: String, context: List<String>? = emptyList()) {
    writeToConsole(msg, MessageType.Message, context)
}

internal fun wrn(msg: String, context: List<String>? = emptyList()) {
    writeToConsole(msg, MessageType.Warning, context)
}

internal fun err(msg: String, context: List<String>? = emptyList()) {
    writeToConsole(msg, MessageType.Error, context)
}