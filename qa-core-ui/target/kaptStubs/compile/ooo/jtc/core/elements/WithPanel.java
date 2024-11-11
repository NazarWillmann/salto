package ooo.jtc.core.elements;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u000b\u0010\u0002\u001a\u00020\u00038BX\u0082\u0004R\u000b\u0010\u0004\u001a\u00020\u00038BX\u0082\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Looo/jtc/core/elements/WithPanel;", "Looo/jtc/core/container/SContext;", "collapseButton", "Looo/jtc/core/container/SContainer;", "expandButton", "isExpanded", "", "()Z", "onPanel", "Lcom/codeborne/selenide/SelenideElement;", "getOnPanel", "()Lcom/codeborne/selenide/SelenideElement;", "collapse", "", "expand", "qa-core-ui"})
public abstract interface WithPanel extends ooo.jtc.core.container.SContext {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.codeborne.selenide.SelenideElement getOnPanel();
    
    public abstract boolean isExpanded();
    
    public abstract void expand();
    
    public abstract void collapse();
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        public static com.codeborne.selenide.SelenideElement getOnPanel(@org.jetbrains.annotations.NotNull()
        ooo.jtc.core.elements.WithPanel $this) {
            return null;
        }
        
        private static ooo.jtc.core.container.SContainer getExpandButton(ooo.jtc.core.elements.WithPanel $this) {
            return null;
        }
        
        private static ooo.jtc.core.container.SContainer getCollapseButton(ooo.jtc.core.elements.WithPanel $this) {
            return null;
        }
        
        public static boolean isExpanded(@org.jetbrains.annotations.NotNull()
        ooo.jtc.core.elements.WithPanel $this) {
            return false;
        }
        
        public static void expand(@org.jetbrains.annotations.NotNull()
        ooo.jtc.core.elements.WithPanel $this) {
        }
        
        public static void collapse(@org.jetbrains.annotations.NotNull()
        ooo.jtc.core.elements.WithPanel $this) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static com.codeborne.selenide.SelenideElement getContext(@org.jetbrains.annotations.NotNull()
        ooo.jtc.core.elements.WithPanel $this) {
            return null;
        }
    }
}