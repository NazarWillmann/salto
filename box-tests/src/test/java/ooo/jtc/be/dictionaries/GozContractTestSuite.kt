package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_GOZ_CONTRACT
import ooo.jtc.api.dictionaries.gozcontract.GozContractCreateTest
import ooo.jtc.api.dictionaries.gozcontract.GozContractDeleteTest
import ooo.jtc.api.dictionaries.gozcontract.GozContractFilterTests
import ooo.jtc.api.dictionaries.gozcontract.GozContractGetPageTest
import ooo.jtc.api.dictionaries.gozcontract.GozContractGetTest
import ooo.jtc.api.dictionaries.gozcontract.GozContractSortingTest
import ooo.jtc.api.dictionaries.gozcontract.GozContractUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.gozcontract.GozContract
import ooo.jtc.dictionaries.gozcontract.GozContractDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.gozcontract.GozContractData
import ooo.jtc.testdata.dictionaries.gozcontract.GozContractFilterParams
import ooo.jtc.testdata.dictionaries.gozcontract.GozContractSortingParams
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.DICTIONARY)
@Story(DictionaryNames.GOZ_CONTRACT)
@DisplayName("API '${DictionaryNames.GOZ_CONTRACT}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_GOZ_CONTRACT
@TestInstance(Lifecycle.PER_CLASS)
class GozContractTestSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T5168") annotation class T5168
@Tag("JTCSALTO-T5169") annotation class T5169
@Tag("JTCSALTO-T5170") annotation class T5170
@Tag("JTCSALTO-T5171") annotation class T5171
@Tag("JTCSALTO-T5172") annotation class T5172
@Tag("JTCSALTO-T5173") annotation class T5173
@Tag("JTCSALTO-T5174") annotation class T5174
@Tag("JTCSALTO-T5175") annotation class T5175
@Tag("JTCSALTO-T5176") annotation class T5176
@Tag("JTCSALTO-T5177") annotation class T5177
@Tag("JTCSALTO-T5178") annotation class T5178
@Tag("JTCSALTO-T5179") annotation class T5179
@Tag("JTCSALTO-T5180") annotation class T5180
@Tag("JTCSALTO-T5181") annotation class T5181
@Tag("JTCSALTO-T5182") annotation class T5182
@Tag("JTCSALTO-T5183") annotation class T5183
@Tag("JTCSALTO-T5184") annotation class T5184
@Tag("JTCSALTO-T5185") annotation class T5185
@Tag("JTCSALTO-T5186") annotation class T5186
@Tag("JTCSALTO-T5187") annotation class T5187
@Tag("JTCSALTO-T5188") annotation class T5188
//@formatter:on
//endregion

    private lateinit var dataForFilter: GozContractDto
    private lateinit var testDataScope: TestDataScope<GozContract>
    private val clientUser = Users.client
    private val bankUser = Users.bankOperator

    @BeforeAll
    fun prepareTestData() {
        testDataScope = GozContractData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T5172 //'Государственный контракт'. CRUD: Создаем запись от пользователя [BANK]
    @T5173 //'Государственный контракт'. CRUD: Получаем запись по id от пользователя [BANK]
    @T5174 //'Государственный контракт'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T5175 //'Государственный контракт'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T5176 //'Государственный контракт'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T5177 //'Государственный контракт'. CRUD: Обновляем запись от пользователя [BANK]
    @T5178 //'Государственный контракт'. CRUD: Удаляем запись от пользователя [BANK]
    internal fun gozContractCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                GozContractCreateTest().withId(T5172::class),
                GozContractGetTest(user = bankUser).withId(T5173::class),
                GozContractGetTest(user = clientUser).withId(T5174::class),
                GozContractGetPageTest(user = bankUser).withId(T5175::class),
                GozContractGetPageTest(user = clientUser).withId(T5176::class),
                GozContractUpdateTest().withId(T5177::class),
                GozContractDeleteTest().withId(T5178::class)
            )
        )
    }

    @TestFactory
    @T5179 //'Государственный контракт'. Сортировка по полю 'id, ASC' [CLIENT]
    @T5180 //'Государственный контракт'. Сортировка по полю 'number, ASC' [CLIENT]
    @T5181 //'Государственный контракт'. Сортировка по полю 'id, DESC' [CLIENT]
    @T5182 //'Государственный контракт'. Сортировка по полю 'number, DESC' [CLIENT]
    internal fun gozContractSortingClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                GozContractSortingTest(user, GozContractSortingParams.ID::asc).withId(T5179::class),
                GozContractSortingTest(user, GozContractSortingParams.NUMBER::asc).withId(T5180::class),
                GozContractSortingTest(user, GozContractSortingParams.ID::desc).withId(T5181::class),
                GozContractSortingTest(user, GozContractSortingParams.NUMBER::desc).withId(T5182::class)
            )
        )
    }

    @TestFactory
    @T5168 //'Государственный контракт'. Сортировка по полю 'id, ASC' [BANK]
    @T5169 //'Государственный контракт'. Сортировка по полю 'number, ASC' [BANK]
    @T5170 //'Государственный контракт'. Сортировка по полю 'id, DESC' [BANK]
    @T5171 //'Государственный контракт'. Сортировка по полю 'number, DESC' [BANK]
    internal fun gozContractSortingBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                GozContractSortingTest(user, GozContractSortingParams.ID::asc).withId(T5168::class),
                GozContractSortingTest(user, GozContractSortingParams.NUMBER::asc).withId(T5169::class),
                GozContractSortingTest(user, GozContractSortingParams.ID::desc).withId(T5170::class),
                GozContractSortingTest(user, GozContractSortingParams.NUMBER::desc).withId(T5171::class)
            )
        )
    }

    @TestFactory
    @T5183 //'Государственный контракт'. Фильтрация по полю id equals. [CLIENT]
    @T5184 //'Государственный контракт'. Фильтрация по полю type equals. [CLIENT]
    @T5185 //'Государственный контракт'. Фильтрация по полю type contains. [CLIENT]
    internal fun gozContractFiltrationClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                GozContractFilterTests("id equals", user, { dataForFilter },
                    { GozContractFilterParams.ID.eq(it!!.id!!) }).withId(T5183::class),
                GozContractFilterTests("type equals", user, { dataForFilter },
                    { GozContractFilterParams.NUMBER.eq(it!!.number) }).withId(T5184::class),
                GozContractFilterTests("type contains", user, { dataForFilter },
                    { GozContractFilterParams.NUMBER.contains(it!!.number.randomSubstringPf()) })
                    .withId(T5185::class)
            )
        )
    }

    @TestFactory
    @T5186 //'Государственный контракт'. Фильтрация по полю id equals. [BANK]
    @T5187 //'Государственный контракт'. Фильтрация по полю type equals. [BANK]
    @T5188 //'Государственный контракт'. Фильтрация по полю type contains. [BANK]
    internal fun gozContractFiltrationBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                GozContractFilterTests("id equals", user, { dataForFilter },
                    { GozContractFilterParams.ID.eq(it!!.id!!) }).withId(T5186::class),
                GozContractFilterTests("type equals", user, { dataForFilter },
                    { GozContractFilterParams.NUMBER.eq(it!!.number) }).withId(T5187::class),
                GozContractFilterTests("type contains", user, { dataForFilter },
                    { GozContractFilterParams.NUMBER.contains(it!!.number.randomSubstringPf()) })
                    .withId(T5188::class)
            )
        )
    }
}