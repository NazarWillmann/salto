package ooo.jtc.dictionaries.okopf

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.UUID

@KotlinBuilder
@EntityName(DictionaryNames.OKOPF)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class OkopfDto(
    override var id: UUID?,
    override var version: Int,
    var code: String?,
    var description: String
) : UpdateIEntityDto<OkopfDto> {

    override fun toModel(): Okopf = Mappers.okopfMapper.toDomainModel(this)
}