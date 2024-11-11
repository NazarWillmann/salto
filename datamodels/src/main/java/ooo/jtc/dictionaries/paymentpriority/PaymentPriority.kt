package ooo.jtc.dictionaries.paymentpriority

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.annotations.Unique
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.util.*

@KotlinBuilder
data class PaymentPriority(
    override var id: UUID?,
    override var version: Int,
    @Unique var code: String,
    var description: String,
    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName = DictionaryNames.PAYMENT_PRIORITY

    override fun toDto(): PaymentPriorityDto = Mappers.paymentPriorityMapper.toDto(this)
}