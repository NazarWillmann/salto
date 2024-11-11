package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_SWIFT
import ooo.jtc.api.dictionaries.swift.SwiftGetPageTest
import ooo.jtc.api.dictionaries.swift.SwiftGetTest
import ooo.jtc.api.dictionaries.swift.SwiftImportTest
import ooo.jtc.api.dictionaries.swift.SwiftPrepareSteps
import ooo.jtc.api.dictionaries.swift.SwiftSteps
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.swift.Swift
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.swift.SwiftData
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.DICTIONARY)
@Story(DictionaryNames.SWIFT)
@DisplayName("API '${DictionaryNames.SWIFT}' suite")
@Execution(ExecutionMode.SAME_THREAD)//otherwise import may break concurrent get-tests
@BE_DICTIONARY_SWIFT
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SwiftTestsSuite {

    //TODO Khatmullin [12.05.2021]: need to be refactored with https://confluence.jtc.ooo/pages/viewpage.action?pageId=31261006
    private val bankUser = Users.bankAdmin
    private val clientUser = Users.client
    private lateinit var existingData: List<Swift>

    @BeforeAll
    fun prepareTestData() {
        existingData = SwiftData.get()
    }

    @AfterAll
    fun cleanTestData() {
        val prepareExistedData = existingData.map { it.toDto().toReducedBicPlusV1Node() }
        val existedBics = SwiftPrepareSteps.prepareTempFileForSwiftImport(prepareExistedData)
        SwiftSteps(bankUser).importSwift(existedBics)
    }

    @TestFactory
    internal fun swiftTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                SwiftImportTest(bankUser),

                SwiftGetTest(bankUser),
                SwiftGetTest(clientUser),
                SwiftGetPageTest(bankUser),
                SwiftGetPageTest(clientUser)
            )
        )
    }
}