package ooo.jtc.dictionaries.lettertypefrombank

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.annotations.Unique
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@EntityName(DictionaryNames.LETTER_TYPE_FROM_BANK)
@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class LetterTypeFromBankDto(
    override var id: UUID?,
    override var version: Int,
    @Unique var code: String, // max size = 30
    @Unique var description: String // max size = 100
) : UpdateIEntityDto<LetterTypeFromBankDto> {

    override fun toModel(): LetterTypeFromBank = Mappers.letterTypeFromBankMapper.toDomainModel(this)
}