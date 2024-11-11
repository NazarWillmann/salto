package ooo.jtc.documents

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import java.time.ZonedDateTime
import java.util.*

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class DocHistoryResponseDto(
    var version: Int? = null,
    var eventTime: ZonedDateTime? = null,
    var userId: UUID? = null,
    var targetStatus: String,
    var statusChanged: Boolean? = null
)