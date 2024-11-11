package ooo.jtc.dictionaries.contractorcontact

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@EntityName(DictionaryNames.CONTRACTOR_CONTACT)
@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ContractorContactDto(
    override var id: UUID?,
    override var version: Int,
    var contractorId: UUID,
    var name: String,       // (WiP) up to 200 symbols
    var position: String?,  // (WiP) up to 200 symbols
    var email: String?,     // (WiP) up to 200 symbols
    var telephone: String?, // (WiP) up to 200 symbols
    var comment: String?    // (WiP) up to 4000 symbols
) : UpdateIEntityDto<ContractorContactDto> {

    override fun toModel(): ContractorContact = Mappers.contractorContactMapper.toDomainModel(this)
}