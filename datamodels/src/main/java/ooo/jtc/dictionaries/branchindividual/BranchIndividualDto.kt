package ooo.jtc.dictionaries.branchindividual

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.branch.BranchDto
import ooo.jtc.dictionaries.individual.IndividualDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.BRANCH_INDIVIDUAL)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class BranchIndividualDto(
    override var id: UUID?,
    override var version: Int,
    var individualId: UUID,
    var branchId: UUID,
    var branch: BranchDto? = null,
    var individual: IndividualDto? = null
) : UpdateIEntityDto<BranchIndividualDto> {
    override fun toModel(): BranchIndividual = Mappers.branchIndividualMapper.toDomainModel(this)
}