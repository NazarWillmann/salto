package ooo.jtc.api.dictionaries.ndspercent

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.ndspercent.NdsPercentPrepareSteps.getNdsPercentDtoForCreate
import ooo.jtc.api.dictionaries.ndspercent.NdsPercentPrepareSteps.getNdsPercentDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.dictionaries.ndspercent.NdsPercentDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.ndspercent.NdsPercentData
import ooo.jtc.testdata.dictionaries.ndspercent.NdsPercentFilterParams
import ooo.jtc.testdata.dictionaries.ndspercent.NdsPercentSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.NDS_PERCENT}\" (ndsPercent)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class NdsPercentFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class NdsPercentFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class NdsPercentFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class NdsPercentFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class NdsPercentFolderOther
const val STORY_NDS_PERCENT = "JTCSALTO-498"
@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY,STORY_NDS_PERCENT,Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1148"]) annotation class NdsPercentTaskIdsCommon
//@formatter:on

@NdsPercentTaskIdsCommon
@NdsPercentFolderCrud
@ComponentDictionary
@HighPriority
class NdsPercentCreateTest(user: User = bankAdmin) :
    CreateTestTemplate<NdsPercentDto>(
        preExecution = { getNdsPercentDtoForCreate() },
        steps = NdsPercentSteps(user)
    )

@NdsPercentTaskIdsCommon
@NdsPercentFolderCrud
@ComponentDictionary
@HighPriority
class NdsPercentGetTest(user: User) :
    GetTestTemplate<NdsPercentDto>(
        preExecution = { NdsPercentData.randomOrException().toDto() },
        steps = NdsPercentSteps(user)
    )

@NdsPercentTaskIdsCommon
@NdsPercentFolderCrud
@ComponentDictionary
@HighPriority
class NdsPercentGetPageTest(user: User) :
    GetPageTestTemplate<NdsPercentDto>(
        steps = NdsPercentSteps(user)
    )

@NdsPercentTaskIdsCommon
@NdsPercentFolderCrud
@ComponentDictionary
@HighPriority
class NdsPercentDeleteTest(user: User = bankAdmin) :
    DeleteTestTemplate<NdsPercentDto>(
        preExecution = {
            val createdResponse = NdsPercentSteps(user).create(getNdsPercentDtoForCreate())
            createdResponse.data!!
        },
        steps = NdsPercentSteps(user)
    )

@NdsPercentTaskIdsCommon
@NdsPercentFolderCrud
@ComponentDictionary
@HighPriority
class NdsPercentUpdateTest(user: User = bankAdmin) :
    UpdateTestTemplate<NdsPercentDto, NdsPercentDto>(
        preExecution = {
            val createdDto = NdsPercentSteps(user).create(getNdsPercentDtoForCreate()).data!!
            getNdsPercentDtoForUpdate(createdDto)
        },
        steps = NdsPercentSteps(user)
    )


@NdsPercentTaskIdsCommon
@NdsPercentFolderSorting
@ComponentDictionary
@LowPriority
class NdsPercentSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<NdsPercentDto, NdsPercentSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = NdsPercentSteps(user),
    clazz = NdsPercentSortingParams::class.java
)

@NdsPercentTaskIdsCommon
@NdsPercentFolderFiltration
@ComponentDictionary
@NormalPriority
class NdsPercentFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> NdsPercentDto)?,
    filterRequestFunction: (NdsPercentDto?) -> FilterData
) : FiltrationTestTemplate<NdsPercentDto, NdsPercentFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = NdsPercentSteps(user),
    clazz = NdsPercentFilterParams::class.java,
    preExecution = preExecution
)