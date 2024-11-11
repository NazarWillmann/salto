package ooo.jtc.api.uaa.tests

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.uaa.prepare.PrepareCatalogData.getCatalogDtoForUpdate
import ooo.jtc.api.uaa.prepare.PrepareCatalogData.prepareCatalogDtoForCreate
import ooo.jtc.api.uaa.steps.CatalogSteps
import ooo.jtc.core.tm4j.*
import ooo.jtc.generic.UaaNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.uaa.catalog.CatalogData
import ooo.jtc.testdata.uaa.catalog.CatalogFilterParams
import ooo.jtc.testdata.uaa.catalog.CatalogSortingParams
import ooo.jtc.uaa.catalog.dto.CatalogDto

//@formatter:off
private const val baseFolder ="${FolderPrefix.UAA} \"${UaaNames.CATALOG}\" (catalog)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class CatalogFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class CatalogFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class CatalogFolderFiltration

private const val STORY_UAA = "JTCSALTO-476"
@TaskIds([Tm4jEpic.EPIC_UAA, STORY_UAA,Tm4jStoryAT.AT_STORY_UAA,"JTCSALTO-779"]) annotation class CatalogTaskIdsCommon
//@formatter:on

@CatalogTaskIdsCommon
@CatalogFolderCrud
@ComponentUaa
@HighPriority
class CatalogCreateTest :
    CreateTestTemplate<CatalogDto>(
        preExecution = { prepareCatalogDtoForCreate() },
        steps = CatalogSteps()
    )

@CatalogTaskIdsCommon
@CatalogFolderCrud
@ComponentUaa
@HighPriority
class CatalogGetTest :
    GetTestTemplate<CatalogDto>(
        preExecution = {
            val random = CatalogData.randomOrException()
            val dto = random.toDto()
            dto
        },
        steps = CatalogSteps()
    )

@CatalogTaskIdsCommon
@CatalogFolderCrud
@ComponentUaa
@HighPriority
class CatalogGetPageTest :
    GetPageTestTemplate<CatalogDto>(
        steps = CatalogSteps()
    )

@CatalogTaskIdsCommon
@CatalogFolderCrud
@ComponentUaa
@HighPriority
class CatalogDeleteTest :
    DeleteTestTemplate<CatalogDto>(
        preExecution = {
            val createdResponse = CatalogSteps().create(prepareCatalogDtoForCreate())
            createdResponse.data!!
        },
        steps = CatalogSteps(),
        preCheckingHandling = {
            it.mfa = emptyList()
            it
        }
    )

@CatalogTaskIdsCommon
@CatalogFolderCrud
@ComponentUaa
@HighPriority
class CatalogUpdateTest :
    UpdateTestTemplate<CatalogDto, CatalogDto>(
        preExecution = {
            val dtoForCreate = prepareCatalogDtoForCreate()
            val createdDto = CatalogSteps().create(dtoForCreate).data!!
            getCatalogDtoForUpdate(createdDto)
        },
        steps = CatalogSteps(),
        preCheckingHandling = { dto ->
            dto.mfa?.forEach { it.id = null }
            dto
        }
    )

@CatalogTaskIdsCommon
@CatalogFolderSorting
@ComponentUaa
@LowPriority
class CatalogSortingTest(sortRequestFunction: () -> List<Sort>) : SortingTestTemplate<CatalogDto, CatalogSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = CatalogSteps(),
    clazz = CatalogSortingParams::class.java
)

@CatalogTaskIdsCommon
@CatalogFolderFiltration
@ComponentUaa
@NormalPriority
class CatalogFilterTests(
    name: String,
    preExecution: (() -> CatalogDto)?,
    filterRequestFunction: (CatalogDto?) -> FilterData
) : FiltrationTestTemplate<CatalogDto, CatalogFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = CatalogSteps(),
    clazz = CatalogFilterParams::class.java,
    preExecution = preExecution
)