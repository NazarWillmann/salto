package ooo.jtc.ui.letters.tobank.tests

import com.codeborne.selenide.Condition.visible
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBPreExecutionDraft
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBPreExecutionNew
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBPreExecutionReceived
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBPreExecutionSigned
import ooo.jtc.api.letters.tobank.steps.LetterToBankSteps
import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.container.shouldNot
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankStatus.NEW
import ooo.jtc.letters.model.LetterToBankStatus.PARTLY_SIGNED
import ooo.jtc.uaa.User
import ooo.jtc.ui.application.BankApplication
import ooo.jtc.ui.application.ClientApplication
import ooo.jtc.ui.common.actions.UiCommonChecks
import ooo.jtc.ui.common.sections.CommonSections.modalUnSignDocument
import ooo.jtc.ui.common.templates.AbstractUiTest
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiFormTabs
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiUnSign
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankSignatureTab

/** Prevent code duplication. */
private fun openDocAtSignatureTabClient(
    it: LetterToBankDto?,
    clientUser: User
): LetterToBankSignatureTab {
    //TODO Sergeyev [2021.04.15]: change to openFormByParams(..., tab = SIGNATURES)
    val documentId = it!!.id!!
    val formPage = ClientApplication.lTBFormBasicRequisitesClient
    formPage.openFormByParams(clientUser, documentId)
    return formPage.signaturesTab.openTab()
}


@LTBTaskIdsUiFormTabs
@NormalPriority
class UiLTBFormViewSignatureStatusDraftTest(clientUser: User) : AbstractUiTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Форма просмотра. Закладка Подписи. Информация об отсутствии подписей. Draft. [Клиент]",
    preExecution = { LTBPreExecutionDraft.invoke(clientUser) },
    params = { mapOf(PARAM_USER to clientUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val signaturesTab = openDocAtSignatureTabClient(it, clientUser)
        signaturesTab.checkMessageForDraft()
    }
)

@LTBTaskIdsUiFormTabs
@NormalPriority
class UiLTBFormViewSignatureStatusNewTest(clientUser: User) : AbstractUiTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Форма просмотра. Закладка Подписи. Информация об отсутствии подписей. New. [Клиент]",
    preExecution = { LTBPreExecutionNew.invoke(clientUser) },
    params = { mapOf(PARAM_USER to clientUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val signaturesTab = openDocAtSignatureTabClient(it, clientUser)
        signaturesTab.checkMessageForNew()
    }
)

@LTBTaskIdsUiFormTabs
@NormalPriority
class UiLTBFormViewSignatureStatusReceivedClientTest(clientUser: User) : AbstractUiTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Форма просмотра. Закладка Подписи. Отображение полей, содержащих сведения о подписи. Delivered+. СМС. [Клиент]",
    preExecution = { LTBPreExecutionReceived.invoke(clientUser) },
    params = { mapOf(PARAM_USER to clientUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val signaturesTab = openDocAtSignatureTabClient(it, clientUser)
        signaturesTab.checkInfoForDeliveredPlus()
    }
)

@LTBTaskIdsUiFormTabs
@NormalPriority
class UiLTBFormViewSignatureStatusReceivedBankTest(clientUser: User, bankUser: User) : AbstractUiTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Форма просмотра. Закладка Подписи. Отображение полей, содержащих сведения о подписи. Delivered+. СМС. [Банк>]",
    preExecution = { LTBPreExecutionReceived.invoke(clientUser) },
    params = { mapOf(PARAM_USER to clientUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val documentId = it!!.id!!
        val formPage = BankApplication.lTBFormBasicRequisitesBank
        formPage.openFormByParams(bankUser, documentId)

        val signaturesTab = formPage.signaturesTab.openTab()
        signaturesTab.checkInfoForDeliveredPlus()
    }
)

@LTBTaskIdsUiFormTabs
@NormalPriority
class UiLTBFormViewSignatureStatusSignedTest(clientUser: User) : AbstractUiTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Форма просмотра. Закладка Подписи. Отображение полей, содержащих сведения о подписи. " +
            "PartlySigned/ Singed+. СМС. [Клиент]",
    preExecution = { LTBPreExecutionSigned.invoke(clientUser) },
    params = { mapOf(PARAM_USER to clientUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val signaturesTab = openDocAtSignatureTabClient(it, clientUser)
        signaturesTab.checkInfoForSigned()
    }
)

@LTBTaskIdsUiUnSign
@HighPriority
class UiLTBSignatureTabUnSignOwnCancelTest(clientUser: User) : AbstractUiTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Закладка Подписи. Снятие своей подписи. Отмена действия.",
    preExecution = { LTBPreExecutionSigned(clientUser) },
    params = { mapOf(PARAM_USER to clientUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val signaturesTab = openDocAtSignatureTabClient(it, clientUser)
        signaturesTab.checkInfoForSigned()
        signaturesTab.makeUnSignActionByUser(clientUser)
        modalUnSignDocument.checkModalOpened()
        modalUnSignDocument.checkMessage(1, true)
        modalUnSignDocument.cancelBtn.click(false)
        modalUnSignDocument shouldNot visible
        signaturesTab.checkInfoForSigned()
    }
)

@LTBTaskIdsUiUnSign
@HighPriority
class UiLTBSignatureTabUnSignOwnTest(clientUser: User) : AbstractUiTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Закладка Подписи. Снятие своей подписи. Подтверждение действия.",
    preExecution = { LTBPreExecutionSigned(clientUser) },
    params = { mapOf(PARAM_USER to clientUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = { dto ->
        val signaturesTab = openDocAtSignatureTabClient(dto, clientUser)
        signaturesTab.checkInfoForSigned()
        signaturesTab.makeUnSignActionByUser(clientUser)
        modalUnSignDocument.checkModalOpened()
        modalUnSignDocument.checkMessage(1, true)
        modalUnSignDocument.unSignBtn.click(false)
        modalUnSignDocument shouldNot visible
        UiCommonChecks.checkPushMessage("Снята подпись для 1 документа")
        val beSteps = LetterToBankSteps(clientUser)
        val dtoId = dto!!.id!!
        val expStatuses = listOf(NEW, PARTLY_SIGNED).map { it.statusClient }
        UiCommonChecks.checkDocSystemStatusThroughBE(beSteps, dtoId, expStatuses)
    }
)