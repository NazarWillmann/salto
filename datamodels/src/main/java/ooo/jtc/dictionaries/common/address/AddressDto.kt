package ooo.jtc.dictionaries.common.address

import com.github.pozo.KotlinBuilder

@KotlinBuilder
data class AddressDto(
    var addressType: String?,
    var russian: RuAddressDto? = null,
    var foreign: ForeignAddressDto? = null
)

@KotlinBuilder
data class ForeignAddressDto(
    var countryDigitCode: String?,
    var index: String?,
    var state: String?,
    var city: String?,
    var address: String?,
)

@KotlinBuilder
data class RuAddressDto(
    var countryDigitCode: String?,
    var index: String?,
    var regionCode: String,
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