package ooo.jtc.testdata.dictionaries.salarypaymenttype

import ooo.jtc.api.dictionaries.salarypaymenttype.SalaryPaymentTypePrepareSteps
import ooo.jtc.api.dictionaries.salarypaymenttype.SalaryPaymentTypePrepareSteps.getSalaryPaymentTypeDtoForCreate
import ooo.jtc.api.dictionaries.salarypaymenttype.SalaryPaymentTypeSteps
import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.dictionaries.salarypaymenttype.SalaryPaymentType
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users.autotest
import ooo.jtc.testdata.common.TestData

object SalaryPaymentTypeData : TestData<SalaryPaymentType>(SalaryPaymentType::class.java) {
    override var atMarkerPredicate: (SalaryPaymentType) -> Boolean = { it.name!!.startsWith(AT_PREFIX_RUS) }
    override val dbDataConsumer = { Services.SALARY.db.execSql("SELECT * FROM payment_type") }
    override val dataFileName = "paymentType.json"

    override var createRecord: (() -> SalaryPaymentType)? = null
        get() = {
            val salaryPaymentTypeDto = getSalaryPaymentTypeDtoForCreate(nameGenerator = RandomData.ruWords)
            SalaryPaymentTypeSteps(user = autotest).create(salaryPaymentTypeDto).data!!.toModel()
        }

    override var removeRecord: ((SalaryPaymentType) -> Unit)? = {
        SalaryPaymentTypeSteps(autotest).delete(it.id!!)
        SalaryPaymentTypePrepareSteps.availableSalaryPaymentTypeCodes.add(it.code!!)
    }
}