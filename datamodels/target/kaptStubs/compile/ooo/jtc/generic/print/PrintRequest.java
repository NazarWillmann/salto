package ooo.jtc.generic.print;

import java.lang.System;

/**
 * Document(s) print request general fields
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Looo/jtc/generic/print/PrintRequest;", "", "format", "Looo/jtc/generic/print/PrintExportFormat;", "getFormat", "()Looo/jtc/generic/print/PrintExportFormat;", "setFormat", "(Looo/jtc/generic/print/PrintExportFormat;)V", "locale", "", "getLocale", "()Ljava/lang/String;", "setLocale", "(Ljava/lang/String;)V", "datamodels"})
public abstract interface PrintRequest {
    
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.generic.print.PrintExportFormat getFormat();
    
    public abstract void setFormat(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getLocale();
    
    public abstract void setLocale(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
}