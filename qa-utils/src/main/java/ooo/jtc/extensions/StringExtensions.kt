package ooo.jtc.extensions

import java.util.*
import kotlin.random.Random

val String.humanize: String get() = replace("(?<=[A-Z])(?=[A-Z][a-z])|(?<=[^A-Z])(?=[A-Z])|(?<=[A-Za-z])(?=[^A-Za-z])".toRegex(), " ").capitalize()

/**
 * If string longer than [n], we take first [n] characters and add ellipsis points at the end.
 */
fun String.ellipsis(n: Int): String {
    if (this.length > n) return this.take(n).plus("...")
    return this
}

/**
 * Returns substring with random starting position and length
 */
fun String.randomSubstringPf(): String {
    if (this.isEmpty()) return ""
    val rndStartPosition = Random.nextInt(this.length)
    val rndEndPosition = Random.nextInt(rndStartPosition, this.length)
    val result = this.substring(rndStartPosition, rndEndPosition + 1).postgresFormat()
    if (result.isBlank()) return this.randomSubstringPf()
    return result
}

/**
 * Returns a new string with collapsed duplicated [symbol] (-s) to a single symbol in [this] string.
 *
 * @param symbol - symbol (or symbol sequence) that is duplicated in [this] string
 * @param reduceBatchesBy - size of batch that will be reduced to a single symbol. DEFAULT: [null]
 *
 * How to use:
 * 1) When [reduceBatchesBy] = [null] function collapses whole found batch, no matter its size.
 * E.g., "QQQwertyQQQQQeQQ".deduplication("Q") will result in "QwertyQeQ".
 * 2) When provided a certain number, function will collapse symbols only in batches of specified size.
 * E.g., "QQQwertyQQQQQeQQ".deduplication("Q", 3) will result in "QwertyQQQeQQ".
 *
 */
fun String.deduplication(symbol: String, reduceBatchesBy: Int? = null): String {
    val regexString = reduceBatchesBy
        ?.let { "[$symbol]{$reduceBatchesBy}" }
        ?: "[$symbol]+"
    return this.replace(regexString.toRegex(), symbol)
}

/**
 * Remove duplication of Postgres ignoring symbols.
 * So far, there is only one symbol. But, if necessary, you can add others.
 * e.g. "1_ 2__ 3___ _4_" => "1_ 2_ 3_ _4"
 * removing underscore from begin and end of string
 */
fun String.postgresFormat(): String {
    return this
        .deduplication("_")
        .deduplication(" ")
        .replace("^\\s+".toRegex(), "")
        .replace("\\s+$".toRegex(), "")
        .trim('_')
}

/**
 * Returns new string without space characters
 */
fun String.withoutSpaces(): String {
    return this.replace("\\s".toRegex(), "")
}

/**
 * Returns uuid-string in uuid format.
 */
fun String.toUUID(): UUID {
    return UUID.fromString(this)
}