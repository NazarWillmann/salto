package ooo.jtc.api.dictionaries.person

import ooo.jtc.dictionaries.person.PersonCategory
import ooo.jtc.dictionaries.person.PersonDto
import ooo.jtc.dictionaries.person.PersonalDataDto
import ooo.jtc.uaa.User

object PersonPrepareSteps {
    fun getPersonDtoForCreate(
        user: User
    ): PersonDto {
        val personalData = PersonalDataDto(
            firstName = user.userDetails?.firstName.toString(),
            lastName = user.userDetails?.lastName.toString(),
            middleName = user.userDetails?.middleName.toString(),
            email = user.userDetails?.email.toString(),
            mobilePhone = user.userDetails?.phoneNumber.toString(),
            sex = null,
            birthdate = null
        )

        return PersonDto(
            id = user.uaaUserId,
            version = 0,
            description = null,
            category = PersonCategory.values().random().value,
            personalData = personalData,
            confirmedEmail = true,
            confirmedMobilePhone = true
        )
    }
}