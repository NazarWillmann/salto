package ooo.jtc.api.dictionaries.bankinfo

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.dictionaries.bankinfo.BankInfoPrepareSteps.deleteBankInfoAndRelatedEntities
import ooo.jtc.api.dictionaries.bankinfo.BankInfoPrepareSteps.getBankInfoDtoForCreate
import ooo.jtc.api.dictionaries.bankinfo.BankInfoPrepareSteps.getBankInfoDtoForUpdate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jStoryAT
import ooo.jtc.dictionaries.bankinfo.BankInfoDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.generic.pageparams.toFilter
import ooo.jtc.testdata.Users.superUser
import ooo.jtc.testdata.dictionaries.bankinfo.BankInfoData
import ooo.jtc.testdata.dictionaries.bankinfo.BankInfoFilterParams
import ooo.jtc.testdata.dictionaries.bankinfo.BankInfoSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.BANK_INFO}\" (bankInfo)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class BankInfoFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class BankInfoFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class BankInfoFolderFiltration

@TaskIds([Tm4jStoryAT.AT_STORY_COMMON_DICTIONARIES_CHANGES]) annotation class BankInfoTaskIdsCommon
//@formatter:on

@BankInfoTaskIdsCommon
@BankInfoFolderCrud
@ComponentDictionary
@HighPriority
class BankInfoCreateTest(
    bankUser: User = superUser
) : CreateTestTemplate<BankInfoDto>(
    preExecution = { getBankInfoDtoForCreate() },
    steps = BankInfoSteps(bankUser),
    preCheckingHandlingAct = { it.apply { logoAccessToken = null } },
    testPostExecution = { deleteBankInfoAndRelatedEntities(it.id!!) }
)

@BankInfoTaskIdsCommon
@BankInfoFolderCrud
@ComponentDictionary
@HighPriority
class BankInfoGetTest(user: User) :
    GetTestTemplate<BankInfoDto>(
        preExecution = { BankInfoData.searchBy(user).random().toDto() },
        steps = BankInfoSteps(user)
    )

@BankInfoTaskIdsCommon
@BankInfoFolderCrud
@ComponentDictionary
@HighPriority
class BankInfoGetPageTest(user: User) :
    GetPageTestTemplate<BankInfoDto>(
        steps = BankInfoSteps(user)
    )

@BankInfoTaskIdsCommon
@BankInfoFolderCrud
@ComponentDictionary
@HighPriority
class BankInfoUpdateTest(
    bankUser: User = superUser
) : UpdateTestTemplate<BankInfoDto, BankInfoDto>(
    preExecution = {
        val createdBankInfoDto = BankInfoPrepareSteps.createBankInfoWithBankRepresentative(bankUser)
        getBankInfoDtoForUpdate(createdBankInfoDto)
    },
    steps = BankInfoSteps(bankUser),
    preCheckingHandling = { createdBankInfoDto ->
        createdBankInfoDto.apply {
            logoAccessToken = null
            phoneSupports?.forEach { it.id = null }
            applicationUrls?.forEach { it.id = null }
            socialUrls?.forEach { it.id = null }
        }
    },
    postExecution = { deleteBankInfoAndRelatedEntities(it.id!!) }
)

@BankInfoTaskIdsCommon
@BankInfoFolderCrud
@ComponentDictionary
@HighPriority
class BankInfoDeleteTest(
    bankUser: User = superUser
) : DeleteTestTemplate<BankInfoDto>(
    preExecution = { BankInfoPrepareSteps.createBankInfoWithBankRepresentative(bankUser) },
    steps = BankInfoSteps(bankUser),
    preCheckingHandling = {
        it.apply {
            logoAccessToken = null
            phoneSupports = null
            applicationUrls = null
            socialUrls = null
        }
    }
)

@BankInfoTaskIdsCommon
@BankInfoFolderSorting
@ComponentDictionary
@LowPriority
class BankInfoSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>,
    additionalFilter: FilterData? = null
) : SortingTestTemplate<BankInfoDto, BankInfoSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = BankInfoSteps(user),
    clazz = BankInfoSortingParams::class.java,
    filter = additionalFilter?.toFilter()
)

@BankInfoTaskIdsCommon
@BankInfoFolderFiltration
@ComponentDictionary
@NormalPriority
class BankInfoFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> BankInfoDto)?,
    filterRequestFunction: (BankInfoDto?) -> FilterData
) : FiltrationTestTemplate<BankInfoDto, BankInfoFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = BankInfoSteps(user),
    clazz = BankInfoFilterParams::class.java,
    preExecution = preExecution
)
