package ooo.jtc.api.common.steps

import io.qameta.allure.Step
import io.restassured.response.Response
import ooo.jtc.api.platform.crypto.CryptoPluginStubSteps
import ooo.jtc.api.platform.crypto.certificate.CertificatePrepareSteps
import ooo.jtc.api.platform.crypto.certificate.CertificateSteps
import ooo.jtc.core.TestConstants.SMS_CODE_FOR_SIGN_DOCUMENTS
import ooo.jtc.core.api.CoreApi.Companion.defaultStatusCheck
import ooo.jtc.core.api.responseAs
import ooo.jtc.crypto.CertificateDto
import ooo.jtc.documents.BatchSelfUnSign
import ooo.jtc.documents.CheckSmsCodeResponse
import ooo.jtc.documents.DigestResponse
import ooo.jtc.documents.DocHistoryResponseDto
import ooo.jtc.documents.ExecutionTicketDto
import ooo.jtc.documents.GetOwnSignToolsResponse
import ooo.jtc.documents.GetSignApplicability
import ooo.jtc.documents.GetUnSignApplicability
import ooo.jtc.documents.PrepareSmsSignRequest
import ooo.jtc.documents.PrepareSmsSignResponse
import ooo.jtc.documents.ReceiveTicketDto
import ooo.jtc.documents.SignChangeApplicabilityResponse
import ooo.jtc.documents.SignDocumentRequestDto
import ooo.jtc.documents.SignTool
import ooo.jtc.documents.SignatureDto
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.AvailableActionDto
import ooo.jtc.generic.CategoryCountResponse
import ooo.jtc.generic.CategoryDto
import ooo.jtc.generic.CategoryListResponse
import ooo.jtc.generic.Count
import ooo.jtc.generic.DocumentWrapperDto
import ooo.jtc.generic.GenericBatchResponseDto
import ooo.jtc.generic.GenericBatchProcessResponseDto
import ooo.jtc.generic.GenericDto
import ooo.jtc.generic.GenericListResponseDto
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.generic.pageparams.Filter
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.generic.pageparams.toParams
import ooo.jtc.generic.print.ExportByFilterRequestDto
import ooo.jtc.generic.print.ExportByIdsRequestDto
import ooo.jtc.generic.print.PrintByIdsRequestDto
import ooo.jtc.generic.print.PrintExportFormat
import ooo.jtc.generic.print.PrintExportFormatDto
import ooo.jtc.generic.print.PrintParams
import ooo.jtc.generic.print.PrintTableByIdsRequestDto
import ooo.jtc.interfaces.IDocument
import ooo.jtc.interfaces.UpdateIDocument
import ooo.jtc.interfaces.getOrException
import ooo.jtc.serialization.SerializationUtils.constructType
import ooo.jtc.sign.SignToolType
import ooo.jtc.testdata.Service
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.UserCertificate
import ooo.jtc.uaa.User
import java.util.*

/**
 * Base class to implement steps for documents as [IDocument]
 *
 * Extends [AbstractEntitySteps] with same entity
 * @param user as [User]. Steps execute by this use authorization.
 * @param document as [Class] Document's class
 * @param service as [Service]
 *
 */
