package ooo.jtc.api.dictionaries.customerkpp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006\u00a8\u0006\u000f"}, d2 = {"Looo/jtc/api/dictionaries/customerkpp/CustomerKppPrepareSteps;", "", "()V", "cleanAtCreated", "", "createCustomerKppDto", "Looo/jtc/dictionaries/customerkpp/CustomerKppDto;", "customerId", "Ljava/util/UUID;", "dtoForCreate", "customerRelatedUser", "Looo/jtc/uaa/User;", "getCustomerKppDtoForCreate", "getCustomerKppDtoForUpdate", "createdDto", "box-tests"})
public final class CustomerKppPrepareSteps {
    public static final ooo.jtc.api.dictionaries.customerkpp.CustomerKppPrepareSteps INSTANCE = null;
    
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0441\u043e\u0437\u0434\u0430\u043d\u043d\u044b\u0435 \u0430\u0432\u0442\u043e\u0442\u0435\u0441\u0442\u0430\u043c\u0438 \u0434\u0430\u043d\u043d\u044b\u0435 CustomerKpp \u0438\u0437 \u0411\u0414")
    public final void cleanAtCreated() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.customerkpp.CustomerKppDto getCustomerKppDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User customerRelatedUser) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.customerkpp.CustomerKppDto getCustomerKppDtoForCreate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.customerkpp.CustomerKppDto getCustomerKppDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.customerkpp.CustomerKppDto createdDto) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041a\u041f\u041f \u043a\u043b\u0438\u0435\u043d\u0442\u0430 \u0434\u043b\u044f \u043b\u044e\u0431\u043e\u0439 \u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u0438, \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u043e\u0439 {customerRelatedUser.login}")
    public final ooo.jtc.dictionaries.customerkpp.CustomerKppDto createCustomerKppDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User customerRelatedUser) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041a\u041f\u041f \u043a\u043b\u0438\u0435\u043d\u0442\u0430 \u0434\u043b\u044f \u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u0438 [{customerId}]")
    public final ooo.jtc.dictionaries.customerkpp.CustomerKppDto createCustomerKppDto(@org.jetbrains.annotations.NotNull()
    java.util.UUID customerId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.customerkpp.CustomerKppDto createCustomerKppDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.customerkpp.CustomerKppDto dtoForCreate) {
        return null;
    }
    
    private CustomerKppPrepareSteps() {
        super();
    }
}