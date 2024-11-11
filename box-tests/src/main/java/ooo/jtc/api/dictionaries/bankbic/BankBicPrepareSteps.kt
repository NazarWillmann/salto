package ooo.jtc.api.dictionaries.bankbic

import com.fasterxml.jackson.module.kotlin.readValue
import io.qameta.allure.Step
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.dictionaries.bankbic.BankBic
import ooo.jtc.dictionaries.bankbic.BankBicAllowedServicesIEnum
import ooo.jtc.dictionaries.bankbic.BankBicDto
import ooo.jtc.dictionaries.bankbic.BankBicParticipantTransferTypeIEnum
import ooo.jtc.dictionaries.bankbic.BankBicParticipantTypeIEnum
import ooo.jtc.dictionaries.bankbic.BankBicStatusesIEnum
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccount
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccountDto
import ooo.jtc.dictionaries.bankbic.ed807.ED807BicNode
import ooo.jtc.dictionaries.bankbic.ed807.ED807Xml
import ooo.jtc.dictionaries.bankbic.restr.BankBicRestrictionDto
import ooo.jtc.dictionaries.branch.paymentdetails.BicPaymentDetailsDto
import ooo.jtc.dictionaries.country.DefaultCountry
import ooo.jtc.files.FileHelper
import ooo.jtc.random.RandomNameUtils
import ooo.jtc.random.RandomRequisites
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.random.RandomData.Companion.regexWords
import ooo.jtc.serialization.SerializationUtils
import java.io.File
import java.time.LocalDate
import java.time.ZonedDateTime

object BankBicPrepareSteps {

    private val ED807_FULL_XML by lazy { File(this::class.java.getResource("${AttachmentPrepareSteps.UPLOAD_DIR}/20211227_ED807_full.xml").toURI()) }
    private val ED807_SAMPLES by lazy { SerializationUtils.XML_MAPPER.readValue<ED807Xml>(ED807_FULL_XML) }

    private fun getEmptyED807Xml(): ED807Xml {
        return ED807Xml(
            edDate = LocalDate.now().minusDays(1),
            bicNodeList = emptyList(),
            creationDateTime = ZonedDateTime.now().minusDays(1),
            businessDay = LocalDate.now()
        )
    }

    fun getRandomED807Entries(amount: Int): List<ED807BicNode> =
        ED807_SAMPLES.bicNodeList.shuffled().take(amount)

    fun prepareAtBankBicDto(): BankBicDto {
        val partTransfType = BankBicParticipantTransferTypeIEnum.values().random().toDto()
        val partType = BankBicParticipantTypeIEnum.values().random().toDto()
        val allowedSrvcs = BankBicAllowedServicesIEnum.values().random().toDto()
        val status = BankBicStatusesIEnum.ACTIVE.toDto()

        val accounts = listOf<BankBicAccountDto>()
        val restrictions = listOf<BankBicRestrictionDto>()
        //TODO Sergeyev [2021.03.10]: (intimidatingly) You're gonna fix this, riiight?
        // [2021.03.16]: (trying to act cool) I dunno. Am I?
        return BankBicDto(
            id = null, version = 0,
            bic = RandomRequisites.generateBic(),
            name = "ENTRY${digits.random(5, 10)}${TestConstants.AT_POSTFIX}",
            countryAlpha2Code = DefaultCountry.RUS.alpha2Code,
            zip = digits.random(5, 10),
            locationType = regexWord.random(2, 3),
            location = RandomNameUtils.city(),
            address = regexWords.random(50, 100),
            parentBic = null,
            participantTransferType = partTransfType,
            participantType = partType,
            allowedServices = allowedSrvcs,
            dateIn = LocalDate.now(),
            dateOut = LocalDate.now().plusYears(1).plusMonths(2).plusWeeks(3).plusDays(4),
            status = status,
            accounts = emptyList(),//accounts,
            restrictions = emptyList()//restrictions
        )
    }

    fun prepareTempFileForBankBicImport(): File {
        val dataToUpload = getEmptyED807Xml()
        val bankBicCodesToUpload = getRandomED807Entries(amount = 10).toMutableList()
        val atBankBicCode = prepareAtBankBicDto().toReducedED807Node()
        bankBicCodesToUpload.add(atBankBicCode)
        dataToUpload.bicNodeList = bankBicCodesToUpload
        val baXmlToSerialize = SerializationUtils.XML_MAPPER.writeValueAsBytes(dataToUpload)
        return FileHelper.createSingleTempFile("serializedBankBic", ".xml", baXmlToSerialize)
    }

    @Step("Подготовить записи БИК РФ для импорта")
    fun prepareBankBicsForImport(amount: Int = 10, withAtRecordsAmount: Int = 3): List<ED807BicNode> {
        val bankBicEntriesToUpload = getRandomED807Entries(amount - withAtRecordsAmount).toMutableList()
        repeat(
            times = withAtRecordsAmount,
            action = {
                val atBankBicCode = prepareAtBankBicDto()
                    .apply { parentBic = bankBicEntriesToUpload.random().bic }
                    .toReducedED807Node()
                bankBicEntriesToUpload.add(atBankBicCode)
            }
        )
        return bankBicEntriesToUpload
    }

    fun prepareTempFileForBankBicImport(amount: Int = 10): File {
        val bankBicForImport = prepareBankBicsForImport(amount)
        return prepareTempFileForBankBicImport(bankBicForImport)
    }

    @Step("Создать временный файл импорта")
    fun prepareTempFileForBankBicImport(bankBicEntriesForImport: List<ED807BicNode>): File {
        val dataToUpload = getEmptyED807Xml()
            .apply { bicNodeList = bankBicEntriesForImport }
        val baXmlToSerialize = SerializationUtils.XML_MAPPER.writeValueAsBytes(dataToUpload)
        return FileHelper.createSingleTempFile("serializedBankBic", ".xml", baXmlToSerialize)
    }

    @Step("Подготовить для импорта файл примера")
    fun prepareSamplesForBankBicImport(): File {
        return ED807_FULL_XML
    }

    @Step("Подготовить Bic Payment Details")
    fun prepareBicPaymentDetails(bankBicData: List<BankBic>,bicAccountData: List<BankBicAccount>): BicPaymentDetailsDto {
        val randomCorrAcc = bicAccountData.random()
        val baseBankBic: BankBic = bankBicData.first{it.id == randomCorrAcc.bicId}
        return BicPaymentDetailsDto(
            bic = baseBankBic.bic,
            corrAcc = randomCorrAcc.account,
            bankNameBic = baseBankBic.name,
            bankPlaceBic = baseBankBic.locationType + " " + baseBankBic.location
        )
    }
}