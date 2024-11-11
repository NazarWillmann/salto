package ooo.jtc.testdata.news.mailgroup

import ooo.jtc.api.common.controls.ControlType
import ooo.jtc.api.common.controls.GroupType
import ooo.jtc.api.common.controls.INestedControls
import ooo.jtc.api.common.controls.MessageType
import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.documents.ControlCheckResult.INVALID
import ooo.jtc.documents.ControlCheckResult.WARNING

/**
 * Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=28606708
 */
enum class MailGroupControls(
    override val resultStatus: ControlCheckResult,
    override val groupCheckResult: ControlCheckResult = resultStatus,
    override val groupType: GroupType,
    override val controlCheckResult: ControlCheckResult = resultStatus,
    override val controlType: ControlType,
    override val checkEntityName: String = "mailGroup.field",
    override val checkFieldName: String,
    override val checkMessage: MessageType?,
    override var additionalParams: Map<String, String>? = mapOf(),
    override val checkSubResults: INestedControls? = null
) : INestedControls {

    //region Name
    NAME_EMPTY(
        resultStatus = INVALID,
        groupType = GroupType.NAME,
        controlType = ControlType.NAME_NOT_EMPTY,
        checkFieldName = "name",
        checkMessage = MessageType.EMPTY
    ),
    NAME_LENGTH(
        resultStatus = INVALID,
        groupType = GroupType.NAME,
        controlType = ControlType.NAME_LENGTH,
        checkFieldName = "name",
        checkMessage = MessageType.LENGTH_MAX
    ),
    NAME_AVAILABLE_SYMBOLS(
        resultStatus = INVALID,
        groupType = GroupType.NAME,
        controlType = ControlType.NAME_AVAILABLE_SYMBOLS,
        checkFieldName = "name",
        checkMessage = MessageType.SYMBOLS_DELETE
    ),
    NAME_UNIQUE(
        resultStatus = INVALID,
        groupType = GroupType.NAME,
        controlType = ControlType.NAME_UNIQUE,
        checkFieldName = "name",
        checkMessage = MessageType.NAME_UNIQUE
    ),
    //endregion

    //region Branch
    BRANCH_NAME_EMPTY(
        resultStatus = INVALID,
        groupType = GroupType.BRANCH,
        controlType = ControlType.BRANCH_NAME_NOT_EMPTY,
        checkFieldName = "branchName",
        checkMessage = MessageType.BRANCH_NAME_EMPTY
    ),
    BRANCH_IN_DICTIONARY(
        resultStatus = INVALID,
        groupType = GroupType.BRANCH,
        controlType = ControlType.BRANCH_IN_DICTIONARY,
        checkFieldName = "branchName",
        checkMessage = MessageType.BRANCH_IN_DICTIONARY
    ),
    //endregion

    //region Customer
    CUSTOMER_NAME_EMPTY(
        resultStatus = INVALID,
        groupType = GroupType.CUSTOMERS,
        controlType = ControlType.CUSTOMERS,
        checkFieldName = "customerName",
        checkMessage = null,
        checkSubResults = NestedCustomerControls.NAME_EMPTY
    ),
    CUSTOMER_IN_DICTIONARY(
        resultStatus = INVALID,
        groupType = GroupType.CUSTOMERS,
        controlType = ControlType.CUSTOMERS,
        checkFieldName = "customerName",
        checkMessage = null,
        checkSubResults = NestedCustomerControls.IN_DICTIONARY
    ),
    CUSTOMER_NOT_BLOCKED(
        resultStatus = WARNING,
        groupType = GroupType.CUSTOMERS,
        controlType = ControlType.CUSTOMERS,
        checkMessage = null,
        checkFieldName = "customerName",
        checkSubResults = NestedCustomerControls.NOT_BLOCKED
    ),
    CUSTOMER_RELATED_TO_BRANCH(
        resultStatus = WARNING,
        groupType = GroupType.CUSTOMERS,
        controlType = ControlType.CUSTOMERS,
        checkMessage = null,
        checkFieldName = "customerName",
        checkSubResults = NestedCustomerControls.RELATED_TO_BRANCH
    ),
    //endregion
    ;

    private enum class NestedCustomerControls(
        override val resultStatus: ControlCheckResult,
        override val groupCheckResult: ControlCheckResult = resultStatus,
        override val groupType: GroupType = GroupType.RECEIVER_CUSTOMER,
        override val controlCheckResult: ControlCheckResult = resultStatus,
        override val controlType: ControlType,
        override val checkEntityName: String = "mailGroup.customers.field",
        override val checkFieldName: String = "customerName",
        override val checkMessage: MessageType?,
        override var additionalParams: Map<String, String>? = mapOf(),
        override val checkSubResults: INestedControls? = null
    ) : INestedControls {
        NAME_EMPTY(
            resultStatus = INVALID,
            controlType = ControlType.CUSTOMER_IN_DICTIONARY,
            checkMessage = MessageType.EMPTY_OR_SPACES
        ),
        IN_DICTIONARY(
            resultStatus = INVALID,
            controlType = ControlType.CUSTOMER_IN_DICTIONARY,
            checkMessage = MessageType.CUSTOMER_IN_DICTIONARY
        ),
        NOT_BLOCKED(
            resultStatus = WARNING,
            controlType = ControlType.CUSTOMER_NOT_BLOCKED,
            checkMessage = MessageType.CUSTOMER_NOT_BLOCKED
        ),
        RELATED_TO_BRANCH(
            resultStatus = WARNING,
            controlType = ControlType.CUSTOMER_RELATED_TO_BRANCH,
            checkMessage = MessageType.STUB
        ),
        ;
    }
}