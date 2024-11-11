package ooo.jtc.testdata.dictionaries.ground

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.ground.GroundDto

enum class GroundSortingParams(
    override var field: String,
    override var fieldDataProvider: (GroundDto) -> Any?
) : ISortingParams<GroundDto> {
    ID("id", fieldDataProvider = { it.id }),
    CONTRACTOR_ID("contractorId", fieldDataProvider = { it.contractorId }),
    CUSTOMER_ID("customerId", fieldDataProvider = { it.customerId }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;
}