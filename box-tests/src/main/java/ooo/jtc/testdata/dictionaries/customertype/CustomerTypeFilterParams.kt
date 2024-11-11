package ooo.jtc.testdata.dictionaries.customertype

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.customertype.CustomerTypeDto

enum class CustomerTypeFilterParams(
    override var field: String,
    override var fieldDataProvider: (CustomerTypeDto) -> Any
) : IFilterParams<CustomerTypeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    NAME("name", fieldDataProvider = { it.name }),
    SYSTEM_NAME("systemName", fieldDataProvider = { it.systemName }),
    ;

}