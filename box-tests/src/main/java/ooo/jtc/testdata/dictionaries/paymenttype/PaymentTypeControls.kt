package ooo.jtc.testdata.dictionaries.paymenttype

import ooo.jtc.api.common.controls.IControls
import ooo.jtc.api.common.controls.MessageType
import ooo.jtc.api.common.controls.MessageType.*
import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.documents.ControlCheckResult.INVALID
import ooo.jtc.documents.ControlCheckResult.WARNING

// https://confluence.jtc.ooo/pages/viewpage.action?pageId=19170101
enum class PaymentTypeControls(
    override val fieldName: String,
    override val messageType: MessageType,
    override val resultStatus: ControlCheckResult,
    override var additionalParams: Map<String, String>? = mapOf()
) : IControls {
    CODE_EMPTY("code", EMPTY_OR_SPACES, INVALID),
    CODE_MAX_LENGTH("code", LENGTH_MAX, INVALID),
    CODE_AVAILABLE_SYMBOLS("code", SYMBOLS_DELETE, INVALID),
    DESCRIPTION_EMPTY("description", EMPTY_OR_SPACES, INVALID),
    DESCRIPTION_MAX_LENGTH("description", LENGTH_MAX, INVALID),
    DESCRIPTION_AVAILABLE_SYMBOLS("description", SYMBOLS_DELETE, WARNING),
    ;

    override val controlEntityName = "payment.type"
}