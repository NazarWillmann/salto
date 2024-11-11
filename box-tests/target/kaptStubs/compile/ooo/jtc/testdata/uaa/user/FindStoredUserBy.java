package ooo.jtc.testdata.uaa.user;

import java.lang.System;

/**
 * Enum for searching [StoredUser] from [StoredUserData]
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u001b\b\u0002\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bR&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017\u00a8\u0006\u0018"}, d2 = {"Looo/jtc/testdata/uaa/user/FindStoredUserBy;", "", "Looo/jtc/testdata/common/FindEntityBy;", "Looo/jtc/uaa/StoredUser;", "Looo/jtc/testdata/uaa/user/StoredUserData;", "predicate", "Lkotlin/Function1;", "", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "getPredicate", "()Lkotlin/jvm/functions/Function1;", "setPredicate", "(Lkotlin/jvm/functions/Function1;)V", "CLIENT_USER", "CLIENT_SECOND_USER", "INDIVIDUAL_USER", "AUTOTEST_USER", "BANK_ADMIN_USER", "BRANCHES_ALMIGHTY", "BANK_OPERATOR_USER", "SUPER_BANK_OPERATOR", "SECURITY_ADMIN_USER", "SYSTEM_SECURITY_USER", "SYSTEM_BANK_OPERATOR_USER", "box-tests"})
public enum FindStoredUserBy implements ooo.jtc.testdata.common.FindEntityBy<ooo.jtc.uaa.StoredUser, ooo.jtc.testdata.uaa.user.StoredUserData> {
    /*public static final*/ CLIENT_USER /* = new CLIENT_USER(null) */,
    /*public static final*/ CLIENT_SECOND_USER /* = new CLIENT_SECOND_USER(null) */,
    /*public static final*/ INDIVIDUAL_USER /* = new INDIVIDUAL_USER(null) */,
    /*public static final*/ AUTOTEST_USER /* = new AUTOTEST_USER(null) */,
    /*public static final*/ BANK_ADMIN_USER /* = new BANK_ADMIN_USER(null) */,
    /*public static final*/ BRANCHES_ALMIGHTY /* = new BRANCHES_ALMIGHTY(null) */,
    /*public static final*/ BANK_OPERATOR_USER /* = new BANK_OPERATOR_USER(null) */,
    /*public static final*/ SUPER_BANK_OPERATOR /* = new SUPER_BANK_OPERATOR(null) */,
    /*public static final*/ SECURITY_ADMIN_USER /* = new SECURITY_ADMIN_USER(null) */,
    /*public static final*/ SYSTEM_SECURITY_USER /* = new SYSTEM_SECURITY_USER(null) */,
    /*public static final*/ SYSTEM_BANK_OPERATOR_USER /* = new SYSTEM_BANK_OPERATOR_USER(null) */;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super ooo.jtc.uaa.StoredUser, java.lang.Boolean> predicate;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<ooo.jtc.uaa.StoredUser, java.lang.Boolean> getPredicate() {
        return null;
    }
    
    @java.lang.Override()
    public void setPredicate(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.uaa.StoredUser, java.lang.Boolean> p0) {
    }
    
    FindStoredUserBy(kotlin.jvm.functions.Function1<? super ooo.jtc.uaa.StoredUser, java.lang.Boolean> predicate) {
    }
}