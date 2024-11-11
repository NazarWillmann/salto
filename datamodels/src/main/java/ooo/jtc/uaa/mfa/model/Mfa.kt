package ooo.jtc.uaa.mfa.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.UaaNames
import ooo.jtc.interfaces.ITransferEntity
import ooo.jtc.uaa.mfa.dto.MfaDto
import java.time.ZonedDateTime
import java.util.*

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
data class Mfa(
    override var id: UUID?,
    @NotRequiredForTest override var version: Int,
    @JsonProperty("mfa_type") val mfaType: String,
    val name: String,
    val title: String,
    val description: String,
    @NotRequiredForTest val config: String?,
    @NotRequiredForTest @JsonProperty("created_at") @JsonFormat(pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSZ") var createdAt: ZonedDateTime?,
    @NotRequiredForTest @JsonProperty("deleted_at") @JsonFormat(pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSZ") var deletedAt: ZonedDateTime?
) : ITransferEntity {

    override fun toDto(): MfaDto {
        return Mappers.mfaMapper.toDto(this)
    }

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = UaaNames.MFA
}

