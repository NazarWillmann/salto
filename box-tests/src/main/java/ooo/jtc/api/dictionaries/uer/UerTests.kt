package ooo.jtc.api.dictionaries.uer

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.dictionaries.uer.UerPrepareSteps.availableUerCodes
import ooo.jtc.api.dictionaries.uer.UerPrepareSteps.getUerDtoForCreate
import ooo.jtc.api.dictionaries.uer.UerPrepareSteps.getUerDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.core.tm4j.Tm4jEpic.EPIC_R_RKO_DICTIONARY
import ooo.jtc.dictionaries.uer.UerDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.uer.UerData
import ooo.jtc.testdata.dictionaries.uer.UerFilterParams
import ooo.jtc.testdata.dictionaries.uer.UerSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.UER}\" (uer)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class UerFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class UerFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class UerFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class UerFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class UerFolderOther

@TaskIds([EPIC_R_RKO_DICTIONARY,Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1154"]) annotation class UerTaskIdsCommon
//@formatter:on

@UerTaskIdsCommon
@UerFolderCrud
@ComponentDictionary
@HighPriority
class UerCreateTest(user: User = bankAdmin, steps: UerSteps = UerSteps(user)) :
    CreateTestTemplate<UerDto>(
        preExecution = { getUerDtoForCreate() },
        steps = steps,
        testPostExecution = {
            availableUerCodes.add(it.uer)
            steps.delete(it.id!!)
        }
    )

@UerTaskIdsCommon
@UerFolderCrud
@ComponentDictionary
@HighPriority
class UerGetTest(user: User) :
    GetTestTemplate<UerDto>(
        preExecution = { UerData.randomOrException().toDto() },
        steps = UerSteps(user)
    )

@UerTaskIdsCommon
@UerFolderCrud
@ComponentDictionary
@HighPriority
class UerGetPageTest(user: User) :
    GetPageTestTemplate<UerDto>(
        steps = UerSteps(user)
    )

@UerTaskIdsCommon
@UerFolderCrud
@ComponentDictionary
@HighPriority
class UerDeleteTest(user: User = bankAdmin, steps: UerSteps = UerSteps(user)) :
    DeleteTestTemplate<UerDto>(
        preExecution = {
            val createdResponse = steps.create(getUerDtoForCreate())
            createdResponse.data!!
        },
        steps = steps,
        postExecution = { availableUerCodes.add(it.uer) }
    )

@UerTaskIdsCommon
@UerFolderCrud
@ComponentDictionary
@HighPriority
class UerUpdateTest(user: User = bankAdmin, steps: UerSteps = UerSteps(user)) :
    UpdateTestTemplate<UerDto, UerDto>(
        preExecution = {
            val createdDto = steps.create(getUerDtoForCreate()).data!!
            getUerDtoForUpdate(createdDto)
        },
        steps = steps,
        postExecution = {
            availableUerCodes.add(it.uer)
            steps.delete(it.id!!)
        }
    )

@UerTaskIdsCommon
@UerFolderSorting
@ComponentDictionary
@LowPriority
class UerSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<UerDto, UerSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = UerSteps(user),
    clazz = UerSortingParams::class.java
)

@UerTaskIdsCommon
@UerFolderFiltration
@ComponentDictionary
@NormalPriority
class UerFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> UerDto)?,
    filterRequestFunction: (UerDto?) -> FilterData
) : FiltrationTestTemplate<UerDto, UerFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = UerSteps(user),
    clazz = UerFilterParams::class.java,
    preExecution = preExecution
)

@UerTaskIdsCommon
@UerFolderOther
@ComponentDictionary
@NormalPriority
class UerOtherTest(
    name: String,
    params: ((Unit?) -> Map<String, Any>)? = null,
    testBody: (Unit?) -> Unit
) : UnitBeTest(
    name = name,
    params = params,
    testBody = testBody
)