package ooo.jtc.ui.common.pages

import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.element
import ooo.jtc.core.elements.SidebarMenu
import ooo.jtc.core.elements.scroller.Scroller
import org.openqa.selenium.By

abstract class ScrollerPage<S : Scroller<*>>(
    endpoint: String,
    pageType: ApplicationPageType,
    sElement: SelenideElement
) : ApplicationPage(endpoint = endpoint, pageType = pageType, sElement = sElement) {
    abstract val scroller: S
    val sidebarMenu get() = SidebarMenu()

    //TODO A.Stykalin [18.09.2020] change loader selector when it will added in FE
    val loader get() = SContainer(sName = "Лоадер", sElement = find(By.xpath(".//*[@role and ./*[@role]/following-sibling::div[@role]]")))

    @Step("Выбрать действие '{action}'")
    open fun makeAction(action: String) = element(By.xpath(".//button[@data-action and text()='$action']")).withTitle(action).click()
}
