package ooo.jtc.dictionaries.individualrepresentative

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
data class IndividualRepresentative(
    override var id: UUID?,
    override var version: Int,
    @JsonProperty("id_user") var userId: UUID,
    @JsonProperty("id_individual") var individualId: UUID,
    @JsonProperty("is_block") @JvmField var isBlock: Boolean,
    @JsonProperty("id_block_user") var blockUser: UUID?,
    @JsonProperty("block_date") var blockDate: Timestamp?,
    var description: String?,
    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?

) : ITransferEntity {
    @NotRequiredForTest
    @JsonIgnore
    override val entityName: String = DictionaryNames.INDIVIDUAL_REPRESENTATIVE

    override fun toDto(): IndividualRepresentativeDto = Mappers.individualRepresentativeMapper.toDto(this)


}
