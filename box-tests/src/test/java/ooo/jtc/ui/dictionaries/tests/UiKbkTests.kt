package ooo.jtc.ui.dictionaries.tests

import ooo.jtc.api.dictionaries.kbk.KbkPrepareSteps.getKbkDtoForCreate
import ooo.jtc.api.dictionaries.kbk.KbkSteps
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.dictionaries.kbk.KbkView
import ooo.jtc.generic.Mappers.kbkViewMapper
import ooo.jtc.testdata.Users
import ooo.jtc.ui.application.BankApplication.kbkFormPage
import ooo.jtc.ui.application.BankApplication.kbkScrollerPage
import ooo.jtc.ui.common.templates.AbstractUiTest
import ooo.jtc.ui.dictionaries.UiDictionaryTestsBody

class UiKbkCreateTest : AbstractUiTest<KbkView, KbkView>(
    name = "Создание записи скроллера",
    params = { mapOf(PARAM_USER to Users.bankAdmin, "Объект создания" to it!!) },
    preExecution = { kbkViewMapper.toView(getKbkDtoForCreate()) },
    testBody = { UiDictionaryTestsBody.createEntity(it!!, kbkScrollerPage, kbkFormPage) },
    postExecution = { KbkSteps(Users.bankAdmin).deleteByCodeAndDescription(code = it.code, description = it.description) }
)

class UiKbkDeleteTest : AbstractUiTest<List<KbkView>, Unit>(
    name = "Групповое действие. Удалить-Удалить",
    params = { mapOf(PARAM_USER to Users.bankAdmin, "Объект удаления" to it!!) },
    preExecution = {
        listOf(getKbkDtoForCreate(), getKbkDtoForCreate())
            .map { KbkSteps(Users.bankAdmin).create(it).data!! }
            .map { kbkViewMapper.toView(it) }
    },
    testBody = { UiDictionaryTestsBody.deleteSomeEntities(it!!, kbkScrollerPage) }
)