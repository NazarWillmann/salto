package ooo.jtc.ui.letters.frombank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import ooo.jtc.UI_LETTER_FROM_BANK_TABS
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.DocumentNames
import ooo.jtc.testdata.Users
import ooo.jtc.ui.letters.frombank.tests.UiLFBFormViewSignatureStatusDeliveredBankTest
import ooo.jtc.ui.letters.frombank.tests.UiLFBFormViewSignatureStatusDraftTest
import ooo.jtc.ui.letters.frombank.tests.UiLFBFormViewSignatureStatusNewTest
import ooo.jtc.ui.letters.frombank.tests.UiLFBFormViewSignatureStatusSignedTest
import ooo.jtc.ui.letters.frombank.tests.UiLFBUnsignTest
import ooo.jtc.ui.letters.frombank.tests.UiLetterFromBankSignResultFormCloseTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.UI)
@Feature(TestFeature.LETTER_FROM_BANK)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("UI. ${DocumentNames.LETTER_FROM_BANK} тесты на вкладки экранной формы")
@UI_LETTER_FROM_BANK_TABS
class UiLetterFromBankTabsTestSuite {
    //region Tags
//@formatter:off
    /* signatures tab*/
    @Tag("JTCSALTO-T4729") annotation class T4729
    @Tag("JTCSALTO-T4730") annotation class T4730
    @Tag("JTCSALTO-T4731") annotation class T4731
    @Tag("JTCSALTO-T4735") annotation class T4735
    @Tag("JTCSALTO-T4088") annotation class T4088
    @Tag("JTCSALTO-T4819") annotation class T4819
    //@formatter:on
//endregion


    @T4729 //Письмо из банка. Форма просмотра. Закладка Подписи. Информация об отсутствии подписей. New. [ Банк]
    @T4730 //Письмо из банка. Форма просмотра. Закладка Подписи. Информация об отсутствии подписей. Статус Draft [ Банк]
    @T4731 //Письмо из банка. Форма просмотра. Закладка Подписи. Информация об отсутствии подписей. Статус отличный от Draft и New. [ Банк]
    @T4735 //[Банк] Письмо из банка. Отображение полей, содержащих сведения о подписи (если список подписей не пуст). Документ в статусе Singed. Подписан Сертификатом
    @T4088 //[Банк] Письмо из банка. Отображение полей, содержащих сведения о подписи (если список подписей не пуст). Документ в статусах выше Singed. Подписан Сертификатом
    @T4819 //[Банк] Письмо из банка. Снятие подписи
    @TestFactory
    internal fun uiLetterFromBankFormSignaturesTests(): List<DynamicTest> {
        val bankUser = Users.bankOperator
        return EntityTestGenerator.generate(
            listOf(
                UiLFBFormViewSignatureStatusNewTest(bankUser).withId(T4729::class),
                UiLFBFormViewSignatureStatusDraftTest(bankUser).withId(T4730::class),
                UiLFBFormViewSignatureStatusSignedTest(bankUser).withId(T4735::class),
                UiLFBFormViewSignatureStatusDeliveredBankTest(bankUser).withId(T4088::class),
                UiLFBUnsignTest(bankUser).withId(T4819::class),
            )
        )
    }

    //TODO A.Stykalin [13.11.2020] Этот тест я написал для проверки подписи сертом на банке, но его не было в ТМС.
    // Возможно Лена уже добавила. Ну или стоит добавить.
    @TestFactory
    internal fun uiLetterFromBankFormSignTests(): List<DynamicTest> {
        val bankUser = Users.bankOperator
        return EntityTestGenerator.generate(
            listOf(
                UiLetterFromBankSignResultFormCloseTest(bankUser)
            )
        )
    }
}