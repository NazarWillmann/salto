package ooo.jtc.dictionaries.bankbic.acc

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestriction
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.time.LocalDate
import java.util.UUID

@KotlinBuilder
data class BankBicAccount(
    override var id: UUID? = null,
    @JsonIgnore override var version: Int = 0,
    @JsonProperty("id_bic") var bicId: UUID,
    var account: String,
    @JsonProperty("account_type") var accountType: String,
    @JsonProperty("account_bic") var accountBic: String,
    @JsonProperty("date_in") var dateIn: LocalDate,
    @JsonProperty("date_out") var dateOut: LocalDate? = null,
    var status: String,

    //filled in dbPostProcessor
    var restrictions: List<BankBicAccRestriction>? = null
): ITransferEntity {

    @NotRequiredForTest @JsonIgnore
    override val entityName = "Счёт ${DictionaryNames.BANK_BIC}"

    override fun toDto(): BankBicAccountDto = Mappers.bankBicAccountMapper.toDto(this)
}