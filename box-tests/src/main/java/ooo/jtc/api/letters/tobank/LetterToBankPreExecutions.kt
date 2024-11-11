package ooo.jtc.api.letters.tobank

import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.getOrCreateLetterToBankDto
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.retrieveClientUser
import ooo.jtc.api.letters.tobank.steps.LetterToBankSteps
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.core.kexensions.retrieveClientUser
import ooo.jtc.extensions.getOrException
import ooo.jtc.files.FileHelper
import ooo.jtc.generic.pageparams.and
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.interfaces.recentDocFilterData
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.letters.model.LetterToBankStatus.DELIVERED
import ooo.jtc.letters.model.LetterToBankStatus.DETAILS_ERROR
import ooo.jtc.letters.model.LetterToBankStatus.FOR_RECEIVING
import ooo.jtc.letters.model.LetterToBankStatus.NEW
import ooo.jtc.letters.model.LetterToBankStatus.PROCESSED
import ooo.jtc.letters.model.LetterToBankStatus.RECALLED
import ooo.jtc.letters.model.LetterToBankStatus.RECEIVED
import ooo.jtc.letters.model.LetterToBankStatus.RECEIVING_ERROR
import ooo.jtc.letters.model.LetterToBankStatus.SIGNED
import ooo.jtc.letters.model.LetterToBankStatus.WRONG_ESIGNATURE
import ooo.jtc.scripts.invoke
import ooo.jtc.scripts.step
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.ATTACH_FILE_NAME
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.CUSTOMER_ID
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.IS_HAS_ATTACH
import ooo.jtc.uaa.User
import java.util.*

/**
 * Short functions to get different preExecutions.
 */
object LetterToBankPreExecutions {

