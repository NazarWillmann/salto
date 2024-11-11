package ooo.jtc.dictionaries.bankbic.restr

import ooo.jtc.interfaces.AbstractDtoMapper
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings


@Mapper(
    imports = [BankBicRestrCodeIEnum::class]
)
interface BankBicRestrictionMapper: AbstractDtoMapper<BankBicRestriction, BankBicRestrictionDto> {

    @Mappings(
        Mapping(target = "restrictionCode",
            expression = "java(BankBicRestrCodeIEnum.Companion.ofStr(domainModel.getRestrictionCode()))"
        )
    )
    override fun toDto(domainModel: BankBicRestriction): BankBicRestrictionDto

    @Mappings(
        Mapping(source = "restrictionCode.value", target = "restrictionCode")
    )
    override fun toDomainModel(dto: BankBicRestrictionDto): BankBicRestriction
}