package ooo.jtc.core.elements.scroller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\b\'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0015\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0017H\u0007\u00a2\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0007J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Looo/jtc/core/elements/scroller/DocumentScroller;", "R", "Looo/jtc/core/elements/scroller/DocumentScrollerRow;", "Looo/jtc/core/elements/scroller/Scroller;", "rowClass", "Lkotlin/reflect/KClass;", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "toolbar", "Looo/jtc/core/elements/scroller/Toolbar;", "(Lkotlin/reflect/KClass;Lcom/codeborne/selenide/SelenideElement;Looo/jtc/core/elements/scroller/Toolbar;)V", "getRowClass", "()Lkotlin/reflect/KClass;", "setRowClass", "(Lkotlin/reflect/KClass;)V", "getSElement", "()Lcom/codeborne/selenide/SelenideElement;", "getToolbar", "()Looo/jtc/core/elements/scroller/Toolbar;", "setToolbar", "(Looo/jtc/core/elements/scroller/Toolbar;)V", "getFirstInStatus", "status", "", "(Ljava/lang/String;)Looo/jtc/core/elements/scroller/DocumentScrollerRow;", "selectAll", "", "selectRows", "", "limitRows", "", "qa-core-ui"})
@ooo.jtc.core.elements.ElementType(name = "\u0421\u043a\u0440\u043e\u043b\u043b\u0435\u0440 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430")
public abstract class DocumentScroller<R extends ooo.jtc.core.elements.scroller.DocumentScrollerRow> extends ooo.jtc.core.elements.scroller.Scroller<R> {
    @org.jetbrains.annotations.NotNull()
    private kotlin.reflect.KClass<R> rowClass;
    @org.jetbrains.annotations.NotNull()
    private final com.codeborne.selenide.SelenideElement sElement = null;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.elements.scroller.Toolbar toolbar;
    
    /**
     * NB! на текущий момент [2020.10.01] если документов больше 50, выбираются только первые 50.
     */
    @io.qameta.allure.Step(value = "\u0412\u044b\u0431\u0440\u0430\u0442\u044c \u0432\u0441\u0435 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u044b \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u044f \u0447\u0435\u043a\u0431\u043e\u043a\u0441")
    public final void selectAll() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u043f\u0435\u0440\u0432\u044b\u0439 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \u0432 \u0441\u0442\u0430\u0442\u0443\u0441\u0435 \'{status}\'")
    public final R getFirstInStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String status) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0412\u044b\u0431\u0440\u0430\u0442\u044c \u0441\u0442\u0440\u043e\u043a\u0438 \u043d\u0430 \u0441\u043a\u0440\u043e\u043b\u043b\u0435\u0440\u0435")
    public final java.util.List<R> selectRows(int limitRows) {
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
    
    @org.jetbrains.annotations.NotNull()
    public ooo.jtc.core.elements.scroller.Toolbar getToolbar() {
        return null;
    }
    
    public void setToolbar(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.elements.scroller.Toolbar p0) {
    }
    
    public DocumentScroller(@org.jetbrains.annotations.NotNull()
    kotlin.reflect.KClass<R> rowClass, @org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.elements.scroller.Toolbar toolbar) {
        super(null, null);
    }
}