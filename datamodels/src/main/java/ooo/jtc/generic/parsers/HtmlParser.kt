package ooo.jtc.generic.parsers

import io.qameta.allure.Step
import ooo.jtc.logging.LoggerDelegate
import org.jsoup.Jsoup

object HtmlParser : FormatParser() {
    override val log by LoggerDelegate()

    @Step("Получить содержимое HTML как список строк")
    override fun parse(byteArray: ByteArray): List<String> {
        val htmlString = String(byteArray)
        val htmlBody = Jsoup.parse(htmlString).body()
        val htmlSpans = htmlBody.select("span")

        return htmlSpans.map { replaceSymbols(it.text()) }
    }

    @Step("Заменить странные символы")
    private fun replaceSymbols(str: String): String {
        var result = str
        STRANGE_SYMBOLS.forEach { (strangeChar, usualChar) ->
            result = result.replace(strangeChar, usualChar)
        }
        return result
    }

    private val STRANGE_SYMBOLS = mapOf(
        ' ' to ' ' // non-breakable space?
    )
}