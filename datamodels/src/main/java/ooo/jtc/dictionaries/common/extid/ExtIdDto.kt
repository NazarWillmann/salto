package ooo.jtc.dictionaries.common.extid

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.UUID

@KotlinBuilder
@EntityName(DictionaryNames.EXT_ID)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ExtIdDto(
    override var id: UUID?,
    @JsonIgnore override var version: Int = 0,
    var ownerId: UUID?,
    var extSystemId: UUID?,
    var externalId: String?
) : UpdateIEntityDto<ExtIdDto> {

    override fun toModel(): ExtId = Mappers.extIdMapper.toDomainModel(this)
}