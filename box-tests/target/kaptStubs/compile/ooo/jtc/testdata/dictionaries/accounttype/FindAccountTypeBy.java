package ooo.jtc.testdata.dictionaries.accounttype;

import java.lang.System;

/**
 * Enum for searching [AccountType] in [AccountTypeData]
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u001b\b\u0002\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bR&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Looo/jtc/testdata/dictionaries/accounttype/FindAccountTypeBy;", "", "Looo/jtc/testdata/common/FindEntityBy;", "Looo/jtc/dictionaries/accountype/AccountType;", "Looo/jtc/testdata/dictionaries/accounttype/AccountTypeData;", "predicate", "Lkotlin/Function1;", "", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "getPredicate", "()Lkotlin/jvm/functions/Function1;", "setPredicate", "(Lkotlin/jvm/functions/Function1;)V", "AT_CREATED", "CURRENT", "DEPOSIT", "LOAN", "box-tests"})
public enum FindAccountTypeBy implements ooo.jtc.testdata.common.FindEntityBy<ooo.jtc.dictionaries.accountype.AccountType, ooo.jtc.testdata.dictionaries.accounttype.AccountTypeData> {
    /*public static final*/ AT_CREATED /* = new AT_CREATED(null) */,
    /*public static final*/ CURRENT /* = new CURRENT(null) */,
    /*public static final*/ DEPOSIT /* = new DEPOSIT(null) */,
    /*public static final*/ LOAN /* = new LOAN(null) */;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super ooo.jtc.dictionaries.accountype.AccountType, java.lang.Boolean> predicate;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<ooo.jtc.dictionaries.accountype.AccountType, java.lang.Boolean> getPredicate() {
        return null;
    }
    
    @java.lang.Override()
    public void setPredicate(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.dictionaries.accountype.AccountType, java.lang.Boolean> p0) {
    }
    
    FindAccountTypeBy(kotlin.jvm.functions.Function1<? super ooo.jtc.dictionaries.accountype.AccountType, java.lang.Boolean> predicate) {
    }
}