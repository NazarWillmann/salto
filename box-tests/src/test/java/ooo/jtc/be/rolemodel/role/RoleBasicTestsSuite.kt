package ooo.jtc.be.rolemodel.role

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_ROLEMODEL_ROLE
import ooo.jtc.api.rolemodel.role.RoleCreateTest
import ooo.jtc.api.rolemodel.role.RoleDeleteTest
import ooo.jtc.api.rolemodel.role.RoleFiltrationTest
import ooo.jtc.api.rolemodel.role.RoleGetPageTest
import ooo.jtc.api.rolemodel.role.RoleGetTest
import ooo.jtc.api.rolemodel.role.RoleSortingTest
import ooo.jtc.api.rolemodel.role.RoleUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.rolemodel.role.Role
import ooo.jtc.rolemodel.role.RoleDto
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.rolemodel.role.RoleData
import ooo.jtc.testdata.rolemodel.role.RoleFilterParams
import ooo.jtc.testdata.rolemodel.role.RoleSortingParams
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
@Story(RoleModelNames.ROLE)
@DisplayName("API '${RoleModelNames.ROLE}' suite")
@BE_ROLEMODEL_ROLE
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(ExecutionMode.CONCURRENT)
class RoleBasicTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T6018") annotation class T6018
@Tag("JTCSALTO-T6019") annotation class T6019
@Tag("JTCSALTO-T6020") annotation class T6020
@Tag("JTCSALTO-T6021") annotation class T6021
@Tag("JTCSALTO-T6022") annotation class T6022
@Tag("JTCSALTO-T6023") annotation class T6023
@Tag("JTCSALTO-T6024") annotation class T6024
@Tag("JTCSALTO-T6025") annotation class T6025
@Tag("JTCSALTO-T6026") annotation class T6026
@Tag("JTCSALTO-T6027") annotation class T6027
@Tag("JTCSALTO-T6028") annotation class T6028
@Tag("JTCSALTO-T6029") annotation class T6029
@Tag("JTCSALTO-T6030") annotation class T6030
@Tag("JTCSALTO-T6031") annotation class T6031
@Tag("JTCSALTO-T6032") annotation class T6032
@Tag("JTCSALTO-T6033") annotation class T6033
@Tag("JTCSALTO-T6034") annotation class T6034
@Tag("JTCSALTO-T6035") annotation class T6035
//@formatter:on
//endregion

    private lateinit var dataForFilter: RoleDto
    private lateinit var testDataRole: TestDataScope<Role>

    @BeforeAll
    fun prepareTestData() {
        testDataRole = RoleData.withRequiredFields()
        dataForFilter = testDataRole.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataRole.removeGenerated()
    }

    private val roleUser = Users.securityAdmin

    @TestFactory
    @T6026 //'Роль'. CRUD: Создаем запись от пользователя [BANK]
    @T6027 //'Роль'. CRUD: Получаем запись по id от пользователя [BANK]
    @T6028 //'Роль'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T6029 //'Роль'. CRUD: Удаляем запись от пользователя [BANK]
    @T6030 //'Роль'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun roleCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                RoleCreateTest().withId(T6026::class),
                RoleGetTest().withId(T6027::class),
                RoleGetPageTest().withId(T6028::class),
                RoleDeleteTest().withId(T6029::class),
                RoleUpdateTest().withId(T6030::class)
            )
        )
    }

    @TestFactory
    @T6018 //'Роль'. Сортировка по полю 'id, ASC' [BANK]
    @T6019 //'Роль'. Сортировка по полю 'description, ASC' [BANK]
    @T6020 //'Роль'. Сортировка по полю 'name, ASC' [BANK]
    @T6021 //'Роль'. Сортировка по полю 'resourceId, ASC' [BANK]
    @T6022 //'Роль'. Сортировка по полю 'id, DESC' [BANK]
    @T6023 //'Роль'. Сортировка по полю 'description, DESC' [BANK]
    @T6024 //'Роль'. Сортировка по полю 'name, DESC' [BANK]
    @T6025 //'Роль'. Сортировка по полю 'resourceId, DESC' [BANK]
    internal fun roleSortingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                RoleSortingTest(roleUser, RoleSortingParams.ID::asc).withId(T6018::class),
                RoleSortingTest(roleUser, RoleSortingParams.DESCRIPTION::asc).withId(T6019::class),
                RoleSortingTest(roleUser, RoleSortingParams.NAME::asc).withId(T6020::class),
                RoleSortingTest(roleUser, RoleSortingParams.RESOURCE_ID::asc).withId(T6021::class),

                RoleSortingTest(roleUser, RoleSortingParams.ID::desc).withId(T6022::class),
                RoleSortingTest(roleUser, RoleSortingParams.DESCRIPTION::desc).withId(T6023::class),
                RoleSortingTest(roleUser, RoleSortingParams.NAME::desc).withId(T6024::class),
                RoleSortingTest(roleUser, RoleSortingParams.RESOURCE_ID::desc).withId(T6025::class)
            )
        )
    }

    @TestFactory
    @T6031 //'Роль'. Фильтрация по полю 'id' (eq) [BANK]
    @T6032 //'Роль'. Фильтрация по полю 'name' (contains) [BANK]
    @T6033 //'Роль'. Фильтрация по полю 'description' (contains) [BANK]
    @T6034 //'Роль'. Фильтрация по полю 'description' (eq) [BANK]
    @T6035 //'Роль'. Фильтрация по полю 'resourceId' (eq) [BANK]
    internal fun roleFiltrationTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                RoleFiltrationTest("id equals", roleUser, { dataForFilter },
                    { RoleFilterParams.ID.eq(it!!.id!!) }).withId(T6031::class),
                RoleFiltrationTest("name contains", roleUser, { dataForFilter },
                    { RoleFilterParams.NAME.contains(it!!.name) }).withId(T6032::class),
                RoleFiltrationTest("description contains", roleUser, { dataForFilter },
                    { RoleFilterParams.DESCRIPTION.contains(it!!.description ?: "") }).withId(T6033::class),
                RoleFiltrationTest("description equals", roleUser, { dataForFilter },
                    { RoleFilterParams.DESCRIPTION.eq(it!!.description ?: "") }).withId(T6034::class),
                RoleFiltrationTest("resourceId equals", roleUser, { dataForFilter },
                    { RoleFilterParams.RESOURCE_ID.eq(it!!.resourceId!!) }).withId(T6035::class)
            )
        )
    }
}