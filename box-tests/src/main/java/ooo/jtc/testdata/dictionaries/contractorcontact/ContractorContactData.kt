package ooo.jtc.testdata.dictionaries.contractorcontact

import ooo.jtc.api.dictionaries.contractorcontact.ContractorContactSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.contractorcontact.ContractorContact
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.testdata.dictionaries.contractor.ContractorData
import ooo.jtc.uaa.User

/**
 * ContractorContact data, that loaded from testDataProvider as [ContractorContactData] in [ContractorContact] format.
 */
object ContractorContactData : TestDataAT<ContractorContact>(ContractorContact::class.java) {
    override var atMarkerPredicate: (ContractorContact) -> Boolean = { it.name.endsWith(AT_POSTFIX) }
    override val dbDataConsumer = { Services.RKO_DICTIONARY.db.execSql("SELECT * FROM contractor_contact") }
    override val dataFileName = "contractorContract.json"

    override var removeRecord: ((ContractorContact) -> Unit)? = { ContractorContactSteps(Users.superUser).delete(it.id!!) }

    fun searchBy(user: User): List<ContractorContact> {
        val availableContractorsIds = ContractorData.searchBy(user).map { it.id!! }
        return get { it.contractorId in availableContractorsIds }
    }
}


/**
 * Enum for searching [ContractorContact] in [ContractorContactData]
 */
enum class FindContractorContactBy(override var predicate: (ContractorContact) -> Boolean) :
    FindEntityBy<ContractorContact, ContractorContactData> {

    AT_CREATED(ContractorContactData.atMarkerPredicate),
    ;
}