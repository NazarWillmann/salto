package ooo.jtc.curtransfer.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import java.time.LocalDate
import java.util.UUID

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class CurRegulationInfoDto(
    val id: UUID?,
    val documentId: UUID?,
    val operCode: String,
    val ucNumber: String?,
    val expectDate: LocalDate?,
    val amount: String
)