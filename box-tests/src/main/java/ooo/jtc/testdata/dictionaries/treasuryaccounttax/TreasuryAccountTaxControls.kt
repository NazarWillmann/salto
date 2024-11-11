package ooo.jtc.testdata.dictionaries.treasuryaccounttax

import ooo.jtc.api.common.controls.ControlType
import ooo.jtc.api.common.controls.ControlType.ACCOUNT_SYMBOLS
import ooo.jtc.api.common.controls.ControlType.TOFK_SYMBOLS
import ooo.jtc.api.common.controls.ControlType.UTRA_ACCOUNT_SYMBOLS
import ooo.jtc.api.common.controls.GroupType
import ooo.jtc.api.common.controls.GroupType.ACCOUNT
import ooo.jtc.api.common.controls.GroupType.BANK_NAME
import ooo.jtc.api.common.controls.GroupType.BIC
import ooo.jtc.api.common.controls.GroupType.TOFK
import ooo.jtc.api.common.controls.GroupType.UTRA_ACCOUNT
import ooo.jtc.api.common.controls.INestedControls
import ooo.jtc.api.common.controls.MessageType
import ooo.jtc.api.common.controls.MessageType.BANK_NAME_REGEXP
import ooo.jtc.api.common.controls.MessageType.COMMON_ACCOUNT_NOT_FOUND
import ooo.jtc.api.common.controls.MessageType.COMMON_BANK_BIC_NOT_FOUND
import ooo.jtc.api.common.controls.MessageType.COMMON_WRONG_ACCOUNT_STATUS
import ooo.jtc.api.common.controls.MessageType.COMMON_WRONG_ACCOUNT_TYPE
import ooo.jtc.api.common.controls.MessageType.COMMON_WRONG_BANK_NAME_FORMAT
import ooo.jtc.api.common.controls.MessageType.EMPTY
import ooo.jtc.api.common.controls.MessageType.LENGTH_FIXED
import ooo.jtc.api.common.controls.MessageType.LENGTH_MAX
import ooo.jtc.api.common.controls.MessageType.SYMBOLS_ALLOWED_POSITION
import ooo.jtc.api.common.controls.MessageType.SYMBOLS_DELETE
import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.documents.ControlCheckResult.INVALID
import ooo.jtc.documents.ControlCheckResult.WARNING

