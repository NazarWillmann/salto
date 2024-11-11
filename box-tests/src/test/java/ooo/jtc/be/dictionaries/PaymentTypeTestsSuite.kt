package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_PAYMENTTYPE
import ooo.jtc.api.dictionaries.paymenttype.PaymentTypeControlTest
import ooo.jtc.api.dictionaries.paymenttype.PaymentTypeCreateTest
import ooo.jtc.api.dictionaries.paymenttype.PaymentTypeDeleteTest
import ooo.jtc.api.dictionaries.paymenttype.PaymentTypeFilterTests
import ooo.jtc.api.dictionaries.paymenttype.PaymentTypeGetPageTest
import ooo.jtc.api.dictionaries.paymenttype.PaymentTypeGetTest
import ooo.jtc.api.dictionaries.paymenttype.PaymentTypeOtherTest
import ooo.jtc.api.dictionaries.paymenttype.PaymentTypePrepareSteps.getPaymentTypeDtoForCreate
import ooo.jtc.api.dictionaries.paymenttype.PaymentTypeSortingTest
import ooo.jtc.api.dictionaries.paymenttype.PaymentTypeSteps
import ooo.jtc.api.dictionaries.paymenttype.PaymentTypeUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.Issues.CONTROL_NOT_IMPLEMENTED
import ooo.jtc.core.TestConstants
import ooo.jtc.core.TestConstants.CONTROL_INVALID_CHARS_REQUEST
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.paymenttype.PaymentType
import ooo.jtc.dictionaries.paymenttype.PaymentTypeDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.random.RandomData
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.paymenttype.PaymentTypeControls
import ooo.jtc.testdata.dictionaries.paymenttype.PaymentTypeData
import ooo.jtc.testdata.dictionaries.paymenttype.PaymentTypeFilterParams
import ooo.jtc.testdata.dictionaries.paymenttype.PaymentTypeSortingParams.CODE
import ooo.jtc.testdata.dictionaries.paymenttype.PaymentTypeSortingParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.paymenttype.PaymentTypeSortingParams.ID
import ooo.jtc.uaa.User
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Disabled
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
@Story(DictionaryNames.PAYMENT_TYPE)
@DisplayName("API '${DictionaryNames.PAYMENT_TYPE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_PAYMENTTYPE
@TestInstance(PER_CLASS)
class PaymentTypeTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T1826") annotation class T1826
@Tag("JTCSALTO-T1827") annotation class T1827
@Tag("JTCSALTO-T1828") annotation class T1828
@Tag("JTCSALTO-T1829") annotation class T1829
@Tag("JTCSALTO-T1830") annotation class T1830
@Tag("JTCSALTO-T1831") annotation class T1831
@Tag("JTCSALTO-T1832") annotation class T1832
@Tag("JTCSALTO-T1833") annotation class T1833
@Tag("JTCSALTO-T1834") annotation class T1834
@Tag("JTCSALTO-T1835") annotation class T1835
@Tag("JTCSALTO-T1836") annotation class T1836
@Tag("JTCSALTO-T1837") annotation class T1837
@Tag("JTCSALTO-T1838") annotation class T1838
@Tag("JTCSALTO-T1839") annotation class T1839
@Tag("JTCSALTO-T1840") annotation class T1840
@Tag("JTCSALTO-T1841") annotation class T1841
@Tag("JTCSALTO-T1842") annotation class T1842
@Tag("JTCSALTO-T1843") annotation class T1843
@Tag("JTCSALTO-T1844") annotation class T1844
@Tag("JTCSALTO-T1845") annotation class T1845
@Tag("JTCSALTO-T1846") annotation class T1846
@Tag("JTCSALTO-T1847") annotation class T1847
@Tag("JTCSALTO-T1848") annotation class T1848
@Tag("JTCSALTO-T1849") annotation class T1849
@Tag("JTCSALTO-T1850") annotation class T1850
@Tag("JTCSALTO-T1851") annotation class T1851
@Tag("JTCSALTO-T1852") annotation class T1852
@Tag("JTCSALTO-T1853") annotation class T1853
@Tag("JTCSALTO-T1854") annotation class T1854
@Tag("JTCSALTO-T1855") annotation class T1855
@Tag("JTCSALTO-T1856") annotation class T1856
@Tag("JTCSALTO-T1857") annotation class T1857
@Tag("JTCSALTO-T1858") annotation class T1858
@Tag("JTCSALTO-T1859") annotation class T1859
@Tag("JTCSALTO-T1860") annotation class T1860
@Tag("JTCSALTO-T1861") annotation class T1861
@Tag("JTCSALTO-T1862") annotation class T1862
@Tag("JTCSALTO-T1863") annotation class T1863
@Tag("JTCSALTO-T1864") annotation class T1864
//@formatter:on
//endregion

    private lateinit var dataForFilter: PaymentTypeDto
    private lateinit var testDataScope: TestDataScope<PaymentType>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = PaymentTypeData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @Execution(ExecutionMode.SAME_THREAD)
    @T1827 //'Вид платежа'. CRUD: Создаем запись от пользователя [BANK]
    @T1833 //'Вид платежа'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T1837 //'Вид платежа'. CRUD: Получаем запись по id от пользователя [BANK]
    @T1840 //'Вид платежа'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T1844 //'Вид платежа'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T1848 //'Вид платежа'. CRUD: Удаляем запись от пользователя [BANK]
    @T1853 //'Вид платежа'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun paymentTypeCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PaymentTypeCreateTest().withId(T1827::class),
                PaymentTypeGetTest(user = Users.client).withId(T1833::class),
                PaymentTypeGetTest(user = Users.bankAdmin).withId(T1837::class),
                PaymentTypeGetPageTest(user = Users.client).withId(T1840::class),
                PaymentTypeGetPageTest(user = Users.bankAdmin).withId(T1844::class),
                PaymentTypeDeleteTest().withId(T1848::class),
                PaymentTypeUpdateTest().withId(T1853::class)
            )
        )
    }

    @TestFactory
    @T1854 //'Вид платежа'. Сортировка по полю 'id, ASC' [CLIENT]
    @T1859 //'Вид платежа'. Сортировка по полю 'code, ASC' [CLIENT]
    @T1862 //'Вид платежа'. Сортировка по полю 'description, ASC' [CLIENT]
    @T1863 //'Вид платежа'. Сортировка по полю 'id, DESC' [CLIENT]
    @T1846 //'Вид платежа'. Сортировка по полю 'code, DESC' [CLIENT]
    @T1851 //'Вид платежа'. Сортировка по полю 'description, DESC' [CLIENT]
    internal fun paymentTypeSortingClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                PaymentTypeSortingTest(user, ID::asc).withId(T1854::class),
                PaymentTypeSortingTest(user, CODE::asc).withId(T1859::class),
                PaymentTypeSortingTest(user, DESCRIPTION::asc).withId(T1862::class),

                PaymentTypeSortingTest(user, ID::desc).withId(T1863::class),
                PaymentTypeSortingTest(user, CODE::desc).withId(T1846::class),
                PaymentTypeSortingTest(user, DESCRIPTION::desc).withId(T1851::class)
            )
        )
    }

    @TestFactory
    @T1852 //'Вид платежа'. Сортировка по полю 'id, ASC' [BANK]
    @T1858 //'Вид платежа'. Сортировка по полю 'code, ASC' [BANK]
    @T1856 //'Вид платежа'. Сортировка по полю 'description, ASC' [BANK]
    @T1847 //'Вид платежа'. Сортировка по полю 'code, DESC' [BANK]
    @T1860 //'Вид платежа'. Сортировка по полю 'id, DESC' [BANK]
    @T1850 //'Вид платежа'. Сортировка по полю 'description, DESC' [BANK]
    internal fun paymentTypeSortingBankTests(): List<DynamicTest> {
        val user = Users.bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                PaymentTypeSortingTest(user, ID::asc).withId(T1852::class),
                PaymentTypeSortingTest(user, CODE::asc).withId(T1858::class),
                PaymentTypeSortingTest(user, DESCRIPTION::asc).withId(T1856::class),

                PaymentTypeSortingTest(user, ID::desc).withId(T1847::class),
                PaymentTypeSortingTest(user, CODE::desc).withId(T1860::class),
                PaymentTypeSortingTest(user, DESCRIPTION::desc).withId(T1850::class)
            )
        )
    }

    @TestFactory
    @T1831 //'Вид платежа'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T1835 //'Вид платежа'. Фильтрация по полю 'code' (eq) [CLIENT]
    @T1839 //'Вид платежа'. Фильтрация по полю 'code' (contains) [CLIENT]
    @T1843 //'Вид платежа'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T1826 //'Вид платежа'. Фильтрация по полю 'description' (contains) [CLIENT]
    internal fun paymentTypeFiltrationClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                PaymentTypeFilterTests("id equals", user, { dataForFilter },
                    { PaymentTypeFilterParams.ID.eq(it!!.id!!) }).withId(T1831::class),
                PaymentTypeFilterTests("code equals", user, { dataForFilter },
                    { PaymentTypeFilterParams.CODE.eq(it!!.code!!) }).withId(T1835::class),
                PaymentTypeFilterTests("code contains", user, { dataForFilter },
                    { PaymentTypeFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }).withId(T1839::class),
                PaymentTypeFilterTests("description equals", user, { dataForFilter },
                    { PaymentTypeFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T1843::class),
                PaymentTypeFilterTests("description contains", user, { dataForFilter },
                    { PaymentTypeFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T1826::class)
            )
        )
    }

    @TestFactory
    @T1832 //'Вид платежа'. Фильтрация по полю 'id' (eq) [BANK]
    @T1834 //'Вид платежа'. Фильтрация по полю 'code' (eq) [BANK]
    @T1838 //'Вид платежа'. Фильтрация по полю 'code' (contains) [BANK]
    @T1842 //'Вид платежа'. Фильтрация по полю 'description' (eq) [BANK]
    @T1829 //'Вид платежа'. Фильтрация по полю 'description' (contains) [BANK]
    internal fun paymentTypeFiltrationBankTests(): List<DynamicTest> {
        val user = Users.bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                PaymentTypeFilterTests("id equals", user, { dataForFilter },
                    { PaymentTypeFilterParams.ID.eq(it!!.id!!) }).withId(T1832::class),
                PaymentTypeFilterTests("code equals", user, { dataForFilter },
                    { PaymentTypeFilterParams.CODE.eq(it!!.code!!) }).withId(T1834::class),
                PaymentTypeFilterTests("code contains", user, { dataForFilter },
                    { PaymentTypeFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }).withId(T1838::class),
                PaymentTypeFilterTests("description equals", user, { dataForFilter },
                    { PaymentTypeFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T1842::class),
                PaymentTypeFilterTests("description contains", user, { dataForFilter },
                    { PaymentTypeFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T1829::class)
            )
        )
    }

    private fun getByCodeAndDescriptionBody(user: User, paymentType: PaymentType) {
        val expCode = paymentType.code
        val expDescription = paymentType.description
        val responseDto = PaymentTypeSteps(user).getByCodeAndDescription(expCode, expDescription)

        "Проверить, что код и описание в списке из ответа соответствуют запросу" {
            assertThat(responseDto.list, Matchers.not(Matchers.empty()))
            responseDto.list!!.forEach {
                assertThat(it.code, Matchers.equalTo(expCode))
                assertThat(it.description, Matchers.equalTo(expDescription))
            }
        }
    }

    private fun getByDescriptionBody(user: User, description: String) {
        val responseDto = PaymentTypeSteps(user).getByDescription(description)

        "Проверить, что описание в списке из ответа соответствуют запросу" {
            assertThat(responseDto.list, Matchers.not(Matchers.empty()))
            responseDto.list!!.forEach {
                assertThat(it.description, Matchers.equalTo(description))
            }
        }
    }

    @TestFactory
    @T1855 //Получить 'Вид платежа' по коду и описанию [CLIENT]
    @T1857 //Получить 'Вид платежа' по коду и описанию [BANK]
    @T1861 //Получить 'Вид платежа' по описанию [CLIENT]
    @T1864 //Получить 'Вид платежа' по описанию [BANK]
    internal fun paymentTypeGetByRequisitesTests(): List<DynamicTest> {
        val testName = "Получить 'Вид платежа'"
        val paymentType4Client = PaymentTypeData.randomOrException()
        val paymentType4Bank = PaymentTypeData.randomOrException()
        val tests = listOf(
            PaymentTypeOtherTest(
                name = "$testName по коду и описанию [${Users.client.userType}]",
                params = { mapOf(PARAM_USER to Users.client, "Вид платежа" to paymentType4Client) },
                testBody = { getByCodeAndDescriptionBody(Users.client, paymentType4Client) }
            ).withId(T1855::class),
            PaymentTypeOtherTest(
                name = "$testName по коду и описанию [${Users.bankAdmin.userType}]",
                params = { mapOf(PARAM_USER to Users.bankAdmin, "Вид платежа" to paymentType4Bank) },
                testBody = { getByCodeAndDescriptionBody(Users.bankAdmin, paymentType4Bank) }
            ).withId(T1857::class),
            PaymentTypeOtherTest(
                name = "$testName по описанию [${Users.client.userType}]",
                params = {
                    mapOf(PARAM_USER to Users.client, "Описание" to paymentType4Client.description)
                },
                testBody = { getByDescriptionBody(Users.client, paymentType4Client.description) }
            ).withId(T1861::class),
            PaymentTypeOtherTest(
                name = "$testName по описанию [${Users.bankAdmin.userType}]",
                params = {
                    mapOf(PARAM_USER to Users.bankAdmin, "Описание" to paymentType4Bank.description)
                },
                testBody = { getByDescriptionBody(Users.bankAdmin, paymentType4Bank.description) }
            ).withId(T1864::class)
        )
        return EntityTestGenerator.generate(tests)
    }

    @TestFactory
    @Disabled(CONTROL_NOT_IMPLEMENTED)
    @T1836 //'Вид платежа'. Контроль: кода вида на непустоту. [BANK]
    @T1841 //'Вид платежа'. Контроль: длины кода вида платежа. [BANK]
    @T1845 //'Вид платежа'. Контроль: кода вида платежа на допустимые символы. [BANK]
    @T1849 //'Вид платежа'. Контроль: описания вида платежа на непустоту. [BANK]
    @T1828 //'Вид платежа'. Контроль: длины описания вида платежа. [BANK]
    @T1830 //'Вид платежа'. Контроль: описания вида платежа на допустимые символы. [BANK]
    internal fun paymentTypeControlTests(): List<DynamicTest> {
        val dto = getPaymentTypeDtoForCreate()
        return EntityTestGenerator.generate(
            listOf(
                PaymentTypeControlTest(
                    testName = "кода вида на непустоту",
                    preExecution = { dto.copy(code = null) },
                    control = PaymentTypeControls.CODE_EMPTY
                ).withId(T1836::class),
                PaymentTypeControlTest(
                    testName = "кода вида на непустоту",
                    preExecution = { dto.copy(code = "") },
                    control = PaymentTypeControls.CODE_EMPTY
                ).withId(T1836::class),
                PaymentTypeControlTest(
                    testName = "кода вида на непустоту",
                    preExecution = { dto.copy(code = "    ") },
                    control = PaymentTypeControls.CODE_EMPTY
                ).withId(T1836::class),
                PaymentTypeControlTest(
                    testName = "длины кода вида платежа",
                    preExecution = { dto.copy(code = "33") },
                    control = PaymentTypeControls.CODE_MAX_LENGTH.withParams("length" to "1")
                ).withId(T1841::class),
                PaymentTypeControlTest(
                    testName = "кода вида платежа на допустимые символы",
                    preExecution = { dto.copy(code = "1ZzЯя! ") },
                    control = PaymentTypeControls.CODE_AVAILABLE_SYMBOLS.withParams("symbols" to "Z;z;Я;я;!; ")
                ).withId(T1845::class),

                PaymentTypeControlTest(
                    testName = "описания вида платежа на непустоту",
                    preExecution = { dto.copy(description = null) },
                    control = PaymentTypeControls.DESCRIPTION_EMPTY
                ).withId(T1849::class),
                PaymentTypeControlTest(
                    testName = "описания вида платежа на непустоту",
                    preExecution = { dto.copy(description = "") },
                    control = PaymentTypeControls.DESCRIPTION_EMPTY
                ).withId(T1849::class),
                PaymentTypeControlTest(
                    testName = "описания вида платежа на непустоту",
                    preExecution = { dto.copy(description = "    ") },
                    control = PaymentTypeControls.DESCRIPTION_EMPTY
                ).withId(T1849::class),

                PaymentTypeControlTest(
                    testName = "длины описания вида платежа",
                    preExecution = { dto.copy(description = RandomData("[а-яА-Я№]*").random(16, 50)) },
                    control = PaymentTypeControls.DESCRIPTION_MAX_LENGTH.withParams("length" to "15")
                ).withId(T1828::class),
                PaymentTypeControlTest(
                    testName = "описания вида платежа на допустимые символы",
                    preExecution = { dto.copy(description = CONTROL_INVALID_CHARS_REQUEST) },
                    control = PaymentTypeControls.DESCRIPTION_AVAILABLE_SYMBOLS
                        .withParams("symbols" to TestConstants.CONTROL_INVALID_CHARS_EXPECT)
                ).withId(T1830::class)
            )
        )
    }
}