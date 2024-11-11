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
import ooo.jtc.ui.common.sections.CommonSections.modalRecallDocument
import ooo.jtc.ui.common.sections.modals.ModalRecallDocument

private const val RECALL_ACTION = "Отозвать"

/**
 * Make necessary UI user actions on UI recall modal.
 * Recall modal should be opened (visible) when calling this method.
 */
private fun <T : IDocument> recallDocumentSuccessfullyWithMsg(document: T, docUiStatus: String, recallMsg: String) {
    val docNumber = document.documentNumber
    val docDate = document.documentDate.string(DOTS_DATE_FORMAT)
    modalRecallDocument.checkModalOpened(docNumber, docDate, docUiStatus)

    modalRecallDocument.recallReason.value = recallMsg
    modalRecallDocument.recallBtn.click()

    UiCommonChecks.checkPushSuccessMessage()
    UiCommonChecks.checkPushMessage("Документ \"${document.getEntityName()}\" (№$docNumber от $docDate г.) отозван")

    modalRecallDocument.shouldNot(exist)
}

open class UiScrollerBankRecallTestTemplate<T : IDocument,
        S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>, C : ScrollerCategory>(
    override var name: String,
    override val preExecution: () -> T,
    val scrollerPage: S,
    val scrollerCategory: C,
    val bankUser: User,
    val status: IDocumentStatus<T>,
    val action: String = RECALL_ACTION,
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

        recallDocumentSuccessfullyWithMsg(
            document = dto,
            docUiStatus = status.descriptionBank,
            recallMsg = "|${UiHelper.uiCurrentDate}| FE scroller AT-recall (success)"
        )

        UiCommonChecks.checkDocSystemStatusThroughBE(beSteps, dto.id!!, expBeStatuses)
    }
}

open class UiFormBankRecallTestTemplate<T: IDocument, F : DocumentPage>(
    override var name: String,
    override val preExecution: () -> T,
    val bankUser: User,
    val status: IDocumentStatus<T>,
    val formPage: F,
    val action: String = RECALL_ACTION,
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
        formPage.makeAction(RECALL_ACTION)

        recallDocumentSuccessfullyWithMsg(
            document = dto,
            docUiStatus = status.descriptionBank,
            recallMsg = "|${UiHelper.uiCurrentDate}| FE form AT-recall (success)"
        )

        UiCommonChecks.checkDocSystemStatusThroughBE(beSteps, dto.id!!, expBeStatuses)
    }
}

/**
 * @param actionsOnRecallModalFunc - user actions on recall modal (after it's opened).
 * E.g., if you want to recall document and check that modal is closed:
 *
 * `actionsOnRecallModalFunc = { recallModal ->
 *     recallModal.recallReason.value = "Changed my mind"
 *     recallModal.recallBtn.click()
 *     recallModal.shouldNot(exist)
 * }`
 */
open class UiBankRecallControlsTestTemplate<T: IDocument, F : DocumentPage>(
    override var name: String,
    override val preExecution: () -> T,
    val bankUser: User,
    val formPage: F,
    val action: String = RECALL_ACTION,
    val actionsOnRecallModalFunc: (ModalRecallDocument) -> Unit
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
        formPage.makeAction(RECALL_ACTION)
        modalRecallDocument.checkModalOpened(docNumber, docDate)

        actionsOnRecallModalFunc.invoke(modalRecallDocument)
    }
}
