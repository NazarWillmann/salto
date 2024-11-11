package ooo.jtc.dictionaries.okopf

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.util.UUID

@KotlinBuilder
data class Okopf(
    override var id: UUID?,
    override var version: Int,
    var code: String?,
    var description: String,

    @NotRequiredForTest @JsonProperty("created_at") var createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.OKOPF

    override fun toDto(): OkopfDto = Mappers.okopfMapper.toDto(this)
}