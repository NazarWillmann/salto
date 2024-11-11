package ooo.jtc.ui.common.sections.modals

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Condition.visible
import io.qameta.allure.Step
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.container.defaultDialogContext
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.element
import ooo.jtc.core.elements.AllElements.label
import ooo.jtc.core.elements.ElementType
import ooo.jtc.documents.ExecutionTicketDto
import ooo.jtc.extensions.DOTS_DATE_FORMAT
import ooo.jtc.extensions.string
import ooo.jtc.testdata.common.UiDateConverter.convertToUiDate
import org.openqa.selenium.By

@ElementType("Результат обработки в банке")
class ModalProcessingResult(var headerName: String) : SContainer(sElement = defaultDialogContext) {

    private val documentType get() = element(By.xpath(".//*[text()='$headerName']")).withTitle("Тип документа")
    private val documentNumberAndDate get() = label["documentNumberAndDate"].withTitle("№  и дата документа")
    private val status get() = label["status"].withTitle("Статус")

    private val executionDate get() = label["executionDate"].withTitle("Обработка документа")
    private val executionUserName get() = label["executionUserName"].withTitle("Отв. исполнитель")//.sibling(0) TODO A.Stykalin [08.09.2020] fix locator
    private val executionMessage get() = label["executionMessage"].withTitle("Сообщение об исполнении документа")

    @Step("Проверить, что данные на форме соответствуют ожидаемым")
    fun checkFormCorrect(expDto: ExecutionTicketDto, expStatus: String) {
        documentType.should(visible)
        documentNumberAndDate.should(text(expDto.documentNumber))
        val expDocDate = expDto.documentDate.string(DOTS_DATE_FORMAT)
        documentNumberAndDate.should(text(expDocDate))
        status.should(text(expStatus))

        val expExecutionDate = convertToUiDate(expDto.executionDate)
        executionDate.should(text(expExecutionDate))
        executionUserName.should(text(expDto.executionUserName))
        executionMessage.should(text(expDto.executionMessage))
    }
}