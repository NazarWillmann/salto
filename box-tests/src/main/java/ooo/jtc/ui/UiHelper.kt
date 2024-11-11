package ooo.jtc.ui

import com.codeborne.selenide.WebDriverRunner
import io.restassured.RestAssured
import ooo.jtc.core.applicationProperties
import ooo.jtc.core.kexensions.asFile
import ooo.jtc.extensions.DOTS_DATE_FORMAT
import ooo.jtc.extensions.getOrException
import ooo.jtc.extensions.string
import ooo.jtc.scripts.repeat
import org.openqa.selenium.remote.RemoteWebDriver
import java.io.File
import java.lang.management.ManagementFactory
import java.time.LocalDate
import java.util.regex.Pattern

object UiHelper {
    private val REGEX_MXBEAN_NAME = Pattern.compile("(.*)@.*")

    /**
     * Current date for UI tests in [DOTS_DATE_FORMAT].
     */
    val uiCurrentDate: String get() = LocalDate.now().string(DOTS_DATE_FORMAT)

    /**
     * Return downloaded through UI tests file by [fileName].
     */
    fun getDownloadedFile(fileName: String): File {
        val downloadsFolder: String = applicationProperties.getSystem("selenide.downloadsFolder")
        return when {
            applicationProperties.isUiRemote() -> getDownloadedFileRemote(downloadsFolder, fileName)
            else -> getDownloadedFileLocal(downloadsFolder, fileName)
        }
    }

    private fun getDownloadedFileLocal(downloadsFolder: String, fileName: String): File {
        val threadDownloadsFolder = getSelenideFileDownloadFolder(downloadsFolder)
        return repeat(function = { File(threadDownloadsFolder, fileName) }, condition = { it.exists() }, limitSec = 4)!!
    }

    private fun getDownloadedFileRemote(downloadsFolder: String, fileName: String): File {
        val sessionId = (WebDriverRunner.getWebDriver() as RemoteWebDriver).sessionId
        val ggrHost = System.getProperty("selenide.remote").substringBefore("/wd")
        val ggrFileUrl = "$ggrHost/download/$sessionId/$fileName"
        repeat(function = { RestAssured.get(ggrFileUrl).asString() }, condition = { !it.contains("404") }, limitSec = 4)
        val threadDownloadsFolder = getSelenideFileDownloadFolder(downloadsFolder)
        return RestAssured.get(ggrFileUrl).asFile("$threadDownloadsFolder/$fileName")
    }

    /**
     * Search folder inside [downloadsFolder] by pid and current thread.
     * @see [com.codeborne.selenide.impl.FileNamer.generateFileName]
     */
    private fun getSelenideFileDownloadFolder(downloadsFolder: String): File {
        val folder = File(downloadsFolder)
        val curThreadId = Thread.currentThread().id.toString()
        val pid = pid()
        return folder.listFiles()?.find { it.isDirectory && it.name.endsWith("${pid}_$curThreadId") }.getOrException()
    }

    private fun pid(): String? {
        return REGEX_MXBEAN_NAME.matcher(ManagementFactory.getRuntimeMXBean().name).replaceFirst("$1")
    }

    fun LocalDate.toUi(): String {
        return this.string(DOTS_DATE_FORMAT)
    }
}