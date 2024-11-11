package ooo.jtc.dictionaries.customerrepresentative;

import java.lang.System;

@org.mapstruct.Mapper(uses = {ooo.jtc.generic.CustomConverter.class})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\'\u00a8\u0006\b"}, d2 = {"Looo/jtc/dictionaries/customerrepresentative/CustomerRepresentativeMapper;", "Looo/jtc/interfaces/AbstractDtoMapper;", "Looo/jtc/dictionaries/customerrepresentative/CustomerRepresentative;", "Looo/jtc/dictionaries/customerrepresentative/CustomerRepresentativeDto;", "toDomainModel", "dto", "toDto", "domainModel", "datamodels"})
public abstract interface CustomerRepresentativeMapper extends ooo.jtc.interfaces.AbstractDtoMapper<ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentative, ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto> {
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "block.isBlock", source = "isBlock"), @org.mapstruct.Mapping(target = "block.blockUser", source = "blockUserId"), @org.mapstruct.Mapping(target = "block.blockDate", source = "blockDate", qualifiedByName = {"CustomConverter", "TimestampToZonedDateTime"})})
    @java.lang.Override()
    public abstract ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto toDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentative domainModel);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "blockDate", source = "block.blockDate", qualifiedByName = {"CustomConverter", "ZonedDateTimeToTimestamp"})})
    @org.mapstruct.InheritInverseConfiguration()
    @java.lang.Override()
    public abstract ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentative toDomainModel(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto dto);
}