package ooo.jtc.ui.common.pages;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u0000*\u0010\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\u00030\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\b\b\u0002\u0010\u0005*\u00020\u0006*\b\b\u0003\u0010\u0007*\u00020\b2\b\u0012\u0004\u0012\u0002H\u00010\tB\u001f\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000bH\u0007J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u000bH\u0007J\u0015\u0010!\u001a\u00028\u00012\u0006\u0010\u001e\u001a\u00020\u000bH\u0017\u00a2\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00028\u0002\u00a2\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u001dH\u0007J\u0015\u0010\'\u001a\u00020\u00122\u0006\u0010$\u001a\u00028\u0002H\u0007\u00a2\u0006\u0002\u0010%J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010)2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+H\u0017R\u0011\u0010\u0011\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00028\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006,"}, d2 = {"Looo/jtc/ui/common/pages/DocumentScrollerPage;", "S", "Looo/jtc/core/elements/scroller/DocumentScroller;", "SR", "Looo/jtc/core/elements/scroller/DocumentScrollerRow;", "C", "Looo/jtc/core/elements/scroller/ScrollerCategory;", "F", "Looo/jtc/core/elements/scroller/FilterForm;", "Looo/jtc/ui/common/pages/ScrollerPage;", "endpoint", "", "pageType", "Looo/jtc/ui/common/pages/ApplicationPageType;", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "(Ljava/lang/String;Looo/jtc/ui/common/pages/ApplicationPageType;Lcom/codeborne/selenide/SelenideElement;)V", "activeTab", "Looo/jtc/core/elements/scroller/ScrollerTab;", "getActiveTab", "()Looo/jtc/core/elements/scroller/ScrollerTab;", "favoriteStar", "Looo/jtc/core/elements/Favorite;", "getFavoriteStar", "()Looo/jtc/core/elements/Favorite;", "filterForm", "getFilterForm", "()Looo/jtc/core/elements/scroller/FilterForm;", "filterByDocumentNumber", "", "documentNumber", "filterByStatus", "searchStatus", "findDocumentRowByNumber", "(Ljava/lang/String;)Looo/jtc/core/elements/scroller/DocumentScrollerRow;", "getTab", "category", "(Looo/jtc/core/elements/scroller/ScrollerCategory;)Looo/jtc/core/elements/scroller/ScrollerTab;", "openFilter", "openTab", "selectDocumentsByStatus", "", "docCount", "", "box-tests"})
public abstract class DocumentScrollerPage<S extends ooo.jtc.core.elements.scroller.DocumentScroller<? extends SR>, SR extends ooo.jtc.core.elements.scroller.DocumentScrollerRow, C extends ooo.jtc.core.elements.scroller.ScrollerCategory, F extends ooo.jtc.core.elements.scroller.FilterForm> extends ooo.jtc.ui.common.pages.ScrollerPage<S> {
    
    @org.jetbrains.annotations.NotNull()
    public abstract F getFilterForm();
    
    @io.qameta.allure.Step(value = "\u041e\u0442\u043a\u0440\u044b\u0442\u044c \u043f\u0430\u043d\u0435\u043b\u044c \u0444\u0438\u043b\u044c\u0442\u0440\u0430\u0446\u0438\u0438")
    public final void openFilter() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.scroller.ScrollerTab getActiveTab() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.scroller.ScrollerTab getTab(@org.jetbrains.annotations.NotNull()
    C category) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u0435\u0440\u0435\u0439\u0442\u0438 \u043d\u0430 \u0432\u043a\u043b\u0430\u0434\u043a\u0443 {category.categoryName}")
    public final ooo.jtc.core.elements.scroller.ScrollerTab openTab(@org.jetbrains.annotations.NotNull()
    C category) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Favorite getFavoriteStar() {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041e\u0442\u0444\u0438\u043b\u044c\u0442\u0440\u043e\u0432\u0430\u0442\u044c \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \u043d\u0430 \u0441\u043a\u0440\u043e\u043b\u043b\u0435\u0440\u0435 \u043f\u043e \u043d\u043e\u043c\u0435\u0440\u0443 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 {documentNumber}")
    public final void filterByDocumentNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String documentNumber) {
    }
    
    @io.qameta.allure.Step(value = "\u041e\u0442\u0444\u0438\u043b\u044c\u0442\u0440\u043e\u0432\u0430\u0442\u044c \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \u043d\u0430 \u0441\u043a\u0440\u043e\u043b\u043b\u0435\u0440\u0435 \u043f\u043e \u0441\u0442\u0430\u0442\u0443\u0441\u0443 {searchStatus}")
    public final void filterByStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String searchStatus) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u0441\u0442\u0440\u043e\u043a\u0443 \u043d\u0430 \u0441\u043a\u0440\u043e\u043b\u043b\u0435\u0440\u0435 \u043f\u043e \u043d\u043e\u043c\u0435\u0440\u0443 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 {documentNumber}")
    public SR findDocumentRowByNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String documentNumber) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0412\u044b\u0431\u0440\u0430\u0442\u044c {docCount} \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430(-\u043e\u0432) \u0432 \u0441\u0442\u0430\u0442\u0443\u0441\u0435 \'{searchStatus}\'")
    public java.util.List<SR> selectDocumentsByStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String searchStatus, int docCount) {
        return null;
    }
    
    public DocumentScrollerPage(@org.jetbrains.annotations.NotNull()
    java.lang.String endpoint, @org.jetbrains.annotations.NotNull()
    ooo.jtc.ui.common.pages.ApplicationPageType pageType, @org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement) {
        super(null, null, null);
    }
}