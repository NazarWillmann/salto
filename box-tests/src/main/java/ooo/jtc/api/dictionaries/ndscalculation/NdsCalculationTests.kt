package ooo.jtc.api.dictionaries.ndscalculation

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.ndscalculation.NdsCalculationPrepareSteps.getNdsCalculationDtoForCreate
import ooo.jtc.api.dictionaries.ndscalculation.NdsCalculationPrepareSteps.getNdsCalculationDtoForUpdate
import ooo.jtc.api.dictionaries.ndscalculation.NdsCalculationPrepareSteps.ndsCalcAvailableCodes
import ooo.jtc.core.tm4j.*
import ooo.jtc.dictionaries.ndscalculation.NdsCalculationDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.ndscalculation.NdsCalculationData
import ooo.jtc.testdata.dictionaries.ndscalculation.NdsCalculationFilterParams
import ooo.jtc.testdata.dictionaries.ndscalculation.NdsCalculationSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.NDS_CALCULATION}\" (ndsCalculation)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class NdsCalculationFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class NdsCalculationFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class NdsCalculationFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class NdsCalculationFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class NdsCalculationFolderOther

const val STORY_NDS_CALCULATION = "JTCSALTO-501"

@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY,STORY_NDS_CALCULATION,Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1147"]) annotation class NdsCalculationTaskIdsCommon
//@formatter:on

@NdsCalculationTaskIdsCommon
@NdsCalculationFolderCrud
@ComponentDictionary
@HighPriority
class NdsCalculationCreateTest(
    user: User = bankAdmin,
    steps: NdsCalculationSteps = NdsCalculationSteps(user)
) :
    CreateTestTemplate<NdsCalculationDto>(
        preExecution = { getNdsCalculationDtoForCreate() },
        steps = steps,
        testPostExecution = {
            ndsCalcAvailableCodes.add(it.code)
            steps.delete(it.id!!)
        }
    )

@NdsCalculationTaskIdsCommon
@NdsCalculationFolderCrud
@ComponentDictionary
@HighPriority
class NdsCalculationGetTest(user: User) :
    GetTestTemplate<NdsCalculationDto>(
        preExecution = { NdsCalculationData.randomOrException().toDto() },
        steps = NdsCalculationSteps(user)
    )

@NdsCalculationTaskIdsCommon
@NdsCalculationFolderCrud
@ComponentDictionary
@HighPriority
class NdsCalculationGetPageTest(user: User) :
    GetPageTestTemplate<NdsCalculationDto>(
        steps = NdsCalculationSteps(user)
    )

@NdsCalculationTaskIdsCommon
@NdsCalculationFolderCrud
@ComponentDictionary
@HighPriority
class NdsCalculationDeleteTest(
    user: User = bankAdmin,
    steps: NdsCalculationSteps = NdsCalculationSteps(user)
) :
    DeleteTestTemplate<NdsCalculationDto>(
        preExecution = {
            val createResponse = NdsCalculationSteps(user).create(getNdsCalculationDtoForCreate())
            createResponse.data!!
        },
        steps = steps,
        postExecution = { ndsCalcAvailableCodes.add(it.code) }
    )

@NdsCalculationTaskIdsCommon
@NdsCalculationFolderCrud
@ComponentDictionary
@HighPriority
class NdsCalculationUpdateTest(
    user: User = bankAdmin,
    steps: NdsCalculationSteps = NdsCalculationSteps(user)
) :
    UpdateTestTemplate<NdsCalculationDto, NdsCalculationDto>(
        preExecution = {
            val createdDto = NdsCalculationSteps(user).create(getNdsCalculationDtoForCreate()).data!!
            getNdsCalculationDtoForUpdate(createdDto)
        },
        steps = steps,
        postExecution = {
            ndsCalcAvailableCodes.add(it.code)
            steps.delete(it.id!!)
        }
    )

@NdsCalculationTaskIdsCommon
@NdsCalculationFolderSorting
@ComponentDictionary
@LowPriority
class NdsCalculationSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<NdsCalculationDto, NdsCalculationSortingParams, Any>(
    steps = NdsCalculationSteps(user),
    sortList = sortRequestFunction.invoke(),
    clazz = NdsCalculationSortingParams::class.java
)

@NdsCalculationTaskIdsCommon
@NdsCalculationFolderFiltration
@ComponentDictionary
@NormalPriority
class NdsCalculationFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> NdsCalculationDto)?,
    filterRequestFunction: (NdsCalculationDto?) -> FilterData
) : FiltrationTestTemplate<NdsCalculationDto, NdsCalculationFilterParams, Any>(
    name = name,
    steps = NdsCalculationSteps(user),
    preExecution = preExecution,
    filterRequestFunction = filterRequestFunction,
    clazz = NdsCalculationFilterParams::class.java
)

@NdsCalculationTaskIdsCommon
@NdsCalculationFolderOther
@ComponentDictionary
@HighPriority
class NdsCalculationValidSymbolsTest(
    user: User = bankAdmin,
    steps: NdsCalculationSteps = NdsCalculationSteps(user)
) :
    CreateTestTemplate<NdsCalculationDto>(
        preExecution = { getNdsCalculationDtoForCreate(forUi = false) },
        steps = steps,
        testPostExecution = {
            ndsCalcAvailableCodes.add(it.code)
            steps.delete(it.id!!)
        }
    ) {
    override fun name(): String = "'${DictionaryNames.NDS_CALCULATION}'. Проверка валидности допустимых символов в полях."
}