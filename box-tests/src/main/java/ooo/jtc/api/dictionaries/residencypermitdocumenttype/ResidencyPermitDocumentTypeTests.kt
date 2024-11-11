package ooo.jtc.api.dictionaries.residencypermitdocumenttype

import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.dictionaries.residencypermitdocumenttype.ResidencyPermitDocumentTypeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.dictionaries.residencypermitdocumenttype.ResidencyPermitDocumentTypeSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val BASE_FOLDER ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.RESIDENCY_PERMIT_DOCUMENT_TYPE}\" (residencyPermitDocumentType)"
@Folder("$BASE_FOLDER/${SubFolder.CRUD}")       annotation class ResidencyPermitDocumentTypeFolderCrud
@Folder("$BASE_FOLDER/${SubFolder.SORTING}")    annotation class ResidencyPermitDocumentTypeFolderSorting
@Folder("$BASE_FOLDER/${SubFolder.DEFAULTS}")   annotation class ResidencyPermitDocumentTypeFolderDefaults

@TaskIds(["JSSP-165","JSSP-170"])         annotation class ResidencyPermitDocumentTypeTraceabilityTasks
//@formatter:on


@ResidencyPermitDocumentTypeTraceabilityTasks
@ComponentDictionary
@ResidencyPermitDocumentTypeFolderCrud
@HighPriority
class ResidencyPermitDocumentTypeGetPageTest(user: User) :
    GetPageTestTemplate<ResidencyPermitDocumentTypeDto>(
        steps = ResidencyPermitDocumentTypeSteps(user)
    )

@ResidencyPermitDocumentTypeTraceabilityTasks
@ComponentDictionary
@ResidencyPermitDocumentTypeFolderSorting
@HighPriority
class ResidencyPermitDocumentTypeSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<ResidencyPermitDocumentTypeDto, ResidencyPermitDocumentTypeSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = ResidencyPermitDocumentTypeSteps(user),
    clazz = ResidencyPermitDocumentTypeSortingParams::class.java
)