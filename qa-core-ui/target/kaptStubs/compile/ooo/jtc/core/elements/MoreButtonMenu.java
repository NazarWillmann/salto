package ooo.jtc.core.elements;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0000H\u0007J%\u0010\u0013\u001a\u00020\f2\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000f0\u0014\"\u0004\u0018\u00010\u000fH\u0016\u00a2\u0006\u0002\u0010\u0015J\u0014\u0010\u0013\u001a\u00020\f2\n\u0010\u0016\u001a\u00020\u0017\"\u00020\u0018H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0019"}, d2 = {"Looo/jtc/core/elements/MoreButtonMenu;", "Looo/jtc/core/elements/ContextMenu;", "rowElement", "Lcom/codeborne/selenide/SelenideElement;", "(Lcom/codeborne/selenide/SelenideElement;)V", "moreButton", "Looo/jtc/core/elements/MoreButton;", "getMoreButton", "()Looo/jtc/core/elements/MoreButton;", "getRowElement", "()Lcom/codeborne/selenide/SelenideElement;", "click", "", "clickByOption", "optionName", "", "getAvailableActions", "", "openMoreMenu", "selectOption", "", "([Ljava/lang/String;)V", "optionNum", "", "", "qa-core-ui"})
@ElementType(name = "\u041a\u043d\u043e\u043f\u043a\u0430 \'\u0415\u0449\u0451\' \u0441 \u043a\u043e\u043d\u0442\u0435\u043a\u0441\u0442\u043d\u044b\u043c \u043c\u0435\u043d\u044e")
public final class MoreButtonMenu extends ooo.jtc.core.elements.ContextMenu {
    @org.jetbrains.annotations.NotNull()
    private final com.codeborne.selenide.SelenideElement rowElement = null;
    
    private final ooo.jtc.core.elements.MoreButton getMoreButton() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041e\u0442\u043a\u0440\u044b\u0442\u044c \u043a\u043e\u043d\u0442\u0435\u043a\u0441\u0442\u043d\u043e\u0435 \u043c\u0435\u043d\u044e")
    public final ooo.jtc.core.elements.MoreButtonMenu openMoreMenu() {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u0412\u044b\u0431\u0440\u0430\u0442\u044c \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435 \'{optionName}\' \u0432 \u043a\u043e\u043d\u0442\u0435\u043a\u0441\u0442\u043d\u043e\u043c \u043c\u0435\u043d\u044e \'...\'")
    public final void clickByOption(@org.jetbrains.annotations.NotNull()
    java.lang.String optionName) {
    }
    
    @java.lang.Override()
    public void selectOption(@org.jetbrains.annotations.NotNull()
    java.lang.String... optionName) {
    }
    
    @java.lang.Override()
    public void selectOption(@org.jetbrains.annotations.NotNull()
    int... optionNum) {
    }
    
    /**
     * Сокращение и оверрайд стандартного клика для избегания путаницы.
     */
    @java.lang.Override()
    public void click() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u043f\u0438\u0441\u043e\u043a \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0445 \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0439 \u0434\u043b\u044f \u0441\u0442\u0440\u043e\u043a\u0438")
    public final java.util.List<java.lang.String> getAvailableActions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.codeborne.selenide.SelenideElement getRowElement() {
        return null;
    }
    
    public MoreButtonMenu(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement rowElement) {
        super();
    }
}