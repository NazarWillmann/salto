package ooo.jtc.dictionaries.bankinfo

import ooo.jtc.generic.CUSTOM_CONVERTER
import ooo.jtc.generic.CustomConverter
import ooo.jtc.generic.MAP_TO_STRING
import ooo.jtc.generic.STRING_TO_MAP
import ooo.jtc.interfaces.AbstractDtoMapper
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(uses = [CustomConverter::class])
interface BankInfoMapper : AbstractDtoMapper<BankInfo, BankInfoDto> {

    @Mappings(
        Mapping(
            source = "uiSettings", target = "uiSettings",
            qualifiedByName = [CUSTOM_CONVERTER, STRING_TO_MAP]
        )
    )
    override fun toDto(domainModel: BankInfo): BankInfoDto

    @InheritInverseConfiguration
    @Mappings(
        Mapping(
            source = "uiSettings", target = "uiSettings",
            qualifiedByName = [CUSTOM_CONVERTER, MAP_TO_STRING]
        )
    )
    override fun toDomainModel(dto: BankInfoDto): BankInfo
}