package ooo.jtc.be.rolemodel

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_ROLEMODEL_ACCESS_OBJECT_TYPE
import ooo.jtc.api.rolemodel.accessobjecttype.AccessObjectTypeFilterTest
import ooo.jtc.api.rolemodel.accessobjecttype.AccessObjectTypeGetPageTest
import ooo.jtc.api.rolemodel.accessobjecttype.AccessObjectTypeGetTest
import ooo.jtc.api.rolemodel.accessobjecttype.AccessObjectTypeSortingTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.testdata.rolemodel.accessobjecttype.AccessObjectTypeData
import ooo.jtc.testdata.rolemodel.accessobjecttype.AccessObjectTypeFilterParams
import ooo.jtc.testdata.rolemodel.accessobjecttype.AccessObjectTypeSortingParams
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.ROLE_MODEL)
@Story(RoleModelNames.ACCESS_OBJECT_TYPE)
@DisplayName("API '${RoleModelNames.ACCESS_OBJECT_TYPE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_ROLEMODEL_ACCESS_OBJECT_TYPE
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccessObjectTypeTestsSuite {
    //region Tags
//@formatter:off
    @Tag("JTCSALTO-T6017") annotation class T6017
    @Tag("JTCSALTO-T6093") annotation class T6093
    @Tag("JTCSALTO-T6094") annotation class T6094
    @Tag("JTCSALTO-T6095") annotation class T6095
    @Tag("JTCSALTO-T6096") annotation class T6096
    @Tag("JTCSALTO-T6097") annotation class T6097
    @Tag("JTCSALTO-T6098") annotation class T6098
    @Tag("JTCSALTO-T6016") annotation class T6016
    @Tag("JTCSALTO-T6121") annotation class T6121
//@formatter:on
//endregion

    @T6016 //'Тип объекта доступа'. CRUD: Получаем запись по id от пользователя [BANK]
    @T6017 //'Тип объекта доступа'. CRUD: Получаем страницу записей от пользователя [BANK]
    @TestFactory
    internal fun accessObjectTypeReadTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                AccessObjectTypeGetTest().withId(T6016::class),
                AccessObjectTypeGetPageTest().withId(T6017::class)
            )
        )
    }

    private val dataForFilter by lazy { AccessObjectTypeData.randomOrException().toDto() }

    @TestFactory
    @T6097 //'Тип объекта доступа'. Фильтрация по полю 'id' (eq) [BANK]
    @T6098 //'Тип объекта доступа'. Фильтрация по полю 'name' (contains) [BANK]
    @T6121 //'Тип объекта доступа'. Фильтрация по полю 'name' (eq) [BANK]
    internal fun accessObjectTypeFilterTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                AccessObjectTypeFilterTest("id equals", { dataForFilter },
                    { AccessObjectTypeFilterParams.ID.eq(it!!.id!!) }).withId(T6097::class),
                AccessObjectTypeFilterTest("name contains", { dataForFilter },
                    { AccessObjectTypeFilterParams.NAME.contains(it!!.name) }).withId(T6098::class),
                AccessObjectTypeFilterTest("name equals", { dataForFilter },
                    { AccessObjectTypeFilterParams.NAME.eq(it!!.name) }).withId(T6121::class),
            )
        )
    }

    @TestFactory
    @T6093 //'Тип объекта доступа'. Сортировка по полю 'name, ASC' [BANK]
    @T6094 //'Тип объекта доступа'. Сортировка по полю 'name, DESC' [BANK]
    @T6095 //'Тип объекта доступа'. Сортировка по полю 'id, ASC' [BANK]
    @T6096 //'Тип объекта доступа'. Сортировка по полю 'id, DESC' [BANK]
    internal fun accessObjectSortingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                AccessObjectTypeSortingTest(AccessObjectTypeSortingParams.ID::asc).withId(T6095::class),
                AccessObjectTypeSortingTest(AccessObjectTypeSortingParams.NAME::asc).withId(T6093::class),

                AccessObjectTypeSortingTest(AccessObjectTypeSortingParams.ID::desc).withId(T6096::class),
                AccessObjectTypeSortingTest(AccessObjectTypeSortingParams.NAME::desc).withId(T6094::class),
            )
        )
    }
}