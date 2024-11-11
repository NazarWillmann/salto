package ooo.jtc.ui.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.UI_LETTER_TO_BANK_TABS
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.testdata.Users
import ooo.jtc.ui.common.pages.ApplicationPageType
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormViewHistoryDetailProcessingTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormViewHistoryDetailReceptionClientTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormViewHistoryTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormViewSignatureStatusDraftTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormViewSignatureStatusNewTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormViewSignatureStatusReceivedBankTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormViewSignatureStatusReceivedClientTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBFormViewSignatureStatusSignedTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBSignatureTabUnSignOwnCancelTest
import ooo.jtc.ui.letters.tobank.tests.UiLTBSignatureTabUnSignOwnTest
import ooo.jtc.ui.letters.tobank.tests.UiLetterToBankScrollerHistoryTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.UI)
@Feature(TestFeature.LETTER_TO_BANK)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("UI. ${DocumentNames.LETTER_TO_BANK} тесты на вкладки экранной формы")
@UI_LETTER_TO_BANK_TABS
class UiLetterToBankTabsTestSuite {
    //region Tags
//@formatter:off
    /* signatures tab*/
    @Tag("JTCSALTO-T4011") annotation class T4011
    @Tag("JTCSALTO-T4380") annotation class T4380
    @Tag("JTCSALTO-T4090") annotation class T4090
    @Tag("JTCSALTO-T4014") annotation class T4014
    @Tag("JTCSALTO-T4092") annotation class T4092
    @Tag("JTCSALTO-T4221") annotation class T4221
    @Tag("JTCSALTO-T4222") annotation class T4222

    /* history tab*/
    @Tag("JTCSALTO-T4205") annotation class T4205
    @Tag("JTCSALTO-T4026") annotation class T4026
    @Tag("JTCSALTO-T4193") annotation class T4193
    @Tag("JTCSALTO-T4195") annotation class T4195
    @Tag("JTCSALTO-T4196") annotation class T4196
    @Tag("JTCSALTO-T4200") annotation class T4200
    @Tag("JTCSALTO-T4201") annotation class T4201

    @Tag("JTCSALTO-T4197") annotation class T4197
    @Tag("JTCSALTO-T4198") annotation class T4198
    @Tag("JTCSALTO-T4199") annotation class T4199
    @Tag("JTCSALTO-T4203") annotation class T4203
    @Tag("JTCSALTO-T4204") annotation class T4204
    @Tag("JTCSALTO-T4214") annotation class T4214
    @Tag("JTCSALTO-T4217") annotation class T4217
//@formatter:on
//endregion

    @T4380 //Письмо в банк. Форма просмотра. Закладка Подписи. Информация об отсутствии подписей. New. [Клиент]
    @T4011 //Письмо в банк. Форма просмотра. Закладка Подписи. Информация об отсутствии подписей. Draft. [Клиент]
    @T4090 //Письмо в банк. Форма просмотра. Закладка Подписи. Отображение полей, содержащих сведения о подписи. Delivered+. СМС. [Клиент]
    @T4014 //Письмо в банк. Форма просмотра. Закладка Подписи. Отображение полей, содержащих сведения о подписи. PartlySigned/ Singed. СМС. [Клиент]
    @T4092 //Письмо в банк. Форма просмотра. Закладка Подписи. Отображение полей, содержащих сведения о подписи. Delivered+. СМС. [Банк]
    @T4221 //Письмо в банк. Закладка Подписи. Снятие своей подписи. Отмена действия.
    @T4222 //Письмо в банк. Закладка Подписи. Снятие своей подписи. Подтверждение действия.
    @Story("${TestStoryLetterToBank.LETTER_TO_BANK_TABS}. Закладка 'Подписи'")
    @TestFactory
    internal fun uiLetterToBankFormSignaturesTests(): List<DynamicTest> {
        val clientUser = Users.client
        val bankUser = Users.bankOperator
        return EntityTestGenerator.generate(
            listOf(
                UiLTBFormViewSignatureStatusNewTest(clientUser).withId(T4380::class),
                UiLTBFormViewSignatureStatusDraftTest(clientUser).withId(T4011::class),
                UiLTBFormViewSignatureStatusReceivedClientTest(clientUser).withId(T4090::class),
                UiLTBFormViewSignatureStatusSignedTest(clientUser).withId(T4014::class),
                UiLTBFormViewSignatureStatusReceivedBankTest(clientUser, bankUser).withId(T4092::class),

                UiLTBSignatureTabUnSignOwnCancelTest(clientUser).withId(T4221::class),
                UiLTBSignatureTabUnSignOwnTest(clientUser).withId(T4222::class),
            )
        )
    }

