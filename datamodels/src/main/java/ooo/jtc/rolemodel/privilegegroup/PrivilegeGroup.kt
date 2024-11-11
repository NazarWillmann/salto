package ooo.jtc.rolemodel.privilegegroup

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.interfaces.ITransferEntity
import ooo.jtc.rolemodel.privilege.Privilege
import java.sql.Timestamp
import java.util.UUID

@KotlinBuilder
data class PrivilegeGroup(
    override var id: UUID?,
    @NotRequiredForTest override var version: Int,
    var name: String,
    var description: String?,

    //filled in dbPostProcessor
    @NotRequiredForTest var groups: List<PrivilegeGroup>?,
    @NotRequiredForTest var privileges: List<Privilege>?,

    @NotRequiredForTest @JsonProperty("created_at") var createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Timestamp?
) : ITransferEntity {

    @NotRequiredForTest
    override val entityName = RoleModelNames.PRIVILEGE_GROUP

    override fun toDto(): PrivilegeGroupDto = Mappers.privilegeGroupMapper.toDto(this)
}
