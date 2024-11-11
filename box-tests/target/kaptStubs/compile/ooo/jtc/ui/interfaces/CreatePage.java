package ooo.jtc.ui.interfaces;

import java.lang.System;

/**
 * Интерфейс для страниц/форм создания документов.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\t"}, d2 = {"Looo/jtc/ui/interfaces/CreatePage;", "V", "Looo/jtc/interfaces/IEntityView;", "", "checkEditFromFilledCorrect", "", "view", "(Looo/jtc/interfaces/IEntityView;)V", "fill", "box-tests"})
public abstract interface CreatePage<V extends ooo.jtc.interfaces.IEntityView> {
    
    /**
     * Функция заполнения формы.
     */
    public abstract void fill(@org.jetbrains.annotations.NotNull()
    V view);
    
    /**
     * Функция проверки корректного заполнения формы.
     */
    public abstract void checkEditFromFilledCorrect(@org.jetbrains.annotations.NotNull()
    V view);
}