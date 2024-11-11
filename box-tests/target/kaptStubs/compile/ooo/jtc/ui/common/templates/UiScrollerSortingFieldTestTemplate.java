package ooo.jtc.ui.common.templates;

import java.lang.System;

/**
 * Проверка сортировки.
 * В прекондишене необходимо проверить, что в системе существует минимум 3 документа для проверки сортировки.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u0000*$\b\u0000\u0010\u0001*\u001e\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005B;\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00028\u0000\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010\u00a2\u0006\u0002\u0010\u0011J\u0017\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020%0$H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000b\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006&"}, d2 = {"Looo/jtc/ui/common/templates/UiScrollerSortingFieldTestTemplate;", "S", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "Looo/jtc/core/elements/scroller/ExpandedScroller;", "Looo/jtc/core/elements/scroller/ExpandedScrollerRow;", "Looo/jtc/api/common/tests/AbstractTest;", "", "entityName", "", "user", "Looo/jtc/uaa/User;", "scrollerPage", "expDefaultDirection", "Looo/jtc/core/elements/scroller/UiSortDirection;", "expDefaultSortingField", "expSortingFields", "", "(Ljava/lang/String;Looo/jtc/uaa/User;Looo/jtc/ui/common/pages/DocumentScrollerPage;Looo/jtc/core/elements/scroller/UiSortDirection;Ljava/lang/String;Ljava/util/List;)V", "getEntityName", "()Ljava/lang/String;", "setEntityName", "(Ljava/lang/String;)V", "getExpDefaultDirection", "()Looo/jtc/core/elements/scroller/UiSortDirection;", "getExpDefaultSortingField", "getExpSortingFields", "()Ljava/util/List;", "getScrollerPage", "()Looo/jtc/ui/common/pages/DocumentScrollerPage;", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "getUser", "()Looo/jtc/uaa/User;", "execution", "preconditionResult", "(Lkotlin/Unit;)V", "params", "", "", "box-tests"})
public class UiScrollerSortingFieldTestTemplate<S extends ooo.jtc.ui.common.pages.DocumentScrollerPage<? extends ooo.jtc.core.elements.scroller.ExpandedScroller<? extends ooo.jtc.core.elements.scroller.ExpandedScrollerRow>, ?, ?, ?>> extends ooo.jtc.api.common.tests.AbstractTest<kotlin.Unit, kotlin.Unit> {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String entityName;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.uaa.User user = null;
    @org.jetbrains.annotations.NotNull()
    private final S scrollerPage = null;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.core.elements.scroller.UiSortDirection expDefaultDirection = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String expDefaultSortingField = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> expSortingFields = null;
    
    @java.lang.Override()
    public void execution(@org.jetbrains.annotations.Nullable()
    kotlin.Unit preconditionResult) {
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
    public final ooo.jtc.core.elements.scroller.UiSortDirection getExpDefaultDirection() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getExpDefaultSortingField() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getExpSortingFields() {
        return null;
    }
    
    public UiScrollerSortingFieldTestTemplate(@org.jetbrains.annotations.NotNull()
    java.lang.String entityName, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    S scrollerPage, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.elements.scroller.UiSortDirection expDefaultDirection, @org.jetbrains.annotations.NotNull()
    java.lang.String expDefaultSortingField, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> expSortingFields) {
        super(null, null, null, null);
    }
}