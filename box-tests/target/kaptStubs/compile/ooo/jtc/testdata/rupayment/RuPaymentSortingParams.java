package ooo.jtc.testdata.rupayment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0017\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u00a2\u0006\u0002\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e\u00a8\u0006\u001f"}, d2 = {"Looo/jtc/testdata/rupayment/RuPaymentSortingParams;", "", "Looo/jtc/api/common/sorting/ISortingParams;", "Looo/jtc/rupayment/dto/RuPaymentDto;", "field", "", "fieldDataProvider", "Lkotlin/Function1;", "", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getField", "()Ljava/lang/String;", "setField", "(Ljava/lang/String;)V", "getFieldDataProvider", "()Lkotlin/jvm/functions/Function1;", "setFieldDataProvider", "(Lkotlin/jvm/functions/Function1;)V", "DOCUMENT_NUMBER", "DOCUMENT_DATE", "CUSTOMER_ID", "BRANCH_ID", "STATUS", "IS_FAVORITES", "AMOUNT", "PAYMENT_GROUND_DESCRIPTION", "RECEIVER_NAME", "RECEIVER_INN", "RECEIVER_ACCOUNT", "RECEIVER_BANK_NAME", "RECEIVER_BANK_BIC", "box-tests"})
public enum RuPaymentSortingParams implements ooo.jtc.api.common.sorting.ISortingParams<ooo.jtc.rupayment.dto.RuPaymentDto> {
    /*public static final*/ DOCUMENT_NUMBER /* = new DOCUMENT_NUMBER(null, null) */,
    /*public static final*/ DOCUMENT_DATE /* = new DOCUMENT_DATE(null, null) */,
    /*public static final*/ CUSTOMER_ID /* = new CUSTOMER_ID(null, null) */,
    /*public static final*/ BRANCH_ID /* = new BRANCH_ID(null, null) */,
    /*public static final*/ STATUS /* = new STATUS(null, null) */,
    /*public static final*/ IS_FAVORITES /* = new IS_FAVORITES(null, null) */,
    /*public static final*/ AMOUNT /* = new AMOUNT(null, null) */,
    /*public static final*/ PAYMENT_GROUND_DESCRIPTION /* = new PAYMENT_GROUND_DESCRIPTION(null, null) */,
    /*public static final*/ RECEIVER_NAME /* = new RECEIVER_NAME(null, null) */,
    /*public static final*/ RECEIVER_INN /* = new RECEIVER_INN(null, null) */,
    /*public static final*/ RECEIVER_ACCOUNT /* = new RECEIVER_ACCOUNT(null, null) */,
    /*public static final*/ RECEIVER_BANK_NAME /* = new RECEIVER_BANK_NAME(null, null) */,
    /*public static final*/ RECEIVER_BANK_BIC /* = new RECEIVER_BANK_BIC(null, null) */;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String field;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super ooo.jtc.rupayment.dto.RuPaymentDto, ? extends java.lang.Object> fieldDataProvider;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getField() {
        return null;
    }
    
    @java.lang.Override()
    public void setField(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<ooo.jtc.rupayment.dto.RuPaymentDto, java.lang.Object> getFieldDataProvider() {
        return null;
    }
    
    @java.lang.Override()
    public void setFieldDataProvider(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.rupayment.dto.RuPaymentDto, ? extends java.lang.Object> p0) {
    }
    
    RuPaymentSortingParams(java.lang.String field, kotlin.jvm.functions.Function1<? super ooo.jtc.rupayment.dto.RuPaymentDto, ? extends java.lang.Object> fieldDataProvider) {
    }
    
    /**
     * Set sorting asc
     */
    @org.jetbrains.annotations.NotNull()
    public java.util.List<ooo.jtc.generic.pageparams.Sort> asc() {
        return null;
    }
    
    /**
     * Set sorting desc
     */
    @org.jetbrains.annotations.NotNull()
    public java.util.List<ooo.jtc.generic.pageparams.Sort> desc() {
        return null;
    }
}