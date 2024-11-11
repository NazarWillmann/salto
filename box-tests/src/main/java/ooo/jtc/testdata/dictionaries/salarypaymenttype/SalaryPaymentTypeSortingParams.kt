package ooo.jtc.testdata.dictionaries.salarypaymenttype

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.salarypaymenttype.SalaryPaymentTypeDto

enum class SalaryPaymentTypeSortingParams(
    override var field: String,
    override var fieldDataProvider: (SalaryPaymentTypeDto) -> Any?
) : ISortingParams<SalaryPaymentTypeDto> {
    CODE("code", fieldDataProvider = { it.code }),
    NAME("name", fieldDataProvider = { it.name }),
    INCOME_TYPE_CODE("incomeTypeCode", fieldDataProvider = { it.incomeTypeCode }),
}
