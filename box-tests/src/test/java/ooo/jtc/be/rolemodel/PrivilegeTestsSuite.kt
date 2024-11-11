package ooo.jtc.be.rolemodel

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_ROLEMODEL_PRIVILEGE
import ooo.jtc.api.rolemodel.privilege.PrivilegeFilterTest
import ooo.jtc.api.rolemodel.privilege.PrivilegeGetPageTest
import ooo.jtc.api.rolemodel.privilege.PrivilegeGetTest
import ooo.jtc.api.rolemodel.privilege.PrivilegeSortingTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.testdata.rolemodel.privilege.PrivilegeData
import ooo.jtc.testdata.rolemodel.privilege.PrivilegeFilterParams
import ooo.jtc.testdata.rolemodel.privilege.PrivilegeSortingParams
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.ROLE_MODEL)
@Story(RoleModelNames.PRIVILEGE)
@DisplayName("API '${RoleModelNames.PRIVILEGE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_ROLEMODEL_PRIVILEGE
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PrivilegeTestsSuite {
    //region Tags
//@formatter:off
    @Tag("JTCSALTO-T6013") annotation class T6013
    @Tag("JTCSALTO-T6064") annotation class T6064
    @Tag("JTCSALTO-T6065") annotation class T6065
    @Tag("JTCSALTO-T6066") annotation class T6066
    @Tag("JTCSALTO-T6067") annotation class T6067
    @Tag("JTCSALTO-T6068") annotation class T6068
    @Tag("JTCSALTO-T6069") annotation class T6069
    @Tag("JTCSALTO-T6070") annotation class T6070
    @Tag("JTCSALTO-T6071") annotation class T6071
    @Tag("JTCSALTO-T6072") annotation class T6072
    @Tag("JTCSALTO-T6073") annotation class T6073
    @Tag("JTCSALTO-T6077") annotation class T6077
    @Tag("JTCSALTO-T6012") annotation class T6012
    @Tag("JTCSALTO-T6074") annotation class T6074
    @Tag("JTCSALTO-T6075") annotation class T6075
    @Tag("JTCSALTO-T6076") annotation class T6076
    @Tag("JTCSALTO-T6078") annotation class T6078
    @Tag("JTCSALTO-T6079") annotation class T6079
    @Tag("JTCSALTO-T6118") annotation class T6118
    @Tag("JTCSALTO-T6119") annotation class T6119
    @Tag("JTCSALTO-T6120") annotation class T6120
//@formatter:on
//endregion

    @T6012 //'Привилегия'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T6013 //'Привилегия'. CRUD: Получаем запись по id от пользователя [BANK]
    @TestFactory
    internal fun privilegeReadTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PrivilegeGetTest().withId(T6013::class),
                PrivilegeGetPageTest().withId(T6012::class)
            )
        )
    }

    @TestFactory
    @T6066 //'Привилегия'. Сортировка по полю 'name, ASC' [BANK]
    @T6069 //'Привилегия'. Сортировка по полю 'description, ASC' [BANK]
    @T6064 //'Привилегия'. Сортировка по полю 'id, ASC' [BANK]
    @T6068 //'Привилегия'. Сортировка по полю 'uiName, ASC' [BANK]
    @T6067 //'Привилегия'. Сортировка по полю 'accessObjectId, ASC' [BANK]
    @T6065 //'Привилегия'. Сортировка по полю 'id, DESC' [BANK]
    @T6070 //'Привилегия'. Сортировка по полю 'accessObjectId, DESC' [BANK]
    @T6071 //'Привилегия'. Сортировка по полю 'description, DESC' [BANK]
    @T6072 //'Привилегия'. Сортировка по полю 'name, DESC' [BANK]
    @T6073 //'Привилегия'. Сортировка по полю 'uiName, DESC' [BANK]
    internal fun privilegeSortingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PrivilegeSortingTest(PrivilegeSortingParams.ID::asc).withId(T6064::class),
                PrivilegeSortingTest(PrivilegeSortingParams.DESCRIPTION::asc).withId(T6069::class),
                PrivilegeSortingTest(PrivilegeSortingParams.NAME::asc).withId(T6066::class),
                PrivilegeSortingTest(PrivilegeSortingParams.UI_NAME::asc).withId(T6068::class),
                PrivilegeSortingTest(PrivilegeSortingParams.ACCESS_OBJECT_ID::asc).withId(T6067::class),

                PrivilegeSortingTest(PrivilegeSortingParams.ID::desc).withId(T6065::class),
                PrivilegeSortingTest(PrivilegeSortingParams.DESCRIPTION::desc).withId(T6071::class),
                PrivilegeSortingTest(PrivilegeSortingParams.NAME::desc).withId(T6072::class),
                PrivilegeSortingTest(PrivilegeSortingParams.UI_NAME::desc).withId(T6073::class),
                PrivilegeSortingTest(PrivilegeSortingParams.ACCESS_OBJECT_ID::desc).withId(T6070::class),
            )
        )
    }

    private val dataForFilter by lazy {
        PrivilegeData.get().filter { it.description != null }.random().toDto()
    }

    @TestFactory
    @T6077 //'Привилегия'. Фильтрация по полю description eq. [BANK]
    @T6079 //'Привилегия'. Фильтрация по полю name contains. [BANK]
    @T6076 //'Привилегия'. Фильтрация по полю uiName contains. [BANK]
    @T6074 //'Привилегия'. Фильтрация по полю description contains. [BANK]
    @T6075 //'Привилегия'. Фильтрация по полю id equals. [BANK]
    @T6078 //'Привилегия'. Фильтрация по полю accessObjectId equals. [BANK]
    @T6118 //'Привилегия'. Фильтрация по полю name equals. [BANK]
    @T6119 //'Привилегия'. Фильтрация по полю description equals. [BANK]
    @T6120 //'Привилегия'. Фильтрация по полю uiName equals. [BANK]
    internal fun privilegeFilterTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PrivilegeFilterTest("id equals", { dataForFilter },
                    { PrivilegeFilterParams.ID.eq(it!!.id!!) }).withId(T6075::class),
                PrivilegeFilterTest("description equals", { dataForFilter },
                    { PrivilegeFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T6119::class),
                PrivilegeFilterTest("description contains", { dataForFilter },
                    { PrivilegeFilterParams.DESCRIPTION.contains(it!!.description!!) }).withId(T6074::class),
                PrivilegeFilterTest("name contains", { dataForFilter },
                    { PrivilegeFilterParams.NAME.contains(it!!.name) }).withId(T6079::class),
                PrivilegeFilterTest("uiName contains", { dataForFilter },
                    { PrivilegeFilterParams.UI_NAME.contains(it!!.uiName) }).withId(T6076::class),
                PrivilegeFilterTest("name equals", { dataForFilter },
                    { PrivilegeFilterParams.NAME.eq(it!!.name) }).withId(T6118::class),
                PrivilegeFilterTest("uiName equals", { dataForFilter },
                    { PrivilegeFilterParams.UI_NAME.eq(it!!.uiName) }).withId(T6120::class),
                PrivilegeFilterTest("accessObjectId equals", { dataForFilter },
                    { PrivilegeFilterParams.ACCESS_OBJECT_ID.eq(it!!.accessObjectId) }).withId(T6078::class),
            )
        )
    }
}