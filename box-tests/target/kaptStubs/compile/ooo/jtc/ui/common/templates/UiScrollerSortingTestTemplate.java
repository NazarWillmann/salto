package ooo.jtc.ui.common.templates;

import java.lang.System;

/**
 * Проверка сортировки.
 * В прекондишене необходимо проверить, что в системе существует минимум 3 документа для проверки сортировки.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u0000*&\b\u0000\u0010\u0001* \u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0002\b\u00030\u0002*\b\b\u0001\u0010\u0005*\u00020\u0006*\b\b\u0002\u0010\u0007*\u00020\b2\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tBG\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00028\u0000\u0012\b\u0010\u0011\u001a\u0004\u0018\u00018\u0001\u0012\u0006\u0010\u0012\u001a\u00028\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\u0002\u0010\u0017J\u0012\u0010+\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020/0.H\u0016R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0011\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010\u0010\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0013\u0010\u0012\u001a\u00028\u0002\u00a2\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010\'R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Looo/jtc/ui/common/templates/UiScrollerSortingTestTemplate;", "S", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "Looo/jtc/core/elements/scroller/ExpandedScroller;", "Looo/jtc/core/elements/scroller/ExpandedScrollerRow;", "C", "Looo/jtc/core/elements/scroller/ScrollerCategory;", "SP", "Looo/jtc/ui/interfaces/UiSortingParam;", "Looo/jtc/api/common/tests/AbstractTest;", "Ljava/util/UUID;", "", "entityName", "", "user", "Looo/jtc/uaa/User;", "scrollerPage", "scrollerCategory", "sortingParam", "preExecution", "Lkotlin/Function0;", "maxRowLimit", "", "(Ljava/lang/String;Looo/jtc/uaa/User;Looo/jtc/ui/common/pages/DocumentScrollerPage;Looo/jtc/core/elements/scroller/ScrollerCategory;Looo/jtc/ui/interfaces/UiSortingParam;Lkotlin/jvm/functions/Function0;I)V", "getEntityName", "()Ljava/lang/String;", "setEntityName", "(Ljava/lang/String;)V", "getMaxRowLimit", "()I", "getPreExecution", "()Lkotlin/jvm/functions/Function0;", "getScrollerCategory", "()Looo/jtc/core/elements/scroller/ScrollerCategory;", "Looo/jtc/core/elements/scroller/ScrollerCategory;", "getScrollerPage", "()Looo/jtc/ui/common/pages/DocumentScrollerPage;", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "getSortingParam", "()Looo/jtc/ui/interfaces/UiSortingParam;", "Looo/jtc/ui/interfaces/UiSortingParam;", "getUser", "()Looo/jtc/uaa/User;", "execution", "preconditionResult", "params", "", "", "box-tests"})
public class UiScrollerSortingTestTemplate<S extends ooo.jtc.ui.common.pages.DocumentScrollerPage<? extends ooo.jtc.core.elements.scroller.ExpandedScroller<? extends ooo.jtc.core.elements.scroller.ExpandedScrollerRow>, ?, C, ?>, C extends ooo.jtc.core.elements.scroller.ScrollerCategory, SP extends ooo.jtc.ui.interfaces.UiSortingParam> extends ooo.jtc.api.common.tests.AbstractTest<java.util.UUID, kotlin.Unit> {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String entityName;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.uaa.User user = null;
    @org.jetbrains.annotations.NotNull()
    private final S scrollerPage = null;
    @org.jetbrains.annotations.Nullable()
    private final C scrollerCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final SP sortingParam = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<java.util.UUID> preExecution = null;
    private final int maxRowLimit = 0;
    
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
    
    @org.jetbrains.annotations.Nullable()
    public final C getScrollerCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final SP getSortingParam() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function0<java.util.UUID> getPreExecution() {
        return null;
    }
    
    public int getMaxRowLimit() {
        return 0;
    }
    
    public UiScrollerSortingTestTemplate(@org.jetbrains.annotations.NotNull()
    java.lang.String entityName, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    S scrollerPage, @org.jetbrains.annotations.Nullable()
    C scrollerCategory, @org.jetbrains.annotations.NotNull()
    SP sortingParam, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.util.UUID> preExecution, int maxRowLimit) {
        super(null, null, null, null);
    }
}