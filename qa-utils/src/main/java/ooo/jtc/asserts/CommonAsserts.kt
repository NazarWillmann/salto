package ooo.jtc.asserts

import io.qameta.allure.Step
import ooo.jtc.serialization.convertToMap
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.slf4j.LoggerFactory

private val logger by lazy { LoggerFactory.getLogger("CommonAsserts") }

/**
 * Assert that [actMap] map's values equals to [expMap] map's values.
 */
@Suppress("UNCHECKED_CAST")
fun assertEqualMaps(expMap: Map<String, Any?>, actMap: Map<String, Any?>, mapName: String? = null) {
    expMap.entries.forEach { expEntry ->
        val key = expEntry.key
        val fieldName = mapName?.let { "$it.$key" } ?: key
        val expValue = expEntry.value
        val actValue = actMap[key]
        when (expValue) {
            is List<*> -> {
                assertThat("Field '$fieldName': expected list ($expValue), but actual: ($actValue)", actValue != null)
                assertEqualList(key, expValue, actValue as List<*>)
            }
            is Map<*, *> -> {
                assertThat("Field '$fieldName': expected map ($expValue), but actual: ($actValue)", actValue != null)
                assertEqualMaps(expValue as Map<String, Any?>, actValue as Map<String, Any?>, key)
            }
            null -> {
                logger.warn("Field '$fieldName' is 'null' in expected result. Not enough information for comparison!")
            }
            else -> {
                assertThat("Value of field '$fieldName': expected ($expValue), but actual: ($actValue)", actValue, equalTo(expValue))
            }
        }
    }
}

/**
 * Assert that elements [expList] are equals to [actList].
 * [listName] - name of list field.
 */
@Suppress("UNCHECKED_CAST")
fun assertEqualList(listName: String, expList: List<*>, actList: List<*>) {
    expList.forEachIndexed { index, expListItem ->
        val itemFieldName = "$listName[$index]"
        val actListItem = actList[index]
        if (expListItem is Map<*, *>) {
            assertThat("Field '$itemFieldName': expected ($expListItem), but actual: ($actListItem)", actListItem != null)
            assertEqualMaps(expListItem as Map<String, Any?>, actListItem as Map<String, Any?>, itemFieldName)
        } else {
            assertThat(
                "Value of field '$itemFieldName': expected ($expListItem), but actual: ($actListItem})",
                actListItem, equalTo(expListItem)
            )
        }
    }
}

@Step("Сравнить ожидаемый и полученный объекты")
fun <T : Any> assertObjectsEqual(expected: T, actual: T) {
    assertEqualMaps(expected.convertToMap(), actual.convertToMap())
}