package ooo.jtc.testdata.dictionaries.customerkpp

import ooo.jtc.api.dictionaries.customerkpp.CustomerKppPrepareSteps
import ooo.jtc.api.dictionaries.customerkpp.CustomerKppSteps
import ooo.jtc.core.TestConstants.AT_NUM
import ooo.jtc.dictionaries.customer.Customer
import ooo.jtc.dictionaries.customerkpp.CustomerKpp
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.uaa.User

/**
 * CustomerKpp data, that loaded from testDataProvider as [CustomerKppData] in [CustomerKpp] format.
 */
object CustomerKppData : TestDataAT<CustomerKpp>(CustomerKpp::class.java) {
    override var atMarkerPredicate: (CustomerKpp) -> Boolean = { it.kpp.endsWith(AT_NUM) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM customer_kpp") }
    override val dataFileName = "customerKpp.json"

    override var removeRecord: ((CustomerKpp) -> Unit)? = { CustomerKppSteps(Users.superUser).delete(it.id!!) }


    fun searchBy(customer: Customer): List<CustomerKpp> = get { customer.id == it.idCustomer && atMarkerPredicate.invoke(it) }

    fun searchBy(user: User): List<CustomerKpp> {
        val availableCustomersIds = CustomerData.searchBy(user).map { it.id!! }
        return get { it.idCustomer in availableCustomersIds }
    }

    // TODO: ?this as GoC
    fun searchDefaultBy(customer: Customer): CustomerKpp? = searchBy(customer).firstOrNull { it.isDefault }

    fun getOrCreateDefault(user: User): CustomerKpp {
        return super.getOrCreate(
            consumer = { searchBy(user).filter { it.isDefault } },
            provider = {
                val defaultKppForCustomer = CustomerKppPrepareSteps.getCustomerKppDtoForCreate(user)
                    .apply { isDefault = true }
                CustomerKppPrepareSteps.createCustomerKppDto(defaultKppForCustomer).toModel()
            }
        )
    }
}

/**
 * Enum for searching [CustomerKpp] in [CustomerKppData]
 */
enum class FindCustomerKppBy(override var predicate: (CustomerKpp) -> Boolean) :
    FindEntityBy<CustomerKpp, CustomerKppData> {

    AT_CREATED(CustomerKppData.atMarkerPredicate),
    ;
}