package ooo.jtc.rupayment.model

import ooo.jtc.documents.clientAvailableStatuses
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.Category
import ooo.jtc.rupayment.dto.RuPaymentDto
import ooo.jtc.uaa.UserType

enum class RuPaymentCategory(override val category: String) : Category<RuPaymentDto> {
    ALL("All"),
    DRAFT("Draft"),
    IMPORT_ERROR("ImportError"),
    FOR_SIGNATURE("ForSignature"),
    FOR_SEND("ForSend"),
    IN_PROCESSING("InProcessing"),
    COMPLETED("Completed"),
    PROBLEM_COMPLETED("ProblemCompleted"),
    CARD_INDEX("CardIndex"),
    ;

    companion object {
        // Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171640
        val clientCategoriesAndStatuses: Map<RuPaymentCategory, List<RuPaymentStatus>> = mapOf(
            DRAFT to listOf(RuPaymentStatus.DRAFT),
            IMPORT_ERROR to listOf(RuPaymentStatus.IMPORT_ERROR),

            FOR_SIGNATURE to listOf(
                RuPaymentStatus.NEW,
                RuPaymentStatus.PARTLY_SIGNED
            ),
            FOR_SEND to listOf(
                RuPaymentStatus.SIGNED
            ),
            IN_PROCESSING to listOf(
                RuPaymentStatus.DELIVERED,
                RuPaymentStatus.CORRECT_ESIGNATURE,
                RuPaymentStatus.RECEIVED,
                RuPaymentStatus.PRINTED,
                RuPaymentStatus.FOR_CHECK_E_SIGNATURE_DETAILS,
                RuPaymentStatus.CORRECT_E_SIGNATURE_AFTER_VALUE_DATE,
                RuPaymentStatus.FOR_EXPORT_TO_ABS,
                RuPaymentStatus.EXPORTING_TO_ABS,
                RuPaymentStatus.EXPORT_ABS_ERROR,
                RuPaymentStatus.EXPORTED_TO_ABS,
                RuPaymentStatus.RECEIVED_BY_ABS,
                RuPaymentStatus.WAITING_FOR_VALUE_DATE,
                RuPaymentStatus.OVERDUE_PAYMENTS,
                RuPaymentStatus.PARTLY_EXECUTED
            ),
            COMPLETED to listOf(
                RuPaymentStatus.WRONG_ESIGNATURE,
                RuPaymentStatus.DETAILS_ERROR,
                RuPaymentStatus.RECALLED,
                RuPaymentStatus.NOT_RECEIVED_BY_ABS,
                RuPaymentStatus.DENIED,
                RuPaymentStatus.EXECUTED
            ),
            PROBLEM_COMPLETED to listOf(
                RuPaymentStatus.WRONG_ESIGNATURE,
                RuPaymentStatus.DETAILS_ERROR,
                RuPaymentStatus.RECALLED,
                RuPaymentStatus.NOT_RECEIVED_BY_ABS,
                RuPaymentStatus.DENIED
            ),
            CARD_INDEX to listOf(
                RuPaymentStatus.OVERDUE_PAYMENTS,
                RuPaymentStatus.PARTLY_EXECUTED
            ),
            ALL to RuPaymentStatus.values.clientAvailableStatuses()
        )

        // Not implemented yet
        val bankCategoriesAndStatuses: Map<RuPaymentCategory, List<RuPaymentStatus>> = emptyMap()
    }

    override fun getStatuses(userType: UserType): List<RuPaymentStatus> {
        return if (UserType.CLIENT == userType) {
            clientCategoriesAndStatuses[this]
                .getOrException("Среди клиентских категорий нет категории $category")
        } else {
            bankCategoriesAndStatuses[this]
                .getOrException("Среди банковских категорий нет категории $category")
        }
    }
}
