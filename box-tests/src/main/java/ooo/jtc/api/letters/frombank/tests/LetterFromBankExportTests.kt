package ooo.jtc.api.letters.frombank.tests

import ooo.jtc.api.common.templates.entity.ExportDocumentsByFilterTestTemplate
import ooo.jtc.api.common.templates.entity.ExportDocumentsByIdTestTemplate
import ooo.jtc.api.common.templates.entity.ExportFormatTestTemplate
import ooo.jtc.api.common.templates.entity.ExportMultipleDocsFileNamesTestTemplate
import ooo.jtc.api.common.templates.entity.ExportSingleDocFileNameTestTemplate
import ooo.jtc.api.common.templates.entity.ExportSingleDocumentByIdTestTemplate
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareExportSteps
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.retrieveBankUser
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.retrieveClientUser
import ooo.jtc.api.letters.frombank.steps.LetterFromBankSteps
import ooo.jtc.core.tm4j.ComponentFreeFormatDoc
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.extensions.DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS
import ooo.jtc.extensions.DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS_REGEX_STRING
import ooo.jtc.extensions.toDateTime
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.generic.print.PrintExportFormat
import ooo.jtc.interfaces.recentDocFilterData
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.letters.model.LetterFromBankPrintExportFormat.Companion.exportFormats
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import ooo.jtc.uaa.User

@LetterFromBankTaskIdsExport
@LetterFromBankFolderExport
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankExportFormatTest(user: User) : ExportFormatTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(user),
    expExportFormats = exportFormats
)

@LetterFromBankTaskIdsExport
@LetterFromBankFolderExport
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankExportSingleDocFileNameTest(
    user: User,
    printFormat: PrintExportFormat
) : ExportSingleDocFileNameTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(user),
    exportFormat = printFormat,
    preExecution = {
        LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(
            searchingUser = user,
            getPageRequest = { recentDocFilterData.toPageRequest() },
            creatorBankUser = retrieveBankUser(user)
        )
    },
    getExpFileNameFunc = { LetterFromBankPrepareExportSteps.prepareExportFileNameSingleDoc(it) }
)

@LetterFromBankTaskIdsExport
@LetterFromBankFolderExport
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankExportMultipleDocsFileNameTest(
    user: User,
    printFormat: PrintExportFormat,
    docsToPrintAmount: Long = REQUIRED_DATA_COUNT
) : ExportMultipleDocsFileNamesTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(user),
    exportFormat = printFormat,
    preExecution = {
        LetterFromBankPrepareSteps.getOrCreateDifferentLetterFromBankDtoList(
            searchingUser = user,
            creatorBankUser = retrieveBankUser(user),
            getPageRequest = { recentDocFilterData.toPageRequest() },
            amount = docsToPrintAmount,
            createLfbFunc = {
                LetterFromBankPrepareSteps.createLetterFromBankAvailableToUser(
                    user = user,
                    creatorBankUser = retrieveBankUser(user),
                    dtoForCreate = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(
                        creatorBankUser = retrieveBankUser(user),
                        receiverClientUser = retrieveClientUser(user)
                    )
                )
            }
        )
    },
    getExpFileNameRegexFunc = { LetterFromBankPrepareExportSteps.prepareExportFileNameRegexMultipleDocs() },
    additionalFileNameChecks = { actFileName ->
        val dateTimeFromFileName = actFileName
            .replace("^.*($DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS_REGEX_STRING).*\$".toRegex(), "$1")
        dateTimeFromFileName.toDateTime(DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS)
        // 2020.09.22 [Sergeyev]: в рамках первого релиза все проблемы, связанные со временем, не будут решаться.
        // Поэтому с такими ограничениями достаточно проверки, что время присутствует в нужном формате и парсится
        // TODO [2020.09.22]: check time correctly (in Release 2)
    }
)

@LetterFromBankTaskIdsExport
@LetterFromBankFolderExport
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankExportSingleDocByIdTest(
    user: User,
    exportFormat: PrintExportFormat
) : ExportSingleDocumentByIdTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(user),
    exportFormat = exportFormat,
    preExecution = {
        LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(
            searchingUser = user,
            getPageRequest = { recentDocFilterData.toPageRequest() },
            creatorBankUser = retrieveBankUser(user)
        )
    },
    getExpFileContentFunc = {
        LetterFromBankPrepareExportSteps.getExportExpContentByFormat(exportFormat, listOf(it), user.userType)
    }
)

@LetterFromBankTaskIdsExport
@LetterFromBankFolderExport
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankExportMultipleDocsByIdTest(
    user: User,
    exportFormat: PrintExportFormat,
    docsToPrintAmount: Long = REQUIRED_DATA_COUNT
) : ExportDocumentsByIdTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(user),
    exportFormat = exportFormat,
    preExecution = {
        LetterFromBankPrepareSteps.getOrCreateDifferentLetterFromBankDtoList(
            searchingUser = user,
            creatorBankUser = retrieveBankUser(user),
            getPageRequest = { recentDocFilterData.toPageRequest() },
            amount = docsToPrintAmount,
            createLfbFunc = {
                LetterFromBankPrepareSteps.createLetterFromBankAvailableToUser(
                    user = user,
                    creatorBankUser = retrieveBankUser(user),
                    dtoForCreate = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(
                        creatorBankUser = retrieveBankUser(user),
                        receiverClientUser = retrieveClientUser(user)
                    )
                )
            }
        )
    },
    getExpFileContentFunc = {
        LetterFromBankPrepareExportSteps.getExportExpContentByFormat(exportFormat, it, user.userType)
    }
)

@LetterFromBankTaskIdsExport
@LetterFromBankFolderExport
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankExportDocsByFilterTest(
    user: User,
    exportFormat: PrintExportFormat,
    filterParams: Params,
    nameDetails: String
) : ExportDocumentsByFilterTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(user),
    exportFormat = exportFormat,
    nameDetails = nameDetails,
    filterParams = filterParams,
    getExpFileContentFunc = {
        LetterFromBankPrepareExportSteps.getExportExpContentByFormat(exportFormat, it, user.userType)
    }
)
