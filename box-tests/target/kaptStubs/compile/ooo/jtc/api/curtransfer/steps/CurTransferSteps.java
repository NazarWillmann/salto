package ooo.jtc.api.curtransfer.steps;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0007J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007J$\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0010H\u0007J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0007H\u0007R\u001b\u0010\u0006\u001a\u00020\u00078TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001e"}, d2 = {"Looo/jtc/api/curtransfer/steps/CurTransferSteps;", "Looo/jtc/api/common/steps/AbstractDocumentSteps;", "Looo/jtc/curtransfer/dto/CurTransferDto;", "clientUser", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)V", "servicePath", "", "getServicePath", "()Ljava/lang/String;", "servicePath$delegate", "Lkotlin/Lazy;", "batchRecall", "Looo/jtc/generic/GenericBatchResponseDto;", "documentIds", "", "Ljava/util/UUID;", "getActions", "Looo/jtc/generic/GenericResponseDto;", "Looo/jtc/generic/AvailableActionDto;", "getNextIngoingDocumentNumber", "customerId", "documentDate", "Ljava/time/LocalDate;", "incrementValue", "", "preFillForCustomer", "recall", "docId", "noteFromBank", "box-tests"})
public final class CurTransferSteps extends ooo.jtc.api.common.steps.AbstractDocumentSteps<ooo.jtc.curtransfer.dto.CurTransferDto, ooo.jtc.curtransfer.dto.CurTransferDto> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy servicePath$delegate = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected java.lang.String getServicePath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u043f\u0440\u0435\u0434\u0437\u0430\u043f\u043e\u043b\u043d\u0435\u043d\u043d\u044b\u0439 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \'{this.entityName}\' \u0434\u043b\u044f \u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u0438 [{customerId}]")
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.curtransfer.dto.CurTransferDto> preFillForCustomer(@org.jetbrains.annotations.NotNull()
    java.util.UUID customerId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u043f\u0438\u0441\u043e\u043a \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0445 \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0439 \u0441 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u043c \'{this.entityName}\' [{this.user.userType}]")
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.generic.AvailableActionDto> getActions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041e\u0442\u043e\u0437\u0432\u0430\u0442\u044c \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \'{this.entityName}\' [{docId}]")
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.curtransfer.dto.CurTransferDto> recall(@org.jetbrains.annotations.NotNull()
    java.util.UUID docId, @org.jetbrains.annotations.NotNull()
    java.lang.String noteFromBank) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041e\u0442\u043e\u0437\u0432\u0430\u0442\u044c \u043d\u0430\u0431\u043e\u0440 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432 \'{this.entityName}\' [{documentIds}]")
    public final ooo.jtc.generic.GenericBatchResponseDto<ooo.jtc.curtransfer.dto.CurTransferDto> batchRecall(@org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> documentIds) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u043b\u0435\u0434\u0443\u044e\u0449\u0438\u0439 \u043d\u043e\u043c\u0435\u0440 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \'{this.entityName}\' \u0434\u043b\u044f \u041a\u043b\u0438\u0435\u043d\u0442\u0430 [{customerId}] (\u0443\u0432\u0435\u043b\u0438\u0447\u0438\u0442\u044c \u0441\u0447\u0451\u0442\u0447\u0438\u043a: {incrementValue})")
    public final java.lang.String getNextIngoingDocumentNumber(@org.jetbrains.annotations.NotNull()
    java.util.UUID customerId, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate documentDate, boolean incrementValue) {
        return null;
    }
    
    public CurTransferSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User clientUser) {
        super(null, null, null);
    }
    
    public CurTransferSteps() {
        super(null, null, null);
    }
}