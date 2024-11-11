@file:Suppress("ClassName")

package ooo.jtc.api.letters.tobank.tests

import ooo.jtc.api.common.templates.entity.PrintDocumentTableByIdTestTemplate
import ooo.jtc.api.common.templates.entity.PrintDocumentsByIdTestTemplate
import ooo.jtc.api.common.templates.entity.PrintFormatTestTemplate
import ooo.jtc.api.common.templates.entity.PrintMultipleDocsFileNamesTestTemplate
import ooo.jtc.api.common.templates.entity.PrintSingleDocFileNameTestTemplate
import ooo.jtc.api.common.templates.entity.PrintSingleDocumentByIdTestTemplate
import ooo.jtc.api.common.templates.entity.PrintTableFormatTestTemplate
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBPreExecutionInStatus
import ooo.jtc.api.letters.tobank.steps.LetterToBankPreparePrintSteps
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.retrieveBankUser
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.retrieveClientUser
import ooo.jtc.api.letters.tobank.steps.LetterToBankSteps
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps.DEFAULT_ATTACH_FILE
import ooo.jtc.core.tm4j.ComponentFreeFormatDoc
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.extensions.DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS
import ooo.jtc.extensions.DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS_REGEX_STRING
import ooo.jtc.extensions.DOTS_DATE_WITH_TIME_WITHOUT_SECONDS_FORMAT
import ooo.jtc.extensions.DOTS_DATE_WITH_TIME_WITHOUT_SECONDS_FORMAT_REGEX_STRING
import ooo.jtc.extensions.toDateTime
import ooo.jtc.generic.pageparams.and
import ooo.jtc.generic.pageparams.or
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.generic.print.PrintExportFormat
import ooo.jtc.generic.print.PrintParams
import ooo.jtc.interfaces.recentDocFilterData
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankPrintExportFormat
import ooo.jtc.letters.model.LetterToBankStampResult
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.letters.model.LetterToBankStatus.DELIVERED
import ooo.jtc.letters.model.LetterToBankStatus.DETAILS_ERROR
import ooo.jtc.letters.model.LetterToBankStatus.FOR_RECEIVING
import ooo.jtc.letters.model.LetterToBankStatus.IN_PROCESSING
import ooo.jtc.letters.model.LetterToBankStatus.PARTLY_SIGNED
import ooo.jtc.letters.model.LetterToBankStatus.PROCESSED
import ooo.jtc.letters.model.LetterToBankStatus.RECALLED
import ooo.jtc.letters.model.LetterToBankStatus.RECEIVED
import ooo.jtc.letters.model.LetterToBankStatus.RECEIVING_ERROR
import ooo.jtc.letters.model.LetterToBankStatus.SIGNED
import ooo.jtc.letters.model.LetterToBankStatus.WRONG_ESIGNATURE
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.IS_HAS_ATTACH
import ooo.jtc.uaa.User
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.not


