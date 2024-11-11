package ooo.jtc.ui.pages.documents.rupayment.scroller

import ooo.jtc.core.elements.scroller.ScrollerCategory

enum class RuPaymentScrollerCategory(override val categoryName: String) : ScrollerCategory {
    PAYMENTS("Платежи"),
    DRAFTS("Черновики"),
    FOR_SEND("К отправке"),
    FOR_SIGNATURE("На подпись"),
    IN_PROCESSING("В обработке"),
    COMPLETED("Обработанные"),
    ;
}