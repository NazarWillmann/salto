package ooo.jtc.api.curtransfer.steps;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J.\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0005H\u0007J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u001c\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005JP\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0\u001c2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0007J`\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050 2\u0006\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0\u001c2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u00192\b\b\u0002\u0010\"\u001a\u00020#H\u0007J\u000e\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fJ\u000e\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\'"}, d2 = {"Looo/jtc/api/curtransfer/steps/CurTransferPrepareSteps;", "", "()V", "docChecks", "Looo/jtc/api/common/checks/ApiDocumentChecks;", "Looo/jtc/curtransfer/dto/CurTransferDto;", "executedCurTransferFilter", "Looo/jtc/generic/pageparams/FilterData;", "getExecutedCurTransferFilter", "()Looo/jtc/generic/pageparams/FilterData;", "createCurTransferAvailableToUser", "targetUser", "Looo/jtc/uaa/User;", "creatorClientUser", "receiverBankUser", "dtoForCreate", "getCurTransferDtoForCreate", "customerId", "Ljava/util/UUID;", "branchId", "getCurTransferDtoForUpdate", "docDto", "getOrCreateCurTransferDto", "searchingUser", "getPageRequest", "Lkotlin/Function0;", "Looo/jtc/generic/pageparams/GetPageRequest;", "additionalFilter", "Lkotlin/Function1;", "", "createCurTrFunc", "getOrCreateDifferentCurTransferDtoList", "", "createLtbFunc", "amount", "", "retrieveBankUser", "user", "retrieveClientUser", "box-tests"})
public final class CurTransferPrepareSteps {
    private static final ooo.jtc.api.common.checks.ApiDocumentChecks<ooo.jtc.curtransfer.dto.CurTransferDto> docChecks = null;
    public static final ooo.jtc.api.curtransfer.steps.CurTransferPrepareSteps INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.generic.pageparams.FilterData getExecutedCurTransferFilter() {
        return null;
    }
    
    /**
     * Retrieve client user for creation.
     * Because only client user can create CurTransfer.
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.User retrieveClientUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        return null;
    }
    
    /**
     * Retrieve bank user for receiving created CurTransfer.
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.User retrieveBankUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u0438\u043b\u0438 \u0441\u043e\u0437\u0434\u0430\u0442\u044c \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \'\u0412\u0430\u043b\u044e\u0442\u043d\u044b\u0439 \u043f\u0435\u0440\u0435\u0432\u043e\u0434\', \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0439 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044e {searchingUser.login}")
    public final ooo.jtc.curtransfer.dto.CurTransferDto getOrCreateCurTransferDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User searchingUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.generic.pageparams.GetPageRequest> getPageRequest, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.curtransfer.dto.CurTransferDto, java.lang.Boolean> additionalFilter, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.curtransfer.dto.CurTransferDto> createCurTrFunc) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u043d\u0430\u0431\u043e\u0440 \u0440\u0430\u0437\u043d\u044b\u0445 \'\u0412\u0430\u043b\u044e\u0442\u043d\u044b\u0439 \u043f\u0435\u0440\u0435\u0432\u043e\u0434\' \u0438\u043b\u0438 \u0441\u043e\u0437\u0434\u0430\u0442\u044c \u0438\u0445 \u043d\u0435\u043e\u0431\u0445\u043e\u0434\u0438\u043c\u043e\u0435 \u043a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e, \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0435 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044e {searchingUser.login}")
    public final java.util.List<ooo.jtc.curtransfer.dto.CurTransferDto> getOrCreateDifferentCurTransferDtoList(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User searchingUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.generic.pageparams.GetPageRequest> getPageRequest, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.curtransfer.dto.CurTransferDto, java.lang.Boolean> additionalFilter, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.curtransfer.dto.CurTransferDto> createLtbFunc, long amount) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \'\u0412\u0430\u043b\u044e\u0442\u043d\u044b\u0439 \u043f\u0435\u0440\u0435\u0432\u043e\u0434\' \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0439 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044e {targetUser.login}")
    public final ooo.jtc.curtransfer.dto.CurTransferDto createCurTransferAvailableToUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User targetUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.CurTransferDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u043e\u0431\u044a\u0435\u043a\u0442 \u0434\u043b\u044f \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f \'\u0412\u0430\u043b\u044e\u0442\u043d\u044b\u0439 \u043f\u0435\u0440\u0435\u0432\u043e\u0434\'")
    public final ooo.jtc.curtransfer.dto.CurTransferDto getCurTransferDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverBankUser) {
        return null;
    }
    
    private final ooo.jtc.curtransfer.dto.CurTransferDto getCurTransferDtoForCreate(java.util.UUID customerId, java.util.UUID branchId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.curtransfer.dto.CurTransferDto getCurTransferDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.curtransfer.dto.CurTransferDto docDto) {
        return null;
    }
    
    private CurTransferPrepareSteps() {
        super();
    }
}