package ooo.jtc.core.elements

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.container.SElementGet
import ooo.jtc.core.container.withTitle
import org.openqa.selenium.By

/** Список всех доступных элементов с короткой инициализацией (input["payerName"]) на странице.
 * Все элементы из [AllElements] ищутся в контексте содержащего их элемента/страницы.
 */
object AllElements {

    /**
     * Возможность создавать список [SContainer]-элементов.
     * @param cssSelector - селектор для поиска списка элементов
     * @param mapper - функция преобразования [SelenideElement] в [SContainer]-элемент [T]
     * e.g. ```val items: List<MenuItem> get() = listElements("button[role='menuitem']") { MenuItem(it).withTitle(text) }```
     */
    fun <T : SContainer> SelenideElement.listElements(cssSelector: String, mapper: (SelenideElement) -> T): List<T> {
        this.shouldBe(Condition.exist)
        return this.findAll(cssSelector).map(mapper)
    }

    /**
     * Возможность создавать список [SContainer]-элементов.
     * @param xPath - селектор для поиска списка элементов
     * @param mapper - функция преобразования [SelenideElement] в [SContainer]-элемент [T]
     * e.g. ```val attachments: List<SAttachment> get() = listElementsX(".//div[contains(@data-name,'attachments') and @role]") { SAttachment(sElement = it) }```
     */
    fun <T : SContainer> SelenideElement.listElementsX(xPath: String, mapper: (SelenideElement) -> T): List<T> {
        this.shouldBe(Condition.exist)
        return this.findAll(By.xpath(xPath)).map(mapper)
    }

    /**
     * Кнопка с текстом.
     * Инициализируется по тексту
     */
    val SelenideElement.textButton: SElementGet<Button>
        get() = SElementGet {
            val xpath = By.xpath(".//button[@type = 'button' and (text()='$it' or ..//div[text()='$it'])]")
            Button(sElement = this.find(xpath)).withTitle(it)
        }

    /**
     * Кнопка.
     * Инициализируется значением из атрибута <i>name</i>.
     */
    val SelenideElement.buttonByName
        get() = SElementGet { Button(sElement = this.find("[name='$it']")).withTitle(it) }

    /**
     * Кнопка.
     * Инициализируется значением из атрибута <i>name</i>.
     */
    val SelenideElement.buttonDropdown
        get() = SElementGet { ButtonWithDropdown(dataName = it, sElement = this.find("[name='$it']")).withTitle(it) }

    /**
     * Текстовое поле ввода.
     * Инициализируется значением из атрибута <i>name</i>.
     */
    val SelenideElement.input
        get() = SElementGet {
            Input(name = it, sElement = this.find("input[name='$it']"))
        }

    /**
     * Текстовое поле ввода с выпадающим списком.
     * Инициализируется значением из атрибута <i>name</i>.
     */
    val SelenideElement.inputDropdown
        get() = SElementGet { InputWithDropdown(name = it, sElement = this.find("input[name='$it']")) }

    /**
     * Широкое текстовое поле.
     * Инициализируется значением из атрибута <i>name</i>.
     */
    val SelenideElement.textArea
        get() = SElementGet { TextArea(sElement = this.find("textarea[name='$it']")).withTitle(it) }

    /**

     * Широкое текстовое поле с выпадающим списком.
     * Инициализируется значением из атрибута <i>name</i>.
     */
    val SelenideElement.textAreaDropdown
        get() = SElementGet { TextAreaWithDropdown(dataName = it, sElement = this.find("textarea[name='$it']")).withTitle(it) }

    /**
     * Выпадающий список.
     * Инициализируется значением из атрибута <i>data-name</i>.
     */
    val SelenideElement.dropdown
        get() = SElementGet { DropDown(dataName = it, sElement = this.find("[data-name='$it'][role='select']")).withTitle(it) }

    /** Динамическое создание элемента по входжению в него текста */
    val SelenideElement.elementByText
        get() = SElementGet { ElementByText(parentElement = this, text = it) }

    /**
     * Лейбл.
     * Инициализируется значением из атрибута <i>data-field</i>.
     */
    val SelenideElement.label get() = SElementGet { Label(sElement = this.find("[data-field = '$it']")).withTitle(it) }

    /**
     * Чекбокс.
     * Инициализируется по наличию атрибута <i>role='checkbox'</i>.
     */
    val SelenideElement.checkbox get() = CheckBox(sElement = this.find("[role='checkbox']"))

    /**
     * Чекбокс.
     * Инициализируется по тексту в поле инпута.
     */
    val SelenideElement.checkboxByText
        get() = SElementGet {
            val xpath = By.xpath(".//*[@role='checkbox' and contains(.,'$it')]")
            CheckBox(this.find(xpath)).withTitle(it)
        }

    /**
     * Тултип (всплывающее сообщение-подсказка).
     * Инициализируется по тексту элемента.
     */
    val SelenideElement.tooltip
        get() = SElementGet {
            val xpath = By.xpath(".//*[@role='tooltip' and . ='$it']")
            SContainer(sElement = this.find(xpath)).withTitle(it)
        }

    /**
     * Элемент.
     * Инициализируется по [By].
     */
    fun SelenideElement.element(by: By): SContainer {
        return SContainer(sElement = this.find(by))
    }

    /**
     * Элемент.
     * Инициализируется по [cssSelector].
     */
    fun SelenideElement.element(cssSelector: String): SContainer {
        val by = By.cssSelector(cssSelector)
        return SContainer(sElement = this.find(by))
    }

    /**
     * Элемент.
     * Инициализируется по [SelenideElement].
     */
    fun SelenideElement.asContainer(title: String = ""): SContainer {
        return SContainer(sElement = this).withTitle(title)
    }

    val SelenideElement.radioGroupByDataName
        get() = SElementGet { RadioGroup(sElement = this.find("[data-name='$it'][role='radiogroup']")).withTitle(it) }
}