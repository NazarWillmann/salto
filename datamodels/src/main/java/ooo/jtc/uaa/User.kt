package ooo.jtc.uaa

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.interfaces.IEntity
import ooo.jtc.uaa.catalog.model.Catalog
import ooo.jtc.uaa.catalog.model.DefaultCatalog
import ooo.jtc.uaa.resource.model.Audience
import ooo.jtc.uaa.user.dto.UserDetails
import java.util.UUID

interface User : IEntity {

    override var id: UUID?

    override var version: Int

    var login: String

    var password: String

    var catalogId: UUID

    var domain: String

    var userType: UserType

    var bearer: String?

    var userDetails: UserDetails?

    var uaaUserId: UUID?

    var isBank: Boolean

    var isClient: Boolean

}

enum class UserType(val pathPrefix: String, val catalogs: List<DefaultCatalog>) {
    BANK("bank", listOf(DefaultCatalog.BANK, DefaultCatalog.LDAP, DefaultCatalog.TECHNICAL)),
    CLIENT("client", listOf(DefaultCatalog.CLIENT, DefaultCatalog.GOOGLE, DefaultCatalog.AUTH0)),
    INDIVIDUAL("individual", listOf(DefaultCatalog.INDIVIDUAL));

    companion object {
        fun getByCatalog(defaultCatalog: DefaultCatalog): UserType {
            return values().find { it.catalogs.contains(defaultCatalog) }
                ?: throw RuntimeException("Can't find a UserType by catalogName - $defaultCatalog. Check the declared catalogs in the UserType enum.")
        }
    }
}


@JsonIgnoreProperties(ignoreUnknown = true)
data class StoredUser(
    override var id: UUID?,
    override var version: Int,
    override var domain: String = "",
    override var userType: UserType,
    override var bearer: String?,
    override var login: String,
    override var password: String,
    @JsonProperty("id_user") override var uaaUserId: UUID?,
    @JsonProperty("id_catalog") override var catalogId: UUID,
    @JsonProperty("cat_name") var catalogName: String?,
    override var userDetails: UserDetails?,
    override var isBank: Boolean,
    override var isClient: Boolean
) : User {
    constructor(login: String, password: String, userType: UserType, catalog: Catalog, audience: Audience, userDetails: UserDetails? = null)
            : this(
        null, 0, audience.value, userType, null, login, password, null, catalog.id!!, catalog.name, userDetails,
        isBank = UserType.BANK == userType,
        isClient = UserType.CLIENT == userType
    )

    @JsonIgnore
    @NotRequiredForTest
    override val entityName = "Stored user"
}

@JsonIgnoreProperties(ignoreUnknown = true)
data class LdapUser(
    override var id: UUID?,
    override var version: Int,
    override var domain: String = "",
    override var userType: UserType,
    override var bearer: String?,
    override var login: String,
    override var password: String,
    @JsonProperty("id_user") override var uaaUserId: UUID?,
    @JsonProperty("id_catalog") override var catalogId: UUID,
    @JsonProperty("cat_name") var catalogName: String?,
    override var userDetails: UserDetails?,
    override var isBank: Boolean,
    override var isClient: Boolean
) : User {
    constructor(login: String, password: String, userType: UserType, catalog: Catalog, audience: Audience, userDetails: UserDetails? = null)
            : this(
        null, 0, audience.value, userType, null, login, password, null, catalog.id!!, catalog.name, userDetails,
        isBank = UserType.BANK == userType,
        isClient = UserType.CLIENT == userType
    )

    @JsonIgnore
    @NotRequiredForTest
    override val entityName = "Ldap user"
}

fun <T : User> T.withDomain(audience: Audience): T {
    this.domain = audience.value
    return this
}