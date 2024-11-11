package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_KBK
import ooo.jtc.api.dictionaries.kbk.KbkControlTest
import ooo.jtc.api.dictionaries.kbk.KbkCreateTest
import ooo.jtc.api.dictionaries.kbk.KbkDeleteTest
import ooo.jtc.api.dictionaries.kbk.KbkFiltrationTest
import ooo.jtc.api.dictionaries.kbk.KbkGetPageTest
import ooo.jtc.api.dictionaries.kbk.KbkGetTest
import ooo.jtc.api.dictionaries.kbk.KbkPrepareSteps.getKbkDtoForCreate
import ooo.jtc.api.dictionaries.kbk.KbkSortingTest
import ooo.jtc.api.dictionaries.kbk.KbkUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.Issues.CONTROL_NOT_IMPLEMENTED
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.kbk.Kbk
import ooo.jtc.dictionaries.kbk.KbkDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.scripts.soft
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.kbk.KbkControls
import ooo.jtc.testdata.dictionaries.kbk.KbkData
import ooo.jtc.testdata.dictionaries.kbk.KbkFilterParams
import ooo.jtc.testdata.dictionaries.kbk.KbkSortingParams.CODE
import ooo.jtc.testdata.dictionaries.kbk.KbkSortingParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.kbk.KbkSortingParams.ID
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
@Story(DictionaryNames.KBK)
@DisplayName("API '${DictionaryNames.KBK}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_KBK
@TestInstance(PER_CLASS)
class KbkTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T1797") annotation class T1797
@Tag("JTCSALTO-T1798") annotation class T1798
@Tag("JTCSALTO-T1799") annotation class T1799
@Tag("JTCSALTO-T1800") annotation class T1800
@Tag("JTCSALTO-T1801") annotation class T1801
@Tag("JTCSALTO-T1802") annotation class T1802
@Tag("JTCSALTO-T1803") annotation class T1803
@Tag("JTCSALTO-T1804") annotation class T1804
@Tag("JTCSALTO-T1805") annotation class T1805
@Tag("JTCSALTO-T1806") annotation class T1806
@Tag("JTCSALTO-T1807") annotation class T1807
@Tag("JTCSALTO-T1808") annotation class T1808
@Tag("JTCSALTO-T1809") annotation class T1809
@Tag("JTCSALTO-T1810") annotation class T1810
@Tag("JTCSALTO-T1811") annotation class T1811
@Tag("JTCSALTO-T1812") annotation class T1812
@Tag("JTCSALTO-T1813") annotation class T1813
@Tag("JTCSALTO-T1814") annotation class T1814
@Tag("JTCSALTO-T1815") annotation class T1815
@Tag("JTCSALTO-T1816") annotation class T1816
@Tag("JTCSALTO-T1817") annotation class T1817
@Tag("JTCSALTO-T1818") annotation class T1818
@Tag("JTCSALTO-T1819") annotation class T1819
@Tag("JTCSALTO-T1820") annotation class T1820
@Tag("JTCSALTO-T1821") annotation class T1821
@Tag("JTCSALTO-T1822") annotation class T1822
@Tag("JTCSALTO-T1823") annotation class T1823
@Tag("JTCSALTO-T1824") annotation class T1824
@Tag("JTCSALTO-T1825") annotation class T1825
@Tag("JTCSALTO-T5299") annotation class T5299
@Tag("JTCSALTO-T5300") annotation class T5300
@Tag("JTCSALTO-T5301") annotation class T5301
@Tag("JTCSALTO-T5302") annotation class T5302
@Tag("JTCSALTO-T5303") annotation class T5303
@Tag("JTCSALTO-T5304") annotation class T5304
@Tag("JTCSALTO-T5305") annotation class T5305
@Tag("JTCSALTO-T5306") annotation class T5306
@Tag("JTCSALTO-T5307") annotation class T5307
//@formatter:on
//endregion


    private lateinit var dataForFilter: KbkDto
    private lateinit var testDataScope: TestDataScope<Kbk>

    @BeforeAll
    fun prepareTestData() {
        soft {
            testDataScope = KbkData.withRequiredFields()
            dataForFilter = testDataScope.all.random().toDto()
        }
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T1798 //'Код бюджетной классификации'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T1804 //'Код бюджетной классификации'. CRUD: Удаляем запись от пользователя [BANK]
    @T1808 //'Код бюджетной классификации'. CRUD: Обновляем запись от пользователя [BANK]
    @T1812 //'Код бюджетной классификации'. CRUD: Создаем запись от пользователя [BANK]
    @T1816 //'Код бюджетной классификации'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T1817 //'Код бюджетной классификации'. CRUD: Получаем запись по id от пользователя [BANK]
    @T1819 //'Код бюджетной классификации'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    internal fun kbkCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                KbkCreateTest().withId(T1812::class),
                KbkGetTest(user = Users.client).withId(T1816::class),
                KbkGetTest(user = Users.bankAdmin).withId(T1817::class),
                KbkGetPageTest(user = Users.client).withId(T1819::class),
                KbkGetPageTest(user = Users.bankAdmin).withId(T1798::class),
                KbkDeleteTest().withId(T1804::class),
                KbkUpdateTest().withId(T1808::class)
            )
        )
    }

    @TestFactory
    @T1797 //'Код бюджетной классификации'. Сортировка по полю 'code, DESC' [CLIENT]
    @T1801 //'Код бюджетной классификации'. Сортировка по полю 'description, DESC' [CLIENT]
    @T1806 //'Код бюджетной классификации'. Сортировка по полю 'id, ASC' [CLIENT]
    @T1809 //'Код бюджетной классификации'. Сортировка по полю 'code, ASC' [CLIENT]
    @T1814 //'Код бюджетной классификации'. Сортировка по полю 'description, ASC' [CLIENT]
    @T1818 //'Код бюджетной классификации'. Сортировка по полю 'id, DESC' [CLIENT]
    internal fun kbkSortingClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                KbkSortingTest(user, ID::asc).withId(T1806::class),
                KbkSortingTest(user, CODE::asc).withId(T1809::class),
                KbkSortingTest(user, DESCRIPTION::asc).withId(T1814::class),

                KbkSortingTest(user, ID::desc).withId(T1818::class),
                KbkSortingTest(user, CODE::desc).withId(T1797::class),
                KbkSortingTest(user, DESCRIPTION::desc).withId(T1801::class)
            )
        )
    }

    @TestFactory
    @T1820 //'Код бюджетной классификации'. Сортировка по полю 'id, ASC' [BANK]
    @T1821 //'Код бюджетной классификации'. Сортировка по полю 'description, ASC' [BANK]
    @T1822 //'Код бюджетной классификации'. Сортировка по полю 'code, DESC' [BANK]
    @T1823 //'Код бюджетной классификации'. Сортировка по полю 'code, ASC' [BANK]
    @T1824 //'Код бюджетной классификации'. Сортировка по полю 'id, DESC' [BANK]
    @T1825 //'Код бюджетной классификации'. Сортировка по полю 'description, DESC' [BANK]
    internal fun kbkSortingBankTests(): List<DynamicTest> {
        val user = Users.bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                KbkSortingTest(user, ID::asc).withId(T1820::class),
                KbkSortingTest(user, CODE::asc).withId(T1823::class),
                KbkSortingTest(user, DESCRIPTION::asc).withId(T1821::class),

                KbkSortingTest(user, ID::desc).withId(T1824::class),
                KbkSortingTest(user, CODE::desc).withId(T1822::class),
                KbkSortingTest(user, DESCRIPTION::desc).withId(T1825::class)
            )
        )
    }

    @TestFactory
    @T1800 //'Код бюджетной классификации'. Фильтрация по полю 'description' (contains) [CLIENT]
    @T1803 //'Код бюджетной классификации'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T1805 //'Код бюджетной классификации'. Фильтрация по полю 'code' (eq) [CLIENT]
    @T1811 //'Код бюджетной классификации'. Фильтрация по полю 'code' (contains) [CLIENT]
    @T1813 //'Код бюджетной классификации'. Фильтрация по полю 'description' (eq) [CLIENT]
    internal fun kbkFiltrationClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                KbkFiltrationTest("id equals", user, { dataForFilter },
                    { KbkFilterParams.ID.eq(it!!.id!!) }).withId(T1803::class),
                KbkFiltrationTest("code equals", user, { dataForFilter },
                    { KbkFilterParams.CODE.eq(it!!.code!!) }).withId(T1805::class),
                KbkFiltrationTest("code contains", user, { dataForFilter },
                    { KbkFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }).withId(T1811::class),
                KbkFiltrationTest("description equals", user, { dataForFilter },
                    { KbkFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T1813::class),
                KbkFiltrationTest("description contains", user, { dataForFilter },
                    { KbkFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T1800::class)
            )
        )
    }

    @TestFactory
    @T1799 //'Код бюджетной классификации'. Фильтрация по полю 'description' (contains) [BANK]
    @T1802 //'Код бюджетной классификации'. Фильтрация по полю 'id' (eq) [BANK]
    @T1807 //'Код бюджетной классификации'. Фильтрация по полю 'code' (eq) [BANK]
    @T1810 //'Код бюджетной классификации'. Фильтрация по полю 'code' (contains) [BANK]
    @T1815 //'Код бюджетной классификации'. Фильтрация по полю 'description' (eq) [BANK]
    internal fun kbkFiltrationBankTests(): List<DynamicTest> {
        val user = Users.bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                KbkFiltrationTest("id equals", user, { dataForFilter },
                    { KbkFilterParams.ID.eq(it!!.id!!) }).withId(T1802::class),
                KbkFiltrationTest("code equals", user, { dataForFilter },
                    { KbkFilterParams.CODE.eq(it!!.code!!) }).withId(T1807::class),
                KbkFiltrationTest("code contains", user, { dataForFilter },
                    { KbkFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }).withId(T1810::class),
                KbkFiltrationTest("description equals", user, { dataForFilter },
                    { KbkFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T1815::class),
                KbkFiltrationTest("description contains", user, { dataForFilter },
                    { KbkFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T1799::class)
            )
        )
    }

    @TestFactory
    @Disabled(CONTROL_NOT_IMPLEMENTED)
    @T5305 //'Код бюджетной классификации'. Контроль: кода бюджетной классификации на непустоту (null) [BANK]
    @T5299 //'Код бюджетной классификации'. Контроль: кода бюджетной классификации на непустоту (empty) [BANK]
    @T5304 //'Код бюджетной классификации'. Контроль: кода бюджетной классификации на непустоту (spaces) [BANK]
    @T5300 //'Код бюджетной классификации'. Контроль: длины кода бюджетной классификации (меньше требуемого значения) [BANK]
    @T5301 //'Код бюджетной классификации'. Контроль: длины кода бюджетной классификации (больше требуемого значения) [BANK]
    @T5302 //'Код бюджетной классификации'. Контроль: кода бюджетной классификации на допустимые символы [BANK]
    @T5306 //'Код бюджетной классификации'. Контроль: описания кода бюджетной классификации на непустоту (null) [BANK]
    @T5303 //'Код бюджетной классификации'. Контроль: описания кода бюджетной классификации на непустоту (empty) [BANK]
    @T5307 //'Код бюджетной классификации'. Контроль: описания кода бюджетной классификации на непустоту (spaces) [BANK]
    internal fun kbkControlTests(): List<DynamicTest> {
        val getDto = { getKbkDtoForCreate() }
        return EntityTestGenerator.generate(
            listOf(
                KbkControlTest(
                    testName = "кода бюджетной классификации на непустоту (null)",
                    preExecution = { getDto.invoke().copy(code = null) },
                    control = KbkControls.CODE_EMPTY
                ).withId(T5305::class),
                KbkControlTest(
                    testName = "кода бюджетной классификации на непустоту (empty)",
                    preExecution = { getDto.invoke().copy(code = "") },
                    control = KbkControls.CODE_EMPTY
                ).withId(T5299::class),
                KbkControlTest(
                    testName = "кода бюджетной классификации на непустоту (spaces)",
                    preExecution = { getDto.invoke().copy(code = "    ") },
                    control = KbkControls.CODE_EMPTY
                ).withId(T5304::class),
                KbkControlTest(
                    testName = "длины кода бюджетной классификации (меньше требуемого значения)",
                    preExecution = { getDto.invoke().copy(code = digits.random(1, 19)) },
                    control = KbkControls.CODE_MAX_LENGTH.withParams("length" to "20")
                ).withId(T5300::class),
                KbkControlTest(
                    testName = "длины кода бюджетной классификации (больше требуемого значения)",
                    preExecution = { getDto.invoke().copy(code = digits.random(21, 40)) },
                    control = KbkControls.CODE_MAX_LENGTH.withParams("length" to "20")
                ).withId(T5301::class),
                KbkControlTest(
                    testName = "кода бюджетной классификации на допустимые символы",
                    preExecution = { getDto.invoke().copy(code = "G1Я!") },
                    control = KbkControls.CODE_AVAILABLE_SYMBOLS.withParams("symbols" to "G;Я;!")
                ).withId(T5302::class),

                KbkControlTest(
                    testName = "описания кода бюджетной классификации на непустоту (null)",
                    preExecution = { getDto.invoke().copy(description = null) },
                    control = KbkControls.DESCRIPTION_EMPTY
                ).withId(T5306::class),
                KbkControlTest(
                    testName = "описания кода бюджетной классификации на непустоту (empty)",
                    preExecution = { getDto.invoke().copy(description = "") },
                    control = KbkControls.DESCRIPTION_EMPTY
                ).withId(T5303::class),
                KbkControlTest(
                    testName = "описания кода бюджетной классификации на непустоту (spaces)",
                    preExecution = { getDto.invoke().copy(description = "    ") },
                    control = KbkControls.DESCRIPTION_EMPTY
                ).withId(T5307::class)
            )
        )
    }
}