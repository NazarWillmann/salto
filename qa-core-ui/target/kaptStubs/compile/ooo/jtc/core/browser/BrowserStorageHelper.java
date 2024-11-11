package ooo.jtc.core.browser;

import java.lang.System;

/**
 * BrowserStorageHelper.
 *
 * @author Pavel_Markin
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fJ\u001e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0012J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000fJ&\u0010\u0016\u001a\n \u0004*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000fJ\u001e\u0010\u0017\u001a\n \u0004*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\rJ\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\u001b"}, d2 = {"Looo/jtc/core/browser/BrowserStorageHelper;", "", "()V", "clearStorage", "kotlin.jvm.PlatformType", "executor", "Lorg/openqa/selenium/JavascriptExecutor;", "storageType", "Looo/jtc/core/browser/StorageType;", "fillPageStorage", "", "list", "", "Looo/jtc/core/browser/StorageItem;", "getItemFromStorage", "", "key", "getKeyFromStorage", "", "isItemPresentInStorage", "", "item", "removeItemFromStorage", "setItemInStorage", "storageItem", "storageLength", "", "qa-core-ui"})
public final class BrowserStorageHelper {
    public static final ooo.jtc.core.browser.BrowserStorageHelper INSTANCE = null;
    
    public final void fillPageStorage(@org.jetbrains.annotations.NotNull()
    org.openqa.selenium.JavascriptExecutor executor, @org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.core.browser.StorageItem> list) {
    }
    
    public final java.lang.Object removeItemFromStorage(@org.jetbrains.annotations.NotNull()
    org.openqa.selenium.JavascriptExecutor executor, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.browser.StorageType storageType, @org.jetbrains.annotations.NotNull()
    java.lang.String item) {
        return null;
    }
    
    public final boolean isItemPresentInStorage(@org.jetbrains.annotations.NotNull()
    org.openqa.selenium.JavascriptExecutor executor, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.browser.StorageType storageType, @org.jetbrains.annotations.NotNull()
    java.lang.String item) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getItemFromStorage(@org.jetbrains.annotations.NotNull()
    org.openqa.selenium.JavascriptExecutor executor, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.browser.StorageType storageType, @org.jetbrains.annotations.NotNull()
    java.lang.String key) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getKeyFromStorage(@org.jetbrains.annotations.NotNull()
    org.openqa.selenium.JavascriptExecutor executor, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.browser.StorageType storageType, int key) {
        return null;
    }
    
    public final long storageLength(@org.jetbrains.annotations.NotNull()
    org.openqa.selenium.JavascriptExecutor executor, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.browser.StorageType storageType) {
        return 0L;
    }
    
    public final java.lang.Object setItemInStorage(@org.jetbrains.annotations.NotNull()
    org.openqa.selenium.JavascriptExecutor executor, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.browser.StorageItem storageItem) {
        return null;
    }
    
    public final java.lang.Object clearStorage(@org.jetbrains.annotations.NotNull()
    org.openqa.selenium.JavascriptExecutor executor, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.browser.StorageType storageType) {
        return null;
    }
    
    private BrowserStorageHelper() {
        super();
    }
}