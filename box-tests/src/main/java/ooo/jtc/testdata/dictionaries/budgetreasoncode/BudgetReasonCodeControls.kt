package ooo.jtc.testdata.dictionaries.budgetreasoncode

import ooo.jtc.api.common.controls.ControlType
import ooo.jtc.api.common.controls.ControlType.UNKNOWN
import ooo.jtc.api.common.controls.GroupType
import ooo.jtc.api.common.controls.GroupType.MAIN
import ooo.jtc.api.common.controls.INestedControls
import ooo.jtc.api.common.controls.MessageType
import ooo.jtc.api.common.controls.MessageType.EMPTY
import ooo.jtc.api.common.controls.MessageType.LENGTH_FIXED
import ooo.jtc.api.common.controls.MessageType.LENGTH_MAX
import ooo.jtc.api.common.controls.MessageType.SYMBOLS_DELETE
import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.documents.ControlCheckResult.INVALID
import ooo.jtc.documents.ControlCheckResult.WARNING

enum class BudgetReasonCodeControls(
    override val resultStatus: ControlCheckResult = INVALID,
    override val groupCheckResult: ControlCheckResult = resultStatus,
    override val groupType: GroupType = MAIN,
    override val controlCheckResult: ControlCheckResult = resultStatus,
    override val controlType: ControlType = UNKNOWN,
    override val checkEntityName: String = "budgetReasonCode",
    override val checkFieldName: String,
    override val checkMessage: MessageType?,
    override var additionalParams: Map<String, String>? = mapOf(),
    override val checkSubResults: INestedControls? = null
) : INestedControls {

    CODE_NOT_EMPTY(
        checkFieldName = "code",
        checkMessage = EMPTY
    ),
    CODE_LENGTH(
        checkFieldName = "code",
        checkMessage = LENGTH_FIXED,
        additionalParams = mapOf(
            "length" to "2"
        )
    ),
    CODE_ALLOWED_SYMBOLS(
        checkFieldName = "code",
        checkMessage = SYMBOLS_DELETE
    ),
    DESCRIPTION_LENGTH(
        checkFieldName = "description",
        checkMessage = LENGTH_MAX,
        additionalParams = mapOf(
            "length" to "500"
        )
    ),
    DESCRIPTION_ALLOWED_SYMBOLS(
        checkFieldName = "description",
        resultStatus = WARNING,
        checkMessage = SYMBOLS_DELETE
    ),
    HINT_108_LENGTH(
        checkFieldName = "hint108",
        checkMessage = LENGTH_MAX,
        additionalParams = mapOf(
            "length" to "600"
        )
    ),
    HINT_108_ALLOWED_SYMBOLS(
        checkFieldName = "hint108",
        resultStatus = WARNING,
        checkMessage = SYMBOLS_DELETE
    ),
    HINT_109_LENGTH(
        checkFieldName = "hint109",
        checkMessage = LENGTH_MAX,
        additionalParams = mapOf(
            "length" to "600"
        )
    ),
    HINT_109_ALLOWED_SYMBOLS(
        checkFieldName = "hint109",
        resultStatus = WARNING,
        checkMessage = SYMBOLS_DELETE
    )
}