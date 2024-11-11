package ooo.jtc.uaa.catalog.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.extensions.toUUID
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.UaaNames
import ooo.jtc.interfaces.ITransferEntity
import ooo.jtc.uaa.catalog.dto.CatalogDto
import java.time.ZonedDateTime
import java.util.UUID

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
data class Catalog(
    override var id: UUID?,
    @NotRequiredForTest override var version: Int,
    val name: String,
    @JsonProperty("cat_kind") val catalogKind: UserCatalogKind,
    @JsonProperty("cat_type") val catalogType: String,
    @JsonProperty("appearance") val appearance: String?,
    @JsonProperty("title") val title: String?,
    val description: String?,
    @NotRequiredForTest val config: String?,
    val enabled: Boolean,
    @NotRequiredForTest @JsonProperty("created_at") @JsonFormat(pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSZ") var createdAt: ZonedDateTime?,
    @NotRequiredForTest @JsonProperty("deleted_at") @JsonFormat(pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSZ") var deletedAt: ZonedDateTime?
) : ITransferEntity {
    override fun toDto(): CatalogDto {
        return Mappers.catalogMapper.toDto(this)
    }

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = UaaNames.CATALOG
}

enum class DefaultCatalog(val id: UUID, val value: String) {
    AUTH0("23abaed0-dc7d-4c89-b632-9f0c256c80fb".toUUID(), "auth0"),
    BANK("a3dc2070-f6cc-4598-99e1-19b450b936b7".toUUID(), "bank"),
    CLIENT("95bcfb4a-d534-4b23-b7fb-c23b3a8613a7".toUUID(), "client"),
    INDIVIDUAL("4ff5dc6c-e6d8-4157-9327-6bd404586cae".toUUID(), "individual"),
    GOOGLE("788807eb-b73f-4db6-b47b-f612708ef0bb".toUUID(), "google"),
    LDAP("35a58fbf-9311-4a1b-83a5-dbbbf7b00a5b".toUUID(), "ldap"),
    TECHNICAL("6681108f-c1e8-46ca-a97b-ce86b6e3c2bc".toUUID(), "Technical user uaa catalog"),
    ;

    companion object {
        fun getById(searchId: UUID): DefaultCatalog {
            return values().find { it.id == searchId } ?: throw RuntimeException("DefaultCatalog by $searchId not found.")
        }

        fun getByValue(searchValue: String): DefaultCatalog {
            return values().find { it.value == searchValue } ?: throw RuntimeException("DefaultCatalog by $searchValue not found.")
        }
    }
}

enum class UserCatalogKind {
    PasswordBased,
    Social,
    Technical;
}

