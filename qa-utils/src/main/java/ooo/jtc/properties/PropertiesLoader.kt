@file:Suppress("UNCHECKED_CAST")

package ooo.jtc.properties

import ooo.jtc.allure.systemStep
import ooo.jtc.serialization.SerializationUtils.OBJECT_MAPPER
import org.apache.commons.text.StringEscapeUtils
import org.yaml.snakeyaml.Yaml
import java.io.File


/**
 * Load application properties from config file and system properties.
 * Principles to work with properties:
 * There is a file (e.g. application.yml) where stored all default properties.
 * All properties from file loads to System.properties,
 * but if System.properties already has some property as from file, it doesn't override.
 * e.g.:
 * application.yml has property `tms:project:JTCSALTO`. if we run tests from maven without key -Dtms.project, System.getProperty("tms.project") => JTCSALTO
 * application.yml has property `tms:project:JTCSALTO`. if we run tests from maven with key -Dtms.project=JTC, System.getProperty("tms.project") => JTC
 */
inline fun <reified T> loadProps(
    configFilePropertyName: String,
    configFileDefault: String,
    profilePropertyName: String,
    profileDefault: String
): T {
    return "Загрузка пропертей" systemStep {
        val applicationConfig = System.getProperty(configFilePropertyName, configFileDefault)
        val map = Yaml().load(File(applicationConfig).readText()) as MutableMap<String, Any>

        retrieveProfile(profilePropertyName, profileDefault, map)
        updateMapFromSystemProperties(map)
        updateSystemPropertiesFromFile(map)
        OBJECT_MAPPER.convertValue(map, T::class.java)
    }
}

/**
 * Select desirable profile.
 *
 * @param profilePropertyName - desirable profile name from System.property (e.g. from maven -Dprofile=dev)
 * @param profileDefault - default profile name (e.g. "test")
 * @param map - properties from yml-file as Map<String, Any>
 */
fun retrieveProfile(profilePropertyName: String, profileDefault: String, map: MutableMap<String, Any>) {
    val profile = System.getProperty(profilePropertyName, profileDefault)
    val profileProps = map.remove(profilePropertyName) as Map<String, Any>
    val propsFromProfile = if (profile != null) profileProps[profile] as MutableMap<String, Any> else mutableMapOf()

    updateConfig(map, propsFromProfile)
}

fun updateSystemPropertiesFromFile(map: MutableMap<String, Any>) {
    val fullKeyValuePairs = retrieveFullKeyValuePairs(prevKey = null, map = map)
    fullKeyValuePairs.forEach { pair ->
        System.getProperty(pair.first) ?: System.setProperty(pair.first, pair.second)
    }
}

fun retrieveFullKeyValuePairs(prevKey: String?, map: MutableMap<String, Any>): List<Pair<String, String>> {
    val res = map.keys.map { key ->
        val value = map[key]
        if (value is Map<*, *>) {
            val xPrevKey = prevKey?.let { "$it.$key" } ?: key
            retrieveFullKeyValuePairs(xPrevKey, value as MutableMap<String, Any>)
        } else prevKey?.let { listOf("$it.$key" to value.toString()) } ?: listOf(key to value.toString())
    }
    return res.flatten()
}

/**
 * Update properties from file by system properties.
 * e.g. application.yml has property `tms:project:JTCSALTO`. if we run tests from maven with key -Dtms.project=JTC, System.getProperty("tms.project") => JTC
 */
@Suppress("MoveVariableDeclarationIntoWhen")
fun updateMapFromSystemProperties(map: MutableMap<String, Any>) {
    val systemProperties = System.getProperties()
    for (key in systemProperties.keys()) {
        val keyList = (key as String).split(".")
        if (map.keys.contains(keyList[0])) {
            val valueMap = createTree(keyList, map)
            val unescapedValue = StringEscapeUtils.unescapeHtml4(systemProperties.getProperty(key))
            val processedValue: Any =
                when (unescapedValue) {
                    "true" -> true
                    "false" -> false
                    else -> unescapedValue
                }
            valueMap[keyList[keyList.size - 1]] = processedValue
        }
    }
}

/**
 * Update config properties, baseNode map updated from updateNode.
 * e.g.:
 * baseNode.user.name = updateNode.user.name
 * baseNode.user.age = updateNode.user.age
 */
fun updateConfig(baseNode: MutableMap<String, Any>, updateNode: MutableMap<String, Any>) {
    updateNode.forEach { (key, value) ->
        when (value) {
            is Map<*, *> -> {
                if (baseNode[key] == null) baseNode[key] = value
                else updateConfig(baseNode[key] as MutableMap<String, Any>, value as MutableMap<String, Any>)
            }
            else -> baseNode[key] = value
        }
    }
}

fun createTree(keys: List<String>, map: MutableMap<String, Any>): MutableMap<String, Any> {
    val firstValue = map[keys[0]]
    val valueMap: MutableMap<String, Any> = if (firstValue == null) {
        mutableMapOf()
    } else {
        when (firstValue) {
            is Map<*, *> -> firstValue as MutableMap<String, Any>
            else -> mutableMapOf(keys[0] to firstValue)
        }
    }
    map[keys[0]] = valueMap
    var out: MutableMap<String, Any> = valueMap
    if (keys.size > 2) {
        out = createTree(keys.subList(1, keys.size), valueMap)
    }
    return out
}
