package ooo.jtc.core.elements;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Looo/jtc/core/elements/DropDown;", "Looo/jtc/core/container/SContainer;", "Looo/jtc/core/elements/WithDropDownSelection;", "dataName", "", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "(Ljava/lang/String;Lcom/codeborne/selenide/SelenideElement;)V", "getDataName", "()Ljava/lang/String;", "selectBy", "Looo/jtc/core/elements/SelectBy;", "getSelectBy", "()Looo/jtc/core/elements/SelectBy;", "openOptions", "", "searchOption", "qa-core-ui"})
@ElementType(name = "\u0412\u044b\u043f\u0430\u0434\u0430\u044e\u0449\u0438\u0439 \u0441\u043f\u0438\u0441\u043e\u043a")
public final class DropDown extends ooo.jtc.core.container.SContainer implements ooo.jtc.core.elements.WithDropDownSelection {
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.core.elements.SelectBy selectBy = ooo.jtc.core.elements.SelectBy.INNER_TEXT;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String dataName = null;
    
    /**
     * Для открытия выпадающего списка, необязательно передавать какое-либо значение.
     */
    public final void openOptions() {
    }
    
    @java.lang.Override()
    public void openOptions(@org.jetbrains.annotations.NotNull()
    java.lang.String searchOption) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.core.elements.SelectBy getSelectBy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getDataName() {
        return null;
    }
    
    public DropDown(@org.jetbrains.annotations.NotNull()
    java.lang.String dataName, @org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement) {
        super(null, null);
    }
    
    public void closeOptions() {
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