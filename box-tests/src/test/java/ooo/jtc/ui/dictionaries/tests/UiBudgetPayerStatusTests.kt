package ooo.jtc.ui.dictionaries.tests

import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusPrepareSteps.getBudgetPayerStatusDtoForCreate
import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusSteps
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.dictionaries.budgetpayerstatus.BudgetPayerStatusView
import ooo.jtc.generic.Mappers.budgetPayerStatusViewMapper
import ooo.jtc.testdata.Users
import ooo.jtc.ui.application.BankApplication.budgetPayerStatusFormPage
import ooo.jtc.ui.application.BankApplication.budgetPayerStatusScrollerPage
import ooo.jtc.ui.common.templates.AbstractUiTest
import ooo.jtc.ui.dictionaries.UiDictionaryTestsBody

class UiBudgetPayerStatusCreateTest : AbstractUiTest<BudgetPayerStatusView, BudgetPayerStatusView>(
        name = "Создание записи скроллера",
        params = { mapOf(PARAM_USER to Users.bankAdmin, "Объект создания" to it!!) },
        preExecution = { budgetPayerStatusViewMapper.toView(getBudgetPayerStatusDtoForCreate()) },
        testBody = { UiDictionaryTestsBody.createEntity(it!!, budgetPayerStatusScrollerPage, budgetPayerStatusFormPage) },
        postExecution = {
            BudgetPayerStatusSteps(Users.bankAdmin).deleteByCodeAndDescription(
                code = it.code,
                description = it.description
            )
        }
    )

    class UiBudgetPayerStatusDeleteTest : AbstractUiTest<List<BudgetPayerStatusView>, Unit>(
        name = "Групповое действие. Удалить-Удалить",
        params = { mapOf(PARAM_USER to Users.bankAdmin, "Объект удаления" to it!!) },
        preExecution = {
            listOf(getBudgetPayerStatusDtoForCreate(), getBudgetPayerStatusDtoForCreate())
                .map { BudgetPayerStatusSteps(Users.bankAdmin).create(it).data!! }
                .map { budgetPayerStatusViewMapper.toView(it) }
        },
        testBody = { UiDictionaryTestsBody.deleteSomeEntities(it!!, budgetPayerStatusScrollerPage) }
    )