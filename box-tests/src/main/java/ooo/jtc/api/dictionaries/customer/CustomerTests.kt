package ooo.jtc.api.dictionaries.customer

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.dictionaries.customer.CustomerPrepareSteps.getCustomerDtoForCreate
import ooo.jtc.api.dictionaries.customer.CustomerPrepareSteps.getCustomerDtoForUpdate
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
import ooo.jtc.dictionaries.customer.CustomerDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.scripts.soft
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.dictionaries.customer.CustomerFilterParams
import ooo.jtc.testdata.dictionaries.customer.CustomerSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.CUSTOMER}\" (customer)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class CustomerFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class CustomerFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class CustomerFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class CustomerFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class CustomerFolderOther

@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY,Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1141"]) annotation class CustomerTaskIdsCommon
//@formatter:on

@CustomerTaskIdsCommon
@CustomerFolderCrud
@ComponentDictionary
@HighPriority
class CustomerCreateTest(user: User = Users.bankAdmin) :
    CreateTestTemplate<CustomerDto>(
        preExecution = { getCustomerDtoForCreate() },
        steps = CustomerSteps(user),
        //TODO Sergeyev [2021.03.23]: remove soft, debug creation+deletion
        testPostExecution = { it.soft { CustomerPrepareSteps.deleteCustomerAndRelatedEntitiesIfPossible(it.id!!) } }
    )

@CustomerTaskIdsCommon
@CustomerFolderCrud
@ComponentDictionary
@HighPriority
class CustomerDeleteTest(user: User = Users.bankAdmin) :
    DeleteTestTemplate<CustomerDto>(
        preExecution = {
            val createdResponse = CustomerSteps(user).create(getCustomerDtoForCreate())
            createdResponse.data!!
        },
        steps = CustomerSteps(user),
        preCheckingHandling = {
            it.apply {
                kpp = emptyList()
            }
        },
        //TODO Khatmullin [2021.05.31] Is postExecution really needed in Delete tests
        postExecution = { it.soft { CustomerPrepareSteps.deleteCustomerAndRelatedEntitiesIfPossible(it.id!!) } }
    )

@CustomerTaskIdsCommon
@CustomerFolderCrud
@ComponentDictionary
@HighPriority
class CustomerUpdateTest(user: User = Users.bankAdmin) :
    UpdateTestTemplate<CustomerDto, CustomerDto>(
        preExecution = {
            val createResponse = CustomerSteps(user).create(getCustomerDtoForCreate())
            getCustomerDtoForUpdate(createResponse.data!!)
        },
        steps = CustomerSteps(user),
        postExecution = { it.soft { CustomerPrepareSteps.deleteCustomerAndRelatedEntitiesIfPossible(it.id!!) } }
    )

@CustomerTaskIdsCommon
@CustomerFolderCrud
@ComponentDictionary
@HighPriority
class CustomerGetTest(user: User) :
    GetTestTemplate<CustomerDto>(
        preExecution = { CustomerData.getOrCreate(user).toDto() },
        steps = CustomerSteps(user)
    )

@CustomerTaskIdsCommon
@CustomerFolderCrud
@ComponentDictionary
@HighPriority
class CustomerGetPageTest(user: User) :
    GetPageTestTemplate<CustomerDto>(
        steps = CustomerSteps(user)
    )

@CustomerTaskIdsCommon
@CustomerFolderSorting
@ComponentDictionary
@LowPriority
class CustomerSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<CustomerDto, CustomerSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = CustomerSteps(user),
    clazz = CustomerSortingParams::class.java
)

@CustomerTaskIdsCommon
@CustomerFolderFiltration
@ComponentDictionary
@NormalPriority
class CustomerFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> CustomerDto)?,
    filterRequestFunction: (CustomerDto?) -> FilterData
) : FiltrationTestTemplate<CustomerDto, CustomerFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = CustomerSteps(user),
    clazz = CustomerFilterParams::class.java,
    preExecution = preExecution
)