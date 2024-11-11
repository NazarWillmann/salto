package ooo.jtc.ui.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.UI_LETTER_TO_BANK_SCROLLER_ACTIONS
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.testdata.Users
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerCopyExpandPanelTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerCopySingleGroupTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerCopyTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerEditTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerSendToBankExpandPanelTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerSendToBankMultiDocTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerSendToBankSingleDocTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerSendToBankSingleGroupTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerSignExpandPanelTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerSignFormSingleDocTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerSignMultipleGroupTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerSignSingleGroupTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerUnSignFormMultipleDocTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerUnSignFormSingleDocTest
import ooo.jtc.ui.letters.tobank.tests.UiLetterToBankDeleteTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.UI)
@Feature(TestFeature.LETTER_TO_BANK)
@Story(TestStoryLetterToBank.LETTER_TO_BANK_ACTIONS)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("UI. ${DocumentNames.LETTER_TO_BANK} тесты на действия (скроллер)")
@UI_LETTER_TO_BANK_SCROLLER_ACTIONS
class UiLetterToBankScrollerActionsTestSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T1675") annotation class T1675
@Tag("JTCSALTO-T4761") annotation class T4761
@Tag("JTCSALTO-T4762") annotation class T4762
@Tag("JTCSALTO-T1668") annotation class T1668

@Tag("JTCSALTO-T1680") annotation class T1680
@Tag("JTCSALTO-T1681") annotation class T1681

@Tag("JTCSALTO-T1676") annotation class T1676

@Tag("JTCSALTO-T1684") annotation class T1684
@Tag("JTCSALTO-T1685") annotation class T1685
@Tag("JTCSALTO-T4756") annotation class T4756
@Tag("JTCSALTO-T4757") annotation class T4757

@Tag("JTCSALTO-T1666") annotation class T1666
@Tag("JTCSALTO-T1667") annotation class T1667
@Tag("JTCSALTO-T4713") annotation class T4713
@Tag("JTCSALTO-T4712") annotation class T4712
//@formatter:on
//endregion

    @T1668 // Удаление документа
    @TestFactory
    internal fun letterToBankScrollerDeleteActionsTests(): List<DynamicTest> {
        val clientUser by lazy { Users.client }
        return EntityTestGenerator.generate(
            listOf(
                UiLetterToBankDeleteTest(clientUser).withId(T1668::class),
            )
        )
    }


    @T1675 // Письмо в Банк. Форма подписи документа из скроллера (меню строки). [CLIENT]
    @T4761 // Письмо в Банк. Форма подписи документа из скроллера (панель быстрого просмотра). [CLIENT]
    @T4762 // Письмо в Банк. Форма подписи документа из скроллера (одиночная операция). [CLIENT]
    @T1676    //Письмо в Банк. Форма подписи документов из скроллера (групповая операция). [CLIENT]
    @TestFactory
    internal fun letterToBankScrollerSignFormActionsTests(): List<DynamicTest> {
        val clientUser by lazy { Users.client }
        return EntityTestGenerator.generate(
            listOf(
                UiLTBScrollerSignFormSingleDocTest(clientUser).withId(T1675::class),
                UiLTBScrollerSignExpandPanelTest(clientUser).withId(T4761::class),
                UiLTBScrollerSignSingleGroupTest(clientUser).withId(T4762::class),
                UiLTBScrollerSignMultipleGroupTest(clientUser).withId(T1676::class),
            )
        )
    }

    @T1680 // Письмо в Банк. Форма Снять подпись с документа из скроллера (меню строки). [CLIENT]
    @T1681 // Письмо в Банк. Форма Снять подпись с документа из скроллера (групповая операция). [CLIENT]
    @TestFactory
    internal fun letterToBankScrollerUnSignFormActionsTests(): List<DynamicTest> {
        val clientUser by lazy { Users.client }
        return EntityTestGenerator.generate(
            listOf(
                UiLTBScrollerUnSignFormSingleDocTest(clientUser).withId(T1680::class),
                UiLTBScrollerUnSignFormMultipleDocTest(clientUser).withId(T1681::class),
            )
        )
    }

    @T1685 // Письмо в Банк. Отправка документа в банк из скроллера (меню строки). [CLIENT]
    @T4756 // Письмо в Банк. Отправка документа в банк из скроллера (панель быстрого просмотра). [CLIENT]
    @T4757 // Письмо в Банк. Отправка документа в банк из скроллера (одиночная операция). [CLIENT]
    @T1684 // Письмо в Банк. Отправка документов в банк из скроллера (групповая операция). [CLIENT]
    @TestFactory
    internal fun letterToBankScrollerSendToBankActionsTests(): List<DynamicTest> {
        val clientUser by lazy { Users.client }
        return EntityTestGenerator.generate(
            listOf(
                UiLTBScrollerSendToBankSingleDocTest(clientUser).withId(T1685::class),
                UiLTBScrollerSendToBankExpandPanelTest(clientUser).withId(T4756::class),
                UiLTBScrollerSendToBankSingleGroupTest(clientUser).withId(T4757::class),
                UiLTBScrollerSendToBankMultiDocTest(clientUser).withId(T1684::class),
            )
        )
    }

    @T1666 // Письмо в Банк. Редактирование документа из скроллера (меню строки). [CLIENT]
    @TestFactory
    internal fun letterToBankScrollerEditActionsTests(): List<DynamicTest> {
        val clientUser by lazy { Users.client }
        return EntityTestGenerator.generate(
            listOf(
                UiLTBScrollerEditTest(clientUser).withId(T1666::class),
            )
        )
    }

    @T1667 // Письмо в Банк. Копирование документа из скроллера (меню строки). [CLIENT]
    @T4712 // Письмо в Банк. Копирование документа из скроллера (панель быстрого просмотра). [CLIENT]
    @T4713 // Письмо в Банк. Копирование документа из скроллера (одиночная операция). [CLIENT]
    @TestFactory
    internal fun letterToBankScrollerCopyActionsTests(): List<DynamicTest> {
        val clientUser by lazy { Users.client }
        return EntityTestGenerator.generate(
            listOf(
                UiLTBScrollerCopyTest(clientUser).withId(T1667::class),
                UiLTBScrollerCopyExpandPanelTest(clientUser).withId(T4712::class),
                UiLTBScrollerCopySingleGroupTest(clientUser).withId(T4713::class),
            )
        )
    }
}