package ooo.jtc.testdata.rupayment

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.generic.amount
import ooo.jtc.rupayment.dto.RuPaymentDto

enum class RuPaymentSortingParams(
    override var field: String,
    override var fieldDataProvider: (RuPaymentDto) -> Any?
) : ISortingParams<RuPaymentDto> {
    DOCUMENT_NUMBER("documentNumber", fieldDataProvider = { it.documentNumber }),
    DOCUMENT_DATE("documentDate", fieldDataProvider = { it.documentDate }),
    CUSTOMER_ID("customerId", fieldDataProvider = { it.customerId }),
    BRANCH_ID("branchId", fieldDataProvider = { it.branchId }),
    STATUS("status", fieldDataProvider = { it.status }),
    IS_FAVORITES("isFavorites", fieldDataProvider = { it.isFavorites }),
    AMOUNT("amount", fieldDataProvider = { amount(it.amount) }),
    PAYMENT_GROUND_DESCRIPTION("paymentGround.description", fieldDataProvider = { it.paymentGround!!.description }),
    RECEIVER_NAME("receiver.name", fieldDataProvider = { it.receiver!!.name }),
    RECEIVER_INN("receiver.inn", fieldDataProvider = { it.receiver!!.inn }),
    RECEIVER_ACCOUNT("receiver.account", fieldDataProvider = { it.receiver!!.account }),
    RECEIVER_BANK_NAME("receiver.bank.name", fieldDataProvider = { it.receiver!!.bank.name }),
    RECEIVER_BANK_BIC("receiver.bank.bic", fieldDataProvider = { it.receiver!!.bank.bic }),
    ;

}