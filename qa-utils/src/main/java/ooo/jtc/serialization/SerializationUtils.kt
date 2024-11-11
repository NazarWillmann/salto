package ooo.jtc.serialization

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.jayway.jsonpath.Configuration
import com.jayway.jsonpath.JsonPath
import com.jayway.jsonpath.ParseContext
import com.jayway.jsonpath.spi.json.JacksonJsonProvider
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider
import ooo.jtc.serialization.SerializationUtils.OBJECT_MAPPER
import java.io.InputStream

object SerializationUtils {

    private val applyDefaultMapperConfig: (ObjectMapper) -> ObjectMapper = { mapper ->
        mapper.registerModule(JavaTimeModule())
        mapper.registerModule(KotlinModule())
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
        mapper
    }

    /** XML-mapper */
    val XML_MAPPER by lazy { applyDefaultMapperConfig(XmlMapper()) }

    /** Default jackson Object Mapper */
    val OBJECT_MAPPER: ObjectMapper by lazy { applyDefaultMapperConfig(ObjectMapper()) }

    val JSON_PATH_CONTEXT: ParseContext
        get() = JsonPath.using(JSON_PATH_CONFIGURATION)

    private val JSON_PATH_CONFIGURATION by lazy {
        Configuration.builder()
            .jsonProvider(JacksonJsonProvider(OBJECT_MAPPER))
            .mappingProvider(JacksonMappingProvider(OBJECT_MAPPER))
            .build()
    }

    fun constructType(baseClass: Class<*>, vararg classes: Class<*>): JavaType =
        OBJECT_MAPPER.typeFactory.constructParametricType(baseClass, *classes)

}

fun <T : Any> T.serialize(): String = OBJECT_MAPPER.writeValueAsString(this)

inline fun <reified T : Any> String.deserialize(): T = OBJECT_MAPPER.readValue(this, T::class.java)

inline fun <reified T : Any> InputStream.deserialize(): T = OBJECT_MAPPER.readValue(this, T::class.java)

fun Any.convertToMap(): Map<String, Any?> {
    val mapper = OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL)
    return mapper.convertValue(this, mutableMapOf<String, Any?>()::class.java)
}

