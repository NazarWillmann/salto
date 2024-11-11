package ooo.jtc.be.news.mailgroup

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_MAILGROUP
import ooo.jtc.api.news.mailgroup.MailGroupAddToFavoritesTest
import ooo.jtc.api.news.mailgroup.MailGroupCreateTest
import ooo.jtc.api.news.mailgroup.MailGroupDeleteTest
import ooo.jtc.api.news.mailgroup.MailGroupFiltrationTest
import ooo.jtc.api.news.mailgroup.MailGroupGetPageTest
import ooo.jtc.api.news.mailgroup.MailGroupGetTest
import ooo.jtc.api.news.mailgroup.MailGroupPrepareSteps
import ooo.jtc.api.news.mailgroup.MailGroupRemoveFromFavoritesTest
import ooo.jtc.api.news.mailgroup.MailGroupSortingTest
import ooo.jtc.api.news.mailgroup.MailGroupUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryCorrespondence
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.news.mailgroup.MailGroup
import ooo.jtc.news.mailgroup.MailGroupDto
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.news.mailgroup.MailGroupData
import ooo.jtc.testdata.news.mailgroup.MailGroupFilterParams
import ooo.jtc.testdata.news.mailgroup.MailGroupSortingParams.BRANCH_ID
import ooo.jtc.testdata.news.mailgroup.MailGroupSortingParams.BRANCH_NAME
import ooo.jtc.testdata.news.mailgroup.MailGroupSortingParams.CREATED_AT
import ooo.jtc.testdata.news.mailgroup.MailGroupSortingParams.CREATED_USER_NAME
import ooo.jtc.testdata.news.mailgroup.MailGroupSortingParams.ID
import ooo.jtc.testdata.news.mailgroup.MailGroupSortingParams.NAME
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.CORRESPONDENCE)
@Story(TestStoryCorrespondence.CORRESPONDENCE_DICTIONARY_MAILGROUP)
@DisplayName("API '${DictionaryNames.MAIL_GROUP}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_MAILGROUP
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MailGroupTestsSuite {
 //region Tags
//@formatter:off
    @Tag("JTCSALTO-T4856") annotation class T4856
    @Tag("JTCSALTO-T4857") annotation class T4857
    @Tag("JTCSALTO-T4858") annotation class T4858
    @Tag("JTCSALTO-T4859") annotation class T4859
    @Tag("JTCSALTO-T4860") annotation class T4860
    @Tag("JTCSALTO-T4861") annotation class T4861
    @Tag("JTCSALTO-T4862") annotation class T4862
    @Tag("JTCSALTO-T4946") annotation class T4946
    @Tag("JTCSALTO-T4947") annotation class T4947
    @Tag("JTCSALTO-T4948") annotation class T4948
    @Tag("JTCSALTO-T4949") annotation class T4949
    @Tag("JTCSALTO-T4950") annotation class T4950
    @Tag("JTCSALTO-T4951") annotation class T4951
    @Tag("JTCSALTO-T4952") annotation class T4952
    @Tag("JTCSALTO-T4953") annotation class T4953
    @Tag("JTCSALTO-T4954") annotation class T4954
    @Tag("JTCSALTO-T4955") annotation class T4955
    @Tag("JTCSALTO-T4956") annotation class T4956
    @Tag("JTCSALTO-T4957") annotation class T4957
    @Tag("JTCSALTO-T4958") annotation class T4958
    @Tag("JTCSALTO-T4959") annotation class T4959
    @Tag("JTCSALTO-T4960") annotation class T4960
    @Tag("JTCSALTO-T4961") annotation class T4961
    @Tag("JTCSALTO-T4962") annotation class T4962
//@formatter:on
//endregion

    private val bankUser = Users.bankOperator
    private lateinit var testDataScope: TestDataScope<MailGroup>
    private lateinit var dataForFilter: MailGroupDto

    @BeforeAll
    fun prepareTestData() {
        val availableToBank = MailGroupData.searchBy(bankUser).map { it.id!! }
        testDataScope = MailGroupData.withRequiredFields(
            additionalFilter = { it.id!! in availableToBank },
            customCreator = { MailGroupPrepareSteps.createMailGroup(creatorBankUser = bankUser).toModel() }
        )
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T4856 //'Группа рассылки Клиентов'. CRUD: Создаем запись от пользователя [BANK]
    @T4857 //'Группа рассылки Клиентов'. CRUD: Получаем запись по id от пользователя [BANK]
    @T4858 //'Группа рассылки Клиентов'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T4859 //'Группа рассылки Клиентов'. CRUD: Обновляем запись от пользователя [BANK]
    @T4860 //'Группа рассылки Клиентов'. CRUD: Удаляем запись от пользователя [BANK]
    internal fun mailGroupCrudBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                MailGroupCreateTest(bankUser).withId(T4856::class),
                MailGroupGetTest(bankUser).withId(T4857::class),
                MailGroupGetPageTest(bankUser).withId(T4858::class),
                MailGroupUpdateTest(bankUser).withId(T4859::class),
                MailGroupDeleteTest(bankUser).withId(T4860::class)
            )
        )
    }

    @TestFactory
    @T4861 //'Группа рассылки Клиентов': Добавить в избранное [BANK]
    @T4862 //'Группа рассылки Клиентов': Удалить из избранного [BANK]
    internal fun mailGroupFavoritesBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                MailGroupAddToFavoritesTest(bankUser).withId(T4861::class),
                MailGroupRemoveFromFavoritesTest(bankUser).withId(T4862::class)
            )
        )
    }

    @TestFactory
    @T4946 //'Группа рассылки Клиентов'. Сортировка по полю 'id, ASC' [BANK]
    @T4947 //'Группа рассылки Клиентов'. Сортировка по полю 'name, ASC' [BANK]
    @T4948 //'Группа рассылки Клиентов'. Сортировка по полю 'branchId, ASC' [BANK]
    @T4949 //'Группа рассылки Клиентов'. Сортировка по полю 'branchName, ASC' [BANK]
    @T4950 //'Группа рассылки Клиентов'. Сортировка по полю 'createdAt, ASC' [BANK]
    @T4951 //'Группа рассылки Клиентов'. Сортировка по полю 'createdUserName, ASC' [BANK]

    @T4952 //'Группа рассылки Клиентов'. Сортировка по полю 'id, DESC' [BANK]
    @T4953 //'Группа рассылки Клиентов'. Сортировка по полю 'name, DESC' [BANK]
    @T4954 //'Группа рассылки Клиентов'. Сортировка по полю 'branchId, DESC' [BANK]
    @T4955 //'Группа рассылки Клиентов'. Сортировка по полю 'branchName, DESC' [BANK]
    @T4956 //'Группа рассылки Клиентов'. Сортировка по полю 'createdAt, DESC' [BANK]
    @T4957 //'Группа рассылки Клиентов'. Сортировка по полю 'createdUserName, DESC' [BANK]
    internal fun mailGroupSortingBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                MailGroupSortingTest(bankUser, ID::asc).withId(T4946::class),
                MailGroupSortingTest(bankUser, NAME::asc).withId(T4947::class),
                MailGroupSortingTest(bankUser, BRANCH_ID::asc).withId(T4948::class),
                MailGroupSortingTest(bankUser, BRANCH_NAME::asc).withId(T4949::class),
                MailGroupSortingTest(bankUser, CREATED_AT::asc).withId(T4950::class),
                MailGroupSortingTest(bankUser, CREATED_USER_NAME::asc).withId(T4951::class),

                MailGroupSortingTest(bankUser, ID::desc).withId(T4952::class),
                MailGroupSortingTest(bankUser, NAME::desc).withId(T4953::class),
                MailGroupSortingTest(bankUser, BRANCH_ID::desc).withId(T4954::class),
                MailGroupSortingTest(bankUser, BRANCH_NAME::desc).withId(T4955::class),
                MailGroupSortingTest(bankUser, CREATED_AT::desc).withId(T4956::class),
                MailGroupSortingTest(bankUser, CREATED_USER_NAME::desc).withId(T4957::class)
            )
        )
    }

    @TestFactory
    @T4958 //'Группа рассылки Клиентов'. Фильтрация по полю 'id' (eq) [BANK]
    @T4959 //'Группа рассылки Клиентов'. Фильтрация по полю 'name' (eq) [BANK]
    @T4960 //'Группа рассылки Клиентов'. Фильтрация по полю 'name' (contains) [BANK]
    @T4961 //'Группа рассылки Клиентов'. Фильтрация по полю 'createdUserName' (eq) [BANK]
    @T4962 //'Группа рассылки Клиентов'. Фильтрация по полю 'createdUserName' (contains) [BANK]
    internal fun mailGroupFiltrationBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                //Test scope is based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=28606828
                MailGroupFiltrationTest("id equals", bankUser, { dataForFilter },
                    { MailGroupFilterParams.ID.eq(it!!.id!!) }).withId(T4958::class),
                MailGroupFiltrationTest("name equals", bankUser, { dataForFilter },
                    { MailGroupFilterParams.NAME.eq(it!!.name!!) }).withId(T4959::class),
                MailGroupFiltrationTest("name contains", bankUser, { dataForFilter },
                    { MailGroupFilterParams.NAME.contains(it!!.name!!.randomSubstringPf()) }).withId(T4960::class),
                MailGroupFiltrationTest("createdUserName equals", bankUser, { dataForFilter },
                    { MailGroupFilterParams.CREATED_USER_NAME.eq(it!!.createdUserName!!) }).withId(T4961::class),
                MailGroupFiltrationTest("createdUserName contains", bankUser, { dataForFilter },
                    { MailGroupFilterParams.CREATED_USER_NAME.contains(it!!.createdUserName!!.randomSubstringPf()) }).withId(T4962::class),

                //TODO Sergeyev [2020.12.16]: createdAt date filtration + edited fields
//                MailGroupFiltrationTest(
//                    "createdAt ${Predicate.LE} + ${Predicate.GE}", bankUser, { dataForFilter },
//                    {
//                        CREATED_AT.ge(it!!.createdAt.minusDays(1))
//                            .and(CREATED_AT.le(it.createdAt.plusDays(1)))
//                    }),
            )
        )
    }
}