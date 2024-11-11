package ooo.jtc.api.news.publication

import io.qameta.allure.Step
import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.common.checks.ApiDocumentChecks
import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.api.dictionaries.branch.BranchPrepareSteps
import ooo.jtc.api.dictionaries.branch.BranchSteps
import ooo.jtc.api.dictionaries.customer.CustomerSteps
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.extensions.asserts.assertIsNotEmpty
import ooo.jtc.extensions.getOrException
import ooo.jtc.extensions.ifNotEmpty
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.interfaces.nullAccessTokens
import ooo.jtc.news.PublicationStatus
import ooo.jtc.news.PublicationStatus.AUTO_FINISHED
import ooo.jtc.news.PublicationStatus.AUTO_FINISH_ERROR
import ooo.jtc.news.PublicationStatus.AUTO_POSTED
import ooo.jtc.news.PublicationStatus.AUTO_POST_ERROR
import ooo.jtc.news.PublicationStatus.DRAFT
import ooo.jtc.news.PublicationStatus.MANUALLY_FINISHED
import ooo.jtc.news.PublicationStatus.MANUALLY_POSTED
import ooo.jtc.news.PublicationStatus.NEW
import ooo.jtc.news.PublicationStatus.WAITING_FOR_AUTO_POST
import ooo.jtc.news.dto.NewsAttachmentDto
import ooo.jtc.news.dto.PublicationDto
import ooo.jtc.news.dto.PublicationMailingChannel
import ooo.jtc.news.dto.PublicationTargetType
import ooo.jtc.news.dto.PublicationType
import ooo.jtc.news.dto.ReceiverCustomerDto
import ooo.jtc.news.dto.toNewsAttachmentDto
import ooo.jtc.news.dto.toReceiverCustomer
import ooo.jtc.random.RandomData
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.RandomData.Companion.regexWords
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.customer.CustomerFilterParams
import ooo.jtc.uaa.User
import kotlin.random.Random
import java.io.File
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.UUID

object PublicationPrepareSteps {

    private val docChecks by lazy { ApiDocumentChecks<PublicationDto>() }
    private val superUser by lazy { Users.superUser }

    /** Retrieve (Publication) client user. */
    fun retrieveClientUser(user: User): User =
        if (user.isClient) user else Users.client

    /** Retrieve (Publication) bank user. */
    fun retrieveBankUser(user: User): User =
        if (user.isBank) user else Users.bankOperator


    @Step("Найти или создать документ '${DocumentNames.PUBLICATION}', доступный пользователю {searchingUser.login}")
    fun getOrCreatePublicationDto(
        searchingUser: User,
        creatorBankUser: User = retrieveBankUser(searchingUser),
        getPageRequest: () -> GetPageRequest = { GetPageRequest() },
        additionalFilter: (PublicationDto) -> Boolean = { true },
        createDocFunc: () -> PublicationDto = { createPublicationAvailableToUser(searchingUser, creatorBankUser) }
    ): PublicationDto {
        val steps = PublicationSteps(searchingUser)
        val existingAvailableDocs = steps
            .getPage(getPageRequest = getPageRequest.invoke())
            .page?.filter(additionalFilter)

        val docToReturn: PublicationDto = if (!existingAvailableDocs.isNullOrEmpty()) {
            steps.getById(existingAvailableDocs.random().id!!).data.getOrException()
        } else {
            createDocFunc.invoke()
        }

        return docToReturn.attachToAllure()
    }

