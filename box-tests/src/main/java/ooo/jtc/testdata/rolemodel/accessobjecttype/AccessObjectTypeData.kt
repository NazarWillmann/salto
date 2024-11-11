package ooo.jtc.testdata.rolemodel.accessobjecttype

import ooo.jtc.rolemodel.accessobjecttype.AccessObjectType
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestData

object AccessObjectTypeData : TestData<AccessObjectType>(AccessObjectType::class.java) {
    override var atMarkerPredicate: (AccessObjectType) -> Boolean = { false }
    override val dbDataConsumer = { Services.DOMAIN_CONTROLLER.db.execSql("SELECT * FROM ao_type") }
    override val dataFileName = "ao_type.json"
}