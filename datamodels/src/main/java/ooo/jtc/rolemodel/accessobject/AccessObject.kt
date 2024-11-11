package ooo.jtc.rolemodel.accessobject

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
data class AccessObject(
    override var id: UUID?,
    override var version: Int,
    var name: String,
    @JsonProperty("ui_name") var uiName: String,
    var description: String?,
    @JsonProperty("id_object_type") var objectTypeId: UUID,
    @JsonProperty("id_product") var productId: UUID,
    var path: String?,
    @JsonProperty("has_controls") var hasControls: Boolean?,
    @NotRequiredForTest @JsonProperty("created_at") var createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Timestamp?

) : ITransferEntity {
    override fun toDto(): AccessObjectDto {
        return Mappers.accessObjectMapper.toDto(this)
    }

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = RoleModelNames.ACCESS_OBJECT
}
