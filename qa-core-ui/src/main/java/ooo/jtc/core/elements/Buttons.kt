package ooo.jtc.core.elements


import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.elements.scroller.UiSortDirection
import org.openqa.selenium.By


@ElementType("Кнопка")
open class Button(sElement: SelenideElement) : SContainer(sElement = sElement)


/**
 * Button, than initialized by name
 */
@ElementType("Кнопка")
open class ButtonByName(
    ctx: SelenideElement,
    nameValue: String,
    by: By = By.xpath(".//button[@type = 'button' and @name='$nameValue']")
) : SContainer(sName = nameValue, sElement = ctx.find(by))


@ElementType("Кнопка")
class SortDirButton(
    ctx: SelenideElement,
    name: String = "Направление сортировки",
    sElement: SelenideElement = ctx.find(By.xpath(".//*[@data-name='sort_direction' and @role = 'button']"))
) : SContainer(sName = name, sElement = sElement) {

    fun getDirection(): UiSortDirection {
        val dataDirection = attr("data-direction")
        return if (dataDirection == "desc") UiSortDirection.DESC else UiSortDirection.ASC
    }

    fun sortByAsc() {
        if (getDirection() != UiSortDirection.ASC) this.click()
    }

    fun sortByDesc() {
        if (getDirection() != UiSortDirection.DESC) this.click()
    }
}

/**
 * More button
 */
@ElementType("Кнопка")
open class MoreButton(
    ctx: SelenideElement,
    sElement: SelenideElement = ctx.find("[data-action='more'][role='button']")
) : SContainer(sName = "Ещё", sElement = sElement) {
    override var useJs: Boolean = true //Элемент (@data-action = 'more') не видимый (display:false), поэтому кликаем на кнопку через JS.
}


/**
 * Button with dropdown list
 */
@ElementType("Кнопка c выпадающим списком")
class ButtonWithDropdown(override val dataName: String, sElement: SelenideElement) : Button(sElement = sElement), WithDropDownSelection {
    override fun openOptions(searchOption: String) {
        click(ignoreStep = true)
    }
}
