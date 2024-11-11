package ooo.jtc.testdata.dictionaries.bankbic;

import java.lang.System;

/**
 * BankBicData data, that loaded from testDataProvider as [BankBicData] in [BankBic] format.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010&\u001a\u00020\u00022\u0006\u0010\'\u001a\u00020\u0017R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u0017X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R,\u0010\u001a\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d0\u001c0\f0\u001bX\u0094\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR8\u0010 \u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d0\u001c0\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\bR*\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020#\u0018\u00010\u00058VX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\b\"\u0004\b%\u0010\n\u00a8\u0006("}, d2 = {"Looo/jtc/testdata/dictionaries/bankbic/BankBicData;", "Looo/jtc/testdata/common/TestData;", "Looo/jtc/dictionaries/bankbic/BankBic;", "()V", "atMarkerPredicate", "Lkotlin/Function1;", "", "getAtMarkerPredicate", "()Lkotlin/jvm/functions/Function1;", "setAtMarkerPredicate", "(Lkotlin/jvm/functions/Function1;)V", "bankBicAccountData", "", "Looo/jtc/dictionaries/bankbic/acc/BankBicAccount;", "getBankBicAccountData", "()Ljava/util/List;", "bankBicAccountData$delegate", "Lkotlin/Lazy;", "bankBicRestrictionData", "Looo/jtc/dictionaries/bankbic/restr/BankBicRestriction;", "getBankBicRestrictionData", "bankBicRestrictionData$delegate", "dataFileName", "", "getDataFileName", "()Ljava/lang/String;", "dbDataConsumer", "Lkotlin/Function0;", "", "", "getDbDataConsumer", "()Lkotlin/jvm/functions/Function0;", "dbResultPostProcessor", "getDbResultPostProcessor", "removeRecord", "", "getRemoveRecord", "setRemoveRecord", "searchBy", "bic", "box-tests"})
public final class BankBicData extends ooo.jtc.testdata.common.TestData<ooo.jtc.dictionaries.bankbic.BankBic> {
    @org.jetbrains.annotations.NotNull()
    private static kotlin.jvm.functions.Function1<? super ooo.jtc.dictionaries.bankbic.BankBic, java.lang.Boolean> atMarkerPredicate;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function0<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> dbDataConsumer = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String dataFileName = "bankBic.json";
    @org.jetbrains.annotations.Nullable()
    private static kotlin.jvm.functions.Function1<? super ooo.jtc.dictionaries.bankbic.BankBic, kotlin.Unit> removeRecord;
    private static final kotlin.Lazy bankBicAccountData$delegate = null;
    private static final kotlin.Lazy bankBicRestrictionData$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function1<java.util.Map<java.lang.String, java.lang.Object>, java.util.Map<java.lang.String, java.lang.Object>> dbResultPostProcessor = null;
    public static final ooo.jtc.testdata.dictionaries.bankbic.BankBicData INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<ooo.jtc.dictionaries.bankbic.BankBic, java.lang.Boolean> getAtMarkerPredicate() {
        return null;
    }
    
    @java.lang.Override()
    public void setAtMarkerPredicate(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.dictionaries.bankbic.BankBic, java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected kotlin.jvm.functions.Function0<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> getDbDataConsumer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getDataFileName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<ooo.jtc.dictionaries.bankbic.BankBic, kotlin.Unit> getRemoveRecord() {
        return null;
    }
    
    @java.lang.Override()
    public void setRemoveRecord(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super ooo.jtc.dictionaries.bankbic.BankBic, kotlin.Unit> p0) {
    }
    
    private final java.util.List<ooo.jtc.dictionaries.bankbic.acc.BankBicAccount> getBankBicAccountData() {
        return null;
    }
    
    private final java.util.List<ooo.jtc.dictionaries.bankbic.restr.BankBicRestriction> getBankBicRestrictionData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<java.util.Map<java.lang.String, java.lang.Object>, java.util.Map<java.lang.String, java.lang.Object>> getDbResultPostProcessor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.bankbic.BankBic searchBy(@org.jetbrains.annotations.NotNull()
    java.lang.String bic) {
        return null;
    }
    
    private BankBicData() {
        super(null);
    }
}