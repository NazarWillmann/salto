package ooo.jtc.core.elements

import com.codeborne.selenide.Condition
import ooo.jtc.core.container.SContext
import ooo.jtc.core.container.wait
import ooo.jtc.scripts.invoke

/**
 * Интерфейс добавляющий взаимодействие с выпадающим списком опций для поля элемента.
 */
interface WithDropDownSelection : SContext {

    /**
     * Функция, которая "раскрывает"/показывает список опций дропдауна.
     * @param searchOption искомое значение в поле. используется для инпутов,
     * когда нужно ввести какую-то часть слова, чтобы сработал быстрый поиск.
     */
    fun openOptions(searchOption: String)

    fun closeOptions() {
        if (options.isDisplayed) {
            getContext().click()
        }
    }

    /** Тип выбора из списка опций. */
    val selectBy: SelectBy get() = SelectBy.INNER_TEXT

    /**
     * data-name атрибут, для поиска опций выпадающего списка.
     * Должен совпадать с атрибутом name основного поля.
     */
    val dataName: String

    /** Опции выпадающего списка. */
    val options get() = ListBoxOptions(dataName = dataName, selectBy = selectBy)

    /** Текст опций */
    val optionsValues: List<String> get() = options.items.map { it.text }

    fun select(searchString: String) {
        "Выбрать '$searchString' в элементе '$title'" {
            openOptions(searchString)
            options wait Condition.visible
            options.select(searchString)
        }
    }
}