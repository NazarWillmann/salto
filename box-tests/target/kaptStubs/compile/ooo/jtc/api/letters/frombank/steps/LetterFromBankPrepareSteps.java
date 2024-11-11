package ooo.jtc.api.letters.frombank.steps;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0007J0\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u00172\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007J&\u0010!\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u00172\b\b\u0002\u0010\u001e\u001a\u00020\bH\u0007J&\u0010\"\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u00172\b\b\u0002\u0010\u001e\u001a\u00020\bH\u0007J&\u0010#\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u00172\b\b\u0002\u0010\u001e\u001a\u00020\bH\u0007J$\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u00172\b\b\u0002\u0010\u001e\u001a\u00020\bH\u0007J\u0018\u0010&\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\bJ\u001c\u0010&\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u0017H\u0007J.\u0010\'\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010\u001e\u001a\u00020\bH\u0007J&\u0010*\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u00172\b\b\u0002\u0010\u001e\u001a\u00020\bH\u0007J&\u0010+\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u00172\b\b\u0002\u0010\u001e\u001a\u00020\bH\u0007J(\u0010,\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020 H\u0007J.\u00100\u001a\u00020\b2\u0006\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00042\u0006\u00104\u001a\u0002022\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0004J*\u00100\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u00172\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u000e\u00107\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bJ\u0016\u00108\u001a\b\u0012\u0004\u0012\u0002090\u00192\u0006\u0010:\u001a\u000202H\u0002J`\u0010;\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010<\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u00172\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>2\u0014\b\u0002\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020 0\n2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020\b0>2\b\b\u0002\u0010B\u001a\u00020CH\u0007JP\u0010D\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u00172\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>2\u0014\b\u0002\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020 0\n2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020\b0>H\u0007J\u0010\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\bH\u0007J\u0010\u0010G\u001a\u00020\b2\u0006\u0010F\u001a\u00020\bH\u0007J\u001c\u0010H\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\n\b\u0002\u0010I\u001a\u0004\u0018\u000102H\u0007J(\u0010J\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00172\u0006\u0010K\u001a\u00020L2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010M\u001a\u00020 H\u0007J\u000e\u0010N\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0017J\u000e\u0010O\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006P"}, d2 = {"Looo/jtc/api/letters/frombank/steps/LetterFromBankPrepareSteps;", "", "()V", "ERROR_MSG_DOC_IS_NOT_SIGNED", "", "ERROR_MSG_SENDING", "docChecks", "Looo/jtc/api/common/checks/ApiDocumentChecks;", "Looo/jtc/letters/dto/LetterFromBankDto;", "removeAttachmentsTokens", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "letterFromBank", "getRemoveAttachmentsTokens", "()Lkotlin/jvm/functions/Function1;", "sentLfbFilter", "Looo/jtc/generic/pageparams/FilterData;", "getSentLfbFilter", "()Looo/jtc/generic/pageparams/FilterData;", "addAttachmentsToDto", "letterDto", "creatorUser", "Looo/jtc/uaa/User;", "files", "", "Ljava/io/File;", "createDeliveredLetterFromBank", "creatorBankUser", "receiverClientUser", "dtoForCreate", "returnBankDto", "", "createDetailsErrorLetterFromBank_DIRTY", "createDraftLetterFromBank", "createIncorrectDigestLetterFromBank_DIRTY", "createLetterFromBankAvailableToUser", "user", "createLetterFromBankDto", "createLetterFromBankInStatus", "status", "Looo/jtc/letters/model/LetterFromBankStatus;", "createNewLetterFromBank", "createSignedLetterFromBank", "getLetterFromBankDtoCopyDto", "sourceLetter", "expDocNumber", "copyWithAttachments", "getLetterFromBankDtoForCreate", "customerId", "Ljava/util/UUID;", "customerName", "branchId", "branchName", "attachments", "getLetterFromBankDtoForUpdate", "getLfbSignaturesFromDB", "Looo/jtc/documents/SignatureDto;", "letterId", "getOrCreateDifferentLetterFromBankDtoList", "searchingUser", "getPageRequest", "Lkotlin/Function0;", "Looo/jtc/generic/pageparams/GetPageRequest;", "additionalFilter", "createLfbFunc", "amount", "", "getOrCreateLetterFromBankDto", "makeDetailsWrong_DIRTY", "document", "makeDigestIncorrect_DIRTY", "makeSignatureCorrupt_DIRTY", "signatureId", "prepareLFBAnswerForLetterToBankDto", "letterToBank", "Looo/jtc/letters/dto/LetterToBankDto;", "answerWithAttachments", "retrieveBankUser", "retrieveClientUser", "box-tests"})
public final class LetterFromBankPrepareSteps {
    private static final ooo.jtc.api.common.checks.ApiDocumentChecks<ooo.jtc.letters.dto.LetterFromBankDto> docChecks = null;
    private static final java.lang.String ERROR_MSG_DOC_IS_NOT_SIGNED = "\u0414\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \u043d\u0435 \u0431\u044b\u043b \u043f\u043e\u0434\u043f\u0438\u0441\u0430\u043d";
    private static final java.lang.String ERROR_MSG_SENDING = "\u041e\u0448\u0438\u0431\u043a\u0430 \u043f\u0440\u0438 \u043e\u0442\u043f\u0440\u0430\u0432\u043a\u0435 \u041a\u043b\u0438\u0435\u043d\u0442\u0443";
    
