package ooo.jtc.ui.common.templates;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*&\b\u0001\u0010\u0003* \u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u0007\u0012\u0002\b\u00030\u0004*\b\b\u0002\u0010\u0007*\u00020\b2\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\n0\tBC\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00028\u0001\u0012\b\u0010\u0010\u001a\u0004\u0018\u00018\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\u00a2\u0006\u0002\u0010\u0015J\u0017\u0010&\u001a\u00020\n2\b\u0010\'\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010(J\u0014\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020+0*H\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0010\u001a\u0004\u0018\u00018\u0002\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000f\u001a\u00028\u0001\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u00a8\u0006,"}, d2 = {"Looo/jtc/ui/common/templates/UiScrollerAvailableActionsTestTemplate;", "T", "Looo/jtc/interfaces/IDocument;", "S", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "Looo/jtc/core/elements/scroller/DocumentScroller;", "Looo/jtc/core/elements/scroller/DocumentScrollerRow;", "C", "Looo/jtc/core/elements/scroller/ScrollerCategory;", "Looo/jtc/api/common/tests/AbstractTest;", "", "entityName", "", "user", "Looo/jtc/uaa/User;", "scrollerPage", "scrollerCategory", "expActions", "", "preExecution", "Lkotlin/Function0;", "(Ljava/lang/String;Looo/jtc/uaa/User;Looo/jtc/ui/common/pages/DocumentScrollerPage;Looo/jtc/core/elements/scroller/ScrollerCategory;Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "getEntityName", "()Ljava/lang/String;", "setEntityName", "(Ljava/lang/String;)V", "getExpActions", "()Ljava/util/List;", "getPreExecution", "()Lkotlin/jvm/functions/Function0;", "getScrollerCategory", "()Looo/jtc/core/elements/scroller/ScrollerCategory;", "Looo/jtc/core/elements/scroller/ScrollerCategory;", "getScrollerPage", "()Looo/jtc/ui/common/pages/DocumentScrollerPage;", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "getUser", "()Looo/jtc/uaa/User;", "execution", "preconditionResult", "(Looo/jtc/interfaces/IDocument;)V", "params", "", "", "box-tests"})
public class UiScrollerAvailableActionsTestTemplate<T extends ooo.jtc.interfaces.IDocument, S extends ooo.jtc.ui.common.pages.DocumentScrollerPage<? extends ooo.jtc.core.elements.scroller.DocumentScroller<? extends ooo.jtc.core.elements.scroller.DocumentScrollerRow>, ?, C, ?>, C extends ooo.jtc.core.elements.scroller.ScrollerCategory> extends ooo.jtc.api.common.tests.AbstractTest<T, kotlin.Unit> {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String entityName;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.uaa.User user = null;
    @org.jetbrains.annotations.NotNull()
    private final S scrollerPage = null;
    @org.jetbrains.annotations.Nullable()
    private final C scrollerCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> expActions = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<T> preExecution = null;
    
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
    
    @org.jetbrains.annotations.Nullable()
    public final C getScrollerCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getExpActions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function0<T> getPreExecution() {
        return null;
    }
    
    public UiScrollerAvailableActionsTestTemplate(@org.jetbrains.annotations.NotNull()
    java.lang.String entityName, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    S scrollerPage, @org.jetbrains.annotations.Nullable()
    C scrollerCategory, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> expActions, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends T> preExecution) {
        super(null, null, null, null);
    }
}