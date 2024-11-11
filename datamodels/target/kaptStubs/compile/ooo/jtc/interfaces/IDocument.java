package ooo.jtc.interfaces;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u001a\"\u00020\u000fH\u0016\u00a2\u0006\u0002\u0010\u001bJ-\u0010\u0017\u001a\u00020\u00182\u001e\u0010\u0019\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00000\u001c0\u001a\"\b\u0012\u0004\u0012\u00020\u00000\u001cH\u0016\u00a2\u0006\u0002\u0010\u001dR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013\u00a8\u0006\u001e"}, d2 = {"Looo/jtc/interfaces/IDocument;", "Looo/jtc/interfaces/IEntityDto;", "customerId", "Ljava/util/UUID;", "getCustomerId", "()Ljava/util/UUID;", "setCustomerId", "(Ljava/util/UUID;)V", "documentDate", "Ljava/time/LocalDate;", "getDocumentDate", "()Ljava/time/LocalDate;", "setDocumentDate", "(Ljava/time/LocalDate;)V", "documentNumber", "", "getDocumentNumber", "()Ljava/lang/String;", "setDocumentNumber", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", "isInStatus", "", "statuses", "", "([Ljava/lang/String;)Z", "Looo/jtc/documents/IDocumentStatus;", "([Looo/jtc/documents/IDocumentStatus;)Z", "datamodels"})
public abstract interface IDocument extends ooo.jtc.interfaces.IEntityDto {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getDocumentNumber();
    
    public abstract void setDocumentNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.time.LocalDate getDocumentDate();
    
    public abstract void setDocumentDate(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.util.UUID getCustomerId();
    
    public abstract void setCustomerId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getStatus();
    
    public abstract void setStatus(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    public abstract boolean isInStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String... statuses);
    
    public abstract boolean isInStatus(@org.jetbrains.annotations.NotNull()
    ooo.jtc.documents.IDocumentStatus<? extends ooo.jtc.interfaces.IDocument>... statuses);
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        public static boolean isInStatus(@org.jetbrains.annotations.NotNull()
        ooo.jtc.interfaces.IDocument $this, @org.jetbrains.annotations.NotNull()
        java.lang.String... statuses) {
            return false;
        }
        
        public static boolean isInStatus(@org.jetbrains.annotations.NotNull()
        ooo.jtc.interfaces.IDocument $this, @org.jetbrains.annotations.NotNull()
        ooo.jtc.documents.IDocumentStatus<? extends ooo.jtc.interfaces.IDocument>... statuses) {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        @com.fasterxml.jackson.annotation.JsonIgnore()
        public static java.lang.String getEntityName(@org.jetbrains.annotations.NotNull()
        ooo.jtc.interfaces.IDocument $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        @com.fasterxml.jackson.annotation.JsonIgnore()
        public static ooo.jtc.interfaces.ITransferEntity toModel(@org.jetbrains.annotations.NotNull()
        ooo.jtc.interfaces.IDocument $this) {
            return null;
        }
    }
}