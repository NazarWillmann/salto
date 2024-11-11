package ooo.jtc.letters.model

import ooo.jtc.documents.IDocumentStatus
import ooo.jtc.documents.IDocumentStatus.Companion.NOT_AVAILABLE
import ooo.jtc.letters.dto.LetterFromBankDto

// Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171063
enum class LetterFromBankStatus(
    override val statusClient: String,
    override val descriptionClient: String,
    override val statusBank: String = statusClient,
    override val descriptionBank: String = descriptionClient
) : IDocumentStatus<LetterFromBankDto> {
    // 'hidden' statuses
    DELETED("Deleted", NOT_AVAILABLE),

    // visible statuses
    DRAFT(
        NOT_AVAILABLE, NOT_AVAILABLE,
        "Draft", "Черновик"
    ),
    NEW(
        NOT_AVAILABLE, NOT_AVAILABLE,
        "New", "На подпись"
    ),
    SIGNED(
        NOT_AVAILABLE, NOT_AVAILABLE,
        "Signed", "Подписан"
    ),
    DELIVERED(
        "Delivered", "Доставлен",
        "DeliveredToClient", "Отправлен"
    ),
    WRONG_ESIGNATURE(
        NOT_AVAILABLE, NOT_AVAILABLE,
        "WrongESignature", "ЭП неверна"
    ),
    DETAILS_ERROR(
        NOT_AVAILABLE, NOT_AVAILABLE,
        "DetailsError", "Ошибка реквизитов"
    ),
    ;

    companion object {
        val values = values()
    }
}
