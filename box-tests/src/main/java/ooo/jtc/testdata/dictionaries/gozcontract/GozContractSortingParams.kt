package ooo.jtc.testdata.dictionaries.gozcontract

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.gozcontract.GozContractDto

enum class GozContractSortingParams(
    override var field: String,
    override var fieldDataProvider: (GozContractDto) -> Any?
) : ISortingParams<GozContractDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    NUMBER("number", fieldDataProvider = { it.number })
}