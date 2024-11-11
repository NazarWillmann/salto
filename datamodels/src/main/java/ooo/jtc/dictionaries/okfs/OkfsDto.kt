package ooo.jtc.dictionaries.okfs

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.UUID

@KotlinBuilder
@EntityName(DictionaryNames.OKFS)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class OkfsDto(
    override var id: UUID?,
    override var version: Int,
    var code: String?,
    var parentCode: String?,
    var description: String
) : UpdateIEntityDto<OkfsDto> {

    override fun toModel(): Okfs = Mappers.okfsMapper.toDomainModel(this)
}