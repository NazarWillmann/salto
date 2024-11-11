package ooo.jtc.api.common.templates.entity;

import java.lang.System;

/**
 * Test template for checking print-response file name.
 *
 * @param steps - document steps; will be used for calling print method
 * @param printFormat - format for printing documents
 * @param printParams - params for printing documents
 * @param preExecution - function for finding/creating documents for printing
 * @param getExpFileNameRegexFunc - function for computing expected file name RegEx
 * @param additionalFileNameChecks - additional checks for parsed file name from response
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003Bk\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000e\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012\u00a2\u0006\u0002\u0010\u0014R&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\u000eX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*\u00a8\u0006+"}, d2 = {"Looo/jtc/api/common/templates/entity/PrintMultipleDocsFileNamesTestTemplate;", "T", "Looo/jtc/interfaces/IDocument;", "Looo/jtc/api/common/tests/AbstractBeTest;", "", "", "steps", "Looo/jtc/api/common/steps/AbstractDocumentSteps;", "Looo/jtc/interfaces/UpdateIDocument;", "printFormat", "Looo/jtc/generic/print/PrintExportFormat;", "printParams", "Looo/jtc/generic/print/PrintParams;", "preExecution", "Lkotlin/Function0;", "getExpFileNameRegexFunc", "Lkotlin/text/Regex;", "additionalFileNameChecks", "Lkotlin/Function1;", "", "(Looo/jtc/api/common/steps/AbstractDocumentSteps;Looo/jtc/generic/print/PrintExportFormat;Looo/jtc/generic/print/PrintParams;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getAdditionalFileNameChecks", "()Lkotlin/jvm/functions/Function1;", "setAdditionalFileNameChecks", "(Lkotlin/jvm/functions/Function1;)V", "getGetExpFileNameRegexFunc", "()Lkotlin/jvm/functions/Function0;", "setGetExpFileNameRegexFunc", "(Lkotlin/jvm/functions/Function0;)V", "getPreExecution", "setPreExecution", "getPrintFormat", "()Looo/jtc/generic/print/PrintExportFormat;", "setPrintFormat", "(Looo/jtc/generic/print/PrintExportFormat;)V", "getPrintParams", "()Looo/jtc/generic/print/PrintParams;", "setPrintParams", "(Looo/jtc/generic/print/PrintParams;)V", "getSteps", "()Looo/jtc/api/common/steps/AbstractDocumentSteps;", "setSteps", "(Looo/jtc/api/common/steps/AbstractDocumentSteps;)V", "box-tests"})
public class PrintMultipleDocsFileNamesTestTemplate<T extends ooo.jtc.interfaces.IDocument> extends ooo.jtc.api.common.tests.AbstractBeTest<java.util.List<? extends T>, kotlin.Unit> {
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ? extends ooo.jtc.interfaces.UpdateIDocument<T>> steps;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.generic.print.PrintExportFormat printFormat;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.generic.print.PrintParams printParams;
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
    public final ooo.jtc.generic.print.PrintExportFormat getPrintFormat() {
        return null;
    }
    
    public final void setPrintFormat(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.generic.print.PrintParams getPrintParams() {
        return null;
    }
    
    public final void setPrintParams(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintParams p0) {
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
    
    public PrintMultipleDocsFileNamesTestTemplate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ? extends ooo.jtc.interfaces.UpdateIDocument<T>> steps, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat printFormat, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintParams printParams, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<? extends java.util.List<? extends T>> preExecution, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.text.Regex> getExpFileNameRegexFunc, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> additionalFileNameChecks) {
        super(null, null, null, null, null, null);
    }
}