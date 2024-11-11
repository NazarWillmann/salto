package ooo.jtc.api.rolemodel.role

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.common.tests.AbstractBeTest
import ooo.jtc.api.rolemodel.privilegegroup.PrivilegeGroupPrepareSteps
import ooo.jtc.api.rolemodel.role.RolePrepareSteps.prepareRoleDtoForCreate
import ooo.jtc.api.rolemodel.role.RolePrepareSteps.prepareRoleDtoForUpdate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jStoryAT
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto
import ooo.jtc.rolemodel.role.RoleDto
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.rolemodel.privilegegroup.PrivilegeGroupData
import ooo.jtc.testdata.rolemodel.role.RoleData
import ooo.jtc.testdata.rolemodel.role.RoleFilterParams
import ooo.jtc.testdata.rolemodel.role.RoleSortingParams
import ooo.jtc.testdata.uaa.resource.ResourceData
import ooo.jtc.uaa.User
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInRelativeOrder
import org.hamcrest.Matchers.empty
import org.hamcrest.Matchers.not

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${RoleModelNames.ROLE}\" (role)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class RoleFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class RoleFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class RoleFolderFiltration
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class RoleFolderOther

//AT_STORY_ROLEMODEL = "JTCSALTO-3484"                      //Проект развития JTC СДМ УБРиР > Механизмы > Права доступа (роли/привилегии и раздача прав)
private const val AT_STORY_ROLEMODEL_AN = "JTCSALTO-3914"   // > Аналитика (уточнение требований)
private const val AT_STORY_ROLEMODEL_AT = "JTCSALTO-3917"   // > Тестирование (автотесты)
private const val AT_STORY_ROLEMODEL_DEV = "JTCSALTO-3482"  // > Разработка бэк (по уточнённым требованиям)

@TaskIds([Tm4jStoryAT.AT_STORY_ROLEMODEL, AT_STORY_ROLEMODEL_AN, AT_STORY_ROLEMODEL_AT, AT_STORY_ROLEMODEL_DEV])
annotation class RoleTaskIdsCommon
//@formatter:on

//region Basic tests
@RoleTaskIdsCommon
@RoleFolderCrud
@ComponentDictionary
@HighPriority
class RoleCreateTest(user: User = Users.securityAdmin) :
    CreateTestTemplate<RoleDto>(
        preExecution = { prepareRoleDtoForCreate() },
        steps = RoleSteps(user)
    )

@RoleTaskIdsCommon
@RoleFolderCrud
@ComponentDictionary
@HighPriority
class RoleGetTest(user: User = Users.securityAdmin) :
    GetTestTemplate<RoleDto>(
        preExecution = {
            RoleData.randomOrException().toDto()
                //Sergeyev [2021.08.09]: removed after analytics changes
                .apply { privilegeGroups = emptyList() }
        },
        steps = RoleSteps(user)
    )

@RoleTaskIdsCommon
@RoleFolderCrud
@ComponentDictionary
@HighPriority
class RoleGetPageTest(user: User = Users.securityAdmin) :
    GetPageTestTemplate<RoleDto>(
        steps = RoleSteps(user)
    )

@RoleTaskIdsCommon
@RoleFolderCrud
@ComponentDictionary
@HighPriority
class RoleDeleteTest(user: User = Users.securityAdmin) :
    DeleteTestTemplate<RoleDto>(
        preExecution = {
            val createdResponse = RoleSteps(user).create(prepareRoleDtoForCreate())
            createdResponse.data!!
        },
        steps = RoleSteps(user)
    )

@RoleTaskIdsCommon
@RoleFolderCrud
@ComponentDictionary
@HighPriority
class RoleUpdateTest(user: User = Users.securityAdmin) :
    UpdateTestTemplate<RoleDto, RoleDto>(
        preExecution = {
            val createdDto = RoleSteps(user).create(prepareRoleDtoForCreate()).data!!
            prepareRoleDtoForUpdate(createdDto)
        },
        preCheckingHandling = { it.apply { version = 1 } },
        steps = RoleSteps(user)
    )

