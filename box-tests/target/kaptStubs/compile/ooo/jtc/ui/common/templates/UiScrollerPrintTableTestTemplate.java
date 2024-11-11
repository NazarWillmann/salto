package ooo.jtc.ui.common.templates;

import java.lang.System;

/**
 * В предусловии необходимо убедиться, что в системе есть минимум 2 документа в нужном статусе (например Received) для одного клиента.
 * Передавать в тест из предусловия документы - очень нестабильно, т.к. порядок сортировки через API может отличатся от UI.
 * Поэтому мы выбираем 2 первых попавшихся документа на скроллере в этом статусе,
 * и для проверки содержимого получаем его для документов через API по ID'шникам выбранных документов.
 *
 * @param getExpTableContentFunc - принимает на вход [docCount] кол-во ID документов и возвращает список ожидаемых в реестре строк.
 * @param preExecution - возвращает customerId [UUID] для которого есть минимум 2 документа в нужном статусе.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u0000*&\b\u0000\u0010\u0001* \u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0002\b\u00030\u0002*\b\b\u0001\u0010\u0005*\u00020\u00062\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007B\u0095\u0001\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00028\u0000\u0012\b\u0010\u000f\u001a\u0004\u0018\u00018\u0001\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0016\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0016\u0012\u001e\u0010\u0019\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00140\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\u0002\u0010\u001eJ\u0012\u0010:\u001a\u00020\t2\b\u0010;\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020>0=H\u0016R\u0011\u0010\u001b\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010%R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R2\u0010\u0019\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00140\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0016X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\'R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0015\u0010\u000f\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0013\u0010\u000e\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0011\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010 R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Looo/jtc/ui/common/templates/UiScrollerPrintTableTestTemplate;", "S", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "Looo/jtc/core/elements/scroller/DocumentScroller;", "Looo/jtc/core/elements/scroller/DocumentScrollerRow;", "C", "Looo/jtc/core/elements/scroller/ScrollerCategory;", "Looo/jtc/api/common/tests/AbstractTest;", "Ljava/util/UUID;", "", "entityName", "", "user", "Looo/jtc/uaa/User;", "scrollerPage", "scrollerCategory", "searchStatus", "printFormat", "Looo/jtc/generic/print/IPrintExportFormat;", "printAvailableFormats", "", "preExecution", "Lkotlin/Function0;", "getExpFileName", "Lkotlin/text/Regex;", "getExpTableContentFunc", "Lkotlin/Function1;", "action", "docCount", "", "(Ljava/lang/String;Looo/jtc/uaa/User;Looo/jtc/ui/common/pages/DocumentScrollerPage;Looo/jtc/core/elements/scroller/ScrollerCategory;Ljava/lang/String;Looo/jtc/generic/print/IPrintExportFormat;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/lang/String;I)V", "getAction", "()Ljava/lang/String;", "getDocCount", "()I", "getEntityName", "setEntityName", "(Ljava/lang/String;)V", "getGetExpFileName", "()Lkotlin/jvm/functions/Function0;", "getGetExpTableContentFunc", "()Lkotlin/jvm/functions/Function1;", "setGetExpTableContentFunc", "(Lkotlin/jvm/functions/Function1;)V", "getPreExecution", "getPrintAvailableFormats", "()Ljava/util/List;", "getPrintFormat", "()Looo/jtc/generic/print/IPrintExportFormat;", "getScrollerCategory", "()Looo/jtc/core/elements/scroller/ScrollerCategory;", "Looo/jtc/core/elements/scroller/ScrollerCategory;", "getScrollerPage", "()Looo/jtc/ui/common/pages/DocumentScrollerPage;", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "getSearchStatus", "getUser", "()Looo/jtc/uaa/User;", "execution", "preconditionResult", "params", "", "", "box-tests"})
public class UiScrollerPrintTableTestTemplate<S extends ooo.jtc.ui.common.pages.DocumentScrollerPage<? extends ooo.jtc.core.elements.scroller.DocumentScroller<? extends ooo.jtc.core.elements.scroller.DocumentScrollerRow>, ?, C, ?>, C extends ooo.jtc.core.elements.scroller.ScrollerCategory> extends ooo.jtc.api.common.tests.AbstractTest<java.util.UUID, kotlin.Unit> {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String entityName;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.uaa.User user = null;
    @org.jetbrains.annotations.NotNull()
    private final S scrollerPage = null;
    @org.jetbrains.annotations.Nullable()
    private final C scrollerCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String searchStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.generic.print.IPrintExportFormat printFormat = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<ooo.jtc.generic.print.IPrintExportFormat> printAvailableFormats = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<java.util.UUID> preExecution = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<kotlin.text.Regex> getExpFileName = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super java.util.List<java.util.UUID>, ? extends java.util.List<java.lang.String>> getExpTableContentFunc;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String action = null;
    private final int docCount = 0;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.Map<java.lang.String, java.lang.Object> params() {
        return null;
    }
    
    @java.lang.Override()
    public void execution(@org.jetbrains.annotations.Nullable()
    java.util.UUID preconditionResult) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEntityName() {
        return null;
    }
    
    public final void setEntityName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.User getUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final S getScrollerPage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final C getScrollerCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSearchStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.generic.print.IPrintExportFormat getPrintFormat() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.generic.print.IPrintExportFormat> getPrintAvailableFormats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function0<java.util.UUID> getPreExecution() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<kotlin.text.Regex> getGetExpFileName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.util.List<java.util.UUID>, java.util.List<java.lang.String>> getGetExpTableContentFunc() {
        return null;
    }
    
    public final void setGetExpTableContentFunc(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<java.util.UUID>, ? extends java.util.List<java.lang.String>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAction() {
        return null;
    }
    
    public final int getDocCount() {
        return 0;
    }
    
    public UiScrollerPrintTableTestTemplate(@org.jetbrains.annotations.NotNull()
    java.lang.String entityName, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    S scrollerPage, @org.jetbrains.annotations.Nullable()
    C scrollerCategory, @org.jetbrains.annotations.NotNull()
    java.lang.String searchStatus, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.IPrintExportFormat printFormat, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends ooo.jtc.generic.print.IPrintExportFormat> printAvailableFormats, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.util.UUID> preExecution, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.text.Regex> getExpFileName, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<java.util.UUID>, ? extends java.util.List<java.lang.String>> getExpTableContentFunc, @org.jetbrains.annotations.NotNull()
    java.lang.String action, int docCount) {
        super(null, null, null, null);
    }
}