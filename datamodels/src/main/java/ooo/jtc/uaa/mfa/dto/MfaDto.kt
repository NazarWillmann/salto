package ooo.jtc.uaa.mfa.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.UaaNames
import ooo.jtc.interfaces.ITransferEntity
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.uaa.mfa.model.Mfa
import java.util.*

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityName(UaaNames.MFA)
data class MfaDto(
    override var id: UUID?,
    override var version: Int,
    val mfaType: String,
    val name: String,
    val title: String,
    val description: String
) : UpdateIEntityDto<MfaDto> {

    override fun toModel(): Mfa {
        return Mappers.mfaMapper.toDomainModel(this)
    }
}

