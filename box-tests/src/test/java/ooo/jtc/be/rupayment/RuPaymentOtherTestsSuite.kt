package ooo.jtc.be.rupayment

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_RUPAYMENT_OTHER
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.rupayment.RuPaymentChecks
import ooo.jtc.api.rupayment.RuPaymentSteps
import ooo.jtc.api.rupayment.prepare.RuPaymentPrepareSteps
import ooo.jtc.api.rupayment.prepare.RuPaymentPrepareSteps.getOrCreateRuPaymentDto
import ooo.jtc.api.rupayment.prepare.RuPaymentPrepareSteps.getRuPaymentDto
import ooo.jtc.api.rupayment.tests.FEATURE_RU_PAYMENT_PREFILL
import ooo.jtc.api.rupayment.tests.RuPaymentAddToFavoritesTest
import ooo.jtc.api.rupayment.tests.RuPaymentFolderOther
import ooo.jtc.api.rupayment.tests.RuPaymentRemoveFromFavoritesTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryRuPayment
import ooo.jtc.core.tm4j.Tm4jComponent
import ooo.jtc.core.tm4j.Tm4jEpic
import ooo.jtc.core.tm4j.Tm4jPriority
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.pageparams.toParams
import ooo.jtc.interfaces.getOrException
import ooo.jtc.rupayment.model.UserPaymentType
import ooo.jtc.rupayment.model.UserPaymentType.BUDGET
import ooo.jtc.rupayment.model.UserPaymentType.BUSINESS
import ooo.jtc.rupayment.model.UserPaymentType.CUSTOM
import ooo.jtc.rupayment.model.UserPaymentType.OTHER
import ooo.jtc.rupayment.model.UserPaymentType.OWNACCOUNTS
import ooo.jtc.rupayment.model.UserPaymentType.PERSON
import ooo.jtc.rupayment.model.UserPaymentType.TAX
import ooo.jtc.testdata.Users.bankOperator
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.rupayment.RuPaymentFilterParams
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.RUPAYMENT)
@Story(TestStoryRuPayment.RUPAYMENT_OTHER)
@DisplayName("API '${DocumentNames.RU_PAYMENT}' other suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_RUPAYMENT_OTHER
class RuPaymentOtherTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T1740") annotation class T1740
@Tag("JTCSALTO-T1741") annotation class T1741
@Tag("JTCSALTO-T3919") annotation class T3919
@Tag("JTCSALTO-T3920") annotation class T3920
@Tag("JTCSALTO-T3921") annotation class T3921
@Tag("JTCSALTO-T3922") annotation class T3922
@Tag("JTCSALTO-T3923") annotation class T3923
@Tag("JTCSALTO-T3924") annotation class T3924
@Tag("JTCSALTO-T3925") annotation class T3925
@Tag("JTCSALTO-T3926") annotation class T3926
@Tag("JTCSALTO-T3927") annotation class T3927
//@formatter:on
//endregion

    private val clientUser = client
    private val bankUser = bankOperator

    @TestFactory
    @T1740 //'Рублевое ПП': Добавить в избранное [CLIENT]
    @T1741 //'Рублевое ПП': Удалить из избранного [CLIENT]
    @T3926 //'Рублевое ПП': Добавить в избранное [BANK]
    @T3927 //'Рублевое ПП': Удалить из избранного [BANK]
    internal fun ruPaymentFavoriteTests(): List<DynamicTest> {
        val notFavoriteParams = RuPaymentFilterParams.IS_FAVORITES.eq(false).toParams()
        val favoriteParams = RuPaymentFilterParams.IS_FAVORITES.eq(true).toParams()
        val createNonFavoriteDto = { RuPaymentPrepareSteps.createRuPaymentDto(clientUser) }
        val createFavoriteDto =
            { RuPaymentPrepareSteps.createRuPaymentDto(clientUser, getRuPaymentDto(clientUser, BUSINESS).apply { isFavorites = true }) }
        val createBankNonFavoriteDto = { RuPaymentPrepareSteps.createSentRuPaymentDto(clientUser) }
        val createBankFavoriteDto = {
            val nonFavRuPayment = RuPaymentPrepareSteps.createSentRuPaymentDto(clientUser)
            RuPaymentSteps(bankUser).addToFavorites(nonFavRuPayment.id!!)
                .data.getOrException()
        }

        return EntityTestGenerator.generate(
            listOf(
                RuPaymentAddToFavoritesTest(clientUser,
                    preExecution = { getOrCreateRuPaymentDto(clientUser, notFavoriteParams, createNonFavoriteDto).id!! }
                ).withId(T1740::class),
                RuPaymentRemoveFromFavoritesTest(clientUser,
                    preExecution = { getOrCreateRuPaymentDto(clientUser, favoriteParams, createFavoriteDto).id!! }
                ).withId(T1741::class),
                RuPaymentAddToFavoritesTest(bankUser,
                    preExecution = { getOrCreateRuPaymentDto(bankUser, notFavoriteParams, createBankNonFavoriteDto).id!! }
                ).withId(T3926::class),
                RuPaymentRemoveFromFavoritesTest(bankUser,
                    preExecution = { getOrCreateRuPaymentDto(bankUser, favoriteParams, createBankFavoriteDto).id!! }
                ).withId(T3927::class)
            )
        )
    }

    @Execution(ExecutionMode.SAME_THREAD)
    @TestFactory
    @T3919 //Рублевое ПП. Предзаполнение по типу платежа "BUSINESS"
    @T3920 //Рублевое ПП. Предзаполнение по типу платежа "PERSON"
    @T3921 //Рублевое ПП. Предзаполнение по типу платежа "BUDGET"
    @T3922 //Рублевое ПП. Предзаполнение по типу платежа "TAX"
    @T3923 //Рублевое ПП. Предзаполнение по типу платежа "CUSTOM"
    @T3924 //Рублевое ПП. Предзаполнение по типу платежа "OWNACCOUNTS"
    @T3925 //Рублевое ПП. Предзаполнение по типу платежа "OTHER"
    internal fun ruPaymentPreFillForUserPaymentTypeTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ruPaymentPreFillForUserPaymentTypeTest(BUSINESS).withId(T3919::class),
                ruPaymentPreFillForUserPaymentTypeTest(PERSON).withId(T3920::class),
                ruPaymentPreFillForUserPaymentTypeTest(BUDGET).withId(T3921::class),
                ruPaymentPreFillForUserPaymentTypeTest(TAX).withId(T3922::class),
                ruPaymentPreFillForUserPaymentTypeTest(CUSTOM).withId(T3923::class),
                ruPaymentPreFillForUserPaymentTypeTest(OWNACCOUNTS).withId(T3924::class),
                ruPaymentPreFillForUserPaymentTypeTest(OTHER).withId(T3925::class)
            ).map {
                it
                    .withComponent(Tm4jComponent.RU_PAYMENT)
                    .withFolder(RuPaymentFolderOther::class)
                    .withPriority(Tm4jPriority.Normal)
                    .withTaskIds(Tm4jEpic.EPIC_R_RKO_PAYMENT, FEATURE_RU_PAYMENT_PREFILL, "JTCSALTO-1170")
            }
        )
    }

    private fun ruPaymentPreFillForUserPaymentTypeTest(uPaymentType: UserPaymentType): UnitBeTest {
        return UnitBeTest(
            name = "${DocumentNames.RU_PAYMENT}. Предзаполнение по типу платежа \"$uPaymentType\"",
            params = { mapOf("Тип платежа" to uPaymentType, PARAM_USER to clientUser) },
            testBody = {
                val actPreFilledDto = RuPaymentSteps(clientUser).preFillForUserPaymentType(uPaymentType).data
                    .getOrException("Ошибка при получении пердзаполненного ПП")
                RuPaymentChecks.checkPreFillForUserPaymentType(RuPaymentPrepareSteps.preparePreFilled(uPaymentType), actPreFilledDto)
            }
        )
    }

}