package ooo.jtc.testdata.uaa.mfa

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.uaa.mfa.dto.MfaDto

enum class MfaFilterParams(
    override var field: String,
    override var fieldDataProvider: (MfaDto) -> Any
) : IFilterParams<MfaDto> {

    ID("id", fieldDataProvider = { it.id!! }),
    MFA_TYPE("mfaType", fieldDataProvider = { it.mfaType }),
    NAME("name", fieldDataProvider = { it.name }),
    TITLE("title", fieldDataProvider = { it.title }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;
}