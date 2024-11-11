package ooo.jtc.dictionaries.bankbic.ed807

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.github.pozo.KotlinBuilder
import javax.xml.bind.annotation.XmlRootElement
import java.time.LocalDate

@XmlRootElement(name = "Accounts")
@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ED807Account(
    @JacksonXmlProperty(isAttribute = true, localName = "Account") var account: String,
    @JacksonXmlProperty(isAttribute = true, localName = "RegulationAccountType") var regulationAccountType: String,
    @JacksonXmlProperty(isAttribute = true, localName = "CK") var ck: String? = null,
    @JacksonXmlProperty(isAttribute = true, localName = "AccountCBRBIC") var accountCbrBic: String,
    @JacksonXmlProperty(isAttribute = true, localName = "DateIn") var dateIn: LocalDate,
    @JacksonXmlProperty(isAttribute = true, localName = "DateOut") var dateOut: LocalDate? = null,
    @JacksonXmlProperty(isAttribute = true, localName = "AccountStatus") var accountStatus: String? = null,

    @JacksonXmlProperty(isAttribute = true, localName = "AccRstrList")
    @JacksonXmlElementWrapper(useWrapping = false)
    var restrictionList: List<ED807AccountRestriction>? = null
)