package ooo.jtc.ui.letters.frombank.tests

import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.api.letters.frombank.LetterFromBankPreExecutions.LFBPreExecutionDelivered
import ooo.jtc.api.letters.frombank.LetterFromBankPreExecutions.LFBPreExecutionDraft
import ooo.jtc.api.letters.frombank.LetterFromBankPreExecutions.LFBPreExecutionNew
import ooo.jtc.api.letters.frombank.LetterFromBankPreExecutions.LFBPreExecutionSigned
import ooo.jtc.api.letters.frombank.steps.LetterFromBankSteps
import ooo.jtc.core.kexensions.getAvailableCNList
import ooo.jtc.core.kexensions.getFio
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.LetterFromBankView
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.letters.model.LetterFromBankStatus
import ooo.jtc.letters.model.LetterFromBankStatus.NEW
import ooo.jtc.sign.SignToolType
import ooo.jtc.uaa.User
import ooo.jtc.ui.application.BankApplication
import ooo.jtc.ui.common.actions.UiCommonChecks
import ooo.jtc.ui.common.sections.modals.ModalUnSignDocument
import ooo.jtc.ui.common.templates.AbstractUiTest
import ooo.jtc.ui.common.templates.UiSignResultFormCloseTestTemplate
import ooo.jtc.ui.letters.frombank.LFBTaskIdsUiFormBankSignatures
import ooo.jtc.ui.pages.documents.letterfrombank.form.LetterFromBankFormPage
import ooo.jtc.ui.pages.documents.letterfrombank.sections.LetterFromBankModalSignDocument
import ooo.jtc.ui.pages.documents.letterfrombank.sections.LetterFromBankModalSignDocumentResult
import ooo.jtc.ui.pages.documents.letterfrombank.sections.LetterFromBankSignatureTab

/** Prevent code duplication. */
private fun openDocAtSignatureTabBank(
    it: LetterFromBankDto?,
    clientUser: User
): LetterFromBankSignatureTab {
    //TODO Sergeyev [2021.04.15]: change to openFormByParams(..., tab = HISTORY)
    val documentId = it!!.id!!
    val formPage = BankApplication.lFBFormBasicRequisitesBank
    formPage.openFormByParams(clientUser, documentId)
    return formPage.signaturesTab.openTab()
}


@LFBTaskIdsUiFormBankSignatures
@HighPriority
class UiLFBFormViewSignatureStatusDraftTest(bankUser: User) : AbstractUiTest<LetterFromBankDto, Unit>(
    name = "[Банк] ${DocumentNames.LETTER_FROM_BANK}. Форма просмотра. Закладка Подписи. Информация об отсутствии подписей. Draft.",
    preExecution = { LFBPreExecutionDraft(bankUser) },
    params = { mapOf(PARAM_USER to bankUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val signaturesTab = openDocAtSignatureTabBank(it, bankUser)
        signaturesTab.checkMessageForDraft()
    }
)

@LFBTaskIdsUiFormBankSignatures
@HighPriority
class UiLFBFormViewSignatureStatusNewTest(bankUser: User) : AbstractUiTest<LetterFromBankDto, Unit>(
    name = "[Банк] ${DocumentNames.LETTER_FROM_BANK}. Форма просмотра. Закладка Подписи. Информация об отсутствии подписей. New.",
    preExecution = { LFBPreExecutionNew(bankUser) },
    params = { mapOf(PARAM_USER to bankUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val signaturesTab = openDocAtSignatureTabBank(it, bankUser)
        signaturesTab.checkMessageForNew()
    }
)

@LFBTaskIdsUiFormBankSignatures
@HighPriority
class UiLFBFormViewSignatureStatusSignedTest(bankUser: User) : AbstractUiTest<LetterFromBankDto, Unit>(
    name = "[Банк] ${DocumentNames.LETTER_FROM_BANK}. Отображение полей, содержащих сведения о подписи (если список подписей не пуст). " +
            "Документ в статусе Singed. Подписан Сертификатом",
    preExecution = { LFBPreExecutionSigned(bankUser) },
    params = { mapOf(PARAM_USER to bankUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val signaturesTab = openDocAtSignatureTabBank(it, bankUser)
        val expSignToolText = "Сертификат"
        signaturesTab.checkInfoForSigned(expSignToolText = expSignToolText)
    }
)

@LFBTaskIdsUiFormBankSignatures
@HighPriority
class UiLFBFormViewSignatureStatusDeliveredBankTest(bankUser: User) : AbstractUiTest<LetterFromBankDto, Unit>(
    name = "[Банк] ${DocumentNames.LETTER_FROM_BANK}. Отображение полей, содержащих сведения о подписи (если список подписей не пуст). " +
            "Документ в статусах выше Singed. Подписан Сертификатом",
    preExecution = { LFBPreExecutionDelivered(bankUser) },
    params = { mapOf(PARAM_USER to bankUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val signaturesTab = openDocAtSignatureTabBank(it, bankUser)
        val expSignToolText = "Сертификат"
        signaturesTab.checkInfoForDeliveredPlus(expSignToolText = expSignToolText)
    }
)

@LFBTaskIdsUiFormBankSignatures
@HighPriority
class UiLFBUnsignTest(bankUser: User) : AbstractUiTest<LetterFromBankDto, Unit>(
    name = "[Банк] ${DocumentNames.LETTER_FROM_BANK}. Снятие подписи",
    preExecution = { LFBPreExecutionSigned(bankUser) },
    params = { mapOf(PARAM_USER to bankUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val ltb = it!!
        val expUserName = bankUser.getFio()
        val signaturesTab = openDocAtSignatureTabBank(ltb, bankUser)
        val selfSignRow = signaturesTab.signatureRows
            .find { signRow -> signRow.userName.text == expUserName }
            ?: throw RuntimeException("Не найдена подпись пользователя '$expUserName'")
        selfSignRow.unSignBtn.click()

        val unsignModal = ModalUnSignDocument()
        unsignModal.checkModalOpened()
        unsignModal.checkMessage(expDocCount = 1, isOwnSign = true)
        unsignModal.unSignBtn.click()

        UiCommonChecks.checkPushMessage("Снята подпись для 1 документа")
        val beSteps = LetterFromBankSteps(bankUser)
        UiCommonChecks.checkDocSystemStatusThroughBE(beSteps, ltb.id!!, listOf(NEW.statusBank))
    }
)


@NormalPriority
class UiLetterFromBankSignResultFormCloseTest(bankUser: User) :
    UiSignResultFormCloseTestTemplate<LetterFromBankView, LetterFromBankFormPage, LetterFromBankModalSignDocument, LetterFromBankModalSignDocumentResult>(
        user = bankUser,
        entityName = DocumentNames.LETTER_FROM_BANK,
        formPage = BankApplication.lFBFormBasicRequisitesBank,
        modalSignDocument = LetterFromBankModalSignDocument(),
        modalSignDocumentResult = LetterFromBankModalSignDocumentResult(),
        beSteps = LetterFromBankSteps(bankUser),
        expSignedStatus = LetterFromBankStatus.SIGNED.statusBank,
        preExecution = { LFBPreExecutionNew(bankUser).toView() },
        signToolType = SignToolType.CRYPTO,
        certUserName = bankUser.getAvailableCNList()[0]
    )