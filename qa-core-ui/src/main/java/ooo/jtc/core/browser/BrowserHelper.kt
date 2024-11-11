package ooo.jtc.core.browser

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.WebDriverRunner.getWebDriver
import io.qameta.allure.Step
import java.lang.System.getProperty
import ooo.jtc.allure.attachToAllure
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.Command
import org.openqa.selenium.remote.CommandExecutor

/**
 * Helper для взаимодействия с вкладками браузера
 */
object BrowserHelper {
    const val CHROME = "chrome"
    const val FIREFOX = "firefox"
    const val IE = "ie"

    private val BROWSER = getProperty("selenide.browser").toLowerCase()

    @Step("Переключится на следующую вкладку")
    fun switchToNextTab() {
        val parentTab = getWebDriver().windowHandle
        val getNextTabName = { getWebDriver().windowHandles.toList().first { it != parentTab } }
        val nextTab = ooo.jtc.scripts.repeat(getNextTabName, { it.isNotBlank() }, limitSec = 4)
        getWebDriver().switchTo().window(nextTab)
    }

    @Step("Получить текст со страницы")
    fun getPageText(): String {
        return element("body").text().attachToAllure("PageText")
    }

    @Step("Получить наименование последнего загруженного файла")
    fun getLastDownloadedFileName(): String {
        return when (BROWSER) {
            CHROME -> {
                openChromeDownloads()
                val downloadsManager = element(By.ByTagName("downloads-manager"))

                val downloadsManagerShadowRoot = expandRootElement(downloadsManager)
                val downloadsItem = downloadsManagerShadowRoot.find("#downloadsList > downloads-item")
                val downloadsItemShadowRoot = expandRootElement(downloadsItem)
                val titleArea = downloadsItemShadowRoot.find("#title-area")

                titleArea.text()
            }
            else -> TODO("Not yet implemented")
        }.attachToAllure()
    }

    @Step("Открыть вкладку Загрузки в браузере Chrome")
    fun openChromeDownloads() {
        Selenide.executeJavaScript<Any>("window.open()")
        switchToNextTab()
        getWebDriver().get("chrome://downloads/")
    }

    private fun expandRootElement(element: SelenideElement): SelenideElement {
        return element(Selenide.executeJavaScript<SelenideElement>("return arguments[0].shadowRoot", element) as WebElement)
    }

    @Step("Переключить режим сети браузера в Offline")
    fun switchNetworkOffline() {
        when (BROWSER) {
            CHROME -> {
                val webDriver = getWebDriver() as ChromeDriver
                val map = HashMap<String, Any>()
                map["offline"] = true
                map["latency"] = 5
                map["download_throughput"] = 5000
                map["upload_throughput"] = 5000
                val executor: CommandExecutor = webDriver.commandExecutor
                executor.execute(Command(webDriver.sessionId, "setNetworkConditions", mapOf("network_conditions" to map)))
            }
            else -> throw RuntimeException("Only chrome web driver is supported switchNetworkOffline() function yet.")
        }
    }
}