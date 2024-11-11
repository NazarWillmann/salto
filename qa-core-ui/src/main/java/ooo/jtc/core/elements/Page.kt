package ooo.jtc.core.elements

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.WebDriverRunner.getWebDriver
import ooo.jtc.core.browser.BrowserStorageHelper
import ooo.jtc.core.browser.CustomSelenideConfiguration
import ooo.jtc.core.browser.StorageItem
import ooo.jtc.core.container.SContainer
import org.openqa.selenium.JavascriptExecutor

/** Базовая страница для всех UI-pages.  */
abstract class Page(var url: String, sElement: SelenideElement) : SContainer(sElement = sElement) {

    /**
     * Основная функция для открытия страниц.
     * Тут же дополнительно конфигурируется selenide
     * и заполняются хранилища (localStorage,sessionStorage) в браузере.
     */
    open fun open(fillingStorages: List<StorageItem> = mutableListOf()): Page {
        CustomSelenideConfiguration.configureSelenide()
        Selenide.open(url)
        BrowserStorageHelper.fillPageStorage((getWebDriver() as JavascriptExecutor), fillingStorages)
        getWebDriver().navigate().refresh()
        return this
    }
}