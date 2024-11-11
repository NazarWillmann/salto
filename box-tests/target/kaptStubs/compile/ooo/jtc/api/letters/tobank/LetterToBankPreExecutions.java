package ooo.jtc.api.letters.tobank;

import java.lang.System;

/**
 * Short functions to get different preExecutions.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00048F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR)\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R#\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\tR\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013R\u001d\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u001d\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00118F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0013R\u001d\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00118F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0013R#\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u00048F\u00a2\u0006\u0006\u001a\u0004\b%\u0010\tR\u001d\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00118F\u00a2\u0006\u0006\u001a\u0004\b\'\u0010\u0013R/\u0010(\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070)0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010\u000fR\u001d\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00118F\u00a2\u0006\u0006\u001a\u0004\b,\u0010\u0013R\u001d\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00118F\u00a2\u0006\u0006\u001a\u0004\b.\u0010\u0013R\u001d\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u00118F\u00a2\u0006\u0006\u001a\u0004\b0\u0010\u0013R#\u00101\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002020)0\u00118F\u00a2\u0006\u0006\u001a\u0004\b3\u0010\u0013R\u001d\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0013R)\u00106\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010\u000f\u00a8\u00068"}, d2 = {"Looo/jtc/api/letters/tobank/LetterToBankPreExecutions;", "", "()V", "LTBPreExecutionCreateSignedForCustomer", "Lkotlin/Function2;", "Looo/jtc/uaa/User;", "Ljava/util/UUID;", "Looo/jtc/letters/dto/LetterToBankDto;", "getLTBPreExecutionCreateSignedForCustomer", "()Lkotlin/jvm/functions/Function2;", "LTBPreExecutionCustomerIdByStatus", "Lkotlin/Function3;", "", "Looo/jtc/letters/model/LetterToBankStatus;", "getLTBPreExecutionCustomerIdByStatus", "()Lkotlin/jvm/functions/Function3;", "LTBPreExecutionDetailsError", "Lkotlin/Function1;", "getLTBPreExecutionDetailsError", "()Lkotlin/jvm/functions/Function1;", "LTBPreExecutionDraft", "getLTBPreExecutionDraft", "LTBPreExecutionInStatus", "getLTBPreExecutionInStatus", "LTBPreExecutionNew", "getLTBPreExecutionNew", "LTBPreExecutionNewWithAttach", "getLTBPreExecutionNewWithAttach", "LTBPreExecutionProcessed", "getLTBPreExecutionProcessed", "LTBPreExecutionRecalled", "getLTBPreExecutionRecalled", "LTBPreExecutionReceived", "getLTBPreExecutionReceived", "LTBPreExecutionReceivedWithAttach", "getLTBPreExecutionReceivedWithAttach", "LTBPreExecutionReceivedWithMultipleAttach", "getLTBPreExecutionReceivedWithMultipleAttach", "LTBPreExecutionSelfSigned", "getLTBPreExecutionSelfSigned", "LTBPreExecutionSelfSignedForCustomer", "", "getLTBPreExecutionSelfSignedForCustomer", "LTBPreExecutionSigned", "getLTBPreExecutionSigned", "LTBPreExecutionSignedWithAttach", "getLTBPreExecutionSignedWithAttach", "LTBPreExecutionWrongESignature", "getLTBPreExecutionWrongESignature", "LTBUiExpSentStatuses", "", "getLTBUiExpSentStatuses", "dtoForCreateWithAttach", "getDtoForCreateWithAttach", "dtoForCreateWithMultipleAttach", "getDtoForCreateWithMultipleAttach", "box-tests"})
public final class LetterToBankPreExecutions {
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterToBankDto> dtoForCreateWithAttach = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function3<ooo.jtc.uaa.User, java.lang.String, java.lang.Integer, ooo.jtc.letters.dto.LetterToBankDto> dtoForCreateWithMultipleAttach = null;
    public static final ooo.jtc.api.letters.tobank.LetterToBankPreExecutions INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterToBankDto> getLTBPreExecutionDraft() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterToBankDto> getLTBPreExecutionNew() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterToBankDto> getLTBPreExecutionSigned() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterToBankDto> getLTBPreExecutionSelfSigned() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function3<ooo.jtc.uaa.User, java.util.UUID, java.lang.Integer, java.util.List<ooo.jtc.letters.dto.LetterToBankDto>> getLTBPreExecutionSelfSignedForCustomer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<ooo.jtc.uaa.User, java.util.UUID, ooo.jtc.letters.dto.LetterToBankDto> getLTBPreExecutionCreateSignedForCustomer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterToBankDto> getLTBPreExecutionReceived() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterToBankDto> getLTBPreExecutionDetailsError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterToBankDto> getLTBPreExecutionWrongESignature() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterToBankDto> getLTBPreExecutionRecalled() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterToBankDto> getLTBPreExecutionProcessed() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterToBankDto> getDtoForCreateWithAttach() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function3<ooo.jtc.uaa.User, java.lang.String, java.lang.Integer, ooo.jtc.letters.dto.LetterToBankDto> getDtoForCreateWithMultipleAttach() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterToBankDto> getLTBPreExecutionNewWithAttach() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterToBankDto> getLTBPreExecutionSignedWithAttach() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterToBankDto> getLTBPreExecutionReceivedWithAttach() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<ooo.jtc.uaa.User, java.lang.Integer, ooo.jtc.letters.dto.LetterToBankDto> getLTBPreExecutionReceivedWithMultipleAttach() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<ooo.jtc.uaa.User, ooo.jtc.letters.model.LetterToBankStatus, ooo.jtc.letters.dto.LetterToBankDto> getLTBPreExecutionInStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function3<ooo.jtc.uaa.User, java.lang.Integer, ooo.jtc.letters.model.LetterToBankStatus, java.util.UUID> getLTBPreExecutionCustomerIdByStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, java.util.List<java.lang.String>> getLTBUiExpSentStatuses() {
        return null;
    }
    
    private LetterToBankPreExecutions() {
        super();
    }
}