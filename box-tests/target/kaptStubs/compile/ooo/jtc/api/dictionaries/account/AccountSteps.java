package ooo.jtc.api.dictionaries.account;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J:\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007J>\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Looo/jtc/api/dictionaries/account/AccountSteps;", "Looo/jtc/api/common/steps/AbstractDictionarySteps;", "Looo/jtc/dictionaries/account/AccountDto;", "user", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)V", "responseBigDecimalListType", "Lcom/fasterxml/jackson/databind/JavaType;", "getAccountBalance", "Looo/jtc/generic/GenericListResponseDto;", "Ljava/math/BigDecimal;", "accountNumber", "", "bic", "customerId", "Ljava/util/UUID;", "withCheckResponseCode", "", "statusCode", "", "getByAccountNumber", "branchId", "box-tests"})
public final class AccountSteps extends ooo.jtc.api.common.steps.AbstractDictionarySteps<ooo.jtc.dictionaries.account.AccountDto, ooo.jtc.dictionaries.account.AccountDto> {
    private final com.fasterxml.jackson.databind.JavaType responseBigDecimalListType = null;
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0431\u0430\u043b\u0430\u043d\u0441 \u0441\u0447\u0451\u0442\u0430 \u043f\u043e \u0435\u0433\u043e \u0440\u0435\u043a\u0432\u0438\u0437\u0438\u0442\u0430\u043c (\u043d\u043e\u043c\u0435\u0440 \'{accountNumber}\', \u0411\u0418\u041a \'{bic}\', \u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u044f [{customerId}])")
    public final ooo.jtc.generic.GenericListResponseDto<java.math.BigDecimal> getAccountBalance(@org.jetbrains.annotations.NotNull()
    java.lang.String accountNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String bic, @org.jetbrains.annotations.NotNull()
    java.util.UUID customerId, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u0447\u0451\u0442 \u043f\u043e \u0435\u0433\u043e \u0440\u0435\u043a\u0432\u0438\u0437\u0438\u0442\u0430\u043c (\u043d\u043e\u043c\u0435\u0440 \'{accountNumber}\', \u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u044f [{customerId}], \u043f\u043e\u0434\u0440\u0430\u0437\u0434\u0435\u043b\u0435\u043d\u0438\u0435 [{branchId}])")
    public final ooo.jtc.generic.GenericListResponseDto<ooo.jtc.dictionaries.account.AccountDto> getByAccountNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String accountNumber, @org.jetbrains.annotations.Nullable()
    java.util.UUID branchId, @org.jetbrains.annotations.Nullable()
    java.util.UUID customerId, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    public AccountSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        super(null, null, null, null);
    }
}