package ooo.jtc.uaa.application.mapper;

import java.lang.System;

@org.mapstruct.Mapper()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\'\u00a8\u0006\b"}, d2 = {"Looo/jtc/uaa/application/mapper/ApplicationMapper;", "Looo/jtc/interfaces/AbstractDtoMapper;", "Looo/jtc/uaa/application/model/Application;", "Looo/jtc/uaa/application/dto/ApplicationDto;", "toDomainModel", "dto", "toDto", "domainModel", "datamodels"})
public abstract interface ApplicationMapper extends ooo.jtc.interfaces.AbstractDtoMapper<ooo.jtc.uaa.application.model.Application, ooo.jtc.uaa.application.dto.ApplicationDto> {
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "autoApproveScopes", source = "autoApprove"), @org.mapstruct.Mapping(target = "loginSite.baseUrl", source = "baseUrl"), @org.mapstruct.Mapping(target = "loginSite.loginPath", source = "loginPath"), @org.mapstruct.Mapping(target = "loginSite.approvePath", source = "approvePath"), @org.mapstruct.Mapping(target = "loginSite.mfaPath", source = "mfaPath"), @org.mapstruct.Mapping(target = "loginSite.smsMfaPath", source = "smsMfaPath"), @org.mapstruct.Mapping(target = "loginSite.paramsViaFragment", source = "paramsViaFragment")})
    @java.lang.Override()
    public abstract ooo.jtc.uaa.application.dto.ApplicationDto toDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.application.model.Application domainModel);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.InheritInverseConfiguration()
    @java.lang.Override()
    public abstract ooo.jtc.uaa.application.model.Application toDomainModel(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.application.dto.ApplicationDto dto);
}