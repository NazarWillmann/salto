package ooo.jtc.testdata.dictionaries.transferterm

import ooo.jtc.api.common.controls.ControlType
import ooo.jtc.api.common.controls.ControlType.CODE_LENGTH
import ooo.jtc.api.common.controls.ControlType.CODE_SYMBOLS
import ooo.jtc.api.common.controls.ControlType.DESCRIPTION_LENGTH
import ooo.jtc.api.common.controls.ControlType.DESCRIPTION_SYMBOLS
import ooo.jtc.api.common.controls.ControlType.UNIQUE
import ooo.jtc.api.common.controls.GroupType
import ooo.jtc.api.common.controls.GroupType.CODE
import ooo.jtc.api.common.controls.GroupType.COMMON
import ooo.jtc.api.common.controls.GroupType.DESCRIPTION
import ooo.jtc.api.common.controls.INestedControls
import ooo.jtc.api.common.controls.MessageType
import ooo.jtc.api.common.controls.MessageType.EMPTY
import ooo.jtc.api.common.controls.MessageType.LENGTH_MAX
import ooo.jtc.api.common.controls.MessageType.SYMBOLS_DELETE
import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.documents.ControlCheckResult.INVALID

enum class TransferTermControls(
    override val resultStatus: ControlCheckResult = INVALID,
    override val groupCheckResult: ControlCheckResult = resultStatus,
    override val groupType: GroupType,
    override val controlCheckResult: ControlCheckResult = resultStatus,
    override val controlType: ControlType,
    override val checkEntityName: String = "transferTerm.field",
    override val checkFieldName: String,
    override val checkMessage: MessageType?,
    override var additionalParams: Map<String, String>? = mapOf(),
    override val checkSubResults: INestedControls? = null
) : INestedControls {

    CODE_NOT_EMPTY(
        groupType = CODE,
        controlType = ControlType.CODE_NOT_EMPTY,
        checkFieldName = "code",
        checkMessage = EMPTY
    ),
    CODE_MAX_LENGTH(
        groupType = CODE,
        controlType = CODE_LENGTH,
        checkFieldName = "code",
        checkMessage = LENGTH_MAX,
        additionalParams = mapOf(
            "length" to "35"
        )
    ),
    CODE_ALLOWED_SYMBOLS(
        groupType = CODE,
        controlType = CODE_SYMBOLS,
        checkFieldName = "code",
        checkMessage = SYMBOLS_DELETE
    ),
    DESCRIPTION_NOT_EMPTY(
        groupType = DESCRIPTION,
        controlType = ControlType.DESCRIPTION_NOT_EMPTY,
        checkFieldName = "description",
        checkMessage = EMPTY
    ),
    DESCRIPTION_MAX_LENGTH(
        groupType = DESCRIPTION,
        controlType = DESCRIPTION_LENGTH,
        checkFieldName = "description",
        checkMessage = LENGTH_MAX,
        additionalParams = mapOf(
            "length" to "255"
        )
    ),
    DESCRIPTION_ALLOWED_SYMBOLS(
        groupType = DESCRIPTION,
        controlType = DESCRIPTION_SYMBOLS,
        checkFieldName = "description",
        checkMessage = SYMBOLS_DELETE
    ),
    TRANSFER_TERM_UNIQUE(
        groupType = COMMON,
        controlType = UNIQUE,
        checkFieldName = "code",
        checkMessage = MessageType.TRANSFER_TERM_UNIQUE
    )
}