package ooo.jtc.random

import com.mifmif.common.regex.Generex
import ooo.jtc.extensions.postgresFormat
import java.math.BigDecimal
import java.time.LocalDate
import kotlin.random.Random

/**
 * Maximum supported length for [String] generation.
 * [Generex] fails to generate long [String] with provided patterns (StackOverflowError).
 */
const val GENEREX_MAX_LENGTH = 4100

/**
 * Wrapper for a random generating data by [Generex].
 * Used for handling generated data.
 */
class RandomData(val generex: Generex) {
    constructor(regex: String) : this(Generex(regex))

    companion object {
        val allAllowedChars = builder().withAllAllowedCharacters().build()
        val digits = RandomData(Generex("\\d*"))
        val invalidChars = RandomData(Generex("[☺ゑїöæù]*"))
        val latinWord = RandomData(Generex("[a-zA-Z]*"))
        val ruWords = RandomData(Generex("[а-яА-Я ]*"))
        val regexWord = RandomData(Generex("\\w*"))
        val regexWords = RandomData(Generex("(\\w| )*"))

        fun getEmptyString(length: Int): String {
            val spaceChars = arrayOf(' ', '\t', '\b', '\r', '\n')
            return (1..length)
                .map { spaceChars.random() }
                .joinToString("")
        }

        fun builder(): Builder {
            return Builder()
        }

        class Builder {

            companion object {
                private val latinCapitalLetters = "A-Z"
                private val latinSmallLetters = "a-z"
                private val latinAlphabet = latinCapitalLetters + latinSmallLetters

                private val russianCapitalLetters = "А-Я"
                private val russianSmallLetters = "а-я"
                private val russianAlphabet = russianCapitalLetters + russianSmallLetters

                private val digits = "0-9"
                private val specialCharacters =
                    "\\ \\!\\\"\\#\\\$\\%\\&\\'\\(\\)\\*\\+\\,\\-\\.\\/\\:\\;\\<\\=\\>\\?\\@\\[\\]\\^\\_\\`\\{\\|\\}\\~\\№"

                private val allCharacters = latinAlphabet + russianAlphabet + digits + specialCharacters
            }

            private var chars: StringBuilder = StringBuilder()

            private fun appendIfNotPresent(chars: String): Builder {
                if (!this.chars.contains(chars)) {
                    this.chars.append(chars)
                }
                return this
            }

            fun withLatinAlphabet(): Builder {
                return appendIfNotPresent(latinAlphabet)
            }

            fun withLatinCapitalLetters(): Builder {
                return appendIfNotPresent(latinCapitalLetters)
            }

            fun withLatinSmallLetters(): Builder {
                return appendIfNotPresent(latinSmallLetters)
            }

            fun withRussianAlphabet(): Builder {
                return appendIfNotPresent(russianAlphabet)
            }

            fun withRussianCapitalLetters(): Builder {
                return appendIfNotPresent(russianCapitalLetters)
            }

            fun withRussianSmallLetters(): Builder {
                return appendIfNotPresent(russianSmallLetters)
            }

            fun withDigits(): Builder {
                return appendIfNotPresent(digits)
            }

            fun withSpecialCharacters(): Builder {
                return appendIfNotPresent(specialCharacters)
            }

            fun withAllAllowedCharacters(): Builder {
                return appendIfNotPresent(allCharacters)
            }

            fun build(): RandomData {
                if (chars.isNotEmpty()) {
                    return RandomData(Generex("[$chars]*"))
                }
                throw RuntimeException("Neither character set, nor custom pattern wasn't set for RandomData.")
            }
        }
    }

    fun random(length: Int, prefix: String = "", postfix: String = ""): String {
        return random(length, length, prefix, postfix)
    }

    fun random(minLength: Int = 0, maxLength: Int = GENEREX_MAX_LENGTH, prefix: String = "", postfix: String = ""): String {
        if (minLength > maxLength)
            throw RuntimeException("minLength should be less or equal to maxLength.")
        if (minLength < 0)
            throw RuntimeException("Minimum supported length is 0, but '$minLength' provided.")
        if (maxLength > GENEREX_MAX_LENGTH)
            throw RuntimeException("Maximum supported length is limited to 4100 (provided value: '$maxLength') due to Generex library limitation.")

        val generationMinLength = getGenerationLength(minLength, prefix, postfix)
        val generationMaxLength = getGenerationLength(maxLength, prefix, postfix)
        var result = generex.random(generationMinLength, generationMaxLength).postgresFormat()

        // Append additional characters if postgresFormat() cuts down generated string
        //todo если result = "" то приводит к ошибке. Доработать
        if (result.length < generationMinLength) {
            result += result.first { it != '_' && it != ' ' && it != '\t' && it != '\n' && it != '\r' && it != '\b' }
                .toString().repeat(generationMinLength - result.length)
        }

        return prefix + result + postfix
    }

    private fun getGenerationLength(requiredLength: Int, prefix: String, postfix: String): Int {
        val generateLength = requiredLength - prefix.length - postfix.length
        if (generateLength < 0)
            throw IllegalArgumentException("Total length value is too low for specified prefix and suffix.")
        return generateLength
    }

    /**
     * Prepare a big string without postgres formatting. Result string will be a concatenation of
     * multiple substrings. Each substring is [wordLength] symbols.
     *
     * @param desiredMaxLength  max string length. Result length may be less, but it won't be lesser than
     * [desiredMaxLength] - [wordLength]
     * @param wordLength        length of generated substrings of specified [this.generex]
     * @param stringStart       generated string will begin with these symbols. Default - <empty string>
     * @param stringEnd         generated string will end with these symbols. Default - <empty string>
     * @param wordDelimiter     generated substrings will be concatenated via these symbols. Default - ' ' (space)
     */
    fun hugeString(
        desiredMaxLength: Int, wordLength: Int,
        stringStart: String = "", stringEnd: String = "", wordDelimiter: String = " "
    ): String {
        val strGenerateIterations: Int = desiredMaxLength / wordLength
        var resultStr = stringStart
        for (i in 1..strGenerateIterations) {
            resultStr += "$wordDelimiter${generex.random(wordLength, wordLength)}"
        }
        resultStr = resultStr.take(desiredMaxLength - stringEnd.length)
        return resultStr + stringEnd
    }
}

fun Random.nextBigDecimal(min: Double = 0.0, max: Double): BigDecimal =
    nextBigDecimal(BigDecimal(min), BigDecimal(max))

fun Random.nextBigDecimal(
    min: BigDecimal = BigDecimal(0),
    max: BigDecimal = BigDecimal(Integer.MAX_VALUE)
): BigDecimal {
    return min.add(
        BigDecimal(Math.random())
            .multiply(max.subtract(min))
    )
        .setScale(2, BigDecimal.ROUND_HALF_UP)
}

/**
 * Returns random date in range [[initialDate] - [maxMinusDays]; [initialDate] + [maxPlusDays]],
 * bounds included.
 *
 * @param maxMinusDays must be non-negative, if specified
 * @param maxPlusDays must be non-negative, if specified
 */
fun Random.nextLocalDate(
    initialDate: LocalDate = LocalDate.now(),
    maxPlusDays: Long = 0,
    maxMinusDays: Long = 0
): LocalDate {
    return initialDate
        .plusDays(Random.nextLong(1 + maxPlusDays))
        .minusDays(Random.nextLong(1 + maxMinusDays))
}