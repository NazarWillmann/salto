package ooo.jtc.dictionaries.identitydocumenttype

import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.IDENTITY_DOC_TYPE)
data class IdentityDocumentTypeDto(
    override var id: UUID?,
    override var version: Int,
    var typeCode: String? = null,
    var name: String,
    var systemName: String? = null,
    var usageLimit: UsageLimit? = null,
    var isHidden: Boolean
) : UpdateIEntityDto<IdentityDocumentTypeDto> {

    override fun toModel(): IdentityDocumentType = Mappers.identityDocTypeMapper.toDomainModel(this)
}