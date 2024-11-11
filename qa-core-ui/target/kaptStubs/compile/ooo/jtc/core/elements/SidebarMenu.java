package ooo.jtc.core.elements;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0007\u00a8\u0006\u000f"}, d2 = {"Looo/jtc/core/elements/SidebarMenu;", "Looo/jtc/core/container/SContainer;", "()V", "items", "", "Looo/jtc/core/elements/SidebarMenu$MenuItem;", "getItems", "()Ljava/util/List;", "textItems", "", "getTextItems", "selectCustomer", "", "customerName", "MenuItem", "qa-core-ui"})
@ElementType(name = "\u0413\u043b\u0430\u0432\u043d\u043e\u0435 \u043c\u0435\u043d\u044e")
public class SidebarMenu extends ooo.jtc.core.container.SContainer {
    
    public final void selectCustomer(@org.jetbrains.annotations.NotNull()
    java.lang.String customerName) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.core.elements.SidebarMenu.MenuItem> getItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTextItems() {
        return null;
    }
    
    public SidebarMenu() {
        super(null, null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Looo/jtc/core/elements/SidebarMenu$MenuItem;", "Looo/jtc/core/container/SContainer;", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "(Lcom/codeborne/selenide/SelenideElement;)V", "qa-core-ui"})
    @ElementType(name = "\u041f\u0443\u043d\u043a\u0442 \u0433\u043b\u0430\u0432\u043d\u043e\u0435 \u043c\u0435\u043d\u044e")
    public static final class MenuItem extends ooo.jtc.core.container.SContainer {
        
        public MenuItem(@org.jetbrains.annotations.NotNull()
        com.codeborne.selenide.SelenideElement sElement) {
            super(null, null);
        }
        
        public MenuItem() {
            super(null, null);
        }
    }
}