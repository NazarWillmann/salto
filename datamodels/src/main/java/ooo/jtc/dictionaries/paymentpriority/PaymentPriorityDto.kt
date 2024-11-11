package ooo.jtc.dictionaries.paymentpriority

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.annotations.Unique
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.rules.Pattern
import ooo.jtc.rules.Size
import java.util.*


@KotlinBuilder
@EntityName(DictionaryNames.PAYMENT_PRIORITY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PaymentPriorityDto(
    override var id: UUID?,
    override var version: Int = 0,
    @Unique @Size(max = 1) @Pattern(acceptable = "[0-9]") var code: String?,
    @Size(max = 255) @Pattern(acceptable = "[А-Яа-я№ ]*") var description: String?
) : UpdateIEntityDto<PaymentPriorityDto> {

    override fun toModel(): PaymentPriority = Mappers.paymentPriorityMapper.toDomainModel(this)
}