package ooo.jtc.dictionaries.bankbic.ed807

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.github.pozo.KotlinBuilder
import java.time.LocalDate
import java.time.ZonedDateTime

@JsonRootName("ED807")
@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ED807Xml(
    @JacksonXmlProperty(isAttribute = true) var xmlns: String = "urn:cbr-ru:ed:v2.0",
    @JacksonXmlProperty(isAttribute = true, localName = "EDNo") var edNo: String = "709920261",
    @JacksonXmlProperty(isAttribute = true, localName = "EDDate") var edDate: LocalDate,
    @JacksonXmlProperty(isAttribute = true, localName = "EDAuthor") var edAuthor: String = "4583001999",
    @JacksonXmlProperty(isAttribute = true, localName = "EDReceiver") var edReceiver: String? = null,
    @JacksonXmlProperty(isAttribute = true, localName = "CreationReason") var creationReason: String = "FCBD",
    @JacksonXmlProperty(isAttribute = true, localName = "CreationDateTime") var creationDateTime: ZonedDateTime,
    @JacksonXmlProperty(isAttribute = true, localName = "InfoTypeCode") var infoTypeCode: String = "FIRR",
    @JacksonXmlProperty(isAttribute = true, localName = "BusinessDay") var businessDay: LocalDate,
    @JacksonXmlProperty(isAttribute = true, localName = "DirectoryVersion") var directoryVersion: String = "1",


    @JacksonXmlProperty(isAttribute = false, localName = "BICDirectoryEntry")
    @JacksonXmlElementWrapper(useWrapping = false)
    var bicNodeList: List<ED807BicNode>
)
