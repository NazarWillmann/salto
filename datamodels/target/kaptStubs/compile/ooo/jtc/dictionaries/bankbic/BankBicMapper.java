package ooo.jtc.dictionaries.bankbic;

import java.lang.System;

@org.mapstruct.Mapper(imports = {ooo.jtc.dictionaries.bankbic.BankBicStatusesIEnum.class, ooo.jtc.dictionaries.bankbic.BankBicParticipantTypeIEnum.class, ooo.jtc.dictionaries.bankbic.BankBicParticipantTransferTypeIEnum.class, ooo.jtc.dictionaries.bankbic.BankBicAllowedServicesIEnum.class, com.mifmif.common.regex.Generex.class, ooo.jtc.dictionaries.bankbic.restr.BankBicRestrCodeIEnum.class, ooo.jtc.dictionaries.bankbic.acc.BankBicAccAccountTypeIEnum.class, ooo.jtc.dictionaries.bankbic.acc.BankBicAccStatusIEnum.class, ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrCodeIEnum.class})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\fH\'J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u000bH\'J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0010H\'J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u000fH\'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\'J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\'J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\'J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0003H\'\u00a8\u0006\u0019"}, d2 = {"Looo/jtc/dictionaries/bankbic/BankBicMapper;", "Looo/jtc/interfaces/AbstractDtoMapper;", "Looo/jtc/dictionaries/bankbic/BankBic;", "Looo/jtc/dictionaries/bankbic/BankBicDto;", "nestedAccountsNestedRestrictionsToDomainModel", "Looo/jtc/dictionaries/bankbic/acc/restr/BankBicAccRestriction;", "dto", "Looo/jtc/dictionaries/bankbic/acc/restr/BankBicAccRestrictionDto;", "nestedAccountsNestedRestrictionsToDto", "domainModel", "nestedAccountsToDomainModel", "Looo/jtc/dictionaries/bankbic/acc/BankBicAccount;", "Looo/jtc/dictionaries/bankbic/acc/BankBicAccountDto;", "nestedAccountsToDto", "nestedRestrictionsToDomainModel", "Looo/jtc/dictionaries/bankbic/restr/BankBicRestriction;", "Looo/jtc/dictionaries/bankbic/restr/BankBicRestrictionDto;", "nestedRestrictionsToDto", "partRestrToED807PartRestr", "Looo/jtc/dictionaries/bankbic/ed807/ED807ParticipantRestriction;", "restrictionDto", "toDomainModel", "toDto", "toED807ParticipantInfo", "Looo/jtc/dictionaries/bankbic/ed807/ED807ParticipantInfo;", "datamodels"})
public abstract interface BankBicMapper extends ooo.jtc.interfaces.AbstractDtoMapper<ooo.jtc.dictionaries.bankbic.BankBic, ooo.jtc.dictionaries.bankbic.BankBicDto> {
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "status", expression = "java(BankBicStatusesIEnum.Companion.ofStr(domainModel.getStatus()))"), @org.mapstruct.Mapping(target = "participantType", expression = "java(BankBicParticipantTypeIEnum.Companion.ofStr(domainModel.getParticipantType()))"), @org.mapstruct.Mapping(target = "participantTransferType", expression = "java(BankBicParticipantTransferTypeIEnum.Companion.ofStr(domainModel.getParticipantTransferType()))"), @org.mapstruct.Mapping(target = "allowedServices", expression = "java(BankBicAllowedServicesIEnum.Companion.ofStr(domainModel.getAllowedServices()))")})
    @java.lang.Override()
    public abstract ooo.jtc.dictionaries.bankbic.BankBicDto toDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.BankBic domainModel);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "status", source = "status.value"), @org.mapstruct.Mapping(target = "participantType", source = "participantType.value"), @org.mapstruct.Mapping(target = "participantTransferType", source = "participantTransferType.value"), @org.mapstruct.Mapping(target = "allowedServices", source = "allowedServices.value")})
    @org.mapstruct.InheritInverseConfiguration()
    @java.lang.Override()
    public abstract ooo.jtc.dictionaries.bankbic.BankBic toDomainModel(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.BankBicDto dto);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "nameP", source = "name"), @org.mapstruct.Mapping(target = "cntrCd", source = "countryAlpha2Code"), @org.mapstruct.Mapping(target = "ind", source = "zip"), @org.mapstruct.Mapping(target = "tnp", source = "locationType"), @org.mapstruct.Mapping(target = "nnp", source = "location"), @org.mapstruct.Mapping(target = "adr", source = "address"), @org.mapstruct.Mapping(target = "prntBic", source = "parentBic"), @org.mapstruct.Mapping(target = "ptType", source = "participantTransferType.value"), @org.mapstruct.Mapping(target = "xchType", source = "participantType.value"), @org.mapstruct.Mapping(target = "srvcs", source = "allowedServices.value"), @org.mapstruct.Mapping(target = "participantStatus", source = "status.value"), @org.mapstruct.Mapping(target = "restrictionList", source = "restrictions"), @org.mapstruct.Mapping(target = "uid", expression = "java(new Generex(\"\\\\d*\").random(10, 10))"), @org.mapstruct.Mapping(target = "rgn", constant = "47")})
    public abstract ooo.jtc.dictionaries.bankbic.ed807.ED807ParticipantInfo toED807ParticipantInfo(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.BankBicDto dto);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "rstr", source = "restrictionCode.value"), @org.mapstruct.Mapping(target = "rstrDate", source = "restrictionDate")})
    public abstract ooo.jtc.dictionaries.bankbic.ed807.ED807ParticipantRestriction partRestrToED807PartRestr(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.restr.BankBicRestrictionDto restrictionDto);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "restrictionCode", expression = "java(BankBicRestrCodeIEnum.Companion.ofStr(domainModel.getRestrictionCode()))")})
    public abstract ooo.jtc.dictionaries.bankbic.restr.BankBicRestrictionDto nestedRestrictionsToDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.restr.BankBicRestriction domainModel);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "restrictionCode", source = "restrictionCode.value")})
    public abstract ooo.jtc.dictionaries.bankbic.restr.BankBicRestriction nestedRestrictionsToDomainModel(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.restr.BankBicRestrictionDto dto);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "accountType", expression = "java(BankBicAccAccountTypeIEnum.Companion.ofStr(domainModel.getAccountType()))"), @org.mapstruct.Mapping(target = "status", expression = "java(BankBicAccStatusIEnum.Companion.ofStr(domainModel.getStatus()))")})
    public abstract ooo.jtc.dictionaries.bankbic.acc.BankBicAccountDto nestedAccountsToDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.acc.BankBicAccount domainModel);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "accountType", source = "accountType.value"), @org.mapstruct.Mapping(target = "status", source = "status.value")})
    public abstract ooo.jtc.dictionaries.bankbic.acc.BankBicAccount nestedAccountsToDomainModel(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.acc.BankBicAccountDto dto);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "restrictionCode", expression = "java(BankBicAccRestrCodeIEnum.Companion.ofStr(domainModel.getRestrictionCode()))")})
    public abstract ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionDto nestedAccountsNestedRestrictionsToDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestriction domainModel);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "restrictionCode", source = "restrictionCode.value")})
    public abstract ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestriction nestedAccountsNestedRestrictionsToDomainModel(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionDto dto);
}