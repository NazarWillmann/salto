package ooo.jtc.api.dictionaries.person

import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jEpic
import ooo.jtc.dictionaries.person.PersonDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.dictionaries.person.PersonData
import ooo.jtc.testdata.dictionaries.person.PersonFilterParams
import ooo.jtc.testdata.dictionaries.person.PersonSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.PERSON}\" (person)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class PersonFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class PersonFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class PersonFolderFiltration

@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY])
annotation class PersonTaskIdsCommon
//@formatter:on

@PersonTaskIdsCommon
@PersonFolderCrud
@ComponentDictionary
@HighPriority
class PersonGetTest(user: User) :
    GetTestTemplate<PersonDto>(
        preExecution = { PersonData.randomOrException().toDto() },
        steps = PersonSteps(user)
    )

@PersonTaskIdsCommon
@PersonFolderCrud
@ComponentDictionary
@HighPriority
class PersonGetPageTest(user: User) :
    GetPageTestTemplate<PersonDto>(
        steps = PersonSteps(user)
    )

@PersonTaskIdsCommon
@PersonFolderSorting
@ComponentDictionary
@LowPriority
class PersonSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<PersonDto, PersonSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = PersonSteps(user),
    clazz = PersonSortingParams::class.java
)

@PersonTaskIdsCommon
@PersonFolderFiltration
@ComponentDictionary
@NormalPriority
class PersonFilterTest(
    name: String,
    user: User,
    preExecution: (() -> PersonDto)?,
    filterRequestFunction: (PersonDto?) -> FilterData
) : FiltrationTestTemplate<PersonDto, PersonFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = PersonSteps(user),
    clazz = PersonFilterParams::class.java,
    preExecution = preExecution
)
