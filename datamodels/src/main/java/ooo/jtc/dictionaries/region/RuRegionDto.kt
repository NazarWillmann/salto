package ooo.jtc.dictionaries.region

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.RU_REGION)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class RuRegionDto(
    override var id: UUID?,
    override var version: Int,
    var code: String,   // 2 symbols
    var name: String    // up to 40 symbols
) : UpdateIEntityDto<RuRegionDto> {

    override fun toModel(): RuRegion = Mappers.ruRegionMapper.toDomainModel(this)
}