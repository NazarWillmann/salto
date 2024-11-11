package ooo.jtc.testdata.dictionaries.stmntoperationtype

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.stmntoperationtype.StatementOperationTypeDto

enum class StatementOperationTypeSortingParams(
    override var field: String,
    override var fieldDataProvider: (StatementOperationTypeDto) -> Any?
) : ISortingParams<StatementOperationTypeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;
}