package ooo.jtc.ui.letters.frombank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.UI_LETTER_FROM_BANK_EXPORT
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterFromBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.model.LetterFromBankPrintExportFormat.CSV
import ooo.jtc.letters.model.LetterFromBankPrintExportFormat.XLSX
import ooo.jtc.letters.model.LetterFromBankPrintExportFormat.XML
import ooo.jtc.testdata.Users
import ooo.jtc.ui.letters.frombank.tests.UiLetterFormExportTest
import ooo.jtc.ui.letters.frombank.tests.UiLetterScrollerExportGroupTest
import ooo.jtc.ui.letters.frombank.tests.UiLetterScrollerExportTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.UI)
@Feature(TestFeature.LETTER_FROM_BANK)
@Story(TestStoryLetterFromBank.LETTER_FROM_BANK_EXPORT)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("UI. ${DocumentNames.LETTER_FROM_BANK} тесты на экспорт")
@UI_LETTER_FROM_BANK_EXPORT
class UiLetterFromBankExportTestSuite {
    //region Tags
//@formatter:off
 @Tag("JTCSALTO-T4719") annotation class T4719
 @Tag("JTCSALTO-T4723") annotation class T4723
 @Tag("JTCSALTO-T4726") annotation class T4726
 @Tag("JTCSALTO-T4721") annotation class T4721
 @Tag("JTCSALTO-T4722") annotation class T4722
 @Tag("JTCSALTO-T4725") annotation class T4725
 @Tag("JTCSALTO-T4720") annotation class T4720
 @Tag("JTCSALTO-T4724") annotation class T4724
 @Tag("JTCSALTO-T4727") annotation class T4727
 @Tag("JTCSALTO-T4736") annotation class T4736
 @Tag("JTCSALTO-T4737") annotation class T4737
 @Tag("JTCSALTO-T4738") annotation class T4738
 @Tag("JTCSALTO-T4739") annotation class T4739
 @Tag("JTCSALTO-T4740") annotation class T4740
 @Tag("JTCSALTO-T4741") annotation class T4741
 @Tag("JTCSALTO-T4742") annotation class T4742
 @Tag("JTCSALTO-T4743") annotation class T4743
 @Tag("JTCSALTO-T4744") annotation class T4744
//@formatter:on
//endregion

    private val bankUser by lazy { Users.bankOperator }
    private val clientUser by lazy { Users.client }

    @Suppress("UNCHECKED_CAST")
    private fun <T: AbstractTest<*, *>> T.withCsvTaskId(): T = this.withTaskIds(LFBTaskIdsUiExportCSV::class) as T
    @Suppress("UNCHECKED_CAST")
    private fun <T: AbstractTest<*, *>> T.withXlsxTaskId(): T = this.withTaskIds(LFBTaskIdsUiExportXLS::class) as T
    @Suppress("UNCHECKED_CAST")
    private fun <T: AbstractTest<*, *>> T.withXmlTaskId(): T = this.withTaskIds(LFBTaskIdsUiExportXML::class) as T

    @TestFactory
    @T4719 //Письмо из Банка. Экспорт документа из скроллера (меню строки). [в файл csv]. [BANK]
    @T4723 //Письмо из Банка. Экспорт документа из скроллера (меню строки). [в файл xlsx]. [BANK]
    @T4726 //Письмо из Банка. Экспорт документа из скроллера (меню строки). [в файл xml]. [BANK]
    @T4721 //Письмо из Банка. Экспорт документа из скроллера (групповое действие). [в файл csv]. [BANK]
    @T4722 //Письмо из Банка. Экспорт документа из скроллера (групповое действие). [в файл xlsx]. [BANK]
    @T4725 //Письмо из Банка. Экспорт документа из скроллера (групповое действие). [в файл xml]. [BANK]
    @T4720 //Письмо из Банка. Экспорт документа из формы. [в файл csv]. [BANK]
    @T4724 //Письмо из Банка. Экспорт документа из формы. [в файл xlsx]. [BANK]
    @T4727 //Письмо из Банка. Экспорт документа из формы. [в файл xml]. [BANK]
    internal fun letterFromBankExportBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                UiLetterScrollerExportTest(user, CSV).withCsvTaskId().withId(T4719::class),
                UiLetterScrollerExportTest(user, XLSX).withXlsxTaskId().withId(T4723::class),
                UiLetterScrollerExportTest(user, XML).withXmlTaskId().withId(T4726::class),

                UiLetterScrollerExportGroupTest(user, CSV).withCsvTaskId().withId(T4721::class),
                UiLetterScrollerExportGroupTest(user, XLSX).withXlsxTaskId().withId(T4722::class),
                UiLetterScrollerExportGroupTest(user, XML).withXmlTaskId().withId(T4725::class),

                UiLetterFormExportTest(user, CSV).withCsvTaskId().withId(T4720::class),
                UiLetterFormExportTest(user, XLSX).withXlsxTaskId().withId(T4724::class),
                UiLetterFormExportTest(user, XML).withXmlTaskId().withId(T4727::class),
            )
        )
    }

    @TestFactory
    @T4736 //Письмо из Банка. Экспорт документа из скроллера (меню строки). [в файл csv]. [CLIENT]
    @T4737 //Письмо из Банка. Экспорт документа из скроллера (меню строки). [в файл xlsx]. [CLIENT]
    @T4738 //Письмо из Банка. Экспорт документа из скроллера (меню строки). [в файл xml]. [CLIENT]
    @T4739 //Письмо из Банка. Экспорт документа из скроллера (групповое действие). [в файл csv]. [CLIENT]
    @T4740 //Письмо из Банка. Экспорт документа из скроллера (групповое действие). [в файл xlsx]. [CLIENT]
    @T4741 //Письмо из Банка. Экспорт документа из скроллера (групповое действие). [в файл xml]. [CLIENT]
    @T4742 //Письмо из Банка. Экспорт документа из формы. [в файл csv]. [CLIENT]
    @T4743 //Письмо из Банка. Экспорт документа из формы. [в файл xlsx]. [CLIENT]
    @T4744 //Письмо из Банка. Экспорт документа из формы. [в файл xml]. [CLIENT]
    internal fun letterFromBankExportClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                UiLetterScrollerExportTest(user, CSV).withCsvTaskId().withId(T4736::class),
                UiLetterScrollerExportTest(user, XLSX).withXlsxTaskId().withId(T4737::class),
                UiLetterScrollerExportTest(user, XML).withXmlTaskId().withId(T4738::class),

                UiLetterScrollerExportGroupTest(user, CSV).withCsvTaskId().withId(T4739::class),
                UiLetterScrollerExportGroupTest(user, XLSX).withXlsxTaskId().withId(T4740::class),
                UiLetterScrollerExportGroupTest(user, XML).withXmlTaskId().withId(T4741::class),

                UiLetterFormExportTest(user, CSV).withCsvTaskId().withId(T4742::class),
                UiLetterFormExportTest(user, XLSX).withXlsxTaskId().withId(T4743::class),
                UiLetterFormExportTest(user, XML).withXmlTaskId().withId(T4744::class),
            )
        )
    }
}