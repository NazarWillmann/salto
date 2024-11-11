@file:Suppress("KDocUnresolvedReference")

package ooo.jtc.api.letters.frombank.steps

import io.qameta.allure.Step
import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.common.checks.ApiDocumentChecks
import ooo.jtc.api.dictionaries.branch.BranchSteps
import ooo.jtc.api.dictionaries.customer.CustomerSteps
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps.getAttachmentDto
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.core.kexensions.getFio
import ooo.jtc.documents.Signature
import ooo.jtc.documents.SignatureDto
import ooo.jtc.extensions.DOTS_DATE_FORMAT
import ooo.jtc.extensions.asserts.assertEq
import ooo.jtc.extensions.asserts.assertIsNotEmpty
import ooo.jtc.extensions.ifNotEmpty
import ooo.jtc.extensions.ofUTC
import ooo.jtc.extensions.string
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.attachments.AttachmentDto
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.interfaces.getOrException
import ooo.jtc.interfaces.nullAccessTokens
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterFromBankStatus
import ooo.jtc.letters.model.LetterFromBankStatus.DELIVERED
import ooo.jtc.letters.model.LetterFromBankStatus.DETAILS_ERROR
import ooo.jtc.letters.model.LetterFromBankStatus.DRAFT
import ooo.jtc.letters.model.LetterFromBankStatus.NEW
import ooo.jtc.letters.model.LetterFromBankStatus.SIGNED
import ooo.jtc.letters.model.LetterFromBankStatus.WRONG_ESIGNATURE
import ooo.jtc.random.RandomData
import ooo.jtc.random.RandomRequisites
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.RandomData.Companion.regexWords
import ooo.jtc.serialization.SerializationUtils
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.dictionaries.lettertypefrombank.LetterTypeFromBankData
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams
import ooo.jtc.uaa.User
import org.apache.commons.codec.binary.Base64
import java.io.File
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.UUID

object LetterFromBankPrepareSteps {

    private val docChecks = ApiDocumentChecks<LetterFromBankDto>()
    private const val ERROR_MSG_DOC_IS_NOT_SIGNED = "Документ не был подписан"
    private const val ERROR_MSG_SENDING = "Ошибка при отправке Клиенту"

    /** Retrieve client user for receiving created LetterFromBank */
    fun retrieveClientUser(user: User): User =
        if (user.isClient) user else Users.client

    /** Retrieve bank user for creating LetterFromBank */
    fun retrieveBankUser(user: User): User =
        if (user.isBank) user else Users.bankOperator

    /**
     * Provides filter for getting all LettersFromBank with filled 'sendDate'.
     * "LesserOrEqual than current moment" basically means "all existing LFBs with non-null 'sendDate'"
     */
    val sentLfbFilter: FilterData
        get() = LetterFromBankFilterParams.SEND_DATE.le(ZonedDateTime.now().ofUTC())

    @Step("Найти или создать '${DocumentNames.LETTER_FROM_BANK}', доступное пользователю {searchingUser.login}")
    fun getOrCreateLetterFromBankDto(
        searchingUser: User,
        creatorBankUser: User = retrieveBankUser(searchingUser),
        getPageRequest: () -> GetPageRequest = { GetPageRequest() },
        additionalFilter: (LetterFromBankDto) -> Boolean = { true },
        createLfbFunc: () -> LetterFromBankDto = { createLetterFromBankAvailableToUser(user = searchingUser, creatorBankUser = creatorBankUser) }
    ): LetterFromBankDto {
        val existingAvailableLetters = LetterFromBankSteps(searchingUser)
            .getPage(getPageRequest = getPageRequest.invoke()).page
            ?.filter(additionalFilter)

        val letterToReturn: LetterFromBankDto =
            if (!existingAvailableLetters.isNullOrEmpty()) existingAvailableLetters.random()
            else createLfbFunc.invoke()

        return letterToReturn.attachToAllure()
    }

