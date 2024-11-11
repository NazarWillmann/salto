package ooo.jtc.api.dictionaries.swift

import com.fasterxml.jackson.module.kotlin.readValue
import io.qameta.allure.Step
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps.UPLOAD_DIR
import ooo.jtc.core.TestConstants
import ooo.jtc.dictionaries.swift.SwiftDto
import ooo.jtc.dictionaries.swift.SwiftInstType
import ooo.jtc.dictionaries.swift.bicplusv1.BicPlusEventType
import ooo.jtc.dictionaries.swift.bicplusv1.BicPlusV1Node
import ooo.jtc.dictionaries.swift.bicplusv1.BicPlusV1Xml
import ooo.jtc.extensions.DATE_ONLY
import ooo.jtc.extensions.string
import ooo.jtc.files.FileHelper
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.random.RandomData.Companion.regexWords
import ooo.jtc.serialization.SerializationUtils.XML_MAPPER
import java.io.File
import java.time.LocalDate

object SwiftPrepareSteps {

    private val BIC_PLUS_V1_SAMPLES_XML by lazy { File(this::class.java.getResource("$UPLOAD_DIR/bicplus_v1_sample.xml").toURI()) }
    private val BIC_PLUS_V1_SAMPLES by lazy { XML_MAPPER.readValue<BicPlusV1Xml>(BIC_PLUS_V1_SAMPLES_XML) }

    //issue JTCSALTO-3356
    private val ACCEPTABLE_BIC_PLUS_NODES by lazy {
        val created = BIC_PLUS_V1_SAMPLES.bicPlusV1NodeList
            .filter { it.eventType == BicPlusEventType.BIC_ISSUED.value }
        val expiredAndSuspended = BIC_PLUS_V1_SAMPLES.bicPlusV1NodeList
            .filter { it.eventType == BicPlusEventType.BIC_EXPIRED.value || it.eventType == BicPlusEventType.BIC_SUSPENDED.value }
        val active = created.minus(expiredAndSuspended)
        val latestValid = active
            .sortedByDescending { it.bic + it.eventDate.string() }
            .distinctBy { it.bic }
        latestValid
    }

    @Step("Подготовить структуру для файла импорта без записей")
    fun getEmptyBicPlusV1Xml(): BicPlusV1Xml {
        return BicPlusV1Xml(
            product = "bicplus_v1",
            filetype = "full",
            filedate = LocalDate.now().string(DATE_ONLY),
            bicPlusV1NodeList = emptyList()
        )
    }

    @Step("Взять из файла примера {amount} записей")
    fun getRandomBicPlusV1Entries(amount: Int): List<BicPlusV1Node> =
            ACCEPTABLE_BIC_PLUS_NODES.shuffled().take(amount)

    fun prepareAtSwiftDto(): SwiftDto {
        //TODO Sergeyev [2021.01.20]: improve
        return SwiftDto(
            id = null,
            version = 0,
            swift = "0000RU00${digits.random(3, 3)}", ///[0-9A-Z]{11}
            institutionType = SwiftInstType.FINANCIAL,
            dateActual = LocalDate.now(),
            name = "ENTRY_${digits.random(5, 10)}${TestConstants.AT_POSTFIX}",
            city = "CITY${digits.random(5, 10)}",
            address1 = regexWords.random(10, 30),
            address2 = regexWords.random(10, 30),
            address3 = null,
            address4 = null,
            branchName = "SOME BRANCH NAME ${regexWord.random(length = 5).toUpperCase()}",
            branchCity = null,
            branchAddress1 = null,
            branchAddress2 = null,
            branchAddress3 = null,
            branchAddress4 = null,
            countryAlpha2Code = "RU",
            recordStatus = "C"
        )
    }

    @Step("Подготовить записи SWIFT для импорта")
    fun prepareSwiftsForImport(amount: Int = 10): List<BicPlusV1Node> {
        val swiftCodesToUpload = getRandomBicPlusV1Entries(amount - 1).toMutableList()
        val atSwiftCode = prepareAtSwiftDto().toReducedBicPlusV1Node()
        swiftCodesToUpload.add(atSwiftCode)
        return swiftCodesToUpload
    }

    fun prepareTempFileForSwiftImport(amount: Int = 10): File {
        val swiftsForImport = prepareSwiftsForImport(amount)
        return prepareTempFileForSwiftImport(swiftsForImport)
    }

    @Step("Создать временный файл импорта")
    fun prepareTempFileForSwiftImport(swiftEntriesForImport: List<BicPlusV1Node>): File {
        val dataToUpload = getEmptyBicPlusV1Xml()
            .apply { bicPlusV1NodeList = swiftEntriesForImport }
        val baXmlToSerialize = XML_MAPPER.writeValueAsBytes(dataToUpload)
        return FileHelper.createSingleTempFile("serializedSwift", ".xml", baXmlToSerialize)
    }

    @Step("Подготовить для импорта файл примера")
    fun prepareSamplesForSwiftImport(): File {
        return BIC_PLUS_V1_SAMPLES_XML
    }

    fun prepareSwiftsForImportInUserCreator(): List<BicPlusV1Node> {
        return ACCEPTABLE_BIC_PLUS_NODES
    }

}