package ooo.jtc.news.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import java.time.ZonedDateTime
import java.util.UUID

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class MustKnowDto(
    var id: UUID?,
    var documentId: UUID?,
    var userId: UUID,
    var customerId: UUID,
    var customerName: String?,
    var inn: String?,
    var fio: String?,
    var knowAt: ZonedDateTime,
    var mailingId: UUID
)