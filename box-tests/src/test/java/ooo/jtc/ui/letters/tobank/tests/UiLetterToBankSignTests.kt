package ooo.jtc.ui.letters.tobank.tests

import com.codeborne.selenide.Condition.visible
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBPreExecutionCreateSignedForCustomer
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBPreExecutionNew
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBPreExecutionSigned
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBUiExpSentStatuses
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps
import ooo.jtc.api.letters.tobank.steps.LetterToBankSteps
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps
import ooo.jtc.core.TestTemplateConstants.PARAM_OBJECT
import ooo.jtc.core.browser.BrowserHelper
import ooo.jtc.core.container.shouldNot
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.extensions.getOrException
import ooo.jtc.files.FileHelper
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.pageparams.and
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.letters.LetterToBankView
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.letters.model.LetterToBankStatus.NEW
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.CUSTOMER_ID
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.IS_HAS_ATTACH
import ooo.jtc.uaa.User
import ooo.jtc.ui.application.ClientApplication
import ooo.jtc.ui.common.actions.UiCommonChecks
import ooo.jtc.ui.common.sections.modals.ModalUnSignError
import ooo.jtc.ui.common.templates.UiScrollerSignFormRequisitesTestTemplate
import ooo.jtc.ui.common.templates.UiSignFormCancelTestTemplate
import ooo.jtc.ui.common.templates.UiSignResultFormCloseTestTemplate
import ooo.jtc.ui.common.templates.UiSignResultFormSendTestTemplate
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiCommon
import ooo.jtc.ui.pages.documents.lettertobank.form.LetterToBankFormPage
import ooo.jtc.ui.pages.documents.lettertobank.scroller.LetterToBankScrollerCategory
import ooo.jtc.ui.pages.documents.lettertobank.scroller.LetterToBankScrollerPage
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankModalSignDocument
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankModalSignDocumentResult
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankModalUnSignCutOff
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankScrollerFilterClient
import org.apache.commons.lang3.RandomStringUtils

//@formatter:off
private const val S_2653 = "JTCSALTO-2653"  // AT. Письма в банк. Функции (UC). Снятие подписи [FE]
private const val S_1897 = "JTCSALTO-1897" // Проект Salto: Release 1 > Переписка с банком > Письмо в банк > Экранные формы > На клиенте > Дополнительные формы > Визард снятия подписи (один документ, несколько документов) > Ручное тестирование
private const val S_1895 = "JTCSALTO-1895" // Проект Salto: Release 1 > Переписка с банком > Письмо в банк > Экранные формы > На клиенте > Дополнительные формы > Визард снятия подписи (один документ, несколько документов) > ANALITICS. Разработка требований
//@formatter:on

//@LTBTaskIdsUiFormTabs //TODO A.Stykalin [14.10.2020] taskId
@HighPriority
class UiLTBSignFormRequisitesTest(
    user: User
) : UiScrollerSignFormRequisitesTestTemplate<LetterToBankView, LetterToBankScrollerPage, LetterToBankScrollerCategory, LetterToBankModalSignDocument>(
    entityName = DocumentNames.LETTER_TO_BANK,
    user = user,
    scrollerPage = ClientApplication.lTBScrollerPageClient,
    scrollerCategory = LetterToBankScrollerCategory.FOR_SIGNATURE,
    modalSignDocument = LetterToBankModalSignDocument(),
    preExecution = {
        val docCount = 2
        val customerId = CustomerData.getOrCreate(user).id!!
        val pageRequest = CUSTOMER_ID.eq(customerId).and(IS_HAS_ATTACH.eq(true)).and(NEW.asFilterData(user)).toPageRequest()
        val pageSize = LetterToBankSteps(user).getPage(pageRequest).size
        if (pageSize == null || pageSize < docCount) {
            for (num in 1..docCount) {
                val content = "ATest ${RandomStringUtils.randomAlphabetic(1000, 2000)}".toByteArray()
                val attachmentFiles = FileHelper.createTempFiles("at_attachment_", "txt", 1, content)
                val attachments = attachmentFiles.map { AttachmentPrepareSteps.uploadFile(user = user, file = it) }
                val dtoForCreate = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(customerId = customerId, attachments = attachments)
                LetterToBankPrepareSteps.createLetterToBankDto(creatorClientUser = user, dtoForCreate = dtoForCreate)
            }
        }
        customerId
    },
    expDocListFunc = { actIds ->
        val steps = LetterToBankSteps(user)
        actIds.map { steps.getById(it).data.getOrException().toView() }
    },
    extraFiltration = { ff ->
        (ff as LetterToBankScrollerFilterClient).isHasAttach.check()
        ff.apply.click(false)
    },
    docCount = 2
)

