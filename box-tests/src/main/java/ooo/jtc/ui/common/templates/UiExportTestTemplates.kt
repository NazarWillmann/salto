package ooo.jtc.ui.common.templates

import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.browser.BrowserHelper
import ooo.jtc.core.elements.scroller.DocumentScroller
import ooo.jtc.core.elements.scroller.DocumentScrollerRow
import ooo.jtc.core.elements.scroller.ExpandedScrollerRow
import ooo.jtc.core.elements.scroller.ScrollerCategory
import ooo.jtc.generic.parsers.ParserFacade
import ooo.jtc.generic.print.IPrintExportFormat
import ooo.jtc.interfaces.IDocument
import ooo.jtc.scripts.invoke
import ooo.jtc.scripts.step
import ooo.jtc.uaa.User
import ooo.jtc.ui.UiHelper
import ooo.jtc.ui.common.actions.UiCommonChecks.checkPushMessage
import ooo.jtc.ui.common.pages.DocumentPage
import ooo.jtc.ui.common.pages.DocumentScrollerPage
import ooo.jtc.ui.common.sections.CommonSections
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import java.util.*

/** Общие действия для проверки экспорта одного документа. */
internal fun <T : IDocument> exportSingleDocCheck(
    entityName: String,
    dto: T,
    exportAvailableFormats: List<IPrintExportFormat>,
    exportFormat: IPrintExportFormat,
    getExpFileName: (T) -> String,
    getExpFileContentFunc: (T) -> List<String>
) {
    "Открылась форма Настройки экспорта"{
        CommonSections.modalExportDocument.checkHeader()
        CommonSections.modalExportDocument.checkAvailableFormats(exportAvailableFormats.map { it.description })
    }

    CommonSections.modalExportDocument.exportFormat.select(exportFormat.description)
    CommonSections.modalExportDocument.exportBtn.click(false)

    //TODO A.Stykalin [05.10.2020] Не реализованы push-уведомления на UI. Исправить после "дельты" аналитики и реализации на UI.
    // checkPushMessage("Документы \"$entityName\" экспортированы")

    val downloadedFile = "Проверить наименование файла" step {
        val expFileName = getExpFileName(dto)
        val downloadedFile = UiHelper.getDownloadedFile(expFileName)
        MatcherAssert.assertThat("Наименование файла не соответствует ожидаемому", downloadedFile.name, Matchers.equalTo(expFileName))
        downloadedFile
    }

    "Проверить, что данные в файле соответствуют документу из предусловия" {
        val expContent = getExpFileContentFunc.invoke(dto).attachToAllure("expContent")
        val parser = ParserFacade.getParserByFormat(exportFormat.format)
        val actContent = parser.parseContent(downloadedFile.readBytes(), " ").attachToAllure("actContext")
        expContent.forEach { MatcherAssert.assertThat("В документе нет строки '$it'", actContent.contains(it)) }
    }
}

open class UiFormExportTestTemplate<T : IDocument, Form : DocumentPage>(
    var entityName: String,
    val user: User,
    val formPage: Form,
    val format: IPrintExportFormat,
    val availableFormats: List<IPrintExportFormat>,
    override val preExecution: (() -> T)?,
    val getExpFileName: (T) -> String,
    var getExpFileContentFunc: (T) -> List<String>,
    val action: String = "Экспортировать"
) : AbstractTest<T, Unit>(
    name = "$entityName. Экспорт документа из формы. [${format.description}]. [${user.userType}]",
    preExecution = preExecution
) {
    override fun execution(preconditionResult: T?) {
        val dto = preconditionResult!!
        formPage.openFormByParams(user = user, documentId = dto.id!!)
        formPage.makeAction(action)
        exportSingleDocCheck(entityName, dto, availableFormats, format, getExpFileName, getExpFileContentFunc)
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to preconditionResult!!)
    }
}

open class UiScrollerExportTestTemplate<T : IDocument,
        S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>, C : ScrollerCategory>(
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val scrollerCategory: C?,
    val format: IPrintExportFormat,
    val availableFormats: List<IPrintExportFormat>,
    override val preExecution: () -> T,
    val getExpFileName: (T) -> String,
    var getExpFileContentFunc: (T) -> List<String>,
    val action: String = "Экспортировать"
) : AbstractTest<T, Unit>(
    name = "$entityName. Экспорт документа из скроллера (меню строки). [${format.description}]. [${user.userType}]",
    preExecution = preExecution
) {
    override fun execution(preconditionResult: T?) {
        val dto = preconditionResult!!
        scrollerPage.openScrollerBy(user, dto.customerId!!)
        scrollerCategory?.let { scrollerPage.openTab(it) }
        val row = scrollerPage.findDocumentRowByNumber(dto.documentNumber)
        row.makeActionByMoreMenu(action)
        exportSingleDocCheck(entityName, dto, availableFormats, format, getExpFileName, getExpFileContentFunc)
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to preconditionResult!!)
    }
}

