package ooo.jtc.dictionaries.uer

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.bankru.BankType
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@EntityName(DictionaryNames.UER)
@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class UerDto(
    override var id: UUID?,
    override var version: Int,
    var uer: String,        // up to 2 symbols (digits only); unique pair with 'bankType'
    var bankType: BankType, // up to 2 symbols
    var description: String // up to 70 symbols
) : UpdateIEntityDto<UerDto> {

    override fun toModel(): Uer = Mappers.uerMapper.toDomainModel(this)
}