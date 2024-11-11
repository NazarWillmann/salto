package ooo.jtc.extensions

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.time.temporal.ChronoUnit
import java.util.Date
import java.util.Locale

const val DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
const val DEFAULT_TIME_FORMAT = "HH:mm:ss"
const val DEFAULT_DATE_FORMAT = "yyyy-MM-dd"
const val DOTS_DATE_FORMAT = "dd.MM.yyyy"
const val DEFAULT_DATE_WITH_MILLIS_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
const val DATE_WITH_MILLIS_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS"
const val DATE_T_TIME_DASH_Z = "yyyy-MM-dd'T'HH:mm:ss'Z'"
const val DATE_T_TIME_DASH_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss'+03:00'"
const val DATE_T_TIME_MILLIS_DASH_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
const val DATE_T_DASH_Z = "yyyy-MM-dd'T'00:00:00'Z'"
const val DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS = "yyyy-MM-dd_HHmmss"
const val DOTS_DATE_WITH_TIME_FORMAT = "dd.MM.yyyy HH:mm:ss"
const val DOTS_DATE_WITH_TIME_WITHOUT_SECONDS_FORMAT = "dd.MM.yyyy HH:mm"
const val STAMP_DATE_FORMAT = "dd MMM yyyy"
const val DATE_ONLY = "yyyyMMdd"
val LOCALE_RU = Locale("ru")

const val DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS_REGEX_STRING = "\\d{4}-\\d{2}-\\d{2}_\\d{6}"
const val DOTS_DATE_WITH_TIME_WITHOUT_SECONDS_FORMAT_REGEX_STRING = "\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}"

fun LocalDateTime.string(expectedFormat: String = DATE_WITH_MILLIS_FORMAT): String = this.format(DateTimeFormatter.ofPattern(expectedFormat))
fun LocalDate.string(expectedFormat: String = DEFAULT_DATE_FORMAT): String = this.format(DateTimeFormatter.ofPattern(expectedFormat))
fun Date.string(expectedFormat: String = DATE_WITH_MILLIS_FORMAT): String = SimpleDateFormat(expectedFormat).format(this)

fun LocalDateTime.stringOfLocale(expectedFormat: String = DATE_WITH_MILLIS_FORMAT, locale: Locale = LOCALE_RU): String =
    this.format(DateTimeFormatter.ofPattern(expectedFormat, locale))

//based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21729812
fun LocalDateTime.convertToDocStamp(locale: Locale = LOCALE_RU): String {
    val day = this.dayOfMonth
    val month = this.month.getDisplayName(TextStyle.SHORT, locale).take(3).toUpperCase()
    val year = this.year
    return "$day $month $year"
}

fun ZonedDateTime.ofUTC(): ZonedDateTime = this.withZoneSameInstant(ZoneId.of("UTC"))
fun ZonedDateTime.truncToSeconds(): ZonedDateTime = this.truncatedTo(ChronoUnit.SECONDS)
fun ZonedDateTime.ofSystemOffset(): LocalDateTime = LocalDateTime.ofInstant(this.toInstant(), ZoneId.systemDefault())

fun String.toDate(expectedFormat: String = DOTS_DATE_FORMAT): LocalDate = LocalDate.parse(this, DateTimeFormatter.ofPattern(expectedFormat))
fun String.toDateTime(expectedFormat: String = DEFAULT_DATETIME_FORMAT): LocalDateTime =
    LocalDateTime.parse(this, DateTimeFormatter.ofPattern(expectedFormat))