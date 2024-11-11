package ooo.jtc.generic.parsers

import ooo.jtc.generic.print.PrintExportFormat

object ParserFacade {
    fun getParserByFormat(format: PrintExportFormat): FormatParser {
        return when (format) {
            PrintExportFormat.HTML -> HtmlParser
            PrintExportFormat.PDF -> PdfParser
            PrintExportFormat.RTF -> RtfParser

            // TODO [Sergeyev]: Привести все в соответствие с ТЗ архитектуры
            //  https://confluence.jtc.ooo/pages/viewpage.action?pageId=21727649 и соседние
            PrintExportFormat.CSV -> CsvParser
            PrintExportFormat.XLSX -> XlsxParser
            PrintExportFormat.XML -> XmlParser
        }
    }
}