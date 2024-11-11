package ooo.jtc.testdata.news.publication

import ooo.jtc.api.common.controls.ControlType
import ooo.jtc.api.common.controls.GroupType
import ooo.jtc.api.common.controls.INestedControls
import ooo.jtc.api.common.controls.MessageType
import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.documents.ControlCheckResult.INVALID
import ooo.jtc.documents.ControlCheckResult.NOT_CHECKED
import ooo.jtc.documents.ControlCheckResult.VALID
import ooo.jtc.documents.ControlCheckResult.WARNING

/**
 * Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21733853
 */
enum class PublicationControls(
    override val resultStatus: ControlCheckResult,
    override val groupCheckResult: ControlCheckResult = resultStatus,
    override val groupType: GroupType,
    override val controlCheckResult: ControlCheckResult = resultStatus,
    override val controlType: ControlType,
    override val checkEntityName: String = "publication.field",
    override val checkFieldName: String,
    override val checkMessage: MessageType?,
    override var additionalParams: Map<String, String>? = mapOf(),
    override val checkSubResults: INestedControls? = null
) : INestedControls {

    //region Document number
    DOCUMENT_NUMBER_EMPTY(
        resultStatus = INVALID,
        groupType = GroupType.DOC_NUMBER,
        controlType = ControlType.DOC_NUMBER_NOT_EMPTY,
        checkFieldName = "documentNumber",
        checkMessage = MessageType.EMPTY
    ),
    DOCUMENT_NUMBER_LENGTH(
        resultStatus = INVALID,
        groupType = GroupType.DOC_NUMBER,
        controlType = ControlType.DOC_NUMBER_LENGTH,
        checkFieldName = "documentNumber",
        checkMessage = MessageType.LENGTH_MAX
    ),
    DOCUMENT_NUMBER_AVAILABLE_SYMBOLS(
        resultStatus = INVALID,
        groupType = GroupType.DOC_NUMBER,
        controlType = ControlType.DOC_NUMBER_AVAILABLE_SYMBOLS,
        checkFieldName = "documentNumber",
        checkMessage = MessageType.SYMBOLS_DELETE
    ),
    DOCUMENT_NUMBER_UNIQUE(
        resultStatus = INVALID,
        groupType = GroupType.DOC_NUMBER,
        controlType = ControlType.DOC_NUMBER_UNIQUE_IN_YEAR,
        checkFieldName = "documentNumber",
        checkMessage = MessageType.DOC_NUMBER_UNIQUE
    ),
    //endregion

    //region Document date
    DOCUMENT_DATE_EMPTY(
        resultStatus = INVALID,
        groupType = GroupType.DOC_DATE,
        controlType = ControlType.DOC_DATE_NOT_EMPTY,
        checkFieldName = "documentDate",
        checkMessage = MessageType.STUB
    ),
    DOCUMENT_DATE_OUT_OF_RANGE(
        resultStatus = VALID,
        groupType = GroupType.DOC_DATE,
        controlCheckResult = NOT_CHECKED,
        controlType = ControlType.DOC_DATE_VALID_RANGE,
        checkFieldName = "documentDate",
        checkMessage = MessageType.OUT_OF_RANGE
    ),
    //endregion

    //region Publication type
    PUBLICATION_TYPE_EMPTY(
        resultStatus = INVALID,
        groupType = GroupType.PUBLICATION_TYPE,
        controlType = ControlType.PUBLICATION_TYPE_NOT_EMPTY,
        checkFieldName = "publicationType",
        checkMessage = MessageType.EMPTY
    ),
    PUBLICATION_TYPE_IN_LIST(
        resultStatus = INVALID,
        groupType = GroupType.PUBLICATION_TYPE,
        controlType = ControlType.PUBLICATION_TYPE_IN_LIST,
        checkMessage = MessageType.STUB,
        checkFieldName = "publicationType"
    ),
    //endregion

    //region Description
    DESCRIPTION_EMPTY(
        resultStatus = INVALID,
        groupType = GroupType.DESCRIPTION,
        controlType = ControlType.DESCRIPTION_NOT_EMPTY,
        checkFieldName = "description",
        checkMessage = MessageType.EMPTY
    ),
    DESCRIPTION_LENGTH(
        resultStatus = WARNING,
        groupType = GroupType.DESCRIPTION,
        controlType = ControlType.DESCRIPTION_LENGTH,
        checkFieldName = "description",
        checkMessage = MessageType.LENGTH_MAX
    ),
    //endregion

    //region Target type
    TARGET_TYPE_EMPTY(
        resultStatus = INVALID,
        groupType = GroupType.TARGET_TYPE,
        controlType = ControlType.TARGET_TYPE_NOT_EMPTY,
        checkFieldName = "targetType",
        checkMessage = MessageType.EMPTY
    ),
    TARGET_TYPE_IN_LIST(
        resultStatus = INVALID,
        groupType = GroupType.TARGET_TYPE,
        controlType = ControlType.TARGET_TYPE_IN_LIST,
        checkMessage = MessageType.STUB,
        checkFieldName = "targetType"
    ),
    TARGET_TYPE_FOR_ALL_BRANCHES(
        resultStatus = INVALID,
        groupType = GroupType.TARGET_TYPE,
        controlType = ControlType.TARGET_TYPE_FOR_ALL_BRANCHES,
        checkFieldName = "targetType",
        checkMessage = MessageType.STUB
    ),
    TARGET_TYPE_CUSTOMERS_EMPTY(
        resultStatus = INVALID,
        groupType = GroupType.TARGET_TYPE,
        controlType = ControlType.TARGET_TYPE_NON_EMPTY_RECEIVER_CUSTOMERS,
        checkFieldName = "targetType",
        checkMessage = MessageType.TARGET_TYPE_CUSTOMERS_EMPTY
    ),
    //endregion

    //region Is for all branches
    IS_FOR_ALL_BRANCHES(
        resultStatus = INVALID,
        groupType = GroupType.IS_FOR_ALL_BRANCHES,
        controlType = ControlType.IS_FOR_ALL_BRANCHES,
        checkFieldName = "isForAllBranches",
        checkMessage = MessageType.STUB
    ),
    //endregion

    //region Post period
    POST_PERIOD_START(
        resultStatus = WARNING,
        groupType = GroupType.POST_PERIOD,
        controlType = ControlType.POST_PERIOD_START_DATE,
        checkFieldName = "startAt",
        checkMessage = MessageType.STUB
    ),
    POST_PERIOD_END(
        resultStatus = INVALID,
        groupType = GroupType.POST_PERIOD,
        controlType = ControlType.POST_PERIOD_END_DATE,
        checkFieldName = "endAt",
        checkMessage = MessageType.STUB
    ),
    POST_PERIOD(
        resultStatus = INVALID,
        groupType = GroupType.POST_PERIOD,
        controlType = ControlType.POST_PERIOD,
        checkFieldName = "endAt",
        checkMessage = MessageType.STUB
    ),
    POST_PERIOD_LENGTH(
        resultStatus = INVALID,
        groupType = GroupType.POST_PERIOD,
        controlType = ControlType.POST_PERIOD_LENGTH,
        checkFieldName = "endAt",
        checkMessage = MessageType.STUB
    ),
    //endregion

    //region Content
    CONTENT_EMPTY(
        resultStatus = INVALID,
        groupType = GroupType.CONTENT,
        controlType = ControlType.CONTENT_NOT_EMPTY,
        checkEntityName = "",
        checkFieldName = "text",
        checkMessage = MessageType.CONTENT_EMPTY
    ),
    HEADER_LENGTH(
        resultStatus = WARNING,
        groupType = GroupType.CONTENT,
        controlType = ControlType.CONTENT_HEADER_LENGTH,
        checkFieldName = "header",
        checkMessage = MessageType.LENGTH_MAX
    ),
    TEXT_LENGTH(
        resultStatus = WARNING,
        groupType = GroupType.CONTENT,
        controlType = ControlType.CONTENT_TEXT_LENGTH,
        checkFieldName = "text",
        checkMessage = MessageType.LENGTH_MAX
    ),
    LINK_EMPTY(
        resultStatus = INVALID,
        groupType = GroupType.CONTENT,
        controlType = ControlType.CONTENT_LINK_NOT_EMPTY,
        checkMessage = MessageType.EMPTY_OR_SPACES,
        checkFieldName = "link"
    ),
    LINK_TEXT_EMPTY(
        resultStatus = WARNING,
        groupType = GroupType.CONTENT,
        controlType = ControlType.CONTENT_LINK_TEXT_NOT_EMPTY,
        checkMessage = MessageType.EMPTY,
        checkFieldName = "linkText"
    ),
    LINK_TEXT_LENGTH(
        resultStatus = WARNING,
        groupType = GroupType.CONTENT,
        controlType = ControlType.CONTENT_LINK_TEXT_LENGTH,
        checkFieldName = "linkText",
        checkMessage = MessageType.LENGTH_MAX
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

    //region Customers
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

    //region Common
    PUBLICATION_GENERAL_UNIQUE(
        resultStatus = WARNING,
        groupType = GroupType.COMMON,
        controlType = ControlType.PUBLICATION_GENERAL_UNIQUE,
        checkFieldName = "documentNumber",
        checkMessage = MessageType.STUB
    ),
    PUBLICATION_DIRECT_UNIQUE(
        resultStatus = WARNING,
        groupType = GroupType.COMMON,
        controlType = ControlType.PUBLICATION_DIRECT_UNIQUE,
        checkFieldName = "UNKNOWN FIELD REFERENCE",
        checkMessage = MessageType.STUB
    ),
    //endregion
    ;

    private enum class NestedCustomerControls(
        override val resultStatus: ControlCheckResult,
        override val groupCheckResult: ControlCheckResult = resultStatus,
        override val groupType: GroupType = GroupType.RECEIVER_CUSTOMER,
        override val controlCheckResult: ControlCheckResult = resultStatus,
        override val controlType: ControlType,
        override val checkEntityName: String = "publication.customers.field",
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