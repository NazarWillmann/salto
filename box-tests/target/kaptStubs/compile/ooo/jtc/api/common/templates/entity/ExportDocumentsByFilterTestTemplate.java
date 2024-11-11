package ooo.jtc.api.common.templates.entity;

import java.lang.System;

/**
 * Test template for exporting a number of documents in provided print format
 *
 * @param steps - document steps; will be used for calling export method
 * @param exportFormat - file format for exporting documents
 * @param preExecution - function for finding/creating documents for export
 * @param getExpFileContentFunc - function for computing expected file contents
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003Bq\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\u0010\u0012\u001e\u0010\u0011\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u0012\u00a2\u0006\u0002\u0010\u0013R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR2\u0010\u0011\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\u0010X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u0006,"}, d2 = {"Looo/jtc/api/common/templates/entity/ExportDocumentsByFilterTestTemplate;", "T", "Looo/jtc/interfaces/IDocument;", "Looo/jtc/api/common/tests/AbstractBeTest;", "", "", "nameDetails", "", "steps", "Looo/jtc/api/common/steps/AbstractDocumentSteps;", "Looo/jtc/interfaces/UpdateIDocument;", "filterParams", "Looo/jtc/generic/pageparams/Params;", "exportFormat", "Looo/jtc/generic/print/PrintExportFormat;", "preExecution", "Lkotlin/Function0;", "getExpFileContentFunc", "Lkotlin/Function1;", "(Ljava/lang/String;Looo/jtc/api/common/steps/AbstractDocumentSteps;Looo/jtc/generic/pageparams/Params;Looo/jtc/generic/print/PrintExportFormat;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getExportFormat", "()Looo/jtc/generic/print/PrintExportFormat;", "setExportFormat", "(Looo/jtc/generic/print/PrintExportFormat;)V", "getFilterParams", "()Looo/jtc/generic/pageparams/Params;", "setFilterParams", "(Looo/jtc/generic/pageparams/Params;)V", "getGetExpFileContentFunc", "()Lkotlin/jvm/functions/Function1;", "setGetExpFileContentFunc", "(Lkotlin/jvm/functions/Function1;)V", "getNameDetails", "()Ljava/lang/String;", "setNameDetails", "(Ljava/lang/String;)V", "getPreExecution", "()Lkotlin/jvm/functions/Function0;", "setPreExecution", "(Lkotlin/jvm/functions/Function0;)V", "getSteps", "()Looo/jtc/api/common/steps/AbstractDocumentSteps;", "setSteps", "(Looo/jtc/api/common/steps/AbstractDocumentSteps;)V", "box-tests"})
public class ExportDocumentsByFilterTestTemplate<T extends ooo.jtc.interfaces.IDocument> extends ooo.jtc.api.common.tests.AbstractBeTest<java.util.List<? extends T>, kotlin.Unit> {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String nameDetails;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ? extends ooo.jtc.interfaces.UpdateIDocument<T>> steps;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.generic.pageparams.Params filterParams;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.generic.print.PrintExportFormat exportFormat;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<? extends java.util.List<? extends T>> preExecution;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.util.List<? extends T>, ? extends java.util.List<java.lang.String>> getExpFileContentFunc;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNameDetails() {
        return null;
    }
    
    public final void setNameDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ? extends ooo.jtc.interfaces.UpdateIDocument<T>> getSteps() {
        return null;
    }
    
    public final void setSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ? extends ooo.jtc.interfaces.UpdateIDocument<T>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.generic.pageparams.Params getFilterParams() {
        return null;
    }
    
    public final void setFilterParams(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.Params p0) {
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
    public final kotlin.jvm.functions.Function1<java.util.List<? extends T>, java.util.List<java.lang.String>> getGetExpFileContentFunc() {
        return null;
    }
    
    public final void setGetExpFileContentFunc(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends T>, ? extends java.util.List<java.lang.String>> p0) {
    }
    
    public ExportDocumentsByFilterTestTemplate(@org.jetbrains.annotations.NotNull()
    java.lang.String nameDetails, @org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ? extends ooo.jtc.interfaces.UpdateIDocument<T>> steps, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.Params filterParams, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat exportFormat, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<? extends java.util.List<? extends T>> preExecution, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends T>, ? extends java.util.List<java.lang.String>> getExpFileContentFunc) {
        super(null, null, null, null, null, null);
    }
}