package ooo.jtc.ui.letters.frombank.tests

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.FileDownloadMode
import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.api.letters.frombank.LetterFromBankPreExecutions
import ooo.jtc.api.letters.frombank.LetterFromBankPreExecutions.LFBPreExecutionDelivered
import ooo.jtc.api.letters.frombank.LetterFromBankPreExecutions.LFBPreExecutionDeliveredWithMultipleAttach
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareExportSteps
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps
import ooo.jtc.core.TestTemplateConstants.PARAM_OBJECT
import ooo.jtc.core.kexensions.retrieveBankUser
import ooo.jtc.core.tm4j.ComponentFreeFormatDoc
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.letters.LetterFromBankView
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.letters.model.LetterFromBankPrintExportFormat
import ooo.jtc.letters.model.LetterFromBankStatus
import ooo.jtc.scripts.invoke
import ooo.jtc.uaa.User
import ooo.jtc.ui.application.BankApplication
import ooo.jtc.ui.application.ClientApplication
import ooo.jtc.ui.common.actions.UiCommonChecks
import ooo.jtc.ui.common.pages.ApplicationPageType
import ooo.jtc.ui.common.pages.DocumentPageTabs.BASIC_REQUISITES
import ooo.jtc.ui.common.pages.DocumentPageTabs.HISTORY
import ooo.jtc.ui.common.pages.DocumentPageTabs.SIGNATURES
import ooo.jtc.ui.common.templates.AbstractUiTest
import ooo.jtc.ui.common.templates.UiFormExportTestTemplate
import ooo.jtc.ui.letters.frombank.LFBTaskIdsUiExport
import ooo.jtc.ui.letters.frombank.LFBTaskIdsUiForm
import ooo.jtc.ui.letters.frombank.LFBTaskIdsUiFormBasicRequisites
import ooo.jtc.ui.letters.frombank.LFBTaskIdsUiFormTabs
import ooo.jtc.ui.pages.documents.letterfrombank.form.LetterFromBankFormBasicRequisitesTab
import ooo.jtc.ui.pages.documents.letterfrombank.scroller.LetterFromBankScrollerCategory
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import java.io.File
import java.time.LocalDate

@LFBTaskIdsUiExport
@NormalPriority
@ComponentFreeFormatDoc
class UiLetterFormExportTest(
    user: User,
    exportFormat: LetterFromBankPrintExportFormat
) : UiFormExportTestTemplate<LetterFromBankDto, LetterFromBankFormBasicRequisitesTab>(
    user = user,
    formPage = if (user.isBank) BankApplication.lFBFormBasicRequisitesBank else ClientApplication.lFBFormBasicRequisitesClient,
    entityName = DocumentNames.LETTER_FROM_BANK,
    format = exportFormat,
    availableFormats = LetterFromBankPrintExportFormat.exportFormats,
    preExecution = { LFBPreExecutionDelivered(user) },
    getExpFileName = { LetterFromBankPrepareExportSteps.prepareExportFileNameSingleDoc(it) + "." + exportFormat.format.name.toLowerCase() },
    getExpFileContentFunc = { LetterFromBankPrepareExportSteps.getExportExpContentByFormat(exportFormat.format, listOf(it), user.userType) }
)

@LFBTaskIdsUiFormTabs
@NormalPriority
class UiLFBFormViewTabsTest(
    user: User,
    preExecution: () -> LetterFromBankDto,
    pageType: ApplicationPageType
) : AbstractUiTest<LetterFromBankDto, Unit>(
    name = "${DocumentNames.LETTER_FROM_BANK}. Форма просмотра. Закладка Основные реквизиты. Отображение вкладок. [${pageType.uiName}]",
    preExecution = preExecution,
    params = { mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val customerId = it!!.customerId!!
        val scrollerPage = if (pageType.isBank()) BankApplication.lFBScrollerPageBank else ClientApplication.lFBScrollerPageClient
        scrollerPage.openScrollerBy(user, customerId)
        scrollerPage.filterByDocumentNumber(it.documentNumber)
        scrollerPage.openTab(LetterFromBankScrollerCategory.ALL)

        scrollerPage.scroller
            .getRowByText(it.documentNumber)
            .moreButtonMenu.clickByOption("Просмотреть")

        val formPage = if (pageType.isBank()) BankApplication.lFBFormBasicRequisitesBank else ClientApplication.lFBFormBasicRequisitesClient
        formPage.checkVisibleTabs(BASIC_REQUISITES, SIGNATURES, HISTORY)
    }
)

@LFBTaskIdsUiForm
@NormalPriority
class UiLFBFormViewDownloadAttachBankTest(bankUser: User, private val attachFile: File = AttachmentPrepareSteps.DEFAULT_ATTACH_FILE) :
    AbstractUiTest<LetterFromBankDto, Unit>(
        name = "${DocumentNames.LETTER_FROM_BANK}. Форма просмотра. Работа с вложениями. Скачать",
        preExecution = {
            LetterFromBankPrepareSteps.createSignedLetterFromBank(
                creatorBankUser = bankUser,
                dtoForCreate = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(
                    creatorBankUser = bankUser,
                    attachments = listOf(attachFile)
                )
            )
        },
        params = { mapOf(PARAM_USER to bankUser, PARAM_OBJECT_TYPE to it!!) },
        testBody = {
            Configuration.fileDownload = FileDownloadMode.FOLDER

            val documentId = it!!.id!!
            val formPage = BankApplication.lFBFormBasicRequisitesBank
            formPage.openFormByParams(bankUser, documentId)

            val attachName = attachFile.name
            val downloadedFile = formPage.downloadAttachment(attachName)
            "Проверить, что вложение успешно скачалось"{
                MatcherAssert.assertThat(
                    "Название скачанного файла не соответствует ожидаемому",
                    downloadedFile.name, Matchers.containsString(attachName)
                )
                MatcherAssert.assertThat(
                    "Содержимое скачанного файла не соответствует ожидаемому",
                    downloadedFile.readText(), Matchers.containsString(attachFile.readText())
                )
            }
        }
    )

