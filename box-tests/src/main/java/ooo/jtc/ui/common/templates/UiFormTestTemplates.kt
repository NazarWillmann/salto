package ooo.jtc.ui.common.templates

import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.interfaces.IDocumentView
import ooo.jtc.uaa.User
import ooo.jtc.ui.common.actions.UiCommonChecks
import ooo.jtc.ui.common.pages.DocumentPage


open class UiFormCopyTestTemplate<T : IDocumentView, Form : DocumentPage>(
    var entityName: String,
    val user: User,
    val formPage: Form,
    override val preExecution: () -> T,
    val expHeaderText: String,
    val action: String = "Повторить"
) : AbstractTest<T, Unit>(
    name = "$entityName. Копирование документа из формы. [${user.userType}]",
    preExecution = preExecution
) {
    @Suppress("UNCHECKED_CAST")
    override fun execution(preconditionResult: T?) {
        val view = preconditionResult!!
        formPage.openFormByParams(user, view.id!!)

        formPage.makeAction(action)
        UiCommonChecks.checkDocumentCopiedSuccessfully(formPage, view, expHeaderText)
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to preconditionResult!!)
    }
}