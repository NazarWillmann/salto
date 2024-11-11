package ooo.jtc.testdata.dictionaries.budgetpayerstatus

import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusPrepareSteps
import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX_RUS_PARENTHESES
import ooo.jtc.dictionaries.budgetpayerstatus.BudgetPayerStatus
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * BudgetPayerStatus data, that loaded from testDataProvider as [BudgetPayerStatusData] in [BudgetPayerStatus] format.
 */
object BudgetPayerStatusData : TestData<BudgetPayerStatus>(BudgetPayerStatus::class.java) {
    override var atMarkerPredicate: (BudgetPayerStatus) -> Boolean = { it.description?.endsWith(AT_POSTFIX_RUS_PARENTHESES) ?: false }
    override val dbDataConsumer = { Services.RKO_DICTIONARY.db.execSql("SELECT * FROM budget_payer_status") }
    override val dataFileName = "budgetPayerStatus.json"

    override var createRecord: (() -> BudgetPayerStatus)? = {
        val prepareDto = BudgetPayerStatusPrepareSteps.getBudgetPayerStatusDtoForCreate()
        BudgetPayerStatusSteps(Users.bankAdmin).create(prepareDto).data!!.toModel()
    }

    override var removeRecord: ((BudgetPayerStatus) -> Unit)? = { BudgetPayerStatusSteps(Users.superUser).delete(it.id!!) }
}


/**
 * Enum for searching [BudgetPayerStatus] in [BudgetPayerStatusData]
 */
enum class FindBudgetPayerStatusBy(override var predicate: (BudgetPayerStatus) -> Boolean) :
    FindEntityBy<BudgetPayerStatus, BudgetPayerStatusData> {

    AT_CREATED(BudgetPayerStatusData.atMarkerPredicate),
    ;
}
