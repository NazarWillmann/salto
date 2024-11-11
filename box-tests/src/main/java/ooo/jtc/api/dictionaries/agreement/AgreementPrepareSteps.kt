package ooo.jtc.api.dictionaries.agreement

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants
import ooo.jtc.dictionaries.agreement.AgreementDto
import ooo.jtc.dictionaries.agreement.AgreementType
import ooo.jtc.dictionaries.agreement.AgreementTypeStatus
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import java.time.LocalDate

object AgreementPrepareSteps {

    val codeChars by lazy {
        RandomData.builder()
            .withRussianCapitalLetters()
            .withDigits()
            .build()
    }

    @Step("Создать новое соглашение")
    fun getAgreementDtoForCreate(): AgreementDto {
        val customer = CustomerData.getOrCreate(Users.client)
        return AgreementDto(
            id = null,
            version = 0,
            agreementDate = LocalDate.now(),
            agreementNumber = RandomData.digits.random(15),
            description = RandomData.regexWords.random(10, 252) + TestConstants.AT_POSTFIX,
            agreementType = AgreementType.SALARY.name,
            status = AgreementTypeStatus.ACTIVE.name,
            endDate = LocalDate.now().plusYears(1),
            customerId = customer.id!!,
            customerFullName = customer.fullName,
            customerShortName = customer.shortName
        )
    }

    @Step("Создать новое соглашение активированное")
    fun getActivateAgreementDto(): AgreementDto {
        val customer = CustomerData.getOrCreate(Users.client)
        return AgreementDto(
            id = null,
            version = 0,
            agreementDate = LocalDate.now(),
            agreementNumber = RandomData.digits.random(15),
            description = RandomData.regexWords.random(10, 252) + TestConstants.AT_POSTFIX,
            agreementType = AgreementType.SALARY.name,
            status = AgreementTypeStatus.ACTIVE.name,
            customerFullName = customer.fullName,
            customerShortName = customer.shortName,
            customerId = customer.id!!
        )
    }

    @Step("Создать новое соглашение деактивированное")
    fun getDeactivateAgreementDto(): AgreementDto {
        val customer = CustomerData.getOrCreate(Users.client)
        return AgreementDto(
            id = null,
            version = 0,
            agreementDate = LocalDate.now(),
            agreementNumber = RandomData.digits.random(15),
            description = RandomData.regexWords.random(10, 252) + TestConstants.AT_POSTFIX,
            agreementType = AgreementType.SALARY.name,
            status = AgreementTypeStatus.INACTIVE.name,
            customerFullName = customer.fullName,
            customerShortName = customer.shortName,
            customerId = customer.id!!
        )
    }

    @Step("Обновить соглашение")
    fun getAgreementDtoForUpdate(createdAgreementDto: AgreementDto): AgreementDto {
        return createdAgreementDto.copy(
            agreementDate = LocalDate.now(),
            agreementNumber = RandomData.digits.random(15),
            description = "(update) " + RandomData.regexWords.random(1, 243) + TestConstants.AT_POSTFIX,
            agreementType = AgreementType.OTHER.name,
        )
    }
}