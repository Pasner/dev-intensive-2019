package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.extensions.TimeUnits

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        if (firstName == "") firstName = null

        var lastName = parts?.getOrNull(1)
        if (lastName == "") lastName = null

        //return Pair(firstName, lastName)
        return firstName to lastName
    }

    // Склонение числительных
    fun getDateNumberEnd(dateNumber: Long, timeUnits: TimeUnits): String {
        val preLastNumber = dateNumber % 100 / 10
        if (preLastNumber == 1L) return "$dateNumber " +
                when (timeUnits) {
                    TimeUnits.SECOND -> "секунд"
                    TimeUnits.MINUTE -> "минут"
                    TimeUnits.HOUR -> "часов"
                    TimeUnits.DAY -> "дней"
                }

        return when (dateNumber % 10) {
            1L -> "$dateNumber " +
                    when (timeUnits) {
                        TimeUnits.SECOND -> "секунду"
                        TimeUnits.MINUTE -> "минуту"
                        TimeUnits.HOUR -> "час"
                        TimeUnits.DAY -> "день"
                    }
            2L, 3L, 4L -> "$dateNumber " +
                    when (timeUnits) {
                        TimeUnits.SECOND -> "секунды"
                        TimeUnits.MINUTE -> "минуты"
                        TimeUnits.HOUR -> "часа"
                        TimeUnits.DAY -> "дня"
                    }
            else -> "$dateNumber " +
                    when (timeUnits) {
                        TimeUnits.SECOND -> "секунд"
                        TimeUnits.MINUTE -> "минут"
                        TimeUnits.HOUR -> "часов"
                        TimeUnits.DAY -> "дней"
                    }
        }
    }


    fun transliteration(payload: String, divider: String = " "): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}