package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_STMNTOPERATIONTYPE
import ooo.jtc.api.dictionaries.stmntoperationtype.StatementOperationTypeControlTest
import ooo.jtc.api.dictionaries.stmntoperationtype.StatementOperationTypeCreateTest
import ooo.jtc.api.dictionaries.stmntoperationtype.StatementOperationTypeDeleteTest
import ooo.jtc.api.dictionaries.stmntoperationtype.StatementOperationTypeFiltrationTest
import ooo.jtc.api.dictionaries.stmntoperationtype.StatementOperationTypeGetPageTest
import ooo.jtc.api.dictionaries.stmntoperationtype.StatementOperationTypeGetTest
import ooo.jtc.api.dictionaries.stmntoperationtype.StatementOperationTypeOtherTest
import ooo.jtc.api.dictionaries.stmntoperationtype.StatementOperationTypePrepareSteps.getStatementOperationTypeDtoForCreate
import ooo.jtc.api.dictionaries.stmntoperationtype.StatementOperationTypeSortingTest
import ooo.jtc.api.dictionaries.stmntoperationtype.StatementOperationTypeSteps
import ooo.jtc.api.dictionaries.stmntoperationtype.StatementOperationTypeUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.stmntoperationtype.StatementOperationType
import ooo.jtc.dictionaries.stmntoperationtype.StatementOperationTypeDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.random.RandomData
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.stmntoperationtype.StatementOperationTypeControls
import ooo.jtc.testdata.dictionaries.stmntoperationtype.StatementOperationTypeData
import ooo.jtc.testdata.dictionaries.stmntoperationtype.StatementOperationTypeFilterParams
import ooo.jtc.testdata.dictionaries.stmntoperationtype.StatementOperationTypeSortingParams.CODE
import ooo.jtc.testdata.dictionaries.stmntoperationtype.StatementOperationTypeSortingParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.stmntoperationtype.StatementOperationTypeSortingParams.ID
import ooo.jtc.uaa.User
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
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
@Story(DictionaryNames.STATEMENT_OPERATION_TYPE)
@DisplayName("API '${DictionaryNames.STATEMENT_OPERATION_TYPE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_STMNTOPERATIONTYPE
@TestInstance(PER_CLASS)
class StatementOperationTypeTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T1297") annotation class T1297
@Tag("JTCSALTO-T1298") annotation class T1298
@Tag("JTCSALTO-T1299") annotation class T1299
@Tag("JTCSALTO-T1300") annotation class T1300
@Tag("JTCSALTO-T1301") annotation class T1301
@Tag("JTCSALTO-T1302") annotation class T1302
@Tag("JTCSALTO-T1303") annotation class T1303
@Tag("JTCSALTO-T1304") annotation class T1304
@Tag("JTCSALTO-T2197") annotation class T2197
@Tag("JTCSALTO-T2198") annotation class T2198
@Tag("JTCSALTO-T2199") annotation class T2199
@Tag("JTCSALTO-T2200") annotation class T2200
@Tag("JTCSALTO-T2201") annotation class T2201
@Tag("JTCSALTO-T2202") annotation class T2202
@Tag("JTCSALTO-T2203") annotation class T2203
@Tag("JTCSALTO-T2204") annotation class T2204
@Tag("JTCSALTO-T2205") annotation class T2205
@Tag("JTCSALTO-T2206") annotation class T2206
@Tag("JTCSALTO-T2207") annotation class T2207
@Tag("JTCSALTO-T2208") annotation class T2208
@Tag("JTCSALTO-T2209") annotation class T2209
@Tag("JTCSALTO-T2210") annotation class T2210
@Tag("JTCSALTO-T2211") annotation class T2211
@Tag("JTCSALTO-T2212") annotation class T2212
@Tag("JTCSALTO-T2213") annotation class T2213
@Tag("JTCSALTO-T2214") annotation class T2214
@Tag("JTCSALTO-T2215") annotation class T2215
@Tag("JTCSALTO-T2216") annotation class T2216
@Tag("JTCSALTO-T2217") annotation class T2217
@Tag("JTCSALTO-T2218") annotation class T2218
@Tag("JTCSALTO-T2219") annotation class T2219
@Tag("JTCSALTO-T2220") annotation class T2220
@Tag("JTCSALTO-T2221") annotation class T2221
@Tag("JTCSALTO-T2222") annotation class T2222
@Tag("JTCSALTO-T2223") annotation class T2223
@Tag("JTCSALTO-T2224") annotation class T2224
@Tag("JTCSALTO-T2225") annotation class T2225
@Tag("JTCSALTO-T2226") annotation class T2226
@Tag("JTCSALTO-T2227") annotation class T2227
//@formatter:on
//endregion

    private lateinit var dataForFilter: StatementOperationTypeDto
    private lateinit var testDataScope: TestDataScope<StatementOperationType>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = StatementOperationTypeData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T2197 //'Тип документа выписки'. CRUD: Создаем запись от пользователя [BANK]
    @T2198 //'Тип документа выписки'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T2199 //'Тип документа выписки'. CRUD: Получаем запись по id от пользователя [BANK]
    @T2200 //'Тип документа выписки'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T2201 //'Тип документа выписки'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T2202 //'Тип документа выписки'. CRUD: Удаляем запись от пользователя [BANK]
    @T2203 //'Тип документа выписки'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun statementOperationTypeCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                StatementOperationTypeCreateTest().withId(T2197::class),
                StatementOperationTypeGetTest(user = Users.client).withId(T2198::class),
                StatementOperationTypeGetTest(user = Users.bankAdmin).withId(T2199::class),
                StatementOperationTypeGetPageTest(user = Users.client).withId(T2200::class),
                StatementOperationTypeGetPageTest(user = Users.bankAdmin).withId(T2201::class),
                StatementOperationTypeDeleteTest().withId(T2202::class),
                StatementOperationTypeUpdateTest().withId(T2203::class)
            )
        )
    }

    @TestFactory
    @T2212 //'Тип документа выписки'. Сортировка по полю 'id, ASC' [CLIENT]
    @T2213 //'Тип документа выписки'. Сортировка по полю 'code, ASC' [CLIENT]
    @T2214 //'Тип документа выписки'. Сортировка по полю 'description, ASC' [CLIENT]
    @T2215 //'Тип документа выписки'. Сортировка по полю 'id, DESC' [CLIENT]
    @T2216 //'Тип документа выписки'. Сортировка по полю 'code, DESC' [CLIENT]
    @T2217 //'Тип документа выписки'. Сортировка по полю 'description, DESC' [CLIENT]
    internal fun statementOperationTypeSortingClientTests(): List<DynamicTest> {
        val user = Users.client
        val tests =
            listOf(
                StatementOperationTypeSortingTest(user, ID::asc).withId(T2212::class),
                StatementOperationTypeSortingTest(user, CODE::asc).withId(T2213::class),
                StatementOperationTypeSortingTest(user, DESCRIPTION::asc).withId(T2214::class),

                StatementOperationTypeSortingTest(user, ID::desc).withId(T2215::class),
                StatementOperationTypeSortingTest(user, CODE::desc).withId(T2216::class),
                StatementOperationTypeSortingTest(user, DESCRIPTION::desc).withId(T2217::class)
            )
        return EntityTestGenerator.generate(tests)
    }

    @TestFactory
    @T2204 //'Тип документа выписки'. Сортировка по полю 'id, ASC' [BANK]
    @T2205 //'Тип документа выписки'. Сортировка по полю 'code, ASC' [BANK]
    @T2206 //'Тип документа выписки'. Сортировка по полю 'description, ASC' [BANK]
    @T2207 //'Тип документа выписки'. Сортировка по полю 'id, DESC' [BANK]
    @T2208 //'Тип документа выписки'. Сортировка по полю 'code, DESC' [BANK]
    @T2209 //'Тип документа выписки'. Сортировка по полю 'description, DESC' [BANK]
    internal fun statementOperationTypeSortingBankTests(): List<DynamicTest> {
        val user = Users.bankAdmin
        val tests =
            listOf(
                StatementOperationTypeSortingTest(user, ID::asc).withId(T2204::class),
                StatementOperationTypeSortingTest(user, CODE::asc).withId(T2205::class),
                StatementOperationTypeSortingTest(user, DESCRIPTION::asc).withId(T2206::class),

                StatementOperationTypeSortingTest(user, ID::desc).withId(T2207::class),
                StatementOperationTypeSortingTest(user, CODE::desc).withId(T2208::class),
                StatementOperationTypeSortingTest(user, DESCRIPTION::desc).withId(T2209::class)
            )
        return EntityTestGenerator.generate(tests)
    }

    @TestFactory
    @T2218 //'Тип документа выписки'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T2219 //'Тип документа выписки'. Фильтрация по полю 'code' (eq) [CLIENT]
    @T2220 //'Тип документа выписки'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T2221 //'Тип документа выписки'. Фильтрация по полю 'description' (contains) [CLIENT]
    internal fun statementOperationTypeFiltrationClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                StatementOperationTypeFiltrationTest("id equals", user, { dataForFilter },
                    { StatementOperationTypeFilterParams.ID.eq(it!!.id!!) }).withId(T2218::class),
                StatementOperationTypeFiltrationTest("code equals", user, { dataForFilter },
                    { StatementOperationTypeFilterParams.CODE.eq(it!!.code) }).withId(T2219::class),
                StatementOperationTypeFiltrationTest("description equals", user, { dataForFilter },
                    { StatementOperationTypeFilterParams.DESCRIPTION.eq(it!!.description) }).withId(T2220::class),
                StatementOperationTypeFiltrationTest("description contains", user, { dataForFilter },
                    { StatementOperationTypeFilterParams.DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T2221::class)
            )
        )
    }

    @TestFactory
    @T2222 //'Тип документа выписки'. Фильтрация по полю 'id' (eq) [BANK]
    @T2223 //'Тип документа выписки'. Фильтрация по полю 'code' (eq) [BANK]
    @T2224 //'Тип документа выписки'. Фильтрация по полю 'description' (eq) [BANK]
    @T2225 //'Тип документа выписки'. Фильтрация по полю 'description' (contains) [BANK]
    internal fun statementOperationTypeFiltrationBankTests(): List<DynamicTest> {
        val user = Users.bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                StatementOperationTypeFiltrationTest("id equals", user, { dataForFilter },
                    { StatementOperationTypeFilterParams.ID.eq(it!!.id!!) }).withId(T2222::class),
                StatementOperationTypeFiltrationTest("code equals", user, { dataForFilter },
                    { StatementOperationTypeFilterParams.CODE.eq(it!!.code) }).withId(T2223::class),
                StatementOperationTypeFiltrationTest("description equals", user, { dataForFilter },
                    { StatementOperationTypeFilterParams.DESCRIPTION.eq(it!!.description) }).withId(T2224::class),
                StatementOperationTypeFiltrationTest("description contains", user, { dataForFilter },
                    { StatementOperationTypeFilterParams.DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T2225::class)
            )
        )
    }

    private fun getStatementOperationTypeByCodeBody(user: User, soType: StatementOperationTypeDto) {
        val response = StatementOperationTypeSteps(user).getSoTypeByCode(soType.code)
        val actResult = response.data!!

        "Проверить, что в ответе вернулся тип документа выписки с ожидаемым кодом '${soType.code}'" {
            assertThat("Код отличается от ожидаемого", actResult.code, equalTo(soType.code))
            assertThat("В ответе не та запись, что ожидается", actResult.id!!, equalTo(soType.id!!))
        }
    }

    private fun getStatementOperationTypesByDescriptionBody(user: User, soType: StatementOperationTypeDto) {
        val response = StatementOperationTypeSteps(user).getSoTypeByDescription(soType.description)
        val actResult = response.data!!

        "Проверить, что в ответе вернулся тип документа выписки с ожидаемым описанием '${soType.description}'" {
            assertThat("описание отличается от ожидаемого", actResult.description, equalTo(soType.description))
            assertThat("В ответе не та запись, что ожидается", actResult.id!!, equalTo(soType.id!!))
        }
    }

    @TestFactory
    @T2210 //'Тип документа выписки'. Получение типа документа выписки по его коду [CLIENT]
    @T2211 //'Тип документа выписки'. Получение типа документа выписки по его коду [BANK]
    internal fun getStatementOperationTypeByCodeTest(): List<DynamicTest> {
        val testName = "'${DictionaryNames.STATEMENT_OPERATION_TYPE}'. Получение типа документа выписки по его коду"
        val sotClient = StatementOperationTypeData.randomOrException().toDto()
        val sotBank = StatementOperationTypeData.randomOrException().toDto()
        val tests = listOf(
            StatementOperationTypeOtherTest(
                name = "$testName [${Users.client.userType}]",
                params = { mapOf(PARAM_USER to Users.client, "Тип операции выписки" to sotClient) },
                testBody = { getStatementOperationTypeByCodeBody(Users.client, sotClient) }
            ).withId(T2210::class),
            StatementOperationTypeOtherTest(
                name = "$testName [${Users.bankAdmin.userType}]",
                params = { mapOf(PARAM_USER to Users.bankAdmin, "Тип операции выписки" to sotBank) },
                testBody = { getStatementOperationTypeByCodeBody(Users.bankAdmin, sotBank) }
            ).withId(T2211::class)
        )
        return EntityTestGenerator.generate(tests)
    }

    @TestFactory
    @T2226 //'Тип документа выписки'. Получение типа документа выписки по его описанию [CLIENT]
    @T2227 //'Тип документа выписки'. Получение типа документа выписки по его описанию [BANK]
    internal fun getStatementOperationTypesByDescriptionTest(): List<DynamicTest> {
        val testName = "'${DictionaryNames.STATEMENT_OPERATION_TYPE}'. Получение типа документа выписки по его описанию"
        val sotClient = StatementOperationTypeData.randomOrException().toDto()
        val sotBank = StatementOperationTypeData.randomOrException().toDto()
        val tests = listOf(
            StatementOperationTypeOtherTest(
                name = "$testName [${Users.client.userType}]",
                params = { mapOf(PARAM_USER to Users.client, "Тип операции выписки" to sotClient) },
                testBody = { getStatementOperationTypesByDescriptionBody(Users.client, sotClient) }
            ).withId(T2226::class),
            StatementOperationTypeOtherTest(
                name = "$testName [${Users.bankAdmin.userType}]",
                params = { mapOf(PARAM_USER to Users.bankAdmin, "Тип операции выписки" to sotBank) },
                testBody = { getStatementOperationTypesByDescriptionBody(Users.bankAdmin, sotBank) }
            ).withId(T2227::class)
        )
        return EntityTestGenerator.generate(tests)
    }

    @TestFactory
    @T1303 //Цифровое обозначение документа. Контроль цифрового обозначения документа на непустоту
    @T1301 //Цифровое обозначение документа. Контроль длины цифрового обозначения документа
    @T1304 //Цифровое обозначение документа. Контроль цифрового обозначения документа на допустимые символы
    @T1300 //Наименование документа. Контроль наименования документа на непустоту
    @T1297 //Наименование документа. Контроль длины наименования документа
    @T1299 //Наименование документа. Контроль наименования документа на допустимые символы
    internal fun statementOperationTypeControlTests(): List<DynamicTest> {
        val dto = { getStatementOperationTypeDtoForCreate() }
        val tests =
            listOf(
                StatementOperationTypeControlTest(
                    testName = "Цифровое обозначение документа. Контроль цифрового обозначения документа на непустоту",
                    preExecution = { dto.invoke().copy(code = "") },
                    control = StatementOperationTypeControls.CODE_EMPTY
                ).withId(T1303::class),
                StatementOperationTypeControlTest(
                    testName = "Цифровое обозначение документа. Контроль длины цифрового обозначения документа",
                    preExecution = { dto.invoke().copy(code = "333") },
                    control = StatementOperationTypeControls.CODE_MAX_LENGTH.withParams("length" to "2")
                ).withId(T1301::class),
                StatementOperationTypeControlTest(
                    testName = "Цифровое обозначение документа. Контроль цифрового обозначения документа на допустимые символы",
                    preExecution = { dto.invoke().copy(code = "Z") },
                    control = StatementOperationTypeControls.CODE_AVAILABLE_SYMBOLS.withParams("symbols" to "Z")
                ).withId(T1304::class),

                StatementOperationTypeControlTest(
                    testName = "Наименование документа. Контроль наименования документа на непустоту",
                    preExecution = { dto.invoke().copy(description = "") },
                    control = StatementOperationTypeControls.DESCRIPTION_EMPTY
                ).withId(T1300::class),
                StatementOperationTypeControlTest(
                    testName = "Наименование документа. Контроль длины наименования документа",
                    preExecution = { dto.invoke().copy(description = RandomData("[а-яА-Я]*").random(length = 31)) },
                    control = StatementOperationTypeControls.DESCRIPTION_MAX_LENGTH.withParams("length" to "30")
                ).withId(T1297::class),
                StatementOperationTypeControlTest(
                    testName = "Наименование документа. Контроль наименования документа на допустимые символы",
                    preExecution = { dto.invoke().copy(description = "Z ~ $ # № ) • ○ (") },
                    control = StatementOperationTypeControls.DESCRIPTION_AVAILABLE_SYMBOLS.withParams("symbols" to "Z;~;$;#;№;•;○")
                ).withId(T1299::class)
            )
        return EntityTestGenerator.generate(tests)
    }

    //TODO A.Stykalin [23.06.2020]  добавить тесты на уникальность полей по резолву https://jira.jtc.ooo/browse/JTCSALTO-673
}