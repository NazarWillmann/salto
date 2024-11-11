package ooo.jtc.testdata.dictionaries.identitydocumenttype

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.identitydocumenttype.IdentityDocumentTypeDto

enum class IdentityDocumentTypeSortingParams(
    override var field: String,
    override var fieldDataProvider: (IdentityDocumentTypeDto) -> Any?
) : ISortingParams<IdentityDocumentTypeDto> {
    NAME("name", fieldDataProvider = { it.name }),
    TYPE_CODE("typeCode", fieldDataProvider = { it.typeCode }),
    USAGE_LIMIT("usageLimit", fieldDataProvider = { it.usageLimit }),
    IS_HIDDEN("isHidden", fieldDataProvider = { it.isHidden });
}