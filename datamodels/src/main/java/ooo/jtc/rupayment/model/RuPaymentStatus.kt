package ooo.jtc.rupayment.model

import ooo.jtc.documents.IDocumentStatus
import ooo.jtc.documents.IDocumentStatus.Companion.NOT_AVAILABLE
import ooo.jtc.rupayment.dto.RuPaymentDto

//[2020.06.18] Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=4337251
enum class RuPaymentStatus(
    override val statusClient: String,
    override val descriptionClient: String,
    override val statusBank: String = statusClient,
    override val descriptionBank: String = descriptionClient
) : IDocumentStatus<RuPaymentDto> {
    // 'hidden' statuses
    DELETED("Deleted", NOT_AVAILABLE),
    IMPORTING("Importing", NOT_AVAILABLE),

    // visible statuses
    DRAFT(
        "Draft", "Черновик",
        NOT_AVAILABLE, NOT_AVAILABLE
    ),
    NEW(
        "New", "На подпись",
        NOT_AVAILABLE, NOT_AVAILABLE
    ),
    IMPORT_ERROR(
        "ImportError", "Ошибка импорта",
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
        NOT_AVAILABLE, NOT_AVAILABLE
    ),
    WRONG_ESIGNATURE("WrongESignature", "ЭП неверна"),
    CORRECT_ESIGNATURE(
        "DeliveredToBank", "Отправлен",
        "CorrectESignature", "ЭП верна"
    ),
    DETAILS_ERROR("DetailsError", "Ошибка реквизитов"),
    RECEIVED(
        "Received", "Принят в обработку",
        "Received", "Принят"
    ),
    PRINTED(
        "InProcessing", "В обработке",
        "Printed", "Распечатан"
    ),
    RECALLED("Recalled", "Отозван"),
    WAITING_FOR_VALUE_DATE("WaitingForValueDate", "Ожидает дату платежа"),
    FOR_CHECK_E_SIGNATURE_DETAILS(
        "InProcessing", "В обработке",
        "ForCheckESignatureDetails", "К проверке ЭП и реквизитов"
    ),
    CORRECT_E_SIGNATURE_AFTER_VALUE_DATE(
        "InProcessing", "В обработке",
        "CorrectESignatureAfterValueDate", "ЭП верна [Дата платежа]"
    ),
    FOR_EXPORT_TO_ABS(
        "InProcessing", "В обработке",
        "ForExportToAbs", "К выгрузке в АБС"
    ),
    EXPORTING_TO_ABS(
        "InProcessing", "В обработке",
        "ExportingToAbs", "Выгружается в АБС"
    ),
    EXPORT_ABS_ERROR(
        "InProcessing", "В обработке",
        "ExportAbsError", "Ошибка выгрузки в АБС"
    ),
    EXPORTED_TO_ABS(
        "InProcessing", "В обработке",
        "ExportedToAbs", "Выгружен в АБС"
    ),
    RECEIVED_BY_ABS(
        "InProcessing", "В обработке",
        "ReceivedByAbs", "Принят в АБС"
    ),
    NOT_RECEIVED_BY_ABS(
        "DeniedByBank", "Отказан Банком",
        "NotReceivedByAbs", "Не принят в АБС"
    ),
    DENIED(
        "DeniedByBank", "Отказан Банком",
        "Denied", "Отказан"
    ),
    EXECUTED("Executed", "Исполнен"),
    OVERDUE_PAYMENTS("OverduePayments", "Картотека"),
    PARTLY_EXECUTED("PartlyExecuted", "Частично исполнен"),
    ;

    //[2020.07.03] "Недоступность" статуса по сути определяется тем, виден ли он пользователю на UI
    companion object {
        val values = values()
    }
}
