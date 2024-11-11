package ooo.jtc.core.elements;

import java.lang.System;

/**
 * Интерфейс добавляющий взаимодействие с выпадающим списком опций для поля элемента.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0003H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Looo/jtc/core/elements/WithDropDownSelection;", "Looo/jtc/core/container/SContext;", "dataName", "", "getDataName", "()Ljava/lang/String;", "options", "Looo/jtc/core/elements/ListBoxOptions;", "getOptions", "()Looo/jtc/core/elements/ListBoxOptions;", "optionsValues", "", "getOptionsValues", "()Ljava/util/List;", "selectBy", "Looo/jtc/core/elements/SelectBy;", "getSelectBy", "()Looo/jtc/core/elements/SelectBy;", "closeOptions", "", "openOptions", "searchOption", "select", "searchString", "qa-core-ui"})
public abstract interface WithDropDownSelection extends ooo.jtc.core.container.SContext {
    
    /**
     * Функция, которая "раскрывает"/показывает список опций дропдауна.
     * @param searchOption искомое значение в поле. используется для инпутов,
     * когда нужно ввести какую-то часть слова, чтобы сработал быстрый поиск.
     */
    public abstract void openOptions(@org.jetbrains.annotations.NotNull()
    java.lang.String searchOption);
    
    public abstract void closeOptions();
    
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.core.elements.SelectBy getSelectBy();
    
    /**
     * data-name атрибут, для поиска опций выпадающего списка.
     * Должен совпадать с атрибутом name основного поля.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getDataName();
    
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.core.elements.ListBoxOptions getOptions();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<java.lang.String> getOptionsValues();
    
    public abstract void select(@org.jetbrains.annotations.NotNull()
    java.lang.String searchString);
    
    /**
     * Интерфейс добавляющий взаимодействие с выпадающим списком опций для поля элемента.
     */
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        public static void closeOptions(@org.jetbrains.annotations.NotNull()
        ooo.jtc.core.elements.WithDropDownSelection $this) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static ooo.jtc.core.elements.SelectBy getSelectBy(@org.jetbrains.annotations.NotNull()
        ooo.jtc.core.elements.WithDropDownSelection $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static ooo.jtc.core.elements.ListBoxOptions getOptions(@org.jetbrains.annotations.NotNull()
        ooo.jtc.core.elements.WithDropDownSelection $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static java.util.List<java.lang.String> getOptionsValues(@org.jetbrains.annotations.NotNull()
        ooo.jtc.core.elements.WithDropDownSelection $this) {
            return null;
        }
        
        public static void select(@org.jetbrains.annotations.NotNull()
        ooo.jtc.core.elements.WithDropDownSelection $this, @org.jetbrains.annotations.NotNull()
        java.lang.String searchString) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static com.codeborne.selenide.SelenideElement getContext(@org.jetbrains.annotations.NotNull()
        ooo.jtc.core.elements.WithDropDownSelection $this) {
            return null;
        }
    }
}