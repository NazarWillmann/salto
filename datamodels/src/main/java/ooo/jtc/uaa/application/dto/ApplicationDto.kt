package ooo.jtc.uaa.application.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.UaaNames
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.uaa.application.model.Application
import java.util.*

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityName(UaaNames.APPLICATION)
data class ApplicationDto(
    override var id: UUID?,
    @NotRequiredForTest override var version: Int,
    val name: String,
    val description: String,
    @NotRequiredForTest var allowedFlows: List<AllowedFlows>,
    val redirectUrls: String?,
    @NotRequiredForTest var availableResources: List<UUID?>,
    @NotRequiredForTest var availableCatalogs: List<UUID?>,
    val autoApproveScopes: Boolean,
    val accessTokenLifeTime: Int?,
    val refreshTokenLifeTime: Int?,
    val sessionLifeTime: Int?,
    val loginSite: ApplicationLoginSiteDto,
    val clientId: UUID?,
    @NotRequiredForTest val clientSecret: String?
) : UpdateIEntityDto<ApplicationDto> {
    override fun toModel(): Application {
        return Mappers.applicationMapper.toDomainModel(this)
    }
}

@KotlinBuilder
data class ApplicationLoginSiteDto(
    val baseUrl: String?,
    val loginPath: String?,
    val approvePath: String?,
    val mfaPath: String?,
    val smsMfaPath: String?,
    val paramsViaFragment: Boolean?
)

enum class AllowedFlows {
    Implicit, RefreshToken, AuthorizationCode, ResourceOwner
}