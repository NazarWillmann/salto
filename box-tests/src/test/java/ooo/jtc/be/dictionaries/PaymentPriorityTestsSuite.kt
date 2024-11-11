package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_PAYMENTPRIORITY
import ooo.jtc.api.dictionaries.paymentpriority.PaymentPriorityControlTest
import ooo.jtc.api.dictionaries.paymentpriority.PaymentPriorityCreateTest
import ooo.jtc.api.dictionaries.paymentpriority.PaymentPriorityDeleteTest
import ooo.jtc.api.dictionaries.paymentpriority.PaymentPriorityFilterTests
import ooo.jtc.api.dictionaries.paymentpriority.PaymentPriorityGetPageTest
import ooo.jtc.api.dictionaries.paymentpriority.PaymentPriorityGetTest
import ooo.jtc.api.dictionaries.paymentpriority.PaymentPriorityPrepareSteps.getPaymentPriorityDtoForCreate
import ooo.jtc.api.dictionaries.paymentpriority.PaymentPrioritySortingTest
import ooo.jtc.api.dictionaries.paymentpriority.PaymentPriorityUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestConstants.CONTROL_INVALID_CHARS_EXPECT
import ooo.jtc.core.TestConstants.CONTROL_INVALID_CHARS_REQUEST
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.paymentpriority.PaymentPriority
import ooo.jtc.dictionaries.paymentpriority.PaymentPriorityDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.paymentpriority.PaymentPriorityControls
import ooo.jtc.testdata.dictionaries.paymentpriority.PaymentPriorityData
import ooo.jtc.testdata.dictionaries.paymentpriority.PaymentPriorityFilterParams
import ooo.jtc.testdata.dictionaries.paymentpriority.PaymentPrioritySortingParams.CODE
import ooo.jtc.testdata.dictionaries.paymentpriority.PaymentPrioritySortingParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.paymentpriority.PaymentPrioritySortingParams.ID
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
@Story(DictionaryNames.PAYMENT_PRIORITY)
@DisplayName("API '${DictionaryNames.PAYMENT_PRIORITY}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_PAYMENTPRIORITY
@TestInstance(PER_CLASS)
class PaymentPriorityTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T1869") annotation class T1869
@Tag("JTCSALTO-T1870") annotation class T1870
@Tag("JTCSALTO-T1871") annotation class T1871
@Tag("JTCSALTO-T1872") annotation class T1872
@Tag("JTCSALTO-T1873") annotation class T1873
@Tag("JTCSALTO-T1874") annotation class T1874
@Tag("JTCSALTO-T1875") annotation class T1875
@Tag("JTCSALTO-T1876") annotation class T1876
@Tag("JTCSALTO-T1877") annotation class T1877
@Tag("JTCSALTO-T1878") annotation class T1878
@Tag("JTCSALTO-T1879") annotation class T1879
@Tag("JTCSALTO-T1880") annotation class T1880
@Tag("JTCSALTO-T1881") annotation class T1881
@Tag("JTCSALTO-T1882") annotation class T1882
@Tag("JTCSALTO-T1883") annotation class T1883
@Tag("JTCSALTO-T1884") annotation class T1884
@Tag("JTCSALTO-T1885") annotation class T1885
@Tag("JTCSALTO-T1886") annotation class T1886
@Tag("JTCSALTO-T1887") annotation class T1887
@Tag("JTCSALTO-T1888") annotation class T1888
@Tag("JTCSALTO-T1889") annotation class T1889
@Tag("JTCSALTO-T1890") annotation class T1890
@Tag("JTCSALTO-T1891") annotation class T1891
@Tag("JTCSALTO-T1892") annotation class T1892
@Tag("JTCSALTO-T1893") annotation class T1893
@Tag("JTCSALTO-T1894") annotation class T1894
@Tag("JTCSALTO-T1895") annotation class T1895
@Tag("JTCSALTO-T1896") annotation class T1896
@Tag("JTCSALTO-T1897") annotation class T1897
@Tag("JTCSALTO-T1898") annotation class T1898
@Tag("JTCSALTO-T1899") annotation class T1899
@Tag("JTCSALTO-T1900") annotation class T1900
@Tag("JTCSALTO-T1901") annotation class T1901
@Tag("JTCSALTO-T1902") annotation class T1902
@Tag("JTCSALTO-T1903") annotation class T1903
//@formatter:on
//endregion

    private lateinit var dataForFilter: PaymentPriorityDto
    private lateinit var testDataScope: TestDataScope<PaymentPriority>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = PaymentPriorityData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @Execution(ExecutionMode.SAME_THREAD)
    @TestFactory
    @T1875 //'Очередность платежа'. CRUD: Создаем запись от пользователя [BANK]
    @T1876 //'Очередность платежа'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T1877 //'Очередность платежа'. CRUD: Получаем запись по id от пользователя [BANK]
    @T1878 //'Очередность платежа'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T1879 //'Очередность платежа'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T1880 //'Очередность платежа'. CRUD: Удаляем запись от пользователя [BANK]
    @T1892 //'Очередность платежа'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun paymentPriorityCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PaymentPriorityCreateTest().withId(T1875::class),
                PaymentPriorityGetTest(user = Users.client).withId(T1876::class),
                PaymentPriorityGetTest(user = Users.bankAdmin).withId(T1877::class),
                PaymentPriorityGetPageTest(user = Users.client).withId(T1878::class),
                PaymentPriorityGetPageTest(user = Users.bankAdmin).withId(T1879::class),
                PaymentPriorityDeleteTest().withId(T1880::class),
                PaymentPriorityUpdateTest().withId(T1892::class)
            )
        )
    }

    @TestFactory
    @T1886 //'Очередность платежа'. Сортировка по полю 'id, ASC' [CLIENT]
    @T1887 //'Очередность платежа'. Сортировка по полю 'code, ASC' [CLIENT]
    @T1888 //'Очередность платежа'. Сортировка по полю 'description, ASC' [CLIENT]
    @T1889 //'Очередность платежа'. Сортировка по полю 'id, DESC' [CLIENT]
    @T1890 //'Очередность платежа'. Сортировка по полю 'code, DESC' [CLIENT]
    @T1891 //'Очередность платежа'. Сортировка по полю 'description, DESC' [CLIENT]
    internal fun paymentPrioritySortingClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                PaymentPrioritySortingTest(user, ID::asc).withId(T1886::class),
                PaymentPrioritySortingTest(user, CODE::asc).withId(T1887::class),
                PaymentPrioritySortingTest(user, DESCRIPTION::asc).withId(T1888::class),

                PaymentPrioritySortingTest(user, ID::desc).withId(T1889::class),
                PaymentPrioritySortingTest(user, CODE::desc).withId(T1890::class),
                PaymentPrioritySortingTest(user, DESCRIPTION::desc).withId(T1891::class)
            )
        )
    }

    @TestFactory
    @T1869 //'Очередность платежа'. Сортировка по полю 'id, ASC' [BANK]
    @T1870 //'Очередность платежа'. Сортировка по полю 'code, ASC' [BANK]
    @T1871 //'Очередность платежа'. Сортировка по полю 'description, ASC' [BANK]
    @T1872 //'Очередность платежа'. Сортировка по полю 'id, DESC' [BANK]
    @T1873 //'Очередность платежа'. Сортировка по полю 'code, DESC' [BANK]
    @T1874 //'Очередность платежа'. Сортировка по полю 'description, DESC' [BANK]
    internal fun paymentPrioritySortingBankTests(): List<DynamicTest> {
        val user = Users.bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                PaymentPrioritySortingTest(user, ID::asc).withId(T1869::class),
                PaymentPrioritySortingTest(user, CODE::asc).withId(T1870::class),
                PaymentPrioritySortingTest(user, DESCRIPTION::asc).withId(T1871::class),

                PaymentPrioritySortingTest(user, ID::desc).withId(T1872::class),
                PaymentPrioritySortingTest(user, CODE::desc).withId(T1873::class),
                PaymentPrioritySortingTest(user, DESCRIPTION::desc).withId(T1874::class)
            )
        )
    }

    @TestFactory
    @T1881 //'Очередность платежа'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T1882 //'Очередность платежа'. Фильтрация по полю 'code' (eq) [CLIENT]
    @T1883 //'Очередность платежа'. Фильтрация по полю 'code' (contains) [CLIENT]
    @T1884 //'Очередность платежа'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T1885 //'Очередность платежа'. Фильтрация по полю 'description' (contains) [CLIENT]
    internal fun paymentPriorityFiltrationClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                PaymentPriorityFilterTests("id equals", user, { dataForFilter },
                    { PaymentPriorityFilterParams.ID.eq(it!!.id!!) }).withId(T1881::class),
                PaymentPriorityFilterTests("code equals", user, { dataForFilter },
                    { PaymentPriorityFilterParams.CODE.eq(it!!.code!!) }).withId(T1882::class),
                PaymentPriorityFilterTests("code contains", user, { dataForFilter },
                    { PaymentPriorityFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }).withId(T1883::class),
                PaymentPriorityFilterTests("description equals", user, { dataForFilter },
                    { PaymentPriorityFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T1884::class),
                PaymentPriorityFilterTests("description contains", user, { dataForFilter },
                    { PaymentPriorityFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T1885::class)
            )
        )
    }

    @TestFactory
    @T1899 //'Очередность платежа'. Фильтрация по полю 'id' (eq) [BANK]
    @T1900 //'Очередность платежа'. Фильтрация по полю 'code' (eq) [BANK]
    @T1901 //'Очередность платежа'. Фильтрация по полю 'code' (contains) [BANK]
    @T1902 //'Очередность платежа'. Фильтрация по полю 'description' (eq) [BANK]
    @T1903 //'Очередность платежа'. Фильтрация по полю 'description' (contains) [BANK]
    internal fun paymentPriorityFiltrationBankTests(): List<DynamicTest> {
        val user = Users.bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                PaymentPriorityFilterTests("id equals", user, { dataForFilter },
                    { PaymentPriorityFilterParams.ID.eq(it!!.id!!) }).withId(T1899::class),
                PaymentPriorityFilterTests("code equals", user, { dataForFilter },
                    { PaymentPriorityFilterParams.CODE.eq(it!!.code!!) }).withId(T1900::class),
                PaymentPriorityFilterTests("code contains", user, { dataForFilter },
                    { PaymentPriorityFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }).withId(T1901::class),
                PaymentPriorityFilterTests("description equals", user, { dataForFilter },
                    { PaymentPriorityFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T1902::class),
                PaymentPriorityFilterTests("description contains", user, { dataForFilter },
                    { PaymentPriorityFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T1903::class)
            )
        )
    }


    @Execution(ExecutionMode.SAME_THREAD)
    @TestFactory
    @T1893 //'Очередность платежа'. Контроль: Контроль цифрового кода очередности платежа на непустоту. [BANK]
    @T1894 //'Очередность платежа'. Контроль: Контроль длины цифрового кода очередности платежа. [BANK]
    @T1895 //'Очередность платежа'. Контроль: Контроль цифрового кода очередности платежа на допустимые символы. [BANK]
    @T1896 //'Очередность платежа'. Контроль: Контроль описания очередности платежа на непустоту. [BANK]
    @T1897 //'Очередность платежа'. Контроль: Контроль длины описания очередности платежа. [BANK]
    @T1898 //'Очередность платежа'. Контроль: Контроль описания очередности платежа на допустимые символы. [BANK]
    internal fun paymentPriorityControlTests(): List<DynamicTest> {
        val getDto = { getPaymentPriorityDtoForCreate() }
        return EntityTestGenerator.generate(
            listOf(
                PaymentPriorityControlTest(
                    testName = "Контроль цифрового кода очередности платежа на непустоту",
                    preExecution = { getDto.invoke().copy(code = "") },
                    control = PaymentPriorityControls.CODE_EMPTY
                ).withId(T1893::class),
                PaymentPriorityControlTest(
                    testName = "Контроль длины цифрового кода очередности платежа",
                    preExecution = { getDto.invoke().copy(code = "33") },
                    control = PaymentPriorityControls.CODE_MAX_LENGTH.withParams("length" to "1")
                ).withId(T1894::class),
                PaymentPriorityControlTest(
                    testName = "Контроль цифрового кода очередности платежа на допустимые символы",
                    preExecution = { getDto.invoke().copy(code = "1Z,Я ") },
                    control = PaymentPriorityControls.CODE_AVAILABLE_SYMBOLS.withParams("symbols" to "Z;,;Я; ")
                ).withId(T1895::class),
                PaymentPriorityControlTest(
                    testName = "Контроль описания очередности платежа на непустоту",
                    preExecution = { getDto.invoke().copy(description = "") },
                    control = PaymentPriorityControls.DESCRIPTION_EMPTY
                ).withId(T1896::class),
                PaymentPriorityControlTest(
                    testName = "Контроль длины описания очередности платежа",
                    preExecution = { getDto.invoke().copy(description = RandomData("[а-яА-Я№]*").random(256, 500)) },
                    control = PaymentPriorityControls.DESCRIPTION_MAX_LENGTH.withParams("length" to "255")
                ).withId(T1897::class),
                PaymentPriorityControlTest(
                    testName = "Контроль описания очередности платежа на допустимые символы",
                    preExecution = { getDto.invoke().copy(description = CONTROL_INVALID_CHARS_REQUEST) },
                    control = PaymentPriorityControls.DESCRIPTION_AVAILABLE_SYMBOLS.withParams("symbols" to CONTROL_INVALID_CHARS_EXPECT)
                ).withId(T1898::class)
            )
        )
    }
}