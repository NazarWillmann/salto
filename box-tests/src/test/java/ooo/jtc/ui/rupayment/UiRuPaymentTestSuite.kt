package ooo.jtc.ui.rupayment

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.UI_RUPAYMENT
import ooo.jtc.UI_RUPAYMENT_COPY
import ooo.jtc.UI_RUPAYMENT_CREATE
import ooo.jtc.UI_RUPAYMENT_DELETE
import ooo.jtc.UI_RUPAYMENT_SEND
import ooo.jtc.UI_RUPAYMENT_SIGN
import ooo.jtc.api.rupayment.prepare.RuPaymentTemplates
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.DocumentNames
import ooo.jtc.ui.rupayment.RuPaymentTests.UiRuPaymentCopyTest
import ooo.jtc.ui.rupayment.RuPaymentTests.UiRuPaymentDeleteTest
import ooo.jtc.ui.rupayment.RuPaymentTests.UiRuPaymentSendTest
import ooo.jtc.ui.rupayment.RuPaymentTests.UiRuPaymentSignTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode


@Epic(TestEpic.UI)
@Feature(TestFeature.RUPAYMENT)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("UI. ${DocumentNames.RU_PAYMENT} тесты на базовые операции")
@UI_RUPAYMENT
class UiRuPaymentTestSuite {

    //TODO A.Stykalin [16.09.2020] need actualization

