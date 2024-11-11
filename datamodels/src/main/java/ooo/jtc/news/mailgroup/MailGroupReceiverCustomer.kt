package ooo.jtc.news.mailgroup

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.interfaces.ITransferEntity
import ooo.jtc.news.dto.ReceiverCustomerDto
import java.util.UUID

@KotlinBuilder
data class MailGroupReceiverCustomer(
    override var id: UUID?,
    @NotRequiredForTest @JsonIgnore override var version: Int = 0,
    @JsonProperty("id_customer") var customerId: UUID?,
    @JsonProperty("customer_name") var customerName: String?,
    var inn: String?,
    @JsonProperty("id_mail_group") var idMailGroup: UUID?
): ITransferEntity {
    @JsonIgnore
    @NotRequiredForTest
    override val entityName = "MailGroupReceiverCustomers"

    override fun toDto(): ReceiverCustomerDto {
        return ReceiverCustomerDto(
            id = id, customerId = customerId!!, customerName = customerName, documentId = null, inn = inn
        )
    }
}
