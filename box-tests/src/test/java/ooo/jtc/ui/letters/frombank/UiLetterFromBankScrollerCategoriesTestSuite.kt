package ooo.jtc.ui.letters.frombank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.UI_LETTER_FROM_BANK_SCROLLER_CATEGORIES
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.model.LetterFromBankCategory
import ooo.jtc.letters.model.LetterFromBankCategory.Companion.bankCategoriesAndStatuses
import ooo.jtc.testdata.Users
import ooo.jtc.ui.letters.frombank.tests.UiLetterFromBankCategoryTest
import ooo.jtc.ui.pages.documents.letterfrombank.scroller.LetterFromBankScrollerCategory
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.UI)
@Feature(TestFeature.LETTER_FROM_BANK)
@Story(TestStoryLetterToBank.LETTER_TO_BANK_CATEGORIES)
@Execution(ExecutionMode.SAME_THREAD)
@DisplayName("UI. ${DocumentNames.LETTER_FROM_BANK} тесты на категории (скроллер)")
@UI_LETTER_FROM_BANK_SCROLLER_CATEGORIES
class UiLetterFromBankScrollerCategoriesTestSuite {
    //region Tags
//@formatter:off
    @Tag("JTCSALTO-T2747") annotation class T2747
    @Tag("JTCSALTO-T3122") annotation class T3122
    @Tag("JTCSALTO-T3183") annotation class T3183
    @Tag("JTCSALTO-T3245") annotation class T3245
    @Tag("JTCSALTO-T3246") annotation class T3246
    @Tag("JTCSALTO-T3247") annotation class T3247
//@formatter:on
//endregion

    @T2747 // Категории документов. Черновики
    @T3122 // Категории документов. На подпись
    @T3183 // Категории документов. К отправке
    @T3245 // Категории документов. Отправлены
    @T3246 // Категории документов. Проблемные
    @T3247 // Категории документов. Все
    @TestFactory
    internal fun letterToBankScrollerCategoryTests(): List<DynamicTest> {
        val bankUser = Users.bankOperator
        return EntityTestGenerator.generate(
            listOf(
                UiLetterFromBankCategoryTest(
                    bankUser, LetterFromBankScrollerCategory.DRAFTS,
                    bankCategoriesAndStatuses.getValue(LetterFromBankCategory.DRAFT)
                ).withId(T2747::class),
                UiLetterFromBankCategoryTest(
                    bankUser, LetterFromBankScrollerCategory.FOR_SIGNATURE,
                    bankCategoriesAndStatuses.getValue(LetterFromBankCategory.FOR_SIGNATURE)
                ).withId(T3122::class),
                UiLetterFromBankCategoryTest(
                    bankUser, LetterFromBankScrollerCategory.FOR_SEND,
                    bankCategoriesAndStatuses.getValue(LetterFromBankCategory.FOR_SEND)
                ).withId(T3183::class),
                UiLetterFromBankCategoryTest(
                    bankUser, LetterFromBankScrollerCategory.DELIVERED,
                    bankCategoriesAndStatuses.getValue(LetterFromBankCategory.DELIVERED)
                ).withId(T3245::class),
                UiLetterFromBankCategoryTest(
                    bankUser, LetterFromBankScrollerCategory.PROBLEMATIC,
                    bankCategoriesAndStatuses.getValue(LetterFromBankCategory.PROBLEMATIC)
                ).withId(T3246::class),
                UiLetterFromBankCategoryTest(
                    bankUser, LetterFromBankScrollerCategory.ALL,
                    bankCategoriesAndStatuses.getValue(LetterFromBankCategory.ALL)
                ).withId(T3247::class)
            )
        )
    }
}