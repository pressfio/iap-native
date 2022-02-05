package io.pressf.kmm_iap_manager.Logging

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter

actual object Timestamp {

    private val basicDatetimeNoMillisFormat = "yyyy-MM-dd'T'hh:mm:ss"

    private val date: Date
        get() = Date()

    @SuppressLint("SimpleDateFormat")
    private fun formattedDate(format: String): String {
        val formatter = SimpleDateFormat(format)
        return formatter.format(date)
    }

    actual fun basicDatetimeNoMillis(): String {
        return formattedDate(basicDatetimeNoMillisFormat)
    }

}