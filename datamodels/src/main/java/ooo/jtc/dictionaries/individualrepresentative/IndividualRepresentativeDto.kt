package ooo.jtc.dictionaries.individualrepresentative

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.common.BlockingInfoDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.IWithBlock
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*
@KotlinBuilder
@EntityName(DictionaryNames.INDIVIDUAL_REPRESENTATIVE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class IndividualRepresentativeDto(
    override var id: UUID?,
    override var version: Int,
    var userId: UUID,
    var individualId: UUID,
    override var block: BlockingInfoDto,
    var description: String?

) : UpdateIEntityDto<IndividualRepresentativeDto>, IWithBlock
