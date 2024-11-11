package ooo.jtc.testdata.dictionaries.incometype

import ooo.jtc.api.dictionaries.incometype.IncomeTypePrepareSteps
import ooo.jtc.api.dictionaries.incometype.IncomeTypePrepareSteps.getIncomeTypeDtoForCreate
import ooo.jtc.api.dictionaries.incometype.IncomeTypeSteps
import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.dictionaries.incometype.IncomeType
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users.autotest
import ooo.jtc.testdata.common.TestData

object IncomeTypeData : TestData<IncomeType>(IncomeType::class.java) {
    override var atMarkerPredicate: (IncomeType) -> Boolean = { it.name.startsWith(AT_PREFIX_RUS) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM income_type") }
    override val dataFileName: String = "incomeType.json"

    override var createRecord: (() -> IncomeType)? = null
        get() = {
            val incomeTypeDto = getIncomeTypeDtoForCreate(textFieldGenerator = RandomData.ruWords)
            IncomeTypeSteps(user = autotest).create(incomeTypeDto).data!!.toModel()
        }

    override var removeRecord: ((IncomeType) -> Unit)? = {
        IncomeTypeSteps(user = autotest).delete(it.id!!)
        IncomeTypePrepareSteps.addValidCode(it.code!!)
    }
}