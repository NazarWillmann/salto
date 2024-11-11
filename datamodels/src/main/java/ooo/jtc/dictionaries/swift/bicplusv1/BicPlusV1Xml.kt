package ooo.jtc.dictionaries.swift.bicplusv1

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.github.pozo.KotlinBuilder

@JsonRootName("dataexport")
@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class BicPlusV1Xml(
    @JacksonXmlProperty(isAttribute = true) var product: String?,
    @JacksonXmlProperty(isAttribute = true) var filetype: String?,
    @JacksonXmlProperty(isAttribute = true) var filedate: String?,

    @JsonProperty("bicplus_v1")
    @JacksonXmlElementWrapper(useWrapping = false)
    var bicPlusV1NodeList: List<BicPlusV1Node>
)