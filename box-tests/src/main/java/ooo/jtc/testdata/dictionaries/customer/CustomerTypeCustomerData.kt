package ooo.jtc.testdata.dictionaries.customer

import ooo.jtc.dictionaries.customer.CustomerTypeCustomer
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestDataAT

/**
 * CustomerTypeCustomer dictionary data, that loaded from testDataProvider as [CustomerTypeCustomerData] in [CustomerTypeCustomer] format.
 */
object CustomerTypeCustomerData : TestDataAT<CustomerTypeCustomer>(CustomerTypeCustomer::class.java) {
    //There is no way to know for sure if CustomerTypeCustomer was AT-created
    override var atMarkerPredicate: (CustomerTypeCustomer) -> Boolean = { false }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM customer_type_customer") }
    override val dataFileName = "customerTypeCustomer.json"

    override var removeRecord: ((CustomerTypeCustomer) -> Unit)? = null
        get() { throw RuntimeException("This should be deleted by deleting or updating Customer!") }
}
