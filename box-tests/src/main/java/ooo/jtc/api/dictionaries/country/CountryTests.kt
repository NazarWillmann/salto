package ooo.jtc.api.dictionaries.country

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.country.CountryPrepareSteps.getCountryDtoForCreate
import ooo.jtc.api.dictionaries.country.CountryPrepareSteps.getCountryDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.dictionaries.country.CountryDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.country.CountryControls
import ooo.jtc.testdata.dictionaries.country.CountryData
import ooo.jtc.testdata.dictionaries.country.CountryFilterParams
import ooo.jtc.testdata.dictionaries.country.CountrySortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.COUNTRY}\" (country)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class CountryFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class CountryFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class CountryFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class CountryFolderControls

@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY,Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1139"]) annotation class CountryTaskIdsCommon
//@formatter:on

@CountryTaskIdsCommon
@CountryFolderCrud
@ComponentDictionary
@HighPriority
class CountryCreateTest(user: User = bankAdmin) :
    CreateTestTemplate<CountryDto>(
        preExecution = { getCountryDtoForCreate() },
        testPostExecution = { CountryPrepareSteps.retrieveUsedCodes(it) },
        steps = CountrySteps(user)
    )

@CountryTaskIdsCommon
@CountryFolderCrud
@ComponentDictionary
@HighPriority
class CountryGetTest(user: User) :
    GetTestTemplate<CountryDto>(
        preExecution = { CountryData.randomOrException().toDto() },
        steps = CountrySteps(user)
    )

@CountryTaskIdsCommon
@CountryFolderCrud
@ComponentDictionary
@HighPriority
class CountryGetPageTest(user: User) :
    GetPageTestTemplate<CountryDto>(
        steps = CountrySteps(user)
    )

@CountryTaskIdsCommon
@CountryFolderCrud
@ComponentDictionary
@HighPriority
class CountryDeleteTest(user: User = bankAdmin) :
    DeleteTestTemplate<CountryDto>(
        preExecution = {
            val createdResponse = CountrySteps(user).create(getCountryDtoForCreate())
            createdResponse.data!!
        },
        postExecution = { CountryPrepareSteps.retrieveUsedCodes(it) },
        steps = CountrySteps(user)
    )

@CountryTaskIdsCommon
@CountryFolderCrud
@ComponentDictionary
@HighPriority
class CountryUpdateTest(user: User = bankAdmin) :
    UpdateTestTemplate<CountryDto, CountryDto>(
        preExecution = {
            val createdDto = CountrySteps(user).create(getCountryDtoForCreate()).data!!
            getCountryDtoForUpdate(createdDto)
        },
        postExecution = { CountryPrepareSteps.retrieveUsedCodes(it) },
        testPostExecution = { CountryPrepareSteps.retrieveUsedCodes(it) },
        steps = CountrySteps(user)
    )

@CountryTaskIdsCommon
@CountryFolderSorting
@ComponentDictionary
@LowPriority
class CountrySortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<CountryDto, CountrySortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = CountrySteps(user),
    clazz = CountrySortingParams::class.java
)

@CountryTaskIdsCommon
@CountryFolderFiltration
@ComponentDictionary
@NormalPriority
class CountryFiltrationTests(
    name: String,
    user: User,
    preExecution: (() -> CountryDto)?,
    filterRequestFunction: (CountryDto?) -> FilterData
) : FiltrationTestTemplate<CountryDto, CountryFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = CountrySteps(user),
    clazz = CountryFilterParams::class.java,
    preExecution = preExecution
)

@CountryTaskIdsCommon
@CountryFolderControls
@ComponentDictionary
@HighPriority
class CountryControlTest(
    testName: String,
    preExecution: (() -> CountryDto)?,
    postExecution: ((CountryDto) -> Unit)? = { CountryPrepareSteps.retrieveUsedCodes(it) },
    control: CountryControls,
    steps: CountrySteps = CountrySteps(bankAdmin)
) : ControlTestTemplate<CountryDto>(
    testName = testName,
    control = control,
    preExecution = preExecution,
    postExecution = postExecution,
    steps = steps
)