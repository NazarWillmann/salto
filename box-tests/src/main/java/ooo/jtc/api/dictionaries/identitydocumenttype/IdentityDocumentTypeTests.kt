package ooo.jtc.api.dictionaries.identitydocumenttype

import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.dictionaries.identitydocumenttype.IdentityDocumentTypePrepareSteps.getIdentityDocTypeDtoForUpdate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jStoryAT
import ooo.jtc.dictionaries.identitydocumenttype.IdentityDocumentTypeDto
import ooo.jtc.generic.DictionaryNames.IDENTITY_DOC_TYPE
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.dictionaries.identitydocumenttype.IdentityDocumentTypeData
import ooo.jtc.testdata.dictionaries.identitydocumenttype.IdentityDocumentTypeFilterParams
import ooo.jtc.testdata.dictionaries.identitydocumenttype.IdentityDocumentTypeSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder = "${FolderPrefix.DICTIONARY} \"$IDENTITY_DOC_TYPE\" (identityDocumentType)"
@Folder("$baseFolder/${SubFolder.CRUD}")                annotation class IdentityDocumentTypeFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")             annotation class IdentityDocumentTypeFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}")          annotation class IdentityDocumentTypeFolderFiltration
@Folder("$baseFolder/${SubFolder.DEFAULTS}")            annotation class IdentityDocumentTypeFolderDefaults

@TaskIds([Tm4jStoryAT.AT_STORY_COMMON_DICTIONARIES_CHANGES])    annotation class IdentityDocumentTypeTaskIdsAll
//@formatter:on

@IdentityDocumentTypeTaskIdsAll
@IdentityDocumentTypeFolderCrud
@ComponentDictionary
@HighPriority
class IdentityDocumentTypeGetTest(user: User) :
    GetTestTemplate<IdentityDocumentTypeDto>(
        preExecution = { IdentityDocumentTypeData.randomOrException().toDto() },
        steps = IdentityDocumentTypeSteps(user)
    )

@IdentityDocumentTypeTaskIdsAll
@IdentityDocumentTypeFolderCrud
@ComponentDictionary
@HighPriority
class IdentityDocumentTypeGetPageTest(user: User) :
    GetPageTestTemplate<IdentityDocumentTypeDto>(
        steps = IdentityDocumentTypeSteps(user)
    )

@IdentityDocumentTypeTaskIdsAll
@IdentityDocumentTypeFolderCrud
@ComponentDictionary
@HighPriority
class IdentityDocumentTypeUpdateTest(
    user: User,
) : UpdateTestTemplate<IdentityDocumentTypeDto, IdentityDocumentTypeDto>(
    preExecution = {
        getIdentityDocTypeDtoForUpdate(IdentityDocumentTypeData.createRecord!!.invoke().toDto())
    },
    steps = IdentityDocumentTypeSteps(user),
    postExecution = {
        IdentityDocumentTypeData.removeRecord!!.invoke(it.toModel())
    }
)

@IdentityDocumentTypeTaskIdsAll
@IdentityDocumentTypeFolderSorting
@ComponentDictionary
@LowPriority
class IdentityDocumentTypeSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<IdentityDocumentTypeDto, IdentityDocumentTypeSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = IdentityDocumentTypeSteps(user),
    clazz = IdentityDocumentTypeSortingParams::class.java
)

@IdentityDocumentTypeTaskIdsAll
@IdentityDocumentTypeFolderFiltration
@ComponentDictionary
@NormalPriority
class IdentityDocumentTypeFiltrationTests(
    name: String,
    user: User,
    preExecution: (() -> IdentityDocumentTypeDto)?,
    filterRequestFunction: (IdentityDocumentTypeDto?) -> FilterData
) : FiltrationTestTemplate<IdentityDocumentTypeDto, IdentityDocumentTypeFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = IdentityDocumentTypeSteps(user),
    clazz = IdentityDocumentTypeFilterParams::class.java,
    preExecution = preExecution
)

@IdentityDocumentTypeTaskIdsAll
@ComponentDictionary
@IdentityDocumentTypeFolderDefaults
@HighPriority
class IdentityDocumentTypeDefaultsTest(
    testBody: (Unit?) -> Unit
) : UnitBeTest(
    name = "'${IDENTITY_DOC_TYPE}'. Наполнение",
    testBody = testBody
)