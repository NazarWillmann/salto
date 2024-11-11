package ooo.jtc.be.news.publication

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_PUBLICATION_CATEGORIES
import ooo.jtc.api.news.publication.PublicationCategoryListTest
import ooo.jtc.api.news.publication.PublicationCategorySummaryCountTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryCorrespondence
import ooo.jtc.generic.DocumentNames
import ooo.jtc.news.PublicationCategory.Companion.bankCategoriesAndStatuses
import ooo.jtc.testdata.Users
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.CORRESPONDENCE)
@Story(TestStoryCorrespondence.CORRESPONDENCE_PUBLICATION_CATEGORIES)
@DisplayName("API '${DocumentNames.PUBLICATION}' categories suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_PUBLICATION_CATEGORIES
class PublicationCategoriesTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T4867") annotation class T4867
@Tag("JTCSALTO-T4868") annotation class T4868
//@formatter:on
//endregion

    private val bankUser by lazy { Users.bankOperator }

    @TestFactory
    @T4867 //'Публикация'. Проверка правильности включения документов в общую категорию [BANK]
    @T4868 //'Публикация'. Получение списка категорий [BANK]
    internal fun publicationCategoriesTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PublicationCategorySummaryCountTest(bankUser).withId(T4867::class),
                PublicationCategoryListTest(bankUser, bankCategoriesAndStatuses.keys.toList()).withId(T4868::class)
            )
        )
    }
}