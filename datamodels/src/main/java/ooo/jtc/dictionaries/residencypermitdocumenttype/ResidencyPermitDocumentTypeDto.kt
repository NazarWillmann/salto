package ooo.jtc.dictionaries.residencypermitdocumenttype

import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.RESIDENCY_PERMIT_DOCUMENT_TYPE)
data class ResidencyPermitDocumentTypeDto(
    override var id: UUID? = null,
    override var version: Int = 0,

    var name: String,
    var systemName: String

) : UpdateIEntityDto<ResidencyPermitDocumentTypeDto> {

    override fun toModel(): ResidencyPermitDocumentType = Mappers.residencyPermitDocumentTypeMapper.toDomainModel(this)
}