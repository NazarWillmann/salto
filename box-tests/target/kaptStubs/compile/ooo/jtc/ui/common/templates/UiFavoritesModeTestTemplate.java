package ooo.jtc.ui.common.templates;

import java.lang.System;

/**
 * В [preExecution] нужно проверить, что у определенного клиента есть документы добавленные в Избранное и не добавленные.
 * И вернуть ID этого клиента.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u0000*&\b\u0000\u0010\u0001* \u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0002\b\u00030\u0002*\b\b\u0001\u0010\u0005*\u00020\u00062\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007B3\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00028\u0000\u0012\u0006\u0010\u000f\u001a\u00028\u0001\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011\u00a2\u0006\u0002\u0010\u0012J\u0012\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010\'\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)0(H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u000f\u001a\u00028\u0001X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000e\u001a\u00028\u0000X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Looo/jtc/ui/common/templates/UiFavoritesModeTestTemplate;", "S", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "Looo/jtc/core/elements/scroller/DocumentScroller;", "Looo/jtc/core/elements/scroller/DocumentScrollerRow;", "C", "Looo/jtc/core/elements/scroller/ScrollerCategory;", "Looo/jtc/api/common/tests/AbstractTest;", "Ljava/util/UUID;", "", "entityName", "", "user", "Looo/jtc/uaa/User;", "scrollerPage", "scrollerCategory", "preExecution", "Lkotlin/Function0;", "(Ljava/lang/String;Looo/jtc/uaa/User;Looo/jtc/ui/common/pages/DocumentScrollerPage;Looo/jtc/core/elements/scroller/ScrollerCategory;Lkotlin/jvm/functions/Function0;)V", "getEntityName", "()Ljava/lang/String;", "setEntityName", "(Ljava/lang/String;)V", "getScrollerCategory", "()Looo/jtc/core/elements/scroller/ScrollerCategory;", "setScrollerCategory", "(Looo/jtc/core/elements/scroller/ScrollerCategory;)V", "Looo/jtc/core/elements/scroller/ScrollerCategory;", "getScrollerPage", "()Looo/jtc/ui/common/pages/DocumentScrollerPage;", "setScrollerPage", "(Looo/jtc/ui/common/pages/DocumentScrollerPage;)V", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "getUser", "()Looo/jtc/uaa/User;", "setUser", "(Looo/jtc/uaa/User;)V", "execution", "preconditionResult", "params", "", "", "box-tests"})
public class UiFavoritesModeTestTemplate<S extends ooo.jtc.ui.common.pages.DocumentScrollerPage<? extends ooo.jtc.core.elements.scroller.DocumentScroller<? extends ooo.jtc.core.elements.scroller.DocumentScrollerRow>, ?, C, ?>, C extends ooo.jtc.core.elements.scroller.ScrollerCategory> extends ooo.jtc.api.common.tests.AbstractTest<java.util.UUID, kotlin.Unit> {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String entityName;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.uaa.User user;
    @org.jetbrains.annotations.NotNull()
    private S scrollerPage;
    @org.jetbrains.annotations.NotNull()
    private C scrollerCategory;
    
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
    
    public UiFavoritesModeTestTemplate(@org.jetbrains.annotations.NotNull()
    java.lang.String entityName, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    S scrollerPage, @org.jetbrains.annotations.NotNull()
    C scrollerCategory, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.util.UUID> preExecution) {
        super(null, null, null, null);
    }
}