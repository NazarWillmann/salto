package ooo.jtc.generic

import io.qameta.allure.Step
import ooo.jtc.documents.IDocumentStatus
import ooo.jtc.documents.getByBankStatus
import ooo.jtc.documents.getByClientStatus
import ooo.jtc.extensions.ANTIE_NUMBER_PATTERN
import ooo.jtc.extensions.formatNumber
import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Converter kotlin code to java for mapping expression in Mapstruct.
 * @see [ooo.jtc.letters.LetterToBankViewMapper]
 */
object KJavaConverter {

    /**
     * Convert 'Draft' to 'Черновик'
     */
    fun <T : IDocumentStatus<*>> convertToStatusClient(values: Array<T>, status: String?): String {
        if (null == status) return ""
        return values.getByClientStatus(status).descriptionClient
    }

    /**
     * Convert 'Draft' to 'Черновик'
     */
    fun <T : IDocumentStatus<*>> convertToStatusBank(values: Array<T>, status: String?): String {
        if (null == status) return ""
        return values.getByBankStatus(status).descriptionBank
    }

    /**
     * Convert 40807810438602823436 to 40807...3436
     */
    fun hiddenMaskAccount(source: String?): String {
        if (source.isNullOrBlank()) return ""
        return "${source.take(5)}...${source.takeLast(4)}"
    }

    fun amountToMaskedString(source: BigDecimal?): String {
        return source?.let { amount(it).formatNumber() } ?: ""
    }

    fun amountToMaskedAntieString(source: BigDecimal?): String {
        return source?.let { amount(it, roundingMode = RoundingMode.DOWN, scale = 0).formatNumber(format = ANTIE_NUMBER_PATTERN) } ?: ""
    }

    /**
     * Convert phone from +71234567890 to ui format `+7 (123) 456 - 78 - 90`
     */
    @Step("Добавить маску номеру телефона ({source}) для UI")
    fun getUiMaskedPhone(source: String?): String {
        return StringBuilder(source)
            .insert(10, " - ")
            .insert(8, " - ")
            .insert(5, ") ")
            .insert(2, " (").toString()
    }
}