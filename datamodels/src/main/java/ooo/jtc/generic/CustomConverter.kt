package ooo.jtc.generic

import ooo.jtc.serialization.deserialize
import ooo.jtc.serialization.serialize
import org.mapstruct.Named
import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime

const val CUSTOM_CONVERTER = "CustomConverter"
const val TIMESTAMP_TO_LOCALDATE_TIME = "TimestampToLocalDateTime"
const val LOCALDATE_TIME_TO_TIMESTAMP = "LocalDateTimeToTimestamp"
const val TIMESTAMP_TO_ZONEDDATE_TIME = "TimestampToZonedDateTime"
const val ZONEDDATE_TIME_TO_TIMESTAMP = "ZonedDateTimeToTimestamp"
const val STRING_TO_MAP = "StringToMap"
const val MAP_TO_STRING = "MapToString"

@Named(CUSTOM_CONVERTER)
class CustomConverter {

    @Named(TIMESTAMP_TO_LOCALDATE_TIME)
    fun timestampToLocalDateTime(source: Timestamp?): LocalDateTime? {
        return source?.toLocalDateTime()
    }

    @Named(LOCALDATE_TIME_TO_TIMESTAMP)
    fun localDateTimeToTimestamp(source: LocalDateTime?): Timestamp? {
        return source?.let { Timestamp.valueOf(source) }
    }

    @Named(TIMESTAMP_TO_ZONEDDATE_TIME)
    fun timestampToZonedDateTime(source: Timestamp?): ZonedDateTime? {
        return source?.let { ZonedDateTime.ofLocal(source.toLocalDateTime(), ZoneId.of("UTC"), ZoneOffset.UTC) }
    }

    @Named(ZONEDDATE_TIME_TO_TIMESTAMP)
    fun zonedDateTimeToTimestamp(source: ZonedDateTime?): Timestamp? {
        return source?.let { Timestamp.valueOf(source.toLocalDateTime()) }
    }


    @Named(STRING_TO_MAP)
    fun stringToMap(source: String?): Map<String, Any?>? {
        return source?.deserialize()
    }

    @Named(MAP_TO_STRING)
    fun mapToString(source: Map<String, Any?>?): String? {
        return source?.serialize()
    }
}