package ooo.jtc.api.rupayment.prepare;

import java.lang.System;

/**
 * NOTES:
 * 1) values are based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=12919992
 * 2) all values have "_AT" in field 'description', so that 'paymentGround' could be used to find AT-created RuPayments
 * 3) 'CheckPaymentGroundNDS' control (https://confluence.jtc.ooo/pages/viewpage.action?pageId=4336938)
 *   checks 'description' for "НДС" / "налогнадобавленнуюстоимость"(ignoring spaces and case), if RuPayment considered
 *   non-budget. Thus - "НДС" in almost every PaymentGround
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B3\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2 = {"Looo/jtc/api/rupayment/prepare/PaymentGrounds;", "", "description", "", "nds", "Ljava/math/BigDecimal;", "ndsCalculation", "", "ndsPercent", "(Ljava/lang/String;ILjava/lang/String;Ljava/math/BigDecimal;Ljava/lang/Integer;Ljava/lang/String;)V", "Ljava/lang/Integer;", "getDto", "Looo/jtc/rupayment/dto/PaymentGroundDto;", "payerAccNum", "receiverAccNum", "operationCode", "NDS_INCLUDED_PAYMENT_GROUND", "NO_NDS_PAYMENT_GROUND", "NO_NDS_CALC_PAYMENT_GROUND", "box-tests"})
public enum PaymentGrounds {
    /*public static final*/ NDS_INCLUDED_PAYMENT_GROUND /* = new NDS_INCLUDED_PAYMENT_GROUND(null, null, null, null) */,
    /*public static final*/ NO_NDS_PAYMENT_GROUND /* = new NO_NDS_PAYMENT_GROUND(null, null, null, null) */,
    /*public static final*/ NO_NDS_CALC_PAYMENT_GROUND /* = new NO_NDS_CALC_PAYMENT_GROUND(null, null, null, null) */;
    private final java.lang.String description = null;
    private final java.math.BigDecimal nds = null;
    private final java.lang.Integer ndsCalculation = null;
    private final java.lang.String ndsPercent = null;
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.rupayment.dto.PaymentGroundDto getDto(@org.jetbrains.annotations.Nullable()
    java.lang.String operationCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.rupayment.dto.PaymentGroundDto getDto(@org.jetbrains.annotations.NotNull()
    java.lang.String payerAccNum, @org.jetbrains.annotations.NotNull()
    java.lang.String receiverAccNum) {
        return null;
    }
    
    PaymentGrounds(java.lang.String description, java.math.BigDecimal nds, java.lang.Integer ndsCalculation, java.lang.String ndsPercent) {
    }
}