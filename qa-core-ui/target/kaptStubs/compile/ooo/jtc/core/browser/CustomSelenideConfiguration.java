package ooo.jtc.core.browser;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002\u00a8\u0006\u000f"}, d2 = {"Looo/jtc/core/browser/CustomSelenideConfiguration;", "", "()V", "configureSelenide", "", "getCapabilities", "Lorg/openqa/selenium/MutableCapabilities;", "getChromeOptions", "Lorg/openqa/selenium/chrome/ChromeOptions;", "getExtensionFile", "Ljava/io/File;", "extensionName", "", "getFireFoxOptions", "Lorg/openqa/selenium/firefox/FirefoxOptions;", "qa-core-ui"})
public final class CustomSelenideConfiguration {
    public static final ooo.jtc.core.browser.CustomSelenideConfiguration INSTANCE = null;
    
    /**
     * Тут конфигурируется все, что нужно для Selenide программно.
     */
    public final void configureSelenide() {
    }
    
    /**
     * Дополнительные свойства для браузеров на selenoid.
     */
    private final org.openqa.selenium.MutableCapabilities getCapabilities() {
        return null;
    }
    
    private final org.openqa.selenium.chrome.ChromeOptions getChromeOptions() {
        return null;
    }
    
    private final org.openqa.selenium.firefox.FirefoxOptions getFireFoxOptions() {
        return null;
    }
    
    /**
     * Retrieve browser extension file by [extensionName] from [resource/extensions] folder.
     */
    private final java.io.File getExtensionFile(java.lang.String extensionName) {
        return null;
    }
    
    private CustomSelenideConfiguration() {
        super();
    }
}