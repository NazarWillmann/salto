package ooo.jtc.core.elements;

import java.lang.System;

/**
 * Для ContextMenu не нужен контекст, т.к. блок меню в DOM'e располагается не в контексте строки, а в контексте body.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Looo/jtc/core/elements/ContextMenu;", "Looo/jtc/core/container/SContainer;", "()V", "item", "Looo/jtc/core/container/SElementGet;", "Looo/jtc/core/elements/ContextMenuItem;", "getItem", "()Looo/jtc/core/container/SElementGet;", "items", "", "getItems", "()Ljava/util/List;", "itemsText", "", "getItemsText", "qa-core-ui"})
@ElementType(name = "\u041a\u043e\u043d\u0442\u0435\u043a\u0441\u0442\u043d\u043e\u0435 \u043c\u0435\u043d\u044e")
public class ContextMenu extends ooo.jtc.core.container.SContainer {
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SElementGet<ooo.jtc.core.elements.ContextMenuItem> getItem() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.core.elements.ContextMenuItem> getItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getItemsText() {
        return null;
    }
    
    public ContextMenu() {
        super(null, null);
    }
}