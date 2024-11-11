package ooo.jtc.letters.model

import ooo.jtc.generic.print.StampResult

/**
 * Relation between a status [LetterToBankStatus] and a stamp result [stampResult] at print form.
 * https://confluence.jtc.ooo/pages/viewpage.action?pageId=21729817
 */
enum class LetterToBankStampResult(override val stampResult: String, override val statuses: List<LetterToBankStatus>) :
    StampResult<LetterToBankStatus> {
    RECEIVED("ПРИНЯТО", listOf(LetterToBankStatus.RECEIVED, LetterToBankStatus.IN_PROCESSING)),
    REJECTED("ОТКАЗАНО", listOf(LetterToBankStatus.WRONG_ESIGNATURE, LetterToBankStatus.DETAILS_ERROR)),
    PROCESSED("ОБРАБОТАНО", listOf(LetterToBankStatus.PROCESSED)),
    RECALLED("ОТОЗВАНО", listOf(LetterToBankStatus.RECALLED));
}