package ooo.jtc.dictionaries.customer

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.interfaces.IEntity
import java.util.UUID

@KotlinBuilder
data class CustomerTypeCustomer(
    @NotRequiredForTest @JsonIgnore override var id: UUID? = null,
    @NotRequiredForTest @JsonIgnore override var version: Int = 0,
    @JsonProperty("id_customer") var customerId: UUID,
    @JsonProperty("id_customer_type") var customerTypeId: UUID
): IEntity {
    @NotRequiredForTest @JsonIgnore
    override val entityName: String = "Связь Клиента ЮЛ и Типа клиента"
}
