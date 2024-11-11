package ooo.jtc.ui.pages.documents.lettertobank.scroller

import ooo.jtc.core.elements.scroller.ScrollerCategory

//TODO A.Stykalin [23.07.2020] Продумать универсальный механизм связи BE<->UI категорий с универсальным получением списка статусов для категории.
enum class LetterToBankScrollerCategory(override val categoryName: String) : ScrollerCategory {
    ALL("Все"),
    DRAFTS("Черновики"),
    FOR_SIGNATURE("На подпись"),
    FOR_SEND("К отправке"),
    IN_PROCESSING("В обработке"),
    COMPLETED_CLIENT("Обработанные"),

    ON_RECEIVE("На приеме"),
    RECEIVED("Принятые"),
    COMPLETED_BANK("Завершенные"),
    PROBLEMATIC("Проблемные")
    ;

    override fun toString(): String {
        return this.categoryName
    }
}