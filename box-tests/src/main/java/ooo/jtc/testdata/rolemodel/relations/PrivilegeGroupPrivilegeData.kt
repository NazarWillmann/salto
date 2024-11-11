package ooo.jtc.testdata.rolemodel.relations

import ooo.jtc.rolemodel.relations.PrivilegeGroupPrivilege
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestData

/**
 * PrivilegeGroupPrivilegeData data, that loaded from testDataProvider as [PrivilegeGroupPrivilegeData] in [PrivilegeGroupPrivilege] format.
 */
object PrivilegeGroupPrivilegeData : TestData<PrivilegeGroupPrivilege>(PrivilegeGroupPrivilege::class.java) {
    override var atMarkerPredicate: (PrivilegeGroupPrivilege) -> Boolean = { false }
    override val dbDataConsumer = { Services.DOMAIN_CONTROLLER.db.execSql("SELECT * FROM privilege_group_privilege") }
    override val dataFileName = "privilegeGroup_privilege.json"

    override var createRecord: (() -> PrivilegeGroupPrivilege)? = null
        get() { throw RuntimeException("This should be created by PrivilegeGroup API!") }

    override var removeRecord: ((PrivilegeGroupPrivilege) -> Unit)? = null
        get() { throw RuntimeException("This should be deleted by PrivilegeGroup API!") }
}