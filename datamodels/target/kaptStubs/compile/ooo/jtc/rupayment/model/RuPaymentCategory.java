package ooo.jtc.rupayment.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016\u00a8\u0006\u0018"}, d2 = {"Looo/jtc/rupayment/model/RuPaymentCategory;", "", "Looo/jtc/generic/Category;", "Looo/jtc/rupayment/dto/RuPaymentDto;", "category", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getStatuses", "", "Looo/jtc/rupayment/model/RuPaymentStatus;", "userType", "Looo/jtc/uaa/UserType;", "ALL", "DRAFT", "IMPORT_ERROR", "FOR_SIGNATURE", "FOR_SEND", "IN_PROCESSING", "COMPLETED", "PROBLEM_COMPLETED", "CARD_INDEX", "Companion", "datamodels"})
public enum RuPaymentCategory implements ooo.jtc.generic.Category<ooo.jtc.rupayment.dto.RuPaymentDto> {
    /*public static final*/ ALL /* = new ALL(null) */,
    /*public static final*/ DRAFT /* = new DRAFT(null) */,
    /*public static final*/ IMPORT_ERROR /* = new IMPORT_ERROR(null) */,
    /*public static final*/ FOR_SIGNATURE /* = new FOR_SIGNATURE(null) */,
    /*public static final*/ FOR_SEND /* = new FOR_SEND(null) */,
    /*public static final*/ IN_PROCESSING /* = new IN_PROCESSING(null) */,
    /*public static final*/ COMPLETED /* = new COMPLETED(null) */,
    /*public static final*/ PROBLEM_COMPLETED /* = new PROBLEM_COMPLETED(null) */,
    /*public static final*/ CARD_INDEX /* = new CARD_INDEX(null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String category = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Map<ooo.jtc.rupayment.model.RuPaymentCategory, java.util.List<ooo.jtc.rupayment.model.RuPaymentStatus>> clientCategoriesAndStatuses = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Map<ooo.jtc.rupayment.model.RuPaymentCategory, java.util.List<ooo.jtc.rupayment.model.RuPaymentStatus>> bankCategoriesAndStatuses = null;
    public static final ooo.jtc.rupayment.model.RuPaymentCategory.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<ooo.jtc.rupayment.model.RuPaymentStatus> getStatuses(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.UserType userType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getCategory() {
        return null;
    }
    
    RuPaymentCategory(java.lang.String category) {
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\f"}, d2 = {"Looo/jtc/rupayment/model/RuPaymentCategory$Companion;", "", "()V", "bankCategoriesAndStatuses", "", "Looo/jtc/rupayment/model/RuPaymentCategory;", "", "Looo/jtc/rupayment/model/RuPaymentStatus;", "getBankCategoriesAndStatuses", "()Ljava/util/Map;", "clientCategoriesAndStatuses", "getClientCategoriesAndStatuses", "datamodels"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<ooo.jtc.rupayment.model.RuPaymentCategory, java.util.List<ooo.jtc.rupayment.model.RuPaymentStatus>> getClientCategoriesAndStatuses() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<ooo.jtc.rupayment.model.RuPaymentCategory, java.util.List<ooo.jtc.rupayment.model.RuPaymentStatus>> getBankCategoriesAndStatuses() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}