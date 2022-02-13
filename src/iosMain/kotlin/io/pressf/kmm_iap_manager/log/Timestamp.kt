package io.pressf.kmm_iap_manager.log

import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter

actual object Timestamp {

    private const val basicDatetimeNoMillisFormat = "yyyy-MM-dd'T'HH:mm:ss"

    private val date: NSDate
        get() = NSDate()

    private fun formattedDate(format: String): String {
        val formatter = NSDateFormatter()
        formatter.dateFormat = format
        return formatter.stringFromDate(date)
    }

    actual fun basicDatetimeNoMillis(): String {
        return formattedDate(basicDatetimeNoMillisFormat)
    }

}