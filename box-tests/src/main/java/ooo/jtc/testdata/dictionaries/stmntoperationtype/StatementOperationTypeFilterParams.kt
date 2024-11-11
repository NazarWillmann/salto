package ooo.jtc.testdata.dictionaries.stmntoperationtype

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.stmntoperationtype.StatementOperationTypeDto

enum class StatementOperationTypeFilterParams(
    override var field: String,
    override var fieldDataProvider: (StatementOperationTypeDto) -> Any
) : IFilterParams<StatementOperationTypeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;
}