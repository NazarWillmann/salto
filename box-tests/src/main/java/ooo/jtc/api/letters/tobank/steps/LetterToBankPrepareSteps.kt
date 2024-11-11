package ooo.jtc.api.letters.tobank.steps

import io.qameta.allure.Step
import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.common.checks.ApiDocumentChecks
import ooo.jtc.api.dictionaries.branch.BranchSteps
import ooo.jtc.api.dictionaries.customer.CustomerSteps
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps.getAttachmentDto
import ooo.jtc.core.DocumentConstants.ERROR_MSG_BANK_GET_BY_ID
import ooo.jtc.core.DocumentConstants.ERROR_MSG_CLIENT_GET_BY_ID
import ooo.jtc.core.DocumentConstants.ERROR_MSG_DOC_IS_NOT_SIGNED
import ooo.jtc.core.DocumentConstants.ERROR_MSG_SENDING_TO_BANK
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.core.kexensions.checkIsClientUser
import ooo.jtc.core.kexensions.getFio
import ooo.jtc.documents.Signature
import ooo.jtc.documents.SignatureDto
import ooo.jtc.documents.bankAvailableStatuses
import ooo.jtc.extensions.DOTS_DATE_FORMAT
import ooo.jtc.extensions.asserts.assertEq
import ooo.jtc.extensions.asserts.assertIsNotEmpty
import ooo.jtc.extensions.getOrException
import ooo.jtc.extensions.ifNotEmpty
import ooo.jtc.extensions.ofSystemOffset
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
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.letters.model.LetterToBankStatus.DELIVERED
import ooo.jtc.letters.model.LetterToBankStatus.DETAILS_ERROR
import ooo.jtc.letters.model.LetterToBankStatus.DRAFT
import ooo.jtc.letters.model.LetterToBankStatus.FOR_RECEIVING
import ooo.jtc.letters.model.LetterToBankStatus.IN_PROCESSING
import ooo.jtc.letters.model.LetterToBankStatus.NEW
import ooo.jtc.letters.model.LetterToBankStatus.PROCESSED
import ooo.jtc.letters.model.LetterToBankStatus.RECALLED
import ooo.jtc.letters.model.LetterToBankStatus.RECEIVED
import ooo.jtc.letters.model.LetterToBankStatus.RECEIVING_ERROR
import ooo.jtc.letters.model.LetterToBankStatus.SIGNED
import ooo.jtc.letters.model.LetterToBankStatus.WRONG_ESIGNATURE
import ooo.jtc.random.RandomData
import ooo.jtc.random.RandomRequisites.generatePhoneNumber
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.RandomData.Companion.regexWords
import ooo.jtc.serialization.SerializationUtils
import ooo.jtc.serialization.deserialize
import ooo.jtc.serialization.serialize
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.dictionaries.lettertypetobank.LetterTypeToBankData
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams
import ooo.jtc.uaa.User
import org.apache.commons.codec.binary.Base64.decodeBase64
import org.apache.commons.codec.binary.Base64.encodeBase64String
import java.io.File
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.UUID

object LetterToBankPrepareSteps {

    private val docChecks = ApiDocumentChecks<LetterToBankDto>()

    /**
     * Provides filter for getting all LettersToBank with filled 'executionDate'.
     * "LesserOrEqual than current moment" basically means "all existing LTBs with non-null 'executionDate'"
     */
    val executedLTBFilter: FilterData
        get() = LetterToBankFilterParams.EXECUTION_DATE.le(ZonedDateTime.now().ofUTC())

    /**
     * Retrieve client user for creation.
     * Because only client user can create LetterToBank.
     */
    fun retrieveClientUser(user: User): User =
        if (user.isClient) user else Users.client

    /**
     * Retrieve bank user for receiving created LetterToBank.
     */
    fun retrieveBankUser(user: User): User =
        if (user.isBank) user else Users.bankOperator


    @Step("Найти или создать '${DocumentNames.LETTER_TO_BANK}', доступное пользователю {searchingUser.login}")
    fun getOrCreateLetterToBankDto(
        searchingUser: User,
        creatorClientUser: User = retrieveClientUser(searchingUser),
        getPageRequest: () -> GetPageRequest = { GetPageRequest() },
        additionalFilter: (LetterToBankDto) -> Boolean = { true },
        createLtbFunc: () -> LetterToBankDto = {
            if (searchingUser.isClient) createLetterToBankDto(creatorClientUser = searchingUser)
            else createLetterToBankDto(creatorClientUser = creatorClientUser, receiverBankUser = searchingUser)
        }
    ): LetterToBankDto {
        creatorClientUser.checkIsClientUser()

        val existingAvailableLetters =
            LetterToBankSteps(searchingUser).getPage(getPageRequest = getPageRequest.invoke()).page?.filter(additionalFilter)

        val letterToReturn: LetterToBankDto = if (!existingAvailableLetters.isNullOrEmpty()) existingAvailableLetters.random()
        else createLtbFunc.invoke()

        return letterToReturn.attachToAllure("result")
    }

