package ooo.jtc.testdata.dictionaries.customerrepresentative

import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativeSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.core.kexensions.checkIsClientUser
import ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentative
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.uaa.User

/**
 * Customer representatives data, that loaded from testDataProvider as [CustomerRepresentativeData] in [CustomerRepresentative] format.
 */
object CustomerRepresentativeData : TestDataAT<CustomerRepresentative>(CustomerRepresentative::class.java) {

    override var atMarkerPredicate: (CustomerRepresentative) -> Boolean = { it.position?.endsWith(AT_POSTFIX) ?: false }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM customer_representative") }
    override val dataFileName = "customerRepresentative.json"

    override var removeRecord: ((CustomerRepresentative) -> Unit)? = { CustomerRepresentativeSteps().delete(it.id!!) }

    /**
     * Find CustomerRepresentative records related to customer's user.
     *
     * Calling this with bank user will always result in an exception
     */
    fun searchBy(clientUser: User): List<CustomerRepresentative> {
        clientUser.checkIsClientUser()
        return get { clientUser.uaaUserId!! == it.userId }
    }
}

/**
 * Enum for searching [CustomerRepresentative] in [CustomerRepresentativeData]
 */
enum class FindCustomerRepresentativeBy(override var predicate: (CustomerRepresentative) -> Boolean) :
    FindEntityBy<CustomerRepresentative, CustomerRepresentativeData> {

    AT_CREATED(CustomerRepresentativeData.atMarkerPredicate),
    ;
}