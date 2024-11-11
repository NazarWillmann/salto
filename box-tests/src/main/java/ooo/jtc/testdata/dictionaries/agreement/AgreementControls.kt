package ooo.jtc.testdata.dictionaries.agreement

import ooo.jtc.api.common.controls.ControlType
import ooo.jtc.api.common.controls.GroupType
import ooo.jtc.api.common.controls.INestedControls
import ooo.jtc.api.common.controls.MessageType
import ooo.jtc.documents.ControlCheckResult

enum class AgreementControls(
    override val resultStatus: ControlCheckResult = ControlCheckResult.INVALID,
    override val groupCheckResult: ControlCheckResult = resultStatus,
    override val groupType: GroupType = GroupType.AGREEMENT,
    override val controlCheckResult: ControlCheckResult = resultStatus,
    override val controlType: ControlType = ControlType.UNKNOWN,
    override val checkEntityName: String = "agreement",
    override val checkFieldName: String,
    override var additionalParams: Map<String, String>? = mapOf(),
    override val checkSubResults: INestedControls? = null
) : INestedControls {
    DATE_NOT_EMPTY(
        checkFieldName = "agreementDate",
        resultStatus = ControlCheckResult.WARNING,
        groupType = GroupType.AGREEMENT,
        groupCheckResult = ControlCheckResult.WARNING
    ) {
        override val checkMessage: MessageType?
            get() = MessageType.EMPTY
    },
    NUMBER_NOT_EMPTY(
        checkFieldName = "agreementNumber",
        resultStatus = ControlCheckResult.INVALID,
        groupCheckResult = ControlCheckResult.WARNING,
        groupType = GroupType.AGREEMENT
    ) {
        override val checkMessage: MessageType?
            get() = MessageType.EMPTY
    },
    NUMBER_LENGTH(
        checkFieldName = "agreementNumber",
        resultStatus = ControlCheckResult.INVALID,
        groupType = GroupType.AGREEMENT,
        groupCheckResult = ControlCheckResult.INVALID,
        additionalParams = mapOf(
            "length" to "15"
        )
    ) {
        override val checkMessage: MessageType?
            get() = MessageType.LENGTH_FIXED
    },
    NUMBER_ALLOWED_SYMBOLS(
        checkFieldName = "agreementNumber",
        resultStatus = ControlCheckResult.INVALID,
        groupCheckResult = ControlCheckResult.INVALID,
        groupType = GroupType.AGREEMENT
    ) {
        override val checkMessage: MessageType?
            get() = MessageType.SYMBOLS_ALLOWED_POSITION
    },
    AGREEMENT_TYPE_NOT_EMPTY(
        checkFieldName = "agreementType",
        resultStatus = ControlCheckResult.INVALID,
        groupCheckResult = ControlCheckResult.INVALID,
        groupType = GroupType.AGREEMENT
    ) {
        override val checkMessage: MessageType?
            get() = MessageType.EMPTY
    },
    END_DATE_NOT_EMPTY(
        checkFieldName = "endDate",
        resultStatus = ControlCheckResult.WARNING,
        groupCheckResult = ControlCheckResult.WARNING,
        groupType = GroupType.AGREEMENT
    ) {
        override val checkMessage: MessageType?
            get() = MessageType.EMPTY
    },
    DESCRIPTION_LENGTH(
        checkFieldName = "description",
        resultStatus = ControlCheckResult.INVALID,
        groupCheckResult = ControlCheckResult.INVALID,
        groupType = GroupType.AGREEMENT,
        additionalParams = mapOf(
            "length" to "255"
        )
    ) {
        override val checkMessage: MessageType?
            get() = MessageType.LENGTH_MAX
    },
    DESCRIPTION_ALLOWED_SYMBOLS(
        checkFieldName = "description",
        resultStatus = ControlCheckResult.INVALID,
        groupCheckResult = ControlCheckResult.INVALID,
        groupType = GroupType.AGREEMENT
    ) {
        override val checkMessage: MessageType?
            get() = MessageType.SYMBOLS_ALLOWED_POSITION
    },
    DESCRIPTION_NOT_EMPTY(
        checkFieldName = "agreementDate",
        resultStatus = ControlCheckResult.INVALID,
        groupCheckResult = ControlCheckResult.INVALID,
        groupType = GroupType.AGREEMENT
    ) {
        override val checkMessage: MessageType?
            get() = MessageType.EMPTY
    }
}