    @Step(
        "Найти набор разных '${DocumentNames.LETTER_TO_BANK}' или создать их необходимое количество," + " доступное пользователю {searchingUser.login}"
    )
    fun getOrCreateDifferentLetterToBankDtoList(
        searchingUser: User,
        creatorClientUser: User = retrieveClientUser(searchingUser),
        getPageRequest: () -> GetPageRequest = { GetPageRequest() },
        additionalFilter: (LetterToBankDto) -> Boolean = { true },
        createLtbFunc: () -> LetterToBankDto = {
            if (searchingUser.isClient) createLetterToBankDto(creatorClientUser = searchingUser)
            else createLetterToBankDto(creatorClientUser = creatorClientUser, receiverBankUser = searchingUser)
        },
        amount: Long = REQUIRED_DATA_COUNT
    ): List<LetterToBankDto> {
        creatorClientUser.checkIsClientUser()
        val resultLettersList: MutableList<LetterToBankDto> = mutableListOf()

        val existingAvailableLetters =
            LetterToBankSteps(searchingUser).getPage(getPageRequest = getPageRequest.invoke()).page?.filter(additionalFilter)

        existingAvailableLetters?.let { resultLettersList.addAll(it.take(amount.toInt())) }
        while (resultLettersList.size < amount) {
            val newLetterToBank = createLtbFunc.invoke()
            resultLettersList.add(newLetterToBank)
        }

        return resultLettersList.attachToAllure("result")
    }

    @Step("Подготовить объект для создания '${DocumentNames.LETTER_TO_BANK}'")
    fun getLetterToBankDtoForCreate(
        customerId: UUID,
        attachments: List<AttachmentDto>? = emptyList()
    ): LetterToBankDto {
        val availableBranchCustomer = BranchCustomerData.get { it.customerId == customerId }
            .ifEmpty { throw RuntimeException("Клиент ($customerId) не привязан ни к одному подразделению") }.random()
        val customer = CustomerSteps(Users.superUser).getById(customerId).data.getOrException()
        val branch = BranchSteps(Users.superUser).getById(availableBranchCustomer.branchId).data.getOrException()
        return getLetterToBankDtoForCreate(
            customerId = customerId,
            customerName = customer.shortName,
            branchId = branch.id!!,
            branchName = branch.shortName,
            attachments = attachments
        )
    }


    fun getLetterToBankDtoForCreate(
        creatorClientUser: User = Users.client,
        receiverBankUser: User = Users.bankOperator,
        attachments: List<File> = emptyList()
    ): LetterToBankDto {
        val availableBranchCustomer = BranchCustomerData.getOrCreateCommonBranchCustomer(creatorClientUser, receiverBankUser)
        val customer = CustomerSteps(Users.superUser).getById(availableBranchCustomer.customerId).data.getOrException()
        val branch = BranchSteps(Users.superUser).getById(availableBranchCustomer.branchId).data.getOrException()
        val preparedDto = getLetterToBankDtoForCreate(
            customerId = customer.id!!, customerName = customer.shortName, branchId = branch.id!!, branchName = branch.shortName
        )
        attachments.ifNotEmpty { addAttachmentsToDto(preparedDto, creatorClientUser, it) }
        return preparedDto
    }

    fun getLetterToBankDtoForCreate(
        customerId: UUID,
        customerName: String? = null,
        branchId: UUID? = null,
        branchName: String? = null,
        attachments: List<AttachmentDto>? = emptyList()
    ): LetterToBankDto {
        val docType = LetterTypeToBankData.randomOrException()
        return LetterToBankDto(
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
            contactPhone = generatePhoneNumber(),
            docType = docType.code,
            docTypeDescription = docType.description,
            docTheme = "Theme ${regexWords.random(20, 25).trim()}$AT_POSTFIX",
            docText = "Letter body ${regexWords.random(20, 100).trim()}$AT_POSTFIX",
            isFavorites = false,
            isHasAttach = false,
            attachments = attachments
        )
    }

    fun getLetterToBankDtoForUpdate(letterDto: LetterToBankDto): LetterToBankDto {
        return letterDto.copy(
            contactName = "Other ${letterDto.contactName}",
            contactPhone = "${letterDto.contactPhone}000".takeLast(12),
            docTheme = "Upd. ${letterDto.docTheme}",
            docText = "Updated ${letterDto.docText}"
        )
    }

    @Step("Добавить вложения к DTO Письма [{letterDto.id}]")
    fun addAttachmentsToDto(letterDto: LetterToBankDto, creatorUser: User, files: List<File>): LetterToBankDto {
        val uploadedFiles = files.map { AttachmentPrepareSteps.uploadFile(creatorUser, it) }.map { it.apply { documentId = letterDto.id } }
        val ltbAttachments = letterDto.attachments!!.toMutableList()
        ltbAttachments.addAll(uploadedFiles)

        return letterDto.apply { isHasAttach = true }.apply { attachments = ltbAttachments }
    }

