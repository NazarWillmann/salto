package ooo.jtc.testdata.dictionaries.transferterm

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.transferterm.TransferTermDto

enum class TransferTermFilterParams(
    override var field: String,
    override var fieldDataProvider: (TransferTermDto) -> Any
) : IFilterParams<TransferTermDto> {

    CODE("code", fieldDataProvider = { it.code!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description!! });
}
