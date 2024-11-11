package ooo.jtc.ui.common.pages;

import java.lang.System;

/**
 * Abstract page for creating a document entity.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0003H\u0007J\u0014\u0010,\u001a\u00020*2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003H\u0007J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u0003H\u0007J!\u00100\u001a\u00020*2\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020302\"\u000203H\u0007\u00a2\u0006\u0002\u00104J\u0010\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u0003H\u0007J\b\u00107\u001a\u00020*H\u0016R\u0011\u0010\t\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\fR\u0011\u0010\u001b\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0018R\u001a\u0010\u001d\u001a\u00020\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010$R\u0011\u0010%\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\fR\u0011\u0010\'\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u0018\u00a8\u00068"}, d2 = {"Looo/jtc/ui/common/pages/DocumentPage;", "Looo/jtc/ui/common/pages/ApplicationPage;", "endpoint", "", "pageType", "Looo/jtc/ui/common/pages/ApplicationPageType;", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "(Ljava/lang/String;Looo/jtc/ui/common/pages/ApplicationPageType;Lcom/codeborne/selenide/SelenideElement;)V", "back", "Looo/jtc/core/elements/Button;", "getBack", "()Looo/jtc/core/elements/Button;", "decline", "getDecline", "documentDate", "Looo/jtc/core/elements/Input;", "getDocumentDate", "()Looo/jtc/core/elements/Input;", "documentNumber", "getDocumentNumber", "documentNumberAndDate", "Looo/jtc/core/container/SContainer;", "getDocumentNumberAndDate", "()Looo/jtc/core/container/SContainer;", "editDocumentNumber", "getEditDocumentNumber", "header", "getHeader", "headerName", "getHeaderName", "()Ljava/lang/String;", "setHeaderName", "(Ljava/lang/String;)V", "isFavorite", "Looo/jtc/core/elements/Favorite;", "()Looo/jtc/core/elements/Favorite;", "save", "getSave", "status", "getStatus", "checkDocumentNumber", "", "expDocNumber", "checkHeader", "expHeaderName", "checkStatus", "expStatus", "checkVisibleTabs", "visibleTabs", "", "Looo/jtc/ui/common/pages/DocumentPageTabs;", "([Looo/jtc/ui/common/pages/DocumentPageTabs;)V", "makeAction", "action", "waitLoading", "box-tests"})
public abstract class DocumentPage extends ooo.jtc.ui.common.pages.ApplicationPage {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String headerName = "";
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getHeaderName() {
        return null;
    }
    
    public void setHeaderName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SContainer getHeader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SContainer getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Favorite isFavorite() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Input getDocumentNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Button getEditDocumentNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Input getDocumentDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SContainer getDocumentNumberAndDate() {
        return null;
    }
    
    @java.lang.Override()
    public void waitLoading() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Button getSave() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Button getDecline() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Button getBack() {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0417\u0430\u0433\u043e\u043b\u043e\u0432\u043e\u043a \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \u0441\u043e\u043e\u0442\u0432\u0435\u0442\u0441\u0442\u0432\u0443\u0435\u0442 \'{this.headerName}\'")
    public final void checkHeader(@org.jetbrains.annotations.Nullable()
    java.lang.String expHeaderName) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u043d\u043e\u043c\u0435\u0440 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \u0441\u043e\u043e\u0442\u0432\u0435\u0442\u0441\u0442\u0432\u0443\u0435\u0442 \'{expDocNumber}\'")
    public final void checkDocumentNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String expDocNumber) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u044e\u0449\u0438\u0435\u0441\u044f \u0432\u043a\u043b\u0430\u0434\u043a\u0438 {visibleTabs}")
    public final void checkVisibleTabs(@org.jetbrains.annotations.NotNull()
    ooo.jtc.ui.common.pages.DocumentPageTabs... visibleTabs) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0441\u0442\u0430\u0442\u0443\u0441 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \'{expStatus}\'")
    public final void checkStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String expStatus) {
    }
    
    @io.qameta.allure.Step(value = "\u0412\u044b\u0431\u0440\u0430\u0442\u044c \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435 \'{action}\'")
    public final void makeAction(@org.jetbrains.annotations.NotNull()
    java.lang.String action) {
    }
    
    public DocumentPage(@org.jetbrains.annotations.NotNull()
    java.lang.String endpoint, @org.jetbrains.annotations.NotNull()
    ooo.jtc.ui.common.pages.ApplicationPageType pageType, @org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement) {
        super(null, null, null);
    }
}