    /**
     * Copies provided LetterToBankDto based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171412.
     * @param user - user that copies [sourceLTB]
     * @param sourceLTB - LetterToBank that will be copied
     * @param expDocNumber - expected [sourceLTB.documentNumber] value. Trying to get it AFTER actual copying
     *                      is incorrect, so it should be prepared beforehand
     * @param copyWithAttachments - boolean flag; indicates if [sourceLTB]-copy should be prepared with/without
     *                      attachment-related data
     */
    @Step("Подготовить ${DocumentNames.LETTER_TO_BANK}-копию [{sourceLTB.id}] от лица '{user.login}'")
    fun prepareLetterToBankDtoCopyDto(
        user: User, sourceLTB: LetterToBankDto, expDocNumber: String, copyWithAttachments: Boolean
    ): LetterToBankDto {
        val customerName = CustomerData.byId(sourceLTB.customerId!!).shortName
        val branchName = BranchData.byId(sourceLTB.branchId!!).shortName
        val ltbType = sourceLTB.docType?.let { docType ->
            LetterTypeToBankData.get(fromCache = true) { it.code == docType }.firstOrNull()
        }
        val contactPerson = CustomerRepresentativeData.searchBy(user).first { it.customerId!! == sourceLTB.customerId!! }
        val contactPhone = contactPerson.phone ?: user.userDetails?.phoneNumber
        val attachments: List<AttachmentDto> = if (!copyWithAttachments) emptyList()
        else {
            val newAttachments = mutableListOf<AttachmentDto>()
            sourceLTB.attachments?.forEach { newAttachments.add(getAttachmentDto(null, it.fileName, it.dataSize, it.dataHash!!)) }
            newAttachments
        }

        return LetterToBankDto(
            id = null,
            version = 1,
            documentNumber = expDocNumber,
            documentDate = LocalDate.now(),
            status = null,

            branchId = sourceLTB.branchId,
            branchName = branchName,
            customerId = sourceLTB.customerId,
            customerName = customerName,
            letterFromBankId = null,
            isFavorites = false,
            isHasAttach = copyWithAttachments && sourceLTB.isHasAttach ?: false,
            docType = ltbType?.code,
            docTypeDescription = ltbType?.description,
            contactName = user.getFio(),
            contactPhone = contactPhone,
            docText = sourceLTB.docText,
            docTheme = sourceLTB.docTheme,
            attachments = attachments
        )
    }

    /**
     * Creates expected LetterToBank-answer for provided LetterFromBank
     * based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171822
     *
     * @param user - user that creates LetterToBank-answer
     * @param letterFromBank - LetterFromBank. Answer will be created for this LFB
     * @param expDocNumber - expected [letterFromBank.documentNumber] value. Trying to get it AFTER requesting answer
     *                      is incorrect, so it should be prepared beforehand
     * @param answerWithAttachments - boolean flag; indicates if LetterToBank-answer should be prepared with/without
     *                      attachment-related data
     */
    @Step(
        "Подготовить ${DocumentNames.LETTER_TO_BANK}-ответ на ${DocumentNames.LETTER_FROM_BANK} [{letterFromBank.id}] от лица '{user.login}'"
    )
    fun prepareLTBAnswerForLetterFromBankDto(
        user: User, letterFromBank: LetterFromBankDto, expDocNumber: String, answerWithAttachments: Boolean
    ): LetterToBankDto {
        val customerName = CustomerData.byId(letterFromBank.customerId!!).shortName
        val branchName = BranchData.byId(letterFromBank.branchId!!).shortName
        val contactPerson = CustomerRepresentativeData.searchBy(user)
            .first { it.customerId!! == letterFromBank.customerId!! }
        val contactPhone = contactPerson.phone ?: user.userDetails?.phoneNumber
        val attachments: List<AttachmentDto> =
            if (!answerWithAttachments) emptyList()
            else {
                val newAttachments = mutableListOf<AttachmentDto>()
                letterFromBank.attachments?.forEach { newAttachments.add(getAttachmentDto(null, it.fileName, it.dataSize, it.dataHash!!)) }
                newAttachments
            }
        val docText = "\n\nВ ответ на: Письмо из банка" +
                " (№${letterFromBank.documentNumber}" +
                " от ${letterFromBank.documentDate.string(DOTS_DATE_FORMAT)})" +
                "\n\n${letterFromBank.docText}"

        return LetterToBankDto(
            id = null,
            version = 1,
            documentNumber = expDocNumber,
            documentDate = LocalDate.now(),
            status = null,

            branchId = letterFromBank.branchId,
            branchName = branchName,
            customerId = letterFromBank.customerId,
            customerName = customerName,
            letterFromBankId = letterFromBank.id!!,
            isFavorites = false,
            isHasAttach = answerWithAttachments && letterFromBank.isHasAttach ?: false,
            docType = null,
            docTypeDescription = null,
            contactName = user.getFio(),
            contactPhone = contactPhone,
            docText = docText,
            docTheme = "RE: ${letterFromBank.docTheme}",
            attachments = attachments
        )
    }

