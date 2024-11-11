package ooo.jtc.be.rupayment

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_RUPAYMENT_SORTING
import ooo.jtc.api.rupayment.RuPaymentSteps
import ooo.jtc.api.rupayment.prepare.RuPaymentPrepareSteps.createRuPaymentDto
import ooo.jtc.api.rupayment.tests.RuPaymentSortingTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryRuPayment
import ooo.jtc.generic.DocumentNames
import ooo.jtc.rupayment.dto.RuPaymentDto
import ooo.jtc.testdata.Users.bankOperator
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import ooo.jtc.testdata.rupayment.RuPaymentSortingParams.AMOUNT
import ooo.jtc.testdata.rupayment.RuPaymentSortingParams.BRANCH_ID
import ooo.jtc.testdata.rupayment.RuPaymentSortingParams.CUSTOMER_ID
import ooo.jtc.testdata.rupayment.RuPaymentSortingParams.DOCUMENT_DATE
import ooo.jtc.testdata.rupayment.RuPaymentSortingParams.DOCUMENT_NUMBER
import ooo.jtc.testdata.rupayment.RuPaymentSortingParams.PAYMENT_GROUND_DESCRIPTION
import ooo.jtc.testdata.rupayment.RuPaymentSortingParams.RECEIVER_ACCOUNT
import ooo.jtc.testdata.rupayment.RuPaymentSortingParams.RECEIVER_BANK_BIC
import ooo.jtc.testdata.rupayment.RuPaymentSortingParams.RECEIVER_BANK_NAME
import ooo.jtc.testdata.rupayment.RuPaymentSortingParams.RECEIVER_INN
import ooo.jtc.testdata.rupayment.RuPaymentSortingParams.RECEIVER_NAME
import ooo.jtc.testdata.rupayment.RuPaymentSortingParams.STATUS
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import java.util.stream.Stream
import kotlin.streams.toList

