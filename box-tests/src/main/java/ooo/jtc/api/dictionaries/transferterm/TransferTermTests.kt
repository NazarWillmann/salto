package ooo.jtc.api.dictionaries.transferterm

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.NestedControlTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.dictionaries.transferterm.TransferTermPrepareSteps.getTransferTermDtoForCreate
import ooo.jtc.api.dictionaries.transferterm.TransferTermPrepareSteps.getTransferTermDtoForUpdate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.dictionaries.transferterm.TransferTermDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.transferterm.TransferTermControls
import ooo.jtc.testdata.dictionaries.transferterm.TransferTermData
import ooo.jtc.testdata.dictionaries.transferterm.TransferTermFilterParams
import ooo.jtc.testdata.dictionaries.transferterm.TransferTermSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.TRANSFER_TERM}\" (transferTerm)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class TransferTermFolderCrud
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class TransferTermFolderControls
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class TransferTermFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class TransferTermFolderFiltration
@Folder("$baseFolder/${SubFolder.DEFAULTS}")   annotation class TransferTermFolderDefaults

@TaskIds(["JSRRKO2-211","JSRRKO2-217"]) annotation class TransferTermTraceabilityTasks
//@formatter:on


@TransferTermTraceabilityTasks
@ComponentDictionary
@TransferTermFolderCrud
@HighPriority
class TransferTermCreateTest(
    user: User
) : CreateTestTemplate<TransferTermDto>(
    preExecution = { getTransferTermDtoForCreate() },
    steps = TransferTermSteps(user)
)

@TransferTermTraceabilityTasks
@ComponentDictionary
@TransferTermFolderCrud
@HighPriority
class TransferTermGetTest(user: User) :
    GetTestTemplate<TransferTermDto>(
        preExecution = { TransferTermData.randomOrException().toDto() },
        steps = TransferTermSteps(user)
    )

@TransferTermTraceabilityTasks
@ComponentDictionary
@TransferTermFolderCrud
@HighPriority
class TransferTermGetPageTest(user: User) :
    GetPageTestTemplate<TransferTermDto>(
        steps = TransferTermSteps(user)
    )

@TransferTermTraceabilityTasks
@ComponentDictionary
@TransferTermFolderCrud
@HighPriority
class TransferTermUpdateTest(
    user: User,
    steps: TransferTermSteps = TransferTermSteps(user),
) : UpdateTestTemplate<TransferTermDto, TransferTermDto>(
    preExecution = {
        val createdDto = steps.create(getTransferTermDtoForCreate()).data!!
        getTransferTermDtoForUpdate(createdDto)
    },
    steps = steps
)

@TransferTermTraceabilityTasks
@ComponentDictionary
@TransferTermFolderCrud
@HighPriority
class TransferTermDeleteTest(
    user: User,
    steps: TransferTermSteps = TransferTermSteps(user)
) : DeleteTestTemplate<TransferTermDto>(
    preExecution = {
        steps.create(getTransferTermDtoForCreate()).data!!
    },
    steps = steps
)

@TransferTermTraceabilityTasks
@ComponentDictionary
@TransferTermFolderControls
@HighPriority
class TransferTermControlTest(
    testName: String,
    preExecution: (() -> TransferTermDto)?,
    control: TransferTermControls
) : NestedControlTestTemplate<TransferTermDto>(
    testName = testName,
    steps = TransferTermSteps(bankAdmin),
    preExecution = preExecution,
    docControl = control
)

@TransferTermTraceabilityTasks
@ComponentDictionary
@TransferTermFolderSorting
@NormalPriority
class TransferTermSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<TransferTermDto, TransferTermSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = TransferTermSteps(user),
    clazz = TransferTermSortingParams::class.java
)

@TransferTermTraceabilityTasks
@ComponentDictionary
@TransferTermFolderFiltration
@NormalPriority
class TransferTermFiltrationTest(
    name: String,
    user: User,
    filterDto: TransferTermDto,
    filterRequestFunction: (TransferTermDto?) -> FilterData
) : FiltrationTestTemplate<TransferTermDto, TransferTermFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = TransferTermSteps(user),
    clazz = TransferTermFilterParams::class.java,
    preExecution = { filterDto }
)

@TransferTermTraceabilityTasks
@ComponentDictionary
@TransferTermFolderDefaults
@HighPriority
class TransferTermDefaultsTest(
    testBody: (Unit?) -> Unit
) : UnitBeTest(
    name = "'${DictionaryNames.TRANSFER_TERM}'. Наполнение",
    testBody = testBody
)