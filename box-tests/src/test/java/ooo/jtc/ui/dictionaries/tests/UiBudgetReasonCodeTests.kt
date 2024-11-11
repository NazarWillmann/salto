package ooo.jtc.ui.dictionaries.tests

import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodePrepareSteps.getBudgetReasonCodeDtoForCreate
import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodeSteps
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.dictionaries.budgetreasoncode.BudgetReasonCodeView
import ooo.jtc.generic.Mappers.budgetReasonCodeViewMapper
import ooo.jtc.testdata.Users
import ooo.jtc.ui.application.BankApplication.budgetReasonCodeFormPage
import ooo.jtc.ui.application.BankApplication.budgetReasonCodeScrollerPage
import ooo.jtc.ui.common.templates.AbstractUiTest
import ooo.jtc.ui.dictionaries.UiDictionaryTestsBody

class UiBudgetReasonCodeCreateTest : AbstractUiTest<BudgetReasonCodeView, BudgetReasonCodeView>(
        name = "Создание записи скроллера",
        params = { mapOf(PARAM_USER to Users.bankAdmin, "Объект создания" to it!!) },
        preExecution = { budgetReasonCodeViewMapper.toView(getBudgetReasonCodeDtoForCreate()) },
        testBody = { UiDictionaryTestsBody.createEntity(it!!, budgetReasonCodeScrollerPage, budgetReasonCodeFormPage) },
        postExecution = { BudgetReasonCodeSteps(Users.bankAdmin).deleteByCodeAndDescription(code = it.code, description = it.description) }
    )

    class UiBudgetReasonCodeDeleteTest : AbstractUiTest<List<BudgetReasonCodeView>, Unit>(
        name = "Групповое действие. Удалить-Удалить",
        params = { mapOf(PARAM_USER to Users.bankAdmin, "Объект удаления" to it!!) },
        preExecution = {

            listOf(getBudgetReasonCodeDtoForCreate(), getBudgetReasonCodeDtoForCreate())
                .map { BudgetReasonCodeSteps(Users.bankAdmin).create(it).data!! }
                .map { budgetReasonCodeViewMapper.toView(it) }

        },
        testBody = { UiDictionaryTestsBody.deleteSomeEntities(it!!, budgetReasonCodeScrollerPage) }
    )