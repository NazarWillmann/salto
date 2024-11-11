package ooo.jtc.documents;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u0016*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003:\u0001\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0012\u0010\f\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0007\u00a8\u0006\u0017"}, d2 = {"Looo/jtc/documents/IDocumentStatus;", "T", "Looo/jtc/interfaces/IDocument;", "", "descriptionBank", "", "getDescriptionBank", "()Ljava/lang/String;", "descriptionClient", "getDescriptionClient", "statusBank", "getStatusBank", "statusClient", "getStatusClient", "asFilterData", "Looo/jtc/generic/pageparams/FilterData;", "user", "Looo/jtc/uaa/User;", "getDescription", "userType", "Looo/jtc/uaa/UserType;", "getUserStatus", "Companion", "datamodels"})
public abstract interface IDocumentStatus<T extends ooo.jtc.interfaces.IDocument> {
    public static final ooo.jtc.documents.IDocumentStatus.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOT_AVAILABLE = "-";
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getStatusClient();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getDescriptionClient();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getStatusBank();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getDescriptionBank();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getUserStatus(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.UserType userType);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getDescription(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.UserType userType);
    
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.generic.pageparams.FilterData asFilterData(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user);
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        public static <T extends ooo.jtc.interfaces.IDocument>java.lang.String getUserStatus(@org.jetbrains.annotations.NotNull()
        ooo.jtc.documents.IDocumentStatus<? extends T> $this, @org.jetbrains.annotations.NotNull()
        ooo.jtc.uaa.UserType userType) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static <T extends ooo.jtc.interfaces.IDocument>java.lang.String getDescription(@org.jetbrains.annotations.NotNull()
        ooo.jtc.documents.IDocumentStatus<? extends T> $this, @org.jetbrains.annotations.NotNull()
        ooo.jtc.uaa.UserType userType) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static <T extends ooo.jtc.interfaces.IDocument>ooo.jtc.generic.pageparams.FilterData asFilterData(@org.jetbrains.annotations.NotNull()
        ooo.jtc.documents.IDocumentStatus<? extends T> $this, @org.jetbrains.annotations.NotNull()
        ooo.jtc.uaa.User user) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Looo/jtc/documents/IDocumentStatus$Companion;", "", "()V", "NOT_AVAILABLE", "", "datamodels"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        public static final java.lang.String NOT_AVAILABLE = "-";
        
        private Companion() {
            super();
        }
    }
}