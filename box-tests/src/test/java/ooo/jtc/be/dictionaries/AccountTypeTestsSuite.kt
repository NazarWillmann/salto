package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_ACCOUNTTYPE
import ooo.jtc.api.dictionaries.accounttype.AccountTypeCreateTest
import ooo.jtc.api.dictionaries.accounttype.AccountTypeDeleteTest
import ooo.jtc.api.dictionaries.accounttype.AccountTypeFilterTests
import ooo.jtc.api.dictionaries.accounttype.AccountTypeGetPageTest
import ooo.jtc.api.dictionaries.accounttype.AccountTypeGetTest
import ooo.jtc.api.dictionaries.accounttype.AccountTypeSortingTest
import ooo.jtc.api.dictionaries.accounttype.AccountTypeUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.accountype.AccountType
import ooo.jtc.dictionaries.accountype.AccountTypeDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.accounttype.AccountTypeData
import ooo.jtc.testdata.dictionaries.accounttype.AccountTypeFilterParams.CLIENT_TYPE
import ooo.jtc.testdata.dictionaries.accounttype.AccountTypeFilterParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.accounttype.AccountTypeFilterParams.FULL_NAME
import ooo.jtc.testdata.dictionaries.accounttype.AccountTypeFilterParams.ID
import ooo.jtc.testdata.dictionaries.accounttype.AccountTypeFilterParams.SHORT_NAME
import ooo.jtc.testdata.dictionaries.accounttype.AccountTypeFilterParams.SYSTEM_NAME
import ooo.jtc.testdata.dictionaries.accounttype.AccountTypeSortingParams
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.DICTIONARY)
@Story(DictionaryNames.ACCOUNT_TYPE)
@DisplayName("API '${DictionaryNames.ACCOUNT_TYPE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_ACCOUNTTYPE
@TestInstance(PER_CLASS)
class AccountTypeTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T2972") annotation class T2972
@Tag("JTCSALTO-T2973") annotation class T2973
@Tag("JTCSALTO-T2974") annotation class T2974
@Tag("JTCSALTO-T2975") annotation class T2975
@Tag("JTCSALTO-T2976") annotation class T2976
@Tag("JTCSALTO-T2977") annotation class T2977
@Tag("JTCSALTO-T2978") annotation class T2978
@Tag("JTCSALTO-T2979") annotation class T2979
@Tag("JTCSALTO-T2980") annotation class T2980
@Tag("JTCSALTO-T2981") annotation class T2981
@Tag("JTCSALTO-T2982") annotation class T2982
@Tag("JTCSALTO-T2983") annotation class T2983
@Tag("JTCSALTO-T2984") annotation class T2984
@Tag("JTCSALTO-T2985") annotation class T2985
@Tag("JTCSALTO-T2986") annotation class T2986
@Tag("JTCSALTO-T2987") annotation class T2987
@Tag("JTCSALTO-T2988") annotation class T2988
@Tag("JTCSALTO-T2989") annotation class T2989
@Tag("JTCSALTO-T2990") annotation class T2990
@Tag("JTCSALTO-T2991") annotation class T2991
@Tag("JTCSALTO-T2992") annotation class T2992
@Tag("JTCSALTO-T2993") annotation class T2993
@Tag("JTCSALTO-T2994") annotation class T2994
@Tag("JTCSALTO-T2995") annotation class T2995
@Tag("JTCSALTO-T2996") annotation class T2996
@Tag("JTCSALTO-T2997") annotation class T2997
@Tag("JTCSALTO-T2998") annotation class T2998
@Tag("JTCSALTO-T2999") annotation class T2999
@Tag("JTCSALTO-T3000") annotation class T3000
@Tag("JTCSALTO-T3001") annotation class T3001
@Tag("JTCSALTO-T3002") annotation class T3002
@Tag("JTCSALTO-T3003") annotation class T3003
@Tag("JTCSALTO-T3004") annotation class T3004
@Tag("JTCSALTO-T3005") annotation class T3005
@Tag("JTCSALTO-T3006") annotation class T3006
@Tag("JTCSALTO-T3007") annotation class T3007
@Tag("JTCSALTO-T3008") annotation class T3008
@Tag("JTCSALTO-T3009") annotation class T3009
@Tag("JTCSALTO-T3010") annotation class T3010
@Tag("JTCSALTO-T3011") annotation class T3011
@Tag("JTCSALTO-T3012") annotation class T3012
@Tag("JTCSALTO-T3013") annotation class T3013
@Tag("JTCSALTO-T3014") annotation class T3014
@Tag("JTCSALTO-T3015") annotation class T3015
@Tag("JTCSALTO-T3016") annotation class T3016
@Tag("JTCSALTO-T5364") annotation class T5364
@Tag("JTCSALTO-T5365") annotation class T5365
@Tag("JTCSALTO-T5366") annotation class T5366
@Tag("JTCSALTO-T5367") annotation class T5367
@Tag("JTCSALTO-T5368") annotation class T5368
@Tag("JTCSALTO-T5369") annotation class T5369
@Tag("JTCSALTO-T5370") annotation class T5370
@Tag("JTCSALTO-T5371") annotation class T5371
//@formatter:on
//endregion

    private val bankUser = Users.bankAdmin
    private val clientUser = Users.client
    private lateinit var dataForFilter: AccountTypeDto
    private lateinit var testDataScope: TestDataScope<AccountType>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = AccountTypeData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T2972 //'Тип счета'. CRUD: Создаем запись от пользователя [BANK]
    @T2973 //'Тип счета'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T2974 //'Тип счета'. CRUD: Получаем запись по id от пользователя [BANK]
    @T2975 //'Тип счета'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T2976 //'Тип счета'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T2977 //'Тип счета'. CRUD: Удаляем запись от пользователя [BANK]
    @T2978 //'Тип счета'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun crudTests(): List<DynamicTest> {
        val tests = listOf(
            AccountTypeCreateTest().withId(T2972::class),
            AccountTypeGetTest(user = clientUser).withId(T2973::class),
            AccountTypeGetTest(user = bankUser).withId(T2974::class),
            AccountTypeGetPageTest(user = clientUser).withId(T2975::class),
            AccountTypeGetPageTest(user = bankUser).withId(T2976::class),
            AccountTypeDeleteTest().withId(T2977::class),
            AccountTypeUpdateTest().withId(T2978::class)
        )

        return EntityTestGenerator.generate(tests)
    }

    @TestFactory
    @T2979 //'Тип счета'. Сортировка по полю 'id, ASC' [CLIENT]
    @T2980 //'Тип счета'. Сортировка по полю 'fullName, ASC' [CLIENT]
    @T2981 //'Тип счета'. Сортировка по полю 'shortName, ASC' [CLIENT]
    @T2982 //'Тип счета'. Сортировка по полю 'description, ASC' [CLIENT]
    @T2983 //'Тип счета'. Сортировка по полю 'systemName, ASC' [CLIENT]
    @T5368 //'Тип счета'. Сортировка по полю 'clientType, ASC' [CLIENT]

    @T2984 //'Тип счета'. Сортировка по полю 'id, DESC' [CLIENT]
    @T2985 //'Тип счета'. Сортировка по полю 'fullName, DESC' [CLIENT]
    @T2986 //'Тип счета'. Сортировка по полю 'shortName, DESC' [CLIENT]
    @T2987 //'Тип счета'. Сортировка по полю 'description, DESC' [CLIENT]
    @T2988 //'Тип счета'. Сортировка по полю 'systemName, DESC' [CLIENT]
    @T5369 //'Тип счета'. Сортировка по полю 'clientType, DESC' [CLIENT]
    internal fun clientSortingTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                AccountTypeSortingTest(user, AccountTypeSortingParams.ID::asc).withId(T2979::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.FULL_NAME::asc).withId(T2980::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.SHORT_NAME::asc).withId(T2981::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.DESCRIPTION::asc).withId(T2982::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.SYSTEM_NAME::asc).withId(T2983::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.CLIENT_TYPE::asc).withId(T5368::class),

                AccountTypeSortingTest(user, AccountTypeSortingParams.ID::desc).withId(T2984::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.FULL_NAME::desc).withId(T2985::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.SHORT_NAME::desc).withId(T2986::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.DESCRIPTION::desc).withId(T2987::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.SYSTEM_NAME::desc).withId(T2988::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.CLIENT_TYPE::desc).withId(T5369::class)
            )
        )
    }

    @TestFactory
    @T2989 //'Тип счета'. Сортировка по полю 'id, ASC' [BANK]
    @T2990 //'Тип счета'. Сортировка по полю 'fullName, ASC' [BANK]
    @T2991 //'Тип счета'. Сортировка по полю 'shortName, ASC' [BANK]
    @T2992 //'Тип счета'. Сортировка по полю 'description, ASC' [BANK]
    @T2993 //'Тип счета'. Сортировка по полю 'systemName, ASC' [BANK]
    @T5366 //'Тип счета'. Сортировка по полю 'clientType, ASC' [BANK]

    @T2994 //'Тип счета'. Сортировка по полю 'id, DESC' [BANK]
    @T2995 //'Тип счета'. Сортировка по полю 'fullName, DESC' [BANK]
    @T2996 //'Тип счета'. Сортировка по полю 'shortName, DESC' [BANK]
    @T2997 //'Тип счета'. Сортировка по полю 'description, DESC' [BANK]
    @T2998 //'Тип счета'. Сортировка по полю 'systemName, DESC' [BANK]
    @T5367 //'Тип счета'. Сортировка по полю 'clientType, DESC' [BANK]
    internal fun bankSortingTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                AccountTypeSortingTest(user, AccountTypeSortingParams.ID::asc).withId(T2989::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.FULL_NAME::asc).withId(T2990::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.SHORT_NAME::asc).withId(T2991::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.DESCRIPTION::asc).withId(T2992::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.SYSTEM_NAME::asc).withId(T2993::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.CLIENT_TYPE::asc).withId(T5366::class),

                AccountTypeSortingTest(user, AccountTypeSortingParams.ID::desc).withId(T2994::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.FULL_NAME::desc).withId(T2995::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.SHORT_NAME::desc).withId(T2996::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.DESCRIPTION::desc).withId(T2997::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.SYSTEM_NAME::desc).withId(T2998::class),
                AccountTypeSortingTest(user, AccountTypeSortingParams.CLIENT_TYPE::desc).withId(T5367::class)
            )
        )
    }

    @TestFactory
    @T2999 //'Тип счета'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T3000 //'Тип счета'. Фильтрация по полю 'fullName' (eq) [CLIENT]
    @T3001 //'Тип счета'. Фильтрация по полю 'fullName' (contains) [CLIENT]
    @T3002 //'Тип счета'. Фильтрация по полю 'shortName' (eq) [CLIENT]
    @T3003 //'Тип счета'. Фильтрация по полю 'shortName' (contains) [CLIENT]
    @T3004 //'Тип счета'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T3005 //'Тип счета'. Фильтрация по полю 'description' (contains) [CLIENT]
    @T3006 //'Тип счета'. Фильтрация по полю 'systemName' (eq) [CLIENT]
    @T3007 //'Тип счета'. Фильтрация по полю 'systemName' (contains) [CLIENT]
    @T5370 //'Тип счета'. Фильтрация по полю 'clientType' (eq) [CLIENT]
    @T5371 //'Тип счета'. Фильтрация по полю 'clientType' (contains) [CLIENT]
    internal fun clientFiltrationTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                AccountTypeFilterTests("id equals", user, { dataForFilter },
                    { ID.eq(it!!.id!!) }).withId(T2999::class),
                AccountTypeFilterTests("full name equals", user, { dataForFilter },
                    { FULL_NAME.eq(it!!.fullName) }).withId(T3000::class),
                AccountTypeFilterTests("full name contains", user, { dataForFilter },
                    { FULL_NAME.contains(it!!.fullName.randomSubstringPf()) }).withId(T3001::class),
                AccountTypeFilterTests("short name equals", user, { dataForFilter },
                    { SHORT_NAME.eq(it!!.shortName) }).withId(T3002::class),
                AccountTypeFilterTests("short name contains", user, { dataForFilter },
                    { SHORT_NAME.contains(it!!.shortName.randomSubstringPf()) }).withId(T3003::class),
                AccountTypeFilterTests("description equals", user, { dataForFilter },
                    { DESCRIPTION.eq(it!!.description) }).withId(T3004::class),
                AccountTypeFilterTests("description contains", user, { dataForFilter },
                    { DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T3005::class),
                AccountTypeFilterTests("systemName equals", user, { dataForFilter },
                    { SYSTEM_NAME.eq(it!!.systemName) }).withId(T3006::class),
                AccountTypeFilterTests("systemName contains", user, { dataForFilter },
                    { SYSTEM_NAME.contains(it!!.systemName.randomSubstringPf()) }).withId(T3007::class),
                AccountTypeFilterTests("clientType equals", user, { dataForFilter },
                    { CLIENT_TYPE.eq(it!!.clientType) }).withId(T5370::class),
                AccountTypeFilterTests("clientType contains", user, { dataForFilter },
                    { CLIENT_TYPE.contains(it!!.clientType.randomSubstringPf()) }).withId(T5371::class)
            )
        )
    }

    @TestFactory
    @T3008 //'Тип счета'. Фильтрация по полю 'id' (eq) [BANK]
    @T3009 //'Тип счета'. Фильтрация по полю 'fullName' (eq) [BANK]
    @T3010 //'Тип счета'. Фильтрация по полю 'fullName' (contains) [BANK]
    @T3011 //'Тип счета'. Фильтрация по полю 'shortName' (eq) [BANK]
    @T3012 //'Тип счета'. Фильтрация по полю 'shortName' (contains) [BANK]
    @T3013 //'Тип счета'. Фильтрация по полю 'description' (eq) [BANK]
    @T3014 //'Тип счета'. Фильтрация по полю 'description' (contains) [BANK]
    @T3015 //'Тип счета'. Фильтрация по полю 'systemName' (eq) [BANK]
    @T3016 //'Тип счета'. Фильтрация по полю 'systemName' (contains) [BANK]
    @T5364 //'Тип счета'. Фильтрация по полю 'clientType' (eq) [BANK]
    @T5365 //'Тип счета'. Фильтрация по полю 'clientType' (contains) [BANK]
    internal fun bankFiltrationTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                AccountTypeFilterTests("id equals", user, { dataForFilter },
                    { ID.eq(it!!.id!!) }).withId(T3008::class),
                AccountTypeFilterTests("full name equals", user, { dataForFilter },
                    { FULL_NAME.eq(it!!.fullName) }).withId(T3009::class),
                AccountTypeFilterTests("full name contains", user, { dataForFilter },
                    { FULL_NAME.contains(it!!.fullName.randomSubstringPf()) }).withId(T3010::class),
                AccountTypeFilterTests("short name equals", user, { dataForFilter },
                    { SHORT_NAME.eq(it!!.shortName) }).withId(T3011::class),
                AccountTypeFilterTests("short name contains", user, { dataForFilter },
                    { SHORT_NAME.contains(it!!.shortName.randomSubstringPf()) }).withId(T3012::class),
                AccountTypeFilterTests("description equals", user, { dataForFilter },
                    { DESCRIPTION.eq(it!!.description) }).withId(T3013::class),
                AccountTypeFilterTests("description contains", user, { dataForFilter },
                    { DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T3014::class),
                AccountTypeFilterTests("systemName equals", user, { dataForFilter },
                    { SYSTEM_NAME.eq(it!!.systemName) }).withId(T3015::class),
                AccountTypeFilterTests("systemName contains", user, { dataForFilter },
                    { SYSTEM_NAME.contains(it!!.systemName.randomSubstringPf()) }).withId(T3016::class),
                AccountTypeFilterTests("clientType equals", user, { dataForFilter },
                    { CLIENT_TYPE.eq(it!!.clientType) }).withId(T5364::class),
                AccountTypeFilterTests("clientType contains", user, { dataForFilter },
                    { CLIENT_TYPE.contains(it!!.clientType.randomSubstringPf()) }).withId(T5365::class)
            )
        )
    }
}