    @Step("Создать ${DocumentNames.LETTER_TO_BANK} доступное пользователю {user.login}")
    fun createLetterToBankAvailableToUser(
        user: User,
        creatorClientUser: User = Users.client,
        dtoForCreate: LetterToBankDto = getLetterToBankDtoForCreate(creatorClientUser, retrieveBankUser(user))
    ): LetterToBankDto {
        return if (user.isClient) createLetterToBankDto(user, dtoForCreate)
        else createSentLetterToBank(creatorClientUser, user, dtoForCreate)
    }

    @Step("Создать ${DocumentNames.LETTER_TO_BANK} для организации, доступной пользователям {creatorClientUser.login}, {receiverBankUser.login}")
    fun createLetterToBankDto(
        creatorClientUser: User = Users.client,
        receiverBankUser: User = Users.bankOperator
    ): LetterToBankDto {
        val dtoForCreate = getLetterToBankDtoForCreate(creatorClientUser, receiverBankUser)
        return createLetterToBankDto(creatorClientUser, dtoForCreate)
    }

    fun createLetterToBankDto(
        creatorClientUser: User = Users.client,
        dtoForCreate: LetterToBankDto
    ): LetterToBankDto {
        return LetterToBankSteps(creatorClientUser).create(dtoForCreate).data.getOrException()
    }


    //region CreateInStatus
    @Step("Создать ${DocumentNames.LETTER_TO_BANK} в статусе '{status}' для пользователей {creatorClientUser.login}, {receiverBankUser.login}")
    fun createLetterToBankInStatus(
        creatorClientUser: User = Users.client,
        receiverBankUser: User = Users.bankOperator,
        status: LetterToBankStatus,
        dtoForCreate: LetterToBankDto = getLetterToBankDtoForCreate(creatorClientUser, receiverBankUser)
    ): LetterToBankDto {
        return when (status) {
            DRAFT -> createDraftLetterToBank(creatorClientUser, receiverBankUser, dtoForCreate)
            NEW -> createNewLetterToBank(creatorClientUser, receiverBankUser, dtoForCreate)
            SIGNED -> createSignedLetterToBank(creatorClientUser, receiverBankUser, dtoForCreate)
            RECEIVED -> createReceivedLetterToBank(creatorClientUser, receiverBankUser, dtoForCreate)
            IN_PROCESSING -> createInProcessingLetterToBank(creatorClientUser, receiverBankUser, dtoForCreate)
            PROCESSED -> createProcessedLetterToBank(creatorClientUser, receiverBankUser, dtoForCreate)
            RECALLED -> createRecalledLetterToBank(creatorClientUser, receiverBankUser, dtoForCreate)

            // Dirty methods (making changes to values in database tables directly!)
            WRONG_ESIGNATURE -> createIncorrectDigestLetterToBank_DIRTY(creatorClientUser, receiverBankUser, dtoForCreate)
            DETAILS_ERROR -> createDetailsErrorLetterToBank_DIRTY(creatorClientUser, receiverBankUser, dtoForCreate)

            DELIVERED, FOR_RECEIVING, RECEIVING_ERROR ->
                fakeLetterToBankInStatus_DIRTY(creatorClientUser, receiverBankUser, dtoForCreate, status)
            // DELETED, <new statuses>
            else -> throw RuntimeException("Unexpected status for LetterToBank creation: $status")
        }
    }

    @Step("Подделать ${DocumentNames.LETTER_TO_BANK} в статусе '{status}'")
    private fun fakeLetterToBankInStatus_DIRTY(
        creatorClientUser: User = Users.client,
        receiverBankUser: User = Users.bankOperator,
        dtoForCreate: LetterToBankDto = getLetterToBankDtoForCreate(creatorClientUser, receiverBankUser),
        status: LetterToBankStatus
    ): LetterToBankDto {
        dtoForCreate.docText = "(AT. Fake $status Letter) ${dtoForCreate.docText}"
        if (status !in LetterToBankStatus.values.bankAvailableStatuses())
            throw RuntimeException("This method isn't supposed to be used for client-only available statuses!")

        // if LTB should be available to bank users, then it'd be better if the document is signed
        val signedLTB = createSignedLetterToBank(creatorClientUser, receiverBankUser, dtoForCreate)
        changeLetterToBankStatus_DIRTY(signedLTB.id!!, status)

        // Every <status>.statusBank is different, but there are some statuses with same [statusClient]
        // Thus, it is [statusBank] that should be checked, not [statusClient]
        val fakeLTB = LetterToBankSteps(receiverBankUser).getById(signedLTB.id!!)
            .data.getOrException(ERROR_MSG_BANK_GET_BY_ID)
        fakeLTB.id.assertEq(signedLTB.id)
        docChecks.checkDocumentStatus(fakeLTB, listOf(status.statusBank))

        return fakeLTB
    }

