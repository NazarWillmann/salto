package ooo.jtc.core.elements.scroller

import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.container.defaultContext
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.buttonDropdown
import ooo.jtc.core.elements.AllElements.checkbox
import ooo.jtc.core.elements.AllElements.element
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.SortDirButton
import org.openqa.selenium.By

@ElementType("Тулбар скроллера")
open class Toolbar(ctx: SelenideElement = defaultContext) : SContainer(sElement = ctx.find(By.xpath(".//*[@role='toolbar']"))) {

    val scrollerCheckbox get() = checkbox.withTitle("Выбрать все")

    val docCount
        get() = element(by = By.xpath("//div[text() = 'Найдено документов:']//following-sibling::div[last()]"))

    val sortBtn
        get() = buttonDropdown["sort"].withTitle("Сортировка")

    /**
     * Returns current for sort field value (as in DTO).
     * e.g. - `createdAt`
     */
    val sortFieldValue get() = sortBtn.attr("data-value")

    /**
     * Returns current for sort field text (as for User).
     * e.g. - `Дата/время создания`
     */
    val sortFieldText get() = sortBtn.innerText().substringAfterLast(delimiter = ":")

    val sortDirButton get() = SortDirButton(ctx = this)
}