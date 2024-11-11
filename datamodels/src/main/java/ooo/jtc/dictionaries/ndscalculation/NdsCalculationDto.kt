package ooo.jtc.dictionaries.ndscalculation

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.NDS_CALCULATION)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class NdsCalculationDto(
    override var id: UUID?,
    override var version: Int,

    var code: Int,                  // unique, number 0->99
    var description: String,        // up to 255 symbols (with codes 32-126, А-Я, а-я, №)
    var template: String?,          // up to 255 symbols (with codes 32-126, А-Я, а-я, №)
    @JvmField var isDefaultRuPayment: Boolean // only 1 'true' allowed
) : UpdateIEntityDto<NdsCalculationDto> {

    override fun toModel(): NdsCalculation = Mappers.ndsCalculationMapper.toDomainModel(this)
}