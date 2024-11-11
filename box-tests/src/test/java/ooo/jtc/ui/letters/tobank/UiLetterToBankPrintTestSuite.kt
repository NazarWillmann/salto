package ooo.jtc.ui.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.UI_LETTER_TO_BANK_PRINT
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.core.tm4j.Tm4jPriority.Low
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.model.LetterToBankPrintExportFormat.HTML
import ooo.jtc.letters.model.LetterToBankPrintExportFormat.PDF
import ooo.jtc.letters.model.LetterToBankPrintExportFormat.RTF
import ooo.jtc.testdata.Users
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerPrintMultiPageHugeDocTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerPrintTableMultiPageTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerPrintTableTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerPrintTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerPrintWithManyAttachmentsTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.UI)
@Feature(TestFeature.LETTER_TO_BANK)
@Story(TestStoryLetterToBank.LETTER_TO_BANK_PRINT)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("UI. ${DocumentNames.LETTER_TO_BANK} тесты на печать")
@UI_LETTER_TO_BANK_PRINT
class UiLetterToBankPrintTestSuite {
//region Tags
//@formatter:off
@Tag("JTCSALTO-T1868") annotation class T1868
@Tag("JTCSALTO-T2170") annotation class T2170
@Tag("JTCSALTO-T2171") annotation class T2171
@Tag("JTCSALTO-T2173") annotation class T2173
@Tag("JTCSALTO-T4529") annotation class T4529
@Tag("JTCSALTO-T2174") annotation class T2174
@Tag("JTCSALTO-T4831") annotation class T4831

@Tag("JTCSALTO-T2172") annotation class T2172
@Tag("JTCSALTO-T2176") annotation class T2176
@Tag("JTCSALTO-T2175") annotation class T2175
@Tag("JTCSALTO-T2177") annotation class T2177
@Tag("JTCSALTO-T4532") annotation class T4532
@Tag("JTCSALTO-T4533") annotation class T4533
//@formatter:on
//endregion

    @T1868 //Письмо в банк. Проверка наличия реквизитов в ПФ. HTML
    @T2170 //Письмо в банк. Проверка наличия реквизитов в ПФ. PDF. 1 страница
    @T2171 //Письмо в банк. Проверка наличия реквизитов в ПФ. RTF. 1 страница
    @T2173 //Письмо в банк. Проверка наличия реквизитов в ПФ. PDF. 2 страницы
    @T4529 //Письмо в банк. Проверка наличия реквизитов в ПФ. RTF. 2 страницы
    @T2174 //Письмо в банк. Проверка наличия реквизитов в ПФ. PDF. Количество вложений > 5
    @T4831 //Письмо в банк. Проверка наличия реквизитов в ПФ. RTF. Количество вложений > 5
    @T2172 //Письмо в банк. Проверка наличия реквизитов. Печать реестра. [HTML]. [Клиент]
    @T2175 //Письмо в банк. Проверка наличия реквизитов. Печать реестра. [PDF]. [Клиент]
    @T2176 //Письмо в банк. Проверка наличия реквизитов. Печать реестра. [RTF]. [Клиент]
    @T2177 //Письмо в банк. Проверка наличия реквизитов. Печать реестра. [PDF]. 2 и более страницы. [Клиент]
    @T4532 //Письмо в банк. Проверка наличия реквизитов. Печать реестра. [RTF]. 2 и более страницы. [Клиент]
    @T4533 //Письмо в банк. Проверка наличия реквизитов. Печать реестра. [HTML]. 2 и более страницы. [Клиент]
    @TestFactory
    internal fun letterToBankClientScrollerPrintTests(): List<DynamicTest> {
        val clientUser by lazy { Users.client }
        return EntityTestGenerator.generate(
            listOf(
                UiLTBScrollerPrintTest(clientUser, HTML).withId(T1868::class),
                UiLTBScrollerPrintTest(clientUser, PDF).withId(T2170::class),
                UiLTBScrollerPrintTest(clientUser, RTF).withId(T2171::class),

                UiLTBScrollerPrintMultiPageHugeDocTest(clientUser, PDF).withId(T2173::class),
                UiLTBScrollerPrintMultiPageHugeDocTest(clientUser, RTF).withId(T4529::class),

                UiLTBScrollerPrintWithManyAttachmentsTest(clientUser, PDF).withId(T2174::class),
                UiLTBScrollerPrintWithManyAttachmentsTest(clientUser, RTF).withId(T4831::class),

                UiLTBScrollerPrintTableTest(clientUser, HTML).withId(T2172::class),
                UiLTBScrollerPrintTableTest(clientUser, RTF).withId(T2176::class),
                UiLTBScrollerPrintTableTest(clientUser, PDF).withId(T2175::class),

                UiLTBScrollerPrintTableMultiPageTest(clientUser, PDF).withId(T2177::class),
                UiLTBScrollerPrintTableMultiPageTest(clientUser, RTF).withId(T4532::class).withPriority(Low),
                UiLTBScrollerPrintTableMultiPageTest(clientUser, HTML).withId(T4533::class).withPriority(Low),
            )
        )
    }
}