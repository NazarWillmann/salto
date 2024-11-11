package ooo.jtc.dictionaries.bankbic.acc;

import java.lang.System;

@org.mapstruct.Mapper(imports = {ooo.jtc.dictionaries.bankbic.acc.BankBicAccAccountTypeIEnum.class, ooo.jtc.dictionaries.bankbic.acc.BankBicAccStatusIEnum.class, ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrCodeIEnum.class})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\'J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH\'J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0003H\'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0003H\'\u00a8\u0006\u0011"}, d2 = {"Looo/jtc/dictionaries/bankbic/acc/BankBicAccountMapper;", "Looo/jtc/interfaces/AbstractDtoMapper;", "Looo/jtc/dictionaries/bankbic/acc/BankBicAccount;", "Looo/jtc/dictionaries/bankbic/acc/BankBicAccountDto;", "accRestrToED807AccRestr", "Looo/jtc/dictionaries/bankbic/ed807/ED807AccountRestriction;", "restrictionDto", "Looo/jtc/dictionaries/bankbic/acc/restr/BankBicAccRestrictionDto;", "nestedListOfRestrictionsToDomainModel", "Looo/jtc/dictionaries/bankbic/acc/restr/BankBicAccRestriction;", "dto", "nestedListOfRestrictionsToDto", "domainModel", "toDomainModel", "toDto", "toED807Account", "Looo/jtc/dictionaries/bankbic/ed807/ED807Account;", "datamodels"})
public abstract interface BankBicAccountMapper extends ooo.jtc.interfaces.AbstractDtoMapper<ooo.jtc.dictionaries.bankbic.acc.BankBicAccount, ooo.jtc.dictionaries.bankbic.acc.BankBicAccountDto> {
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "accountType", expression = "java(BankBicAccAccountTypeIEnum.Companion.ofStr(domainModel.getAccountType()))"), @org.mapstruct.Mapping(target = "status", expression = "java(BankBicAccStatusIEnum.Companion.ofStr(domainModel.getStatus()))")})
    @java.lang.Override()
    public abstract ooo.jtc.dictionaries.bankbic.acc.BankBicAccountDto toDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.acc.BankBicAccount domainModel);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "accountType", source = "accountType.value"), @org.mapstruct.Mapping(target = "status", source = "status.value")})
    @java.lang.Override()
    public abstract ooo.jtc.dictionaries.bankbic.acc.BankBicAccount toDomainModel(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.acc.BankBicAccountDto dto);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "restrictionCode", expression = "java(BankBicAccRestrCodeIEnum.Companion.ofStr(domainModel.getRestrictionCode()))")})
    public abstract ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionDto nestedListOfRestrictionsToDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestriction domainModel);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "restrictionCode", source = "restrictionCode.value")})
    public abstract ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestriction nestedListOfRestrictionsToDomainModel(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionDto dto);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "regulationAccountType", source = "accountType.value"), @org.mapstruct.Mapping(target = "accountCbrBic", source = "accountBic"), @org.mapstruct.Mapping(target = "accountStatus", source = "status.value"), @org.mapstruct.Mapping(target = "restrictionList", source = "restrictions")})
    public abstract ooo.jtc.dictionaries.bankbic.ed807.ED807Account toED807Account(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.acc.BankBicAccountDto dto);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "accRstr", source = "restrictionCode.value"), @org.mapstruct.Mapping(target = "accRstrDate", source = "restrictionDate")})
    public abstract ooo.jtc.dictionaries.bankbic.ed807.ED807AccountRestriction accRestrToED807AccRestr(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionDto restrictionDto);
}