package ooo.jtc.letters.model;

import java.lang.System;

/**
 * Letter to bank print formats.
 * 'desc' values are based on
 * https://confluence.jtc.ooo/pages/viewpage.action?pageId=21725845
 * https://confluence.jtc.ooo/pages/viewpage.action?pageId=21725847
 * https://confluence.jtc.ooo/pages/viewpage.action?pageId=21725850
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0012B\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0013"}, d2 = {"Looo/jtc/letters/model/LetterToBankPrintExportFormat;", "", "Looo/jtc/generic/print/IPrintExportFormat;", "format", "Looo/jtc/generic/print/PrintExportFormat;", "description", "", "(Ljava/lang/String;ILooo/jtc/generic/print/PrintExportFormat;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getFormat", "()Looo/jtc/generic/print/PrintExportFormat;", "HTML", "PDF", "RTF", "XLSX", "XML", "CSV", "Companion", "datamodels"})
public enum LetterToBankPrintExportFormat implements ooo.jtc.generic.print.IPrintExportFormat {
    /*public static final*/ HTML /* = new HTML(null, null) */,
    /*public static final*/ PDF /* = new PDF(null, null) */,
    /*public static final*/ RTF /* = new RTF(null, null) */,
    /*public static final*/ XLSX /* = new XLSX(null, null) */,
    /*public static final*/ XML /* = new XML(null, null) */,
    /*public static final*/ CSV /* = new CSV(null, null) */;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.generic.print.PrintExportFormat format = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<ooo.jtc.letters.model.LetterToBankPrintExportFormat> printFormats = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<ooo.jtc.letters.model.LetterToBankPrintExportFormat> printTableFormats = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<ooo.jtc.letters.model.LetterToBankPrintExportFormat> exportFormats = null;
    public static final ooo.jtc.letters.model.LetterToBankPrintExportFormat.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.generic.print.PrintExportFormat getFormat() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getDescription() {
        return null;
    }
    
    LetterToBankPrintExportFormat(ooo.jtc.generic.print.PrintExportFormat format, java.lang.String description) {
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007\u00a8\u0006\f"}, d2 = {"Looo/jtc/letters/model/LetterToBankPrintExportFormat$Companion;", "", "()V", "exportFormats", "", "Looo/jtc/letters/model/LetterToBankPrintExportFormat;", "getExportFormats", "()Ljava/util/List;", "printFormats", "getPrintFormats", "printTableFormats", "getPrintTableFormats", "datamodels"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<ooo.jtc.letters.model.LetterToBankPrintExportFormat> getPrintFormats() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<ooo.jtc.letters.model.LetterToBankPrintExportFormat> getPrintTableFormats() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<ooo.jtc.letters.model.LetterToBankPrintExportFormat> getExportFormats() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}