    @Step(
        "Найти набор разных документов '${DocumentNames.PUBLICATION}' или создать их необходимое количество," +
                " доступное пользователю {searchingUser.login}"
    )
    fun getOrCreateDifferentPublicationDtoList(
        searchingUser: User,
        creatorBankUser: User = retrieveBankUser(searchingUser),
        getPageRequest: () -> GetPageRequest = { GetPageRequest() },
        additionalFilter: (PublicationDto) -> Boolean = { true },
        createDocFunc: () -> PublicationDto = { createPublicationAvailableToUser(searchingUser, creatorBankUser) },
        amount: Long = REQUIRED_DATA_COUNT
    ): List<PublicationDto> {
        val resultDocsList: MutableList<PublicationDto> = mutableListOf()

        val existingAvailableDocs = PublicationSteps(searchingUser)
            .getPage(getPageRequest = getPageRequest.invoke())
            .page?.filter(additionalFilter)

        existingAvailableDocs?.let { resultDocsList.addAll(it.take(amount.toInt())) }
        while (resultDocsList.size < amount) {
            val newDocument = createDocFunc.invoke()
            resultDocsList.add(newDocument)
        }

        return resultDocsList.attachToAllure()
    }

    /**
     * Method for preparing [PublicationTargetType.GENERAL] publication.
     * For all branches and thus - all customers ([isForAllBranches] = [true])
     * N.B.: creating user must be a 'superuser'
     *
     * @param relatedBankUser       bank (super-)user, who can create this publication and will have access to it afterwards
     * @param attachments           list of attachments for publication
     */
    fun getGlobalGeneralPublicationDtoForCreate(
        relatedBankUser: User,
        attachments: List<File> = emptyList()
    ): PublicationDto {
        var preparedDto = getPublicationDtoForCreate(
            isForAllBranches = true,
            targetType = PublicationTargetType.GENERAL
        )
        attachments.ifNotEmpty { preparedDto = addAttachmentsToDto(preparedDto, relatedBankUser, it) }
        return preparedDto
    }

    /**
     * Method for preparing [PublicationTargetType.GENERAL] publication.
     * For a single branch and thus - all related to the branch customers ([isForAllBranches] = [false])
     *
     * (!) WARNING (!)
     * Possible changes to branch/customer/branchCustomer dictionaries
     *
     * @param relatedBankUser       bank (operator) user, who can create this publication and will have access to it afterwards
     * @param branchId              branch, available to [relatedBankUser]. If not specified, or not available to provided
     * user - publication will be created for random available branch. [null] by default
     * @param attachments           list of attachments for publication
     */
    fun getGeneralPublicationDtoForCreate(
        relatedBankUser: User,
        branchId: UUID? = null,
        attachments: List<File> = emptyList()
    ): PublicationDto {
        var branch = branchId
            ?.let { BranchSteps(relatedBankUser).getById(branchId, withCheckResponseCode = false).data }

        if (null == branch) {
            val availableBranches = BranchData.searchBy(relatedBankUser)

            branch = if (availableBranches.isNotEmpty()) availableBranches.random().toDto()
            else BranchPrepareSteps.createBranchWithBranchRepresentative(relatedBankUser)
        }

        var preparedDto = getPublicationDtoForCreate(
            branchId = branch.id,
            branchName = branch.shortName,
            isForAllBranches = false,
            targetType = PublicationTargetType.GENERAL
        )
        attachments.ifNotEmpty { preparedDto = addAttachmentsToDto(preparedDto, relatedBankUser, it) }
        return preparedDto
    }

    /**
     * Method for preparing [PublicationTargetType.GENERAL] publication.
     * For a single branch, available to both provided users
     *
     * (!) WARNING (!)
     * Possible changes to branch/customer/branchCustomer dictionaries
     *
     * @param relatedBankUser       bank (operator) user, who can create this publication and will have access to it afterwards
     * @param receiverClientUser    customer user, who will have access to this publication
     * @param attachments           list of attachments for publication
     */
    fun getGeneralPublicationDtoForCreate(
        relatedBankUser: User,
        receiverClientUser: User,
        attachments: List<File> = emptyList()
    ): PublicationDto {
        val branchCustomer = BranchCustomerData.getOrCreateCommonBranchCustomer(clientUser = receiverClientUser, bankUser = relatedBankUser)
        val branch = BranchSteps(superUser).getById(branchCustomer.branchId).data.getOrException()

        var preparedDto = getPublicationDtoForCreate(
            branchId = branch.id,
            branchName = branch.shortName,
            isForAllBranches = false,
            targetType = PublicationTargetType.GENERAL
        )
        attachments.ifNotEmpty { preparedDto = addAttachmentsToDto(preparedDto, relatedBankUser, it) }
        return preparedDto
    }

