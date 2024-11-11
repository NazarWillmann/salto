package ooo.jtc.api.dictionaries.bankbic;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0007J \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\rH\u0007J \u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\rH\u0007J&\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Looo/jtc/api/dictionaries/bankbic/BankBicSteps;", "Looo/jtc/api/common/steps/AbstractDictionarySteps;", "Looo/jtc/dictionaries/bankbic/BankBicDto;", "user", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)V", "importResultResponseType", "Lcom/fasterxml/jackson/databind/JavaType;", "getImportResultResponseType", "()Lcom/fasterxml/jackson/databind/JavaType;", "importResultResponseType$delegate", "Lkotlin/Lazy;", "notApplicableError", "", "create", "Looo/jtc/generic/GenericResponseDto;", "entity", "withCheckResponseCode", "", "statusCode", "", "delete", "id", "Ljava/util/UUID;", "findByBic", "Looo/jtc/generic/GenericListResponseDto;", "bic", "importBankBic", "Looo/jtc/api/dictionaries/swift/ImportResultDto;", "bankBicFile", "Ljava/io/File;", "fileName", "importBankBicAsync", "update", "box-tests"})
public final class BankBicSteps extends ooo.jtc.api.common.steps.AbstractDictionarySteps<ooo.jtc.dictionaries.bankbic.BankBicDto, ooo.jtc.dictionaries.bankbic.BankBicDto> {
    private final kotlin.Lazy importResultResponseType$delegate = null;
    private final java.lang.String notApplicableError = "Not applicable for BankBic dictionary. It can be changed only through import";
    
    private final com.fasterxml.jackson.databind.JavaType getImportResultResponseType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.Suppress(names = {"UNUSED_PARAMETER"})
    @io.qameta.allure.Step(value = "\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c (upload) \u0441\u043f\u0438\u0441\u043e\u043a \u0411\u0418\u041a \u0420\u0424 \'{fileName}\'")
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.api.dictionaries.swift.ImportResultDto> importBankBic(@org.jetbrains.annotations.NotNull()
    java.io.File bankBicFile, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.Suppress(names = {"UNUSED_PARAMETER"})
    @io.qameta.allure.Step(value = "\u0410\u0441\u0438\u043d\u0445\u0440\u043e\u043d\u043d\u043e \u0437\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c (upload) \u0441\u043f\u0438\u0441\u043e\u043a \u0411\u0418\u041a \u0420\u0424 \'{fileName}\'")
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.api.dictionaries.swift.ImportResultDto> importBankBicAsync(@org.jetbrains.annotations.NotNull()
    java.io.File bankBicFile, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \'{this.entityName}\' \u043f\u043e bic={bic}")
    public final ooo.jtc.generic.GenericListResponseDto<ooo.jtc.dictionaries.bankbic.BankBicDto> findByBic(@org.jetbrains.annotations.NotNull()
    java.lang.String bic) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.generic.GenericResponseDto<ooo.jtc.dictionaries.bankbic.BankBicDto> create(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.BankBicDto entity, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.generic.GenericResponseDto<ooo.jtc.dictionaries.bankbic.BankBicDto> update(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.BankBicDto entity, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.generic.GenericResponseDto<ooo.jtc.dictionaries.bankbic.BankBicDto> delete(@org.jetbrains.annotations.NotNull()
    java.util.UUID id, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    public BankBicSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        super(null, null, null, null);
    }
    
    public BankBicSteps() {
        super(null, null, null, null);
    }
}