package ooo.jtc.letters.model

import ooo.jtc.documents.bankAvailableStatuses
import ooo.jtc.documents.clientAvailableStatuses
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.Category
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.uaa.UserType

enum class LetterToBankCategory(override val category: String) : Category<LetterToBankDto> {
    ALL("All"),
    PROBLEM_COMPLETED("ProblemCompleted"),// supplementary category for 'double counter' implementation
    PROBLEMATIC("Problematic"),
    COMPLETED("Completed"),
    DRAFT("Draft"),
    FOR_SEND("ForSend"),
    FOR_SIGNATURE("ForSignature"),
    IN_PROCESSING("InProcessing"),
    ON_RECEIVE("OnReceive"),
    RECEIVED("Received"),
    ;

    companion object {
        // Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171640
        val clientCategoriesAndStatuses: Map<LetterToBankCategory, List<LetterToBankStatus>> = mapOf(
            DRAFT to listOf(
                LetterToBankStatus.DRAFT
            ),
            FOR_SIGNATURE to listOf(
                LetterToBankStatus.NEW,
                LetterToBankStatus.PARTLY_SIGNED
            ),
            FOR_SEND to listOf(
                LetterToBankStatus.SIGNED
            ),
            IN_PROCESSING to listOf(
                LetterToBankStatus.DELIVERED,
                LetterToBankStatus.FOR_RECEIVING,
                LetterToBankStatus.RECEIVING_ERROR,
                LetterToBankStatus.RECEIVED,
                LetterToBankStatus.IN_PROCESSING
            ),
            PROBLEM_COMPLETED to listOf(
                LetterToBankStatus.WRONG_ESIGNATURE,
                LetterToBankStatus.DETAILS_ERROR,
                LetterToBankStatus.RECALLED
            ),
            COMPLETED to listOf(
                LetterToBankStatus.WRONG_ESIGNATURE,
                LetterToBankStatus.DETAILS_ERROR,
                LetterToBankStatus.RECALLED,
                LetterToBankStatus.PROCESSED
            ),
            ALL to LetterToBankStatus.values.clientAvailableStatuses()
        )

        // Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171783
        val bankCategoriesAndStatuses: Map<LetterToBankCategory, List<LetterToBankStatus>> = mapOf(
            ON_RECEIVE to listOf(
                LetterToBankStatus.DELIVERED,
                LetterToBankStatus.FOR_RECEIVING
            ),
            RECEIVED to listOf(
                LetterToBankStatus.RECEIVED
            ),
            IN_PROCESSING to listOf(
                LetterToBankStatus.IN_PROCESSING
            ),
            COMPLETED to listOf(
                LetterToBankStatus.WRONG_ESIGNATURE,
                LetterToBankStatus.DETAILS_ERROR,
                LetterToBankStatus.RECALLED,
                LetterToBankStatus.PROCESSED
            ),
            PROBLEMATIC to listOf(
                LetterToBankStatus.RECEIVING_ERROR
            ),
            ALL to LetterToBankStatus.values.bankAvailableStatuses()
        )
    }

    override fun getStatuses(userType: UserType): List<LetterToBankStatus> {
        return if (UserType.CLIENT == userType) {
            clientCategoriesAndStatuses[this]
                .getOrException("Среди клиентских категорий нет категории $category")
        } else {
            bankCategoriesAndStatuses[this]
                .getOrException("Среди банковских категорий нет категории $category")
        }
    }
}
