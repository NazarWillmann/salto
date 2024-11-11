package ooo.jtc.testdata.dictionaries.customerrepresentative;

import java.lang.System;

/**
 * Customer representatives data, that loaded from testDataProvider as [CustomerRepresentativeData] in [CustomerRepresentative] format.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cR&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR,\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00130\u00120\u00110\u0010X\u0094\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\n\u00a8\u0006\u001d"}, d2 = {"Looo/jtc/testdata/dictionaries/customerrepresentative/CustomerRepresentativeData;", "Looo/jtc/testdata/common/TestDataAT;", "Looo/jtc/dictionaries/customerrepresentative/CustomerRepresentative;", "()V", "atMarkerPredicate", "Lkotlin/Function1;", "", "getAtMarkerPredicate", "()Lkotlin/jvm/functions/Function1;", "setAtMarkerPredicate", "(Lkotlin/jvm/functions/Function1;)V", "dataFileName", "", "getDataFileName", "()Ljava/lang/String;", "dbDataConsumer", "Lkotlin/Function0;", "", "", "", "getDbDataConsumer", "()Lkotlin/jvm/functions/Function0;", "removeRecord", "", "getRemoveRecord", "setRemoveRecord", "searchBy", "clientUser", "Looo/jtc/uaa/User;", "box-tests"})
public final class CustomerRepresentativeData extends ooo.jtc.testdata.common.TestDataAT<ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentative> {
    @org.jetbrains.annotations.NotNull()
    private static kotlin.jvm.functions.Function1<? super ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentative, java.lang.Boolean> atMarkerPredicate;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function0<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> dbDataConsumer = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String dataFileName = "customerRepresentative.json";
    @org.jetbrains.annotations.Nullable()
    private static kotlin.jvm.functions.Function1<? super ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentative, kotlin.Unit> removeRecord;
    public static final ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeData INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentative, java.lang.Boolean> getAtMarkerPredicate() {
        return null;
    }
    
    @java.lang.Override()
    public void setAtMarkerPredicate(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentative, java.lang.Boolean> p0) {
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
    public kotlin.jvm.functions.Function1<ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentative, kotlin.Unit> getRemoveRecord() {
        return null;
    }
    
    @java.lang.Override()
    public void setRemoveRecord(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentative, kotlin.Unit> p0) {
    }
    
    /**
     * Find CustomerRepresentative records related to customer's user.
     *
     * Calling this with bank user will always result in an exception
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentative> searchBy(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User clientUser) {
        return null;
    }
    
    private CustomerRepresentativeData() {
        super(null);
    }
}