package ooo.jtc.ui.common.pages

import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.WebDriverRunner.getWebDriver
import ooo.jtc.allure.attachToAllure
import ooo.jtc.core.applicationProperties
import ooo.jtc.core.browser.BrowserStorageHelper
import ooo.jtc.core.browser.StorageItem
import ooo.jtc.core.browser.StorageType
import ooo.jtc.core.elements.Page
import ooo.jtc.core.kexensions.invokeAuth
import ooo.jtc.logging.LoggerDelegate
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.uaa.User
import ooo.jtc.ui.common.pages.ApplicationPageType.BANK_PAGE
import ooo.jtc.ui.common.pages.ApplicationPageType.CLIENT_PAGE
import org.openqa.selenium.JavascriptExecutor
import java.util.UUID
import java.util.concurrent.atomic.AtomicInteger

private val uiProps = applicationProperties.server.ui
private val openPageCounter: AtomicInteger by lazy { AtomicInteger() }

enum class ApplicationPageType(val uiName: String) {
    CLIENT_PAGE("Клиент"),
    BANK_PAGE("Банк")
    ;

    fun isBank(): Boolean = this == BANK_PAGE
    fun isClient(): Boolean = this == CLIENT_PAGE
}

abstract class ApplicationPage(
    endpoint: String = "/",
    var pageType: ApplicationPageType,
    sElement: SelenideElement
) : Page(
    url = when (pageType) {
        CLIENT_PAGE -> "${uiProps.client.host}:${uiProps.client.port}/$endpoint"
        BANK_PAGE -> "${uiProps.bank.host}:${uiProps.bank.port}/$endpoint"
    },
    sElement = sElement
) {
    private val log by LoggerDelegate()
    private fun getUserToken(user: User): String =
        (user.bearer ?: user.invokeAuth().bearer!!).replace("Bearer ", "")

    /**
     * Функция ожидания загрузки страницы.
     * Рекомендуется ждать видимости самого долго загружающегося элемента на странице.
     */
    abstract fun waitLoading()

    infix fun openScrollerBy(user: User) {
        "Открываем страницу приложения '${this.title}' под пользователем ${user.login}" {
            openWithWaiting(
                listOf(
                    StorageItem(StorageType.LOCAL, "token", getUserToken(user))
                )
            )
        }
    }

    fun openScrollerBy(user: User, customerId: UUID) {
        val customerName = CustomerData.find { it.id!! == customerId }.shortName
        "Открываем страницу приложения '${this.title}' под пользователем '${user.login}' для клиента '$customerName' ($customerId)" {
            val userToken = getUserToken(user)
            var hasOpenPageError: Boolean = false
            try {
                openWithWaiting(
                    fillingStorages = listOf(
                        StorageItem(StorageType.LOCAL, "token", userToken),
                        StorageItem(StorageType.LOCAL, "SelectedOrganization", customerId.toString())
                    )
                )
            } catch (e: Throwable) {
                hasOpenPageError = true
                log.error("Open page error.", e)
            }

            val selectedCustomer =
                BrowserStorageHelper.getItemFromStorage((getWebDriver() as JavascriptExecutor), StorageType.LOCAL, "SelectedOrganization")
                    .attachToAllure("SelectedOrganization")
            if ((hasOpenPageError || customerId.toString() != selectedCustomer) && openPageCounter.getAndIncrement() < 3) {
                log.warn("Retry to open page [${openPageCounter.get()}].")
                openScrollerBy(user, customerId)
            }
        }
    }

    fun openFormByParams(user: User, documentId: UUID, mode: String? = "view", tab: DocumentPageTabs = DocumentPageTabs.BASIC_REQUISITES) {
        val openId = "/id~$documentId"
        val openMode = mode?.let { "/mode~$mode" } ?: ""
        val openTab = tab.urlName?.let { "/tab~$tab" } ?: ""

        "Открываем страницу приложения '${this.title}' пользователем '${user.login}' с переходом к просмотру/редактированию документа '$documentId'" {
            this@ApplicationPage.url = this@ApplicationPage.url + "$openId$openMode$openTab/"
            val userToken = getUserToken(user)
            openWithWaiting(
                fillingStorages = listOf(
                    StorageItem(StorageType.LOCAL, "token", userToken),
                )
            )
        }
    }

    private fun openWithWaiting(fillingStorages: List<StorageItem>) {
        super.open(fillingStorages = fillingStorages)
        waitLoading()
    }
}