    @Step("Создать черновик ${DocumentNames.LETTER_TO_BANK}")
    fun createDraftLetterToBank(
        creatorClientUser: User = Users.client,
        receiverBankUser: User = Users.bankOperator,
        dtoForCreate: LetterToBankDto = getLetterToBankDtoForCreate(creatorClientUser, receiverBankUser)
    ): LetterToBankDto {
        val draftLtb = LetterToBankSteps(creatorClientUser).createWithoutCheck(dtoForCreate).data.getOrException()

        draftLtb.id.assertIsNotEmpty()
        docChecks.checkDocumentStatus(draftLtb, listOf(DRAFT.statusClient))
        return draftLtb
    }

    @Step("Создать новый ${DocumentNames.LETTER_TO_BANK}")
    fun createNewLetterToBank(
        creatorClientUser: User = Users.client,
        receiverBankUser: User = Users.bankOperator,
        dtoForCreate: LetterToBankDto = getLetterToBankDtoForCreate(creatorClientUser, receiverBankUser)
    ): LetterToBankDto {
        val newLTB = LetterToBankSteps(creatorClientUser).create(dtoForCreate).data.getOrException()

        newLTB.id.assertIsNotEmpty()
        docChecks.checkDocumentStatus(newLTB, listOf(NEW.statusClient))
        return newLTB
    }

    @Step("Создать подписанный ${DocumentNames.LETTER_TO_BANK}")
    fun createSignedLetterToBank(
        creatorClientUser: User = Users.client,
        receiverBankUser: User = Users.bankOperator,
        dtoForCreate: LetterToBankDto = getLetterToBankDtoForCreate(creatorClientUser, receiverBankUser)
    ): LetterToBankDto {
        val newLTB = createNewLetterToBank(creatorClientUser, receiverBankUser, dtoForCreate)

        val steps = LetterToBankSteps(creatorClientUser)
        var signedLTB = steps.signDocumentBySms(newLTB).data.getOrException("Ошибка при подписании")
        signedLTB.id.assertEq(newLTB.id)
        signedLTB = steps.getById(signedLTB.id!!).data.getOrException(ERROR_MSG_CLIENT_GET_BY_ID)
        docChecks.checkDocumentStatus(signedLTB, listOf(SIGNED.statusClient))
        return signedLTB
    }

    //TODO [Sergeyev]: CommonLetterToBank with clientDto/bankDto
    /**
     * @param creatorClientUser - user, who creates LetterToBank
     * @param receiverBankUser - user, who receives/processes LetterToBank
     * @param dtoForCreate - LetterToBank DTO, that's going to be created
     * @param returnBankDto - boolean flag; indicates what 'version' of LTB will be returned: client/bank.
     *              NB: Bank-version has more filled fields
     *
     * (!) WARNING (!)
     * returned LTB most likely will be in DELIVERED status, especially client-version,
     * but when it's a bank-version its status may be any of:
     * [DELIVERED, DETAILS_ERROR, WRONG_E_SIGNATURE, CORRECT_E_SIGNATURE, RECEIVED].
     *
     * @return sent LetterToBank
     */
    @Step("Создать отправленный ${DocumentNames.LETTER_TO_BANK}")
    fun createSentLetterToBank(
        creatorClientUser: User = Users.client,
        receiverBankUser: User = Users.bankOperator,
        dtoForCreate: LetterToBankDto = getLetterToBankDtoForCreate(creatorClientUser, receiverBankUser),
        returnBankDto: Boolean = true
    ): LetterToBankDto {
        val signedLTB = createSignedLetterToBank(creatorClientUser, receiverBankUser, dtoForCreate)

        val deliveredLTB = LetterToBankSteps(creatorClientUser).send(signedLTB.id!!).data.getOrException(ERROR_MSG_SENDING_TO_BANK)
        deliveredLTB.id.assertEq(signedLTB.id)
        docChecks.checkDocumentStatus(deliveredLTB, listOf(DELIVERED, RECEIVED).map { it.statusClient })

        return if (!returnBankDto) deliveredLTB
        else LetterToBankSteps(receiverBankUser).getById(deliveredLTB.id!!).data.getOrException(ERROR_MSG_BANK_GET_BY_ID)
    }

