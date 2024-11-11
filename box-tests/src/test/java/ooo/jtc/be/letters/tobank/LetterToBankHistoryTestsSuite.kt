package ooo.jtc.be.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_TO_BANK_HISTORY
import ooo.jtc.api.letters.tobank.tests.LTBHistoryBankTest_None2Received
import ooo.jtc.api.letters.tobank.tests.LTBHistoryBankTest_Received2InProcess2Recalled
import ooo.jtc.api.letters.tobank.tests.LTBHistoryBankTest_Received2Processed
import ooo.jtc.api.letters.tobank.tests.LTBHistoryBankTest_Received2Recalled
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.testdata.Users
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import ooo.jtc.api.letters.tobank.tests.LTBHistoryClientTest_Draft2New2Draft
import ooo.jtc.api.letters.tobank.tests.LTBHistoryClientTest_Draft2New_MultipleSameChanges
import ooo.jtc.api.letters.tobank.tests.LTBHistoryClientTest_None2Draft
import ooo.jtc.api.letters.tobank.tests.LTBHistoryClientTest_None2New
import ooo.jtc.api.letters.tobank.tests.LTBHistoryClientTest_None2Received
import ooo.jtc.api.letters.tobank.tests.LTBHistoryClientTest_Received2InProcess2Recalled
import ooo.jtc.api.letters.tobank.tests.LTBHistoryClientTest_Received2Processed
import ooo.jtc.api.letters.tobank.tests.LTBHistoryClientTest_Received2Recalled
import ooo.jtc.api.letters.tobank.tests.LTBHistoryClientTest_Signed2New2Signed

@Epic(TestEpic.API)
@Feature(TestFeature.LETTER_TO_BANK)
@Story(TestStoryLetterToBank.LETTER_TO_BANK_HISTORY)
@DisplayName("API '${DocumentNames.LETTER_TO_BANK}' history suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_TO_BANK_HISTORY
class LetterToBankHistoryTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3968") annotation class T3968
@Tag("JTCSALTO-T3969") annotation class T3969
@Tag("JTCSALTO-T3970") annotation class T3970
@Tag("JTCSALTO-T3971") annotation class T3971
@Tag("JTCSALTO-T3972") annotation class T3972
@Tag("JTCSALTO-T3973") annotation class T3973
@Tag("JTCSALTO-T3974") annotation class T3974
@Tag("JTCSALTO-T3975") annotation class T3975
@Tag("JTCSALTO-T3976") annotation class T3976
@Tag("JTCSALTO-T3977") annotation class T3977
@Tag("JTCSALTO-T3978") annotation class T3978
@Tag("JTCSALTO-T3979") annotation class T3979
@Tag("JTCSALTO-T3980") annotation class T3980
@Tag("JTCSALTO-T3981") annotation class T3981
//@formatter:on
//endregion

    private val bankUser = Users.bankOperator
    private val clientUser = Users.client

    @TestFactory
    @T3968 //'Письмо в Банк'. История изменений. Проверка перехода none->NEW [CLIENT]
    @T3969 //'Письмо в Банк'. История изменений. Проверка перехода none->DRAFT [CLIENT]
    @T3970 //'Письмо в Банк'. История изменений. Проверка перехода DRAFT->NEW->DRAFT [CLIENT]
    internal fun clientHistoryWithoutSigningTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LTBHistoryClientTest_None2New(clientUser).withId(T3968::class),
                LTBHistoryClientTest_None2Draft(clientUser).withId(T3969::class),
                LTBHistoryClientTest_Draft2New2Draft(clientUser).withId(T3970::class)
            )
        )
    }

    @Execution(ExecutionMode.SAME_THREAD)
    @TestFactory
    @T3971 //'Письмо в Банк'. История изменений. Проверка перехода SIGNED->NEW->SIGNED [CLIENT]
    @T3972 //'Письмо в Банк'. История изменений. Проверка перехода none->...->DELIVERED [CLIENT]
    @T3973 //'Письмо в Банк'. История изменений. Проверка перехода RECEIVED->...->PROCESSED [CLIENT]
    @T3974 //'Письмо в Банк'. История изменений. Проверка перехода RECEIVED->RECALLED [CLIENT]
    @T3975 //'Письмо в Банк'. История изменений. Проверка перехода RECEIVED->IN_PROCESS->RECALLED [CLIENT]
    internal fun clientHistoryWithSigningTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LTBHistoryClientTest_Signed2New2Signed(clientUser).withId(T3971::class),

                LTBHistoryClientTest_None2Received(clientUser, bankUser).withId(T3972::class),
                LTBHistoryClientTest_Received2Processed(clientUser, bankUser).withId(T3973::class),
                LTBHistoryClientTest_Received2Recalled(clientUser, bankUser).withId(T3974::class),
                LTBHistoryClientTest_Received2InProcess2Recalled(clientUser, bankUser).withId(T3975::class)
            )
        )
    }

    @Execution(ExecutionMode.SAME_THREAD)
    @TestFactory
    @T3976 //'Письмо в Банк'. История изменений. Проверка перехода none->...->DELIVERED [BANK]
    @T3977 //'Письмо в Банк'. История изменений. Проверка перехода RECEIVED->...->PROCESSED [BANK]
    @T3978 //'Письмо в Банк'. История изменений. Проверка перехода RECEIVED->RECALLED [BANK]
    @T3979 //'Письмо в Банк'. История изменений. Проверка перехода RECEIVED->IN_PROCESS->RECALLED [BANK]
    internal fun bankHistoryTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LTBHistoryBankTest_None2Received(bankUser, clientUser).withId(T3976::class),
                LTBHistoryBankTest_Received2Processed(bankUser, clientUser).withId(T3977::class),
                LTBHistoryBankTest_Received2Recalled(bankUser, clientUser).withId(T3978::class),
                LTBHistoryBankTest_Received2InProcess2Recalled(bankUser, clientUser).withId(T3979::class)
            )
        )
    }

    @TestFactory
    // 2020.09.29 [Sergeyev]: в связи с недавними правками пользователю отдаются только те записи истории изменений,
    // которые отличаются по имени пользователя и/или статусу
    //@T3980 //'Письмо в Банк'. История изменений. Проверка перехода DRAFT->DRAFT(x4)->NEW (все записи) [CLIENT]
    @T3981 //'Письмо в Банк'. История изменений. Проверка перехода DRAFT->DRAFT(x4)->NEW (только смена статуса) [CLIENT]
    internal fun additionalHistoryTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            LTBHistoryClientTest_Draft2New_MultipleSameChanges(clientUser).withId(T3981::class)
        )
    }
}
