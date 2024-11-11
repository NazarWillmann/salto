package ooo.jtc.uaa.scope.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.UaaNames
import ooo.jtc.interfaces.ITransferEntity
import ooo.jtc.uaa.scope.dto.ScopeDto
import java.time.ZonedDateTime
import java.util.*

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
data class Scope(
    override var id: UUID?,
    @NotRequiredForTest override var version: Int,
    var name: String,
    @JsonProperty("ui_name") var uiName: String,
    var description: String?,
    @JsonProperty("id_resource") val resourceId: UUID,
    @JsonProperty("need_approve") val needApprove: Boolean,
    @NotRequiredForTest @JsonProperty("created_at") @JsonFormat(pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSZ") var createdAt: ZonedDateTime?,
    @NotRequiredForTest @JsonProperty("deleted_at") @JsonFormat(pattern = "uuuu-MM-dd'T'HH:mm:ss.SSSZ") var deletedAt: ZonedDateTime?
) : ITransferEntity {
    override fun toDto(): ScopeDto {
        return Mappers.scopeMapper.toDto(this)
    }

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = UaaNames.SCOPE
}