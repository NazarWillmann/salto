package ooo.jtc.testdata.rolemodel.role

import ooo.jtc.api.rolemodel.role.RolePrepareSteps
import ooo.jtc.api.rolemodel.role.RoleSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.rolemodel.role.Role
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestData
import ooo.jtc.testdata.rolemodel.privilegegroup.PrivilegeGroupOnlyData
import ooo.jtc.testdata.rolemodel.relations.RolePrivilegeGroupData

/**
 * RoleData data, that loaded from testDataProvider as [RoleData] in [Role] format.
 * With related Privilege Groups
 */
object RoleData : TestData<Role>(Role::class.java) {
    override var atMarkerPredicate: (Role) -> Boolean = { it.name.endsWith(TestConstants.AT_POSTFIX) }
    override val dbDataConsumer = { Services.UAA.db.execSql("SELECT * FROM oauth_scope") }
    override val dataFileName = "role(scope).json"

    override var createRecord: (() -> Role)? = null
        get() = { RolePrepareSteps.createRoleDto().toModel() }

    override var removeRecord: ((Role) -> Unit)? = { RoleSteps(Users.securityAdmin).delete(it.id!!) }

    private val privilegeGroupData by lazy { PrivilegeGroupOnlyData.get() }
    private val relationData by lazy { RolePrivilegeGroupData.get() }

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { abRoleMap ->
            abRoleMap.apply {
                val relatedPrivilegeGroupsIds = relationData
                    .filter { it.roleName == abRoleMap["name"] }
                    .map { it.idGroup }
                abRoleMap["privilegeGroups"] = privilegeGroupData
                    .filter { it.id in relatedPrivilegeGroupsIds }
            }
        }
}