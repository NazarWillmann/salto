package ooo.jtc.core;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001eR\u001d\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00060)\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001d\u0010-\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00060)\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010,\u00a8\u0006/"}, d2 = {"Looo/jtc/core/TestConstants;", "", "()V", "ACCEPTABLE_TIME_LAG_SECONDS", "", "AT", "", "AT_NUM", "AT_PERCENTAGE", "", "AT_POSTFIX", "AT_POSTFIX_RUS", "AT_POSTFIX_RUS_PARENTHESES", "AT_POSTFIX_UNDERSCORE", "AT_PREFIX", "AT_PREFIX_RUS", "AT_RUS", "AT_USERS_FILE_PATH", "CONTROL_INVALID_CHARS_EXPECT", "CONTROL_INVALID_CHARS_REQUEST", "DOC_DATE_ACCEPTABLE_FUTURE_DAYS", "DOC_DATE_ACCEPTABLE_PAST_DAYS", "LT", "MIN_ZONED_DATE", "Ljava/time/ZonedDateTime;", "getMIN_ZONED_DATE", "()Ljava/time/ZonedDateTime;", "NON_EXISTENT_ID", "Ljava/util/UUID;", "getNON_EXISTENT_ID", "()Ljava/util/UUID;", "PARAM_OBJECT_TYPE", "PARAM_USER", "PRE_EXECUTION_ERROR_MSG", "REPEAT_DELAY_MS", "REPEAT_LIMIT_SEC", "SMS_CODE_FOR_SIGN_DOCUMENTS", "SORT_CONTROL_IGNORE", "TECH_USER_ID", "getTECH_USER_ID", "documentWordFormFunc", "Lkotlin/Function1;", "", "getDocumentWordFormFunc", "()Lkotlin/jvm/functions/Function1;", "documentWordFormGenitiveFunc", "getDocumentWordFormGenitiveFunc", "box-tests"})
public final class TestConstants {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String AT = "AT";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String AT_RUS = "\u0410\u0422";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String AT_PREFIX = "AT ";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String AT_PREFIX_RUS = "\u0410\u0422 ";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String AT_POSTFIX = " AT";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String AT_POSTFIX_UNDERSCORE = "_AT";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String AT_POSTFIX_RUS = " \u0410\u0422";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String AT_POSTFIX_RUS_PARENTHESES = " (\u0410\u0442)";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LT = "_LT";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String AT_NUM = "00047";
    public static final double AT_PERCENTAGE = 91.0;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PARAM_USER = "\u041f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044c";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PARAM_OBJECT_TYPE = "\u0422\u0438\u043f \u043e\u0431\u044a\u0435\u043a\u0442\u0430";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String AT_USERS_FILE_PATH = "/AT_Users.json";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SMS_CODE_FOR_SIGN_DOCUMENTS = "0000";
    public static final long REPEAT_LIMIT_SEC = 65L;
    public static final long REPEAT_DELAY_MS = 750L;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CONTROL_INVALID_CHARS_REQUEST = "\u263a\u3091\u0457";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CONTROL_INVALID_CHARS_EXPECT = "\u263a;\u3091;\u0457";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SORT_CONTROL_IGNORE = "\u25a0\u263a\u263b\u2663\u25d8\u2022\u25cb";
    public static final long ACCEPTABLE_TIME_LAG_SECONDS = 10L;
    public static final long DOC_DATE_ACCEPTABLE_PAST_DAYS = 10L;
    public static final long DOC_DATE_ACCEPTABLE_FUTURE_DAYS = 0L;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.UUID TECH_USER_ID = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.UUID NON_EXISTENT_ID = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.time.ZonedDateTime MIN_ZONED_DATE = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PRE_EXECUTION_ERROR_MSG = "\u041e\u0448\u0438\u0431\u043a\u0430 \u043f\u0440\u0438 \u043f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u043a\u0435 \u0434\u0430\u043d\u043d\u044b\u0445 \u0434\u043b\u044f \u043f\u0440\u0435\u0434\u0443\u0441\u043b\u043e\u0432\u0438\u044f";
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function1<java.lang.Integer, java.lang.String> documentWordFormFunc = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function1<java.lang.Integer, java.lang.String> documentWordFormGenitiveFunc = null;
    public static final ooo.jtc.core.TestConstants INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getTECH_USER_ID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getNON_EXISTENT_ID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.ZonedDateTime getMIN_ZONED_DATE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Integer, java.lang.String> getDocumentWordFormFunc() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.Integer, java.lang.String> getDocumentWordFormGenitiveFunc() {
        return null;
    }
    
    private TestConstants() {
        super();
    }
}