package ooo.jtc.ui.common.templates;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ak\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\f2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\fH\u0000\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"exportSingleDocCheck", "", "T", "Looo/jtc/interfaces/IDocument;", "entityName", "", "dto", "exportAvailableFormats", "", "Looo/jtc/generic/print/IPrintExportFormat;", "exportFormat", "getExpFileName", "Lkotlin/Function1;", "getExpFileContentFunc", "(Ljava/lang/String;Looo/jtc/interfaces/IDocument;Ljava/util/List;Looo/jtc/generic/print/IPrintExportFormat;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "box-tests"})
public final class UiExportTestTemplatesKt {
    
    /**
     * Общие действия для проверки экспорта одного документа.
     */
    public static final <T extends ooo.jtc.interfaces.IDocument>void exportSingleDocCheck(@org.jetbrains.annotations.NotNull()
    java.lang.String entityName, @org.jetbrains.annotations.NotNull()
    T dto, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends ooo.jtc.generic.print.IPrintExportFormat> exportAvailableFormats, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.IPrintExportFormat exportFormat, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, java.lang.String> getExpFileName, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ? extends java.util.List<java.lang.String>> getExpFileContentFunc) {
    }
}