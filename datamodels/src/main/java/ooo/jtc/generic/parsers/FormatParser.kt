package ooo.jtc.generic.parsers

import ooo.jtc.allure.attachToAllure
import org.slf4j.Logger

/**
 * General methods for parsing printed and exported documents in different formats.
 * Used as a template for parser classes.
 * Every *Parser class should be set for its format in [ParserFacade]
 */
abstract class FormatParser {
    abstract val log: Logger

    protected abstract fun parse(byteArray: ByteArray): List<String>

    protected fun log(content: List<String>): Unit {
        log.info("Parsed content:\n$content")
        content.attachToAllure("Parsed content")
    }

    fun parseContentToListOfStrings(byteArray: ByteArray): List<String> {
        val parsedContent = parse(byteArray)
        log(parsedContent)
        return parsedContent
    }

    fun parseContent(byteArray: ByteArray, newDelimiter: String = "\n"): String {
        val contentInStrings: List<String> = parseContentToListOfStrings(byteArray)
        return contentInStrings.reduce { s1, s2 ->
            if (isWordDashWrap(s1, newDelimiter)) "$s1$s2"
            else "$s1$newDelimiter$s2"
        }
    }

    /**
     * Check if the word [s1] ends with dash [-] and [newDelimiter] == " ".
     * Then we should skip this [newDelimiter], because it's very likely will affects our expects.
     * e.g.
     * ```
     * s1="Предложения по улучшению WEB-"
     * s2="версии системы"
     * ```
     * If [newDelimiter] == " " then we get "Предложения по улучшению WEB- версии системы",
     * but we expect "Предложения по улучшению WEB-версии системы".
     */
    private val isWordDashWrap: (s1: String, newDelimiter: String) -> Boolean = { s1, newDelimiter ->
        s1.trimEnd().endsWith("-") && newDelimiter == " "
    }
}