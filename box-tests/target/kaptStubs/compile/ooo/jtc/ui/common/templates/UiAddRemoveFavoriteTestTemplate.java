package ooo.jtc.ui.common.templates;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*&\b\u0001\u0010\u0003* \u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u0007\u0012\u0002\b\u00030\u0004*\b\b\u0002\u0010\u0007*\u00020\b2\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\n0\tB3\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00028\u0001\u0012\u0006\u0010\u0010\u001a\u00028\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\u00a2\u0006\u0002\u0010\u0013J\u0017\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010,J\u0014\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020/0.H\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0010\u001a\u00028\u0002X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000f\u001a\u00028\u0001X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)\u00a8\u00060"}, d2 = {"Looo/jtc/ui/common/templates/UiAddRemoveFavoriteTestTemplate;", "T", "Looo/jtc/interfaces/IDocumentView;", "S", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "Looo/jtc/core/elements/scroller/DocumentScroller;", "Looo/jtc/core/elements/scroller/DocumentScrollerRow;", "C", "Looo/jtc/core/elements/scroller/ScrollerCategory;", "Looo/jtc/api/common/tests/AbstractTest;", "", "entityName", "", "user", "Looo/jtc/uaa/User;", "scrollerPage", "scrollerCategory", "preExecution", "Lkotlin/Function0;", "(Ljava/lang/String;Looo/jtc/uaa/User;Looo/jtc/ui/common/pages/DocumentScrollerPage;Looo/jtc/core/elements/scroller/ScrollerCategory;Lkotlin/jvm/functions/Function0;)V", "getEntityName", "()Ljava/lang/String;", "setEntityName", "(Ljava/lang/String;)V", "getPreExecution", "()Lkotlin/jvm/functions/Function0;", "setPreExecution", "(Lkotlin/jvm/functions/Function0;)V", "getScrollerCategory", "()Looo/jtc/core/elements/scroller/ScrollerCategory;", "setScrollerCategory", "(Looo/jtc/core/elements/scroller/ScrollerCategory;)V", "Looo/jtc/core/elements/scroller/ScrollerCategory;", "getScrollerPage", "()Looo/jtc/ui/common/pages/DocumentScrollerPage;", "setScrollerPage", "(Looo/jtc/ui/common/pages/DocumentScrollerPage;)V", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "getUser", "()Looo/jtc/uaa/User;", "setUser", "(Looo/jtc/uaa/User;)V", "execution", "preconditionResult", "(Looo/jtc/interfaces/IDocumentView;)V", "params", "", "", "box-tests"})
public class UiAddRemoveFavoriteTestTemplate<T extends ooo.jtc.interfaces.IDocumentView, S extends ooo.jtc.ui.common.pages.DocumentScrollerPage<? extends ooo.jtc.core.elements.scroller.DocumentScroller<? extends ooo.jtc.core.elements.scroller.DocumentScrollerRow>, ?, C, ?>, C extends ooo.jtc.core.elements.scroller.ScrollerCategory> extends ooo.jtc.api.common.tests.AbstractTest<T, kotlin.Unit> {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String entityName;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.uaa.User user;
    @org.jetbrains.annotations.NotNull()
    private S scrollerPage;
    @org.jetbrains.annotations.NotNull()
    private C scrollerCategory;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<? extends T> preExecution;
    
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
    
    public final void setUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final S getScrollerPage() {
        return null;
    }
    
    public final void setScrollerPage(@org.jetbrains.annotations.NotNull()
    S p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final C getScrollerCategory() {
        return null;
    }
    
    public final void setScrollerCategory(@org.jetbrains.annotations.NotNull()
    C p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function0<T> getPreExecution() {
        return null;
    }
    
    public void setPreExecution(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends T> p0) {
    }
    
    public UiAddRemoveFavoriteTestTemplate(@org.jetbrains.annotations.NotNull()
    java.lang.String entityName, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    S scrollerPage, @org.jetbrains.annotations.NotNull()
    C scrollerCategory, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends T> preExecution) {
        super(null, null, null, null);
    }
}