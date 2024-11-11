package ooo.jtc.be.rupayment

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_RUPAYMENT_CRUD
import ooo.jtc.api.rupayment.prepare.RuPaymentTemplates
import ooo.jtc.api.rupayment.tests.RuPaymentCreateTest
import ooo.jtc.api.rupayment.tests.RuPaymentDeleteTest
import ooo.jtc.api.rupayment.tests.RuPaymentGetPageTest
import ooo.jtc.api.rupayment.tests.RuPaymentGetTest
import ooo.jtc.api.rupayment.tests.RuPaymentUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryRuPayment
import ooo.jtc.generic.DocumentNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.Users.client
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.RUPAYMENT)
@Story(TestStoryRuPayment.RUPAYMENT_CRUD)
@DisplayName("API '${DocumentNames.RU_PAYMENT}' CRUD suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_RUPAYMENT_CRUD
class RuPaymentCrudTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3799") annotation class T3799
@Tag("JTCSALTO-T3800") annotation class T3800
@Tag("JTCSALTO-T3801") annotation class T3801
@Tag("JTCSALTO-T3802") annotation class T3802
@Tag("JTCSALTO-T3803") annotation class T3803
@Tag("JTCSALTO-T3804") annotation class T3804
@Tag("JTCSALTO-T3805") annotation class T3805
@Tag("JTCSALTO-T3806") annotation class T3806
@Tag("JTCSALTO-T3807") annotation class T3807
@Tag("JTCSALTO-T3808") annotation class T3808
@Tag("JTCSALTO-T3809") annotation class T3809
@Tag("JTCSALTO-T3810") annotation class T3810
@Tag("JTCSALTO-T3811") annotation class T3811
@Tag("JTCSALTO-T3812") annotation class T3812
@Tag("JTCSALTO-T3813") annotation class T3813
@Tag("JTCSALTO-T3814") annotation class T3814
//@formatter:on
//endregion

    @TestFactory
    @T3799 //'Рублевое ПП'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3800 //'Рублевое ПП'. CRUD: Получаем страницу записей от пользователя [BANK]
    internal fun ruPaymentCrudBankTests(): List<DynamicTest> {

        return EntityTestGenerator.generate(
            listOf(
                RuPaymentGetTest(Users.bankOperator).withId(T3799::class),
                RuPaymentGetPageTest(Users.bankOperator).withId(T3800::class)
            )
        )
    }

    @TestFactory
    @T3801 //'Рублевое ПП'. CRUD: Создание рублевого платежного поручения [BUSINESS]
    @T3802 //'Рублевое ПП'. CRUD: Создание рублевого платежного поручения [PERSON]
    @T3803 //'Рублевое ПП'. CRUD: Создание рублевого платежного поручения [BUDGET]
    @T3804 //'Рублевое ПП'. CRUD: Создание рублевого платежного поручения [TAX]
    @T3805 //'Рублевое ПП'. CRUD: Создание рублевого платежного поручения [CUSTOM]
    @T3806 //'Рублевое ПП'. CRUD: Создание рублевого платежного поручения [OWNACCOUNTS]
    @T3807 //'Рублевое ПП'. CRUD: Создание рублевого платежного поручения [OTHER/null]
    @T3808 //'Рублевое ПП'. CRUD: Создание рублевого платежного поручения [OTHER/TAX]
    @T3809 //'Рублевое ПП'. CRUD: Создание рублевого платежного поручения [OTHER/CUSTOM]
    @T3810 //'Рублевое ПП'. CRUD: Создание рублевого платежного поручения [OTHER/OTHER]

    @T3811 //'Рублевое ПП'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T3812 //'Рублевое ПП'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T3813 //'Рублевое ПП'. CRUD: Обновляем запись от пользователя [CLIENT]
    @T3814 //'Рублевое ПП'. CRUD: Удаляем запись от пользователя [CLIENT]
    @Execution(ExecutionMode.SAME_THREAD)
    internal fun ruPaymentCrudClientTests(): List<DynamicTest> {
        val clientUser = client
        return EntityTestGenerator.generate(
            listOf(
                RuPaymentCreateTest(clientUser, nameDetails = " [BUSINESS]",
                    dtoForCreation = { RuPaymentTemplates.getBusinessRuPayment(clientUser) }).withId(T3801::class),
                RuPaymentCreateTest(clientUser, nameDetails = " [PERSON]",
                    dtoForCreation = { RuPaymentTemplates.getPersonRuPayment(clientUser) }).withId(T3802::class),
                //TODO A.Stykalin [29.06.2020] Disabled. Postponed to backlog. Need more time to fix.
//                RuPaymentCreateTest(clientUser, nameDetails = " [BUDGET]",
//                    dtoForCreation = { RuPaymentTemplates.getBudgetRuPayment(clientUser) }).withId(T3803::class),
//                RuPaymentCreateTest(clientUser, nameDetails = " [TAX]",
//                    dtoForCreation = { RuPaymentTemplates.getTaxRuPayment(clientUser) }).withId(T3804::class),
//                RuPaymentCreateTest(clientUser, nameDetails = " [CUSTOM]",
//                    dtoForCreation = { RuPaymentTemplates.getCustomRuPayment(clientUser) }).withId(T3805::class),
                RuPaymentCreateTest(clientUser, nameDetails = " [OWNACCOUNTS]",
                    dtoForCreation = { RuPaymentTemplates.getOwnAccountsRuPayment(clientUser) }).withId(T3806::class),
//                RuPaymentCreateTest(clientUser, nameDetails = " [OTHER/null]",
//                    dtoForCreation = { RuPaymentTemplates.getOtherRuPayment(clientUser) }).withId(T3807::class),
//                RuPaymentCreateTest(clientUser, nameDetails = " [OTHER/TAX]",
//                    dtoForCreation = { RuPaymentTemplates.getOtherTaxRuPayment(clientUser) }).withId(T3808::class),
//                RuPaymentCreateTest(clientUser, nameDetails = " [OTHER/CUSTOM]",
//                    dtoForCreation = { RuPaymentTemplates.getOtherCustomRuPayment(clientUser) }).withId(T3809::class),
//                RuPaymentCreateTest(clientUser, nameDetails = " [OTHER/OTHER]",
//                    dtoForCreation = { RuPaymentTemplates.getOtherOtherRuPayment(clientUser) }).withId(T3810::class),
                RuPaymentGetTest(clientUser).withId(T3811::class),
                RuPaymentGetPageTest(clientUser).withId(T3812::class),
                RuPaymentUpdateTest(clientUser).withId(T3813::class),
                RuPaymentDeleteTest(clientUser).withId(T3814::class)
            )
        )
    }
}