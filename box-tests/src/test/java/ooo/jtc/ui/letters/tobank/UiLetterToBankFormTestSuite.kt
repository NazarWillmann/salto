package ooo.jtc.ui.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import ooo.jtc.UI_LETTER_TO_BANK
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBPreExecutionReceived
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBPreExecutionSigned
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.model.LetterToBankPrintExportFormat
import ooo.jtc.testdata.Users.bankOperator
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.Users.secondClient
import ooo.jtc.ui.common.pages.ApplicationPageType.BANK_PAGE
import ooo.jtc.ui.common.pages.ApplicationPageType.CLIENT_PAGE
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormCopyTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormCreateTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormEditDeleteAttachClientTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormEditTabsClientTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormSendToBankTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormViewBaseRequisitesFieldsTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormViewClientTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormViewDeleteAttachClientTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormViewDownloadAttachClientTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormViewTabsTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBSignFormRequisitesTest
import ooo.jtc.ui.letters.tobank.tests.UiLetterFormPrintTest
import ooo.jtc.ui.letters.tobank.tests.UiLetterToBankSignFormCancelTest
import ooo.jtc.ui.letters.tobank.tests.UiLetterToBankSignResultFormCloseTest
import ooo.jtc.ui.letters.tobank.tests.UiLetterToBankSignResultFormSendTest
import ooo.jtc.ui.letters.tobank.tests.UiLetterToBankUnSignErrorTest
import ooo.jtc.ui.letters.tobank.tests.UiLetterToBankUnSignOneOfTwoCancelTest
import ooo.jtc.ui.letters.tobank.tests.UiLetterToBankUnSignOneOfTwoTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.UI)
@Feature(TestFeature.LETTER_TO_BANK)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("UI. ${DocumentNames.LETTER_TO_BANK} тесты на экранную форму")
@UI_LETTER_TO_BANK
class UiLetterToBankFormTestSuite {
    //region Tags
//@formatter:off
    @Tag("JTCSALTO-T4388") annotation class T4388
    @Tag("JTCSALTO-T1665") annotation class T1665
    @Tag("JTCSALTO-T4143") annotation class T4143
    @Tag("JTCSALTO-T4144") annotation class T4144
    @Tag("JTCSALTO-T4147") annotation class T4147
    @Tag("JTCSALTO-T4148") annotation class T4148
    @Tag("JTCSALTO-T4149") annotation class T4149
    @Tag("JTCSALTO-T4714") annotation class T4714
    @Tag("JTCSALTO-T4715") annotation class T4715

    @Tag("JTCSALTO-T4439") annotation class T4439
    @Tag("JTCSALTO-T4440") annotation class T4440

    @Tag("JTCSALTO-T1766") annotation class T1766
    @Tag("JTCSALTO-T1767") annotation class T1767
    @Tag("JTCSALTO-T1866") annotation class T1866
    @Tag("JTCSALTO-T1867") annotation class T1867
    @Tag("JTCSALTO-T4224") annotation class T4224
    @Tag("JTCSALTO-T4159") annotation class T4159
    //@formatter:on
//endregion

