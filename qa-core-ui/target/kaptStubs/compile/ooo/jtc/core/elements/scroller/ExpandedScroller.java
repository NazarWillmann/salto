package ooo.jtc.core.elements.scroller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ%\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0017\u00a2\u0006\u0002\u0010\u0015R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Looo/jtc/core/elements/scroller/ExpandedScroller;", "R", "Looo/jtc/core/elements/scroller/ExpandedScrollerRow;", "Looo/jtc/core/elements/scroller/DocumentScroller;", "rowClass", "Lkotlin/reflect/KClass;", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "(Lkotlin/reflect/KClass;Lcom/codeborne/selenide/SelenideElement;)V", "getRowClass", "()Lkotlin/reflect/KClass;", "setRowClass", "(Lkotlin/reflect/KClass;)V", "getSElement", "()Lcom/codeborne/selenide/SelenideElement;", "getValuesFromRows", "", "", "searchLocator", "limitRows", "", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/util/List;", "qa-core-ui"})
@ooo.jtc.core.elements.ElementType(name = "\u0421\u043a\u0440\u043e\u043b\u043b\u0435\u0440 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \u0441 \u0440\u0430\u0441\u043a\u0440\u044b\u0432\u0430\u044e\u0449\u0438\u043c\u0438\u0441\u044f \u0441\u0442\u0440\u043e\u043a\u0430\u043c\u0438")
public abstract class ExpandedScroller<R extends ooo.jtc.core.elements.scroller.ExpandedScrollerRow> extends ooo.jtc.core.elements.scroller.DocumentScroller<R> {
    @org.jetbrains.annotations.NotNull()
    private kotlin.reflect.KClass<R> rowClass;
    @org.jetbrains.annotations.NotNull()
    private final com.codeborne.selenide.SelenideElement sElement = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u044f \u0438\u0437 \u0441\u0442\u0440\u043e\u043a\u0438 \u043f\u043e \u043b\u043e\u043a\u0430\u0442\u043e\u0440\u0443 {searchLocator}")
    public java.util.List<java.lang.String> getValuesFromRows(@org.jetbrains.annotations.NotNull()
    java.lang.String searchLocator, @org.jetbrains.annotations.Nullable()
    java.lang.Integer limitRows) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.reflect.KClass<R> getRowClass() {
        return null;
    }
    
    @java.lang.Override()
    public void setRowClass(@org.jetbrains.annotations.NotNull()
    kotlin.reflect.KClass<R> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.codeborne.selenide.SelenideElement getSElement() {
        return null;
    }
    
    public ExpandedScroller(@org.jetbrains.annotations.NotNull()
    kotlin.reflect.KClass<R> rowClass, @org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement) {
        super(null, null, null);
    }
}