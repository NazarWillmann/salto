package ooo.jtc.api.dictionaries.customerrepresentative

import ooo.jtc.api.common.templates.entity.BlockingTestTemplate
import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UnblockingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.dictionaries.customer.CustomerPrepareSteps
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativePrepareSteps.getCustomerRepresentativeDtoForCreate
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativePrepareSteps.getCustomerRepresentativeDtoForUpdate
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.kexensions.invokeAuth
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
import ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeData
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeFilterParams
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeSortingParams
import ooo.jtc.uaa.User
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.hamcrest.Matchers.equalTo

//@formatter:off
private const val baseFolder = "${FolderPrefix.DICTIONARY} \"${DictionaryNames.CUSTOMER_REPRESENTATIVE}\" (customerRepresentative)"

@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class CustomerRepresentativeFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class CustomerRepresentativeFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class CustomerRepresentativeFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class CustomerRepresentativeFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class CustomerRepresentativeFolderOther

@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY,Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1135"]) annotation class CustomerRepresentativeTaskIdsCommon
//@formatter:on

@CustomerRepresentativeTaskIdsCommon
@CustomerRepresentativeFolderCrud
@ComponentDictionary
@HighPriority
class CustomerRepresentativeCreateTest(
    runTestAsUser: User,
    createEntityForUser: User
) : CreateTestTemplate<CustomerRepresentativeDto>(
    steps = CustomerRepresentativeSteps(runTestAsUser),
    preExecution = {
        val newCustomer = CustomerPrepareSteps.createCustomerWithNoRelations()
        getCustomerRepresentativeDtoForCreate(
            uaaUserId = createEntityForUser.uaaUserId!!,
            customerId = newCustomer.id!!
        )
    },
    postExecution = { CustomerPrepareSteps.deleteCustomerAndRelatedEntitiesIfPossible(it.customerId!!) },
    testPostExecution = null
)

@CustomerRepresentativeTaskIdsCommon
@CustomerRepresentativeFolderCrud
@ComponentDictionary
@HighPriority
class CustomerRepresentativeGetTest(bankUser: User) :
    GetTestTemplate<CustomerRepresentativeDto>(
        preExecution = {
            if (Users.superUser == bankUser) {
                //Sergeyev [2021.04.13]: superUser has access to every record in dictionaries
                CustomerRepresentativeData.get().random().toDto()
            } else {
                //Sergeyev [2021.04.13]: bankUsers are connected to Customers through related branches,
                // and thus to CustomerRepresentatives
                val relatedCustomersIds = BranchCustomerData.searchBy(bankUser).map { it.customerId }.distinct()
                CustomerRepresentativeData.get { it.customerId in relatedCustomersIds }.filter { !it.isBlock }.random().toDto()
            }
        },
        steps = CustomerRepresentativeSteps(bankUser)
    )

@CustomerRepresentativeTaskIdsCommon
@CustomerRepresentativeFolderCrud
@ComponentDictionary
@HighPriority
class CustomerRepresentativeGetPageTest(user: User) :
    GetPageTestTemplate<CustomerRepresentativeDto>(
        steps = CustomerRepresentativeSteps(user)
    )


@CustomerRepresentativeTaskIdsCommon
@CustomerRepresentativeFolderCrud
@ComponentDictionary
@HighPriority
class CustomerRepresentativeDeleteTest(
    runTestAsUser: User,
    createEntityForUser: User
) : DeleteTestTemplate<CustomerRepresentativeDto>(
    steps = CustomerRepresentativeSteps(runTestAsUser),
    preExecution = {
        val newCustomer = CustomerPrepareSteps.createCustomerWithNoRelations()
        val prepCustRepres = getCustomerRepresentativeDtoForCreate(
            uaaUserId = createEntityForUser.uaaUserId!!,
            customerId = newCustomer.id!!
        )
        CustomerRepresentativePrepareSteps.createCustomerRepresentative(prepCustRepres)
    },
    postExecution = { CustomerPrepareSteps.deleteCustomerAndRelatedEntitiesIfPossible(it.customerId!!) }
)

@CustomerRepresentativeTaskIdsCommon
@CustomerRepresentativeFolderCrud
@ComponentDictionary
@HighPriority
class CustomerRepresentativeUpdateTest(
    runTestAsUser: User,
    createEntityForUser: User
) : UpdateTestTemplate<CustomerRepresentativeDto, CustomerRepresentativeDto>(
    steps = CustomerRepresentativeSteps(runTestAsUser),
    preExecution = {
        val newCustomer = CustomerPrepareSteps.createCustomerWithNoRelations()
        val prepCustRepres = getCustomerRepresentativeDtoForCreate(
            uaaUserId = createEntityForUser.uaaUserId!!,
            customerId = newCustomer.id!!
        )
        val newCustRepres = CustomerRepresentativePrepareSteps.createCustomerRepresentative(prepCustRepres)
        getCustomerRepresentativeDtoForUpdate(newCustRepres)
    },
    postExecution = { CustomerPrepareSteps.deleteCustomerAndRelatedEntitiesIfPossible(it.customerId!!) },
    testPostExecution = null
)

