package ooo.jtc.ui.letters.frombank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import ooo.jtc.UI_LETTER_TO_BANK
import ooo.jtc.api.letters.frombank.LetterFromBankPreExecutions
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.Issues.JTCSALTO_3062
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.DocumentNames
import ooo.jtc.testdata.Users.bankOperator
import ooo.jtc.testdata.Users.client
import ooo.jtc.ui.common.pages.ApplicationPageType.BANK_PAGE
import ooo.jtc.ui.letters.frombank.tests.UiLFBFormCreateTest
import ooo.jtc.ui.letters.frombank.tests.UiLFBFormEditDeleteAttachBankTest
import ooo.jtc.ui.letters.frombank.tests.UiLFBFormEditTabsBankTest
import ooo.jtc.ui.letters.frombank.tests.UiLFBFormViewDeleteAttachBankTest
import ooo.jtc.ui.letters.frombank.tests.UiLFBFormViewDownloadAttachBankTest
import ooo.jtc.ui.letters.frombank.tests.UiLFBFormViewFieldsTest
import ooo.jtc.ui.letters.frombank.tests.UiLFBFormViewHistoryDetailProcessingTest
import ooo.jtc.ui.letters.frombank.tests.UiLFBFormViewHistoryTest
import ooo.jtc.ui.letters.frombank.tests.UiLFBFormViewTabsTest
import ooo.jtc.ui.letters.frombank.tests.UiLTBCreateFormAttachmentTest
import ooo.jtc.ui.letters.frombank.tests.UiLTBCreateFormCustomerAndBranchNameMultiBranchTest
import ooo.jtc.ui.letters.frombank.tests.UiLTBCreateFormCustomerAndBranchNameOneBranchTest
import ooo.jtc.ui.letters.frombank.tests.UiLTBCreateFormNumberDateStatusTest
import ooo.jtc.ui.letters.frombank.tests.UiLTBCreateFormThemeAndTextTest
import ooo.jtc.ui.letters.frombank.tests.UiLTBCreateFormTypeDescriptionTest
import ooo.jtc.ui.letters.frombank.tests.UiLetterFromBankScrollerHistoryTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.UI)
@Feature(TestFeature.LETTER_FROM_BANK)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("UI. ${DocumentNames.LETTER_FROM_BANK} тесты на экранную форму")
@UI_LETTER_TO_BANK
class UiLetterFromBankFormTestSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3253") annotation class T3253
@Tag("JTCSALTO-T4111") annotation class T4111
@Tag("JTCSALTO-T4131") annotation class T4131
@Tag("JTCSALTO-T4136") annotation class T4136
@Tag("JTCSALTO-T4137") annotation class T4137
@Tag("JTCSALTO-T4113") annotation class T4113
@Tag("JTCSALTO-T4116") annotation class T4116
@Tag("JTCSALTO-T4109") annotation class T4109
@Tag("JTCSALTO-T4117") annotation class T4117
@Tag("JTCSALTO-T4119") annotation class T4119
@Tag("JTCSALTO-T4120") annotation class T4120
@Tag("JTCSALTO-T4450") annotation class T4450

