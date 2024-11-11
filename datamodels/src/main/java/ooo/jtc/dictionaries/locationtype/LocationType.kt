package ooo.jtc.dictionaries.locationtype

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
data class LocationType(
    override var id: UUID?,
    override var version: Int,
    @JsonProperty("location_type") var locationType: String?,
    var name: String,
    @JsonProperty("name_short") var nameShort: String,
    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName = DictionaryNames.LOCATION_TYPE

    override fun toDto(): LocationTypeDto = Mappers.locationTypeMapper.toDto(this)

}