    /**
     * Method for preparing [PublicationTargetType.DIRECT] publication.
     * For any single customer, available to both provided users.
     *
     * (!) WARNING (!)
     * Possible changes to branch/customer/branchCustomer dictionaries
     *
     * @param relatedBankUser       bank (operator) user, who can create this publication and will have access to it afterwards
     * @param receiverClientUser    customer user, who will have access to this publication
     * @param attachments           list of attachments for publication
     */
    fun getClientSpecificPublicationDtoForCreate(
        relatedBankUser: User,
        receiverClientUser: User = Users.client,
        attachments: List<File> = emptyList()
    ): PublicationDto {
        val branchCustomer = BranchCustomerData.getOrCreateCommonBranchCustomer(clientUser = receiverClientUser, bankUser = relatedBankUser)
        val branch = BranchSteps(superUser).getById(branchCustomer.branchId).data.getOrException()
        val preparedDto = getPublicationDtoForCreate(
            branchId = branch.id!!,
            branchName = branch.shortName,
            isForAllBranches = false,
            targetType = PublicationTargetType.DIRECT
        )
        val customer = CustomerSteps(superUser).getById(branchCustomer.customerId).data.getOrException()
        preparedDto.customers = listOf(customer.toReceiverCustomer())
        preparedDto.totalReceiverCustomers = 1 // preparedDto.customers.size

        attachments.ifNotEmpty { addAttachmentsToDto(preparedDto, relatedBankUser, it) }
        return preparedDto
    }

    /**
     * Method for preparing [PublicationTargetType.DIRECT] publication.
     * For specified non-empty list (1+) customers, available to both users AND linked to
     * at least one common branch, available for provided [relatedBankUser]
     *
     * @param relatedBankUser       bank (operator) user, who can create this publication and will have access to it afterwards
     * @param customerIds           non-empty list of targeted customers.
     * All users, related to these customers will have access to this publication. Customers must be
     * - available to both provided users
     * - linked to at least one common branch
     * @param attachments           list of attachments for publication
     */
    fun getClientSpecificPublicationDtoForCreate(
        relatedBankUser: User,
        customerIds: List<UUID>,
        attachments: List<File> = emptyList()
    ): PublicationDto {
        if (customerIds.isEmpty())
            throw RuntimeException("Provided list of customerIds is empty!")

        // get all branches available to relatedBankUser
        val availableBranchesIds = BranchData.searchBy(relatedBankUser)
            .map { it.id!! }
            .toMutableSet()
        // remove branches, that aren't related to provided customers
        customerIds.forEach { customerId ->
            val branchesRelatedToCustomer = BranchCustomerData.searchByCustomersIds(customerId).map { it.branchId }
            availableBranchesIds.removeIf { !branchesRelatedToCustomer.contains(it) }
        }
        // take single random branch id
        val commonBranchId = availableBranchesIds.random()
        val branch = BranchSteps(superUser).getById(commonBranchId).data.getOrException()
        val preparedDto = getPublicationDtoForCreate(
            branchId = branch.id!!,
            branchName = branch.shortName,
            isForAllBranches = false,
            targetType = PublicationTargetType.DIRECT
        )

        // prepare filter for CustomerSteps
        val customerIdsFilter = IFilterParams.and(
            *(customerIds.map { { CustomerFilterParams.ID.eq(it) } }).toTypedArray()
        )
        // get all Customers in one request
        val receiverCustomers = CustomerSteps(superUser).getPageAll(customerIdsFilter.toPageRequest())
            .page.getOrException()
            .map { it.toReceiverCustomer() }
        preparedDto.customers = receiverCustomers
        preparedDto.totalReceiverCustomers = receiverCustomers.size

        attachments.ifNotEmpty { addAttachmentsToDto(preparedDto, relatedBankUser, it) }
        return preparedDto
    }

