package ooo.jtc.api.rolemodel.privilegegroup

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.rolemodel.privilegegroup.PrivilegeGroupPrepareSteps.preparePrivilegeGroupDtoForCreate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jStoryAT
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.rolemodel.privilegegroup.PrivilegeGroupData
import ooo.jtc.testdata.rolemodel.privilegegroup.PrivilegeGroupFilterParams
import ooo.jtc.testdata.rolemodel.privilegegroup.PrivilegeGroupSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${RoleModelNames.PRIVILEGE_GROUP}\" (privilege group)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class PrivilegeGroupFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class PrivilegeGroupFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class PrivilegeGroupFolderFiltration

//AT_STORY_ROLEMODEL = "JTCSALTO-3484"                      //Проект развития JTC СДМ УБРиР > Механизмы > Права доступа (роли/привилегии и раздача прав)
private const val AT_STORY_ROLEMODEL_AN = "JTCSALTO-3914"   // > Аналитика (уточнение требований)
private const val AT_STORY_ROLEMODEL_AT = "JTCSALTO-3917"   // > Тестирование (автотесты)
private const val AT_STORY_ROLEMODEL_DEV = "JTCSALTO-3482"  // > Разработка бэк (по уточнённым требованиям)

@TaskIds([Tm4jStoryAT.AT_STORY_ROLEMODEL, AT_STORY_ROLEMODEL_AN, AT_STORY_ROLEMODEL_AT, AT_STORY_ROLEMODEL_DEV])
annotation class PrivilegeGroupTaskIdsCommon
//@formatter:on


@PrivilegeGroupTaskIdsCommon
@PrivilegeGroupFolderCrud
@ComponentDictionary
@HighPriority
class PrivilegeGroupCreateTest(user: User = Users.securityAdmin) :
    CreateTestTemplate<PrivilegeGroupDto>(
        preExecution = { preparePrivilegeGroupDtoForCreate() },
        steps = PrivilegeGroupSteps(user)
    )

@PrivilegeGroupTaskIdsCommon
@PrivilegeGroupFolderCrud
@ComponentDictionary
@HighPriority
class PrivilegeGroupGetTest(user: User = Users.securityAdmin) :
    GetTestTemplate<PrivilegeGroupDto>(
        preExecution = { PrivilegeGroupData.randomOrException().toDto() },
        steps = PrivilegeGroupSteps(user)
    )

@PrivilegeGroupTaskIdsCommon
@PrivilegeGroupFolderCrud
@ComponentDictionary
@HighPriority
class PrivilegeGroupGetPageTest(user: User = Users.securityAdmin) :
    GetPageTestTemplate<PrivilegeGroupDto>(
        steps = PrivilegeGroupSteps(user)
    )

@PrivilegeGroupTaskIdsCommon
@PrivilegeGroupFolderCrud
@ComponentDictionary
@HighPriority
class PrivilegeGroupDeleteTest(user: User = Users.securityAdmin) :
    DeleteTestTemplate<PrivilegeGroupDto>(
        preExecution = {
            val createdResponse = PrivilegeGroupSteps(user).create(preparePrivilegeGroupDtoForCreate())
            createdResponse.data!!
        },
        steps = PrivilegeGroupSteps(user)
    )

@PrivilegeGroupTaskIdsCommon
@PrivilegeGroupFolderCrud
@ComponentDictionary
@HighPriority
class PrivilegeGroupUpdateTest(user: User = Users.securityAdmin) :
    UpdateTestTemplate<PrivilegeGroupDto, PrivilegeGroupDto>(
        preExecution = {
            val createdDto = PrivilegeGroupSteps(user).create(preparePrivilegeGroupDtoForCreate()).data!!
            PrivilegeGroupPrepareSteps.preparePrivilegeGroupDtoForUpdate(createdDto)
        },
        steps = PrivilegeGroupSteps(user)
    )

@PrivilegeGroupTaskIdsCommon
@PrivilegeGroupFolderSorting
@ComponentDictionary
@LowPriority
class PrivilegeGroupSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<PrivilegeGroupDto, PrivilegeGroupSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = PrivilegeGroupSteps(user),
    clazz = PrivilegeGroupSortingParams::class.java
)

@PrivilegeGroupTaskIdsCommon
@PrivilegeGroupFolderFiltration
@ComponentDictionary
@NormalPriority
class PrivilegeGroupFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> PrivilegeGroupDto)?,
    filterRequestFunction: (PrivilegeGroupDto?) -> FilterData
) : FiltrationTestTemplate<PrivilegeGroupDto, PrivilegeGroupFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = PrivilegeGroupSteps(user),
    clazz = PrivilegeGroupFilterParams::class.java,
    preExecution = preExecution
)
