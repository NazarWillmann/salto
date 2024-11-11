package ooo.jtc.dictionaries.country

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.COUNTRY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CountryDto(
    override var id: UUID?,
    override var version: Int,
    var digitCode: String,
    var shortName: String,
    var fullName: String?,
    var intNameIso: String?,
    var alpha2Code: String,
    var alpha3Code: String
) : UpdateIEntityDto<CountryDto> {

    override fun toModel(): Country = Mappers.countryMapper.toDomainModel(this)

    fun toReducedCountryDto(): ReducedCountryDto = ReducedCountryDto(digitCode, alpha2Code, intNameIso)
}

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ReducedCountryDto(
    var digitCode: String? = null,
    var alpha2Code: String? = null,
    var intNameIso: String? = null
)

/**
 * Frequently used currencies
 */
enum class DefaultCountry(
    val digitCode: String,
    val alpha2Code: String,
    val alpha3Code: String
) {
    USA("840", "US", "USA"),
    RUS("643", "RU", "RUS")
}