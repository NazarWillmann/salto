package ooo.jtc.core.browser;

import java.lang.System;

/**
 * You can use custom Driver factory for creating webDriver for Selenide.
 * https://github.com/selenide/selenide/wiki/How-Selenide-creates-WebDriver
 *
 * There is an issue with chrome extension in Selenide.
 * For now we can use this workaround.
 * Will be looking for fixes.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Looo/jtc/core/browser/CustomRemoteWebDriverProvider;", "Lcom/codeborne/selenide/WebDriverProvider;", "()V", "createDriver", "Lorg/openqa/selenium/WebDriver;", "desiredCapabilities", "Lorg/openqa/selenium/remote/DesiredCapabilities;", "qa-core-ui"})
public final class CustomRemoteWebDriverProvider implements com.codeborne.selenide.WebDriverProvider {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.openqa.selenium.WebDriver createDriver(@org.jetbrains.annotations.NotNull()
    org.openqa.selenium.remote.DesiredCapabilities desiredCapabilities) {
        return null;
    }
    
    public CustomRemoteWebDriverProvider() {
        super();
    }
}