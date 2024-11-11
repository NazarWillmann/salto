package ooo.jtc.random

object ValidateUtils {

    fun checkCalcKey(bic: String?, number: String, rkcFlag: Boolean): String? {
        if (bic == null || bic.length != ValidateConstants.BIC_LENGTH) {
            return null
        }
        val code = if (rkcFlag) "0" + bic.substring(
            ValidateConstants.RKC_IND_BEGIN,
            ValidateConstants.RKC_IND_END
        ) else bic.substring(ValidateConstants.BANK_IND_BEGIN, ValidateConstants.BANK_IND_END)
        val key = calcKey(code, number)
        val keyAcc = number.substring(ValidateConstants.KEY_IND_BEGIN, ValidateConstants.KEY_IND_END)
        return if (key == keyAcc) null else key
    }

    private fun calcKey(code: String, number: String): String {
        val num = code + number
        var sum = 0
        for (i in ValidateConstants.ACCOUNT_KOEF.indices) {
            if (i == ValidateConstants.KEY_IND2_KEY) {
                // если разряд ключа, считаем, что он == 0
                continue
            }
            var c = Character.getNumericValue(num[i])
            c = c * ValidateConstants.ACCOUNT_KOEF[i] % 10
            sum += c
        }
        sum = sum % 10 * 3 % 10
        return sum.toString()
    }


    fun checkInn(innStr: String): Boolean {
        val valid: Boolean
        val inn = innStr.toCharArray().map { Character.getNumericValue(it) }
        valid = when (inn.size) {
            12 -> {
                val n1 = getChecksum(inn, ValidateConstants.INN_MULT_N1)
                val n2 = getChecksum(inn, ValidateConstants.INN_MULT_N2)
                inn[inn.size - 1] == n2 && inn[inn.size - 2] == n1
            }
            10 -> {
                val n = getChecksum(inn, ValidateConstants.INN_MULT_N)
                inn[inn.size - 1] == n
            }
            else -> false
        }
        return valid
    }

    fun getChecksum(digits: List<Int>, multipliers: Array<Int>): Int {
        var checksum = 0
        for (i in multipliers.indices) {
            checksum += digits[i] * multipliers[i]
        }
        return checksum % 11 % 10
    }
}

object ValidateConstants{
    const val BIC_LENGTH = 9
    const val NUMBER_LENGTH = 20

    const val BANK_IND_BEGIN = 6
    const val BANK_IND_END = 9
    const val RKC_IND_BEGIN = 4
    const val RKC_IND_END = 6
    const val KEY_IND_BEGIN = 8
    const val KEY_IND_END = 9
    const val KEY_IND2_KEY = KEY_IND_BEGIN + (BANK_IND_END - BANK_IND_BEGIN)
    val BIC_RKC_SUFFIX = listOf("000", "001", "002")

    val ACCOUNT_KOEF = intArrayOf(7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1)

    val INN_MULT_N = arrayOf(2, 4, 10, 3, 5, 9, 4, 6, 8)
    val INN_MULT_N1 = arrayOf(7, 2, 4, 10, 3, 5, 9, 4, 6, 8)
    val INN_MULT_N2 = arrayOf(3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8)
}