package ooo.jtc.letters.model

import ooo.jtc.documents.bankAvailableStatuses
import ooo.jtc.documents.clientAvailableStatuses
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.Category
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.uaa.UserType

enum class LetterFromBankCategory(override val category: String) : Category<LetterFromBankDto> {
    ALL("All"),
    PROBLEMATIC("Problematic"),// supplementary category for 'double counter' implementation
    DELIVERED("Delivered"),
    DRAFT("Draft"),
    FOR_SEND("ForSend"),
    FOR_SIGNATURE("ForSignature"),
    ;

    companion object {
        /** Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21726801 */
        val bankCategoriesAndStatuses: Map<LetterFromBankCategory, List<LetterFromBankStatus>> = mapOf(
                DRAFT to listOf(
                        LetterFromBankStatus.DRAFT
                ),
                FOR_SIGNATURE to listOf(
                        LetterFromBankStatus.NEW
                ),
                FOR_SEND to listOf(
                        LetterFromBankStatus.SIGNED
                ),
                DELIVERED to listOf(
                        LetterFromBankStatus.DELIVERED
                ),
                PROBLEMATIC to listOf(
                        LetterFromBankStatus.WRONG_ESIGNATURE,
                        LetterFromBankStatus.DETAILS_ERROR
                ),
                ALL to LetterFromBankStatus.values.bankAvailableStatuses()
        )

        /** Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21726777 */
        val clientCategoriesAndStatuses: Map<LetterFromBankCategory, List<LetterFromBankStatus>> = mapOf(
                ALL to LetterFromBankStatus.values.clientAvailableStatuses()
        )
    }

    override fun getStatuses(userType: UserType): List<LetterFromBankStatus> {
        return if (UserType.CLIENT == userType) {
            clientCategoriesAndStatuses[this]
                .getOrException("Среди клиентских категорий нет категории $category")
        } else {
            bankCategoriesAndStatuses[this]
                .getOrException("Среди банковских категорий нет категории $category")
        }
    }
}
