package ooo.jtc.dictionaries.accountype

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*


@KotlinBuilder
@EntityName(DictionaryNames.ACCOUNT_TYPE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class AccountTypeDto(
    override var id: UUID?,
    override var version: Int,
    var fullName: String,
    var shortName: String,
    var systemName: String,
    var clientType: String,//TODO? Sergeyev [2021.02.02]: type for 'listOf(CustomerTypeShort.IP, CustomerTypeShort.UL)'
    var description: String
) : UpdateIEntityDto<AccountTypeDto> {

    override fun toModel(): AccountType = Mappers.accountTypeMapper.toDomainModel(this)
}