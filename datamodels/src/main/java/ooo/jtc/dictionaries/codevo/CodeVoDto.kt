package ooo.jtc.dictionaries.codevo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*


@KotlinBuilder
@EntityName(DictionaryNames.CODE_VO)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CodeVoDto(
    override var id: UUID?,
    override var version: Int,
    var code: String?,
    var description: String?
) : UpdateIEntityDto<CodeVoDto> {

    override fun toModel(): CodeVo = Mappers.codeVoMapper.toDomainModel(this)
}