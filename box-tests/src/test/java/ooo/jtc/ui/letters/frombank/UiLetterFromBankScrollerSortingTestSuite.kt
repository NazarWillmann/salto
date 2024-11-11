package ooo.jtc.ui.letters.frombank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.UI_LETTER_FROM_BANK_SCROLLER_SORTING
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterFromBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.letters.frombank.UiLetterFromBankSortingParams
import ooo.jtc.ui.common.pages.ApplicationPageType.BANK_PAGE
import ooo.jtc.ui.common.pages.ApplicationPageType.CLIENT_PAGE
import ooo.jtc.ui.letters.frombank.tests.UiLetterFromBankSortingFieldsBankTest
import ooo.jtc.ui.letters.frombank.tests.UiLetterFromBankSortingFieldsClientTest
import ooo.jtc.ui.letters.frombank.tests.UiLetterFromBankSortingTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.UI)
@Feature(TestFeature.LETTER_FROM_BANK)
@Story(TestStoryLetterFromBank.LETTER_FROM_BANK_SORTING)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("UI. ${DocumentNames.LETTER_FROM_BANK} тесты на сортировку (скроллер)")
@UI_LETTER_FROM_BANK_SCROLLER_SORTING
class UiLetterFromBankScrollerSortingTestSuite {
    //region Tags
//@formatter:off
    @Tag("JTCSALTO-T3819") annotation class T3819
    @Tag("JTCSALTO-T3820") annotation class T3820
    @Tag("JTCSALTO-T3817") annotation class T3817

    @Tag("JTCSALTO-T3325") annotation class T3325
    @Tag("JTCSALTO-T3326") annotation class T3326
    @Tag("JTCSALTO-T3327") annotation class T3327
    @Tag("JTCSALTO-T3328") annotation class T3328
//@formatter:on
//endregion
    //TODO Sergeyev [2021.04.02]: add filtration tests

    @T3819 //Письмо из Банка. Сортировка. Список полей. [CLIENT]
    @T3817 //Письмо из Банка. Сортировка по полю 'Дата документа'. [CLIENT]
    @T3820 //Письмо из Банка. Сортировка по полю '№ документа'. [CLIENT]
    @LFBUiFormsClient
    @TestFactory
    internal fun letterToBankScrollerSortingClientTests(): List<DynamicTest> {
        val clientUser = Users.client
        return EntityTestGenerator.generate(
            UiLetterFromBankSortingFieldsClientTest(clientUser).withId(T3819::class),
            UiLetterFromBankSortingTest(clientUser, UiLetterFromBankSortingParams.DOCUMENT_DATE, CLIENT_PAGE).withId(T3817::class),
            UiLetterFromBankSortingTest(clientUser, UiLetterFromBankSortingParams.DOCUMENT_NUMBER, CLIENT_PAGE).withId(T3820::class)
        )
    }

    @T3325 //Письмо из Банка. Сортировка. Список полей. [BANK]
    @T3326 //Письмо из Банка. Сортировка по полю 'Дата документа'. [BANK]
    @T3327 //Письмо из Банка. Сортировка по полю 'Статус'. [BANK]
    @T3328 //Письмо из Банка. Сортировка по полю '№ документа'. [BANK]
    @LFBUiFormsBank
    @TestFactory
    internal fun letterToBankScrollerSortingBankTests(): List<DynamicTest> {
        val bankUser = Users.bankOperator
        return EntityTestGenerator.generate(
            UiLetterFromBankSortingFieldsBankTest(bankUser).withId(T3325::class),
            UiLetterFromBankSortingTest(bankUser, UiLetterFromBankSortingParams.B_DOCUMENT_DATE, BANK_PAGE).withId(T3326::class),
            UiLetterFromBankSortingTest(bankUser, UiLetterFromBankSortingParams.B_STATUS, BANK_PAGE).withId(T3327::class),
            UiLetterFromBankSortingTest(bankUser, UiLetterFromBankSortingParams.B_CUSTOMER_NAME, BANK_PAGE).withId(T3328::class)
        )
    }
}