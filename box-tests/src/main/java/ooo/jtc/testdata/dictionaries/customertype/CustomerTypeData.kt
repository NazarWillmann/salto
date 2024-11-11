package ooo.jtc.testdata.dictionaries.customertype

import ooo.jtc.api.dictionaries.customertype.CustomerTypePrepareSteps
import ooo.jtc.api.dictionaries.customertype.CustomerTypeSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.customertype.CustomerType
import ooo.jtc.dictionaries.customertype.CustomerTypeShort
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * CustomerType data, that loaded from testDataProvider as [CustomerTypeData] in [CustomerType] format.
 */
object CustomerTypeData : TestData<CustomerType>(CustomerType::class.java) {
    override var atMarkerPredicate: (CustomerType) -> Boolean = { it.systemName.endsWith(AT_POSTFIX) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM customer_type") }
    override val dataFileName = "customerType.json"

    override var createRecord: (() -> CustomerType)? = null
        get() = {
            val preparedDto = CustomerTypePrepareSteps.getCustomerTypeDtoForCreate()
            CustomerTypeSteps(Users.bankAdmin).create(preparedDto).data!!.toModel()
        }

    override var removeRecord: ((CustomerType) -> Unit)? = { CustomerTypeSteps(Users.superUser).delete(it.id!!) }
}

/**
 * Enum for searching [CustomerType] in [CustomerTypeData]
 */
enum class FindCustomerTypeBy(override var predicate: (CustomerType) -> Boolean) :
    FindEntityBy<CustomerType, CustomerTypeData> {

    AT_CREATED(CustomerTypeData.atMarkerPredicate),
    IP(predicate = { CustomerTypeShort.IP == it.systemName }),
    UL(predicate = { CustomerTypeShort.UL == it.systemName }),
    ;
}
