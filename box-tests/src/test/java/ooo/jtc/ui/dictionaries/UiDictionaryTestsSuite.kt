package ooo.jtc.ui.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.UI_DICTIONARY_BUDGETPAYERSTATUS
import ooo.jtc.UI_DICTIONARY_BUDGETREASONCODE
import ooo.jtc.UI_DICTIONARY_CODEVO
import ooo.jtc.UI_DICTIONARY_KBK
import ooo.jtc.UI_DICTIONARY_PAYMENTPRIORITY
import ooo.jtc.UI_DICTIONARY_PAYMENTTYPE
import ooo.jtc.UI_DICTIONARY_STATEMENTOPERATIONTYPE
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.ui.dictionaries.tests.UiBudgetPayerStatusCreateTest
import ooo.jtc.ui.dictionaries.tests.UiBudgetPayerStatusDeleteTest
import ooo.jtc.ui.dictionaries.tests.UiBudgetReasonCodeCreateTest
import ooo.jtc.ui.dictionaries.tests.UiBudgetReasonCodeDeleteTest
import ooo.jtc.ui.dictionaries.tests.UiCodeVoCreateTest
import ooo.jtc.ui.dictionaries.tests.UiCodeVoDeleteTest
import ooo.jtc.ui.dictionaries.tests.UiKbkCreateTest
import ooo.jtc.ui.dictionaries.tests.UiKbkDeleteTest
import ooo.jtc.ui.dictionaries.tests.UiPaymentPriorityCreateTest
import ooo.jtc.ui.dictionaries.tests.UiPaymentPriorityDeleteTest
import ooo.jtc.ui.dictionaries.tests.UiPaymentTypeCreateTest
import ooo.jtc.ui.dictionaries.tests.UiPaymentTypeDeleteTest
import ooo.jtc.ui.dictionaries.tests.UiStatementOperationTypeCreateTest
import ooo.jtc.ui.dictionaries.tests.UiStatementOperationTypeDeleteTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode


@Epic(TestEpic.UI)
@Feature(TestFeature.DICTIONARY)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("UI. Справочники. Базовые операции")
class UiDictionaryTestsSuite {

    @TestFactory
    @Story(DictionaryNames.BUDGET_PAYER_STATUS)
    @UI_DICTIONARY_BUDGETPAYERSTATUS
    @Tags(Tag("JTCSALTO-T1255"), Tag("JTCSALTO-T1249"))
    @DisplayName("Справочник '${DictionaryNames.BUDGET_PAYER_STATUS}'(BudgetPayerStatus)")
    fun uiBudgetPayerStatusTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            UiBudgetPayerStatusCreateTest().withId("JTCSALTO-T1255"),
            UiBudgetPayerStatusDeleteTest().withId("JTCSALTO-T1249")
        )
    }

    @TestFactory
    @Story(DictionaryNames.BUDGET_REASON_CODE)
    @UI_DICTIONARY_BUDGETREASONCODE
    @Tags(Tag("JTCSALTO-T1546"), Tag("JTCSALTO-T1504"))
    @DisplayName(" Справочник '${DictionaryNames.BUDGET_REASON_CODE}' (budgetReasonCode)")
    fun uiBudgetReasonCodeTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            UiBudgetReasonCodeCreateTest().withId("JTCSALTO-T1546"),
            UiBudgetReasonCodeDeleteTest().withId("JTCSALTO-T1504")
        )
    }

    @TestFactory
    @Story(DictionaryNames.CODE_VO)
    @UI_DICTIONARY_CODEVO
    @Tags(Tag("JTCSALTO-T1484"), Tag("JTCSALTO-T1478"))
    @DisplayName(" Справочник '${DictionaryNames.CODE_VO}' (codeVO)")
    fun uiCodeVoTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            UiCodeVoCreateTest().withId("JTCSALTO-T1484"),
            UiCodeVoDeleteTest().withId("JTCSALTO-T1478")
        )
    }

    @TestFactory
    @Story(DictionaryNames.KBK)
    @Tags(Tag("JTCSALTO-T1520"), Tag("JTCSALTO-T1511"))
    @DisplayName("Справочник '${DictionaryNames.KBK}' (kbk)")
    @UI_DICTIONARY_KBK
    fun uiKbkTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            UiKbkCreateTest().withId("JTCSALTO-T1520"),
            UiKbkDeleteTest().withId("JTCSALTO-T1511")
        )
    }

    @TestFactory
    @Story(DictionaryNames.PAYMENT_PRIORITY)
    @DisplayName(" Справочник '${DictionaryNames.PAYMENT_PRIORITY}' (PaymentPriority)")
    @Tags(Tag("JTCSALTO-T1229"), Tag("JTCSALTO-T1226"))
    @UI_DICTIONARY_PAYMENTPRIORITY
    fun uiPaymentPriorityTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            UiPaymentPriorityCreateTest().withId("JTCSALTO-T1229"),
            UiPaymentPriorityDeleteTest().withId("JTCSALTO-T1226")
        )
    }

    @TestFactory
    @Story(DictionaryNames.PAYMENT_TYPE)
    @DisplayName(" Справочник '${DictionaryNames.PAYMENT_TYPE}' (PaymentType)")
    @Tags(Tag("JTCSALTO-T1442"), Tag("JTCSALTO-T1504"))
    @UI_DICTIONARY_PAYMENTTYPE
    fun uiPaymentTypeTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            UiPaymentTypeCreateTest().withId("JTCSALTO-T1442"),
            UiPaymentTypeDeleteTest().withId("JTCSALTO-T1504")
        )
    }

    @TestFactory
    @Story(DictionaryNames.STATEMENT_OPERATION_TYPE)
    @Tags(Tag("JTCSALTO-T1284"), Tag("JTCSALTO-T1278"))
    @DisplayName(" Справочник '${DictionaryNames.STATEMENT_OPERATION_TYPE}' (StatementOperationType)")
    @UI_DICTIONARY_STATEMENTOPERATIONTYPE
    fun uiStatementOperationTypeTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            UiStatementOperationTypeCreateTest().withId("JTCSALTO-T1284"),
            UiStatementOperationTypeDeleteTest().withId("JTCSALTO-T1278")
        )
    }
}