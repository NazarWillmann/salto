package ooo.jtc.api.common.templates.entity

import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.common.checks.ApiDocumentChecks
import ooo.jtc.api.common.steps.AbstractDocumentSteps
import ooo.jtc.api.common.tests.AbstractBeTest
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.kexensions.getContentAsByteArray
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.parsers.ParserFacade
import ooo.jtc.generic.print.IPrintExportFormat
import ooo.jtc.generic.print.PrintExportFormat
import ooo.jtc.generic.print.PrintParams
import ooo.jtc.interfaces.IDocument
import ooo.jtc.interfaces.UpdateIDocument
import ooo.jtc.scripts.invoke
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalToIgnoringCase
import org.hamcrest.Matchers.matchesRegex

const val PARAM_PRINT_FORMAT = "Формат печати"
const val PARAM_DOCS_TO_PRINT = "Документы для печати"
const val CHECK_FILE_CONTENTS = "Проверить содержимое файла"

/**
 * Test template for checking available document print formats.
 *
 * @param steps - document steps; will be used for calling [getAvailablePrintFormat()]
 * @param expPrintFormats - expected list of available document print formats with descriptions
 */
open class PrintFormatTestTemplate<T : IDocument>(
    var steps: AbstractDocumentSteps<T, out UpdateIDocument<T>>,
    var expPrintFormats: List<IPrintExportFormat>,
    private var checks: ApiDocumentChecks<T> = ApiDocumentChecks()
) : UnitBeTest(
    name = "'${steps.entityName}'. Получить доступные форматы печати документа [${steps.user.userType}]",
    params = { mapOf(PARAM_USER to steps.user, "Ожидаемый список форматов" to expPrintFormats) },
    testBody = {
        val docPrintFormats = steps.getAvailablePrintFormat().list.getOrException()
        checks.checkPrintFormatResponse(docPrintFormats, expPrintFormats)
    }
)

/**
 * Test template for checking available document table print formats.
 *
 * @param steps - document steps; will be used for calling [getAvailablePrintFormatTable()]
 * @param expPrintTableFormats - expected list of available document table print formats with descriptions
 */
open class PrintTableFormatTestTemplate<T : IDocument>(
    var steps: AbstractDocumentSteps<T, out UpdateIDocument<T>>,
    var expPrintTableFormats: List<IPrintExportFormat>,
    private var checks: ApiDocumentChecks<T> = ApiDocumentChecks()
) : UnitBeTest(
    name = "'${steps.entityName}'. Получить доступные форматы печати списка документов [${steps.user.userType}]",
    params = { mapOf(PARAM_USER to steps.user, "Ожидаемый список форматов" to expPrintTableFormats) },
    testBody = {
        val docPrintTableFormats = steps.getAvailablePrintTableFormat().list.getOrException()
        checks.checkPrintFormatResponse(docPrintTableFormats, expPrintTableFormats)
    }
)

/**
 * Test template for checking print-response file name.
 *
 * @param steps - document steps; will be used for calling print method
 * @param printFormat - format for printing documents
 * @param printParams - params for printing documents
 * @param preExecution - function for finding/creating documents for printing
 * @param getExpFileNameFunc - function for computing expected file name
 */
open class PrintSingleDocFileNameTestTemplate<T : IDocument>(
    var steps: AbstractDocumentSteps<T, out UpdateIDocument<T>>,
    var printFormat: PrintExportFormat,
    var printParams: PrintParams,
    override var preExecution: (() -> T)?,
    var getExpFileNameFunc: (T) -> String
) : AbstractBeTest<T, Unit>(
    name = "'${steps.entityName}'. Распечатать один документ" +
            " в формате $printFormat (проверка имени файла) [${steps.user.userType}]",
    params = { mapOf(PARAM_USER to steps.user, PARAM_DOCS_TO_PRINT to it!!, PARAM_PRINT_FORMAT to printFormat) },
    testBody = { doc ->
        val docToPrint = doc!!
        val docId = docToPrint.id!!
        val response = steps.printById(docId, printFormat, printParams)

        val fileName = steps.getFileNameFromResponse(response)
        val expFileName = getExpFileNameFunc.invoke(docToPrint)
        assertThat(
            "Наименование файла соответствует ожидаемому",
            fileName,
            equalToIgnoringCase("${expFileName}.${printFormat.name}")
        )
    }
)

