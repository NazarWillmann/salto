package ooo.jtc.generic.print;

import java.lang.System;

/**
 * Print request: print list of document(s) by filter
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J\'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Looo/jtc/generic/print/PrintTableByFilterRequestDto;", "Looo/jtc/generic/print/PrintRequest;", "format", "Looo/jtc/generic/print/PrintExportFormat;", "locale", "", "filter", "Looo/jtc/generic/pageparams/Params;", "(Looo/jtc/generic/print/PrintExportFormat;Ljava/lang/String;Looo/jtc/generic/pageparams/Params;)V", "getFilter", "()Looo/jtc/generic/pageparams/Params;", "setFilter", "(Looo/jtc/generic/pageparams/Params;)V", "getFormat", "()Looo/jtc/generic/print/PrintExportFormat;", "setFormat", "(Looo/jtc/generic/print/PrintExportFormat;)V", "getLocale", "()Ljava/lang/String;", "setLocale", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "datamodels"})
public final class PrintTableByFilterRequestDto implements ooo.jtc.generic.print.PrintRequest {
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.generic.print.PrintExportFormat format;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String locale;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.generic.pageparams.Params filter;
    
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
    public final ooo.jtc.generic.pageparams.Params getFilter() {
        return null;
    }
    
    public final void setFilter(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.Params p0) {
    }
    
    public PrintTableByFilterRequestDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat format, @org.jetbrains.annotations.NotNull()
    java.lang.String locale, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.Params filter) {
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
    public final ooo.jtc.generic.pageparams.Params component3() {
        return null;
    }
    
    /**
     * Print request: print list of document(s) by filter
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.generic.print.PrintTableByFilterRequestDto copy(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat format, @org.jetbrains.annotations.NotNull()
    java.lang.String locale, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.Params filter) {
        return null;
    }
    
    /**
     * Print request: print list of document(s) by filter
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Print request: print list of document(s) by filter
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Print request: print list of document(s) by filter
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}