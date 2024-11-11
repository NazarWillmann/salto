package ooo.jtc.letters.model

import ooo.jtc.documents.IDocumentStatus
import ooo.jtc.documents.IDocumentStatus.Companion.NOT_AVAILABLE
import ooo.jtc.letters.dto.LetterToBankDto

// [2020.06.05] Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171047
// [2020.09.18] UI status bank https://confluence.jtc.ooo/pages/viewpage.action?pageId=21732029
// [2020.09.18] UI status client https://confluence.jtc.ooo/pages/viewpage.action?pageId=21732027
enum class LetterToBankStatus(
    override val statusClient: String,
    override val descriptionClient: String,
    override val statusBank: String = statusClient,
    override val descriptionBank: String = descriptionClient
) : IDocumentStatus<LetterToBankDto> {
    // 'hidden' statuses
    DELETED("Deleted", NOT_AVAILABLE),

    // visible statuses
    DRAFT(
        "Draft", "Черновик",
        NOT_AVAILABLE, NOT_AVAILABLE
    ),

    NEW(
        "New", "На подпись",
        NOT_AVAILABLE, NOT_AVAILABLE
    ),
    PARTLY_SIGNED(
        "PartlySigned", "Частично подписан",
        NOT_AVAILABLE, NOT_AVAILABLE
    ),
    SIGNED(
        "Signed", "Подписан",
        NOT_AVAILABLE, NOT_AVAILABLE
    ),
    DELIVERED(
        "DeliveredToBank", "Отправлен",
        "Delivered", "Доставлен"
    ),
    FOR_RECEIVING(
        "Receiving", "Принимается",
        "ForReceiving", "К приему"
    ),
    RECEIVING_ERROR(
        "Receiving", "Принимается",
        "ReceivingError", "Ошибка приема"
    ),
    WRONG_ESIGNATURE("WrongESignature", "ЭП неверна"),
    DETAILS_ERROR("DetailsError", "Ошибка реквизитов"),
    RECEIVED("Received", "Принят"),
    IN_PROCESSING("InProcessing", "В обработке"),
    RECALLED("Recalled", "Отозван"),
    PROCESSED("Processed", "Обработан"),
    ;

    companion object {
        val values = values()

        /**
         * Action 'recall' is available for any LetterToBank in listed statuses:
         * - DELIVERED - a system status in a sort. Document are processed to next status too fast for human- or AT-interaction
         * - FOR_RECEIVING - also a "kinda system status"
         * - RECEIVING_ERROR - an erroneous status. Usually can't be achieved
         * //NB: As of now documents in these /\ three statuses can be created only through direct DB manipulation
         * - RECEIVED
         * - IN_PROCESSING
         *
         * Source: https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171043
         */
        val recallableStatuses = listOf(DELIVERED, FOR_RECEIVING, RECEIVING_ERROR, RECEIVED, IN_PROCESSING)
    }
}