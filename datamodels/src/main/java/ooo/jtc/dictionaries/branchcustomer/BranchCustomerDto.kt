package ooo.jtc.dictionaries.branchcustomer

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.branch.BranchDto
import ooo.jtc.dictionaries.customer.CustomerDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.UUID

@KotlinBuilder
@EntityName(DictionaryNames.BRANCH_CUSTOMER)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class BranchCustomerDto(
    override var id: UUID?,
    override var version: Int,
    var customerId: UUID,
    var branchId: UUID,
    var branch: BranchDto? = null,
    var customer: CustomerDto? = null
) : UpdateIEntityDto<BranchCustomerDto> {

    override fun toModel(): BranchCustomer = Mappers.branchCustomerMapper.toDomainModel(this)
}