//TODO A.Stykalin [14.10.2020] taskId
@NormalPriority
class UiLetterToBankSignFormCancelTest(user: User) :
    UiSignFormCancelTestTemplate<LetterToBankView, LetterToBankFormPage, LetterToBankModalSignDocument>(
        user = user,
        entityName = DocumentNames.LETTER_TO_BANK,
        formPage = ClientApplication.lTBFormBasicRequisitesClient,
        modalSignDocument = LetterToBankModalSignDocument(),
        beSteps = LetterToBankSteps(user),
        preExecution = { LTBPreExecutionNew(user).toView() }
    )

//TODO A.Stykalin [14.10.2020] taskId
@NormalPriority
class UiLetterToBankSignResultFormCloseTest(clientUser: User) :
    UiSignResultFormCloseTestTemplate<LetterToBankView, LetterToBankFormPage, LetterToBankModalSignDocument, LetterToBankModalSignDocumentResult>(
        user = clientUser,
        entityName = DocumentNames.LETTER_TO_BANK,
        formPage = ClientApplication.lTBFormBasicRequisitesClient,
        modalSignDocument = LetterToBankModalSignDocument(),
        modalSignDocumentResult = LetterToBankModalSignDocumentResult(),
        beSteps = LetterToBankSteps(clientUser),
        expSignedStatus = LetterToBankStatus.SIGNED.statusClient,
        preExecution = { LTBPreExecutionNew(clientUser).toView() }
    )

//TODO A.Stykalin [14.10.2020] taskId
@NormalPriority
class UiLetterToBankSignResultFormSendTest(clientUser: User) :
    UiSignResultFormSendTestTemplate<LetterToBankView, LetterToBankFormPage, LetterToBankModalSignDocument, LetterToBankModalSignDocumentResult>(
        user = clientUser,
        entityName = DocumentNames.LETTER_TO_BANK,
        formPage = ClientApplication.lTBFormBasicRequisitesClient,
        modalSignDocument = LetterToBankModalSignDocument(),
        modalSignDocumentResult = LetterToBankModalSignDocumentResult(),
        beSteps = LetterToBankSteps(clientUser),
        expSentStatuses = LTBUiExpSentStatuses(clientUser),
        preExecution = { LTBPreExecutionNew(clientUser).toView() }
    )

@LTBTaskIdsUiCommon
@TaskIds([S_2653, S_1897, S_1895])
@HighPriority
class UiLetterToBankUnSignOneOfTwoTest(val firstClientUser: User, val secondClientUser: User) : AbstractTest<List<LetterToBankDto>, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Снять подпись под одним из двух документов. Продолжить действие. [Клиент]",
    preExecution = {
        val commonCustomersId = CustomerData.getOrCreateCommonCustomersId(firstClientUser, secondClientUser)
        val dtoList = mutableListOf<LetterToBankDto>()
        dtoList.add(LTBPreExecutionCreateSignedForCustomer(firstClientUser, commonCustomersId))
        dtoList.add(LTBPreExecutionCreateSignedForCustomer(secondClientUser, commonCustomersId))
        dtoList
    }
) {
    override fun execution(preconditionResult: List<LetterToBankDto>?) {
        unSignOneOfTwoOpenModal(preconditionResult, secondClientUser)
        val modalUnSignCutOff = LetterToBankModalUnSignCutOff()
//        TODO A.Stykalin [28.10.2020] включить проверки, когда фронт изменит форму
//        val viewList = dtoList.map { it.toView() }
//        modalUnSignCutOff.checkDocsPreview(viewList)

        modalUnSignCutOff.proceedBtn.click(false)
        UiCommonChecks.checkPushMessage("Снята подпись для 1 документа")
    }

    override fun params(): Map<String, Any> = mapOf(
        "${PARAM_USER}_1" to firstClientUser,
        "${PARAM_USER}_2" to secondClientUser,
        "Список документов" to preconditionResult!!
    )
}

