package ooo.jtc.dictionaries.bankbic.ed807

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.github.pozo.KotlinBuilder
import javax.xml.bind.annotation.XmlRootElement
import java.time.LocalDate


@XmlRootElement(name = "AccRstrList")
@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ED807AccountRestriction(
    @JacksonXmlProperty(isAttribute = true, localName = "AccRstr") var accRstr: String,
    @JacksonXmlProperty(isAttribute = true, localName = "AccRstrDate") var accRstrDate: LocalDate
)