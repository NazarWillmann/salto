package ooo.jtc.testdata.dictionaries.contractorpayment

import ooo.jtc.api.dictionaries.contractorpayment.ContractorPaymentSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.contractor.Contractor
import ooo.jtc.dictionaries.contractorpayment.ContractorPayment
import ooo.jtc.dictionaries.customer.Customer
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.testdata.dictionaries.contractor.ContractorData
import ooo.jtc.uaa.User

/**
 * ContractorPaymentData data, that loaded from testDataProvider as [ContractorPaymentData] in [ContractorPayment] format.
 */
object ContractorPaymentData : TestDataAT<ContractorPayment>(ContractorPayment::class.java) {
    override var atMarkerPredicate: (ContractorPayment) -> Boolean = { it.bankAddress.endsWith(AT_POSTFIX) }
    override val dbDataConsumer = { Services.RKO_DICTIONARY.db.execSql("SELECT * FROM contractor_payment") }
    override val dataFileName = "contractorPayment.json"

    override var removeRecord: ((ContractorPayment) -> Unit)? = { ContractorPaymentSteps(Users.superUser).delete(it.id!!) }

    fun searchBy(user: User): List<ContractorPayment> {
        val availableContractorsIds = ContractorData.searchBy(user).map { it.id!! }
        return this.get { it.contractorId in availableContractorsIds }
    }

    fun searchBy(contractor: Contractor): List<ContractorPayment> {
        return this.get { it.contractorId == contractor.id }
    }

    fun searchBy(customer: Customer): List<ContractorPayment> {
        val contractors = ContractorData.searchBy(customer)
        return contractors.flatMap { searchBy(it) }
    }

}


/**
 * Enum for searching [ContractorPayment] in [ContractorPaymentData]
 */
enum class FindContractorPaymentBy(override var predicate: (ContractorPayment) -> Boolean) :
    FindEntityBy<ContractorPayment, ContractorPaymentData> {

    AT_CREATED(ContractorPaymentData.atMarkerPredicate),
    ;
}