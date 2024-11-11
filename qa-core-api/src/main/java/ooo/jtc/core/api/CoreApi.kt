package ooo.jtc.core.api

import com.fasterxml.jackson.databind.ObjectMapper
import io.qameta.allure.restassured.AllureRestAssured
import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.config.ObjectMapperConfig
import io.restassured.config.RestAssuredConfig
import io.restassured.filter.log.LogDetail
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.http.ContentType
import io.restassured.response.Response
import io.restassured.response.ResponseBodyExtractionOptions
import io.restassured.specification.RequestSpecification
import ooo.jtc.serialization.SerializationUtils.OBJECT_MAPPER
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.slf4j.LoggerFactory
import java.io.PrintStream
import java.lang.reflect.Type
import java.util.logging.Level

/**
 * Class for working with REST API.
 * @param baseUri - host value
 * @param port - host port
 * @param headers - map of String, String to adding in request headers
 * @param objectMapper - mapper for serialize/deserialize objects
 * @param contentType - content type (enum), Json by default
 * @param contentTypeStr - content type (string). Should be used only when there is no corresponding [contentType] enum
 */
class CoreApi(
    baseUri: String,
    port: Int? = null,
    headers: Map<String, String> = emptyMap(),
    objectMapper: ObjectMapper = OBJECT_MAPPER,
    contentType: ContentType? = ContentType.JSON,
    contentTypeStr: String = "multipart/form-data",
    config: RequestSpecBuilder.() -> Unit = {},
    val reAuthorize: () -> Any = {}
) {
    private val requestVar = PrintStream(LoggingOutputStream(LoggerFactory.getLogger(Thread.currentThread().name), Level.INFO), true)
    private val responseVar = PrintStream(LoggingOutputStream(LoggerFactory.getLogger(Thread.currentThread().name), Level.INFO), true)

    private var spec: RequestSpecification
    private var specBaseState: RequestSpecification
    private var reAuthorizeAttempts = 1

    companion object {
        fun defaultStatusCheck(withCheckResponseCode: Boolean, statusCode: Int): Response.() -> Unit =
            { if (withCheckResponseCode) assertThat("Wrong response code", statusCode(), equalTo(statusCode)) }
    }

    init {
        val mapperFactory = ObjectMapperConfig.objectMapperConfig().jackson2ObjectMapperFactory { _, _ -> objectMapper }
        val requestSpecBuilder = RequestSpecBuilder()
        requestSpecBuilder.setBaseUri(baseUri)
        port?.let { requestSpecBuilder.setPort(port) }
        requestSpecBuilder.addHeaders(headers)
        contentType
            ?.let { requestSpecBuilder.setContentType(contentType) }
            ?: let { requestSpecBuilder.setContentType(contentTypeStr) }
        requestSpecBuilder.addFilter(RequestLoggingFilter(LogDetail.ALL, requestVar))
        requestSpecBuilder.addFilter(ResponseLoggingFilter(LogDetail.ALL, responseVar))
        requestSpecBuilder.addFilter(AllureRestAssured())
        requestSpecBuilder.setConfig(RestAssuredConfig.config().objectMapperConfig(mapperFactory))
        config.invoke(requestSpecBuilder)
        spec = RestAssured.given(requestSpecBuilder.build())
        specBaseState = RestAssured.given(requestSpecBuilder.build())
    }

    /**
     * Add basic authentication.
     */
    fun withBaseAuth(userName: String, password: String): CoreApi {
        spec.auth().preemptive().basic(userName, password)
        specBaseState = RestAssured.given(spec)
        return this
    }

    /**
     * Add bearer authorization in header
     *
     * @param bearer - Bearer key in format 'Bearer ...'
     */
    fun withBearerAuth(bearer: String): CoreApi {
        return withHeader("Authorization", bearer)
    }

    /**
     * Add domain in header
     *
     * @param domain - add s-domain in header
     */
    fun withDomain(domain: String): CoreApi {
        return withHeader("s-domain", domain)
    }

    /**
     * Add user in header
     */
    fun withUserAuth(user: String): CoreApi {
        return withHeader("user", user)
    }

    /**
     * Add Content-Language in header
     * E.g. "ru", "en"
     */
    fun withLanguage(language: String): CoreApi {
        return withHeader("Content-Language", language)
    }

    /**
     * Add custom header
     *
     * @param headerName - custom header name
     * @param headerValue - custom header value
     */
    fun withHeader(headerName: String, headerValue: String): CoreApi {
        spec.header(headerName, headerValue)
        specBaseState = RestAssured.given(spec)
        return this
    }

    /**
     * Add custom parameter
     *
     * @param paramName - custom parameter name
     * @param paramValue - custom parameter value
     */
    fun withParam(paramName: String, paramValue: String): CoreApi {
        spec.param(paramName, paramValue)
        specBaseState = RestAssured.given(spec)
        return this
    }

    /**
     * Main method for sending REST request
     *
     * @param build - lambda for adding need actions in RequestSpecBuilder
     * @param method - RestAssurded sending method
     * @param check - method for checking Response
     *
     */
    fun send(
        method: RequestSpecification.() -> Response,
        check: Response.() -> Unit = {}
    ): Response {
        val result = method.invoke(spec)
        try {
            check.invoke(result)
        } catch (e: Throwable) {
            if (result.body.asString().contains("Access token expired.") && reAuthorizeAttempts > 0) {
                reAuthorize.invoke()
                reAuthorizeAttempts--
                send(method, check)
            }
            throw e
        } finally {
            spec = RestAssured.given(specBaseState)
        }
        return result
    }

}

/**
 * Deserialize response by type.
 *
 * @param type - response type
 */
fun <T> ResponseBodyExtractionOptions.responseAs(type: Type): T {
    return this.`as`(type)
}

/**
 * Deserialize response by Class.
 */
fun <T> ResponseBodyExtractionOptions.responseAs(tClass: Class<T>): T {
    return this.`as`(tClass)
}