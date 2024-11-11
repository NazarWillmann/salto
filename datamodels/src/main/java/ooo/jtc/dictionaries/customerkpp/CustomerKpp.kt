package ooo.jtc.dictionaries.customerkpp

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
data class CustomerKpp(
    override var id: UUID?,
    override var version: Int,
    @JsonProperty("id_customer") var idCustomer: UUID?,
    //Sergeyev [2021.07.14]: potentially dangerous change, but it's necessary for Customer DTO<->Model conversion
    @JsonProperty("unit_name") var unitName: String?,
    var kpp: String,
    @JsonProperty("is_default") @JvmField var isDefault: Boolean,
    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.CUSTOMER_KPP

    override fun toDto(): CustomerKppDto = Mappers.customerKppMapper.toDto(this)
}