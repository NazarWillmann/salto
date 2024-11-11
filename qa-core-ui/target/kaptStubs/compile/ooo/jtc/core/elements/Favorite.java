package ooo.jtc.core.elements;

import java.lang.System;

/**
 * Элемент управления Избранное.
 * Представляет одновременно и общую кнопку 'Избранное' в топе на скроллере,
 * и кнопку-звезддочку в строке скроллера.
 * Взаимодействие происходит на основе контекста от которого ищется этот элемент.
 * Элемент добавляется через добавление интерфейса [WithFavoriteStar] к компоненту приложения.
 * e.g. - [ooo.jtc.ui.common.pages.DocumentScrollerPage]
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\tH\u0007J\b\u0010\u000b\u001a\u00020\tH\u0007J\b\u0010\f\u001a\u00020\tH\u0007R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007\u00a8\u0006\r"}, d2 = {"Looo/jtc/core/elements/Favorite;", "Looo/jtc/core/container/SContainer;", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "(Lcom/codeborne/selenide/SelenideElement;)V", "isFavorite", "", "()Z", "checkIsMarked", "", "checkNotMarked", "mark", "unMark", "qa-core-ui"})
public final class Favorite extends ooo.jtc.core.container.SContainer {
    
    private final boolean isFavorite() {
        return false;
    }
    
    @io.qameta.allure.Step(value = "\u041e\u0442\u043c\u0435\u0442\u0438\u0442\u044c {this.sName}")
    public final void mark() {
    }
    
    @io.qameta.allure.Step(value = "\u0421\u043d\u044f\u0442\u044c \u043e\u0442\u043c\u0435\u0442\u043a\u0443 \u0441 {this.sName}")
    public final void unMark() {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u044d\u043b\u0435\u043c\u0435\u043d\u0442 \u0443\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u044f \u0418\u0437\u0431\u0440\u0430\u043d\u043d\u044b\u043c \u0432\u044b\u0434\u0435\u043b\u0435\u043d")
    public final void checkIsMarked() {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u044d\u043b\u0435\u043c\u0435\u043d\u0442 \u0443\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u0438\u044f \u0418\u0437\u0431\u0440\u0430\u043d\u043d\u044b\u043c \u043d\u0435 \u0432\u044b\u0434\u0435\u043b\u0435\u043d")
    public final void checkNotMarked() {
    }
    
    public Favorite(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement) {
        super(null, null);
    }
}