package ooo.jtc.api.dictionaries.customerkpp

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.customerkpp.CustomerKppPrepareSteps.getCustomerKppDtoForCreate
import ooo.jtc.api.dictionaries.customerkpp.CustomerKppPrepareSteps.getCustomerKppDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.dictionaries.customerkpp.CustomerKppDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.customerkpp.CustomerKppData
import ooo.jtc.testdata.dictionaries.customerkpp.CustomerKppFilterParams
import ooo.jtc.testdata.dictionaries.customerkpp.CustomerKppSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.CUSTOMER_KPP}\" (customerKpp)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class CustomerKppFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class CustomerKppFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class CustomerKppFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class CustomerKppFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class CustomerKppFolderOther

@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY,Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1142"]) annotation class CustomerKppTaskIdsCommon
//@formatter:on

@CustomerKppTaskIdsCommon
@CustomerKppFolderCrud
@ComponentDictionary
@HighPriority
class CustomerKppCreateTest(user: User = Users.bankAdmin) :
    CreateTestTemplate<CustomerKppDto>(
        preExecution = { getCustomerKppDtoForCreate(user) },
        steps = CustomerKppSteps(user)
    )

@CustomerKppTaskIdsCommon
@CustomerKppFolderCrud
@ComponentDictionary
@HighPriority
class CustomerKppGetTest(user: User) :
    GetTestTemplate<CustomerKppDto>(
        preExecution = {
            CustomerKppData.getOrCreate(
                consumer = { CustomerKppData.searchBy(user) },
                provider = { CustomerKppPrepareSteps.createCustomerKppDto(user).toModel() }
            ).toDto()
        },
        steps = CustomerKppSteps(user)
    )

@CustomerKppTaskIdsCommon
@CustomerKppFolderCrud
@ComponentDictionary
@HighPriority
class CustomerKppGetPageTest(user: User) :
    GetPageTestTemplate<CustomerKppDto>(
        steps = CustomerKppSteps(user)
    )

@CustomerKppTaskIdsCommon
@CustomerKppFolderCrud
@ComponentDictionary
@HighPriority
class CustomerKppDeleteTest(user: User = Users.bankAdmin) :
    DeleteTestTemplate<CustomerKppDto>(
        preExecution = { CustomerKppPrepareSteps.createCustomerKppDto(user) },
        steps = CustomerKppSteps(user)
    )

@CustomerKppTaskIdsCommon
@CustomerKppFolderCrud
@ComponentDictionary
@HighPriority
class CustomerKppUpdateTest(user: User = Users.bankAdmin) :
    UpdateTestTemplate<CustomerKppDto, CustomerKppDto>(
        preExecution = {
            val createdDto = CustomerKppPrepareSteps.createCustomerKppDto(user)
            getCustomerKppDtoForUpdate(createdDto)
        },
        steps = CustomerKppSteps(user)
    )

@CustomerKppTaskIdsCommon
@CustomerKppFolderSorting
@ComponentDictionary
@LowPriority
class CustomerKppSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<CustomerKppDto, CustomerKppSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = CustomerKppSteps(user),
    clazz = CustomerKppSortingParams::class.java
)

@CustomerKppTaskIdsCommon
@CustomerKppFolderFiltration
@ComponentDictionary
@NormalPriority
class CustomerKppFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> CustomerKppDto)?,
    filterRequestFunction: (CustomerKppDto?) -> FilterData
) : FiltrationTestTemplate<CustomerKppDto, CustomerKppFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = CustomerKppSteps(user),
    clazz = CustomerKppFilterParams::class.java,
    preExecution = preExecution
)