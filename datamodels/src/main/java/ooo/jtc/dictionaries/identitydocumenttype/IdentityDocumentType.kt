package ooo.jtc.dictionaries.identitydocumenttype

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.util.*

@KotlinBuilder
data class IdentityDocumentType(
    override var id: UUID? = null,
    override var version: Int = 0,
    var name: String,
    @JsonProperty("system_name") var systemName: String?,
    @JsonProperty("usage_limit") var usageLimit: UsageLimit?,
    @JsonProperty("type_code") var typeCode: String?,
    @JsonProperty("is_hidden") var isHidden: Boolean,

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp? = null,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp? = null
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.IDENTITY_DOC_TYPE

    override fun toDto(): IdentityDocumentTypeDto = Mappers.identityDocTypeMapper.toDto(this)
}