    private fun getPublicationDtoForCreate(
        branchId: UUID? = null,
        branchName: String? = null,
        isForAllBranches: Boolean,
        targetType: PublicationTargetType
    ): PublicationDto {
        val publicationType = PublicationType.values().random()
        val documentNumber = digits.random(6, 6)
        return PublicationDto(
            id = null,
            version = 0,
            documentNumber = documentNumber,
            documentDate = LocalDate.now(),
            status = null,
            customerId = null,
            createdAt = null,
            description = "Description ${RandomData("[а-яА-Я ]*").random(100, 150)}$AT_POSTFIX",
            publicationType = publicationType.type,
            targetType = targetType.type,
            isMustKnow = Random.nextBoolean(),
            isImportant = Random.nextBoolean(),
            isFavorites = null,
            isForAllBranches = isForAllBranches,
            startAt = ZonedDateTime.now().plusMinutes(5).toInstant(),
            endAt = ZonedDateTime.now().plusYears(1).toInstant(),
            mailingChannel = PublicationMailingChannel.ALL,
            header = "Header $documentNumber$AT_POSTFIX",
            text = "Publication №$documentNumber text.\n ${regexWords.random(200, 250).trim()}$AT_POSTFIX",
            link = null,
            linkText = null,
            picture = null,
            branchId = branchId,
            branchName = branchName,
            isHasAttach = false,
            attachments = emptyList(),
            customers = emptyList(),
            mustKnows = emptyList(),
            totalMustKnows = 0,
            totalReceiverCustomers = 0
        )
    }

    fun getPublicationDtoForUpdate(pblDto: PublicationDto): PublicationDto {
        return pblDto.copy(
            header = "Upd. ${pblDto.header}",
            description = "Upd. ${pblDto.description}",
            text = "Updated ${pblDto.text}"
        )
    }

    @Step("Добавить вложения к DTO Публикации [{pblDto.id}]")
    fun addAttachmentsToDto(pblDto: PublicationDto, creatorUser: User, files: List<File>): PublicationDto {
        val uploadedFiles = files
            .map { AttachmentPrepareSteps.uploadFile(creatorUser, it) }
            .map { it.toNewsAttachmentDto("linkText_${it.fileName}") }
            .map { it.apply { documentId = pblDto.id } }
        val ltbAttachments = pblDto.attachments!!.toMutableList()
        ltbAttachments.addAll(uploadedFiles)

        return pblDto
            .apply { isHasAttach = true }
            .apply { attachments = ltbAttachments }
    }

    @Step("Создать документ '${DocumentNames.PUBLICATION}', доступный пользователям {creatorBankUser.login}, {receiverClientUser.login}")
    fun createPublicationDto(
        creatorBankUser: User = Users.bankOperator,
        receiverClientUser: User = Users.client,
        dtoForCreate: PublicationDto = getGeneralPublicationDtoForCreate(creatorBankUser, receiverClientUser)
    ): PublicationDto {
        return PublicationSteps(creatorBankUser).create(dtoForCreate).data.getOrException()
    }

    @Step("Создать документ '${DocumentNames.PUBLICATION}', доступный пользователю {user.login}")
    fun createPublicationAvailableToUser(
        user: User,
        creatorBankUser: User = retrieveBankUser(user),
        dtoForCreate: PublicationDto = getGeneralPublicationDtoForCreate(creatorBankUser, retrieveClientUser(user))
    ): PublicationDto {
        return if (user.isBank) createPublicationDto(creatorBankUser = user, dtoForCreate = dtoForCreate)
        else createManuallyPostedPublication(creatorBankUser = creatorBankUser, receiverClientUser = user, dtoForCreate)
    }

