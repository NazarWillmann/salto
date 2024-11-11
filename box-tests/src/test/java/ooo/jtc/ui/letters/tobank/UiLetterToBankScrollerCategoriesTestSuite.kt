package ooo.jtc.ui.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.UI_LETTER_TO_BANK_SCROLLER_CATEGORIES
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.model.LetterToBankCategory
import ooo.jtc.letters.model.LetterToBankCategory.Companion.clientCategoriesAndStatuses
import ooo.jtc.testdata.Users
import ooo.jtc.ui.letters.tobank.tests.UiLetterToBankCategoryTest
import ooo.jtc.ui.pages.documents.lettertobank.scroller.LetterToBankScrollerCategory
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.UI)
@Feature(TestFeature.LETTER_TO_BANK)
@Story(TestStoryLetterToBank.LETTER_TO_BANK_CATEGORIES)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("UI. ${DocumentNames.LETTER_TO_BANK} тесты на категории (скроллер)")
@UI_LETTER_TO_BANK_SCROLLER_CATEGORIES
class UiLetterToBankScrollerCategoriesTestSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T1642") annotation class T1642
@Tag("JTCSALTO-T1643") annotation class T1643
@Tag("JTCSALTO-T1644") annotation class T1644
@Tag("JTCSALTO-T1645") annotation class T1645
@Tag("JTCSALTO-T1646") annotation class T1646
@Tag("JTCSALTO-T1647") annotation class T1647
//@formatter:on
//endregion

    @T1642 // Категории документов. Черновики
    @T1643 // Категории документов. На подпись
    @T1644 // Категории документов. К отправке
    @T1645 // Категории документов. В обработке
    @T1646 // Категории документов. Обработанные
    @T1647 // Категории документов. Все
    @TestFactory
    internal fun letterToBankScrollerCategoryTests(): List<DynamicTest> {
        val clientUser = Users.client
        return EntityTestGenerator.generate(
            listOf(
                UiLetterToBankCategoryTest(
                    clientUser, LetterToBankScrollerCategory.DRAFTS,
                    clientCategoriesAndStatuses.getValue(LetterToBankCategory.DRAFT)
                ).withId(T1642::class),
                UiLetterToBankCategoryTest(
                    clientUser, LetterToBankScrollerCategory.FOR_SIGNATURE,
                    clientCategoriesAndStatuses.getValue(LetterToBankCategory.FOR_SIGNATURE)
                ).withId(T1643::class),
                UiLetterToBankCategoryTest(
                    clientUser, LetterToBankScrollerCategory.FOR_SEND,
                    clientCategoriesAndStatuses.getValue(LetterToBankCategory.FOR_SEND)
                ).withId(T1644::class),
                UiLetterToBankCategoryTest(
                    clientUser, LetterToBankScrollerCategory.IN_PROCESSING,
                    clientCategoriesAndStatuses.getValue(LetterToBankCategory.IN_PROCESSING)
                ).withId(T1645::class),
                UiLetterToBankCategoryTest(
                    clientUser, LetterToBankScrollerCategory.COMPLETED_CLIENT,
                    clientCategoriesAndStatuses.getValue(LetterToBankCategory.COMPLETED)
                ).withId(T1646::class),
                UiLetterToBankCategoryTest(
                    clientUser, LetterToBankScrollerCategory.ALL,
                    clientCategoriesAndStatuses.getValue(LetterToBankCategory.ALL)
                ).withId(T1647::class)
            )
        )
    }
}