package ooo.jtc.ui.common.pages

import com.codeborne.selenide.Condition.exactTextCaseSensitive
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selectors.ByText
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.core.container.wait
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.asContainer
import ooo.jtc.core.elements.AllElements.element
import ooo.jtc.core.elements.AllElements.elementByText
import ooo.jtc.core.elements.AllElements.input
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.Button
import ooo.jtc.core.elements.Favorite
import org.openqa.selenium.By.xpath


/**
 * Abstract page for creating a document entity.
 */
abstract class DocumentPage(
    endpoint: String, pageType: ApplicationPageType,
    sElement: SelenideElement = Selenide.element("[role='drawer']")
) : ApplicationPage(pageType = pageType, endpoint = endpoint, sElement = sElement) {
    open var headerName: String = ""

    val header
        get() = element(xpath(".//*[text()='${this.headerName}']"))
            .withTitle("Заголовок формы")

    val status get() = element("[role='status']").withTitle("Статус")

    val isFavorite
        get() = Favorite(sElement = find("[data-name='isFavorites']")).withTitle("звездочка Избранное на форме")

    val documentNumber get() = input["documentNumber"].withTitle("№ документа")

    //TODO A.Stykalin [02.09.2020] для editDocumentNumber поменять локатор, когда добавят на FE
    val editDocumentNumber get() = Button(find(xpath("(.//div[@role='button' and .=''])[1]/*"))).withTitle("Редактировать номер документа")
    val documentDate get() = input["documentDate"].withTitle("Дата документа")

    val documentNumberAndDate get() = header.sibling(0).asContainer("Номер документа и Дата документа")

    override fun waitLoading() {
        save.apply { timeout = 10000L } wait visible
    }

    val save get() = textButton["Сохранить"]
    val decline get() = textButton["Отмена"]
    val back get() = textButton["Назад"]

    @Step("Проверить, что Заголовок документа соответствует '{this.headerName}'")
    fun checkHeader(expHeaderName: String? = null) {
        expHeaderName?.let { this.headerName = expHeaderName }
        header.shouldBe(visible)
    }

    @Step("Проверить, что номер документа соответствует '{expDocNumber}'")
    fun checkDocumentNumber(expDocNumber: String) {
        documentNumberAndDate.should(text(expDocNumber))
    }

    @Step("Проверить отображающиеся вкладки {visibleTabs}")
    fun checkVisibleTabs(vararg visibleTabs: DocumentPageTabs) {
        visibleTabs.forEach {
            element(ByText(it.tabName)).shouldBe(visible)
        }
    }

    @Step("Проверить, что статус документа '{expStatus}'")
    fun checkStatus(expStatus: String) {
        status.should(exactTextCaseSensitive(expStatus))
    }

    @Step("Выбрать действие '{action}'")
    fun makeAction(action: String) {
        if (textButton[action].isDisplayed) {
            textButton[action].click()
        } else {
            element("[data-action='more']").withTitle("Кнопка Еще").click()
            elementByText[action].shouldBe(visible).click()
        }
    }
}

