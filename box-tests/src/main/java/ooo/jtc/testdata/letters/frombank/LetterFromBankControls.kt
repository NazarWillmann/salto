package ooo.jtc.testdata.letters.frombank

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
 * Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21730467
 */
enum class LetterFromBankControls(
    override val resultStatus: ControlCheckResult,
    override val groupCheckResult: ControlCheckResult = resultStatus,
    override val groupType: GroupType,
    override val controlCheckResult: ControlCheckResult = resultStatus,
    override val controlType: ControlType,
    override val checkEntityName: String = "letterFromBank.field",
    override val checkFieldName: String? = null,
    override val checkMessage: MessageType?,
    override var additionalParams: Map<String, String>? = mapOf(),
    override val checkSubResults: INestedControls? = null
) : INestedControls {

    //region Document number
    DOC_NUMBER_EMPTY(
        resultStatus = INVALID,
        groupType = GroupType.DOC_NUMBER,
        controlType = ControlType.DOC_NUMBER_NOT_EMPTY,
        checkFieldName = "documentNumber",
        checkMessage = MessageType.EMPTY
    ),
    DOC_NUMBER_MAX_LENGTH(
        resultStatus = INVALID,
        groupType = GroupType.DOC_NUMBER,
        controlType = ControlType.DOC_NUMBER_LENGTH,
        checkFieldName = "documentNumber",
        checkMessage = MessageType.LENGTH_MAX
    ),
    DOC_NUMBER_AVAILABLE_SYMBOLS_SPACES(
        resultStatus = INVALID,
        groupType = GroupType.DOC_NUMBER,
        controlType = ControlType.DOC_NUMBER_AVAILABLE_SYMBOLS,
        checkFieldName = "documentNumber",
        checkMessage = MessageType.SYMBOLS_SPACES
    ),
    DOC_NUMBER_AVAILABLE_SYMBOLS_DELETE(
        resultStatus = INVALID,
        groupType = GroupType.DOC_NUMBER,
        controlType = ControlType.DOC_NUMBER_AVAILABLE_SYMBOLS,
        checkFieldName = "documentNumber",
        checkMessage = MessageType.SYMBOLS_DELETE
    ),
    DOC_NUMBER_AVAILABLE_SYMBOLS_ZEROS(
        resultStatus = INVALID,
        groupType = GroupType.DOC_NUMBER,
        controlType = ControlType.DOC_NUMBER_AVAILABLE_SYMBOLS,
        checkFieldName = "documentNumber",
        checkMessage = MessageType.SYMBOLS_ZEROS
    ),
    DOC_NUMBER_UNIQUE_IN_YEAR(
        resultStatus = INVALID,
        groupType = GroupType.DOC_NUMBER,
        controlType = ControlType.DOC_NUMBER_UNIQUE_IN_YEAR,
        checkMessage = MessageType.UNIQUE_IN_YEAR
    ),
    //endregion

    //region Document date
    DOC_DATE_EMPTY(
        resultStatus = INVALID,
        groupType = GroupType.DOC_DATE,
        controlType = ControlType.DOC_DATE_NOT_EMPTY,
        checkFieldName = "documentDate",
        checkMessage = MessageType.STUB
    ),
    DOC_DATE_RANGE(
        resultStatus = VALID,
        groupType = GroupType.DOC_DATE,
        controlCheckResult = NOT_CHECKED,
        controlType = ControlType.DOC_DATE_VALID_RANGE,
        checkFieldName = "documentDate",
        checkMessage = MessageType.OUT_OF_RANGE
    ),
    //endregion

    //region Document type
    DOC_TYPE_EMPTY(
        resultStatus = INVALID,
        groupType = GroupType.DOC_TYPE,
        controlType = ControlType.DOC_TYPE_NOT_EMPTY,
        checkFieldName = "docTypeDescription",
        checkMessage = MessageType.EMPTY
    ),
    DOC_TYPE_IN_DICTIONARY(
        resultStatus = INVALID,
        groupType = GroupType.DOC_TYPE,
        controlType = ControlType.DOC_TYPE_IN_DICTIONARY,
        checkMessage = MessageType.DOC_TYPE_IN_DICTIONARY
    ),
    //endregion

    //region Document theme
    DOC_THEME_EMPTY(
        resultStatus = WARNING,
        groupType = GroupType.DOC_THEME,
        controlType = ControlType.DOC_THEME_NOT_EMPTY,
        checkFieldName = "docTheme",
        checkMessage = MessageType.EMPTY
    ),
    DOC_THEME_MAX_LENGTH(
        resultStatus = INVALID,
        groupType = GroupType.DOC_THEME,
        controlType = ControlType.DOC_THEME_LENGTH,
        checkFieldName = "docTheme",
        checkMessage = MessageType.LENGTH_MAX
    ),
    DOC_THEME_AVAILABLE_SYMBOLS(
        resultStatus = INVALID,
        groupType = GroupType.DOC_THEME,
        controlType = ControlType.DOC_THEME_AVAILABLE_SYMBOLS,
        checkFieldName = "docTheme",
        checkMessage = MessageType.SYMBOLS_DELETE
    ),
    //endregion

    //region Document text
    DOC_TEXT_EMPTY(
        resultStatus = WARNING,
        groupType = GroupType.DOC_TEXT,
        controlType = ControlType.DOC_TEXT_NOT_EMPTY,
        checkFieldName = "docText",
        checkMessage = MessageType.EMPTY
    ),
    DOC_TEXT_MAX_LENGTH(
        resultStatus = INVALID,
        groupType = GroupType.DOC_TEXT,
        controlType = ControlType.DOC_TEXT_LENGTH,
        checkFieldName = "docText",
        checkMessage = MessageType.LENGTH_MAX
    ),
    DOC_TEXT_AVAILABLE_SYMBOLS(
        resultStatus = INVALID,
        groupType = GroupType.DOC_TEXT,
        controlType = ControlType.DOC_TEXT_AVAILABLE_SYMBOLS,
        checkFieldName = "docText",
        checkMessage = MessageType.SYMBOLS_DELETE
    ),
    //endregion

    //region Contact name
    CONTACT_NAME_EMPTY(
        resultStatus = WARNING,
        groupType = GroupType.CONTACT_NAME,
        controlType = ControlType.CONTACT_NAME_NOT_EMPTY,
        checkFieldName = "contactName",
        checkMessage = MessageType.EMPTY
    ),
    CONTACT_NAME_AVAILABLE_SYMBOLS(
        resultStatus = INVALID,
        groupType = GroupType.CONTACT_NAME,
        controlType = ControlType.CONTACT_NAME_AVAILABLE_SYMBOLS,
        checkFieldName = "contactName",
        checkMessage = MessageType.SYMBOLS_DELETE
    ),
    ///endregion

    //region Contact phone
    CONTACT_PHONE_EMPTY(
        resultStatus = WARNING,
        groupType = GroupType.CONTACT_PHONE,
        controlType = ControlType.CONTACT_PHONE_NOT_EMPTY,
        checkFieldName = "contactPhone",
        checkMessage = MessageType.EMPTY
    ),
    CONTACT_PHONE_MAX_LENGTH(
        resultStatus = INVALID,
        groupType = GroupType.CONTACT_PHONE,
        controlType = ControlType.CONTACT_PHONE_LENGTH,
        checkFieldName = "contactPhone",
        checkMessage = MessageType.LENGTH_MAX
    ),
    CONTACT_PHONE_AVAILABLE_SYMBOLS(
        resultStatus = INVALID,
        groupType = GroupType.CONTACT_PHONE,
        controlType = ControlType.CONTACT_PHONE_AVAILABLE_SYMBOLS,
        checkFieldName = "contactPhone",
        checkMessage = MessageType.SYMBOLS_DELETE
    ),
    //endregion

    //region Customer
    CUSTOMER_NAME_EMPTY(
        resultStatus = INVALID,
        groupType = GroupType.CUSTOMER,
        controlType = ControlType.CUSTOMER_NAME_NOT_EMPTY,
        checkFieldName = "customerName",
        checkMessage = MessageType.CUSTOMER_NAME_EMPTY
    ),
    CUSTOMER_IN_DICTIONARY(
        resultStatus = INVALID,
        groupType = GroupType.CUSTOMER,
        controlType = ControlType.CUSTOMER_IN_DICTIONARY,
        checkMessage = MessageType.CUSTOMER_IN_DICTIONARY
    ),
    CUSTOMER_NOT_BLOCKED(
        resultStatus = INVALID,
        groupType = GroupType.CUSTOMER,
        controlType = ControlType.CUSTOMER_NOT_BLOCKED,
        checkFieldName = "customerName",
        checkMessage = MessageType.EMPTY_OR_SPACES
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
    BRANCH_NAME_IN_DICTIONARY(
        resultStatus = INVALID,
        groupType = GroupType.BRANCH,
        controlType = ControlType.BRANCH_IN_DICTIONARY,
        checkMessage = MessageType.BRANCH_IN_DICTIONARY
    ),
    CUSTOMER_RELATED_TO_BRANCH(
        resultStatus = WARNING,
        groupType = GroupType.BRANCH,
        controlType = ControlType.CUSTOMER_RELATED_TO_BRANCH,
        checkFieldName = "branchName",
        checkMessage = MessageType.STUB
    ),
    //endregion

    //region Common
    DOCUMENT_UNIQUE(
        resultStatus = INVALID, // (!) also triggers DOC_NUMBER_UNIQUE_IN_YEAR control check (!)
        groupType = GroupType.COMMON,
        controlCheckResult = NOT_CHECKED,
        controlType = ControlType.DOCUMENT_UNIQUE,
        checkFieldName = "UNKNOWN FIELD REFERENCE",
        checkMessage = MessageType.STUB
    ),
    //endregion
    ;
}