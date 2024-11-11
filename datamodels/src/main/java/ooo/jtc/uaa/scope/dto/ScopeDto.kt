package ooo.jtc.uaa.scope.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.UaaNames
import ooo.jtc.interfaces.IEntityDto
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.uaa.mfa.model.Mfa
import ooo.jtc.uaa.resource.dto.ResourceDto
import ooo.jtc.uaa.scope.model.Scope
import java.util.*

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityName(UaaNames.SCOPE)
data class ScopeDto(
    override var id: UUID?,
    override var version: Int,
    var resourceId: UUID,
    val name: String,
    val uiName: String,
    var description: String?,
    val needApprove: Boolean,
    val resource: ResourceDto?
) : IEntityDto {

    override fun toModel(): Scope {
        return Mappers.scopeMapper.toDomainModel(this)
    }
}

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityName(UaaNames.SCOPE)
data class ScopeUpdateRequest(
    override var id: UUID?,
    override var version: Int,
    val uiName: String,
    var description: String?,
    val needApprove: Boolean
) : UpdateIEntityDto<ScopeDto>