package ooo.jtc.api.common.templates.entity

import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.common.checks.ApiDocumentChecks
import ooo.jtc.api.common.steps.AbstractDocumentSteps
import ooo.jtc.api.common.tests.AbstractBeTest
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.kexensions.getContentAsByteArray
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.generic.pageparams.toGetPageRequest
import ooo.jtc.generic.parsers.ParserFacade
import ooo.jtc.generic.print.IPrintExportFormat
import ooo.jtc.generic.print.PrintExportFormat
import ooo.jtc.interfaces.IDocument
import ooo.jtc.interfaces.UpdateIDocument
import ooo.jtc.scripts.invoke
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalToIgnoringCase
import org.hamcrest.Matchers.matchesRegex

const val PARAM_EXPORT_FORMAT = "Формат экспорта"
const val PARAM_DOCS_TO_EXPORT = "Документы для экспорта"

/**
 * Test template for checking available document export formats.
 *
 * @param steps - document steps; will be used for calling [getAvailableExportFormat()]
 * @param expExportFormats - expected list of available document export formats with descriptions
 */
open class ExportFormatTestTemplate<T : IDocument>(
    var steps: AbstractDocumentSteps<T, out UpdateIDocument<T>>,
    var expExportFormats: List<IPrintExportFormat>,
    private var checks: ApiDocumentChecks<T> = ApiDocumentChecks()
) : UnitBeTest(
    name = "'${steps.entityName}'. Получить доступные форматы экспорта документа [${steps.user.userType}]",
    params = { mapOf(PARAM_USER to steps.user, "Ожидаемый список форматов" to expExportFormats) },
    testBody = {
        val docExportFormats = steps.getAvailableExportFormat().list.getOrException()
        checks.checkExportFormatResponse(docExportFormats, expExportFormats)
    }
)

/**
 * Test template for checking export-response file name.
 *
 * @param steps - document steps; will be used for calling export method
 * @param exportFormat - file format for exporting document
 * @param preExecution - function for finding/creating document for export
 * @param getExpFileNameFunc - function for computing expected file name
 */
open class ExportSingleDocFileNameTestTemplate<T : IDocument>(
    var steps: AbstractDocumentSteps<T, out UpdateIDocument<T>>,
    var exportFormat: PrintExportFormat,
    override var preExecution: (() -> T)?,
    var getExpFileNameFunc: (T) -> String
) : AbstractBeTest<T, Unit>(
    name = "'${steps.entityName}'. Экспортировать один документ" +
            " в формате $exportFormat (проверка имени файла) [${steps.user.userType}]",
    params = { mapOf(PARAM_USER to steps.user, PARAM_DOCS_TO_EXPORT to it!!, PARAM_EXPORT_FORMAT to exportFormat) },
    testBody = { doc ->
        val docToExport = doc!!
        val docsIds = docToExport.id!!
        val response = steps.exportById(docsIds, exportFormat)

        val fileName = steps.getFileNameFromResponse(response)
        val expFileName = getExpFileNameFunc.invoke(docToExport)
        assertThat(
            "Наименование файла соответствует ожидаемому",
            fileName,
            equalToIgnoringCase("${expFileName}.${exportFormat.name}")
        )
    }
)

/**
 * Test template for checking export-response file name.
 *
 * @param steps - document steps; will be used for calling export method
 * @param exportFormat - file format for exporting documents
 * @param preExecution - function for finding/creating documents for export
 * @param getExpFileNameRegexFunc - function for computing expected file name RegEx
 * @param additionalFileNameChecks - additional checks for parsed file name from response
 */
open class ExportMultipleDocsFileNamesTestTemplate<T : IDocument>(
    var steps: AbstractDocumentSteps<T, out UpdateIDocument<T>>,
    var exportFormat: PrintExportFormat,
    override var preExecution: (() -> List<T>)?,
    var getExpFileNameRegexFunc: () -> Regex,
    var additionalFileNameChecks: ((String) -> Unit) = {}
) : AbstractBeTest<List<T>, Unit>(
    name = "'${steps.entityName}'. Экспортировать несколько документов" +
            " в формате $exportFormat (проверка имени файла) [${steps.user.userType}]",
    params = { mapOf(PARAM_USER to steps.user, PARAM_DOCS_TO_EXPORT to it!!, PARAM_EXPORT_FORMAT to exportFormat) },
    testBody = { docList ->
        val docsToExport = docList!!
        val docsIds = docsToExport.map { it.id!! }
        val response = steps.exportById(docsIds, exportFormat)

        val fileName = steps.getFileNameFromResponse(response)
        val expFileNameRegex = getExpFileNameRegexFunc.invoke().toString()
        assertThat("Наименование файла соответствует ожидаемому", fileName, matchesRegex(expFileNameRegex))
        additionalFileNameChecks.invoke(fileName)
    }
)

