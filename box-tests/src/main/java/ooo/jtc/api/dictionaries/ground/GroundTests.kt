package ooo.jtc.api.dictionaries.ground

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.ground.GroundPrepareSteps.getDtoForUpdate
import ooo.jtc.api.dictionaries.ground.GroundPrepareSteps.getGroundDtoForCreate
import ooo.jtc.core.tm4j.*
import ooo.jtc.dictionaries.ground.GroundDto
import ooo.jtc.dictionaries.ground.GroundUpdateRequest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.dictionaries.ground.GroundFilterParams
import ooo.jtc.testdata.dictionaries.ground.GroundSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.GROUND}\" (ground)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class GroundFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class GroundFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class GroundFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class GroundFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class GroundFolderOther

@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY,Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1144"]) annotation class GroundTaskIdsCommon
//@formatter:on

@GroundTaskIdsCommon
@GroundFolderCrud
@ComponentDictionary
@HighPriority
class GroundCreateTest(user: User) :
    CreateTestTemplate<GroundDto>(
        preExecution = { getGroundDtoForCreate(user) },
        steps = GroundSteps(user)
    )

@GroundTaskIdsCommon
@GroundFolderCrud
@ComponentDictionary
@HighPriority
class GroundGetTest(user: User, preExecution: (() -> GroundDto)?) :
    GetTestTemplate<GroundDto>(
        preExecution = preExecution,
        steps = GroundSteps(user)
    )

@GroundTaskIdsCommon
@GroundFolderCrud
@ComponentDictionary
@HighPriority
class GroundGetPageTest(user: User) :
    GetPageTestTemplate<GroundDto>(
        steps = GroundSteps(user)
    )

@GroundTaskIdsCommon
@GroundFolderCrud
@ComponentDictionary
@HighPriority
class GroundDeleteTest(user: User) :
    DeleteTestTemplate<GroundDto>(
        preExecution = { GroundPrepareSteps.createGroundDto(user) },
        steps = GroundSteps(user)
    )

@GroundTaskIdsCommon
@GroundFolderCrud
@ComponentDictionary
@HighPriority
class GroundUpdateTest(user: User) :
    UpdateTestTemplate<GroundDto, GroundUpdateRequest>(
        preExecution = {
            val createdDto = GroundPrepareSteps.createGroundDto(user)
            getDtoForUpdate(createdDto)
        },
        steps = GroundSteps(user)
    )

@GroundTaskIdsCommon
@GroundFolderSorting
@ComponentDictionary
@LowPriority
class GroundSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<GroundDto, GroundSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = GroundSteps(user),
    clazz = GroundSortingParams::class.java
)

@GroundTaskIdsCommon
@GroundFolderFiltration
@ComponentDictionary
@NormalPriority
class GroundFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> GroundDto)?,
    filterRequestFunction: (GroundDto?) -> FilterData
) : FiltrationTestTemplate<GroundDto, GroundFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = GroundSteps(user),
    clazz = GroundFilterParams::class.java,
    preExecution = preExecution
)