package ooo.jtc.dictionaries.branchcustomer

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.util.UUID

@KotlinBuilder
data class BranchCustomer(
    override var id: UUID?,
    override var version: Int,
    @JsonProperty("id_customer") var customerId: UUID,
    @JsonProperty("id_branch") var branchId: UUID,

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.BRANCH_CUSTOMER

    override fun toDto(): BranchCustomerDto = Mappers.branchCustomerMapper.toDto(this)
}