    //region CreateInStatus
    @Step("Создать документ '${DocumentNames.PUBLICATION}' в статусе '{status}' для пользователей {creatorBankUser.login}, {receiverClientUser.login}")
    fun createPublicationInStatus(
        creatorBankUser: User,
        receiverClientUser: User = Users.client,
        status: PublicationStatus,
        dtoForCreate: PublicationDto = getGeneralPublicationDtoForCreate(creatorBankUser, receiverClientUser)
    ): PublicationDto {
        return when (status) {
            DRAFT -> createDraftPublication(creatorBankUser, receiverClientUser, dtoForCreate)
            NEW -> createNewPublication(creatorBankUser, receiverClientUser, dtoForCreate)
            MANUALLY_POSTED -> createManuallyPostedPublication(creatorBankUser, receiverClientUser, dtoForCreate)
            WAITING_FOR_AUTO_POST -> createWaitingForAutoPostPublication(creatorBankUser, receiverClientUser, dtoForCreate)
            AUTO_POSTED -> createAutoPostedPublication(creatorBankUser, receiverClientUser, dtoForCreate)
            AUTO_FINISHED -> createAutoFinishedPublication(creatorBankUser, receiverClientUser, dtoForCreate)
            MANUALLY_FINISHED -> createManuallyFinishedPublication(creatorBankUser, receiverClientUser, dtoForCreate)
            AUTO_POST_ERROR -> createAutoPostErrorPublication_DIRTY(creatorBankUser, receiverClientUser, dtoForCreate)
            AUTO_FINISH_ERROR -> createAutoFinishErrorPublication_DIRTY(creatorBankUser, receiverClientUser, dtoForCreate)
            //<new statuses>
            else -> throw RuntimeException("Unexpected status for Publication creation: $status")
        }
    }

    @Step("Создать черновик документа '${DocumentNames.PUBLICATION}'")
    fun createDraftPublication(
        creatorBankUser: User,
        receiverClientUser: User,
        dtoForCreate: PublicationDto = getGeneralPublicationDtoForCreate(creatorBankUser, receiverClientUser)
    ): PublicationDto {
        val draftDoc = PublicationSteps(creatorBankUser).createWithoutCheck(dtoForCreate).data.getOrException()

        draftDoc.id.assertIsNotEmpty()
        docChecks.checkDocumentStatus(draftDoc, listOf(DRAFT.statusBank))
        return draftDoc
    }

    @Step("Создать новый документ '${DocumentNames.PUBLICATION}'")
    fun createNewPublication(
        creatorBankUser: User,
        receiverClientUser: User,
        dtoForCreate: PublicationDto = getGeneralPublicationDtoForCreate(creatorBankUser, receiverClientUser)
    ): PublicationDto {
        val newDoc = PublicationSteps(creatorBankUser).create(dtoForCreate).data.getOrException()

        newDoc.id.assertIsNotEmpty()
        docChecks.checkDocumentStatus(newDoc, listOf(NEW.statusBank))
        return newDoc
    }

    /**
     * For publication to be manually posted it must have [startAt] = [null]
     */
    @Step("Создать размещённый вручную документ '${DocumentNames.PUBLICATION}'")
    fun createManuallyPostedPublication(
        creatorBankUser: User,
        receiverClientUser: User,
        dtoForCreate: PublicationDto = getGeneralPublicationDtoForCreate(creatorBankUser, receiverClientUser).apply { startAt = null }
    ): PublicationDto {
        val newDoc = createNewPublication(creatorBankUser, receiverClientUser, dtoForCreate).getOrException()
        val manuallyPostedDoc = PublicationSteps(creatorBankUser).postSingle(newDoc.id!!)
        manuallyPostedDoc.id.assertIsNotEmpty()
        docChecks.checkDocumentStatus(manuallyPostedDoc, listOf(MANUALLY_POSTED.statusBank))
        return manuallyPostedDoc
    }

