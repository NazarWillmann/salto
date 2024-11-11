package ooo.jtc.api.dictionaries.paymenttype

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.dictionaries.paymenttype.PaymentTypePrepareSteps.availablePaymentTypeCodes
import ooo.jtc.api.dictionaries.paymenttype.PaymentTypePrepareSteps.getPaymentTypeDtoForCreate
import ooo.jtc.api.dictionaries.paymenttype.PaymentTypePrepareSteps.getPaymentTypeDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.core.tm4j.FolderPrefix.DICTIONARY
import ooo.jtc.core.tm4j.SubFolder.CONTROLS
import ooo.jtc.core.tm4j.SubFolder.CRUD
import ooo.jtc.core.tm4j.SubFolder.FILTRATION
import ooo.jtc.core.tm4j.SubFolder.OTHER
import ooo.jtc.core.tm4j.SubFolder.SORTING
import ooo.jtc.core.tm4j.Tm4jEpic.EPIC_R_RKO_DICTIONARY
import ooo.jtc.dictionaries.paymenttype.PaymentTypeDto
import ooo.jtc.generic.DictionaryNames.PAYMENT_TYPE
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.paymenttype.PaymentTypeControls
import ooo.jtc.testdata.dictionaries.paymenttype.PaymentTypeData
import ooo.jtc.testdata.dictionaries.paymenttype.PaymentTypeFilterParams
import ooo.jtc.testdata.dictionaries.paymenttype.PaymentTypeSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder = "$DICTIONARY \"$PAYMENT_TYPE\" (paymentType)"
@Folder("$baseFolder/$CRUD")       annotation class PaymentTypeFolderCrud
@Folder("$baseFolder/$SORTING")    annotation class PaymentTypeFolderSorting
@Folder("$baseFolder/$FILTRATION") annotation class PaymentTypeFolderFiltration
@Folder("$baseFolder/$CONTROLS")   annotation class PaymentTypeFolderControls
@Folder("$baseFolder/$OTHER")      annotation class PaymentTypeFolderOther

@TaskIds([EPIC_R_RKO_DICTIONARY, "JTCSALTO-844",Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1150"]) annotation class PaymentTypeTaskIdsCommon
//@formatter:on

@PaymentTypeTaskIdsCommon
@PaymentTypeFolderCrud
@ComponentDictionary
@HighPriority
class PaymentTypeCreateTest(
    user: User = bankAdmin,
    steps: PaymentTypeSteps = PaymentTypeSteps(user)
) : CreateTestTemplate<PaymentTypeDto>(
    preExecution = { getPaymentTypeDtoForCreate() },
    steps = steps,
    testPostExecution = {
        availablePaymentTypeCodes.add(it.code!!)
        steps.delete(it.id!!)
    }
)

@PaymentTypeTaskIdsCommon
@PaymentTypeFolderCrud
@ComponentDictionary
@HighPriority
class PaymentTypeGetTest(user: User) :
    GetTestTemplate<PaymentTypeDto>(
        preExecution = { PaymentTypeData.randomOrException().toDto() },
        steps = PaymentTypeSteps(user)
    )

@PaymentTypeTaskIdsCommon
@PaymentTypeFolderCrud
@ComponentDictionary
@HighPriority
class PaymentTypeGetPageTest(user: User) :
    GetPageTestTemplate<PaymentTypeDto>(
        steps = PaymentTypeSteps(user)
    )

@PaymentTypeTaskIdsCommon
@PaymentTypeFolderCrud
@ComponentDictionary
@HighPriority
class PaymentTypeDeleteTest(
    user: User = bankAdmin,
    steps: PaymentTypeSteps = PaymentTypeSteps(user)
) : DeleteTestTemplate<PaymentTypeDto>(
    preExecution = {
        val createdResponse = steps.create(getPaymentTypeDtoForCreate())
        createdResponse.data!!
    },
    steps = steps
)

@PaymentTypeTaskIdsCommon
@PaymentTypeFolderCrud
@ComponentDictionary
@HighPriority
class PaymentTypeUpdateTest(
    user: User = bankAdmin,
    steps: PaymentTypeSteps = PaymentTypeSteps(user)
) : UpdateTestTemplate<PaymentTypeDto, PaymentTypeDto>(
    preExecution = {
        val createdDto = steps.create(getPaymentTypeDtoForCreate()).data!!
        getPaymentTypeDtoForUpdate(createdDto)
    },
    steps = steps,
    postExecution = {
        availablePaymentTypeCodes.add(it.code!!)
        steps.delete(it.id!!)
    }
)


@PaymentTypeTaskIdsCommon
@PaymentTypeFolderSorting
@ComponentDictionary
@LowPriority
class PaymentTypeSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<PaymentTypeDto, PaymentTypeSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = PaymentTypeSteps(user),
    clazz = PaymentTypeSortingParams::class.java
)


@PaymentTypeTaskIdsCommon
@PaymentTypeFolderFiltration
@ComponentDictionary
@NormalPriority
class PaymentTypeFilterTests(
    name: String,
    user: User,
    preExecution: (() -> PaymentTypeDto)?,
    filterRequestFunction: (PaymentTypeDto?) -> FilterData
) : FiltrationTestTemplate<PaymentTypeDto, PaymentTypeFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = PaymentTypeSteps(user),
    clazz = PaymentTypeFilterParams::class.java,
    preExecution = preExecution
)

@TaskIds([EPIC_R_RKO_DICTIONARY, "JTCSALTO-844", "JTCSALTO-847"])
@PaymentTypeFolderControls
@ComponentDictionary
@HighPriority
class PaymentTypeControlTest(
    testName: String,
    preExecution: (() -> PaymentTypeDto)?,
    control: PaymentTypeControls,
    steps: PaymentTypeSteps = PaymentTypeSteps(bankAdmin)
) : ControlTestTemplate<PaymentTypeDto>(
    testName = testName,
    control = control,
    preExecution = preExecution,
    steps = steps
)

@PaymentTypeTaskIdsCommon
@PaymentTypeFolderOther
@ComponentDictionary
@NormalPriority
class PaymentTypeOtherTest(
    name: String,
    params: ((Unit?) -> Map<String, Any>)? = null,
    testBody: (Unit?) -> Unit
) : UnitBeTest(
    name = name,
    params = params,
    testBody = testBody
)