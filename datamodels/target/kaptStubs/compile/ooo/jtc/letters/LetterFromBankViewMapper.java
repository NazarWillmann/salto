package ooo.jtc.letters;

import java.lang.System;

@org.mapstruct.Mapper(uses = {ooo.jtc.generic.ViewConverter.class}, imports = {ooo.jtc.letters.model.LetterFromBankStatus.class, ooo.jtc.generic.KJavaConverter.class}, nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\'\u00a8\u0006\b"}, d2 = {"Looo/jtc/letters/LetterFromBankViewMapper;", "Looo/jtc/interfaces/AbstractViewMapper;", "Looo/jtc/letters/dto/LetterFromBankDto;", "Looo/jtc/letters/LetterFromBankView;", "toDto", "view", "toView", "dto", "datamodels"})
public abstract interface LetterFromBankViewMapper extends ooo.jtc.interfaces.AbstractViewMapper<ooo.jtc.letters.dto.LetterFromBankDto, ooo.jtc.letters.LetterFromBankView> {
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.InheritInverseConfiguration()
    @java.lang.Override()
    public abstract ooo.jtc.letters.dto.LetterFromBankDto toDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.LetterFromBankView view);
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Mappings(value = {@org.mapstruct.Mapping(target = "documentDate", source = "documentDate", defaultValue = "", qualifiedByName = {"ViewConverter", "LocalDateToString"}), @org.mapstruct.Mapping(target = "id", nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.SET_TO_NULL, source = "id"), @org.mapstruct.Mapping(target = "documentNumber", source = "documentNumber", defaultValue = ""), @org.mapstruct.Mapping(target = "statusSystem", source = "status", defaultValue = ""), @org.mapstruct.Mapping(target = "statusClient", expression = "java(KJavaConverter.INSTANCE.convertToStatusClient(LetterFromBankStatus.values(),dto.getStatus()))"), @org.mapstruct.Mapping(target = "statusBank", expression = "java(KJavaConverter.INSTANCE.convertToStatusBank(LetterFromBankStatus.values(),dto.getStatus()))"), @org.mapstruct.Mapping(target = "createdAt", source = "createdAt", defaultValue = ""), @org.mapstruct.Mapping(target = "customerName", source = "customerName", defaultValue = ""), @org.mapstruct.Mapping(target = "branchName", source = "branchName", defaultValue = ""), @org.mapstruct.Mapping(target = "contactName", source = "contactName", defaultValue = ""), @org.mapstruct.Mapping(target = "contactPhone", source = "contactPhone", defaultValue = ""), @org.mapstruct.Mapping(target = "docType", source = "docType", defaultValue = ""), @org.mapstruct.Mapping(target = "docTypeDescription", source = "docTypeDescription", defaultValue = ""), @org.mapstruct.Mapping(target = "docTheme", source = "docTheme", defaultValue = ""), @org.mapstruct.Mapping(target = "docText", source = "docText", defaultValue = ""), @org.mapstruct.Mapping(target = "branchId", nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.SET_TO_NULL, source = "branchId"), @org.mapstruct.Mapping(target = "customerId", nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.SET_TO_NULL, source = "customerId"), @org.mapstruct.Mapping(target = "letterToBankId", nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.SET_TO_NULL, source = "letterToBankId")})
    @java.lang.Override()
    public abstract ooo.jtc.letters.LetterFromBankView toView(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterFromBankDto dto);
}