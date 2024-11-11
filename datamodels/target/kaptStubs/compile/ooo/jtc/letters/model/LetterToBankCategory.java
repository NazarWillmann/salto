package ooo.jtc.letters.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0018B\u000f\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017\u00a8\u0006\u0019"}, d2 = {"Looo/jtc/letters/model/LetterToBankCategory;", "", "Looo/jtc/generic/Category;", "Looo/jtc/letters/dto/LetterToBankDto;", "category", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getStatuses", "", "Looo/jtc/letters/model/LetterToBankStatus;", "userType", "Looo/jtc/uaa/UserType;", "ALL", "PROBLEM_COMPLETED", "PROBLEMATIC", "COMPLETED", "DRAFT", "FOR_SEND", "FOR_SIGNATURE", "IN_PROCESSING", "ON_RECEIVE", "RECEIVED", "Companion", "datamodels"})
public enum LetterToBankCategory implements ooo.jtc.generic.Category<ooo.jtc.letters.dto.LetterToBankDto> {
    /*public static final*/ ALL /* = new ALL(null) */,
    /*public static final*/ PROBLEM_COMPLETED /* = new PROBLEM_COMPLETED(null) */,
    /*public static final*/ PROBLEMATIC /* = new PROBLEMATIC(null) */,
    /*public static final*/ COMPLETED /* = new COMPLETED(null) */,
    /*public static final*/ DRAFT /* = new DRAFT(null) */,
    /*public static final*/ FOR_SEND /* = new FOR_SEND(null) */,
    /*public static final*/ FOR_SIGNATURE /* = new FOR_SIGNATURE(null) */,
    /*public static final*/ IN_PROCESSING /* = new IN_PROCESSING(null) */,
    /*public static final*/ ON_RECEIVE /* = new ON_RECEIVE(null) */,
    /*public static final*/ RECEIVED /* = new RECEIVED(null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String category = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Map<ooo.jtc.letters.model.LetterToBankCategory, java.util.List<ooo.jtc.letters.model.LetterToBankStatus>> clientCategoriesAndStatuses = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Map<ooo.jtc.letters.model.LetterToBankCategory, java.util.List<ooo.jtc.letters.model.LetterToBankStatus>> bankCategoriesAndStatuses = null;
    public static final ooo.jtc.letters.model.LetterToBankCategory.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<ooo.jtc.letters.model.LetterToBankStatus> getStatuses(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.UserType userType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getCategory() {
        return null;
    }
    
    LetterToBankCategory(java.lang.String category) {
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\f"}, d2 = {"Looo/jtc/letters/model/LetterToBankCategory$Companion;", "", "()V", "bankCategoriesAndStatuses", "", "Looo/jtc/letters/model/LetterToBankCategory;", "", "Looo/jtc/letters/model/LetterToBankStatus;", "getBankCategoriesAndStatuses", "()Ljava/util/Map;", "clientCategoriesAndStatuses", "getClientCategoriesAndStatuses", "datamodels"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<ooo.jtc.letters.model.LetterToBankCategory, java.util.List<ooo.jtc.letters.model.LetterToBankStatus>> getClientCategoriesAndStatuses() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<ooo.jtc.letters.model.LetterToBankCategory, java.util.List<ooo.jtc.letters.model.LetterToBankStatus>> getBankCategoriesAndStatuses() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}