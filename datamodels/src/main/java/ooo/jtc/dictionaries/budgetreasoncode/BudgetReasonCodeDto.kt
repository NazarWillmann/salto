package ooo.jtc.dictionaries.budgetreasoncode

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.BUDGET_REASON_CODE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class BudgetReasonCodeDto(
    override var id: UUID?,
    override var version: Int,
    var code: String?,
    var description: String?,
    var payType: PayType?,
    var hint108: String?,
    var hint109: String?
) : UpdateIEntityDto<BudgetReasonCodeDto> {

    override fun toModel(): BudgetReasonCode = Mappers.budgetReasonCodeMapper.toDomainModel(this)
}

enum class PayType {
    TAX,
    CUSTOM,
    ALL
}