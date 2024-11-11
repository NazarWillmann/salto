package ooo.jtc.api.dictionaries.salarypaymenttype

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.NestedControlTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.dictionaries.salarypaymenttype.SalaryPaymentTypePrepareSteps.availableSalaryPaymentTypeCodes
import ooo.jtc.api.dictionaries.salarypaymenttype.SalaryPaymentTypePrepareSteps.getSalaryPaymentTypeDtoForCreate
import ooo.jtc.api.dictionaries.salarypaymenttype.SalaryPaymentTypePrepareSteps.getSalaryPaymentTypeDtoForUpdate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jEpic.EPIC_SALARY
import ooo.jtc.dictionaries.salarypaymenttype.SalaryPaymentTypeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.Users.systemBankOperator
import ooo.jtc.testdata.dictionaries.salarypaymenttype.SalaryPaymentTypeControls
import ooo.jtc.testdata.dictionaries.salarypaymenttype.SalaryPaymentTypeData
import ooo.jtc.testdata.dictionaries.salarypaymenttype.SalaryPaymentTypeFilterParams
import ooo.jtc.testdata.dictionaries.salarypaymenttype.SalaryPaymentTypeSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder = "${FolderPrefix.DICTIONARY} \"${DictionaryNames.SALARY_PAYMENT_TYPE}\" (salaryPaymentType)"

@Folder("${baseFolder}/${SubFolder.CRUD}")
annotation class SalaryPaymentTypeFolderCrud

@Folder("${baseFolder}/${SubFolder.SORTING}")
annotation class SalaryPaymentTypeFolderSorting

@Folder("${baseFolder}/${SubFolder.FILTRATION}")
annotation class SalaryPaymentTypeFolderFiltration

@Folder("${baseFolder}/${SubFolder.CONTROLS}")
annotation class SalaryPaymentTypeFolderControls

@Folder("${baseFolder}/${SubFolder.DEFAULTS}")
annotation class SalaryPaymentTypeFolderDefaults

@TaskIds([EPIC_SALARY, "JSSP-119"])
annotation class SalaryPaymentTypeTaskIdsCommon
//@formatter:on

@SalaryPaymentTypeTaskIdsCommon
@SalaryPaymentTypeFolderCrud
@ComponentDictionary
@HighPriority
class SalaryPaymentTypeCreateTest(
    user: User = systemBankOperator,
    steps: SalaryPaymentTypeSteps = SalaryPaymentTypeSteps(user)
) : CreateTestTemplate<SalaryPaymentTypeDto>(
    preExecution = { getSalaryPaymentTypeDtoForCreate() },
    steps = steps,
    testPostExecution = {
        availableSalaryPaymentTypeCodes.add(it.code!!)
        steps.delete(it.id!!)
    }
)

@SalaryPaymentTypeTaskIdsCommon
@SalaryPaymentTypeFolderCrud
@ComponentDictionary
@HighPriority
class SalaryPaymentTypeGetTest(user: User) :
    GetTestTemplate<SalaryPaymentTypeDto>(
        preExecution = { SalaryPaymentTypeData.randomOrException().toDto() },
        steps = SalaryPaymentTypeSteps(user)
    )

@SalaryPaymentTypeTaskIdsCommon
@SalaryPaymentTypeFolderCrud
@ComponentDictionary
@HighPriority
class SalaryPaymentTypeGetPageTest(user: User) :
    GetPageTestTemplate<SalaryPaymentTypeDto>(
        steps = SalaryPaymentTypeSteps(user)
    )

@SalaryPaymentTypeTaskIdsCommon
@SalaryPaymentTypeFolderCrud
@ComponentDictionary
@HighPriority
class SalaryPaymentTypeDeleteTest(
    user: User = bankAdmin,
    steps: SalaryPaymentTypeSteps = SalaryPaymentTypeSteps(user)
) : DeleteTestTemplate<SalaryPaymentTypeDto>(
    preExecution = {
        val createdResponse = steps.create(getSalaryPaymentTypeDtoForCreate())
        createdResponse.data!!
    },
    steps = steps
)

@SalaryPaymentTypeTaskIdsCommon
@SalaryPaymentTypeFolderCrud
@ComponentDictionary
@HighPriority
class SalaryPaymentTypeUpdateTest(
    user: User = bankAdmin,
    steps: SalaryPaymentTypeSteps = SalaryPaymentTypeSteps(user),
    createCode: String? = availableSalaryPaymentTypeCodes.remove()
) : UpdateTestTemplate<SalaryPaymentTypeDto, SalaryPaymentTypeDto>(
    preExecution = {
        val createdDto = steps.create(getSalaryPaymentTypeDtoForCreate(code = createCode)).data!!
        getSalaryPaymentTypeDtoForUpdate(createdDto)
    },
    steps = steps,
    postExecution = {
        steps.delete(it.id!!)
        availableSalaryPaymentTypeCodes.add(it.code!!)
        availableSalaryPaymentTypeCodes.add(createCode!!)
    }
)

@SalaryPaymentTypeTaskIdsCommon
@SalaryPaymentTypeFolderSorting
@ComponentDictionary
@NormalPriority
class SalaryPaymentTypeSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<SalaryPaymentTypeDto, SalaryPaymentTypeSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = SalaryPaymentTypeSteps(user),
    clazz = SalaryPaymentTypeSortingParams::class.java
)

@SalaryPaymentTypeTaskIdsCommon
@SalaryPaymentTypeFolderFiltration
@ComponentDictionary
@NormalPriority
class SalaryPaymentTypeFilterTest(
    name: String,
    user: User,
    preExecution: (() -> SalaryPaymentTypeDto)?,
    filterRequestFunction: (SalaryPaymentTypeDto?) -> FilterData
) : FiltrationTestTemplate<SalaryPaymentTypeDto, SalaryPaymentTypeFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = SalaryPaymentTypeSteps(user),
    clazz = SalaryPaymentTypeFilterParams::class.java,
    preExecution = preExecution
)

@SalaryPaymentTypeTaskIdsCommon
@SalaryPaymentTypeFolderControls
@ComponentDictionary
@HighPriority
class SalaryPaymentTypeControlTest(
    testName: String,
    preExecution: (() -> SalaryPaymentTypeDto)?,
    postExecution: ((SalaryPaymentTypeDto) -> Unit)? = { availableSalaryPaymentTypeCodes.add(it.code!!) },
    control: SalaryPaymentTypeControls,
) : NestedControlTestTemplate<SalaryPaymentTypeDto>(
    testName = testName,
    preExecution = preExecution,
    postExecution = postExecution,
    steps = SalaryPaymentTypeSteps(bankAdmin),
    docControl = control
)

@SalaryPaymentTypeTaskIdsCommon
@SalaryPaymentTypeFolderDefaults
@ComponentDictionary
@HighPriority
class SalaryPaymentTypeDefaultsTest(
    testBody: (Unit?) -> Unit
) : UnitBeTest(
    name = "'${DictionaryNames.SALARY_PAYMENT_TYPE}'. Наполнение",
    testBody = testBody
)