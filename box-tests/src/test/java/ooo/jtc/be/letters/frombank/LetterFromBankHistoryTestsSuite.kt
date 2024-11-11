package ooo.jtc.be.letters.frombank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_FROM_BANK_HISTORY
import ooo.jtc.api.letters.frombank.tests.LFBHistoryTest_Draft2Deleted
import ooo.jtc.api.letters.frombank.tests.LFBHistoryTest_Draft2New2Draft
import ooo.jtc.api.letters.frombank.tests.LFBHistoryTest_None2Draft
import ooo.jtc.api.letters.frombank.tests.LFBHistoryTest_None2New
import ooo.jtc.api.letters.frombank.tests.LFBHistoryTest_Draft2New_MultipleSameChanges
import ooo.jtc.api.letters.frombank.tests.LFBHistoryTest_Signed2Delivered
import ooo.jtc.api.letters.frombank.tests.LFBHistoryTest_Signed2DetailsError
import ooo.jtc.api.letters.frombank.tests.LFBHistoryTest_Signed2New2Signed
import ooo.jtc.api.letters.frombank.tests.LFBHistoryTest_Signed2WrongDigest
import ooo.jtc.api.letters.frombank.tests.LFBHistoryTest_Signed2WrongSignature
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.Issues.JTCSALTO_2990
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterFromBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.LETTER_FROM_BANK)
@Story(TestStoryLetterFromBank.LETTER_FROM_BANK_HISTORY)
@DisplayName("API '${DocumentNames.LETTER_FROM_BANK}' history suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_FROM_BANK_HISTORY
class LetterFromBankHistoryTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T4451") annotation class T4451
@Tag("JTCSALTO-T4452") annotation class T4452
@Tag("JTCSALTO-T4453") annotation class T4453
@Tag("JTCSALTO-T4454") annotation class T4454
@Tag("JTCSALTO-T4455") annotation class T4455
@Tag("JTCSALTO-T4456") annotation class T4456
@Tag("JTCSALTO-T4457") annotation class T4457
@Tag("JTCSALTO-T4458") annotation class T4458
@Tag("JTCSALTO-T4459") annotation class T4459
@Tag("JTCSALTO-T4460") annotation class T4460
@Tag("JTCSALTO-T4461") annotation class T4461
//@formatter:on
//endregion

    private val bankUser: User by lazy { Users.bankOperator }

    @TestFactory
    @T4459 //'Письмо из Банка'. История изменений. Проверка перехода none->NEW [BANK]
    @T4460 //'Письмо из Банка'. История изменений. Проверка перехода none->DRAFT [BANK]
    @T4461 //'Письмо из Банка'. История изменений. Проверка перехода DRAFT->NEW->DRAFT [BANK]
    internal fun bankHistoryWithoutSigningTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LFBHistoryTest_None2New(bankUser).withId(T4459::class),
                LFBHistoryTest_None2Draft(bankUser).withId(T4460::class),
                LFBHistoryTest_Draft2New2Draft(bankUser).withId(T4461::class)
            )
        )
    }

    @TestFactory
    @Execution(ExecutionMode.SAME_THREAD)
    @T4454 //'Письмо из Банка'. История изменений. Проверка перехода SIGNED->NEW->SIGNED [BANK]
    @T4455 //'Письмо из Банка'. История изменений. Проверка перехода SIGNED->DELIVERED [BANK]
    @T4456 //'Письмо из Банка'. История изменений. Проверка перехода SIGNED->WRONG_ESIGNATURE (SignatureCorrupt) [BANK]
    @T4457 //'Письмо из Банка'. История изменений. Проверка перехода SIGNED->WRONG_ESIGNATURE (DigestIncorrect) [BANK]
    @T4458 //'Письмо из Банка'. История изменений. Проверка перехода SIGNED->DETAILS_ERROR [BANK]
    internal fun bankHistoryWithSigningTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LFBHistoryTest_Signed2New2Signed(bankUser).withId(T4454::class),
                LFBHistoryTest_Signed2Delivered(bankUser).withId(T4455::class),
                LFBHistoryTest_Signed2WrongSignature(bankUser).withId(T4456::class),
                LFBHistoryTest_Signed2WrongDigest(bankUser).withId(T4457::class),
                LFBHistoryTest_Signed2DetailsError(bankUser).withId(T4458::class),
            )
        )
    }

    @TestFactory
    // 2020.09.29 [Sergeyev]: в связи с недавними правками пользователю отдаются только те записи истории изменений,
    // которые отличаются по имени пользователя и/или статусу
    //@T4451 //'Письмо из Банка'. История изменений. Проверка перехода DRAFT->DRAFT(x4)->NEW (все записи) [BANK]
    @T4452 //'Письмо из Банка'. История изменений. Проверка перехода DRAFT->DRAFT(x4)->NEW (только смена статуса) [BANK]
    @T4453 //'Письмо из Банка'. История изменений. Проверка перехода DRAFT->DELETED [BANK]
    internal fun additionalHistoryTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LFBHistoryTest_Draft2New_MultipleSameChanges(bankUser).withId(T4452::class),
                LFBHistoryTest_Draft2Deleted(bankUser).withId(T4453::class).withIssues(JTCSALTO_2990)
            )
        )
    }
}
