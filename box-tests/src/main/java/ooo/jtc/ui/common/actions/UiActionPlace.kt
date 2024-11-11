package ooo.jtc.ui.common.actions

import ooo.jtc.core.elements.scroller.DocumentScrollerRow
import ooo.jtc.core.elements.scroller.ExpandedScrollerRow
import ooo.jtc.ui.common.pages.DocumentScrollerPage

/**
 * Перечисление выбора действия.
 * Используется для оптимизации тестов для проверки действий на скроллере из разных мест вызова.
 */
enum class UiActionPlace(
    val description: String
) {
    BY_ROW("меню строки"),
    BY_EXPAND_PANEL("панель быстрого просмотра"),
    BY_SINGLE_GROUP("одиночная операция"), //вызывается из общего меню на скроллере при выделении чекбокса строки
    ;

    fun <R : DocumentScrollerRow, S : DocumentScrollerPage<*, *, *, *>> makeAction(scrollerPage: S, row: R, action: String) {
        when (this) {
            BY_ROW -> row.makeActionByMoreMenu(action)
            BY_EXPAND_PANEL -> (row as ExpandedScrollerRow).makeActionByExpandPanel(action)
            BY_SINGLE_GROUP -> {
                if (!row.isSelected) row.checkBox.check()
                scrollerPage.makeAction(action)
            }
        }
    }
}