    /**
     * Null all attachments' [accessToken]s from LetterFromBank for proper DTO comparison
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function1<ooo.jtc.letters.dto.LetterFromBankDto, ooo.jtc.letters.dto.LetterFromBankDto> removeAttachmentsTokens = null;
    public static final ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps INSTANCE = null;
    
    /**
     * Retrieve client user for receiving created LetterFromBank
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.User retrieveClientUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        return null;
    }
    
    /**
     * Retrieve bank user for creating LetterFromBank
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.User retrieveBankUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.generic.pageparams.FilterData getSentLfbFilter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u0438\u043b\u0438 \u0441\u043e\u0437\u0434\u0430\u0442\u044c \'\u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430\', \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u043e\u0435 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044e {searchingUser.login}")
    public final ooo.jtc.letters.dto.LetterFromBankDto getOrCreateLetterFromBankDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User searchingUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.generic.pageparams.GetPageRequest> getPageRequest, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.letters.dto.LetterFromBankDto, java.lang.Boolean> additionalFilter, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.letters.dto.LetterFromBankDto> createLfbFunc) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u043d\u0430\u0431\u043e\u0440 \u0440\u0430\u0437\u043d\u044b\u0445 \'\u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430\' \u0438\u043b\u0438 \u0441\u043e\u0437\u0434\u0430\u0442\u044c \u0438\u0445 \u043d\u0435\u043e\u0431\u0445\u043e\u0434\u0438\u043c\u043e\u0435 \u043a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e, \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u043e\u0435 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044e {searchingUser.login}")
    public final java.util.List<ooo.jtc.letters.dto.LetterFromBankDto> getOrCreateDifferentLetterFromBankDtoList(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User searchingUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.generic.pageparams.GetPageRequest> getPageRequest, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.letters.dto.LetterFromBankDto, java.lang.Boolean> additionalFilter, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.letters.dto.LetterFromBankDto> createLfbFunc, long amount) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.letters.dto.LetterFromBankDto getLetterFromBankDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.io.File> attachments) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.letters.dto.LetterFromBankDto getLetterFromBankDtoForCreate(@org.jetbrains.annotations.NotNull()
    java.util.UUID customerId, @org.jetbrains.annotations.Nullable()
    java.lang.String customerName, @org.jetbrains.annotations.NotNull()
    java.util.UUID branchId, @org.jetbrains.annotations.Nullable()
    java.lang.String branchName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.letters.dto.LetterFromBankDto getLetterFromBankDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterFromBankDto letterDto) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0432\u043b\u043e\u0436\u0435\u043d\u0438\u044f \u043a DTO \u041f\u0438\u0441\u044c\u043c\u0430 [{letterDto.id}]")
    public final ooo.jtc.letters.dto.LetterFromBankDto addAttachmentsToDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterFromBankDto letterDto, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorUser, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.io.File> files) {
        return null;
    }
    
    /**
     * Copies provided LetterFromBankDto based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21726854.
     * @param user - user that copies [sourceLetter]
     * @param sourceLetter - LetterFromBank that will be copied
     * @param expDocNumber - expected [sourceLetter.documentNumber] value. Trying to get it AFTER actual copying
     *                     is incorrect, so it should be prepared beforehand
     * @param copyWithAttachments - boolean flag; indicates if [sourceLetter]-copy should be prepared with/without
     *                     attachment-related data
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430-\u043a\u043e\u043f\u0438\u044e [{sourceLetter.id}] \u043e\u0442 \u043b\u0438\u0446\u0430 \'{user.login}\'")
    public final ooo.jtc.letters.dto.LetterFromBankDto getLetterFromBankDtoCopyDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterFromBankDto sourceLetter, @org.jetbrains.annotations.NotNull()
    java.lang.String expDocNumber, boolean copyWithAttachments) {
        return null;
    }
    
    /**
     * Creates expected LetterFromBank-answer for provided LetterToBank
     * based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171822
     *
     * @param user - user that creates LetterFromBank-answer
     * @param letterToBank - LetterToBank. Answer will be created for this LFB
     * @param expDocNumber - expected [letterToBank.documentNumber] value. Trying to get it AFTER requesting answer
     *                     is incorrect, so it should be prepared beforehand
     * @param answerWithAttachments - boolean flag; indicates if LetterFromBank-answer should be prepared with/without
     *                     attachment-related data
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430-\u043e\u0442\u0432\u0435\u0442 \u043d\u0430 \u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0411\u0430\u043d\u043a [{letterToBank.id}] \u043e\u0442 \u043b\u0438\u0446\u0430 \'{user.login}\'")
    public final ooo.jtc.letters.dto.LetterFromBankDto prepareLFBAnswerForLetterToBankDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterToBankDto letterToBank, @org.jetbrains.annotations.NotNull()
    java.lang.String expDocNumber, boolean answerWithAttachments) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430 \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u043e\u0435 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044e {user.login}")
    public final ooo.jtc.letters.dto.LetterFromBankDto createLetterFromBankAvailableToUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterFromBankDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430 \u0434\u043b\u044f \u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u0438, \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u043e\u0439 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044f\u043c {creatorBankUser.login}, {receiverClientUser.login}")
    public final ooo.jtc.letters.dto.LetterFromBankDto createLetterFromBankDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.letters.dto.LetterFromBankDto createLetterFromBankDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterFromBankDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430 \u0432 \u0441\u0442\u0430\u0442\u0443\u0441\u0435 \'{status}\' \u0434\u043b\u044f \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u0435\u0439 {creatorBankUser.login}, {receiverClientUser.login}")
    public final ooo.jtc.letters.dto.LetterFromBankDto createLetterFromBankInStatus(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.model.LetterFromBankStatus status, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterFromBankDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430 \u0432 \u0441\u0442\u0430\u0442\u0443\u0441\u0435 DRAFT")
    public final ooo.jtc.letters.dto.LetterFromBankDto createDraftLetterFromBank(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterFromBankDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430 \u0432 \u0441\u0442\u0430\u0442\u0443\u0441\u0435 NEW")
    public final ooo.jtc.letters.dto.LetterFromBankDto createNewLetterFromBank(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterFromBankDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430 \u0432 \u0441\u0442\u0430\u0442\u0443\u0441\u0435 SIGNED")
    public final ooo.jtc.letters.dto.LetterFromBankDto createSignedLetterFromBank(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterFromBankDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430 \u0432 \u0441\u0442\u0430\u0442\u0443\u0441\u0435 WRONG_ESIGNATURE (\u0438\u0437\u043c\u0435\u043d\u0435\u043d\u0438\u0435 \u0434\u0430\u0439\u0434\u0436\u0435\u0441\u0442\u0430)")
    public final ooo.jtc.letters.dto.LetterFromBankDto createIncorrectDigestLetterFromBank_DIRTY(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterFromBankDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430 DETAILS_ERROR")
    public final ooo.jtc.letters.dto.LetterFromBankDto createDetailsErrorLetterFromBank_DIRTY(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterFromBankDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430 \u0432 \u0441\u0442\u0430\u0442\u0443\u0441\u0435 DELIVERED")
    public final ooo.jtc.letters.dto.LetterFromBankDto createDeliveredLetterFromBank(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterFromBankDto dtoForCreate, boolean returnBankDto) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.letters.dto.LetterFromBankDto, ooo.jtc.letters.dto.LetterFromBankDto> getRemoveAttachmentsTokens() {
        return null;
    }
    
    private final java.util.List<ooo.jtc.documents.SignatureDto> getLfbSignaturesFromDB(java.util.UUID letterId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0418\u0441\u043f\u043e\u0440\u0442\u0438\u0442\u044c \u043f\u043e\u0434\u043f\u0438\u0441\u044c, \u0441\u043b\u043e\u043c\u0430\u0432 \u0435\u0451 \u0441\u0442\u0440\u0443\u043a\u0442\u0443\u0440\u0443")
    public final ooo.jtc.letters.dto.LetterFromBankDto makeSignatureCorrupt_DIRTY(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterFromBankDto document, @org.jetbrains.annotations.Nullable()
    java.util.UUID signatureId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0418\u0437\u043c\u0435\u043d\u0438\u0442\u044c \u0434\u0430\u043d\u043d\u044b\u0435 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430, \u0447\u0442\u043e\u0431\u044b \u0434\u0430\u0439\u0434\u0436\u0435\u0441\u0442 \u043f\u0440\u0438 \u043f\u0440\u043e\u0432\u0435\u0440\u043a\u0435 \u0431\u044b\u043b \u043f\u0440\u0438\u0437\u043d\u0430\u043d \u043d\u0435\u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u044b\u043c")
    public final ooo.jtc.letters.dto.LetterFromBankDto makeDigestIncorrect_DIRTY(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterFromBankDto document) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0418\u0441\u043f\u043e\u0440\u0442\u0438\u0442\u044c \u0434\u0430\u043d\u043d\u044b\u0435 \u041f\u0438\u0441\u044c\u043c\u0430, \u043d\u0435 \u0437\u0430\u0442\u0440\u043e\u043d\u0443\u0432 \u043f\u043e\u0434\u043f\u0438\u0441\u0430\u043d\u043d\u044b\u0435 \u0434\u0430\u043d\u043d\u044b\u0435")
    public final ooo.jtc.letters.dto.LetterFromBankDto makeDetailsWrong_DIRTY(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterFromBankDto document) {
        return null;
    }
    
    private LetterFromBankPrepareSteps() {
        super();
    }
}