abstract class AbstractDocumentSteps<T : IDocument, U : UpdateIDocument<T>>(
    user: User,
    service: Service,
    var document: Class<T>
) : AbstractEntitySteps<T, U>(user, service, document) {
    override fun <T, R : GenericDto<T>> requestDtoWrapper(entity: T): DocumentWrapperDto<T> = DocumentWrapperDto(entity)
    private val peFormatResponseType = constructType(GenericListResponseDto::class.java, PrintExportFormatDto::class.java)
    protected val avActionResponseType = constructType(GenericResponseDto::class.java, AvailableActionDto::class.java)
    private val historyResponseType = constructType(GenericListResponseDto::class.java, DocHistoryResponseDto::class.java)
    protected val batchResponseType = constructType(GenericBatchResponseDto::class.java, document)
    protected val batchProcessResponseType = constructType(GenericBatchProcessResponseDto::class.java, document)
    private val signatureResponseType = constructType(GenericListResponseDto::class.java, SignatureDto::class.java)
    private val receiveTicketResponseType = constructType(GenericResponseDto::class.java, ReceiveTicketDto::class.java)
    private val executionTicketResponseType = constructType(GenericResponseDto::class.java, ExecutionTicketDto::class.java)

    protected fun emptyBodyPostRequest(
        postPath: String,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200,
        check: Response.() -> Unit = defaultStatusCheck(withCheckResponseCode, statusCode)
    ): Response {
        return authorizedApi.send(
            method = {
                body("{}")
                post(postPath)
            },
            check = check
        )
    }

    //region Miscellaneous swagger methods
    @Step("Получить презаполненный '{this.entityName}'")
    open fun preFill(withCheckResponseCode: Boolean = true, statusCode: Int = 200): GenericResponseDto<T> {
        return emptyBodyPostRequest("$servicePath/PreFill", withCheckResponseCode, statusCode)
            .responseAs(responseType)
    }

    @Step("Проверить документ '{this.entityName}'")
    open fun checkDocument(documentDto: T, withCheckResponseCode: Boolean = true, statusCode: Int = 200)
            : GenericResponseDto<T> {
        return authorizedApi.send(
            method = {
                body(requestDtoWrapper(documentDto))
                post("$servicePath/CheckDocument")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = statusCode)
        ).responseAs(responseType)
    }

    @Step("Создать без проверки реквизитов (создать черновик) '{this.entityName}'")
    open fun createWithoutCheck(
        entity: T,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericResponseDto<T> {
        return stepApi.send(
            method = {
                body(requestDtoWrapper(entity))
                post("$servicePath/CreateWithoutCheck")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseType)
    }

    @Step("Изменить без проверки реквизитов (сделать черновиком) '{this.entityName}' с id = [{entity.id}]")
    open fun updateWithoutCheck(
        entity: U,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericResponseDto<T> {
        return stepApi.send(
            method = {
                body(requestDtoWrapper(entity))
                post("$servicePath/UpdateWithoutCheck")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseType)
    }

    @Step("Отправить документ '{this.entityName}' [{documentId}]")
    open fun send(documentId: UUID, withCheckResponseCode: Boolean = true): GenericResponseDto<T> {
        return authorizedApi.send(
            method = {
                body(mapOf("id" to documentId))
                post("$servicePath/Send")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(responseType)
    }

    @Step("Получить историю документа '{this.entityName}' id = [{documentId}] [{this.user.userType}]")
    open fun getHistory(documentId: UUID, withCheckResponseCode: Boolean = true)
            : GenericListResponseDto<DocHistoryResponseDto> {
        return authorizedApi.send(
            method = {
                body(mapOf("documentId" to documentId))
                post("$servicePath/GetHistory")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(historyResponseType)
    }

    @Step("Копировать '{this.entityName}' [{documentId}]")
    open fun copy(documentId: UUID, withCheckResponseCode: Boolean = true): GenericResponseDto<T> {
        return stepApi.send(
            method = {
                body("""{"id":"$documentId"}""")
                post("$servicePath/Copy")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(responseType)
    }
    //endregion

    //region Categories swagger methods
    @Step("Получить количество документов '{this.entityName}' по предоставленному фильтру")
    open fun getCount(filter: Filter, withCheckResponseCode: Boolean = true): Count {
        return stepApi.send(
            method = {
                body(mapOf("filter" to filter))
                post("$servicePath/GetCount")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(Count::class.java)
    }

    @Step("Получить количество документов в разрезе доступных категорий [{this.user.userType}]")
    open fun getCategoriesCounts(withCheckResponseCode: Boolean = true): GenericDto<Map<String, Int>> {
        return emptyBodyPostRequest("$servicePath/GetCategories", withCheckResponseCode)
            .responseAs(CategoryCountResponse::class.java)
    }

    @Step("Получить список доступных категорий [{this.user.userType}]")
    open fun getCategoriesList(withCheckResponseCode: Boolean = true): GenericDto<List<CategoryDto>> {
        return emptyBodyPostRequest("$servicePath/GetCategoriesList", withCheckResponseCode)
            .responseAs(CategoryListResponse::class.java)
    }
    //endregion

    //region Sign-related swagger methods
    @Step("Получить подписи под документом {this.entityName} [{documentId}]")
    open fun getSignatures(documentId: UUID, withCheckResponseCode: Boolean = true): GenericListResponseDto<SignatureDto> {
        return authorizedApi.send(
            method = {
                body("""{"documentId":"$documentId"}""")
                post("$servicePath/GetSignatures")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(signatureResponseType)
    }

    @Step("Проверить, могут ли документы [{documentsIds}] быть подписаны")
    open fun getSignApplicability(vararg documentsIds: UUID, withCheckResponseCode: Boolean = true)
            : SignChangeApplicabilityResponse {
        return authorizedApi.send(
            method = {
                body(GetSignApplicability(documents = documentsIds.toList()))
                post("$servicePath/GetSignApplicability")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(SignChangeApplicabilityResponse::class.java)
    }

    @Step("Проверить, можно ли с документов [{documentsIds}] снять свою подпись")
    open fun getSelfUnSignApplicability(vararg documentsIds: UUID, withCheckResponseCode: Boolean = true)
            : SignChangeApplicabilityResponse {
        return authorizedApi.send(
            method = {
                body(GetUnSignApplicability(documents = documentsIds.toList()))
                post("$servicePath/GetSelfUnSignApplicability")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(SignChangeApplicabilityResponse::class.java)
    }

    @Step("Проверить, можно ли с документов [{documentsIds}] снять любую подпись")
    open fun getAllUnSignApplicability(vararg documentsIds: UUID, withCheckResponseCode: Boolean = true)
            : SignChangeApplicabilityResponse {
        return authorizedApi.send(
            method = {
                body(GetUnSignApplicability(documents = documentsIds.toList()))
                post("$servicePath/GetAllUnSignApplicability")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(SignChangeApplicabilityResponse::class.java)
    }

    @Step("Получить средства подписи текущего пользователя ({this.user.login})")
    open fun getOwnSignTools(withCheckResponseCode: Boolean = true): GetOwnSignToolsResponse {
        val signServicePath = Services.SIGN.baseEndpoint
        return emptyBodyPostRequest("$signServicePath/signtool/GetOwnSignTools", withCheckResponseCode)
            .responseAs(GetOwnSignToolsResponse::class.java)
    }

    @Step("Подготовить СМС средство подписи [{signToolId}] для подписи документов [{documentsIds}]")
    open fun prepareSmsSign(
        vararg documentsIds: UUID,
        signToolId: UUID,
        withCheckResponseCode: Boolean = true
    ): PrepareSmsSignResponse {
        return authorizedApi.send(
            method = {
                body(PrepareSmsSignRequest(ids = documentsIds.toList(), signToolId = signToolId))
                post("$servicePath/PrepareSmsSign")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(PrepareSmsSignResponse::class.java)
    }

    @Step("Подтвердить подпись СМС-кодом {code}")
    open fun checkSmsCode(
        smsCodeId: UUID,
        code: String = SMS_CODE_FOR_SIGN_DOCUMENTS,
        withCheckResponseCode: Boolean = true
    ): CheckSmsCodeResponse {
        return authorizedApi.send(
            method = {
                body(mapOf("id" to smsCodeId, "code" to code))
                post("$servicePath/CheckSmsCode")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(CheckSmsCodeResponse::class.java)
    }

    @Step("Вычислить дайджест документа [{documentId}]")
    open fun makeDigest(documentId: UUID, withCheckResponseCode: Boolean = true): DigestResponse {
        return authorizedApi.send(
            method = {
                body("""{"id" : "$documentId"}""")
                post("$servicePath/MakeDigest")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(DigestResponse::class.java)
    }

    @Step("Отправить запрос на подпись")
    open fun sign(
        signDocumentRequestDto: SignDocumentRequestDto,
        withCheckResponseCode: Boolean = true
    ): GenericResponseDto<T> {
        return authorizedApi.send(
            method = {
                body(signDocumentRequestDto)
                post("$servicePath/Sign")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(responseType)
    }

    @Step("Снять с документа '{this.entityName}' [{documentId}] подпись [{signatureId}]")
    fun unSign(documentId: UUID, signatureId: UUID, withCheckResponseCode: Boolean = true): GenericResponseDto<T> {
        return authorizedApi.send(
            method = {
                body(mapOf("documentId" to documentId, "signatureId" to signatureId))
                post("$servicePath/UnSign")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(responseType)
    }

    @Step("Снять с документа '{this.entityName}' свою подпись")
    fun batchSelfUnSign(vararg documentsIds: UUID, withCheckResponseCode: Boolean = true): GenericBatchProcessResponseDto<T> {
        return authorizedApi.send(
            method = {
                body(BatchSelfUnSign(documents = documentsIds.toList()))
                post("$servicePath/BatchSelfUnSign")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(batchProcessResponseType)
    }
    //endregion

    //region Print swagger methods
    @Step("Получить доступные форматы печати документа '{this.entityName}'")
    open fun getAvailablePrintFormat(withCheckResponseCode: Boolean = true): GenericListResponseDto<PrintExportFormatDto> {
        return emptyBodyPostRequest("$servicePath/AvailablePrintFormat", withCheckResponseCode)
            .responseAs(peFormatResponseType)
    }

    @Step("Печать одного документа '{this.entityName}' по id [{id}] (формат '{format}'; параметры '{params}')")
    open fun printById(
        id: UUID, format: PrintExportFormat, params: PrintParams = PrintParams(),
        withCheckResponseCode: Boolean = true
    ): Response {
        return printById(PrintByIdsRequestDto(ids = listOf(id), format = format, params = params), withCheckResponseCode)
    }

    @Step("Печать списка документов '{this.entityName}' по id (формат '{format}'; параметры '{params}')")
    open fun printById(
        ids: List<UUID>, format: PrintExportFormat, params: PrintParams = PrintParams(),
        withCheckResponseCode: Boolean = true
    ): Response {
        return printById(PrintByIdsRequestDto(ids = ids, format = format, params = params), withCheckResponseCode)
    }

    private fun printById(printRequest: PrintByIdsRequestDto, withCheckResponseCode: Boolean = true): Response {
        return stepApi.send(
            method = {
                body(printRequest)
                post("$servicePath/PrintById")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        )
    }


    @Step("Получить доступные форматы печати списка документов '{this.entityName}'")
    open fun getAvailablePrintTableFormat(withCheckResponseCode: Boolean = true): GenericListResponseDto<PrintExportFormatDto> {
        return emptyBodyPostRequest("$servicePath/AvailablePrintTableFormat", withCheckResponseCode)
            .responseAs(peFormatResponseType)
    }

    @Step("Печать реестра документов '{this.entityName}' по id (формат '{format}')")
    open fun printTableById(
        ids: List<UUID>, format: PrintExportFormat,
        withCheckResponseCode: Boolean = true
    ): Response {
        val printTableRequest = PrintTableByIdsRequestDto(ids = ids, format = format)
        return stepApi.send(
            method = {
                body(printTableRequest)
                post("$servicePath/PrintTableById")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        )
    }
    //endregion

    //region Export swagger methods
    @Step("Получить доступные форматы экспорта документа '{this.entityName}'")
    open fun getAvailableExportFormat(withCheckResponseCode: Boolean = true): GenericListResponseDto<PrintExportFormatDto> {
        return emptyBodyPostRequest("$servicePath/AvailableExportFormat", withCheckResponseCode)
            .responseAs(peFormatResponseType)
    }

    @Step("Экспорт одного документа '{this.entityName}' по id [{id}] в формате '{format}'")
    open fun exportById(id: UUID, format: PrintExportFormat, withCheckResponseCode: Boolean = true): Response {
        return exportById(ExportByIdsRequestDto(ids = listOf(id), format = format), withCheckResponseCode)
    }

    @Step("Экспорт списка документов '{this.entityName}' по id в формате '{format}'")
    open fun exportById(ids: List<UUID>, format: PrintExportFormat, withCheckResponseCode: Boolean = true): Response {
        return exportById(ExportByIdsRequestDto(ids = ids, format = format), withCheckResponseCode)
    }

    private fun exportById(exportRequest: ExportByIdsRequestDto, withCheckResponseCode: Boolean = true): Response {
        return stepApi.send(
            method = {
                body(exportRequest)
                post("$servicePath/ExportById")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        )
    }

    open fun exportByFilter(params: Params, format: PrintExportFormat, withCheckResponseCode: Boolean = true): Response {
        return exportByFilter(ExportByFilterRequestDto(params = params, format = format))
    }

    open fun exportByFilter(filter: Filter, format: PrintExportFormat, withCheckResponseCode: Boolean = true): Response {
        return exportByFilter(ExportByFilterRequestDto(params = filter.toParams(), format = format))
    }

    @Step("Экспорт списка документов '{this.entityName}' по фильтру")
    open fun exportByFilter(exportRequest: ExportByFilterRequestDto, withCheckResponseCode: Boolean = true): Response {
        return stepApi.send(
            method = {
                body(exportRequest)
                post("$servicePath/ExportByFilter")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        )
    }
    //endregion

    //region Ticket swagger methods
    @Step("Получить квиток о приёме '{this.entityName}' [{documentId}]")
    open fun getReceiveTicket(documentId: UUID): GenericResponseDto<ReceiveTicketDto> {
        return stepApi.send(
            method = {
                body("""{"docId":"$documentId"}""")
                post("$servicePath/GetReceiveTicket")
            }
        ).responseAs(receiveTicketResponseType)
    }

    @Step("Получить квиток об исполнении '{this.entityName}' [{documentId}]")
    open fun getExecutionTicket(documentId: UUID): GenericResponseDto<ExecutionTicketDto> {
        return stepApi.send(
            method = {
                body("""{"docId":"$documentId"}""")
                post("$servicePath/GetExecutionTicket")
            }
        ).responseAs(executionTicketResponseType)
    }
    //endregion

    //region Non-swagger signing methods
    open fun getDocSignaturesList(documentId: UUID, withCheckResponseCode: Boolean = true): List<SignatureDto> {
        return getSignatures(documentId, withCheckResponseCode)
            .list.getOrException("Ошибка при получении подписей документа")
    }

    @Step("Подготовить данные для подписи документа {this.entityName} [{document.id}] по СМС")
    open fun prepareSmsSignDocumentRequest(document: T, withCheckResponseCode: Boolean = true): SignDocumentRequestDto {
        val documentId = document.id!!

        //Check is document could be signed
        val signApplicabilityResponse = getSignApplicability(documentId, withCheckResponseCode = withCheckResponseCode)
        if (signApplicabilityResponse.nonApplicable.contains(documentId))
            throw RuntimeException("Document [$documentId] couldn't be signed")

        //Get active sign tools for current user
        val getActiveSignTools = getOwnSignTools(withCheckResponseCode)
        val signToolIdForSmsSigning =
            getActiveSignTools.list.find { it.toolType == "Sms" }?.id
                ?: throw RuntimeException("User ${user.login} has no sign tools for sms signing")

        //Prepare sms signing
        val prepareSmsSignResponse = prepareSmsSign(
            documentId,
            signToolId = signToolIdForSmsSigning,
            withCheckResponseCode = withCheckResponseCode
        )

        //Check sms code for signing. By default sms code = 0000
        val checkSmsCodeResponse = checkSmsCode(
            smsCodeId = prepareSmsSignResponse.data.codeId,
            withCheckResponseCode = withCheckResponseCode
        )

        //Create document digest for signing
        val digest = makeDigest(documentId)

        val signature = checkSmsCodeResponse.list.find { it.documentId == document.id }?.signature
        return SignDocumentRequestDto(
            digest = digest.digest.value,
            signToolId = signToolIdForSmsSigning,
            signToolRef = null,
            version = 1L,
            documentId = document.id!!,
            signature = signature!!
        )
    }

    @Step("Подготовить данные для подписи документа {this.entityName} [{document.id}] по сертификату [{certThumbprint}]")
    open fun prepareCertificateSignDocumentRequest(
        document: T,
        certThumbprint: String? = null,
        withCheckResponseCode: Boolean = true
    ): SignDocumentRequestDto {
        val documentId = document.id!!

        //Check if document could be signed
        val signApplicabilityResponse = getSignApplicability(documentId, withCheckResponseCode = withCheckResponseCode)
        if (signApplicabilityResponse.nonApplicable.contains(documentId))
            throw RuntimeException("Document [$documentId] couldn't be signed")

        //Get active sign tools for current user
        val getActiveSignTools = getOwnSignTools(withCheckResponseCode)
        val signToolListForCryptoSigning =
            getActiveSignTools.list.filter { it.toolType == SignToolType.CRYPTO.type }
        if (signToolListForCryptoSigning.isEmpty())
            throw RuntimeException("User ${user.login} has no sign tools for certificate signing")

        //Get certificate (by thumbprint, if provided)
        val certificateId: UUID
        val certificate: CertificateDto
        val thumbprint: String
        val signToolForCryptoSigning: SignTool
        if (null == certThumbprint) {
            signToolForCryptoSigning = signToolListForCryptoSigning.first()
            certificateId = signToolForCryptoSigning.refId!!
            certificate = CertificateSteps(user).getById(certificateId)
                .data.getOrException("Encountered error when getting '${user.login}'s certificate by id")
            thumbprint = certificate.thumbprint
        } else {
            thumbprint = certThumbprint
            certificate = CertificatePrepareSteps.getCertificateByThumbprint(user, certThumbprint)
            certificateId = certificate.id!!
            signToolForCryptoSigning = signToolListForCryptoSigning
                .find { it.refId!! == certificateId }
                ?: throw RuntimeException("User '${user.login}' has no (active) signTool with certificate [$certificateId]")
        }

        //Create document digest for signing
        val digest = makeDigest(documentId)
        val digestToSign = digest.digest.value

        val signature = CryptoPluginStubSteps().signString(thumbprint, digestToSign)
        return SignDocumentRequestDto(
            digest = digest.digest.value,
            signToolId = signToolForCryptoSigning.id,
            signToolRef = certificateId,
            version = 1L,
            documentId = document.id!!,
            signature = signature
        )
    }

    @Step("Подписать документ {this.entityName} [{document.id}], используя смс код")
    open fun signDocumentBySms(document: T, withCheckResponseCode: Boolean = true): GenericResponseDto<T> {
        val signDocumentRequestDto = prepareSmsSignDocumentRequest(document, withCheckResponseCode)

        //Sign document
        val signResponse = sign(signDocumentRequestDto).data!!
        return getById(signResponse.id!!)
    }

    @Step("Подписать документ {this.entityName} [{document.id}] сертификатом")
    open fun signDocumentByCertificate(document: T, withCheckResponseCode: Boolean = true): GenericResponseDto<T> {
        val existingUserCertificates = UserCertificate.getCertFilesByUser(user)
            .map { certFile -> CertificatePrepareSteps.getCertificateDtoByFilePath(x509CertFile = certFile) }
        val certificateForSigning = existingUserCertificates.random()
        /* Sergeyev [2021.07.14]:
         * 'random()' is wrong! If there is more than 1 certificate, we can end up with inactive certificate / signTool,
         * and that will lead to an undesired error
         */
        //TODO Sergeyev [2021.07.14]: take existing VALID certificate

        val signDocumentRequestDto = prepareCertificateSignDocumentRequest(document, certificateForSigning.thumbprint, withCheckResponseCode)

        //Sign document
        val signResponse = sign(signDocumentRequestDto).data!!
        return getById(signResponse.id!!)
    }

    /* TODO Sergeyev [2020.11.12]: this
    @Step(
        "Снять подпись [{signatureId}] с документа {this.entityName} [{document.id}]," +
                " предварительно проверив доступность этого действия"
    )
    open fun unSignDocument(document: T, signatureId: UUID, withCheckResponseCode: Boolean = true): GenericResponseDto<T> {
        val documentId = document.id!!

        //Check if document's signature can be removed
        val unSignApplicabilityResp = getSelfUnSignApplicability(documentId, withCheckResponseCode = withCheckResponseCode)
        if (unSignApplicabilityResp.nonApplicable.contains(documentId))
            throw RuntimeException("User ${user.login} can't remove signature from document [$documentId]")

        //Remove signature
        val unSignResponse = unSign(documentId, signatureId, withCheckResponseCode).data!!
        return getById(unSignResponse.id!!)
    }*/

    @Step("Снять свою подпись с документа {this.entityName} [{document.id}], предварительно проверив доступность этого действия")
    open fun selfUnSignDocument(document: T, withCheckResponseCode: Boolean = true): GenericResponseDto<T> {
        val documentId = document.id!!

        //Check if document's signature can be removed
        val unSignApplicabilityResp = getSelfUnSignApplicability(documentId, withCheckResponseCode = withCheckResponseCode)
        if (unSignApplicabilityResp.nonApplicable.contains(documentId))
            throw RuntimeException("User ${user.login} can't remove signature from document [$documentId]")

        //Remove signature
        val unSignResponse = batchSelfUnSign(documentId, withCheckResponseCode = withCheckResponseCode)
            .documentResults!![0].dto!!
        return getById(unSignResponse.id!!)
    }
    //endregion

    //region Non-swagger printing methods
    @Step("Извлечь из ответа наименование файла")
    open fun getFileNameFromResponse(fileResponse: Response): String {
        return fileResponse.headers["Content-Disposition"].value
            .substringAfter("filename=").removeSurrounding("\"")
    }
    //endregion
}