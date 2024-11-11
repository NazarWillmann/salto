package ooo.jtc.dictionaries.person

import ooo.jtc.interfaces.AbstractDtoMapper
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper
interface PersonMapper : AbstractDtoMapper<Person, PersonDto> {

    @Mappings(
        Mapping(source = "firstName", target = "personalData.firstName"),
        Mapping(source = "lastName", target = "personalData.lastName"),
        Mapping(source = "middleName", target = "personalData.middleName"),
        Mapping(source = "mobilePhone", target = "personalData.mobilePhone"),
        Mapping(source = "email", target = "personalData.email"),
        Mapping(source = "sex", target = "personalData.sex"),
        Mapping(source = "birthdate", target = "personalData.birthdate"),
        Mapping(source = "phoneConfirmed", target = "confirmedMobilePhone"),
        Mapping(source = "emailConfirmed", target = "confirmedEmail")
    )
    override fun toDto(domainModel: Person): PersonDto

    @InheritInverseConfiguration
    override fun toDomainModel(dto: PersonDto): Person
}