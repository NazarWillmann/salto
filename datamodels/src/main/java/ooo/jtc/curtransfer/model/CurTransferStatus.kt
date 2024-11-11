package ooo.jtc.curtransfer.model

import ooo.jtc.curtransfer.dto.CurTransferDto
import ooo.jtc.documents.IDocumentStatus
import ooo.jtc.documents.IDocumentStatus.Companion.NOT_AVAILABLE

// [2021.01.25]
// Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=27755013
// UI status bank https://confluence.jtc.ooo/pages/viewpage.action?pageId=27755016
// UI status client https://confluence.jtc.ooo/pages/viewpage.action?pageId=27755015
enum class CurTransferStatus(
    override val statusClient: String,
    override val descriptionClient: String,
    override val statusBank: String = statusClient,
    override val descriptionBank: String = descriptionClient
) : IDocumentStatus<CurTransferDto> {
    // 'hidden' statuses
    DELETED("Deleted", NOT_AVAILABLE),
    IMPORTING("Importing", NOT_AVAILABLE),

    // visible statuses
    IMPORT_ERROR(
        "ImportError", "Ошибка импорта",
        "ImportError", NOT_AVAILABLE
    ),
    DRAFT(
        "Draft", "Черновик",
        "Draft", NOT_AVAILABLE
    ),
    NEW(
        "New", "На подпись",
        "New", NOT_AVAILABLE
    ),
    PARTLY_SIGNED(
        "PartlySigned", "Частично подписан",
        "PartlySigned", NOT_AVAILABLE
    ),
    SIGNED(
        "Signed", "Подписан",
        "Signed", NOT_AVAILABLE
    ),

    DELIVERED(
        "DeliveredToBank", "Отправлен",
        "Delivered", "Доставлен"
    ),
    FOR_RECEIVING("Receiving", "Принимается",
        "ForReceiving", "К приему"
    ),
    RECEIVING_ERROR(
        "Receiving", "Принимается",
        "ReceivingError", "Ошибка приема"
    ),
    WRONG_E_SIGNATURE(
        "WrongESignature", "ЭП неверна"
    ),
    DETAILS_ERROR(
        "DetailsError", "Ошибка реквизитов"
    ),
    RECEIVED(
        "Received", "Принят в обработку", // TODO Sergeyev [2021.01.25]: same statuses, different descriptions
        "Received", "Принят"
    ),
    EXPORTING_TO_ABS(
        "InProcessing", "В обработке",
        "ExportingToAbs", "Выгружается в АБС"
    ),
    EXPORTED_TO_ABS(
        "InProcessing", "В обработке",
        "ExportedToAbs", "Выгружен в АБС"
    ),
    EXPORT_TO_ABS_ERROR(
        "InProcessing", "В обработке",
        "ExportToAbsError", "Ошибка выгрузки в АБС"
    ),
    ACCEPTED_TO_ABS(
        "InProcessing", "В обработке",
        "AcceptedToAbs", "Принят в АБС"
    ),
    NOT_ACCEPTED_TO_ABS(
        "Rejected", "Отказан Банком",
        "NotAcceptedToAbs", "Не принят в АБС"
    ),
    REJECTED(
        "Rejected", "Отказан Банком"
    ),
    RECALLED(
        "Recalled", "Отозван"
    ),
    EXECUTED(
        "Executed", "Исполнен"
    ),
    ;
}