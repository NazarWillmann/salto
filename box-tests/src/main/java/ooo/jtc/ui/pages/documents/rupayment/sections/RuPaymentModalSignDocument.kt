package ooo.jtc.ui.pages.documents.rupayment.sections

import io.qameta.allure.Step
import ooo.jtc.rupayment.RuPaymentView
import ooo.jtc.ui.common.sections.modals.ModalSignDocument

class RuPaymentModalSignDocument : ModalSignDocument<RuPaymentView>() {

    @Step("Проверяем, что '{this.title}' открыта")
    override fun checkModalOpened(expDocCount: Int, expDocCounterText: String) {
        TODO("Not yet implemented")
    }

    @Step("Проверяем реквизиты документов в строках быстрого просмотра")
    override fun checkDocsPreview(expDocList: List<RuPaymentView>) {
        TODO("Not yet implemented")
    }
}