    @Step(
        "Найти набор разных '${DocumentNames.LETTER_FROM_BANK}' или создать их необходимое количество,"
                + " доступное пользователю {searchingUser.login}"
    )
    fun getOrCreateDifferentLetterFromBankDtoList(
        searchingUser: User,
        creatorBankUser: User = retrieveBankUser(searchingUser),
        getPageRequest: () -> GetPageRequest = { GetPageRequest() },
        additionalFilter: (LetterFromBankDto) -> Boolean = { true },
        createLfbFunc: () -> LetterFromBankDto = { createLetterFromBankAvailableToUser(user = searchingUser, creatorBankUser = creatorBankUser) },
        amount: Long = REQUIRED_DATA_COUNT
    ): List<LetterFromBankDto> {
        val resultLettersList: MutableList<LetterFromBankDto> = mutableListOf()

        val existingAvailableLetters =
            LetterFromBankSteps(searchingUser).getPage(getPageRequest = getPageRequest.invoke()).page
                ?.filter(additionalFilter)

        existingAvailableLetters?.let { resultLettersList.addAll(it.take(amount.toInt())) }
        while (resultLettersList.size < amount) {
            val newLetterFromBank = createLfbFunc.invoke()
            resultLettersList.add(newLetterFromBank)
        }

        return resultLettersList.attachToAllure()
    }

    fun getLetterFromBankDtoForCreate(
        creatorBankUser: User = Users.bankOperator,
        receiverClientUser: User = Users.client,
        attachments: List<File> = emptyList()
    ): LetterFromBankDto {
        val availableBranchCustomer = BranchCustomerData.getOrCreateCommonBranchCustomer(receiverClientUser, creatorBankUser)
        val customer = CustomerSteps(Users.superUser).getById(availableBranchCustomer.customerId).data.getOrException()
        val branch = BranchSteps(Users.superUser).getById(availableBranchCustomer.branchId).data.getOrException()
        val preparedDto = getLetterFromBankDtoForCreate(
            customerId = customer.id!!,
            customerName = customer.shortName,
            branchId = branch.id!!,
            branchName = branch.shortName
        )
        attachments.ifNotEmpty { addAttachmentsToDto(preparedDto, creatorBankUser, it) }
        return preparedDto
    }

    fun getLetterFromBankDtoForCreate(
        customerId: UUID,
        customerName: String? = CustomerData.byId(customerId).shortName,
        branchId: UUID,
        branchName: String? = BranchData.byId(branchId).shortName
    ): LetterFromBankDto {
        val docType = LetterTypeFromBankData.randomOrException()
        return LetterFromBankDto(
            id = null,
            version = 0,
            documentNumber = digits.random(6, 6),
            documentDate = LocalDate.now(),
            status = null,
            customerId = customerId,
            customerName = customerName,
            branchId = branchId,
            branchName = branchName,
            contactName = "Contact Name ${RandomData("[а-яА-Я ]*").random(7, 10)}",
            contactPhone = RandomRequisites.generatePhoneNumber(),
            docType = docType.code,
            docTypeDescription = docType.description,
            docTheme = "Theme ${regexWords.random(20, 25).trim()}$AT_POSTFIX",
            docText = "Letter body ${regexWords.random(20, 100).trim()}$AT_POSTFIX",
            isFavorites = false,
            isHasAttach = false,
            attachments = emptyList()
        )
    }

    fun getLetterFromBankDtoForUpdate(letterDto: LetterFromBankDto): LetterFromBankDto {
        return letterDto.copy(
            contactName = "Other ${letterDto.contactName}",
            contactPhone = "${letterDto.contactPhone}000".takeLast(12),
            docTheme = "Upd. ${letterDto.docTheme}",
            docText = "Updated ${letterDto.docText}"
        )
    }

    @Step("Добавить вложения к DTO Письма [{letterDto.id}]")
    fun addAttachmentsToDto(letterDto: LetterFromBankDto, creatorUser: User, files: List<File>): LetterFromBankDto {
        val uploadedFiles = files
            .map { AttachmentPrepareSteps.uploadFile(creatorUser, it) }
            .map { it.apply { documentId = letterDto.id } }
        val letterAttachments = letterDto.attachments!!.toMutableList()
        letterAttachments.addAll(uploadedFiles)

        return letterDto
            .apply { isHasAttach = true }
            .apply { attachments = letterAttachments }
    }

