package ooo.jtc.be.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_TO_BANK_CATEGORIES
import ooo.jtc.api.letters.tobank.tests.LetterToBankCategoryListTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankCategorySummaryCountTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankCategoryTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankPaginationTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.model.LetterToBankCategory
import ooo.jtc.letters.model.LetterToBankCategory.Companion.bankCategoriesAndStatuses
import ooo.jtc.letters.model.LetterToBankCategory.Companion.clientCategoriesAndStatuses
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.testdata.Users
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.LETTER_TO_BANK)
@Story(TestStoryLetterToBank.LETTER_TO_BANK_CATEGORIES)
@DisplayName("API '${DocumentNames.LETTER_TO_BANK}' categories suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_TO_BANK_CATEGORIES
class LetterToBankCategoriesPaginationTestsSuite {
    //region Tags
    //@formatter:off
    @Tag("JTCSALTO-T1937") annotation class T1937
    @Tag("JTCSALTO-T1938") annotation class T1938
    @Tag("JTCSALTO-T1939") annotation class T1939
    @Tag("JTCSALTO-T1940") annotation class T1940
    @Tag("JTCSALTO-T3947") annotation class T3947
    @Tag("JTCSALTO-T3948") annotation class T3948
    @Tag("JTCSALTO-T4176") annotation class T4176
    @Tag("JTCSALTO-T4177") annotation class T4177
    @Tag("JTCSALTO-T4178") annotation class T4178
    @Tag("JTCSALTO-T4179") annotation class T4179
    @Tag("JTCSALTO-T4180") annotation class T4180
    @Tag("JTCSALTO-T4181") annotation class T4181
    @Tag("JTCSALTO-T4182") annotation class T4182
    @Tag("JTCSALTO-T4183") annotation class T4183
    @Tag("JTCSALTO-T4184") annotation class T4184
    @Tag("JTCSALTO-T4185") annotation class T4185
    @Tag("JTCSALTO-T4186") annotation class T4186
    //@formatter:on
    //endregion

    private val clientUser = Users.client
    private val bankUser = Users.bankOperator

    @TestFactory
    @T1937 //'Письмо в Банк'. Проверка правильности включения документов в общую категорию [CLIENT]
    @T1938 //'Письмо в Банк'. Проверка правильности включения документов в общую категорию [BANK]
    @T1939 //'Письмо в Банк'. Получение списка категорий [CLIENT]
    @T1940 //'Письмо в Банк'. Получение списка категорий [BANK]
    internal fun letterCategoryTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankCategorySummaryCountTest(
                    clientUser,
                    ignoreCategories = listOf(LetterToBankCategory.PROBLEM_COMPLETED.category)
                ).withId(T1937::class),
                LetterToBankCategorySummaryCountTest(bankUser).withId(T1938::class),
                LetterToBankCategoryListTest(clientUser, clientCategoriesAndStatuses.keys.toList()).withId(T1939::class),
                LetterToBankCategoryListTest(bankUser, bankCategoriesAndStatuses.keys.toList()).withId(T1940::class)
            )
        )
    }

    @TestFactory
    @Execution(ExecutionMode.SAME_THREAD)
    @T4176 //'Письмо в Банк'. Проверка категории [RECEIVED] [BANK]
    @T4177 //'Письмо в Банк'. Проверка категории [IN_PROCESSING] [BANK]
    @T4178 //'Письмо в Банк'. Проверка категории [COMPLETED] [BANK]
    @T4179 //'Письмо в Банк'. Проверка категории [ALL] [BANK]
    internal fun letterBankCategoriesTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                //системная категория; документы не задерживаются в этих статусах
                //LetterToBankCategoryTest(bankUser, LetterToBankCategory.ON_RECEIVE)
                LetterToBankCategoryTest(bankUser, LetterToBankCategory.RECEIVED).withId(T4176::class),
                LetterToBankCategoryTest(bankUser, LetterToBankCategory.IN_PROCESSING).withId(T4177::class),
                LetterToBankCategoryTest(bankUser, LetterToBankCategory.COMPLETED).withId(T4178::class),
                LetterToBankCategoryTest(bankUser, LetterToBankCategory.ALL).withId(T4179::class)
            )
        )
    }

    @TestFactory
    @Execution(ExecutionMode.SAME_THREAD)
    @T4180 //'Письмо в Банк'. Проверка категории [DRAFT] [CLIENT]
    @T4181 //'Письмо в Банк'. Проверка категории [FOR_SIGNATURE] [CLIENT]
    @T4182 //'Письмо в Банк'. Проверка категории [FOR_SEND] [CLIENT]
    @T4183 //'Письмо в Банк'. Проверка категории [IN_PROCESSING] [CLIENT]
    @T4184 //'Письмо в Банк'. Проверка категории [PROBLEM_COMPLETED] [CLIENT]
    @T4185 //'Письмо в Банк'. Проверка категории [COMPLETED] [CLIENT]
    @T4186 //'Письмо в Банк'. Проверка категории [ALL] [CLIENT]
    internal fun letterClientCategoriesTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankCategoryTest(clientUser, LetterToBankCategory.DRAFT).withId(T4180::class),
                LetterToBankCategoryTest(clientUser, LetterToBankCategory.FOR_SIGNATURE).withId(T4181::class),
                LetterToBankCategoryTest(clientUser, LetterToBankCategory.FOR_SEND).withId(T4182::class),
                LetterToBankCategoryTest(
                    clientUser, LetterToBankCategory.IN_PROCESSING,
                    createLTBInStatus = LetterToBankStatus.RECEIVED
                ).withId(T4183::class),
                LetterToBankCategoryTest(clientUser, LetterToBankCategory.PROBLEM_COMPLETED).withId(T4184::class),
                LetterToBankCategoryTest(clientUser, LetterToBankCategory.COMPLETED).withId(T4185::class),
                LetterToBankCategoryTest(clientUser, LetterToBankCategory.ALL).withId(T4186::class)
            //TODO: схлопывание по пользователю и статусу
            //TODO: история должна быть отсортирована по дате/времени по убыванию
            //https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171628
            //https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171636
            )
        )
    }


    @TestFactory
    @T3947 //'Письмо в Банк'. Проверка пагинации [CLIENT]
    @T3948 //'Письмо в Банк'. Проверка пагинации [BANK]
    internal fun letterPaginationTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankPaginationTest(clientUser).withId(T3947::class),
                LetterToBankPaginationTest(bankUser).withId(T3948::class)
            )
        )
    }
}
