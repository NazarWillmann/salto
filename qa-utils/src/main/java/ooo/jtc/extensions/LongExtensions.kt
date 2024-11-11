package ooo.jtc.extensions

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

/**
 * Create LocalDateTime from Long
 *
 * @param zoneId - ZoneId, default by ZoneId.systemDefault()
 */
fun Long.toLocalDateTime(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime =
        LocalDateTime.ofInstant(Instant.ofEpochMilli(this), zoneId)