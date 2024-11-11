package ooo.jtc.core

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonValue
import ooo.jtc.extensions.getOrException
import ooo.jtc.properties.UiTestProperties
import ooo.jtc.properties.loadProps

const val CONFIG_FILE_PROPERTY_NAME = "configFile"
const val CONFIG_FILE_DEFAULT = "../application.yml"
const val PROFILE_PROPERTY_NAME = "profile"
const val PROFILE_DEFAULT = "test"
const val CHECK_PROPERTIES_STEP = "Инициализация пропертей"

/**
 * Uses for prepared data "queue" size.
 * Based on parallel threads count multiplied by expander for insurance that queue not empty.
 */
val queueSize by lazy {
    val expander = 3
    System.getProperty("threadCount", "3").toLong() * expander
}

/**
 * Object for store Application Properties
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class ApplicationProperties(
    val testdata: TestDataProps,
    val server: Server,
    val db: Db,
    val services: ServicesInfo,
    val cryptoPluginStub: Api,
    val ui: UiTestProperties,
    val tms: Tms,
    val failedTestsFile: String,
    val maxRetry: Int,
    val i18nLocale: String
) {
    /**
     * Exception handler for [System.getProperty].
     */
    fun getSystem(propName: String): String {
        return System.getProperty(propName).getOrException("Property '$propName' not found in System properties.")
    }

    /**
     * Flag for UI-test running mode.
     * If is remote then - true.
     */
    fun isUiRemote(): Boolean {
        return System.getProperty("selenide.remote", "").isNotBlank()
    }
}

/**
 * Object for store server host/port properties
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Server(var api: Api, var ui: Ui)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Api(var port: Int, var host: String)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Ui(var client: UiEndpoint, var bank: UiEndpoint)


@JsonIgnoreProperties(ignoreUnknown = true)
data class UiEndpoint(var port: Int, var host: String)

/**
 * Object for store list of services
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class ServicesInfo(
    var oauth: ServiceInfo,
    var uaa: ServiceInfo,
    var uaaManagement: ServiceInfo,
    var sign: ServiceInfo,
    var dictionary: ServiceInfo,
    var rkoDictionary: ServiceInfo,
    var rkoRupayment: ServiceInfo,
    var rkoStatement: ServiceInfo,
    var letter: ServiceInfo,
    var fsSystem: ServiceInfo,
    var crypto: ServiceInfo,
    var news: ServiceInfo,
    var curRko: ServiceInfo,
    var salary: ServiceInfo,
    var domainController: ServiceInfo
)

/**
 * Object for store information about service
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class ServiceInfo(
    var port: Int,
    var baseEndpoint: String? = ""
)

/**
 * Object for store information about database
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Db(var port: Int, var host: String, var user: String, var password: String)

/**
 * Object for store information about service
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class TestDataProps(
    var dir: String,
    var strategy: TestDataStrategy = TestDataStrategy.FROM_DB
)

/**
 * Object for store information about tms
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Tms(
    var host: String,
    var user: String,
    var userId: String,
    var password: String,
    var project: String,
    val createTestCase: Boolean,
    val updateTestCase: Boolean
)


enum class TestDataStrategy(@get:JsonValue var value: String) {

    FROM_FILE("fromFile"),
    FROM_DB("fromDb")

}

val applicationProperties: ApplicationProperties =
    loadProps(
        configFilePropertyName = CONFIG_FILE_PROPERTY_NAME,
        configFileDefault = CONFIG_FILE_DEFAULT,
        profileDefault = PROFILE_DEFAULT,
        profilePropertyName = PROFILE_PROPERTY_NAME
    )