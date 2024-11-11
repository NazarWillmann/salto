package ooo.jtc.dictionaries.contractor

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.dictionaries.contractorcontact.ContractorContact
import ooo.jtc.dictionaries.contractorpayment.ContractorPayment
import ooo.jtc.dictionaries.ground.Ground
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import ooo.jtc.rules.Size
import java.sql.Timestamp
import java.util.*

@KotlinBuilder
data class Contractor(
    override var id: UUID?,
    override var version: Int,
    @JsonProperty("id_customer") var customerId: UUID,
    @Size(max = 160) var name: String?,
    var inn: String,
    var kpp: String?,
    @Size(max = 255) var description: String?,

    // filled in data postProcessor
    var payments: List<ContractorPayment>?,
    var grounds: List<Ground>?,
    var contacts: List<ContractorContact>?,
    // var isFavorites: Boolean?, // TODO?: получение этого реквизита основано на текущем пользователе

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.CONTRACTOR

    override fun toDto(): ContractorDto = Mappers.contractorMapper.toDto(this)

    @get:JsonIgnore
    val isPerson: Boolean
        get() = inn.length == 12

    @get:JsonIgnore
    val isBudget: Boolean
        get() = inn.length == 10 && !kpp.isNullOrEmpty()

    @get:JsonIgnore
    val isOrganization: Boolean
        get() = inn.length == 10
}