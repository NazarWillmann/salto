package ooo.jtc.dictionaries.timezone

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@EntityName(DictionaryNames.TIME_ZONE)
@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class TimezoneDto(
    override var id: UUID?,
    override var version: Int,
    var name: String,   // up to 255 symbols, unique
    var shift: Int
) : UpdateIEntityDto<TimezoneDto> {
    override fun toModel(): Timezone {
        return Mappers.timezoneMapper.toDomainModel(this)
    }
}