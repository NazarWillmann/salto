package ooo.jtc.dictionaries.swift.bicplusv1

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.dictionaries.swift.SwiftDto
import ooo.jtc.dictionaries.swift.SwiftInstType
import ooo.jtc.extensions.DATE_ONLY
import java.time.LocalDate
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "bicplus_v1")
@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class BicPlusV1Node(
    // TODO Sergeyev [2021.01.20]: continue with types; xml annotations
    @JsonProperty("modification_flag") var modificationFlag: BicPlusModificationFlagType,
    @JsonProperty("changed_field") var changedField: String? = null,
    @JsonProperty("record_key") var recordKey: String,              /// bp_record_keyType,
    @JsonProperty("previous_record_key") var previousRecordKey: String? = null,            /// bp_record_keyType?,
    @JsonProperty("next_record_key") var nextRecordKey: String? = null,            /// bp_record_keyType?,
    @JsonProperty("event_type") var eventType: String,              /// event_typeType,
    @JsonFormat(pattern = DATE_ONLY) @JsonProperty("event_date") var eventDate: LocalDate,
    var bic8: String,              /// bic_codeType,
    @JsonProperty("branch_bic") var branchBic: String,              /// branch_codeType,
    var bic: String,              /// bicType,
    @JsonProperty("record_status") var recordStatus: String,              /// record_statusType,
    @JsonProperty("operationally_active_record") var operationallyActiveRecord: BicPlusYesNoType,
    @JsonProperty("subtype_indicator") var subtypeIndicator: String? = null,            /// subtype_indicatorType?,
    @JsonProperty("swift_fin") var swiftFin: BicPlusYesNoType,
    @JsonProperty("swift_fa") var swiftFa: BicPlusYesNoType,
    @JsonProperty("swift_ia") var swiftIa: BicPlusYesNoType,
    @JsonProperty("legal_name") var legalName: String? = null,            /// institution_nameType?,
    @JsonProperty("institution_name") var institutionName: String,
    @JsonProperty("institution_type") var institutionType: SwiftInstType,
    @JsonProperty("entity_type") var entityType: String,              /// entity_typeType,
    @JsonProperty("re_street_address_1") var reStreetAddress1: String? = null,            /// street_addressType?,
    @JsonProperty("re_street_address_2") var reStreetAddress2: String? = null,            /// street_addressType?,
    @JsonProperty("re_street_address_3") var reStreetAddress3: String? = null,            /// street_addressType?,
    @JsonProperty("re_street_address_4") var reStreetAddress4: String? = null,            /// street_addressType?,
    @JsonProperty("re_city") var reCity: String? = null,            /// cityType?,
    @JsonProperty("re_cps") var reCps: String? = null,            /// cpsType?,
    @JsonProperty("re_zip_code") var reZipCode: String? = null,            /// zip_codeType?,
    @JsonProperty("re_pob_number") var rePobNumber: String? = null,            /// pob_numberType?,
    @JsonProperty("op_street_address_1") var opStreetAddress1: String? = null,            /// street_addressType?,
    @JsonProperty("op_street_address_2") var opStreetAddress2: String? = null,            /// street_addressType?,
    @JsonProperty("op_street_address_3") var opStreetAddress3: String? = null,            /// street_addressType?,
    @JsonProperty("op_street_address_4") var opStreetAddress4: String? = null,            /// street_addressType?,
    @JsonProperty("op_city") var opCity: String? = null,            /// cityType?,
    @JsonProperty("op_cps") var opCps: String? = null,            /// cpsType?,
    @JsonProperty("op_zip_code") var opZipCode: String? = null,            /// zip_codeType?,
    @JsonProperty("op_pob_number") var opPobNumber: String? = null,            /// pob_numberType?,
    @JsonProperty("br_street_address_1") var brStreetAddress1: String? = null,            /// street_addressType?,
    @JsonProperty("br_street_address_2") var brStreetAddress2: String? = null,            /// street_addressType?,
    @JsonProperty("br_street_address_3") var brStreetAddress3: String? = null,            /// street_addressType?,
    @JsonProperty("br_street_address_4") var brStreetAddress4: String? = null,            /// street_addressType?,
    @JsonProperty("br_city") var brCity: String? = null,            /// cityType?,
    @JsonProperty("br_cps") var brCps: String? = null,            /// cpsType?,
    @JsonProperty("br_zip_code") var brZipCode: String? = null,            /// zip_codeType?,
    @JsonProperty("br_pob_number") var brPobNumber: String? = null,            /// pob_numberType?,
    @JsonProperty("branch_information") var branchInformation: String? = null,            /// branch_informationType?,
    @JsonProperty("country_name") var countryName: String,              /// country_nameType,
    @JsonProperty("iso_country_code") var isoCountryCode: String,              /// iso_country_codeType,
    @JsonProperty("location_code") var locationCode: String,              /// location_codeType,
    @JsonProperty("fin_service_codes") var finServiceCodes: String? = null,            /// fin_service_codesType?,
    @JsonProperty("record_key_bdp") var recordKeyBdp: String? = null,            /// string(BD[0-9A-Z]{10})
    @JsonProperty("field_a") var fieldA: String? = null,                   /// string(1)
    @JsonProperty("field_b") var fieldB: String? = null,                   /// string(64)
    @JsonProperty("field_c") var fieldC: String? = null,                   /// string(128)
    @JsonProperty("field_d") var fieldD: String? = null,                   /// string(256)
    @JsonProperty("field_e") var fieldE: String? = null,                   /// string(11)
    @JsonProperty("field_f") var fieldF: String? = null                    /// string(12)
)  {

    fun toSwiftDto(): SwiftDto {
        //Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21732807
        return SwiftDto(
            id = null,
            version = 0,
            swift = this.bic,
            institutionType = this.institutionType,
            dateActual = this.eventDate,
            name = this.institutionName,
            city = this.opCity,
            address1 = this.opStreetAddress1,
            address2 = this.opStreetAddress2,
            address3 = this.opStreetAddress3,
            address4 = this.opStreetAddress4,
            branchName = this.branchInformation,
            branchCity = this.brCity,
            branchAddress1 = this.brStreetAddress1,
            branchAddress2 = this.brStreetAddress2,
            branchAddress3 = this.brStreetAddress3,
            branchAddress4 = this.brStreetAddress4,
            countryAlpha2Code = this.isoCountryCode
        )
    }
}