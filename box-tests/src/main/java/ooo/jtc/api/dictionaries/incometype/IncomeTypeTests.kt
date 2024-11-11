package ooo.jtc.api.dictionaries.incometype

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
import ooo.jtc.api.dictionaries.incometype.IncomeTypePrepareSteps.addValidCode
import ooo.jtc.api.dictionaries.incometype.IncomeTypePrepareSteps.getIncomeTypeDtoForCreate
import ooo.jtc.api.dictionaries.incometype.IncomeTypePrepareSteps.getIncomeTypeDtoForUpdate
import ooo.jtc.api.dictionaries.incometype.IncomeTypePrepareSteps.getValidCode
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.dictionaries.incometype.IncomeTypeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.incometype.IncomeTypeControls
import ooo.jtc.testdata.dictionaries.incometype.IncomeTypeData
import ooo.jtc.testdata.dictionaries.incometype.IncomeTypeFilterParams
import ooo.jtc.testdata.dictionaries.incometype.IncomeTypeSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val BASE_FOLDER ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.INCOME_TYPE}\" (incomeType)"
@Folder("$BASE_FOLDER/${SubFolder.CRUD}")       annotation class IncomeTypeFolderCrud
@Folder("$BASE_FOLDER/${SubFolder.CONTROLS}")   annotation class IncomeTypeFolderControls
@Folder("$BASE_FOLDER/${SubFolder.SORTING}")    annotation class IncomeTypeFolderSorting
@Folder("$BASE_FOLDER/${SubFolder.FILTRATION}") annotation class IncomeTypeFolderFiltration
@Folder("$BASE_FOLDER/${SubFolder.DEFAULTS}")   annotation class IncomeTypeFolderDefaults

@TaskIds(["JSRRKO2-204","JSRRKO2-210"]) annotation class IncomeTypeTraceabilityTasks
//@formatter:on


@IncomeTypeTraceabilityTasks
@ComponentDictionary
@IncomeTypeFolderCrud
@HighPriority
class IncomeTypeCreateTest(
    user: User,
    steps: IncomeTypeSteps = IncomeTypeSteps(user)
) : CreateTestTemplate<IncomeTypeDto>(
    preExecution = { getIncomeTypeDtoForCreate() },
    testPostExecution = {
        steps.delete(it.id!!)
        addValidCode(it.code!!)
    },
    steps = steps
)

@IncomeTypeTraceabilityTasks
@ComponentDictionary
@IncomeTypeFolderCrud
@HighPriority
class IncomeTypeGetTest(user: User) :
    GetTestTemplate<IncomeTypeDto>(
        preExecution = { IncomeTypeData.randomOrException().toDto() },
        steps = IncomeTypeSteps(user)
    )

@IncomeTypeTraceabilityTasks
@ComponentDictionary
@IncomeTypeFolderCrud
@HighPriority
class IncomeTypeGetPageTest(user: User) :
    GetPageTestTemplate<IncomeTypeDto>(
        steps = IncomeTypeSteps(user)
    )

@IncomeTypeTraceabilityTasks
@ComponentDictionary
@IncomeTypeFolderCrud
@HighPriority
class IncomeTypeUpdateTest(
    user: User,
    steps: IncomeTypeSteps = IncomeTypeSteps(user),
    createCode: Int = getValidCode()
) : UpdateTestTemplate<IncomeTypeDto, IncomeTypeDto>(
    preExecution = {
        val createdDto = steps.create(getIncomeTypeDtoForCreate(code = createCode)).data!!
        getIncomeTypeDtoForUpdate(createdDto)
    },
    postExecution = {
        steps.delete(it.id!!)
        addValidCode(it.code!!)
        addValidCode(createCode)
    },
    steps = steps
)

@IncomeTypeTraceabilityTasks
@ComponentDictionary
@IncomeTypeFolderCrud
@HighPriority
class IncomeTypeDeleteTest(
    user: User,
    steps: IncomeTypeSteps = IncomeTypeSteps(user)
) : DeleteTestTemplate<IncomeTypeDto>(
    preExecution = {
        steps.create(getIncomeTypeDtoForCreate()).data!!
    },
    postExecution = { addValidCode(it.code!!) },
    steps = steps
)

@IncomeTypeTraceabilityTasks
@ComponentDictionary
@IncomeTypeFolderControls
@HighPriority
class IncomeTypeControlTest(
    testName: String,
    preExecution: (() -> IncomeTypeDto)?,
    postExecution: ((IncomeTypeDto) -> Unit)? = { addValidCode(it.code!!) },
    control: IncomeTypeControls
) : NestedControlTestTemplate<IncomeTypeDto>(
    testName = testName,
    preExecution = preExecution,
    postExecution = postExecution,
    steps = IncomeTypeSteps(bankAdmin),
    docControl = control
)

@IncomeTypeTraceabilityTasks
@ComponentDictionary
@IncomeTypeFolderControls
@HighPriority
class IncomeTypeServerErrorTest(
    testName: String,
    user: User = bankAdmin,
    preExecution: (() -> IncomeTypeDto)?,
    expectedHttpCode: Int = 500,
    expectedCode: Int,
    expectedMessage: String,
) : ServerErrorTestTemplate<IncomeTypeDto, IncomeTypeDto>(
    testName = testName,
    user = user,
    preExecution = preExecution,
    steps = IncomeTypeSteps(user),
    expectedHttpCode = expectedHttpCode,
    expectedCode = expectedCode,
    expectedMessage = expectedMessage,
)

@IncomeTypeTraceabilityTasks
@ComponentDictionary
@IncomeTypeFolderSorting
@NormalPriority
class IncomeTypeSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<IncomeTypeDto, IncomeTypeSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = IncomeTypeSteps(user),
    clazz = IncomeTypeSortingParams::class.java
)

@IncomeTypeTraceabilityTasks
@ComponentDictionary
@IncomeTypeFolderFiltration
@NormalPriority
class IncomeTypeFiltrationTest(
    name: String,
    user: User,
    filterDto: IncomeTypeDto,
    filterRequestFunction: (IncomeTypeDto?) -> FilterData
) : FiltrationTestTemplate<IncomeTypeDto, IncomeTypeFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = IncomeTypeSteps(user),
    clazz = IncomeTypeFilterParams::class.java,
    preExecution = { filterDto }
)

@IncomeTypeTraceabilityTasks
@ComponentDictionary
@IncomeTypeFolderDefaults
@HighPriority
class IncomeTypeDefaultsTest(
    testBody: (Unit?) -> Unit
) : UnitBeTest(
    name = "'${DictionaryNames.INCOME_TYPE}'. Наполнение",
    testBody = testBody
)