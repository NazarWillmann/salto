package ooo.jtc.dictionaries.branchrepresentative

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.common.BlockingInfoDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.IWithBlock
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.UUID

@KotlinBuilder
@EntityName(DictionaryNames.BRANCH_REPRESENTATIVE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class BranchRepresentativeDto(
    override var id: UUID?,
    override var version: Int,
    var branchId: UUID?,
    var userId: UUID?,
    var position: String?,
    var email: String?,
    var phone: String?,
    override var block: BlockingInfoDto,
    var description: String?
) : UpdateIEntityDto<BranchRepresentativeDto>, IWithBlock {

    override fun toModel(): BranchRepresentative = Mappers.branchRepresentativeMapper.toDomainModel(this)
}
