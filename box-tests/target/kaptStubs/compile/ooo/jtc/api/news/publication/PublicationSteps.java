package ooo.jtc.api.news.publication;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J4\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007J&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007J&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0016H\u0007J,\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020$H\u0007J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020 2\b\b\u0002\u0010!\u001a\u00020\"J&\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$H\u0016J&\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007J&\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010(\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0018\u0010)\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012R\u001b\u0010\u0006\u001a\u00020\u00078TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006*"}, d2 = {"Looo/jtc/api/news/publication/PublicationSteps;", "Looo/jtc/api/common/steps/AbstractDocumentSteps;", "Looo/jtc/news/dto/PublicationDto;", "bankUser", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)V", "servicePath", "", "getServicePath", "()Ljava/lang/String;", "servicePath$delegate", "Lkotlin/Lazy;", "cancelPost", "Looo/jtc/generic/GenericBatchProcessResponseDto;", "documentIds", "", "Ljava/util/UUID;", "withCheckResponseCode", "", "cancelPostSingle", "documentId", "copy", "Looo/jtc/generic/GenericResponseDto;", "isAttachment", "isReceiverCustomers", "finishFromErrorPost", "finishPost", "finishPostFromErrorSingle", "finishPostSingle", "getActions", "Looo/jtc/generic/AvailableActionDto;", "getCustomerPage", "Looo/jtc/generic/GenericPageResponseDto;", "getPageRequest", "Looo/jtc/generic/pageparams/GetPageRequest;", "statusCode", "", "getPage", "post", "postFromError", "postFromErrorSingle", "postSingle", "box-tests"})
public final class PublicationSteps extends ooo.jtc.api.common.steps.AbstractDocumentSteps<ooo.jtc.news.dto.PublicationDto, ooo.jtc.news.dto.PublicationDto> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy servicePath$delegate = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected java.lang.String getServicePath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u043f\u0438\u0441\u043e\u043a \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0445 \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0439 \u0441 \u043f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u0435\u0439")
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.generic.AvailableActionDto> getActions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.news.dto.PublicationDto postSingle(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u0435\u0440\u0435\u0434\u0430\u0442\u044c \u043a \u0440\u0430\u0437\u043c\u0435\u0449\u0435\u043d\u0438\u044e \u043f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u0438 {documentIds}")
    public final ooo.jtc.generic.GenericBatchProcessResponseDto<ooo.jtc.news.dto.PublicationDto> post(@org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> documentIds, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.news.dto.PublicationDto postFromErrorSingle(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u0435\u0440\u0435\u0434\u0430\u0442\u044c \u043a \u0440\u0430\u0437\u043c\u0435\u0449\u0435\u043d\u0438\u044e \u043f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u0438 \u0432 \u043e\u0448\u0438\u0431\u043a\u0435 {documentIds}")
    public final ooo.jtc.generic.GenericBatchProcessResponseDto<ooo.jtc.news.dto.PublicationDto> postFromError(@org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> documentIds, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.news.dto.PublicationDto finishPostSingle(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0417\u0430\u0432\u0435\u0440\u0448\u0438\u0442\u044c \u043f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u0438 {documentIds}")
    public final ooo.jtc.generic.GenericBatchProcessResponseDto<ooo.jtc.news.dto.PublicationDto> finishPost(@org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> documentIds, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.news.dto.PublicationDto finishPostFromErrorSingle(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0417\u0430\u0432\u0435\u0440\u0448\u0438\u0442\u044c \u043f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u0438 \u0432 \u043e\u0448\u0438\u0431\u043a\u0435 {documentIds}")
    public final ooo.jtc.generic.GenericBatchProcessResponseDto<ooo.jtc.news.dto.PublicationDto> finishFromErrorPost(@org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> documentIds, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.news.dto.PublicationDto cancelPostSingle(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041e\u0442\u043c\u0435\u043d\u0438\u0442\u044c \u043f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u0438 {documentIds}")
    public final ooo.jtc.generic.GenericBatchProcessResponseDto<ooo.jtc.news.dto.PublicationDto> cancelPost(@org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> documentIds, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.generic.GenericResponseDto<ooo.jtc.news.dto.PublicationDto> copy(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041a\u043e\u043f\u0438\u0440\u043e\u0432\u0430\u0442\u044c \'{this.entityName}\' (isAttachment={isAttachment}, isReceiverCustomers={isReceiverCustomers}) [{documentId}]")
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.news.dto.PublicationDto> copy(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId, boolean isAttachment, boolean isReceiverCustomers, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u043f\u0438\u0441\u043e\u043a \'{this.entityName}\' \u0434\u043b\u044f \u043a\u043b\u0438\u0435\u043d\u0442\u0441\u043a\u043e\u0439 \u0441\u0442\u043e\u0440\u043e\u043d\u044b")
    public final ooo.jtc.generic.GenericPageResponseDto<ooo.jtc.news.dto.PublicationDto> getCustomerPage(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.GetPageRequest getPageRequest, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.generic.GenericPageResponseDto<ooo.jtc.news.dto.PublicationDto> getPage(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.GetPageRequest getPageRequest) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.generic.GenericPageResponseDto<ooo.jtc.news.dto.PublicationDto> getPage(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.GetPageRequest getPageRequest, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    public PublicationSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User bankUser) {
        super(null, null, null);
    }
    
    public PublicationSteps() {
        super(null, null, null);
    }
}