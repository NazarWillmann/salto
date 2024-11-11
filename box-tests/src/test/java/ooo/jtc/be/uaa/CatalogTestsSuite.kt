package ooo.jtc.be.uaa

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_UAA_CATALOG
import ooo.jtc.api.uaa.tests.CatalogCreateTest
import ooo.jtc.api.uaa.tests.CatalogDeleteTest
import ooo.jtc.api.uaa.tests.CatalogFilterTests
import ooo.jtc.api.uaa.tests.CatalogGetPageTest
import ooo.jtc.api.uaa.tests.CatalogGetTest
import ooo.jtc.api.uaa.tests.CatalogSortingTest
import ooo.jtc.api.uaa.tests.CatalogUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.UaaNames
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.uaa.catalog.CatalogData
import ooo.jtc.testdata.uaa.catalog.CatalogFilterParams.APPEARANCE
import ooo.jtc.testdata.uaa.catalog.CatalogFilterParams.CATALOG_KIND
import ooo.jtc.testdata.uaa.catalog.CatalogFilterParams.CATALOG_TYPE
import ooo.jtc.testdata.uaa.catalog.CatalogFilterParams.ENABLED
import ooo.jtc.testdata.uaa.catalog.CatalogFilterParams.ID
import ooo.jtc.testdata.uaa.catalog.CatalogFilterParams.NAME
import ooo.jtc.testdata.uaa.catalog.CatalogFilterParams.TITLE
import ooo.jtc.testdata.uaa.catalog.CatalogSortingParams
import ooo.jtc.uaa.catalog.dto.CatalogDto
import ooo.jtc.uaa.catalog.model.Catalog
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
@Feature(TestFeature.UAA)
@Story(UaaNames.CATALOG)
@DisplayName("API '${UaaNames.CATALOG}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_UAA_CATALOG
@TestInstance(PER_CLASS)
class CatalogTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3377") annotation class T3377
@Tag("JTCSALTO-T3378") annotation class T3378
@Tag("JTCSALTO-T3379") annotation class T3379
@Tag("JTCSALTO-T3380") annotation class T3380
@Tag("JTCSALTO-T3381") annotation class T3381
@Tag("JTCSALTO-T3382") annotation class T3382
@Tag("JTCSALTO-T3383") annotation class T3383
@Tag("JTCSALTO-T3384") annotation class T3384
@Tag("JTCSALTO-T3385") annotation class T3385
@Tag("JTCSALTO-T3386") annotation class T3386
@Tag("JTCSALTO-T3387") annotation class T3387
@Tag("JTCSALTO-T3388") annotation class T3388
@Tag("JTCSALTO-T3389") annotation class T3389
@Tag("JTCSALTO-T3390") annotation class T3390
@Tag("JTCSALTO-T3391") annotation class T3391
@Tag("JTCSALTO-T3392") annotation class T3392
@Tag("JTCSALTO-T3393") annotation class T3393
@Tag("JTCSALTO-T3394") annotation class T3394
@Tag("JTCSALTO-T3395") annotation class T3395
@Tag("JTCSALTO-T3396") annotation class T3396
@Tag("JTCSALTO-T3397") annotation class T3397
@Tag("JTCSALTO-T3398") annotation class T3398
@Tag("JTCSALTO-T3399") annotation class T3399
@Tag("JTCSALTO-T3400") annotation class T3400
@Tag("JTCSALTO-T3401") annotation class T3401
@Tag("JTCSALTO-T3402") annotation class T3402
@Tag("JTCSALTO-T3403") annotation class T3403
@Tag("JTCSALTO-T3404") annotation class T3404
@Tag("JTCSALTO-T3405") annotation class T3405
@Tag("JTCSALTO-T3406") annotation class T3406
@Tag("JTCSALTO-T3407") annotation class T3407
@Tag("JTCSALTO-T3408") annotation class T3408
//@formatter:on
//endregion


    private lateinit var dataForFilter: CatalogDto
    private lateinit var testDataScope: TestDataScope<Catalog>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = CatalogData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T3377 //'Каталог'. CRUD: Создаем запись от пользователя [BANK]
    @T3378 //'Каталог'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3379 //'Каталог'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T3380 //'Каталог'. CRUD: Удаляем запись от пользователя [BANK]
    @T3408 //'Каталог'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun catalogCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                CatalogCreateTest().withId(T3377::class),
                CatalogGetTest().withId(T3378::class),
                CatalogGetPageTest().withId(T3379::class),
                CatalogDeleteTest().withId(T3380::class),
                CatalogUpdateTest().withId(T3408::class)
            )
        )
    }

    @TestFactory
    @T3381 //'Каталог'. Сортировка по полю 'id, ASC' [BANK]
    @T3382 //'Каталог'. Сортировка по полю 'catalogType, ASC' [BANK]
    @T3383 //'Каталог'. Сортировка по полю 'catalogKind, ASC' [BANK]
    @T3384 //'Каталог'. Сортировка по полю 'name, ASC' [BANK]
    @T3385 //'Каталог'. Сортировка по полю 'title, ASC' [BANK]
    @T3386 //'Каталог'. Сортировка по полю 'appearance, ASC' [BANK]
    @T3387 //'Каталог'. Сортировка по полю 'description, ASC' [BANK]
    @T3388 //'Каталог'. Сортировка по полю 'enabled, ASC' [BANK]

    @T3389 //'Каталог'. Сортировка по полю 'id, DESC' [BANK]
    @T3390 //'Каталог'. Сортировка по полю 'catalogType, DESC' [BANK]
    @T3391 //'Каталог'. Сортировка по полю 'catalogKind, DESC' [BANK]
    @T3392 //'Каталог'. Сортировка по полю 'name, DESC' [BANK]
    @T3393 //'Каталог'. Сортировка по полю 'title, DESC' [BANK]
    @T3394 //'Каталог'. Сортировка по полю 'appearance, DESC' [BANK]
    @T3395 //'Каталог'. Сортировка по полю 'description, DESC' [BANK]
    @T3396 //'Каталог'. Сортировка по полю 'enabled, DESC' [BANK]
    internal fun catalogSortingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                CatalogSortingTest(CatalogSortingParams.ID::asc).withId(T3381::class),
                CatalogSortingTest(CatalogSortingParams.CATALOG_TYPE::asc).withId(T3382::class),
                CatalogSortingTest(CatalogSortingParams.CATALOG_KIND::asc).withId(T3383::class),
                CatalogSortingTest(CatalogSortingParams.NAME::asc).withId(T3384::class),
                CatalogSortingTest(CatalogSortingParams.TITLE::asc).withId(T3385::class),
                CatalogSortingTest(CatalogSortingParams.APPEARANCE::asc).withId(T3386::class),
                CatalogSortingTest(CatalogSortingParams.DESCRIPTION::asc).withId(T3387::class),
                CatalogSortingTest(CatalogSortingParams.ENABLED::asc).withId(T3388::class),

                CatalogSortingTest(CatalogSortingParams.ID::desc).withId(T3389::class),
                CatalogSortingTest(CatalogSortingParams.CATALOG_TYPE::desc).withId(T3390::class),
                CatalogSortingTest(CatalogSortingParams.CATALOG_KIND::desc).withId(T3391::class),
                CatalogSortingTest(CatalogSortingParams.NAME::desc).withId(T3392::class),
                CatalogSortingTest(CatalogSortingParams.TITLE::desc).withId(T3393::class),
                CatalogSortingTest(CatalogSortingParams.APPEARANCE::desc).withId(T3394::class),
                CatalogSortingTest(CatalogSortingParams.DESCRIPTION::desc).withId(T3395::class),
                CatalogSortingTest(CatalogSortingParams.ENABLED::desc).withId(T3396::class)
            )
        )
    }

    @TestFactory
    @T3397 //'Каталог'. Фильтрация по полю 'id' (eq) [BANK]
    @T3398 //'Каталог'. Фильтрация по полю 'catalogType' (eq) [BANK]
    @T3399 //'Каталог'. Фильтрация по полю 'catalogType' (contains) [BANK]
    @T3400 //'Каталог'. Фильтрация по полю 'catalogKind' (eq) [BANK]
    @T3401 //'Каталог'. Фильтрация по полю 'name' (eq) [BANK]
    @T3402 //'Каталог'. Фильтрация по полю 'name' (contains) [BANK]
    @T3403 //'Каталог'. Фильтрация по полю 'title' (eq) [BANK]
    @T3404 //'Каталог'. Фильтрация по полю 'title' (contains) [BANK]
    @T3405 //'Каталог'. Фильтрация по полю 'appearance' (eq) [BANK]
    @T3406 //'Каталог'. Фильтрация по полю 'appearance' (contains) [BANK]
    @T3407 //'Каталог'. Фильтрация по полю 'enabled' (eq) [BANK]
    internal fun catalogFiltrationTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                CatalogFilterTests("id equals", { dataForFilter },
                    { ID.eq(it!!.id!!) }).withId(T3397::class),
                CatalogFilterTests("catalogType equals", { dataForFilter },
                    { CATALOG_TYPE.eq(it!!.catalogType) }).withId(T3398::class),
                CatalogFilterTests("catalogType contains", { dataForFilter },
                    { CATALOG_TYPE.contains(it!!.catalogType.randomSubstringPf()) }).withId(T3399::class),
                CatalogFilterTests("catalogKind equals", { dataForFilter },
                    { CATALOG_KIND.eq(it!!.catalogKind) }).withId(T3400::class),
                CatalogFilterTests("name equals", { dataForFilter },
                    { NAME.eq(it!!.name) }).withId(T3401::class),
                CatalogFilterTests("name contains", { dataForFilter },
                    { NAME.contains(it!!.name.randomSubstringPf()) }).withId(T3402::class),
                CatalogFilterTests("title equals", { dataForFilter },
                    { TITLE.eq(it!!.title ?: "") }).withId(T3403::class),
                CatalogFilterTests("title contains", { dataForFilter },
                    { TITLE.contains((it!!.title ?: "").randomSubstringPf()) }).withId(T3404::class),
                CatalogFilterTests("appearance equals", { dataForFilter },
                    { APPEARANCE.eq(it!!.appearance ?: "") }).withId(T3405::class),
                CatalogFilterTests("appearance contains", { dataForFilter },
                    { APPEARANCE.contains((it!!.appearance ?: "").randomSubstringPf()) }).withId(T3406::class),
                CatalogFilterTests("enabled equals", { dataForFilter },
                    { ENABLED.eq(it!!.enabled) }).withId(T3407::class)
            )
        )
    }
}