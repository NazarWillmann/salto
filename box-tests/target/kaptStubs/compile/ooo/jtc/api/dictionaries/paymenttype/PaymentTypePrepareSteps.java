package ooo.jtc.api.dictionaries.paymenttype;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007J\u0012\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007J\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rR!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Looo/jtc/api/dictionaries/paymenttype/PaymentTypePrepareSteps;", "", "()V", "availablePaymentTypeCodes", "Ljava/util/concurrent/BlockingQueue;", "", "getAvailablePaymentTypeCodes", "()Ljava/util/concurrent/BlockingQueue;", "availablePaymentTypeCodes$delegate", "Lkotlin/Lazy;", "cleanAtCreated", "", "createPaymentTypeDto", "Looo/jtc/dictionaries/paymenttype/PaymentTypeDto;", "dtoForCreate", "getPaymentTypeDtoForCreate", "getPaymentTypeDtoForUpdate", "createdDto", "box-tests"})
public final class PaymentTypePrepareSteps {
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy availablePaymentTypeCodes$delegate = null;
    public static final ooo.jtc.api.dictionaries.paymenttype.PaymentTypePrepareSteps INSTANCE = null;
    
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0441\u043e\u0437\u0434\u0430\u043d\u043d\u044b\u0435 \u0430\u0432\u0442\u043e\u0442\u0435\u0441\u0442\u0430\u043c\u0438 \u0434\u0430\u043d\u043d\u044b\u0435 PaymentType \u0438\u0437 \u0411\u0414")
    public final void cleanAtCreated() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.concurrent.BlockingQueue<java.lang.String> getAvailablePaymentTypeCodes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.paymenttype.PaymentTypeDto getPaymentTypeDtoForCreate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.paymenttype.PaymentTypeDto getPaymentTypeDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.paymenttype.PaymentTypeDto createdDto) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0412\u0438\u0434 \u043f\u043b\u0430\u0442\u0435\u0436\u0430")
    public final ooo.jtc.dictionaries.paymenttype.PaymentTypeDto createPaymentTypeDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.paymenttype.PaymentTypeDto dtoForCreate) {
        return null;
    }
    
    private PaymentTypePrepareSteps() {
        super();
    }
}