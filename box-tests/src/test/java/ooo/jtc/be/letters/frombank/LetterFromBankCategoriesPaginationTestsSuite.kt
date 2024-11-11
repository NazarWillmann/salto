package ooo.jtc.be.letters.frombank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_FROM_BANK_CATEGORIES
import ooo.jtc.api.letters.frombank.tests.LetterFromBankCategoryListTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankCategorySummaryCountTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankCategoryTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankPaginationTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterFromBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.model.LetterFromBankCategory
import ooo.jtc.letters.model.LetterFromBankCategory.Companion.bankCategoriesAndStatuses
import ooo.jtc.letters.model.LetterFromBankCategory.Companion.clientCategoriesAndStatuses
import ooo.jtc.testdata.Users
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.LETTER_FROM_BANK)
@Story(TestStoryLetterFromBank.LETTER_FROM_BANK_CATEGORIES)
@DisplayName("API '${DocumentNames.LETTER_FROM_BANK}' categories suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_FROM_BANK_CATEGORIES
class LetterFromBankCategoriesPaginationTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T4017") annotation class T4017
@Tag("JTCSALTO-T4018") annotation class T4018
@Tag("JTCSALTO-T4019") annotation class T4019
@Tag("JTCSALTO-T4020") annotation class T4020
@Tag("JTCSALTO-T4021") annotation class T4021
@Tag("JTCSALTO-T5263") annotation class T5263
@Tag("JTCSALTO-T5264") annotation class T5264
@Tag("JTCSALTO-T5265") annotation class T5265
@Tag("JTCSALTO-T5266") annotation class T5266
@Tag("JTCSALTO-T5267") annotation class T5267
@Tag("JTCSALTO-T5268") annotation class T5268
@Tag("JTCSALTO-T5269") annotation class T5269
@Tag("JTCSALTO-T5526") annotation class T5526
//@formatter:on
//endregion

    private val clientUser = Users.client
    private val bankUser = Users.bankOperator

    @TestFactory
    @T4018 //'Письмо из Банка'. Проверка правильности включения документов в общую категорию [BANK]
    @T4019 //'Письмо из Банка'. Проверка правильности включения документов в общую категорию [CLIENT]
    @T4020 //'Письмо из Банка'. Получение списка категорий [BANK]
    @T4021 //'Письмо из Банка'. Получение списка категорий [CLIENT]
    internal fun letterCategoryTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankCategorySummaryCountTest(bankUser).withId(T4018::class),
                LetterFromBankCategorySummaryCountTest(clientUser).withId(T4019::class),
                LetterFromBankCategoryListTest(bankUser, bankCategoriesAndStatuses.keys.toList()).withId(T4020::class),
                LetterFromBankCategoryListTest(clientUser, clientCategoriesAndStatuses.keys.toList()).withId(T4021::class)
            )
        )
    }

    @TestFactory
    @Execution(ExecutionMode.SAME_THREAD)
    @T5263 //'Письмо из Банка'. Проверка категории [DRAFT] [BANK]
    @T5264 //'Письмо из Банка'. Проверка категории [FOR_SEND] [BANK]
    @T5265 //'Письмо из Банка'. Проверка категории [FOR_SIGNATURE] [BANK]
    @T5266 //'Письмо из Банка'. Проверка категории [PROBLEMATIC] [BANK]
    @T5267 //'Письмо из Банка'. Проверка категории [DELIVERED] [BANK]
    @T5268 //'Письмо из Банка'. Проверка категории [ALL] [BANK]
    internal fun letterBankCategoriesTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankCategoryTest(bankUser, LetterFromBankCategory.DRAFT).withId(T5263::class),
                LetterFromBankCategoryTest(bankUser, LetterFromBankCategory.FOR_SEND).withId(T5264::class),
                LetterFromBankCategoryTest(bankUser, LetterFromBankCategory.FOR_SIGNATURE).withId(T5265::class),
                LetterFromBankCategoryTest(bankUser, LetterFromBankCategory.PROBLEMATIC).withId(T5266::class),
                LetterFromBankCategoryTest(bankUser, LetterFromBankCategory.DELIVERED).withId(T5267::class),
                LetterFromBankCategoryTest(bankUser, LetterFromBankCategory.ALL).withId(T5268::class)
            )
        )
    }

    @TestFactory
    @Execution(ExecutionMode.SAME_THREAD)
    @T5269 //'Письмо из Банка'. Проверка категории [ALL] [CLIENT]
    internal fun letterClientCategoriesTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankCategoryTest(clientUser, LetterFromBankCategory.ALL).withId(T5269::class)
            )
        )
    }
    @TestFactory
    @T4017 //'Письмо из Банка'. Проверка пагинации [BANK]
    @T5526 //'Письмо из Банка'. Проверка пагинации [CLIENT]
    internal fun letterPaginationTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankPaginationTest(bankUser).withId(T4017::class),
                LetterFromBankPaginationTest(clientUser).withId(T5526::class)
            )
        )
    }
}
