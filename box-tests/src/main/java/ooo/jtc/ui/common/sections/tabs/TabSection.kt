package ooo.jtc.ui.common.sections.tabs

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.element
import ooo.jtc.core.container.SContext
import ooo.jtc.scripts.invoke
import org.openqa.selenium.By


/**
 * Закладка (вкладка).
 */
interface TabSection<T> : SContext {

    /**
     * Название закладки.
     */
    val tabName: String

    /**
     * Ожидание загрузки элементов закладки.
     */
    fun waitTabOpens() {
        //по умолчанию просто ждем, что на закладке есть какой-то элемент с текстом
        element(By.xpath(".//*[text()]")).should(Condition.visible)
    }

    @Suppress("UNCHECKED_CAST")
    fun openTab(): T {
        "Перейти на вкладку '$tabName'"{
            element(By.xpath(".//*[@role='TAB' and .//text()='$tabName']")).click()
            waitTabOpens()
        }
        return this as T
    }
}