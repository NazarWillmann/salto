package ooo.jtc.dictionaries.bankbic.acc.restr;

import java.lang.System;

@org.mapstruct.Mapper(imports = {ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrCodeIEnum.class})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\'\u00a8\u0006\b"}, d2 = {"Looo/jtc/dictionaries/bankbic/acc/restr/BankBicAccRestrictionMapper;", "Looo/jtc/interfaces/AbstractDtoMapper;", "Looo/jtc/dictionaries/bankbic/acc/restr/BankBicAccRestriction;", "Looo/jtc/dictionaries/bankbic/acc/restr/BankBicAccRestrictionDto;", "toDomainModel", "dto", "toDto", "domainModel", "datamodels"})
public abstract interface BankBicAccRestrictionMapper extends ooo.jtc.interfaces.AbstractDtoMapper<ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestriction, ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionDto> {
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "restrictionCode", expression = "java(BankBicAccRestrCodeIEnum.Companion.ofStr(domainModel.getRestrictionCode()))")})
    @java.lang.Override()
    public abstract ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionDto toDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestriction domainModel);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "restrictionCode", source = "restrictionCode.value")})
    @java.lang.Override()
    public abstract ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestriction toDomainModel(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionDto dto);
}