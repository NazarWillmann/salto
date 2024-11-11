package ooo.jtc.interfaces;

import java.lang.System;

/**
 * Entity's representation on user interface.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R\u0018\u0010\u0014\u001a\u00020\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u0018\u0010\u0017\u001a\u00020\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u0018\u0010\u001a\u001a\u00020\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\r\u00a8\u0006\u001d"}, d2 = {"Looo/jtc/interfaces/IDocumentView;", "Looo/jtc/interfaces/IEntityView;", "customerId", "Ljava/util/UUID;", "getCustomerId", "()Ljava/util/UUID;", "setCustomerId", "(Ljava/util/UUID;)V", "documentDate", "", "getDocumentDate", "()Ljava/lang/String;", "setDocumentDate", "(Ljava/lang/String;)V", "documentNumber", "getDocumentNumber", "setDocumentNumber", "id", "getId", "setId", "statusBank", "getStatusBank", "setStatusBank", "statusClient", "getStatusClient", "setStatusClient", "statusSystem", "getStatusSystem", "setStatusSystem", "datamodels"})
public abstract interface IDocumentView extends ooo.jtc.interfaces.IEntityView {
    
    /**
     * Entity ID
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.util.UUID getId();
    
    /**
     * Entity ID
     */
    public abstract void setId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0);
    
    /**
     * Customer ID
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.UUID getCustomerId();
    
    /**
     * Customer ID
     */
    public abstract void setCustomerId(@org.jetbrains.annotations.NotNull()
    java.util.UUID p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getDocumentNumber();
    
    public abstract void setDocumentNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getDocumentDate();
    
    public abstract void setDocumentDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
    
    /**
     * Document system status. `DeliveredToBank`
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getStatusSystem();
    
    /**
     * Document system status. `DeliveredToBank`
     */
    public abstract void setStatusSystem(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
    
    /**
     * Document UI client status. `Отправлен`
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getStatusClient();
    
    /**
     * Document UI client status. `Отправлен`
     */
    public abstract void setStatusClient(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
    
    /**
     * Document UI bank status. `Доставлен`
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getStatusBank();
    
    /**
     * Document UI bank status. `Доставлен`
     */
    public abstract void setStatusBank(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
}