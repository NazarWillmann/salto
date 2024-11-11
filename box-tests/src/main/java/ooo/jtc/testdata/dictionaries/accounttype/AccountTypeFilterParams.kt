package ooo.jtc.testdata.dictionaries.accounttype

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.accountype.AccountTypeDto

enum class AccountTypeFilterParams(
    override var field: String,
    override var fieldDataProvider: (AccountTypeDto) -> Any
) : IFilterParams<AccountTypeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    FULL_NAME("fullName", fieldDataProvider = { it.fullName }),
    SHORT_NAME("shortName", fieldDataProvider = { it.shortName }),
    SYSTEM_NAME("systemName", fieldDataProvider = { it.systemName }),
    CLIENT_TYPE("clientType", fieldDataProvider = { it.clientType }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;

}
