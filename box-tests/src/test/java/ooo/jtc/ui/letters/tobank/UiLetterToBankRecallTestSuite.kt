package ooo.jtc.ui.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Issue
import io.qameta.allure.Story
import ooo.jtc.UI_LETTER_TO_BANK_RECALL
import ooo.jtc.UI_LETTER_TO_BANK_SCROLLER
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.Issues.JTCSALTO_3044
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.testdata.Users
import ooo.jtc.ui.letters.tobank.tests.UiLTBBankRecallControlEmptyReasonTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBBankRecallControlForbiddenSymbolsTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBBankRecallControlReasonTooBigTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormBankRecallTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerBankRecallSingleGroupTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerBankRecallTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.UI)
@Feature(TestFeature.LETTER_TO_BANK)
@Story(TestStoryLetterToBank.LETTER_TO_BANK_RECALL)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("UI. ${DocumentNames.LETTER_TO_BANK} тесты на отзыв")
@UI_LETTER_TO_BANK_RECALL
class UiLetterToBankRecallTestSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T1762") annotation class T1762
@Tag("JTCSALTO-T4162") annotation class T4162
@Tag("JTCSALTO-T4163") annotation class T4163
@Tag("JTCSALTO-T4164") annotation class T4164
@Tag("JTCSALTO-T4745") annotation class T4745
@Tag("JTCSALTO-T4746") annotation class T4746
@Tag("JTCSALTO-T4747") annotation class T4747
@Tag("JTCSALTO-T4748") annotation class T4748
@Tag("JTCSALTO-T4749") annotation class T4749
@Tag("JTCSALTO-T4750") annotation class T4750

@Tag("JTCSALTO-T4751") annotation class T4751
@Tag("JTCSALTO-T4752") annotation class T4752
@Tag("JTCSALTO-T4753") annotation class T4753
@Tag("JTCSALTO-T4754") annotation class T4754
@Tag("JTCSALTO-T4755") annotation class T4755

@Tag("JTCSALTO-T4165") annotation class T4165
@Tag("JTCSALTO-T4166") annotation class T4166
@Tag("JTCSALTO-T4167") annotation class T4167

