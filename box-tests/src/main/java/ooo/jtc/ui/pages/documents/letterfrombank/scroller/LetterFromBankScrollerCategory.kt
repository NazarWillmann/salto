package ooo.jtc.ui.pages.documents.letterfrombank.scroller

import ooo.jtc.core.elements.scroller.ScrollerCategory

//TODO Sergeyev (A.Stykalin) [23.07.2020] Продумать универсальный механизм связи
// BE<->UI категорий с универсальным получением списка статусов для категории.
enum class LetterFromBankScrollerCategory(override val categoryName: String) : ScrollerCategory {
    ALL("Все"),
    DRAFTS("Черновики"),
    FOR_SIGNATURE("На подпись"),
    FOR_SEND("К отправке"),
    DELIVERED("Отправлены"),
    PROBLEMATIC("Проблемные");

    override fun toString(): String {
        return this.categoryName
    }
}