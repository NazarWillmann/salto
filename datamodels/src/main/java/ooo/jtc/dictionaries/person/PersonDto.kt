package ooo.jtc.dictionaries.person

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.PERSON)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PersonDto(
    override var id: UUID?, // person.id == user.uaaUserId
    override var version: Int,
    var personalData: PersonalDataDto,
    var description: String? = null,
    @JsonProperty("isConfirmedMobilePhone") var confirmedMobilePhone: Boolean,
    @JsonProperty("isConfirmedEmail") var confirmedEmail: Boolean,
    var category: String?

) : UpdateIEntityDto<PersonDto> {

    @JsonIgnore
    override fun toModel(): Person = Mappers.personMapper.toDomainModel(this)
}
