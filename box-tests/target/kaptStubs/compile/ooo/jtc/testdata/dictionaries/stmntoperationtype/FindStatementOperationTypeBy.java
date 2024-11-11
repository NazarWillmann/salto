package ooo.jtc.testdata.dictionaries.stmntoperationtype;

import java.lang.System;

/**
 * Enum for searching [StatementOperationType] in [StatementOperationTypeData]
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u001b\b\u0002\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bR&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Looo/jtc/testdata/dictionaries/stmntoperationtype/FindStatementOperationTypeBy;", "", "Looo/jtc/testdata/common/FindEntityBy;", "Looo/jtc/dictionaries/stmntoperationtype/StatementOperationType;", "Looo/jtc/testdata/dictionaries/stmntoperationtype/StatementOperationTypeData;", "predicate", "Lkotlin/Function1;", "", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "getPredicate", "()Lkotlin/jvm/functions/Function1;", "setPredicate", "(Lkotlin/jvm/functions/Function1;)V", "AT_CREATED", "box-tests"})
public enum FindStatementOperationTypeBy implements ooo.jtc.testdata.common.FindEntityBy<ooo.jtc.dictionaries.stmntoperationtype.StatementOperationType, ooo.jtc.testdata.dictionaries.stmntoperationtype.StatementOperationTypeData> {
    /*public static final*/ AT_CREATED /* = new AT_CREATED(null) */;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super ooo.jtc.dictionaries.stmntoperationtype.StatementOperationType, java.lang.Boolean> predicate;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<ooo.jtc.dictionaries.stmntoperationtype.StatementOperationType, java.lang.Boolean> getPredicate() {
        return null;
    }
    
    @java.lang.Override()
    public void setPredicate(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.dictionaries.stmntoperationtype.StatementOperationType, java.lang.Boolean> p0) {
    }
    
    FindStatementOperationTypeBy(kotlin.jvm.functions.Function1<? super ooo.jtc.dictionaries.stmntoperationtype.StatementOperationType, java.lang.Boolean> predicate) {
    }
}