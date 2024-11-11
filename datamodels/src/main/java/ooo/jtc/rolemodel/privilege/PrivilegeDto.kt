package ooo.jtc.rolemodel.privilege

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.rolemodel.accessobject.AccessObjectDto
import java.util.*

@KotlinBuilder
@EntityName(RoleModelNames.PRIVILEGE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PrivilegeDto(
    override var id: UUID?,
    override var version: Int,
    var name: String,
    var uiName: String,
    var description: String?,
    var accessObjectId: UUID,
    var accessObject: AccessObjectDto?
) : UpdateIEntityDto<PrivilegeDto> {
    override fun toModel(): Privilege = Mappers.privilegeMapper.toDomainModel(this)
}