    @T4205 // Письмо в банк. Форма просмотра. Закладка История изменений. [Клиент]
    @T4026 // Письмо в банк. Просмотреть историю изменений документа из скроллера. [Клиент]
    @T4193 // Письмо в банк. Форма просмотра. Закладка История изменений. Просмотр сведений о результатах приема в Банке. DetailsError. [Клиент]
    @T4195 // Письмо в банк. Форма просмотра. Закладка История изменений. Просмотр сведений о результатах приема в Банке. WrongESignature. [Клиент]
    @T4196 // Письмо в банк. Форма просмотра. Закладка История изменений. Просмотр сведений о результатах приема в Банке. Received. [Клиент]
    @T4200 // Письмо в банк. Форма просмотра. Закладка История изменений. Просмотр сведений о результатах обработки в Банке. Processed. [Клиент]
    @T4201 // Письмо в банк. Форма просмотра. Закладка История изменений. Просмотр сведений о результатах обработки в Банке. Recalled. [Клиент]
    @Story("${TestStoryLetterToBank.LETTER_TO_BANK_TABS}. Закладка 'История изменений'")
    @TestFactory
    internal fun uiLetterToBankFormHistoryClientTests(): List<DynamicTest> {
        val clientUser = Users.client
        return EntityTestGenerator.generate(
            listOf(
                UiLTBFormViewHistoryTest(
                    user = clientUser,
                    preExecution = { LetterToBankPreExecutions.LTBPreExecutionReceived.invoke(clientUser) },
                    pageType = ApplicationPageType.CLIENT_PAGE
                ).withId(T4205::class),
                UiLetterToBankScrollerHistoryTest(
                    user = clientUser,
                    preExecution = { LetterToBankPreExecutions.LTBPreExecutionSigned.invoke(clientUser) },
                    pageType = ApplicationPageType.CLIENT_PAGE
                ).withId(T4026::class),
                UiLTBFormViewHistoryDetailProcessingTest(
                    statusForName = "Processed",
                    user = clientUser,
                    preExecution = { LetterToBankPreExecutions.LTBPreExecutionProcessed.invoke(clientUser) },
                    pageType = ApplicationPageType.CLIENT_PAGE
                ).withId(T4200::class),
                UiLTBFormViewHistoryDetailProcessingTest(
                    statusForName = "Recalled",
                    user = clientUser,
                    preExecution = { LetterToBankPreExecutions.LTBPreExecutionRecalled.invoke(clientUser) },
                    pageType = ApplicationPageType.CLIENT_PAGE
                ).withId(T4201::class),
                UiLTBFormViewHistoryDetailReceptionClientTest(
                    statusForName = "DetailsError",
                    user = clientUser,
                    preExecution = { LetterToBankPreExecutions.LTBPreExecutionDetailsError.invoke(clientUser) },
                    pageType = ApplicationPageType.CLIENT_PAGE
                ).withId(T4193::class),
                UiLTBFormViewHistoryDetailReceptionClientTest(
                    statusForName = "WrongESignature",
                    user = clientUser,
                    preExecution = { LetterToBankPreExecutions.LTBPreExecutionWrongESignature.invoke(clientUser) },
                    pageType = ApplicationPageType.CLIENT_PAGE
                ).withId(T4195::class),
                UiLTBFormViewHistoryDetailReceptionClientTest(
                    statusForName = "Received",
                    user = clientUser,
                    preExecution = { LetterToBankPreExecutions.LTBPreExecutionReceived.invoke(clientUser) },
                    pageType = ApplicationPageType.CLIENT_PAGE
                ).withId(T4196::class),

                )
        )
    }

