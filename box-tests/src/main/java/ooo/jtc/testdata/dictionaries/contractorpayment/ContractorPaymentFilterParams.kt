package ooo.jtc.testdata.dictionaries.contractorpayment

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.contractorpayment.ContractorPaymentDto

enum class ContractorPaymentFilterParams(
    override var field: String,
    override var fieldDataProvider: (ContractorPaymentDto) -> Any
) : IFilterParams<ContractorPaymentDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    ACCOUNT("account", fieldDataProvider = { it.account }),
    BANK_ADDRESS("bankAddress", fieldDataProvider = { it.bankAddress }),
    BANK_NAME("bankName", fieldDataProvider = { it.bankName }),
    BIC("bic", fieldDataProvider = { it.bic }),
    CONTRACTOR_ID("contractorId", fieldDataProvider = { it.contractorId }),
    CORR_ACCOUNT("corrAccount", fieldDataProvider = { it.corrAccount ?: "" }),
    IS_DEFAULT("isDefault", fieldDataProvider = { it.isDefault }),
    ;
}

