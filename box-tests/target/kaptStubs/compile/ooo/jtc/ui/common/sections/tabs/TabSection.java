package ooo.jtc.ui.common.sections.tabs;

import java.lang.System;

/**
 * Закладка (вкладка).
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\r\u0010\u0007\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Looo/jtc/ui/common/sections/tabs/TabSection;", "T", "Looo/jtc/core/container/SContext;", "tabName", "", "getTabName", "()Ljava/lang/String;", "openTab", "()Ljava/lang/Object;", "waitTabOpens", "", "box-tests"})
public abstract interface TabSection<T extends java.lang.Object> extends ooo.jtc.core.container.SContext {
    
    /**
     * Название закладки.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getTabName();
    
    /**
     * Ожидание загрузки элементов закладки.
     */
    public abstract void waitTabOpens();
    
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    public abstract T openTab();
    
    /**
     * Закладка (вкладка).
     */
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        /**
         * Ожидание загрузки элементов закладки.
         */
        public static <T extends java.lang.Object>void waitTabOpens(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.TabSection<T> $this) {
        }
        
        @kotlin.Suppress(names = {"UNCHECKED_CAST"})
        public static <T extends java.lang.Object>T openTab(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.TabSection<T> $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static <T extends java.lang.Object>com.codeborne.selenide.SelenideElement getContext(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.TabSection<T> $this) {
            return null;
        }
    }
}