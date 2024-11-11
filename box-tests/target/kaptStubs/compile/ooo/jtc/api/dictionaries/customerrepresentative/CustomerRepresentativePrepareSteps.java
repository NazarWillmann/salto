package ooo.jtc.api.dictionaries.customerrepresentative;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0007J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006J\u001a\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00162\u0006\u0010\u000b\u001a\u00020\nH\u0007\u00a8\u0006\u0017"}, d2 = {"Looo/jtc/api/dictionaries/customerrepresentative/CustomerRepresentativePrepareSteps;", "", "()V", "cleanAtCreated", "", "createBlockedCustomerRepresentativeDto", "Looo/jtc/dictionaries/customerrepresentative/CustomerRepresentativeDto;", "crDtoForCreateAndBlock", "createCustomerRepresentative", "uaaUserId", "Ljava/util/UUID;", "customerId", "crDtoForCreate", "getCustomerRepresentativeDtoForCreate", "forUi", "", "bankUser", "Looo/jtc/uaa/User;", "customerUser", "getCustomerRepresentativeDtoForUpdate", "createdDto", "getCustomerRepresentativeIds", "", "box-tests"})
public final class CustomerRepresentativePrepareSteps {
    public static final ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativePrepareSteps INSTANCE = null;
    
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0441\u043e\u0437\u0434\u0430\u043d\u043d\u044b\u0435 \u0430\u0432\u0442\u043e\u0442\u0435\u0441\u0442\u0430\u043c\u0438 \u0434\u0430\u043d\u043d\u044b\u0435 CustomerRepresentative \u0438\u0437 \u0411\u0414")
    public final void cleanAtCreated() {
    }
    
    /**
     * Prepare CustomerRepresentativeDto
     * [bankUser] - user that will be creating prepared DTO.
     * CustomerRepresentative will be created for a random Customer, available to [bankUser].
     * [customerUser] - client user that will be used as a 'new' representative for [bankUser]'s Customer
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto getCustomerRepresentativeDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User bankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User customerUser) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto getCustomerRepresentativeDtoForCreate(@org.jetbrains.annotations.NotNull()
    java.util.UUID uaaUserId, @org.jetbrains.annotations.NotNull()
    java.util.UUID customerId, boolean forUi) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto getCustomerRepresentativeDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto createdDto) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto createCustomerRepresentative(@org.jetbrains.annotations.NotNull()
    java.util.UUID uaaUserId, @org.jetbrains.annotations.NotNull()
    java.util.UUID customerId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \'\u041f\u0440\u0435\u0434\u0441\u0442\u0430\u0432\u0438\u0442\u0435\u043b\u044c \u041a\u043b\u0438\u0435\u043d\u0442\u0430 \u042e\u041b\'")
    public final ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto createCustomerRepresentative(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto crDtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0437\u0430\u0431\u043b\u043e\u043a\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u044b\u0439 \'\u041f\u0440\u0435\u0434\u0441\u0442\u0430\u0432\u0438\u0442\u0435\u043b\u044c \u041a\u043b\u0438\u0435\u043d\u0442\u0430 \u042e\u041b\'")
    public final ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto createBlockedCustomerRepresentativeDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto crDtoForCreateAndBlock) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 id \u0437\u0430\u043f\u0438\u0441\u0435\u0439 \u0441\u0432\u044f\u0437\u0435\u0439 \u041f\u0440\u0435\u0434\u0441\u0442\u0430\u0432\u0438\u0442\u0435\u043b\u0435\u0439 \u041a\u043b\u0438\u0435\u043d\u0442\u0430 \'{customerId}\'")
    public final java.util.List<java.util.UUID> getCustomerRepresentativeIds(@org.jetbrains.annotations.NotNull()
    java.util.UUID customerId) {
        return null;
    }
    
    private CustomerRepresentativePrepareSteps() {
        super();
    }
}