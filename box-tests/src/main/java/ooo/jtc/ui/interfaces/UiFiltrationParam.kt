package ooo.jtc.ui.interfaces

import ooo.jtc.core.elements.scroller.FilterForm
import ooo.jtc.core.elements.scroller.ScrollerRow
import ooo.jtc.interfaces.IDocument

/**
 * Интерфейс для формирования объектов для проверки фильтрации на UI.
 */
interface UiFiltrationParam<T : IDocument, F : FilterForm, SR : ScrollerRow> {

    /**
     * Наименование поля, по которому осуществляется фильтрация.
     * Используется преимущественно для читаемости отчета.
     */
    val fpName: String

    /**
     * Функция заполнения нужного поля(-ей) на форме фильтрации [F].
     * Данные для заполнения берем из dto [T].
     * Это позволяет заполнить на форме несколько полей.
     */
    val fillFilterFields: (filterForm: F, dto: T) -> Unit

    /**
     * Функция проверки фильтрации для искомого значения из строки.
     */
    val checkFilteredValue: (row: SR, dto: T) -> Unit

    fun rfText(row: SR, dataName: String): String {
        return row.getTextByDataName(dataName)
    }
}