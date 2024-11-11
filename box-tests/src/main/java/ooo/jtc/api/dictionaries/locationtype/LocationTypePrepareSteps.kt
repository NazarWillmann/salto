package ooo.jtc.api.dictionaries.locationtype

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.locationtype.LocationTypeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.locationtype.FindLocationTypeBy
import ooo.jtc.testdata.dictionaries.locationtype.LocationTypeData

object LocationTypePrepareSteps {

    @Step("Удалить созданные автотестами данные LocationType из БД")
    fun cleanAtCreated() {
        FindLocationTypeBy.AT_CREATED.get().forEach { locType ->
            LocationTypeData.removeRecord?.let { it(locType) }
        }
    }

    fun getLocationTypeDtoForCreate(): LocationTypeDto {
        val randStr = regexWord.random(5, 10)
        return LocationTypeDto(
            id = null,
            version = 0,
            locationType = "9${digits.random(4, 4)}",
            name = "Location Type / ${randStr}$AT_POSTFIX",
            nameShort = "LT / $randStr"
        )
    }

    fun getLocationTypeDtoForUpdate(createdDto: LocationTypeDto) =
        LocationTypeDto(
            createdDto.id, createdDto.version,
            "951${createdDto.locationType}",
            "Updated ${createdDto.name}",
            "U${createdDto.nameShort}"
        )

    @Step("Создать ${DictionaryNames.LOCATION_TYPE}")
    fun createLocationTypeDto(dtoForCreate: LocationTypeDto = getLocationTypeDtoForCreate()): LocationTypeDto {
        return LocationTypeSteps(Users.bankAdmin).create(dtoForCreate).data.getOrException()
    }
}