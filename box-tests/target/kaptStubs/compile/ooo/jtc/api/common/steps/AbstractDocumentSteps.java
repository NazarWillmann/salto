package ooo.jtc.api.common.steps;

import java.lang.System;

/**
 * Base class to implement steps for documents as [IDocument]
 *
 * Extends [AbstractEntitySteps] with same entity
 * @param user as [User]. Steps execute by this use authorization.
 * @param document as [Class] Document's class
 * @param service as [Service]
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00a0\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B#\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u00a2\u0006\u0002\u0010\fJ1\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!\"\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007\u00a2\u0006\u0002\u0010%J/\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\'2\u0006\u0010(\u001a\u00028\u00002\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010)\u001a\u00020*H\u0017\u00a2\u0006\u0002\u0010+J$\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\"2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010#\u001a\u00020$H\u0017J \u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\'2\u0006\u00102\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0017J/\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\'2\u0006\u00104\u001a\u00028\u00002\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010)\u001a\u00020*H\u0017\u00a2\u0006\u0002\u0010+J?\u00105\u001a\u0002062\u0006\u00107\u001a\u0002002\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010)\u001a\u00020*2\u0019\b\u0002\u00108\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020:09\u00a2\u0006\u0002\b;H\u0004J\"\u0010<\u001a\u0002062\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\b\b\u0002\u0010#\u001a\u00020$H\u0016J\"\u0010<\u001a\u0002062\u0006\u0010A\u001a\u00020B2\u0006\u0010?\u001a\u00020@2\b\b\u0002\u0010#\u001a\u00020$H\u0016J\u001a\u0010<\u001a\u0002062\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010#\u001a\u00020$H\u0017J\"\u0010E\u001a\u0002062\u0006\u0010F\u001a\u00020\"2\u0006\u0010?\u001a\u00020@2\b\b\u0002\u0010#\u001a\u00020$H\u0017J(\u0010E\u001a\u0002062\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\"0H2\u0006\u0010?\u001a\u00020@2\b\b\u0002\u0010#\u001a\u00020$H\u0017J\u001a\u0010E\u001a\u0002062\u0006\u0010C\u001a\u00020I2\b\b\u0002\u0010#\u001a\u00020$H\u0002J+\u0010J\u001a\u00020K2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!\"\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0017\u00a2\u0006\u0002\u0010LJ\u0018\u0010M\u001a\b\u0012\u0004\u0012\u00020O0N2\b\b\u0002\u0010#\u001a\u00020$H\u0017J\u0018\u0010P\u001a\b\u0012\u0004\u0012\u00020O0N2\b\b\u0002\u0010#\u001a\u00020$H\u0017J\u0018\u0010Q\u001a\b\u0012\u0004\u0012\u00020O0N2\b\b\u0002\u0010#\u001a\u00020$H\u0017J$\u0010R\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020*0T0S2\b\b\u0002\u0010#\u001a\u00020$H\u0017J\u001e\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0H0S2\b\b\u0002\u0010#\u001a\u00020$H\u0017J\u001a\u0010W\u001a\u00020X2\u0006\u0010=\u001a\u00020>2\b\b\u0002\u0010#\u001a\u00020$H\u0017J \u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0H2\u0006\u00102\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0016J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0\'2\u0006\u00102\u001a\u00020\"H\u0017J\u0010\u0010]\u001a\u0002002\u0006\u0010^\u001a\u000206H\u0017J \u0010_\u001a\b\u0012\u0004\u0012\u00020`0N2\u0006\u00102\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0017J\u0012\u0010a\u001a\u00020b2\b\b\u0002\u0010#\u001a\u00020$H\u0017J\u0016\u0010c\u001a\b\u0012\u0004\u0012\u00020d0\'2\u0006\u00102\u001a\u00020\"H\u0017J+\u0010e\u001a\u00020K2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!\"\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0017\u00a2\u0006\u0002\u0010LJ+\u0010f\u001a\u00020K2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!\"\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0017\u00a2\u0006\u0002\u0010LJ \u0010g\u001a\b\u0012\u0004\u0012\u00020Z0N2\u0006\u00102\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0017J\u001a\u0010h\u001a\u00020i2\u0006\u00102\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0017J\"\u0010j\u001a\b\u0012\u0004\u0012\u00028\u00000\'2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010)\u001a\u00020*H\u0017J+\u0010k\u001a\u00020l2\u0006\u0010\n\u001a\u00028\u00002\n\b\u0002\u0010m\u001a\u0004\u0018\u0001002\b\b\u0002\u0010#\u001a\u00020$H\u0017\u00a2\u0006\u0002\u0010nJ3\u0010o\u001a\u00020p2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!\"\u00020\"2\u0006\u0010q\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0017\u00a2\u0006\u0002\u0010rJ\u001f\u0010s\u001a\u00020l2\u0006\u0010\n\u001a\u00028\u00002\b\b\u0002\u0010#\u001a\u00020$H\u0017\u00a2\u0006\u0002\u0010tJ,\u0010u\u001a\u0002062\u0006\u0010F\u001a\u00020\"2\u0006\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020v2\b\b\u0002\u0010#\u001a\u00020$H\u0017J2\u0010u\u001a\u0002062\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\"0H2\u0006\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020v2\b\b\u0002\u0010#\u001a\u00020$H\u0017J\u001a\u0010u\u001a\u0002062\u0006\u0010w\u001a\u00020x2\b\b\u0002\u0010#\u001a\u00020$H\u0002J(\u0010y\u001a\u0002062\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\"0H2\u0006\u0010?\u001a\u00020@2\b\b\u0002\u0010#\u001a\u00020$H\u0017J1\u0010z\u001a\b\u0012\u0004\u0012\u0002H\u00010{\"\u0004\b\u0002\u0010\u0001\"\u000e\b\u0003\u0010|*\b\u0012\u0004\u0012\u0002H\u00010S2\u0006\u00104\u001a\u0002H\u0001H\u0016\u00a2\u0006\u0002\u0010}J%\u0010~\u001a\b\u0012\u0004\u0012\u00028\u00000\'2\u0006\u0010\n\u001a\u00028\u00002\b\b\u0002\u0010#\u001a\u00020$H\u0017\u00a2\u0006\u0002\u0010\u007fJ!\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\'2\u0006\u00102\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0017J\"\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\'2\u0007\u0010\u0082\u0001\u001a\u00020l2\b\b\u0002\u0010#\u001a\u00020$H\u0017J&\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\'2\u0006\u0010\n\u001a\u00028\u00002\b\b\u0002\u0010#\u001a\u00020$H\u0017\u00a2\u0006\u0002\u0010\u007fJ&\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\'2\u0006\u0010\n\u001a\u00028\u00002\b\b\u0002\u0010#\u001a\u00020$H\u0017\u00a2\u0006\u0002\u0010\u007fJ*\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\'2\u0006\u00102\u001a\u00020\"2\u0007\u0010\u0086\u0001\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007J1\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\'2\u0006\u00104\u001a\u00028\u00012\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010)\u001a\u00020*H\u0017\u00a2\u0006\u0003\u0010\u0088\u0001R\u0014\u0010\r\u001a\u00020\u000eX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000eX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000eX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0089\u0001"}, d2 = {"Looo/jtc/api/common/steps/AbstractDocumentSteps;", "T", "Looo/jtc/interfaces/IDocument;", "U", "Looo/jtc/interfaces/UpdateIDocument;", "Looo/jtc/api/common/steps/AbstractEntitySteps;", "user", "Looo/jtc/uaa/User;", "service", "Looo/jtc/testdata/Service;", "document", "Ljava/lang/Class;", "(Looo/jtc/uaa/User;Looo/jtc/testdata/Service;Ljava/lang/Class;)V", "avActionResponseType", "Lcom/fasterxml/jackson/databind/JavaType;", "getAvActionResponseType", "()Lcom/fasterxml/jackson/databind/JavaType;", "batchProcessResponseType", "getBatchProcessResponseType", "batchResponseType", "getBatchResponseType", "getDocument", "()Ljava/lang/Class;", "setDocument", "(Ljava/lang/Class;)V", "executionTicketResponseType", "historyResponseType", "peFormatResponseType", "receiveTicketResponseType", "signatureResponseType", "batchSelfUnSign", "Looo/jtc/generic/GenericBatchProcessResponseDto;", "documentsIds", "", "Ljava/util/UUID;", "withCheckResponseCode", "", "([Ljava/util/UUID;Z)Looo/jtc/generic/GenericBatchProcessResponseDto;", "checkDocument", "Looo/jtc/generic/GenericResponseDto;", "documentDto", "statusCode", "", "(Looo/jtc/interfaces/IDocument;ZI)Looo/jtc/generic/GenericResponseDto;", "checkSmsCode", "Looo/jtc/documents/CheckSmsCodeResponse;", "smsCodeId", "code", "", "copy", "documentId", "createWithoutCheck", "entity", "emptyBodyPostRequest", "Lio/restassured/response/Response;", "postPath", "check", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "exportByFilter", "filter", "Looo/jtc/generic/pageparams/Filter;", "format", "Looo/jtc/generic/print/PrintExportFormat;", "params", "Looo/jtc/generic/pageparams/Params;", "exportRequest", "Looo/jtc/generic/print/ExportByFilterRequestDto;", "exportById", "id", "ids", "", "Looo/jtc/generic/print/ExportByIdsRequestDto;", "getAllUnSignApplicability", "Looo/jtc/documents/SignChangeApplicabilityResponse;", "([Ljava/util/UUID;Z)Looo/jtc/documents/SignChangeApplicabilityResponse;", "getAvailableExportFormat", "Looo/jtc/generic/GenericListResponseDto;", "Looo/jtc/generic/print/PrintExportFormatDto;", "getAvailablePrintFormat", "getAvailablePrintTableFormat", "getCategoriesCounts", "Looo/jtc/generic/GenericDto;", "", "getCategoriesList", "Looo/jtc/generic/CategoryDto;", "getCount", "Looo/jtc/generic/Count;", "getDocSignaturesList", "Looo/jtc/documents/SignatureDto;", "getExecutionTicket", "Looo/jtc/documents/ExecutionTicketDto;", "getFileNameFromResponse", "fileResponse", "getHistory", "Looo/jtc/documents/DocHistoryResponseDto;", "getOwnSignTools", "Looo/jtc/documents/GetOwnSignToolsResponse;", "getReceiveTicket", "Looo/jtc/documents/ReceiveTicketDto;", "getSelfUnSignApplicability", "getSignApplicability", "getSignatures", "makeDigest", "Looo/jtc/documents/DigestResponse;", "preFill", "prepareCertificateSignDocumentRequest", "Looo/jtc/documents/SignDocumentRequestDto;", "certThumbprint", "(Looo/jtc/interfaces/IDocument;Ljava/lang/String;Z)Looo/jtc/documents/SignDocumentRequestDto;", "prepareSmsSign", "Looo/jtc/documents/PrepareSmsSignResponse;", "signToolId", "([Ljava/util/UUID;Ljava/util/UUID;Z)Looo/jtc/documents/PrepareSmsSignResponse;", "prepareSmsSignDocumentRequest", "(Looo/jtc/interfaces/IDocument;Z)Looo/jtc/documents/SignDocumentRequestDto;", "printById", "Looo/jtc/generic/print/PrintParams;", "printRequest", "Looo/jtc/generic/print/PrintByIdsRequestDto;", "printTableById", "requestDtoWrapper", "Looo/jtc/generic/DocumentWrapperDto;", "R", "(Ljava/lang/Object;)Looo/jtc/generic/DocumentWrapperDto;", "selfUnSignDocument", "(Looo/jtc/interfaces/IDocument;Z)Looo/jtc/generic/GenericResponseDto;", "send", "sign", "signDocumentRequestDto", "signDocumentByCertificate", "signDocumentBySms", "unSign", "signatureId", "updateWithoutCheck", "(Looo/jtc/interfaces/UpdateIDocument;ZI)Looo/jtc/generic/GenericResponseDto;", "box-tests"})
public abstract class AbstractDocumentSteps<T extends ooo.jtc.interfaces.IDocument, U extends ooo.jtc.interfaces.UpdateIDocument<T>> extends ooo.jtc.api.common.steps.AbstractEntitySteps<T, U> {
    private final com.fasterxml.jackson.databind.JavaType peFormatResponseType = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fasterxml.jackson.databind.JavaType avActionResponseType = null;
    private final com.fasterxml.jackson.databind.JavaType historyResponseType = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fasterxml.jackson.databind.JavaType batchResponseType = null;
    @org.jetbrains.annotations.NotNull()
    private final com.fasterxml.jackson.databind.JavaType batchProcessResponseType = null;
    private final com.fasterxml.jackson.databind.JavaType signatureResponseType = null;
    private final com.fasterxml.jackson.databind.JavaType receiveTicketResponseType = null;
    private final com.fasterxml.jackson.databind.JavaType executionTicketResponseType = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.Class<T> document;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public <T extends java.lang.Object, R extends ooo.jtc.generic.GenericDto<T>>ooo.jtc.generic.DocumentWrapperDto<T> requestDtoWrapper(T entity) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.fasterxml.jackson.databind.JavaType getAvActionResponseType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.fasterxml.jackson.databind.JavaType getBatchResponseType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.fasterxml.jackson.databind.JavaType getBatchProcessResponseType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final io.restassured.response.Response emptyBodyPostRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String postPath, boolean withCheckResponseCode, int statusCode, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super io.restassured.response.Response, kotlin.Unit> check) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u043f\u0440\u0435\u0437\u0430\u043f\u043e\u043b\u043d\u0435\u043d\u043d\u044b\u0439 \'{this.entityName}\'")
    public ooo.jtc.generic.GenericResponseDto<T> preFill(boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \'{this.entityName}\'")
    public ooo.jtc.generic.GenericResponseDto<T> checkDocument(@org.jetbrains.annotations.NotNull()
    T documentDto, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0431\u0435\u0437 \u043f\u0440\u043e\u0432\u0435\u0440\u043a\u0438 \u0440\u0435\u043a\u0432\u0438\u0437\u0438\u0442\u043e\u0432 (\u0441\u043e\u0437\u0434\u0430\u0442\u044c \u0447\u0435\u0440\u043d\u043e\u0432\u0438\u043a) \'{this.entityName}\'")
    public ooo.jtc.generic.GenericResponseDto<T> createWithoutCheck(@org.jetbrains.annotations.NotNull()
    T entity, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0418\u0437\u043c\u0435\u043d\u0438\u0442\u044c \u0431\u0435\u0437 \u043f\u0440\u043e\u0432\u0435\u0440\u043a\u0438 \u0440\u0435\u043a\u0432\u0438\u0437\u0438\u0442\u043e\u0432 (\u0441\u0434\u0435\u043b\u0430\u0442\u044c \u0447\u0435\u0440\u043d\u043e\u0432\u0438\u043a\u043e\u043c) \'{this.entityName}\' \u0441 id = [{entity.id}]")
    public ooo.jtc.generic.GenericResponseDto<T> updateWithoutCheck(@org.jetbrains.annotations.NotNull()
    U entity, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041e\u0442\u043f\u0440\u0430\u0432\u0438\u0442\u044c \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \'{this.entityName}\' [{documentId}]")
    public ooo.jtc.generic.GenericResponseDto<T> send(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0438\u0441\u0442\u043e\u0440\u0438\u044e \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \'{this.entityName}\' id = [{documentId}] [{this.user.userType}]")
    public ooo.jtc.generic.GenericListResponseDto<ooo.jtc.documents.DocHistoryResponseDto> getHistory(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041a\u043e\u043f\u0438\u0440\u043e\u0432\u0430\u0442\u044c \'{this.entityName}\' [{documentId}]")
    public ooo.jtc.generic.GenericResponseDto<T> copy(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u043a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432 \'{this.entityName}\' \u043f\u043e \u043f\u0440\u0435\u0434\u043e\u0441\u0442\u0430\u0432\u043b\u0435\u043d\u043d\u043e\u043c\u0443 \u0444\u0438\u043b\u044c\u0442\u0440\u0443")
    public ooo.jtc.generic.Count getCount(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.Filter filter, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u043a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432 \u0432 \u0440\u0430\u0437\u0440\u0435\u0437\u0435 \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0445 \u043a\u0430\u0442\u0435\u0433\u043e\u0440\u0438\u0439 [{this.user.userType}]")
    public ooo.jtc.generic.GenericDto<java.util.Map<java.lang.String, java.lang.Integer>> getCategoriesCounts(boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u043f\u0438\u0441\u043e\u043a \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0445 \u043a\u0430\u0442\u0435\u0433\u043e\u0440\u0438\u0439 [{this.user.userType}]")
    public ooo.jtc.generic.GenericDto<java.util.List<ooo.jtc.generic.CategoryDto>> getCategoriesList(boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u043f\u043e\u0434\u043f\u0438\u0441\u0438 \u043f\u043e\u0434 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u043c {this.entityName} [{documentId}]")
    public ooo.jtc.generic.GenericListResponseDto<ooo.jtc.documents.SignatureDto> getSignatures(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u043c\u043e\u0433\u0443\u0442 \u043b\u0438 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u044b [{documentsIds}] \u0431\u044b\u0442\u044c \u043f\u043e\u0434\u043f\u0438\u0441\u0430\u043d\u044b")
    public ooo.jtc.documents.SignChangeApplicabilityResponse getSignApplicability(@org.jetbrains.annotations.NotNull()
    java.util.UUID[] documentsIds, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u043c\u043e\u0436\u043d\u043e \u043b\u0438 \u0441 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432 [{documentsIds}] \u0441\u043d\u044f\u0442\u044c \u0441\u0432\u043e\u044e \u043f\u043e\u0434\u043f\u0438\u0441\u044c")
    public ooo.jtc.documents.SignChangeApplicabilityResponse getSelfUnSignApplicability(@org.jetbrains.annotations.NotNull()
    java.util.UUID[] documentsIds, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u043c\u043e\u0436\u043d\u043e \u043b\u0438 \u0441 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432 [{documentsIds}] \u0441\u043d\u044f\u0442\u044c \u043b\u044e\u0431\u0443\u044e \u043f\u043e\u0434\u043f\u0438\u0441\u044c")
    public ooo.jtc.documents.SignChangeApplicabilityResponse getAllUnSignApplicability(@org.jetbrains.annotations.NotNull()
    java.util.UUID[] documentsIds, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u0440\u0435\u0434\u0441\u0442\u0432\u0430 \u043f\u043e\u0434\u043f\u0438\u0441\u0438 \u0442\u0435\u043a\u0443\u0449\u0435\u0433\u043e \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044f ({this.user.login})")
    public ooo.jtc.documents.GetOwnSignToolsResponse getOwnSignTools(boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u0421\u041c\u0421 \u0441\u0440\u0435\u0434\u0441\u0442\u0432\u043e \u043f\u043e\u0434\u043f\u0438\u0441\u0438 [{signToolId}] \u0434\u043b\u044f \u043f\u043e\u0434\u043f\u0438\u0441\u0438 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432 [{documentsIds}]")
    public ooo.jtc.documents.PrepareSmsSignResponse prepareSmsSign(@org.jetbrains.annotations.NotNull()
    java.util.UUID[] documentsIds, @org.jetbrains.annotations.NotNull()
    java.util.UUID signToolId, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0442\u0432\u0435\u0440\u0434\u0438\u0442\u044c \u043f\u043e\u0434\u043f\u0438\u0441\u044c \u0421\u041c\u0421-\u043a\u043e\u0434\u043e\u043c {code}")
    public ooo.jtc.documents.CheckSmsCodeResponse checkSmsCode(@org.jetbrains.annotations.NotNull()
    java.util.UUID smsCodeId, @org.jetbrains.annotations.NotNull()
    java.lang.String code, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0412\u044b\u0447\u0438\u0441\u043b\u0438\u0442\u044c \u0434\u0430\u0439\u0434\u0436\u0435\u0441\u0442 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 [{documentId}]")
    public ooo.jtc.documents.DigestResponse makeDigest(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041e\u0442\u043f\u0440\u0430\u0432\u0438\u0442\u044c \u0437\u0430\u043f\u0440\u043e\u0441 \u043d\u0430 \u043f\u043e\u0434\u043f\u0438\u0441\u044c")
    public ooo.jtc.generic.GenericResponseDto<T> sign(@org.jetbrains.annotations.NotNull()
    ooo.jtc.documents.SignDocumentRequestDto signDocumentRequestDto, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043d\u044f\u0442\u044c \u0441 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \'{this.entityName}\' [{documentId}] \u043f\u043e\u0434\u043f\u0438\u0441\u044c [{signatureId}]")
    public final ooo.jtc.generic.GenericResponseDto<T> unSign(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId, @org.jetbrains.annotations.NotNull()
    java.util.UUID signatureId, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043d\u044f\u0442\u044c \u0441 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \'{this.entityName}\' \u0441\u0432\u043e\u044e \u043f\u043e\u0434\u043f\u0438\u0441\u044c")
    public final ooo.jtc.generic.GenericBatchProcessResponseDto<T> batchSelfUnSign(@org.jetbrains.annotations.NotNull()
    java.util.UUID[] documentsIds, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0435 \u0444\u043e\u0440\u043c\u0430\u0442\u044b \u043f\u0435\u0447\u0430\u0442\u0438 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \'{this.entityName}\'")
    public ooo.jtc.generic.GenericListResponseDto<ooo.jtc.generic.print.PrintExportFormatDto> getAvailablePrintFormat(boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u0435\u0447\u0430\u0442\u044c \u043e\u0434\u043d\u043e\u0433\u043e \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \'{this.entityName}\' \u043f\u043e id [{id}] (\u0444\u043e\u0440\u043c\u0430\u0442 \'{format}\'; \u043f\u0430\u0440\u0430\u043c\u0435\u0442\u0440\u044b \'{params}\')")
    public io.restassured.response.Response printById(@org.jetbrains.annotations.NotNull()
    java.util.UUID id, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat format, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintParams params, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u0435\u0447\u0430\u0442\u044c \u0441\u043f\u0438\u0441\u043a\u0430 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432 \'{this.entityName}\' \u043f\u043e id (\u0444\u043e\u0440\u043c\u0430\u0442 \'{format}\'; \u043f\u0430\u0440\u0430\u043c\u0435\u0442\u0440\u044b \'{params}\')")
    public io.restassured.response.Response printById(@org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> ids, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat format, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintParams params, boolean withCheckResponseCode) {
        return null;
    }
    
    private final io.restassured.response.Response printById(ooo.jtc.generic.print.PrintByIdsRequestDto printRequest, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0435 \u0444\u043e\u0440\u043c\u0430\u0442\u044b \u043f\u0435\u0447\u0430\u0442\u0438 \u0441\u043f\u0438\u0441\u043a\u0430 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432 \'{this.entityName}\'")
    public ooo.jtc.generic.GenericListResponseDto<ooo.jtc.generic.print.PrintExportFormatDto> getAvailablePrintTableFormat(boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u0435\u0447\u0430\u0442\u044c \u0440\u0435\u0435\u0441\u0442\u0440\u0430 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432 \'{this.entityName}\' \u043f\u043e id (\u0444\u043e\u0440\u043c\u0430\u0442 \'{format}\')")
    public io.restassured.response.Response printTableById(@org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> ids, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat format, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0435 \u0444\u043e\u0440\u043c\u0430\u0442\u044b \u044d\u043a\u0441\u043f\u043e\u0440\u0442\u0430 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \'{this.entityName}\'")
    public ooo.jtc.generic.GenericListResponseDto<ooo.jtc.generic.print.PrintExportFormatDto> getAvailableExportFormat(boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u042d\u043a\u0441\u043f\u043e\u0440\u0442 \u043e\u0434\u043d\u043e\u0433\u043e \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \'{this.entityName}\' \u043f\u043e id [{id}] \u0432 \u0444\u043e\u0440\u043c\u0430\u0442\u0435 \'{format}\'")
    public io.restassured.response.Response exportById(@org.jetbrains.annotations.NotNull()
    java.util.UUID id, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat format, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u042d\u043a\u0441\u043f\u043e\u0440\u0442 \u0441\u043f\u0438\u0441\u043a\u0430 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432 \'{this.entityName}\' \u043f\u043e id \u0432 \u0444\u043e\u0440\u043c\u0430\u0442\u0435 \'{format}\'")
    public io.restassured.response.Response exportById(@org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> ids, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat format, boolean withCheckResponseCode) {
        return null;
    }
    
    private final io.restassured.response.Response exportById(ooo.jtc.generic.print.ExportByIdsRequestDto exportRequest, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public io.restassured.response.Response exportByFilter(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.Params params, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat format, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public io.restassured.response.Response exportByFilter(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.Filter filter, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.PrintExportFormat format, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u042d\u043a\u0441\u043f\u043e\u0440\u0442 \u0441\u043f\u0438\u0441\u043a\u0430 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432 \'{this.entityName}\' \u043f\u043e \u0444\u0438\u043b\u044c\u0442\u0440\u0443")
    public io.restassured.response.Response exportByFilter(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.print.ExportByFilterRequestDto exportRequest, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u043a\u0432\u0438\u0442\u043e\u043a \u043e \u043f\u0440\u0438\u0451\u043c\u0435 \'{this.entityName}\' [{documentId}]")
    public ooo.jtc.generic.GenericResponseDto<ooo.jtc.documents.ReceiveTicketDto> getReceiveTicket(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u043a\u0432\u0438\u0442\u043e\u043a \u043e\u0431 \u0438\u0441\u043f\u043e\u043b\u043d\u0435\u043d\u0438\u0438 \'{this.entityName}\' [{documentId}]")
    public ooo.jtc.generic.GenericResponseDto<ooo.jtc.documents.ExecutionTicketDto> getExecutionTicket(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<ooo.jtc.documents.SignatureDto> getDocSignaturesList(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u0434\u0430\u043d\u043d\u044b\u0435 \u0434\u043b\u044f \u043f\u043e\u0434\u043f\u0438\u0441\u0438 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 {this.entityName} [{document.id}] \u043f\u043e \u0421\u041c\u0421")
    public ooo.jtc.documents.SignDocumentRequestDto prepareSmsSignDocumentRequest(@org.jetbrains.annotations.NotNull()
    T document, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u0434\u0430\u043d\u043d\u044b\u0435 \u0434\u043b\u044f \u043f\u043e\u0434\u043f\u0438\u0441\u0438 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 {this.entityName} [{document.id}] \u043f\u043e \u0441\u0435\u0440\u0442\u0438\u0444\u0438\u043a\u0430\u0442\u0443 [{certThumbprint}]")
    public ooo.jtc.documents.SignDocumentRequestDto prepareCertificateSignDocumentRequest(@org.jetbrains.annotations.NotNull()
    T document, @org.jetbrains.annotations.Nullable()
    java.lang.String certThumbprint, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u043f\u0438\u0441\u0430\u0442\u044c \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 {this.entityName} [{document.id}], \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u044f \u0441\u043c\u0441 \u043a\u043e\u0434")
    public ooo.jtc.generic.GenericResponseDto<T> signDocumentBySms(@org.jetbrains.annotations.NotNull()
    T document, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u043f\u0438\u0441\u0430\u0442\u044c \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 {this.entityName} [{document.id}] \u0441\u0435\u0440\u0442\u0438\u0444\u0438\u043a\u0430\u0442\u043e\u043c")
    public ooo.jtc.generic.GenericResponseDto<T> signDocumentByCertificate(@org.jetbrains.annotations.NotNull()
    T document, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043d\u044f\u0442\u044c \u0441\u0432\u043e\u044e \u043f\u043e\u0434\u043f\u0438\u0441\u044c \u0441 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 {this.entityName} [{document.id}], \u043f\u0440\u0435\u0434\u0432\u0430\u0440\u0438\u0442\u0435\u043b\u044c\u043d\u043e \u043f\u0440\u043e\u0432\u0435\u0440\u0438\u0432 \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u043e\u0441\u0442\u044c \u044d\u0442\u043e\u0433\u043e \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u044f")
    public ooo.jtc.generic.GenericResponseDto<T> selfUnSignDocument(@org.jetbrains.annotations.NotNull()
    T document, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0418\u0437\u0432\u043b\u0435\u0447\u044c \u0438\u0437 \u043e\u0442\u0432\u0435\u0442\u0430 \u043d\u0430\u0438\u043c\u0435\u043d\u043e\u0432\u0430\u043d\u0438\u0435 \u0444\u0430\u0439\u043b\u0430")
    public java.lang.String getFileNameFromResponse(@org.jetbrains.annotations.NotNull()
    io.restassured.response.Response fileResponse) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Class<T> getDocument() {
        return null;
    }
    
    public final void setDocument(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> p0) {
    }
    
    public AbstractDocumentSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    ooo.jtc.testdata.Service service, @org.jetbrains.annotations.NotNull()
    java.lang.Class<T> document) {
        super(null, null, null);
    }
}