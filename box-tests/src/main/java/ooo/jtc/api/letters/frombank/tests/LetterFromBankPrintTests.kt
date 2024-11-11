package ooo.jtc.api.letters.frombank.tests

import ooo.jtc.api.common.templates.entity.PrintDocumentTableByIdTestTemplate
import ooo.jtc.api.common.templates.entity.PrintDocumentsByIdTestTemplate
import ooo.jtc.api.common.templates.entity.PrintFormatTestTemplate
import ooo.jtc.api.common.templates.entity.PrintMultipleDocsFileNamesTestTemplate
import ooo.jtc.api.common.templates.entity.PrintSingleDocFileNameTestTemplate
import ooo.jtc.api.common.templates.entity.PrintSingleDocumentByIdTestTemplate
import ooo.jtc.api.common.templates.entity.PrintTableFormatTestTemplate
import ooo.jtc.api.letters.frombank.LetterFromBankPreExecutions.LFBPreExecutionInStatus
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.retrieveBankUser
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.retrieveClientUser
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPreparePrintSteps
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps
import ooo.jtc.api.letters.frombank.steps.LetterFromBankSteps
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps.DEFAULT_ATTACH_FILE
import ooo.jtc.core.tm4j.ComponentFreeFormatDoc
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
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.letters.model.LetterFromBankPrintExportFormat
import ooo.jtc.letters.model.LetterFromBankStampResult
import ooo.jtc.letters.model.LetterFromBankStatus
import ooo.jtc.letters.model.LetterFromBankStatus.DELIVERED
import ooo.jtc.letters.model.LetterFromBankStatus.DETAILS_ERROR
import ooo.jtc.letters.model.LetterFromBankStatus.SIGNED
import ooo.jtc.letters.model.LetterFromBankStatus.WRONG_ESIGNATURE
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.IS_HAS_ATTACH
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.STATUS
import ooo.jtc.uaa.User
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.not

@LetterFromBankTaskIdsPrint
@LetterFromBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankPrintFormatTest(user: User) : PrintFormatTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(user),
    expPrintFormats = LetterFromBankPrintExportFormat.printFormats
)

@LetterFromBankTaskIdsPrint
@LetterFromBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankPrintTableFormatTest(user: User) : PrintTableFormatTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(user),
    expPrintTableFormats = LetterFromBankPrintExportFormat.printTableFormats
)

@LetterFromBankTaskIdsPrintDoc
@LetterFromBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankPrintSingleDocFileNameTest(
    user: User,
    printFormat: PrintExportFormat,
    printParams: PrintParams
) : PrintSingleDocFileNameTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(user),
    printFormat = printFormat,
    printParams = printParams,
    preExecution = {
        LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(
            searchingUser = user,
            getPageRequest = { recentDocFilterData.toPageRequest() },
            creatorBankUser = retrieveBankUser(user)
        )
    },
    getExpFileNameFunc = { LetterFromBankPreparePrintSteps.preparePrintFileNameSingleDoc(it) }
)

@LetterFromBankTaskIdsPrintDoc
@LetterFromBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankPrintMultipleDocsFileNameTest(
    user: User,
    printFormat: PrintExportFormat,
    printParams: PrintParams,
    docsToPrintAmount: Long = REQUIRED_DATA_COUNT
) : PrintMultipleDocsFileNamesTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(user),
    printFormat = printFormat,
    printParams = printParams,
    preExecution = {
        val localBankUser = retrieveBankUser(user)
        LetterFromBankPrepareSteps.getOrCreateDifferentLetterFromBankDtoList(
            searchingUser = user,
            creatorBankUser = localBankUser,
            getPageRequest = { recentDocFilterData.toPageRequest() },
            amount = docsToPrintAmount,
            createLfbFunc = {
                LetterFromBankPrepareSteps.createLetterFromBankAvailableToUser(
                    user = user,
                    creatorBankUser = localBankUser,
                    dtoForCreate = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(
                        creatorBankUser = localBankUser,
                        receiverClientUser = retrieveClientUser(user)
                    )
                )
            }
        )
    },
    getExpFileNameRegexFunc = { LetterFromBankPreparePrintSteps.preparePrintFileNameRegexMultipleDocs() },
    additionalFileNameChecks = { actFileName ->
        val dateTimeFromFileName = actFileName
            .replace("^.*($DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS_REGEX_STRING).*\$".toRegex(), "$1")
        dateTimeFromFileName.toDateTime(DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS)
        // 2020.09.22 [Sergeyev]: в рамках первого релиза все проблемы, связанные со временем, не будут решаться.
        // Поэтому с такими ограничениями достаточно проверки, что время присутствует в нужном формате и парсится
        // TODO [2020.09.22]: check time correctly (in Release 2)
    }
)

