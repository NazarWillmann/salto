package ooo.jtc.letters.model

import ooo.jtc.generic.print.IPrintExportFormat
import ooo.jtc.generic.print.PrintExportFormat

/**
 * Letter to bank print formats.
 * 'desc' values are based on
 * https://confluence.jtc.ooo/pages/viewpage.action?pageId=21725845
 * https://confluence.jtc.ooo/pages/viewpage.action?pageId=21725847
 * https://confluence.jtc.ooo/pages/viewpage.action?pageId=21725850
 */
enum class LetterToBankPrintExportFormat(
    override val format: PrintExportFormat,
    override val description: String
) : IPrintExportFormat {
    HTML(PrintExportFormat.HTML, "на принтер"),
    PDF(PrintExportFormat.PDF, "в файл pdf"),
    RTF(PrintExportFormat.RTF, "в файл rtf"),

    XLSX(PrintExportFormat.XLSX, "в файл xlsx"),
    XML(PrintExportFormat.XML, "в файл xml"),
    CSV(PrintExportFormat.CSV, "в файл csv"),
    ;

    companion object {
        val printFormats = listOf(HTML, PDF, RTF)
        val printTableFormats = listOf(HTML, PDF, RTF)
        val exportFormats = listOf(CSV, XLSX, XML)
    }
}