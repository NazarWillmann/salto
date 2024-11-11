package ooo.jtc.dictionaries.bankbic.ed807

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.github.pozo.KotlinBuilder
import javax.xml.bind.annotation.XmlRootElement
import java.time.LocalDate

@XmlRootElement(name = "RstrList")
@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ED807ParticipantRestriction(
    @JacksonXmlProperty(isAttribute = true, localName = "Rstr") var rstr: String,
    @JacksonXmlProperty(isAttribute = true, localName = "RstrDate") var rstrDate: LocalDate
)
