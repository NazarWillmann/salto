package ooo.jtc.ui.common.templates;

import java.lang.System;

/**
 * @param extraFiltration - дополнительная фильтрация документов на скроллере.
 * @param expDocListFunc - возвращает список ожидаемых view для проверки по ID выделенных строк на скроллере.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*&\b\u0001\u0010\u0003* \u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u0007\u0012\u0002\b\u00030\u0004*\b\b\u0002\u0010\u0007*\u00020\b*\u000e\b\u0003\u0010\t*\b\u0012\u0004\u0012\u0002H\u00010\n2\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bB\u00a0\u0001\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00028\u0001\u0012\u0006\u0010\u0013\u001a\u00028\u0002\u0012\u0006\u0010\u0014\u001a\u00028\u0003\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0016\u0012-\u0010\u0017\u001a)\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\u0019\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\u0018\u0012\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\r\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000f\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020\u000f\u00a2\u0006\u0002\u0010#J\u0012\u0010<\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010\fH\u0016J\u0014\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020@0?H\u0016R\u0011\u0010\"\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010 \u001a\u00020!\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0011\u0010\u001f\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010+R8\u0010\u0017\u001a)\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\u0019\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00190\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001f\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\r\u0018\u00010\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0013\u0010\u0014\u001a\u00028\u0003\u00a2\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0016X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0013\u001a\u00028\u0002\u00a2\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0013\u0010\u0012\u001a\u00028\u0001\u00a2\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010;\u00a8\u0006A"}, d2 = {"Looo/jtc/ui/common/templates/UiScrollerSignFormRequisitesTestTemplate;", "V", "Looo/jtc/interfaces/IDocumentView;", "S", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "Looo/jtc/core/elements/scroller/DocumentScroller;", "Looo/jtc/core/elements/scroller/DocumentScrollerRow;", "C", "Looo/jtc/core/elements/scroller/ScrollerCategory;", "M", "Looo/jtc/ui/common/sections/modals/ModalSignDocument;", "Looo/jtc/api/common/tests/AbstractTest;", "Ljava/util/UUID;", "", "entityName", "", "user", "Looo/jtc/uaa/User;", "scrollerPage", "scrollerCategory", "modalSignDocument", "preExecution", "Lkotlin/Function0;", "expDocListFunc", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "actDocIds", "extraFiltration", "Looo/jtc/core/elements/scroller/FilterForm;", "docCounterText", "docCount", "", "action", "(Ljava/lang/String;Looo/jtc/uaa/User;Looo/jtc/ui/common/pages/DocumentScrollerPage;Looo/jtc/core/elements/scroller/ScrollerCategory;Looo/jtc/ui/common/sections/modals/ModalSignDocument;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;ILjava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getDocCount", "()I", "getDocCounterText", "getEntityName", "setEntityName", "(Ljava/lang/String;)V", "getExpDocListFunc", "()Lkotlin/jvm/functions/Function1;", "getExtraFiltration", "getModalSignDocument", "()Looo/jtc/ui/common/sections/modals/ModalSignDocument;", "Looo/jtc/ui/common/sections/modals/ModalSignDocument;", "getPreExecution", "()Lkotlin/jvm/functions/Function0;", "getScrollerCategory", "()Looo/jtc/core/elements/scroller/ScrollerCategory;", "Looo/jtc/core/elements/scroller/ScrollerCategory;", "getScrollerPage", "()Looo/jtc/ui/common/pages/DocumentScrollerPage;", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "getUser", "()Looo/jtc/uaa/User;", "execution", "preconditionResult", "params", "", "", "box-tests"})
public class UiScrollerSignFormRequisitesTestTemplate<V extends ooo.jtc.interfaces.IDocumentView, S extends ooo.jtc.ui.common.pages.DocumentScrollerPage<? extends ooo.jtc.core.elements.scroller.DocumentScroller<? extends ooo.jtc.core.elements.scroller.DocumentScrollerRow>, ?, C, ?>, C extends ooo.jtc.core.elements.scroller.ScrollerCategory, M extends ooo.jtc.ui.common.sections.modals.ModalSignDocument<V>> extends ooo.jtc.api.common.tests.AbstractTest<java.util.UUID, kotlin.Unit> {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String entityName;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.uaa.User user = null;
    @org.jetbrains.annotations.NotNull()
    private final S scrollerPage = null;
    @org.jetbrains.annotations.NotNull()
    private final C scrollerCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final M modalSignDocument = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<java.util.UUID> preExecution = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.util.List<java.util.UUID>, java.util.List<V>> expDocListFunc = null;
    @org.jetbrains.annotations.Nullable()
    private final kotlin.jvm.functions.Function1<ooo.jtc.core.elements.scroller.FilterForm, kotlin.Unit> extraFiltration = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String docCounterText = null;
    private final int docCount = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String action = null;
    
    @java.lang.Override()
    public void execution(@org.jetbrains.annotations.Nullable()
    java.util.UUID preconditionResult) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.Map<java.lang.String, java.lang.Object> params() {
        return null;
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
    
    @org.jetbrains.annotations.NotNull()
    public final C getScrollerCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final M getModalSignDocument() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function0<java.util.UUID> getPreExecution() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.util.List<java.util.UUID>, java.util.List<V>> getExpDocListFunc() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<ooo.jtc.core.elements.scroller.FilterForm, kotlin.Unit> getExtraFiltration() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDocCounterText() {
        return null;
    }
    
    public final int getDocCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAction() {
        return null;
    }
    
    public UiScrollerSignFormRequisitesTestTemplate(@org.jetbrains.annotations.NotNull()
    java.lang.String entityName, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    S scrollerPage, @org.jetbrains.annotations.NotNull()
    C scrollerCategory, @org.jetbrains.annotations.NotNull()
    M modalSignDocument, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.util.UUID> preExecution, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<java.util.UUID>, ? extends java.util.List<? extends V>> expDocListFunc, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super ooo.jtc.core.elements.scroller.FilterForm, kotlin.Unit> extraFiltration, @org.jetbrains.annotations.NotNull()
    java.lang.String docCounterText, int docCount, @org.jetbrains.annotations.NotNull()
    java.lang.String action) {
        super(null, null, null, null);
    }
}