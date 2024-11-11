package ooo.jtc.testdata.dictionaries.gozcontract

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.gozcontract.GozContractDto

enum class GozContractFilterParams(
    override var field: String,
    override var fieldDataProvider: (GozContractDto) -> Any
) : IFilterParams<GozContractDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    NUMBER("number", fieldDataProvider = { it.number })
}