@LFBTaskIdsUiForm
@NormalPriority
class UiLFBFormViewDeleteAttachBankTest(bankUser: User) : AbstractUiTest<LetterFromBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Форма просмотра. Работа с вложениями. Удаление",
    preExecution = { LetterFromBankPreExecutions.LFBPreExecutionSignedWithAttach.invoke(bankUser) },
    params = { mapOf(PARAM_USER to bankUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val documentId = it!!.id!!
        val formPage = BankApplication.lFBFormBasicRequisitesBank
        formPage.openFormByParams(bankUser, documentId)
        formPage.checkAttachmentsCantRemove()
    }
)

@LFBTaskIdsUiForm
@NormalPriority
class UiLFBFormEditTabsBankTest(bankUser: User, clientUser: User) : AbstractUiTest<LetterFromBankDto, Unit>(
    name = "${DocumentNames.LETTER_FROM_BANK}. Форма редактирования. Закладка Основные реквизиты. Отображение вкладок. [${bankUser.userType}]",
    preExecution = {
        LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(searchingUser = clientUser,
            getPageRequest = { LetterFromBankStatus.DRAFT.asFilterData(bankUser).toPageRequest() },
            createLfbFunc = { LetterFromBankPrepareSteps.createDraftLetterFromBank(creatorBankUser = bankUser) }
        )
    },
    params = { mapOf(PARAM_USER to bankUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val customerId = it!!.customerId!!
        val scrollerPage = BankApplication.lFBScrollerPageBank
        scrollerPage.openScrollerBy(bankUser, customerId)
        scrollerPage.filterByDocumentNumber(it.documentNumber)
        scrollerPage.scroller
            .getRowByText(it.documentNumber)
            .moreButtonMenu.clickByOption("Редактировать")

        val formPage = BankApplication.lFBFormBasicRequisitesBank
        formPage.checkVisibleTabs(BASIC_REQUISITES, SIGNATURES, HISTORY)
    }
)

@LFBTaskIdsUiFormBasicRequisites
@HighPriority
class UiLFBFormViewFieldsTest(bankUser: User) : AbstractUiTest<LetterFromBankDto, Unit>(
    name = "${DocumentNames.LETTER_FROM_BANK}. Форма просмотра. Закладка Основные реквизиты. Проверка отображения всех полей. [${bankUser.userType}]",
    preExecution = {
        LFBPreExecutionDeliveredWithMultipleAttach(bankUser, 2)
    },
    params = { mapOf(PARAM_USER to bankUser, PARAM_OBJECT to it!!) },
    testBody = {
        val documentId = it!!.id!!
        val formPage = BankApplication.lFBFormBasicRequisitesBank
        formPage.openFormByParams(bankUser, documentId)
        formPage.checkVisibleTabs(BASIC_REQUISITES, SIGNATURES, HISTORY)
        formPage.checkFieldsNotEditable()
        formPage.checkAllAttachments(condition = Condition.visible, isRemovable = false)
    }
)

@LFBTaskIdsUiForm
@NormalPriority
class UiLFBFormEditDeleteAttachBankTest(bankUser: User) : AbstractUiTest<LetterFromBankDto, Unit>(
    name = "${DocumentNames.LETTER_FROM_BANK}. Форма редактирования. Работа с вложениями. Удаление",
    preExecution = { LetterFromBankPreExecutions.LFBPreExecutionNewWithAttach.invoke(bankUser) },
    params = { mapOf(PARAM_USER to bankUser, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val documentId = it!!.id!!
        val formPage = BankApplication.lFBFormBasicRequisitesBank
        formPage.openFormByParams(bankUser, documentId)

        val attachToRemove = it.attachments!!.size
        formPage.removeAttachments(attachToRemove)
        formPage.checkAllAttachments(Condition.not(Condition.exist))
    }
)

@LFBTaskIdsUiForm
@NormalPriority
class UiLFBFormCreateTest(user: User) : AbstractUiTest<LetterFromBankView, Unit>(
    name = "${DocumentNames.LETTER_FROM_BANK}. Создание документа. Успешный сценарий",
    params = { mapOf(PARAM_USER to user) },
    preExecution = {
        val attachments = listOf(AttachmentPrepareSteps.DEFAULT_ATTACH_FILE)
        LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(creatorBankUser = user.retrieveBankUser()).toView().withAttachmentFiles(attachments)
    },
    testBody = {
        val action = "Сохранить"
        val expStatus = LetterFromBankStatus.NEW.getDescription(user.userType)
        val docView = it!!
        val scrollerPage = BankApplication.lFBScrollerPageBank
        val createPage = BankApplication.lFBFormBasicRequisitesBank
        scrollerPage.openScrollerBy(user, docView.customerId)
        scrollerPage.createLetter.click()
        createPage.headerName = "Новое письмо из банка"
        createPage.checkVisibleTabs(BASIC_REQUISITES)
        "Проверить, что элемент управления 'Избранным' не отображается"{
            createPage.isFavorite.shouldNot(Condition.visible)
        }
        "Проверить, что Статус не отображается"{
            createPage.status.shouldNot(Condition.visible)
        }
        createPage.checkPreFilled(user, docView)
        createPage.fill(docView)
        createPage.checkHeader(LocalDate.now())
        createPage.makeAction(action)
        UiCommonChecks.checkPushMessage("Документ успешно сохранён")
        createPage.checkEditFromFilledCorrect(docView)
        createPage.checkStatus(expStatus)
    }
)