@Tag("JTCSALTO-T4121") annotation class T4121
@Tag("JTCSALTO-T4122") annotation class T4122
@Tag("JTCSALTO-T4123") annotation class T4123
@Tag("JTCSALTO-T4124") annotation class T4124
@Tag("JTCSALTO-T4125") annotation class T4125
@Tag("JTCSALTO-T4783") annotation class T4783
//@formatter:on
//endregion

    private val bankUser by lazy { bankOperator }
    private val clientUser by lazy { client }

    @TestFactory
    @T3253 //Письмо из Банка. Форма просмотра. Закладка История изменений. [Банк]
    @T4111 //Письмо из Банка. Просмотреть историю изменений документа из скроллера. [Банк]
    @T4131 //Письмо из Банка. Форма просмотра. Закладка История изменений. Просмотр сведений о результатах отправки Клиенту. DetailsError. [Банк]
    @T4136 //Письмо из Банка. Форма просмотра. Закладка История изменений. Просмотр сведений о результатах отправки Клиенту. WrongESignature. [Банк]
    @T4137 //Письмо из Банка. Форма просмотра. Закладка История изменений. Просмотр сведений о результатах отправки Клиенту. Delivered. [Банк]
    internal fun uiLetterFromBankFormHistoryBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                UiLFBFormViewHistoryTest(
                    user = bankUser,
                    preExecution = { LetterFromBankPreExecutions.LFBPreExecutionDelivered.invoke(bankUser) },
                    pageType = BANK_PAGE
                ).withId(T3253::class),
                UiLetterFromBankScrollerHistoryTest(
                    user = bankUser,
                    preExecution = { LetterFromBankPreExecutions.LFBPreExecutionSigned.invoke(bankUser) },
                    pageType = BANK_PAGE
                ).withId(T4111::class),
                UiLFBFormViewHistoryDetailProcessingTest(
                    statusForName = "DetailsError",
                    user = bankUser,
                    preExecution = { LetterFromBankPreExecutions.LFBPreExecutionDetailsError.invoke(bankUser) },
                    pageType = BANK_PAGE
                ).withId(T4131::class),
                UiLFBFormViewHistoryDetailProcessingTest(
                    statusForName = "WrongESignature",
                    user = bankUser,
                    preExecution = { LetterFromBankPreExecutions.LFBPreExecutionWrongESignature.invoke(bankUser) },
                    pageType = BANK_PAGE
                ).withId(T4136::class),
                UiLFBFormViewHistoryDetailProcessingTest(
                    statusForName = "Delivered",
                    user = bankUser,
                    preExecution = { LetterFromBankPreExecutions.LFBPreExecutionDelivered.invoke(bankUser) },
                    pageType = BANK_PAGE
                ).withId(T4137::class),
            )
        )
    }

    @T4450 //Письмо из банка. Создание документа. Успешный сценарий [Банк]
    @T4113 //Письмо из банка. Форма просмотра. Закладка Основные реквизиты. Проверка отображения всех полей. [Банк]
    @T4116 //Письмо из банка. Форма просмотра. Закладка Основные реквизиты. Отображение вкладок. [Банк]
    @T4109 //Письмо из банка. Форма просмотра. Работа с вложениями. Скачать. [Банк]
    @T4117 //Письмо из банка. Форма просмотра. Работа с вложениями. Удаление. [Банк]
    @T4119 //Письмо из банка. Отображение вкладок на форме редактирования. [Банк]
    @T4120 //Письмо из банка. Форма Редактирования. Работа с вложениями. Удаление. [Банк]
    @TestFactory
    internal fun uiLetterFromBankFormTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                UiLFBFormCreateTest(bankUser).withId(T4450::class).withIssues(JTCSALTO_3062),
                UiLFBFormViewFieldsTest(bankUser).withId(T4113::class),
                UiLFBFormViewTabsTest(
                    user = bankUser,
                    preExecution = { LetterFromBankPreExecutions.LFBPreExecutionSigned(bankUser) },
                    pageType = BANK_PAGE
                ).withId(T4116::class),
                UiLFBFormViewDownloadAttachBankTest(bankUser).withId(T4109::class),
                UiLFBFormViewDeleteAttachBankTest(bankUser).withId(T4117::class),
                UiLFBFormEditTabsBankTest(bankUser, clientUser).withId(T4119::class),
                UiLFBFormEditDeleteAttachBankTest(bankUser).withId(T4120::class)
            )
        )
    }

    @T4121 //[Банк] Письмо из банка. ЭФ создания документа. Поля Номер, Дата, Статус
    @T4122 //[Банк] Письмо из банка. ЭФ создания документа. Область выбора файла для загрузки
    @T4123 //[Банк] Письмо из банка. ЭФ создания документа. Поле Тема и Текст
    @T4124 //[Банк] Письмо из банка. ЭФ создания документа. Поле Тип письма
    @T4125 //[Банк] Письмо из банка. ЭФ создания документа. Поля Отправитель и Получатель. Пользователь привязан к 1 Подразделению (поле Отправитель)
    @T4783 //[Банк] Письмо из банка. ЭФ создания документа. Поля Отправитель и Получатель. Пользователь является представителем нескольких подразделений Банка(поле Отправитель)
    @TestFactory
    internal fun uiLetterFromBankCreateFormTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                UiLTBCreateFormNumberDateStatusTest(bankUser).withId(T4121::class).withIssues(JTCSALTO_3062),
                UiLTBCreateFormAttachmentTest(bankUser).withId(T4122::class),
                UiLTBCreateFormThemeAndTextTest(bankUser).withId(T4123::class),
                UiLTBCreateFormTypeDescriptionTest(bankUser).withId(T4124::class),
                UiLTBCreateFormCustomerAndBranchNameOneBranchTest().withId(T4125::class),
                UiLTBCreateFormCustomerAndBranchNameMultiBranchTest().withId(T4783::class),
            )
        )
    }
}