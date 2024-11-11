package ooo.jtc.ui.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.UI_LETTER_TO_BANK_SCROLLER_SORTING
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.Issues
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.letters.tobank.LetterToBankUiSortingParams
import ooo.jtc.ui.common.pages.ApplicationPageType.BANK_PAGE
import ooo.jtc.ui.common.pages.ApplicationPageType.CLIENT_PAGE
import ooo.jtc.ui.letters.tobank.tests.UiLetterToBankSortingFieldsBankTest
import ooo.jtc.ui.letters.tobank.tests.UiLetterToBankSortingFieldsClientTest
import ooo.jtc.ui.letters.tobank.tests.UiLetterToBankSortingTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.UI)
@Feature(TestFeature.LETTER_TO_BANK)
@Story(TestStoryLetterToBank.LETTER_TO_BANK_SORTING)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("UI. ${DocumentNames.LETTER_TO_BANK} тесты на сортировку (скроллер)")
@UI_LETTER_TO_BANK_SCROLLER_SORTING
class UiLetterToBankScrollerSortingTestSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T1662") annotation class T1662
@Tag("JTCSALTO-T1663") annotation class T1663
@Tag("JTCSALTO-T1661") annotation class T1661
@Tag("JTCSALTO-T1660") annotation class T1660

@Tag("JTCSALTO-T1747") annotation class T1747
@Tag("JTCSALTO-T1746") annotation class T1746
@Tag("JTCSALTO-T1745") annotation class T1745
@Tag("JTCSALTO-T1744") annotation class T1744
//@formatter:on
//endregion

    @T1660 // Сортировка. Список полей
    @T1661 // Сортировка по полю № документа
    @T1662 // Сортировка по полю Дата документа
    @T1663 // Сортировка по полю Дата/время создания документа
    @TestFactory
    internal fun letterToBankScrollerSortingClientTests(): List<DynamicTest> {
        val clientUser = Users.client
        return EntityTestGenerator.generate(
            UiLetterToBankSortingFieldsClientTest(clientUser).withId(T1660::class),
            UiLetterToBankSortingTest(clientUser, LetterToBankUiSortingParams.DOCUMENT_NUMBER, CLIENT_PAGE).withId(T1661::class),
            UiLetterToBankSortingTest(clientUser, LetterToBankUiSortingParams.DOCUMENT_DATE, CLIENT_PAGE).withId(T1662::class),
            UiLetterToBankSortingTest(clientUser, LetterToBankUiSortingParams.CREATED_AT, CLIENT_PAGE).withId(T1663::class)
        )
    }


    @T1744 // Сортировка. Список полей. [Банк]
    @T1746 // Сортировка по полю Статус документа. [Банк]
    @T1747 // Сортировка по полю Наименование Клиента. [Банк]
    @T1745 // Сортировка по полю Дата документа. [Банк]
    @TestFactory
    internal fun letterToBankScrollerSortingBankTests(): List<DynamicTest> {
        val clientUser = Users.bankOperator
        return EntityTestGenerator.generate(
            UiLetterToBankSortingFieldsBankTest(clientUser).withId(T1744::class),
            UiLetterToBankSortingTest(clientUser, LetterToBankUiSortingParams.B_STATUS, BANK_PAGE).withId(T1746::class)
                .withIssues(Issues.JTCSALTO_2963),
            UiLetterToBankSortingTest(clientUser, LetterToBankUiSortingParams.B_CUSTOMER_NAME, BANK_PAGE).withId(T1747::class),
            UiLetterToBankSortingTest(clientUser, LetterToBankUiSortingParams.B_DOCUMENT_DATE, BANK_PAGE).withId(T1745::class),

            )
    }


}