    /**
     * Copies provided LetterFromBankDto based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21726854.
     * @param user - user that copies [sourceLetter]
     * @param sourceLetter - LetterFromBank that will be copied
     * @param expDocNumber - expected [sourceLetter.documentNumber] value. Trying to get it AFTER actual copying
     *                      is incorrect, so it should be prepared beforehand
     * @param copyWithAttachments - boolean flag; indicates if [sourceLetter]-copy should be prepared with/without
     *                      attachment-related data
     */
    @Step("Подготовить ${DocumentNames.LETTER_FROM_BANK}-копию [{sourceLetter.id}] от лица '{user.login}'")
    fun getLetterFromBankDtoCopyDto(
        user: User,
        sourceLetter: LetterFromBankDto,
        expDocNumber: String,
        copyWithAttachments: Boolean
    ): LetterFromBankDto {
        val branchName = BranchData.byId(sourceLetter.branchId!!).shortName
        val letterType = sourceLetter.docType?.let { docType ->
            LetterTypeFromBankData.get(fromCache = true) { it.code == docType }
                .firstOrNull()
        }

        val contactPhone = BranchRepresentativeData.getOnlyOneOrNull(user)?.phone

        val attachments: List<AttachmentDto> =
            if (!copyWithAttachments) emptyList()
            else {
                val newAttachments = mutableListOf<AttachmentDto>()
                sourceLetter.attachments
                    ?.forEach { newAttachments.add(getAttachmentDto(null, it.fileName, it.dataSize, it.dataHash!!)) }
                newAttachments
            }

        return LetterFromBankDto(
            id = null,
            version = 1,
            documentNumber = expDocNumber,
            documentDate = LocalDate.now(),
            status = null,

            branchId = sourceLetter.branchId,
            branchName = branchName,

            customerId = sourceLetter.customerId,
            customerName = sourceLetter.customerName,

            isFavorites = sourceLetter.isFavorites,
            isHasAttach = copyWithAttachments && sourceLetter.isHasAttach ?: false,
            docType = letterType?.code,
            docTypeDescription = letterType?.description,
            contactName = user.getFio(),
            contactPhone = contactPhone,
            docText = sourceLetter.docText,
            docTheme = sourceLetter.docTheme,
            attachments = attachments
        )
    }

    /**
     * Creates expected LetterFromBank-answer for provided LetterToBank
     * based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171822
     *
     * @param user - user that creates LetterFromBank-answer
     * @param letterToBank - LetterToBank. Answer will be created for this LFB
     * @param expDocNumber - expected [letterToBank.documentNumber] value. Trying to get it AFTER requesting answer
     *                      is incorrect, so it should be prepared beforehand
     * @param answerWithAttachments - boolean flag; indicates if LetterFromBank-answer should be prepared with/without
     *                      attachment-related data
     */
    @Step("Подготовить ${DocumentNames.LETTER_FROM_BANK}-ответ на ${DocumentNames.LETTER_TO_BANK} [{letterToBank.id}] от лица '{user.login}'")
    fun prepareLFBAnswerForLetterToBankDto(
        user: User,
        letterToBank: LetterToBankDto,
        expDocNumber: String,
        answerWithAttachments: Boolean
    ): LetterFromBankDto {
        val customerName = CustomerData.byId(letterToBank.customerId!!).shortName
        val branchName = BranchData.byId(letterToBank.branchId!!).shortName
        val contactPhone = BranchRepresentativeData.getOnlyOneOrNull(user)?.phone
        val attachments: List<AttachmentDto> =
            if (!answerWithAttachments) emptyList()
            else {
                val newAttachments = mutableListOf<AttachmentDto>()
                letterToBank.attachments
                    ?.forEach { newAttachments.add(getAttachmentDto(null, it.fileName, it.dataSize, it.dataHash!!)) }
                newAttachments
            }
        val docText = "\n\nВ ответ на: Письмо в банк" +
                " (№${letterToBank.documentNumber}" +
                " от ${letterToBank.documentDate.string(DOTS_DATE_FORMAT)})" +
                "\n\n${letterToBank.docText}"

        return LetterFromBankDto(
            id = null,
            version = 1,
            documentNumber = expDocNumber,
            documentDate = LocalDate.now(),
            status = null,

            branchId = letterToBank.branchId,
            branchName = branchName,
            customerId = letterToBank.customerId,
            customerName = customerName,
            letterToBankId = letterToBank.id!!,
            isFavorites = false,
            isHasAttach = answerWithAttachments && letterToBank.isHasAttach ?: false,
            docType = null,
            docTypeDescription = null,
            contactName = user.getFio(),
            contactPhone = contactPhone,
            docText = docText,
            docTheme = "RE: ${letterToBank.docTheme}",
            attachments = attachments
        )
    }

