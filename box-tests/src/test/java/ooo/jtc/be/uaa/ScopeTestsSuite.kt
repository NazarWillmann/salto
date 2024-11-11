package ooo.jtc.be.uaa

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_UAA_SCOPE
import ooo.jtc.api.uaa.tests.ScopeCreateTest
import ooo.jtc.api.uaa.tests.ScopeDeleteTest
import ooo.jtc.api.uaa.tests.ScopeFilterTests
import ooo.jtc.api.uaa.tests.ScopeGetPageTest
import ooo.jtc.api.uaa.tests.ScopeGetTest
import ooo.jtc.api.uaa.tests.ScopeSortingTest
import ooo.jtc.api.uaa.tests.ScopeUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.UaaNames
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.uaa.scope.ScopeData
import ooo.jtc.testdata.uaa.scope.ScopeFilterParams.DESCRIPTION
import ooo.jtc.testdata.uaa.scope.ScopeFilterParams.ID
import ooo.jtc.testdata.uaa.scope.ScopeFilterParams.NAME
import ooo.jtc.testdata.uaa.scope.ScopeFilterParams.NEED_APPROVE
import ooo.jtc.testdata.uaa.scope.ScopeFilterParams.RESOURCE_ID
import ooo.jtc.testdata.uaa.scope.ScopeSortingParams
import ooo.jtc.uaa.scope.dto.ScopeDto
import ooo.jtc.uaa.scope.model.Scope
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS

@Epic(TestEpic.API)
@Feature(TestFeature.UAA)
@Story(UaaNames.SCOPE)
@DisplayName("API '${UaaNames.SCOPE}' suite")
@BE_UAA_SCOPE
@TestInstance(PER_CLASS)
class ScopeTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3451") annotation class T3451
@Tag("JTCSALTO-T3452") annotation class T3452
@Tag("JTCSALTO-T3453") annotation class T3453
@Tag("JTCSALTO-T3454") annotation class T3454
@Tag("JTCSALTO-T3455") annotation class T3455
@Tag("JTCSALTO-T3456") annotation class T3456
@Tag("JTCSALTO-T3457") annotation class T3457
@Tag("JTCSALTO-T3458") annotation class T3458
@Tag("JTCSALTO-T3459") annotation class T3459
@Tag("JTCSALTO-T3460") annotation class T3460
@Tag("JTCSALTO-T3461") annotation class T3461
@Tag("JTCSALTO-T3462") annotation class T3462
@Tag("JTCSALTO-T3463") annotation class T3463
@Tag("JTCSALTO-T3464") annotation class T3464
@Tag("JTCSALTO-T3465") annotation class T3465
@Tag("JTCSALTO-T3466") annotation class T3466
@Tag("JTCSALTO-T3467") annotation class T3467
@Tag("JTCSALTO-T3468") annotation class T3468
@Tag("JTCSALTO-T3469") annotation class T3469
@Tag("JTCSALTO-T3470") annotation class T3470
@Tag("JTCSALTO-T3471") annotation class T3471
//@formatter:on
//endregion

    private lateinit var dataForFilter: ScopeDto
    private lateinit var testDataScope: TestDataScope<Scope>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = ScopeData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }


    @TestFactory
    @T3457 //'Скоуп'. CRUD: Создаем запись от пользователя [BANK]
    @T3458 //'Скоуп'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3459 //'Скоуп'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T3460 //'Скоуп'. CRUD: Удаляем запись от пользователя [BANK]
    @T3461 //'Скоуп'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun scopeCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ScopeCreateTest().withId(T3457::class),
                ScopeGetTest().withId(T3458::class),
                ScopeGetPageTest().withId(T3459::class),
                ScopeDeleteTest().withId(T3460::class),
                ScopeUpdateTest().withId(T3461::class)
            )
        )
    }

    @TestFactory
    @T3462 //'Скоуп'. Сортировка по полю 'id, ASC' [BANK]
    @T3463 //'Скоуп'. Сортировка по полю 'description, ASC' [BANK]
    @T3464 //'Скоуп'. Сортировка по полю 'name, ASC' [BANK]
    @T3465 //'Скоуп'. Сортировка по полю 'needApprove, ASC' [BANK]
    @T3466 //'Скоуп'. Сортировка по полю 'resourceId, ASC' [BANK]

    @T3467 //'Скоуп'. Сортировка по полю 'id, DESC' [BANK]
    @T3468 //'Скоуп'. Сортировка по полю 'description, DESC' [BANK]
    @T3469 //'Скоуп'. Сортировка по полю 'name, DESC' [BANK]
    @T3470 //'Скоуп'. Сортировка по полю 'needApprove, DESC' [BANK]
    @T3471 //'Скоуп'. Сортировка по полю 'resourceId, DESC' [BANK]
    internal fun scopeSortingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ScopeSortingTest(ScopeSortingParams.ID::asc).withId(T3462::class),
                ScopeSortingTest(ScopeSortingParams.DESCRIPTION::asc).withId(T3463::class),
                ScopeSortingTest(ScopeSortingParams.NAME::asc).withId(T3464::class),
                ScopeSortingTest(ScopeSortingParams.AUDIENCE::asc).withId(T3465::class),
                ScopeSortingTest(ScopeSortingParams.RESOURCE_ID::asc).withId(T3466::class),

                ScopeSortingTest(ScopeSortingParams.ID::desc).withId(T3467::class),
                ScopeSortingTest(ScopeSortingParams.DESCRIPTION::desc).withId(T3468::class),
                ScopeSortingTest(ScopeSortingParams.NAME::desc).withId(T3469::class),
                ScopeSortingTest(ScopeSortingParams.AUDIENCE::desc).withId(T3470::class),
                ScopeSortingTest(ScopeSortingParams.RESOURCE_ID::desc).withId(T3471::class)
            )
        )
    }


    @TestFactory
    @T3451 //'Скоуп'. Фильтрация по полю 'id' (eq) [BANK]
    @T3452 //'Скоуп'. Фильтрация по полю 'name' (contains) [BANK]
    @T3453 //'Скоуп'. Фильтрация по полю 'description' (contains) [BANK]
    @T3454 //'Скоуп'. Фильтрация по полю 'description' (eq) [BANK]
    @T3455 //'Скоуп'. Фильтрация по полю 'needApprove' (eq) [BANK]
    @T3456 //'Скоуп'. Фильтрация по полю 'resourceId' (eq) [BANK]
    internal fun scopeFiltrationTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ScopeFilterTests("id equals", { dataForFilter },
                    { ID.eq(it!!.id!!) }).withId(T3451::class),
                ScopeFilterTests("name contains", { dataForFilter },
                    { NAME.contains(it!!.name) }).withId(T3452::class),
                ScopeFilterTests("description contains", { dataForFilter },
                    { DESCRIPTION.contains(it!!.description ?: "") }).withId(T3453::class),
                ScopeFilterTests("description equals", { dataForFilter },
                    { DESCRIPTION.eq(it!!.description ?: "") }).withId(T3454::class),
                ScopeFilterTests("needApprove equals", { dataForFilter },
                    { NEED_APPROVE.eq(it!!.needApprove) }).withId(T3455::class),
                ScopeFilterTests("resourceId equals", { dataForFilter },
                    { RESOURCE_ID.eq(it!!.resourceId) }).withId(T3456::class)
            )
        )
    }
}