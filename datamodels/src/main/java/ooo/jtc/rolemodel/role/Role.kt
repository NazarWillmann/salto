package ooo.jtc.rolemodel.role

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.interfaces.ITransferEntity
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroup
import java.sql.Timestamp
import java.util.UUID

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
data class Role(
    override var id: UUID?,
    @NotRequiredForTest override var version: Int,
    var name: String,
    @JsonProperty("ui_name") var uiName: String,
    var description: String?,
    @JsonProperty("id_resource") val resourceId: UUID,
    @JsonProperty("need_approve") val needApprove: Boolean,

    // filled in dbPostProcessor
    @NotRequiredForTest var privilegeGroups: List<PrivilegeGroup>?,

    @NotRequiredForTest @JsonProperty("created_at") var createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Timestamp?
) : ITransferEntity {

    override fun toDto(): RoleDto = Mappers.roleMapper.toDto(this)

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = RoleModelNames.ROLE
}