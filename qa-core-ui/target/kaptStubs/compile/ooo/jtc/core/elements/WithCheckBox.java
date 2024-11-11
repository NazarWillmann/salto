package ooo.jtc.core.elements;

import java.lang.System;

/**
 * Интерфейс добавляет чекбокс к элементу реализующему этот интерфейс.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Looo/jtc/core/elements/WithCheckBox;", "Looo/jtc/core/container/SContext;", "checkBox", "Looo/jtc/core/elements/CheckBox;", "getCheckBox", "()Looo/jtc/core/elements/CheckBox;", "qa-core-ui"})
public abstract interface WithCheckBox extends ooo.jtc.core.container.SContext {
    
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.core.elements.CheckBox getCheckBox();
    
    /**
     * Интерфейс добавляет чекбокс к элементу реализующему этот интерфейс.
     */
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        public static ooo.jtc.core.elements.CheckBox getCheckBox(@org.jetbrains.annotations.NotNull()
        ooo.jtc.core.elements.WithCheckBox $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static com.codeborne.selenide.SelenideElement getContext(@org.jetbrains.annotations.NotNull()
        ooo.jtc.core.elements.WithCheckBox $this) {
            return null;
        }
    }
}