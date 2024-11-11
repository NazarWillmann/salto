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

@ElementType("Форма обработки документа")
class ModalProcessDocument : ModalWindow() {
    companion object {
        const val UI_FIELD_NAME_PROCESS_RESULT = "«Сообщение об обработке документа»"
    }

    override val headerText: String = "Обработка документа"
    val processBtn get() = textButton["Обработать"]
    val cancelBtn get() = textButton["Отменить"]

    private val docNumberAndDateInfo get() = label["documentNumberAndDate"]
    private val docStatus get() = label["status"]
    val processResult get() = textArea["executionMessage"].withTitle("Результат обработки")

    @Step("Проверить, что форма обработки открылась и содержит данные документа")
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