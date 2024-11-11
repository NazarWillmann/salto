package ooo.jtc.uaa.resource.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.UaaNames
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.uaa.resource.model.Resource
import ooo.jtc.uaa.scope.dto.ScopeDto
import java.util.*

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityName(UaaNames.RESOURCE)
data class ResourceDto(
    override var id: UUID?,
    override var version: Int,
    var name: String,
    var description: String,
    var audience: String,
    var scopes: List<ScopeDto>?
) : UpdateIEntityDto<ResourceDto> {
    @JsonIgnore
    override fun toModel(): Resource = Mappers.resourceMapper.toDomainModel(this)
}

