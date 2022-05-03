package io.pressf.kmm_iap_manager.log

enum class MessageType(val title: String) {
    Message(""),
    Warning(" - WARNING"),
    Error(" - ERROR")
}

fun writeToConsole(className: String?, message: String, type: MessageType, tags: Map<String, String>) {
    println("─${ if (tags.isEmpty()) { "─" } else { "┬" } }─ [${io.pressf.kmm_iap_manager.log.Timestamp.basicDatetimeNoMillis()}]${type.title} - ${className ?: "Undefined"} - $message")
    val count = tags.count()
    tags.keys.forEachIndexed { index, key ->
        val prefix = " ${ if (index == count - 1) { "└" } else { "├" } }───"
        println("$prefix $key : ${tags[key]}")
    }
}

inline fun <reified T> T.m(msg: String, tags: Map<String, String> = emptyMap()) {
    writeToConsole(T::class.simpleName, msg, MessageType.Message, tags)
}

inline fun <reified T> T.w(msg: String, tags: Map<String, String> = emptyMap()) {
    writeToConsole(T::class.simpleName, msg, MessageType.Warning, tags)
}

inline fun <reified T> T.e(msg: String, tags: Map<String, String> = emptyMap()) {
    writeToConsole(T::class.simpleName, msg, MessageType.Error, tags)
}

fun mObjc(msg: String, className: String?, tags: Map<String, String> = emptyMap()) {
    writeToConsole(className, msg, MessageType.Message, tags)
}

fun wObjc(msg: String, className: String?, tags: Map<String, String> = emptyMap()) {
    writeToConsole(className, msg, MessageType.Warning, tags)
}

fun eObjc(msg: String, className: String?, tags: Map<String, String> = emptyMap()) {
    writeToConsole(className, msg, MessageType.Error, tags)
}