enum class TreasuryAccountTaxControls(
    override val resultStatus: ControlCheckResult = INVALID,
    override val groupCheckResult: ControlCheckResult = resultStatus,
    override val groupType: GroupType,
    override val controlCheckResult: ControlCheckResult = resultStatus,
    override val controlType: ControlType,
    override val checkEntityName: String = "treasuryAccountTax.field",
    override val checkFieldName: String? = null,
    override val checkMessage: MessageType?,
    override var additionalParams: Map<String, String>? = mutableMapOf(),
    override val checkSubResults: INestedControls? = null
) : INestedControls {

    TOFK_LENGTH(
        groupType = TOFK,
        controlType = ControlType.TOFK_LENGTH,
        checkFieldName = "tofk",
        checkMessage = LENGTH_MAX
    ),
    TOFK_ALLOWED_SYMBOLS(
        resultStatus = WARNING,
        groupCheckResult = WARNING,
        controlCheckResult = WARNING,
        groupType = TOFK,
        controlType = TOFK_SYMBOLS,
        checkFieldName = "tofk",
        checkMessage = SYMBOLS_DELETE
    ),
    ACCOUNT_LENGTH(
        groupType = ACCOUNT,
        controlType = ControlType.ACCOUNT_LENGTH,
        checkFieldName = "account",
        checkMessage = LENGTH_FIXED
    ),
    ACCOUNT_ALLOWED_SYMBOLS(
        groupType = ACCOUNT,
        controlType = ACCOUNT_SYMBOLS,
        checkFieldName = "account",
        checkMessage = SYMBOLS_DELETE
    ),
    ACCOUNT_CURRENCY_CODE(
        resultStatus = WARNING,
        groupCheckResult = WARNING,
        controlCheckResult = WARNING,
        groupType = ACCOUNT,
        controlType = ControlType.ACCOUNT_CURRENCY_CODE,
        checkFieldName = "account",
        checkMessage = SYMBOLS_ALLOWED_POSITION
    ),
    ACCOUNT_CODE(
        resultStatus = WARNING,
        groupCheckResult = WARNING,
        controlCheckResult = WARNING,
        groupType = ACCOUNT,
        controlType = ControlType.ACCOUNT_CODE,
        checkFieldName = "account",
        checkMessage = SYMBOLS_ALLOWED_POSITION
    ),
    BANK_NAME_LENGTH(
        groupType = BANK_NAME,
        controlType = ControlType.BANK_NAME_LENGTH,
        checkFieldName = "bankName",
        checkMessage = LENGTH_MAX
    ),
    BANK_NAME_ALLOWED_SYMBOLS(
        groupType = BANK_NAME,
        controlType = ControlType.BANK_NAME_SYMBOLS,
        checkFieldName = "bankName",
        checkMessage = SYMBOLS_DELETE
    ),
    BANK_NAME_FORMAT(
        groupCheckResult = WARNING,
        controlCheckResult = WARNING,
        groupType = BANK_NAME,
        controlType = ControlType.BANK_NAME_FORMAT,
        checkFieldName = "bankName",
        checkMessage = BANK_NAME_REGEXP
    ),
    BIC_LENGTH(
        groupType = BIC,
        controlType = ControlType.BIC_LENGTH,
        checkFieldName = "bic",
        checkMessage = LENGTH_FIXED
    ),
    BIC_ALLOWED_SYMBOLS(
        groupType = BIC,
        controlType = ControlType.BIC_SYMBOLS,
        checkFieldName = "bic",
        checkMessage = SYMBOLS_DELETE
    ),
    UTRA_ACCOUNT_EMPTY(
        groupCheckResult = WARNING,
        controlCheckResult = WARNING,
        groupType = UTRA_ACCOUNT,
        controlType = ControlType.UTRA_ACCOUNT_NOT_EMPTY,
        checkFieldName = "utraAccount",
        checkMessage = EMPTY
    ),
    UTRA_ACCOUNT_LENGTH(
        groupCheckResult = WARNING,
        controlCheckResult = WARNING,
        groupType = UTRA_ACCOUNT,
        controlType = ControlType.UTRA_ACCOUNT_LENGTH,
        checkFieldName = "utraAccount",
        checkMessage = LENGTH_FIXED
    ),
    UTRA_ACCOUNT_ALLOWED_SYMBOLS(
        groupCheckResult = WARNING,
        controlCheckResult = WARNING,
        groupType = UTRA_ACCOUNT,
        controlType = UTRA_ACCOUNT_SYMBOLS,
        checkFieldName = "utraAccount",
        checkMessage = SYMBOLS_DELETE
    ),
    COMMON_BIC(
        groupType = GroupType.COMMON,
        controlType = ControlType.COMMON,
        checkMessage = COMMON_BANK_BIC_NOT_FOUND
    ),
    COMMON_ACCOUNT(
        groupType = GroupType.COMMON,
        controlType = ControlType.COMMON,
        checkMessage = COMMON_ACCOUNT_NOT_FOUND
    ),
    COMMON_ACCOUNT_TYPE(
        groupType = GroupType.COMMON,
        controlType = ControlType.COMMON,
        checkMessage = COMMON_WRONG_ACCOUNT_TYPE
    ),
    COMMON_ACCOUNT_STATUS(
        groupType = GroupType.COMMON,
        controlType = ControlType.COMMON,
        checkMessage = COMMON_WRONG_ACCOUNT_STATUS
    ),
    COMMON_BANK_NAME(
        groupType = GroupType.COMMON,
        controlType = ControlType.COMMON,
        checkMessage = COMMON_WRONG_BANK_NAME_FORMAT
    )
}