@LTBTaskIdsUiCommon
@TaskIds([S_2653, S_1897, S_1895])
@NormalPriority
class UiLetterToBankUnSignOneOfTwoCancelTest(val firstClientUser: User, val secondClientUser: User) : AbstractTest<List<LetterToBankDto>, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Снять подпись под одним из двух документов. Отмена действия. [Клиент]",
    preExecution = {
        val commonCustomersId = CustomerData.getOrCreateCommonCustomersId(firstClientUser, secondClientUser)
        val dtoList = mutableListOf<LetterToBankDto>()
        dtoList.add(LTBPreExecutionCreateSignedForCustomer(firstClientUser, commonCustomersId))
        dtoList.add(LTBPreExecutionCreateSignedForCustomer(secondClientUser, commonCustomersId))
        dtoList
    }
) {
    override fun execution(preconditionResult: List<LetterToBankDto>?) {
        val dtoList = preconditionResult!!
        val user = secondClientUser
        unSignOneOfTwoOpenModal(preconditionResult, user)
        val modalUnSignCutOff = LetterToBankModalUnSignCutOff()

        modalUnSignCutOff.cancelBtn.click(false)
        modalUnSignCutOff shouldNot visible
        dtoList.forEach {
            val beSteps = LetterToBankSteps(user)
            UiCommonChecks.checkDocSystemStatusThroughBE(beSteps = beSteps, dtoId = it.id!!, listOf(it.status!!))
        }
    }

    override fun params(): Map<String, Any> = mapOf(
        "${PARAM_USER}_1" to firstClientUser,
        "${PARAM_USER}_2" to secondClientUser,
        "Список документов" to preconditionResult!!
    )
}

@LTBTaskIdsUiCommon
@TaskIds([S_2653, S_1897, S_1895])
@HighPriority
class UiLetterToBankUnSignErrorTest(val clientUser: User) : AbstractTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Письмо в Банк. Снять подпись. Непредвиденная ошибка. [${clientUser.userType}]",
    preExecution = { LTBPreExecutionSigned(clientUser) }
) {
    override fun execution(preconditionResult: LetterToBankDto?) {
        val dto = preconditionResult!!
        val formPage = ClientApplication.lTBFormBasicRequisitesClient
        val action = "Снять подпись"

        formPage.openFormByParams(clientUser, dto.id!!)
        BrowserHelper.switchNetworkOffline()
        formPage.makeAction(action)
        ModalUnSignError().checkModalOpened()
    }

    override fun params(): Map<String, Any> = mapOf(
        PARAM_USER to clientUser,
        PARAM_OBJECT to preconditionResult!!
    )
}


/**
 * DRY function for tests UiLetterToBankUnSignOneOfTwo.
 * There should always be two documents in the list - one is selfSigned by `secondClientUser`, the second signed by another user.
 */
private val unSignOneOfTwoOpenModal: (List<LetterToBankDto>?, User) -> Unit = { preconditionResult, secondClientUser ->
    val dtoList = preconditionResult!!
    val customerId = dtoList[0].customerId!!
    val scrollerPage = ClientApplication.lTBScrollerPageClient
    val action = "Снять подпись"
    val modalUnSignCutOff = LetterToBankModalUnSignCutOff()

    scrollerPage.openScrollerBy(secondClientUser, customerId)
    scrollerPage.openTab(LetterToBankScrollerCategory.FOR_SEND)
    val docNumbers = dtoList.map { it.documentNumber }
    scrollerPage.scroller.selectRowByText(docNumbers)
    scrollerPage.makeAction(action)

    modalUnSignCutOff.checkModalOpened(canUnSign = true)
    modalUnSignCutOff.checkCounters(
        expSuccessDocsCount = 1,
        expSuccessDocsText = "К снятию подписи",
        expErrorDocsCount = 1,
        expErrorDocsText = "Подпись не может быть снята"
    )
}