@LetterFromBankTaskIdsPrintTable
@LetterFromBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankPrintTableDocsTest(
    user: User,
    printFormat: PrintExportFormat,
    nameDetails: String = "",
    docsToPrintAmount: Long = REQUIRED_DATA_COUNT
) : PrintDocumentTableByIdTestTemplate<LetterFromBankDto>(
    nameDetails = nameDetails,
    steps = LetterFromBankSteps(user),
    printFormat = printFormat,
    preExecution = {
        val localBankUser = retrieveBankUser(user)
        LetterFromBankPrepareSteps.getOrCreateDifferentLetterFromBankDtoList(
            searchingUser = user,
            creatorBankUser = localBankUser,
            getPageRequest = { recentDocFilterData.toPageRequest() },
            amount = docsToPrintAmount,
            createLfbFunc = {
                LetterFromBankPrepareSteps.createLetterFromBankAvailableToUser(
                    user = user,
                    creatorBankUser = localBankUser,
                    dtoForCreate = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(
                        creatorBankUser = localBankUser,
                        receiverClientUser = retrieveClientUser(user)
                    )
                )
            }
        )
    },
    getExpFileContentFunc = { LetterFromBankPreparePrintSteps.preparePrintTableExpContent(it, user.userType) },
    additionalContentChecks = { actFileName ->
        val dateTimeFromContent = actFileName
            .replace("^(.|\n)*($DOTS_DATE_WITH_TIME_WITHOUT_SECONDS_FORMAT_REGEX_STRING)(.|\n)*$".toRegex(), "$2")
        dateTimeFromContent.toDateTime(DOTS_DATE_WITH_TIME_WITHOUT_SECONDS_FORMAT)
        // 2020.09.22 [Sergeyev]: в рамках первого релиза все проблемы, связанные со временем, не будут решаться.
        // Поэтому с такими ограничениями достаточно проверки, что время присутствует в нужном формате и парсится
        // TODO [2020.09.22]: check time correctly (in Release 2)
    }
)

@LetterFromBankTaskIdsPrintDoc
@LetterFromBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
open class LetterFromBankPrintSingleDocByIdTest(
    user: User,
    printFormat: PrintExportFormat,
    printParams: PrintParams,
    nameDetails: String = "",
    preExecution: (() -> LetterFromBankDto)? = null
) : PrintSingleDocumentByIdTestTemplate<LetterFromBankDto>(
    nameDetails = nameDetails,
    steps = LetterFromBankSteps(user),
    printFormat = printFormat,
    printParams = printParams,
    preExecution = preExecution
        ?: {
            LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(
                searchingUser = user,
                getPageRequest = { recentDocFilterData.toPageRequest() },
                creatorBankUser = retrieveBankUser(user)
            )
        },
    getExpFileContentFunc = { LetterFromBankPreparePrintSteps.preparePrintExpContent(listOf(it), printParams.needSignInfo, user) }
)

@LetterFromBankTaskIdsPrintDoc
@LetterFromBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankPrintSingleDocByIdTest_WithoutAttachAndSignature(
    user: User,
    printFormat: PrintExportFormat
) : LetterFromBankPrintSingleDocByIdTest(
    user = user,
    nameDetails = " (проверка содержимого без подписи и вложений)",
    printFormat = printFormat,
    printParams = PrintParams(needSignInfo = false),
    preExecution = {
        val localBankUser = retrieveBankUser(user)
        LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(
            searchingUser = user, creatorBankUser = localBankUser,
            getPageRequest = { recentDocFilterData.and(IS_HAS_ATTACH.eq(false)).toPageRequest() },
            createLfbFunc = {
                LetterFromBankPrepareSteps.createLetterFromBankAvailableToUser(
                    user = user, creatorBankUser = localBankUser,
                    dtoForCreate = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(
                        creatorBankUser = localBankUser, receiverClientUser = retrieveClientUser(user)
                    )
                )
            }
        )
    }
)

@LetterFromBankTaskIdsPrintDoc
@LetterFromBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankPrintSingleDocByIdTest_WithSignature(
    user: User,
    printFormat: PrintExportFormat,
    status: LetterFromBankStatus? = null
) : LetterFromBankPrintSingleDocByIdTest(
    user = user,
    nameDetails = " (проверка содержимого с данными подписи)",
    printFormat = printFormat,
    printParams = PrintParams(needSignInfo = true),
    preExecution = {
        val localBankUser = retrieveBankUser(user)
        val signedLtbFilterDataByStatus = status
            ?.asFilterData(user)
            ?: listOf(SIGNED, DELIVERED, WRONG_ESIGNATURE, DETAILS_ERROR)
                .map { it.asFilterData(user) }
                .distinct()
                .reduce { fd1, fd2 -> fd1.or(fd2) }

        LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(
            searchingUser = user, creatorBankUser = localBankUser,
            getPageRequest = {
                recentDocFilterData
                    .and(IS_HAS_ATTACH.eq(false))
                    .and(signedLtbFilterDataByStatus)
                    .toPageRequest()
            },
            createLfbFunc = {
                LetterFromBankPrepareSteps.createLetterFromBankAvailableToUser(
                    user = user, creatorBankUser = localBankUser,
                    dtoForCreate = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(
                        creatorBankUser = localBankUser, receiverClientUser = retrieveClientUser(user)
                    )
                )
            }
        )
    }
)

