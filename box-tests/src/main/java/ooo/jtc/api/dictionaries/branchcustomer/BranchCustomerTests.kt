package ooo.jtc.api.dictionaries.branchcustomer

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerPrepareSteps.getBranchCustomerDtoForCreate
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerPrepareSteps.getBranchCustomerDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.dictionaries.branchcustomer.BranchCustomerDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.superUser
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerFilterParams
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.BRANCH_CUSTOMER}\" (branchCustomer)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class BranchCustomerFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class BranchCustomerFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class BranchCustomerFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class BranchCustomerFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class BranchCustomerFolderOther

@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY,Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1119"]) annotation class BranchCustomerTaskIdsCommon
//@formatter:on

@BranchCustomerTaskIdsCommon
@BranchCustomerFolderCrud
@ComponentDictionary
@HighPriority
class BranchCustomerCreateTest(user: User = superUser) :
    CreateTestTemplate<BranchCustomerDto>(
        preExecution = { getBranchCustomerDtoForCreate() },
        steps = BranchCustomerSteps(user)
    )

@BranchCustomerTaskIdsCommon
@BranchCustomerFolderCrud
@ComponentDictionary
@HighPriority
class BranchCustomerGetTest(user: User = superUser) :
    GetTestTemplate<BranchCustomerDto>(
        preExecution = { BranchCustomerData.getOrCreate { BranchCustomerPrepareSteps.createBranchCustomer().toModel() }.toDto() },
        steps = BranchCustomerSteps(user)
    )

@BranchCustomerTaskIdsCommon
@BranchCustomerFolderCrud
@ComponentDictionary
@HighPriority
class BranchCustomerGetPageTest(user: User = superUser) :
    GetPageTestTemplate<BranchCustomerDto>(
        steps = BranchCustomerSteps(user)
    )

@BranchCustomerTaskIdsCommon
@BranchCustomerFolderCrud
@ComponentDictionary
@HighPriority
class BranchCustomerDeleteTest(user: User = superUser) :
    DeleteTestTemplate<BranchCustomerDto>(
        preExecution = {
            val createdResponse = BranchCustomerSteps(user).create(getBranchCustomerDtoForCreate())
            createdResponse.data!!
        },
        steps = BranchCustomerSteps(user)
    )

@BranchCustomerTaskIdsCommon
@BranchCustomerFolderCrud
@ComponentDictionary
@HighPriority
class BranchCustomerUpdateTest(user: User = superUser) :
    UpdateTestTemplate<BranchCustomerDto, BranchCustomerDto>(
        preExecution = {
            val createdDto = BranchCustomerSteps(user).create(getBranchCustomerDtoForCreate()).data!!
            getBranchCustomerDtoForUpdate(createdDto)
        },
        steps = BranchCustomerSteps(user)
    )

@BranchCustomerTaskIdsCommon
@BranchCustomerFolderSorting
@ComponentDictionary
@LowPriority
class BranchCustomerSortingTest(
    sortRequestFunction: () -> List<Sort>,
    user: User = superUser
) : SortingTestTemplate<BranchCustomerDto, BranchCustomerSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = BranchCustomerSteps(user),
    clazz = BranchCustomerSortingParams::class.java
)

@BranchCustomerTaskIdsCommon
@BranchCustomerFolderFiltration
@ComponentDictionary
@NormalPriority
class BranchCustomerFiltrationTest(
    name: String,
    user: User = superUser,
    preExecution: (() -> BranchCustomerDto)?,
    filterRequestFunction: (BranchCustomerDto?) -> FilterData
) : FiltrationTestTemplate<BranchCustomerDto, BranchCustomerFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = BranchCustomerSteps(user),
    clazz = BranchCustomerFilterParams::class.java,
    preExecution = preExecution
)