package ooo.jtc.be.rolemodel.role

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_ROLEMODEL_ROLE
import ooo.jtc.api.rolemodel.privilegegroup.PrivilegeGroupPrepareSteps
import ooo.jtc.api.rolemodel.role.AddPrivilegeGroupToRolesTest
import ooo.jtc.api.rolemodel.role.AddPrivilegeGroupsToRoleTest
import ooo.jtc.api.rolemodel.role.CreateRoleCopyTest
import ooo.jtc.api.rolemodel.role.GetAvailableResourcesTest
import ooo.jtc.api.rolemodel.role.GetContainingRolesForPrivilegeGroupTest
import ooo.jtc.api.rolemodel.role.GetGroupTreeForRoleTest
import ooo.jtc.api.rolemodel.role.GetPrivilegeTreeForRoleTest
import ooo.jtc.api.rolemodel.role.GetRoleTreeTest
import ooo.jtc.api.rolemodel.role.RemovePrivilegeGroupFromRolesTest
import ooo.jtc.api.rolemodel.role.RemovePrivilegeGroupsFromRoleTest
import ooo.jtc.api.rolemodel.role.RolePrepareSteps
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.Issues.JTCSALTO_4327
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto
import ooo.jtc.rolemodel.role.RoleDto
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import ooo.jtc.testdata.rolemodel.privilegegroup.PrivilegeGroupData
import ooo.jtc.testdata.rolemodel.role.RoleData
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
@DisplayName("API '${RoleModelNames.ROLE}' additional suite")
@BE_ROLEMODEL_ROLE
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(ExecutionMode.CONCURRENT)
class RoleOtherTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T6036") annotation class T6036
@Tag("JTCSALTO-T6037") annotation class T6037
@Tag("JTCSALTO-T6038") annotation class T6038
@Tag("JTCSALTO-T6039") annotation class T6039
@Tag("JTCSALTO-T6040") annotation class T6040
@Tag("JTCSALTO-T6041") annotation class T6041
@Tag("JTCSALTO-T6042") annotation class T6042
@Tag("JTCSALTO-T6043") annotation class T6043
@Tag("JTCSALTO-T6044") annotation class T6044
@Tag("JTCSALTO-T6045") annotation class T6045
@Tag("JTCSALTO-T6046") annotation class T6046
@Tag("JTCSALTO-T6047") annotation class T6047
@Tag("JTCSALTO-T6048") annotation class T6048
//@formatter:on
//endregion

    private var atRoles = mutableListOf<RoleDto>()
    private var atPrGroups = mutableListOf<PrivilegeGroupDto>()

    @BeforeAll
    fun prepareTestData() {
        repeat(REQUIRED_DATA_COUNT.toInt(), action = { atRoles.add(RolePrepareSteps.createRoleDto()) })
        repeat(REQUIRED_DATA_COUNT.toInt(), action = { atPrGroups.add(PrivilegeGroupPrepareSteps.createPrivilegeGroupDto()) })
    }

    @AfterAll
    fun cleanTestData() {
        atRoles.forEach { RoleData.removeRecord!!(it.toModel()) }
        atPrGroups.forEach { PrivilegeGroupData.removeRecord!!(it.toModel()) }
    }

    @TestFactory
    @T6036 //'Роль'. Связать Группу привилегий с Ролями [BANK]
    @T6037 //'Роль'. Связать список Групп привилегий с Ролью [BANK]
    @T6038 //'Роль'. Создать копию Роли (без Групп привилегий, без Пользователей) [BANK]
    @T6039 //'Роль'. Создать копию Роли (без Групп привилегий, с Пользователями) [BANK]
    @T6040 //'Роль'. Создать копию Роли (с Группами привилегий, без Пользователей) [BANK]
    @T6041 //'Роль'. Создать копию Роли (с Группами привилегий, с Пользователями) [BANK]
    @T6042 //'Роль'. Получить доступные Ресурсы [BANK]
    @T6043 //'Роль'. Получить список Ролей, использующих указанную Группу привилегий [BANK]
    @T6044 //'Роль'. Получить дерево Групп Привилегий для указанной Роли [BANK]
    @T6045 //'Роль'. Получить дерево Привилегий для указанной Роли [BANK]
    @T6046 //'Роль'. Получить дерево Ролей [BANK]
    @T6047 //'Роль'. Удалить указанную Группу привилегий из списка Ролей [BANK]
    @T6048 //'Роль'. Удалить список Групп привилегий из указанной Роли [BANK]
    internal fun otherRoleTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                AddPrivilegeGroupToRolesTest(roles = atRoles).withId(T6036::class),
                AddPrivilegeGroupsToRoleTest(groups = atPrGroups).withId(T6037::class),
                CreateRoleCopyTest(copyGroups = false, copyUsers = false).withId(T6038::class).withIssues(JTCSALTO_4327),
                CreateRoleCopyTest(copyGroups = false, copyUsers = true).withId(T6039::class).withIssues(JTCSALTO_4327),
                CreateRoleCopyTest(copyGroups = true, copyUsers = false).withId(T6040::class).withIssues(JTCSALTO_4327),
                CreateRoleCopyTest(copyGroups = true, copyUsers = true).withId(T6041::class).withIssues(JTCSALTO_4327),
                GetAvailableResourcesTest().withId(T6042::class),
                GetContainingRolesForPrivilegeGroupTest().withId(T6043::class),
                GetGroupTreeForRoleTest(showIncluded = false, showNonIncluded = true).withId(T6044::class),
                GetGroupTreeForRoleTest(showIncluded = true, showNonIncluded = false).withId(T6044::class),
                GetPrivilegeTreeForRoleTest(showIncluded = false, showNonIncluded = true).withId(T6045::class),
                GetPrivilegeTreeForRoleTest(showIncluded = true, showNonIncluded = false).withId(T6045::class),
                GetRoleTreeTest().withId(T6046::class),
                RemovePrivilegeGroupFromRolesTest(roles = atRoles).withId(T6047::class),
                RemovePrivilegeGroupsFromRoleTest(groups = atPrGroups).withId(T6048::class)
            )
        )
    }
}