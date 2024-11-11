package ooo.jtc.ui.letters.tobank.tests

import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.api.letters.tobank.steps.LetterToBankSteps
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.documents.getDescriptionByStatus
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.uaa.User
import ooo.jtc.ui.application.BankApplication.lTBFormBasicRequisitesBank
import ooo.jtc.ui.application.ClientApplication.lTBFormBasicRequisitesClient
import ooo.jtc.ui.common.pages.ApplicationPageType
import ooo.jtc.ui.common.sections.tabs.HistoryTab
import ooo.jtc.ui.common.templates.AbstractUiTest
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiFormTabs
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankHistoryTab

/** Prevent code duplication. */
private fun openDocAtHistoryTab(
    it: LetterToBankDto?,
    user: User,
    pageType: ApplicationPageType
): LetterToBankHistoryTab {
    //TODO Sergeyev [2021.04.15]: change to openFormByParams(..., tab = HISTORY)
    val documentId = it!!.id!!
    val formPage = if (pageType.isClient()) lTBFormBasicRequisitesClient else lTBFormBasicRequisitesBank

    formPage.openFormByParams(user, documentId)
    return formPage.historyTab.openTab()
}

@LTBTaskIdsUiFormTabs
@NormalPriority
class UiLTBFormViewHistoryTest(
    user: User,
    preExecution: () -> LetterToBankDto,
    pageType: ApplicationPageType
) : AbstractUiTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Форма просмотра. Закладка История изменений. [${pageType.uiName}]",
    preExecution = preExecution,
    params = { mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val historyTab = openDocAtHistoryTab(it = it, user = user, pageType = pageType)
        val statusMapper: (LetterToBankStatus) -> String = HistoryTab.Companion.getHistoryStatusTransform(pageType)
        val expStatusOrder = listOf(
            LetterToBankStatus.RECEIVED,
            LetterToBankStatus.DELIVERED,
            LetterToBankStatus.DELIVERED,
            LetterToBankStatus.SIGNED,
            LetterToBankStatus.NEW
        ).map(statusMapper)

        historyTab.checkStatusOrder(expStatusOrder)
        historyTab.checkAllFields(pageType)
    }
)

@LTBTaskIdsUiFormTabs
@NormalPriority
class UiLTBFormViewHistoryDetailProcessingTest(
    statusForName: String,
    user: User,
    preExecution: () -> LetterToBankDto,
    pageType: ApplicationPageType
) : AbstractUiTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Форма просмотра. Закладка История изменений. " +
            "Просмотр сведений о результатах обработки в Банке. $statusForName. [${pageType.uiName}]",
    preExecution = preExecution,
    params = { mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val documentId = it!!.id!!
        val historyTab = openDocAtHistoryTab(it, user, pageType)
        val processingModal = historyTab.openProcessingModal(pageType)

        val expExecutionTicketDto =
            LetterToBankSteps(user).getExecutionTicket(documentId).data.getOrException("Ошибка при получении квитка об исполнении")

        val expStatus = LetterToBankStatus.values.getDescriptionByStatus(it.status!!, userType = user.userType)
        processingModal.checkFormCorrect(expExecutionTicketDto, expStatus)
    }
)

@LTBTaskIdsUiFormTabs
@NormalPriority
class UiLTBFormViewHistoryDetailReceptionClientTest(
    statusForName: String,
    user: User,
    preExecution: () -> LetterToBankDto,
    pageType: ApplicationPageType
) : AbstractUiTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Форма просмотра. Закладка История изменений. " +
            "Просмотр сведений о результатах обработки в Банке. $statusForName. [${pageType.uiName}]",
    preExecution = preExecution,
    params = { mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val documentId = it!!.id!!
        val historyTab = openDocAtHistoryTab(it, user, pageType)
        val receptionModal = historyTab.openReceptionModal(pageType)

        val expReceiveTicketDto =
            LetterToBankSteps(user).getReceiveTicket(documentId).data.getOrException("Ошибка при получении квитка об исполнении")

        val expStatus = LetterToBankStatus.values.getDescriptionByStatus(it.status!!, userType = user.userType)
        receptionModal.checkFormCorrect(expReceiveTicketDto, expStatus)
    }
)