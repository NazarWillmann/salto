package ooo.jtc.core.browser;

import java.lang.System;

/**
 * Helper для взаимодействия с вкладками браузера
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u000eH\u0007J\b\u0010\u0010\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Looo/jtc/core/browser/BrowserHelper;", "", "()V", "BROWSER", "", "CHROME", "FIREFOX", "IE", "expandRootElement", "Lcom/codeborne/selenide/SelenideElement;", "element", "getLastDownloadedFileName", "getPageText", "openChromeDownloads", "", "switchNetworkOffline", "switchToNextTab", "qa-core-ui"})
public final class BrowserHelper {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHROME = "chrome";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FIREFOX = "firefox";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IE = "ie";
    private static final java.lang.String BROWSER = null;
    public static final ooo.jtc.core.browser.BrowserHelper INSTANCE = null;
    
    @io.qameta.allure.Step(value = "\u041f\u0435\u0440\u0435\u043a\u043b\u044e\u0447\u0438\u0442\u0441\u044f \u043d\u0430 \u0441\u043b\u0435\u0434\u0443\u044e\u0449\u0443\u044e \u0432\u043a\u043b\u0430\u0434\u043a\u0443")
    public final void switchToNextTab() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0442\u0435\u043a\u0441\u0442 \u0441\u043e \u0441\u0442\u0440\u0430\u043d\u0438\u0446\u044b")
    public final java.lang.String getPageText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u043d\u0430\u0438\u043c\u0435\u043d\u043e\u0432\u0430\u043d\u0438\u0435 \u043f\u043e\u0441\u043b\u0435\u0434\u043d\u0435\u0433\u043e \u0437\u0430\u0433\u0440\u0443\u0436\u0435\u043d\u043d\u043e\u0433\u043e \u0444\u0430\u0439\u043b\u0430")
    public final java.lang.String getLastDownloadedFileName() {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041e\u0442\u043a\u0440\u044b\u0442\u044c \u0432\u043a\u043b\u0430\u0434\u043a\u0443 \u0417\u0430\u0433\u0440\u0443\u0437\u043a\u0438 \u0432 \u0431\u0440\u0430\u0443\u0437\u0435\u0440\u0435 Chrome")
    public final void openChromeDownloads() {
    }
    
    private final com.codeborne.selenide.SelenideElement expandRootElement(com.codeborne.selenide.SelenideElement element) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0435\u0440\u0435\u043a\u043b\u044e\u0447\u0438\u0442\u044c \u0440\u0435\u0436\u0438\u043c \u0441\u0435\u0442\u0438 \u0431\u0440\u0430\u0443\u0437\u0435\u0440\u0430 \u0432 Offline")
    public final void switchNetworkOffline() {
    }
    
    private BrowserHelper() {
        super();
    }
}