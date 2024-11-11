package ooo.jtc.api.dictionaries.incometype

import io.qameta.allure.Step
import ooo.jtc.api.common.checks.Checks
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.incometype.IncomeType
import ooo.jtc.dictionaries.incometype.IncomeTypeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.uaa.User

class IncomeTypeSteps(user: User) :
    AbstractDictionarySteps<IncomeTypeDto, IncomeTypeDto>(
        user = user,
        entity = IncomeTypeDto::class.java,
        dictionaryName = "incomeType"
    ) {

    companion object {

        @Step("Проверка предзаполненной сущности '${DictionaryNames.INCOME_TYPE}'")
        fun checkDefaultEntity(actualEntity: IncomeType, expectedEntity: IncomeType) {
            Checks.checkFieldValue("код", actualEntity.code, expectedEntity.code)
            Checks.checkFieldValue("наименование ", actualEntity.name, expectedEntity.name)
            Checks.checkFieldValue("описание", actualEntity.description, expectedEntity.description)
        }
    }
}