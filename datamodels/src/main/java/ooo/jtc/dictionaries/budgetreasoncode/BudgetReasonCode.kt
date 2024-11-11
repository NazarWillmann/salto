package ooo.jtc.dictionaries.budgetreasoncode

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
data class BudgetReasonCode(
    override var id: UUID? = null,
    override var version: Int = 0,
    var code: String,
    var description: String,
    @JsonProperty("pay_type") var payType: PayType,
    var hint108: String?,
    var hint109: String?,
    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp? = null,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp? = null
) : ITransferEntity {
    @JsonIgnore
    @NotRequiredForTest
    override val entityName = DictionaryNames.BUDGET_REASON_CODE

    override fun toDto(): BudgetReasonCodeDto {
        return Mappers.budgetReasonCodeMapper.toDto(this)
    }
}