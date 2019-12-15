package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.utils.Utils
import java.text.SimpleDateFormat
import java.util.*

// Константы для переращёта милисекунд в секунды, минуты, часы и дни
const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR


// Возвращение даты в заданном формате
fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

// Получение даты с заданным временным сдвигом
fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}


fun Date.humanizeDiff(date: Date = Date()): String {
    val dateDiff = Date().time - date.time
    return when {
        dateDiff < MINUTE -> "только что"
        dateDiff < HOUR -> "${Utils.getDateNumberEnd(dateDiff / MINUTE, TimeUnits.MINUTE)} назад"
        dateDiff < DAY -> "${Utils.getDateNumberEnd(dateDiff / HOUR, TimeUnits.HOUR)} назад"
        else -> "${Utils.getDateNumberEnd(dateDiff / DAY, TimeUnits.DAY)} назад"
    }
}



