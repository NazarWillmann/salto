package ooo.jtc.testdata.rolemodel.relations

import ooo.jtc.rolemodel.relations.RolePrivilegeGroup
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestData

/**
 * RolePrivilegeGroupData data, that loaded from testDataProvider as [RolePrivilegeGroupData] in [RolePrivilegeGroup] format.
 */
object RolePrivilegeGroupData : TestData<RolePrivilegeGroup>(RolePrivilegeGroup::class.java) {
    override var atMarkerPredicate: (RolePrivilegeGroup) -> Boolean = { false }
    override val dbDataConsumer = { Services.DOMAIN_CONTROLLER.db.execSql("SELECT * FROM role_privilege_group") }
    override val dataFileName = "role_privilegeGroup.json"

    override var createRecord: (() -> RolePrivilegeGroup)? = null
        get() { throw RuntimeException("This should be created by Role API or PrivilegeGroup API!") }

    override var removeRecord: ((RolePrivilegeGroup) -> Unit)? = null
        get() { throw RuntimeException("This should be deleted by Role API or PrivilegeGroup API!") }
}