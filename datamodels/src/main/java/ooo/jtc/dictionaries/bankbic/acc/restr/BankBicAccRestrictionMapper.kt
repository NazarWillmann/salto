package ooo.jtc.dictionaries.bankbic.acc.restr

import ooo.jtc.interfaces.AbstractDtoMapper
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(
    imports = [BankBicAccRestrCodeIEnum::class]
)
interface BankBicAccRestrictionMapper: AbstractDtoMapper<BankBicAccRestriction, BankBicAccRestrictionDto> {

    @Mappings(
        Mapping(target = "restrictionCode",
            expression = "java(BankBicAccRestrCodeIEnum.Companion.ofStr(domainModel.getRestrictionCode()))"
        )
    )
    override fun toDto(domainModel: BankBicAccRestriction): BankBicAccRestrictionDto

    @Mappings(
        Mapping(source = "restrictionCode.value", target = "restrictionCode")
    )
    override fun toDomainModel(dto: BankBicAccRestrictionDto): BankBicAccRestriction
}