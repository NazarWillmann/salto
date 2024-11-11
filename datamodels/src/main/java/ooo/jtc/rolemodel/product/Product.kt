package ooo.jtc.rolemodel.product

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.util.*

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
data class Product(
    override var id: UUID?,
    override var version: Int,
    var name: String,
    @JsonProperty("ui_name") var uiName: String,
    var description: String?,
    var path: String?,
    @NotRequiredForTest @JsonProperty("created_at") var createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Timestamp?

) : ITransferEntity {
    override fun toDto(): ProductDto {
        return Mappers.productMapper.toDto(this)
    }

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = RoleModelNames.PRODUCT
}
