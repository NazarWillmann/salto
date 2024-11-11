package ooo.jtc.rolemodel.accessobject

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.rolemodel.accessobjecttype.AccessObjectTypeDto
import ooo.jtc.rolemodel.product.ProductDto
import java.util.*

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityName(RoleModelNames.ACCESS_OBJECT)
data class AccessObjectDto(
    override var id: UUID?,
    override var version: Int,
    var name: String,
    var uiName: String,
    var description: String?,
    var objectTypeId: UUID,
    var objectType: AccessObjectTypeDto?,
    var productId: UUID,
    var product: ProductDto?,
    var path: String?,
    var hasControls: Boolean?
) : UpdateIEntityDto<AccessObjectDto> {
    override fun toModel(): AccessObject = Mappers.accessObjectMapper.toDomainModel(this)
}
