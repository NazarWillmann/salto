package ooo.jtc.testdata.letters.tobank

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.generic.attachments.concatFileNames
import ooo.jtc.letters.dto.LetterToBankDto

/**
 * Numbers are a reference to https://confluence.jtc.ooo/pages/viewpage.action?pageId=19170978
 */
enum class LetterToBankFilterParams(
    override var field: String,
    override var fieldDataProvider: (LetterToBankDto) -> Any
) : IFilterParams<LetterToBankDto> {

    // common document filter-params
    ID("id", fieldDataProvider = { it.id!! }),                                          //1.1
    DOCUMENT_NUMBER("documentNumber", fieldDataProvider = { it.documentNumber }),       //1.2
    DOCUMENT_DATE("documentDate", fieldDataProvider = { it.documentDate }),             //1.3

    // other filter-params
    STATUS("status", fieldDataProvider = { it.status!! }),                              //1.4
    DOC_TYPE("docType", fieldDataProvider = { it.docType ?: "" }),                      //1.5
    DOC_TYPE_DESCRIPTION("docTypeDescription", { it.docTypeDescription ?: "" }),        //1.6
    DOC_THEME("docTheme", fieldDataProvider = { it.docTheme ?: "" }),                   //1.7
    DOC_TEXT("docText", fieldDataProvider = { it.docText ?: "" }),                      //1.8
    IS_HAS_ATTACH("isHasAttach", fieldDataProvider = { it.isHasAttach ?: false }),      //1.9

    CUSTOMER_ID("customerId", fieldDataProvider = { it.customerId!! }),                 //2.1
    CUSTOMER_NAME("customerName", fieldDataProvider = { it.customerName ?: "" }),       //2.2

    CONTACT_NAME("contactName", fieldDataProvider = { it.contactName ?: "" }),          //3.1
    CONTACT_PHONE("contactPhone", fieldDataProvider = { it.contactPhone ?: "" }),        //3.2

    BRANCH_ID("branchId", fieldDataProvider = { it.branchId!! }),                       //4.1
    BRANCH_NAME("branchName", fieldDataProvider = { it.branchName ?: "" }),             //4.2

    LETTER_FROM_BANK_ID("letterFromBankId", { it.letterFromBankId!! }),                 //5.1

    CREATED_AT("createdAt", fieldDataProvider = { it.createdAt!! }),                    //6.1
    //CHANNEL("channel", fieldDataProvider = { it.??? }),                                           //6.2

    RECEIVE_DATE("receiveDate", { it.receiveDate ?: "" }),               //7.1
    //RECEIVE_USER_ID("receiveUserId", { it.<getReceiveTicket>().receiveUserId!! }),                //7.2
    //RECEIVE_MESSAGE("receiveMessage", { it.<getReceiveTicket>().receiveMessage ?: "" }),          //7.3
    //SIGN_CHECK_MESSAGE("signCheckMessage", {it.<getReceiveTicket>().signCheckMessage ?: ""}),     //7.4
    //CONTROL_CHECK_MESSAGE("cpmString", {it.<getReceiveTicket>().cpmString ?: ""}),                //7.5

    EXECUTION_DATE("executionDate", { it.executionDate ?: "" }),         //8.1
    //EXECUTION_USER_ID("executionUserId", { it.<getExecutionTicket>().executionUserId!! }),        //8.2
    //EXECUTION_MESSAGE("executionMessage", { it.<getExecutionTicket>().executionMessage ?: "" }),  //8.3

    ATTACH_FILE_NAME("attachName", { it.attachments?.concatFileNames() ?: "" }),        //9.1

    IS_FAVORITES("isFavorites", fieldDataProvider = { it.isFavorites ?: false }),
    ;

    //TODO Sergeyev [2020.08.13]: <getReceiveTicket>; <getExecutionTicket>
}