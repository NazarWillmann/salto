package ooo.jtc.rolemodel.trees

import com.github.pozo.KotlinBuilder
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto
import java.util.UUID

@KotlinBuilder
data class GroupTreeDto(
    var id: UUID,
    var name: String,
    var description: String?,
    var included: Boolean,
    var includedDirect: Boolean,
    var groups: List<PrivilegeGroupDto>
)
