package ooo.jtc.dictionaries.ground

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.IEntityDto
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.GROUND)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class GroundDto(
    override var id: UUID?,
    override var version: Int,
    var customerId: UUID,
    var contractorId: UUID?,
    var description: String?
) : IEntityDto {

    override fun toModel(): Ground = Mappers.groundMapper.toDomainModel(this)
}

@KotlinBuilder
@EntityName("${DictionaryNames.GROUND} (запрос на обновление)")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class GroundUpdateRequest(
    override var id: UUID?,
    override var version: Int,
    var description: String?
) : UpdateIEntityDto<GroundDto>

