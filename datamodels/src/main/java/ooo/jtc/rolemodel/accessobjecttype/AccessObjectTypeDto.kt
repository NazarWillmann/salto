package ooo.jtc.rolemodel.accessobjecttype

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityName(RoleModelNames.ACCESS_OBJECT_TYPE)
data class AccessObjectTypeDto(
    override var id: UUID?,
    override var version: Int,
    var name: String,
) : UpdateIEntityDto<AccessObjectTypeDto> {
    override fun toModel(): AccessObjectType = Mappers.accessObjectTypeMapper.toDomainModel(this)
}
