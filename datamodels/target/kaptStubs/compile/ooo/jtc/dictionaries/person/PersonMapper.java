package ooo.jtc.dictionaries.person;

import java.lang.System;

@org.mapstruct.Mapper()
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\'\u00a8\u0006\b"}, d2 = {"Looo/jtc/dictionaries/person/PersonMapper;", "Looo/jtc/interfaces/AbstractDtoMapper;", "Looo/jtc/dictionaries/person/Person;", "Looo/jtc/dictionaries/person/PersonDto;", "toDomainModel", "dto", "toDto", "domainModel", "datamodels"})
public abstract interface PersonMapper extends ooo.jtc.interfaces.AbstractDtoMapper<ooo.jtc.dictionaries.person.Person, ooo.jtc.dictionaries.person.PersonDto> {
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "personalData.firstName", source = "firstName"), @org.mapstruct.Mapping(target = "personalData.lastName", source = "lastName"), @org.mapstruct.Mapping(target = "personalData.middleName", source = "middleName"), @org.mapstruct.Mapping(target = "personalData.mobilePhone", source = "mobilePhone"), @org.mapstruct.Mapping(target = "personalData.email", source = "email"), @org.mapstruct.Mapping(target = "personalData.sex", source = "sex"), @org.mapstruct.Mapping(target = "personalData.birthdate", source = "birthdate"), @org.mapstruct.Mapping(target = "confirmedMobilePhone", source = "phoneConfirmed"), @org.mapstruct.Mapping(target = "confirmedEmail", source = "emailConfirmed")})
    @java.lang.Override()
    public abstract ooo.jtc.dictionaries.person.PersonDto toDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.person.Person domainModel);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.InheritInverseConfiguration()
    @java.lang.Override()
    public abstract ooo.jtc.dictionaries.person.Person toDomainModel(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.person.PersonDto dto);
}