package ooo.jtc.random

import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.RandomData.Companion.latinWord
import ooo.jtc.random.RandomData.Companion.regexWord
import java.time.LocalDate
import kotlin.math.roundToLong
import kotlin.random.Random

/**
 * RandomRequisites - generators for account, inn, ogrn, kpp, etc.
 *
 * @author Aleksandr_Stykalin
 */
object RandomRequisites {

    /**
     * Сгенерировать БИК РФ
     */
    fun generateBic(): String = "04${digits.random(7, 7)}"

    /**
     * Сгенерировать случайный ОКПО для ИП
     */
    fun generateOkpoForIp(): String = digits.random(10, 10)

    /**
     * Сгенерировать случайный ОКПО для ЮЛ
     */
    fun generateOkpoForUl(): String = digits.random(8, 8)

    /**
     * Сгенерировать случайный номер Документа, удостоверяющего личность
     */
    fun generateIdentityDocumentNumber(): String = digits.random(14, 14)

    /**
     * Сгенерировать email по шаблону "<случайная строка>_at@[lowerLvlDomain].[rootDomain]"
     */
    fun generateEmail(lowerLvlDomain: String = "jtc-at", rootDomain: String = "ooo"): String =
        regexWord.random(8, 10) + "_at@$lowerLvlDomain.$rootDomain"


    private fun calculateAccountKey(bic: String?, number: String): String? {
        return bic?.let {
            val code = it.substring(ValidateConstants.BANK_IND_BEGIN, ValidateConstants.BANK_IND_END)
            if (ValidateConstants.BIC_RKC_SUFFIX.contains(code))
                ValidateUtils.checkCalcKey(bic, number, true)  // по 5, 6 символам (РКЦ)
            else
                ValidateUtils.checkCalcKey(bic, number, false) // по 7, 8, 9 символам (Идентификатор банка)
        }
    }

    /**
     * Сгенерировать номер телефона без маски с кодом страны, в формате +71234567890.
     */
    fun generatePhoneNumber(countryCode: String = "+7"): String {
        return "$countryCode${digits.random(10, 10)}"
    }

    /**
     * Генерирует 20-ти значный расчетный счет с проверкой ключевания.
     *
     * @param balanceAccount - балансовый счет второго порядка (5 цифр).
     * @param currency       - международный код валюты (3 цифры). Для рублей - 810.
     * @param bic            - БИК банка, к которому привязан счет.
     */
    fun generateAccountNumber(
        balanceAccount: String,
        currency: String,
        bic: String?
    ): String {
        val generatedAccNumber = balanceAccount + currency + digits.random(12, 12)
        val correctKey: String = calculateAccountKey(bic, generatedAccNumber) ?: return generatedAccNumber
        return generatedAccNumber.substring(0, 8) + correctKey + generatedAccNumber.substring(9, 20)
    }

    /**
     * Генерирует 20-ти значный корреспондентский счет банка с проверкой ключевания.
     *
     * @param corrAccount - корреспондентский счет второго порядка (5 цифр).
     * @param currency    - международный код валюты (3 цифры). Для рублей - 810.
     * @param bic         - БИК банка.
     * @param bicRkc      - БИК расчётно-кассового центра, в котором обслуживается банк. Для ЦБ РФ - 044536002.
     */
    fun generateCorrAccountNumber(
        corrAccount: String,
        currency: String,
        bic: String,
        bicRkc: String? = "044536002"
    ): String {
        val generatedAccNumber = corrAccount + currency + digits.random(9, 9) + bic.takeLast(3)
        val correctKey: String = calculateAccountKey(bicRkc, generatedAccNumber) ?: return generatedAccNumber
        return generatedAccNumber.substring(0, 8) + correctKey + generatedAccNumber.substring(9, 20)
    }

    /**
     * Сгенерировать 10-значный ИНН для ЮЛ.
     */
    fun generateInnForUl(): String {
        var innStr: String = digits.random(10, 10)
        if (!ValidateUtils.checkInn(innStr)) {
            val checksumNumber: Int = ValidateUtils.getChecksum(
                innStr.toCharArray().map { it - '0' },
                ValidateConstants.INN_MULT_N
            )
            innStr = innStr.substring(0, 9) + checksumNumber
        }
        return innStr
    }