    /**
     * Mostly the same method as [createSentLetterToBank] above,
     * but this one will always result in a WRONG_E_SIGNATURE LetterToBank
     */
    @Step("Создать отправленный ошибочный ${DocumentNames.LETTER_TO_BANK} (некорректный дайджест)")
    fun createIncorrectDigestLetterToBank_DIRTY(
        creatorClientUser: User = Users.client,
        receiverBankUser: User = Users.bankOperator,
        dtoForCreate: LetterToBankDto = getLetterToBankDtoForCreate(creatorClientUser, receiverBankUser),
        returnBankDto: Boolean = true
    ): LetterToBankDto {
        val signedLtb = createSignedLetterToBank(creatorClientUser, receiverBankUser, dtoForCreate)
        val changedLtb = makeDigestIncorrect_DIRTY(signedLtb)

        val clientUserSteps = LetterToBankSteps(creatorClientUser)
        val sentLtb = clientUserSteps.send(changedLtb.id!!).data.getOrException(ERROR_MSG_SENDING_TO_BANK)
        sentLtb.id.assertEq(changedLtb.id)
        val incorrectESignatureLtb = docChecks.repeatableCheckDocumentLifecycleTransition(
            getActResultFunc = { clientUserSteps.getById(sentLtb.id!!).data.getOrException(ERROR_MSG_CLIENT_GET_BY_ID) },
            preparedDto = sentLtb,
            expStatuses = listOf(WRONG_ESIGNATURE.statusClient),
            additionalHandling = { prepDto, _ -> removeAttachmentsTokens(prepDto) }
        )

        return if (!returnBankDto) incorrectESignatureLtb
        else LetterToBankSteps(receiverBankUser).getById(incorrectESignatureLtb.id!!).data.getOrException(ERROR_MSG_BANK_GET_BY_ID)
    }

    /**
     * Mostly the same method as [createSentLetterToBank] above,
     * but this one will always result in a WRONG_E_SIGNATURE LetterToBank
     */
    @Step("Создать отправленный ошибочный ${DocumentNames.LETTER_TO_BANK} (изменённая подпись)")
    fun createWrongESignatureLetterToBank_DIRTY(
        creatorClientUser: User = Users.client,
        receiverBankUser: User = Users.bankOperator,
        dtoForCreate: LetterToBankDto = getLetterToBankDtoForCreate(creatorClientUser, receiverBankUser),
        returnBankDto: Boolean = true
    ): LetterToBankDto {
        val signedLtb = createSignedLetterToBank(creatorClientUser, receiverBankUser, dtoForCreate)
        val changedLtb = makeSignatureCorrupt_DIRTY(signedLtb)

        val clientUserSteps = LetterToBankSteps(creatorClientUser)
        val sentLtb = clientUserSteps.send(changedLtb.id!!).data.getOrException(ERROR_MSG_SENDING_TO_BANK)
        sentLtb.id.assertEq(changedLtb.id)
        val corruptESignatureLtb = docChecks.repeatableCheckDocumentLifecycleTransition(
            getActResultFunc = { clientUserSteps.getById(sentLtb.id!!).data.getOrException(ERROR_MSG_CLIENT_GET_BY_ID) },
            preparedDto = sentLtb,
            expStatuses = listOf(WRONG_ESIGNATURE.statusClient),
            additionalHandling = { prepDto, _ -> removeAttachmentsTokens(prepDto) }
        )

        return if (!returnBankDto) corruptESignatureLtb
        else LetterToBankSteps(receiverBankUser).getById(corruptESignatureLtb.id!!).data.getOrException(ERROR_MSG_BANK_GET_BY_ID)
    }

    /**
     * Mostly the same method as [createSentLetterToBank] above,
     * but this one will always result in a DETAILS_ERROR LetterToBank
     */
    @Step("Создать отправленный ошибочный ${DocumentNames.LETTER_TO_BANK} (данные)")
    fun createDetailsErrorLetterToBank_DIRTY(
        creatorClientUser: User = Users.client,
        receiverBankUser: User = Users.bankOperator,
        dtoForCreate: LetterToBankDto = getLetterToBankDtoForCreate(creatorClientUser, receiverBankUser),
        returnBankDto: Boolean = true
    ): LetterToBankDto {
        val signedLtb = createSignedLetterToBank(creatorClientUser, receiverBankUser, dtoForCreate)
        val changedLtb = makeDetailsWrong_DIRTY(signedLtb)

        val clientUserSteps = LetterToBankSteps(creatorClientUser)
        val sentLtb = clientUserSteps.send(changedLtb.id!!).data.getOrException(ERROR_MSG_SENDING_TO_BANK)
        sentLtb.id.assertEq(changedLtb.id)
        val detailsErrorLtb = docChecks.repeatableCheckDocumentLifecycleTransition(
            getActResultFunc = { clientUserSteps.getById(sentLtb.id!!).data.getOrException(ERROR_MSG_CLIENT_GET_BY_ID) },
            preparedDto = sentLtb,
            expStatuses = listOf(DETAILS_ERROR.statusClient),
            additionalHandling = { prepDto, _ -> removeAttachmentsTokens(prepDto) }
        )

        return if (!returnBankDto) detailsErrorLtb
        else LetterToBankSteps(receiverBankUser).getById(detailsErrorLtb.id!!).data.getOrException(ERROR_MSG_BANK_GET_BY_ID)
    }

