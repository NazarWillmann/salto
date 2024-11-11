package ooo.jtc.api.letters.tobank.tests

import ooo.jtc.api.common.templates.entity.ExportDocumentsByFilterTestTemplate
import ooo.jtc.api.common.templates.entity.ExportDocumentsByIdTestTemplate
import ooo.jtc.api.common.templates.entity.ExportFormatTestTemplate
import ooo.jtc.api.common.templates.entity.ExportMultipleDocsFileNamesTestTemplate
import ooo.jtc.api.common.templates.entity.ExportSingleDocFileNameTestTemplate
import ooo.jtc.api.common.templates.entity.ExportSingleDocumentByIdTestTemplate
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareExportSteps
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.retrieveBankUser
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.retrieveClientUser
import ooo.jtc.api.letters.tobank.steps.LetterToBankSteps
import ooo.jtc.core.tm4j.ComponentFreeFormatDoc
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.extensions.DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS
import ooo.jtc.extensions.DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS_REGEX_STRING
import ooo.jtc.extensions.toDateTime
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.generic.print.PrintExportFormat
import ooo.jtc.interfaces.recentDocFilterData
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankPrintExportFormat.Companion.exportFormats
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import ooo.jtc.uaa.User

@LetterToBankTaskIdsDocApi
@LetterToBankFolderExport
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankExportFormatTest(user: User) : ExportFormatTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(user),
    expExportFormats = exportFormats
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderExport
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankExportSingleDocFileNameTest(
    user: User,
    printFormat: PrintExportFormat
) : ExportSingleDocFileNameTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(user),
    exportFormat = printFormat,
    preExecution = {
        LetterToBankPrepareSteps.getOrCreateLetterToBankDto(
            searchingUser = user,
            getPageRequest = { recentDocFilterData.toPageRequest() },
            creatorClientUser = retrieveClientUser(user)
        )
    },
    getExpFileNameFunc = { LetterToBankPrepareExportSteps.prepareExportFileNameSingleDoc(it) }
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderExport
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankExportMultipleDocsFileNameTest(
    user: User,
    printFormat: PrintExportFormat,
    docsToPrintAmount: Long = REQUIRED_DATA_COUNT
) : ExportMultipleDocsFileNamesTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(user),
    exportFormat = printFormat,
    preExecution = {
        LetterToBankPrepareSteps.getOrCreateDifferentLetterToBankDtoList(
            searchingUser = user,
            creatorClientUser = retrieveClientUser(user),
            getPageRequest = { recentDocFilterData.toPageRequest() },
            amount = docsToPrintAmount,
            createLtbFunc = {
                LetterToBankPrepareSteps.createLetterToBankAvailableToUser(
                    user = user,
                    creatorClientUser = retrieveClientUser(user),
                    dtoForCreate = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(
                        creatorClientUser = retrieveClientUser(user),
                        receiverBankUser = retrieveBankUser(user)
                    )
                )
            }
        )
    },
    getExpFileNameRegexFunc = { LetterToBankPrepareExportSteps.prepareExportFileNameRegexMultipleDocs() },
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
@LetterToBankFolderExport
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankExportSingleDocByIdTest(
    user: User,
    exportFormat: PrintExportFormat
) : ExportSingleDocumentByIdTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(user),
    exportFormat = exportFormat,
    preExecution = {
        LetterToBankPrepareSteps.getOrCreateLetterToBankDto(
            searchingUser = user,
            getPageRequest = { recentDocFilterData.toPageRequest() },
            creatorClientUser = retrieveClientUser(user)
        )
    },
    getExpFileContentFunc = {
        LetterToBankPrepareExportSteps.getExportExpContentByFormat(exportFormat, listOf(it), user.userType)
    }
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderExport
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankExportMultipleDocsByIdTest(
    user: User,
    exportFormat: PrintExportFormat,
    docsToPrintAmount: Long = REQUIRED_DATA_COUNT
) : ExportDocumentsByIdTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(user),
    exportFormat = exportFormat,
    preExecution = {
        LetterToBankPrepareSteps.getOrCreateDifferentLetterToBankDtoList(
            searchingUser = user,
            creatorClientUser = retrieveClientUser(user),
            getPageRequest = { recentDocFilterData.toPageRequest() },
            amount = docsToPrintAmount,
            createLtbFunc = {
                LetterToBankPrepareSteps.createLetterToBankAvailableToUser(
                    user = user,
                    creatorClientUser = retrieveClientUser(user),
                    dtoForCreate = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(
                        creatorClientUser = retrieveClientUser(user),
                        receiverBankUser = retrieveBankUser(user)
                    )
                )
            }
        )
    },
    getExpFileContentFunc = {
        LetterToBankPrepareExportSteps.getExportExpContentByFormat(exportFormat, it, user.userType)
    }
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderExport
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankExportDocsByFilterTest(
    user: User,
    exportFormat: PrintExportFormat,
    filterParams: Params,
    nameDetails: String
) : ExportDocumentsByFilterTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(user),
    exportFormat = exportFormat,
    nameDetails = nameDetails,
    filterParams = filterParams,
    getExpFileContentFunc = {
        LetterToBankPrepareExportSteps.getExportExpContentByFormat(exportFormat, it, user.userType)
    }
)
//endregion