@RoleTaskIdsCommon
@RoleFolderSorting
@ComponentDictionary
@LowPriority
class RoleSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<RoleDto, RoleSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = RoleSteps(user),
    clazz = RoleSortingParams::class.java
)

@RoleTaskIdsCommon
@RoleFolderFiltration
@ComponentDictionary
@NormalPriority
class RoleFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> RoleDto)?,
    filterRequestFunction: (RoleDto?) -> FilterData
) : FiltrationTestTemplate<RoleDto, RoleFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = RoleSteps(user),
    clazz = RoleFilterParams::class.java,
    preExecution = preExecution
)
//endregion


//region Other tests
@RoleTaskIdsCommon
@RoleFolderOther
@ComponentDictionary
@HighPriority
class AddPrivilegeGroupToRolesTest(
    user: User = Users.securityAdmin,
    var steps: RoleSteps = RoleSteps(user),
    roles: List<RoleDto>
) : AbstractBeTest<PrivilegeGroupDto, PrivilegeGroupDto>(
    name = "'${steps.entityName}'. Связать Группу привилегий с Ролями [${steps.user.userType}]",
    preExecution = { PrivilegeGroupPrepareSteps.createPrivilegeGroupDto() },
    postExecution = { pgDto -> PrivilegeGroupData.removeRecord!!(pgDto.toModel()) },
    testPostExecution = { pgDto -> steps.removePrivilegeGroupFromRoles(pgDto.id!!, roles.map { it.id!! }) },
    testBody = { pgDto ->
        val groupId = pgDto!!.id!!
        val rolesIds = roles.map { it.id!! }.sorted()
        val additionResponseDto = steps.addPrivilegeGroupToRoles(
            prGroupId = groupId,
            roleIdsList = rolesIds
        )

        assertThat("Id возвращённой Группы привилегий на совпадает с ожидаемым", additionResponseDto.entity.id, equalTo(groupId))

        val groupTree = steps.getContainingRolesForPrivilegeGroup(groupId)
        val roleGroupsIds = groupTree.page
            .getOrException("No roles returned for group [$groupId]")
            .map { it.id!! }
            .distinct()
            .sorted()

        assertThat(
            "Группа привилений [$groupId] не была добавлена списку Ролей '$rolesIds'",
            roleGroupsIds,
            containsInRelativeOrder(*rolesIds.toTypedArray())
        )
        pgDto
    }
)

@RoleTaskIdsCommon
@RoleFolderOther
@ComponentDictionary
@HighPriority
class AddPrivilegeGroupsToRoleTest(
    user: User = Users.securityAdmin,
    var steps: RoleSteps = RoleSteps(user),
    groups: List<PrivilegeGroupDto>
) : AbstractBeTest<RoleDto, Unit>(
    name = "'${steps.entityName}'. Связать список Групп привилегий с Ролью [${steps.user.userType}]",
    preExecution = { RolePrepareSteps.createRoleDto() },
    postExecution = { RoleData.removeRecord!!(it.toModel()) },
    testBody = { roleDto ->
        val roleId = roleDto!!.id!!
        val groupsIds = groups.map { it.id!! }.sorted()
        val additionResponseDto = steps.addPrivilegeGroupsToRole(
            roleId = roleId,
            groupIdsList = groupsIds
        )

        assertThat("Id возвращённой Роли на совпадает с ожидаемым", additionResponseDto.entity.id, equalTo(roleId))

        val groupTree = steps.getGroupTreeForRole(roleId, showIncluded = true, showNonIncluded = false)
        val roleGroupsIds = groupTree.list
            .getOrException("No groups returned for role [$roleId]")
            .map { it.id }
            .distinct()
            .sorted()

        assertThat(
            "Роли [$roleId] не был добавлен список групп '$groupsIds'",
            roleGroupsIds,
            containsInRelativeOrder(*groupsIds.toTypedArray())
        )
    }
)

