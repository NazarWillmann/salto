package ooo.jtc.testdata.dictionaries.contractor

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.contractor.ContractorDto

enum class ContractorSortingParams(
    override var field: String,
    override var fieldDataProvider: (ContractorDto) -> Any?
) : ISortingParams<ContractorDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CUSTOMER_ID("customerId", fieldDataProvider = { it.customerId }),
    NAME("name", fieldDataProvider = { it.name }),
    INN("inn", fieldDataProvider = { it.inn }),
    KPP("kpp", fieldDataProvider = { it.kpp }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    IS_FAVORITE("isFavorites", fieldDataProvider = { it.isFavorites }),
    ;
}
