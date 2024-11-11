package ooo.jtc.dictionaries.bankbic.restr

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.time.LocalDate
import java.util.UUID

@KotlinBuilder
data class BankBicRestriction(
    override var id: UUID?,
    @JsonIgnore override var version: Int = 0,
    @JsonProperty("id_bic") var bicId: UUID,
    @JsonProperty("code") var restrictionCode: String,
    @JsonProperty("restr_date") var restrictionDate: LocalDate
): ITransferEntity {

    @NotRequiredForTest @JsonIgnore
    override val entityName = "Ограничения на ${DictionaryNames.BANK_BIC}"

    override fun toDto(): BankBicRestrictionDto = Mappers.bankBicRestrictionMapper.toDto(this)
}