package ooo.jtc.dictionaries.branchindividual

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
data class BranchIndividual(
    override var id: UUID?,
    override var version: Int,
    @JsonProperty("id_branch") var branchId: UUID,
    @JsonProperty("id_individual") var individualId: UUID,

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @NotRequiredForTest
    @JsonIgnore
    override val entityName: String = DictionaryNames.BRANCH_INDIVIDUAL

    override fun toDto(): BranchIndividualDto = Mappers.branchIndividualMapper.toDto(this)
}