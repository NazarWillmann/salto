package ooo.jtc.rolemodel.trees

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.github.pozo.KotlinBuilder
import java.util.UUID

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
data class AccessObjectTreeDto(
    var id: UUID,
    var name: String,
    var uiName: String,
    var description: String?,
    var included: Boolean,
    var privileges: List<PrivilegeTreeDto>
)
