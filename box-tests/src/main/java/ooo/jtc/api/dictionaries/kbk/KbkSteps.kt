package ooo.jtc.api.dictionaries.kbk

import io.qameta.allure.Step
import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.kbk.KbkDto
import ooo.jtc.generic.pageparams.Filter
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeFilterParams
import ooo.jtc.testdata.dictionaries.kbk.KbkFilterParams
import ooo.jtc.uaa.User

class KbkSteps(user: User) :
    AbstractDictionarySteps<KbkDto, KbkDto>(
        user = user,
        entity = KbkDto::class.java,
        dictionaryName = "kbk"
    ) {

    @Step("Удалить {this.entityName} по коду ({code}) и описанию ({description})")
    fun deleteByCodeAndDescription(
        code: String,
        description: String
    ) {
        val filtterData =
            IFilterParams.and({ KbkFilterParams.DESCRIPTION.eq(description) }, { KbkFilterParams.CODE.eq(code) })
        val page = getPage(getPageRequest = GetPageRequest(params = Params(filter = Filter(data = filtterData)))).page
        page?.forEach { delete(id = it.id!!) }

    }

}