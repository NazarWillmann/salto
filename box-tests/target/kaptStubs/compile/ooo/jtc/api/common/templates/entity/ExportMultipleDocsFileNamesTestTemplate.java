package ooo.jtc.api.common.templates.entity;

import java.lang.System;

/**
 * Test template for checking export-response file name.
 *
 * @param steps - document steps; will be used for calling export method
 * @param exportFormat - file format for exporting documents
 * @param preExecution - function for finding/creating documents for export
 * @param getExpFileNameRegexFunc - function for computing expected file name RegEx
 * @param additionalFileNameChecks - additional checks for parsed file name from response
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003Bc\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0014\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0010\u00a2\u0006\u0002\u0010\u0012R&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\fX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006%"}, d2 = {"Looo/jtc/api/common/templates/entity/ExportMultipleDocsFileNamesTestTemplate;", "T", "Looo/jtc/interfaces/IDocument;", "Looo/jtc/api/common/tests/AbstractBeTest;", "", "", "steps", "Looo/jtc/api/common/steps/AbstractDocumentSteps;", "Looo/jtc/interfaces/UpdateIDocument;", "exportFormat", "Looo/jtc/generic/print/PrintExportFormat;", "preExecution", "Lkotlin/Function0;", "getExpFileNameRegexFunc", "Lkotlin/text/Regex;", "additionalFileNameChecks", "Lkotlin/Function1;", "", "(Looo/jtc/api/common/steps/AbstractDocumentSteps;Looo/jtc/generic/print/PrintExportFormat;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getAdditionalFileNameChecks", "()Lkotlin/jvm/functions/Function1;", "setAdditionalFileNameChecks", "(Lkotlin/jvm/functions/Function1;)V", "getExportFormat", "()Looo/jtc/generic/print/PrintExportFormat;", "setExportFormat", "(Looo/jtc/generic/print/PrintExportFormat;)V", "getGetExpFileNameRegexFunc", "()Lkotlin/jvm/functions/Function0;", "setGetExpFileNameRegexFunc", "(Lkotlin/jvm/functions/Function0;)V", "getPreExecution", "setPreExecution", "getSteps", "()Looo/jtc/api/common/steps/AbstractDocumentSteps;", "setSteps", "(Looo/jtc/api/common/steps/AbstractDocumentSteps;)V", "box-tests"})
public class ExportMultipleDocsFileNamesTestTemplate<T extends ooo.jtc.interfaces.IDocument> extends ooo.jtc.api.common.tests.AbstractBeTest<java.util.List<? extends T>, kotlin.Unit> {
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ? extends ooo.jtc.interfaces.UpdateIDocument<T>> steps;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.generic.print.PrintExportFormat exportFormat;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<? extends java.util.List<? extends T>> preExecution;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<kotlin.text.Regex> getExpFileNameRegexFunc;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> additionalFileNameChecks;
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ? extends ooo.jtc.interfaces.UpdateIDocument<T>> getSteps() {
        return null;
    }
    
    public final void setSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ? extends ooo.jtc.interfaces.UpdateIDocument<T>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.generic.print.PrintExportFormat getExportFormat() {
        return null;
    }
    
    public final void setExportFormat(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public kotlin.jvm.functions.Function0<java.util.List<T>> getPreExecution() {
        return null;
    }
    
    public void setPreExecution(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<? extends java.util.List<? extends T>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.text.Regex> getGetExpFileNameRegexFunc() {
        return null;
    }
    
    public final void setGetExpFileNameRegexFunc(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.text.Regex> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getAdditionalFileNameChecks() {
        return null;
    }
    
    public final void setAdditionalFileNameChecks(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0) {
    }
    
    public ExportMultipleDocsFileNamesTestTemplate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ? extends ooo.jtc.interfaces.UpdateIDocument<T>> steps, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat exportFormat, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<? extends java.util.List<? extends T>> preExecution, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.text.Regex> getExpFileNameRegexFunc, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> additionalFileNameChecks) {
        super(null, null, null, null, null, null);
    }
}