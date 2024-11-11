package ooo.jtc.ui.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import ooo.jtc.UI_LETTER_TO_BANK_PROCESS
import ooo.jtc.UI_LETTER_TO_BANK_SCROLLER
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.testdata.Users
import ooo.jtc.ui.letters.tobank.tests.UiLTBBankCancelProcessTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBBankProcessControlEmptyResultTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBBankProcessControlForbiddenSymbolsTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBBankProcessControlProcessResultTooBigTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBBankProcessControlSpacesOnlyTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormBankProcessTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerBankProcessSingleGroupTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBScrollerBankProcessTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.UI)
@Feature(TestFeature.LETTER_TO_BANK)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("UI. ${DocumentNames.LETTER_TO_BANK} тесты на обработку")
@UI_LETTER_TO_BANK_PROCESS
class UiLetterToBankProcessTestSuite {
    //region Tags
//@formatter:off
    @Tag("JTCSALTO-T4170") annotation class T4170
    @Tag("JTCSALTO-T4171") annotation class T4171
    @Tag("JTCSALTO-T4763") annotation class T4763
    @Tag("JTCSALTO-T4764") annotation class T4764
    @Tag("JTCSALTO-T4172") annotation class T4172
    @Tag("JTCSALTO-T4765") annotation class T4765
    @Tag("JTCSALTO-T4173") annotation class T4173
    @Tag("JTCSALTO-T4174") annotation class T4174

//@formatter:on
//endregion

    @T4763 // Письмо в Банк. Обработка документа. Из скроллера (меню строки). [BANK]
    @T4764 // Письмо в Банк. Обработка документа. Из скроллера (одиночная операция). [BANK]
    @Execution(ExecutionMode.SAME_THREAD)
    @UI_LETTER_TO_BANK_SCROLLER
    @TestFactory
    internal fun letterToBankScrollerProcessTests(): List<DynamicTest> {
        val bankUser by lazy { Users.bankOperator }
        return EntityTestGenerator.generate(
            listOf(
                UiLTBScrollerBankProcessTest(bankUser, LetterToBankStatus.IN_PROCESSING).withId(T4763::class),
                UiLTBScrollerBankProcessSingleGroupTest(bankUser, LetterToBankStatus.IN_PROCESSING).withId(T4764::class),
            )
        )
    }

    @T4171 // Письмо в Банк. Обработка документа. С формы просмотра. [BANK]
    @T4170 // Письмо в Банк. Обработка документа. Кнопка Отменить. [BANK]
    @Execution(ExecutionMode.SAME_THREAD)
    @TestFactory
    internal fun letterToBankFormProcessTests(): List<DynamicTest> {
        val bankUser by lazy { Users.bankOperator }
        return EntityTestGenerator.generate(
            listOf(
                UiLTBFormBankProcessTest(bankUser, LetterToBankStatus.IN_PROCESSING).withId(T4171::class),
                UiLTBBankCancelProcessTest(bankUser).withId(T4170::class)
            )
        )
    }

    @T4173 // Письмо в Банк. Обработка документа. Контроли формы. Результат обработки. Проверка длины сообщения. [BANK]
    @T4174 // Письмо в Банк. Обработка документа. Контроли формы. Результат обработки. Недопустимые символы. [BANK]
    @T4172 // Письмо в Банк. Обработка документа. Контроли формы. Результат обработки. Пустое поле. [BANK]
    @T4765 // Письмо в Банк. Обработка документа. Контроли формы. Результат обработки. Только пробелы. [BANK]
    @TestFactory
    internal fun letterToBankRecallModalControlsTests(): List<DynamicTest> {
        val bankUser by lazy { Users.bankOperator }
        return EntityTestGenerator.generate(
            listOf(
                UiLTBBankProcessControlProcessResultTooBigTest(bankUser).withId(T4173::class),
                UiLTBBankProcessControlForbiddenSymbolsTest(bankUser).withId(T4174::class),
                UiLTBBankProcessControlEmptyResultTest(bankUser).withId(T4172::class),
                UiLTBBankProcessControlSpacesOnlyTest(bankUser).withId(T4765::class),
            )
        )
    }
}