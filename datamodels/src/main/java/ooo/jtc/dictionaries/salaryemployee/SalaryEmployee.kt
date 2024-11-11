package ooo.jtc.dictionaries.salaryemployee

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.dictionaries.common.address.RuAddress
import ooo.jtc.extensions.DEFAULT_DATE_FORMAT
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.util.*

@KotlinBuilder
data class SalaryEmployee(
    override var id: UUID?,
    override var version: Int,
    @JsonProperty("last_name") var lastName: String,
    @JsonProperty("first_name") var firstName: String?,
    @JsonProperty("middle_name") var middleName: String?,
    var fio: String?,
    var sex: String,
    var birthday: LocalDate?,
    @JsonProperty("is_resident") var isResident: Boolean,
    @JsonProperty("nationality_code") var nationalityCode: String?,
    var inn: String?,
    var snils: String?,
    @JsonProperty("personnel_number") var personnelNumber: String?,
    var position: String?,
    var status: String,
    @JsonProperty("is_agreement") var isAgreement: Boolean,
    @JsonProperty("id_customer") var customerId: UUID,
    @JsonProperty("customer_name") var customerName: String?,
    @JsonProperty("id_user") var userId: UUID,
    var phone: String?,
    @JsonProperty("home_phone") var homePhone: String?,
    @JsonProperty("work_phone") var workPhone: String?,
    @JsonProperty("mobile_phone") var mobilePhone: String?,
    var email: String?,
    @JsonProperty("creating_date") var creatingDate: Instant,
    @JsonProperty("inclusion_date") var inclusionDate: Instant?,
    @JsonProperty("excluding_date") var excludingDate: Instant?,

//    @JsonProperty("identity_doc_doc_type_code") var identityDocTypeCode: String,
//    @JsonProperty("identity_doc_doc_type") var identityDocType: String,
//    @JsonProperty("identity_doc_doc_type_name") var identityDocTypeName: String,
//    @JsonProperty("identity_doc_series") var identityDocSeries: String?,
//    @JsonProperty("identity_doc_number") var identityDocNumber: String?,
//    @JsonProperty("identity_doc_issuing_date") var identityDocIssuingDate: LocalDate?,
//    @JsonProperty("identity_doc_issuing_authority") var identityDocIssuingAuthority: String?,
//    @JsonProperty("identity_doc_department_code") var identityDocDepartmentCode: String?,
//    @JsonProperty("identity_doc_country_digit_code") var identityDocCountryDigitCode: String?,
//    @JsonProperty("identity_doc_end_date") var identityDocEndDate: LocalDate?,
//    @NotRequiredForTest @JsonProperty("identity_doc_begin_date") var identityDocBeginDate: LocalDate?,
//
//    @JsonProperty("residency_permit_doc_doc_type_code") var residencyPermitTypeCode: String,
//    @JsonProperty("residency_permit_doc_doc_type") var residencyPermitType: String,
//    @JsonProperty("residency_permit_doc_doc_type_name") var residencyPermitTypeName: String,
//    @JsonProperty("residency_permit_doc_series") var residencyPermitSeries: String?,
//    @JsonProperty("residency_permit_doc_number") var residencyPermitNumber: String?,
//    @JsonProperty("residency_permit_doc_issuing_date") var residencyPermitIssuingDate: LocalDate?,
//    @JsonProperty("residency_permit_doc_issuing_authority") var residencyPermitIssuingAuthority: String?,
//    @JsonProperty("residency_permit_doc_department_code") var residencyPermitDepartmentCode: String?,
//    @JsonProperty("residency_permit_doc_country_digit_code") var residencyPermitCountryDigitCode: String?,
//    @JsonProperty("residency_permit_doc_end_date") var residencyPermitEndDate: LocalDate?,
//    @JsonProperty("residency_permit_doc_begin_date") var residencyPermitBeginDate: LocalDate?,
//
//    @JsonProperty("address_registration_country_digit_code") var addressRegCountryDigitCode: String?,
//    @JsonProperty("address_registration_c_index") var addressRegCountryIndex: String?,
//    @JsonProperty("address_registration_region_code") var addressRegRegionCode: String,
//    @JsonProperty("address_registration_district") var addressRegDistrict: String?,
//    @JsonProperty("address_registration_city") var addressRegCity: String?,
//    @JsonProperty("address_registration_inhabited_locality") var addressRegInhabitedLocality: String?,
//    @JsonProperty("address_registration_street") var addressRegStreet: String?,
//    @JsonProperty("address_registration_house_number") var addressRegHouseNumber: String?,
//    @JsonProperty("address_registration_housing_number") var addressRegHousingNumber: String?,
//    @JsonProperty("address_registration_building_number") var addressRegBuildingNumber: String?,
//    @JsonProperty("address_registration_apartment_number") var addressRegApartmentNumber: String?,
//    @JsonProperty("address_registration_room_number") var addressRegRoomNumber: String?,
//    @JsonProperty("address_registration_full_address") var addressRegFullAddress: String?,
//
//    @JsonProperty("address_location_country_digit_code") var addressLocCountryDigitCode: String?,
//    @JsonProperty("address_location_c_index") var addressLocCountryIndex: String?,
//    @JsonProperty("address_location_region_code") var addressLocRegionCode: String,
//    @JsonProperty("address_location_district") var addressLocDistrict: String?,
//    @JsonProperty("address_location_city") var addressLocCity: String?,
//    @JsonProperty("address_location_inhabited_locality") var addressLocInhabitedLocality: String?,
//    @JsonProperty("address_location_street") var addressLocStreet: String?,
//    @JsonProperty("address_location_house_number") var addressLocHouseNumber: String?,
//    @JsonProperty("address_location_housing_number") var addressLocHousingNumber: String?,
//    @JsonProperty("address_location_building_number") var addressLocBuildingNumber: String?,
//    @JsonProperty("address_location_apartment_number") var addressLocApartmentNumber: String?,
//    @JsonProperty("address_location_room_number") var addressLocRoomNumber: String?,
//    @JsonProperty("address_location_full_address") var addressLocFullAddress: String?,
//
//    @JsonProperty("address_info_country_digit_code") var addressInfoCountryDigitCode: String?,
//    @JsonProperty("address_info_c_index") var addressInfoCountryIndex: String?,
//    @JsonProperty("address_info_region_code") var addressInfoRegionCode: String,
//    @JsonProperty("address_info_district") var addressInfoDistrict: String?,
//    @JsonProperty("address_info_city") var addressInfoCity: String?,
//    @JsonProperty("address_info_inhabited_locality") var addressInfoInhabitedLocality: String?,
//    @JsonProperty("address_info_street") var addressInfoStreet: String?,
//    @JsonProperty("address_info_house_number") var addressInfoHouseNumber: String?,
//    @JsonProperty("address_info_housing_number") var addressInfoHousingNumber: String?,
//    @JsonProperty("address_info_building_number") var addressInfoBuildingNumber: String?,
//    @JsonProperty("address_info_apartment_number") var addressInfoApartmentNumber: String?,
//    @JsonProperty("address_info_room_number") var addressInfoRoomNumber: String?,
//    @JsonProperty("address_info_full_address") var addressInfoFullAddress: String?,

    // filled in [dbResultPostProcessor]
    var paymentDetails: List<SalaryEmployeePaymentDetails>,
    var addressInfo: RuAddress,
    var addressLocation: RuAddress,
    var addressRegistration: RuAddress,
    var identityDocument: SalaryEmployeeIdentityDocument?,
    var residencyPermitDocument: SalaryEmployeeResidencyPermitDocument?,

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?

) : ITransferEntity {
    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.SALARY_EMPLOYEE

    override fun toDto(): SalaryEmployeeDto = Mappers.salaryEmployeeMapper.toDto(this)

}