    /**
     * Сгенерировать невалидный 10-значный ИНН для ЮЛ.
     */
    fun generateIncorrectInnForUl(): String {
        var innStr: String = digits.random(10, 10)
        while (ValidateUtils.checkInn(innStr)) {
            innStr = digits.random(10, 10)
        }
        return innStr
    }

    /**
     * Сгенерировать 12-значный ИНН для ИП.
     */
    fun generateInnForIp(): String {
        var innStr: String
        var n1: Int
        var n2: Int
        var inn: List<Int>
        do {
            innStr = digits.random(12, 12)
            inn = innStr.toCharArray().map { it - '0' }
            n1 = ValidateUtils.getChecksum(inn, ValidateConstants.INN_MULT_N1)
            n2 = ValidateUtils.getChecksum(inn, ValidateConstants.INN_MULT_N2)
        } while (!(inn[inn.size - 1] == n2 && inn[inn.size - 2] == n1))
        return innStr
    }

    /**
     * Сгенерировать 12-значный ИНН персоны.
     */
    fun generateInnPerson(): String {
        var innStr: String
        var n1: Int
        var n2: Int
        var inn: List<Int>
        do {
            innStr = digits.random(12, 12)
            inn = innStr.toCharArray().map { it - '0' }
            n1 = ValidateUtils.getChecksum(inn, ValidateConstants.INN_MULT_N1)
            n2 = ValidateUtils.getChecksum(inn, ValidateConstants.INN_MULT_N2)
        } while (!(inn[inn.size - 1] == n2 && inn[inn.size - 2] == n1))
        return innStr
    }

    /**
     * Сгенерировать невалидный 12-значный ИНН для ИП.
     */
    fun generateIncorrectInnForIp(): String {
        var innStr: String = digits.random(12, 12)
        while (ValidateUtils.checkInn(innStr)) {
            innStr = digits.random(12, 12)
        }
        return innStr
    }

    /**
     * Сгенерировать 5-значный КИО для ЮЛ.
     */
    fun generateKio(): String = digits.random(5, 5)

    /**
     * Сгенерировать 9-значный КПП для ЮЛ.
     */
    fun generateKpp(): String = digits.random(9, 9)

    /**
     * Сгенерировать 13-значный ОГРН для ЮЛ.
     */
    fun generateOgrnUl(): String {
        // для ОГРН первой цифрой может быть 1 или 5
        val mainPart = ((500 + LocalDate.now().year % 100 + Math.random()) * 1000000000L).roundToLong()
        val control = mainPart % 11 % 10
        return mainPart.toString() + control
    }

    /**
     * Сгенерировать 15-значный ОГРНИП для ИП.
     */
    fun generateOgrnIp(): String {
        // для ОГРНИП первой цифрой должна быть 3
        val mainPart = ((300 + LocalDate.now().year % 100 + Math.random()) * 100000000000L).roundToLong()
        val control = mainPart % 13 % 10
        return mainPart.toString() + control
    }

    /**
     * Сгенерировать 11-значный СНИЛС РФ.
     */
    fun generateSnils(): String {
        val resultInn = StringBuilder()
        var digit = Random.nextInt(9) + 1
        var control = digit * 9
        resultInn.append(digit)
        for (i in 8 downTo 1) {
            digit = (Math.random() * 10).toInt()
            control += digit * i
            resultInn.append(digit)
        }
        control = control % 101 % 100
        resultInn.append(control / 10) // если так не делать, то нули могут
        resultInn.append(control % 10) // потеряться в случаях 00 -> 09
        return resultInn.toString()
    }

    /**
     * Сгенерировать 11-значный SWIFT
     */
    fun generateSwift(): String {
        // TODO Sergeyev [2021.01.12]: this
        return (latinWord.random(5, 5) + digits.random(3, 3) + latinWord.random(3, 3))
            .toUpperCase()
    }

    /**
     * Сгенерировать 8-значный SWIFT
     */
    fun generateHeadSwift(): String {
        // TODO Sergeyev [2021.01.12]: this
        return (regexWord.random(5, 5) + digits.random(3, 3))
            .toUpperCase()
    }

    /**
     * Сгенерировать 5-значный ОКОПФ
     */
    fun generateOkopf(): String {
        return (digits.random(5, 5))
    }

    /**
     * Сгенерировать 2-значный ОКФС
     */
    fun generateOkfs(): String {
        return (digits.random(2, 2))
    }
}

