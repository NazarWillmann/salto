package ooo.jtc.testdata.dictionaries.paymenttype


import ooo.jtc.api.dictionaries.paymenttype.PaymentTypePrepareSteps
import ooo.jtc.api.dictionaries.paymenttype.PaymentTypeSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.paymenttype.PaymentType
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * PaymentTypeData data, that loaded from testDataProvider as [PaymentTypeData] in [PaymentType] format.
 */
object PaymentTypeData : TestData<PaymentType>(PaymentType::class.java) {
    override var atMarkerPredicate: (PaymentType) -> Boolean = { it.description.endsWith(AT_POSTFIX) }
    override val dbDataConsumer = { Services.RKO_DICTIONARY.db.execSql("SELECT * FROM payment_type") }
    override val dataFileName = "paymentType.json"

    override var createRecord: (() -> PaymentType)? = null
        get() = { PaymentTypePrepareSteps.createPaymentTypeDto().toModel() }

    override var removeRecord: ((PaymentType) -> Unit)? = { PaymentTypeSteps(Users.superUser).delete(it.id!!) }
}

/**
 * Enum for searching [PaymentType] in [PaymentTypeData]
 */
enum class FindPaymentTypeBy(override var predicate: (PaymentType) -> Boolean) :
    FindEntityBy<PaymentType, PaymentTypeData> {

    AT_CREATED(PaymentTypeData.atMarkerPredicate),
    ;
}