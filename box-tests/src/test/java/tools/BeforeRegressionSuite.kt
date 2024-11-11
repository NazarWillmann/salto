package tools

import io.qameta.allure.Epic
import ooo.jtc.allure.AllureSystemSuite.Companion.SYSTEM_EPIC_NAME
import ooo.jtc.allure.AllureSystemSuite.Companion.SYSTEM_SUITE_NAME
import ooo.jtc.reflections.ReflectionUtils
import ooo.jtc.testdata.common.TestData
import ooo.jtc.testdata.common.TestDataAT
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

/**
 * Functions for cleaning AT test data at CI.
 * Tests should have [Tag] with prefix `BR_` (before regression).
 */
@DisplayName(SYSTEM_SUITE_NAME)
object BeforeRegressionSuite {

    //TODO A.Stykalin [29.06.2020] add check that AT-users exist in system.

    /**
     * Clean all AT-test data from common (user independent) dictionaries.
     * Starts up at CI before regression tests.
     */
    @Test
    @Tag("BR_BE_CLEAN_COMMON_DICTIONARY")
    @Epic(SYSTEM_EPIC_NAME)
    @DisplayName("Зачистка Общесистемных справочников")
    fun cleanNotDependsOfUserTestData() {
        val testDataClasses = ReflectionUtils.findKotlinObjects(TestData::class.java)
        val testDataATClasses = ReflectionUtils.findKotlinObjects(TestDataAT::class.java)
        val notDependsOfUserTestData = testDataClasses.toMutableList()
        notDependsOfUserTestData.removeAll(testDataATClasses)
        notDependsOfUserTestData.forEach { it.cleanAtCreated() }
    }
}