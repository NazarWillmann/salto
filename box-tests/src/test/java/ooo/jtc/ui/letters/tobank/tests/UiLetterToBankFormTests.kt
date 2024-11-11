package ooo.jtc.ui.letters.tobank.tests

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.FileDownloadMode
import ooo.jtc.api.common.checks.ApiDocumentChecks
import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBPreExecutionNewWithAttach
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBPreExecutionSigned
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBPreExecutionSignedWithAttach
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBUiExpSentStatuses
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareExportSteps
import ooo.jtc.api.letters.tobank.steps.LetterToBankPreparePrintSteps
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.createDraftLetterToBank
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.createSignedLetterToBank
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.getLetterToBankDtoForCreate
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.getOrCreateLetterToBankDto
import ooo.jtc.api.letters.tobank.steps.LetterToBankSteps
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps.DEFAULT_ATTACH_FILE
import ooo.jtc.core.kexensions.getClientRepresentativePhone
import ooo.jtc.core.kexensions.getFio
import ooo.jtc.core.kexensions.retrieveClientUser
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.letters.LetterToBankView
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankPrintExportFormat
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.letters.model.LetterToBankStatus.DRAFT
import ooo.jtc.letters.model.LetterToBankStatus.SIGNED
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.STATUS
import ooo.jtc.uaa.User
import ooo.jtc.ui.application.BankApplication.lTBFormBasicRequisitesBank
import ooo.jtc.ui.application.BankApplication.lTBScrollerPageBank
import ooo.jtc.ui.application.ClientApplication.lTBFormBasicRequisitesClient
import ooo.jtc.ui.application.ClientApplication.lTBScrollerPageClient
import ooo.jtc.ui.common.actions.UiCommonChecks
import ooo.jtc.ui.common.pages.ApplicationPageType
import ooo.jtc.ui.common.pages.DocumentPageTabs.BASIC_REQUISITES
import ooo.jtc.ui.common.pages.DocumentPageTabs.HISTORY
import ooo.jtc.ui.common.pages.DocumentPageTabs.SIGNATURES
import ooo.jtc.ui.common.templates.AbstractUiTest
import ooo.jtc.ui.common.templates.UiFormCopyTestTemplate
import ooo.jtc.ui.common.templates.UiFormExportTestTemplate
import ooo.jtc.ui.common.templates.UiFormPrintTestTemplate
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiExport
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiForm
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiFormTabs
import ooo.jtc.ui.pages.documents.lettertobank.form.LetterToBankFormBasicRequisitesTab
import ooo.jtc.ui.pages.documents.lettertobank.scroller.LetterToBankScrollerCategory
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import java.io.File
import java.time.LocalDate

@LTBTaskIdsUiForm
@NormalPriority
class UiLTBFormViewDeleteAttachClientTest(clientUser: User) : AbstractUiTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Форма просмотра. Работа с вложениями. Удаление",
    preExecution = { LTBPreExecutionSignedWithAttach.invoke(clientUser) },
    params = { mapOf(PARAM_USER to clientUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val documentId = it!!.id!!
        val formPage = lTBFormBasicRequisitesClient
        formPage.openFormByParams(clientUser, documentId)
        formPage.checkAttachmentsCantRemove()
    }
)

@LTBTaskIdsUiForm
@NormalPriority
class UiLTBFormViewDownloadAttachClientTest(clientUser: User, private val attachFile: File = DEFAULT_ATTACH_FILE) :
    AbstractUiTest<LetterToBankDto, Unit>(
        name = "${DocumentNames.LETTER_TO_BANK}. Форма просмотра. Работа с вложениями. Скачать",
        preExecution = {
            createSignedLetterToBank(
                creatorClientUser = clientUser,
                dtoForCreate = getLetterToBankDtoForCreate(
                    creatorClientUser = clientUser,
                    attachments = listOf(attachFile)
                )
            )
        },
        params = { mapOf(PARAM_USER to clientUser, PARAM_OBJECT_TYPE to it!!) },
        testBody = {
            Configuration.fileDownload = FileDownloadMode.FOLDER

            val documentId = it!!.id!!
            val formPage = lTBFormBasicRequisitesClient
            formPage.openFormByParams(clientUser, documentId)

            val attachName = attachFile.name
            val downloadedFile = formPage.downloadAttachment(attachName)
            "Проверить, что вложение успешно скачалось"{
                assertThat(
                    "Название скачанного файла не соответствует ожидаемому",
                    downloadedFile.name, Matchers.containsString(attachName)
                )
                assertThat(
                    "Содержимое скачанного файла не соответствует ожидаемому",
                    downloadedFile.readText(), Matchers.containsString(attachFile.readText())
                )
            }
        }
    )

