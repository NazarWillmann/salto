package ooo.jtc.api.dictionaries.budgetpayerstatus

import io.qameta.allure.Step
import ooo.jtc.api.common.checks.Checks
import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.budgetpayerstatus.BudgetPayerStatus
import ooo.jtc.dictionaries.budgetpayerstatus.BudgetPayerStatusDto
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.Filter
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.dictionaries.budgetpayerstatus.BudgetPayerStatusFilterParams
import ooo.jtc.uaa.User

class BudgetPayerStatusSteps(user: User) :
    AbstractDictionarySteps<BudgetPayerStatusDto, BudgetPayerStatusDto>(
        user = user,
        service = Services.RKO_DICTIONARY,
        entity = BudgetPayerStatusDto::class.java,
        dictionaryName = "budgetPayerStatus"
    ) {

    companion object {

        @Step("Проверка предзаполненной сущности '${DictionaryNames.BUDGET_PAYER_STATUS}'")
        fun checkDefaultEntity(actualEntity: BudgetPayerStatus, expectedEntity: BudgetPayerStatus) {
            Checks.checkFieldValue("код", actualEntity.code, expectedEntity.code)
            Checks.checkFieldValue("описание", actualEntity.description, expectedEntity.description)
        }
    }

    @Step("Удалить {this.entityName} по коду ({code}) и описанию ({description})")
    fun deleteByCodeAndDescription(
        code: String,
        description: String
    ) {
        val filterData = IFilterParams.and(
            { BudgetPayerStatusFilterParams.DESCRIPTION.eq(description) },
            { BudgetPayerStatusFilterParams.CODE.eq(code) }
        )
        val page = getPage(getPageRequest = GetPageRequest(params = Params(filter = Filter(data = filterData))))
            .page.getOrException()
        page.forEach { delete(id = it.id!!) }
    }
}