package ooo.jtc.rolemodel.trees

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.github.pozo.KotlinBuilder
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto
import java.util.UUID

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
data class PrivilegeTreeDto(
    var id: UUID,
    var name: String,
    var uiName: String,
    var description: String?,
    var included: Boolean,
    var includedDirect: Boolean,
    var includedViaGroup: PrivilegeGroupDto?
)
