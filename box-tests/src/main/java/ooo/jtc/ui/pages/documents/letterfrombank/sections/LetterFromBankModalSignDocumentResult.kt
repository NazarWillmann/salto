package ooo.jtc.ui.pages.documents.letterfrombank.sections

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Condition.exactTextCaseSensitive
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.container.should
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.label
import ooo.jtc.core.elements.AllElements.listElements
import ooo.jtc.core.elements.Button
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.Row
import ooo.jtc.core.elements.WithPanel
import ooo.jtc.extensions.getOrException
import ooo.jtc.letters.LetterFromBankView
import ooo.jtc.ui.common.sections.modals.ModalSignDocumentResult

@ElementType("Форма 'Результат подписи'")
class LetterFromBankModalSignDocumentResult : ModalSignDocumentResult<LetterFromBankView>() {

    override val sendBtn: Button get() = TODO("Not present at the form")

    @Step("Проверяем, что '{this.title}' открыта")
    override fun checkModalOpened() {
        header should Condition.visible
        docCounterSuccess should Condition.visible
        docCounterError should Condition.visible
        closeBtn should Condition.enabled
    }

    @Step("Проверяем реквизиты документов в строках быстрого просмотра")
    override fun checkDocsPreview(expDocList: List<LetterFromBankView>) {
        expDocList.forEach { view ->
            val actDetails = previewDetails.find { it.id == view.id!!.toString() }
                .getOrException("Не найдено строки с data-id '${view.id}'")
            actDetails.checkDocRequisites(view)
        }
    }

    inner class LfbSignDetailsRow(sElement: SelenideElement) : SContainer(sElement = sElement), Row, WithPanel {
        private val documentNumberAndDate get() = label["documentNumberAndDate"].withTitle("Номер документа и Дата документа")
        private val docTypeDescription get() = label["docTypeDescription"].withTitle("Описание типа письма в банк")
        val docTheme get() = label["docTheme"].withTitle("Тема письма")
        val status get() = label["status"].withTitle("Статус")

        @Step("Проверяем реквизиты для документа ({view.id})")
        fun checkDocRequisites(view: LetterFromBankView) {
            documentNumberAndDate should text(view.documentNumber)
            documentNumberAndDate should text(view.documentDate)
            docTypeDescription should exactTextCaseSensitive(view.docTypeDescription)
            docTheme should exactTextCaseSensitive(view.docTheme)
            status should exactTextCaseSensitive(view.statusClient)
        }

    }

    private val previewDetails: List<LfbSignDetailsRow> get() = listElements("[role='row']") { LfbSignDetailsRow((it)) }
}