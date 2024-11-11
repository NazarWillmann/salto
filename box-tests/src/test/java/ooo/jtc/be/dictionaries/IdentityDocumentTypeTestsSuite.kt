package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_IDENTITY_DOC_TYPE
import ooo.jtc.api.dictionaries.identitydocumenttype.IdentityDocumentTypeDefaultsTest
import ooo.jtc.api.dictionaries.identitydocumenttype.IdentityDocumentTypeFiltrationTests
import ooo.jtc.api.dictionaries.identitydocumenttype.IdentityDocumentTypeGetPageTest
import ooo.jtc.api.dictionaries.identitydocumenttype.IdentityDocumentTypeGetTest
import ooo.jtc.api.dictionaries.identitydocumenttype.IdentityDocumentTypeSortingTest
import ooo.jtc.api.dictionaries.identitydocumenttype.IdentityDocumentTypeSteps
import ooo.jtc.api.dictionaries.identitydocumenttype.IdentityDocumentTypeUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.identitydocumenttype.IdentityDocumentType
import ooo.jtc.dictionaries.identitydocumenttype.IdentityDocumentTypeDto
import ooo.jtc.dictionaries.identitydocumenttype.UsageLimit
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.Users.bankOperator
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.identitydocumenttype.IdentityDocumentTypeData
import ooo.jtc.testdata.dictionaries.identitydocumenttype.IdentityDocumentTypeFilterParams
import ooo.jtc.testdata.dictionaries.identitydocumenttype.IdentityDocumentTypeSortingParams.IS_HIDDEN
import ooo.jtc.testdata.dictionaries.identitydocumenttype.IdentityDocumentTypeSortingParams.NAME
import ooo.jtc.testdata.dictionaries.identitydocumenttype.IdentityDocumentTypeSortingParams.TYPE_CODE
import ooo.jtc.testdata.dictionaries.identitydocumenttype.IdentityDocumentTypeSortingParams.USAGE_LIMIT
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
@Feature(TestFeature.DICTIONARY)
@Story(DictionaryNames.IDENTITY_DOC_TYPE)
@DisplayName("API '${DictionaryNames.IDENTITY_DOC_TYPE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_IDENTITY_DOC_TYPE
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IdentityDocumentTypeTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T5271") annotation class T5271
@Tag("JTCSALTO-T5272") annotation class T5272
@Tag("JTCSALTO-T5273") annotation class T5273
@Tag("JTCSALTO-T5274") annotation class T5274
@Tag("JTCSALTO-T5276") annotation class T5276
@Tag("JTCSALTO-T5278") annotation class T5278
@Tag("JTCSALTO-T5279") annotation class T5279
@Tag("JTCSALTO-T5280") annotation class T5280
@Tag("JTCSALTO-T5281") annotation class T5281
@Tag("JTCSALTO-T5283") annotation class T5283
@Tag("JTCSALTO-T5284") annotation class T5284
@Tag("JTCSALTO-T5285") annotation class T5285
@Tag("JTCSALTO-T5286") annotation class T5286
@Tag("JTCSALTO-T5288") annotation class T5288
@Tag("JTCSALTO-T5291") annotation class T5291
@Tag("JTCSALTO-T5294") annotation class T5294
@Tag("JTCSALTO-T5297") annotation class T5297
@Tag("JTCSALTO-T6859") annotation class T6859
@Tag("JTCSALTO-T6860") annotation class T6860
@Tag("JTCSALTO-T6861") annotation class T6861
@Tag("JTCSALTO-T6862") annotation class T6862
@Tag("JTCSALTO-T6863") annotation class T6863
@Tag("JTCSALTO-T6864") annotation class T6864
@Tag("JTCSALTO-T6865") annotation class T6865
@Tag("JTCSALTO-T6866") annotation class T6866
@Tag("JTCSALTO-T6867") annotation class T6867
@Tag("JTCSALTO-T6868") annotation class T6868
@Tag("JTCSALTO-T6869") annotation class T6869
@Tag("JTCSALTO-T6870") annotation class T6870
@Tag("JTCSALTO-T6976") annotation class T6976
@Tag("JTCSALTO-T6977") annotation class T6977
@Tag("JTCSALTO-T6978") annotation class T6978
@Tag("JTCSALTO-T6979") annotation class T6979
@Tag("JTCSALTO-T6980") annotation class T6980
@Tag("JTCSALTO-T6981") annotation class T6981
@Tag("JTCSALTO-T6982") annotation class T6982
@Tag("JTCSALTO-T6983") annotation class T6983
@Tag("JTCSALTO-T6984") annotation class T6984
@Tag("JTCSALTO-T6985") annotation class T6985
@Tag("JTCSALTO-T6986") annotation class T6986
//@formatter:on
//endregion


    private lateinit var dataForFilter: IdentityDocumentTypeDto
    private lateinit var testDataScope: TestDataScope<IdentityDocumentType>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = IdentityDocumentTypeData.withRequiredFields(requiredDataCount = 10)
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T5271 //'Вид ДУЛ'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T5272 //'Вид ДУЛ'. CRUD: Получаем запись по id от пользователя [BANK]
    @T5273 //'Вид ДУЛ'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T5274 //'Вид ДУЛ'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T5276 //'Вид ДУЛ'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun identityDocTypeCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                IdentityDocumentTypeGetTest(user = client).withId(T5271::class),
                IdentityDocumentTypeGetTest(user = bankOperator).withId(T5272::class),
                IdentityDocumentTypeGetPageTest(user = client).withId(T5273::class),
                IdentityDocumentTypeGetPageTest(user = bankOperator).withId(T5274::class),
                IdentityDocumentTypeUpdateTest(user = bankAdmin).withId(T5276::class)
            )
        )
    }

    @TestFactory
    @T5288 //'Вид ДУЛ'. Сортировка по полю 'name, ASC' [CLIENT]
    @T5291 //'Вид ДУЛ'. Сортировка по полю 'name, DESC' [CLIENT]
    @T6979 //'Вид ДУЛ'. Сортировка по полю 'typeCode, ASC' [CLIENT]
    @T6980 //'Вид ДУЛ'. Сортировка по полю 'usageLimit, ASC' [CLIENT]
    @T6981 //'Вид ДУЛ'. Сортировка по полю 'isHidden, ASC' [CLIENT]
    @T6982 //'Вид ДУЛ'. Сортировка по полю 'typeCode, DESC' [CLIENT]
    @T6983 //'Вид ДУЛ'. Сортировка по полю 'usageLimit, DESC' [CLIENT]
    @T6984 //'Вид ДУЛ'. Сортировка по полю 'isHidden, DESC' [CLIENT]
    internal fun identityDocTypeSortingClientTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                IdentityDocumentTypeSortingTest(client, NAME::asc).withId(T5288::class),
                IdentityDocumentTypeSortingTest(client, TYPE_CODE::asc).withId(T6979::class),
                IdentityDocumentTypeSortingTest(client, USAGE_LIMIT::asc).withId(T6980::class),
                IdentityDocumentTypeSortingTest(client, IS_HIDDEN::asc).withId(T6981::class),

                IdentityDocumentTypeSortingTest(client, NAME::desc).withId(T5291::class),
                IdentityDocumentTypeSortingTest(client, TYPE_CODE::desc).withId(T6982::class),
                IdentityDocumentTypeSortingTest(client, USAGE_LIMIT::desc).withId(T6983::class),
                IdentityDocumentTypeSortingTest(client, IS_HIDDEN::desc).withId(T6984::class)
            )
        )
    }

    @TestFactory
    @T5294 //'Вид ДУЛ'. Сортировка по полю 'name, ASC' [BANK]
    @T5297 //'Вид ДУЛ'. Сортировка по полю 'name, DESC' [BANK]
    @T6859 //'Вид ДУЛ'. Сортировка по полю 'usageLimit, ASC' [BANK]
    @T6863 //'Вид ДУЛ'. Сортировка по полю 'typeCode, DESC' [BANK]
    @T6862 //'Вид ДУЛ'. Сортировка по полю 'typeCode, ASC' [BANK]
    @T6866 //'Вид ДУЛ'. Сортировка по полю 'usageLimit, DESC' [BANK]
    @T6985 //'Вид ДУЛ'. Сортировка по полю 'isHidden, ASC' [BANK]
    @T6986 //'Вид ДУЛ'. Сортировка по полю 'isHidden, DESC' [BANK]
    internal fun identityDocTypeSortingBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                IdentityDocumentTypeSortingTest(bankOperator, NAME::asc).withId(T5294::class),
                IdentityDocumentTypeSortingTest(bankOperator, TYPE_CODE::asc).withId(T6862::class),
                IdentityDocumentTypeSortingTest(bankOperator, USAGE_LIMIT::asc).withId(T6859::class),
                IdentityDocumentTypeSortingTest(bankOperator, IS_HIDDEN::asc).withId(T6985::class),

                IdentityDocumentTypeSortingTest(bankOperator, NAME::desc).withId(T5297::class),
                IdentityDocumentTypeSortingTest(bankOperator, TYPE_CODE::desc).withId(T6863::class),
                IdentityDocumentTypeSortingTest(bankOperator, USAGE_LIMIT::desc).withId(T6866::class),
                IdentityDocumentTypeSortingTest(bankOperator, IS_HIDDEN::desc).withId(T6986::class)
            )
        )
    }

    @TestFactory
    @T5278 //'Вид ДУЛ'. Фильтрация по полю 'name' (eq) [CLIENT]
    @T5279 //'Вид ДУЛ'. Фильтрация по полю 'name' (contains) [CLIENT]
    @T5280 //'Вид ДУЛ'. Фильтрация по полю 'systemName' (eq) [CLIENT]
    @T5281 //'Вид ДУЛ'. Фильтрация по полю 'systemName' (contains) [CLIENT]
    @T6864 //'Вид ДУЛ'. Фильтрация по полю 'typeCode' (contains) [CLIENT]
    @T6861 //'Вид ДУЛ'. Фильтрация по полю 'typeCode' (eq) [CLIENT]
    @T6868 //'Вид ДУЛ'. Фильтрация по полю 'usageLimit' (eq) [CLIENT]
    @T6867 //'Вид ДУЛ'. Фильтрация по полю 'usageLimit' (contains) [CLIENT]
    @T6976 //'Вид ДУЛ'. Фильтрация по полю 'isHidden' (eq) [CLIENT]
    internal fun identityDocTypeFiltrationClientTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                IdentityDocumentTypeFiltrationTests("name equals", client, { dataForFilter },
                    { IdentityDocumentTypeFilterParams.NAME.eq(it!!.name) }).withId(T5278::class),
                IdentityDocumentTypeFiltrationTests("name contains", client, { dataForFilter },
                    { IdentityDocumentTypeFilterParams.NAME.contains(it!!.name.randomSubstringPf()) }).withId(T5279::class),
                IdentityDocumentTypeFiltrationTests("systemName equals", client, { dataForFilter },
                    { IdentityDocumentTypeFilterParams.SYSTEM_NAME.eq(it!!.systemName!!) }).withId(T5280::class),
                IdentityDocumentTypeFiltrationTests("systemName contains", client, { dataForFilter },
                    { IdentityDocumentTypeFilterParams.SYSTEM_NAME.contains(it!!.systemName!!.randomSubstringPf()) }).withId(T5281::class),
                IdentityDocumentTypeFiltrationTests("typeCode equals", client, { dataForFilter },
                    { IdentityDocumentTypeFilterParams.TYPE_CODE.eq(it!!.typeCode!!) }).withId(T6861::class),
                IdentityDocumentTypeFiltrationTests("typeCode contains", client, { dataForFilter },
                    { IdentityDocumentTypeFilterParams.TYPE_CODE.contains(it!!.typeCode!!.randomSubstringPf()) }).withId(T6864::class),
                IdentityDocumentTypeFiltrationTests("usageLimit equals", client, { dataForFilter },
                    { IdentityDocumentTypeFilterParams.USAGE_LIMIT.eq(it!!.usageLimit!!.name) }).withId(T6868::class),
                IdentityDocumentTypeFiltrationTests("usageLimit contains", client, { dataForFilter },
                    { IdentityDocumentTypeFilterParams.USAGE_LIMIT.contains(it!!.usageLimit!!.name.randomSubstringPf()) }).withId(T6867::class),
                IdentityDocumentTypeFiltrationTests("isHidden equals", client, { dataForFilter },
                    { IdentityDocumentTypeFilterParams.IS_HIDDEN.eq(it!!.isHidden) }).withId(T6976::class)
            )
        )
    }

    @TestFactory
    @T5283 //'Вид ДУЛ'. Фильтрация по полю 'name' (eq) [BANK]
    @T5284 //'Вид ДУЛ'. Фильтрация по полю 'name' (contains) [BANK]
    @T5285 //'Вид ДУЛ'. Фильтрация по полю 'systemName' (eq) [BANK]
    @T5286 //'Вид ДУЛ'. Фильтрация по полю 'systemName' (contains) [BANK]
    @T6860 //'Вид ДУЛ'. Фильтрация по полю 'typeCode' (contains) [BANK]
    @T6865 //'Вид ДУЛ'. Фильтрация по полю 'typeCode' (eq) [BANK]
    @T6869 //'Вид ДУЛ'. Фильтрация по полю 'usageLimit' (contains) [BANK]
    @T6870 //'Вид ДУЛ'. Фильтрация по полю 'usageLimit' (eq) [BANK]
    @T6977 //'Вид ДУЛ'. Фильтрация по полю 'isHidden' (eq) [BANK]
    internal fun identityDocTypeFiltrationBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                IdentityDocumentTypeFiltrationTests("name equals", bankOperator, { dataForFilter },
                    { IdentityDocumentTypeFilterParams.NAME.eq(it!!.name) }).withId(T5283::class),
                IdentityDocumentTypeFiltrationTests("name contains", bankOperator, { dataForFilter },
                    { IdentityDocumentTypeFilterParams.NAME.contains(it!!.name.randomSubstringPf()) }).withId(T5284::class),
                IdentityDocumentTypeFiltrationTests("systemName equals", bankOperator, { dataForFilter },
                    { IdentityDocumentTypeFilterParams.SYSTEM_NAME.eq(it!!.systemName!!) }).withId(T5285::class),
                IdentityDocumentTypeFiltrationTests("systemName contains", bankOperator, { dataForFilter },
                    { IdentityDocumentTypeFilterParams.SYSTEM_NAME.contains(it!!.systemName!!.randomSubstringPf()) }).withId(T5286::class),
                IdentityDocumentTypeFiltrationTests("typeCode equals", bankOperator, { dataForFilter },
                    { IdentityDocumentTypeFilterParams.TYPE_CODE.eq(it!!.typeCode!!) }).withId(T6865::class),
                IdentityDocumentTypeFiltrationTests("typeCode contains", bankOperator, { dataForFilter },
                    { IdentityDocumentTypeFilterParams.TYPE_CODE.contains(it!!.typeCode!!.randomSubstringPf()) }).withId(T6860::class),
                IdentityDocumentTypeFiltrationTests("usageLimit equals", bankOperator, { dataForFilter },
                    { IdentityDocumentTypeFilterParams.USAGE_LIMIT.eq(it!!.usageLimit!!.name) }).withId(T6870::class),
                IdentityDocumentTypeFiltrationTests("usageLimit contains", bankOperator, { dataForFilter },
                    { IdentityDocumentTypeFilterParams.USAGE_LIMIT.contains(it!!.usageLimit!!.name.randomSubstringPf()) }).withId(T6869::class),
                IdentityDocumentTypeFiltrationTests("isHidden equals", bankOperator, { dataForFilter },
                    { IdentityDocumentTypeFilterParams.IS_HIDDEN.eq(it!!.isHidden) }).withId(T6977::class)
            )
        )
    }

    @TestFactory
    @T6978 //'Вид ДУЛ'. Наполнение
    internal fun identityDocTypeDefaultsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                IdentityDocumentTypeDefaultsTest(
                    testBody = {
                        val actualEntities = testDataScope.consumed
                        val expectedEntities = getExpectedDefaultEntities()
                        expectedEntities.forEach { expectedEntity ->
                            try {
                                val actualEntity = actualEntities.first { it.typeCode == expectedEntity.typeCode }
                                IdentityDocumentTypeSteps.checkDefaultEntity(actualEntity, expectedEntity)
                            } catch (e: NoSuchElementException) {
                                throw RuntimeException("Вид ДУЛ со следующим кодом вида документа не найден: '${expectedEntity.typeCode}'")
                            }
                        }
                    }
                ).withId(T6978::class)
            )
        )
    }

    private fun getExpectedDefaultEntities(): List<IdentityDocumentType> {
        return listOf(
            IdentityDocumentType(
                name = "Паспорт иностранного гражданина",
                systemName = "foreignPassport",
                usageLimit = UsageLimit.ONLY_FOREIGN,
                typeCode = "10",
                isHidden = false
            ),
            IdentityDocumentType(
                name = "Временное удостоверение личности гражданина РФ",
                systemName = "interimCertificateRf",
                usageLimit = UsageLimit.ONLY_RF,
                typeCode = "14",
                isHidden = false
            ),
            IdentityDocumentType(
                name = "Паспорт гражданина Российской Федерации",
                systemName = "passportRf",
                usageLimit = UsageLimit.ONLY_RF,
                typeCode = "21",
                isHidden = false
            ),
            IdentityDocumentType(
                name = "Заграничный паспорт гражданина РФ",
                systemName = "foreignPassportRf",
                usageLimit = UsageLimit.ONLY_RF,
                typeCode = "22",
                isHidden = false
            ),
            IdentityDocumentType(
                name = "Иные документы",
                systemName = "other",
                usageLimit = UsageLimit.ALL,
                typeCode = "91",
                isHidden = false
            )
        )
    }
}