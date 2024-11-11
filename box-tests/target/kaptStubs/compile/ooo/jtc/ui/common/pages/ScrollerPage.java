package ooo.jtc.ui.common.pages;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0017R\u0011\u0010\u000b\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00028\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Looo/jtc/ui/common/pages/ScrollerPage;", "S", "Looo/jtc/core/elements/scroller/Scroller;", "Looo/jtc/ui/common/pages/ApplicationPage;", "endpoint", "", "pageType", "Looo/jtc/ui/common/pages/ApplicationPageType;", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "(Ljava/lang/String;Looo/jtc/ui/common/pages/ApplicationPageType;Lcom/codeborne/selenide/SelenideElement;)V", "loader", "Looo/jtc/core/container/SContainer;", "getLoader", "()Looo/jtc/core/container/SContainer;", "scroller", "getScroller", "()Looo/jtc/core/elements/scroller/Scroller;", "sidebarMenu", "Looo/jtc/core/elements/SidebarMenu;", "getSidebarMenu", "()Looo/jtc/core/elements/SidebarMenu;", "makeAction", "", "action", "box-tests"})
public abstract class ScrollerPage<S extends ooo.jtc.core.elements.scroller.Scroller<?>> extends ooo.jtc.ui.common.pages.ApplicationPage {
    
    @org.jetbrains.annotations.NotNull()
    public abstract S getScroller();
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.SidebarMenu getSidebarMenu() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SContainer getLoader() {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u0412\u044b\u0431\u0440\u0430\u0442\u044c \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435 \'{action}\'")
    public void makeAction(@org.jetbrains.annotations.NotNull()
    java.lang.String action) {
    }
    
    public ScrollerPage(@org.jetbrains.annotations.NotNull()
    java.lang.String endpoint, @org.jetbrains.annotations.NotNull()
    ooo.jtc.ui.common.pages.ApplicationPageType pageType, @org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement) {
        super(null, null, null);
    }
}