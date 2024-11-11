package ooo.jtc.api.dictionaries.paymenttype;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J2\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u00a8\u0006\u0012"}, d2 = {"Looo/jtc/api/dictionaries/paymenttype/PaymentTypeSteps;", "Looo/jtc/api/common/steps/AbstractDictionarySteps;", "Looo/jtc/dictionaries/paymenttype/PaymentTypeDto;", "user", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)V", "deleteByCodeAndDescription", "", "code", "", "description", "withCheckResponseCode", "", "statusCode", "", "getByCodeAndDescription", "Looo/jtc/generic/GenericListResponseDto;", "getByDescription", "box-tests"})
public final class PaymentTypeSteps extends ooo.jtc.api.common.steps.AbstractDictionarySteps<ooo.jtc.dictionaries.paymenttype.PaymentTypeDto, ooo.jtc.dictionaries.paymenttype.PaymentTypeDto> {
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c {this.entityName} \u043f\u043e \u043a\u043e\u0434\u0443 ({code}) \u0438 \u043e\u043f\u0438\u0441\u0430\u043d\u0438\u044e ({description})")
    public final ooo.jtc.generic.GenericListResponseDto<ooo.jtc.dictionaries.paymenttype.PaymentTypeDto> getByCodeAndDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    java.lang.String description, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c {this.entityName} \u043f\u043e \u043a\u043e\u0434\u0443 ({code}) \u0438 \u043e\u043f\u0438\u0441\u0430\u043d\u0438\u044e ({description})")
    public final void deleteByCodeAndDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    java.lang.String description, boolean withCheckResponseCode, int statusCode) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c {this.entityName} \u043f\u043e \u043e\u043f\u0438\u0441\u0430\u043d\u0438\u044e ({description})")
    public final ooo.jtc.generic.GenericListResponseDto<ooo.jtc.dictionaries.paymenttype.PaymentTypeDto> getByDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String description, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    public PaymentTypeSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        super(null, null, null, null);
    }
}