@LTBTaskIdsUiForm
@NormalPriority
class UiLTBFormEditDeleteAttachClientTest(clientUser: User) : AbstractUiTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Форма редактирования. Работа с вложениями. Удаление",
    preExecution = { LTBPreExecutionNewWithAttach.invoke(clientUser) },
    params = { mapOf(PARAM_USER to clientUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val documentId = it!!.id!!
        val formPage = lTBFormBasicRequisitesClient
        formPage.openFormByParams(clientUser, documentId)

        val attachToRemove = it.attachments!!.size
        formPage.removeAttachments(attachToRemove)
        formPage.checkAllAttachments(Condition.not(Condition.exist))
    }
)

@LTBTaskIdsUiFormTabs
@NormalPriority
class UiLTBFormViewTabsTest(
    user: User,
    preExecution: () -> LetterToBankDto,
    pageType: ApplicationPageType
) : AbstractUiTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Форма просмотра. Закладка Основные реквизиты. Отображение вкладок. [${pageType.uiName}]",
    preExecution = preExecution,
    params = { mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val customerId = it!!.customerId!!
        val scrollerPage = if (pageType.isClient()) lTBScrollerPageClient else lTBScrollerPageBank
        scrollerPage.openScrollerBy(user, customerId)
        scrollerPage.filterByDocumentNumber(it.documentNumber)
        scrollerPage.openTab(LetterToBankScrollerCategory.ALL)

        scrollerPage.scroller
            .getRowByText(it.documentNumber)
            .moreButtonMenu.clickByOption("Просмотреть")

        val formPage = if (pageType.isClient()) lTBFormBasicRequisitesClient else lTBFormBasicRequisitesBank
        formPage.checkVisibleTabs(BASIC_REQUISITES, SIGNATURES, HISTORY)
    }
)

@LTBTaskIdsUiFormTabs
@NormalPriority
class UiLTBFormViewBaseRequisitesFieldsTest(
    user: User,
    preExecution: () -> LetterToBankDto,
    pageType: ApplicationPageType
) : AbstractUiTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Форма просмотра. Закладка Основные реквизиты. Отображение полей. [${pageType.uiName}]",
    preExecution = preExecution,
    params = { mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val documentId = it!!.id!!
        val basicRequisitesTab = if (pageType.isClient()) lTBFormBasicRequisitesClient else lTBFormBasicRequisitesBank
        basicRequisitesTab.openFormByParams(user = user, documentId = documentId)
        basicRequisitesTab.checkViewFormFilledCorrect(it.toView())
    }
)

@LTBTaskIdsUiForm
@NormalPriority
class UiLTBFormEditTabsClientTest(clientUser: User) : AbstractUiTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Форма редактирования. Закладка Основные реквизиты. Отображение вкладок. [Клиент]",
    preExecution = {
        getOrCreateLetterToBankDto(searchingUser = clientUser,
            getPageRequest = { DRAFT.asFilterData(clientUser).toPageRequest() },
            createLtbFunc = { createDraftLetterToBank(creatorClientUser = clientUser) }
        )
    },
    params = { mapOf(PARAM_USER to clientUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val customerId = it!!.customerId!!
        val scrollerPage = lTBScrollerPageClient
        scrollerPage.openScrollerBy(clientUser, customerId)
        scrollerPage.filterByDocumentNumber(it.documentNumber)
        scrollerPage.scroller
            .getRowByText(it.documentNumber)
            .moreButtonMenu.clickByOption("Редактировать")

        val formPage = lTBFormBasicRequisitesClient
        formPage.checkVisibleTabs(BASIC_REQUISITES, SIGNATURES, HISTORY)
    }
)


@LTBTaskIdsUiForm
@NormalPriority
class UiLTBFormCreateTest(user: User) : AbstractUiTest<LetterToBankView, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Создание документа. Успешный сценарий",
    params = { mapOf(PARAM_USER to user) },
    preExecution = {
        val attachments = listOf(DEFAULT_ATTACH_FILE)
        getLetterToBankDtoForCreate(creatorClientUser = user.retrieveClientUser()).toView().withAttachmentFiles(attachments)
    },
    testBody = {
        val action = "Сохранить"
        val expStatus = LetterToBankStatus.NEW.getDescription(user.userType)
        val docView = it!!
        val scrollerPage = lTBScrollerPageClient
        val createPage = lTBFormBasicRequisitesClient
        scrollerPage.openScrollerBy(user, docView.customerId)
        scrollerPage.createLetter.click()
        createPage.headerName = "Новое письмо в банк"
        createPage.checkHeader(LocalDate.now())
        createPage.checkVisibleTabs(BASIC_REQUISITES)
        "Проверить, что элемент управления 'Избранным' не отображается"{
            createPage.isFavorite.shouldNot(Condition.visible)
        }
        "Проверить, что Статус не отображается"{
            createPage.status.shouldNot(Condition.visible)
        }
        createPage.checkPreFilled(user, docView)
        createPage.fill(docView)
        createPage.makeAction(action)
        //TODO A.Stykalin [07.10.2020] Не реализованы push-уведомления на UI. Исправить после "дельты" аналитики и реализации на UI.
        UiCommonChecks.checkPushMessage("Документ успешно сохранён")
        createPage.checkEditFromFilledCorrect(docView)
        createPage.checkStatus(expStatus)
    }
)

