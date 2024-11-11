package ooo.jtc.dictionaries.paymenttype

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.annotations.Unique
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*


@KotlinBuilder
@EntityName(DictionaryNames.PAYMENT_TYPE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PaymentTypeDto(
    override var id: UUID?,
    override var version: Int,
    @Unique var code: String?,
    var description: String?
) : UpdateIEntityDto<PaymentTypeDto> {

    override fun toModel(): PaymentType = Mappers.paymentTypeMapper.toDomainModel(this)
}