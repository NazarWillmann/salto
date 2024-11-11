package ooo.jtc.extensions

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols


const val DEFAULT_NUMBER_PATTERN = ",##0.00"
const val ANTIE_NUMBER_PATTERN = ",##0"
const val DEFAULT_DIGIT_GROUP_DELIMITER = ' '
const val DEFAULT_DECIMAL_DELIMITER = '.'

/**
 * Convert number for need format.
 *
 * @param format return format.
 * @param groups discharge delimiter.
 * @param decimal decimal delimiter.
 * @return value in needed format.
 *
 * @see DecimalFormat
 * @see DecimalFormatSymbols
 */
fun BigDecimal.formatNumber(
    format: String = DEFAULT_NUMBER_PATTERN,
    groups: Char = DEFAULT_DIGIT_GROUP_DELIMITER,
    decimal: Char = DEFAULT_DECIMAL_DELIMITER
): String = DecimalFormat(format, DecimalFormatSymbols().apply {
    groupingSeparator = groups
    decimalSeparator = decimal
}).format(this)
