package ooo.jtc.news

import ooo.jtc.documents.IDocumentStatus
import ooo.jtc.documents.bankAvailableStatuses
import ooo.jtc.documents.clientAvailableStatuses
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.Category
import ooo.jtc.news.dto.PublicationDto
import ooo.jtc.uaa.UserType

enum class PublicationCategory(override val category: String) : Category<PublicationDto> {
    ALL("All"),
    PROBLEMATIC("Problematic"),
    WAITING_POST_DATE("WaitingPostDate"),
    COMPLETED("Completed"),
    DRAFT("Draft"),
    POSTED("Posted"),
    FOR_POST("ForPost"),
    ;

    companion object {
        /** Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21733768 */
        val bankCategoriesAndStatuses: Map<PublicationCategory, List<PublicationStatus>> = mapOf(
            DRAFT to listOf(
                PublicationStatus.DRAFT
            ),
            FOR_POST to listOf(
                PublicationStatus.NEW
            ),
            WAITING_POST_DATE to listOf(
                PublicationStatus.WAITING_FOR_AUTO_POST
            ),
            POSTED to listOf(
                PublicationStatus.AUTO_POSTED,
                PublicationStatus.MANUALLY_POSTED
            ),
            COMPLETED to listOf(
                PublicationStatus.AUTO_FINISHED,
                PublicationStatus.MANUALLY_FINISHED
            ),
            PROBLEMATIC to listOf(
                PublicationStatus.AUTO_POST_ERROR,
                PublicationStatus.AUTO_FINISH_ERROR
            ),
            ALL to PublicationStatus.values.bankAvailableStatuses()
        )

        /** Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21726777 */
        val clientCategoriesAndStatuses: Map<PublicationCategory, List<PublicationStatus>> = mapOf(
            ALL to PublicationStatus.values.clientAvailableStatuses()
        )
    }

    override fun getStatuses(userType: UserType): List<IDocumentStatus<PublicationDto>> {
        return if (UserType.CLIENT == userType) {
            clientCategoriesAndStatuses[this]
                .getOrException("Среди клиентских категорий нет категории $category")
        } else {
            bankCategoriesAndStatuses[this]
                .getOrException("Среди банковских категорий нет категории $category")
        }
    }
}