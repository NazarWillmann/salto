package ooo.jtc.ui.common.sections.modals

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Condition.visible
import io.qameta.allure.Step
import ooo.jtc.core.container.should
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.label
import ooo.jtc.core.elements.AllElements.textArea
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.ModalWindow

@ElementType("Форма отзыва документа")
class ModalRecallDocument : ModalWindow() {
    companion object {
        const val UI_FIELD_NAME_RECALL_REASON = "«Причина отзыва документа»"
    }

    override val headerText: String = "Отзыв документа"
    val recallBtn get() = textButton["Отозвать"]
    val cancelBtn get() = textButton["Отменить"]

    private val docNumberAndDateInfo get() = label["documentNumberAndDate"]
    private val docStatus get() = label["status"]
    val recallReason get() = textArea["executionMessage"].withTitle("Причина отзыва")

    @Step("Проверить, что форма отзыва открылась и содержит данные документа")
    fun checkModalOpened(docNumber: String? = null, docDate: String? = null, docStatus: String? = null) {
        this.should(visible)
        this.checkHeader()
        this.checkDocNumberAndDateInfo(docNumber, docDate)
        this.checkDocStatus(docStatus)
    }

    @Step("Проверить, что в форме корректно указаны данные документа")
    fun checkDocNumberAndDateInfo(docNumber: String? = null, docDate: String? = null) {
        this.docNumberAndDateInfo should visible
        docNumber?.let { this.docNumberAndDateInfo should text(docNumber) }
        docDate?.let { this.docNumberAndDateInfo should text(docDate) }
    }

    @Step("Проверить, что в форме корректно указан статус документа")
    fun checkDocStatus(docStatus: String? = null) {
        this.docStatus should visible
        docStatus?.let { this.docStatus should text(docStatus) }
    }
}