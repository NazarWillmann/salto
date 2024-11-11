package ooo.jtc.dictionaries.common.extid

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.util.UUID

@KotlinBuilder
data class ExtId(
    override var id: UUID?,
    @JsonIgnore override var version: Int = 0,
    @JsonProperty("id_owner") var ownerId: UUID?,
    @JsonProperty("id_ext_system") var extSystemId: UUID,
    @JsonProperty("id_external") var externalId: String
): ITransferEntity {

    @NotRequiredForTest @JsonIgnore override val entityName: String = DictionaryNames.EXT_ID

    override fun toDto(): ExtIdDto = Mappers.extIdMapper.toDto(this)
}