@RoleTaskIdsCommon
@RoleFolderOther
@ComponentDictionary
@HighPriority
class CreateRoleCopyTest(
    user: User = Users.securityAdmin,
    var steps: RoleSteps = RoleSteps(user),
    copyGroups: Boolean,
    copyUsers: Boolean
) : AbstractBeTest<RoleDto, RoleDto>(
    name = "'${steps.entityName}'. Создать копию Роли (" +
            "${if (copyGroups) "с Группами" else "без Групп"} привилегий, " +
            "${if (copyUsers) "с Пользователями" else "без Пользователей"}) [${steps.user.userType}]",
    preExecution = {
        val prGroup = PrivilegeGroupPrepareSteps.createPrivilegeGroupDto()
        val role = RolePrepareSteps.createRoleDto()
        val roleWithGroup = steps.addPrivilegeGroupsToRole(role.id!!, listOf(prGroup.id!!))
        roleWithGroup.entity
    },
    postExecution = { roleWithGroup ->
        roleWithGroup.privilegeGroups?.forEach { PrivilegeGroupData.removeRecord!!(it.toModel()) }
        RoleData.removeRecord!!(roleWithGroup.toModel())
    },
    testPostExecution = { roleCopy -> RoleData.removeRecord!!(roleCopy.toModel()) },
    testBody = { roleWithGroup ->
        val roleId = roleWithGroup!!.id!!
        val copyName = "AT copy ${roleWithGroup.name}"
        val roleCopy = steps.createRoleCopy(
            roleId = roleId,
            name = copyName,
            copyGroups = copyGroups,
            copyUsers = copyUsers
        )
            .data.getOrException("Failed copying role [$roleId]")

        "Проверка копирования основных полей Роли" {
            assertThat("Поле 'name' копии Роли не совпадает с ожидаемым", roleCopy.name, equalTo(copyName))
            assertThat("Поле 'uiName' копии Роли не совпадает с ожидаемым", roleCopy.uiName, equalTo("Copy_${roleWithGroup.uiName}"))
            assertThat("Поле 'resourceId' копии Роли не совпадает с ожидаемым", roleCopy.resourceId, equalTo(roleWithGroup.resourceId))
            assertThat("Поле 'description' копии Роли не совпадает с ожидаемым", roleCopy.description, equalTo(roleWithGroup.description))
        }

        "Проверка копирования Групп Привилегий" {
            val copyGroupTree = steps.getGroupTreeForRole(roleCopy.id!!, showIncluded = true, showNonIncluded = false)
                .list.getOrException("Can't get PrivilegeGroup for Role copy [${roleCopy.id}]")
            if (copyGroups) {
                val expGroupTree = steps.getGroupTreeForRole(roleId, showIncluded = true, showNonIncluded = false)
                    .list.getOrException("Can't get PrivilegeGroup for Role [$roleId]")

                assertThat("Список Групп Привилегий копии Роли не совпадает с ожидаемым", expGroupTree, equalTo(copyGroupTree))
            } else {
                assertThat("Список Групп Привилегий не пуст", copyGroupTree, empty())
            }
        }

        "НЕ РЕАЛИЗОВАНО! Проверка копирования Пользователей" {
            // TODO Sergeyev [2021.08.13]: this
        }
        roleCopy
    }
)

@RoleTaskIdsCommon
@RoleFolderOther
@ComponentDictionary
@HighPriority
class GetAvailableResourcesTest(
    user: User = Users.securityAdmin,
    var steps: RoleSteps = RoleSteps(user)
) : AbstractBeTest<Unit, Unit>(
    name = "'${steps.entityName}'. Получить доступные Ресурсы [${steps.user.userType}]",
    testBody = {
        val availableResources = steps.getAvailableResources()
            .list.getOrException("Can't get available resources")

        assertThat("Список доступных Ресурсов пуст", availableResources, not(empty()))
        // TODO Sergeyev [2021.08.13]: is there some restrictions to accessible Resources?
        val expResources = ResourceData.get().map { it.toDto().apply { scopes = null } }
        assertThat("Список доступных Ресурсов не совпадает с ожидаемым", availableResources, equalTo(expResources))
    }
)

