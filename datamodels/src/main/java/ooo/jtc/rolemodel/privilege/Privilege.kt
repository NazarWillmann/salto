package ooo.jtc.rolemodel.privilege

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.interfaces.ITransferEntity
import ooo.jtc.rolemodel.accessobject.AccessObject
import java.sql.Timestamp
import java.util.*

@KotlinBuilder
data class Privilege(
    override var id: UUID?,
    override var version: Int,
    var name: String,
    @JsonProperty("ui_name") var uiName: String,
    var description: String?,
    @JsonProperty("id_access_object") val accessObjectId: UUID,
    var accessObject: AccessObject,

    @NotRequiredForTest @JsonProperty("created_at") var createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Timestamp?
) : ITransferEntity {

    @NotRequiredForTest
    @JsonIgnore
    override val entityName: String = RoleModelNames.PRIVILEGE

    override fun toDto(): PrivilegeDto = Mappers.privilegeMapper.toDto(this)
}