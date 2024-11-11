package ooo.jtc.ui.common.sections.modals

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.container.defaultDialogContext
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.element
import ooo.jtc.core.elements.AllElements.label
import ooo.jtc.core.elements.ElementType
import ooo.jtc.documents.SendTicketDto
import ooo.jtc.extensions.DOTS_DATE_FORMAT
import ooo.jtc.extensions.string
import ooo.jtc.testdata.common.UiDateConverter
import org.openqa.selenium.By

@ElementType("Результат обработки в банке")
class ModalSendingResult(var headerName: String) : SContainer(sElement = defaultDialogContext) {

    private val documentType get() = element(By.xpath(".//*[text()='$headerName']")).withTitle("Тип документа")
    private val documentNumberAndDate get() = label["documentNumberAndDate"].withTitle("№  и дата документа")
    private val status get() = label["status"].withTitle("Статус")

    private val sendDate get() = label["actionDate"].withTitle("Отправка документа")
    private val sendUserName get() = label["userName"].withTitle("Отв. исполнитель")
    private val sendMessage get() = label["actionMessage"].withTitle("Сообщение об исполнении документа")

    @Step("Проверить, что данные на форме соответствуют ожидаемым")
    fun checkFormCorrect(expDto: SendTicketDto, expStatus: String) {
        documentType.should(Condition.visible)
        documentNumberAndDate.should(Condition.text(expDto.documentNumber))
        val expDocDate = expDto.documentDate.string(DOTS_DATE_FORMAT)
        documentNumberAndDate.should(Condition.text(expDocDate))
        status.should(Condition.text(expStatus))

        val expSendDate = UiDateConverter.convertToUiDate(expDto.sendDate!!)
        sendDate.should(Condition.text(expSendDate))
        sendUserName.should(Condition.text(expDto.sendUserName!!))
        sendMessage.should(Condition.text(expDto.sendMessage!!))
    }
}