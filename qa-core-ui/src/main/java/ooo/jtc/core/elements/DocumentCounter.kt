package ooo.jtc.core.elements

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.container.should
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.element
import ooo.jtc.core.selenide.attrSafe

@ElementType("Счетчик кол-ва документов")
class DocumentCounter(parentElement: SelenideElement, dataType: DocumentCounterType) :
    SContainer(sElement = parentElement.find("[role='documentcounter'][data-type='${dataType.name.toLowerCase()}']"), sName = "") {
    enum class DocumentCounterType {
        INFO,
        ERROR,
        SUCCESS,
        WARNING,
    }

    val counter get() = element("[role='note']").withTitle("Кол-во документов")

    fun getType(): DocumentCounterType {
        return DocumentCounterType.valueOf(this.attrSafe("data-type").toUpperCase())
    }

    @Step("Проверяем значение и текст счетчика документов")
    fun checkCounter(docCount: Int, docCounterText: String) {
        counter should Condition.exactText(docCount.toString())
        this should Condition.text(docCounterText)
    }
}