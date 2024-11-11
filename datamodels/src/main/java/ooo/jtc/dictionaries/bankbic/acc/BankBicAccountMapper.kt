package ooo.jtc.dictionaries.bankbic.acc

import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrCodeIEnum
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestriction
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionDto
import ooo.jtc.dictionaries.bankbic.ed807.ED807Account
import ooo.jtc.dictionaries.bankbic.ed807.ED807AccountRestriction
import ooo.jtc.interfaces.AbstractDtoMapper
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(
    imports = [
        //BankBicAccounts str2InnerEnum mappers
        BankBicAccAccountTypeIEnum::class, BankBicAccStatusIEnum::class,
        //nested BankBicAccountRestrictions str2InnerEnum mappers
        BankBicAccRestrCodeIEnum::class
    ]
)
interface BankBicAccountMapper: AbstractDtoMapper<BankBicAccount, BankBicAccountDto> {

    @Mappings(
        Mapping(
            target = "accountType",
            expression = "java(BankBicAccAccountTypeIEnum.Companion.ofStr(domainModel.getAccountType()))"
        ),
        Mapping(target = "status",
            expression = "java(BankBicAccStatusIEnum.Companion.ofStr(domainModel.getStatus()))"
        )
    )
    override fun toDto(domainModel: BankBicAccount): BankBicAccountDto

    @Mappings(
        Mapping(source = "accountType.value", target = "accountType"),
        Mapping(source = "status.value", target = "status")
    )
    override fun toDomainModel(dto: BankBicAccountDto): BankBicAccount

    //region supplementary mapping
    @Mappings(
        Mapping(target = "restrictionCode",
            expression = "java(BankBicAccRestrCodeIEnum.Companion.ofStr(domainModel.getRestrictionCode()))"
        )
    )
    fun nestedListOfRestrictionsToDto(domainModel: BankBicAccRestriction): BankBicAccRestrictionDto

    @Mappings(
        Mapping(source = "restrictionCode.value", target = "restrictionCode")
    )
    fun nestedListOfRestrictionsToDomainModel(dto: BankBicAccRestrictionDto): BankBicAccRestriction
    //endregion

    //region import-related mapping
    @Mappings(
        Mapping(source = "accountType.value", target = "regulationAccountType"),
        Mapping(source = "accountBic", target = "accountCbrBic"),
        Mapping(source = "status.value", target = "accountStatus"),
        Mapping(source = "restrictions", target = "restrictionList"),
    )
    fun toED807Account(dto: BankBicAccountDto): ED807Account

    @Mappings(
        Mapping(source = "restrictionCode.value", target = "accRstr"),
        Mapping(source = "restrictionDate", target = "accRstrDate")
    )
    fun accRestrToED807AccRestr(restrictionDto: BankBicAccRestrictionDto): ED807AccountRestriction
    //endregion
}