package ooo.jtc.api.dictionaries.account

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.api.dictionaries.account.AccountPrepareSteps.getAccountDtoForUpdate
import ooo.jtc.api.dictionaries.account.AccountPrepareSteps.getDefaultAccountDtoForCreate
import ooo.jtc.asserts.assertObjectsEqual
import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.TestConstants.PARAM_USER
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
import ooo.jtc.dictionaries.account.AccountDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.generic.pageparams.toFilter
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.account.AccountData
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams
import ooo.jtc.testdata.dictionaries.account.AccountSortingParams
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.uaa.User
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.ACCOUNT}\" (account)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class AccountFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class AccountFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class AccountFolderFiltration
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class AccountFolderOther

@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY, Tm4jStoryAT.AT_STORY_COMMON_DICTIONARIES_CHANGES]) annotation class AccountTaskIdsCommon
//@formatter:on

@AccountTaskIdsCommon
@AccountFolderCrud
@ComponentDictionary
@HighPriority
class AccountCreateTest(
    user: User = bankAdmin
) : CreateTestTemplate<AccountDto>(
    preExecution = { getDefaultAccountDtoForCreate(user) },
    steps = AccountSteps(user),
    preCheckingHandlingExp = { it.toReducedDto() }
)

@AccountTaskIdsCommon
@AccountFolderCrud
@ComponentDictionary
@HighPriority
class AccountGetTest(user: User) :
    GetTestTemplate<AccountDto>(
        preExecution = {
            AccountData.getOrCreate(
                consumer = { AccountData.searchBy(user) },
                provider = { AccountPrepareSteps.createNewAccountForUser(user) }
            ).toDto()
        },
        steps = AccountSteps(user)
    )

@AccountTaskIdsCommon
@AccountFolderCrud
@ComponentDictionary
@HighPriority
class AccountGetPageTest(user: User) :
    GetPageTestTemplate<AccountDto>(
        steps = AccountSteps(user)
    )

@AccountTaskIdsCommon
@AccountFolderCrud
@ComponentDictionary
@HighPriority
class AccountUpdateTest(
    user: User = bankAdmin,
    private val accSteps: AccountSteps = AccountSteps(user)
) : UpdateTestTemplate<AccountDto, AccountDto>(
    preExecution = {
        val createdResponse = accSteps.create(getDefaultAccountDtoForCreate(user)).data!!
        val createdAccountDto = accSteps.getById(createdResponse.id!!).data!!
        getAccountDtoForUpdate(createdAccountDto)
    },
    steps = accSteps,
    preCheckingHandling = { it.toReducedDto() }
)

@AccountTaskIdsCommon
@AccountFolderCrud
@ComponentDictionary
@HighPriority
class AccountDeleteTest(
    user: User = bankAdmin,
    private val accSteps: AccountSteps = AccountSteps(user)
) : DeleteTestTemplate<AccountDto>(
    preExecution = {
        val createdResponse = accSteps.create(getDefaultAccountDtoForCreate(user)).data!!
        accSteps.getById(createdResponse.id!!).data!!
    },
    steps = accSteps,
    preCheckingHandling = { it.toReducedDto() }
)

@AccountTaskIdsCommon
@AccountFolderSorting
@ComponentDictionary
@LowPriority
class AccountSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>,
    additionalFilter: FilterData? = null
) : SortingTestTemplate<AccountDto, AccountSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = AccountSteps(user),
    clazz = AccountSortingParams::class.java,
    filter = additionalFilter?.toFilter()
)

@AccountTaskIdsCommon
@AccountFolderFiltration
@ComponentDictionary
@NormalPriority
class AccountFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> AccountDto)?,
    filterRequestFunction: (AccountDto?) -> FilterData
) : FiltrationTestTemplate<AccountDto, AccountFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = AccountSteps(user),
    clazz = AccountFilterParams::class.java,
    preExecution = preExecution
)


// -=| Additional tests |=-


@AccountTaskIdsCommon
@AccountFolderOther
@ComponentDictionary
@NormalPriority
class GetAccountBalanceTest(val user: User) :
    AbstractTest<AccountDto, AccountDto>(
        preExecution = {
            AccountData.getOrCreate(
                consumer = { AccountData.searchBy(user) },
                provider = { AccountPrepareSteps.createNewAccountForUser(user) }
            ).toDto()
        },
        postExecution = {}
    ) {
    private val accSteps = AccountSteps(user)

    override fun execution(preconditionResult: AccountDto?) {
        testResult = preconditionResult!!
        val relatedBranch = BranchData.get(false) { it.id!! == preconditionResult.branchId }.first()
        val expValue = preconditionResult.actualBalance

        val response = accSteps.getAccountBalance(preconditionResult.accountNumber, relatedBranch.paymentDetailsBic!!.bic!!, preconditionResult.customerId!!)

        "Проверить, что полученный баланс соответствует actualBalance рассматриваемого счёта" {
            assertThat("Ответ не получен", response.list, CoreMatchers.notNullValue())
            assertThat("Получен пустой ответ", response.list!!, Matchers.not(Matchers.empty()))
            val actValue = response.list!!.first()
            assertThat("Баланс не соответствует ожидамому", actValue, Matchers.equalTo(expValue))
        }
    }

    override fun name(): String = "'${DictionaryNames.ACCOUNT}'. Получить баланс счёта по его реквизитам [${user.userType}]"

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to user,
            PARAM_OBJECT_TYPE to accSteps.entityName,
            "Счёт" to preconditionResult!!
        )
    }
}

@AccountTaskIdsCommon
@AccountFolderOther
@ComponentDictionary
@NormalPriority
class GetAccountByAccInfoTest(val user: User) :
    AbstractTest<AccountDto, AccountDto>(
        preExecution = {
            AccountData.getOrCreate(
                consumer = { AccountData.searchBy(user) },
                provider = { AccountPrepareSteps.createNewAccountForUser(user) }
            ).toDto()
        },
        postExecution = {}
    ) {
    private val accSteps = AccountSteps(user)

    override fun execution(preconditionResult: AccountDto?) {
        testResult = preconditionResult!!
        val expValue = preconditionResult

        val response = accSteps.getByAccountNumber(preconditionResult.accountNumber, preconditionResult.branchId, preconditionResult.customerId)

        "Проверить, что полученный счёт соответствует ожидаемому" {
            assertThat("Ответ не получен", response.list, CoreMatchers.notNullValue())
            assertThat("Получен пустой ответ", response.list!!, Matchers.not(Matchers.empty()))
            val actValue = response.list!!.first()
            assertObjectsEqual(expValue, actValue)
        }
    }

    override fun name(): String = "'${DictionaryNames.ACCOUNT}'. Получить счёт по его реквизитам [${user.userType}]"

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to user,
            PARAM_OBJECT_TYPE to accSteps.entityName,
            "Счёт" to preconditionResult!!
        )
    }
}
