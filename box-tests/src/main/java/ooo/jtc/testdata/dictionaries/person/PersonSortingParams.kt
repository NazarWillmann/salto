package ooo.jtc.testdata.dictionaries.person

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.person.PersonDto

enum class PersonSortingParams(
    override var field: String,
    override var fieldDataProvider: (PersonDto) -> Any?
) : ISortingParams<PersonDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    FIRST_NAME("personalData.firstName", fieldDataProvider = { it.personalData.firstName }),
    LAST_NAME("personalData.lastName", fieldDataProvider = { it.personalData.lastName }),
    MIDDLE_NAME("personalData.middleName", fieldDataProvider = { it.personalData.middleName }),
    MOBILE_PHONE("personalData.mobilePhone", fieldDataProvider = { it.personalData.mobilePhone }),
    EMAIL("personalData.email", fieldDataProvider = { it.personalData.email }),
    BIRTHDATE("personalData.birthdate", fieldDataProvider = { it.personalData.birthdate }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    SEX("personalData.sex", fieldDataProvider = { it.personalData.sex }),
    CATEGORY("category", fieldDataProvider = { it.category }),
    EMAIL_CONFIRMED("isConfirmedEmail", fieldDataProvider = { it.confirmedEmail }),
    PHONE_CONFIRMED("isConfirmedMobilePhone", fieldDataProvider = { it.confirmedMobilePhone }),
    ;
}