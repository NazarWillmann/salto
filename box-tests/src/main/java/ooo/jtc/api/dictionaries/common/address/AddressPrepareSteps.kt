package ooo.jtc.api.dictionaries.common.address

import ooo.jtc.dictionaries.common.address.AddressDto
import ooo.jtc.dictionaries.common.address.AddressType
import ooo.jtc.dictionaries.common.address.AddressType.RU
import ooo.jtc.dictionaries.common.address.ForeignAddressDto
import ooo.jtc.dictionaries.common.address.RuAddressDto
import ooo.jtc.extensions.ellipsis
import ooo.jtc.extensions.randomAnother
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.RandomData.Companion.latinWord
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.random.RandomNameUtils
import ooo.jtc.testdata.dictionaries.country.CountryData
import ooo.jtc.testdata.dictionaries.region.RuRegionData

object AddressPrepareSteps {

    fun getRandomAddressType(): AddressType {
        return AddressType.values().random()
    }

    fun generateRuAddressDto(): AddressDto {
        return AddressDto(
            addressType = RU.value,
            russian = getFilledRuAddressDto()
        )


    }

    fun getFilledAddressDto(addressType: AddressType): AddressDto {
        return if (addressType.value == "Russia")
            AddressDto(
                addressType = addressType.value,
                russian = getFilledRuAddressDto(),
            )
        else
            AddressDto(
                addressType = addressType.value,
                foreign = getFilledForeignAddressDto(),
            )
    }


    fun getFilledForeignAddressDto(): ForeignAddressDto {
        val countryDigitCode = CountryData.get(seekAtCreated = false)
            .map { it.digitCode }
            .randomAnother("643")
        val city = regexWord.random(3, 15)
        val index = digits.random(15, 15)
        val state = regexWord.random(3, 15)
        val address = "$state, $city," + latinWord.random(5, 15)
        return ForeignAddressDto(
            countryDigitCode = countryDigitCode,
            index = index,
            city = city,
            state = state,
            address = address
        )
    }


    fun getFilledRuAddressDto(): RuAddressDto {
        val region = RuRegionData.randomOrException(seekAtCreated = false)
        val countryDigitCode = "643"
        val index = digits.random(6, 6)
        val district = RandomNameUtils.state()
        val city = RandomNameUtils.city()
        val inhabitedLocality = "район '${region.name.ellipsis(35)}'"
        val street = RandomNameUtils.street()
        val houseNumber = digits.random(1, 7)
        val housingNumber = digits.random(1, 5)
        val apartmentNumber = digits.random(1, 9)
        val regionCode = RuRegionData.get(fromCache = false).random().code
        val buildingNumber = digits.random(1, 5)
        val roomNumber = digits.random(1, 9)
        return RuAddressDto(
            countryDigitCode = countryDigitCode,
            index = index,
            district = district,
            city = city,
            inhabitedLocality = inhabitedLocality,
            street = street,
            houseNumber = houseNumber,
            housingNumber = housingNumber,
            apartmentNumber = apartmentNumber,
            regionCode = regionCode,
            buildingNumber = buildingNumber,
            roomNumber = roomNumber,
            fullAddress = "$index $district $city $inhabitedLocality $street $houseNumber $housingNumber $apartmentNumber"
        )
    }
}