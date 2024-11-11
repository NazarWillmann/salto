package ooo.jtc.core.elements;

import java.lang.System;

/**
 * Список всех доступных элементов с короткой инициализацией (input["payerName"]) на странице.
 * Все элементы из [AllElements] ищутся в контексте содержащего их элемента/страницы.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010/\u001a\u00020-*\u00020\u00062\b\b\u0002\u00100\u001a\u000201J\u0012\u00102\u001a\u00020-*\u00020\u00062\u0006\u00103\u001a\u000201J\u0012\u00102\u001a\u00020-*\u00020\u00062\u0006\u00104\u001a\u000205J6\u00106\u001a\b\u0012\u0004\u0012\u0002H807\"\b\b\u0000\u00108*\u00020-*\u00020\u00062\u0006\u00103\u001a\u0002012\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H80:J6\u0010;\u001a\b\u0012\u0004\u0012\u0002H807\"\b\b\u0000\u00108*\u00020-*\u00020\u00062\u0006\u0010<\u001a\u0002012\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H80:R\u001b\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u0015\u0010\f\u001a\u00020\r*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0004*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\bR\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\bR\u001b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\bR\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\bR\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0004*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\bR\u001b\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0004*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b \u0010\bR\u001b\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0004*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\bR\u001b\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0004*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\bR\u001b\u0010\'\u001a\b\u0012\u0004\u0012\u00020(0\u0004*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b)\u0010\bR\u001b\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b+\u0010\bR\u001b\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0004*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b.\u0010\b\u00a8\u0006="}, d2 = {"Looo/jtc/core/elements/AllElements;", "", "()V", "buttonByName", "Looo/jtc/core/container/SElementGet;", "Looo/jtc/core/elements/Button;", "Lcom/codeborne/selenide/SelenideElement;", "getButtonByName", "(Lcom/codeborne/selenide/SelenideElement;)Looo/jtc/core/container/SElementGet;", "buttonDropdown", "Looo/jtc/core/elements/ButtonWithDropdown;", "getButtonDropdown", "checkbox", "Looo/jtc/core/elements/CheckBox;", "getCheckbox", "(Lcom/codeborne/selenide/SelenideElement;)Looo/jtc/core/elements/CheckBox;", "checkboxByText", "getCheckboxByText", "dropdown", "Looo/jtc/core/elements/DropDown;", "getDropdown", "elementByText", "Looo/jtc/core/elements/ElementByText;", "getElementByText", "input", "Looo/jtc/core/elements/Input;", "getInput", "inputDropdown", "Looo/jtc/core/elements/InputWithDropdown;", "getInputDropdown", "label", "Looo/jtc/core/elements/Label;", "getLabel", "radioGroupByDataName", "Looo/jtc/core/elements/RadioGroup;", "getRadioGroupByDataName", "textArea", "Looo/jtc/core/elements/TextArea;", "getTextArea", "textAreaDropdown", "Looo/jtc/core/elements/TextAreaWithDropdown;", "getTextAreaDropdown", "textButton", "getTextButton", "tooltip", "Looo/jtc/core/container/SContainer;", "getTooltip", "asContainer", "title", "", "element", "cssSelector", "by", "Lorg/openqa/selenium/By;", "listElements", "", "T", "mapper", "Lkotlin/Function1;", "listElementsX", "xPath", "qa-core-ui"})
public final class AllElements {
    public static final ooo.jtc.core.elements.AllElements INSTANCE = null;
    
    /**
     * Возможность создавать список [SContainer]-элементов.
     * @param cssSelector - селектор для поиска списка элементов
     * @param mapper - функция преобразования [SelenideElement] в [SContainer]-элемент [T]
     * e.g. ```val items: List<MenuItem> get() = listElements("button[role='menuitem']") { MenuItem(it).withTitle(text) }```
     */
    @org.jetbrains.annotations.NotNull()
    public final <T extends ooo.jtc.core.container.SContainer>java.util.List<T> listElements(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$listElements, @org.jetbrains.annotations.NotNull()
    java.lang.String cssSelector, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.codeborne.selenide.SelenideElement, ? extends T> mapper) {
        return null;
    }
    
    /**
     * Возможность создавать список [SContainer]-элементов.
     * @param xPath - селектор для поиска списка элементов
     * @param mapper - функция преобразования [SelenideElement] в [SContainer]-элемент [T]
     * e.g. ```val attachments: List<SAttachment> get() = listElementsX(".//div[contains(@data-name,'attachments') and @role]") { SAttachment(sElement = it) }```
     */
    @org.jetbrains.annotations.NotNull()
    public final <T extends ooo.jtc.core.container.SContainer>java.util.List<T> listElementsX(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$listElementsX, @org.jetbrains.annotations.NotNull()
    java.lang.String xPath, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.codeborne.selenide.SelenideElement, ? extends T> mapper) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SElementGet<ooo.jtc.core.elements.Button> getTextButton(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$textButton) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SElementGet<ooo.jtc.core.elements.Button> getButtonByName(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$buttonByName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SElementGet<ooo.jtc.core.elements.ButtonWithDropdown> getButtonDropdown(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$buttonDropdown) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SElementGet<ooo.jtc.core.elements.Input> getInput(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$input) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SElementGet<ooo.jtc.core.elements.InputWithDropdown> getInputDropdown(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$inputDropdown) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SElementGet<ooo.jtc.core.elements.TextArea> getTextArea(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$textArea) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SElementGet<ooo.jtc.core.elements.TextAreaWithDropdown> getTextAreaDropdown(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$textAreaDropdown) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SElementGet<ooo.jtc.core.elements.DropDown> getDropdown(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$dropdown) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SElementGet<ooo.jtc.core.elements.ElementByText> getElementByText(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$elementByText) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SElementGet<ooo.jtc.core.elements.Label> getLabel(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$label) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.CheckBox getCheckbox(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$checkbox) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SElementGet<ooo.jtc.core.elements.CheckBox> getCheckboxByText(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$checkboxByText) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SElementGet<ooo.jtc.core.container.SContainer> getTooltip(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$tooltip) {
        return null;
    }
    
    /**
     * Элемент.
     * Инициализируется по [By].
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SContainer element(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$element, @org.jetbrains.annotations.NotNull()
    org.openqa.selenium.By by) {
        return null;
    }
    
    /**
     * Элемент.
     * Инициализируется по [cssSelector].
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SContainer element(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$element, @org.jetbrains.annotations.NotNull()
    java.lang.String cssSelector) {
        return null;
    }
    
    /**
     * Элемент.
     * Инициализируется по [SelenideElement].
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SContainer asContainer(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$asContainer, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SElementGet<ooo.jtc.core.elements.RadioGroup> getRadioGroupByDataName(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement $this$radioGroupByDataName) {
        return null;
    }
    
    private AllElements() {
        super();
    }
}