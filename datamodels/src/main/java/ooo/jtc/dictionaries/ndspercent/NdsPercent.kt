package ooo.jtc.dictionaries.ndspercent

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.*

@KotlinBuilder
data class NdsPercent(
    override var id: UUID?,
    override var version: Int,
    var percent: BigDecimal,
    @JsonProperty("is_default_ru_payment") @JvmField var isDefaultRuPayment: Boolean,

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.NDS_PERCENT

    override fun toDto(): NdsPercentDto = Mappers.ndsPercentMapper.toDto(this)

}