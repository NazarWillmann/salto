package ooo.jtc.testdata.dictionaries.budgetreasoncode

import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodePrepareSteps.getBudgetReasonCodeDtoForCreate
import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodeSteps
import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.dictionaries.budgetreasoncode.BudgetReasonCode
import ooo.jtc.dictionaries.budgetreasoncode.PayType
import ooo.jtc.random.RandomData
import ooo.jtc.rupayment.model.BudgetType
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.common.TestData

/**
 * BudgetReasonCode data, that loaded from testDataProvider as [BudgetReasonCodeData] in [BudgetReasonCode] format.
 */
object BudgetReasonCodeData : TestData<BudgetReasonCode>(BudgetReasonCode::class.java) {
    override var atMarkerPredicate: (BudgetReasonCode) -> Boolean = { it.description.startsWith(AT_PREFIX_RUS) }
    override val dbDataConsumer = { Services.RKO_DICTIONARY.db.execSql("SELECT * FROM budget_reason_code") }
    override val dataFileName = "budgetReasonCode.json"

    fun searchBy(budgetType: BudgetType) = get { it.payType.toString() == budgetType.toString() || it.payType == PayType.ALL }

    override var createRecord: (() -> BudgetReasonCode)? = null
        get() = {
            val prepareDto = getBudgetReasonCodeDtoForCreate(textFieldGenerator = RandomData.ruWords)
            BudgetReasonCodeSteps(user = bankAdmin).create(prepareDto).data!!.toModel()
        }

    override var removeRecord: ((BudgetReasonCode) -> Unit)? = { BudgetReasonCodeSteps(Users.superUser).delete(it.id!!) }
}