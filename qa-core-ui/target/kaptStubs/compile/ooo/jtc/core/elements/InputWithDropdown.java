package ooo.jtc.core.elements;

import java.lang.System;

/**
 * Text field with dropdown selection
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Looo/jtc/core/elements/InputWithDropdown;", "Looo/jtc/core/elements/Input;", "Looo/jtc/core/elements/WithDropDownSelection;", "name", "", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "(Ljava/lang/String;Lcom/codeborne/selenide/SelenideElement;)V", "dataName", "getDataName", "()Ljava/lang/String;", "openOptions", "", "searchOption", "qa-core-ui"})
@ElementType(name = "\u0422\u0435\u043a\u0441\u0442\u043e\u0432\u043e\u0435 \u043f\u043e\u043b\u0435 \u0432\u0432\u043e\u0434\u0430")
public final class InputWithDropdown extends ooo.jtc.core.elements.Input implements ooo.jtc.core.elements.WithDropDownSelection {
    
    @java.lang.Override()
    public void openOptions(@org.jetbrains.annotations.NotNull()
    java.lang.String searchOption) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getDataName() {
        return null;
    }
    
    public InputWithDropdown(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement) {
        super(null, null);
    }
    
    public void closeOptions() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public ooo.jtc.core.elements.SelectBy getSelectBy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public ooo.jtc.core.elements.ListBoxOptions getOptions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<java.lang.String> getOptionsValues() {
        return null;
    }
    
    public void select(@org.jetbrains.annotations.NotNull()
    java.lang.String searchString) {
    }
}