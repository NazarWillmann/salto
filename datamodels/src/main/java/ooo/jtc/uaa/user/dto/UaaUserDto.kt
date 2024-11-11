package ooo.jtc.uaa.user.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.UaaNames
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.uaa.scope.dto.ScopeDetails
import ooo.jtc.uaa.user.model.UaaUser
import java.time.ZonedDateTime
import java.util.*

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityName(UaaNames.USER)
data class UaaUserDto(
    override var id: UUID?,
    override var version: Int,
    val blockReason: String?,
    val blockUser: UUID?,
    val permanentBlocked: Boolean,
    val preferredLocale: String?,
    var scopes: List<UUID?>,
    var scopeDetails: List<ScopeDetails>?,
    val temporaryBlocked: Boolean,
    val temporaryBlockedUntil: ZonedDateTime?,
    var userDetails: UserDetails?
) : UpdateIEntityDto<UaaUserDto> {

    override fun toModel(): UaaUser {
        return Mappers.userMapper.toDomainModel(this)
    }
}