    /**
     * For publication to await for automatic posting it must have non-null [startAt] and its value must be greater that current time on server.
     *
     * Publication will be automatically posted in
     * @param seconds
     */
    @Step("Создать ожидающий автоматического размещения документ '${DocumentNames.PUBLICATION}'")
    fun createWaitingForAutoPostPublication(
        creatorBankUser: User,
        receiverClientUser: User,
        dtoForCreate: PublicationDto = getGeneralPublicationDtoForCreate(creatorBankUser, receiverClientUser),
        seconds: Long = 30
    ): PublicationDto {
        val startAt = ZonedDateTime.now().plusSeconds(seconds)
        dtoForCreate.startAt = startAt.toInstant()
        dtoForCreate.endAt = startAt.plusDays(1).toInstant()
        val newDoc = createNewPublication(creatorBankUser, receiverClientUser, dtoForCreate).getOrException()
        val waitingForAutoPost = PublicationSteps(creatorBankUser).postSingle(newDoc.id!!)
        waitingForAutoPost.id.assertIsNotEmpty()
        docChecks.checkDocumentStatus(waitingForAutoPost, listOf(WAITING_FOR_AUTO_POST.statusBank))
        return waitingForAutoPost
    }

    @Step("Создать автоматически размещённый документ '${DocumentNames.PUBLICATION}'")
    fun createAutoPostedPublication(
        creatorBankUser: User,
        receiverClientUser: User,
        dtoForCreate: PublicationDto =
            getGeneralPublicationDtoForCreate(creatorBankUser, receiverClientUser)
                .apply { startAt = ZonedDateTime.now().toInstant() }
    ): PublicationDto {
        val steps = PublicationSteps(creatorBankUser)
        val newDoc = createNewPublication(creatorBankUser, receiverClientUser, dtoForCreate).getOrException()
        var autoPostedDoc = steps.postSingle(newDoc.id!!)
        autoPostedDoc.id.assertIsNotEmpty()
        autoPostedDoc = docChecks.repeatableCheckDocumentLifecycleTransition(
            preparedDto = autoPostedDoc,
            getActResultFunc = { steps.getById(autoPostedDoc.id!!).data.getOrException() },
            expStatuses = listOf(AUTO_POSTED.statusBank)
        )
        return autoPostedDoc
    }

    /**
     * For publication to await for automatic posting it must have non-null [endAt] and its value must be equal or less that current time on server.
     *
     * After posting publication will be automatically finished in
     * @param seconds
     */
    @Step("Создать автоматически завершённый документ '${DocumentNames.PUBLICATION}'")
    fun createAutoFinishedPublication(
        creatorBankUser: User,
        receiverClientUser: User,
        dtoForCreate: PublicationDto =
            getGeneralPublicationDtoForCreate(creatorBankUser, receiverClientUser)
                .apply {
                    startAt = null
                    endAt = ZonedDateTime.now().plusSeconds(seconds).toInstant()
                },
        seconds: Long = 5
    ): PublicationDto {
        val steps = PublicationSteps(creatorBankUser)
        val manuallyPostedDoc = createManuallyPostedPublication(creatorBankUser, receiverClientUser, dtoForCreate).getOrException()
        Thread.sleep(1000 * seconds)
        val autoFinishedDoc = docChecks.repeatableCheckDocumentLifecycleTransition(
            preparedDto = manuallyPostedDoc,
            getActResultFunc = { steps.getById(manuallyPostedDoc.id!!).data.getOrException() },
            expStatuses = listOf(AUTO_FINISHED.statusBank)
        )
        return autoFinishedDoc
    }

