package ooo.jtc.dictionaries.controlcode

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.CONTROL_CODE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ControlCodeDto(
    override var id: UUID?,
    override var version: Int,
    var code: String?,          // up to 4 symbols, unique
    var description: String?    // up to 60 symbols
) : UpdateIEntityDto<ControlCodeDto> {

    override fun toModel(): ControlCode = Mappers.controlCodeMapper.toDomainModel(this)
}