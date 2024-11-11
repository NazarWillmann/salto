package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_INDIVIDUAL
import ooo.jtc.api.dictionaries.individual.IndividualCreateTest
import ooo.jtc.api.dictionaries.individual.IndividualDeleteTest
import ooo.jtc.api.dictionaries.individual.IndividualUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.DICTIONARY)
@Story(DictionaryNames.INDIVIDUAL)
@DisplayName("API '${DictionaryNames.INDIVIDUAL}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_INDIVIDUAL
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IndividualTestsSuite {
    private val clientUser = Users.client
    private val bankUser = Users.superUser
    private val individualUser = Users.individual

    @TestFactory
    @Execution(ExecutionMode.SAME_THREAD)
    internal fun individualCrudTests(): List<DynamicTest> {
        val tests = listOf(
            IndividualCreateTest(bankUser, individualUser),
            IndividualDeleteTest(bankUser, individualUser),
            IndividualUpdateTest(bankUser, individualUser),
        )
        return EntityTestGenerator.generate(tests)
    }
}