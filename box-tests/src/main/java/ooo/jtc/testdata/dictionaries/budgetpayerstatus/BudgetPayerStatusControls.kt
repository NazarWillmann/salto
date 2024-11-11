package ooo.jtc.testdata.dictionaries.budgetpayerstatus

import ooo.jtc.api.common.controls.ControlType
import ooo.jtc.api.common.controls.GroupType
import ooo.jtc.api.common.controls.INestedControls
import ooo.jtc.api.common.controls.MessageType
import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.documents.ControlCheckResult.INVALID
import ooo.jtc.documents.ControlCheckResult.WARNING

enum class BudgetPayerStatusControls(
    override val resultStatus: ControlCheckResult = INVALID,
    override val groupCheckResult: ControlCheckResult = resultStatus,
    override val groupType: GroupType = GroupType.MAIN,
    override val controlCheckResult: ControlCheckResult = resultStatus,
    override val controlType: ControlType = ControlType.UNKNOWN,
    override val checkEntityName: String = "budget.payer.status",
    override val checkFieldName: String,
    override val checkMessage: MessageType?,
    override var additionalParams: Map<String, String>? = mapOf(),
    override val checkSubResults: INestedControls? = null
) : INestedControls {

    CODE_NOT_EMPTY(
        checkFieldName = "code",
        checkMessage = MessageType.EMPTY
    ),
    CODE_LENGTH(
        checkFieldName = "code",
        checkMessage = MessageType.LENGTH_FIXED,
        additionalParams = mapOf(
            "length" to "2"
        )
    ),
    CODE_ALLOWED_SYMBOLS(
        checkFieldName = "code",
        checkMessage = MessageType.SYMBOLS_DELETE
    ),
    DESCRIPTION_NOT_EMPTY(
        checkFieldName = "description",
        checkMessage = MessageType.EMPTY
    ),
    DESCRIPTION_LENGTH(
        checkFieldName = "description",
        checkMessage = MessageType.LENGTH_MAX,
        additionalParams = mapOf(
            "length" to "500"
        )
    ),
    DESCRIPTION_ALLOWED_SYMBOLS(
        resultStatus = WARNING,
        groupCheckResult = WARNING,
        controlCheckResult = WARNING,
        checkFieldName = "description",
        checkMessage = MessageType.SYMBOLS_DELETE
    )
}

