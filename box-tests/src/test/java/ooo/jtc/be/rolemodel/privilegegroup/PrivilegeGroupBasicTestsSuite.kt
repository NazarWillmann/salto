package ooo.jtc.be.rolemodel.privilegegroup

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_ROLEMODEL_PRIVILEGEGROUP
import ooo.jtc.api.rolemodel.privilegegroup.PrivilegeGroupCreateTest
import ooo.jtc.api.rolemodel.privilegegroup.PrivilegeGroupDeleteTest
import ooo.jtc.api.rolemodel.privilegegroup.PrivilegeGroupFiltrationTest
import ooo.jtc.api.rolemodel.privilegegroup.PrivilegeGroupGetPageTest
import ooo.jtc.api.rolemodel.privilegegroup.PrivilegeGroupGetTest
import ooo.jtc.api.rolemodel.privilegegroup.PrivilegeGroupSortingTest
import ooo.jtc.api.rolemodel.privilegegroup.PrivilegeGroupUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroup
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.rolemodel.privilegegroup.PrivilegeGroupData
import ooo.jtc.testdata.rolemodel.privilegegroup.PrivilegeGroupFilterParams
import ooo.jtc.testdata.rolemodel.privilegegroup.PrivilegeGroupSortingParams
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
@Feature(TestFeature.ROLE_MODEL)
@Story(RoleModelNames.PRIVILEGE_GROUP)
@DisplayName("API '${RoleModelNames.PRIVILEGE_GROUP}' suite")
@BE_ROLEMODEL_PRIVILEGEGROUP
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(ExecutionMode.CONCURRENT)
class PrivilegeGroupBasicTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T6049") annotation class T6049
@Tag("JTCSALTO-T6050") annotation class T6050
@Tag("JTCSALTO-T6051") annotation class T6051
@Tag("JTCSALTO-T6052") annotation class T6052
@Tag("JTCSALTO-T6053") annotation class T6053
@Tag("JTCSALTO-T6054") annotation class T6054
@Tag("JTCSALTO-T6055") annotation class T6055
@Tag("JTCSALTO-T6056") annotation class T6056
@Tag("JTCSALTO-T6057") annotation class T6057
@Tag("JTCSALTO-T6058") annotation class T6058
@Tag("JTCSALTO-T6059") annotation class T6059
@Tag("JTCSALTO-T6060") annotation class T6060
@Tag("JTCSALTO-T6061") annotation class T6061
@Tag("JTCSALTO-T6062") annotation class T6062
@Tag("JTCSALTO-T6063") annotation class T6063
//@formatter:on
//endregion

    private lateinit var dataForFilter: PrivilegeGroupDto
    private lateinit var testDataRole: TestDataScope<PrivilegeGroup>
    private val pgUser = Users.securityAdmin

    @BeforeAll
    fun prepareTestData() {
        testDataRole = PrivilegeGroupData.withRequiredFields()
        dataForFilter = testDataRole.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataRole.removeGenerated()
    }


    @TestFactory
    @T6049 //'Группа привилегий'. CRUD: Создаем запись от пользователя [BANK]
    @T6050 //'Группа привилегий'. CRUD: Получаем запись по id от пользователя [BANK]
    @T6051 //'Группа привилегий'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T6052 //'Группа привилегий'. CRUD: Удаляем запись от пользователя [BANK]
    @T6053 //'Группа привилегий'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun privilegeGroupCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PrivilegeGroupCreateTest().withId(T6049::class),
                PrivilegeGroupGetTest().withId(T6050::class),
                PrivilegeGroupGetPageTest().withId(T6051::class),
                PrivilegeGroupDeleteTest().withId(T6052::class),
                PrivilegeGroupUpdateTest().withId(T6053::class)
            )
        )
    }

    @TestFactory
    @T6054 //'Группа привилегий'. Сортировка по полю 'id, ASC' [BANK]
    @T6055 //'Группа привилегий'. Сортировка по полю 'description, ASC' [BANK]
    @T6056 //'Группа привилегий'. Сортировка по полю 'name, ASC' [BANK]
    @T6057 //'Группа привилегий'. Сортировка по полю 'id, DESC' [BANK]
    @T6058 //'Группа привилегий'. Сортировка по полю 'description, DESC' [BANK]
    @T6059 //'Группа привилегий'. Сортировка по полю 'name, DESC' [BANK]
    internal fun privilegGroupSortingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PrivilegeGroupSortingTest(pgUser, PrivilegeGroupSortingParams.ID::asc).withId(T6054::class),
                PrivilegeGroupSortingTest(pgUser, PrivilegeGroupSortingParams.DESCRIPTION::asc).withId(T6055::class),
                PrivilegeGroupSortingTest(pgUser, PrivilegeGroupSortingParams.NAME::asc).withId(T6056::class),

                PrivilegeGroupSortingTest(pgUser, PrivilegeGroupSortingParams.ID::desc).withId(T6057::class),
                PrivilegeGroupSortingTest(pgUser, PrivilegeGroupSortingParams.DESCRIPTION::desc).withId(T6058::class),
                PrivilegeGroupSortingTest(pgUser, PrivilegeGroupSortingParams.NAME::desc).withId(T6059::class)
            )
        )
    }

    @TestFactory
    @T6060 //'Группа привилегий'. Фильтрация по полю 'id' (eq) [BANK]
    @T6061 //'Группа привилегий'. Фильтрация по полю 'name' (contains) [BANK]
    @T6062 //'Группа привилегий'. Фильтрация по полю 'description' (contains) [BANK]
    @T6063 //'Группа привилегий'. Фильтрация по полю 'description' (eq) [BANK]
    internal fun privilegeGroupFiltrationTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PrivilegeGroupFiltrationTest("id equals", pgUser, { dataForFilter },
                    { PrivilegeGroupFilterParams.ID.eq(it!!.id!!) }).withId(T6060::class),
                PrivilegeGroupFiltrationTest("name contains", pgUser, { dataForFilter },
                    { PrivilegeGroupFilterParams.NAME.contains(it!!.name) }).withId(T6061::class),
                PrivilegeGroupFiltrationTest("description contains", pgUser, { dataForFilter },
                    { PrivilegeGroupFilterParams.DESCRIPTION.contains(it!!.description ?: "") }).withId(T6062::class),
                PrivilegeGroupFiltrationTest("description equals", pgUser, { dataForFilter },
                    { PrivilegeGroupFilterParams.DESCRIPTION.eq(it!!.description ?: "") }).withId(T6063::class)
            )
        )
    }
}