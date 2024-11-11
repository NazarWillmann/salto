package ooo.jtc.api.uaa.tests

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.uaa.prepare.PrepareUaaUserData.getUaaUserDtoForUpdate
import ooo.jtc.api.uaa.prepare.PrepareUaaUserData.prepareUaaUserDtoForCreate
import ooo.jtc.api.uaa.steps.UaaUserSteps
import ooo.jtc.core.tm4j.*
import ooo.jtc.generic.UaaNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.uaa.user.UaaUserData
import ooo.jtc.testdata.uaa.user.UaaUserFilterParams
import ooo.jtc.testdata.uaa.user.UaaUserSortingParams
import ooo.jtc.uaa.user.dto.UaaUserDto

//@formatter:off
private const val baseFolder ="${FolderPrefix.UAA} \"${UaaNames.USER}\" (uaaUser)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class UaaUserFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class UaaUserFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class UaaUserFolderFiltration

private const val STORY_UAA = "JTCSALTO-476"
@TaskIds([Tm4jEpic.EPIC_UAA, STORY_UAA,Tm4jStoryAT.AT_STORY_UAA,"JTCSALTO-783"]) annotation class UaaUserTaskIdsCommon
//@formatter:on

@UaaUserTaskIdsCommon
@UaaUserFolderCrud
@ComponentUaa
@HighPriority
class UaaUserCreateTest :
    CreateTestTemplate<UaaUserDto>(
        preExecution = { prepareUaaUserDtoForCreate() },
        steps = UaaUserSteps()
    )

@UaaUserTaskIdsCommon
@UaaUserFolderCrud
@ComponentUaa
@HighPriority
class UaaUserGetTest :
    GetTestTemplate<UaaUserDto>(
        preExecution = { UaaUserData.get { !it.tempBlock && !it.permBlock }.random().toDto() },
        steps = UaaUserSteps()
    )

@UaaUserTaskIdsCommon
@UaaUserFolderCrud
@ComponentUaa
@HighPriority
class UaaUserGetPageTest :
    GetPageTestTemplate<UaaUserDto>(
        steps = UaaUserSteps()
    )

@UaaUserTaskIdsCommon
@UaaUserFolderCrud
@ComponentUaa
@HighPriority
class UaaUserDeleteTest :
    DeleteTestTemplate<UaaUserDto>(
        preExecution = {
            val createdResponse = UaaUserSteps().create(prepareUaaUserDtoForCreate())
            createdResponse.data!!
        },
        steps = UaaUserSteps(),
        preCheckingHandling = {
            it.scopes = emptyList()
            it
        }
    )

@UaaUserTaskIdsCommon
@UaaUserFolderCrud
@ComponentUaa
@HighPriority
class UaaUserUpdateTest :
    UpdateTestTemplate<UaaUserDto, UaaUserDto>(
        preExecution = {
            val dtoForCreate = prepareUaaUserDtoForCreate()
            val createdDto = UaaUserSteps().create(dtoForCreate).data!!
            getUaaUserDtoForUpdate(createdDto)
        },
        steps = UaaUserSteps()
    )

@UaaUserTaskIdsCommon
@UaaUserFolderSorting
@ComponentUaa
@LowPriority
class UaaUserSortingTest(sortRequestFunction: () -> List<Sort>) : SortingTestTemplate<UaaUserDto, UaaUserSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = UaaUserSteps(),
    clazz = UaaUserSortingParams::class.java
)

@UaaUserTaskIdsCommon
@UaaUserFolderFiltration
@ComponentUaa
@NormalPriority
class UaaUserFilterTests(
    name: String,
    preExecution: (() -> UaaUserDto)?,
    filterRequestFunction: (UaaUserDto?) -> FilterData
) : FiltrationTestTemplate<UaaUserDto, UaaUserFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = UaaUserSteps(),
    clazz = UaaUserFilterParams::class.java,
    preExecution = preExecution
)