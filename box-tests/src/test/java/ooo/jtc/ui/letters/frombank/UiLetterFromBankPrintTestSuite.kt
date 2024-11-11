package ooo.jtc.ui.letters.frombank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.UI_LETTER_FROM_BANK_PRINT
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterFromBank
import ooo.jtc.core.tm4j.Tm4jPriority.Low
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.model.LetterFromBankPrintExportFormat.HTML
import ooo.jtc.letters.model.LetterFromBankPrintExportFormat.PDF
import ooo.jtc.letters.model.LetterFromBankPrintExportFormat.RTF
import ooo.jtc.testdata.Users
import ooo.jtc.ui.letters.frombank.tests.UiLFBScrollerPrintMultiPageHugeDocTest
import ooo.jtc.ui.letters.frombank.tests.UiLFBScrollerPrintTableMultiPageTest
import ooo.jtc.ui.letters.frombank.tests.UiLFBScrollerPrintTableTest
import ooo.jtc.ui.letters.frombank.tests.UiLFBScrollerPrintTest
import ooo.jtc.ui.letters.frombank.tests.UiLFBScrollerPrintWithManyAttachmentsTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.UI)
@Feature(TestFeature.LETTER_FROM_BANK)
@Story(TestStoryLetterFromBank.LETTER_FROM_BANK_PRINT)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("UI. ${DocumentNames.LETTER_FROM_BANK} тесты на печать")
@UI_LETTER_FROM_BANK_PRINT
class UiLetterFromBankPrintTestSuite {

    // TODO? Sergeyev [2020.11.03]: flaky when in ExecutionMode.SAME_THREAD and HTML tests are in suite (tab focus)

//region Tags
//@formatter:off
@Tag("JTCSALTO-T2422") annotation class T2422 //Проверка наличия реквизитов в ПФ. HTML
@Tag("JTCSALTO-T2423") annotation class T2423 //Проверка наличия реквизитов в ПФ. PDF. 1 страница
@Tag("JTCSALTO-T2426") annotation class T2426 //Проверка наличия реквизитов в ПФ. RTF. 1 страница
@Tag("JTCSALTO-T2424") annotation class T2424 //Проверка наличия реквизитов в ПФ. PDF. 2 страницы
@Tag("JTCSALTO-T4791") annotation class T4791 //Проверка наличия реквизитов в ПФ. RTF. 2 страницы
@Tag("JTCSALTO-T2425") annotation class T2425 //Проверка наличия реквизитов в ПФ. PDF. Количество вложений > 5
@Tag("JTCSALTO-T4829") annotation class T4829 //Проверка наличия реквизитов в ПФ. RTF. Количество вложений > 5
@Tag("JTCSALTO-T2418") annotation class T2418 //Проверка наличия реквизитов. Печать реестра. HTML
@Tag("JTCSALTO-T2419") annotation class T2419 //Проверка наличия реквизитов. Печать реестра. PDF
@Tag("JTCSALTO-T2421") annotation class T2421 //Проверка наличия реквизитов. Печать реестра. RTF
@Tag("JTCSALTO-T2420") annotation class T2420 //Проверка наличия реквизитов. Печать реестра. PDF. 2 и более страницы
@Tag("JTCSALTO-T4792") annotation class T4792 //Проверка наличия реквизитов. Печать реестра. RTF. 2 и более страницы

@Tag("JTCSALTO-T3845") annotation class T3845 //Проверка наличия реквизитов в ПФ. HTML
@Tag("JTCSALTO-T3846") annotation class T3846 //Проверка наличия реквизитов в ПФ. PDF. 1 страница
@Tag("JTCSALTO-T3849") annotation class T3849 //Проверка наличия реквизитов в ПФ. RTF. 1 страница
@Tag("JTCSALTO-T3847") annotation class T3847 //Проверка наличия реквизитов в ПФ. PDF. 2 страницы
@Tag("JTCSALTO-T4793") annotation class T4793 //Проверка наличия реквизитов в ПФ. RTF. 2 страницы
@Tag("JTCSALTO-T3848") annotation class T3848 //Проверка наличия реквизитов в ПФ. PDF. Количество вложений > 5
@Tag("JTCSALTO-T4830") annotation class T4830 //Проверка наличия реквизитов в ПФ. RTF. Количество вложений > 5
@Tag("JTCSALTO-T4139") annotation class T4139 //Проверка наличия реквизитов. Печать реестра. HTML
@Tag("JTCSALTO-T4140") annotation class T4140 //Проверка наличия реквизитов. Печать реестра. PDF
@Tag("JTCSALTO-T4142") annotation class T4142 //Проверка наличия реквизитов. Печать реестра. RTF
@Tag("JTCSALTO-T4141") annotation class T4141 //Проверка наличия реквизитов. Печать реестра. PDF. 2 и более страницы
@Tag("JTCSALTO-T4794") annotation class T4794 //Проверка наличия реквизитов. Печать реестра. RTF. 2 и более страницы
//@formatter:on
//endregion

