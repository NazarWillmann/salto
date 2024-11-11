package ooo.jtc.api.letters.frombank.steps;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0007J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0007J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u00a8\u0006!"}, d2 = {"Looo/jtc/api/letters/frombank/steps/LetterFromBankSteps;", "Looo/jtc/api/common/steps/AbstractDocumentSteps;", "Looo/jtc/letters/dto/LetterFromBankDto;", "bankUser", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)V", "sendTicketResponseType", "Lcom/fasterxml/jackson/databind/JavaType;", "servicePath", "", "getServicePath", "()Ljava/lang/String;", "servicePath$delegate", "Lkotlin/Lazy;", "copyWithAttachment", "Looo/jtc/generic/GenericResponseDto;", "documentId", "Ljava/util/UUID;", "createAnswer", "letterToBankId", "createAnswerWithAttachment", "getExecutionTicket", "Looo/jtc/documents/ExecutionTicketDto;", "getNextOutgoingDocumentNumber", "branchId", "documentDate", "Ljava/time/LocalDate;", "incrementValue", "", "getReceiveTicket", "Looo/jtc/documents/ReceiveTicketDto;", "getSendTicket", "Looo/jtc/documents/SendTicketDto;", "box-tests"})
public final class LetterFromBankSteps extends ooo.jtc.api.common.steps.AbstractDocumentSteps<ooo.jtc.letters.dto.LetterFromBankDto, ooo.jtc.letters.dto.LetterFromBankDto> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy servicePath$delegate = null;
    private final com.fasterxml.jackson.databind.JavaType sendTicketResponseType = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected java.lang.String getServicePath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u043b\u0435\u0434\u0443\u044e\u0449\u0438\u0439 \u043d\u043e\u043c\u0435\u0440 \u041f\u0438\u0441\u044c\u043c\u0430 \u0438\u0437 \u0411\u0430\u043d\u043a\u0430 [{branchId}] (\u0443\u0432\u0435\u043b\u0438\u0447\u0438\u0442\u044c \u0441\u0447\u0451\u0442\u0447\u0438\u043a: {incrementValue})")
    public final java.lang.String getNextOutgoingDocumentNumber(@org.jetbrains.annotations.NotNull()
    java.util.UUID branchId, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate documentDate, boolean incrementValue) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041a\u043e\u043f\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u0441 \u0432\u043b\u043e\u0436\u0435\u043d\u0438\u044f\u043c\u0438 \u041f\u0438\u0441\u044c\u043c\u043e [{documentId}]")
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.letters.dto.LetterFromBankDto> copyWithAttachment(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u043e\u0442\u0432\u0435\u0442 \u043d\u0430 \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a [{letterToBankId}] \u0431\u0435\u0437 \u0432\u043b\u043e\u0436\u0435\u043d\u0438\u0439")
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.letters.dto.LetterFromBankDto> createAnswer(@org.jetbrains.annotations.NotNull()
    java.util.UUID letterToBankId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u043e\u0442\u0432\u0435\u0442 \u043d\u0430 \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a [{letterToBankId}] \u0441 \u0432\u043b\u043e\u0436\u0435\u043d\u0438\u0435\u043c")
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.letters.dto.LetterFromBankDto> createAnswerWithAttachment(@org.jetbrains.annotations.NotNull()
    java.util.UUID letterToBankId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.generic.GenericResponseDto<ooo.jtc.documents.ReceiveTicketDto> getReceiveTicket(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.generic.GenericResponseDto<ooo.jtc.documents.ExecutionTicketDto> getExecutionTicket(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u043a\u0432\u0438\u0442\u043e\u043a \u043e\u0431 \u043e\u0442\u043f\u0440\u0430\u0432\u043a\u0435 \'{this.entityName}\' [{documentId}]")
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.documents.SendTicketDto> getSendTicket(@org.jetbrains.annotations.NotNull()
    java.util.UUID documentId) {
        return null;
    }
    
    public LetterFromBankSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User bankUser) {
        super(null, null, null);
    }
    
    public LetterFromBankSteps() {
        super(null, null, null);
    }
}