package ooo.jtc.rolemodel.privilegegroup

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.rolemodel.privilege.PrivilegeDto
import java.util.UUID

@KotlinBuilder
@EntityName(RoleModelNames.PRIVILEGE_GROUP)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PrivilegeGroupDto(
    override var id: UUID?,
    override var version: Int,
    var name: String,
    var description: String?,

    var groups: List<PrivilegeGroupDto>?,
    var privileges: List<PrivilegeDto>?
) : UpdateIEntityDto<PrivilegeGroupDto> {

    override fun toModel(): PrivilegeGroup = Mappers.privilegeGroupMapper.toDomainModel(this)
}
