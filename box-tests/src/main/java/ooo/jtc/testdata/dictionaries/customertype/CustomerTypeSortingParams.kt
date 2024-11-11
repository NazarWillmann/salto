package ooo.jtc.testdata.dictionaries.customertype

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.customertype.CustomerTypeDto

enum class CustomerTypeSortingParams(
    override var field: String,
    override var fieldDataProvider: (CustomerTypeDto) -> Any?
) : ISortingParams<CustomerTypeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    NAME("name", fieldDataProvider = { it.name }),
    SYSTEM_NAME("systemName", fieldDataProvider = { it.systemName }),
    ;

}