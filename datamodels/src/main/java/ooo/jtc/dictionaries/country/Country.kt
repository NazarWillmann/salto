package ooo.jtc.dictionaries.country

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.util.*

@KotlinBuilder
data class Country(
    override var id: UUID?,
    override var version: Int,
    @JsonProperty("digit_code") var digitCode: String, // unique
    @JsonProperty("short_name") var shortName: String, // unique
    @JsonProperty("full_name") var fullName: String?,
    @JsonProperty("int_name_iso") var intNameIso: String?,
    @JsonProperty("alpha2_code") var alpha2Code: String, // unique
    @JsonProperty("alpha3_code") var alpha3Code: String, // unique

    @NotRequiredForTest @JsonProperty("created_at") var createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.COUNTRY

    override fun toDto(): CountryDto = Mappers.countryMapper.toDto(this)
}