    @T4214 // Письмо в банк. Форма просмотра. Закладка История изменений [Банк]
    @T4217 // Письмо в банк. Просмотреть историю изменений документа из скроллера. [Банк]
    @T4204 // Письмо в банк. Форма просмотра. Закладка История изменений. Просмотр сведений о результатах обработки в Банке. Processed. [Банк]
    @T4203 // Письмо в банк. Форма просмотра. Закладка История изменений. Просмотр сведений о результатах обработки в Банке. Recalled. [Банк]
    @T4198 // Письмо в банк. Форма просмотра. Закладка История изменений. Просмотр сведений о результатах приема в Банке. DetailsError. [Банк]
    @T4197 // Письмо в банк. Форма просмотра. Закладка История изменений. Просмотр сведений о результатах приема в Банке. WrongESignature. [Банк]
    @T4199 // Письмо в банк. Форма просмотра. Закладка История изменений. Просмотр сведений о результатах приема в Банке. Received. [Банк]
    @Story("${TestStoryLetterToBank.LETTER_TO_BANK_TABS}. Закладка 'История изменений'")
    @TestFactory
    internal fun uiLetterToBankFormHistoryBankTests(): List<DynamicTest> {
        val clientUser = Users.client
        val bankUser = Users.bankOperator
        return EntityTestGenerator.generate(
            listOf(
//                UiLTBFormViewHistoryTest(
//                    user = bankUser,
//                    preExecution = { UiLetterToBankPreExecutions.LTBPreExecutionReceived.invoke(clientUser) },
//                    pageType = BANK_PAGE
//                ).withId(T4214::class), //TODO A.Stykalin [10.09.2020] нужно будет поправить, после изменений статусов на бэке
                UiLetterToBankScrollerHistoryTest(
                    user = bankUser,
                    preExecution = { LetterToBankPreExecutions.LTBPreExecutionReceived.invoke(clientUser) },
                    pageType = ApplicationPageType.BANK_PAGE
                ).withId(T4217::class),
                UiLTBFormViewHistoryDetailProcessingTest(
                    statusForName = "Processed",
                    user = bankUser,
                    preExecution = { LetterToBankPreExecutions.LTBPreExecutionProcessed.invoke(clientUser) },
                    pageType = ApplicationPageType.BANK_PAGE
                ).withId(T4214::class),
                UiLTBFormViewHistoryDetailProcessingTest(
                    statusForName = "Recalled",
                    user = bankUser,
                    preExecution = { LetterToBankPreExecutions.LTBPreExecutionRecalled.invoke(clientUser) },
                    pageType = ApplicationPageType.BANK_PAGE
                ).withId(T4203::class),
                UiLTBFormViewHistoryDetailReceptionClientTest(
                    statusForName = "DetailsError",
                    user = bankUser,
                    preExecution = { LetterToBankPreExecutions.LTBPreExecutionDetailsError.invoke(clientUser) },
                    pageType = ApplicationPageType.BANK_PAGE
                ).withId(T4198::class),
                UiLTBFormViewHistoryDetailReceptionClientTest(
                    statusForName = "WrongESignature",
                    user = bankUser,
                    preExecution = { LetterToBankPreExecutions.LTBPreExecutionWrongESignature.invoke(clientUser) },
                    pageType = ApplicationPageType.BANK_PAGE
                ).withId(T4197::class),
                UiLTBFormViewHistoryDetailReceptionClientTest(
                    statusForName = "Received",
                    user = bankUser,
                    preExecution = { LetterToBankPreExecutions.LTBPreExecutionReceived.invoke(clientUser) },
                    pageType = ApplicationPageType.BANK_PAGE
                ).withId(T4199::class),
            )
        )
    }
}