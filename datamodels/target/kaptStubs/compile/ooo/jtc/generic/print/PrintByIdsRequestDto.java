package ooo.jtc.generic.print;

import java.lang.System;

/**
 * Print request: print document(s) by ids
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\nH\u00c6\u0003J7\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u00d6\u0003J\t\u0010%\u001a\u00020&H\u00d6\u0001J\t\u0010\'\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006("}, d2 = {"Looo/jtc/generic/print/PrintByIdsRequestDto;", "Looo/jtc/generic/print/PrintRequest;", "format", "Looo/jtc/generic/print/PrintExportFormat;", "locale", "", "ids", "", "Ljava/util/UUID;", "params", "Looo/jtc/generic/print/PrintParams;", "(Looo/jtc/generic/print/PrintExportFormat;Ljava/lang/String;Ljava/util/List;Looo/jtc/generic/print/PrintParams;)V", "getFormat", "()Looo/jtc/generic/print/PrintExportFormat;", "setFormat", "(Looo/jtc/generic/print/PrintExportFormat;)V", "getIds", "()Ljava/util/List;", "setIds", "(Ljava/util/List;)V", "getLocale", "()Ljava/lang/String;", "setLocale", "(Ljava/lang/String;)V", "getParams", "()Looo/jtc/generic/print/PrintParams;", "setParams", "(Looo/jtc/generic/print/PrintParams;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "datamodels"})
public final class PrintByIdsRequestDto implements ooo.jtc.generic.print.PrintRequest {
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.generic.print.PrintExportFormat format;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String locale;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.util.UUID> ids;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.generic.print.PrintParams params;
    
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
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.generic.print.PrintParams getParams() {
        return null;
    }
    
    public final void setParams(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintParams p0) {
    }
    
    public PrintByIdsRequestDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat format, @org.jetbrains.annotations.NotNull()
    java.lang.String locale, @org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> ids, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintParams params) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.generic.print.PrintParams component4() {
        return null;
    }
    
    /**
     * Print request: print document(s) by ids
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.generic.print.PrintByIdsRequestDto copy(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat format, @org.jetbrains.annotations.NotNull()
    java.lang.String locale, @org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> ids, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintParams params) {
        return null;
    }
    
    /**
     * Print request: print document(s) by ids
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Print request: print document(s) by ids
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Print request: print document(s) by ids
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}