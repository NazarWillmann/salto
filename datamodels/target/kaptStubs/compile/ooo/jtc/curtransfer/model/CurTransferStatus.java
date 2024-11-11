package ooo.jtc.curtransfer.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B+\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tR\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#\u00a8\u0006$"}, d2 = {"Looo/jtc/curtransfer/model/CurTransferStatus;", "", "Looo/jtc/documents/IDocumentStatus;", "Looo/jtc/curtransfer/dto/CurTransferDto;", "statusClient", "", "descriptionClient", "statusBank", "descriptionBank", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescriptionBank", "()Ljava/lang/String;", "getDescriptionClient", "getStatusBank", "getStatusClient", "DELETED", "IMPORTING", "IMPORT_ERROR", "DRAFT", "NEW", "PARTLY_SIGNED", "SIGNED", "DELIVERED", "FOR_RECEIVING", "RECEIVING_ERROR", "WRONG_E_SIGNATURE", "DETAILS_ERROR", "RECEIVED", "EXPORTING_TO_ABS", "EXPORTED_TO_ABS", "EXPORT_TO_ABS_ERROR", "ACCEPTED_TO_ABS", "NOT_ACCEPTED_TO_ABS", "REJECTED", "RECALLED", "EXECUTED", "datamodels"})
public enum CurTransferStatus implements ooo.jtc.documents.IDocumentStatus<ooo.jtc.curtransfer.dto.CurTransferDto> {
    /*public static final*/ DELETED /* = new DELETED(null, null, null, null) */,
    /*public static final*/ IMPORTING /* = new IMPORTING(null, null, null, null) */,
    /*public static final*/ IMPORT_ERROR /* = new IMPORT_ERROR(null, null, null, null) */,
    /*public static final*/ DRAFT /* = new DRAFT(null, null, null, null) */,
    /*public static final*/ NEW /* = new NEW(null, null, null, null) */,
    /*public static final*/ PARTLY_SIGNED /* = new PARTLY_SIGNED(null, null, null, null) */,
    /*public static final*/ SIGNED /* = new SIGNED(null, null, null, null) */,
    /*public static final*/ DELIVERED /* = new DELIVERED(null, null, null, null) */,
    /*public static final*/ FOR_RECEIVING /* = new FOR_RECEIVING(null, null, null, null) */,
    /*public static final*/ RECEIVING_ERROR /* = new RECEIVING_ERROR(null, null, null, null) */,
    /*public static final*/ WRONG_E_SIGNATURE /* = new WRONG_E_SIGNATURE(null, null, null, null) */,
    /*public static final*/ DETAILS_ERROR /* = new DETAILS_ERROR(null, null, null, null) */,
    /*public static final*/ RECEIVED /* = new RECEIVED(null, null, null, null) */,
    /*public static final*/ EXPORTING_TO_ABS /* = new EXPORTING_TO_ABS(null, null, null, null) */,
    /*public static final*/ EXPORTED_TO_ABS /* = new EXPORTED_TO_ABS(null, null, null, null) */,
    /*public static final*/ EXPORT_TO_ABS_ERROR /* = new EXPORT_TO_ABS_ERROR(null, null, null, null) */,
    /*public static final*/ ACCEPTED_TO_ABS /* = new ACCEPTED_TO_ABS(null, null, null, null) */,
    /*public static final*/ NOT_ACCEPTED_TO_ABS /* = new NOT_ACCEPTED_TO_ABS(null, null, null, null) */,
    /*public static final*/ REJECTED /* = new REJECTED(null, null, null, null) */,
    /*public static final*/ RECALLED /* = new RECALLED(null, null, null, null) */,
    /*public static final*/ EXECUTED /* = new EXECUTED(null, null, null, null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String statusClient = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String descriptionClient = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String statusBank = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String descriptionBank = null;
    
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
    
    CurTransferStatus(java.lang.String statusClient, java.lang.String descriptionClient, java.lang.String statusBank, java.lang.String descriptionBank) {
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
}