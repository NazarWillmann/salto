package ooo.jtc.rolemodel.trees

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.github.pozo.KotlinBuilder
import ooo.jtc.rolemodel.role.RoleDto
import ooo.jtc.uaa.resource.dto.ResourceDto

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
data class RoleTreeDto(
    var resources: List<ResourceRoleTreeDto>
)

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
data class ResourceRoleTreeDto(
    var resource: ResourceDto,
    var roles: List<RoleDto>
)
