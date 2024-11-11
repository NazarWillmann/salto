package ooo.jtc.dictionaries.customerkpp

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.CUSTOMER_KPP)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CustomerKppDto(
    override var id: UUID?,
    override var version: Int,
    var unitName: String?,
    var kpp: String,             // up to 9 symbols (digits only)
    @JvmField var isDefault: Boolean
) : UpdateIEntityDto<CustomerKppDto> {

    override fun toModel(): CustomerKpp {
        return Mappers.customerKppMapper.toDomainModel(this)
    }
}