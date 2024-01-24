package com.charlottewiltshire0.weatherwise.core.utils

import java.text.SimpleDateFormat
import java.util.Date

fun getCurrentTime(): String {
    val dateFormat = SimpleDateFormat("HH:mm")
    val currentTime = Date()
    return dateFormat.format(currentTime)
}
fun getCurrentTimeWithAMPM(): String {
    val dateFormat = SimpleDateFormat("hh:mm a")
    val currentTime = Date()
    return dateFormat.format(currentTime)
}
