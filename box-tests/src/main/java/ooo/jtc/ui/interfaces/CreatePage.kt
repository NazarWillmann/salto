package ooo.jtc.ui.interfaces

import ooo.jtc.interfaces.IEntityView

/**
 * Интерфейс для страниц/форм создания документов.
 */
interface CreatePage<V : IEntityView> {
    /**
     * Функция заполнения формы.
     */
    fun fill(view: V)

    /**
     * Функция проверки корректного заполнения формы.
     */
    fun checkEditFromFilledCorrect(view: V)
}