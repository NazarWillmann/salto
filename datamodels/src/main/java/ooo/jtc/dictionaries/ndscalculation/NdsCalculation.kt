package ooo.jtc.dictionaries.ndscalculation

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
data class NdsCalculation(
    override var id: UUID?,
    override var version: Int,
    var code: Int,
    var description: String,
    var template: String?,
    @JsonProperty("is_default_ru_payment") @JvmField var isDefaultRuPayment: Boolean,

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName = DictionaryNames.NDS_CALCULATION

    override fun toDto(): NdsCalculationDto = Mappers.ndsCalculationMapper.toDto(this)
}