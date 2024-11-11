package ooo.jtc.testdata.letters.frombank

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.generic.attachments.concatFileNames
import ooo.jtc.letters.dto.LetterFromBankDto

/** Numbers are a reference to https://confluence.jtc.ooo/pages/viewpage.action?pageId=19170999 */
enum class LetterFromBankFilterParams(
    override var field: String,
    override var fieldDataProvider: (LetterFromBankDto) -> Any
) : IFilterParams<LetterFromBankDto> {
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

    BRANCH_ID("branchId", fieldDataProvider = { it.branchId!! }),                       //2.1
    BRANCH_NAME("branchName", fieldDataProvider = { it.branchName ?: "" }),             //2.2

    CONTACT_NAME("contactName", fieldDataProvider = { it.contactName ?: "" }),          //3.1
    CONTACT_PHONE("contactPhone", fieldDataProvider = { it.contactPhone ?: "" }),       //3.2

    CUSTOMER_ID("customerId", fieldDataProvider = { it.customerId!! }),                 //4.1
    CUSTOMER_NAME("customerName", fieldDataProvider = { it.customerName ?: "" }),       //4.2

    LETTER_TO_BANK_ID("letterToBankId", { it.letterToBankId!! }),                       //5.1

    CREATED_AT("createdAt", fieldDataProvider = { it.createdAt!! }),                    //6.1
    //CHANNEL("channel", fieldDataProvider = { it.??? }),                                      //6.2

    SEND_DATE("sendDate", { it.sendDate ?: "" }),                                       //7.1
    //SEND_USER_ID("sendUserId", { it.<getSendTicket>().sendUserId!! }),                       //7.2
    //SEND_MESSAGE("sendMessage", { it.<getSendTicket>().sendMessage ?: "" }),                 //7.3
    //SIGN_CHECK_MESSAGE("signCheckMessage", {it.<getSendTicket>().signCheckMessage ?: ""}),   //7.4
    //CONTROL_CHECK_MESSAGE("cpmString", {it.<getSendTicket>().cpmString ?: ""}),              //7.5

    ATTACH_FILE_NAME("attachName", { it.attachments?.concatFileNames() ?: "" }),        //8.1

    IS_FAVORITES("isFavorites", fieldDataProvider = { it.isFavorites ?: false }),
    ;

    //TODO Sergeyev [2020.10.06]: <getSendTicket>
}