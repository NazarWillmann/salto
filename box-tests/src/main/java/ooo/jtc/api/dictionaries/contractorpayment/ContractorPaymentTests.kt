package ooo.jtc.api.dictionaries.contractorpayment

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.contractorpayment.ContractorPaymentPrepareSteps.createContractorPaymentDto
import ooo.jtc.api.dictionaries.contractorpayment.ContractorPaymentPrepareSteps.getContractorPaymentDtoForCreate
import ooo.jtc.api.dictionaries.contractorpayment.ContractorPaymentPrepareSteps.getContractorPaymentDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.dictionaries.contractorpayment.ContractorPaymentDto
import ooo.jtc.dictionaries.contractorpayment.ContractorPaymentUpdateRequest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.dictionaries.contractorpayment.ContractorPaymentData
import ooo.jtc.testdata.dictionaries.contractorpayment.ContractorPaymentFilterParams
import ooo.jtc.testdata.dictionaries.contractorpayment.ContractorPaymentSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.CONTRACTOR_PAYMENT}\" (contractorPayment)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class ContractorPaymentFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class ContractorPaymentFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class ContractorPaymentFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class ContractorPaymentFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class ContractorPaymentFolderOther

@TaskIds([Tm4jEpic.EPIC_R_RKO_CONTRACTOR,"JTCSALTO-836",Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1137"]) annotation class ContractorPaymentTaskIdsCommon
//@formatter:on

@ContractorPaymentTaskIdsCommon
@ContractorPaymentFolderCrud
@ComponentDictionary
@HighPriority
class ContractorPaymentCreateTest(user: User) :
    CreateTestTemplate<ContractorPaymentDto>(
        preExecution = { getContractorPaymentDtoForCreate(user) },
        steps = ContractorPaymentSteps(user)
    )

@ContractorPaymentTaskIdsCommon
@ContractorPaymentFolderCrud
@ComponentDictionary
@HighPriority
class ContractorPaymentGetTest(user: User) :
    GetTestTemplate<ContractorPaymentDto>(
        preExecution = {
            ContractorPaymentData.getOrCreate(
                consumer = { ContractorPaymentData.searchBy(user) },
                provider = { createContractorPaymentDto(user).toModel() }
            ).toDto()
        },
        steps = ContractorPaymentSteps(user)
    )

@ContractorPaymentTaskIdsCommon
@ContractorPaymentFolderCrud
@ComponentDictionary
@HighPriority
class ContractorPaymentGetPageTest(user: User) :
    GetPageTestTemplate<ContractorPaymentDto>(
        steps = ContractorPaymentSteps(user)
    )

@ContractorPaymentTaskIdsCommon
@ContractorPaymentFolderCrud
@ComponentDictionary
@HighPriority
class ContractorPaymentDeleteTest(user: User) :
    DeleteTestTemplate<ContractorPaymentDto>(
        preExecution = {
            createContractorPaymentDto(user)
        },
        steps = ContractorPaymentSteps(user)
    )

@ContractorPaymentTaskIdsCommon
@ContractorPaymentFolderCrud
@ComponentDictionary
@HighPriority
class ContractorPaymentUpdateTest(user: User) :
    UpdateTestTemplate<ContractorPaymentDto, ContractorPaymentUpdateRequest>(
        preExecution = {
            val createdDto = createContractorPaymentDto(user)
            getContractorPaymentDtoForUpdate(createdDto)
        },
        steps = ContractorPaymentSteps(user)
    )


@ContractorPaymentTaskIdsCommon
@ContractorPaymentFolderSorting
@ComponentDictionary
@LowPriority
class ContractorPaymentSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<ContractorPaymentDto, ContractorPaymentSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = ContractorPaymentSteps(user),
    clazz = ContractorPaymentSortingParams::class.java
)

@ContractorPaymentTaskIdsCommon
@ContractorPaymentFolderFiltration
@ComponentDictionary
@NormalPriority
class ContractorPaymentFiltrationTests(
    name: String,
    user: User,
    preExecution: (() -> ContractorPaymentDto)?,
    filterRequestFunction: (ContractorPaymentDto?) -> FilterData
) : FiltrationTestTemplate<ContractorPaymentDto, ContractorPaymentFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = ContractorPaymentSteps(user),
    clazz = ContractorPaymentFilterParams::class.java,
    preExecution = preExecution
)