@LetterFromBankTaskIdsPrintDoc
@LetterFromBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankPrintSingleDocByIdTest_WithAttach(
    user: User,
    printFormat: PrintExportFormat
) : LetterFromBankPrintSingleDocByIdTest(
    user = user,
    nameDetails = " (проверка содержимого с вложениями)",
    printFormat = printFormat,
    printParams = PrintParams(needSignInfo = false),
    preExecution = {
        val localBankUser = retrieveBankUser(user)
        LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(
            searchingUser = user, creatorBankUser = localBankUser,
            getPageRequest = { recentDocFilterData.and(IS_HAS_ATTACH.eq(true)).toPageRequest() },
            createLfbFunc = {
                LetterFromBankPrepareSteps.createLetterFromBankAvailableToUser(
                    user = user, creatorBankUser = localBankUser,
                    dtoForCreate = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(
                        creatorBankUser = localBankUser, receiverClientUser = retrieveClientUser(user),
                        attachments = listOf(DEFAULT_ATTACH_FILE)
                    )
                )
            }
        )
    }
)

@LetterFromBankTaskIdsPrintDoc
@LetterFromBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankPrintSingleDocByIdTest_InStatus(
    user: User,
    printFormat: PrintExportFormat,
    status: LetterFromBankStatus
) : LetterFromBankPrintSingleDocByIdTest(
    user = user,
    nameDetails = " (проверка содержимого для статуса '$status')",
    printFormat = printFormat,
    printParams = PrintParams(needSignInfo = false),
    preExecution = {
        val localBankUser = retrieveBankUser(user)
        LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(
            searchingUser = user, creatorBankUser = localBankUser,
            getPageRequest = { recentDocFilterData.and(STATUS.eq(status.getUserStatus(user.userType))).toPageRequest() },
            createLfbFunc = {
                val localClientUser = retrieveClientUser(user)
                LetterFromBankPrepareSteps.createLetterFromBankInStatus(
                    creatorBankUser = localBankUser, receiverClientUser = localClientUser,
                    dtoForCreate = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(
                        creatorBankUser = localBankUser, receiverClientUser = localClientUser
                    ),
                    status = status
                )
            }
        )
    }
)

@LetterFromBankTaskIdsPrintDoc
@LetterFromBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankPrintMultipleDocsByIdTest(
    user: User,
    printFormat: PrintExportFormat,
    printParams: PrintParams,
    nameDetails: String = "",
    docsToPrintAmount: Long = REQUIRED_DATA_COUNT
) : PrintDocumentsByIdTestTemplate<LetterFromBankDto>(
    nameDetails = nameDetails,
    steps = LetterFromBankSteps(user),
    printFormat = printFormat,
    printParams = printParams,
    preExecution = {
        val localBankUser = retrieveBankUser(user)
        LetterFromBankPrepareSteps.getOrCreateDifferentLetterFromBankDtoList(
            searchingUser = user,
            creatorBankUser = localBankUser,
            getPageRequest = { recentDocFilterData.toPageRequest() },
            amount = docsToPrintAmount,
            createLfbFunc = {
                LetterFromBankPrepareSteps.createLetterFromBankAvailableToUser(
                    user = user,
                    creatorBankUser = localBankUser,
                    dtoForCreate = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(
                        creatorBankUser = localBankUser,
                        receiverClientUser = retrieveClientUser(user)
                    )
                )
            }
        )
    },
    getExpFileContentFunc = { LetterFromBankPreparePrintSteps.preparePrintExpContent(it, printParams.needSignInfo, user) }
)

@LetterFromBankTaskIdsPrintDoc
@LetterFromBankFolderPrint
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankPrintSingleDocNoStampTest(
    user: User,
    printFormat: PrintExportFormat,
    status: LetterFromBankStatus
) : PrintSingleDocumentByIdTestTemplate<LetterFromBankDto>(
    nameDetails = " (проверка отсутствия штампа для статуса '$status')",
    steps = LetterFromBankSteps(user),
    printFormat = printFormat,
    printParams = PrintParams(needSignInfo = false),
    preExecution = { LFBPreExecutionInStatus(user, status) },
    getExpFileContentFunc = { emptyList() },
    additionalContentChecks = {
        LetterFromBankStampResult.values().forEach { sResult ->
            assertThat("В ПФ присутствует штамп", it, not(containsString(sResult.stampResult)))
        }
    }
)