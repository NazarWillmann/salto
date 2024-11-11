package ooo.jtc.testdata.dictionaries.salaryemloyee

import ooo.jtc.core.TestConstants.AT_POSTFIX_RUS
import ooo.jtc.dictionaries.common.address.RuAddress
import ooo.jtc.dictionaries.salaryemployee.SalaryEmployee
import ooo.jtc.dictionaries.salaryemployee.SalaryEmployeeIdentityDocument
import ooo.jtc.dictionaries.salaryemployee.SalaryEmployeeResidencyPermitDocument
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestDataAT
import java.time.LocalDate

object SalaryEmployeeData : TestDataAT<SalaryEmployee>(SalaryEmployee::class.java) {
    override var atMarkerPredicate: (SalaryEmployee) -> Boolean = { it.lastName.endsWith(AT_POSTFIX_RUS) }
    override val dbDataConsumer = { Services.SALARY.db.execSql("SELECT * FROM employee") }
    override val dataFileName: String = "employee.json"

    private val paymentDetailsData by lazy { SalaryEmployeePaymentDetailsData.get() }

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { dbSalaryEmployeeInfoMap ->
            dbSalaryEmployeeInfoMap.apply {
                dbSalaryEmployeeInfoMap["paymentDetails"] = paymentDetailsData
                    .filter { it.customerId == dbSalaryEmployeeInfoMap["id_customer"] }

                val addressInfo = RuAddress(
                    countryDigitCode = dbSalaryEmployeeInfoMap["address_info_country_digit_code"] as String?,
                    index = dbSalaryEmployeeInfoMap["address_info_c_index"] as String?,
                    regionCode = dbSalaryEmployeeInfoMap["address_info_region_code"] as String?,
                    district = dbSalaryEmployeeInfoMap["address_info_district"] as String?,
                    city = dbSalaryEmployeeInfoMap["address_info_city"] as String?,
                    inhabitedLocality = dbSalaryEmployeeInfoMap["address_info_inhabited_locality"] as String?,
                    street = dbSalaryEmployeeInfoMap["address_info_street"] as String?,
                    houseNumber = dbSalaryEmployeeInfoMap["address_info_house_number"] as String?,
                    housingNumber = dbSalaryEmployeeInfoMap["address_info_housing_number"] as String?,
                    buildingNumber = dbSalaryEmployeeInfoMap["address_info_building_number"] as String?,
                    apartmentNumber = dbSalaryEmployeeInfoMap["address_info_apartment_number"] as String?,
                    roomNumber = dbSalaryEmployeeInfoMap["address_info_room_number"] as String,
                    fullAddress = dbSalaryEmployeeInfoMap["address_info_full_address"] as String,
                )
                dbSalaryEmployeeInfoMap["addressInfo"] = addressInfo

                val addressLocation = RuAddress(
                    countryDigitCode = dbSalaryEmployeeInfoMap["address_info_country_digit_code"] as String?,
                    index = dbSalaryEmployeeInfoMap["address_info_c_index"] as String?,
                    regionCode = dbSalaryEmployeeInfoMap["address_info_region_code"] as String?,
                    district = dbSalaryEmployeeInfoMap["address_info_district"] as String?,
                    city = dbSalaryEmployeeInfoMap["address_info_city"] as String?,
                    inhabitedLocality = dbSalaryEmployeeInfoMap["address_info_inhabited_locality"] as String?,
                    street = dbSalaryEmployeeInfoMap["address_info_street"] as String?,
                    houseNumber = dbSalaryEmployeeInfoMap["address_info_house_number"] as String?,
                    housingNumber = dbSalaryEmployeeInfoMap["address_info_housing_number"] as String?,
                    buildingNumber = dbSalaryEmployeeInfoMap["address_info_building_number"] as String?,
                    apartmentNumber = dbSalaryEmployeeInfoMap["address_info_apartment_number"] as String?,
                    roomNumber = dbSalaryEmployeeInfoMap["address_info_room_number"] as String,
                    fullAddress = dbSalaryEmployeeInfoMap["address_info_full_address"] as String,
                )
                dbSalaryEmployeeInfoMap["addressLocation"] = addressLocation

                val addressRegistration = RuAddress(
                    countryDigitCode = dbSalaryEmployeeInfoMap["address_info_country_digit_code"] as String?,
                    index = dbSalaryEmployeeInfoMap["address_info_c_index"] as String?,
                    regionCode = dbSalaryEmployeeInfoMap["address_info_region_code"] as String?,
                    district = dbSalaryEmployeeInfoMap["address_info_district"] as String?,
                    city = dbSalaryEmployeeInfoMap["address_info_city"] as String?,
                    inhabitedLocality = dbSalaryEmployeeInfoMap["address_info_inhabited_locality"] as String?,
                    street = dbSalaryEmployeeInfoMap["address_info_street"] as String?,
                    houseNumber = dbSalaryEmployeeInfoMap["address_info_house_number"] as String?,
                    housingNumber = dbSalaryEmployeeInfoMap["address_info_housing_number"] as String?,
                    buildingNumber = dbSalaryEmployeeInfoMap["address_info_building_number"] as String?,
                    apartmentNumber = dbSalaryEmployeeInfoMap["address_info_apartment_number"] as String?,
                    roomNumber = dbSalaryEmployeeInfoMap["address_info_room_number"] as String,
                    fullAddress = dbSalaryEmployeeInfoMap["address_info_full_address"] as String,
                )
                dbSalaryEmployeeInfoMap["addressRegistration"] = addressRegistration

                val identityDocument = SalaryEmployeeIdentityDocument(
                    docTypeCode = dbSalaryEmployeeInfoMap["identity_doc_doc_type_code"] as String,
                    docType = dbSalaryEmployeeInfoMap["identity_doc_doc_type"] as String,
                    docTypeName = dbSalaryEmployeeInfoMap["identity_doc_doc_type_name"] as String,
                    series  = dbSalaryEmployeeInfoMap["identity_doc_series"] as String?,
                    number = dbSalaryEmployeeInfoMap["identity_doc_number"] as String?,
                    issuingDate = dbSalaryEmployeeInfoMap["identity_doc_issuing_date"] as LocalDate?,
                    issuingAuthority = dbSalaryEmployeeInfoMap["identity_doc_issuing_authority"] as String?,
                    departmentCode = dbSalaryEmployeeInfoMap["identity_doc_department_code"] as String?,
                    countryDigitCode = dbSalaryEmployeeInfoMap["identity_doc_country_digit_code"] as String?,
                    endDate = dbSalaryEmployeeInfoMap["identity_doc_end_date"] as LocalDate?,
                )
                dbSalaryEmployeeInfoMap["identityDocument"] = identityDocument

                val residencyPermitDocument = SalaryEmployeeResidencyPermitDocument(
                    docType = dbSalaryEmployeeInfoMap["residency_permit_doc_doc_type"] as String,
                    docTypeName = dbSalaryEmployeeInfoMap["residency_permit_doc_doc_type_name"] as String,
                    series = dbSalaryEmployeeInfoMap["residency_permit_doc_series"] as String?,
                    number = dbSalaryEmployeeInfoMap["residency_permit_doc_number"] as String?,
                    issuingDate = dbSalaryEmployeeInfoMap["residency_permit_doc_issuing_date"] as LocalDate?,
                    issuingAuthority = dbSalaryEmployeeInfoMap["residency_permit_doc_issuing_authority"] as String?,
                    departmentCode = dbSalaryEmployeeInfoMap["residency_permit_doc_department_code"] as String?,
                    endDate = dbSalaryEmployeeInfoMap["residency_permit_doc_end_date"] as LocalDate?,
                    beginDate = dbSalaryEmployeeInfoMap["residency_permit_doc_begin_date"] as LocalDate?,
                )
                dbSalaryEmployeeInfoMap["residencyPermitDocument"] = residencyPermitDocument
            }

        }
}
