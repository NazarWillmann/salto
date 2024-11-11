package ooo.jtc.uaa.application.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.UaaNames
import ooo.jtc.interfaces.ITransferEntity
import ooo.jtc.uaa.application.dto.AllowedFlows
import ooo.jtc.uaa.application.dto.ApplicationDto
import java.sql.Timestamp
import java.util.*

/**
 * Application model.
 * Has fields that fills in [ApplicationData#dbResultPostProcessor]
 */
@KotlinBuilder
data class Application(
    override var id: UUID?,
    override var version: Int,
    var name: String,
    @JsonProperty("client_id") var clientId: UUID,
    @JsonProperty("client_secret") var clientSecret: String,
    @JsonProperty("redirect_urls") var redirectUrls: String?,
    @JsonProperty("auto_approve") var autoApprove: Boolean,
    @JsonProperty("access_token_lifetime") var accessTokenLifeTime: Int?,
    @JsonProperty("description") var description: String,
    @JsonProperty("base_url") var baseUrl: String?,
    @JsonProperty("login_path") var loginPath: String?,
    @JsonProperty("approve_path") var approvePath: String?,
    @JsonProperty("mfa_path") var mfaPath: String?,
    @JsonProperty("sms_mfa_path") var smsMfaPath: String?,
    @JsonProperty("params_via_fragment") var paramsViaFragment: Boolean?,
    @JsonProperty("created_at") var createdAt: Timestamp?,
    @JsonProperty("deleted_at") var deletedAt: Timestamp?,
    @JsonProperty("session_lifetime") var sessionLifeTime: Int?,
    @JsonProperty("refresh_token_lifetime") var refreshTokenLifeTime: Int?,
    // fills in [dbResultPostProcessor]
    val allowedFlows: List<AllowedFlows?>,
    val availableResources: List<UUID?>,
    val availableCatalogs: List<UUID?>
) : ITransferEntity {
    override fun toDto(): ApplicationDto {
        return Mappers.applicationMapper.toDto(this)
    }

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = UaaNames.APPLICATION
}

enum class ApplicationName(@get:JsonValue var value: String) {

    BANK("Salto bank portal"),
    CLIENT("Salto customer portal"),
    INDIVIDUAL("Salto individual portal"),
    SERVER("Salto server side application"),
    SOME("Some application");

    companion object {
        fun getByValue(name: String): ApplicationName {
            return values().find { it.value == name } ?: throw RuntimeException("ApplicationName not found by $name")
        }
    }
}