/**
 * Test template for checking print-response file name.
 *
 * @param steps - document steps; will be used for calling print method
 * @param printFormat - format for printing documents
 * @param printParams - params for printing documents
 * @param preExecution - function for finding/creating documents for printing
 * @param getExpFileNameRegexFunc - function for computing expected file name RegEx
 * @param additionalFileNameChecks - additional checks for parsed file name from response
 */
open class PrintMultipleDocsFileNamesTestTemplate<T : IDocument>(
    var steps: AbstractDocumentSteps<T, out UpdateIDocument<T>>,
    var printFormat: PrintExportFormat,
    var printParams: PrintParams,
    override var preExecution: (() -> List<T>)?,
    var getExpFileNameRegexFunc: () -> Regex,
    var additionalFileNameChecks: ((String) -> Unit) = {}
) : AbstractBeTest<List<T>, Unit>(
    name = "'${steps.entityName}'. Распечатать несколько документов" +
            " в формате $printFormat (проверка имени файла) [${steps.user.userType}]",
    params = { mapOf(PARAM_USER to steps.user, PARAM_DOCS_TO_PRINT to it!!, PARAM_PRINT_FORMAT to printFormat) },
    testBody = { docList ->
        val docsToPrint = docList!!
        val docsIds = docsToPrint.map { it.id!! }
        val response = steps.printById(docsIds, printFormat, printParams)

        val fileName = steps.getFileNameFromResponse(response)
        val expFileNameRegex = getExpFileNameRegexFunc().toPattern()
        assertThat("Наименование файла соответствует ожидаемому", fileName, matchesRegex(expFileNameRegex))
        additionalFileNameChecks.invoke(fileName)
    }
)

/**
 * Test template for printing a single document in provided print format
 *
 * @param steps - document steps; will be used for calling print method
 * @param printFormat - format for printing a document
 * @param printParams - params for printing a document
 * @param preExecution - function for finding/creating a document for printing
 * @param getExpFileContentFunc - function for computing expected file contents
 * @param additionalContentChecks - additional checks for parsed contents (string)
 */
open class PrintSingleDocumentByIdTestTemplate<T : IDocument>(
    var nameDetails: String,
    var steps: AbstractDocumentSteps<T, out UpdateIDocument<T>>,
    var printFormat: PrintExportFormat,
    var printParams: PrintParams,
    override var preExecution: (() -> T)?,
    var getExpFileContentFunc: (T) -> List<String>,
    var additionalContentChecks: (String) -> Unit = {}
) : AbstractBeTest<T, Unit>(
    name = "'${steps.entityName}'. Распечатать один документ в формате $printFormat$nameDetails [${steps.user.userType}]",
    params = { mapOf(PARAM_USER to steps.user, PARAM_DOCS_TO_PRINT to it!!, PARAM_PRINT_FORMAT to printFormat) },
    testBody = { docDto ->
        val docToPrint = docDto!!
        val response = steps.printById(docToPrint.id!!, printFormat, printParams)

        val content = response.getContentAsByteArray()
        val parser = ParserFacade.getParserByFormat(printFormat)
        val parsedContent = parser.parseContent(content)
        val expContent = getExpFileContentFunc.invoke(docToPrint).attachToAllure("expContent")
        CHECK_FILE_CONTENTS {
            expContent.forEach { assertThat("В документе нет строки '$it'", parsedContent.contains(it)) }
        }
        additionalContentChecks.invoke(parsedContent)
    }
)

/**
 * Test template for printing a number of documents in provided print format
 *
 * @param steps - document steps; will be used for calling print method
 * @param printFormat - file format for printing documents
 * @param printParams - params for printing a document
 * @param preExecution - function for finding/creating documents for print
 * @param getExpFileContentFunc - function for computing expected file contents
 * @param additionalContentChecks - additional checks for parsed contents (string)
 */
