package ooo.jtc.ui.pages.documents.letterfrombank.sections

import com.codeborne.selenide.CollectionCondition
import com.codeborne.selenide.Condition.enabled
import com.codeborne.selenide.Condition.exactTextCaseSensitive
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.container.should
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.label
import ooo.jtc.core.elements.AllElements.listElements
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.Row
import ooo.jtc.core.elements.WithPanel
import ooo.jtc.extensions.getOrException
import ooo.jtc.letters.LetterFromBankView
import ooo.jtc.ui.common.sections.modals.ModalSignDocument

@ElementType("Форма 'Подписать'")
class LetterFromBankModalSignDocument : ModalSignDocument<LetterFromBankView>() {

    inner class LfbSignDetailsRow(sElement: SelenideElement) : SContainer(sElement = sElement), Row, WithPanel {
        //Data details at panel
        inner class DocRequisites(sElement: SelenideElement) : SContainer(sElement = sElement) {
            val documentNumber get() = label["documentNumber"].withTitle("№ документа")
            val documentDate get() = label["documentDate"].withTitle("Дата документа")
            val docType get() = label["docType"].withTitle("Тип письма")
            val customerName get() = label["customerName"].withTitle("Получатель")
            val branchName get() = label["branchName"].withTitle("Отправитель")
            val docTheme get() = label["docTheme"].withTitle("Тема")
            val docText get() = label["docText"].withTitle("Текст")

            val contactName get() = label["contactName"].withTitle("ФИО")
            val contactPhone get() = label["contactPhone"].withTitle("Телефон")
            val attachmentsNames get() = this.findAll("[data-field^='attachments']")
        }

        private val documentNumberAndDate get() = label["documentNumberAndDate"].withTitle("Номер документа и Дата документа")
        private val docTypeDescription get() = label["docTypeDescription"].withTitle("Описание типа письма из банка")
        val docTheme get() = label["docTheme"].withTitle("Тема письма")
        val status get() = label["status"].withTitle("Статус")

        private val docRequisites: DocRequisites get() = DocRequisites(sElement = onPanel)

        @Step("Проверяем реквизиты для документа ({view.id})")
        fun checkDocRequisites(view: LetterFromBankView) {
            documentNumberAndDate should text(view.documentNumber)
            documentNumberAndDate should text(view.documentDate)
            docTypeDescription should exactTextCaseSensitive(view.docTypeDescription)
            docTheme should exactTextCaseSensitive(view.docTheme)
            status should exactTextCaseSensitive(view.statusClient)
            expand()
            docRequisites.documentNumber should exactTextCaseSensitive(view.documentNumber)
            docRequisites.documentDate should exactTextCaseSensitive(view.documentDate)
            docRequisites.docType should text(view.docType)
            docRequisites.docType should text(view.docTypeDescription)
            docRequisites.customerName should exactTextCaseSensitive(view.customerName)
            docRequisites.branchName should exactTextCaseSensitive(view.branchName)
            docRequisites.docTheme should exactTextCaseSensitive(view.docTheme)
            docRequisites.docText should exactTextCaseSensitive(view.docText)

            view.attachmentFiles?.forEach { attachFile ->
                docRequisites.attachmentsNames.shouldHave(CollectionCondition.texts(attachFile.name))
            }
        }

    }

    private val previewDetails: List<LfbSignDetailsRow> get() = listElements("[role='row']") { LfbSignDetailsRow((it)) }

    @Step("Проверяем, что '{this.title}' открыта")
    override fun checkModalOpened(expDocCount: Int, expDocCounterText: String) {
        docCounter.checkCounter(expDocCount, expDocCounterText)
        signBtn should enabled
        cancelBtn should enabled
    }

    @Step("Проверяем реквизиты документов в строках быстрого просмотра")
    override fun checkDocsPreview(expDocList: List<LetterFromBankView>) {
        expDocList.forEach { view ->
            val actDetails = previewDetails.find { it.id == view.id!!.toString() }
                .getOrException("Не найдено строки с data-id '${view.id}'")
            actDetails.checkDocRequisites(view)
        }
    }
}