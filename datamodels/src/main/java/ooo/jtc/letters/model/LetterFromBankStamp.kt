package ooo.jtc.letters.model

import ooo.jtc.generic.print.StampResult

/**
 * Relation between a status [LetterFromBankStatus] and a stamp result [stampResult] at print form.
 * https://confluence.jtc.ooo/pages/viewpage.action?pageId=21729830
 */
enum class LetterFromBankStampResult(override val stampResult: String, override val statuses: List<LetterFromBankStatus>) :
    StampResult<LetterFromBankStatus> {
    REJECTED("ОТКАЗАНО В ОТПРАВКЕ", listOf(LetterFromBankStatus.WRONG_ESIGNATURE, LetterFromBankStatus.DETAILS_ERROR)),
    DELIVERED("ДОСТАВЛЕНО", listOf(LetterFromBankStatus.DELIVERED));
}