package ooo.jtc.testdata.uaa.application

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.uaa.application.dto.ApplicationDto

enum class ApplicationFilterParams(
    override var field: String,
    override var fieldDataProvider: (ApplicationDto) -> Any
) : IFilterParams<ApplicationDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CLIENT_ID("clientId", fieldDataProvider = { it.clientId!! }),
    ACCESS_TOKEN_LIFE_TIME("accessTokenLifeTime", fieldDataProvider = { it.accessTokenLifeTime!! }),
    AUTO_APPROVE_SCOPES("autoApproveScopes", fieldDataProvider = { it.autoApproveScopes }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    NAME("name", fieldDataProvider = { it.name }),
    REDIRECT_URLS("redirectUrls", fieldDataProvider = { it.redirectUrls ?: "" }),
    ;
}