    val LTBPreExecutionDraft
        get() = { user: User ->
            getOrCreateLetterToBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(LetterToBankStatus.DRAFT.asFilterData(user)).toPageRequest() },
                createLtbFunc = {
                    val clientUser = retrieveClientUser(user)
                    LetterToBankPrepareSteps.createDraftLetterToBank(creatorClientUser = clientUser)
                }
            )
        }

    val LTBPreExecutionNew
        get() = { user: User ->
            getOrCreateLetterToBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(NEW.asFilterData(user)).toPageRequest() },
                createLtbFunc = {
                    val clientUser = retrieveClientUser(user)
                    LetterToBankPrepareSteps.createNewLetterToBank(creatorClientUser = clientUser)
                }
            )
        }

    val LTBPreExecutionSigned
        get() = { user: User ->
            getOrCreateLetterToBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(SIGNED.asFilterData(user)).toPageRequest() },
                createLtbFunc = {
                    val clientUser = retrieveClientUser(user)
                    LetterToBankPrepareSteps.createSignedLetterToBank(creatorClientUser = clientUser)
                }
            )
        }

    val LTBPreExecutionSelfSigned: (User) -> LetterToBankDto
        get() = { user: User ->
            val lTBSteps = LetterToBankSteps(user)
            val pageRequest = recentDocFilterData.and(SIGNED.asFilterData(user)).toPageRequest()

            val availableDocIds = lTBSteps.getPage(getPageRequest = pageRequest).page?.map { it.id!! }
            val applicableDocIds = availableDocIds?.let { lTBSteps.getSelfUnSignApplicability(*it.toTypedArray()).applicable }

            if (applicableDocIds.isNullOrEmpty()) {
                val clientUser = retrieveClientUser(user)
                LetterToBankPrepareSteps.createSignedLetterToBank(creatorClientUser = clientUser)
            } else {
                val id = applicableDocIds.random()
                lTBSteps.getById(id).data.getOrException()
            }
        }


    val LTBPreExecutionSelfSignedForCustomer: (User, UUID, Int) -> List<LetterToBankDto>
        get() = { user: User, customerId: UUID, count: Int ->
            "Получить список подписанных пользователем ${user.login} писем в банк в кол-ве: $count " step {
                val lTBSteps = LetterToBankSteps(user)
                val pageRequest = recentDocFilterData.and(SIGNED.asFilterData(user)).and(CUSTOMER_ID.eq(customerId)).toPageRequest()

                val availableDocIds = lTBSteps.getPage(getPageRequest = pageRequest).page?.map { it.id!! }
                val applicableDocIds = availableDocIds?.let { lTBSteps.getSelfUnSignApplicability(*it.toTypedArray()).applicable }

                val resultList = if (applicableDocIds.isNullOrEmpty() || applicableDocIds.size < count) {
                    val needToCreate = count - (applicableDocIds?.size ?: 0)
                    generateSequence {
                        LTBPreExecutionCreateSignedForCustomer(user, customerId)
                    }.asSequence().take(needToCreate).toList()
                } else {
                    val ids = applicableDocIds.take(count)
                    ids.map {
                        lTBSteps.getById(it).data.getOrException()
                    }
                }
                resultList
            }
        }

    val LTBPreExecutionCreateSignedForCustomer: (User, UUID) -> LetterToBankDto
        get() = { user: User, customerId: UUID ->
            val clientUser = retrieveClientUser(user)
            val dtoForCreate = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(customerId = customerId)
            LetterToBankPrepareSteps.createSignedLetterToBank(creatorClientUser = clientUser, dtoForCreate = dtoForCreate)
        }

    val LTBPreExecutionReceived
        get() = { user: User ->
            getOrCreateLetterToBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(RECEIVED.asFilterData(user)).toPageRequest() },
                createLtbFunc = {
                    val clientUser = retrieveClientUser(user)
                    LetterToBankPrepareSteps.createReceivedLetterToBank(creatorClientUser = clientUser)
                }
            )
        }

    val LTBPreExecutionDetailsError
        get() = { user: User ->
            getOrCreateLetterToBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(DETAILS_ERROR.asFilterData(user)).toPageRequest() },
                createLtbFunc = {
                    val clientUser = retrieveClientUser(user)
                    LetterToBankPrepareSteps.createDetailsErrorLetterToBank_DIRTY(creatorClientUser = clientUser)
                }
            )
        }

    val LTBPreExecutionWrongESignature
        get() = { user: User ->
            getOrCreateLetterToBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(WRONG_ESIGNATURE.asFilterData(user)).toPageRequest() },
                createLtbFunc = {
                    val clientUser = retrieveClientUser(user)
                    LetterToBankPrepareSteps.createWrongESignatureLetterToBank_DIRTY(creatorClientUser = clientUser)
                }
            )
        }

    val LTBPreExecutionRecalled
        get() = { user: User ->
            getOrCreateLetterToBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(RECALLED.asFilterData(user)).toPageRequest() },
                createLtbFunc = {
                    val clientUser = retrieveClientUser(user)
                    LetterToBankPrepareSteps.createRecalledLetterToBank(creatorClientUser = clientUser)
                }
            )
        }

    val LTBPreExecutionProcessed
        get() = { user: User ->
            getOrCreateLetterToBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(PROCESSED.asFilterData(user)).toPageRequest() },
                createLtbFunc = {
                    val clientUser = retrieveClientUser(user)
                    LetterToBankPrepareSteps.createProcessedLetterToBank(creatorClientUser = clientUser)
                }
            )
        }

    //region With Attach
    val dtoForCreateWithAttach: (User) -> LetterToBankDto = {
        LetterToBankPrepareSteps.getLetterToBankDtoForCreate(
            creatorClientUser = it.retrieveClientUser(),
            attachments = listOf(AttachmentPrepareSteps.DEFAULT_ATTACH_FILE)
        )
    }

    val dtoForCreateWithMultipleAttach: (User, String, Int) -> LetterToBankDto = { user: User, fileName, attachQty: Int ->
        val attachments = FileHelper.createTempFiles(fileName, "txt", attachQty, "ATest attachment".toByteArray())
        LetterToBankPrepareSteps.getLetterToBankDtoForCreate(
            creatorClientUser = user,
            attachments = attachments
        )
    }

    val LTBPreExecutionNewWithAttach
        get() = { user: User ->
            getOrCreateLetterToBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(NEW.asFilterData(user)).and(IS_HAS_ATTACH.eq(true)).toPageRequest() },
                createLtbFunc = {
                    val clientUser = retrieveClientUser(user)
                    LetterToBankPrepareSteps.createLetterToBankDto(
                        creatorClientUser = clientUser,
                        dtoForCreate = dtoForCreateWithAttach(clientUser)
                    )
                }
            )
        }

    val LTBPreExecutionSignedWithAttach
        get() = { user: User ->
            getOrCreateLetterToBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(SIGNED.asFilterData(user)).and(IS_HAS_ATTACH.eq(true)).toPageRequest() },
                createLtbFunc = {
                    val clientUser = retrieveClientUser(user)
                    LetterToBankPrepareSteps.createSignedLetterToBank(
                        creatorClientUser = clientUser,
                        dtoForCreate = dtoForCreateWithAttach(clientUser)
                    )
                }
            )
        }

    val LTBPreExecutionReceivedWithAttach
        get() = { user: User ->
            getOrCreateLetterToBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(RECEIVED.asFilterData(user)).and(IS_HAS_ATTACH.eq(true)).toPageRequest() },
                createLtbFunc = {
                    val clientUser = retrieveClientUser(user)
                    LetterToBankPrepareSteps.createReceivedLetterToBank(
                        creatorClientUser = clientUser,
                        dtoForCreate = dtoForCreateWithAttach(clientUser)
                    )
                }
            )
        }

    val LTBPreExecutionReceivedWithMultipleAttach
        get() = { user: User, attachQty: Int ->
            val fileName = "ltb_attach"
            val searchFileName = "${fileName}_$attachQty"
            getOrCreateLetterToBankDto(searchingUser = user,
                getPageRequest = {
                    recentDocFilterData.and(RECEIVED.asFilterData(user)).and(ATTACH_FILE_NAME.contains(searchFileName)).toPageRequest()
                },
                createLtbFunc = {
                    val clientUser = retrieveClientUser(user)
                    LetterToBankPrepareSteps.createReceivedLetterToBank(
                        creatorClientUser = clientUser,
                        dtoForCreate = dtoForCreateWithMultipleAttach(clientUser, fileName, attachQty)
                    )
                }
            )
        }
    //endregion

    val LTBPreExecutionInStatus
        get() = { user: User, status: LetterToBankStatus ->
            val localClientUser = retrieveClientUser(user)
            getOrCreateLetterToBankDto(
                searchingUser = user, creatorClientUser = localClientUser,
                getPageRequest = { recentDocFilterData.and(status.asFilterData(user)).toPageRequest() },
                createLtbFunc = {
                    val localBankUser = LetterToBankPrepareSteps.retrieveBankUser(user)
                    LetterToBankPrepareSteps.createLetterToBankInStatus(
                        creatorClientUser = localClientUser, receiverBankUser = localBankUser,
                        dtoForCreate = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(
                            creatorClientUser = localClientUser, receiverBankUser = localBankUser
                        ),
                        status = status
                    )
                }
            )
        }

    val LTBPreExecutionCustomerIdByStatus: (User, Int, LetterToBankStatus) -> UUID
        get() = { user, docCountNeed, statusNeed ->
            "Получить клиента (customer_id) у которого есть $docCountNeed документа в статусе $statusNeed"{
                val availableCustomers = CustomerData.searchBy(user)
                val availableCustomersStr = availableCustomers.joinToString { "'${it.id!!}'" }
                val docStatus = statusNeed.getUserStatus(user.userType)
                val sql = "select  id_customer from letter_to_bank\n" +
                        "where status='$docStatus' and id_customer in ($availableCustomersStr)\n" +
                        "group by id_customer " +
                        "having count(id_customer) > $docCountNeed"

                val suitableCustomers = Services.LETTER.db.execSql(sql).map { UUID.fromString("${it["id_customer"]}") }
                if (suitableCustomers.isEmpty()) {
                    val customerId = availableCustomers.random().id!!
                    repeat(docCountNeed) {
                        val dtoForCreate = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(customerId = customerId)
                        val clientUser = retrieveClientUser(user)
                        LetterToBankPrepareSteps.createLetterToBankInStatus(
                            creatorClientUser = clientUser,
                            status = statusNeed,
                            dtoForCreate = dtoForCreate
                        )
                    }
                    customerId
                } else suitableCustomers.random()
            }.output.getOrException(TestConstants.PRE_EXECUTION_ERROR_MSG).attachToAllure()
        }

    val LTBUiExpSentStatuses: (User) -> List<String>
        get() = { user ->
            listOf(DELIVERED, FOR_RECEIVING, RECEIVING_ERROR, WRONG_ESIGNATURE, DETAILS_ERROR, RECEIVED).map { it.getUserStatus(user.userType) }
        }

}