@Epic(TestEpic.API)
@Feature(TestFeature.RUPAYMENT)
@Story(TestStoryRuPayment.RUPAYMENT_SORTING)
@DisplayName("API '${DocumentNames.RU_PAYMENT}' sorting suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_RUPAYMENT_SORTING
@TestInstance(PER_CLASS)
class RuPaymentSortingTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3751") annotation class T3751
@Tag("JTCSALTO-T3752") annotation class T3752
@Tag("JTCSALTO-T3753") annotation class T3753
@Tag("JTCSALTO-T3754") annotation class T3754
@Tag("JTCSALTO-T3755") annotation class T3755
@Tag("JTCSALTO-T3756") annotation class T3756
@Tag("JTCSALTO-T3757") annotation class T3757
@Tag("JTCSALTO-T3758") annotation class T3758
@Tag("JTCSALTO-T3759") annotation class T3759
@Tag("JTCSALTO-T3760") annotation class T3760
@Tag("JTCSALTO-T3761") annotation class T3761
@Tag("JTCSALTO-T3762") annotation class T3762
@Tag("JTCSALTO-T3763") annotation class T3763
@Tag("JTCSALTO-T3764") annotation class T3764
@Tag("JTCSALTO-T3765") annotation class T3765
@Tag("JTCSALTO-T3766") annotation class T3766
@Tag("JTCSALTO-T3767") annotation class T3767
@Tag("JTCSALTO-T3768") annotation class T3768
@Tag("JTCSALTO-T3769") annotation class T3769
@Tag("JTCSALTO-T3770") annotation class T3770
@Tag("JTCSALTO-T3771") annotation class T3771
@Tag("JTCSALTO-T3772") annotation class T3772
@Tag("JTCSALTO-T3773") annotation class T3773
@Tag("JTCSALTO-T3774") annotation class T3774
@Tag("JTCSALTO-T3775") annotation class T3775
@Tag("JTCSALTO-T3776") annotation class T3776
@Tag("JTCSALTO-T3777") annotation class T3777
@Tag("JTCSALTO-T3778") annotation class T3778
@Tag("JTCSALTO-T3779") annotation class T3779
@Tag("JTCSALTO-T3780") annotation class T3780
@Tag("JTCSALTO-T3781") annotation class T3781
@Tag("JTCSALTO-T3782") annotation class T3782
@Tag("JTCSALTO-T3783") annotation class T3783
@Tag("JTCSALTO-T3784") annotation class T3784
@Tag("JTCSALTO-T3785") annotation class T3785
@Tag("JTCSALTO-T3786") annotation class T3786
@Tag("JTCSALTO-T3787") annotation class T3787
@Tag("JTCSALTO-T3788") annotation class T3788
@Tag("JTCSALTO-T3789") annotation class T3789
@Tag("JTCSALTO-T3790") annotation class T3790
@Tag("JTCSALTO-T3791") annotation class T3791
@Tag("JTCSALTO-T3792") annotation class T3792
@Tag("JTCSALTO-T3793") annotation class T3793
@Tag("JTCSALTO-T3794") annotation class T3794
@Tag("JTCSALTO-T3795") annotation class T3795
@Tag("JTCSALTO-T3796") annotation class T3796
@Tag("JTCSALTO-T3797") annotation class T3797
@Tag("JTCSALTO-T3798") annotation class T3798
//@formatter:on
//endregion

    private lateinit var testData: List<RuPaymentDto>

    @BeforeAll
    fun prepareDataForRuPaymentSortingTests() {
        if (RuPaymentSteps(client).getPage().page == null) {
            testData = Stream
                .generate { createRuPaymentDto(client) }
                .limit(REQUIRED_DATA_COUNT)
                .toList()
        }
    }

    @AfterAll
    fun cleanDataForRuPaymentSortingTests() {
        if (this::testData.isInitialized) {
            val steps = RuPaymentSteps(client)
            testData.forEach { steps.delete(it.id!!) }
        }
    }

    @TestFactory
    @T3775 //'Рублевое ПП'. Сортировка по полю 'documentNumber, ASC' [CLIENT]
    @T3776 //'Рублевое ПП'. Сортировка по полю 'documentDate, ASC' [CLIENT]
    @T3777 //'Рублевое ПП'. Сортировка по полю 'customerId, ASC' [CLIENT]
    @T3778 //'Рублевое ПП'. Сортировка по полю 'branchId, ASC' [CLIENT]
    @T3779 //'Рублевое ПП'. Сортировка по полю 'status, ASC' [CLIENT]
    @T3780 //'Рублевое ПП'. Сортировка по полю 'amount, ASC' [CLIENT]
    @T3781 //'Рублевое ПП'. Сортировка по полю 'paymentGround.description, ASC' [CLIENT]
    @T3782 //'Рублевое ПП'. Сортировка по полю 'receiver.name, ASC' [CLIENT]
    @T3783 //'Рублевое ПП'. Сортировка по полю 'receiver.innKio, ASC' [CLIENT]
    @T3784 //'Рублевое ПП'. Сортировка по полю 'receiver.account, ASC' [CLIENT]
    @T3785 //'Рублевое ПП'. Сортировка по полю 'receiver.bank.name, ASC' [CLIENT]
    @T3786 //'Рублевое ПП'. Сортировка по полю 'receiver.bank.bic, ASC' [CLIENT]

    @T3787 //'Рублевое ПП'. Сортировка по полю 'documentNumber, DESC' [CLIENT]
    @T3788 //'Рублевое ПП'. Сортировка по полю 'documentDate, DESC' [CLIENT]
    @T3789 //'Рублевое ПП'. Сортировка по полю 'customerId, DESC' [CLIENT]
    @T3790 //'Рублевое ПП'. Сортировка по полю 'branchId, DESC' [CLIENT]
    @T3791 //'Рублевое ПП'. Сортировка по полю 'status, DESC' [CLIENT]
    @T3792 //'Рублевое ПП'. Сортировка по полю 'amount, DESC' [CLIENT]
    @T3793 //'Рублевое ПП'. Сортировка по полю 'paymentGround.description, DESC' [CLIENT]
    @T3794 //'Рублевое ПП'. Сортировка по полю 'receiver.name, DESC' [CLIENT]
    @T3795 //'Рублевое ПП'. Сортировка по полю 'receiver.innKio, DESC' [CLIENT]
    @T3796 //'Рублевое ПП'. Сортировка по полю 'receiver.account, DESC' [CLIENT]
    @T3797 //'Рублевое ПП'. Сортировка по полю 'receiver.bank.name, DESC' [CLIENT]
    @T3798 //'Рублевое ПП'. Сортировка по полю 'receiver.bank.bic, DESC' [CLIENT]
    internal fun ruPaymentSortingClientTests(): List<DynamicTest> {
        val user = client
        return EntityTestGenerator.generate(
            listOf(
                RuPaymentSortingTest(user, DOCUMENT_NUMBER::asc).withId(T3775::class),
                RuPaymentSortingTest(user, DOCUMENT_DATE::asc).withId(T3776::class),
                RuPaymentSortingTest(user, CUSTOMER_ID::asc).withId(T3777::class),
                RuPaymentSortingTest(user, BRANCH_ID::asc).withId(T3778::class),
                RuPaymentSortingTest(user, STATUS::asc).withId(T3779::class),
                RuPaymentSortingTest(user, AMOUNT::asc).withId(T3780::class),
                RuPaymentSortingTest(user, PAYMENT_GROUND_DESCRIPTION::asc).withId(T3781::class),
                RuPaymentSortingTest(user, RECEIVER_NAME::asc).withId(T3782::class),
                RuPaymentSortingTest(user, RECEIVER_INN::asc).withId(T3783::class),
                RuPaymentSortingTest(user, RECEIVER_ACCOUNT::asc).withId(T3784::class),
                RuPaymentSortingTest(user, RECEIVER_BANK_NAME::asc).withId(T3785::class),
                RuPaymentSortingTest(user, RECEIVER_BANK_BIC::asc).withId(T3786::class),

                RuPaymentSortingTest(user, DOCUMENT_NUMBER::desc).withId(T3787::class),
                RuPaymentSortingTest(user, DOCUMENT_DATE::desc).withId(T3788::class),
                RuPaymentSortingTest(user, CUSTOMER_ID::desc).withId(T3789::class),
                RuPaymentSortingTest(user, BRANCH_ID::desc).withId(T3790::class),
                RuPaymentSortingTest(user, STATUS::desc).withId(T3791::class),
                RuPaymentSortingTest(user, AMOUNT::desc).withId(T3792::class),
                RuPaymentSortingTest(user, PAYMENT_GROUND_DESCRIPTION::desc).withId(T3793::class),
                RuPaymentSortingTest(user, RECEIVER_NAME::desc).withId(T3794::class),
                RuPaymentSortingTest(user, RECEIVER_INN::desc).withId(T3795::class),
                RuPaymentSortingTest(user, RECEIVER_ACCOUNT::desc).withId(T3796::class),
                RuPaymentSortingTest(user, RECEIVER_BANK_NAME::desc).withId(T3797::class),
                RuPaymentSortingTest(user, RECEIVER_BANK_BIC::desc).withId(T3798::class)
            )
        )
    }

    @TestFactory
    @T3751 //'Рублевое ПП'. Сортировка по полю 'documentNumber, ASC' [BANK]
    @T3752 //'Рублевое ПП'. Сортировка по полю 'documentDate, ASC' [BANK]
    @T3753 //'Рублевое ПП'. Сортировка по полю 'customerId, ASC' [BANK]
    @T3754 //'Рублевое ПП'. Сортировка по полю 'branchId, ASC' [BANK]
    @T3755 //'Рублевое ПП'. Сортировка по полю 'status, ASC' [BANK]
    @T3756 //'Рублевое ПП'. Сортировка по полю 'amount, ASC' [BANK]
    @T3757 //'Рублевое ПП'. Сортировка по полю 'paymentGround.description, ASC' [BANK]
    @T3758 //'Рублевое ПП'. Сортировка по полю 'receiver.name, ASC' [BANK]
    @T3759 //'Рублевое ПП'. Сортировка по полю 'receiver.innKio, ASC' [BANK]
    @T3760 //'Рублевое ПП'. Сортировка по полю 'receiver.account, ASC' [BANK]
    @T3761 //'Рублевое ПП'. Сортировка по полю 'receiver.bank.name, ASC' [BANK]
    @T3762 //'Рублевое ПП'. Сортировка по полю 'receiver.bank.bic, ASC' [BANK]

    @T3763 //'Рублевое ПП'. Сортировка по полю 'documentNumber, DESC' [BANK]
    @T3764 //'Рублевое ПП'. Сортировка по полю 'documentDate, DESC' [BANK]
    @T3765 //'Рублевое ПП'. Сортировка по полю 'customerId, DESC' [BANK]
    @T3766 //'Рублевое ПП'. Сортировка по полю 'branchId, DESC' [BANK]
    @T3767 //'Рублевое ПП'. Сортировка по полю 'status, DESC' [BANK]
    @T3768 //'Рублевое ПП'. Сортировка по полю 'amount, DESC' [BANK]
    @T3769 //'Рублевое ПП'. Сортировка по полю 'paymentGround.description, DESC' [BANK]
    @T3770 //'Рублевое ПП'. Сортировка по полю 'receiver.name, DESC' [BANK]
    @T3771 //'Рублевое ПП'. Сортировка по полю 'receiver.innKio, DESC' [BANK]
    @T3772 //'Рублевое ПП'. Сортировка по полю 'receiver.account, DESC' [BANK]
    @T3773 //'Рублевое ПП'. Сортировка по полю 'receiver.bank.name, DESC' [BANK]
    @T3774 //'Рублевое ПП'. Сортировка по полю 'receiver.bank.bic, DESC' [BANK]
    internal fun ruPaymentSortingBankTests(): List<DynamicTest> {
        val user = bankOperator
        return EntityTestGenerator.generate(
            listOf(
                RuPaymentSortingTest(user, DOCUMENT_NUMBER::asc).withId(T3751::class),
                RuPaymentSortingTest(user, DOCUMENT_DATE::asc).withId(T3752::class),
                RuPaymentSortingTest(user, CUSTOMER_ID::asc).withId(T3753::class),
                RuPaymentSortingTest(user, BRANCH_ID::asc).withId(T3754::class),
                RuPaymentSortingTest(user, STATUS::asc).withId(T3755::class),
                RuPaymentSortingTest(user, AMOUNT::asc).withId(T3756::class),
                RuPaymentSortingTest(user, PAYMENT_GROUND_DESCRIPTION::asc).withId(T3757::class),
                RuPaymentSortingTest(user, RECEIVER_NAME::asc).withId(T3758::class),
                RuPaymentSortingTest(user, RECEIVER_INN::asc).withId(T3759::class),
                RuPaymentSortingTest(user, RECEIVER_ACCOUNT::asc).withId(T3760::class),
                RuPaymentSortingTest(user, RECEIVER_BANK_NAME::asc).withId(T3761::class),
                RuPaymentSortingTest(user, RECEIVER_BANK_BIC::asc).withId(T3762::class),

                RuPaymentSortingTest(user, DOCUMENT_NUMBER::desc).withId(T3763::class),
                RuPaymentSortingTest(user, DOCUMENT_DATE::desc).withId(T3764::class),
                RuPaymentSortingTest(user, CUSTOMER_ID::desc).withId(T3765::class),
                RuPaymentSortingTest(user, BRANCH_ID::desc).withId(T3766::class),
                RuPaymentSortingTest(user, STATUS::desc).withId(T3767::class),
                RuPaymentSortingTest(user, AMOUNT::desc).withId(T3768::class),
                RuPaymentSortingTest(user, PAYMENT_GROUND_DESCRIPTION::desc).withId(T3769::class),
                RuPaymentSortingTest(user, RECEIVER_NAME::desc).withId(T3770::class),
                RuPaymentSortingTest(user, RECEIVER_INN::desc).withId(T3771::class),
                RuPaymentSortingTest(user, RECEIVER_ACCOUNT::desc).withId(T3772::class),
                RuPaymentSortingTest(user, RECEIVER_BANK_NAME::desc).withId(T3773::class),
                RuPaymentSortingTest(user, RECEIVER_BANK_BIC::desc).withId(T3774::class)
            )
        )
    }
}