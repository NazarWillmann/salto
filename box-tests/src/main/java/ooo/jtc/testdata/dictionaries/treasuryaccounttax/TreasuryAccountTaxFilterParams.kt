package ooo.jtc.testdata.dictionaries.treasuryaccounttax

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.treasuryaccounttax.TreasuryAccountTaxDto

enum class TreasuryAccountTaxFilterParams(
    override var field: String,
    override var fieldDataProvider: (TreasuryAccountTaxDto) -> Any
) : IFilterParams<TreasuryAccountTaxDto> {

    TOFK("tofk", fieldDataProvider = { it.tofk!! }),
    ACCOUNT("account", fieldDataProvider = { it.account!! }),
    BANK_NAME("bankName", fieldDataProvider = { it.bankName!! }),
    BIC("bic", fieldDataProvider = { it.bic!! }),
    UTRA_ACCOUNT("utraAccount", fieldDataProvider = { it.utraAccount!! });
}
