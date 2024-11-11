package ooo.jtc.dictionaries.lettertypetobank

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.annotations.Unique
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@EntityName(DictionaryNames.LETTER_TYPE_TO_BANK)
@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class LetterTypeToBankDto(
    override var id: UUID?,
    override var version: Int,
    @Unique var code: String,
    @Unique var description: String
) : UpdateIEntityDto<LetterTypeToBankDto> {

    override fun toModel(): LetterTypeToBank = Mappers.letterTypeToBankMapper.toDomainModel(this)
}