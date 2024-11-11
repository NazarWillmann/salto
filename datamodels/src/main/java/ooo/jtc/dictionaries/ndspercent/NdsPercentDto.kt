package ooo.jtc.dictionaries.ndspercent

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.math.BigDecimal
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.NDS_PERCENT)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class NdsPercentDto(
    override var id: UUID?,
    override var version: Int,
    var percent: BigDecimal,        // numeric 0-100.00
    @JvmField var isDefaultRuPayment: Boolean // only 1 'true' allowed
) : UpdateIEntityDto<NdsPercentDto> {

    override fun toModel(): NdsPercent = Mappers.ndsPercentMapper.toDomainModel(this)
}