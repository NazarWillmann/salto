package ooo.jtc.dictionaries.bankrepresentative

import ooo.jtc.generic.CUSTOM_CONVERTER
import ooo.jtc.generic.CustomConverter
import ooo.jtc.generic.TIMESTAMP_TO_ZONEDDATE_TIME
import ooo.jtc.generic.ZONEDDATE_TIME_TO_TIMESTAMP
import ooo.jtc.interfaces.AbstractDtoMapper
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(uses = [CustomConverter::class])
interface BankRepresentativeMapper : AbstractDtoMapper<BankRepresentative, BankRepresentativeDto> {

    @Mappings(
        Mapping(source = "isBlock", target = "block.isBlock"),
        Mapping(source = "blockUserId", target = "block.blockUser"),
        Mapping(
            source = "blockDate", target = "block.blockDate",
            qualifiedByName = [CUSTOM_CONVERTER, TIMESTAMP_TO_ZONEDDATE_TIME]
        )
    )
    override fun toDto(domainModel: BankRepresentative): BankRepresentativeDto

    @InheritInverseConfiguration
    @Mappings(
        Mapping(
            source = "block.blockDate", target = "blockDate",
            qualifiedByName = [CUSTOM_CONVERTER, ZONEDDATE_TIME_TO_TIMESTAMP]
        )
    )
    override fun toDomainModel(dto: BankRepresentativeDto): BankRepresentative
}