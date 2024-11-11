package ooo.jtc.be.rupayment

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_RUPAYMENT_FILTRATION
import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.rupayment.RuPaymentSteps
import ooo.jtc.api.rupayment.prepare.RuPaymentPrepareSteps
import ooo.jtc.api.rupayment.tests.RuPaymentFiltrationTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryRuPayment
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.amount
import ooo.jtc.generic.pageparams.Predicate
import ooo.jtc.generic.pageparams.and
import ooo.jtc.rupayment.dto.RuPaymentDto
import ooo.jtc.testdata.Users.bankOperator
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.rupayment.RuPaymentFilterParams
import ooo.jtc.testdata.rupayment.RuPaymentFilterParams.BRANCH_ID
import ooo.jtc.testdata.rupayment.RuPaymentFilterParams.CUSTOMER_ID
import ooo.jtc.testdata.rupayment.RuPaymentFilterParams.DOCUMENT_DATE
import ooo.jtc.testdata.rupayment.RuPaymentFilterParams.DOCUMENT_NUMBER
import ooo.jtc.uaa.User
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

@Epic(TestEpic.API)
@Feature(TestFeature.RUPAYMENT)
@Story(TestStoryRuPayment.RUPAYMENT_FILTRATION)
@DisplayName("API '${DocumentNames.RU_PAYMENT}' filtration suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_RUPAYMENT_FILTRATION
@TestInstance(PER_CLASS)
class RuPaymentFiltrationTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3721") annotation class T3721
@Tag("JTCSALTO-T3722") annotation class T3722
@Tag("JTCSALTO-T3723") annotation class T3723
@Tag("JTCSALTO-T3724") annotation class T3724
@Tag("JTCSALTO-T3725") annotation class T3725
@Tag("JTCSALTO-T3726") annotation class T3726
@Tag("JTCSALTO-T3727") annotation class T3727
@Tag("JTCSALTO-T3728") annotation class T3728
@Tag("JTCSALTO-T3729") annotation class T3729
@Tag("JTCSALTO-T3730") annotation class T3730
@Tag("JTCSALTO-T3731") annotation class T3731
@Tag("JTCSALTO-T3732") annotation class T3732
@Tag("JTCSALTO-T3733") annotation class T3733
@Tag("JTCSALTO-T3734") annotation class T3734
@Tag("JTCSALTO-T3735") annotation class T3735
@Tag("JTCSALTO-T3736") annotation class T3736
@Tag("JTCSALTO-T3737") annotation class T3737
@Tag("JTCSALTO-T3738") annotation class T3738
@Tag("JTCSALTO-T3739") annotation class T3739
@Tag("JTCSALTO-T3740") annotation class T3740
@Tag("JTCSALTO-T3741") annotation class T3741
@Tag("JTCSALTO-T3742") annotation class T3742
@Tag("JTCSALTO-T3743") annotation class T3743
@Tag("JTCSALTO-T3744") annotation class T3744
@Tag("JTCSALTO-T3745") annotation class T3745
@Tag("JTCSALTO-T3746") annotation class T3746
@Tag("JTCSALTO-T3747") annotation class T3747
@Tag("JTCSALTO-T3748") annotation class T3748
@Tag("JTCSALTO-T3749") annotation class T3749
@Tag("JTCSALTO-T3750") annotation class T3750
//@formatter:on
//endregion

    private lateinit var dtoForFiltration: RuPaymentDto

    @BeforeAll
    fun prepareDataForRuPaymentFiltrationTests() {
        dtoForFiltration = RuPaymentPrepareSteps.createRuPaymentDto(client)
            .attachToAllure()
    }

    @AfterAll
    fun clearDataForRuPaymentFiltrationTests() {
        RuPaymentSteps(client).delete(dtoForFiltration.id!!)
    }

    //region Tests
    private val docNumberContainsTest = { user: User ->
        RuPaymentFiltrationTest(
            name = "documentNumber ${Predicate.CONTAINS}",
            user = user,
            preExecution = { dtoForFiltration },
            filterRequestFunction = { DOCUMENT_NUMBER.contains(it!!.documentNumber.randomSubstringPf()) })
    }

    private val docDateGeFiltrationTest = { user: User ->
        RuPaymentFiltrationTest(
            "documentDate ${Predicate.GE}",
            user,
            { dtoForFiltration },
            { DOCUMENT_DATE.ge(it!!.documentDate.minusDays(1)) })
    }

    private val docDateLeFiltrationTest = { user: User ->
        RuPaymentFiltrationTest(
            "documentDate ${Predicate.LE}",
            user,
            { dtoForFiltration },
            { DOCUMENT_DATE.le(it!!.documentDate.plusDays(1)) })
    }
    private val docDateLeGeFiltrationTest = { user: User ->
        RuPaymentFiltrationTest(
            "documentDate ${Predicate.LE} + ${Predicate.GE}",
            user,
            { dtoForFiltration },
            { DOCUMENT_DATE.ge(it!!.documentDate.minusDays(1)).and(DOCUMENT_DATE.le(it.documentDate.plusDays(1))) })
    }
    private val payGroundDescriptionContainsFiltrationTest = { user: User ->
        RuPaymentFiltrationTest(
            "paymentGround description ${Predicate.CONTAINS}",
            user,
            { dtoForFiltration },
            { RuPaymentFilterParams.PAYMENT_GROUND_DESCRIPTION.contains(it!!.paymentGround!!.description!!.randomSubstringPf()) })
    }
    private val amountGeFiltrationTest = { user: User ->
        RuPaymentFiltrationTest(
            "amount ${Predicate.GE}",
            user,
            { dtoForFiltration },
            { RuPaymentFilterParams.AMOUNT.ge(amount(it!!.amount).minus(amount("10"))) })
    }
    private val amountLeFiltrationTest = { user: User ->
        RuPaymentFiltrationTest(
            "amount ${Predicate.LE}",
            user,
            { dtoForFiltration },
            { RuPaymentFilterParams.AMOUNT.le(amount(it!!.amount).plus(amount("10"))) })
    }
    private val amountElGeFiltrationTest = { user: User ->
        RuPaymentFiltrationTest(
            "amount ${Predicate.LE} + ${Predicate.GE}",
            user,
            { dtoForFiltration },
            {
                RuPaymentFilterParams.AMOUNT.le(amount(it!!.amount).plus(amount("10")))
                    .and(RuPaymentFilterParams.AMOUNT.ge(amount(it.amount).minus(amount("10"))))
            })
    }
    private val receiverNameContainsFiltrationTest = { user: User ->
        RuPaymentFiltrationTest(
            "receiver name ${Predicate.CONTAINS}",
            user,
            { dtoForFiltration },
            { RuPaymentFilterParams.RECEIVER_NAME.contains(it!!.receiver!!.name!!.randomSubstringPf()) })
    }
    private val receiverInnContainsFiltrationTest = { user: User ->
        RuPaymentFiltrationTest(
            "receiver inn ${Predicate.CONTAINS}",
            user,
            { dtoForFiltration },
            { RuPaymentFilterParams.RECEIVER_INN.contains(it!!.receiver!!.inn!!.randomSubstringPf()) })
    }
    private val receiverAccountContainsFiltrationTest = { user: User ->
        RuPaymentFiltrationTest(
            "receiver account ${Predicate.CONTAINS}",
            user,
            { dtoForFiltration },
            { RuPaymentFilterParams.RECEIVER_ACCOUNT.contains(it!!.receiver!!.account!!.randomSubstringPf()) })
    }
    private val receiverBankNameContainsFiltrationTest = { user: User ->
        RuPaymentFiltrationTest(
            "receiver bank name ${Predicate.CONTAINS}",
            user,
            { dtoForFiltration },
            { RuPaymentFilterParams.RECEIVER_BANK_NAME.contains(it!!.receiver!!.bank.name!!.randomSubstringPf()) })
    }
    private val receiverBankBicContainsFiltrationTest = { user: User ->
        RuPaymentFiltrationTest(
            "receiver bank bic ${Predicate.CONTAINS}",
            user,
            { dtoForFiltration },
            { RuPaymentFilterParams.RECEIVER_BANK_BIC.contains(it!!.receiver!!.bank.bic!!.randomSubstringPf()) })
    }
    private val branchIdEqFiltrationTest = { user: User ->
        RuPaymentFiltrationTest(
            "branchId ${Predicate.EQ}",
            user,
            { dtoForFiltration },
            { BRANCH_ID.eq(it!!.branchId!!) })
    }
    private val customerIdEqFiltrationTest = { user: User ->
        RuPaymentFiltrationTest(
            "customerId ${Predicate.EQ}",
            user,
            { dtoForFiltration },
            { CUSTOMER_ID.eq(it!!.customerId!!) })
    }
    //endregion


    @TestFactory
    @T3721 //'Рублевое ПП'. Фильтрация по полю 'documentNumber' (contains) [CLIENT]
    @T3722 //'Рублевое ПП'. Фильтрация по полю 'documentDate' (ge) [CLIENT]
    @T3723 //'Рублевое ПП'. Фильтрация по полю 'documentDate' (le) [CLIENT]
    @T3724 //'Рублевое ПП'. Фильтрация по полю 'documentDate' ge and 'documentDate' le [CLIENT]
    @T3725 //'Рублевое ПП'. Фильтрация по полю 'paymentGround.description' (contains) [CLIENT]
    @T3726 //'Рублевое ПП'. Фильтрация по полю 'amount' (ge) [CLIENT]
    @T3727 //'Рублевое ПП'. Фильтрация по полю 'amount' (le) [CLIENT]
    @T3728 //'Рублевое ПП'. Фильтрация по полю 'amount' le and 'amount' ge [CLIENT]
    @T3729 //'Рублевое ПП'. Фильтрация по полю 'receiver.name' (contains) [CLIENT]
    @T3730 //'Рублевое ПП'. Фильтрация по полю 'receiver.innKio' (contains) [CLIENT]
    @T3731 //'Рублевое ПП'. Фильтрация по полю 'receiver.account' (contains) [CLIENT]
    @T3732 //'Рублевое ПП'. Фильтрация по полю 'receiver.bank.name' (contains) [CLIENT]
    @T3733 //'Рублевое ПП'. Фильтрация по полю 'receiver.bank.bic' (contains) [CLIENT]
    @T3734 //'Рублевое ПП'. Фильтрация по полю 'branchId' (eq) [CLIENT]
    @T3735 //'Рублевое ПП'. Фильтрация по полю 'customerId' (eq) [CLIENT]
    internal fun ruPaymentClientFiltrationTests(): List<DynamicTest> {
        val user = client
        return EntityTestGenerator.generate(
            listOf(
                docNumberContainsTest.invoke(user).withId(T3721::class),
                docDateGeFiltrationTest.invoke(user).withId(T3722::class),
                docDateLeFiltrationTest.invoke(user).withId(T3723::class),
                docDateLeGeFiltrationTest.invoke(user).withId(T3724::class),
                payGroundDescriptionContainsFiltrationTest.invoke(user).withId(T3725::class),
                amountGeFiltrationTest.invoke(user).withId(T3726::class),
                amountLeFiltrationTest.invoke(user).withId(T3727::class),
                amountElGeFiltrationTest.invoke(user).withId(T3728::class),
                receiverNameContainsFiltrationTest.invoke(user).withId(T3729::class),
                receiverInnContainsFiltrationTest.invoke(user).withId(T3730::class),
                receiverAccountContainsFiltrationTest.invoke(user).withId(T3731::class),
                receiverBankNameContainsFiltrationTest.invoke(user).withId(T3732::class),
                receiverBankBicContainsFiltrationTest.invoke(user).withId(T3733::class),
                branchIdEqFiltrationTest.invoke(user).withId(T3734::class),
                customerIdEqFiltrationTest.invoke(user).withId(T3735::class)
            )
        )
    }


    //    @TestFactory
    @T3736 //'Рублевое ПП'. Фильтрация по полю 'documentNumber' (contains) [BANK]
    @T3737 //'Рублевое ПП'. Фильтрация по полю 'documentDate' (ge) [BANK]
    @T3738 //'Рублевое ПП'. Фильтрация по полю 'documentDate' (le) [BANK]
    @T3739 //'Рублевое ПП'. Фильтрация по полю 'documentDate' ge and 'documentDate' le [BANK]
    @T3740 //'Рублевое ПП'. Фильтрация по полю 'paymentGround.description' (contains) [BANK]
    @T3741 //'Рублевое ПП'. Фильтрация по полю 'amount' (ge) [BANK]
    @T3742 //'Рублевое ПП'. Фильтрация по полю 'amount' (le) [BANK]
    @T3743 //'Рублевое ПП'. Фильтрация по полю 'amount' le and 'amount' ge [BANK]
    @T3744 //'Рублевое ПП'. Фильтрация по полю 'receiver.name' (contains) [BANK]
    @T3745 //'Рублевое ПП'. Фильтрация по полю 'receiver.innKio' (contains) [BANK]
    @T3746 //'Рублевое ПП'. Фильтрация по полю 'receiver.account' (contains) [BANK]
    @T3747 //'Рублевое ПП'. Фильтрация по полю 'receiver.bank.name' (contains) [BANK]
    @T3748 //'Рублевое ПП'. Фильтрация по полю 'receiver.bank.bic' (contains) [BANK]
    @T3749 //'Рублевое ПП'. Фильтрация по полю 'branchId' (eq) [BANK]
    @T3750 //'Рублевое ПП'. Фильтрация по полю 'customerId' (eq) [BANK]
    internal fun ruPaymentBankFiltrationTests(): List<DynamicTest> {
        val user = bankOperator
        return EntityTestGenerator.generate(
            listOf(
                docNumberContainsTest.invoke(user).withId(T3736::class),
                docDateGeFiltrationTest.invoke(user).withId(T3737::class),
                docDateLeFiltrationTest.invoke(user).withId(T3738::class),
                docDateLeGeFiltrationTest.invoke(user).withId(T3739::class),
                payGroundDescriptionContainsFiltrationTest.invoke(user).withId(T3740::class),
                amountGeFiltrationTest.invoke(user).withId(T3741::class),
                amountLeFiltrationTest.invoke(user).withId(T3742::class),
                amountElGeFiltrationTest.invoke(user).withId(T3743::class),
                receiverNameContainsFiltrationTest.invoke(user).withId(T3744::class),
                receiverInnContainsFiltrationTest.invoke(user).withId(T3745::class),
                receiverAccountContainsFiltrationTest.invoke(user).withId(T3746::class),
                receiverBankNameContainsFiltrationTest.invoke(user).withId(T3747::class),
                receiverBankBicContainsFiltrationTest.invoke(user).withId(T3748::class),
                branchIdEqFiltrationTest.invoke(user).withId(T3749::class),
                customerIdEqFiltrationTest.invoke(user).withId(T3750::class)
            )
        )
    }
}