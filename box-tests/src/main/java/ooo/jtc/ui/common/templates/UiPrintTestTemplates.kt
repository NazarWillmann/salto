package ooo.jtc.ui.common.templates

import com.codeborne.selenide.Condition
import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.TestTemplateConstants.PARAM_CUSTOMER_ID
import ooo.jtc.core.browser.BrowserHelper
import ooo.jtc.core.elements.scroller.DocumentScroller
import ooo.jtc.core.elements.scroller.DocumentScrollerRow
import ooo.jtc.core.elements.scroller.ScrollerCategory
import ooo.jtc.generic.parsers.ParserFacade
import ooo.jtc.generic.print.IPrintExportFormat
import ooo.jtc.generic.print.PrintExportFormat
import ooo.jtc.interfaces.IDocument
import ooo.jtc.scripts.invoke
import ooo.jtc.uaa.User
import ooo.jtc.ui.UiHelper
import ooo.jtc.ui.common.actions.UiCommonChecks.checkPushMessage
import ooo.jtc.ui.common.pages.DocumentPage
import ooo.jtc.ui.common.pages.DocumentScrollerPage
import ooo.jtc.ui.common.sections.CommonSections
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.matchesRegex
import java.util.*

/** Общие действия для проверки ПФ одного документа. */
internal fun <T : IDocument> printSingleDocCheck(
    dto: T,
    format: IPrintExportFormat,
    availableFormats: List<IPrintExportFormat>,
    getExpFileName: (T) -> String,
    getExpFileContentFunc: (T) -> List<String>,
    additionalChecks: (dto: T, actContent: String) -> Unit
) {
    "Открылась форма Настройки печати"{
        CommonSections.modalPrintDocument.checkHeader()
        CommonSections.modalPrintDocument.checkAvailableFormats(availableFormats.map { it.description })
    }

    CommonSections.modalPrintDocument.printFormat.select(format.description)
    CommonSections.modalPrintDocument.printBtn.click()

    //TODO A.Stykalin [07.10.2020] Не реализованы push-уведомления на UI. Исправить после "дельты" аналитики и реализации на UI.
    checkPushMessage("Отправлен на печать 1 документ")

    val expContent: List<String> = getExpFileContentFunc.invoke(dto).attachToAllure("expContent")
    val actContent: String = if (format.format == PrintExportFormat.HTML) {
        BrowserHelper.switchToNextTab()
        BrowserHelper.getPageText()
    } else {
        val fileName = getExpFileName(dto)
        val downloadedFile = UiHelper.getDownloadedFile(fileName)
        val parser = ParserFacade.getParserByFormat(format.format)
        parser.parseContent(downloadedFile.readBytes(), "")
    }.attachToAllure("actContext")

    "Проверить соответствие содержания ПФ" {
        expContent.forEach { assertThat("В документе нет строки '$it'", actContent.contains(it)) }
        additionalChecks(dto, actContent)
    }
}

open class UiFormPrintTestTemplate<T : IDocument, Form : DocumentPage>(
    var entityName: String,
    val user: User,
    val formPage: Form,
    val format: IPrintExportFormat,
    val availableFormats: List<IPrintExportFormat>,
    override val preExecution: (() -> T)?,
    val getExpFileName: (T) -> String,
    var getExpFileContentFunc: (T) -> List<String>,
    val additionalChecks: (dto: T, actContent: String) -> Unit = { _: T, _: String -> },
    val action: String = "Печатать"
) : AbstractTest<T, Unit>(
    name = "$entityName. $action документа из формы.[${format.description}]. [${user.userType}]",
    preExecution = preExecution
) {
    override fun execution(preconditionResult: T?) {
        val dto = preconditionResult!!
        formPage.openFormByParams(user = user, documentId = dto.id!!)

        formPage.makeAction(action)

        printSingleDocCheck(dto, format, availableFormats, getExpFileName, getExpFileContentFunc, additionalChecks)
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to preconditionResult!!)
    }
}

open class UiScrollerPrintTestTemplate<T : IDocument,
        S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>, C : ScrollerCategory>(
    val testName: String? = null,
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val scrollerCategory: C?,
    val format: IPrintExportFormat,
    val availableFormats: List<IPrintExportFormat>,
    override val preExecution: () -> T,
    val getExpFileName: (T) -> String,
    var getExpFileContentFunc: (T) -> List<String>,
    val additionalChecks: (dto: T, actContent: String) -> Unit = { _: T, _: String -> },
    val action: String = "Печатать"
) : AbstractTest<T, Unit>(
    name = testName ?: "$entityName. Проверка наличия реквизитов в ПФ. (из скроллера).[${format.description}]. [${user.userType}]",
    preExecution = preExecution
) {
    override fun execution(preconditionResult: T?) {
        val dto = preconditionResult!!
        scrollerPage.openScrollerBy(user, dto.customerId!!)
        scrollerCategory?.let { scrollerPage.openTab(scrollerCategory) }
        val row = scrollerPage.findDocumentRowByNumber(dto.documentNumber)
        row.makeActionByMoreMenu(action)
        printSingleDocCheck(dto, format, availableFormats, getExpFileName, getExpFileContentFunc, additionalChecks)
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to preconditionResult!!)
    }
}

