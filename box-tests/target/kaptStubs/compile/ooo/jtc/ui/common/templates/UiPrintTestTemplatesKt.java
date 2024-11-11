package ooo.jtc.ui.common.templates;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u009b\u0001\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\n2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\n26\u0010\r\u001a2\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\u000eH\u0000\u00a2\u0006\u0002\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"printSingleDocCheck", "", "T", "Looo/jtc/interfaces/IDocument;", "dto", "format", "Looo/jtc/generic/print/IPrintExportFormat;", "availableFormats", "", "getExpFileName", "Lkotlin/Function1;", "", "getExpFileContentFunc", "additionalChecks", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "actContent", "(Looo/jtc/interfaces/IDocument;Looo/jtc/generic/print/IPrintExportFormat;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "box-tests"})
public final class UiPrintTestTemplatesKt {
    
    /**
     * Общие действия для проверки ПФ одного документа.
     */
    public static final <T extends ooo.jtc.interfaces.IDocument>void printSingleDocCheck(@org.jetbrains.annotations.NotNull()
    T dto, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.IPrintExportFormat format, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends ooo.jtc.generic.print.IPrintExportFormat> availableFormats, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, java.lang.String> getExpFileName, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ? extends java.util.List<java.lang.String>> getExpFileContentFunc, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super T, ? super java.lang.String, kotlin.Unit> additionalChecks) {
    }
}