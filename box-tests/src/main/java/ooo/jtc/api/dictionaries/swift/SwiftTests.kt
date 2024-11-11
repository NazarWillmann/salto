package ooo.jtc.api.dictionaries.swift

import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.asserts.assertEqualList
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jStoryAT
import ooo.jtc.dictionaries.swift.SwiftDto
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.dictionaries.swift.SwiftData
import ooo.jtc.uaa.User
import org.hamcrest.MatcherAssert.assertThat

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.SWIFT}\" (swift)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class SwiftFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class SwiftFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class SwiftFolderFiltration
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class SwiftFolderOther

@TaskIds([Tm4jStoryAT.AT_STORY_COMMON_DICTIONARIES_CHANGES, "JTCSALTO-3131"]) annotation class SwiftTaskIdsCommon
//@formatter:on

@SwiftTaskIdsCommon
@SwiftFolderCrud
@ComponentDictionary
@HighPriority
class SwiftGetTest(user: User) :
    GetTestTemplate<SwiftDto>(
        preExecution = { SwiftData.randomOrException(fromCache = false).toDto() },
        steps = SwiftSteps(user)
    )

@SwiftTaskIdsCommon
@SwiftFolderCrud
@ComponentDictionary
@HighPriority
class SwiftGetPageTest(user: User) :
    GetPageTestTemplate<SwiftDto>(
        steps = SwiftSteps(user)
    )

@SwiftTaskIdsCommon
@SwiftFolderCrud
@ComponentDictionary
@HighPriority
class SwiftImportTest(
    val bankUser: User,
    val steps: SwiftSteps = SwiftSteps(bankUser)
) : AbstractTest<Any, Any>(
    name = "${DictionaryNames.SWIFT}'. Импорт справочника пользователем [${bankUser.userType}]"
) {

    override fun execution(preconditionResult: Any?) {
        val swiftsForImport = SwiftPrepareSteps.prepareSwiftsForImport(amount = 10)
        val serializedXmlFile = SwiftPrepareSteps.prepareTempFileForSwiftImport(swiftsForImport)
        val importResponse = steps.importSwift(serializedXmlFile)

        assertThat(
            "Несовпадает количество отправленных и импортированных записей",
            swiftsForImport.size == importResponse.data.getOrException("No 'data' in /Import response!").total
        )

        val swiftsInDB = steps.getPageAll()
        assertThat(
            "Несовпадает количество отправленных записей и записей в БД",
            swiftsForImport.size == swiftsInDB.size.getOrException("No 'size' in /Get response!")
        )

        val expSwiftDtos = swiftsForImport.map { it.toSwiftDto() }.sortedBy { it.swift }
        val actSwiftDtos = swiftsInDB.page.getOrException().sortedBy { it.swift }
        actSwiftDtos.forEach { it.apply {
            id = null
            version = 0
        } }
        assertEqualList("SWIFT", expSwiftDtos, actSwiftDtos)
    }
}

/* TODO Sergeyev [2021.01.20]: this
@SwiftTaskIdsCommon
@SwiftFolderSorting
@ComponentDictionary
@LowPriority
class SwiftSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<SwiftDto, SwiftSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = SwiftSteps(user),
    clazz = SwiftSortingParams::class.java
)

@SwiftTaskIdsCommon
@SwiftFolderFiltration
@ComponentDictionary
@NormalPriority
class SwiftFiltrationTests(
    name: String,
    user: User,
    preExecution: (() -> SwiftDto)?,
    filterRequestFunction: (SwiftDto?) -> FilterData
) : FiltrationTestTemplate<SwiftDto, SwiftFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = SwiftSteps(user),
    clazz = SwiftFilterParams::class.java,
    preExecution = preExecution
)*/
