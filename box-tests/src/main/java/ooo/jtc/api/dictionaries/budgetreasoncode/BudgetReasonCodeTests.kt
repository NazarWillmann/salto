package ooo.jtc.api.dictionaries.budgetreasoncode

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
import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodePrepareSteps.getBudgetReasonCodeDtoForCreate
import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodePrepareSteps.getBudgetReasonCodeDtoForUpdate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.dictionaries.budgetreasoncode.BudgetReasonCodeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeControls
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeData
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeFilterParams
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val BASE_FOLDER ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.BUDGET_REASON_CODE}\" (budgetReasonCode)"

@Folder("$BASE_FOLDER/${SubFolder.CRUD}")          annotation class BudgetReasonCodeFolderCrud
@Folder("$BASE_FOLDER/${SubFolder.SORTING}")       annotation class BudgetReasonCodeFolderSorting
@Folder("$BASE_FOLDER/${SubFolder.FILTRATION}")    annotation class BudgetReasonCodeFolderFiltration
@Folder("$BASE_FOLDER/${SubFolder.CONTROLS}")      annotation class BudgetReasonCodeFolderControls
@Folder("$BASE_FOLDER/${SubFolder.DEFAULTS}")      annotation class BudgetReasonCodeFolderDefaults

@TaskIds(["JSRRKO2-234", "JSRRKO2-240"]) annotation class BudgetReasonCodeTraceabilityTasks
//@formatter:on

@BudgetReasonCodeTraceabilityTasks
@BudgetReasonCodeFolderCrud
@ComponentDictionary
@HighPriority
class BudgetReasonCodeCreateTest(user: User = bankAdmin) :
    CreateTestTemplate<BudgetReasonCodeDto>(
        preExecution = { getBudgetReasonCodeDtoForCreate() },
        steps = BudgetReasonCodeSteps(user)
    )

@BudgetReasonCodeTraceabilityTasks
@BudgetReasonCodeFolderCrud
@ComponentDictionary
@HighPriority
class BudgetReasonCodeGetTest(user: User) :
    GetTestTemplate<BudgetReasonCodeDto>(
        preExecution = { BudgetReasonCodeData.randomOrException().toDto() },
        steps = BudgetReasonCodeSteps(user)
    )

@BudgetReasonCodeTraceabilityTasks
@BudgetReasonCodeFolderCrud
@ComponentDictionary
@HighPriority
class BudgetReasonCodeGetPageTest(user: User) :
    GetPageTestTemplate<BudgetReasonCodeDto>(
        steps = BudgetReasonCodeSteps(user)
    )

@BudgetReasonCodeTraceabilityTasks
@BudgetReasonCodeFolderCrud
@ComponentDictionary
@HighPriority
class BudgetReasonCodeDeleteTest(user: User) :
    DeleteTestTemplate<BudgetReasonCodeDto>(
        preExecution = {
            val createdResponse =
                BudgetReasonCodeSteps(user).create(getBudgetReasonCodeDtoForCreate())
            createdResponse.data!!
        },
        steps = BudgetReasonCodeSteps(user)
    )

@BudgetReasonCodeTraceabilityTasks
@BudgetReasonCodeFolderCrud
@ComponentDictionary
@HighPriority
class BudgetReasonCodeUpdateTest(user: User) :
    UpdateTestTemplate<BudgetReasonCodeDto, BudgetReasonCodeDto>(
        preExecution = {
            val createdDto = BudgetReasonCodeSteps(user).create(getBudgetReasonCodeDtoForCreate()).data!!
            getBudgetReasonCodeDtoForUpdate(createdDto)
        },
        steps = BudgetReasonCodeSteps(user)
    )

@BudgetReasonCodeTraceabilityTasks
@BudgetReasonCodeFolderSorting
@ComponentDictionary
@LowPriority
class BudgetReasonCodeSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<BudgetReasonCodeDto, BudgetReasonCodeSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = BudgetReasonCodeSteps(user),
    clazz = BudgetReasonCodeSortingParams::class.java
)

@BudgetReasonCodeTraceabilityTasks
@BudgetReasonCodeFolderFiltration
@ComponentDictionary
@NormalPriority
class BudgetReasonCodeFilterTests(
    name: String,
    user: User,
    preExecution: (() -> BudgetReasonCodeDto)?,
    filterRequestFunction: (BudgetReasonCodeDto?) -> FilterData
) : FiltrationTestTemplate<BudgetReasonCodeDto, BudgetReasonCodeFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = BudgetReasonCodeSteps(user),
    clazz = BudgetReasonCodeFilterParams::class.java,
    preExecution = preExecution
)

@BudgetReasonCodeTraceabilityTasks
@BudgetReasonCodeFolderControls
@ComponentDictionary
@NormalPriority
class BudgetReasonCodeControlTest(
    testName: String,
    preExecution: (() -> BudgetReasonCodeDto)?,
    control: BudgetReasonCodeControls
) : NestedControlTestTemplate<BudgetReasonCodeDto>(
    testName = testName,
    docControl = control,
    preExecution = preExecution,
    steps = BudgetReasonCodeSteps(bankAdmin)
)

@BudgetReasonCodeTraceabilityTasks
@BudgetReasonCodeFolderControls
@ComponentDictionary
@NormalPriority
class BudgetReasonCodeServerErrorTest(
    testName: String,
    user: User = bankAdmin,
    preExecution: (() -> BudgetReasonCodeDto)?,
    expectedHttpCode: Int = 500,
    expectedCode: Int,
    expectedMessage: String,
) : ServerErrorTestTemplate<BudgetReasonCodeDto, BudgetReasonCodeDto>(
    testName = testName,
    user = user,
    preExecution = preExecution,
    steps = BudgetReasonCodeSteps(user),
    expectedHttpCode = expectedHttpCode,
    expectedCode = expectedCode,
    expectedMessage = expectedMessage,
)

@BudgetReasonCodeTraceabilityTasks
@BudgetReasonCodeFolderDefaults
@ComponentDictionary
@HighPriority
class BudgetReasonCodeDefaultsTest(
    testBody: (Unit?) -> Unit
) : UnitBeTest(
    name = "'${DictionaryNames.BUDGET_REASON_CODE}'. Наполнение",
    testBody = testBody
)
