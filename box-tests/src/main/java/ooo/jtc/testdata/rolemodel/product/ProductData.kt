package ooo.jtc.testdata.rolemodel.product

import ooo.jtc.rolemodel.product.Product
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestData

object ProductData : TestData<Product>(Product::class.java) {
    override var atMarkerPredicate: (Product) -> Boolean = { false }
    override val dbDataConsumer = { Services.DOMAIN_CONTROLLER.db.execSql("SELECT * FROM product") }
    override val dataFileName = "product.json"
}