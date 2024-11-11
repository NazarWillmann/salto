package ooo.jtc.api.letters.tobank.steps;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003J0\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020#H\u0007J&\u0010$\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u0005H\u0007J&\u0010%\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u0005H\u0007J0\u0010&\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020#H\u0007J$\u0010\'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u0005H\u0007J\u0018\u0010)\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0005J\u001c\u0010)\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u0014H\u0007J.\u0010*\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010!\u001a\u00020\u0005H\u0007J&\u0010+\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u0005H\u0007J&\u0010,\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u0005H\u0007J&\u0010-\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u0005H\u0007J&\u0010.\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u0005H\u0007J0\u0010/\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020#H\u0007J&\u00100\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u0005H\u0007J0\u00101\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020#H\u0007J.\u00102\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0003JD\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u001b2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u00108\u001a\u0004\u0018\u0001062\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010\u0016J\"\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u001b2\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010\u0016H\u0007J*\u00103\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u00142\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u000e\u0010;\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J`\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00050\u00162\u0006\u0010?\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00142\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020B0A2\u0014\b\u0002\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020#0\u000b2\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00050A2\b\b\u0002\u0010E\u001a\u00020FH\u0007JP\u0010G\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00142\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020B0A2\u0014\b\u0002\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020#0\u000b2\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00050AH\u0007J\u0010\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u0005H\u0007J\u0010\u0010J\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u0005H\u0007J\u001c\u0010K\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u00052\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u001bH\u0007J(\u0010M\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00142\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u0002062\u0006\u0010Q\u001a\u00020#H\u0007J(\u0010R\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00142\u0006\u0010S\u001a\u00020\u00052\u0006\u0010P\u001a\u0002062\u0006\u0010T\u001a\u00020#H\u0007J\u000e\u0010U\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0014J\u000e\u0010V\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR,\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00050\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006W"}, d2 = {"Looo/jtc/api/letters/tobank/steps/LetterToBankPrepareSteps;", "", "()V", "docChecks", "Looo/jtc/api/common/checks/ApiDocumentChecks;", "Looo/jtc/letters/dto/LetterToBankDto;", "executedLTBFilter", "Looo/jtc/generic/pageparams/FilterData;", "getExecutedLTBFilter", "()Looo/jtc/generic/pageparams/FilterData;", "removeAttachmentsTokens", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "letterToBank", "getRemoveAttachmentsTokens", "()Lkotlin/jvm/functions/Function1;", "addAttachmentsToDto", "letterDto", "creatorUser", "Looo/jtc/uaa/User;", "files", "", "Ljava/io/File;", "changeLetterToBankStatus_DIRTY", "", "letterId", "Ljava/util/UUID;", "status", "Looo/jtc/letters/model/LetterToBankStatus;", "createDetailsErrorLetterToBank_DIRTY", "creatorClientUser", "receiverBankUser", "dtoForCreate", "returnBankDto", "", "createDraftLetterToBank", "createInProcessingLetterToBank", "createIncorrectDigestLetterToBank_DIRTY", "createLetterToBankAvailableToUser", "user", "createLetterToBankDto", "createLetterToBankInStatus", "createNewLetterToBank", "createProcessedLetterToBank", "createRecalledLetterToBank", "createReceivedLetterToBank", "createSentLetterToBank", "createSignedLetterToBank", "createWrongESignatureLetterToBank_DIRTY", "fakeLetterToBankInStatus_DIRTY", "getLetterToBankDtoForCreate", "customerId", "customerName", "", "branchId", "branchName", "attachments", "Looo/jtc/generic/attachments/AttachmentDto;", "getLetterToBankDtoForUpdate", "getLtbSignaturesFromDB", "Looo/jtc/documents/SignatureDto;", "getOrCreateDifferentLetterToBankDtoList", "searchingUser", "getPageRequest", "Lkotlin/Function0;", "Looo/jtc/generic/pageparams/GetPageRequest;", "additionalFilter", "createLtbFunc", "amount", "", "getOrCreateLetterToBankDto", "makeDetailsWrong_DIRTY", "document", "makeDigestIncorrect_DIRTY", "makeSignatureCorrupt_DIRTY", "signatureId", "prepareLTBAnswerForLetterFromBankDto", "letterFromBank", "Looo/jtc/letters/dto/LetterFromBankDto;", "expDocNumber", "answerWithAttachments", "prepareLetterToBankDtoCopyDto", "sourceLTB", "copyWithAttachments", "retrieveBankUser", "retrieveClientUser", "box-tests"})
public final class LetterToBankPrepareSteps {
    private static final ooo.jtc.api.common.checks.ApiDocumentChecks<ooo.jtc.letters.dto.LetterToBankDto> docChecks = null;
    
