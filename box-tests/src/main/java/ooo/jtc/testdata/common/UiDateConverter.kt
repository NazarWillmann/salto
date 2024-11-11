package ooo.jtc.testdata.common

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter.ofPattern

object UiDateConverter {
    /**
     * Convert "Документ создан 15.07.2020 в 08:23" to LocalDateTime.
     * Convert "Документ создан сегодня в 08:23" to LocalDateTime.
     * Convert "Документ создан вчера в 08:23" to LocalDateTime.
     */
    fun convertCreatedAtDateTime(s: String): LocalDateTime {
        val replaced = s.replace("[^\\d\\.:]".toRegex(), "")
        return when {
            s.contains("сегодня") -> {
                val time = LocalTime.parse(replaced, ofPattern("HH:mm"))
                time.atDate(LocalDate.now())
            }
            s.contains("вчера") -> {
                val time = LocalTime.parse(replaced, ofPattern("HH:mm"))
                time.atDate(LocalDate.now().minusDays(1))
            }
            else -> {
                LocalDateTime.parse(replaced, ofPattern("dd.MM.yyyyHH:mm"))
            }
        }
    }

    /**
     * Convert from ZonedDateTime.now() to "сегодня в 12:50".
     * Convert from ZonedDateTime.now().minusDays(1) to "вчера в 12:50".
     * Convert from ZonedDateTime.now().minusDays(2) to "01.12.2020 в 12:50".
     */
    fun convertToUiDate(date: ZonedDateTime): String {
        val now = LocalDate.now()
        return when {
            (date.toLocalDate() == now) -> "сегодня в " + toMskTime(date).format(ofPattern("HH:mm"))
            (date.toLocalDate() == now.minusDays(1)) -> "вчера в " + toMskTime(date).format(ofPattern("HH:mm"))
            else -> toMskTime(date).format(ofPattern("dd.MM.yyyy' в 'HH:mm"))
        }
    }

    /**
     * Convert server time (05:00) to local (MSK) time (08:00)
     */
    private fun toMskTime(date: ZonedDateTime): LocalDateTime {
        return date.plusHours(3).toLocalDateTime()
    }

}