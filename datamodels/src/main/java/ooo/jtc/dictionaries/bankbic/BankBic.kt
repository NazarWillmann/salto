package ooo.jtc.dictionaries.bankbic

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccAccountTypeIEnum
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccStatusIEnum
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccount
import ooo.jtc.dictionaries.bankbic.restr.BankBicRestriction
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.time.LocalDate
import java.util.UUID

@KotlinBuilder
data class BankBic(
    override var id: UUID?,
    override var version: Int,
    var bic: String,
    var name: String,
    @JsonProperty("country_alpha2_code") var countryAlpha2Code: String?,
    var zip: String?,
    @JsonProperty("location_type") var locationType: String?,
    var location: String?,
    var address: String?,
    @JsonProperty("parent_bic") var parentBic: String?,
    @JsonProperty("transfer_type") var participantTransferType: String,
    @JsonProperty("participant_type") var participantType: String,
    @JsonProperty("allowed_services") var allowedServices: String,
    @JsonProperty("date_in") var dateIn: LocalDate,
    @JsonProperty("date_out") var dateOut: LocalDate?,
    var status: String,

    //filled in dbPostProcessor
    var accounts: List<BankBicAccount>?,
    var restrictions: List<BankBicRestriction>?,

    @NotRequiredForTest @JsonProperty("created_at") var createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.BANK_BIC

    override fun toDto(): BankBicDto = Mappers.bankBicMapper.toDto(this)

    @JsonIgnore
    fun getSingleOrNullActiveAccount(): BankBicAccount? {
        val foundActiveCrsaAccounts = accounts
            ?.filter { BankBicAccAccountTypeIEnum.CRSA.value == it.accountType }
            ?.filter { BankBicAccStatusIEnum.ACTIVE.value == it.status }

        return foundActiveCrsaAccounts?.let { if (1 != foundActiveCrsaAccounts.size) null else it[0] }
    }
}