@LetterToBankTaskIdsDocApi
@LetterToBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankPrintFormatTest(user: User) : PrintFormatTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(user),
    expPrintFormats = LetterToBankPrintExportFormat.printFormats
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankPrintTableFormatTest(user: User) : PrintTableFormatTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(user),
    expPrintTableFormats = LetterToBankPrintExportFormat.printTableFormats
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankPrintSingleDocFileNameTest(
    user: User,
    printFormat: PrintExportFormat,
    printParams: PrintParams
) : PrintSingleDocFileNameTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(user),
    printFormat = printFormat,
    printParams = printParams,
    preExecution = {
        LetterToBankPrepareSteps.getOrCreateLetterToBankDto(
            searchingUser = user,
            getPageRequest = { recentDocFilterData.toPageRequest() },
            creatorClientUser = retrieveClientUser(user)
        )
    },
    getExpFileNameFunc = { LetterToBankPreparePrintSteps.preparePrintFileNameSingleDoc(it) }
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankPrintMultipleDocsFileNameTest(
    user: User,
    printFormat: PrintExportFormat,
    printParams: PrintParams,
    docsToPrintAmount: Long = REQUIRED_DATA_COUNT
) : PrintMultipleDocsFileNamesTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(user),
    printFormat = printFormat,
    printParams = printParams,
    preExecution = {
        val localClientUser = retrieveClientUser(user)
        LetterToBankPrepareSteps.getOrCreateDifferentLetterToBankDtoList(
            searchingUser = user,
            creatorClientUser = localClientUser,
            getPageRequest = { recentDocFilterData.toPageRequest() },
            amount = docsToPrintAmount,
            createLtbFunc = {
                LetterToBankPrepareSteps.createLetterToBankAvailableToUser(
                    user = user,
                    creatorClientUser = localClientUser,
                    dtoForCreate = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(
                        creatorClientUser = localClientUser,
                        receiverBankUser = retrieveBankUser(user)
                    )
                )
            }
        )
    },
    getExpFileNameRegexFunc = { LetterToBankPreparePrintSteps.preparePrintFileNameRegexMultipleDocs() },
    additionalFileNameChecks = { actFileName ->
        val dateTimeFromFileName = actFileName
            .replace("^.*($DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS_REGEX_STRING).*\$".toRegex(), "$1")
        dateTimeFromFileName.toDateTime(DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS)
        // 2020.09.22 [Sergeyev]: в рамках первого релиза все проблемы, связанные со временем, не будут решаться.
        // Поэтому с такими ограничениями достаточно проверки, что время присутствует в нужном формате и парсится
        // TODO [2020.09.22]: check time correctly (in Release 2)
    }
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankPrintTableDocsTest(
    user: User,
    printFormat: PrintExportFormat,
    nameDetails: String = "",
    docsToPrintAmount: Long = REQUIRED_DATA_COUNT
) : PrintDocumentTableByIdTestTemplate<LetterToBankDto>(
    nameDetails = nameDetails,
    steps = LetterToBankSteps(user),
    printFormat = printFormat,
    preExecution = {
        val localClientUser = retrieveClientUser(user)
        LetterToBankPrepareSteps.getOrCreateDifferentLetterToBankDtoList(
            searchingUser = user,
            creatorClientUser = localClientUser,
            getPageRequest = { recentDocFilterData.toPageRequest() },
            amount = docsToPrintAmount,
            createLtbFunc = {
                LetterToBankPrepareSteps.createLetterToBankAvailableToUser(
                    user = user,
                    creatorClientUser = localClientUser,
                    dtoForCreate = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(
                        creatorClientUser = localClientUser,
                        receiverBankUser = retrieveBankUser(user)
                    )
                )
            }
        )
    },
    getExpFileContentFunc = { LetterToBankPreparePrintSteps.preparePrintTableExpContent(it, user.userType) },
    additionalContentChecks = { actFileName ->
        val dateTimeFromContent = actFileName
            .replace("^(.|\n)*($DOTS_DATE_WITH_TIME_WITHOUT_SECONDS_FORMAT_REGEX_STRING)(.|\n)*$".toRegex(), "$2")
        dateTimeFromContent.toDateTime(DOTS_DATE_WITH_TIME_WITHOUT_SECONDS_FORMAT)
        // 2020.09.22 [Sergeyev]: в рамках первого релиза все проблемы, связанные со временем, не будут решаться.
        // Поэтому с такими ограничениями достаточно проверки, что время присутствует в нужном формате и парсится
        // TODO [2020.09.22]: check time correctly (in Release 2)
    }
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
open class LetterToBankPrintSingleDocByIdTest(
    user: User,
    printFormat: PrintExportFormat,
    printParams: PrintParams,
    nameDetails: String = "",
    preExecution: (() -> LetterToBankDto)? = null
) : PrintSingleDocumentByIdTestTemplate<LetterToBankDto>(
    nameDetails = nameDetails,
    steps = LetterToBankSteps(user),
    printFormat = printFormat,
    printParams = printParams,
    preExecution = preExecution
        ?: {
            LetterToBankPrepareSteps.getOrCreateLetterToBankDto(
                searchingUser = user,
                getPageRequest = { recentDocFilterData.toPageRequest() },
                creatorClientUser = retrieveClientUser(user)
            )
        },
    getExpFileContentFunc = { LetterToBankPreparePrintSteps.preparePrintExpContent(listOf(it), printParams.needSignInfo, user) }
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankPrintSingleDocByIdTest_WithoutAttachAndSignature(
    user: User,
    printFormat: PrintExportFormat
) : LetterToBankPrintSingleDocByIdTest(
    user = user,
    nameDetails = " (проверка содержимого без подписи и вложений)",
    printFormat = printFormat,
    printParams = PrintParams(needSignInfo = false),
    preExecution = {
        val localClientUser = retrieveClientUser(user)
        LetterToBankPrepareSteps.getOrCreateLetterToBankDto(
            searchingUser = user, creatorClientUser = localClientUser,
            getPageRequest = { recentDocFilterData.and(IS_HAS_ATTACH.eq(false)).toPageRequest() },
            createLtbFunc = {
                LetterToBankPrepareSteps.createLetterToBankAvailableToUser(
                    user = user, creatorClientUser = localClientUser,
                    dtoForCreate = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(
                        creatorClientUser = localClientUser, receiverBankUser = retrieveBankUser(user)
                    )
                )
            }
        )
    }
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankPrintSingleDocByIdTest_WithSignature(
    user: User,
    printFormat: PrintExportFormat,
    status: LetterToBankStatus? = null
) : LetterToBankPrintSingleDocByIdTest(
    user = user,
    nameDetails = " (проверка содержимого с данными подписи)",
    printFormat = printFormat,
    printParams = PrintParams(needSignInfo = true),
    preExecution = {
        val localClientUser = retrieveClientUser(user)
        val signedLtbFilterDataByStatus = status?.asFilterData(user) ?: listOf(
            PARTLY_SIGNED, SIGNED, DELIVERED, FOR_RECEIVING, RECEIVING_ERROR, WRONG_ESIGNATURE,
            DETAILS_ERROR, RECEIVED, IN_PROCESSING, RECALLED, PROCESSED,
        )
            .map { it.asFilterData(user) }
            .distinct()
            .reduce { fd1, fd2 -> fd1.or(fd2) }

        LetterToBankPrepareSteps.getOrCreateLetterToBankDto(
            searchingUser = user, creatorClientUser = localClientUser,
            getPageRequest = {
                recentDocFilterData
                    .and(IS_HAS_ATTACH.eq(false))
                    .and(signedLtbFilterDataByStatus)
                    .toPageRequest()
            },
            createLtbFunc = {
                LetterToBankPrepareSteps.createLetterToBankAvailableToUser(
                    user = user, creatorClientUser = localClientUser,
                    dtoForCreate = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(
                        creatorClientUser = localClientUser, receiverBankUser = retrieveBankUser(user)
                    )
                )
            }
        )
    }
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankPrintSingleDocByIdTest_WithAttach(
    user: User,
    printFormat: PrintExportFormat
) : LetterToBankPrintSingleDocByIdTest(
    user = user,
    nameDetails = " (проверка содержимого с вложениями)",
    printFormat = printFormat,
    printParams = PrintParams(needSignInfo = false),
    preExecution = {
        val localClientUser = retrieveClientUser(user)
        LetterToBankPrepareSteps.getOrCreateLetterToBankDto(
            searchingUser = user, creatorClientUser = localClientUser,
            getPageRequest = { recentDocFilterData.and(IS_HAS_ATTACH.eq(true)).toPageRequest() },
            createLtbFunc = {
                LetterToBankPrepareSteps.createLetterToBankAvailableToUser(
                    user = user, creatorClientUser = localClientUser,
                    dtoForCreate = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(
                        creatorClientUser = localClientUser, receiverBankUser = retrieveBankUser(user),
                        attachments = listOf(DEFAULT_ATTACH_FILE)
                    )
                )
            }
        )
    }
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankPrintSingleDocByIdTest_InStatus(
    user: User,
    printFormat: PrintExportFormat,
    status: LetterToBankStatus
) : LetterToBankPrintSingleDocByIdTest(
    user = user,
    nameDetails = " (проверка содержимого для статуса '$status')",
    printFormat = printFormat,
    printParams = PrintParams(needSignInfo = false),
    preExecution = { LTBPreExecutionInStatus(user, status) }
)


@LetterToBankTaskIdsDocApi
@LetterToBankFolderPrint
@ComponentFreeFormatDoc
@HighPriority
class LetterToBankPrintSingleDocNoStampTest(
    user: User,
    printFormat: PrintExportFormat,
    status: LetterToBankStatus
) : PrintSingleDocumentByIdTestTemplate<LetterToBankDto>(
    nameDetails = " (проверка отсутствия штампа для статуса '$status')",
    steps = LetterToBankSteps(user),
    printFormat = printFormat,
    printParams = PrintParams(needSignInfo = false),
    preExecution = { LTBPreExecutionInStatus(user, status) },
    getExpFileContentFunc = { emptyList() },
    additionalContentChecks = {
        LetterToBankStampResult.values().forEach { sResult ->
            assertThat("В ПФ присутствует штамп", it, not(containsString(sResult.stampResult)))
        }
    }
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankPrintMultipleDocsByIdTest(
    user: User,
    printFormat: PrintExportFormat,
    printParams: PrintParams,
    nameDetails: String = "",
    docsToPrintAmount: Long = REQUIRED_DATA_COUNT
) : PrintDocumentsByIdTestTemplate<LetterToBankDto>(
    nameDetails = nameDetails,
    steps = LetterToBankSteps(user),
    printFormat = printFormat,
    printParams = printParams,
    preExecution = {
        val localClientUser = retrieveClientUser(user)
        LetterToBankPrepareSteps.getOrCreateDifferentLetterToBankDtoList(
            searchingUser = user,
            creatorClientUser = localClientUser,
            getPageRequest = { recentDocFilterData.toPageRequest() },
            amount = docsToPrintAmount,
            createLtbFunc = {
                LetterToBankPrepareSteps.createLetterToBankAvailableToUser(
                    user = user,
                    creatorClientUser = localClientUser,
                    dtoForCreate = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(
                        creatorClientUser = localClientUser,
                        receiverBankUser = retrieveBankUser(user)
                    )
                )
            }
        )
    },
    getExpFileContentFunc = { LetterToBankPreparePrintSteps.preparePrintExpContent(it, printParams.needSignInfo, user) }
)