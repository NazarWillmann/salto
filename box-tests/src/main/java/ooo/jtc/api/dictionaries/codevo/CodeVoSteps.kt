package ooo.jtc.api.dictionaries.codevo

import io.qameta.allure.Step
import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.codevo.CodeVoDto
import ooo.jtc.generic.pageparams.Filter
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeFilterParams
import ooo.jtc.testdata.dictionaries.codevo.CodeVoFilterParams
import ooo.jtc.uaa.User

class CodeVoSteps(user: User) :
    AbstractDictionarySteps<CodeVoDto, CodeVoDto>(
        user = user,
        entity = CodeVoDto::class.java,
        dictionaryName = "codeVo"
    ) {

    @Step("Удалить {this.entityName} по коду ({code}) и описанию ({description})")
    fun deleteByCodeAndDescription(
        code: String,
        description: String
    ) {
        val filterData =
            IFilterParams.and({ CodeVoFilterParams.DESCRIPTION.eq(description) }, { CodeVoFilterParams.CODE.eq(code) })
        val page = getPage(getPageRequest = GetPageRequest(params = Params(filter = Filter(data = filterData)))).page
        page?.forEach { delete(id = it.id!!) }

    }
}