    @Step("Создать ${DocumentNames.LETTER_FROM_BANK} доступное пользователю {user.login}")
    fun createLetterFromBankAvailableToUser(
        user: User,
        creatorBankUser: User = Users.bankOperator,
        dtoForCreate: LetterFromBankDto = getLetterFromBankDtoForCreate(creatorBankUser, retrieveClientUser(user))
    ): LetterFromBankDto {
        return if (user.isBank) createLetterFromBankDto(user, dtoForCreate)
        else createDeliveredLetterFromBank(creatorBankUser, user, dtoForCreate, returnBankDto = false)
    }

    @Step("Создать ${DocumentNames.LETTER_FROM_BANK} для организации, доступной пользователям {creatorBankUser.login}, {receiverClientUser.login}")
    fun createLetterFromBankDto(
        creatorBankUser: User = Users.bankOperator,
        receiverClientUser: User = Users.client
    ): LetterFromBankDto {
        val dtoForCreate = getLetterFromBankDtoForCreate(creatorBankUser, receiverClientUser)
        return createLetterFromBankDto(creatorBankUser, dtoForCreate)
    }

    fun createLetterFromBankDto(
        creatorBankUser: User = Users.bankOperator,
        dtoForCreate: LetterFromBankDto
    ): LetterFromBankDto {
        return LetterFromBankSteps(creatorBankUser).create(dtoForCreate).data.getOrException()
    }

    //region Create in status
    @Step("Создать ${DocumentNames.LETTER_FROM_BANK} в статусе '{status}' для пользователей {creatorBankUser.login}, {receiverClientUser.login}")
    fun createLetterFromBankInStatus(
        creatorBankUser: User = Users.bankOperator,
        receiverClientUser: User = Users.client,
        status: LetterFromBankStatus,
        dtoForCreate: LetterFromBankDto = getLetterFromBankDtoForCreate(creatorBankUser, receiverClientUser)
    ): LetterFromBankDto {
        return when (status) {
            DRAFT -> createDraftLetterFromBank(creatorBankUser, receiverClientUser, dtoForCreate)
            NEW -> createNewLetterFromBank(creatorBankUser, receiverClientUser, dtoForCreate)
            SIGNED -> createSignedLetterFromBank(creatorBankUser, receiverClientUser, dtoForCreate)
            DELIVERED -> createDeliveredLetterFromBank(creatorBankUser, receiverClientUser, dtoForCreate)
            WRONG_ESIGNATURE -> createIncorrectDigestLetterFromBank_DIRTY(creatorBankUser, receiverClientUser, dtoForCreate)
            DETAILS_ERROR -> createDetailsErrorLetterFromBank_DIRTY(creatorBankUser, receiverClientUser, dtoForCreate)
            else -> throw RuntimeException("Unexpected status for LetterFromBank creation: $status")
        }
    }

    @Step("Создать ${DocumentNames.LETTER_FROM_BANK} в статусе DRAFT")
    fun createDraftLetterFromBank(
        creatorBankUser: User = Users.bankOperator,
        receiverClientUser: User = Users.client,
        dtoForCreate: LetterFromBankDto = getLetterFromBankDtoForCreate(creatorBankUser, receiverClientUser)
    ): LetterFromBankDto {
        val draftLfb = LetterFromBankSteps(creatorBankUser).createWithoutCheck(dtoForCreate).data.getOrException()

        draftLfb.id.assertIsNotEmpty()
        docChecks.checkDocumentStatus(draftLfb, listOf(DRAFT.statusBank))
        return draftLfb
    }