open class PrintDocumentsByIdTestTemplate<T : IDocument>(
    var nameDetails: String,
    var steps: AbstractDocumentSteps<T, out UpdateIDocument<T>>,
    var printFormat: PrintExportFormat,
    var printParams: PrintParams,
    override var preExecution: (() -> List<T>)?,
    var getExpFileContentFunc: (List<T>) -> List<String>,
    var additionalContentChecks: ((String) -> Unit) = {}
) : AbstractBeTest<List<T>, Unit>(
    name = "'${steps.entityName}'. Распечатать несколько документов в формате $printFormat$nameDetails [${steps.user.userType}]",
    params = { mapOf(PARAM_USER to steps.user, PARAM_DOCS_TO_PRINT to it!!, PARAM_PRINT_FORMAT to printFormat) },
    testBody = { docList ->
        val docsToPrint = docList!!
        val docsIds = docsToPrint.map { it.id!! }
        val response = steps.printById(docsIds, printFormat, printParams)

        val content = response.getContentAsByteArray()
        val parser = ParserFacade.getParserByFormat(printFormat)
        val parsedContent = parser.parseContent(content)
        val expContent = getExpFileContentFunc.invoke(docsToPrint).attachToAllure("expContent")
        CHECK_FILE_CONTENTS {
            expContent.forEach { assertThat("В документе нет строки '$it'", parsedContent.contains(it)) }
        }
        additionalContentChecks.invoke(parsedContent)
    }
)

/**
 * Test template for printing a documents table in provided print format
 *
 * @param steps - document steps; will be used for calling printTable method
 * @param printFormat - file format for printing documents
 * @param preExecution - function for finding/creating documents for print
 * @param getExpFileContentFunc - function for computing expected file contents
 * @param additionalContentChecks - additional checks for parsed contents (string)
 */
open class PrintDocumentTableByIdTestTemplate<T : IDocument>(
    var nameDetails: String,
    var steps: AbstractDocumentSteps<T, out UpdateIDocument<T>>,
    var printFormat: PrintExportFormat,
    override var preExecution: (() -> List<T>)?,
    var getExpFileContentFunc: (List<T>) -> List<String>,
    var additionalContentChecks: ((String) -> Unit) = {}
) : AbstractBeTest<List<T>, Unit>(
    name = "'${steps.entityName}'. Распечатать реестр документов в формате $printFormat$nameDetails [${steps.user.userType}]",
    params = { mapOf(PARAM_USER to steps.user, PARAM_DOCS_TO_PRINT to it!!, PARAM_PRINT_FORMAT to printFormat) },
    testBody = { docList ->
        val docsToPrint = docList!!
        val docsIds = docsToPrint.map { it.id!! }
        val response = steps.printTableById(docsIds, printFormat)

        val content = response.getContentAsByteArray()
        val parser = ParserFacade.getParserByFormat(printFormat)
        // [2020.08.12]: при печати реестра данные ОДНОГО поля, в зависимости от их длины,
        // могут быть разбиты на несколько строк. Поэтому для реестра в качестве разделителя применяется пробел.
        val parsedContent = parser.parseContent(content, newDelimiter = " ")
        val modifiedParsedContent = printTableParsedContentStringHandling(parsedContent)!!
        val expContent = getExpFileContentFunc.invoke(docsToPrint).attachToAllure("expContent")
        CHECK_FILE_CONTENTS {
            expContent.forEach {
                assertThat("В документе нет строки '$it'", modifiedParsedContent.contains(it))
            }
        }
        additionalContentChecks.invoke(modifiedParsedContent)
    }
)

/**
 * List of transform functions for parsed content of printed documents' table.
 */
private val printTableParsedContentTransform = listOf<(String?) -> String?>(
    { it?.replace("(\\S*)- ".toRegex(), "$1-") }
)

/**
 * Handling for string in printTable tests.
 */
private fun printTableParsedContentStringHandling(expectValue: String?): String? {
    var result = expectValue
    printTableParsedContentTransform.forEach { result = it.invoke(result) }
    return result
}
