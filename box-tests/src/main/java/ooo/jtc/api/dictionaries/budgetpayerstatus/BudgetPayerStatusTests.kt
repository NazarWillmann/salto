package ooo.jtc.api.dictionaries.budgetpayerstatus

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.NestedControlTestTemplate
import ooo.jtc.api.common.templates.entity.ServerErrorTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusPrepareSteps.availableCodes
import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusPrepareSteps.getBudgetPayerStatusDtoForCreate
import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusPrepareSteps.getBudgetPayerStatusDtoForUpdate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jEpic
import ooo.jtc.core.tm4j.Tm4jStoryAT
import ooo.jtc.dictionaries.budgetpayerstatus.BudgetPayerStatusDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.budgetpayerstatus.BudgetPayerStatusControls
import ooo.jtc.testdata.dictionaries.budgetpayerstatus.BudgetPayerStatusData
import ooo.jtc.testdata.dictionaries.budgetpayerstatus.BudgetPayerStatusFilterParams
import ooo.jtc.testdata.dictionaries.budgetpayerstatus.BudgetPayerStatusSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.BUDGET_PAYER_STATUS}\" (budgetPayerStatus)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class BudgetPayerStatusFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class BudgetPayerStatusFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class BudgetPayerStatusFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class BudgetPayerStatusFolderControls
@Folder("${baseFolder}/${SubFolder.DEFAULTS}") annotation class BudgetPayerStatusFolderDefaults

@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY,Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1120"]) annotation class BudgetPayerStatusTaskIdsCommon
//@formatter:on

@BudgetPayerStatusTaskIdsCommon
@BudgetPayerStatusFolderCrud
@ComponentDictionary
@HighPriority
class BudgetPayerStatusCreateTest(user: User = bankAdmin, steps: BudgetPayerStatusSteps = BudgetPayerStatusSteps(user)) :
    CreateTestTemplate<BudgetPayerStatusDto>(
        preExecution = { getBudgetPayerStatusDtoForCreate() },
        steps = steps,
        testPostExecution = { BudgetPayerStatusPrepareSteps.deleteWithCodeRetrieval(it) }
    )

@BudgetPayerStatusTaskIdsCommon
@BudgetPayerStatusFolderCrud
@ComponentDictionary
@HighPriority
class BudgetPayerStatusGetTest(user: User) :
    GetTestTemplate<BudgetPayerStatusDto>(
        preExecution = { BudgetPayerStatusData.randomOrException().toDto() },
        steps = BudgetPayerStatusSteps(user)
    )

@BudgetPayerStatusTaskIdsCommon
@BudgetPayerStatusFolderCrud
@ComponentDictionary
@HighPriority
class BudgetPayerStatusGetPageTest(user: User) :
    GetPageTestTemplate<BudgetPayerStatusDto>(
        steps = BudgetPayerStatusSteps(user)
    )

@BudgetPayerStatusTaskIdsCommon
@BudgetPayerStatusFolderCrud
@ComponentDictionary
@HighPriority
class BudgetPayerStatusDeleteTest(user: User = bankAdmin, steps: BudgetPayerStatusSteps = BudgetPayerStatusSteps(user)) :
    DeleteTestTemplate<BudgetPayerStatusDto>(
        preExecution = {
            val createResponse = BudgetPayerStatusSteps(user).create(getBudgetPayerStatusDtoForCreate())
            createResponse.data!!
        },
        steps = steps,
        postExecution = { availableCodes.add(it.code!!) }
    )

@BudgetPayerStatusTaskIdsCommon
@BudgetPayerStatusFolderCrud
@ComponentDictionary
@HighPriority
class BudgetPayerStatusUpdateTest(user: User = bankAdmin, steps: BudgetPayerStatusSteps = BudgetPayerStatusSteps(user)) :
    UpdateTestTemplate<BudgetPayerStatusDto, BudgetPayerStatusDto>(
        preExecution = {
            val createdDto = BudgetPayerStatusSteps(user).create(getBudgetPayerStatusDtoForCreate()).data!!
            getBudgetPayerStatusDtoForUpdate(createdDto)
        },
        steps = steps,
        postExecution = { BudgetPayerStatusPrepareSteps.deleteWithCodeRetrieval(it) }
    )

@BudgetPayerStatusTaskIdsCommon
@BudgetPayerStatusFolderSorting
@ComponentDictionary
@LowPriority
class BudgetPayerStatusSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<BudgetPayerStatusDto, BudgetPayerStatusSortingParams, Any>(
    steps = BudgetPayerStatusSteps(user),
    sortList = sortRequestFunction.invoke(),
    clazz = BudgetPayerStatusSortingParams::class.java
)

@BudgetPayerStatusTaskIdsCommon
@BudgetPayerStatusFolderFiltration
@ComponentDictionary
@NormalPriority
class BudgetPayerStatusFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> BudgetPayerStatusDto)?,
    filterRequestFunction: (BudgetPayerStatusDto?) -> FilterData
) : FiltrationTestTemplate<BudgetPayerStatusDto, BudgetPayerStatusFilterParams, Any>(
    name = name,
    steps = BudgetPayerStatusSteps(user),
    preExecution = preExecution,
    filterRequestFunction = filterRequestFunction,
    clazz = BudgetPayerStatusFilterParams::class.java
)

@BudgetPayerStatusTaskIdsCommon
@BudgetPayerStatusFolderControls
@ComponentDictionary
@NormalPriority
class BudgetPayerStatusControlTest(
    testName: String,
    preExecution: (() -> BudgetPayerStatusDto)?,
    postExecution: ((BudgetPayerStatusDto) -> Unit)? = null,
    control: BudgetPayerStatusControls,
    steps: BudgetPayerStatusSteps = BudgetPayerStatusSteps(bankAdmin)
) : NestedControlTestTemplate<BudgetPayerStatusDto>(
    testName = testName,
    docControl = control,
    preExecution = preExecution,
    postExecution = postExecution,
    steps = steps
)

@BudgetPayerStatusTaskIdsCommon
@BudgetPayerStatusFolderControls
@ComponentDictionary
@NormalPriority
class BudgetPayerStatusServerErrorTest(
    testName: String,
    user: User = bankAdmin,
    preExecution: (() -> BudgetPayerStatusDto)?,
    postExecution: ((BudgetPayerStatusDto) -> Unit)? = null,
    expectedHttpCode: Int = 500,
    expectedCode: Int,
    expectedMessage: String,
) : ServerErrorTestTemplate<BudgetPayerStatusDto, BudgetPayerStatusDto>(
    testName = testName,
    user = user,
    preExecution = preExecution,
    postExecution = postExecution,
    steps = BudgetPayerStatusSteps(user),
    expectedHttpCode = expectedHttpCode,
    expectedCode = expectedCode,
    expectedMessage = expectedMessage,
)

@BudgetPayerStatusTaskIdsCommon
@BudgetPayerStatusFolderDefaults
@ComponentDictionary
@HighPriority
class BudgetPayerStatusDefaultsTest(
    testBody: (Unit?) -> Unit
) : UnitBeTest(
    name = "'${DictionaryNames.BUDGET_PAYER_STATUS}'. Наполнение",
    testBody = testBody
)