package ooo.jtc.ui.dictionaries.tests

import ooo.jtc.api.dictionaries.codevo.CodeVoPrepareSteps.getCodeVoDtoForCreate
import ooo.jtc.api.dictionaries.codevo.CodeVoSteps
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.dictionaries.codevo.CodeVoView
import ooo.jtc.generic.Mappers.codeVoViewMapper
import ooo.jtc.testdata.Users
import ooo.jtc.ui.application.BankApplication.codeVoFormPage
import ooo.jtc.ui.application.BankApplication.codeVoScrollerPage
import ooo.jtc.ui.common.templates.AbstractUiTest
import ooo.jtc.ui.dictionaries.UiDictionaryTestsBody

class UiCodeVoCreateTest : AbstractUiTest<CodeVoView, CodeVoView>(
        name = "Создание записи скроллера",
        params = { mapOf(PARAM_USER to Users.bankAdmin, "Объект создания" to it!!) },
        preExecution = { codeVoViewMapper.toView(getCodeVoDtoForCreate()) },
        testBody = { UiDictionaryTestsBody.createEntity(it!!, codeVoScrollerPage, codeVoFormPage) },
        postExecution = { CodeVoSteps(Users.bankAdmin).deleteByCodeAndDescription(code = it.code, description = it.description) }
    )

    class UiCodeVoDeleteTest : AbstractUiTest<List<CodeVoView>, Unit>(
        name = "Групповое действие. Удалить-Удалить",
        params = { mapOf(PARAM_USER to Users.bankAdmin, "Объект удаления" to it!!) },
        preExecution = {
            listOf(getCodeVoDtoForCreate(), getCodeVoDtoForCreate())
                .map { CodeVoSteps(Users.bankAdmin).create(it).data!! }
                .map { codeVoViewMapper.toView(it) }
        },
        testBody = { UiDictionaryTestsBody.deleteSomeEntities(it!!, codeVoScrollerPage) }
    )