package ooo.jtc.ui.dictionaries.tests

import ooo.jtc.api.dictionaries.stmntoperationtype.StatementOperationTypePrepareSteps.getStatementOperationTypeDtoForCreate
import ooo.jtc.api.dictionaries.stmntoperationtype.StatementOperationTypeSteps
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.dictionaries.stmntoperationtype.StatementOperationTypeView
import ooo.jtc.generic.Mappers.statementOperationTypeViewMapper
import ooo.jtc.testdata.Users
import ooo.jtc.ui.application.BankApplication.statementOperationTypeFormPage
import ooo.jtc.ui.application.BankApplication.statementOperationTypeScrollerPage
import ooo.jtc.ui.common.templates.AbstractUiTest
import ooo.jtc.ui.dictionaries.UiDictionaryTestsBody

class UiStatementOperationTypeCreateTest : AbstractUiTest<StatementOperationTypeView, StatementOperationTypeView>(
        name = "Создание записи",
        params = { mapOf(PARAM_USER to Users.bankAdmin, "Объект создания" to it!!) },
        preExecution = { statementOperationTypeViewMapper.toView(getStatementOperationTypeDtoForCreate()) },
        testBody = { UiDictionaryTestsBody.createEntity(it!!, statementOperationTypeScrollerPage, statementOperationTypeFormPage) },
        postExecution = { StatementOperationTypeSteps(Users.bankAdmin).deleteSoTypeByDescription(description = it.description) }
    )

    class UiStatementOperationTypeDeleteTest : AbstractUiTest<List<StatementOperationTypeView>, Unit>(
        name = "Групповое действие. Удалить-Удалить",
        params = { mapOf(PARAM_USER to Users.bankAdmin, "Объект удаления" to it!!) },
        preExecution = {
            listOf(getStatementOperationTypeDtoForCreate(), getStatementOperationTypeDtoForCreate())
                .map { StatementOperationTypeSteps(Users.bankAdmin).create(it).data!! }
                .map { statementOperationTypeViewMapper.toView(it) }
        },
        testBody = { UiDictionaryTestsBody.deleteSomeEntities(it!!, statementOperationTypeScrollerPage) }
    )