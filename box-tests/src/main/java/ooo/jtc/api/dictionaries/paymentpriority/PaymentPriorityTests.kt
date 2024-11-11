package ooo.jtc.api.dictionaries.paymentpriority

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.paymentpriority.PaymentPriorityPrepareSteps.availablePaymentPriorityCodes
import ooo.jtc.api.dictionaries.paymentpriority.PaymentPriorityPrepareSteps.getPaymentPriorityDtoForCreate
import ooo.jtc.api.dictionaries.paymentpriority.PaymentPriorityPrepareSteps.getPaymentPriorityDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.core.tm4j.FolderPrefix.DICTIONARY
import ooo.jtc.core.tm4j.SubFolder.CONTROLS
import ooo.jtc.core.tm4j.SubFolder.CRUD
import ooo.jtc.core.tm4j.SubFolder.FILTRATION
import ooo.jtc.core.tm4j.SubFolder.OTHER
import ooo.jtc.core.tm4j.SubFolder.SORTING
import ooo.jtc.core.tm4j.Tm4jEpic.EPIC_R_RKO_DICTIONARY
import ooo.jtc.dictionaries.paymentpriority.PaymentPriorityDto
import ooo.jtc.generic.DictionaryNames.PAYMENT_PRIORITY
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.paymentpriority.PaymentPriorityControls
import ooo.jtc.testdata.dictionaries.paymentpriority.PaymentPriorityData
import ooo.jtc.testdata.dictionaries.paymentpriority.PaymentPriorityFilterParams
import ooo.jtc.testdata.dictionaries.paymentpriority.PaymentPrioritySortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="$DICTIONARY \"$PAYMENT_PRIORITY\" (paymentPriority)"
@Folder("$baseFolder/$CRUD")       annotation class PaymentPriorityFolderCrud
@Folder("$baseFolder/$SORTING")    annotation class PaymentPriorityFolderSorting
@Folder("$baseFolder/$FILTRATION") annotation class PaymentPriorityFolderFiltration
@Folder("$baseFolder/$CONTROLS")   annotation class PaymentPriorityFolderControls
@Folder("$baseFolder/$OTHER")      annotation class PaymentPriorityFolderOther

@TaskIds([EPIC_R_RKO_DICTIONARY, "JTCSALTO-398", "JTCSALTO-402",Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1149"]) annotation class PaymentPriorityTaskIdsCommon
//@formatter:on

@PaymentPriorityTaskIdsCommon
@PaymentPriorityFolderCrud
@ComponentDictionary
@HighPriority
class PaymentPriorityCreateTest(
    user: User = bankAdmin,
    steps: PaymentPrioritySteps = PaymentPrioritySteps(user)
) :
    CreateTestTemplate<PaymentPriorityDto>(
        preExecution = { getPaymentPriorityDtoForCreate() },
        steps = steps,
        testPostExecution = {
            availablePaymentPriorityCodes.add(it.code!!)
            steps.delete(it.id!!)
        }
    )

@PaymentPriorityTaskIdsCommon
@PaymentPriorityFolderCrud
@ComponentDictionary
@HighPriority
class PaymentPriorityGetTest(user: User) :
    GetTestTemplate<PaymentPriorityDto>(
        preExecution = { PaymentPriorityData.randomOrException().toDto() },
        steps = PaymentPrioritySteps(user)
    )

@PaymentPriorityTaskIdsCommon
@PaymentPriorityFolderCrud
@ComponentDictionary
@HighPriority
class PaymentPriorityGetPageTest(user: User) :
    GetPageTestTemplate<PaymentPriorityDto>(
        steps = PaymentPrioritySteps(user)
    )

@PaymentPriorityTaskIdsCommon
@PaymentPriorityFolderCrud
@ComponentDictionary
@HighPriority
class PaymentPriorityDeleteTest(
    user: User = bankAdmin,
    steps: PaymentPrioritySteps = PaymentPrioritySteps(user)
) :
    DeleteTestTemplate<PaymentPriorityDto>(
        preExecution = {
            val createdResponse = steps.create(getPaymentPriorityDtoForCreate())
            createdResponse.data!!
        },
        steps = steps,
        postExecution = { availablePaymentPriorityCodes.add(it.code!!) }
    )

@PaymentPriorityTaskIdsCommon
@PaymentPriorityFolderCrud
@ComponentDictionary
@HighPriority
class PaymentPriorityUpdateTest(
    user: User = bankAdmin,
    steps: PaymentPrioritySteps = PaymentPrioritySteps(user)
) :
    UpdateTestTemplate<PaymentPriorityDto, PaymentPriorityDto>(
        preExecution = {
            val createdDto = steps.create(getPaymentPriorityDtoForCreate()).data!!
            getPaymentPriorityDtoForUpdate(createdDto)
        },
        steps = steps,
        postExecution = {
            availablePaymentPriorityCodes.add(it.code!!)
            steps.delete(it.id!!)
        }
    )

@PaymentPriorityTaskIdsCommon
@PaymentPriorityFolderSorting
@ComponentDictionary
@LowPriority
class PaymentPrioritySortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<PaymentPriorityDto, PaymentPrioritySortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = PaymentPrioritySteps(user),
    clazz = PaymentPrioritySortingParams::class.java
)

@PaymentPriorityTaskIdsCommon
@PaymentPriorityFolderFiltration
@ComponentDictionary
@NormalPriority
class PaymentPriorityFilterTests(
    name: String,
    user: User,
    preExecution: (() -> PaymentPriorityDto)?,
    filterRequestFunction: (PaymentPriorityDto?) -> FilterData
) : FiltrationTestTemplate<PaymentPriorityDto, PaymentPriorityFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = PaymentPrioritySteps(user),
    clazz = PaymentPriorityFilterParams::class.java,
    preExecution = preExecution
)

@TaskIds([EPIC_R_RKO_DICTIONARY, "JTCSALTO-398", "JTCSALTO-403"])
@PaymentPriorityFolderControls
@ComponentDictionary
@HighPriority
class PaymentPriorityControlTest(
    testName: String,
    preExecution: (() -> PaymentPriorityDto)?,
    control: PaymentPriorityControls,
    steps: PaymentPrioritySteps = PaymentPrioritySteps(bankAdmin)
) : NestedControlTestTemplate<PaymentPriorityDto>(
    testName = testName,
    docControl = control,
    preExecution = preExecution,
    steps = steps
)