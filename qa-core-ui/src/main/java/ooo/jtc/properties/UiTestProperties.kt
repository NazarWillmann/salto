package ooo.jtc.properties

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

const val CONFIG_FILE_PROPERTY_NAME = "configFile"
const val CONFIG_FILE_DEFAULT = "../application.yml"
const val PROFILE_PROPERTY_NAME = "profile"
const val PROFILE_DEFAULT = "test"

val uiTestProperties: UiTestProperties =
    loadProps<AllTestProperties>(
        configFilePropertyName = CONFIG_FILE_PROPERTY_NAME,
        configFileDefault = CONFIG_FILE_DEFAULT,
        profileDefault = PROFILE_DEFAULT,
        profilePropertyName = PROFILE_PROPERTY_NAME
    ).ui

@JsonIgnoreProperties(ignoreUnknown = true)
data class AllTestProperties(var ui: UiTestProperties)

@JsonIgnoreProperties(ignoreUnknown = true)
data class UiTestProperties(
    var proxy: Proxy,
    var browser: Browser,
    var elements: ElementSetting
) {
    val remoteUrl: String? get() = System.getProperty("selenide.remote")
}

@JsonIgnoreProperties(ignoreUnknown = true)
data class Browser(
    var capabilities: HashMap<String, Any>
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Proxy(
    val port: Int
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ElementSetting(var timeout: Long, var poolingInterval: Long, var useJs: Boolean)