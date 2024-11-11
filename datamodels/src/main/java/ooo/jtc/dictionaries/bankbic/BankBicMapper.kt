package ooo.jtc.dictionaries.bankbic

import com.mifmif.common.regex.Generex
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccAccountTypeIEnum
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccStatusIEnum
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccount
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccountDto
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrCodeIEnum
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestriction
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionDto
import ooo.jtc.dictionaries.bankbic.ed807.ED807ParticipantInfo
import ooo.jtc.dictionaries.bankbic.ed807.ED807ParticipantRestriction
import ooo.jtc.dictionaries.bankbic.restr.BankBicRestrCodeIEnum
import ooo.jtc.dictionaries.bankbic.restr.BankBicRestriction
import ooo.jtc.dictionaries.bankbic.restr.BankBicRestrictionDto
import ooo.jtc.interfaces.AbstractDtoMapper
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(
    imports = [
        //BankBic str2InnerEnum mappers
        BankBicStatusesIEnum::class, BankBicParticipantTypeIEnum::class,
        BankBicParticipantTransferTypeIEnum::class, BankBicAllowedServicesIEnum::class,
        //import-related mapping
        Generex::class,
        //nested BankBicRestrictions str2InnerEnum mappers
        BankBicRestrCodeIEnum::class,
        //nested BankBicAccounts str2InnerEnum mappers
        BankBicAccAccountTypeIEnum::class, BankBicAccStatusIEnum::class,
        //nested^2 BankBicAccountRestrictions str2InnerEnum mappers
        BankBicAccRestrCodeIEnum::class
    ]
)
interface BankBicMapper: AbstractDtoMapper<BankBic, BankBicDto> {

    @Mappings(
        Mapping(target = "status",
            expression = "java(BankBicStatusesIEnum.Companion.ofStr(domainModel.getStatus()))"
        ),
        Mapping(target = "participantType",
            expression = "java(BankBicParticipantTypeIEnum.Companion.ofStr(domainModel.getParticipantType()))"
        ),
        Mapping(target = "participantTransferType",
            expression = "java(BankBicParticipantTransferTypeIEnum.Companion.ofStr(domainModel.getParticipantTransferType()))"
        ),
        Mapping(target = "allowedServices",
            expression = "java(BankBicAllowedServicesIEnum.Companion.ofStr(domainModel.getAllowedServices()))"
        )
    )
    override fun toDto(domainModel: BankBic): BankBicDto

    @InheritInverseConfiguration
    @Mappings(
        Mapping(source = "status.value", target = "status"),
        Mapping(source = "participantType.value", target = "participantType"),
        Mapping(source = "participantTransferType.value", target = "participantTransferType"),
        Mapping(source = "allowedServices.value", target = "allowedServices"),
    )
    override fun toDomainModel(dto: BankBicDto): BankBic


    //region import-related mappers
    @Mappings(
        Mapping(source = "name", target = "nameP"),
        Mapping(source = "countryAlpha2Code", target = "cntrCd"),
        Mapping(source = "zip", target = "ind"),
        Mapping(source = "locationType", target = "tnp"),
        Mapping(source = "location", target = "nnp"),
        Mapping(source = "address", target = "adr"),
        Mapping(source = "parentBic", target = "prntBic"),
        Mapping(source = "participantTransferType.value", target = "ptType"),
        Mapping(source = "participantType.value", target = "xchType"),
        Mapping(source = "allowedServices.value", target = "srvcs"),
        Mapping(source = "status.value", target = "participantStatus"),
        Mapping(source = "restrictions", target = "restrictionList"),

        Mapping(target = "uid", expression = """java(new Generex("\\d*").random(10, 10))"""),
        Mapping(target = "rgn", constant = "47")
    )
    fun toED807ParticipantInfo(dto: BankBicDto): ED807ParticipantInfo

    @Mappings(
        Mapping(source = "restrictionCode.value", target = "rstr"),
        Mapping(source = "restrictionDate", target = "rstrDate")
    )
    fun partRestrToED807PartRestr(restrictionDto: BankBicRestrictionDto): ED807ParticipantRestriction

    //endregion

    @Mappings(
        Mapping(target = "restrictionCode", expression = "java(BankBicRestrCodeIEnum.Companion.ofStr(domainModel.getRestrictionCode()))")
    )
    fun nestedRestrictionsToDto(domainModel: BankBicRestriction): BankBicRestrictionDto

    @Mappings(
        Mapping(source = "restrictionCode.value", target = "restrictionCode")
    )
    fun nestedRestrictionsToDomainModel(dto: BankBicRestrictionDto): BankBicRestriction



    @Mappings(
        Mapping(target = "accountType", expression = "java(BankBicAccAccountTypeIEnum.Companion.ofStr(domainModel.getAccountType()))"),
        Mapping(target = "status", expression = "java(BankBicAccStatusIEnum.Companion.ofStr(domainModel.getStatus()))")
    )
    fun nestedAccountsToDto(domainModel: BankBicAccount): BankBicAccountDto

    @Mappings(
        Mapping(source = "accountType.value", target = "accountType"),
        Mapping(source = "status.value", target = "status")
    )
    fun nestedAccountsToDomainModel(dto: BankBicAccountDto): BankBicAccount

    @Mappings(
        Mapping(target = "restrictionCode", expression = "java(BankBicAccRestrCodeIEnum.Companion.ofStr(domainModel.getRestrictionCode()))")
    )
    fun nestedAccountsNestedRestrictionsToDto(domainModel: BankBicAccRestriction): BankBicAccRestrictionDto

    @Mappings(
        Mapping(source = "restrictionCode.value", target = "restrictionCode")
    )
    fun nestedAccountsNestedRestrictionsToDomainModel(dto: BankBicAccRestrictionDto): BankBicAccRestriction
}