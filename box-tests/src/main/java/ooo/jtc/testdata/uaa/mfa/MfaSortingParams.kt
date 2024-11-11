package ooo.jtc.testdata.uaa.mfa

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.uaa.mfa.dto.MfaDto

enum class MfaSortingParams(
    override var field: String,
    override var fieldDataProvider: (MfaDto) -> Any?
) : ISortingParams<MfaDto> {

    ID("id", fieldDataProvider = { it.id!! }),
    MFA_TYPE("mfaType", fieldDataProvider = { it.mfaType }),
    NAME("name", fieldDataProvider = { it.name }),
    TITLE("title", fieldDataProvider = { it.title }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;

}