package ooo.jtc.rolemodel.relations

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.interfaces.IEntity
import java.util.UUID


@KotlinBuilder
data class RolePrivilegeGroup(
    @JsonProperty("id_group") val idGroup: UUID,
    @JsonProperty("role_name") val roleName: String
): IEntity {

    @NotRequiredForTest @JsonIgnore override val entityName: String = "Связь Групп привилегий с Ролями"
    @NotRequiredForTest @JsonIgnore override var id: UUID? = null
    @NotRequiredForTest @JsonIgnore override var version: Int = 0
}
