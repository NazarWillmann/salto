package ooo.jtc.text

object TextUtils {

    /**
     * Returns one of declension form ([form1]||[form234]||[form567890]) of a word by last digit in [number].
     * e.g. declensionByDigit(2, form1="голубь", form234="голубя", form567890="голубей") => "голубя"
     */
    @Suppress("MoveVariableDeclarationIntoWhen")
    fun declensionByDigit(number: Int, form1: String, form234: String, form567890: String): String {
        val digit = if (number in 11..14) number else number.toString().last().toString().toInt()
        return when (digit) {
            1 -> form1
            2, 3, 4 -> form234
            5, 6, 7, 8, 9, 0, 11, 12, 13, 14 -> form567890
            else -> throw RuntimeException("UnExpected lastNum - $digit")
        }
    }
}