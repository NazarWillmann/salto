package ooo.jtc.ui.common.templates;

import java.lang.System;

/**
 * Проверка соответствия статусов документов в проверяемой категории.
 * В прекондишене необходимо проверить, что в системе для проверяемой категории есть документы.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u0000*&\b\u0000\u0010\u0001* \u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0002\b\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0002\b\u00030\u0002*\b\b\u0001\u0010\u0005*\u00020\u00062\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007BK\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00028\u0000\u0012\u0006\u0010\u000f\u001a\u00028\u0001\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0002\u0010\u0016J\u0012\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020-0,H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000f\u001a\u00028\u0001\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0013\u0010\u000e\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(\u00a8\u0006."}, d2 = {"Looo/jtc/ui/common/templates/UiScrollerCategoryTestTemplate;", "S", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "Looo/jtc/core/elements/scroller/DocumentScroller;", "Looo/jtc/core/elements/scroller/DocumentScrollerRow;", "C", "Looo/jtc/core/elements/scroller/ScrollerCategory;", "Looo/jtc/api/common/tests/AbstractTest;", "Ljava/util/UUID;", "", "entityName", "", "user", "Looo/jtc/uaa/User;", "scrollerPage", "scrollerCategory", "expStatuses", "", "preExecution", "Lkotlin/Function0;", "maxRowLimit", "", "(Ljava/lang/String;Looo/jtc/uaa/User;Looo/jtc/ui/common/pages/DocumentScrollerPage;Looo/jtc/core/elements/scroller/ScrollerCategory;Ljava/util/List;Lkotlin/jvm/functions/Function0;I)V", "getEntityName", "()Ljava/lang/String;", "setEntityName", "(Ljava/lang/String;)V", "getExpStatuses", "()Ljava/util/List;", "getMaxRowLimit", "()I", "getPreExecution", "()Lkotlin/jvm/functions/Function0;", "getScrollerCategory", "()Looo/jtc/core/elements/scroller/ScrollerCategory;", "Looo/jtc/core/elements/scroller/ScrollerCategory;", "getScrollerPage", "()Looo/jtc/ui/common/pages/DocumentScrollerPage;", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "getUser", "()Looo/jtc/uaa/User;", "execution", "preconditionResult", "params", "", "", "box-tests"})
public class UiScrollerCategoryTestTemplate<S extends ooo.jtc.ui.common.pages.DocumentScrollerPage<? extends ooo.jtc.core.elements.scroller.DocumentScroller<? extends ooo.jtc.core.elements.scroller.DocumentScrollerRow>, ?, C, ?>, C extends ooo.jtc.core.elements.scroller.ScrollerCategory> extends ooo.jtc.api.common.tests.AbstractTest<java.util.UUID, kotlin.Unit> {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String entityName;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.uaa.User user = null;
    @org.jetbrains.annotations.NotNull()
    private final S scrollerPage = null;
    @org.jetbrains.annotations.NotNull()
    private final C scrollerCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> expStatuses = null;
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
    
    @org.jetbrains.annotations.NotNull()
    public final C getScrollerCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getExpStatuses() {
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
    
    public UiScrollerCategoryTestTemplate(@org.jetbrains.annotations.NotNull()
    java.lang.String entityName, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    S scrollerPage, @org.jetbrains.annotations.NotNull()
    C scrollerCategory, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> expStatuses, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.util.UUID> preExecution, int maxRowLimit) {
        super(null, null, null, null);
    }
}