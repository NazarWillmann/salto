package ooo.jtc.be.crypto

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_CRYPTO_PROFILE
import ooo.jtc.api.platform.crypto.profile.ProfileCreateTest
import ooo.jtc.api.platform.crypto.profile.ProfileDeleteTest
import ooo.jtc.api.platform.crypto.profile.ProfileGetPageTest
import ooo.jtc.api.platform.crypto.profile.ProfileGetTest
import ooo.jtc.api.platform.crypto.profile.ProfileUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.CryptoNames
import ooo.jtc.testdata.Users
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.CRYPTO)
@Story(CryptoNames.PROFILE)
@DisplayName("API '${CryptoNames.PROFILE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_CRYPTO_PROFILE
class ProfileTestsSuite {

    private val bankOperator by lazy { Users.bankOperator }
    private val bankAdmin by lazy { Users.bankAdmin }

    @TestFactory
    internal fun profileCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ProfileCreateTest(creatorUser = bankAdmin, createForUser = bankOperator),
                ProfileGetTest(bankOperator),
                ProfileGetPageTest(bankOperator),
                ProfileDeleteTest(creatorUser = bankAdmin, createForUser = bankOperator),
                ProfileUpdateTest(creatorUser = bankAdmin, createForUser = bankOperator),
            )
        )
    }
}