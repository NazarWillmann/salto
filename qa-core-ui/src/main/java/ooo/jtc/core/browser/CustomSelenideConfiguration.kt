package ooo.jtc.core.browser

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.WebDriverProvider
import com.codeborne.selenide.webdriver.ChromeDriverFactory
import ooo.jtc.properties.uiTestProperties
import org.openqa.selenium.MutableCapabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import java.io.File
import java.net.URL

object CustomSelenideConfiguration {

    //TODO A.Stykalin [2020.11.24]: update selenide to 5.16.1; remove custom driver methods
    /**
     * Тут конфигурируется все, что нужно для Selenide программно.
     */
    fun configureSelenide() {
        Configuration.browserCapabilities = getCapabilities()
    }

    /**
     * Дополнительные свойства для браузеров на selenoid.
     */
    private fun getCapabilities(): MutableCapabilities {
        var options = MutableCapabilities()
        when (val browser = System.getProperty("selenide.browser")) {
            BrowserHelper.CHROME -> options = getChromeOptions()
            BrowserHelper.FIREFOX -> options = getFireFoxOptions()
            else -> println("Capabilities for browser '$browser' not configured.")
        }
        val capabilities = uiTestProperties.browser.capabilities
        capabilities.forEach { (k, v) ->
            options.setCapability(k, v)
        }
        return options
    }

    private fun getChromeOptions(): ChromeOptions {
        //workaround for selenide with chrome extension
        if (uiTestProperties.remoteUrl != null) {
            Configuration.remote = null
            Configuration.browser = CustomRemoteWebDriverProvider::class.java.name
        } else {
            Configuration.browser = CustomChromeDriverFactory::class.java.name
        }
        val chromeOptions = ChromeOptions()
        // Sergeyev [2020.11.16]: starting from chromedriver_78 CRX2-extensions are not supported. Useful link:
        // https://stackoverflow.com/questions/58762418/webdriverexception-message-unknown-error-cannot-process-extension-1-from-unk
        val extFile = getExtensionFile("chrome_cryptopro_crx3.crx")
        chromeOptions.addExtensions(extFile)
        return chromeOptions
    }

    private fun getFireFoxOptions(): FirefoxOptions {
        val options = FirefoxOptions()
        val extFile = getExtensionFile("ff_cryptopro_ext.xpi")
        val profile = FirefoxProfile()
        profile.addExtension(extFile)
        options.profile = profile
        return options
    }

    /**
     * Retrieve browser extension file by [extensionName] from [resource/extensions] folder.
     */
    private fun getExtensionFile(extensionName: String): File {
        return this::class.java.classLoader.getResource("extensions/$extensionName").let { File(it!!.file) }
    }
}

/**
 * You can use custom Driver factory for creating webDriver for Selenide.
 * https://github.com/selenide/selenide/wiki/How-Selenide-creates-WebDriver
 *
 * There is an issue with chrome extension in Selenide.
 * For now we can use this workaround.
 * Will be looking for fixes.
 */
internal class CustomRemoteWebDriverProvider : WebDriverProvider {
    override fun createDriver(desiredCapabilities: DesiredCapabilities): WebDriver {
        return RemoteWebDriver(URL(uiTestProperties.remoteUrl), desiredCapabilities)
    }
}

internal class CustomChromeDriverFactory : ChromeDriverFactory() {
    override fun excludeSwitches(): Array<String> {
        return arrayOf()
    }
}