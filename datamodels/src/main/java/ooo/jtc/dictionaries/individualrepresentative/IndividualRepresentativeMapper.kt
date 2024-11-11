package ooo.jtc.dictionaries.individualrepresentative

import ooo.jtc.generic.CUSTOM_CONVERTER
import ooo.jtc.generic.TIMESTAMP_TO_ZONEDDATE_TIME
import ooo.jtc.generic.ZONEDDATE_TIME_TO_TIMESTAMP
import ooo.jtc.interfaces.AbstractDtoMapper
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapping
import org.mapstruct.Mappings

interface IndividualRepresentativeMapper : AbstractDtoMapper<IndividualRepresentative, IndividualRepresentativeDto> {
    @Mappings(
        Mapping(source = "isBlock", target = "block.isBlock"),
        Mapping(source = "blockUser", target = "block.blockUser"),
        Mapping(
            source = "blockDate", target = "block.blockDate",
            qualifiedByName = [CUSTOM_CONVERTER, TIMESTAMP_TO_ZONEDDATE_TIME]
        )
    )
    override fun toDto(domainModel: IndividualRepresentative): IndividualRepresentativeDto

    @InheritInverseConfiguration
    @Mappings(
        Mapping(
            source = "block.blockDate", target = "blockDate",
            qualifiedByName = [CUSTOM_CONVERTER, ZONEDDATE_TIME_TO_TIMESTAMP]
        )
    )
    override fun toDomainModel(dto: IndividualRepresentativeDto): IndividualRepresentative
}