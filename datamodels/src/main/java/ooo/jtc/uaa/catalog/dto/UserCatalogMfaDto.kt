package ooo.jtc.uaa.catalog.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import java.util.*

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityName("Mfa for User Catalog")
data class UserCatalogMfaDto(
    var id: UUID?,
    val mfaId: UUID,
    val lifetimeSec: Long,
    val maxAttempts: Long
)
