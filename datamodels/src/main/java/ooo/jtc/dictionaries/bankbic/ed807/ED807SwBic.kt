package ooo.jtc.dictionaries.bankbic.ed807

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.github.pozo.KotlinBuilder
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "SWBICS")
@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ED807SwBic(
    @JacksonXmlProperty(isAttribute = true, localName = "SWBIC") var swBic: String,
    @JacksonXmlProperty(isAttribute = true, localName = "DefaultSWBIC") var defaultSwBic: String
)