package ooo.jtc.api.dictionaries.region

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.region.RuRegionPrepareSteps.getRuRegionDtoForCreate
import ooo.jtc.api.dictionaries.region.RuRegionPrepareSteps.getRuRegionDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.core.tm4j.FolderPrefix.DICTIONARY
import ooo.jtc.core.tm4j.SubFolder.CONTROLS
import ooo.jtc.core.tm4j.SubFolder.CRUD
import ooo.jtc.core.tm4j.SubFolder.FILTRATION
import ooo.jtc.core.tm4j.SubFolder.OTHER
import ooo.jtc.core.tm4j.SubFolder.SORTING
import ooo.jtc.core.tm4j.Tm4jEpic.EPIC_R_RKO_DICTIONARY
import ooo.jtc.dictionaries.region.RuRegionDto
import ooo.jtc.generic.DictionaryNames.RU_REGION
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.region.RuRegionData
import ooo.jtc.testdata.dictionaries.region.RuRegionFilterParams
import ooo.jtc.testdata.dictionaries.region.RuRegionSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="$DICTIONARY \"$RU_REGION\" (region)"
@Folder("$baseFolder/$CRUD")       annotation class RuRegionFolderCrud
@Folder("$baseFolder/$SORTING")    annotation class RuRegionFolderSorting
@Folder("$baseFolder/$FILTRATION") annotation class RuRegionFolderFiltration
@Folder("$baseFolder/$CONTROLS")   annotation class RuRegionFolderControls
@Folder("$baseFolder/$OTHER")      annotation class RuRegionFolderOther

@TaskIds([EPIC_R_RKO_DICTIONARY, "JTCSALTO-397",Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1151"]) annotation class RuRegionTaskIdsCommon
//@formatter:on

@RuRegionTaskIdsCommon
@RuRegionFolderCrud
@ComponentDictionary
@HighPriority
class RuRegionCreateTest(user: User = bankAdmin) :
    CreateTestTemplate<RuRegionDto>(
        preExecution = { getRuRegionDtoForCreate() },
        steps = RuRegionSteps(user)
    )

@RuRegionTaskIdsCommon
@RuRegionFolderCrud
@ComponentDictionary
@HighPriority
class RuRegionGetTest(user: User) :
    GetTestTemplate<RuRegionDto>(
        preExecution = { RuRegionData.randomOrException().toDto() },
        steps = RuRegionSteps(user)
    )

@RuRegionTaskIdsCommon
@RuRegionFolderCrud
@ComponentDictionary
@HighPriority
class RuRegionGetPageTest(user: User) :
    GetPageTestTemplate<RuRegionDto>(
        steps = RuRegionSteps(user)
    )

@RuRegionTaskIdsCommon
@RuRegionFolderCrud
@ComponentDictionary
@HighPriority
class RuRegionDeleteTest(user: User = bankAdmin) :
    DeleteTestTemplate<RuRegionDto>(
        preExecution = {
            val createdResponse = RuRegionSteps(user).create(getRuRegionDtoForCreate())
            createdResponse.data!!
        },
        steps = RuRegionSteps(user)
    )

@RuRegionTaskIdsCommon
@RuRegionFolderCrud
@ComponentDictionary
@HighPriority
class RuRegionUpdateTest(user: User = bankAdmin) :
    UpdateTestTemplate<RuRegionDto, RuRegionDto>(
        preExecution = {
            val createdDto = RuRegionSteps(user).create(getRuRegionDtoForCreate()).data!!
            getRuRegionDtoForUpdate(createdDto)
        },
        steps = RuRegionSteps(user)
    )

@RuRegionTaskIdsCommon
@RuRegionFolderSorting
@ComponentDictionary
@LowPriority
class RuRegionSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<RuRegionDto, RuRegionSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = RuRegionSteps(user),
    clazz = RuRegionSortingParams::class.java
)

@RuRegionTaskIdsCommon
@RuRegionFolderFiltration
@ComponentDictionary
@NormalPriority
class RuRegionFiltrationTests(
    name: String,
    user: User,
    preExecution: (() -> RuRegionDto)?,
    filterRequestFunction: (RuRegionDto?) -> FilterData
) : FiltrationTestTemplate<RuRegionDto, RuRegionFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = RuRegionSteps(user),
    clazz = RuRegionFilterParams::class.java,
    preExecution = preExecution
)