package ooo.jtc.dictionaries.locationtype

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.LOCATION_TYPE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class LocationTypeDto(
    override var id: UUID?,
    override var version: Int,
    var locationType: String?,  // 2 symbols
    var name: String,           // up to 25 symbols
    var nameShort: String       // up to 5 symbols
) : UpdateIEntityDto<LocationTypeDto> {

    override fun toModel(): LocationType = Mappers.locationTypeMapper.toDomainModel(this)
}