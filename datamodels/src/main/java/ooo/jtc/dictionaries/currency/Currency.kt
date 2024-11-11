package ooo.jtc.dictionaries.currency

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.util.UUID

@KotlinBuilder
data class Currency(
    override var id: UUID?,
    override var version: Int,
    @JsonProperty("digit_code") val digitCode: String,
    @JsonProperty("alpha_code") val alphaCode: String,
    val name: String,
    @JsonProperty("name_in_okv") val nameInOkv: String,
    @JsonProperty("minor_unit_count") val minorUnitCount: Int,

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName = DictionaryNames.CURRENCY

    override fun toDto(): CurrencyDto = Mappers.currencyMapper.toDto(this)
}