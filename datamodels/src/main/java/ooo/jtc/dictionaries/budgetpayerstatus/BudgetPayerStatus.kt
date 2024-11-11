package ooo.jtc.dictionaries.budgetpayerstatus

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
data class BudgetPayerStatus(
    override var id: UUID? = null,
    override var version: Int = 0,
    var code: String?, //up to 2 symbols; unique
    var description: String?,

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp? = null,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp? = null
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.BUDGET_PAYER_STATUS

    override fun toDto(): BudgetPayerStatusDto = Mappers.budgetPayerStatusMapper.toDto(this)
}