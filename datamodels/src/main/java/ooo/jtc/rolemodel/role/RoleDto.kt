package ooo.jtc.rolemodel.role;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto
import ooo.jtc.uaa.resource.dto.ResourceDto

import java.util.UUID

/**
 * Wrapper for UAA's [ooo.jtc.uaa.scope.dto.ScopeDto]
 * with additional 'privilegeGroups' list (of [ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto])
 * and with [ooo.jtc.uaa.resource.dto.ResourceDto] without 'scope's (i.e. 'role's)
 */
@KotlinBuilder
@EntityName(RoleModelNames.ROLE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class RoleDto(
    override var id: UUID?,
    override var version: Int,
    var resourceId: UUID?,
    var name: String,
    var uiName: String,
    var description: String?,
    var resource: ResourceDto?,
    var privilegeGroups: List<PrivilegeGroupDto>?
) : UpdateIEntityDto<RoleDto> {

    override fun toModel(): Role = Mappers.roleMapper.toDomainModel(this)
}
