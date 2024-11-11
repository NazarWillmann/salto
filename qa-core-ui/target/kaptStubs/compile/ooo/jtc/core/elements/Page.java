package ooo.jtc.core.elements;

import java.lang.System;

/**
 * Базовая страница для всех UI-pages.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Looo/jtc/core/elements/Page;", "Looo/jtc/core/container/SContainer;", "url", "", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "(Ljava/lang/String;Lcom/codeborne/selenide/SelenideElement;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "open", "fillingStorages", "", "Looo/jtc/core/browser/StorageItem;", "qa-core-ui"})
public abstract class Page extends ooo.jtc.core.container.SContainer {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String url;
    
    /**
     * Основная функция для открытия страниц.
     * Тут же дополнительно конфигурируется selenide
     * и заполняются хранилища (localStorage,sessionStorage) в браузере.
     */
    @org.jetbrains.annotations.NotNull()
    public ooo.jtc.core.elements.Page open(@org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.core.browser.StorageItem> fillingStorages) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrl() {
        return null;
    }
    
    public final void setUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public Page(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement) {
        super(null, null);
    }
}