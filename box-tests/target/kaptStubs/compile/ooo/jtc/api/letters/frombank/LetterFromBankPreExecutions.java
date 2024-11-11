package ooo.jtc.api.letters.frombank;

import java.lang.System;

/**
 * Short functions to get different preExecutions.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R)\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00048F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR#\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u000fR#\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u001d\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u000fR\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f8F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u000fR\u001d\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u000fR\u001d\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u000fR\u001d\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f8F\u00a2\u0006\u0006\u001a\u0004\b%\u0010\u000fR\u001d\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u000fR)\u0010(\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\n\u00a8\u0006+"}, d2 = {"Looo/jtc/api/letters/frombank/LetterFromBankPreExecutions;", "", "()V", "LFBPreExecutionCustomerIdByStatus", "Lkotlin/Function3;", "Looo/jtc/uaa/User;", "", "Looo/jtc/letters/model/LetterFromBankStatus;", "Ljava/util/UUID;", "getLFBPreExecutionCustomerIdByStatus", "()Lkotlin/jvm/functions/Function3;", "LFBPreExecutionDelivered", "Lkotlin/Function1;", "Looo/jtc/letters/dto/LetterFromBankDto;", "getLFBPreExecutionDelivered", "()Lkotlin/jvm/functions/Function1;", "LFBPreExecutionDeliveredWithAttach", "getLFBPreExecutionDeliveredWithAttach", "LFBPreExecutionDeliveredWithMultipleAttach", "Lkotlin/Function2;", "getLFBPreExecutionDeliveredWithMultipleAttach", "()Lkotlin/jvm/functions/Function2;", "LFBPreExecutionDetailsError", "getLFBPreExecutionDetailsError", "LFBPreExecutionDraft", "getLFBPreExecutionDraft", "LFBPreExecutionInStatus", "getLFBPreExecutionInStatus", "LFBPreExecutionNew", "getLFBPreExecutionNew", "LFBPreExecutionNewWithAttach", "getLFBPreExecutionNewWithAttach", "LFBPreExecutionSigned", "getLFBPreExecutionSigned", "LFBPreExecutionSignedWithAttach", "getLFBPreExecutionSignedWithAttach", "LFBPreExecutionWrongESignature", "getLFBPreExecutionWrongESignature", "dtoForCreateWithAttach", "getDtoForCreateWithAttach", "dtoForCreateWithMultipleAttach", "", "getDtoForCreateWithMultipleAttach", "box-tests"})
public final class LetterFromBankPreExecutions {
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterFromBankDto> dtoForCreateWithAttach = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function3<ooo.jtc.uaa.User, java.lang.String, java.lang.Integer, ooo.jtc.letters.dto.LetterFromBankDto> dtoForCreateWithMultipleAttach = null;
    public static final ooo.jtc.api.letters.frombank.LetterFromBankPreExecutions INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterFromBankDto> getLFBPreExecutionDraft() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterFromBankDto> getLFBPreExecutionNew() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterFromBankDto> getLFBPreExecutionSigned() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterFromBankDto> getLFBPreExecutionDelivered() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterFromBankDto> getLFBPreExecutionDetailsError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterFromBankDto> getLFBPreExecutionWrongESignature() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function3<ooo.jtc.uaa.User, java.lang.Integer, ooo.jtc.letters.model.LetterFromBankStatus, java.util.UUID> getLFBPreExecutionCustomerIdByStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterFromBankDto> getDtoForCreateWithAttach() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function3<ooo.jtc.uaa.User, java.lang.String, java.lang.Integer, ooo.jtc.letters.dto.LetterFromBankDto> getDtoForCreateWithMultipleAttach() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterFromBankDto> getLFBPreExecutionNewWithAttach() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterFromBankDto> getLFBPreExecutionSignedWithAttach() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.uaa.User, ooo.jtc.letters.dto.LetterFromBankDto> getLFBPreExecutionDeliveredWithAttach() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<ooo.jtc.uaa.User, java.lang.Integer, ooo.jtc.letters.dto.LetterFromBankDto> getLFBPreExecutionDeliveredWithMultipleAttach() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<ooo.jtc.uaa.User, ooo.jtc.letters.model.LetterFromBankStatus, ooo.jtc.letters.dto.LetterFromBankDto> getLFBPreExecutionInStatus() {
        return null;
    }
    
    private LetterFromBankPreExecutions() {
        super();
    }
}