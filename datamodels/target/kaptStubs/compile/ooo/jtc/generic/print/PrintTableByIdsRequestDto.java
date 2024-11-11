package ooo.jtc.generic.print;

import java.lang.System;

/**
 * Print request: print list of document(s) by ids
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J-\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006!"}, d2 = {"Looo/jtc/generic/print/PrintTableByIdsRequestDto;", "Looo/jtc/generic/print/PrintRequest;", "format", "Looo/jtc/generic/print/PrintExportFormat;", "locale", "", "ids", "", "Ljava/util/UUID;", "(Looo/jtc/generic/print/PrintExportFormat;Ljava/lang/String;Ljava/util/List;)V", "getFormat", "()Looo/jtc/generic/print/PrintExportFormat;", "setFormat", "(Looo/jtc/generic/print/PrintExportFormat;)V", "getIds", "()Ljava/util/List;", "setIds", "(Ljava/util/List;)V", "getLocale", "()Ljava/lang/String;", "setLocale", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "datamodels"})
public final class PrintTableByIdsRequestDto implements ooo.jtc.generic.print.PrintRequest {
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.generic.print.PrintExportFormat format;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String locale;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.util.UUID> ids;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.generic.print.PrintExportFormat getFormat() {
        return null;
    }
    
    @java.lang.Override()
    public void setFormat(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getLocale() {
        return null;
    }
    
    @java.lang.Override()
    public void setLocale(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.UUID> getIds() {
        return null;
    }
    
    public final void setIds(@org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> p0) {
    }
    
    public PrintTableByIdsRequestDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat format, @org.jetbrains.annotations.NotNull()
    java.lang.String locale, @org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> ids) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.generic.print.PrintExportFormat component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.UUID> component3() {
        return null;
    }
    
    /**
     * Print request: print list of document(s) by ids
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.generic.print.PrintTableByIdsRequestDto copy(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat format, @org.jetbrains.annotations.NotNull()
    java.lang.String locale, @org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> ids) {
        return null;
    }
    
    /**
     * Print request: print list of document(s) by ids
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Print request: print list of document(s) by ids
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Print request: print list of document(s) by ids
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}