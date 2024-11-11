package ooo.jtc.generic.parsers

import io.qameta.allure.Step
import ooo.jtc.logging.LoggerDelegate
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import java.io.IOException

object PdfParser : FormatParser() {
    override val log by LoggerDelegate()

    @Step("Получить содержимое PDF как список строк")
    override fun parse(byteArray: ByteArray): List<String> {
        try {
            val document = PDDocument.load(byteArray)
            val content = PDFTextStripper().getText(document)
            document.close()
            return content.lines()
        } catch (ioEx: IOException) {
            throw RuntimeException("Ошибка парсинга pdf", ioEx)
        }
    }
}