package ooo.jtc.testdata.curtransfer

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.curtransfer.dto.CurTransferDto

/**
 * [2021.01.23] Numbers are a reference to https://confluence.jtc.ooo/pages/viewpage.action?pageId=21730727
 */
enum class CurTransferSortingParams(
    override var field: String,
    override var fieldDataProvider: (CurTransferDto) -> Any?
) : ISortingParams<CurTransferDto> {

    //region Table 1.1: common document filter-params;
    ID("id", fieldDataProvider = { it.id!! }),                                          //1.1
    DOCUMENT_DATE("documentDate", fieldDataProvider = { it.documentDate }),             //1.2
    DOCUMENT_NUMBER("documentNumber", fieldDataProvider = { it.documentNumber }),       //1.3
    STATUS("status", fieldDataProvider = { it.status!! }),                              //1.4
    //endregion


    //region (also) Table 1.1: other (document) filter-params;
    CUSTOMER_ID("customerId", fieldDataProvider = { it.customerId }),                   //2.1
    CUSTOMER_NAME("customerName", fieldDataProvider = { it.customerName }),             //2.2

    BRANCH_ID("branchId", fieldDataProvider = { it.branchId }),                         //3.1
    BRANCH_NAME("branchName", fieldDataProvider = { it.branchName }),                   //3.2

    CREATED_AT("createdAt", fieldDataProvider = { it.createdAt }),                      //4.1
    //CHANNEL("channel", fieldDataProvider = { it.??? }),                                       //4.2

    RECEIVE_DATE("receiveDate", { it.receiveDate }),                                    //5.1
    //RECEIVE_USER_ID("receiveUserId", { it.<getReceiveTicket>().receiveUserId }),              //5.2
    //RECEIVE_MESSAGE("receiveMessage", { it.<getReceiveTicket>().receiveMessage }),            //5.3
    //SIGN_CHECK_MESSAGE("signCheckMessage", {it.<getReceiveTicket>().signCheckMessage }),      //5.4
    //CONTROL_CHECK_MESSAGE("cpmString", {it.<getReceiveTicket>().cpmString }),                 //5.5

    EXECUTION_DATE("executionDate", { it.executionDate }),                              //6.1
    //EXECUTION_USER_ID("executionUserId", { it.<getExecutionTicket>().executionUserId }),      //6.2
    //EXECUTION_MESSAGE("executionMessage", { it.<getExecutionTicket>().executionMessage }),    //6.3
    //TODO? Sergeyev [2021.01.23]: <getReceiveTicket>; <getExecutionTicket>
    //endregion


    //region Table 1.2: CurTransfer-specific filter params;
    DEBIT_AMOUNT("debit.amount", { it.debit.amount }),                                                  //1.1
    DEBIT_CURRENCY_DIGIT_CODE("debit.currency.digitCode", { it.debit.currency.digitCode }),             //1.2
    DEBIT_CURRENCY_ALPHA_CODE("debit.currency.alphaCode", { it.debit.currency.alphaCode }),             //1.3
    VALUE_DATE("valueDate", { it.valueDate }),                                                          //1.4
    URGENCY("urgency", { it.urgency }),                                                                 //1.5

    TRANSFER_AMOUNT("transfer.amount", { it.transfer.amount }),                                         //2.1
    TRANSFER_CURRENCY_DIGIT_CODE("transfer.currency.digitCode", { it.transfer.currency.digitCode }),    //2.2
    TRANSFER_CURRENCY_ALPHA_CODE("transfer.currency.alphaCode", { it.transfer.currency.alphaCode }),    //2.3

    RATE_TYPE("rateType", { it.rateType }),                                                             //3.1
    RATE("rate", { it.rate }),                                                                          //3.2

    PAYER_NAME("payer.name", { it.payer.name }),                                                        //4.1
    PAYER_ACCOUNT("payer.account", { it.payer.account }),                                               //4.2
    PAYER_INN("payer.inn", { it.payer.inn }),                                                           //4.3
    PAYER_COUNTRY_DIGIT_CODE("payer.country.digitCode", { it.payer.country.digitCode }),                //4.4
    PAYER_COUNTRY_ALPHA_CODE("payer.country.alpha2Code", { it.payer.country.alpha2Code }),              //4.5
    PAYER_COUNTRY_INT_NAME("payer.country.intNameIso", { it.payer.country.intNameIso }),                //4.6
    PAYER_CITY("payer.city", { it.payer.city }),                                                        //4.7
    PAYER_ADDRESS("payer.address", { it.payer.address }),                                               //4.8

    PAYER_BANK_NAME("payerBank.name", { it.payerBank.name }),                                           //5.1
    PAYER_BANK_SWIFT("payerBank.swift", { it.payerBank.swift }),                                        //5.2
    PAYER_BANK_COUNTRY_DIGIT_CODE("payerBank.country.digitCode", { it.payerBank.country.digitCode }),   //5.3
    PAYER_BANK_COUNTRY_ALPHA_CODE("payerBank.country.alpha2Code", { it.payerBank.country.alpha2Code }), //5.4
    PAYER_BANK_COUNTRY_INT_NAME("payerBank.country.intNameIso", { it.payerBank.country.intNameIso }),   //5.5
    PAYER_BANK_CITY("payerBank.city", { it.payerBank.city }),                                           //5.6
    PAYER_BANK_ADDRESS("payerBank.address", { it.payerBank.address }),                                  //5.7

    BENEF_NAME("beneficiary.name", { it.beneficiary.name }),                                            //6.1
    BENEF_ACCOUNT("beneficiary.account", { it.beneficiary.account }),                                   //6.2
    BENEF_COUNTRY_DIGIT_CODE("beneficiary.country.digitCode", { it.beneficiary.country.digitCode }),    //6.3
    BENEF_COUNTRY_ALPHA_CODE("beneficiary.country.alpha2Code", { it.beneficiary.country.alpha2Code }),  //6.4
    BENEF_COUNTRY_INT_NAME("beneficiary.country.intNameIso", { it.beneficiary.country.intNameIso }),    //6.5
    BENEF_CITY("beneficiary.city", { it.beneficiary.city }),                                            //6.6
    BENEF_ADDRESS("beneficiary.address", { it.beneficiary.address }),                                   //6.7

    BENEF_BANK_NAME("beneficiaryBank.name", { it.beneficiaryBank.name }),                                           //7.1
    BENEF_BANK_SWIFT("beneficiaryBank.swift", { it.beneficiaryBank.swift }),                                        //7.2
    //BENEF_BANK_ACCOUNT("beneficiaryBank.account", { it.beneficiaryBank.account }),                                  //7.3
    BENEF_BANK_COUNTRY_DIGIT_CODE("beneficiaryBank.country.digitCode", { it.beneficiaryBank.country.digitCode }),   //7.4
    BENEF_BANK_COUNTRY_ALPHA_CODE("beneficiaryBank.country.alpha2Code", { it.beneficiaryBank.country.alpha2Code }), //7.5
    BENEF_BANK_COUNTRY_INT_NAME("beneficiaryBank.country.intNameIso", { it.beneficiaryBank.country.intNameIso }),   //7.6
    BENEF_BANK_CITY("beneficiaryBank.city", { it.beneficiaryBank.city }),                                           //7.7
    BENEF_BANK_ADDRESS("beneficiaryBank.address", { it.beneficiaryBank.address }),                                  //7.8
    BENEF_BANK_CLEARING_CODE("beneficiaryBank.clearingCode", { it.beneficiaryBank.clearingCode }),                  //7.9

    INTER_BANK_NAME("intermediaryBank.name", { it.intermediaryBank.name }),                                             //8.1
    INTER_BANK_SWIFT("intermediaryBank.swift", { it.intermediaryBank.swift }),                                          //8.2
    INTER_BANK_COUNTRY_DIGIT_CODE("intermediaryBank.country.digitCode", { it.intermediaryBank.country.digitCode }),     //8.3
    INTER_BANK_COUNTRY_ALPHA_CODE("intermediaryBank.country.alpha2Code", { it.intermediaryBank.country.alpha2Code }),   //8.4
    INTER_BANK_COUNTRY_INT_NAME("intermediaryBank.country.intNameIso", { it.intermediaryBank.country.intNameIso }),     //8.5
    INTER_BANK_CITY("intermediaryBank.city", { it.intermediaryBank.city }),                                             //8.6
    INTER_BANK_ADDRESS("intermediaryBank.address", { it.intermediaryBank.address }),                                    //8.7
    INTER_BANK_CLEARING_CODE("intermediaryBank.clearingCode", { it.intermediaryBank.clearingCode }),                    //8.8

    PAYMENT_INFORMATION("paymentInformation", { it.paymentInformation }),                               //9.1

    CHARGE_TYPE("chargeType", { it.chargeType }),                                                       //10.1
    CHARGE_ACCOUNT("chargeAccount", { it.chargeAccount }),                                              //10.2
    CHARGE_BIC("chargeBic", { it.chargeBic }),                                                          //10.3

    PAYMENT_ADD_INFO("paymentAddInformation", { it.paymentAddInformation }),                            //11.1

    CONTACT_NAME("contactName", fieldDataProvider = { it.contactName }),                                //12.1
    CONTACT_PHONE("contactPhone", fieldDataProvider = { it.contactPhone }),                             //12.2
    //endregion


    //region Table 2: nested CurTransfer-specific filter params
//    CUR_REGULATION_INFO_ID("regulationInfos.id", { curTr -> curTr.regulationInfos.map { it.id } }),                         //1
//    CUR_REGULATION_INFO_OPER_CODE("regulationInfos.operCode", { curTr -> curTr.regulationInfos.map { it.operCode } }),      //2
//    CUR_REGULATION_INFO_UC_NUMBER("regulationInfos.ucNumber", { curTr -> curTr.regulationInfos.map { it.ucNumber } }),      //3
//    CUR_REGULATION_INFO_EXPECT_DATE("regulationInfos.expectDate", { curTr -> curTr.regulationInfos.map { it.expectDate } }),//4
//    CUR_REGULATION_INFO_AMOUNT("regulationInfos.amount", { curTr -> curTr.regulationInfos.map { it.amount } }),             //5
    //endregion


    IS_FAVORITES("isFavorites", fieldDataProvider = { it.isFavorites }),
    IS_RECEIVED("isReceived", fieldDataProvider = { it.isReceived }),
    IS_EXECUTED("isExecuted", fieldDataProvider = { it.isExecuted }),
    IS_DECLINED("isDeclined", fieldDataProvider = { it.isDeclined }),
    IS_NOT_RECEIVED("isNotReceived", fieldDataProvider = { it.isNotReceived }),
    IS_RECALLED("isRecalled", fieldDataProvider = { it.isRecalled }),
    ;

}