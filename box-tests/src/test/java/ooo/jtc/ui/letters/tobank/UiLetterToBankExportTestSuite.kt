package ooo.jtc.ui.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.UI_LETTER_TO_BANK_EXPORT
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.model.LetterToBankPrintExportFormat.CSV
import ooo.jtc.letters.model.LetterToBankPrintExportFormat.XLSX
import ooo.jtc.letters.model.LetterToBankPrintExportFormat.XML
import ooo.jtc.testdata.Users
import ooo.jtc.ui.letters.tobank.tests.UiLetterFormExportTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerExportExpandPanelTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerExportGroupTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerExportTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.UI)
@Feature(TestFeature.LETTER_TO_BANK)
@Story(TestStoryLetterToBank.LETTER_TO_BANK_EXPORT)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("UI. ${DocumentNames.LETTER_TO_BANK} тесты на экспорт")
@UI_LETTER_TO_BANK_EXPORT
class UiLetterToBankExportTestSuite {
    //region Tags
//@formatter:off
    @Tag("JTCSALTO-T4707") annotation class T4707
    @Tag("JTCSALTO-T4706") annotation class T4706
    @Tag("JTCSALTO-T4705") annotation class T4705
    @Tag("JTCSALTO-T4704") annotation class T4704
    @Tag("JTCSALTO-T4711") annotation class T4711
    @Tag("JTCSALTO-T4710") annotation class T4710
    @Tag("JTCSALTO-T4708") annotation class T4708
    @Tag("JTCSALTO-T4703") annotation class T4703
    @Tag("JTCSALTO-T4598") annotation class T4598
    @Tag("JTCSALTO-T4597") annotation class T4597
    @Tag("JTCSALTO-T4596") annotation class T4596
    @Tag("JTCSALTO-T4595") annotation class T4595
//endregion
//@formatter:on

    @Suppress("UNCHECKED_CAST")
    private fun <T: AbstractTest<*, *>> T.withCsvTaskId(): T = this.withTaskIds(LTBTaskIdsUiExportCSV::class) as T
    @Suppress("UNCHECKED_CAST")
    private fun <T: AbstractTest<*, *>> T.withXlsxTaskId(): T = this.withTaskIds(LTBTaskIdsUiExportXLS::class) as T
    @Suppress("UNCHECKED_CAST")
    private fun <T: AbstractTest<*, *>> T.withXmlTaskId(): T = this.withTaskIds(LTBTaskIdsUiExportXML::class) as T


    @T4598 // Письмо в Банк. Экспорт документа из скроллера (меню строки). [в файл csv]. [CLIENT]
    @T4703 // Письмо в Банк. Экспорт документа из скроллера (меню строки). [в файл xlsx]. [CLIENT]
    @T4704 // Письмо в Банк. Экспорт документа из скроллера (меню строки). [в файл xml]. [CLIENT]

    @T4708 // Письмо в Банк. Экспорт документа из скроллера (панель быстрого просмотра). [в файл csv]. [CLIENT]
    @T4710 // Письмо в Банк. Экспорт документа из скроллера (панель быстрого просмотра). [в файл xlsx]. [CLIENT]
    @T4711 // Письмо в Банк. Экспорт документа из скроллера (панель быстрого просмотра). [в файл xml]. [CLIENT]

    @T4595 // Письмо в Банк. Экспорт документов из скроллера (групповое действие). [в файл csv]. [CLIENT]
    @T4596 // Письмо в Банк. Экспорт документов из скроллера (групповое действие). [в файл xlsx]. [CLIENT]
    @T4597 // Письмо в Банк. Экспорт документов из скроллера (групповое действие). [в файл xml]. [CLIENT]
    @TestFactory
    internal fun letterToBankScrollerExportTests(): List<DynamicTest> {
        val clientUser by lazy { Users.client }
        return EntityTestGenerator.generate(
            listOf(
                UiLTBScrollerExportTest(clientUser, CSV).withCsvTaskId().withId(T4598::class),
                UiLTBScrollerExportTest(clientUser, XLSX).withXlsxTaskId().withId(T4703::class),
                UiLTBScrollerExportTest(clientUser, XML).withXmlTaskId().withId(T4704::class),

                UiLTBScrollerExportExpandPanelTest(clientUser, CSV).withCsvTaskId().withId(T4708::class),
                UiLTBScrollerExportExpandPanelTest(clientUser, XLSX).withXlsxTaskId().withId(T4710::class),
                UiLTBScrollerExportExpandPanelTest(clientUser, XML).withXmlTaskId().withId(T4711::class),

                UiLTBScrollerExportGroupTest(clientUser, CSV).withCsvTaskId().withId(T4595::class),
                UiLTBScrollerExportGroupTest(clientUser, XLSX).withXlsxTaskId().withId(T4596::class),
                UiLTBScrollerExportGroupTest(clientUser, XML).withXmlTaskId().withId(T4597::class),
            )
        )
    }

    @T4705 // Письмо в Банк. Экспорт документа из формы. [в файл csv]. [CLIENT]
    @T4706 // Письмо в Банк. Экспорт документа из формы. [в файл xlsx]. [CLIENT]
    @T4707 // Письмо в Банк. Экспорт документа из формы. [в файл xml]. [CLIENT]
    @TestFactory
    internal fun uiLetterToBankFormExportTests(): List<DynamicTest> {
        val clientUser = Users.client
        return EntityTestGenerator.generate(
            listOf(
                UiLetterFormExportTest(clientUser, CSV).withCsvTaskId().withId(T4705::class),
                UiLetterFormExportTest(clientUser, XLSX).withXlsxTaskId().withId(T4706::class),
                UiLetterFormExportTest(clientUser, XML).withXmlTaskId().withId(T4707::class),
            )
        )
    }
}