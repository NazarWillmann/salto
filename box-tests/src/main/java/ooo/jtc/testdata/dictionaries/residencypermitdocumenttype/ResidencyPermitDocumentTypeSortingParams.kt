package ooo.jtc.testdata.dictionaries.residencypermitdocumenttype

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.residencypermitdocumenttype.ResidencyPermitDocumentTypeDto

enum class ResidencyPermitDocumentTypeSortingParams(
    override var field: String,
    override var fieldDataProvider: (ResidencyPermitDocumentTypeDto) -> Any?
) : ISortingParams<ResidencyPermitDocumentTypeDto> {

    NAME("name", fieldDataProvider = { it.name }),
    SYSTEM_NAME("systemName", fieldDataProvider = { it.systemName });
}