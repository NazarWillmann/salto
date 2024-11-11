package ooo.jtc.testdata.dictionaries.salarypaymenttype

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.salarypaymenttype.SalaryPaymentTypeDto

enum class SalaryPaymentTypeFilterParams(
    override var field: String,
    override var fieldDataProvider: (SalaryPaymentTypeDto) -> Any
) : IFilterParams<SalaryPaymentTypeDto> {
    CODE("code", fieldDataProvider = { it.code!! }),
    NAME("name", fieldDataProvider = { it.name!! }),
    INCOME_TYPE_CODE("incomeTypeCode", fieldDataProvider = { it.incomeTypeCode!! }),

}