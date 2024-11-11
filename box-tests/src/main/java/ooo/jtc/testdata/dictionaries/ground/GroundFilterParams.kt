package ooo.jtc.testdata.dictionaries.ground

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.ground.GroundDto

enum class GroundFilterParams(
    override var field: String,
    override var fieldDataProvider: (GroundDto) -> Any
) : IFilterParams<GroundDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CONTRACTOR_ID("contractorId", fieldDataProvider = { it.contractorId ?: "" }),
    CUSTOMER_ID("customerId", fieldDataProvider = { it.customerId }),
    DESCRIPTION("description", fieldDataProvider = { it.description ?: "" }),
    ;
}