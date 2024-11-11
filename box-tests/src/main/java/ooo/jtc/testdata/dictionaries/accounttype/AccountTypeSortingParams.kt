package ooo.jtc.testdata.dictionaries.accounttype

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.accountype.AccountTypeDto

enum class AccountTypeSortingParams(
    override var field: String,
    override var fieldDataProvider: (AccountTypeDto) -> Any?
) : ISortingParams<AccountTypeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    FULL_NAME("fullName", fieldDataProvider = { it.fullName }),
    SHORT_NAME("shortName", fieldDataProvider = { it.shortName }),
    SYSTEM_NAME("systemName", fieldDataProvider = { it.systemName }),
    CLIENT_TYPE("clientType", fieldDataProvider = { it.clientType }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;
}