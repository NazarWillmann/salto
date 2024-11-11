package ooo.jtc.ui.common.templates;

import java.lang.System;

/**
 * Проверка фильтрации.
 * В прекондишене необходимо получить документ для проверки фильтрации по значениям его полей.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*(\b\u0001\u0010\u0003*\"\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\b0\u0004*\b\b\u0002\u0010\t*\u00020\u0006*\b\b\u0003\u0010\u0007*\u00020\n*\b\b\u0004\u0010\u000b*\u00020\b2\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\r0\fBW\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00028\u0001\u0012\u0006\u0010\u0013\u001a\u00028\u0003\u0012\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00020\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\u0002\u0010\u001aJ\u0017\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010/J\u0014\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020201H\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR#\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0013\u001a\u00028\u0003\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b%\u0010&R\u0013\u0010\u0012\u001a\u00028\u0001\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,\u00a8\u00063"}, d2 = {"Looo/jtc/ui/common/templates/UiScrollerFiltrationTestTemplate;", "T", "Looo/jtc/interfaces/IDocument;", "S", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "Looo/jtc/core/elements/scroller/ExpandedScroller;", "Looo/jtc/core/elements/scroller/ExpandedScrollerRow;", "C", "Looo/jtc/core/elements/scroller/FilterForm;", "SR", "Looo/jtc/core/elements/scroller/ScrollerCategory;", "FF", "Looo/jtc/api/common/tests/AbstractTest;", "", "entityName", "", "user", "Looo/jtc/uaa/User;", "scrollerPage", "scrollerCategory", "filtrationParam", "Looo/jtc/ui/interfaces/UiFiltrationParam;", "preExecution", "Lkotlin/Function0;", "maxRowLimit", "", "(Ljava/lang/String;Looo/jtc/uaa/User;Looo/jtc/ui/common/pages/DocumentScrollerPage;Looo/jtc/core/elements/scroller/ScrollerCategory;Looo/jtc/ui/interfaces/UiFiltrationParam;Lkotlin/jvm/functions/Function0;I)V", "getEntityName", "()Ljava/lang/String;", "setEntityName", "(Ljava/lang/String;)V", "getFiltrationParam", "()Looo/jtc/ui/interfaces/UiFiltrationParam;", "getMaxRowLimit", "()I", "getPreExecution", "()Lkotlin/jvm/functions/Function0;", "getScrollerCategory", "()Looo/jtc/core/elements/scroller/ScrollerCategory;", "Looo/jtc/core/elements/scroller/ScrollerCategory;", "getScrollerPage", "()Looo/jtc/ui/common/pages/DocumentScrollerPage;", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "getUser", "()Looo/jtc/uaa/User;", "execution", "preconditionResult", "(Looo/jtc/interfaces/IDocument;)V", "params", "", "", "box-tests"})
public class UiScrollerFiltrationTestTemplate<T extends ooo.jtc.interfaces.IDocument, S extends ooo.jtc.ui.common.pages.DocumentScrollerPage<? extends ooo.jtc.core.elements.scroller.ExpandedScroller<? extends ooo.jtc.core.elements.scroller.ExpandedScrollerRow>, ?, C, ooo.jtc.core.elements.scroller.FilterForm>, SR extends ooo.jtc.core.elements.scroller.ExpandedScrollerRow, C extends ooo.jtc.core.elements.scroller.ScrollerCategory, FF extends ooo.jtc.core.elements.scroller.FilterForm> extends ooo.jtc.api.common.tests.AbstractTest<T, kotlin.Unit> {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String entityName;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.uaa.User user = null;
    @org.jetbrains.annotations.NotNull()
    private final S scrollerPage = null;
    @org.jetbrains.annotations.NotNull()
    private final C scrollerCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.ui.interfaces.UiFiltrationParam<T, FF, SR> filtrationParam = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<T> preExecution = null;
    private final int maxRowLimit = 0;
    
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @java.lang.Override()
    public void execution(@org.jetbrains.annotations.Nullable()
    T preconditionResult) {
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
    public final ooo.jtc.ui.interfaces.UiFiltrationParam<T, FF, SR> getFiltrationParam() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function0<T> getPreExecution() {
        return null;
    }
    
    public int getMaxRowLimit() {
        return 0;
    }
    
    public UiScrollerFiltrationTestTemplate(@org.jetbrains.annotations.NotNull()
    java.lang.String entityName, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    S scrollerPage, @org.jetbrains.annotations.NotNull()
    C scrollerCategory, @org.jetbrains.annotations.NotNull()
    ooo.jtc.ui.interfaces.UiFiltrationParam<T, FF, SR> filtrationParam, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends T> preExecution, int maxRowLimit) {
        super(null, null, null, null);
    }
}