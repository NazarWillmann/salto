package ooo.jtc.dictionaries.bankru

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.dictionaries.controlcode.ControlCode
import ooo.jtc.dictionaries.locationtype.LocationType
import ooo.jtc.dictionaries.uer.Uer
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import ooo.jtc.random.ValidateConstants
import java.sql.Timestamp
import java.util.*

@KotlinBuilder
data class BankRu(
    override var id: UUID?,
    override var version: Int,
    var bic: String,
    @JsonProperty("bank_name") var bankName: String,
    @JsonProperty("corr_account") var corrAccount: String?,
    var address: String?,
    var zip: String,
    var location: String?,
    var phone: String?,
    @JsonProperty("reg_number") var regNumber: String?,
    @JsonProperty("control_date") var controlDate: Timestamp?,

    @JsonProperty("id_location_type") var idLocationType: UUID?,
    @JsonProperty("id_control_code") var idControlCode: UUID?,
    @JsonProperty("id_uer") var idUer: UUID,

    // fills in [dbResultPostProcessor]
    var locationType: LocationType?,
    var controlCode: ControlCode?,
    var uer: Uer?,

    @NotRequiredForTest @JsonProperty("created_at") var createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName = DictionaryNames.BANK_RU

    override fun toDto(): BankRuDto = Mappers.bankRuMapper.toDto(this)

    @get:JsonIgnore
    val isRkc: Boolean
        get() = this.bic.substring(
            ValidateConstants.BANK_IND_BEGIN,
            ValidateConstants.BANK_IND_END
        ) in ValidateConstants.BIC_RKC_SUFFIX
}