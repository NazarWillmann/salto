package ooo.jtc.testdata.rolemodel.privilege

import ooo.jtc.rolemodel.privilege.Privilege
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestData
import ooo.jtc.testdata.rolemodel.accessojbect.AccessObjectData

object PrivilegeData : TestData<Privilege>(Privilege::class.java) {
    override var atMarkerPredicate: (Privilege) -> Boolean = { false }
    override val dbDataConsumer = { Services.DOMAIN_CONTROLLER.db.execSql("SELECT * FROM privilege") }
    override val dataFileName = "privilege.json"

    private val accessObjectData by lazy { AccessObjectData.get() }

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { dbPrivilegeMap ->
            dbPrivilegeMap.apply {
                dbPrivilegeMap["accessObject"] = accessObjectData
                    .first { it.id == dbPrivilegeMap["id_access_object"] }
            }
        }
}