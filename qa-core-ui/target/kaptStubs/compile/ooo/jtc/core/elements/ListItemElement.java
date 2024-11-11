package ooo.jtc.core.elements;

import java.lang.System;

/**
 * Обертка для одного элемента списка.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0011"}, d2 = {"Looo/jtc/core/elements/ListItemElement;", "Looo/jtc/core/container/SContainer;", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "(Lcom/codeborne/selenide/SelenideElement;)V", "dataAction", "", "getDataAction", "()Ljava/lang/String;", "dataActive", "", "getDataActive", "()Z", "dataDisabled", "getDataDisabled", "dataSelected", "getDataSelected", "qa-core-ui"})
@ElementType(name = "\u041f\u0443\u043d\u043a\u0442 \u0432\u044b\u043f\u0430\u0434\u0430\u044e\u0449\u0435\u0433\u043e \u0441\u043f\u0438\u0441\u043a\u0430")
public class ListItemElement extends ooo.jtc.core.container.SContainer {
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDataAction() {
        return null;
    }
    
    public final boolean getDataDisabled() {
        return false;
    }
    
    public final boolean getDataActive() {
        return false;
    }
    
    public final boolean getDataSelected() {
        return false;
    }
    
    public ListItemElement(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement) {
        super(null, null);
    }
}