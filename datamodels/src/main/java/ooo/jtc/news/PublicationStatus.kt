package ooo.jtc.news

import ooo.jtc.documents.IDocumentStatus
import ooo.jtc.documents.IDocumentStatus.Companion.NOT_AVAILABLE
import ooo.jtc.news.dto.PublicationDto

// [2020.10.20] Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21733683
// [2020.10.20] UI status bank https://confluence.jtc.ooo/pages/viewpage.action?pageId=21733723
// [2020.10.20] UI status client https://confluence.jtc.ooo/pages/viewpage.action?pageId=21733724
enum class PublicationStatus(
    override val statusClient: String,
    override val descriptionClient: String,
    override val statusBank: String = statusClient,
    override val descriptionBank: String = descriptionClient
) : IDocumentStatus<PublicationDto> {
    // 'hidden' statuses
    DELETED("Deleted", NOT_AVAILABLE),

    // visible statuses
    DRAFT(
        NOT_AVAILABLE, NOT_AVAILABLE,
        "Draft", "Черновик"
    ),
    NEW(
        NOT_AVAILABLE, NOT_AVAILABLE,
        "New", "Новый"
    ),
    WAITING_FOR_AUTO_POST(
        NOT_AVAILABLE, NOT_AVAILABLE,
        "WaitingForAutoPost", "Ожидает размещения"
    ),
    AUTO_POST_ERROR(
        NOT_AVAILABLE, NOT_AVAILABLE,
        "AutoPostError","Ошибка размещения"
    ),

    AUTO_POSTED(
        "Posted", "Размещена",
        "AutoPosted", "Размещена"
    ),
    MANUALLY_POSTED(
        "Posted", "Размещена",
        "ManuallyPosted", "Размещена"
    ),

    AUTO_FINISHED(
        NOT_AVAILABLE, NOT_AVAILABLE,
        "AutoFinished", "Завершена"
    ),
    AUTO_FINISH_ERROR(
        NOT_AVAILABLE, NOT_AVAILABLE,
        "AutoFinishError", "Ошибка завершения"
    ),
    MANUALLY_FINISHED(
        NOT_AVAILABLE, NOT_AVAILABLE,
        "ManuallyFinished", "Завершена"
    ),
    ;

    companion object {
        val values = values()
    }
}