    @T2422 //Письмо из Банка. Проверка наличия реквизитов в ПФ. (из скроллера).[на принтер]. [BANK]
    @T2423 //Письмо из Банка. Проверка наличия реквизитов в ПФ. (из скроллера).[в файл pdf]. [BANK]
    @T2426 //Письмо из Банка. Проверка наличия реквизитов в ПФ. (из скроллера).[в файл rtf]. [BANK]
    @T2424 //Письмо из Банка. Проверка наличия реквизитов в ПФ. (из скроллера).[в файл pdf]. 2 страницы. [BANK]
    @T4791 //Письмо из Банка. Проверка наличия реквизитов в ПФ. (из скроллера).[в файл rtf]. 2 страницы. [BANK]
    @T2425 //Письмо из Банка. Проверка наличия реквизитов в ПФ. (из скроллера).[в файл pdf]. Количество вложений > 5. [BANK]
    @T4829 //Письмо из Банка. Проверка наличия реквизитов в ПФ. (из скроллера).[в файл rtf]. Количество вложений > 5. [BANK]
    @T2418 //Письмо из Банка. Проверка наличия реквизитов. Печать реестра. [на принтер]. [BANK]
    @T2421 //Письмо из Банка. Проверка наличия реквизитов. Печать реестра. [в файл pdf]. [BANK]
    @T2419 //Письмо из Банка. Проверка наличия реквизитов. Печать реестра. [в файл rtf]. [BANK]
    @T2420 //Письмо из Банка. Проверка наличия реквизитов. Печать реестра. [в файл pdf]. 2 и более страницы. [BANK]
    @T4792 //Письмо из Банка. Проверка наличия реквизитов. Печать реестра. [в файл rtf]. 2 и более страницы. [BANK]
    @TestFactory
    internal fun letterFromBankScrollerPrintBankTests(): List<DynamicTest> {
        val bankUser by lazy { Users.bankOperator }
        return EntityTestGenerator.generate(
            listOf(
                UiLFBScrollerPrintTest(bankUser, HTML).withId(T2422::class),
                UiLFBScrollerPrintTest(bankUser, PDF).withId(T2423::class),
                UiLFBScrollerPrintTest(bankUser, RTF).withId(T2426::class),

                UiLFBScrollerPrintMultiPageHugeDocTest(bankUser, PDF).withId(T2424::class),
                UiLFBScrollerPrintMultiPageHugeDocTest(bankUser, RTF).withId(T4791::class),

                UiLFBScrollerPrintWithManyAttachmentsTest(bankUser, PDF).withId(T2425::class),
                UiLFBScrollerPrintWithManyAttachmentsTest(bankUser, RTF).withId(T4829::class),

                UiLFBScrollerPrintTableTest(bankUser, HTML).withId(T2418::class),
                UiLFBScrollerPrintTableTest(bankUser, PDF).withId(T2421::class),
                UiLFBScrollerPrintTableTest(bankUser, RTF).withId(T2419::class),

                UiLFBScrollerPrintTableMultiPageTest(bankUser, PDF).withId(T2420::class),
                UiLFBScrollerPrintTableMultiPageTest(bankUser, RTF).withPriority(Low).withId(T4792::class),
            )
        )
    }

    @T3845 //Письмо из Банка. Проверка наличия реквизитов в ПФ. (из скроллера).[на принтер]. [CLIENT]
    @T3846 //Письмо из Банка. Проверка наличия реквизитов в ПФ. (из скроллера).[в файл pdf]. [CLIENT]
    @T3849 //Письмо из Банка. Проверка наличия реквизитов в ПФ. (из скроллера).[в файл rtf]. [CLIENT]
    @T3847 //Письмо из Банка. Проверка наличия реквизитов в ПФ. (из скроллера).[в файл pdf]. 2 страницы. [CLIENT]
    @T4793 //Письмо из Банка. Проверка наличия реквизитов в ПФ. (из скроллера).[в файл rtf]. 2 страницы. [CLIENT]
    @T3848 //Письмо из Банка. Проверка наличия реквизитов в ПФ. (из скроллера).[в файл pdf]. Количество вложений > 5. [CLIENT]
    @T4830 //Письмо из Банка. Проверка наличия реквизитов в ПФ. (из скроллера).[в файл rtf]. Количество вложений > 5. [CLIENT]
    @T4139 //Письмо из Банка. Проверка наличия реквизитов. Печать реестра. [на принтер]. [CLIENT]
    @T4142 //Письмо из Банка. Проверка наличия реквизитов. Печать реестра. [в файл pdf]. [CLIENT]
    @T4140 //Письмо из Банка. Проверка наличия реквизитов. Печать реестра. [в файл rtf]. [CLIENT]
    @T4141 //Письмо из Банка. Проверка наличия реквизитов. Печать реестра. [в файл pdf]. 2 и более страницы. [CLIENT]
    @T4794 //Письмо из Банка. Проверка наличия реквизитов. Печать реестра. [в файл rtf]. 2 и более страницы. [CLIENT]
    @TestFactory
    internal fun letterFromBankScrollerPrintClientTests(): List<DynamicTest> {
        val clientUser by lazy { Users.client }
        return EntityTestGenerator.generate(
            listOf(
                UiLFBScrollerPrintTest(clientUser, HTML).withId(T3845::class),
                UiLFBScrollerPrintTest(clientUser, PDF).withId(T3846::class),
                UiLFBScrollerPrintTest(clientUser, RTF).withId(T3849::class),

                UiLFBScrollerPrintMultiPageHugeDocTest(clientUser, PDF).withId(T3847::class),
                UiLFBScrollerPrintMultiPageHugeDocTest(clientUser, RTF).withId(T4793::class),

                UiLFBScrollerPrintWithManyAttachmentsTest(clientUser, PDF).withId(T3848::class),
                UiLFBScrollerPrintWithManyAttachmentsTest(clientUser, RTF).withId(T4830::class),

                UiLFBScrollerPrintTableTest(clientUser, HTML).withId(T4139::class),
                UiLFBScrollerPrintTableTest(clientUser, PDF).withId(T4142::class),
                UiLFBScrollerPrintTableTest(clientUser, RTF).withId(T4140::class),

                UiLFBScrollerPrintTableMultiPageTest(clientUser, PDF).withId(T4141::class),
                UiLFBScrollerPrintTableMultiPageTest(clientUser, RTF).withPriority(Low).withId(T4794::class),
            )
        )
    }
}