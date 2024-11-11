package ooo.jtc.dictionaries.treasuryaccounttax

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
data class TreasuryAccountTax(
    override var id: UUID? = null,
    override var version: Int = 0,

    var tofk: String?,
    var account: String?,
    @JsonProperty("bank_name") var bankName: String?,
    var bic: String?,
    @JsonProperty("utra_account") var utraAccount: String?,

    @NotRequiredForTest @JsonProperty("created_at") var createdAt: Timestamp? = null,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Timestamp? = null
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.TREASURY_ACCOUNT_TAX

    override fun toDto(): TreasuryAccountTaxDto = Mappers.treasuryAccountTaxMapper.toDto(this)
}