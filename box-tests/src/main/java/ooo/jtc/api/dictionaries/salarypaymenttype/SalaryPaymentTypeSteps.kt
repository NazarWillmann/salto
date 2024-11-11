package ooo.jtc.api.dictionaries.salarypaymenttype

import io.qameta.allure.Step
import ooo.jtc.api.common.checks.Checks
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.salarypaymenttype.SalaryPaymentType
import ooo.jtc.dictionaries.salarypaymenttype.SalaryPaymentTypeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User

class SalaryPaymentTypeSteps(user: User) :
    AbstractDictionarySteps<SalaryPaymentTypeDto, SalaryPaymentTypeDto>(
        user = user,
        service = Services.SALARY,
        entity = SalaryPaymentTypeDto::class.java,
        dictionaryName = "paymentType"
    ) {

    companion object {

        @Step("Проверка предзаполненной сущности '${DictionaryNames.SALARY_PAYMENT_TYPE}'")
        fun checkDefaultEntity(actualEntity: SalaryPaymentType, expectedEntity: SalaryPaymentType) {
            Checks.checkFieldValue("код", actualEntity.code, expectedEntity.code)
            Checks.checkFieldValue("наименование", actualEntity.name, expectedEntity.name)
            Checks.checkFieldValue("код вида дохода", actualEntity.incomeTypeCode, expectedEntity.incomeTypeCode)
        }
    }
}