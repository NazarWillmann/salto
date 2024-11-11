package ooo.jtc.uaa.user.mapper

import ooo.jtc.generic.CUSTOM_CONVERTER
import ooo.jtc.generic.CustomConverter
import ooo.jtc.generic.LOCALDATE_TIME_TO_TIMESTAMP
import ooo.jtc.generic.TIMESTAMP_TO_LOCALDATE_TIME
import ooo.jtc.generic.TIMESTAMP_TO_ZONEDDATE_TIME
import ooo.jtc.generic.ZONEDDATE_TIME_TO_TIMESTAMP
import ooo.jtc.interfaces.AbstractDtoMapper
import ooo.jtc.uaa.user.dto.UaaUserDto
import ooo.jtc.uaa.user.model.UaaUser
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(uses = [CustomConverter::class])
interface UaaUserMapper : AbstractDtoMapper<UaaUser, UaaUserDto> {

    @Mappings(
        Mapping(source = "permBlock", target = "permanentBlocked"),
        Mapping(source = "tempBlock", target = "temporaryBlocked"),
        Mapping(source = "prefLocale", target = "preferredLocale"),
        Mapping(
            source = "tempBlockUntil", target = "temporaryBlockedUntil",
            qualifiedByName = [CUSTOM_CONVERTER, TIMESTAMP_TO_ZONEDDATE_TIME]
        ),
        Mapping(source = "firstName", target = "userDetails.firstName"),
        Mapping(source = "lastName", target = "userDetails.lastName"),
        Mapping(source = "middleName", target = "userDetails.middleName"),
        Mapping(source = "phoneNumber", target = "userDetails.phoneNumber"),
        Mapping(source = "email", target = "userDetails.email")
    )
    override fun toDto(domainModel: UaaUser): UaaUserDto

    @InheritInverseConfiguration
    @Mappings(
        Mapping(
            source = "temporaryBlockedUntil", target = "tempBlockUntil",
            qualifiedByName = [CUSTOM_CONVERTER, ZONEDDATE_TIME_TO_TIMESTAMP]
        )
    )
    override fun toDomainModel(dto: UaaUserDto): UaaUser
}
