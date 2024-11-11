package ooo.jtc.core.container

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.selenide.scrollIntoView
import ooo.jtc.logging.LoggerDelegate
import ooo.jtc.properties.uiTestProperties
import ooo.jtc.scripts.invoke
import org.openqa.selenium.By

val defaultContext: SelenideElement = `$`("body")
val defaultDialogContext: SelenideElement = `$`("[role='dialog']")

/** Форматирует [By.ByXPath] локатор для поиска из контекста. */
fun formatXPathBy(by: By): By {
    if (by is By.ByXPath) {
        val locator = by.toString().substringAfter("By.xpath: ")
        return if (!locator.startsWith("//body") && locator.startsWith("/")) {
            By.xpath(locator.replaceFirst("/", "./"))
        } else by
    }
    return by
}

/**
 * Контейнер-обертка для [SelenideElement].
 * Позволяет создавать новые сложные элементы в контексте текущего элемента.
 * Добавляет возможность человеко-читаемого наименования элементов.
 *
 * Основные элементы контейнера: [selenideElement] и [ctx].
 *
 * @param sName - наименование элемента. Используется для формирования [title], который используется в [toString], в т.ч. для отчета.
 * @param sElement - основной [SelenideElement] находящийся в контейнере.
 */
@ElementType("Элемент")
open class SContainer(
    var sName: String = "",
    override val sElement: SelenideElement = defaultContext
) : SelenideElement by sElement, SContext {
    private val log by LoggerDelegate()

    /**
     * Время ожидания элемента на странице.
     * Используется преимущественно в ожиданиях и проверках [ooo.jtc.core.container.wait].
     */
    open var timeout: Long = uiTestProperties.elements.timeout

    /** Интервал выполнения проверки для элемента. */
    open var pollingInterval: Long = uiTestProperties.elements.poolingInterval

    /** Флаг для выполнения действия с элементом через JS. */
    open var useJs: Boolean = uiTestProperties.elements.useJs

    /**
     * Наименование элемента (контейнера) для отчета.
     * Формируется динамически. Состоит значения в аннотации [ElementType] над классом элемента
     * и [sName]/либо заданным значением через экстеншн-функцию [withTitle].
     * Если для элемента вызвана функция [withTitle], то значение [sName] (оно же [field])
     * будет заменено на значение из [withTitle].
     *
     * e.g. Для элемента [ooo.jtc.core.elements.Input]:
     * ```
     * @ElementType("Текстовое поле ввода")
     * open class Input(val name: String, sElement: SelenideElement) : SContainer(sName = name, sElement = sElement) {...
     * ```
     * Если создать этот элемент `val code get() = input["code"]`
     * то title будет иметь значение => ` "Текстовое поле ввода": 'code'" `
     *
     * Если создать этот элемент с [withTitle] `val code get() = input["code"].withTitle("КБК")`
     * то title будет иметь значение => ` "Текстовое поле ввода: 'КБК'" `
     */
    override var title: String? = sName
        get() {
            val fromAnnotations = this::class.annotations.filterIsInstance<ElementType>().map { it.name }.ifEmpty { listOf("") }.first()
            return if (field.isNullOrEmpty() || field == fromAnnotations)
                fromAnnotations
            else
                "$fromAnnotations: '$field'"
        }

    override fun toString(): String = title!!

    //region Вспомогательные методы для оптимизации поиска SelenideElement
    /** Находим элемент от текущего по атрибуту `data-field`. */
    fun findByDataField(dataFieldName: String): SelenideElement {
        return this.find(" [data-field='$dataFieldName']")
    }

    /** Получить текст из элемента по [dataName]*/
    fun getTextByDataName(dataName: String): String {
        return this.find(" [data-name='$dataName']").text()
    }
    //endregion

    //region "Переопределенные" методы SelenideElement

    val isNotDisplayed get() = !isDisplayed

    override fun setValue(text: String?): SelenideElement {
        "Ввести данные '$text' в ${title}" {
            if (text != null) {
                this@SContainer.`val`(text)
            }
        }
        return this
    }

    fun click(ignoreStep: Boolean = false) {
        val title = if (!ignoreStep) "Нажать на элемент '$title'" else ""
        title {
            if (useJs) {
                executeJS("arguments[0].click()")
            } else {
                try {
                    click()
                } catch (ex: Throwable) {
                    scrollIntoView()
                    click()
                }
            }
        }
    }
    //endregion

    /**
     * Simple wrapper.
     * For actions with the element call `arguments[0]`
     * e.g. - `arguments[0].click()`
     * `selenideElement.wrappedElement` means `arguments[0]` in script.
     */
    fun executeJS(script: String) = apply {
        Selenide.executeJavaScript<Any>(script, this.wrappedElement)
    }
}