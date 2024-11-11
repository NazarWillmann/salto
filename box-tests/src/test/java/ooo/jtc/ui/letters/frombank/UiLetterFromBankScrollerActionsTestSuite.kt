package ooo.jtc.ui.letters.frombank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.UI_LETTER_FROM_BANK_SCROLLER_ACTIONS
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterFromBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.testdata.Users
import ooo.jtc.ui.letters.frombank.tests.UiLFBScrollerAnswerForLFBClientTest
import ooo.jtc.ui.letters.frombank.tests.UiLFBScrollerAvailableActionsClientTest
import ooo.jtc.ui.letters.frombank.tests.UiLFBScrollerViewTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.UI)
@Feature(TestFeature.LETTER_FROM_BANK)
@Story(TestStoryLetterFromBank.LETTER_FROM_BANK_ACTIONS)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("UI. ${DocumentNames.LETTER_FROM_BANK} тесты на действия (скроллер)")
@UI_LETTER_FROM_BANK_SCROLLER_ACTIONS
class UiLetterFromBankScrollerActionsTestSuite {

    //region Tags
//@formatter:off
    @Tag("JTCSALTO-T3826") annotation class T3826
    @Tag("JTCSALTO-T3830") annotation class T3830
    @Tag("JTCSALTO-T3831") annotation class T3831   //TODO Sergeyev [2021.04.05]: update TMS
    @Tag("JTCSALTO-T3832") annotation class T3832
    @Tag("JTCSALTO-T4591") annotation class T4591
//@formatter:on
//endregion


    @T3826 // Письмо из банка. Просмотр документа [Клиент]
    @T3830 // Письмо из банка. Ответ на письмо из банка [Клиент]
    @T4591 // Письмо из банка. Проверка доступных действия из скроллера [Клиент]
    @TestFactory
    internal fun letterFromBankScrollerActionsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                UiLFBScrollerViewTest(Users.client).withId(T3826::class),
                UiLFBScrollerAnswerForLFBClientTest(Users.client).withId(T3830::class),
                UiLFBScrollerAvailableActionsClientTest(Users.client).withId(T4591::class),
            )
        )
    }
}