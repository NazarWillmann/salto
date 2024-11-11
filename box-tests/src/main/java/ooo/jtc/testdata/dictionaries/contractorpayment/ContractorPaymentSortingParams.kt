package ooo.jtc.testdata.dictionaries.contractorpayment

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.contractorpayment.ContractorPaymentDto

enum class ContractorPaymentSortingParams(
    override var field: String,
    override var fieldDataProvider: (ContractorPaymentDto) -> Any?
) : ISortingParams<ContractorPaymentDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    ACCOUNT("account", fieldDataProvider = { it.account }),
    BANK_ADDRESS("bankAddress", fieldDataProvider = { it.bankAddress }),
    BANK_NAME("bankName", fieldDataProvider = { it.bankName }),
    BIC("bic", fieldDataProvider = { it.bic }),
    CONTRACTOR_ID("contractorId", fieldDataProvider = { it.contractorId }),
    CORR_ACCOUNT("corrAccount", fieldDataProvider = { it.corrAccount }),
    IS_DEFAULT("isDefault", fieldDataProvider = { it.isDefault }),
    ;
}

