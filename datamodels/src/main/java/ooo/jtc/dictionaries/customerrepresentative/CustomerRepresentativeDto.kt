package ooo.jtc.dictionaries.customerrepresentative

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.common.BlockingInfoDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.IWithBlock
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.UUID

@KotlinBuilder
@EntityName(DictionaryNames.CUSTOMER_REPRESENTATIVE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CustomerRepresentativeDto(
    override var id: UUID?,
    override var version: Int,
    var customerId: UUID?,
    var userId: UUID?,
    var position: String?,
    var email: String?,
    var phone: String?,
    var description: String?,
    override var block: BlockingInfoDto
) : UpdateIEntityDto<CustomerRepresentativeDto>, IWithBlock {

    override fun toModel(): CustomerRepresentative = Mappers.customerRepresentativeMapper.toDomainModel(this)
}