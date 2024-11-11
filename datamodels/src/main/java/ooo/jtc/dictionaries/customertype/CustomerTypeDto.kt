package ooo.jtc.dictionaries.customertype

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.CUSTOMER_TYPE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CustomerTypeDto(
    override var id: UUID?,
    override var version: Int,
    val name: String,       // up to 60 (100) symbols, unique
    val systemName: String  // up to (100) symbols, unique
) : UpdateIEntityDto<CustomerTypeDto> {

    override fun toModel(): CustomerType = Mappers.customerTypeMapper.toDomainModel(this)
}