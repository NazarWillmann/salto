package ooo.jtc.api.dictionaries.budgetreasoncode

import io.qameta.allure.Step
import ooo.jtc.api.common.checks.Checks
import ooo.jtc.api.common.filter.IFilterParams.Companion.and
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.budgetreasoncode.BudgetReasonCode
import ooo.jtc.dictionaries.budgetreasoncode.BudgetReasonCodeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.Filter
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeFilterParams
import ooo.jtc.uaa.User

class BudgetReasonCodeSteps(user: User) :
    AbstractDictionarySteps<BudgetReasonCodeDto, BudgetReasonCodeDto>(
        user = user,
        service = Services.RKO_DICTIONARY,
        entity = BudgetReasonCodeDto::class.java,
        dictionaryName = "budgetReasonCode"
    ) {

    @Step("Удалить {this.entityName} по коду ({code}) и описанию ({description})")
    fun deleteByCodeAndDescription(
        code: String,
        description: String
    ) {
        val filterData = and({ BudgetReasonCodeFilterParams.DESCRIPTION.eq(description) }, { BudgetReasonCodeFilterParams.CODE.eq(code) })
        val page = getPage(getPageRequest = GetPageRequest(params = Params(filter = Filter(data = filterData)))).page
        page?.forEach { delete(id = it.id!!) }
    }

    companion object {

        @Step("Проверка предзаполненной сущности '${DictionaryNames.BUDGET_REASON_CODE}'")
        fun checkDefaultEntity(actualEntity: BudgetReasonCode, expectedEntity: BudgetReasonCode) {
            Checks.checkFieldValue("показатель основания платежа", actualEntity.code, expectedEntity.code)
            Checks.checkFieldValue("описание показателя основания платежа", actualEntity.description, expectedEntity.description)
            Checks.checkFieldValue("тип платежа в бюджет РФ", actualEntity.payType, expectedEntity.payType)
            Checks.checkFieldValue("подсказка к полю 108", actualEntity.hint108, expectedEntity.hint108)
            Checks.checkFieldValue("подсказка к полю 109", actualEntity.hint109, expectedEntity.hint109)
        }
    }
}