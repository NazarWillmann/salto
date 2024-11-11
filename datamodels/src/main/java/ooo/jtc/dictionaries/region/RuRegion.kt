package ooo.jtc.dictionaries.region

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
data class RuRegion(
    override var id: UUID?,
    override var version: Int,
    var code: String, // 2 symbols
    var name: String, // up to 40 symbols
    @NotRequiredForTest @JsonProperty("created_at") var createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName = DictionaryNames.RU_REGION

    override fun toDto() = Mappers.ruRegionMapper.toDto(this)
}