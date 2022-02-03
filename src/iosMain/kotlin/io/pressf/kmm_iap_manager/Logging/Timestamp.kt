package io.pressf.kmm_iap_manager.Logging

import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter

actual object Timestamp {

    private val basicDatetimeNoMillisFormat = "yyyyMMdd'T'HHmmssZ"

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