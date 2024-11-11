package ooo.jtc.api.dictionaries.contractorcontact

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.contractorcontact.ContractorContactPrepareSteps.getContractorContactDtoForCreate
import ooo.jtc.api.dictionaries.contractorcontact.ContractorContactPrepareSteps.getContractorContactDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.dictionaries.contractorcontact.ContractorContactDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.dictionaries.contractorcontact.ContractorContactData
import ooo.jtc.testdata.dictionaries.contractorcontact.ContractorContactFilterParams
import ooo.jtc.testdata.dictionaries.contractorcontact.ContractorContactSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.CONTRACTOR_CONTACT}\" (contractorContact)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class ContractorContactFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class ContractorContactFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class ContractorContactFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class ContractorContactFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class ContractorContactFolderOther

@TaskIds([Tm4jEpic.EPIC_R_RKO_CONTRACTOR,"JTCSALTO-837",Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1136"]) annotation class ContractorContactTaskIdsCommon
//@formatter:on

@ContractorContactTaskIdsCommon
@ContractorContactFolderCrud
@ComponentDictionary
@HighPriority
class ContractorContactCreateTest(user: User) :
    CreateTestTemplate<ContractorContactDto>(
        preExecution = { getContractorContactDtoForCreate(user) },
        steps = ContractorContactSteps(user)
    )

@ContractorContactTaskIdsCommon
@ContractorContactFolderCrud
@ComponentDictionary
@HighPriority
class ContractorContactGetTest(user: User) :
    GetTestTemplate<ContractorContactDto>(
        preExecution = {
            ContractorContactData.getOrCreate(
                consumer = { ContractorContactData.searchBy(user) },
                provider = {
                    ContractorContactPrepareSteps.createContractorContactDto(user).toModel()
                }
            ).toDto()
        },
        steps = ContractorContactSteps(user)
    )

@ContractorContactTaskIdsCommon
@ContractorContactFolderCrud
@ComponentDictionary
@HighPriority
class ContractorContactGetPageTest(user: User) :
    GetPageTestTemplate<ContractorContactDto>(
        steps = ContractorContactSteps(user)
    )

@ContractorContactTaskIdsCommon
@ContractorContactFolderCrud
@ComponentDictionary
@HighPriority
class ContractorContactDeleteTest(user: User) :
    DeleteTestTemplate<ContractorContactDto>(
        preExecution = { ContractorContactPrepareSteps.createContractorContactDto(user) },
        steps = ContractorContactSteps(user)
    )

@ContractorContactTaskIdsCommon
@ContractorContactFolderCrud
@ComponentDictionary
@HighPriority
class ContractorContactUpdateTest(user: User) :
    UpdateTestTemplate<ContractorContactDto, ContractorContactDto>(
        preExecution = {
            val createdDto = ContractorContactPrepareSteps.createContractorContactDto(user)
            getContractorContactDtoForUpdate(createdDto)
        },
        steps = ContractorContactSteps(user)
    )


@ContractorContactTaskIdsCommon
@ContractorContactFolderSorting
@ComponentDictionary
@LowPriority
class ContractorContactSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<ContractorContactDto, ContractorContactSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = ContractorContactSteps(user),
    clazz = ContractorContactSortingParams::class.java
)

@ContractorContactTaskIdsCommon
@ContractorContactFolderFiltration
@ComponentDictionary
@NormalPriority
class ContractorContactFiltrationTests(
    name: String,
    user: User,
    preExecution: (() -> ContractorContactDto)?,
    filterRequestFunction: (ContractorContactDto?) -> FilterData
) : FiltrationTestTemplate<ContractorContactDto, ContractorContactFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = ContractorContactSteps(user),
    clazz = ContractorContactFilterParams::class.java,
    preExecution = preExecution
)