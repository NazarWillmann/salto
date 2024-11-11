package ooo.jtc.testdata.dictionaries.paymentpriority

import ooo.jtc.api.dictionaries.paymentpriority.PaymentPriorityPrepareSteps
import ooo.jtc.api.dictionaries.paymentpriority.PaymentPrioritySteps
import ooo.jtc.core.TestConstants.AT_POSTFIX_RUS_PARENTHESES
import ooo.jtc.dictionaries.paymentpriority.PaymentPriority
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * PaymentPriorityData data, that loaded from testDataProvider as [PaymentPriorityData] in [PaymentPriority] format.
 */
object PaymentPriorityData : TestData<PaymentPriority>(PaymentPriority::class.java) {
    override var atMarkerPredicate: (PaymentPriority) -> Boolean = { it.description.endsWith(AT_POSTFIX_RUS_PARENTHESES) }
    override val dbDataConsumer = { Services.RKO_DICTIONARY.db.execSql("SELECT * FROM payment_priority") }
    override val dataFileName = "paymentPriority.json"

    override var createRecord: (() -> PaymentPriority)? = null
        get() = { PaymentPriorityPrepareSteps.createPaymentPriorityDto().toModel() }

    override var removeRecord: ((PaymentPriority) -> Unit)? = { PaymentPrioritySteps(Users.superUser).delete(it.id!!) }
}

/**
 * Enum for searching [PaymentPriority] in [PaymentPriorityData]
 */
enum class FindPaymentPriorityBy(override var predicate: (PaymentPriority) -> Boolean) :
    FindEntityBy<PaymentPriority, PaymentPriorityData> {

    AT_CREATED(PaymentPriorityData.atMarkerPredicate),
    ;
}