    @Step("Создать ${DocumentNames.LETTER_FROM_BANK} в статусе NEW")
    fun createNewLetterFromBank(
        creatorBankUser: User = Users.bankOperator,
        receiverClientUser: User = Users.client,
        dtoForCreate: LetterFromBankDto = getLetterFromBankDtoForCreate(creatorBankUser, receiverClientUser)
    ): LetterFromBankDto {
        val newLTB = LetterFromBankSteps(creatorBankUser).create(dtoForCreate).data.getOrException()

        newLTB.id.assertIsNotEmpty()
        docChecks.checkDocumentStatus(newLTB, listOf(NEW.statusBank))
        return newLTB
    }

    @Step("Создать ${DocumentNames.LETTER_FROM_BANK} в статусе SIGNED")
    fun createSignedLetterFromBank(
        creatorBankUser: User = Users.bankOperator,
        receiverClientUser: User = Users.client,
        dtoForCreate: LetterFromBankDto = getLetterFromBankDtoForCreate(creatorBankUser, receiverClientUser)
    ): LetterFromBankDto {
        val newLetter = createNewLetterFromBank(creatorBankUser, receiverClientUser, dtoForCreate)
        val signedLetter = LetterFromBankSteps(creatorBankUser).signDocumentByCertificate(newLetter).data
            .getOrException("Ошибка при подписании")
        signedLetter.id.assertEq(newLetter.id)
        docChecks.checkDocumentStatus(signedLetter, listOf(SIGNED.statusBank))
        return signedLetter
    }

    @Step("Создать ${DocumentNames.LETTER_FROM_BANK} в статусе WRONG_ESIGNATURE (изменение дайджеста)")
    fun createIncorrectDigestLetterFromBank_DIRTY(
        creatorBankUser: User = Users.bankOperator,
        receiverClientUser: User = Users.client,
        dtoForCreate: LetterFromBankDto = getLetterFromBankDtoForCreate(creatorBankUser, receiverClientUser)
    ): LetterFromBankDto {
        val signedLfb = createSignedLetterFromBank(creatorBankUser, receiverClientUser, dtoForCreate)
        val changedLfb = makeDigestIncorrect_DIRTY(signedLfb)

        val bankUserSteps = LetterFromBankSteps(creatorBankUser)
        val sentLfb = bankUserSteps.send(changedLfb.id!!).data.getOrException(ERROR_MSG_SENDING)
        sentLfb.id.assertEq(changedLfb.id)
        val wrongESignatureLfb = docChecks.repeatableCheckDocumentLifecycleTransition(
            getActResultFunc = {
                bankUserSteps.getById(sentLfb.id!!).data
                    .getOrException("Ошибка при получении документа на банковской стороне")
            },
            preparedDto = sentLfb,
            expStatuses = listOf(WRONG_ESIGNATURE.statusBank),
            additionalHandling = { prepDto, _ -> removeAttachmentsTokens(prepDto) },
            repeatLimitSec = 10
        )

        return wrongESignatureLfb
    }

    @Step("Создать ${DocumentNames.LETTER_FROM_BANK} DETAILS_ERROR")
    fun createDetailsErrorLetterFromBank_DIRTY(
        creatorBankUser: User = Users.bankOperator,
        receiverClientUser: User = Users.client,
        dtoForCreate: LetterFromBankDto = getLetterFromBankDtoForCreate(creatorBankUser, receiverClientUser)
    ): LetterFromBankDto {
        val signedLetter = createSignedLetterFromBank(creatorBankUser, receiverClientUser, dtoForCreate)
        val changedLetter = makeDetailsWrong_DIRTY(signedLetter)

        val bankUserSteps = LetterFromBankSteps(creatorBankUser)
        val sentLetter = bankUserSteps.send(changedLetter.id!!).data.getOrException(ERROR_MSG_SENDING)
        sentLetter.id.assertEq(changedLetter.id)
        val detailsWrongLetter = docChecks.repeatableCheckDocumentLifecycleTransition(
            getActResultFunc = {
                bankUserSteps.getById(sentLetter.id!!).data
                    .getOrException("Ошибка при получении документа на банковской стороне")
            },
            preparedDto = sentLetter,
            expStatuses = listOf(DETAILS_ERROR.statusBank),
            additionalHandling = { prepDto, _ -> removeAttachmentsTokens(prepDto) },
            repeatLimitSec = 10
        )
        return detailsWrongLetter
    }

