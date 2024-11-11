package ooo.jtc.api.dictionaries.gozcontract

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.dictionaries.gozcontract.GozContractDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.gozcontract.GozContractData
import ooo.jtc.testdata.dictionaries.gozcontract.GozContractFilterParams
import ooo.jtc.testdata.dictionaries.gozcontract.GozContractSortingParams
import ooo.jtc.uaa.User

// @formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.GOZ_CONTRACT}\" (gozcontract)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class GozContractFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class GozContractFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class GozContractFolderFiltration

@TaskIds([/*Tm4jEpic.EPIC_R_RKO_DICTIONARY, Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,*/"JTC-240"]) annotation class GozContractTaskIdsCommon
// @formatter:on

@GozContractTaskIdsCommon
@GozContractFolderCrud
@ComponentDictionary
@HighPriority
class GozContractCreateTest(user: User = Users.bankAdmin) :
    CreateTestTemplate<GozContractDto>(
        preExecution = { GozContractPrepareSteps.getGozContractDtoForCreate() },
        steps = GozContractSteps(user)
    )

@GozContractTaskIdsCommon
@GozContractFolderCrud
@ComponentDictionary
@HighPriority
class GozContractGetTest(user: User) :
    GetTestTemplate<GozContractDto>(
        preExecution = { GozContractData.randomOrException(fromCache = false).toDto() },
        steps = GozContractSteps(user)
    )

@GozContractTaskIdsCommon
@GozContractFolderCrud
@ComponentDictionary
@HighPriority
class GozContractGetPageTest(user: User) :
    GetPageTestTemplate<GozContractDto>(
        steps = GozContractSteps(user)
    )

@GozContractTaskIdsCommon
@GozContractFolderCrud
@ComponentDictionary
@HighPriority
class GozContractDeleteTest(user: User = Users.bankAdmin) :
    DeleteTestTemplate<GozContractDto>(
        preExecution = { GozContractSteps(user).create(GozContractPrepareSteps.getGozContractDtoForCreate()).data!! },
        steps = GozContractSteps(user)
    )

@GozContractTaskIdsCommon
@GozContractFolderCrud
@ComponentDictionary
@HighPriority
class GozContractUpdateTest(user: User = Users.bankAdmin) :
    UpdateTestTemplate<GozContractDto, GozContractDto>(
        preExecution = {
            val initialDto = GozContractSteps(user).create(GozContractPrepareSteps.getGozContractDtoForCreate()).data!!

            val updatedDto = GozContractPrepareSteps.getGozContractDtoForCreate()
            updatedDto.id = initialDto.id
            updatedDto.version = initialDto.version
            updatedDto.date = initialDto.date.plusDays(1)
            updatedDto.contractDate = initialDto.contractDate?.minusDays(1)

            updatedDto
        },
        steps = GozContractSteps(user)
    )

@GozContractTaskIdsCommon
@GozContractFolderSorting
@ComponentDictionary
@LowPriority
class GozContractSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<GozContractDto, GozContractSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = GozContractSteps(user),
    clazz = GozContractSortingParams::class.java
)

@GozContractTaskIdsCommon
@GozContractFolderFiltration
@ComponentDictionary
@NormalPriority
class GozContractFilterTests(
    name: String,
    user: User,
    preExecution: (() -> GozContractDto)?,
    filterRequestFunction: (GozContractDto?) -> FilterData
) : FiltrationTestTemplate<GozContractDto, GozContractFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = GozContractSteps(user),
    clazz = GozContractFilterParams::class.java,
    preExecution = preExecution
)