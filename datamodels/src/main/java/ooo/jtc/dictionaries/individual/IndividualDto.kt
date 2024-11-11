package ooo.jtc.dictionaries.individual

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.common.BlockingInfoDto
import ooo.jtc.dictionaries.common.address.AddressDto
import ooo.jtc.dictionaries.identitydocument.IdentityDocumentDto
import ooo.jtc.dictionaries.person.PersonDto
import ooo.jtc.dictionaries.person.PersonalInfoDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.INDIVIDUAL)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class IndividualDto(
    override var id: UUID?,
    override var version: Int,
    var block: BlockingInfoDto,
    var person: PersonDto?,
    var personalInfo: PersonalInfoDto,
    var identityDocuments: List<IdentityDocumentDto>,
    var addressRegistration: AddressDto?,
    var addressLocation: AddressDto?,
) : UpdateIEntityDto<IndividualDto> {

    override fun toModel(): Individual = Mappers.individualMapper.toDomainModel(this)
}


