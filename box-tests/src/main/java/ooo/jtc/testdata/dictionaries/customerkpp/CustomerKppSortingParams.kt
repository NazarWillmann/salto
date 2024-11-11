package ooo.jtc.testdata.dictionaries.customerkpp

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.customerkpp.CustomerKppDto

enum class CustomerKppSortingParams(
    override var field: String,
    override var fieldDataProvider: (CustomerKppDto) -> Any?
) : ISortingParams<CustomerKppDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    KPP("kpp", fieldDataProvider = { it.kpp }),
    UNIT_NAME("unitName", fieldDataProvider = { it.unitName }),
    IS_DEFAULT("isDefault", fieldDataProvider = { it.isDefault }),
    ;
}