//TODO [2020.10.16 Sergeyev]: @Tag("JTCSALTO-T4168") annotation class T4168//Отзыв документа. Документ в статусе Received. Кнопка Отменить
//@formatter:on
//endregion

    @T1762 // Письмо в Банк. Отзыв документа. Из скроллера (меню строки). Статус Delivered. [BANK]
    @T4162 // Письмо в Банк. Отзыв документа. Из скроллера (меню строки). Статус ForReceiving. [BANK]
    @T4163 // Письмо в Банк. Отзыв документа. Из скроллера (меню строки). Статус ReceivingError. [BANK]
    @T4164 // Письмо в Банк. Отзыв документа. Из скроллера (меню строки). Статус Received. [BANK]
    @T4745 // Письмо в Банк. Отзыв документа. Из скроллера (меню строки). Статус InProcessing. [BANK]
    @T4746 // Письмо в Банк. Отзыв документа. Из скроллера (одиночная операция). Статус Delivered. [BANK]
    @T4747 // Письмо в Банк. Отзыв документа. Из скроллера (одиночная операция). Статус ForReceiving. [BANK]
    @T4748 // Письмо в Банк. Отзыв документа. Из скроллера (одиночная операция). Статус InProcessing. [BANK]
    @T4749 // Письмо в Банк. Отзыв документа. Из скроллера (одиночная операция). Статус Received. [BANK]
    @T4750 // Письмо в Банк. Отзыв документа. Из скроллера (одиночная операция). Статус ReceivingError. [BANK]
    @Issue(JTCSALTO_3044)
    @Execution(ExecutionMode.SAME_THREAD)
    @UI_LETTER_TO_BANK_SCROLLER
    @TestFactory
    internal fun letterToBankScrollerRecallTests(): List<DynamicTest> {
        val bankUser by lazy { Users.bankOperator }
        return EntityTestGenerator.generate(
            listOf(
                UiLTBScrollerBankRecallTest(bankUser, LetterToBankStatus.DELIVERED).withId(T1762::class),
                UiLTBScrollerBankRecallTest(bankUser, LetterToBankStatus.FOR_RECEIVING).withId(T4162::class),
                UiLTBScrollerBankRecallTest(bankUser, LetterToBankStatus.RECEIVING_ERROR).withId(T4163::class),
                UiLTBScrollerBankRecallTest(bankUser, LetterToBankStatus.RECEIVED).withId(T4164::class),
                UiLTBScrollerBankRecallTest(bankUser, LetterToBankStatus.IN_PROCESSING).withId(T4745::class),
                UiLTBScrollerBankRecallSingleGroupTest(bankUser, LetterToBankStatus.DELIVERED).withId(T4746::class),
                UiLTBScrollerBankRecallSingleGroupTest(bankUser, LetterToBankStatus.FOR_RECEIVING).withId(T4747::class),
                UiLTBScrollerBankRecallSingleGroupTest(bankUser, LetterToBankStatus.RECEIVING_ERROR).withId(T4748::class),
                UiLTBScrollerBankRecallSingleGroupTest(bankUser, LetterToBankStatus.RECEIVED).withId(T4749::class),
                UiLTBScrollerBankRecallSingleGroupTest(bankUser, LetterToBankStatus.IN_PROCESSING).withId(T4750::class)
            )
        )
    }

    @T4751 // Письмо в Банк. Отзыв документа. С формы просмотра. Статус Delivered. [BANK]
    @T4752 // Письмо в Банк. Отзыв документа. С формы просмотра. Статус ForReceiving. [BANK]
    @T4753 // Письмо в Банк. Отзыв документа. С формы просмотра. Статус InProcessing. [BANK]
    @T4754 // Письмо в Банк. Отзыв документа. С формы просмотра. Статус Received. [BANK]
    @T4755 // Письмо в Банк. Отзыв документа. С формы просмотра. Статус ReceivingError. [BANK]
    @Issue(JTCSALTO_3044)
    @Execution(ExecutionMode.SAME_THREAD)
    @TestFactory
    internal fun letterToBankFormRecallTests(): List<DynamicTest> {
        val bankUser by lazy { Users.bankOperator }
        return EntityTestGenerator.generate(
            listOf(
                UiLTBFormBankRecallTest(bankUser, LetterToBankStatus.DELIVERED).withId(T4751::class),
                UiLTBFormBankRecallTest(bankUser, LetterToBankStatus.FOR_RECEIVING).withId(T4752::class),
                UiLTBFormBankRecallTest(bankUser, LetterToBankStatus.RECEIVING_ERROR).withId(T4753::class),
                UiLTBFormBankRecallTest(bankUser, LetterToBankStatus.RECEIVED).withId(T4754::class),
                UiLTBFormBankRecallTest(bankUser, LetterToBankStatus.IN_PROCESSING).withId(T4755::class)
            )
        )
    }

    @T4165 // Письмо в Банк. Отзыв документа. Контроли формы. Причина отзыва. Слишком большое значение. [BANK]
    @T4166 // Письмо в Банк. Отзыв документа. Контроли формы. Причина отзыва. Недопустимые символы. [BANK]
    @T4167 // Письмо в Банк. Отзыв документа. Контроли формы. Причина отзыва. Пустое поле. [BANK]
    @TestFactory
    internal fun letterToBankRecallModalControlsTests(): List<DynamicTest> {
        val bankUser by lazy { Users.bankOperator }
        return EntityTestGenerator.generate(
            listOf(
                UiLTBBankRecallControlReasonTooBigTest(bankUser).withId(T4165::class),
                UiLTBBankRecallControlForbiddenSymbolsTest(bankUser).withId(T4166::class),
                UiLTBBankRecallControlEmptyReasonTest(bankUser).withId(T4167::class)
            )
        )
    }
}