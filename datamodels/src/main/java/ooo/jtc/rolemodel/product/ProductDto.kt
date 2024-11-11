package ooo.jtc.rolemodel.product

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
@EntityName(RoleModelNames.PRODUCT)
data class ProductDto(
    override var id: UUID?,
    override var version: Int,
    var name: String,
    var uiName: String,
    var description: String?,
    var path: String?
) : UpdateIEntityDto<ProductDto> {
    override fun toModel(): Product = Mappers.productMapper.toDomainModel(this)
}
