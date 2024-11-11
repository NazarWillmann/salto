package ooo.jtc.api.dictionaries.bankinfo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017J*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u00a8\u0006\u000f"}, d2 = {"Looo/jtc/api/dictionaries/bankinfo/BankInfoSteps;", "Looo/jtc/api/common/steps/AbstractDictionarySteps;", "Looo/jtc/dictionaries/bankinfo/BankInfoDto;", "bankUser", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)V", "delete", "Looo/jtc/generic/GenericResponseDto;", "id", "Ljava/util/UUID;", "withCheckResponseCode", "", "statusCode", "", "deleteOnlyBankInfo", "box-tests"})
public final class BankInfoSteps extends ooo.jtc.api.common.steps.AbstractDictionarySteps<ooo.jtc.dictionaries.bankinfo.BankInfoDto, ooo.jtc.dictionaries.bankinfo.BankInfoDto> {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \'{this.entityName}\' \u0438 \u0441\u0432\u044f\u0437\u0430\u043d\u043d\u044b\u0445 \u043f\u0440\u0435\u0434\u0441\u0442\u0430\u0432\u0438\u0442\u0435\u043b\u0435\u0439 \u043f\u043e id={id}")
    public ooo.jtc.generic.GenericResponseDto<ooo.jtc.dictionaries.bankinfo.BankInfoDto> delete(@org.jetbrains.annotations.NotNull()
    java.util.UUID id, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \'{this.entityName}\' \u043f\u043e id={id}")
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.dictionaries.bankinfo.BankInfoDto> deleteOnlyBankInfo(@org.jetbrains.annotations.NotNull()
    java.util.UUID id, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    public BankInfoSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User bankUser) {
        super(null, null, null, null);
    }
}