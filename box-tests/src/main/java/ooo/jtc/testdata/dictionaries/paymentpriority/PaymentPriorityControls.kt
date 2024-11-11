package ooo.jtc.testdata.dictionaries.paymentpriority

import ooo.jtc.api.common.controls.ControlType
import ooo.jtc.api.common.controls.GroupType
import ooo.jtc.api.common.controls.INestedControls
import ooo.jtc.api.common.controls.MessageType
import ooo.jtc.api.common.controls.MessageType.EMPTY
import ooo.jtc.api.common.controls.MessageType.LENGTH_MAX
import ooo.jtc.api.common.controls.MessageType.SYMBOLS_DELETE
import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.documents.ControlCheckResult.INVALID
import ooo.jtc.documents.ControlCheckResult.WARNING

// https://confluence.jtc.ooo/pages/viewpage.action?pageId=12916930
enum class PaymentPriorityControls(
    override val resultStatus: ControlCheckResult = INVALID,
    override val groupCheckResult: ControlCheckResult = resultStatus,
    override val groupType: GroupType = GroupType.MAIN,
    override val controlCheckResult: ControlCheckResult = resultStatus,
    override val controlType: ControlType = ControlType.UNKNOWN,
    override val checkEntityName: String = "payment.priority",
    override val checkFieldName: String,
    override val checkMessage: MessageType?,
    override var additionalParams: Map<String, String>? = mapOf(),
    override val checkSubResults: INestedControls? = null
) : INestedControls {

    CODE_EMPTY(
        checkFieldName = "code",
        checkMessage = EMPTY
    ),
    CODE_MAX_LENGTH(
        checkFieldName = "code",
        checkMessage = LENGTH_MAX
    ),
    CODE_AVAILABLE_SYMBOLS(
        checkFieldName = "code",
        checkMessage = SYMBOLS_DELETE
    ),
    DESCRIPTION_EMPTY(
        checkFieldName = "description",
        checkMessage = EMPTY
    ),
    DESCRIPTION_MAX_LENGTH(
        resultStatus = WARNING,
        groupCheckResult = WARNING,
        controlCheckResult = WARNING,
        checkFieldName = "description",
        checkMessage = LENGTH_MAX
    ),
    DESCRIPTION_AVAILABLE_SYMBOLS(
        resultStatus = WARNING,
        groupCheckResult = WARNING,
        controlCheckResult = WARNING,
        checkFieldName = "description",
        checkMessage = SYMBOLS_DELETE
    )
}