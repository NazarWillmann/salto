package ooo.jtc.salary.dto;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B+\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tR\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2 = {"Looo/jtc/salary/dto/SalaryRegisterStatus;", "", "Looo/jtc/documents/IDocumentStatus;", "Looo/jtc/salary/dto/SalaryRegisterDto;", "statusClient", "", "descriptionClient", "statusBank", "descriptionBank", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescriptionBank", "()Ljava/lang/String;", "getDescriptionClient", "getStatusBank", "getStatusClient", "DELETED", "DRAFT", "NEW", "datamodels"})
public enum SalaryRegisterStatus implements ooo.jtc.documents.IDocumentStatus<ooo.jtc.salary.dto.SalaryRegisterDto> {
    /*public static final*/ DELETED /* = new DELETED(null, null, null, null) */,
    /*public static final*/ DRAFT /* = new DRAFT(null, null, null, null) */,
    /*public static final*/ NEW /* = new NEW(null, null, null, null) */;
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
    
    SalaryRegisterStatus(java.lang.String statusClient, java.lang.String descriptionClient, java.lang.String statusBank, java.lang.String descriptionBank) {
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