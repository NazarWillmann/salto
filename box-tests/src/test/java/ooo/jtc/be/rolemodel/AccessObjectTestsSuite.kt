package ooo.jtc.be.rolemodel

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_ROLEMODEL_ACCESS_OBJECT
import ooo.jtc.api.rolemodel.accessobject.AccessObjectFilterTest
import ooo.jtc.api.rolemodel.accessobject.AccessObjectGetPageTest
import ooo.jtc.api.rolemodel.accessobject.AccessObjectGetTest
import ooo.jtc.api.rolemodel.accessobject.AccessObjectSortingTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.testdata.rolemodel.accessojbect.AccessObjectData
import ooo.jtc.testdata.rolemodel.accessojbect.AccessObjectFilterParams
import ooo.jtc.testdata.rolemodel.accessojbect.AccessObjectSortingParams
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.ROLE_MODEL)
@Story(RoleModelNames.ACCESS_OBJECT)
@DisplayName("API '${RoleModelNames.ACCESS_OBJECT}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_ROLEMODEL_ACCESS_OBJECT
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccessObjectTestsSuite {
    //region Tags
//@formatter:off
    @Tag("JTCSALTO-T6011") annotation class T6011
    @Tag("JTCSALTO-T6099") annotation class T6099
    @Tag("JTCSALTO-T6100") annotation class T6100
    @Tag("JTCSALTO-T6101") annotation class T6101
    @Tag("JTCSALTO-T6102") annotation class T6102
    @Tag("JTCSALTO-T6103") annotation class T6103
    @Tag("JTCSALTO-T6104") annotation class T6104
    @Tag("JTCSALTO-T6105") annotation class T6105
    @Tag("JTCSALTO-T6106") annotation class T6106
    @Tag("JTCSALTO-T6107") annotation class T6107
    @Tag("JTCSALTO-T6108") annotation class T6108
    @Tag("JTCSALTO-T6109") annotation class T6109
    @Tag("JTCSALTO-T6110") annotation class T6110
    @Tag("JTCSALTO-T6111") annotation class T6111
    @Tag("JTCSALTO-T6112") annotation class T6112
    @Tag("JTCSALTO-T6113") annotation class T6113
    @Tag("JTCSALTO-T6114") annotation class T6114
    @Tag("JTCSALTO-T6115") annotation class T6115
    @Tag("JTCSALTO-T6116") annotation class T6116
    @Tag("JTCSALTO-T6117") annotation class T6117
    @Tag("JTCSALTO-T6010") annotation class T6010
    @Tag("JTCSALTO-T6122") annotation class T6122
    @Tag("JTCSALTO-T6123") annotation class T6123
//@formatter:on
//endregion
 
    //Access object is read-only entity
    //TODO Khatmullin [13.08.2021]: need to be actualised after fixing the bug
    // https://jira.jtc.ooo/browse/JTCSALTO-4386

    @T6011 //'Объект доступа Системы'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T6010 //'Объект доступа Системы'. CRUD: Получаем запись по id от пользователя [BANK]
    @TestFactory
    internal fun accessObjectReadTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                AccessObjectGetTest().withId(T6010::class),
                AccessObjectGetPageTest().withId(T6011::class)
            )
        )
    }

    private val dataForFilter by lazy { AccessObjectData.randomOrException().toDto() }

    @TestFactory
    @T6103 //'Объект доступа Системы'. Фильтрация по полю 'name' (contains) [BANK]
    @T6102 //'Объект доступа Системы'. Фильтрация по полю 'id' (eq) [BANK]
    @T6104 //'Объект доступа Системы'. Фильтрация по полю 'uiName' (contains) [BANK]
    @T6100 //'Объект доступа Системы'. Фильтрация по полю 'description' (eq) [BANK]
    @T6099 //'Объект доступа Системы'. Фильтрация по полю 'description' (contains) [BANK]
    @T6101 //'Объект доступа Системы'. Фильтрация по полю 'productId' (eq) [BANK]
    @T6105 //'Объект доступа Системы'. Фильтрация по полю 'objectTypeId' (eq) [BANK]
    @T6122 //'Объект доступа Системы'. Фильтрация по полю 'name' (eq) [BANK]
    @T6123 //'Объект доступа Системы'. Фильтрация по полю 'uiName' (eq) [BANK]
    internal fun accessObjectFilterTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                AccessObjectFilterTest("id equals", { dataForFilter },
                    { AccessObjectFilterParams.ID.eq(it!!.id!!) }).withId(T6102::class),
                AccessObjectFilterTest("description eq", { dataForFilter },
                    { AccessObjectFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T6100::class),
                AccessObjectFilterTest("description contains", { dataForFilter },
                    { AccessObjectFilterParams.DESCRIPTION.contains(it!!.description!!) }).withId(T6099::class),
                AccessObjectFilterTest("name contains", { dataForFilter },
                    { AccessObjectFilterParams.NAME.contains(it!!.name) }).withId(T6103::class),
                AccessObjectFilterTest("uiName contains", { dataForFilter },
                    { AccessObjectFilterParams.UI_NAME.contains(it!!.uiName) }).withId(T6104::class),
                AccessObjectFilterTest("name equals", { dataForFilter },
                    { AccessObjectFilterParams.NAME.eq(it!!.name) }).withId(T6122::class),
                AccessObjectFilterTest("uiName equals", { dataForFilter },
                    { AccessObjectFilterParams.UI_NAME.eq(it!!.uiName) }).withId(T6123::class),
                AccessObjectFilterTest("productId equals", { dataForFilter },
                    { AccessObjectFilterParams.PRODUCT_ID.eq(it!!.productId) }).withId(T6101::class),
                AccessObjectFilterTest("objectTypeId equals", { dataForFilter },
                    { AccessObjectFilterParams.OBJECT_TYPE_ID.eq(it!!.objectTypeId) }).withId(T6105::class),
            )
        )
    }

    @TestFactory
    @T6107 //'Объект доступа Системы'. Сортировка по полю 'name, ASC' [BANK]
    @T6108 //'Объект доступа Системы'. Сортировка по полю 'id, ASC' [BANK]
    @T6106 //'Объект доступа Системы'. Сортировка по полю 'objectTypeId, ASC' [BANK]
    @T6109 //'Объект доступа Системы'. Сортировка по полю 'uiName, DESC' [BANK]
    @T6110 //'Объект доступа Системы'. Сортировка по полю 'productId, ASC' [BANK]
    @T6111 //'Объект доступа Системы'. Сортировка по полю 'description, ASC' [BANK]
    @T6112 //'Объект доступа Системы'. Сортировка по полю 'id, DESC' [BANK]
    @T6113 //'Объект доступа Системы'. Сортировка по полю 'uiName, ASC' [BANK]
    @T6115 //'Объект доступа Системы'. Сортировка по полю 'productId, DESC' [BANK]
    @T6114 //'Объект доступа Системы'. Сортировка по полю 'objectTypeId, DESC' [BANK]
    @T6117 //'Объект доступа Системы'. Сортировка по полю 'description, DESC' [BANK]
    @T6116 //'Объект доступа Системы'. Сортировка по полю 'name, DESC' [BANK]
    internal fun accessObjectSortingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                AccessObjectSortingTest(AccessObjectSortingParams.ID::asc).withId(T6108::class),
                AccessObjectSortingTest(AccessObjectSortingParams.DESCRIPTION::asc).withId(T6111::class),
                AccessObjectSortingTest(AccessObjectSortingParams.NAME::asc).withId(T6107::class),
                AccessObjectSortingTest(AccessObjectSortingParams.PRODUCT_ID::asc).withId(T6110::class),
                AccessObjectSortingTest(AccessObjectSortingParams.OBJECT_TYPE_ID::asc).withId(T6106::class),
                AccessObjectSortingTest(AccessObjectSortingParams.UI_NAME::asc).withId(T6113::class),

                AccessObjectSortingTest(AccessObjectSortingParams.ID::desc).withId(T6112::class),
                AccessObjectSortingTest(AccessObjectSortingParams.DESCRIPTION::desc).withId(T6117::class),
                AccessObjectSortingTest(AccessObjectSortingParams.NAME::desc).withId(T6116::class),
                AccessObjectSortingTest(AccessObjectSortingParams.PRODUCT_ID::desc).withId(T6115::class),
                AccessObjectSortingTest(AccessObjectSortingParams.OBJECT_TYPE_ID::desc).withId(T6114::class),
                AccessObjectSortingTest(AccessObjectSortingParams.UI_NAME::desc).withId(T6109::class),
            )
        )
    }
}