    /**
     * Null all attachments' [accessToken]s from LetterToBank for proper DTO comparison
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function1<ooo.jtc.letters.dto.LetterToBankDto, ooo.jtc.letters.dto.LetterToBankDto> removeAttachmentsTokens = null;
    public static final ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.generic.pageparams.FilterData getExecutedLTBFilter() {
        return null;
    }
    
    /**
     * Retrieve client user for creation.
     * Because only client user can create LetterToBank.
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.User retrieveClientUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        return null;
    }
    
    /**
     * Retrieve bank user for receiving created LetterToBank.
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.User retrieveBankUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u0438\u043b\u0438 \u0441\u043e\u0437\u0434\u0430\u0442\u044c \'\u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a\', \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u043e\u0435 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044e {searchingUser.login}")
    public final ooo.jtc.letters.dto.LetterToBankDto getOrCreateLetterToBankDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User searchingUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.generic.pageparams.GetPageRequest> getPageRequest, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.letters.dto.LetterToBankDto, java.lang.Boolean> additionalFilter, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.letters.dto.LetterToBankDto> createLtbFunc) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u043d\u0430\u0431\u043e\u0440 \u0440\u0430\u0437\u043d\u044b\u0445 \'\u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a\' \u0438\u043b\u0438 \u0441\u043e\u0437\u0434\u0430\u0442\u044c \u0438\u0445 \u043d\u0435\u043e\u0431\u0445\u043e\u0434\u0438\u043c\u043e\u0435 \u043a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e, \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u043e\u0435 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044e {searchingUser.login}")
    public final java.util.List<ooo.jtc.letters.dto.LetterToBankDto> getOrCreateDifferentLetterToBankDtoList(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User searchingUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.generic.pageparams.GetPageRequest> getPageRequest, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.letters.dto.LetterToBankDto, java.lang.Boolean> additionalFilter, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.letters.dto.LetterToBankDto> createLtbFunc, long amount) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u043e\u0431\u044a\u0435\u043a\u0442 \u0434\u043b\u044f \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f \'\u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a\'")
    public final ooo.jtc.letters.dto.LetterToBankDto getLetterToBankDtoForCreate(@org.jetbrains.annotations.NotNull()
    java.util.UUID customerId, @org.jetbrains.annotations.Nullable()
    java.util.List<? extends ooo.jtc.generic.attachments.AttachmentDto> attachments) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.letters.dto.LetterToBankDto getLetterToBankDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverBankUser, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.io.File> attachments) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.letters.dto.LetterToBankDto getLetterToBankDtoForCreate(@org.jetbrains.annotations.NotNull()
    java.util.UUID customerId, @org.jetbrains.annotations.Nullable()
    java.lang.String customerName, @org.jetbrains.annotations.Nullable()
    java.util.UUID branchId, @org.jetbrains.annotations.Nullable()
    java.lang.String branchName, @org.jetbrains.annotations.Nullable()
    java.util.List<? extends ooo.jtc.generic.attachments.AttachmentDto> attachments) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.letters.dto.LetterToBankDto getLetterToBankDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto letterDto) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0432\u043b\u043e\u0436\u0435\u043d\u0438\u044f \u043a DTO \u041f\u0438\u0441\u044c\u043c\u0430 [{letterDto.id}]")
    public final ooo.jtc.letters.dto.LetterToBankDto addAttachmentsToDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto letterDto, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorUser, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.io.File> files) {
        return null;
    }
    
    /**
     * Copies provided LetterToBankDto based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171412.
     * @param user - user that copies [sourceLTB]
     * @param sourceLTB - LetterToBank that will be copied
     * @param expDocNumber - expected [sourceLTB.documentNumber] value. Trying to get it AFTER actual copying
     *                     is incorrect, so it should be prepared beforehand
     * @param copyWithAttachments - boolean flag; indicates if [sourceLTB]-copy should be prepared with/without
     *                     attachment-related data
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a-\u043a\u043e\u043f\u0438\u044e [{sourceLTB.id}] \u043e\u0442 \u043b\u0438\u0446\u0430 \'{user.login}\'")
    public final ooo.jtc.letters.dto.LetterToBankDto prepareLetterToBankDtoCopyDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto sourceLTB, @org.jetbrains.annotations.NotNull()
    java.lang.String expDocNumber, boolean copyWithAttachments) {
        return null;
    }
    
    /**
     * Creates expected LetterToBank-answer for provided LetterFromBank
     * based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171822
     *
     * @param user - user that creates LetterToBank-answer
     * @param letterFromBank - LetterFromBank. Answer will be created for this LFB
     * @param expDocNumber - expected [letterFromBank.documentNumber] value. Trying to get it AFTER requesting answer
     *                     is incorrect, so it should be prepared beforehand
     * @param answerWithAttachments - boolean flag; indicates if LetterToBank-answer should be prepared with/without
     *                     attachment-related data
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a-\u043e\u0442\u0432\u0435\u0442 \u043d\u0430 \u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430 [{letterFromBank.id}] \u043e\u0442 \u043b\u0438\u0446\u0430 \'{user.login}\'")
    public final ooo.jtc.letters.dto.LetterToBankDto prepareLTBAnswerForLetterFromBankDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterFromBankDto letterFromBank, @org.jetbrains.annotations.NotNull()
    java.lang.String expDocNumber, boolean answerWithAttachments) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u043e\u0435 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044e {user.login}")
    public final ooo.jtc.letters.dto.LetterToBankDto createLetterToBankAvailableToUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a \u0434\u043b\u044f \u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u0438, \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u043e\u0439 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044f\u043c {creatorClientUser.login}, {receiverBankUser.login}")
    public final ooo.jtc.letters.dto.LetterToBankDto createLetterToBankDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverBankUser) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.letters.dto.LetterToBankDto createLetterToBankDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a \u0432 \u0441\u0442\u0430\u0442\u0443\u0441\u0435 \'{status}\' \u0434\u043b\u044f \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u0435\u0439 {creatorClientUser.login}, {receiverBankUser.login}")
    public final ooo.jtc.letters.dto.LetterToBankDto createLetterToBankInStatus(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.model.LetterToBankStatus status, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto dtoForCreate) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0434\u0435\u043b\u0430\u0442\u044c \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a \u0432 \u0441\u0442\u0430\u0442\u0443\u0441\u0435 \'{status}\'")
    private final ooo.jtc.letters.dto.LetterToBankDto fakeLetterToBankInStatus_DIRTY(ooo.jtc.uaa.User creatorClientUser, ooo.jtc.uaa.User receiverBankUser, ooo.jtc.letters.dto.LetterToBankDto dtoForCreate, ooo.jtc.letters.model.LetterToBankStatus status) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0447\u0435\u0440\u043d\u043e\u0432\u0438\u043a \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a")
    public final ooo.jtc.letters.dto.LetterToBankDto createDraftLetterToBank(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043d\u043e\u0432\u044b\u0439 \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a")
    public final ooo.jtc.letters.dto.LetterToBankDto createNewLetterToBank(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043f\u043e\u0434\u043f\u0438\u0441\u0430\u043d\u043d\u044b\u0439 \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a")
    public final ooo.jtc.letters.dto.LetterToBankDto createSignedLetterToBank(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto dtoForCreate) {
        return null;
    }
    
    /**
     * @param creatorClientUser - user, who creates LetterToBank
     * @param receiverBankUser - user, who receives/processes LetterToBank
     * @param dtoForCreate - LetterToBank DTO, that's going to be created
     * @param returnBankDto - boolean flag; indicates what 'version' of LTB will be returned: client/bank.
     *             NB: Bank-version has more filled fields
     *
     * (!) WARNING (!)
     * returned LTB most likely will be in DELIVERED status, especially client-version,
     * but when it's a bank-version its status may be any of:
     * [DELIVERED, DETAILS_ERROR, WRONG_E_SIGNATURE, CORRECT_E_SIGNATURE, RECEIVED].
     *
     * @return sent LetterToBank
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u043d\u044b\u0439 \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a")
    public final ooo.jtc.letters.dto.LetterToBankDto createSentLetterToBank(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto dtoForCreate, boolean returnBankDto) {
        return null;
    }
    
    /**
     * Mostly the same method as [createSentLetterToBank] above,
     * but this one will always result in a WRONG_E_SIGNATURE LetterToBank
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u043d\u044b\u0439 \u043e\u0448\u0438\u0431\u043e\u0447\u043d\u044b\u0439 \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a (\u043d\u0435\u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u044b\u0439 \u0434\u0430\u0439\u0434\u0436\u0435\u0441\u0442)")
    public final ooo.jtc.letters.dto.LetterToBankDto createIncorrectDigestLetterToBank_DIRTY(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto dtoForCreate, boolean returnBankDto) {
        return null;
    }
    
    /**
     * Mostly the same method as [createSentLetterToBank] above,
     * but this one will always result in a WRONG_E_SIGNATURE LetterToBank
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u043d\u044b\u0439 \u043e\u0448\u0438\u0431\u043e\u0447\u043d\u044b\u0439 \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a (\u0438\u0437\u043c\u0435\u043d\u0451\u043d\u043d\u0430\u044f \u043f\u043e\u0434\u043f\u0438\u0441\u044c)")
    public final ooo.jtc.letters.dto.LetterToBankDto createWrongESignatureLetterToBank_DIRTY(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto dtoForCreate, boolean returnBankDto) {
        return null;
    }
    
    /**
     * Mostly the same method as [createSentLetterToBank] above,
     * but this one will always result in a DETAILS_ERROR LetterToBank
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u043d\u044b\u0439 \u043e\u0448\u0438\u0431\u043e\u0447\u043d\u044b\u0439 \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a (\u0434\u0430\u043d\u043d\u044b\u0435)")
    public final ooo.jtc.letters.dto.LetterToBankDto createDetailsErrorLetterToBank_DIRTY(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto dtoForCreate, boolean returnBankDto) {
        return null;
    }
    
    /**
     * @param creatorClientUser - user, who creates LetterToBank
     * @param receiverBankUser - user, who receives/processes LetterToBank
     * @param dtoForCreate - LetterToBank DTO, that's going to be created
     *
     * @return received LetterToBank, bank version (has more filled fields)
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043f\u043e\u043b\u0443\u0447\u0435\u043d\u043d\u044b\u0439 \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a")
    public final ooo.jtc.letters.dto.LetterToBankDto createReceivedLetterToBank(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto dtoForCreate) {
        return null;
    }
    
    /**
     * @param creatorClientUser - user, who creates LetterToBank
     * @param receiverBankUser - user, who receives/processes LetterToBank
     * @param dtoForCreate - LetterToBank DTO, that's going to be created
     *
     * @return LetterToBank-in-processing, bank version (has more filled fields)
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a, \u0432\u0437\u044f\u0442\u044b\u0439 \u0432 \u0440\u0430\u0431\u043e\u0442\u0443")
    public final ooo.jtc.letters.dto.LetterToBankDto createInProcessingLetterToBank(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto dtoForCreate) {
        return null;
    }
    
    /**
     * @param creatorClientUser - user, who creates LetterToBank
     * @param receiverBankUser - user, who receives/processes LetterToBank
     * @param dtoForCreate - LetterToBank DTO, that's going to be created
     *
     * @return processed LetterToBank, bank version (has more filled fields)
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0443\u0441\u043f\u0435\u0448\u043d\u043e \u043e\u0431\u0440\u0430\u0431\u043e\u0442\u0430\u043d\u043d\u044b\u0439 \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a")
    public final ooo.jtc.letters.dto.LetterToBankDto createProcessedLetterToBank(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto dtoForCreate) {
        return null;
    }
    
    /**
     * @param creatorClientUser - user, who creates LetterToBank
     * @param receiverBankUser - user, who receives/processes LetterToBank
     * @param dtoForCreate - LetterToBank DTO, that's going to be created
     *
     * @return recalled LetterToBank, bank version (has more filled fields)
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043e\u0442\u043e\u0437\u0432\u0430\u043d\u043d\u044b\u0439 \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a")
    public final ooo.jtc.letters.dto.LetterToBankDto createRecalledLetterToBank(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.letters.dto.LetterToBankDto, ooo.jtc.letters.dto.LetterToBankDto> getRemoveAttachmentsTokens() {
        return null;
    }
    
    private final java.util.List<ooo.jtc.documents.SignatureDto> getLtbSignaturesFromDB(java.util.UUID letterId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0418\u0441\u043f\u043e\u0440\u0442\u0438\u0442\u044c \u043f\u043e\u0434\u043f\u0438\u0441\u044c, \u043d\u0435 \u0437\u0430\u0442\u0440\u043e\u043d\u0443\u0432 \u0435\u0451 \u0441\u0442\u0440\u0443\u043a\u0442\u0443\u0440\u0443")
    public final ooo.jtc.letters.dto.LetterToBankDto makeSignatureCorrupt_DIRTY(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto document, @org.jetbrains.annotations.Nullable()
    java.util.UUID signatureId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0418\u0437\u043c\u0435\u043d\u0438\u0442\u044c \u0434\u0430\u043d\u043d\u044b\u0435 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430, \u0447\u0442\u043e\u0431\u044b \u0434\u0430\u0439\u0434\u0436\u0435\u0441\u0442 \u043f\u0440\u0438 \u043f\u0440\u043e\u0432\u0435\u0440\u043a\u0435 \u0431\u044b\u043b \u043f\u0440\u0438\u0437\u043d\u0430\u043d \u043d\u0435\u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u044b\u043c")
    public final ooo.jtc.letters.dto.LetterToBankDto makeDigestIncorrect_DIRTY(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto document) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0418\u0441\u043f\u043e\u0440\u0442\u0438\u0442\u044c \u0434\u0430\u043d\u043d\u044b\u0435 \u041f\u0438\u0441\u044c\u043c\u0430, \u043d\u0435 \u0437\u0430\u0442\u0440\u043e\u043d\u0443\u0432 \u043f\u043e\u0434\u043f\u0438\u0441\u0430\u043d\u043d\u044b\u0435 \u0434\u0430\u043d\u043d\u044b\u0435")
    public final ooo.jtc.letters.dto.LetterToBankDto makeDetailsWrong_DIRTY(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto document) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u0418\u0437\u043c\u0435\u043d\u0438\u0442\u044c \u0441\u0442\u0430\u0442\u0443\u0441 \u041f\u0438\u0441\u044c\u043c\u0430 \u0447\u0435\u0440\u0435\u0437 \u0411\u0414: \'{status}\'")
    private final void changeLetterToBankStatus_DIRTY(java.util.UUID letterId, ooo.jtc.letters.model.LetterToBankStatus status) {
    }
    
    private LetterToBankPrepareSteps() {
        super();
    }
}