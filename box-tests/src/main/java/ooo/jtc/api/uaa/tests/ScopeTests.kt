package ooo.jtc.api.uaa.tests

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.uaa.prepare.PrepareScopeData.getScopeDtoForUpdate
import ooo.jtc.api.uaa.prepare.PrepareScopeData.prepareScopeDtoForCreate
import ooo.jtc.api.uaa.steps.ScopeSteps
import ooo.jtc.core.tm4j.*
import ooo.jtc.generic.UaaNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.uaa.scope.ScopeData
import ooo.jtc.testdata.uaa.scope.ScopeFilterParams
import ooo.jtc.testdata.uaa.scope.ScopeSortingParams
import ooo.jtc.uaa.scope.dto.ScopeDto
import ooo.jtc.uaa.scope.dto.ScopeUpdateRequest

//@formatter:off
private const val baseFolder ="${FolderPrefix.UAA} \"${UaaNames.SCOPE}\" (scope)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class ScopeFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class ScopeFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class ScopeFolderFiltration

private const val STORY_UAA = "JTCSALTO-476"
@TaskIds([Tm4jEpic.EPIC_UAA, STORY_UAA,Tm4jStoryAT.AT_STORY_UAA,"JTCSALTO-782"]) annotation class ScopeTaskIdsCommon
//@formatter:on

@ScopeTaskIdsCommon
@ScopeFolderCrud
@ComponentUaa
@HighPriority
class ScopeCreateTest :
    CreateTestTemplate<ScopeDto>(
        preExecution = { prepareScopeDtoForCreate() },
        steps = ScopeSteps()
    )

@ScopeTaskIdsCommon
@ScopeFolderCrud
@ComponentUaa
@HighPriority
class ScopeGetTest :
    GetTestTemplate<ScopeDto>(
        preExecution = { ScopeData.randomOrException().toDto() },
        steps = ScopeSteps()
    )

@ScopeTaskIdsCommon
@ScopeFolderCrud
@ComponentUaa
@HighPriority
class ScopeGetPageTest :
    GetPageTestTemplate<ScopeDto>(
        steps = ScopeSteps()
    )


@ScopeTaskIdsCommon
@ScopeFolderCrud
@ComponentUaa
@HighPriority
class ScopeDeleteTest :
    DeleteTestTemplate<ScopeDto>(
        preExecution = {
            val createdResponse = ScopeSteps().create(prepareScopeDtoForCreate())
            createdResponse.data!!
        },
        steps = ScopeSteps()
    )

@ScopeTaskIdsCommon
@ScopeFolderCrud
@ComponentUaa
@HighPriority
class ScopeUpdateTest :
    UpdateTestTemplate<ScopeDto, ScopeUpdateRequest>(
        preExecution = {
            val dtoForCreate = prepareScopeDtoForCreate()
            val createdDto = ScopeSteps().create(dtoForCreate).data!!
            getScopeDtoForUpdate(createdDto)
        },
        steps = ScopeSteps()
    )


@ScopeTaskIdsCommon
@ScopeFolderSorting
@ComponentUaa
@LowPriority
class ScopeSortingTest(sortRequestFunction: () -> List<Sort>) : SortingTestTemplate<ScopeDto, ScopeSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = ScopeSteps(),
    clazz = ScopeSortingParams::class.java
)

@ScopeTaskIdsCommon
@ScopeFolderFiltration
@ComponentUaa
@NormalPriority
class ScopeFilterTests(
    name: String,
    preExecution: (() -> ScopeDto)?,
    filterRequestFunction: (ScopeDto?) -> FilterData
) : FiltrationTestTemplate<ScopeDto, ScopeFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = ScopeSteps(),
    clazz = ScopeFilterParams::class.java,
    preExecution = preExecution
)