    // @TestFactory
    @Story("Создание ${DocumentNames.RU_PAYMENT}")
    @UI_RUPAYMENT_CREATE
    @Tags(
        Tag("JTCSALTO-T1686"),
        Tag("JTCSALTO-T1691"),
        Tag("JTCSALTO-T1692"),
        Tag("JTCSALTO-T1695"),
        Tag("JTCSALTO-T1696"),
        Tag("JTCSALTO-T1698"),
        Tag("JTCSALTO-T1699"),
        Tag("JTCSALTO-T1700"),
        Tag("JTCSALTO-T1701")
    )
    @DisplayName("Создание ${DocumentNames.RU_PAYMENT}")
    fun createRuPayment(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                //TODO A.Stykalin [12.08.2020] actualize after changing UI-kit
//                RuPaymentCreateTest(
//                    name = "Перевод юридическим лицам и ИП (BUSINESS). Создание ПП ",
//                    ruPaymentDto = RuPaymentTemplates.getBusinessRuPayment()
//                ).withId("JTCSALTO-T1686")
//                ,
//                RuPaymentCreateTest(
//                    name = "Платеж физическому лицу (PERSON). Создание ПП ", ruPaymentDto = RuPaymentTemplates.getPersonRuPayment()
//                ).withId("JTCSALTO-T1691"),
//                RuPaymentCreateTest(
//                    name = "Платеж в бюджетную организацию (BUDGET). Создание ПП",
//                    ruPaymentDto = RuPaymentTemplates.getBudgetRuPayment()
//                ).withId("JTCSALTO-T1692"),
//                RuPaymentCreateTest(name = "Оплата налогов и сборов (TAX). Создание ПП", ruPaymentDto = RuPaymentTemplates.getTaxRuPayment())
//                    .withId("JTCSALTO-T1695"),
//                RuPaymentCreateTest(
//                    name = "Оплата таможенных пошлин (CUSTOM). Создание ПП", ruPaymentDto = RuPaymentTemplates.getCustomRuPayment()
//                ).withId("JTCSALTO-T1696"),
//                RuPaymentCreateTest(
//                    name = "Платеж по свободным реквизитам (OTHER). Создание ПП. Платеж в бюджет = Нет ", ruPaymentDto =
//                    RuPaymentTemplates.getOtherRuPayment()
//                ).withId("JTCSALTO-T1698"),
//                RuPaymentCreateTest(
//                    name = "Платеж по свободным реквизитам (OTHER). Создание ПП. Платеж в бюджет = Налоговый", ruPaymentDto =
//                    RuPaymentTemplates.getOtherTaxRuPayment()
//                ).withId("JTCSALTO-T1699"),
//                RuPaymentCreateTest(
//                    name = " Платеж по свободным реквизитам (OTHER). Создание ПП. Платеж в бюджет = Таможенный", ruPaymentDto =
//                    RuPaymentTemplates.getOtherCustomRuPayment()
//                ).withId("JTCSALTO-T1700"),
//                RuPaymentCreateTest(
//                    name = " Платеж по свободным реквизитам (OTHER). Создание ПП. Платеж в бюджет = Иной", ruPaymentDto =
//                    RuPaymentTemplates.getOtherOtherRuPayment()
//                ).withId("JTCSALTO-T1701")
            )
        )
    }


    // @TestFactory
    @Story("Копирование ${DocumentNames.RU_PAYMENT}")
    @UI_RUPAYMENT_COPY
    @Tags(
        Tag("JTCSALTO-T1688"),
        Tag("JTCSALTO-T1694"),
        Tag("JTCSALTO-T1695"),
        Tag("JTCSALTO-T1697")
    )

    @DisplayName("Копирование ${DocumentNames.RU_PAYMENT}")
    fun copyRuPayment(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                UiRuPaymentCopyTest(
                    name = "Перевод юридическим лицам и ИП (BUSINESS). Копирование ПП",
                    ruPaymentDto = RuPaymentTemplates.getBusinessRuPayment()
                ).withId("JTCSALTO-T1688"),
                UiRuPaymentCopyTest(
                    name = "Платеж в бюджетную организацию (BUDGET). Копирование ПП",
                    ruPaymentDto = RuPaymentTemplates.getBudgetRuPayment()
                ).withId("JTCSALTO-T1694"),
                UiRuPaymentCopyTest(
                    name = "Оплата налогов и сборов (TAX). Копирование ПП ",
                    ruPaymentDto = RuPaymentTemplates.getTaxRuPayment()
                ).withId("JTCSALTO-T1695"),
                UiRuPaymentCopyTest(
                    name = "Оплата таможенных пошлин (CUSTOM). Копирование ПП",
                    ruPaymentDto = RuPaymentTemplates.getCustomRuPayment()
                ).withId("JTCSALTO-T1697")
            )
        )
    }

    // @TestFactory
    @Story("Подписание ${DocumentNames.RU_PAYMENT}")
    @UI_RUPAYMENT_SIGN
    @Tag("JTCSALTO-T1689")
    @DisplayName("Подписание ${DocumentNames.RU_PAYMENT}")
    fun signRuPayment(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                UiRuPaymentSignTest(
                    name = "Перевод юридическим лицам и ИП (BUSINESS). Подписание ПП",
                    ruPaymentDto = RuPaymentTemplates.getBusinessRuPayment()
                ).withId("JTCSALTO-T1689")
            )
        )
    }

    // @TestFactory
    @Story("Удаление ${DocumentNames.RU_PAYMENT}")
    @UI_RUPAYMENT_DELETE
    @Tags(
        Tag("JTCSALTO-T1702"),
        Tag("JTCSALTO-T1687")
    )
    @DisplayName("Удаление ${DocumentNames.RU_PAYMENT}")
    fun deleteRuPayment(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                UiRuPaymentDeleteTest(
                    name = "Платеж в бюджетную организацию (BUDGET). Скроллер. Удаление ПП",
                    ruPaymentDto = RuPaymentTemplates.getBudgetRuPayment()
                ).withId("JTCSALTO-T1702"),
                UiRuPaymentDeleteTest(
                    name = "Перевод юридическим лицам и ИП (BUSINESS). Форма просмотра. Удаление ПП ",
                    ruPaymentDto = RuPaymentTemplates.getBusinessRuPayment()
                ).withId("JTCSALTO-T1687")
            )
        )
    }

    //@TestFactory
    @Story("Отправка ${DocumentNames.RU_PAYMENT}")
    @UI_RUPAYMENT_SEND
    @Tag("JTCSALTO-T1690")
    @DisplayName("Отправка ${DocumentNames.RU_PAYMENT}")
    fun sendRuPayment(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            UiRuPaymentSendTest(
                name = "Перевод юридическим лицам и ИП (BUSINESS). Скроллер. Отправка ПП в банк",
                ruPaymentDto = RuPaymentTemplates.getBudgetRuPayment()
            ).withId("JTCSALTO-T1690")
        )
    }

}