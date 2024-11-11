package ooo.jtc.api.dictionaries.agreement

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.NestedControlTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.dictionaries.agreement.AgreementPrepareSteps.getAgreementDtoForCreate
import ooo.jtc.api.dictionaries.agreement.AgreementPrepareSteps.getAgreementDtoForUpdate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.dictionaries.agreement.AgreementDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.agreement.AgreementControls
import ooo.jtc.testdata.dictionaries.agreement.AgreementFilterParams
import ooo.jtc.testdata.dictionaries.agreement.AgreementSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder = "${FolderPrefix.DICTIONARY} \"${DictionaryNames.AGREEMENT}\" (agreement)"
@Folder("${baseFolder}/${SubFolder.CRUD}")                  annotation class AgreementFolderCrud
@Folder("${baseFolder}/${SubFolder.FILTRATION}")            annotation class AgreementFolderFiltration
@Folder("${baseFolder}/${SubFolder.SORTING}")               annotation class AgreementFolderSorting
@Folder("${baseFolder}/${SubFolder.CONTROLS}")              annotation class AgreementFolderControls
@Folder("${baseFolder}/${SubFolder.DEFAULTS}")              annotation class AgreementFolderDefaults
//@formatter:on

@AgreementFolderCrud
@ComponentDictionary
@HighPriority
class AgreementCreateTest(user: User = Users.autotest) :
    CreateTestTemplate<AgreementDto>(
        preExecution = { getAgreementDtoForCreate() },
        steps = AgreementSteps(user),
    )

@AgreementFolderCrud
@ComponentDictionary
@HighPriority
class AgreementUpdateTest(user: User = Users.autotest) :
    UpdateTestTemplate<AgreementDto, AgreementDto>(
        preExecution = {
            val createResponse = AgreementSteps(user).create(getAgreementDtoForCreate())
            getAgreementDtoForUpdate(createResponse.data!!)
        },
        steps = AgreementSteps(user)
    )

@AgreementFolderCrud
@ComponentDictionary
@HighPriority
class AgreementActivateDeactivateTest(testBody: (Unit?) -> Unit, isActivate: Boolean
) : UnitBeTest(
    name = "'${DictionaryNames.AGREEMENT}'. Проверка изменения статуса на " + when(isActivate) {
        true -> "Активировано"
        false -> "Деактивировано"
    },
    testBody = testBody
)

@AgreementFolderCrud
@ComponentDictionary
@HighPriority
class AgreementGetTest(user: User = Users.autotest) :
    GetTestTemplate<AgreementDto>(
        preExecution = { AgreementSteps(Users.bankAdmin).create(getAgreementDtoForCreate()).data!! },
        steps = AgreementSteps(user),
        postExecution = { AgreementSteps(Users.bankAdmin).delete(it.id!!) }
    )

@AgreementFolderCrud
@ComponentDictionary
@HighPriority
class AgreementGetPageTest(user: User = Users.autotest) :
    GetPageTestTemplate<AgreementDto>(
        steps = AgreementSteps(user)
    )

@AgreementFolderCrud
@ComponentDictionary
@HighPriority
class AgreementDeleteTest(user: User = Users.autotest) :
    DeleteTestTemplate<AgreementDto>(
        preExecution = {
            val createResponse = AgreementSteps(user).create(getAgreementDtoForCreate())
            createResponse.data!!
        },
        steps = AgreementSteps(user),
        preCheckingHandling = {it.toReducedDto()}
    )

@AgreementFolderFiltration
@ComponentDictionary
@NormalPriority
class AgreementFilterTest(
    name: String,
    user: User,
    preExecution: (() -> AgreementDto)?,
    filterRequestFunction: (AgreementDto?) -> FilterData
) : FiltrationTestTemplate<AgreementDto, AgreementFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = AgreementSteps(user),
    clazz = AgreementFilterParams::class.java,
    preExecution = preExecution
)

@AgreementFolderSorting
@ComponentDictionary
@LowPriority
class AgreementSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<AgreementDto, AgreementSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = AgreementSteps(user),
    clazz = AgreementSortingParams::class.java
)

@AgreementFolderDefaults
@ComponentDictionary
@HighPriority
class AgreementDefaultsTest(
    testBody: (Unit?) -> Unit
) : UnitBeTest(
    name = "'${DictionaryNames.AGREEMENT}'. Наполнение",
    testBody = testBody
)

@AgreementFolderControls
@ComponentDictionary
@NormalPriority
class AgreementControlTest(
    testName: String,
    preExecution: (() -> AgreementDto)?,
    control: AgreementControls
) : NestedControlTestTemplate<AgreementDto>(
    testName = testName,
    docControl = control,
    preExecution = preExecution,
    steps = AgreementSteps(Users.bankAdmin)
)