    /**
     * @param creatorClientUser - user, who creates LetterToBank
     * @param receiverBankUser - user, who receives/processes LetterToBank
     * @param dtoForCreate - LetterToBank DTO, that's going to be created
     *
     * @return received LetterToBank, bank version (has more filled fields)
     */
    @Step("Создать полученный ${DocumentNames.LETTER_TO_BANK}")
    fun createReceivedLetterToBank(
        creatorClientUser: User = Users.client,
        receiverBankUser: User = Users.bankOperator,
        dtoForCreate: LetterToBankDto = getLetterToBankDtoForCreate(creatorClientUser, receiverBankUser)
    ): LetterToBankDto {
        val sentLTB = createSentLetterToBank(creatorClientUser, receiverBankUser, dtoForCreate)

        val bankUserSteps = LetterToBankSteps(receiverBankUser)
        val receivedLTBBank = docChecks.repeatableCheckDocumentLifecycleTransition(
            getActResultFunc = { bankUserSteps.getById(sentLTB.id!!).data.getOrException(ERROR_MSG_BANK_GET_BY_ID) },
            preparedDto = sentLTB,
            expStatuses = listOf(RECEIVED.statusBank),
            additionalHandling = { prepDto, _ -> removeAttachmentsTokens(prepDto) }
        )
        return receivedLTBBank
    }

    /**
     * @param creatorClientUser - user, who creates LetterToBank
     * @param receiverBankUser - user, who receives/processes LetterToBank
     * @param dtoForCreate - LetterToBank DTO, that's going to be created
     *
     * @return LetterToBank-in-processing, bank version (has more filled fields)
     */
    @Step("Создать ${DocumentNames.LETTER_TO_BANK}, взятый в работу")
    fun createInProcessingLetterToBank(
        creatorClientUser: User = Users.client,
        receiverBankUser: User = Users.bankOperator,
        dtoForCreate: LetterToBankDto = getLetterToBankDtoForCreate(creatorClientUser, receiverBankUser)
    ): LetterToBankDto {
        val receivedLTBBank = createReceivedLetterToBank(creatorClientUser, receiverBankUser, dtoForCreate)

        val bankUserSteps = LetterToBankSteps(receiverBankUser)
        val processingResponse =
            bankUserSteps.startProcessing(listOf(receivedLTBBank.id!!)).documentResults.getOrException("Ошибка при взятии документа в работу")
        val inProcessingLTBBank = processingResponse[0].dto.getOrException("Ошибка при получении документа из списка взятых в обработку")
        docChecks.checkDocumentLifecycleTransition(
            expDocumentDto = receivedLTBBank,
            actResult = inProcessingLTBBank,
            expStatuses = listOf(IN_PROCESSING.statusBank),
            additionalHandling = { prepDto, _ -> removeAttachmentsTokens(prepDto) }
        )
        return bankUserSteps.getById(inProcessingLTBBank.id!!).data.getOrException(ERROR_MSG_BANK_GET_BY_ID)
    }

    /**
     * @param creatorClientUser - user, who creates LetterToBank
     * @param receiverBankUser - user, who receives/processes LetterToBank
     * @param dtoForCreate - LetterToBank DTO, that's going to be created
     *
     * @return processed LetterToBank, bank version (has more filled fields)
     */
    @Step("Создать успешно обработанный ${DocumentNames.LETTER_TO_BANK}")
    fun createProcessedLetterToBank(
        creatorClientUser: User = Users.client,
        receiverBankUser: User = Users.bankOperator,
        dtoForCreate: LetterToBankDto = getLetterToBankDtoForCreate(creatorClientUser, receiverBankUser)
    ): LetterToBankDto {
        val inProcessingLTBBank = createInProcessingLetterToBank(creatorClientUser, receiverBankUser, dtoForCreate)

        val bankUserSteps = LetterToBankSteps(receiverBankUser)
        val processResponse = bankUserSteps.batchProcess(listOf(inProcessingLTBBank.id!!))
            .documentResults.getOrException("Ошибка при групповой обработке одного документа")
        val processedLTBBank = processResponse[0].dto.getOrException("Ошибка при получении документа из списка обработанных")
        docChecks.checkDocumentLifecycleTransition(
            expDocumentDto = inProcessingLTBBank,
            actResult = processedLTBBank,
            expStatuses = listOf(PROCESSED.statusBank),
            additionalHandling = { prepDto, _ -> removeAttachmentsTokens(prepDto) }
        )
        return processedLTBBank
    }

