package ooo.jtc.api.dictionaries.accounttype

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.accounttype.AccountTypePrepareSteps.getAccountTypeDtoForCreate
import ooo.jtc.api.dictionaries.accounttype.AccountTypePrepareSteps.getAccountTypeDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.core.tm4j.Tm4jStoryAT.AT_STORY_COMMON_DICTIONARIES_CHANGES
import ooo.jtc.core.tm4j.Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY
import ooo.jtc.dictionaries.accountype.AccountTypeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.accounttype.AccountTypeData
import ooo.jtc.testdata.dictionaries.accounttype.AccountTypeFilterParams
import ooo.jtc.testdata.dictionaries.accounttype.AccountTypeSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.ACCOUNT_TYPE}\" (accountType)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class AccountTypeFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class AccountTypeFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class AccountTypeFolderFiltration
//Sergeyev [2021.03.16]: согласно постановке https://confluence.jtc.ooo/pages/viewpage.action?pageId=31262698 от 2020.12.28
// контроли в данной версии (релизе) не реализуются

@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY, AT_STORY_R_RKO_DICTIONARY, AT_STORY_COMMON_DICTIONARIES_CHANGES, "JTCSALTO-1114"])
annotation class AccountTypeTaskIdsCommon
//@formatter:on

@AccountTypeTaskIdsCommon
@AccountTypeFolderCrud
@ComponentDictionary
@HighPriority
class AccountTypeCreateTest(user: User = bankAdmin) :
    CreateTestTemplate<AccountTypeDto>(
        preExecution = { getAccountTypeDtoForCreate() },
        steps = AccountTypeSteps(user)
    )

@AccountTypeTaskIdsCommon
@AccountTypeFolderCrud
@ComponentDictionary
@HighPriority
class AccountTypeGetTest(user: User) :
    GetTestTemplate<AccountTypeDto>(
        preExecution = { AccountTypeData.randomOrException().toDto() },
        steps = AccountTypeSteps(user)
    )

@AccountTypeTaskIdsCommon
@AccountTypeFolderCrud
@ComponentDictionary
@HighPriority
class AccountTypeGetPageTest(user: User) :
    GetPageTestTemplate<AccountTypeDto>(
        steps = AccountTypeSteps(user)
    )


@AccountTypeTaskIdsCommon
@AccountTypeFolderCrud
@ComponentDictionary
@HighPriority
class AccountTypeDeleteTest(user: User = bankAdmin) :
    DeleteTestTemplate<AccountTypeDto>(
        preExecution = {
            val createdResponse = AccountTypeSteps(user).create(getAccountTypeDtoForCreate())
            createdResponse.data!!
        },
        steps = AccountTypeSteps(user)
    )

@AccountTypeTaskIdsCommon
@AccountTypeFolderCrud
@ComponentDictionary
@HighPriority
class AccountTypeUpdateTest(user: User = bankAdmin) :
    UpdateTestTemplate<AccountTypeDto, AccountTypeDto>(
        preExecution = {
            val createdDto = AccountTypeSteps(user).create(getAccountTypeDtoForCreate()).data!!
            getAccountTypeDtoForUpdate(createdDto)
        },
        steps = AccountTypeSteps(user)
    )

@AccountTypeTaskIdsCommon
@AccountTypeFolderSorting
@ComponentDictionary
@LowPriority
class AccountTypeSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<AccountTypeDto, AccountTypeSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = AccountTypeSteps(user),
    clazz = AccountTypeSortingParams::class.java
)

@AccountTypeTaskIdsCommon
@AccountTypeFolderFiltration
@ComponentDictionary
@NormalPriority
class AccountTypeFilterTests(
    name: String,
    user: User,
    preExecution: (() -> AccountTypeDto)?,
    filterRequestFunction: (AccountTypeDto?) -> FilterData
) : FiltrationTestTemplate<AccountTypeDto, AccountTypeFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = AccountTypeSteps(user),
    clazz = AccountTypeFilterParams::class.java,
    preExecution = preExecution
)