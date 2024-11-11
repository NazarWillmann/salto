package ooo.jtc.api.letters.tobank.steps;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0002J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0002J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J8\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\fJ8\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002J$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u00a8\u0006\u001d"}, d2 = {"Looo/jtc/api/letters/tobank/steps/LetterToBankPrepareExportSteps;", "", "()V", "exportDateConversion", "", "date", "Ljava/time/ZonedDateTime;", "getExportExpContentByFormat", "", "exportFormat", "Looo/jtc/generic/print/PrintExportFormat;", "docsToPrint", "Looo/jtc/letters/dto/LetterToBankDto;", "userType", "Looo/jtc/uaa/UserType;", "getRuHeaderValues", "getSysHeaderValues", "prepareDocFieldCsvExportValue", "fieldValue", "prepareExportCsvExpContent", "withRuHeader", "", "withSysHeader", "prepareExportFileNameRegexMultipleDocs", "Lkotlin/text/Regex;", "prepareExportFileNameSingleDoc", "docToPrint", "prepareExportXlsxExpContent", "prepareExportXmlExpContent", "box-tests"})
public final class LetterToBankPrepareExportSteps {
    public static final ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareExportSteps INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String prepareExportFileNameSingleDoc(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto docToPrint) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.text.Regex prepareExportFileNameRegexMultipleDocs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getExportExpContentByFormat(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat exportFormat, @org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.letters.dto.LetterToBankDto> docsToPrint, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.UserType userType) {
        return null;
    }
    
    /**
     * @param docsToPrint - letterFromBank DTO's to print
     * @param userType - user type of printing user (client/bank)
     * @param withRuHeader - boolean flag; column descriptions (localized field names) should be printed.
     *                     Always 'true' in Release 1
     * @param withSysHeader - boolean flag; column fields (system field names) should be printed.
     *                     Always 'false' in Release 1
     */
    private final java.util.List<java.lang.String> prepareExportCsvExpContent(java.util.List<ooo.jtc.letters.dto.LetterToBankDto> docsToPrint, ooo.jtc.uaa.UserType userType, boolean withRuHeader, boolean withSysHeader) {
        return null;
    }
    
    /**
     * @param docsToPrint - letterFromBank DTO's to print
     * @param userType - user type of printing user (client/bank)
     * @param withRuHeader - boolean flag; column descriptions (localized field names) should be printed.
     *                     Always 'true' in Release 1
     * @param withSysHeader - boolean flag; column fields (system field names) should be printed.
     *                     Always 'false' in Release 1
     */
    private final java.util.List<java.lang.String> prepareExportXlsxExpContent(java.util.List<ooo.jtc.letters.dto.LetterToBankDto> docsToPrint, ooo.jtc.uaa.UserType userType, boolean withRuHeader, boolean withSysHeader) {
        return null;
    }
    
    private final java.util.List<java.lang.String> prepareExportXmlExpContent(java.util.List<ooo.jtc.letters.dto.LetterToBankDto> docsToPrint, ooo.jtc.uaa.UserType userType) {
        return null;
    }
    
    private final java.lang.String exportDateConversion(java.time.ZonedDateTime date) {
        return null;
    }
    
    private final java.lang.String prepareDocFieldCsvExportValue(java.lang.String fieldValue) {
        return null;
    }
    
    private final java.util.List<java.lang.String> getRuHeaderValues() {
        return null;
    }
    
    private final java.util.List<java.lang.String> getSysHeaderValues() {
        return null;
    }
    
    private LetterToBankPrepareExportSteps() {
        super();
    }
}