@RoleTaskIdsCommon
@RoleFolderOther
@ComponentDictionary
@HighPriority
class GetContainingRolesForPrivilegeGroupTest(
    user: User = Users.securityAdmin,
    var steps: RoleSteps = RoleSteps(user)
) : AbstractBeTest<PrivilegeGroupDto, Unit>(
    name = "'${steps.entityName}'. Получить список Ролей, использующих указанную Группу привилегий [${steps.user.userType}]",
    preExecution = { PrivilegeGroupData.randomOrException(seekAtCreated = false).toDto() },
    testBody = { prGroup ->
        val prGroupId = prGroup!!.id!!
        val roleList = steps.getContainingRolesForPrivilegeGroup(prGroupId = prGroupId)
            .page.getOrException()
            .map { it.id!! }

        assertThat("Список Ролей пуст", roleList, not(empty()))

        val roles = PrivilegeGroupData.getRolesUsingPrGroup(prGroupId).map { it.id!! }
        assertThat(
            "Список Ролей, так или иначе включающих Группу привилегий [$prGroupId] не совпадает с ожидаемым",
            roleList, equalTo(roles)
        )
    }
)

@RoleTaskIdsCommon
@RoleFolderOther
@ComponentDictionary
@HighPriority
class GetGroupTreeForRoleTest(
    user: User = Users.securityAdmin,
    var steps: RoleSteps = RoleSteps(user),
    showIncluded: Boolean,
    showNonIncluded: Boolean
) : AbstractBeTest<RoleDto, Unit>(
    name = "'${steps.entityName}'. Получить дерево Групп Привилегий для указанной Роли [${steps.user.userType}]",
    preExecution = { RoleData.randomOrException().toDto() },
    testBody = { roleDto ->
        val roleId = roleDto!!.id!!
        val prGroupTree = steps.getGroupTreeForRole(
            roleId = roleId,
            showIncluded = showIncluded,
            showNonIncluded = showNonIncluded
        )
            .list.getOrException("Failed to get PrivilegeGroup tree For Role [$roleId]")

        assertThat("Дерево групп привилегий пусто", prGroupTree, not(empty()))

        // TODO Sergeyev [2021.08.13]: build prGroupTree through PrivilegeGroupData
    }
)

@RoleTaskIdsCommon
@RoleFolderOther
@ComponentDictionary
@HighPriority
class GetPrivilegeTreeForRoleTest(
    user: User = Users.securityAdmin,
    var steps: RoleSteps = RoleSteps(user),
    showIncluded: Boolean,
    showNonIncluded: Boolean
) : AbstractBeTest<RoleDto, Unit>(
    name = "'${steps.entityName}'. Получить дерево Привилегий для указанной Роли [${steps.user.userType}]",
    preExecution = { RoleData.randomOrException().toDto() },
    testBody = { roleDto ->
        val roleId = roleDto!!.id!!
        val privilegeTree = steps.getPrivilegeTreeForRole(
            roleId = roleId,
            showIncluded = showIncluded,
            showNonIncluded = showNonIncluded
        )
            .list.getOrException("Failed to get Privileges tree For Role [$roleId]")

        assertThat("Дерево привилегий пусто", privilegeTree, not(empty()))

        // TODO Sergeyev [2021.08.13]: build privilegeTree through PrivilegeGroupData/PrivilegeData
    }
)

