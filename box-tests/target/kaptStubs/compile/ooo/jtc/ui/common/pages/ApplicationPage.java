package ooo.jtc.ui.common.pages;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J,\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u0011\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0086\u0004J\u0016\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0019J\u0016\u0010\u001f\u001a\u00020\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\b\u0010#\u001a\u00020\u0017H&R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006$"}, d2 = {"Looo/jtc/ui/common/pages/ApplicationPage;", "Looo/jtc/core/elements/Page;", "endpoint", "", "pageType", "Looo/jtc/ui/common/pages/ApplicationPageType;", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "(Ljava/lang/String;Looo/jtc/ui/common/pages/ApplicationPageType;Lcom/codeborne/selenide/SelenideElement;)V", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "log$delegate", "Looo/jtc/logging/LoggerDelegate;", "getPageType", "()Looo/jtc/ui/common/pages/ApplicationPageType;", "setPageType", "(Looo/jtc/ui/common/pages/ApplicationPageType;)V", "getUserToken", "user", "Looo/jtc/uaa/User;", "openFormByParams", "", "documentId", "Ljava/util/UUID;", "mode", "tab", "Looo/jtc/ui/common/pages/DocumentPageTabs;", "openScrollerBy", "customerId", "openWithWaiting", "fillingStorages", "", "Looo/jtc/core/browser/StorageItem;", "waitLoading", "box-tests"})
public abstract class ApplicationPage extends ooo.jtc.core.elements.Page {
    private final ooo.jtc.logging.LoggerDelegate log$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.ui.common.pages.ApplicationPageType pageType;
    
    private final org.slf4j.Logger getLog() {
        return null;
    }
    
    private final java.lang.String getUserToken(ooo.jtc.uaa.User user) {
        return null;
    }
    
    /**
     * Функция ожидания загрузки страницы.
     * Рекомендуется ждать видимости самого долго загружающегося элемента на странице.
     */
    public abstract void waitLoading();
    
    public final void openScrollerBy(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
    }
    
    public final void openScrollerBy(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    java.util.UUID customerId) {
    }
    
    public final void openFormByParams(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    java.util.UUID documentId, @org.jetbrains.annotations.Nullable()
    java.lang.String mode, @org.jetbrains.annotations.NotNull()
    ooo.jtc.ui.common.pages.DocumentPageTabs tab) {
    }
    
    private final void openWithWaiting(java.util.List<ooo.jtc.core.browser.StorageItem> fillingStorages) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.ui.common.pages.ApplicationPageType getPageType() {
        return null;
    }
    
    public final void setPageType(@org.jetbrains.annotations.NotNull()
    ooo.jtc.ui.common.pages.ApplicationPageType p0) {
    }
    
    public ApplicationPage(@org.jetbrains.annotations.NotNull()
    java.lang.String endpoint, @org.jetbrains.annotations.NotNull()
    ooo.jtc.ui.common.pages.ApplicationPageType pageType, @org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement) {
        super(null, null);
    }
}