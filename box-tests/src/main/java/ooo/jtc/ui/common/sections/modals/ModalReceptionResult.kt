package ooo.jtc.ui.common.sections.modals

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Condition.text
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.container.defaultDialogContext
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.element
import ooo.jtc.core.elements.AllElements.label
import ooo.jtc.core.elements.ElementType
import ooo.jtc.documents.ReceiveTicketDto
import ooo.jtc.extensions.DOTS_DATE_FORMAT
import ooo.jtc.extensions.string
import ooo.jtc.testdata.common.UiDateConverter
import org.openqa.selenium.By

@ElementType("Результат приема в банке")
class ModalReceptionResult(var headerName: String) : SContainer(sElement = defaultDialogContext) {

    private val documentType get() = element(By.xpath(".//*[text()='$headerName']")).withTitle("Тип документа")
    private val documentNumberAndDate get() = label["documentNumberAndDate"].withTitle("№  и дата документа")
    private val status get() = label["status"].withTitle("Статус")

    private val receiveDate get() = label["actionDate"].withTitle("Прием документа")
    private val receiveUserName get() = label["userName"].withTitle("Отв. исполнитель")
    private val receiveMessage get() = label["actionMessage"].withTitle("Сообщение о приеме документа")
    private val signCheckMessage get() = label["signCheckMessage"].withTitle("Результат проверки подписей")
    private val cpmString get() = label["cpmString"].withTitle("Результат проверки реквизитов")

    fun checkFormCorrect(expDto: ReceiveTicketDto, expStatus: String) {
        documentType.should(Condition.visible)
        documentNumberAndDate.should(text(expDto.documentNumber))
        val expDocDate = expDto.documentDate.string(DOTS_DATE_FORMAT)
        documentNumberAndDate.should(text(expDocDate))
        status.should(text(expStatus))

        val expReceiveDate = UiDateConverter.convertToUiDate(expDto.receiveDate!!)
        receiveDate.should(text(expReceiveDate))
        receiveUserName.should(text(expDto.receiveUserName!!))
        receiveMessage.should(text(expDto.receiveMessage!!))
        expDto.signCheckMessage?.let { signCheckMessage.should(text(it)) }
        expDto.cpmString?.let { cpmString.should(text(it)) }
    }
}