/**
 * В предусловии необходимо убедиться, что в системе есть минимум 2 документа в нужном статусе (например Received) для одного клиента.
 * Передавать в тест из предусловия документы - очень нестабильно, т.к. порядок сортировки через API может отличатся от UI.
 * Поэтому мы выбираем 2 первых попавшихся документа на скроллере в этом статусе,
 * и для проверки содержимого получаем его для документов через API по ID'шникам выбранных документов.
 *
 * @param getExpTableContentFunc - принимает на вход [docCount] кол-во ID документов и возвращает список ожидаемых в реестре строк.
 * @param preExecution - возвращает customerId [UUID] для которого есть минимум 2 документа в нужном статусе.
 */
open class UiScrollerPrintTableTestTemplate<S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>, C : ScrollerCategory>(
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val scrollerCategory: C?,
    val searchStatus: String,
    val printFormat: IPrintExportFormat,
    val printAvailableFormats: List<IPrintExportFormat>,
    override val preExecution: () -> UUID,
    val getExpFileName: () -> Regex,
    var getExpTableContentFunc: (List<UUID>) -> List<String>,
    val action: String = "Печатать реестр",
    val docCount: Int = 2
) : AbstractTest<UUID, Unit>(
    name = "$entityName. Проверка наличия реквизитов. Печать реестра. [${printFormat.description}]. [${user.userType}]",
    preExecution = preExecution
) {
    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_CUSTOMER_ID to preconditionResult!!)
    }

    override fun execution(preconditionResult: UUID?) {
        val customerId = preconditionResult!!
        scrollerPage.openScrollerBy(user, customerId)

        // TODO Sergeyev [2020.11.03]: \/ нужно больше проверки на разных типах документов
        // * идёт смешение кейсов "на скроллере только одна категория" и "для скроллера не предусмотрена фильтрация по статусам"
        val rows = scrollerCategory
            ?.let {
                scrollerPage.openTab(scrollerCategory)
                scrollerPage.selectDocumentsByStatus(searchStatus, docCount)
            }
            ?: scrollerPage.scroller.selectRows(docCount)

        val actIds = rows.map { UUID.fromString(it.id) }

        scrollerPage.makeAction(action)

        "Открылась форма Настройки печати"{
            CommonSections.modalPrintDocument.checkHeader()
            CommonSections.modalPrintDocument.checkAvailableFormats(printAvailableFormats.map { it.description })
        }

        CommonSections.modalPrintDocument.printFormat.select(printFormat.description)
        CommonSections.modalPrintDocument.printBtn.click()

        //TODO A.Stykalin [07.10.2020] Не реализованы push-уведомления на UI. Исправить после "дельты" аналитики и реализации на UI.
        checkPushMessage("Отправлен на печать реестр для $docCount документов")

        val expContent: List<String> = getExpTableContentFunc(actIds).attachToAllure("expContent")
        val actContent: String = if (printFormat.format == PrintExportFormat.HTML) {
            BrowserHelper.switchToNextTab()
            BrowserHelper.getPageText()
        } else {
            val expFileNameRegex = getExpFileName().toPattern()
            val actDownloadedFileName: String = BrowserHelper.getLastDownloadedFileName()

            assertThat("Наименование файла не соответствует ожидаемому", actDownloadedFileName, matchesRegex(expFileNameRegex))

            val downloadedFile = UiHelper.getDownloadedFile(actDownloadedFileName)
            val parser = ParserFacade.getParserByFormat(printFormat.format)
            parser.parseContent(downloadedFile.readBytes(), " ")
        }.attachToAllure("actContext")

        "Проверить соответствие содержания ПФ реестра" {
            expContent.forEach { assertThat("В документе нет строки '$it'", actContent.contains(it)) }
        }
    }
}

open class UiScrollerPrintTableMultiplePageTestTemplate<S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>, C : ScrollerCategory>(
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val scrollerCategory: C?,
    val printFormat: IPrintExportFormat,
    override val preExecution: () -> UUID,
    var getExpTableContentFunc: () -> List<String>,
    val action: String = "Печатать реестр"
) : AbstractTest<UUID, Unit>(
    name = "$entityName. Проверка наличия реквизитов. Печать реестра. [${printFormat.description}]. 2 и более страницы. [${user.userType}]",
    preExecution = preExecution
) {
    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_CUSTOMER_ID to preconditionResult!!)
    }

    override fun execution(preconditionResult: UUID?) {
        val customerId = preconditionResult!!
        scrollerPage.openScrollerBy(user, customerId)
        scrollerCategory?.let { scrollerPage.openTab(scrollerCategory) }
        scrollerPage.scroller.selectAll()
        scrollerPage.makeAction(action)
        CommonSections.modalPrintDocument.checkHeader()
        CommonSections.modalPrintDocument.printFormat.select(printFormat.description)
        CommonSections.modalPrintDocument.printBtn.click()

        val expContent: List<String> = getExpTableContentFunc().attachToAllure("expContent")
        val actContent: String = if (printFormat.format == PrintExportFormat.HTML) {
            scrollerPage.loader.shouldNot(Condition.visible)
            BrowserHelper.switchToNextTab()
            BrowserHelper.getPageText()
        } else {
            val actDownloadedFileName: String = BrowserHelper.getLastDownloadedFileName()
            val downloadedFile = UiHelper.getDownloadedFile(actDownloadedFileName)
            val parser = ParserFacade.getParserByFormat(printFormat.format)
            parser.parseContent(downloadedFile.readBytes(), " ")
        }.attachToAllure("actContext")

        "Проверить соответствие содержания ПФ реестра" {
            expContent.forEach { assertThat("В документе нет строки '$it'", actContent.contains(it)) }
        }
    }
}