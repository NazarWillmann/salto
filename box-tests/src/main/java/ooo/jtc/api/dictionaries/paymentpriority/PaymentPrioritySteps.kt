package ooo.jtc.api.dictionaries.paymentpriority

import io.qameta.allure.Step
import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.paymentpriority.PaymentPriorityDto
import ooo.jtc.generic.pageparams.Filter
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.dictionaries.budgetpayerstatus.BudgetPayerStatusFilterParams
import ooo.jtc.testdata.dictionaries.paymentpriority.PaymentPriorityFilterParams
import ooo.jtc.uaa.User

class PaymentPrioritySteps(user: User) :
    AbstractDictionarySteps<PaymentPriorityDto, PaymentPriorityDto>(
        user = user,
        service = Services.RKO_DICTIONARY,
        entity = PaymentPriorityDto::class.java,
        dictionaryName = "paymentPriority"
    ) {

    @Step("Удалить {this.entityName} по коду ({code}) и описанию ({description})")
    fun deleteByCodeAndDescription(
        code: String,
        description: String
    ) {
        val filterData =
            IFilterParams.and({ PaymentPriorityFilterParams.DESCRIPTION.eq(description) }, { PaymentPriorityFilterParams.CODE.eq(code) })
        val page = getPage(getPageRequest = GetPageRequest(params = Params(filter = Filter(data = filterData)))).page
        page?.forEach { delete(id = it.id!!) }

    }
}