@CustomerRepresentativeTaskIdsCommon
@CustomerRepresentativeFolderSorting
@ComponentDictionary
@LowPriority
class CustomerRepresentativeSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<CustomerRepresentativeDto, CustomerRepresentativeSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = CustomerRepresentativeSteps(user),
    clazz = CustomerRepresentativeSortingParams::class.java
)

@CustomerRepresentativeTaskIdsCommon
@CustomerRepresentativeFolderFiltration
@ComponentDictionary
@NormalPriority
class CustomerRepresentativeFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> CustomerRepresentativeDto)?,
    filterRequestFunction: (CustomerRepresentativeDto?) -> FilterData
) : FiltrationTestTemplate<CustomerRepresentativeDto, CustomerRepresentativeFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = CustomerRepresentativeSteps(user),
    clazz = CustomerRepresentativeFilterParams::class.java,
    preExecution = preExecution
)

@CustomerRepresentativeTaskIdsCommon
@CustomerRepresentativeFolderOther
@ComponentDictionary
@NormalPriority
class CustomerRepresentativeBlockingTest(
    runTestAsUser: User,
    createEntityForUser: User
): BlockingTestTemplate<CustomerRepresentativeDto>(
    steps = CustomerRepresentativeSteps(runTestAsUser),
    preExecution = {
        val newCustomer = CustomerPrepareSteps.createCustomerWithNoRelations()
        val prepBranchRepres = getCustomerRepresentativeDtoForCreate(
            uaaUserId = createEntityForUser.uaaUserId!!,
            customerId = newCustomer.id!!
        )
        CustomerRepresentativePrepareSteps.createCustomerRepresentative(prepBranchRepres)
    },
    postExecution = { CustomerPrepareSteps.deleteCustomerAndRelatedEntitiesIfPossible(it.customerId!!) }
)

@CustomerRepresentativeTaskIdsCommon
@CustomerRepresentativeFolderOther
@ComponentDictionary
@NormalPriority
class CustomerRepresentativeUnblockingTest(
    runTestAsUser: User,
    createEntityForUser: User
): UnblockingTestTemplate<CustomerRepresentativeDto>(
    steps = CustomerRepresentativeSteps(runTestAsUser),
    preExecution = {
        val newCustomer = CustomerPrepareSteps.createCustomerWithNoRelations()
        val prepBranchRepres = getCustomerRepresentativeDtoForCreate(
            uaaUserId = createEntityForUser.uaaUserId!!,
            customerId = newCustomer.id!!
        )
        CustomerRepresentativePrepareSteps.createBlockedCustomerRepresentativeDto(prepBranchRepres)
    },
    postExecution = { CustomerPrepareSteps.deleteCustomerAndRelatedEntitiesIfPossible(it.customerId!!) }
)

@CustomerRepresentativeTaskIdsCommon
@CustomerRepresentativeFolderOther
@NormalPriority
@ComponentDictionary
class CustomerRepresentativeGetForUser(
    runTestAsUser: User,
    createEntityForUser: User
): UnitBeTest(
    name = "'${DictionaryNames.CUSTOMER_REPRESENTATIVE}'. Получение списка Представителей, доступных пользователю [${createEntityForUser.userType}]",
    params = { mapOf(PARAM_USER to createEntityForUser) },
    testBody = {
        createEntityForUser.invokeAuth(newToken = true)
        val userUaaId = createEntityForUser.uaaUserId!!
        //Sergeyev [2021.04.12]: стоит помнить, что обычный пользователь получает только то, к чему у него:
        // - доступ есть (создана соответствующая запись в БД)
        // - доступ не заблокирован ('blocked' записи установлен в false).
        // Поэтому ниже при подготовке ожидаемого результата из списка записей исключаются заблокированные
        val actResult = CustomerRepresentativeSteps(runTestAsUser).getUserRepresentatives(userUaaId).list.getOrException()

        val expResult: List<CustomerRepresentativeDto>
        val relatedCustomersIds = BranchCustomerData.searchBy(createEntityForUser).map { it.customerId }
        val relatedCustomerRepresentatives = CustomerRepresentativeData.get { it.customerId in relatedCustomersIds }
        expResult = relatedCustomerRepresentatives
            .filter { !it.isBlock }
            .map { it.toDto() }

        "Проверить, что в ответе вернулись представители организаций, связаные пользователем id = '$userUaaId'" {
            assertThat("Количество представителей не совпадает с ожидаемым", actResult.size, equalTo(expResult.size))
            assertThat("Фактический результат не совпадает с ожидаемым", actResult, containsInAnyOrder(*expResult.toTypedArray()))
        }
    }
)
