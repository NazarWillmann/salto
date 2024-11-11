package ooo.jtc.api.dictionaries.locationtype

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.locationtype.LocationTypePrepareSteps.getLocationTypeDtoForCreate
import ooo.jtc.api.dictionaries.locationtype.LocationTypePrepareSteps.getLocationTypeDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.dictionaries.locationtype.LocationTypeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.locationtype.LocationTypeData
import ooo.jtc.testdata.dictionaries.locationtype.LocationTypeFilterParams
import ooo.jtc.testdata.dictionaries.locationtype.LocationTypeSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.LOCATION_TYPE}\" (locationType)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class LocationTypeFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class LocationTypeFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class LocationTypeFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class LocationTypeFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class LocationTypeFolderOther

@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY,Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1146"]) annotation class LocationTypeTaskIdsCommon
//@formatter:on

@LocationTypeTaskIdsCommon
@LocationTypeFolderCrud
@ComponentDictionary
@HighPriority
class LocationTypeCreateTest(user: User = bankAdmin) :
    CreateTestTemplate<LocationTypeDto>(
        preExecution = { getLocationTypeDtoForCreate() },
        steps = LocationTypeSteps(user)
    )

@LocationTypeTaskIdsCommon
@LocationTypeFolderCrud
@ComponentDictionary
@HighPriority
class LocationTypeGetTest(user: User) :
    GetTestTemplate<LocationTypeDto>(
        preExecution = { LocationTypeData.randomOrException().toDto() },
        steps = LocationTypeSteps(user)
    )

@LocationTypeTaskIdsCommon
@LocationTypeFolderCrud
@ComponentDictionary
@HighPriority
class LocationTypeGetPageTest(user: User) :
    GetPageTestTemplate<LocationTypeDto>(
        steps = LocationTypeSteps(user)
    )

@LocationTypeTaskIdsCommon
@LocationTypeFolderCrud
@ComponentDictionary
@HighPriority
class LocationTypeDeleteTest(user: User = bankAdmin) :
    DeleteTestTemplate<LocationTypeDto>(
        preExecution = {
            val createdResponse = LocationTypeSteps(user).create(getLocationTypeDtoForCreate())
            createdResponse.data!!
        },
        steps = LocationTypeSteps(user)
    )

@LocationTypeTaskIdsCommon
@LocationTypeFolderCrud
@ComponentDictionary
@HighPriority
class LocationTypeUpdateTest(user: User = bankAdmin) :
    UpdateTestTemplate<LocationTypeDto, LocationTypeDto>(
        preExecution = {
            val createdDto = LocationTypeSteps(user).create(getLocationTypeDtoForCreate()).data!!
            getLocationTypeDtoForUpdate(createdDto)
        },
        steps = LocationTypeSteps(user)
    )

@LocationTypeTaskIdsCommon
@LocationTypeFolderSorting
@ComponentDictionary
@LowPriority
class LocationTypeSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<LocationTypeDto, LocationTypeSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = LocationTypeSteps(user),
    clazz = LocationTypeSortingParams::class.java
)

@LocationTypeTaskIdsCommon
@LocationTypeFolderFiltration
@ComponentDictionary
@NormalPriority
class LocationTypeFilterTests(
    name: String,
    user: User,
    preExecution: (() -> LocationTypeDto)?,
    filterRequestFunction: (LocationTypeDto?) -> FilterData
) : FiltrationTestTemplate<LocationTypeDto, LocationTypeFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = LocationTypeSteps(user),
    clazz = LocationTypeFilterParams::class.java,
    preExecution = preExecution
)