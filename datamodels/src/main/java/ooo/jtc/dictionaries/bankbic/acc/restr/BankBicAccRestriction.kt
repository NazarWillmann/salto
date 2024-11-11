package ooo.jtc.dictionaries.bankbic.acc.restr

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
data class BankBicAccRestriction(
    override var id: UUID?,
    @JsonIgnore override var version: Int = 0,
    @JsonProperty("id_bic") var bicId: UUID,
    @JsonProperty("id_account") var accountId: UUID,
    @JsonProperty("code") var restrictionCode: String,
    @JsonProperty("restr_date") var restrictionDate: LocalDate
): ITransferEntity {

    @NotRequiredForTest @JsonIgnore
    override val entityName = "Ограничения на счёт ${DictionaryNames.BANK_BIC}"

    override fun toDto(): BankBicAccRestrictionDto = Mappers.bankBicAccountRestrMapper.toDto(this)
}