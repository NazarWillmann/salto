package ooo.jtc.dictionaries.common.address

import com.github.pozo.KotlinBuilder

@KotlinBuilder
data class Address(
    var addressType: String,
    var ruAddress: RuAddress?,
    var foreignAddress: ForeignAddress?
)

@KotlinBuilder
data class RuAddress(
    var countryDigitCode: String?,
    var index: String?,
    var regionCode: String?,
    var district: String?,
    var city: String?,
    var inhabitedLocality: String?,
    var street: String?,
    var houseNumber: String?,
    var housingNumber: String?,
    var buildingNumber: String?,
    var apartmentNumber: String?,
    var roomNumber: String?,
    var fullAddress: String?,
)

@KotlinBuilder
data class ForeignAddress(
    var countryDigitCode: String?,
    var index: String?,
    var state: String?,
    var city: String?,
    var address: String?,
)

