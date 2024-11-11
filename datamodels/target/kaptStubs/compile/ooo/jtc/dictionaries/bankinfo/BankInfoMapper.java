package ooo.jtc.dictionaries.bankinfo;

import java.lang.System;

@org.mapstruct.Mapper(uses = {ooo.jtc.generic.CustomConverter.class})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\'\u00a8\u0006\b"}, d2 = {"Looo/jtc/dictionaries/bankinfo/BankInfoMapper;", "Looo/jtc/interfaces/AbstractDtoMapper;", "Looo/jtc/dictionaries/bankinfo/BankInfo;", "Looo/jtc/dictionaries/bankinfo/BankInfoDto;", "toDomainModel", "dto", "toDto", "domainModel", "datamodels"})
public abstract interface BankInfoMapper extends ooo.jtc.interfaces.AbstractDtoMapper<ooo.jtc.dictionaries.bankinfo.BankInfo, ooo.jtc.dictionaries.bankinfo.BankInfoDto> {
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "uiSettings", source = "uiSettings", qualifiedByName = {"CustomConverter", "StringToMap"})})
    @java.lang.Override()
    public abstract ooo.jtc.dictionaries.bankinfo.BankInfoDto toDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankinfo.BankInfo domainModel);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "uiSettings", source = "uiSettings", qualifiedByName = {"CustomConverter", "MapToString"})})
    @org.mapstruct.InheritInverseConfiguration()
    @java.lang.Override()
    public abstract ooo.jtc.dictionaries.bankinfo.BankInfo toDomainModel(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankinfo.BankInfoDto dto);
}