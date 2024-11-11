package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_RESIDENCY_PERMIT_DOCUMENT_TYPE
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.dictionaries.residencypermitdocumenttype.ResidencyPermitDocumentTypeFolderDefaults
import ooo.jtc.api.dictionaries.residencypermitdocumenttype.ResidencyPermitDocumentTypeGetPageTest
import ooo.jtc.api.dictionaries.residencypermitdocumenttype.ResidencyPermitDocumentTypeSortingTest
import ooo.jtc.api.dictionaries.residencypermitdocumenttype.ResidencyPermitDocumentTypeSteps.Companion.checkDefaultEntity
import ooo.jtc.api.dictionaries.residencypermitdocumenttype.ResidencyPermitDocumentTypeTraceabilityTasks
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.tm4j.Tm4jComponent
import ooo.jtc.core.tm4j.Tm4jPriority
import ooo.jtc.dictionaries.residencypermitdocumenttype.ResidencyPermitDocumentType
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.residencypermitdocumenttype.ResidencyPermitDocumentTypeData
import ooo.jtc.testdata.dictionaries.residencypermitdocumenttype.ResidencyPermitDocumentTypeSortingParams.NAME
import ooo.jtc.testdata.dictionaries.residencypermitdocumenttype.ResidencyPermitDocumentTypeSortingParams.SYSTEM_NAME
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
@Story(DictionaryNames.RESIDENCY_PERMIT_DOCUMENT_TYPE)
@DisplayName("API '${DictionaryNames.RESIDENCY_PERMIT_DOCUMENT_TYPE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_RESIDENCY_PERMIT_DOCUMENT_TYPE
@TestInstance(PER_CLASS)
class ResidencyPermitDocumentTypeTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T6965") annotation class T6965
@Tag("JTCSALTO-T6966") annotation class T6966
@Tag("JTCSALTO-T6967") annotation class T6967
@Tag("JTCSALTO-T6968") annotation class T6968
@Tag("JTCSALTO-T6969") annotation class T6969
@Tag("JTCSALTO-T6970") annotation class T6970
@Tag("JTCSALTO-T6971") annotation class T6971
@Tag("JTCSALTO-T6972") annotation class T6972
@Tag("JTCSALTO-T6973") annotation class T6973
@Tag("JTCSALTO-T6974") annotation class T6974
@Tag("JTCSALTO-T6975") annotation class T6975
//@formatter:on
//endregion


    private lateinit var testDataScope: TestDataScope<ResidencyPermitDocumentType>

    @BeforeAll
    fun setUpResidencyPermitDocumentTypeClass() {
        testDataScope = ResidencyPermitDocumentTypeData.withRequiredFields()
    }

    @AfterAll
    fun tearDownResidencyPermitDocumentTypeClass() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T6965 //'Вид документа, подтверждающего право пребывания в РФ'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T6966 //'Вид документа, подтверждающего право пребывания в РФ'. CRUD: Получаем страницу записей от пользователя [BANK]
    internal fun residencyPermitDocumentTypeCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ResidencyPermitDocumentTypeGetPageTest(user = client).withId(T6965::class),
                ResidencyPermitDocumentTypeGetPageTest(user = bankAdmin).withId(T6966::class)
            )
        )
    }

    @TestFactory
    @T6967 //'Вид документа, подтверждающего право пребывания в РФ'. Сортировка по полю 'name, ASC' [CLIENT]
    @T6968 //'Вид документа, подтверждающего право пребывания в РФ'. Сортировка по полю 'name, DESC' [CLIENT]
    @T6969 //'Вид документа, подтверждающего право пребывания в РФ'. Сортировка по полю 'systemName, ASC' [CLIENT]
    @T6970 //'Вид документа, подтверждающего право пребывания в РФ'. Сортировка по полю 'systemName, DESC' [CLIENT]
    @T6971 //'Вид документа, подтверждающего право пребывания в РФ'. Сортировка по полю 'name, ASC' [BANK]
    @T6972 //'Вид документа, подтверждающего право пребывания в РФ'. Сортировка по полю 'name, DESC' [BANK]
    @T6973 //'Вид документа, подтверждающего право пребывания в РФ'. Сортировка по полю 'systemName, ASC' [BANK]
    @T6974 //'Вид документа, подтверждающего право пребывания в РФ'. Сортировка по полю 'systemName, DESC' [BANK]
    internal fun residencyPermitDocumentTypeSortingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ResidencyPermitDocumentTypeSortingTest(user = client, sortRequestFunction = NAME::asc).withId(T6967::class),
                ResidencyPermitDocumentTypeSortingTest(user = client, sortRequestFunction = NAME::desc).withId(T6968::class),
                ResidencyPermitDocumentTypeSortingTest(user = client, sortRequestFunction = SYSTEM_NAME::asc).withId(T6969::class),
                ResidencyPermitDocumentTypeSortingTest(user = client, sortRequestFunction = SYSTEM_NAME::desc).withId(T6970::class),

                ResidencyPermitDocumentTypeSortingTest(user = bankAdmin, sortRequestFunction = NAME::asc).withId(T6971::class),
                ResidencyPermitDocumentTypeSortingTest(user = bankAdmin, sortRequestFunction = NAME::desc).withId(T6972::class),
                ResidencyPermitDocumentTypeSortingTest(user = bankAdmin, sortRequestFunction = SYSTEM_NAME::asc).withId(T6973::class),
                ResidencyPermitDocumentTypeSortingTest(user = bankAdmin, sortRequestFunction = SYSTEM_NAME::desc).withId(T6974::class)
            )
        )
    }

    @TestFactory
    @T6975 //'Вид документа, подтверждающего право пребывания в РФ'. Наполнение
    internal fun residencyPermitDocumentTypeDefaultsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                UnitBeTest(
                    name = "'${DictionaryNames.RESIDENCY_PERMIT_DOCUMENT_TYPE}'. Наполнение",
                    testBody = {
                        val actualEntities = testDataScope.consumed
                        val expectedEntities = getExpectedDefaultEntities()
                        expectedEntities.forEach { expectedEntity ->
                            try {
                                val actualEntity = actualEntities.first { it.name == expectedEntity.name }
                                checkDefaultEntity(actualEntity, expectedEntity)
                            } catch (e: NoSuchElementException) {
                                throw RuntimeException(
                                    "Вид документа, подтверждающего право пребывания в РФ" +
                                            " со следующим наименованием не найден: '${expectedEntity.name}'"
                                )
                            }
                        }
                    }
                ).withId(T6975::class)
                    .withTaskIds(ResidencyPermitDocumentTypeTraceabilityTasks::class)
                    .withComponent(Tm4jComponent.DICTIONARY)
                    .withFolder(ResidencyPermitDocumentTypeFolderDefaults::class)
                    .withPriority(Tm4jPriority.High)
            )
        )
    }

    private fun getExpectedDefaultEntities(): List<ResidencyPermitDocumentType> {
        return listOf(
            ResidencyPermitDocumentType(
                name = "Виза",
                systemName = "visa"
            ),
            ResidencyPermitDocumentType(
                name = "Миграционная карта",
                systemName = "migrationCard"
            ),
            ResidencyPermitDocumentType(
                name = "Разрешение на временное проживание",
                systemName = "temporaryResidencyPermit"
            ),
            ResidencyPermitDocumentType(
                name = "Вид на жительство",
                systemName = "residencyPermit"
            ),
            ResidencyPermitDocumentType(
                name = "Иной документ",
                systemName = "other"
            )
        )
    }
}