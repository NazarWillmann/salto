package ooo.jtc.api.common.checks;

import java.lang.System;

/**
 * Base asserts than can be applied for Document
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004Jg\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2:\b\u0002\u0010\f\u001a4\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0017\u00a2\u0006\u0002\u0010\u0012J#\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00028\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007\u00a2\u0006\u0002\u0010\u0015J$\u0010\u0016\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00170\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\nH\u0007J$\u0010\u001a\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00170\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\nH\u0007J\u0081\u0001\u0010\u001b\u001a\u00028\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00028\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2:\b\u0002\u0010\f\u001a4\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0007\u00a2\u0006\u0002\u0010!\u00a8\u0006\""}, d2 = {"Looo/jtc/api/common/checks/ApiDocumentChecks;", "D", "Looo/jtc/interfaces/IDocument;", "Looo/jtc/api/common/checks/ApiEntityChecks;", "()V", "checkDocumentLifecycleTransition", "", "expDocumentDto", "actResult", "expStatuses", "", "", "additionalHandling", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "preparedDto", "receivedDto", "(Looo/jtc/interfaces/IDocument;Looo/jtc/interfaces/IDocument;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "checkDocumentStatus", "document", "(Looo/jtc/interfaces/IDocument;Ljava/util/List;)V", "checkExportFormatResponse", "Looo/jtc/generic/print/PrintExportFormatDto;", "expFormats", "Looo/jtc/generic/print/IPrintExportFormat;", "checkPrintFormatResponse", "repeatableCheckDocumentLifecycleTransition", "getActResultFunc", "Lkotlin/Function0;", "repeatLimitSec", "", "repeatDelayMs", "(Lkotlin/jvm/functions/Function0;JJLooo/jtc/interfaces/IDocument;Ljava/util/List;Lkotlin/jvm/functions/Function2;)Looo/jtc/interfaces/IDocument;", "box-tests"})
public class ApiDocumentChecks<D extends ooo.jtc.interfaces.IDocument> extends ooo.jtc.api.common.checks.ApiEntityChecks<D> {
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u0441\u0442\u0430\u0442\u0443\u0441\u043d\u044b\u0439 \u043f\u0435\u0440\u0435\u0445\u043e\u0434 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \'{expDocumentDto.status} -> {expStatuses}\'")
    public void checkDocumentLifecycleTransition(@org.jetbrains.annotations.NotNull()
    D expDocumentDto, @org.jetbrains.annotations.NotNull()
    D actResult, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> expStatuses, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function2<? super D, ? super D, kotlin.Unit> additionalHandling) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u0441\u0442\u0430\u0442\u0443\u0441\u043d\u044b\u0439 \u043f\u0435\u0440\u0435\u0445\u043e\u0434 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \'{preparedDto.status} -> {expStatuses}\' \u0441 \u043f\u043e\u0432\u0442\u043e\u0440\u0435\u043d\u0438\u0435\u043c")
    public final D repeatableCheckDocumentLifecycleTransition(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends D> getActResultFunc, long repeatLimitSec, long repeatDelayMs, @org.jetbrains.annotations.NotNull()
    D preparedDto, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> expStatuses, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function2<? super D, ? super D, kotlin.Unit> additionalHandling) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 [{document.id}] \u043d\u0430\u0445\u043e\u0434\u0438\u0442\u0441\u044f \u0432 \u043e\u0434\u043d\u043e\u043c \u0438\u0437 \u0441\u0442\u0430\u0442\u0443\u0441\u043e\u0432 {expStatuses}")
    public final void checkDocumentStatus(@org.jetbrains.annotations.NotNull()
    D document, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> expStatuses) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043d\u0430\u0431\u043e\u0440 \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0445 \u0444\u043e\u0440\u043c\u0430\u0442\u043e\u0432 \u043f\u0435\u0447\u0430\u0442\u0438")
    public final void checkPrintFormatResponse(@org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.generic.print.PrintExportFormatDto> actResult, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends ooo.jtc.generic.print.IPrintExportFormat> expFormats) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043d\u0430\u0431\u043e\u0440 \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0445 \u0444\u043e\u0440\u043c\u0430\u0442\u043e\u0432 \u044d\u043a\u0441\u043f\u043e\u0440\u0442\u0430")
    public final void checkExportFormatResponse(@org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.generic.print.PrintExportFormatDto> actResult, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends ooo.jtc.generic.print.IPrintExportFormat> expFormats) {
    }
    
    public ApiDocumentChecks() {
        super();
    }
}