@RoleTaskIdsCommon
@RoleFolderOther
@ComponentDictionary
@HighPriority
class GetRoleTreeTest(
    user: User = Users.securityAdmin,
    var steps: RoleSteps = RoleSteps(user)
) : AbstractBeTest<Unit, Unit>(
    name = "'${steps.entityName}'. Получить дерево Ролей [${steps.user.userType}]",
    testBody = {
        val roleTree = steps.getRoleTree()
        val resourcesList = roleTree.resources

        // TODO Sergeyev [2021.08.13]: build Role/Resource Tree through RoleData & ResourceData?
        val existingResources = ResourceData.get().map { it.toDto() }

        resourcesList.forEach { listEntry ->
            val entryResource = listEntry.resource
            val entryRoles = listEntry.roles


        }
        throw RuntimeException("Test not implemented!")
    }
)

@RoleTaskIdsCommon
@RoleFolderOther
@ComponentDictionary
@HighPriority
class RemovePrivilegeGroupFromRolesTest(
    user: User = Users.securityAdmin,
    var steps: RoleSteps = RoleSteps(user),
    roles: List<RoleDto>
) : AbstractBeTest<PrivilegeGroupDto, Unit>(
    name = "'${steps.entityName}'. Удалить указанную Группу привилегий из списка Ролей [${steps.user.userType}]",
    preExecution = {
        val prGroup = PrivilegeGroupPrepareSteps.createPrivilegeGroupDto()
        steps.addPrivilegeGroupToRoles(prGroupId = prGroup.id!!, roleIdsList = roles.map { it.id!! })
        prGroup
    },
    postExecution = { PrivilegeGroupData.removeRecord!!(it.toModel()) },
    testBody = { prGroup ->
        val prGroupId = prGroup!!.id!!
        val rolesIds = roles.map { it.id!! }
        val removalResponseDto = steps.removePrivilegeGroupFromRoles(
            prGroupId = prGroupId,
            roleIdsList = rolesIds
        )

        assertThat("Id возвращённой Группы привилегий на совпадает с ожидаемым", removalResponseDto.entity.id, equalTo(prGroupId))

        val rolesTree = steps.getContainingRolesForPrivilegeGroup(prGroupId)
        val roleTreeIds = rolesTree.page
            .getOrException("Failed to get Roles tree for PrivilegeGroup [$prGroupId]")
            .map { it.id!! }
            .distinct()

        assertThat(
            "Группа привилений [$prGroupId] не была удалена из списка Ролей '$rolesIds'",
            roleTreeIds,
            equalTo(roleTreeIds.minus(rolesIds))
        )
    }
)

@RoleTaskIdsCommon
@RoleFolderOther
@ComponentDictionary
@HighPriority
class RemovePrivilegeGroupsFromRoleTest(
    user: User = Users.securityAdmin,
    var steps: RoleSteps = RoleSteps(user),
    groups: List<PrivilegeGroupDto>
) : AbstractBeTest<RoleDto, Unit>(
    name = "'${steps.entityName}'. Удалить список Групп привилегий из указанной Роли [${steps.user.userType}]",
    preExecution = { RolePrepareSteps.createRoleDto() },
    postExecution = { RoleData.removeRecord!!(it.toModel()) },
    testBody = { roleDto ->
        val roleId = roleDto!!.id!!
        val groupsIds = groups.map { it.id!! }
        val removalResponseDto = steps.removePrivilegeGroupsFromRole(
            roleId = roleId,
            groupIdsList = groupsIds
        )

        assertThat("Id возвращённой Роли на совпадает с ожидаемым", removalResponseDto.entity.id, equalTo(roleId))

        val groupTree = steps.getGroupTreeForRole(roleId, showIncluded = true, showNonIncluded = false)
        val groupTreeIds = groupTree.list
            .getOrException("Failed to get PrivilegeGroup tree for Role [$roleId]")
            .map { it.id }
            .distinct()

        assertThat(
            "У Роли [$roleId] не был удалён список Групп Привилегий '$groupsIds'",
            groupTreeIds,
            equalTo(groupTreeIds.minus(groupsIds))
        )
    }
)
//endregion