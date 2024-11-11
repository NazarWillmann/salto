package ooo.jtc.dictionaries.contractorpayment

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
data class ContractorPayment(
    override var id: UUID?,
    @NotRequiredForTest override var version: Int,
    @JsonProperty("id_contractor") var contractorId: UUID,
    @JsonProperty("bank_name") var bankName: String,
    @JsonProperty("bank_address") var bankAddress: String,
    @JsonProperty("corr_account") var corrAccount: String?,
    @JsonProperty("is_default") @JvmField var isDefault: Boolean,
    var account: String,
    var bic: String?,

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName = DictionaryNames.CONTRACTOR_PAYMENT

    override fun toDto(): ContractorPaymentDto = Mappers.contractorPaymentMapper.toDto(this)
}