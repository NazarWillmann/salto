package ooo.jtc.testdata.rolemodel.accessojbect

import ooo.jtc.rolemodel.accessobject.AccessObject
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestData
import ooo.jtc.testdata.rolemodel.accessobjecttype.AccessObjectTypeData
import ooo.jtc.testdata.rolemodel.product.ProductData

object AccessObjectData : TestData<AccessObject>(AccessObject::class.java) {
    override var atMarkerPredicate: (AccessObject) -> Boolean = { false }
    override val dbDataConsumer = { Services.DOMAIN_CONTROLLER.db.execSql("SELECT * FROM ao") }
    override val dataFileName = "ao.json"

    private val productData by lazy { ProductData.get() }
    private val accessObjectTypeData by lazy { AccessObjectTypeData.get() }

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { dbAccessObjectMap ->
            dbAccessObjectMap.apply {
                dbAccessObjectMap["product"] = productData
                    .filter { it.id == dbAccessObjectMap["id_product"] }
                dbAccessObjectMap["objectType"] = accessObjectTypeData
                    .filter { it.id == dbAccessObjectMap["id_object_type"] }
            }
        }
}