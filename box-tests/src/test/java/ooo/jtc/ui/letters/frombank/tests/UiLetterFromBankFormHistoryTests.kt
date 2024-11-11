package ooo.jtc.ui.letters.frombank.tests

import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.api.letters.frombank.steps.LetterFromBankSteps
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.documents.getDescriptionByStatus
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.letters.model.LetterFromBankStatus
import ooo.jtc.uaa.User
import ooo.jtc.ui.application.BankApplication.lFBFormBasicRequisitesBank
import ooo.jtc.ui.application.ClientApplication.lFBFormBasicRequisitesClient
import ooo.jtc.ui.common.pages.ApplicationPageType
import ooo.jtc.ui.common.sections.tabs.HistoryTab.Companion.getHistoryStatusTransform
import ooo.jtc.ui.common.templates.AbstractUiTest
import ooo.jtc.ui.letters.frombank.LFBTaskIdsUiChangeHistory
import ooo.jtc.ui.pages.documents.letterfrombank.sections.LetterFromBankHistoryTab

/** Prevent code duplication. */
private fun openDocAtHistoryTab(
    it: LetterFromBankDto?,
    user: User,
    pageType: ApplicationPageType
): LetterFromBankHistoryTab {
    //TODO Sergeyev [2021.04.15]: change to openFormByParams(..., tab = HISTORY)
    val documentId = it!!.id!!
    val formPage = if (pageType.isClient()) lFBFormBasicRequisitesClient else lFBFormBasicRequisitesBank

    formPage.openFormByParams(user, documentId)
    return formPage.historyTab.openTab()
}

@LFBTaskIdsUiChangeHistory
@NormalPriority
class UiLFBFormViewHistoryTest(
    user: User,
    preExecution: () -> LetterFromBankDto,
    pageType: ApplicationPageType
) : AbstractUiTest<LetterFromBankDto, Unit>(
    name = "${DocumentNames.LETTER_FROM_BANK}. Форма просмотра. Закладка История изменений. [${pageType.uiName}]",
    preExecution = preExecution,
    params = { mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val historyTab = openDocAtHistoryTab(it = it, user = user, pageType = pageType)
        val statusMapper: (LetterFromBankStatus) -> String = getHistoryStatusTransform(pageType)
        val expStatusOrder = listOf(
            LetterFromBankStatus.DELIVERED,
            LetterFromBankStatus.SIGNED,
            LetterFromBankStatus.NEW
        ).map(statusMapper)

        historyTab.checkStatusOrder(expStatusOrder)
        historyTab.checkAllFields(pageType)
    }
)

@LFBTaskIdsUiChangeHistory
@NormalPriority
class UiLFBFormViewHistoryDetailProcessingTest(
    statusForName: String,
    user: User,
    preExecution: () -> LetterFromBankDto,
    pageType: ApplicationPageType
) : AbstractUiTest<LetterFromBankDto, Unit>(
    name = "${DocumentNames.LETTER_FROM_BANK}. Форма просмотра. Закладка История изменений. " +
            "Просмотр сведений о результатах отправки Клиенту. $statusForName. [${pageType.uiName}]",
    preExecution = preExecution,
    params = { mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val documentId = it!!.id!!
        val historyTab = openDocAtHistoryTab(it, user, pageType)
        val sentModal = historyTab.openSentModal(pageType)

        val expSentTicketDto = LetterFromBankSteps(user).getSendTicket(documentId)
            .data.getOrException("Ошибка при получении квитка об отправке")

        val expStatus = LetterFromBankStatus.values.getDescriptionByStatus(it.status!!, userType = user.userType)
        sentModal.checkFormCorrect(expSentTicketDto, expStatus)
    }
)