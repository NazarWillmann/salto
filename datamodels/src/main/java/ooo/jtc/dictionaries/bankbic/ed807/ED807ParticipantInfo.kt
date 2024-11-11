package ooo.jtc.dictionaries.bankbic.ed807

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.github.pozo.KotlinBuilder
import javax.xml.bind.annotation.XmlRootElement
import java.time.LocalDate

@XmlRootElement(name = "ParticipantInfo")
@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ED807ParticipantInfo(
    @JacksonXmlProperty(isAttribute = true, localName = "NameP") var nameP: String,
    @JacksonXmlProperty(isAttribute = true, localName = "EnglName") var englName: String? = null,
    @JacksonXmlProperty(isAttribute = true, localName = "RegN") var regN: String? = null,
    @JacksonXmlProperty(isAttribute = true, localName = "CntrCd") var cntrCd: String? = null,
    @JacksonXmlProperty(isAttribute = true, localName = "Rgn") var rgn: String,
    @JacksonXmlProperty(isAttribute = true, localName = "Ind") var ind: String? = null,
    @JacksonXmlProperty(isAttribute = true, localName = "Tnp") var tnp: String? = null,
    @JacksonXmlProperty(isAttribute = true, localName = "Nnp") var nnp: String? = null,
    @JacksonXmlProperty(isAttribute = true, localName = "Adr") var adr: String? = null,
    @JacksonXmlProperty(isAttribute = true, localName = "PrntBIC") var prntBic: String? = null,
    @JacksonXmlProperty(isAttribute = true, localName = "DateIn") var dateIn: LocalDate,
    @JacksonXmlProperty(isAttribute = true, localName = "DateOut") var dateOut: LocalDate? = null,
    @JacksonXmlProperty(isAttribute = true, localName = "PtType") var ptType: String,
    @JacksonXmlProperty(isAttribute = true, localName = "Srvcs") var srvcs: String,
    @JacksonXmlProperty(isAttribute = true, localName = "XchType") var xchType: String,
    @JacksonXmlProperty(isAttribute = true, localName = "UID") var uid: String,
    @JacksonXmlProperty(isAttribute = true, localName = "NPSParticipant") var npsParticipant: String? = null,
    @JacksonXmlProperty(isAttribute = true, localName = "ToNPSDate") var toNpsDate: String? = null,
    @JacksonXmlProperty(isAttribute = true, localName = "ParticipantStatus") var participantStatus: String,

    @JacksonXmlProperty(isAttribute = true, localName = "RstrList")
    @JacksonXmlElementWrapper(useWrapping = false)
    var restrictionList: List<ED807ParticipantRestriction>? = null,
)
