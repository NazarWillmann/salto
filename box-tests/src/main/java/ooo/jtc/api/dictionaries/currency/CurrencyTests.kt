package ooo.jtc.api.dictionaries.currency

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.currency.CurrencyPrepareSteps.getCurrencyDtoForCreate
import ooo.jtc.api.dictionaries.currency.CurrencyPrepareSteps.getCurrencyDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.dictionaries.currency.CurrencyDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.currency.CurrencyData
import ooo.jtc.testdata.dictionaries.currency.CurrencyFilterParams
import ooo.jtc.testdata.dictionaries.currency.CurrencySortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.CURRENCY}\" (currency)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class CurrencyFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class CurrencyFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class CurrencyFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class CurrencyFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class CurrencyFolderOther

@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY,"JTCSALTO-354",Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1140"]) annotation class CurrencyTaskIdsCommon
//@formatter:on

@CurrencyTaskIdsCommon
@CurrencyFolderCrud
@ComponentDictionary
@HighPriority
class CurrencyCreateTest(user: User = bankAdmin) :
    CreateTestTemplate<CurrencyDto>(
        preExecution = { getCurrencyDtoForCreate() },
        steps = CurrencySteps(user)
    )

@CurrencyTaskIdsCommon
@CurrencyFolderCrud
@ComponentDictionary
@HighPriority
class CurrencyGetTest(user: User) :
    GetTestTemplate<CurrencyDto>(
        preExecution = { CurrencyData.randomOrException().toDto() },
        steps = CurrencySteps(user)
    )

@CurrencyTaskIdsCommon
@CurrencyFolderCrud
@ComponentDictionary
@HighPriority
class CurrencyGetPageTest(user: User) :
    GetPageTestTemplate<CurrencyDto>(
        steps = CurrencySteps(user)
    )

@CurrencyTaskIdsCommon
@CurrencyFolderCrud
@ComponentDictionary
@HighPriority
class CurrencyDeleteTest(user: User = bankAdmin) :
    DeleteTestTemplate<CurrencyDto>(
        preExecution = {
            val createdResponse = CurrencySteps(user).create(getCurrencyDtoForCreate())
            createdResponse.data!!
        },
        steps = CurrencySteps(user)
    )

@CurrencyTaskIdsCommon
@CurrencyFolderCrud
@ComponentDictionary
@HighPriority
class CurrencyUpdateTest(user: User = bankAdmin) :
    UpdateTestTemplate<CurrencyDto, CurrencyDto>(
        preExecution = {
            val createdDto = CurrencySteps(user).create(getCurrencyDtoForCreate()).data!!
            getCurrencyDtoForUpdate(createdDto)
        },
        steps = CurrencySteps(user)
    )


@CurrencyTaskIdsCommon
@CurrencyFolderSorting
@ComponentDictionary
@LowPriority
class CurrencySortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<CurrencyDto, CurrencySortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = CurrencySteps(user),
    clazz = CurrencySortingParams::class.java
)

@CurrencyTaskIdsCommon
@CurrencyFolderFiltration
@ComponentDictionary
@NormalPriority
class CurrencyFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> CurrencyDto)?,
    filterRequestFunction: (CurrencyDto?) -> FilterData
) : FiltrationTestTemplate<CurrencyDto, CurrencyFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = CurrencySteps(user),
    clazz = CurrencyFilterParams::class.java,
    preExecution = preExecution
)