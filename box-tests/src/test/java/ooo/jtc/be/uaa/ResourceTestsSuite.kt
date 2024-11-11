package ooo.jtc.be.uaa

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_UAA_RESOURCE
import ooo.jtc.api.uaa.tests.ResourceCreateTest
import ooo.jtc.api.uaa.tests.ResourceDeleteTest
import ooo.jtc.api.uaa.tests.ResourceFilterTest
import ooo.jtc.api.uaa.tests.ResourceGetPageTest
import ooo.jtc.api.uaa.tests.ResourceGetTest
import ooo.jtc.api.uaa.tests.ResourceSortingTest
import ooo.jtc.api.uaa.tests.ResourceUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.UaaNames
import ooo.jtc.testdata.uaa.resource.ResourceData
import ooo.jtc.testdata.uaa.resource.ResourceFilterParams.AUDIENCE
import ooo.jtc.testdata.uaa.resource.ResourceFilterParams.DESCRIPTION
import ooo.jtc.testdata.uaa.resource.ResourceFilterParams.ID
import ooo.jtc.testdata.uaa.resource.ResourceFilterParams.NAME
import ooo.jtc.testdata.uaa.resource.ResourceSortingParams
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.UAA)
@Story(UaaNames.RESOURCE)
@DisplayName("API '${UaaNames.RESOURCE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_UAA_RESOURCE
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ResourceTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T3433") annotation class T3433
@Tag("JTCSALTO-T3434") annotation class T3434
@Tag("JTCSALTO-T3435") annotation class T3435
@Tag("JTCSALTO-T3436") annotation class T3436
@Tag("JTCSALTO-T3437") annotation class T3437
@Tag("JTCSALTO-T3438") annotation class T3438
@Tag("JTCSALTO-T3439") annotation class T3439
@Tag("JTCSALTO-T3440") annotation class T3440
@Tag("JTCSALTO-T3441") annotation class T3441
@Tag("JTCSALTO-T3442") annotation class T3442
@Tag("JTCSALTO-T3443") annotation class T3443
@Tag("JTCSALTO-T3444") annotation class T3444
@Tag("JTCSALTO-T3445") annotation class T3445
@Tag("JTCSALTO-T3446") annotation class T3446
@Tag("JTCSALTO-T3447") annotation class T3447
@Tag("JTCSALTO-T3448") annotation class T3448
@Tag("JTCSALTO-T3449") annotation class T3449
@Tag("JTCSALTO-T3450") annotation class T3450
@Tag("JTCSALTO-T6126") annotation class T6126
//@formatter:on
//endregion
    

    @TestFactory
    @T3433 //'Ресурс'. CRUD: Создаем запись от пользователя [BANK]
    @T3434 //'Ресурс'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3435 //'Ресурс'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T3436 //'Ресурс'. CRUD: Удаляем запись от пользователя [BANK]
    @T3437 //'Ресурс'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun resourceCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ResourceCreateTest().withId(T3433::class),
                ResourceGetTest().withId(T3434::class),
                ResourceGetPageTest().withId(T3435::class),
                ResourceDeleteTest().withId(T3436::class),
                ResourceUpdateTest().withId(T3437::class)
            )
        )
    }

    @TestFactory
    @T3443 //'Ресурс'. Сортировка по полю 'id, ASC' [BANK]
    @T3444 //'Ресурс'. Сортировка по полю 'description, ASC' [BANK]
    @T3445 //'Ресурс'. Сортировка по полю 'name, ASC' [BANK]
    @T3446 //'Ресурс'. Сортировка по полю 'audience, ASC' [BANK]

    @T3447 //'Ресурс'. Сортировка по полю 'id, DESC' [BANK]
    @T3448 //'Ресурс'. Сортировка по полю 'description, DESC' [BANK]
    @T3449 //'Ресурс'. Сортировка по полю 'name, DESC' [BANK]
    @T3450 //'Ресурс'. Сортировка по полю 'audience, DESC' [BANK]
    internal fun resourceSortingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ResourceSortingTest(ResourceSortingParams.ID::asc).withId(T3443::class),
                ResourceSortingTest(ResourceSortingParams.DESCRIPTION::asc).withId(T3444::class),
                ResourceSortingTest(ResourceSortingParams.NAME::asc).withId(T3445::class),
                ResourceSortingTest(ResourceSortingParams.AUDIENCE::asc).withId(T3446::class),

                ResourceSortingTest(ResourceSortingParams.ID::desc).withId(T3447::class),
                ResourceSortingTest(ResourceSortingParams.DESCRIPTION::desc).withId(T3448::class),
                ResourceSortingTest(ResourceSortingParams.NAME::desc).withId(T3449::class),
                ResourceSortingTest(ResourceSortingParams.AUDIENCE::desc).withId(T3450::class)
            )
        )
    }

    private val dataForFilter by lazy { ResourceData.randomOrException().toDto() }

    @TestFactory
    @T3438 //'Ресурс'. Фильтрация по полю 'id' (eq) [BANK]
    @T3439 //'Ресурс'. Фильтрация по полю 'name' (contains) [BANK]
    @T3440 //'Ресурс'. Фильтрация по полю 'description' (contains) [BANK]
    @T3441 //'Ресурс'. Фильтрация по полю 'description' (eq) [BANK]
    @T3442 //'Ресурс'. Фильтрация по полю 'audience' (eq) [BANK]
    @T6126 //'Ресурс'. Фильтрация по полю 'name' (eq) [BANK]
    internal fun resourceFiltrationTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ResourceFilterTest("id equals", { dataForFilter },
                    { ID.eq(it!!.id!!) }).withId(T3438::class),
                ResourceFilterTest("name contains", { dataForFilter },
                    { NAME.contains(it!!.name) }).withId(T3439::class),
                ResourceFilterTest("name equals", { dataForFilter },
                    { NAME.eq(it!!.name) }),
                ResourceFilterTest("description contains", { dataForFilter },
                    { DESCRIPTION.contains(it!!.description) }).withId(T3440::class),
                ResourceFilterTest("description equals", { dataForFilter },
                    { DESCRIPTION.eq(it!!.description) }).withId(T3441::class),
                ResourceFilterTest("audience equals", { dataForFilter },
                    { AUDIENCE.eq(it!!.audience) }).withId(T3442::class)
            )
        )
    }
}