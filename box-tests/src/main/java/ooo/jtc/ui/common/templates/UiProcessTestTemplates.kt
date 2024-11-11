package ooo.jtc.ui.common.templates

import com.codeborne.selenide.Condition.exist
import ooo.jtc.api.common.steps.AbstractDocumentSteps
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.elements.scroller.DocumentScroller
import ooo.jtc.core.elements.scroller.DocumentScrollerRow
import ooo.jtc.core.elements.scroller.ScrollerCategory
import ooo.jtc.core.kexensions.checkIsBankUser
import ooo.jtc.documents.IDocumentStatus
import ooo.jtc.extensions.DOTS_DATE_FORMAT
import ooo.jtc.extensions.string
import ooo.jtc.interfaces.IDocument
import ooo.jtc.uaa.User
import ooo.jtc.ui.UiHelper
import ooo.jtc.ui.common.actions.UiActionPlace
import ooo.jtc.ui.common.actions.UiCommonChecks
import ooo.jtc.ui.common.pages.DocumentPage
import ooo.jtc.ui.common.pages.DocumentScrollerPage
import ooo.jtc.ui.common.sections.CommonSections.modalProcessDocument
import ooo.jtc.ui.common.sections.modals.ModalProcessDocument

private const val PROCESS_ACTION = "Обработать"

private fun <T : IDocument> processDocumentSuccessfullyWithMsg(document: T, docUiStatus: String, resultMsg: String) {
    val docNumber = document.documentNumber
    val docDate = document.documentDate.string(DOTS_DATE_FORMAT)
    modalProcessDocument.checkModalOpened(docNumber, docDate, docUiStatus)

    modalProcessDocument.processResult.value = resultMsg
    modalProcessDocument.processBtn.click()

    UiCommonChecks.checkPushSuccessMessage()
    UiCommonChecks.checkPushMessage("Документ №$docNumber от $docDate г. обработан")

    modalProcessDocument.shouldNot(exist)
}

open class UiScrollerBankProcessTestTemplate<T : IDocument,
        S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>, C : ScrollerCategory>(
    override var name: String,
    override val preExecution: () -> T,
    val scrollerPage: S,
    val scrollerCategory: C,
    val bankUser: User,
    val status: IDocumentStatus<T>,
    val action: String = PROCESS_ACTION,
    val actionPlace: UiActionPlace,
    val beSteps: AbstractDocumentSteps<T, *>,
    val expBeStatuses: List<String>
) : AbstractTest<T, Unit>(
    name = name,
    preExecution = preExecution
) {
    override fun params(): Map<String, Any> = mapOf(PARAM_USER to bankUser, PARAM_OBJECT_TYPE to preconditionResult!!)

    override fun execution(preconditionResult: T?) {
        bankUser.checkIsBankUser()
        val dto = preconditionResult!!

        scrollerPage.openScrollerBy(bankUser)
        scrollerPage.openTab(scrollerCategory)

        val row = scrollerPage.findDocumentRowByNumber(dto.documentNumber)
        actionPlace.makeAction(scrollerPage, row, action)

        processDocumentSuccessfullyWithMsg(
            document = dto,
            docUiStatus = status.descriptionBank,
            resultMsg = "|${UiHelper.uiCurrentDate}| FE scroller AT-process (success)"
        )

        UiCommonChecks.checkDocSystemStatusThroughBE(beSteps, dto.id!!, expBeStatuses)
    }
}

open class UiFormBankProcessTestTemplate<T: IDocument, F : DocumentPage>(
    override var name: String,
    override val preExecution: () -> T,
    val bankUser: User,
    val status: IDocumentStatus<T>,
    val formPage: F,
    val action: String = PROCESS_ACTION,
    val beSteps: AbstractDocumentSteps<T, *>,
    val expBeStatuses: List<String>
) : AbstractTest<T, Unit>(
    name = name,
    preExecution = preExecution
) {
    override fun params(): Map<String, Any> = mapOf(PARAM_USER to bankUser, PARAM_OBJECT_TYPE to preconditionResult!!)

    override fun execution(preconditionResult: T?) {
        bankUser.checkIsBankUser()
        val dto = preconditionResult!!

        formPage.openFormByParams(bankUser, dto.id!!)
        formPage.makeAction(PROCESS_ACTION)

        processDocumentSuccessfullyWithMsg(
            document = dto,
            docUiStatus = status.descriptionBank,
            resultMsg = "|${UiHelper.uiCurrentDate}| FE form AT-process (success)"
        )

        UiCommonChecks.checkDocSystemStatusThroughBE(beSteps, dto.id!!, expBeStatuses)
    }
}

open class UiBankProcessControlsTestTemplate<T: IDocument, F : DocumentPage>(
    override var name: String,
    override val preExecution: () -> T,
    val bankUser: User,
    val formPage: F,
    val action: String = PROCESS_ACTION,
    val actionsOnProcessModalFunc: (ModalProcessDocument) -> Unit
) : AbstractTest<T, Unit>(
    name = name,
    preExecution = preExecution
) {
    override fun params(): Map<String, Any> = mapOf(PARAM_USER to bankUser, PARAM_OBJECT_TYPE to preconditionResult!!)

    override fun execution(preconditionResult: T?) {
        bankUser.checkIsBankUser()
        val dto = preconditionResult!!
        val docNumber = dto.documentNumber
        val docDate = dto.documentDate.string(DOTS_DATE_FORMAT)

        formPage.openFormByParams(bankUser, dto.id!!)
        formPage.makeAction(PROCESS_ACTION)
        modalProcessDocument.checkModalOpened(docNumber, docDate)

        actionsOnProcessModalFunc.invoke(modalProcessDocument)
    }
}