@LTBTaskIdsUiForm
@NormalPriority
class UiLTBFormViewClientTest(clientUser: User) : AbstractUiTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Форма просмотра документа",
    preExecution = {
        getOrCreateLetterToBankDto(searchingUser = clientUser,
            getPageRequest = { STATUS.eq(SIGNED).toPageRequest() },
            createLtbFunc = { createSignedLetterToBank(creatorClientUser = clientUser) }
        )
    },
    params = { mapOf(PARAM_USER to clientUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val customerId = it!!.customerId!!
        val scrollerPage = lTBScrollerPageClient
        scrollerPage.openScrollerBy(clientUser, customerId)
        scrollerPage.filterByDocumentNumber(it.documentNumber)
        scrollerPage.openTab(LetterToBankScrollerCategory.ALL)
        scrollerPage.scroller
            .getRowByText(it.documentNumber)
            .moreButtonMenu.clickByOption("Просмотреть")

        "Проверить, что Открылась форма просмотра письма в банк без возможности редактирования полей"{
            val formPage = lTBFormBasicRequisitesClient
            formPage.checkHeader(it.documentDate)
            formPage.checkFieldsNotEditable()
        }
    }
)

@LTBTaskIdsUiForm
@NormalPriority
class UiLetterFormPrintTest(
    user: User,
    printFormat: LetterToBankPrintExportFormat
) : UiFormPrintTestTemplate<LetterToBankDto, LetterToBankFormBasicRequisitesTab>(
    user = user,
    formPage = if (user.isClient) lTBFormBasicRequisitesClient else lTBFormBasicRequisitesBank,
    entityName = DocumentNames.LETTER_TO_BANK,
    format = printFormat,
    availableFormats = LetterToBankPrintExportFormat.printFormats,
    preExecution = { LetterToBankPreExecutions.LTBPreExecutionReceived(user) },
    getExpFileName = { LetterToBankPreparePrintSteps.preparePrintFileNameSingleDoc(it) + "." + printFormat.format.name.toLowerCase() },
    getExpFileContentFunc = { LetterToBankPreparePrintSteps.preparePrintExpContent(listOf(it), true, user) }
)

@LTBTaskIdsUiExport
@NormalPriority
class UiLetterFormExportTest(
    user: User,
    exportFormat: LetterToBankPrintExportFormat
) : UiFormExportTestTemplate<LetterToBankDto, LetterToBankFormBasicRequisitesTab>(
    user = user,
    formPage = if (user.isClient) lTBFormBasicRequisitesClient else lTBFormBasicRequisitesBank,
    entityName = DocumentNames.LETTER_TO_BANK,
    format = exportFormat,
    availableFormats = LetterToBankPrintExportFormat.exportFormats,
    preExecution = { LetterToBankPreExecutions.LTBPreExecutionReceived(user) },
    getExpFileName = { LetterToBankPrepareExportSteps.prepareExportFileNameSingleDoc(it) + "." + exportFormat.format.name.toLowerCase() },
    getExpFileContentFunc = { LetterToBankPrepareExportSteps.getExportExpContentByFormat(exportFormat.format, listOf(it), user.userType) }
)

@LTBTaskIdsUiForm
@LowPriority
class UiLTBFormSendToBankTest(clientUser: User) : AbstractUiTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Отправка документа в банк из формы. [${clientUser.userType}]",
    preExecution = { LTBPreExecutionSigned(clientUser) },
    params = { mapOf(PARAM_USER to clientUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = { dto ->
        val action = "Отправить"
        val expStatuses = LTBUiExpSentStatuses(clientUser)
        val beSteps = LetterToBankSteps(clientUser)

        val documentId = dto!!.id!!
        val formPage = lTBFormBasicRequisitesClient
        formPage.openFormByParams(clientUser, documentId)

        formPage.makeAction(action)
        UiCommonChecks.checkPushMessage("Отправлен в банк 1 документ")
        "Проверить, что документ перешел в один из статусов $expStatuses"{
            val byId = beSteps.getById(dto.id!!).data!!
            ApiDocumentChecks<LetterToBankDto>().checkDocumentStatus(byId, expStatuses)
        }
    }
)

@LTBTaskIdsUiForm
@LowPriority
class UiLTBFormCopyTest(clientUser: User) : UiFormCopyTestTemplate<LetterToBankView, LetterToBankFormBasicRequisitesTab>(
    entityName = DocumentNames.LETTER_TO_BANK,
    user = clientUser,
    formPage = lTBFormBasicRequisitesClient,
    preExecution = {
        LetterToBankPreExecutions.LTBPreExecutionNew(clientUser).toView()
            .apply {
                this.contactName = clientUser.getFio()
                this.contactPhone = clientUser.getClientRepresentativePhone(this.customerId) ?: ""
            }
    },
    expHeaderText = "Новое письмо в банк"
)