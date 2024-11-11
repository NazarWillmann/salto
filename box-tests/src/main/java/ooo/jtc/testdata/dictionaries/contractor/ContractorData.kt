package ooo.jtc.testdata.dictionaries.contractor

import ooo.jtc.api.dictionaries.contactor.ContractorPrepareSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX_RUS_PARENTHESES
import ooo.jtc.dictionaries.contractor.Contractor
import ooo.jtc.dictionaries.contractorpayment.ContractorPayment
import ooo.jtc.dictionaries.customer.Customer
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.testdata.dictionaries.contractorcontact.ContractorContactData
import ooo.jtc.testdata.dictionaries.contractorpayment.ContractorPaymentData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.dictionaries.ground.GroundData
import ooo.jtc.uaa.User

/**
 * Contractor data, that loaded from testDataProvider as [ContractorData] in [Contractor] format.
 */
object ContractorData : TestDataAT<Contractor>(Contractor::class.java) {
    override var atMarkerPredicate: (Contractor) -> Boolean = { it.name?.endsWith(AT_POSTFIX_RUS_PARENTHESES) ?: false }
    override val dbDataConsumer = { Services.RKO_DICTIONARY.db.execSql("SELECT * FROM contractor") }
    override val dataFileName = "contractor.json"

    override var removeRecord: ((Contractor) -> Unit)? = { ContractorPrepareSteps.deleteContractorAndRelatedEntities(it.id!!) }

    fun searchBy(user: User): List<Contractor> {
        val availableCustomersIds = CustomerData.searchBy(user).map { it.id!! }
        return get { it.customerId in availableCustomersIds && atMarkerPredicate.invoke(it) }
    }

    fun searchBy(customer: Customer): List<Contractor> {
        return get { it.customerId == customer.id && atMarkerPredicate.invoke(it) }
    }

    fun searchBy(customer: Customer, isOrganization: Boolean, isBudget: Boolean): List<Contractor> {
        return get { it.customerId == customer.id && it.isOrganization == isOrganization && it.isBudget == isBudget && atMarkerPredicate.invoke(it) }
    }

    fun searchBy(contractorPayment: ContractorPayment): List<Contractor> {
        return get { it.id == contractorPayment.contractorId && atMarkerPredicate.invoke(it) }
    }

    private val contact by lazy { ContractorContactData.get() }
    private val payment by lazy { ContractorPaymentData.get() }
    private val ground by lazy { GroundData.get() }

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { dbContractorMap ->
            dbContractorMap.apply {
                val contractorId = dbContractorMap["id"].toString()

                dbContractorMap["contacts"] = contact
                    .filter { contractorId == it.contractorId.toString() }
                dbContractorMap["payments"] = payment
                    .filter { contractorId == it.contractorId.toString() }
                dbContractorMap["grounds"] = ground
                    .filter { contractorId == it.contractorId.toString() }
            }
        }
}


/**
 * Enum for searching [Contractor] in [ContractorData]
 */
enum class FindContractorBy(override var predicate: (Contractor) -> Boolean) :
    FindEntityBy<Contractor, ContractorData> {

    AT_CREATED(ContractorData.atMarkerPredicate),
    ;
}