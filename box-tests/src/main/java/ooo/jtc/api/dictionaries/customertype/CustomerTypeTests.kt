package ooo.jtc.api.dictionaries.customertype

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.customertype.CustomerTypePrepareSteps.getCustomerTypeDtoForCreate
import ooo.jtc.api.dictionaries.customertype.CustomerTypePrepareSteps.getCustomerTypeDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.dictionaries.customertype.CustomerTypeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.customertype.CustomerTypeData
import ooo.jtc.testdata.dictionaries.customertype.CustomerTypeFilterParams
import ooo.jtc.testdata.dictionaries.customertype.CustomerTypeSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.CUSTOMER_TYPE}\" (customerType)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class CustomerTypeFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class CustomerTypeFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class CustomerTypeFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class CustomerTypeFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class CustomerTypeFolderOther

@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY,Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1143"]) annotation class CustomerTypeTaskIdsCommon
//@formatter:on

@CustomerTypeTaskIdsCommon
@CustomerTypeFolderCrud
@ComponentDictionary
@HighPriority
class CustomerTypeCreateTest(user: User = bankAdmin) :
    CreateTestTemplate<CustomerTypeDto>(
        preExecution = { getCustomerTypeDtoForCreate() },
        steps = CustomerTypeSteps(user)
    )

@CustomerTypeTaskIdsCommon
@CustomerTypeFolderCrud
@ComponentDictionary
@HighPriority
class CustomerTypeGetTest(user: User) :
    GetTestTemplate<CustomerTypeDto>(
        preExecution = { CustomerTypeData.randomOrException().toDto() },
        steps = CustomerTypeSteps(user)
    )

@CustomerTypeTaskIdsCommon
@CustomerTypeFolderCrud
@ComponentDictionary
@HighPriority
class CustomerTypeGetPageTest(user: User) :
    GetPageTestTemplate<CustomerTypeDto>(
        steps = CustomerTypeSteps(user)
    )

@CustomerTypeTaskIdsCommon
@CustomerTypeFolderCrud
@ComponentDictionary
@HighPriority
class CustomerTypeDeleteTest(user: User = bankAdmin) :
    DeleteTestTemplate<CustomerTypeDto>(
        preExecution = {
            val createdResponse = CustomerTypeSteps(user).create(getCustomerTypeDtoForCreate())
            createdResponse.data!!
        },
        steps = CustomerTypeSteps(user)
    )

@CustomerTypeTaskIdsCommon
@CustomerTypeFolderCrud
@ComponentDictionary
@HighPriority
class CustomerTypeUpdateTest(user: User = bankAdmin) :
    UpdateTestTemplate<CustomerTypeDto, CustomerTypeDto>(
        preExecution = {
            val createdDto = CustomerTypeSteps(user).create(getCustomerTypeDtoForCreate()).data!!
            getCustomerTypeDtoForUpdate(createdDto)
        },
        steps = CustomerTypeSteps(user)
    )

@CustomerTypeTaskIdsCommon
@CustomerTypeFolderSorting
@ComponentDictionary
@LowPriority
class CustomerTypeSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<CustomerTypeDto, CustomerTypeSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = CustomerTypeSteps(user),
    clazz = CustomerTypeSortingParams::class.java
)

@CustomerTypeTaskIdsCommon
@CustomerTypeFolderFiltration
@ComponentDictionary
@NormalPriority
class CustomerTypeFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> CustomerTypeDto)?,
    filterRequestFunction: (CustomerTypeDto?) -> FilterData
) : FiltrationTestTemplate<CustomerTypeDto, CustomerTypeFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = CustomerTypeSteps(user),
    clazz = CustomerTypeFilterParams::class.java,
    preExecution = preExecution
)