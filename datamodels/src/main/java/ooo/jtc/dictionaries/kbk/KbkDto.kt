package ooo.jtc.dictionaries.kbk

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.KBK)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class KbkDto(
    override var id: UUID?,
    override var version: Int,
    var code: String?,          // up to 20 symbols, unique
    var description: String?    // 'unlimited'
) : UpdateIEntityDto<KbkDto> {

    override fun toModel(): Kbk = Mappers.kbkMapper.toDomainModel(this)
}