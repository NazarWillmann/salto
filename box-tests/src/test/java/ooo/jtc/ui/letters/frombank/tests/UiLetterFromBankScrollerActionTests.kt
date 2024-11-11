package ooo.jtc.ui.letters.frombank.tests

import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.api.letters.frombank.LetterFromBankPreExecutions
import ooo.jtc.core.TestTemplateConstants.PARAM_OBJECT
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.LetterFromBankView
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.uaa.User
import ooo.jtc.ui.UiHelper.toUi
import ooo.jtc.ui.application.ClientApplication
import ooo.jtc.ui.common.actions.UiActionPlace
import ooo.jtc.ui.common.templates.UiScrollerAvailableActionsTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerViewTestTemplate
import ooo.jtc.ui.letters.frombank.LFBTaskIdsUiScrollerActions
import ooo.jtc.ui.pages.documents.letterfrombank.form.LetterFromBankFormBasicRequisitesTab
import ooo.jtc.ui.pages.documents.letterfrombank.scroller.LetterFromBankScrollerCategory
import ooo.jtc.ui.pages.documents.letterfrombank.scroller.LetterFromBankScrollerPage

@LFBTaskIdsUiScrollerActions
@HighPriority
open class UiLFBScrollerAvailableActionsClientTest(
    user: User
) : UiScrollerAvailableActionsTestTemplate<LetterFromBankDto, LetterFromBankScrollerPage, LetterFromBankScrollerCategory>(
    user = user,
    scrollerPage = ClientApplication.lFBScrollerPageClient,
    entityName = DocumentNames.LETTER_FROM_BANK,
    expActions = listOf("Просмотреть", "Печатать", "Экспортировать", "Ответить"),
    preExecution = { LetterFromBankPreExecutions.LFBPreExecutionDelivered(user) },
    scrollerCategory = null,
)

@LFBTaskIdsUiScrollerActions
@HighPriority
open class UiLFBScrollerViewTest(
    user: User,
    actionPlace: UiActionPlace = UiActionPlace.BY_ROW
) : UiScrollerViewTestTemplate<LetterFromBankView, LetterFromBankScrollerPage, LetterFromBankScrollerCategory, LetterFromBankFormBasicRequisitesTab>(
    user = user,
    scrollerPage = ClientApplication.lFBScrollerPageClient,
    entityName = DocumentNames.LETTER_FROM_BANK,
    formPage = ClientApplication.lFBFormBasicRequisitesClient,
    expHeaderText = "Письмо из банка",
    actionPlace = actionPlace,
    preExecution = { LetterFromBankPreExecutions.LFBPreExecutionDelivered(user).toView() },
    scrollerCategory = null,
)

@LFBTaskIdsUiScrollerActions
@HighPriority
class UiLFBScrollerAnswerForLFBClientTest(val clientUser: User) : AbstractTest<LetterFromBankDto, Unit>(
    name = "${DocumentNames.LETTER_FROM_BANK}. Ответ на письмо из банка. [Клиент]",
    preExecution = { LetterFromBankPreExecutions.LFBPreExecutionDelivered(clientUser) }
) {
    override fun execution(preconditionResult: LetterFromBankDto?) {
        val dto = preconditionResult!!
        val customerId = dto.customerId!!
        val action = "Ответить"
        val scrollerPage = ClientApplication.lFBScrollerPageClient
        val lTBAnswerFormPage = ClientApplication.lTBFormBasicRequisitesClient

        scrollerPage.openScrollerBy(clientUser, customerId)
        scrollerPage.findDocumentRowByNumber(dto.documentNumber).makeActionByMoreMenu(action)
        lTBAnswerFormPage.checkAnswerToLfb(
            user = clientUser,
            customerId = customerId,
            lfbDocNumber = dto.documentNumber,
            lfbDocDate = dto.documentDate.toUi(),
            lfbDocTheme = dto.docTheme!!,
            lfbDocText = dto.docText!!
        )
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to clientUser, PARAM_OBJECT to preconditionResult!!)
    }
}
