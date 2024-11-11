package ooo.jtc.generic.parsers

import io.qameta.allure.Step
import ooo.jtc.logging.LoggerDelegate
import java.io.ByteArrayInputStream
import javax.swing.text.Document
import javax.swing.text.rtf.RTFEditorKit

object RtfParser : FormatParser() {
    override val log by LoggerDelegate()
    private const val LINE_START = "fLine0" // TODO: проверить на бОльших наборах данных

    @Step("Получить содержимое RTF как список строк")
    override fun parse(byteArray: ByteArray): List<String> {
        val rtfParser = RTFEditorKit()
        val document: Document = rtfParser.createDefaultDocument()
        rtfParser.read(ByteArrayInputStream(byteArray), document, 0)
        val text: String = document.getText(0, document.length)
        val splitContent = text.lines()
        return removeRtfInfo(splitContent)
    }

    private fun removeRtfInfo(strings: List<String>): List<String> {
        return strings
            .map {
                val textStartPosition = it.lastIndexOf(LINE_START) + LINE_START.length
                if (LINE_START.length < textStartPosition) {
                    it.substring(startIndex = textStartPosition)
                } else it
            }
    }
}