    /**
     * @param creatorClientUser - user, who creates LetterToBank
     * @param receiverBankUser - user, who receives/processes LetterToBank
     * @param dtoForCreate - LetterToBank DTO, that's going to be created
     *
     * @return recalled LetterToBank, bank version (has more filled fields)
     */
    @Step("Создать отозванный ${DocumentNames.LETTER_TO_BANK}")
    fun createRecalledLetterToBank(
        creatorClientUser: User = Users.client,
        receiverBankUser: User = Users.bankOperator,
        dtoForCreate: LetterToBankDto = getLetterToBankDtoForCreate(creatorClientUser, receiverBankUser)
    ): LetterToBankDto {
        val inProcessingLtbBank = createInProcessingLetterToBank(creatorClientUser, receiverBankUser, dtoForCreate)

        val bankUserSteps = LetterToBankSteps(receiverBankUser)
        val recallResponse =
            bankUserSteps.batchRecall(listOf(inProcessingLtbBank.id!!))
                .documentResults.getOrException("Ошибка при групповом отзыве одного документа")
        val recalledLtbBank = recallResponse[0].dto.getOrException("Ошибка при получении документа из списка отозванных")
        docChecks.checkDocumentLifecycleTransition(
            expDocumentDto = inProcessingLtbBank,
            actResult = recalledLtbBank,
            expStatuses = listOf(RECALLED.statusBank),
            additionalHandling = { prepDto, _ -> removeAttachmentsTokens(prepDto) }
        )
        return recalledLtbBank
    }
    //endregion

    //region Support methods
    /** Null all attachments' [accessToken]s from LetterToBank for proper DTO comparison */
    val removeAttachmentsTokens: (letterToBank: LetterToBankDto) -> LetterToBankDto = { ltb ->
        ltb.apply { attachments.nullAccessTokens() }
    }

    private fun getLtbSignaturesFromDB(letterId: UUID): List<SignatureDto> {
        val sqlRequest = "SELECT * from letter_to_bank_signatures WHERE id_document = '$letterId'"
        val data = Services.LETTER.db.execSql(sqlRequest)
            .map { SerializationUtils.OBJECT_MAPPER.convertValue(it, Signature::class.java) }
            .map { it.toDto() }
        return data
    }

    @Step("Испортить подпись, не затронув её структуру")
    fun makeSignatureCorrupt_DIRTY(document: LetterToBankDto, signatureId: UUID? = null): LetterToBankDto {
        val docSignatures = getLtbSignaturesFromDB(document.id!!)
        if (docSignatures.isEmpty()) throw RuntimeException(ERROR_MSG_DOC_IS_NOT_SIGNED)

        // shuffle signature's hash
        val signatureDto = signatureId
            ?.let { signToCorruptId -> docSignatures.first { signToCorruptId == it.id } }
            ?: docSignatures.first()
        val signatureDecoded = String(decodeBase64(signatureDto.signature))
        val signatureParsed: MutableMap<String, String> = signatureDecoded.deserialize()
        signatureParsed["hash"] = signatureParsed["hash"]!!.toList().shuffled().joinToString(separator = "")
        val corruptedSignatureEncoded = encodeBase64String(signatureParsed.serialize().toByteArray())

        // corrupt signature
        val sqlRequest = "UPDATE letter_to_bank_signatures" +
                " SET signature = '$corruptedSignatureEncoded'" +
                " WHERE id = '${signatureDto.id!!}'"
        Services.LETTER.db.execute(sqlRequest)

        return document
    }

    @Step("Изменить данные документа, чтобы дайджест при проверке был признан некорректным")
    fun makeDigestIncorrect_DIRTY(document: LetterToBankDto): LetterToBankDto {
        if (getLtbSignaturesFromDB(document.id!!).isEmpty()) throw RuntimeException(ERROR_MSG_DOC_IS_NOT_SIGNED)

        // change docField that stored in digest
        val updatedDocText = "[Corrupting the digest] ${document.docText!!}"
        val sqlRequest = "UPDATE letter_to_bank" +
                " SET doc_text = '$updatedDocText'" +
                " WHERE id = '${document.id!!}'"
        Services.LETTER.db.execute(sqlRequest)

        // return changed DTO
        document.docText = updatedDocText
        return document
    }

    @Step("Испортить данные Письма, не затронув подписанные данные")
    fun makeDetailsWrong_DIRTY(document: LetterToBankDto): LetterToBankDto {
        if (getLtbSignaturesFromDB(document.id!!).isEmpty()) throw RuntimeException(ERROR_MSG_DOC_IS_NOT_SIGNED)

        // empty important unsigned fields
        val sqlRequest = "UPDATE letter_to_bank" +
                " SET customer_name = null, branch_name = null" +
                " WHERE id = '${document.id!!}'"
        Services.LETTER.db.execute(sqlRequest)

        // return changed DTO
        document.customerName = null
        document.branchName = null
        return document
    }

    @Step("Изменить статус Письма через БД: '{status}'")
    private fun changeLetterToBankStatus_DIRTY(letterId: UUID, status: LetterToBankStatus) {
        val sqlRequest = "UPDATE letter_to_bank" +
                " SET client_status = '${status.statusClient}', bank_status = '${status.statusBank}', status = '${status.statusBank}'" +
                " WHERE id = '${letterId}'"
        Services.LETTER.db.execute(sqlRequest)
    }
    //endregion
}