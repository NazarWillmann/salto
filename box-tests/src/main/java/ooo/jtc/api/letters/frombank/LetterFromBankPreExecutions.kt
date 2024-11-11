package ooo.jtc.api.letters.frombank

import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.retrieveBankUser
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.retrieveClientUser
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.extensions.getOrException
import ooo.jtc.files.FileHelper
import ooo.jtc.generic.pageparams.and
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.interfaces.recentDocFilterData
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.letters.model.LetterFromBankStatus
import ooo.jtc.letters.model.LetterFromBankStatus.DELIVERED
import ooo.jtc.letters.model.LetterFromBankStatus.DETAILS_ERROR
import ooo.jtc.letters.model.LetterFromBankStatus.DRAFT
import ooo.jtc.letters.model.LetterFromBankStatus.NEW
import ooo.jtc.letters.model.LetterFromBankStatus.SIGNED
import ooo.jtc.letters.model.LetterFromBankStatus.WRONG_ESIGNATURE
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.ATTACH_FILE_NAME
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.IS_HAS_ATTACH
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.STATUS
import ooo.jtc.uaa.User
import java.util.UUID

/**
 * Short functions to get different preExecutions.
 */
object LetterFromBankPreExecutions {

    val LFBPreExecutionDraft
        get() = { user: User ->
            getOrCreateLetterFromBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(DRAFT.asFilterData(user)).toPageRequest() },
                createLfbFunc = {
                    val bankUser = retrieveBankUser(user)
                    LetterFromBankPrepareSteps.createDraftLetterFromBank(creatorBankUser = bankUser)
                }
            )
        }

    val LFBPreExecutionNew
        get() = { user: User ->
            getOrCreateLetterFromBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(NEW.asFilterData(user)).toPageRequest() },
                createLfbFunc = {
                    val bankUser = retrieveBankUser(user)
                    LetterFromBankPrepareSteps.createNewLetterFromBank(creatorBankUser = bankUser)
                }
            )
        }

    val LFBPreExecutionSigned
        get() = { user: User ->
            getOrCreateLetterFromBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(SIGNED.asFilterData(user)).toPageRequest() },
                createLfbFunc = {
                    val bankUser = retrieveBankUser(user)
                    LetterFromBankPrepareSteps.createSignedLetterFromBank(creatorBankUser = bankUser)
                }
            )
        }

    val LFBPreExecutionDelivered
        get() = { user: User ->
            getOrCreateLetterFromBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(DELIVERED.asFilterData(user)).toPageRequest() },
                createLfbFunc = {
                    val bankUser = retrieveBankUser(user)
                    LetterFromBankPrepareSteps.createDeliveredLetterFromBank(creatorBankUser = bankUser)
                }
            )
        }

    val LFBPreExecutionDetailsError
        get() = { user: User ->
            getOrCreateLetterFromBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(DETAILS_ERROR.asFilterData(user)).toPageRequest() },
                createLfbFunc = {
                    val bankUser = retrieveBankUser(user)
                    LetterFromBankPrepareSteps.createDetailsErrorLetterFromBank_DIRTY(creatorBankUser = bankUser)
                }
            )
        }

    val LFBPreExecutionWrongESignature
        get() = { user: User ->
            getOrCreateLetterFromBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(WRONG_ESIGNATURE.asFilterData(user)).toPageRequest() },
                createLfbFunc = {
                    val bankUser = retrieveBankUser(user)
                    LetterFromBankPrepareSteps.createIncorrectDigestLetterFromBank_DIRTY(creatorBankUser = bankUser)
                }
            )
        }

    val LFBPreExecutionCustomerIdByStatus: (User, Int, LetterFromBankStatus) -> UUID
        get() = { user, docCountNeed, statusNeed ->
            "Получить клиента (customer_id) у которого есть $docCountNeed документа в статусе $statusNeed"{
                val availableCustomers = CustomerData.searchBy(user)
                val availableCustomersStr = availableCustomers.joinToString { "'${it.id!!}'" }
                // Sergeyev [2020.11.03]: в текущем состоянии системы банковские статусы всегда чётко отражают этап,
                // на котором находится документ (не только Письмо из Банка!), в то время как клиентские могут скрывать
                // за одним названием несколько состояний
                val docStatus = statusNeed.statusBank
                val sql = "select id_customer from letter_from_bank\n" +
                        "where bank_status='$docStatus' and id_customer in ($availableCustomersStr)\n" +
                        "group by id_customer " +
                        "having count(id_customer) > $docCountNeed"

                val suitableCustomers = Services.LETTER.db.execSql(sql).map { UUID.fromString("${it["id_customer"]}") }
                if (suitableCustomers.isEmpty()) {
                    val customerId = availableCustomers.random().id!!
                    repeat(docCountNeed) {
                        val bankUser = LetterToBankPrepareSteps.retrieveBankUser(user)
                        val clientUser = Users.client
                        val dtoForCreate = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(bankUser, clientUser)
                        LetterFromBankPrepareSteps.createLetterFromBankInStatus(
                            creatorBankUser = bankUser,
                            status = statusNeed,
                            dtoForCreate = dtoForCreate
                        )
                    }
                    customerId
                } else suitableCustomers.random()
            }.output.getOrException(TestConstants.PRE_EXECUTION_ERROR_MSG).attachToAllure()
        }

    //region With Attach
    val dtoForCreateWithAttach: (User) -> LetterFromBankDto = {
        LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(
            creatorBankUser = it,
            attachments = listOf(AttachmentPrepareSteps.DEFAULT_ATTACH_FILE)
        )
    }

    val dtoForCreateWithMultipleAttach: (User, String, Int) -> LetterFromBankDto = { user: User, fileName, attachQty: Int ->
        val attachments = FileHelper.createTempFiles(fileName, "txt", attachQty, "ATest attachment".toByteArray())
        LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(
            creatorBankUser = user,
            attachments = attachments
        )
    }

    val LFBPreExecutionNewWithAttach
        get() = { user: User ->
            getOrCreateLetterFromBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(NEW.asFilterData(user)).and(IS_HAS_ATTACH.eq(true)).toPageRequest() },
                createLfbFunc = {
                    val bankUser = retrieveBankUser(user)
                    LetterFromBankPrepareSteps.createLetterFromBankDto(
                        creatorBankUser = bankUser,
                        dtoForCreate = dtoForCreateWithAttach(bankUser)
                    )
                }
            )
        }

    val LFBPreExecutionSignedWithAttach
        get() = { user: User ->
            getOrCreateLetterFromBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(SIGNED.asFilterData(user)).and(IS_HAS_ATTACH.eq(true)).toPageRequest() },
                createLfbFunc = {
                    val bankUser = retrieveBankUser(user)
                    LetterFromBankPrepareSteps.createSignedLetterFromBank(
                        creatorBankUser = bankUser,
                        dtoForCreate = dtoForCreateWithAttach(bankUser)
                    )
                }
            )
        }

    val LFBPreExecutionDeliveredWithAttach
        get() = { user: User ->
            getOrCreateLetterFromBankDto(searchingUser = user,
                getPageRequest = { recentDocFilterData.and(DELIVERED.asFilterData(user)).and(IS_HAS_ATTACH.eq(true)).toPageRequest() },
                createLfbFunc = {
                    val bankUser = retrieveBankUser(user)
                    LetterFromBankPrepareSteps.createDeliveredLetterFromBank(
                        creatorBankUser = bankUser,
                        dtoForCreate = dtoForCreateWithAttach(bankUser)
                    )
                }
            )
        }

    val LFBPreExecutionDeliveredWithMultipleAttach
        get() = { user: User, attachQty: Int ->
            val fileName = "lfb_attach"
            val searchFileName = "${fileName}_$attachQty"
            getOrCreateLetterFromBankDto(searchingUser = user,
                getPageRequest = {
                    recentDocFilterData.and(DELIVERED.asFilterData(user)).and(ATTACH_FILE_NAME.contains(searchFileName)).toPageRequest()
                },
                createLfbFunc = {
                    val bankUser = retrieveBankUser(user)
                    LetterFromBankPrepareSteps.createDeliveredLetterFromBank(
                        creatorBankUser = bankUser,
                        dtoForCreate = dtoForCreateWithMultipleAttach(bankUser, fileName, attachQty)
                    )
                }
            )
        }
    //endregion

    val LFBPreExecutionInStatus
        get() = { user: User, status: LetterFromBankStatus ->
            val localBankUser = retrieveBankUser(user)
            getOrCreateLetterFromBankDto(
                searchingUser = user, creatorBankUser = localBankUser,
                getPageRequest = { recentDocFilterData.and(STATUS.eq(status.getUserStatus(user.userType))).toPageRequest() },
                createLfbFunc = {
                    val localClientUser = retrieveClientUser(user)
                    LetterFromBankPrepareSteps.createLetterFromBankInStatus(
                        creatorBankUser = localClientUser, receiverClientUser = localClientUser,
                        dtoForCreate = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(
                            creatorBankUser = localClientUser, receiverClientUser = localClientUser
                        ),
                        status = status
                    )
                }
            )
        }
    //endregion
}