package ooo.jtc.core.elements;

import java.lang.System;

/**
 * Любое модальное окно.
 * По умолчанию имеет role="dialog".
 * В DOM'е не может быть одновременно 2 модальных окна.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0007R\u001b\u0010\u0005\u001a\u00020\u00018FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Looo/jtc/core/elements/ModalWindow;", "Looo/jtc/core/container/SContainer;", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "(Lcom/codeborne/selenide/SelenideElement;)V", "close", "getClose", "()Looo/jtc/core/container/SContainer;", "close$delegate", "Lkotlin/Lazy;", "header", "Looo/jtc/core/elements/ElementByText;", "getHeader", "()Looo/jtc/core/elements/ElementByText;", "headerText", "", "getHeaderText", "()Ljava/lang/String;", "checkHeader", "", "qa-core-ui"})
public abstract class ModalWindow extends ooo.jtc.core.container.SContainer {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy close$delegate = null;
    
    /**
     * Текст заголовка окна.
     * Используется для поиска элемента.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getHeaderText();
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.ElementByText getHeader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SContainer getClose() {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0437\u0430\u0433\u043e\u043b\u043e\u0432\u043e\u043a \u0444\u043e\u0440\u043c\u044b \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u0435\u0442\u0441\u044f")
    public final void checkHeader() {
    }
    
    public ModalWindow(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement) {
        super(null, null);
    }
    
    public ModalWindow() {
        super(null, null);
    }
}