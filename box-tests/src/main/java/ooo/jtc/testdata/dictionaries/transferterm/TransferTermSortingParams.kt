package ooo.jtc.testdata.dictionaries.transferterm

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.transferterm.TransferTermDto

enum class TransferTermSortingParams(
    override var field: String,
    override var fieldDataProvider: (TransferTermDto) -> Any?
) : ISortingParams<TransferTermDto> {

    CODE("code", fieldDataProvider = { it.code }),
    DESCRIPTION("description", fieldDataProvider = { it.description });
}