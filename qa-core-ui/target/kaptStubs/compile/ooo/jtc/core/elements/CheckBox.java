package ooo.jtc.core.elements;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\tH\u0007R\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Looo/jtc/core/elements/CheckBox;", "Looo/jtc/core/container/SContainer;", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "(Lcom/codeborne/selenide/SelenideElement;)V", "isChecked", "", "()Z", "check", "", "unCheck", "qa-core-ui"})
@ElementType(name = "\u0427\u0435\u043a\u0431\u043e\u043a\u0441")
public final class CheckBox extends ooo.jtc.core.container.SContainer {
    
    public final boolean isChecked() {
        return false;
    }
    
    @io.qameta.allure.Step(value = "\u041e\u0442\u043c\u0435\u0442\u0438\u0442\u044c \u0447\u0435\u043a\u0431\u043e\u043a\u0441 \'{this.title}\'")
    public final void check() {
    }
    
    @io.qameta.allure.Step(value = "\u0421\u043d\u044f\u0442\u044c \u043e\u0442\u043c\u0435\u0442\u043a\u0443 \u0441 \u0447\u0435\u043a\u0431\u043e\u043a\u0441\u0430 \'{this.title}\'")
    public final void unCheck() {
    }
    
    public CheckBox(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement) {
        super(null, null);
    }
}