package ooo.jtc.api.dictionaries.bankru

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.bankru.BankRuPrepareSteps.getBankRuDtoForUpdate
import ooo.jtc.api.dictionaries.bankru.BankRuPrepareSteps.getValidBankRuDtoForCreate
import ooo.jtc.core.tm4j.*
import ooo.jtc.dictionaries.bankru.BankRuDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.bankru.BankRuData
import ooo.jtc.testdata.dictionaries.bankru.BankRuFilterParams
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.BANK_RU}\" (bankRu)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class BankRuFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class BankRuFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class BankRuFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class BankRuFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class BankRuFolderOther

@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY,Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1118"]) annotation class BankRuTaskIdsCommon
//@formatter:on

@BankRuTaskIdsCommon
@BankRuFolderCrud
@ComponentDictionary
@HighPriority
class BankRuCreateTest(user: User = bankAdmin) :
    CreateTestTemplate<BankRuDto>(
        preExecution = { getValidBankRuDtoForCreate() },
        steps = BankRuSteps(user)
    )

@BankRuTaskIdsCommon
@BankRuFolderCrud
@ComponentDictionary
@HighPriority
class BankRuGetTest(user: User) :
    GetTestTemplate<BankRuDto>(
        preExecution = { BankRuData.randomOrException().toDto() },
        steps = BankRuSteps(user)
    )

@BankRuTaskIdsCommon
@BankRuFolderCrud
@ComponentDictionary
@HighPriority
class BankRuGetPageTest(user: User) :
    GetPageTestTemplate<BankRuDto>(
        steps = BankRuSteps(user)
    )

@BankRuTaskIdsCommon
@BankRuFolderCrud
@ComponentDictionary
@HighPriority
class BankRuDeleteTest(user: User = bankAdmin) :
    DeleteTestTemplate<BankRuDto>(
        preExecution = {
            val createdResponse = BankRuSteps(user).create(getValidBankRuDtoForCreate())
            createdResponse.data!!
        },
        steps = BankRuSteps(user)
    )

@BankRuTaskIdsCommon
@BankRuFolderCrud
@ComponentDictionary
@HighPriority
class BankRuUpdateTest(user: User = bankAdmin) :
    UpdateTestTemplate<BankRuDto, BankRuDto>(
        preExecution = {
            val createdDto = BankRuSteps(user).create(getValidBankRuDtoForCreate()).data!!
            getBankRuDtoForUpdate(createdDto)
        },
        steps = BankRuSteps(user)
    )

@BankRuTaskIdsCommon
@BankRuFolderSorting
@ComponentDictionary
@LowPriority
class BankRuSortingTest(
    user: User = bankAdmin,
    sortRequestFunction: () -> List<Sort>,
    limit: Int
) : SortingTestTemplate<BankRuDto, BankRuSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = BankRuSteps(user),
    clazz = BankRuSortingParams::class.java,
    limit = limit
)

@BankRuTaskIdsCommon
@BankRuFolderFiltration
@ComponentDictionary
@NormalPriority
class BankRuFiltrationTest(
    name: String,
    user: User = bankAdmin,
    preExecution: (() -> BankRuDto)?,
    filterRequestFunction: (BankRuDto?) -> FilterData
) : FiltrationTestTemplate<BankRuDto, BankRuFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = BankRuSteps(user),
    clazz = BankRuFilterParams::class.java,
    preExecution = preExecution
)

