package ooo.jtc.api.dictionaries.account;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u00c0\u0001\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%J\u000e\u0010\'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006J\u000e\u0010)\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010*\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ$\u0010+\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u00a8\u0006,"}, d2 = {"Looo/jtc/api/dictionaries/account/AccountPrepareSteps;", "", "()V", "cleanAtCreated", "", "createNewAccount", "Looo/jtc/dictionaries/account/AccountDto;", "dtoForCreate", "createNewAccountForUser", "Looo/jtc/dictionaries/account/Account;", "user", "Looo/jtc/uaa/User;", "deleteUnusedAccount", "accId", "Ljava/util/UUID;", "getAccountDto", "branchCustomerId", "customerId", "branchId", "currencyAlphaCode", "", "currencyDigitCode", "accountTypeId", "accountKind", "state", "accountNumber", "name", "actualBalance", "Ljava/math/BigDecimal;", "planBalance", "blockedAmount", "cardAmount", "actualDate", "Ljava/time/ZonedDateTime;", "openDate", "closeDate", "isMarkInfoAccount", "", "isBlock", "getAccountDtoForUpdate", "createdDto", "getDefaultAccountDtoForCreate", "getMaxFilledAccountDtoForCreate", "getRuPaymentValidAccountDto", "box-tests"})
public final class AccountPrepareSteps {
    public static final ooo.jtc.api.dictionaries.account.AccountPrepareSteps INSTANCE = null;
    
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0441\u043e\u0437\u0434\u0430\u043d\u043d\u044b\u0435 \u0430\u0432\u0442\u043e\u0442\u0435\u0441\u0442\u0430\u043c\u0438 \u0434\u0430\u043d\u043d\u044b\u0435 Account \u0438\u0437 \u0411\u0414")
    public final void cleanAtCreated() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.account.AccountDto getDefaultAccountDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        return null;
    }
    
    /**
     * Create valid RuPayment-valid Account for user as [User] and customer
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.account.AccountDto getRuPaymentValidAccountDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    java.util.UUID customerId, @org.jetbrains.annotations.NotNull()
    java.util.UUID branchCustomerId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.account.AccountDto getAccountDto(@org.jetbrains.annotations.NotNull()
    java.util.UUID branchCustomerId, @org.jetbrains.annotations.NotNull()
    java.util.UUID customerId, @org.jetbrains.annotations.NotNull()
    java.util.UUID branchId, @org.jetbrains.annotations.Nullable()
    java.lang.String currencyAlphaCode, @org.jetbrains.annotations.NotNull()
    java.lang.String currencyDigitCode, @org.jetbrains.annotations.NotNull()
    java.util.UUID accountTypeId, @org.jetbrains.annotations.NotNull()
    java.lang.String accountKind, @org.jetbrains.annotations.NotNull()
    java.lang.String state, @org.jetbrains.annotations.NotNull()
    java.lang.String accountNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal actualBalance, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal planBalance, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal blockedAmount, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal cardAmount, @org.jetbrains.annotations.NotNull()
    java.time.ZonedDateTime actualDate, @org.jetbrains.annotations.NotNull()
    java.time.ZonedDateTime openDate, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime closeDate, boolean isMarkInfoAccount, boolean isBlock) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.account.AccountDto getMaxFilledAccountDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.account.AccountDto getAccountDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.account.AccountDto createdDto) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043d\u043e\u0432\u044b\u0439 \u0441\u0447\u0451\u0442")
    public final ooo.jtc.dictionaries.account.AccountDto createNewAccount(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.account.AccountDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "(createRecord) \u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043d\u043e\u0432\u044b\u0439 \u0441\u043b\u0443\u0447\u0430\u0439\u043d\u044b\u0439 \'Account\', \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0439 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044e \'{user.login}\'")
    public final ooo.jtc.dictionaries.account.Account createNewAccountForUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0441\u0447\u0451\u0442, \u0435\u0441\u043b\u0438 \u043a \u043d\u0435\u043c\u0443 \u043d\u0435 \u043f\u0440\u0438\u0432\u044f\u0437\u0430\u043d\u043e \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432")
    public final void deleteUnusedAccount(@org.jetbrains.annotations.NotNull()
    java.util.UUID accId) {
    }
    
    private AccountPrepareSteps() {
        super();
    }
}