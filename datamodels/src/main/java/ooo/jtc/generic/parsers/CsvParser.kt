package ooo.jtc.generic.parsers

import io.qameta.allure.Step
import ooo.jtc.extensions.deduplication
import ooo.jtc.logging.LoggerDelegate

object CsvParser : FormatParser() {
    override val log by LoggerDelegate()

    @Step("Получить содержимое CSV как список строк")
    override fun parse(byteArray: ByteArray): List<String> {
        // Splitting by lines/delimiters and replacing double quotes, applied to parsed [content], are
        // based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21725887
        val content = String(byteArray)

        val elementsDelimiter = ';'
        // split by lines and field delimiters
        val contentEntries = content.lines()
        val contentElements = contentEntries.flatMap { it.split(elementsDelimiter) }

        // remove encasing quotes; replace double quotes
        return contentElements.map {
            it
                    .removeSurrounding("\"")
                    .deduplication("\"", 2)
        }
    }
}