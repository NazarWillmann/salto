package ooo.jtc.dictionaries.contractorpayment

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.IEntityDto
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@EntityName(DictionaryNames.CONTRACTOR_PAYMENT)
@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ContractorPaymentDto(
    override var id: UUID?,
    override var version: Int,
    var contractorId: UUID,
    var account: String,
    var bankName: String,
    var bankAddress: String,
    var corrAccount: String?,
    var bic: String,
    @JvmField var isDefault: Boolean
) : IEntityDto {
    override fun toModel(): ContractorPayment = Mappers.contractorPaymentMapper.toDomainModel(this)
}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ContractorPaymentUpdateRequest(
    override var id: UUID?,
    override var version: Int,
    var account: String,
    var bankName: String,
    var bankAddress: String,
    var corrAccount: String?,
    var bic: String,
    @JvmField var isDefault: Boolean
) : UpdateIEntityDto<ContractorPaymentDto>