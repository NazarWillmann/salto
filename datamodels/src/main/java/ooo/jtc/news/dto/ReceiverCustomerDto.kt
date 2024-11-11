package ooo.jtc.news.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.dictionaries.customer.CustomerDto
import ooo.jtc.interfaces.IEntityDto
import java.util.UUID

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ReceiverCustomerDto(
    override var id: UUID? = null,
    @JsonIgnore override var version: Int = 0,
    var documentId: UUID? = null,
    var customerId: UUID,
    var customerName: String? = null,
    var inn: String? = null
): IEntityDto

fun CustomerDto.toReceiverCustomer(): ReceiverCustomerDto {
    return ReceiverCustomerDto(
        id = null,
        documentId = null,
        customerId = this.id!!,
        customerName = this.shortName,
        inn = this.inn
    )
}