package ooo.jtc.testdata.dictionaries.customerkpp

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.customerkpp.CustomerKppDto

enum class CustomerKppFilterParams(
    override var field: String,
    override var fieldDataProvider: (CustomerKppDto) -> Any
) : IFilterParams<CustomerKppDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    KPP("kpp", fieldDataProvider = { it.kpp }),
    UNIT_NAME("unitName", fieldDataProvider = { it.unitName!! }),
    IS_DEFAULT("isDefault", fieldDataProvider = { it.isDefault }),
    ;
}