package ooo.jtc.uaa.user.mapper;

import java.lang.System;

@org.mapstruct.Mapper(uses = {ooo.jtc.generic.CustomConverter.class})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\'\u00a8\u0006\b"}, d2 = {"Looo/jtc/uaa/user/mapper/UaaUserMapper;", "Looo/jtc/interfaces/AbstractDtoMapper;", "Looo/jtc/uaa/user/model/UaaUser;", "Looo/jtc/uaa/user/dto/UaaUserDto;", "toDomainModel", "dto", "toDto", "domainModel", "datamodels"})
public abstract interface UaaUserMapper extends ooo.jtc.interfaces.AbstractDtoMapper<ooo.jtc.uaa.user.model.UaaUser, ooo.jtc.uaa.user.dto.UaaUserDto> {
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "permanentBlocked", source = "permBlock"), @org.mapstruct.Mapping(target = "temporaryBlocked", source = "tempBlock"), @org.mapstruct.Mapping(target = "preferredLocale", source = "prefLocale"), @org.mapstruct.Mapping(target = "temporaryBlockedUntil", source = "tempBlockUntil", qualifiedByName = {"CustomConverter", "TimestampToZonedDateTime"}), @org.mapstruct.Mapping(target = "userDetails.firstName", source = "firstName"), @org.mapstruct.Mapping(target = "userDetails.lastName", source = "lastName"), @org.mapstruct.Mapping(target = "userDetails.middleName", source = "middleName"), @org.mapstruct.Mapping(target = "userDetails.phoneNumber", source = "phoneNumber"), @org.mapstruct.Mapping(target = "userDetails.email", source = "email")})
    @java.lang.Override()
    public abstract ooo.jtc.uaa.user.dto.UaaUserDto toDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.user.model.UaaUser domainModel);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "tempBlockUntil", source = "temporaryBlockedUntil", qualifiedByName = {"CustomConverter", "ZonedDateTimeToTimestamp"})})
    @org.mapstruct.InheritInverseConfiguration()
    @java.lang.Override()
    public abstract ooo.jtc.uaa.user.model.UaaUser toDomainModel(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.user.dto.UaaUserDto dto);
}