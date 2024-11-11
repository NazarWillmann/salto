package ooo.jtc.dictionaries.swift

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.swift.bicplusv1.BicPlusEntityType
import ooo.jtc.dictionaries.swift.bicplusv1.BicPlusEventType
import ooo.jtc.dictionaries.swift.bicplusv1.BicPlusModificationFlagType
import ooo.jtc.dictionaries.swift.bicplusv1.BicPlusYesNoType
import ooo.jtc.dictionaries.swift.bicplusv1.BicPlusV1Node
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.time.LocalDate
import java.util.UUID

@EntityName(DictionaryNames.SWIFT)
@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class SwiftDto(
    override var id: UUID?,
    override var version: Int,
    var swift: String,
    var institutionType: SwiftInstType,
    var dateActual: LocalDate,
    val name: String,
    val city: String?,
    val address1: String?,
    val address2: String?,
    val address3: String?,
    val address4: String?,
    val branchName: String?,
    val branchCity: String?,
    val branchAddress1: String?,
    val branchAddress2: String?,
    val branchAddress3: String?,
    val branchAddress4: String?,
    val countryAlpha2Code: String,
    val recordStatus: String? = "C" //only 'C'-swifts will be imported; p3. https://confluence.jtc.ooo/pages/viewpage.action?pageId=21732807
) : UpdateIEntityDto<SwiftDto> {

    override fun toModel(): Swift = Mappers.swiftMapper.toDomainModel(this)

    fun toReducedBicPlusV1Node(): BicPlusV1Node {
        //Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21732807
        // + https://www.swift.com/our-solutions/compliance-and-shared-services/swiftref/bic-plus
        return BicPlusV1Node(
            bic = this.swift,
            institutionType = this.institutionType,
            eventDate = this.dateActual,
            institutionName = this.name,
            opCity = this.city,
            opStreetAddress1 = this.address1,
            opStreetAddress2 = this.address2,
            opStreetAddress3 = this.address3,
            opStreetAddress4 = this.address4,
            branchInformation = this.branchName,
            brCity = this.branchCity,
            brStreetAddress1 = this.branchAddress1,
            brStreetAddress2 = this.branchAddress2,
            brStreetAddress3 = this.branchAddress3,
            brStreetAddress4 = this.branchAddress4,
            isoCountryCode = this.countryAlpha2Code,
            recordStatus = this.recordStatus?: "C",

            bic8 = "00000000", ///[0-9A-Z]{8}
            branchBic = "000", ///[0-9A-Z]{3}
            countryName = "ATStubCountryName", ///str[70]
            entityType = BicPlusEntityType.values().random().value,
            eventType = BicPlusEventType.BIC_ISSUED.value,
            locationCode = "A", ///[0-9A-Z]
            modificationFlag = BicPlusModificationFlagType.A,
            operationallyActiveRecord = BicPlusYesNoType.Y,
            recordKey = "BP0000000000", ///BP[0-9A-Z]{10}
            swiftFa = BicPlusYesNoType.values().random(), //TODO Sergeyev [2021.01.20]: calculate by swift
            swiftFin = BicPlusYesNoType.values().random(),
            swiftIa = BicPlusYesNoType.values().random()
        )
    }
}