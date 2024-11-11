package ooo.jtc.crypto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.CryptoNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(CryptoNames.PROFILE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ProfileDto(
    override var id: UUID?,
    override var version: Int,
    var authOnly: Boolean = false,
    var profileType: ProfileType = ProfileType.CRYPTOPRO,
    var state: String = ProfileState.ENABLED,
    var userId: UUID
) : UpdateIEntityDto<ProfileDto> {

    override fun toModel(): Profile = Mappers.profileMapper.toDomainModel(this)
}