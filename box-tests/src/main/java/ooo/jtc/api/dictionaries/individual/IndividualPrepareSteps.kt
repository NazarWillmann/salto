package ooo.jtc.api.dictionaries.individual

import ooo.jtc.api.dictionaries.common.address.AddressPrepareSteps
import ooo.jtc.core.kexensions.invokeAuth
import ooo.jtc.dictionaries.common.BlockingInfoDto
import ooo.jtc.dictionaries.common.address.AddressDto
import ooo.jtc.dictionaries.identitydocument.IdentityDocumentDto
import ooo.jtc.dictionaries.identitydocument.IdentityDocumentStatusEnum
import ooo.jtc.dictionaries.individual.IndividualDto
import ooo.jtc.dictionaries.person.PersonalInfoDto
import ooo.jtc.extensions.getOrException
import ooo.jtc.random.RandomRequisites
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.identitydocumenttype.IdentityDocumentTypeData
import ooo.jtc.testdata.dictionaries.person.PersonData
import ooo.jtc.uaa.User
import java.time.LocalDate

object IndividualPrepareSteps {

    fun getIndividualDtoForCreate(
        personUser: User,
        isBlock: Boolean = false
    ): IndividualDto {
        //TODO Sergeyev [2021.08.27]: rewrite this
        val addressReg = AddressPrepareSteps.getFilledAddressDto(AddressPrepareSteps.getRandomAddressType())
        val addressLoc = AddressPrepareSteps.getFilledAddressDto(AddressPrepareSteps.getRandomAddressType())
        val personalInfo = getPersonalInfoDto(personUser)
        val identityDocument = getIdentityDocumentDto()
        val person = PersonData.getOrCreate(personUser).toDto()
        return IndividualDto(
            id = null,
            version = 0,
            block = BlockingInfoDto(isBlock),
            addressRegistration = addressReg,
            addressLocation = addressLoc,
            person = person,
            personalInfo = personalInfo,
            identityDocuments = listOf(identityDocument)
        )
    }

    private fun getIdentityDocumentDto(): IdentityDocumentDto {
        val docType = IdentityDocumentTypeData.randomOrException().toDto()
        return IdentityDocumentDto(
            id = null,
            version = 0,
            docType = docType,
            series = null,
            number = RandomRequisites.generateIdentityDocumentNumber(),
            issuingDate = LocalDate.now().minusYears(1),
            issuingAuthority = null,
            departmentCode = null,
            countryDigitCode = null,
            status = IdentityDocumentStatusEnum.ACTIVE.value
        )
    }

    private fun getPersonalInfoDto(personUser: User): PersonalInfoDto {

        return PersonalInfoDto(
            firstName = personUser.userDetails?.firstName.toString(),
            lastName = personUser.userDetails?.lastName.toString(),
            middleName = personUser.userDetails?.middleName.toString(),
            //TODO generate
            sex = null,
            birthday = LocalDate.now().minusYears(25),
            nationalityCountryDigitCode = "643",
            isResident = true,
            inn = RandomRequisites.generateInnPerson(),
            email = personUser.userDetails?.email.toString(),
            snils = RandomRequisites.generateSnils(),
            mobilePhone = personUser.userDetails?.phoneNumber.toString(),
            isPdAgreed = false
        )
    }

    fun createIndividualDto(
        bankCreatorUser: User,
        personUser: User,
        forUi: Boolean = true,
        individualForCreate: IndividualDto = getIndividualDtoForCreate(personUser, forUi),
        withLocAddress: Boolean = false,
        withRegAddress: Boolean = false,
        prepareAddress: () -> AddressDto = { AddressPrepareSteps.getFilledAddressDto(AddressPrepareSteps.getRandomAddressType()) },
    ): IndividualDto {
        val individualSteps = IndividualSteps(Users.superUser)
        val individualDto = individualSteps.create(individualForCreate).data.getOrException()
        val individualId = individualDto.id!!
        if (withRegAddress) {
            val addressRegDto = prepareAddress()
            individualDto.addressRegistration = addressRegDto
            individualSteps.update(individualDto)
        }
        if (withLocAddress) {
            val addressLocDto = prepareAddress()
            individualDto.addressLocation = addressLocDto
            individualSteps.update(individualDto)
        }
        bankCreatorUser.invokeAuth(newToken = true)
        return individualSteps.getById(individualId).data.getOrException()
    }
}