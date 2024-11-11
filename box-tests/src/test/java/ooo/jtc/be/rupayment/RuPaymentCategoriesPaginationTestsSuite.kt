package ooo.jtc.be.rupayment

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_RUPAYMENT_CATEGORIES
import ooo.jtc.api.rupayment.tests.RuPaymentCategoryListTest
import ooo.jtc.api.rupayment.tests.RuPaymentPaginationTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryRuPayment
import ooo.jtc.generic.DocumentNames
import ooo.jtc.testdata.Users
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.RUPAYMENT)
@Story(TestStoryRuPayment.RUPAYMENT_CATEGORIES)
@DisplayName("API '${DocumentNames.RU_PAYMENT}' categories suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_RUPAYMENT_CATEGORIES
class RuPaymentCategoriesPaginationTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3841") annotation class T3841
@Tag("JTCSALTO-T3842") annotation class T3842
@Tag("JTCSALTO-T3843") annotation class T3843
//@formatter:on
//endregion

    @TestFactory
    @T3841 //'Рублевое ПП'. Проверка правильности включения документов в общую категорию [CLIENT]
    @T3842 //'Рублевое ПП'. Получение списка категорий [CLIENT]
    internal fun ruPaymentCategoryTests(): List<DynamicTest> {
        val clientUser = Users.client
        return EntityTestGenerator.generate(
            listOf(
                //TODO A.Stykalin [12.08.2020] enable when there will be relevant analytics and development
                // RuPaymentCategorySummaryCountTest(clientUser).withId(T3841::class),
                RuPaymentCategoryListTest(clientUser).withId(T3842::class)
            )
        )
    }

    @TestFactory
    @T3843 //'Рублевое ПП'. Проверка пагинации [CLIENT]
    internal fun ruPaymentPaginationTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                RuPaymentPaginationTest().withId(T3843::class)
            )
        )
    }
}