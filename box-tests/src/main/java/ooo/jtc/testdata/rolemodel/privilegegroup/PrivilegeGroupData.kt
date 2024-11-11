package ooo.jtc.testdata.rolemodel.privilegegroup

import ooo.jtc.api.rolemodel.privilegegroup.PrivilegeGroupPrepareSteps
import ooo.jtc.api.rolemodel.privilegegroup.PrivilegeGroupSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroup
import ooo.jtc.rolemodel.role.Role
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestData
import ooo.jtc.testdata.rolemodel.privilege.PrivilegeData
import ooo.jtc.testdata.rolemodel.relations.PrivilegeGroupPrivilegeData
import ooo.jtc.testdata.rolemodel.relations.PrivilegeGroupPrivilegeGroupData
import ooo.jtc.testdata.rolemodel.relations.RolePrivilegeGroupData
import ooo.jtc.testdata.rolemodel.role.RoleData
import java.util.UUID

/**
 * PrivilegeGroupData data, that loaded from testDataProvider as [PrivilegeGroupData] in [PrivilegeGroup] format.
 * With related Roles
 */
object PrivilegeGroupData : TestData<PrivilegeGroup>(PrivilegeGroup::class.java) {
    override var atMarkerPredicate: (PrivilegeGroup) -> Boolean = { it.name.endsWith(TestConstants.AT_POSTFIX) }
    override val dbDataConsumer = { Services.DOMAIN_CONTROLLER.db.execSql("SELECT * FROM privilege_group") }
    override val dataFileName = "privilegeGroup.json"

    override var createRecord: (() -> PrivilegeGroup)? = null
        get() = { PrivilegeGroupPrepareSteps.createPrivilegeGroupDto().toModel() }

    override var removeRecord: ((PrivilegeGroup) -> Unit)? = { PrivilegeGroupSteps(Users.securityAdmin).delete(it.id!!) }

    private val groupsOnlyData by lazy { PrivilegeGroupOnlyData.get() }
    private val groupsRelationData by lazy { PrivilegeGroupPrivilegeGroupData.get() }
    private val privilegeData by lazy { PrivilegeData.get() }
    private val privilegesRelationData by lazy { PrivilegeGroupPrivilegeData.get() }

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { privilegeGroupMap ->
            privilegeGroupMap.apply {
                val relatedPrivilegesIds = privilegesRelationData
                    .filter { privilegeGroupMap["id"] == it.idGroup.toString() }
                    .map { it.idPrivilege }
                privilegeGroupMap["privileges"] = privilegeData
                    .filter { it.id in relatedPrivilegesIds }

                val relatedGroupsIds = groupsRelationData
                    .filter { privilegeGroupMap["id"] == it.idParent.toString() }
                    .map { it.idChild }
                privilegeGroupMap["groups"] = groupsOnlyData
                    .filter { it.id in relatedGroupsIds }
            }
        }

    fun getRolesUsingPrGroup(prGroupId: UUID): List<Role> {
        val allRelatedPrGroupsIds = PrivilegeGroupPrivilegeGroupData.getAllPrGroupsIdsContainingPrGroupsIds(prGroupId)
            .toMutableList()
        allRelatedPrGroupsIds.add(prGroupId)
        val roleIds = RolePrivilegeGroupData.get { it.idGroup in allRelatedPrGroupsIds }.map { it.roleName }

        return RoleData.get { it.name in roleIds }
    }
}

/**
 * PrivilegeGroupData data, that loaded from testDataProvider as [PrivilegeGroupData] in [PrivilegeGroup] format.
 * Without related Roles
 */
object PrivilegeGroupOnlyData : TestData<PrivilegeGroup>(PrivilegeGroup::class.java) {
    override var atMarkerPredicate: (PrivilegeGroup) -> Boolean = { it.name.endsWith(TestConstants.AT_POSTFIX) }
    override val dbDataConsumer = { Services.DOMAIN_CONTROLLER.db.execSql("SELECT * FROM privilege_group") }
    override val dataFileName = "privilegeGroup(pure).json"

    override var createRecord: (() -> PrivilegeGroup)? = null
        get() = throw RuntimeException("Use 'PrivilegeGroupData' instead!")
    override var removeRecord: ((PrivilegeGroup) -> Unit)? = null
        get() = throw RuntimeException("Use 'PrivilegeGroupData' instead!")
}