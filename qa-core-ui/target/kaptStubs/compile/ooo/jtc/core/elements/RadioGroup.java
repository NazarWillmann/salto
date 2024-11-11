package ooo.jtc.core.elements;

import java.lang.System;

/**
 * Radio group
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0007J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000eH\u0007R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\t\u00a8\u0006\u0015"}, d2 = {"Looo/jtc/core/elements/RadioGroup;", "Looo/jtc/core/container/SContainer;", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "(Lcom/codeborne/selenide/SelenideElement;)V", "items", "", "Looo/jtc/core/elements/RadioGroupItem;", "getItems", "()Ljava/util/List;", "selected", "getSelected", "()Looo/jtc/core/elements/RadioGroupItem;", "textItems", "", "getTextItems", "selectByDataValue", "", "dataValue", "selectByText", "itemText", "qa-core-ui"})
public final class RadioGroup extends ooo.jtc.core.container.SContainer {
    
    private final java.util.List<ooo.jtc.core.elements.RadioGroupItem> getItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTextItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.RadioGroupItem getSelected() {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u0412\u044b\u0431\u0440\u0430\u0442\u044c \u043e\u043f\u0446\u0438\u044e \'{itemText}")
    public final void selectByText(@org.jetbrains.annotations.NotNull()
    java.lang.String itemText) {
    }
    
    @io.qameta.allure.Step(value = "\u0412\u044b\u0431\u0440\u0430\u0442\u044c \u043e\u043f\u0446\u0438\u044e \'{dataValue}")
    public final void selectByDataValue(@org.jetbrains.annotations.NotNull()
    java.lang.String dataValue) {
    }
    
    public RadioGroup(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement) {
        super(null, null);
    }
}