package ooo.jtc.api.dictionaries.customer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017J(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017\u00a8\u0006\u0011"}, d2 = {"Looo/jtc/api/dictionaries/customer/CustomerSteps;", "Looo/jtc/api/common/steps/AbstractDictionarySteps;", "Looo/jtc/dictionaries/customer/CustomerDto;", "user", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)V", "create", "Looo/jtc/generic/GenericResponseDto;", "entity", "withCheckResponseCode", "", "statusCode", "", "createWithoutBranchCustomer", "delete", "id", "Ljava/util/UUID;", "box-tests"})
public final class CustomerSteps extends ooo.jtc.api.common.steps.AbstractDictionarySteps<ooo.jtc.dictionaries.customer.CustomerDto, ooo.jtc.dictionaries.customer.CustomerDto> {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c {this.entityName}: \u0441\u043e \u0441\u0432\u044f\u0437\u0430\u043d\u043d\u044b\u043c \u043f\u043e\u0434\u0440\u0430\u0437\u0434\u0435\u043b\u0435\u043d\u0438\u0435\u043c BranchCustomer")
    public ooo.jtc.generic.GenericResponseDto<ooo.jtc.dictionaries.customer.CustomerDto> create(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.customer.CustomerDto entity, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \'{this.entityName}\' \u043f\u043e id={id} \u0441 \u043f\u0440\u043e\u0432\u0435\u0440\u043a\u043e\u0439 \u043f\u0440\u0435\u0434\u0441\u0442\u0430\u0432\u0438\u0442\u0435\u043b\u0435\u0439")
    public ooo.jtc.generic.GenericResponseDto<ooo.jtc.dictionaries.customer.CustomerDto> delete(@org.jetbrains.annotations.NotNull()
    java.util.UUID id, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.dictionaries.customer.CustomerDto> createWithoutBranchCustomer(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.customer.CustomerDto entity, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    public CustomerSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        super(null, null, null, null);
    }
}