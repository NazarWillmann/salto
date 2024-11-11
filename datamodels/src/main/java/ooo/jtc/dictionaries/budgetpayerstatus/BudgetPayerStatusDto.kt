package ooo.jtc.dictionaries.budgetpayerstatus

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.annotations.Unique
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.rules.Pattern
import ooo.jtc.rules.Size
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.BUDGET_PAYER_STATUS)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class BudgetPayerStatusDto(
    override var id: UUID?,
    override var version: Int,
    @Unique @Size(min = 2, max = 2) @Pattern(acceptable = "[0-9]*") var code: String?,
    @Size(max = 255) @Pattern(acceptable = "[А-Яа-я№ ]*") var description: String?
) : UpdateIEntityDto<BudgetPayerStatusDto> {

    override fun toModel(): BudgetPayerStatus = Mappers.budgetPayerStatusMapper.toDomainModel(this)
}