/**
 * Test template for exporting a single document in provided print format
 *
 * @param steps - document steps; will be used for calling export method
 * @param exportFormat - file format for exporting a document
 * @param preExecution - function for finding/creating a document for export
 * @param getExpFileContentFunc - function for computing expected file contents
 */
open class ExportSingleDocumentByIdTestTemplate<T : IDocument>(
    var steps: AbstractDocumentSteps<T, out UpdateIDocument<T>>,
    var exportFormat: PrintExportFormat,
    override var preExecution: (() -> T)?,
    var getExpFileContentFunc: (T) -> List<String>
) : AbstractBeTest<T, Unit>(
    name = "'${steps.entityName}'. Экспортировать один документ в формате $exportFormat [${steps.user.userType}]",
    params = { mapOf(PARAM_USER to steps.user, PARAM_DOCS_TO_EXPORT to it!!, PARAM_EXPORT_FORMAT to exportFormat) },
    testBody = { docDto ->
        val docToPrint = docDto!!
        val response = steps.exportById(docToPrint.id!!, exportFormat)

        val content = response.getContentAsByteArray()
        val parser = ParserFacade.getParserByFormat(exportFormat)
        val parsedContent = parser.parseContent(content)
        val expContent = getExpFileContentFunc.invoke(docToPrint).attachToAllure("expContent")
        CHECK_FILE_CONTENTS {
            expContent.forEach { assertThat("В документе нет строки '$it'", parsedContent.contains(it)) }
        }
    }
)

/**
 * Test template for exporting a number of documents in provided print format
 *
 * @param steps - document steps; will be used for calling export method
 * @param exportFormat - file format for exporting documents
 * @param preExecution - function for finding/creating documents for export
 * @param getExpFileContentFunc - function for computing expected file contents
 */
open class ExportDocumentsByIdTestTemplate<T : IDocument>(
    var steps: AbstractDocumentSteps<T, out UpdateIDocument<T>>,
    var exportFormat: PrintExportFormat,
    override var preExecution: (() -> List<T>)?,
    var getExpFileContentFunc: (List<T>) -> List<String>
) : AbstractBeTest<List<T>, Unit>(
    name = "'${steps.entityName}'. Экспортировать несколько документов в формате $exportFormat [${steps.user.userType}]",
    params = { mapOf(PARAM_USER to steps.user, PARAM_DOCS_TO_EXPORT to it!!, PARAM_EXPORT_FORMAT to exportFormat) },
    testBody = { docList ->
        val docsToExport = docList!!
        val docsIds = docsToExport.map { it.id!! }
        val response = steps.exportById(docsIds, exportFormat)

        val content = response.getContentAsByteArray()
        val parser = ParserFacade.getParserByFormat(exportFormat)
        val parsedContent = parser.parseContent(content)
        val expContent = getExpFileContentFunc.invoke(docsToExport).attachToAllure("expContent")
        CHECK_FILE_CONTENTS {
            expContent.forEach { assertThat("В документе нет строки '$it'", parsedContent.contains(it)) }
        }
    }
)

/**
 * Test template for exporting a number of documents in provided print format
 *
 * @param steps - document steps; will be used for calling export method
 * @param exportFormat - file format for exporting documents
 * @param preExecution - function for finding/creating documents for export
 * @param getExpFileContentFunc - function for computing expected file contents
 */
open class ExportDocumentsByFilterTestTemplate<T : IDocument>(
    var nameDetails: String,
    var steps: AbstractDocumentSteps<T, out UpdateIDocument<T>>,
    var filterParams: Params,
    var exportFormat: PrintExportFormat,
    override var preExecution: (() -> List<T>)? = { steps.getPage(filterParams.toGetPageRequest()).page.getOrException() },
    var getExpFileContentFunc: (List<T>) -> List<String>
) : AbstractBeTest<List<T>, Unit>(
    name = "'${steps.entityName}'. Экспортировать документы по фильтру в формате $exportFormat$nameDetails [${steps.user.userType}]",
    params = { mapOf(PARAM_USER to steps.user, PARAM_DOCS_TO_EXPORT to it!!, PARAM_EXPORT_FORMAT to exportFormat) },
    testBody = { docList ->
        val docsToExport = docList!!
        val response = steps.exportByFilter(filterParams, exportFormat)

        val content = response.getContentAsByteArray()
        val parser = ParserFacade.getParserByFormat(exportFormat)
        val parsedContent = parser.parseContent(content)
        val expContent = getExpFileContentFunc.invoke(docsToExport).attachToAllure("expContent")
        CHECK_FILE_CONTENTS {
            expContent.forEach { assertThat("В документе нет строки '$it'", parsedContent.contains(it)) }
        }
    }
)