    /**
     * For publication to have the possibility to be 'finished' manually it either:
     * - must have [endAt] = [null] and be successfully posted or
     * - be in status [AUTO_FINISH_ERROR]
     */
    @Step("Создать автоматически завершённый документ '${DocumentNames.PUBLICATION}'")
    fun createManuallyFinishedPublication(
        creatorBankUser: User,
        receiverClientUser: User,
        dtoForCreate: PublicationDto =
            getGeneralPublicationDtoForCreate(creatorBankUser, receiverClientUser)
                .apply {
                    startAt = null
                    endAt = null
                }
    ): PublicationDto {
        val manuallyPostedDoc = createManuallyPostedPublication(creatorBankUser, receiverClientUser, dtoForCreate).getOrException()
        val manuallyFinishedDoc = PublicationSteps(creatorBankUser).finishPostSingle(manuallyPostedDoc.id!!)
        manuallyFinishedDoc.id.assertIsNotEmpty()
        docChecks.checkDocumentStatus(manuallyFinishedDoc, listOf(MANUALLY_FINISHED.statusBank))
        return manuallyFinishedDoc
    }

    @Step("Создать размещённый с ошибкой документ '${DocumentNames.PUBLICATION}'")
    fun createAutoPostErrorPublication_DIRTY(
        creatorBankUser: User,
        receiverClientUser: User,
        dtoForCreate: PublicationDto = getGeneralPublicationDtoForCreate(creatorBankUser, receiverClientUser)
    ): PublicationDto {
        val waitingForAutoPostDoc = createWaitingForAutoPostPublication(creatorBankUser, receiverClientUser, dtoForCreate).getOrException()
        val dirtyAutoPostError = changePublicationStatus_DIRTY(waitingForAutoPostDoc, AUTO_POST_ERROR)

        return dirtyAutoPostError
    }

    @Step("Создать завершённый с ошибкой документ '${DocumentNames.PUBLICATION}'")
    fun createAutoFinishErrorPublication_DIRTY(
        creatorBankUser: User,
        receiverClientUser: User,
        dtoForCreate: PublicationDto = getGeneralPublicationDtoForCreate(creatorBankUser, receiverClientUser)
    ): PublicationDto {
        val waitingForAutoPostDoc = createWaitingForAutoPostPublication(creatorBankUser, receiverClientUser, dtoForCreate).getOrException()
        val dirtyAutoFinishError = changePublicationStatus_DIRTY(waitingForAutoPostDoc, AUTO_FINISH_ERROR)

        return dirtyAutoFinishError
    }
    //endregion

    //region Support methods
    /** Null all attachments' [accessToken]s from Publication for proper DTO comparison */
    val removeAttachmentsTokens: (publication: PublicationDto) -> PublicationDto = { pbl ->
        pbl.apply { attachments.nullAccessTokens() }
    }

    /** Prepare list of publication attachments for comparison */
    val prepareAttachmentsForComparison: (List<NewsAttachmentDto>) -> List<NewsAttachmentDto> = { attachList ->
        attachList
            .sortedBy { it.fileName }
            .map {
                it.apply {
                    accessToken = null
                    documentId = null
                    fileId = null
                    id = null
                }
            }
    }

    /** Prepare list of publication receiver customers for comparison */
    val prepareCustomersForComparison: (List<ReceiverCustomerDto>) -> List<ReceiverCustomerDto> = { customerList ->
        customerList
            .sortedBy { it.customerId }
            .map {
                it.apply {
                    documentId = null
                    id = null
                }
            }
    }

    @Step("Напрямую в БД изменить статус документа [{publDto.id}] на 'status'")
    private fun changePublicationStatus_DIRTY(publDto: PublicationDto, status: PublicationStatus): PublicationDto {
        val bankStatus = status.statusBank
        // change publication status in DB
        val sqlRequest = "UPDATE publication" +
                " SET status = '$bankStatus', bank_status = '$bankStatus', client_status = '${status.statusClient}'" +
                " WHERE id = '${publDto.id!!}'"
        Services.NEWS.db.execute(sqlRequest)

        // return changed DTO
        publDto.status = bankStatus
        return publDto
    }
    //endregion
}