    @T4388 //Письмо в банк. Создание документа. Успешный сценарий
    @T1665 //Письмо в Банк. Просмотр документа
    @T4143 //Письмо в банк. Форма просмотра. Закладка Основные реквизиты. Отображение вкладок. [Клиент]
    @T4144 //Письмо в банк. Форма редактирования. Закладка Основные реквизиты. Отображение вкладок. [Клиент]
    @T4147 //Письмо в Банк. Форма редактирования. Работа с вложениями. Удаление
    @T4148 //Письмо в Банк. Форма просмотра. Работа с вложениями. Скачать
    @T4149 //Письмо в Банк. Форма просмотра. Работа с вложениями. Удаление
    @T4439 //Письмо в банк. Форма просмотра. Закладка Основные реквизиты. Отображение полей. [Банк]
    @T4440 //Письмо в банк. Форма просмотра. Закладка Основные реквизиты. Отображение вкладок. [Банк]
    @T4714 //Письмо в Банк. Копирование документа из формы. [CLIENT]
    @T4715 //Письмо в Банк. Отправка документа в банк из формы. [CLIENT]
    @TestFactory
    internal fun uiLetterToBankFormTests(): List<DynamicTest> {
        val clientUser = client
        val bankUser = bankOperator
        return EntityTestGenerator.generate(
            listOf(
                UiLTBFormCreateTest(clientUser).withId(T4388::class),
                UiLTBFormViewClientTest(clientUser).withId(T1665::class),
                UiLTBFormViewTabsTest(
                    user = clientUser,
                    preExecution = { LTBPreExecutionSigned(clientUser) },
                    pageType = CLIENT_PAGE
                ).withId(T4143::class),
                UiLTBFormEditTabsClientTest(clientUser).withId(T4144::class),
                UiLTBFormEditDeleteAttachClientTest(clientUser).withId(T4147::class),
                UiLTBFormViewDownloadAttachClientTest(clientUser).withId(T4148::class),
                UiLTBFormViewDeleteAttachClientTest(clientUser).withId(T4149::class),
                UiLTBFormViewTabsTest(
                    user = bankUser,
                    preExecution = { LTBPreExecutionReceived(clientUser) },
                    pageType = BANK_PAGE
                ).withId(T4440::class),
                UiLTBFormViewBaseRequisitesFieldsTest(
                    user = bankUser,
                    preExecution = { LTBPreExecutionReceived(clientUser) },
                    pageType = BANK_PAGE
                ).withId(T4439::class),
                UiLTBFormCopyTest(clientUser).withId(T4714::class),
                UiLTBFormSendToBankTest(clientUser).withId(T4715::class),
            )
        )
    }

    @TestFactory
    internal fun uiLetterToBankFormPrintTests(): List<DynamicTest> {
        val clientUser = client
        val bankUser = bankOperator
        return EntityTestGenerator.generate(
            listOf(
                UiLetterFormPrintTest(clientUser, LetterToBankPrintExportFormat.HTML),
                UiLetterFormPrintTest(clientUser, LetterToBankPrintExportFormat.PDF),
                UiLetterFormPrintTest(clientUser, LetterToBankPrintExportFormat.RTF),

                UiLetterFormPrintTest(bankUser, LetterToBankPrintExportFormat.HTML),
                UiLetterFormPrintTest(bankUser, LetterToBankPrintExportFormat.PDF),
                UiLetterFormPrintTest(bankUser, LetterToBankPrintExportFormat.RTF),
            )
        )
    }

    @T1766 //Письмо в Банк. Форма Подпись. Проверка реквизитов быстрого просмотра. [CLIENT]
    @T1767 //Письмо в банк. Форма Подпись. Действие Отмена. [CLIENT]
    @T1866 //Письмо в банк. Форма Результат подписи. Кнопка Закрыть. [CLIENT]
    @T1867 //Письмо в Банк. Форма Результат подписи. Отправить документ. [CLIENT]
    @T4224 //Письмо в Банк. Снять подпись под одним из двух документов. Продолжить действие. [Клиент]
    @T4159 //Письмо в Банк. Снять подпись под одним из двух документов. Отмена действия. [Клиент]
    @TestFactory
    internal fun uiLetterToBankFormSignTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                UiLTBSignFormRequisitesTest(client).withId(T1766::class),
                UiLetterToBankSignFormCancelTest(client).withId(T1767::class),
                UiLetterToBankSignResultFormCloseTest(client).withId(T1866::class),
                UiLetterToBankSignResultFormSendTest(client).withId(T1867::class),
                UiLetterToBankUnSignOneOfTwoTest(client, secondClient).withId(T4224::class),
                UiLetterToBankUnSignOneOfTwoCancelTest(client, secondClient).withId(T4159::class),
                UiLetterToBankUnSignErrorTest(client).withId(T4159::class),
            )
        )
    }
}