package ooo.jtc.core.container;

import java.lang.System;

/**
 * Интерфейс для сохранения контекста в разрезе [sElement].
 * Позволяет осуществлять поиск от текущего селенид-элемента [sElement], предоставляя контекст.
 * Т.е. для вложенного элемента, текущий элемент является контекстом.
 * Преимущественно используется для создания интерфейсов элементов (компонентов),
 * где [sElement] является контекстом (родителем) создаваемого элемента.
 * <p>
 * см. interface [ooo.jtc.core.elements.WithCheckBox].
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"Looo/jtc/core/container/SContext;", "", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "getSElement", "()Lcom/codeborne/selenide/SelenideElement;", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getContext", "qa-core-ui"})
public abstract interface SContext {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.codeborne.selenide.SelenideElement getSElement();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getTitle();
    
    public abstract void setTitle(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.codeborne.selenide.SelenideElement getContext();
    
    /**
     * Интерфейс для сохранения контекста в разрезе [sElement].
     * Позволяет осуществлять поиск от текущего селенид-элемента [sElement], предоставляя контекст.
     * Т.е. для вложенного элемента, текущий элемент является контекстом.
     * Преимущественно используется для создания интерфейсов элементов (компонентов),
     * где [sElement] является контекстом (родителем) создаваемого элемента.
     * <p>
     * см. interface [ooo.jtc.core.elements.WithCheckBox].
     */
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        public static com.codeborne.selenide.SelenideElement getContext(@org.jetbrains.annotations.NotNull()
        ooo.jtc.core.container.SContext $this) {
            return null;
        }
    }
}