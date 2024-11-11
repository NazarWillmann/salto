package ooo.jtc.random;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0011\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0019\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0011\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0018\u0010\u0013R\u000e\u0010\u0019\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Looo/jtc/random/ValidateConstants;", "", "()V", "ACCOUNT_KOEF", "", "getACCOUNT_KOEF", "()[I", "BANK_IND_BEGIN", "", "BANK_IND_END", "BIC_LENGTH", "BIC_RKC_SUFFIX", "", "", "getBIC_RKC_SUFFIX", "()Ljava/util/List;", "INN_MULT_N", "", "getINN_MULT_N", "()[Ljava/lang/Integer;", "[Ljava/lang/Integer;", "INN_MULT_N1", "getINN_MULT_N1", "INN_MULT_N2", "getINN_MULT_N2", "KEY_IND2_KEY", "KEY_IND_BEGIN", "KEY_IND_END", "NUMBER_LENGTH", "RKC_IND_BEGIN", "RKC_IND_END", "qa-utils"})
public final class ValidateConstants {
    public static final int BIC_LENGTH = 9;
    public static final int NUMBER_LENGTH = 20;
    public static final int BANK_IND_BEGIN = 6;
    public static final int BANK_IND_END = 9;
    public static final int RKC_IND_BEGIN = 4;
    public static final int RKC_IND_END = 6;
    public static final int KEY_IND_BEGIN = 8;
    public static final int KEY_IND_END = 9;
    public static final int KEY_IND2_KEY = 11;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> BIC_RKC_SUFFIX = null;
    @org.jetbrains.annotations.NotNull()
    private static final int[] ACCOUNT_KOEF = {7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1};
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.Integer[] INN_MULT_N = {2, 4, 10, 3, 5, 9, 4, 6, 8};
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.Integer[] INN_MULT_N1 = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.Integer[] INN_MULT_N2 = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
    public static final ooo.jtc.random.ValidateConstants INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getBIC_RKC_SUFFIX() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final int[] getACCOUNT_KOEF() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Integer[] getINN_MULT_N() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Integer[] getINN_MULT_N1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Integer[] getINN_MULT_N2() {
        return null;
    }
    
    private ValidateConstants() {
        super();
    }
}