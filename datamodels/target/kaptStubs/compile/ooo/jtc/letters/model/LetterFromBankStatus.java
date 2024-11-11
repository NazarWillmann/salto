package ooo.jtc.letters.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0016B+\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tR\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015\u00a8\u0006\u0017"}, d2 = {"Looo/jtc/letters/model/LetterFromBankStatus;", "", "Looo/jtc/documents/IDocumentStatus;", "Looo/jtc/letters/dto/LetterFromBankDto;", "statusClient", "", "descriptionClient", "statusBank", "descriptionBank", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescriptionBank", "()Ljava/lang/String;", "getDescriptionClient", "getStatusBank", "getStatusClient", "DELETED", "DRAFT", "NEW", "SIGNED", "DELIVERED", "WRONG_ESIGNATURE", "DETAILS_ERROR", "Companion", "datamodels"})
public enum LetterFromBankStatus implements ooo.jtc.documents.IDocumentStatus<ooo.jtc.letters.dto.LetterFromBankDto> {
    /*public static final*/ DELETED /* = new DELETED(null, null, null, null) */,
    /*public static final*/ DRAFT /* = new DRAFT(null, null, null, null) */,
    /*public static final*/ NEW /* = new NEW(null, null, null, null) */,
    /*public static final*/ SIGNED /* = new SIGNED(null, null, null, null) */,
    /*public static final*/ DELIVERED /* = new DELIVERED(null, null, null, null) */,
    /*public static final*/ WRONG_ESIGNATURE /* = new WRONG_ESIGNATURE(null, null, null, null) */,
    /*public static final*/ DETAILS_ERROR /* = new DETAILS_ERROR(null, null, null, null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String statusClient = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String descriptionClient = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String statusBank = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String descriptionBank = null;
    @org.jetbrains.annotations.NotNull()
    private static final ooo.jtc.letters.model.LetterFromBankStatus[] values = null;
    public static final ooo.jtc.letters.model.LetterFromBankStatus.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getStatusClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getDescriptionClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getStatusBank() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getDescriptionBank() {
        return null;
    }
    
    LetterFromBankStatus(java.lang.String statusClient, java.lang.String descriptionClient, java.lang.String statusBank, java.lang.String descriptionBank) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getUserStatus(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.UserType userType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getDescription(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.UserType userType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public ooo.jtc.generic.pageparams.FilterData asFilterData(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Looo/jtc/letters/model/LetterFromBankStatus$Companion;", "", "()V", "values", "", "Looo/jtc/letters/model/LetterFromBankStatus;", "getValues", "()[Looo/jtc/letters/model/LetterFromBankStatus;", "[Looo/jtc/letters/model/LetterFromBankStatus;", "datamodels"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.letters.model.LetterFromBankStatus[] getValues() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}