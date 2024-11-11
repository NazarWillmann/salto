package ooo.jtc.api.dictionaries.treasuryaccounttax

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.NestedControlTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxPrepareSteps.getTreasuryAccountTaxDtoForCreate
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxPrepareSteps.getTreasuryAccountTaxDtoForUpdate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.dictionaries.treasuryaccounttax.TreasuryAccountTaxDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxData
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxFilterParams
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val BASE_FOLDER ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.TREASURY_ACCOUNT_TAX}\" (treasuryaccounttax)"
@Folder("$BASE_FOLDER/${SubFolder.CRUD}")       annotation class TreasuryAccountTaxFolderCrud
@Folder("$BASE_FOLDER/${SubFolder.CONTROLS}")   annotation class TreasuryAccountTaxFolderControls
@Folder("$BASE_FOLDER/${SubFolder.SORTING}")    annotation class TreasuryAccountTaxFolderSorting
@Folder("$BASE_FOLDER/${SubFolder.FILTRATION}") annotation class TreasuryAccountTaxFolderFiltration
@Folder("$BASE_FOLDER/${SubFolder.DEFAULTS}")   annotation class TreasuryAccountTaxFolderDefaults
@Folder("$BASE_FOLDER/${SubFolder.OTHER}")      annotation class TreasuryAccountTaxFolderOther

@TaskIds(["JSRRKO2-218","JSRRKO2-226"])         annotation class TreasuryAccountTaxTraceabilityTasks
//@formatter:on

@TreasuryAccountTaxTraceabilityTasks
@ComponentDictionary
@TreasuryAccountTaxFolderCrud
@HighPriority
class TreasuryAccountTaxCreateTest(
    user: User
) : CreateTestTemplate<TreasuryAccountTaxDto>(
    preExecution = { getTreasuryAccountTaxDtoForCreate() },
    steps = TreasuryAccountTaxSteps(user)
)

@TreasuryAccountTaxTraceabilityTasks
@ComponentDictionary
@TreasuryAccountTaxFolderCrud
@HighPriority
class TreasuryAccountTaxGetTest(user: User) :
    GetTestTemplate<TreasuryAccountTaxDto>(
        preExecution = { TreasuryAccountTaxData.randomOrException().toDto() },
        steps = TreasuryAccountTaxSteps(user)
    )

@TreasuryAccountTaxTraceabilityTasks
@ComponentDictionary
@TreasuryAccountTaxFolderCrud
@HighPriority
class TreasuryAccountTaxGetPageTest(user: User) :
    GetPageTestTemplate<TreasuryAccountTaxDto>(
        steps = TreasuryAccountTaxSteps(user)
    )

@TreasuryAccountTaxTraceabilityTasks
@ComponentDictionary
@TreasuryAccountTaxFolderCrud
@HighPriority
class TreasuryAccountTaxUpdateTest(
    user: User,
    steps: TreasuryAccountTaxSteps = TreasuryAccountTaxSteps(user),
) : UpdateTestTemplate<TreasuryAccountTaxDto, TreasuryAccountTaxDto>(
    preExecution = {
        val createdDto = steps.create(getTreasuryAccountTaxDtoForCreate()).data!!
        getTreasuryAccountTaxDtoForUpdate(createdDto)
    },
    steps = steps
)

@TreasuryAccountTaxTraceabilityTasks
@ComponentDictionary
@TreasuryAccountTaxFolderCrud
@HighPriority
class TreasuryAccountTaxDeleteTest(
    user: User,
    steps: TreasuryAccountTaxSteps = TreasuryAccountTaxSteps(user)
) : DeleteTestTemplate<TreasuryAccountTaxDto>(
    preExecution = {
        steps.create(getTreasuryAccountTaxDtoForCreate()).data!!
    },
    steps = steps
)

@TreasuryAccountTaxTraceabilityTasks
@ComponentDictionary
@TreasuryAccountTaxFolderControls
@HighPriority
class TreasuryAccountTaxControlTest(
    testName: String,
    preExecution: (() -> TreasuryAccountTaxDto)?,
    control: TreasuryAccountTaxControls
) : NestedControlTestTemplate<TreasuryAccountTaxDto>(
    testName = testName,
    preExecution = preExecution,
    steps = TreasuryAccountTaxSteps(user = bankAdmin),
    docControl = control
)

@TreasuryAccountTaxTraceabilityTasks
@ComponentDictionary
@TreasuryAccountTaxFolderControls
@HighPriority
class TreasuryAccountTaxControlUnitBeTest(
    name: String,
    testBody: (Unit?) -> Unit
) : UnitBeTest(
    name = name,
    testBody = testBody
)

@TreasuryAccountTaxTraceabilityTasks
@ComponentDictionary
@TreasuryAccountTaxFolderSorting
@NormalPriority
class TreasuryAccountTaxSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<TreasuryAccountTaxDto, TreasuryAccountTaxSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = TreasuryAccountTaxSteps(user),
    clazz = TreasuryAccountTaxSortingParams::class.java
)

@TreasuryAccountTaxTraceabilityTasks
@ComponentDictionary
@TreasuryAccountTaxFolderFiltration
@NormalPriority
class TreasuryAccountTaxFiltrationTest(
    name: String,
    user: User,
    filterDto: TreasuryAccountTaxDto,
    filterRequestFunction: (TreasuryAccountTaxDto?) -> FilterData
) : FiltrationTestTemplate<TreasuryAccountTaxDto, TreasuryAccountTaxFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = TreasuryAccountTaxSteps(user),
    clazz = TreasuryAccountTaxFilterParams::class.java,
    preExecution = { filterDto }
)