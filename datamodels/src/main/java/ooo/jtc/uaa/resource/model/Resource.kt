package ooo.jtc.uaa.resource.model

import com.fasterxml.jackson.annotation.*
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.UaaNames
import ooo.jtc.interfaces.ITransferEntity
import ooo.jtc.uaa.resource.dto.ResourceDto
import java.time.ZonedDateTime
import java.util.*

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
data class Resource(
    override var id: UUID?,
    override var version: Int,
    var name: String,
    var audience: String,
    var description: String,
    @JsonProperty("created_at") @JsonFormat(pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSZ") var createdAt: ZonedDateTime,
    @JsonProperty("deleted_at") @JsonFormat(pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSZ") var deletedAt: ZonedDateTime?
) : ITransferEntity {
    override fun toDto(): ResourceDto {
        return Mappers.resourceMapper.toDto(this)
    }

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = UaaNames.RESOURCE
}

/**
 * Enum uses for 's-domain' parameter in API-request's header.
 * Also for modifying CoreApi.withDomain().
 */
enum class Audience(@get:JsonValue var value: String) {
    CUSTOMER("customer.api.salto.jtc.ooo"),
    BANK("bank.api.salto.jtc.ooo"),
    INDIVIDUAL("individual.api.salto.jtc.ooo"),
    INTERNAL("internal.api.salto.jtc.ooo"),
    UAA("uaa.api.jtc.ooo"),
    MANAGEMENT_UAA("management.uaa.api.jtc.ooo"),
    FOR_TEST("test.audience.jtc.ooo"),
    ;
}