open class UiScrollerExportExpandPanelTestTemplate<T : IDocument,
        S : DocumentScrollerPage<out DocumentScroller<out ExpandedScrollerRow>, ExpandedScrollerRow, C, *>, C : ScrollerCategory>(
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val scrollerCategory: C,
    val format: IPrintExportFormat,
    val availableFormats: List<IPrintExportFormat>,
    override val preExecution: () -> T,
    val getExpFileName: (T) -> String,
    var getExpFileContentFunc: (T) -> List<String>,
    val action: String = "Экспортировать"
) : AbstractTest<T, Unit>(
    name = "$entityName. Экспорт документа из скроллера (панель быстрого просмотра). [${format.description}]. [${user.userType}]",
    preExecution = preExecution
) {
    override fun execution(preconditionResult: T?) {
        val dto = preconditionResult!!
        scrollerPage.openScrollerBy(user, dto.customerId!!)
        scrollerPage.openTab(scrollerCategory)
        val row = scrollerPage.findDocumentRowByNumber(dto.documentNumber)

        row.makeActionByExpandPanel(action)
        exportSingleDocCheck(entityName, dto, availableFormats, format, getExpFileName, getExpFileContentFunc)
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to preconditionResult!!)
    }
}

open class UiScrollerExportGroupTestTemplate<S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>, C : ScrollerCategory>(
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val scrollerCategory: C?, //Если на скроллере нет категорий, то `scrollerCategory=null`
    val format: IPrintExportFormat,
    val availableFormats: List<IPrintExportFormat>,
    override val preExecution: () -> UUID,
    val getExpFileName: () -> Regex,
    var getExpTableContentFunc: (List<UUID>) -> List<String>,
    val action: String = "Экспортировать",
    val docCount: Int = 2
) : AbstractTest<UUID, Unit>(
    name = "$entityName. Экспорт документа из скроллера (групповое действие). [${format.description}]. [${user.userType}]",
    preExecution = preExecution
) {
    override fun execution(preconditionResult: UUID?) {
        val customerId = preconditionResult!!
        scrollerPage.openScrollerBy(user, customerId)
        scrollerCategory?.let { scrollerPage.openTab(it) }
        val rows = scrollerPage.scroller.selectRows(docCount)
        val actIds = rows.map { UUID.fromString(it.id) }

        scrollerPage.makeAction(action)

        "Открылась форма Настройки экспорта"{
            CommonSections.modalExportDocument.checkHeader()
            CommonSections.modalExportDocument.checkAvailableFormats(availableFormats.map { it.description })
        }

        CommonSections.modalExportDocument.exportFormat.select(format.description)
        CommonSections.modalExportDocument.exportBtn.click(false)

        //TODO A.Stykalin [05.10.2020] Не реализованы push-уведомления на UI. Исправить после "дельты" аналитики и реализации на UI.
        checkPushMessage("Экспортировано $docCount документа")

        val actDownloadedFileName = "Проверить наименование файла" step {
            val expFileNameRegex = getExpFileName().toPattern()
            val actDownloadedFileName: String = BrowserHelper.getLastDownloadedFileName()

            MatcherAssert.assertThat("Наименование файла не соответствует ожидаемому", actDownloadedFileName, Matchers.matchesRegex(expFileNameRegex))
            actDownloadedFileName
        }

        "Проверить, что данные в файле соответствуют документам выбранным на шаге 2" {
            val expContent: List<String> =
                "Получить содержимое выбранных документов"{ getExpTableContentFunc(actIds).attachToAllure("expContent") }.output!!

            val downloadedFile = UiHelper.getDownloadedFile(actDownloadedFileName)
            val parser = ParserFacade.getParserByFormat(format.format)
            val actContent: String = parser.parseContent(downloadedFile.readBytes(), " ").attachToAllure("actContext")

            expContent.forEach { MatcherAssert.assertThat("В документе нет строки '$it'", actContent.contains(it)) }
        }
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to preconditionResult!!)
    }
}