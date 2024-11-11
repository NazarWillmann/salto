package ooo.jtc.testdata.dictionaries.identitydocumenttype

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.identitydocumenttype.IdentityDocumentTypeDto

enum class IdentityDocumentTypeFilterParams(
    override var field: String,
    override var fieldDataProvider: (IdentityDocumentTypeDto) -> Any
) : IFilterParams<IdentityDocumentTypeDto> {
    NAME("name", fieldDataProvider = { it.name }),
    SYSTEM_NAME("systemName", fieldDataProvider = { it.systemName!! }),
    TYPE_CODE("typeCode", fieldDataProvider = { it.typeCode!! }),
    USAGE_LIMIT("usageLimit", fieldDataProvider = { it.usageLimit!!.name }),
    IS_HIDDEN("isHidden", fieldDataProvider = { it.isHidden });
}