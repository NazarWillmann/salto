package ooo.jtc.api.dictionaries.bankrepresentative

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.bankinfo.BankInfoPrepareSteps
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativePrepareSteps.getBankRepresentativeDtoForCreate
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativePrepareSteps.getBankRepresentativeDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.dictionaries.bankrepresentative.BankRepresentativeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeData
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeFilterParams
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.BANK_REPRESENTATIVE}\" (bankRepresentative)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class BankRepresentativeFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class BankRepresentativeFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class BankRepresentativeFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class BankRepresentativeFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class BankRepresentativeFolderOther

@TaskIds([Tm4jStoryAT.AT_STORY_COMMON_DICTIONARIES_CHANGES]) annotation class BankRepresentativeTaskIdsCommon
//@formatter:on

@BankRepresentativeTaskIdsCommon
@BankRepresentativeFolderCrud
@ComponentDictionary
@HighPriority
class BankRepresentativeCreateTest(
    runTestAsUser: User,
    createEntityForUser: User
) : CreateTestTemplate<BankRepresentativeDto>(
    preExecution = {
        val newBank = BankInfoPrepareSteps.createBankInfoDto()
        getBankRepresentativeDtoForCreate(
            uaaUserId = createEntityForUser.uaaUserId!!,
            bankId = newBank.id!!
        )
    },
    steps = BankRepresentativeSteps(runTestAsUser),
    postExecution = { BankInfoPrepareSteps.deleteBankInfoAndRelatedEntities(it.bankId!!) },
    testPostExecution = null
)

@BankRepresentativeTaskIdsCommon
@BankRepresentativeFolderCrud
@ComponentDictionary
@HighPriority
class BankRepresentativeGetTest(user: User) :
    GetTestTemplate<BankRepresentativeDto>(
        preExecution = { BankRepresentativeData.searchBy(user).filter { !it.isBlock }.random().toDto() },
        steps = BankRepresentativeSteps(user)
    )

@BankRepresentativeTaskIdsCommon
@BankRepresentativeFolderCrud
@ComponentDictionary
@HighPriority
class BankRepresentativeGetPageTest(user: User) :
    GetPageTestTemplate<BankRepresentativeDto>(
        steps = BankRepresentativeSteps(user)
    )

@BankRepresentativeTaskIdsCommon
@BankRepresentativeFolderCrud
@ComponentDictionary
@HighPriority
class BankRepresentativeDeleteTest(
    runTestAsUser: User,
    createEntityForUser: User
): DeleteTestTemplate<BankRepresentativeDto>(
    preExecution = {
        val newBank = BankInfoPrepareSteps.createBankInfoDto()
        val newBankRepres = getBankRepresentativeDtoForCreate(
            uaaUserId = createEntityForUser.uaaUserId!!,
            bankId = newBank.id!!
        )
        val createdResponse = BankRepresentativeSteps(runTestAsUser).create(newBankRepres)
        createdResponse.data!!
    },
    steps = BankRepresentativeSteps(runTestAsUser),
    postExecution = { BankInfoPrepareSteps.deleteBankInfoAndRelatedEntities(it.bankId!!) }
)

@BankRepresentativeTaskIdsCommon
@BankRepresentativeFolderCrud
@ComponentDictionary
@HighPriority
class BankRepresentativeUpdateTest(
    runTestAsUser: User,
    createEntityForUser: User
) : UpdateTestTemplate<BankRepresentativeDto, BankRepresentativeDto>(
    preExecution = {
        val newBank = BankInfoPrepareSteps.createBankInfoDto()
        val bankRepresentativeDto = getBankRepresentativeDtoForCreate(
            uaaUserId = createEntityForUser.uaaUserId!!,
            bankId = newBank.id!!
        )
        val createdDto = BankRepresentativeSteps(runTestAsUser).create(bankRepresentativeDto).data!!
        getBankRepresentativeDtoForUpdate(createdDto)
    },
    postExecution = { BankInfoPrepareSteps.deleteBankInfoAndRelatedEntities(it.bankId!!) },
    steps = BankRepresentativeSteps(runTestAsUser)
)


@BankRepresentativeTaskIdsCommon
@BankRepresentativeFolderSorting
@ComponentDictionary
@LowPriority
class BankRepresentativeSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<BankRepresentativeDto, BankRepresentativeSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = BankRepresentativeSteps(user),
    clazz = BankRepresentativeSortingParams::class.java
)

@BankRepresentativeTaskIdsCommon
@BankRepresentativeFolderFiltration
@ComponentDictionary
@NormalPriority
class BankRepresentativeFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> BankRepresentativeDto)?,
    filterRequestFunction: (BankRepresentativeDto?) -> FilterData
) : FiltrationTestTemplate<BankRepresentativeDto, BankRepresentativeFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = BankRepresentativeSteps(user),
    clazz = BankRepresentativeFilterParams::class.java,
    preExecution = preExecution
)

@BankRepresentativeTaskIdsCommon
@BankRepresentativeFolderOther
@ComponentDictionary
@NormalPriority
class BankRepresentativeBlockingTest(
    runTestAsUser: User,
    createEntityForUser: User
) : BlockingTestTemplate<BankRepresentativeDto>(
    steps = BankRepresentativeSteps(runTestAsUser),
    preExecution = {
        val newBank = BankInfoPrepareSteps.createBankInfoDto()
        val branchRepresForCreate = getBankRepresentativeDtoForCreate(uaaUserId = createEntityForUser.uaaUserId!!, bankId = newBank.id!!)
        BankRepresentativePrepareSteps.createBankRepresentativeDto(branchRepresForCreate)
    },
    postExecution = { BankInfoPrepareSteps.deleteBankInfoAndRelatedEntities(it.bankId!!) }
)

@BankRepresentativeTaskIdsCommon
@BankRepresentativeFolderOther
@ComponentDictionary
@NormalPriority
class BankRepresentativeUnblockingTest(
    runTestAsUser: User,
    createEntityForUser: User
) : UnblockingTestTemplate<BankRepresentativeDto>(
    steps = BankRepresentativeSteps(runTestAsUser),
    preExecution = {
        val newBank = BankInfoPrepareSteps.createBankInfoDto()
        val branchRepresForCreate = getBankRepresentativeDtoForCreate(uaaUserId = createEntityForUser.uaaUserId!!, bankId = newBank.id!!)
        BankRepresentativePrepareSteps.createBlockedBankRepresentativeDto(branchRepresForCreate)
    },
    postExecution = { BankInfoPrepareSteps.deleteBankInfoAndRelatedEntities(it.bankId!!) }
)