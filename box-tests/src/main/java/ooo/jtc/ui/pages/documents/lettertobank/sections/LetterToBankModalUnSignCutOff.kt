package ooo.jtc.ui.pages.documents.lettertobank.sections

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
import ooo.jtc.letters.LetterToBankView
import ooo.jtc.ui.common.sections.modals.ModalUnSignCutOffDocument

@ElementType("Диалоговое окно 'Снять подпись' (отсечка)")
class LetterToBankModalUnSignCutOff : ModalUnSignCutOffDocument<LetterToBankView>() {

    override val sendBtn: Button get() = TODO("Not present at the form")

    @Step("Проверяем, что '{this.title}' открыта")
    override fun checkModalOpened() {
        header should Condition.visible
        docCounterSuccess should Condition.visible
        docCounterError should Condition.visible
        closeBtn should Condition.enabled
    }

    @Step("Проверяем реквизиты документов в строках быстрого просмотра")
    override fun checkDocsPreview(expDocList: List<LetterToBankView>) {
        expDocList.forEach { view ->
            val actDetails = previewDetails.find { it.id == view.id!!.toString() }
                .getOrException("Не найдено строки с data-id '${view.id}'")
            actDetails.checkDocRequisites(view)
        }
    }

    inner class LtbSignDetailsRow(sElement: SelenideElement) : SContainer(sElement = sElement), Row, WithPanel {
        private val documentNumberAndDate get() = label["documentNumberAndDate"].withTitle("Номер документа и Дата документа")
        private val docTypeDescription get() = label["docTypeDescription"].withTitle("Описание типа письма в банк")
        val docTheme get() = label["docTheme"].withTitle("Тема письма")
        val status get() = label["status"].withTitle("Статус")

        @Step("Проверяем реквизиты для документа ({view.id})")
        fun checkDocRequisites(view: LetterToBankView) {
            documentNumberAndDate should text(view.documentNumber)
            documentNumberAndDate should text(view.documentDate)
            docTypeDescription should exactTextCaseSensitive(view.docTypeDescription)
            docTheme should exactTextCaseSensitive(view.docTheme)
            status should exactTextCaseSensitive(view.statusClient)
        }

    }

    //TODO A.Stykalin [28.10.2020] форма будет меняться - добавят отображение документов, для которых возможно снять подпись.
    // сейчас нет атрибутов для строк. проверить (попросить добавить), когда внесут изменения в форму
    private val previewDetails: List<LtbSignDetailsRow> get() = listElements("[role='row']") { LtbSignDetailsRow((it)) }
}