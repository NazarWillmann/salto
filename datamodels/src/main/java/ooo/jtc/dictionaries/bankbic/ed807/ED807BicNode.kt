package ooo.jtc.dictionaries.bankbic.ed807

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.dictionaries.bankbic.BankBicAllowedServicesIEnum
import ooo.jtc.dictionaries.bankbic.BankBicDto
import ooo.jtc.dictionaries.bankbic.BankBicParticipantTransferTypeIEnum
import ooo.jtc.dictionaries.bankbic.BankBicParticipantTypeIEnum
import ooo.jtc.dictionaries.bankbic.BankBicStatusesIEnum
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccAccountTypeIEnum
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccStatusIEnum
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccountDto
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrCodeIEnum
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionDto
import ooo.jtc.dictionaries.bankbic.restr.BankBicRestrCodeIEnum
import ooo.jtc.dictionaries.bankbic.restr.BankBicRestrictionDto
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "BICDirectoryEntry")
@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ED807BicNode(
    @JacksonXmlProperty(isAttribute = true, localName = "BIC") var bic: String,
    @JacksonXmlProperty(isAttribute = true, localName = "ChangeType") var changeType: String? = null,


    @JacksonXmlProperty(isAttribute = false, localName = "ParticipantInfo")
    @JacksonXmlElementWrapper(useWrapping = false)
    var participantInfo: ED807ParticipantInfo,

    @JacksonXmlProperty(isAttribute = false, localName = "SWBICS")
    @JacksonXmlElementWrapper(useWrapping = false)
    var swBics: List<ED807SwBic>? = null,

    @JacksonXmlProperty(isAttribute = false, localName = "Accounts")
    @JacksonXmlElementWrapper(useWrapping = false)
    var accounts: List<ED807Account>? = null,
) {

    //TODO Sergeyev [2021.03.11]: когда-нибудь мне будет совсем нечем заняться и я перепишу это на маппер-интерфейс
    fun toBankBicDto(): BankBicDto {
        return BankBicDto(
            id = null,
            version = 0,
            bic = bic,
            name = participantInfo.nameP,
            countryAlpha2Code = participantInfo.cntrCd,
            zip = participantInfo.ind,
            locationType = participantInfo.tnp,
            location = participantInfo.nnp,
            address = participantInfo.adr,
            parentBic = participantInfo.prntBic,
            participantTransferType = BankBicParticipantTransferTypeIEnum.ofStr(participantInfo.ptType),
            participantType = BankBicParticipantTypeIEnum.ofStr(participantInfo.xchType),
            allowedServices = BankBicAllowedServicesIEnum.ofStr(participantInfo.srvcs),
            dateIn = participantInfo.dateIn,
            dateOut = participantInfo.dateOut,
            status = BankBicStatusesIEnum.ofStr(participantInfo.participantStatus),
            restrictions = participantInfo.restrictionList
                ?.map {
                    BankBicRestrictionDto(
                        id = null, version = 0,
                        restrictionCode = BankBicRestrCodeIEnum.ofStr(it.rstr),
                        restrictionDate = it.rstrDate
                    )
                }
                ?: emptyList(),
            accounts = accounts
                ?.map { acc ->
                    println(acc)
                    println(acc.regulationAccountType)
                    BankBicAccountDto(
                        id = null, version = 0,
                        account = acc.account,
                        accountType = BankBicAccAccountTypeIEnum.ofStr(acc.regulationAccountType),
                        accountBic = acc.accountCbrBic,
                        dateIn = acc.dateIn,
                        dateOut = acc.dateOut,
                        status = BankBicAccStatusIEnum.ofStr(acc.accountStatus!!),
                        restrictions = acc.restrictionList
                            ?.map { accRestr ->
                                BankBicAccRestrictionDto(
                                    id = null, version = 0,
                                    restrictionCode = BankBicAccRestrCodeIEnum.ofStr(accRestr.accRstr),
                                    restrictionDate = accRestr.accRstrDate
                                )
                            }
                            ?: emptyList()
                    )
                }
                ?: emptyList()
        )
    }
}