    @Step("Создать ${DocumentNames.LETTER_FROM_BANK} в статусе DELIVERED")
    fun createDeliveredLetterFromBank(
        creatorBankUser: User = Users.bankOperator,
        receiverClientUser: User = Users.client,
        dtoForCreate: LetterFromBankDto = getLetterFromBankDtoForCreate(creatorBankUser, receiverClientUser),
        returnBankDto: Boolean = true
    ): LetterFromBankDto {
        val signedLfb = createSignedLetterFromBank(creatorBankUser, receiverClientUser, dtoForCreate)

        val sentLfb = LetterFromBankSteps(creatorBankUser).send(signedLfb.id!!).data
            .getOrException(ERROR_MSG_SENDING)
        sentLfb.id.assertEq(signedLfb.id)
        docChecks.checkDocumentStatus(sentLfb, listOf(DELIVERED.statusBank))
        if (returnBankDto)
            return sentLfb

        val deliveredLfbClient = LetterFromBankSteps(receiverClientUser).getById(sentLfb.id!!).data
            .getOrException("Ошибка при получении документа на клиентской стороне")
        docChecks.checkDocumentStatus(deliveredLfbClient, listOf(DELIVERED.statusClient))
        return deliveredLfbClient
    }
    //endregion

    //region Support methods
    /** Null all attachments' [accessToken]s from LetterFromBank for proper DTO comparison */
    val removeAttachmentsTokens: (letterFromBank: LetterFromBankDto) -> LetterFromBankDto = { lfb ->
        lfb.apply { attachments.nullAccessTokens() }
    }

    private fun getLfbSignaturesFromDB(letterId: UUID): List<SignatureDto> {
        val sqlRequest = "SELECT * from letter_from_bank_signatures WHERE id_document = '$letterId'"
        val data = Services.LETTER.db.execSql(sqlRequest)
            .map { SerializationUtils.OBJECT_MAPPER.convertValue(it, Signature::class.java) }
            .map { it.toDto() }
        return data
    }

    @Step("Испортить подпись, сломав её структуру")
    fun makeSignatureCorrupt_DIRTY(document: LetterFromBankDto, signatureId: UUID? = null): LetterFromBankDto {
        val docSignatures = getLfbSignaturesFromDB(document.id!!)
        if (docSignatures.isEmpty()) throw RuntimeException(ERROR_MSG_DOC_IS_NOT_SIGNED)

        val signatureDto = signatureId
            ?.let { signToCorruptId -> docSignatures.first { signToCorruptId == it.id } }
            ?: docSignatures.first()
        val corruptedSignatureEncoded = Base64.encodeBase64String("Corrupted signature".toByteArray())

        // corrupt signature
        val sqlRequest = "UPDATE letter_from_bank_signatures " +
                "SET signature = '$corruptedSignatureEncoded' " +
                "WHERE id = '${signatureDto.id!!}'"
        Services.LETTER.db.execute(sqlRequest)
        return document
    }

    @Step("Изменить данные документа, чтобы дайджест при проверке был признан некорректным")
    fun makeDigestIncorrect_DIRTY(document: LetterFromBankDto): LetterFromBankDto {
        if (getLfbSignaturesFromDB(document.id!!).isEmpty()) throw RuntimeException(ERROR_MSG_DOC_IS_NOT_SIGNED)

        // change docField that stored in digest
        val updatedDocText = "[Corrupting the digest] ${document.docText!!}"
        val sqlRequest = "UPDATE letter_from_bank " +
                "SET doc_text = '$updatedDocText'" +
                "WHERE id = '${document.id!!}'"
        Services.LETTER.db.execute(sqlRequest)

        // return changed DTO
        document.docText = updatedDocText
        return document
    }

    @Step("Испортить данные Письма, не затронув подписанные данные")
    fun makeDetailsWrong_DIRTY(document: LetterFromBankDto): LetterFromBankDto {
        if (getLfbSignaturesFromDB(document.id!!).isEmpty()) throw RuntimeException(ERROR_MSG_DOC_IS_NOT_SIGNED)

        // empty important unsigned fields
        val sqlRequest = "UPDATE letter_from_bank " +
                "SET doc_type_description = null " +
                "WHERE id = '${document.id!!}'"
        Services.LETTER.db.execute(sqlRequest)

        document.docTypeDescription = null
        return document
    }
    //endregion
}